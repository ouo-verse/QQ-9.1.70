package com.tencent.mobileqq.profilecard.bussiness.accountlevel;

import QQService.EVIPSPEC;
import SLICE_UPLOAD.cnst.appid_qun;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.FastDynamicDrawable;
import com.tencent.cachedrawable.dynamicdrawable.d;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.LocaleManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.mini.utils.SchemaUtils;
import com.tencent.mobileqq.nearby.k;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.base.component.IProfileContentKey;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.utils.ProfileCardUtils;
import com.tencent.mobileqq.profilecard.bussiness.accountinfo.view.ProfileQQLevelView;
import com.tencent.mobileqq.profilecard.bussiness.accountlevel.report.ProfileAccountLevelReport;
import com.tencent.mobileqq.profilecard.bussiness.accountlevel.report.ProfileVipReport;
import com.tencent.mobileqq.profilecard.component.ProfileCardComponentConstant;
import com.tencent.mobileqq.profilecard.component.content.ElegantProfileAccountLevelComponent;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.IDiyMoreInfoManager;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.ab.ABTest;
import com.tencent.mobileqq.vas.ao;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vas.api.IVasWebUrl;
import com.tencent.mobileqq.vas.profilecard.VasTipsData;
import com.tencent.mobileqq.vas.profilecard.util.LevelUtil;
import com.tencent.mobileqq.vas.profilecard.view.OnTipsClickListener;
import com.tencent.mobileqq.vas.profilecard.view.VasProfileTipsView;
import com.tencent.mobileqq.vas.qqmc.QQLevelSwitchIconConfig;
import com.tencent.mobileqq.vas.qqvaluecard.view.QQValuePagView;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.mobileqq.vip.IVasQQSettingMe;
import com.tencent.mobileqq.vip.api.IVipTraceDetailReport;
import com.tencent.mobileqq.vip.api.e;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.util.TokenResUtils;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.qzone.mobilereport.MobileReportManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* loaded from: classes16.dex */
public class BaseProfileAccountLevelComponent extends AbsQQProfileContentComponent implements View.OnClickListener {
    static IPatchRedirector $redirector_ = null;
    private static final String SIMPLE_MODE_LEVEL_URL = "https://ti.qq.com/qqlevel/index?_wv=3&_wwv=1&tab=7&source=29";
    private static final String TAG = "BaseProfileAccountLevelComponent";
    private ProfileCardInfo mCardInfo;
    protected boolean mIsFromArkBabyQ;
    private long mLastGoToQQVipWebTime;

    public BaseProfileAccountLevelComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iComponentCenter, (Object) profileCardInfo);
        } else {
            this.mCardInfo = profileCardInfo;
        }
    }

    private String getQQVIPWebURL(String str, String str2, String str3) {
        IFeatureRuntimeService iFeatureRuntimeService = (IFeatureRuntimeService) this.mApp.getRuntimeService(IFeatureRuntimeService.class, "all");
        if (!iFeatureRuntimeService.isFeatureSwitchEnable(ProfileCardComponentConstant.TOGGLE_SWITCH_QQ_VALUE, false)) {
            QLog.e(TAG, 1, "getQQVIPWebURL, toggle is not enable.");
            return str3;
        }
        JSONObject jSONObject = iFeatureRuntimeService.getJSONObject(ProfileCardComponentConstant.TOGGLE_SWITCH_QQ_VALUE, "");
        if (jSONObject != null) {
            if (TextUtils.isEmpty(jSONObject.toString())) {
                QLog.e(TAG, 1, "getQQVIPWebURL, jsonObject is empty.");
                return str2;
            }
            return jSONObject.optString(str, str2);
        }
        return str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void gotoQQVipWeb(int i3) {
        final String str;
        String qQVIPWebURL;
        IVipTraceDetailReport.FROM from;
        String str2;
        int i16;
        DATA data = this.mData;
        final String str3 = "qita";
        if (((ProfileCardInfo) data).allInOne.f260789pa != 40 && ((ProfileCardInfo) data).allInOne.f260789pa != 41 && ((ProfileCardInfo) data).allInOne.f260789pa != 58) {
            int i17 = ((ProfileCardInfo) data).allInOne.f260789pa;
            str = IProfileCardConst.VIP_QQ_FROM_OTHER;
            if (i17 != 1 && ((ProfileCardInfo) data).allInOne.f260789pa != 0) {
                if (((ProfileCardInfo) data).allInOne.f260789pa != 20 && ((ProfileCardInfo) data).allInOne.f260789pa != 21) {
                    if (((ProfileCardInfo) data).allInOne.f260789pa == 46) {
                        str = IProfileCardConst.VIP_QQ_FROM_DISCUSS;
                        str3 = "taolunzu";
                    } else if (ProfilePAUtils.isPaTypeTempTalk(((ProfileCardInfo) data).allInOne)) {
                        str = IProfileCardConst.VIP_QQ_FROM_TEMPTALK;
                    }
                } else {
                    str = IProfileCardConst.VIP_QQ_FROM_TROOP;
                    str3 = appid_qun.value;
                }
            } else {
                str3 = "geren";
            }
        } else {
            str = IProfileCardConst.VIP_QQ_FROM_NEARBY;
        }
        if (((ProfileCardInfo) this.mData).allInOne.f260789pa != 0 && !this.mApp.getCurrentAccountUin().equals(((ProfileCardInfo) this.mData).allInOne.uin)) {
            qQVIPWebURL = getQQVIPWebURL(ProfileCardComponentConstant.TOGGLE_KEY_QQ_VALUE_GUEST_URL, ProfileCardComponentConstant.DEFAULT_QQ_VALUE_GUEST_URL, IndividuationUrlHelper.getUrl(IndividuationUrlHelper.UrlId.VIP_PERSONAL_CARD_CUSTOM));
        } else {
            qQVIPWebURL = getQQVIPWebURL(ProfileCardComponentConstant.TOGGLE_KEY_QQ_VALUE_HOST_URL, ProfileCardComponentConstant.DEFAULT_QQ_VALUE_HOST_URL, IndividuationUrlHelper.getUrl(IndividuationUrlHelper.UrlId.VIP_PERSONAL_CARD_MASTER));
            String accountJumpUrl = ((IVasQQSettingMe) QRoute.api(IVasQQSettingMe.class)).getAccountJumpUrl();
            if (!TextUtils.isEmpty(accountJumpUrl)) {
                qQVIPWebURL = accountJumpUrl;
            }
            if (SimpleUIUtil.getSimpleUISwitch()) {
                qQVIPWebURL = SIMPLE_MODE_LEVEL_URL;
            }
        }
        if (!this.mApp.getCurrentAccountUin().equals(((ProfileCardInfo) this.mData).allInOne.uin)) {
            str2 = ((ProfileCardInfo) this.mData).allInOne.uin;
            from = IVipTraceDetailReport.FROM.PROFILECARD_LEVEL_GUEST;
        } else {
            from = IVipTraceDetailReport.FROM.PROFILECARD_LEVEL;
            str2 = "0";
        }
        if (i3 == 1) {
            from.setItemID(ProfileVipReport.LEVEL_ITEM_ID);
        }
        String buildTraceDetailUrl = e.a().buildTraceDetailUrl(qQVIPWebURL, from);
        StringBuilder sb5 = new StringBuilder(buildTraceDetailUrl.replace(ElegantProfileAccountLevelComponent.URL_REPLACE_FRIEND_QQ, str2));
        if (buildTraceDetailUrl.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
            sb5.append("&platform=1");
        } else {
            sb5.append("?platform=1");
        }
        if (!buildTraceDetailUrl.contains("&qq=")) {
            sb5.append("&qq=");
            sb5.append(str2);
        }
        sb5.append("&adtag=");
        sb5.append(str3);
        sb5.append("&aid=");
        sb5.append(str);
        String sb6 = sb5.toString();
        long currentTimeMillis = System.currentTimeMillis();
        if (ProfileUtils.isValidClick(this.mLastGoToQQVipWebTime, currentTimeMillis)) {
            this.mLastGoToQQVipWebTime = currentTimeMillis;
            boolean z16 = false;
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, String.format("gotoQQVipWeb url=%s", sb6));
            }
            if (from == IVipTraceDetailReport.FROM.PROFILECARD_LEVEL && ((IVasWebUrl) QRoute.api(IVasWebUrl.class)).gotoLevelPage(this.mActivity, new Function1() { // from class: com.tencent.mobileqq.profilecard.bussiness.accountlevel.c
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    String lambda$gotoQQVipWeb$2;
                    lambda$gotoQQVipWeb$2 = BaseProfileAccountLevelComponent.lambda$gotoQQVipWeb$2(str3, str, (String) obj);
                    return lambda$gotoQQVipWeb$2;
                }
            })) {
                z16 = true;
            }
            if (!z16 && !openByJumpParser(sb6, this.mActivity)) {
                if (((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).isEnable()) {
                    ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openBrowser(this.mActivity, sb6);
                } else {
                    Intent intent = new Intent(this.mActivity, (Class<?>) QQBrowserActivity.class);
                    intent.putExtra("uin", this.mApp.getCurrentAccountUin());
                    intent.putExtra("url", sb6);
                    intent.putExtra("hide_more_button", true);
                    intent.putExtra("startOpenPageTime", System.currentTimeMillis());
                    this.mActivity.startActivity(intent);
                }
            }
            AppInterface appInterface = this.mApp;
            if (((ProfileCardInfo) this.mData).allInOne.f260789pa == 0) {
                i16 = 23;
            } else {
                i16 = 24;
            }
            ReportController.o(appInterface, "CliOper", "", "", "vip", "logo_in", i16, 0, "", "", "", "");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void handleBigVipLevelClick() {
        gotoQQVipWeb(1);
        ProfileVipReport.reportLevelBadge((ProfileCardInfo) this.mData, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$gotoQQVipWeb$2(String str, String str2, String str3) {
        return e.a().buildTraceDetailUrl(str3, IVipTraceDetailReport.FROM.PROFILECARD_LEVEL) + "&adtag=" + str + "&aid=" + str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit lambda$updateLevelBadge$0(ImageView imageView, int i3, FastDynamicDrawable fastDynamicDrawable, d dVar) {
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-2, i3);
        }
        layoutParams.width = (int) (fastDynamicDrawable.getIntrinsicWidth() * (i3 / fastDynamicDrawable.getIntrinsicHeight()));
        imageView.setLayoutParams(layoutParams);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$updateNoticeView$1(VasTipsData vasTipsData, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        String jumpUrl = vasTipsData.getJumpUrl();
        Context context = ((View) this.mViewContainer).getContext();
        if (context != null && !jumpUrl.isEmpty()) {
            MobileReportManager.getInstance().reportAction("tips", "4", "data_card", "data_card_page", "vip_tips", 102, 0, System.currentTimeMillis(), vasTipsData.getClmParams());
            if (jumpUrl.startsWith("https")) {
                Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
                intent.putExtra("url", jumpUrl);
                context.startActivity(intent);
            } else {
                ax c16 = bi.c((BaseQQAppInterface) this.mApp, context, jumpUrl);
                if (c16 == null) {
                    QLog.e(TAG, 1, "launchScheme: jumpAction is null");
                } else {
                    c16.b();
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private boolean openByJumpParser(String str, Context context) {
        if (!TextUtils.isEmpty(str) && str.startsWith(SchemaUtils.SCHEMA_MQQAPI)) {
            ax c16 = bi.c((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime(), context, str);
            if (c16 != null) {
                c16.b();
                return true;
            }
            QLog.e(TAG, 1, "openByJumpParser, parse mqqAPI url failed.");
        }
        return false;
    }

    private void setViewAlphaWhenTouch(View view) {
        view.setOnTouchListener(new View.OnTouchListener(view) { // from class: com.tencent.mobileqq.profilecard.bussiness.accountlevel.BaseProfileAccountLevelComponent.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ View val$view;

            {
                this.val$view = view;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) BaseProfileAccountLevelComponent.this, (Object) view);
                }
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view2, (Object) motionEvent)).booleanValue();
                }
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action == 1 || action == 3) {
                        this.val$view.setAlpha(1.0f);
                        return false;
                    }
                    return false;
                }
                this.val$view.setAlpha(0.5f);
                return false;
            }
        });
    }

    private void updateLevelBadge(int i3, int i16, final ImageView imageView, boolean z16) {
        float f16;
        com.tencent.mobileqq.vas.quickupdate.a aVar = (com.tencent.mobileqq.vas.quickupdate.a) QQVasUpdateBusiness.getBusiness(com.tencent.mobileqq.vas.quickupdate.a.class);
        final FastDynamicDrawable a16 = com.tencent.cachedrawable.dynamicdrawable.api.a.a().j(59L, aVar.transformScid(i3, i16)).d(aVar.getSavePath(i3, i16)).a();
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageDrawable(a16);
        if (z16) {
            f16 = 20.0f;
        } else {
            f16 = 18.0f;
        }
        final int dip2px = ViewUtils.dip2px(f16);
        a16.c0(new Function1() { // from class: com.tencent.mobileqq.profilecard.bussiness.accountlevel.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit lambda$updateLevelBadge$0;
                lambda$updateLevelBadge$0 = BaseProfileAccountLevelComponent.lambda$updateLevelBadge$0(imageView, dip2px, a16, (d) obj);
                return lambda$updateLevelBadge$0;
            }
        });
    }

    private void updateLevelTestA(int i3, int i16, ImageView imageView, boolean z16) {
        imageView.setVisibility(0);
        updateLevelBadge(i3, i16, imageView, z16);
        imageView.setTag(new com.tencent.mobileqq.profile.b(68, null));
        imageView.setOnClickListener(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void updateLevelTestB(int i3, int i16, int i17, boolean z16, View view) {
        float f16;
        view.setVisibility(0);
        ImageView imageView = (ImageView) ((View) this.mViewContainer).findViewById(R.id.zpm);
        AnimationTextView animationTextView = (AnimationTextView) ((View) this.mViewContainer).findViewById(R.id.zpl);
        updateLevelBadge(i3, i16, imageView, z16);
        Context context = view.getContext();
        if (z16) {
            f16 = 20.0f;
        } else {
            f16 = 14.0f;
        }
        animationTextView.setText(LevelUtil.parseQQLevel(context, 15, i17, i16, true, ViewUtils.dpToPx(f16)), TextView.BufferType.SPANNABLE);
        if (!z16) {
            updateItemTheme((View) this.mViewContainer, null, null, (ImageView) ((View) this.mViewContainer).findViewById(R.id.zpk));
        }
        imageView.setTag(new com.tencent.mobileqq.profile.b(68, null));
        animationTextView.setTag(new com.tencent.mobileqq.profile.b(68, null));
        animationTextView.setOnClickListener(this);
        imageView.setOnClickListener(this);
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public String getComponentName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return TAG;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public int getComponentType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 1021;
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent, com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent
    public String getProfileContentKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return IProfileContentKey.MAP_KEY_ACCOUNT_LEVEL;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void handleAccountLevelClick() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        gotoQQVipWeb(0);
        int J2 = VipInfoHandler.J2(this.mQQAppInterface, this.mApp.getCurrentUin(), false);
        DATA data = this.mData;
        int i3 = 99999;
        if (((ProfileCardInfo) data).card != null && ((ProfileCardInfo) data).card.mQQLevelType != 0) {
            i3 = ((ProfileCardInfo) data).card.mQQLevelType;
        }
        int i16 = i3;
        ReportController.o(this.mApp, "dc00898", "", "", "0X800A8C1", "0X800A8C1", J2, 0, String.valueOf(J2), "", "", "");
        if (((ProfileCardInfo) this.mData).allInOne.f260789pa == 0) {
            ReportController.o(this.mApp, "CliOper", "", "", "0X8006A7A", "0X8006A7A", 0, 0, "", "", "", "");
            ReportController.o(null, "dc00898", "", "", QQPermissionConstants.Business.SCENE.QQ_VIP, "0X800A775", i16, 0, "", "", "", "");
        } else {
            ReportController.o(this.mApp, "CliOper", "", "", "0X8006A8E", "0X8006A8E", 0, 0, "", "", "", "");
            ReportController.o(null, "dc00898", "", "", QQPermissionConstants.Business.SCENE.QQ_VIP, "0X800A774", i16, 0, "", "", "", "");
            ReportController.o(this.mApp, "dc00898", "", "", "0X800A8C2", "0X800A8C2", J2, 0, String.valueOf(J2), "", "", "");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void handleDarenIconClick() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        if (((ProfileCardInfo) this.mData).allInOne.f260789pa != 0) {
            return;
        }
        Intent intent = new Intent(this.mActivity, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("uin", this.mApp.getCurrentAccountUin());
        intent.putExtra("url", IProfileCardConst.PROFILE_QQXMAN_URL);
        intent.putExtra("hide_more_button", true);
        this.mActivity.startActivity(intent);
        ReportController.o(this.mApp, "CliOper", "", "", "0X800A9C2", "0X800A9C2", 0, 0, "", "", "", "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void handleMedalIconClick() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        String b16 = k.b(((ProfileCardInfo) this.mData).allInOne.uin);
        Intent intent = new Intent(this.mActivity, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("uin", this.mApp.getCurrentAccountUin());
        intent.putExtra("url", IProfileCardConst.PROFILE_MEDAL_URL + b16);
        this.mActivity.startActivity(intent);
        ReportController.o(this.mApp, "CliOper", "", "", "0X800A9C2", "0X800A9C2", 0, 0, "", "", "", "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void handleVipNumPagViewClick(View view, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) view, (Object) str);
        } else if (view instanceof QQValuePagView) {
            ((QQValuePagView) view).u(IndividuationUrlHelper.UrlId.CARD_HOME, str);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v27, types: [android.view.View, VIEW] */
    public boolean makeOrRefreshAccountLevel(Card card, boolean z16, boolean z17, boolean z18) {
        boolean z19;
        VIEW view;
        boolean z26;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 4;
        boolean z27 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, this, card, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18))).booleanValue();
        }
        boolean needShowAccountLevel = needShowAccountLevel(card);
        boolean isSwitchEnable = this.mConfigHelper.isSwitchEnable(12);
        boolean isDefaultProfile = ProfileCardUtils.isDefaultProfile((ProfileCardInfo) this.mData);
        if (card != null && card.switchMembershipAndRank == 0) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 2, String.format("makeOrRefreshAccountLevel showAccountInfo=%s baseInfoABTestEnable=%s isDefaultProfile=%s", Boolean.valueOf(needShowAccountLevel), Boolean.valueOf(isSwitchEnable), Boolean.valueOf(isDefaultProfile)));
        }
        if (needShowAccountLevel && ((!isSwitchEnable || !isDefaultProfile || z17 || z18) && z19)) {
            if (this.mViewContainer == 0) {
                ?? inflate = this.mActivity.getLayoutInflater().inflate(R.layout.b0s, (ViewGroup) null);
                View findViewById = inflate.findViewById(R.id.icon);
                View findViewById2 = inflate.findViewById(R.id.zpy);
                findViewById2.setBackgroundResource(TokenResUtils.getTokenRes(R.drawable.qq_profilecard_item_rank, R.drawable.qui_rank));
                findViewById.setBackgroundResource(TokenResUtils.getTokenRes(R.drawable.qq_profilecard_item_rank, R.drawable.qui_rank));
                ProfileAccountLevelReport.reportAccountLevelVisible(this.mQQAppInterface, (ProfileCardInfo) this.mData);
                this.mViewContainer = inflate;
                updateItemTheme(null, null, findViewById2, null, null);
                z26 = true;
            } else {
                z26 = false;
            }
            ProfileQQLevelView profileQQLevelView = (ProfileQQLevelView) ((View) this.mViewContainer).findViewById(R.id.gre);
            profileQQLevelView.update((ProfileCardInfo) this.mData, this.mIsFromArkBabyQ);
            profileQQLevelView.setClickable(false);
            updateMedalView();
            updateNumPAGView();
            updateNoticeView(z16);
            ((View) this.mViewContainer).setTag(new com.tencent.mobileqq.profile.b(69, null));
            ((View) this.mViewContainer).setOnClickListener(this);
            ProfileCardDtReportUtil.initElementWithExposureClick((View) this.mViewContainer, ProfileCardDtReportUtil.DT_REPORT_LEVEL);
            boolean updateQQLevel = updateQQLevel(false);
            View findViewById3 = ((View) this.mViewContainer).findViewById(R.id.icon);
            ImageView imageView = (ImageView) ((View) this.mViewContainer).findViewById(R.id.f164472yw);
            updateItemTheme((View) this.mViewContainer, null, findViewById3, null, imageView);
            if (!updateQQLevel) {
                i3 = 0;
            }
            imageView.setVisibility(i3);
            z27 = z26;
        } else if (this.mViewContainer != 0) {
            this.mViewContainer = null;
            z27 = true;
        }
        IDiyMoreInfoManager diyMoreInfoManager = ProfileTemplateApi.getDiyMoreInfoManager(this.mComponentCenter);
        if (diyMoreInfoManager.isDiy() && (view = this.mViewContainer) != 0) {
            ((View) view).setBackgroundResource(R.drawable.f160556k2);
            ((View) this.mViewContainer).setClickable(true);
            diyMoreInfoManager.updateLevelForDeepDiy((View) this.mViewContainer);
        }
        return z27;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean needShowAccountLevel(Card card) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) card)).booleanValue();
        }
        if (!this.mIsFromArkBabyQ && card != null) {
            z17 = card.isVipOpen(EVIPSPEC.E_SP_QQVIP);
            z18 = card.isVipOpen(EVIPSPEC.E_SP_SUPERVIP);
            long j3 = card.lUserFlag;
            if ((j3 & 1) == 1) {
                z26 = true;
            } else {
                z26 = false;
            }
            if ((j3 & 1024) == 1024) {
                z19 = true;
            } else {
                z19 = false;
            }
            if ((!ProfilePAUtils.isPaTypeShowAccount(((ProfileCardInfo) this.mData).allInOne) || ProfilePAUtils.isFromGuild(((ProfileCardInfo) this.mData).allInOne.f260789pa)) && !z18 && !z17 && card.iQQLevel < 0) {
                z16 = false;
            } else {
                z16 = true;
            }
        } else {
            z16 = false;
            z17 = false;
            z18 = false;
            z19 = false;
            z26 = false;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 2, String.format("makeOrRefreshAccountLevelInfoView showAccountInfo=%s vipOpen=%s superVipOpen=%s enterprise=%s prettyNumber=%s", Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), Boolean.valueOf(z26), Boolean.valueOf(z19)));
        }
        return z16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ProfileCardInfo profileCardInfo;
        Card card;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view);
        } else {
            ProfileCardDtReportUtil.dtReportClick(view);
            Object tag = view.getTag();
            if (tag instanceof com.tencent.mobileqq.profile.b) {
                int i3 = ((com.tencent.mobileqq.profile.b) tag).f260135a;
                if (i3 != 68) {
                    int i16 = 2;
                    boolean z16 = false;
                    if (i3 != 69) {
                        if (i3 != 100) {
                            if (i3 == 104 && (profileCardInfo = this.mCardInfo) != null && (card = profileCardInfo.card) != null) {
                                handleVipNumPagViewClick(view, card.uin);
                            }
                        } else {
                            handleMedalIconClick();
                            if (ProfileCardUtils.isDefaultProfile((ProfileCardInfo) this.mData)) {
                                if (((ProfileCardInfo) this.mData).allInOne.f260789pa == 0) {
                                    z16 = true;
                                }
                                QQAppInterface qQAppInterface = this.mQQAppInterface;
                                if (!z16) {
                                    i16 = 4;
                                }
                                ProfileAccountLevelReport.reportAccountDarenClick(qQAppInterface, i16);
                            }
                        }
                    } else {
                        handleAccountLevelClick();
                        ProfileVipReport.reportLevelItem((ProfileCardInfo) this.mData, true);
                        if (ProfileCardUtils.isDefaultProfile((ProfileCardInfo) this.mData)) {
                            if (((ProfileCardInfo) this.mData).allInOne.f260789pa == 0) {
                                z16 = true;
                            }
                            QQAppInterface qQAppInterface2 = this.mQQAppInterface;
                            if (!z16) {
                                i16 = 4;
                            }
                            ProfileAccountLevelReport.reportAccountLevelClick(qQAppInterface2, i16);
                        }
                    }
                } else {
                    handleBigVipLevelClick();
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent, com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onCreate(QBaseActivity qBaseActivity, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) qBaseActivity, (Object) bundle);
            return;
        }
        super.onCreate(qBaseActivity, bundle);
        Intent intent = this.mActivity.getIntent();
        if (intent != null) {
            this.mIsFromArkBabyQ = intent.getBooleanExtra(IProfileCardConst.KEY_FROM_ARK_BABYQ, false);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            m23.b.b().g(IndividuationUrlHelper.UrlId.CARD_HOME);
            super.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void updateMedalView() {
        FrameLayout frameLayout;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        VIEW view = this.mViewContainer;
        if (view == 0 || (frameLayout = (FrameLayout) ((View) view).findViewById(R.id.a3y)) == null) {
            return;
        }
        frameLayout.setOnClickListener(this);
        frameLayout.setTag(new com.tencent.mobileqq.profile.b(100, null));
        ProfileCardInfo profileCardInfo = this.mCardInfo;
        if (profileCardInfo != null && profileCardInfo.card != null) {
            String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(this.mCardInfo.card.uin);
            if (!this.mCardInfo.card.medalSwitchDisable && ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(uidFromUin, TAG)) {
                frameLayout.setVisibility(0);
                setViewAlphaWhenTouch(frameLayout);
            } else {
                frameLayout.setVisibility(8);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void updateNoticeView(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, z16);
            return;
        }
        if (QQLevelSwitchIconConfig.INSTANCE.isNotifyPayment() && z16 && LocaleManager.isLocaleCN()) {
            ao aoVar = (ao) this.mApp.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER);
            final VasTipsData d16 = aoVar.d();
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, String.format("updateNoticeView noticeData=%s", d16));
            }
            if (d16 == null) {
                return;
            }
            if (!aoVar.a()) {
                QLog.e(TAG, 2, "can't show notice");
            } else if (((ProfileCardInfo) this.mData).allInOne.f260789pa == 0) {
                VasProfileTipsView vasProfileTipsView = (VasProfileTipsView) ((View) this.mViewContainer).findViewById(R.id.f11990784);
                vasProfileTipsView.updateView(d16, ProfileTemplateApi.isDiyTemplateStyleID(((ProfileCardInfo) this.mData).curUseStyleId), new OnTipsClickListener(aoVar, d16) { // from class: com.tencent.mobileqq.profilecard.bussiness.accountlevel.BaseProfileAccountLevelComponent.2
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ ao val$extensionManager;
                    final /* synthetic */ VasTipsData val$noticeData;

                    {
                        this.val$extensionManager = aoVar;
                        this.val$noticeData = d16;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, BaseProfileAccountLevelComponent.this, aoVar, d16);
                        }
                    }

                    @Override // com.tencent.mobileqq.vas.profilecard.view.OnTipsClickListener
                    public void onCloseClick() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            this.val$extensionManager.g();
                            MobileReportManager.getInstance().reportAction("close", "4", "data_card", "data_card_page", "vip_tips", 102, 0, System.currentTimeMillis(), this.val$noticeData.getClmParams());
                        }
                    }
                });
                MobileReportManager.getInstance().reportAction("tips", "4", "data_card", "data_card_page", "vip_tips", 101, 0, System.currentTimeMillis(), d16.getClmParams());
                vasProfileTipsView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.bussiness.accountlevel.a
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        BaseProfileAccountLevelComponent.this.lambda$updateNoticeView$1(d16, view);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void updateNumPAGView() {
        ViewGroup viewGroup;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        VIEW view = this.mViewContainer;
        if (view != 0 && (viewGroup = (ViewGroup) ((View) view).findViewById(R.id.f219702g)) != null) {
            viewGroup.setOnClickListener(this);
            viewGroup.setTag(new com.tencent.mobileqq.profile.b(104, null));
            if (viewGroup instanceof QQValuePagView) {
                ((QQValuePagView) viewGroup).setForeground(null);
            }
            ProfileCardDtReportUtil.initElementWithExposure(viewGroup, ProfileCardDtReportUtil.DT_REPORT_ENERGY);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean updateQQLevel(boolean z16) {
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, z16)).booleanValue();
        }
        DATA data = this.mData;
        if (data != 0 && ((ProfileCardInfo) data).card != null) {
            View findViewById = ((View) this.mViewContainer).findViewById(R.id.dkg);
            findViewById.setTag(new com.tencent.mobileqq.profile.b(68, null));
            findViewById.setOnClickListener(this);
            View findViewById2 = ((View) this.mViewContainer).findViewById(R.id.f164741to3);
            ImageView imageView = (ImageView) ((View) this.mViewContainer).findViewById(R.id.f164742to4);
            DATA data2 = this.mData;
            int i3 = ((ProfileCardInfo) data2).card.mQQLevelType;
            int i16 = ((ProfileCardInfo) data2).card.iQQLevel;
            int i17 = ((ProfileCardInfo) data2).card.bigVipBadgeItemId;
            if (i17 > 0 && i16 >= 0) {
                if (com.tencent.mobileqq.vas.ab.a.f307906b.a().getFirst() == ABTest.B) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    findViewById.setVisibility(8);
                    imageView.setVisibility(8);
                    updateLevelTestB(i17, i16, i3, z16, findViewById2);
                } else {
                    findViewById.setVisibility(0);
                    findViewById2.setVisibility(8);
                    updateLevelTestA(i17, i16, imageView, z16);
                }
                return z17;
            }
            findViewById2.setVisibility(8);
            imageView.setVisibility(8);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: onDataUpdate, reason: merged with bridge method [inline-methods] */
    public boolean lambda$checkValidComponent$3(ProfileCardInfo profileCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) profileCardInfo)).booleanValue();
        }
        this.mCardInfo = profileCardInfo;
        boolean lambda$checkValidComponent$3 = super.lambda$checkValidComponent$3((BaseProfileAccountLevelComponent) profileCardInfo);
        IProfileActivityDelegate iProfileActivityDelegate = this.mDelegate;
        boolean z16 = false;
        boolean isShowZplanCover = iProfileActivityDelegate != null ? iProfileActivityDelegate.getIsShowZplanCover() : false;
        IProfileActivityDelegate iProfileActivityDelegate2 = this.mDelegate;
        if (iProfileActivityDelegate2 != null && iProfileActivityDelegate2.isShowQCircleCover()) {
            z16 = true;
        }
        DATA data = this.mData;
        return lambda$checkValidComponent$3 | makeOrRefreshAccountLevel(((ProfileCardInfo) data).card, ((ProfileCardInfo) data).isNetRet, isShowZplanCover, z16);
    }
}
