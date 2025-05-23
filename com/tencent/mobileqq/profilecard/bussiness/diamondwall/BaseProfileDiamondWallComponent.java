package com.tencent.mobileqq.profilecard.bussiness.diamondwall;

import QQService.PrivilegeInfo;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.cachedrawable.dynamicdrawable.api.a;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.mini.utils.SchemaUtils;
import com.tencent.mobileqq.profile.b;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileContentKey;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent;
import com.tencent.mobileqq.profilecard.base.utils.VasSvipPrivilegeAnimateHelper;
import com.tencent.mobileqq.profilecard.bussiness.accountlevel.report.ProfileVipReport;
import com.tencent.mobileqq.profilecard.component.ProfileCardComponentConstant;
import com.tencent.mobileqq.profilecard.component.content.ElegantProfileAccountLevelComponent;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.IDiyMoreInfoManager;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IMobileReportManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.vas.VasDynamicDrawableCache;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vas.profilecard.util.LevelUtil;
import com.tencent.mobileqq.vas.search.SearchConstants;
import com.tencent.mobileqq.vas.vip.QVipConfigManager;
import com.tencent.mobileqq.vas.vipicon.api.ILoverVipIconDrawable;
import com.tencent.mobileqq.vip.api.IVipTraceDetailReport;
import com.tencent.mobileqq.vip.api.e;
import com.tencent.pb.profilecard.VaProfileGate$LoverSvipExtInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.TokenResUtils;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* loaded from: classes16.dex */
public class BaseProfileDiamondWallComponent extends AbsQQProfileContentComponent {
    static IPatchRedirector $redirector_ = null;
    public static final int ANIMATOR_DENSITY = 500;
    public static final String REMIND_TIME = "iRemindTime";
    public static final int SHOW_ANIMATOR = 1;
    private static final String SP_ICON_TWINKLE = "sp_icon_twinkle";
    private static final String SP_SHOW_POP_BEGIN_TIME = "sp_show_pop_begin_time";
    private static final String TAG = "BaseProfileDiamondWallComponent";
    public static final String TIPS_TIMES = "iTipsTimes";
    private AnimatorHandler handler;
    private boolean isInitDtReport;
    private int isMedalExposure;
    protected float mDensity;
    protected float mItemInfoWidth;
    View.OnClickListener mOnClickListener;
    private boolean noDiamond;

    public BaseProfileDiamondWallComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iComponentCenter, (Object) profileCardInfo);
            return;
        }
        this.isMedalExposure = 0;
        this.handler = new AnimatorHandler();
        this.isInitDtReport = false;
        this.noDiamond = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.bussiness.diamondwall.BaseProfileDiamondWallComponent.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BaseProfileDiamondWallComponent.this);
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:47:0x0156  */
            /* JADX WARN: Removed duplicated region for block: B:57:0x0197  */
            @Override // android.view.View.OnClickListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onClick(View view) {
                String buildTraceDetailUrl;
                String buildTraceDetailUrl2;
                boolean z16;
                String str;
                int i3;
                String str2;
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                int i16 = 2;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view);
                } else {
                    ProfileCardDtReportUtil.dtReportClick((View) ((AbsComponent) BaseProfileDiamondWallComponent.this).mViewContainer);
                    Object tag = view.getTag();
                    if (tag instanceof b) {
                        b bVar = (b) tag;
                        int i17 = bVar.f260135a;
                        if (i17 == 26) {
                            String togglePrivilegeJumpUrl = BaseProfileDiamondWallComponent.this.getTogglePrivilegeJumpUrl(BaseProfileDiamondWallComponent.this.getOldPrivilegeJumpUrl());
                            if (((ProfileCardInfo) ((AbsComponent) BaseProfileDiamondWallComponent.this).mData).allInOne.f260789pa == 0) {
                                if (BaseProfileDiamondWallComponent.this.noDiamond) {
                                    buildTraceDetailUrl = e.a().buildTraceDetailUrl(togglePrivilegeJumpUrl, IVipTraceDetailReport.FROM.PROFILECARD_DIAMOND_EMPTY);
                                } else {
                                    buildTraceDetailUrl = e.a().buildTraceDetailUrl(togglePrivilegeJumpUrl, IVipTraceDetailReport.FROM.PROFILECARD_DIAMOND);
                                }
                            } else if (BaseProfileDiamondWallComponent.this.noDiamond) {
                                buildTraceDetailUrl = e.a().buildTraceDetailUrl(togglePrivilegeJumpUrl, IVipTraceDetailReport.FROM.PROFILECARD_DIAMOND_GUEST_EMPTY);
                            } else {
                                buildTraceDetailUrl = e.a().buildTraceDetailUrl(togglePrivilegeJumpUrl, IVipTraceDetailReport.FROM.PROFILECARD_DIAMOND_GUEST);
                            }
                            if (!BaseProfileDiamondWallComponent.this.openByJumpParser(buildTraceDetailUrl)) {
                                if (((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).isEnable()) {
                                    ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openBrowser(((AbsComponent) BaseProfileDiamondWallComponent.this).mActivity, buildTraceDetailUrl);
                                } else {
                                    Intent intent = new Intent(((AbsComponent) BaseProfileDiamondWallComponent.this).mActivity, (Class<?>) QQBrowserActivity.class);
                                    intent.putExtra("url", buildTraceDetailUrl);
                                    intent.putExtra("hide_operation_bar", true);
                                    intent.putExtra("hide_more_button", true);
                                    intent.putExtra("startOpenPageTime", System.currentTimeMillis());
                                    ((AbsComponent) BaseProfileDiamondWallComponent.this).mActivity.startActivity(intent);
                                }
                            }
                            ReportController.n(((AbsComponent) BaseProfileDiamondWallComponent.this).mApp, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "ziliaoka_qqtequan", "tab-click", 0, 1, 0, "", "", "", "");
                            ProfileVipReport.reportDiamondItem((ProfileCardInfo) ((AbsComponent) BaseProfileDiamondWallComponent.this).mData, true);
                            if (((ProfileCardInfo) ((AbsComponent) BaseProfileDiamondWallComponent.this).mData).allInOne.f260789pa == 0) {
                                ReportController.o(((AbsComponent) BaseProfileDiamondWallComponent.this).mApp, "CliOper", "", "", "0X8006A7B", "0X8006A7B", 0, 0, "", "", "", "");
                                ReportController.o(((AbsComponent) BaseProfileDiamondWallComponent.this).mApp, "dc00898", "", "", "qvip", "0X800A12F", 0, 0, "", "", "", "");
                            } else {
                                ReportController.o(((AbsComponent) BaseProfileDiamondWallComponent.this).mApp, "CliOper", "", "", "0X8006A8F", "0X8006A8F", 0, 0, "", "", "", "");
                                ReportController.o(((AbsComponent) BaseProfileDiamondWallComponent.this).mApp, "dc00898", "", "", "qvip", "0X800A137", 0, 0, String.valueOf(VipInfoHandler.J2(((AbsQQProfileContentComponent) BaseProfileDiamondWallComponent.this).mQQAppInterface, ((AbsComponent) BaseProfileDiamondWallComponent.this).mApp.getCurrentUin(), false)), "", "", "");
                            }
                        } else if (i17 == 93) {
                            Object obj = bVar.f260136b;
                            if (!(obj instanceof PrivilegeInfo)) {
                                QLog.e("DIYProfileTemplate.BaseProfileDiamondWallComponent", 1, "DATA_TYPE_BIG_DIAMOND url is not string:" + bVar.f260136b);
                            } else {
                                PrivilegeInfo privilegeInfo = (PrivilegeInfo) obj;
                                String str3 = privilegeInfo.strJumpUrl;
                                if (((ProfileCardInfo) ((AbsComponent) BaseProfileDiamondWallComponent.this).mData).allInOne.f260789pa == 0) {
                                    buildTraceDetailUrl2 = e.a().buildTraceDetailUrl(str3, IVipTraceDetailReport.FROM.PROFILECARD_SINGLE_DIAMOND);
                                } else {
                                    buildTraceDetailUrl2 = e.a().buildTraceDetailUrl(str3, IVipTraceDetailReport.FROM.PROFILECARD_SINGLE_DIAMOND_GUEST);
                                }
                                if (((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).isEnable()) {
                                    ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openBrowser(((AbsComponent) BaseProfileDiamondWallComponent.this).mActivity, buildTraceDetailUrl2);
                                } else {
                                    Intent intent2 = new Intent(((AbsComponent) BaseProfileDiamondWallComponent.this).mActivity, (Class<?>) QQBrowserActivity.class);
                                    intent2.putExtra("url", buildTraceDetailUrl2);
                                    intent2.putExtra("hide_operation_bar", true);
                                    intent2.putExtra("hide_more_button", true);
                                    intent2.putExtra("startOpenPageTime", System.currentTimeMillis());
                                    ((AbsComponent) BaseProfileDiamondWallComponent.this).mActivity.startActivity(intent2);
                                }
                                if (QLog.isColorLevel()) {
                                    QLog.d("DIYProfileTemplate.BaseProfileDiamondWallComponent", 1, "DATA_TYPE_BIG_DIAMOND click");
                                }
                                ProfileVipReport.reportDiamond((ProfileCardInfo) ((AbsComponent) BaseProfileDiamondWallComponent.this).mData, privilegeInfo.iType, true);
                                if (((ProfileCardInfo) ((AbsComponent) BaseProfileDiamondWallComponent.this).mData).allInOne.f260789pa == 0) {
                                    z16 = true;
                                } else {
                                    z16 = false;
                                }
                                int i18 = privilegeInfo.iType;
                                if (i18 != 1) {
                                    if (i18 != 102) {
                                        if (i18 != 113) {
                                            if (z16) {
                                                str = "0X800A137";
                                            } else {
                                                str = "0X800A12F";
                                            }
                                        } else if (z16) {
                                            str = "0X800A131";
                                        } else {
                                            str = "0X800A129";
                                        }
                                    } else if (z16) {
                                        str = "0X800A135";
                                    } else {
                                        str = "0X800A12D";
                                    }
                                } else if (z16) {
                                    str = "0X800A133";
                                } else {
                                    str = "0X800A12B";
                                }
                                String str4 = str;
                                if (!TextUtils.isEmpty(str4)) {
                                    if (privilegeInfo.iIsBig == 1) {
                                        if (privilegeInfo.isOpen) {
                                            i3 = 1;
                                            if (privilegeInfo.iType != 1) {
                                                int J2 = VipInfoHandler.J2(((AbsQQProfileContentComponent) BaseProfileDiamondWallComponent.this).mQQAppInterface, ((AbsComponent) BaseProfileDiamondWallComponent.this).mApp.getCurrentUin(), false);
                                                String valueOf = String.valueOf(J2);
                                                if (AnimatorHandler.playing && BaseProfileDiamondWallComponent.this.isNeedShowPop(privilegeInfo.iRemindTime, privilegeInfo.iType)) {
                                                    BaseProfileDiamondWallComponent.this.reportAction("0X800B27E", J2);
                                                } else if (AnimatorHandler.playing) {
                                                    BaseProfileDiamondWallComponent.this.reportAction("0X800B27C", J2);
                                                }
                                                str2 = valueOf;
                                            } else {
                                                str2 = "";
                                            }
                                            ReportController.o(((AbsComponent) BaseProfileDiamondWallComponent.this).mApp, "dc00898", "", "", "qvip", str4, i3, 0, str2, "", "", "");
                                        }
                                    } else if (privilegeInfo.isOpen) {
                                        i16 = 3;
                                    } else {
                                        i16 = 4;
                                    }
                                    i3 = i16;
                                    if (privilegeInfo.iType != 1) {
                                    }
                                    ReportController.o(((AbsComponent) BaseProfileDiamondWallComponent.this).mApp, "dc00898", "", "", "qvip", str4, i3, 0, str2, "", "", "");
                                }
                                BaseProfileDiamondWallComponent.this.reportCardIconClick(privilegeInfo);
                            }
                        }
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        };
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0097  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private View generateMedalImageView(PrivilegeInfo privilegeInfo, String str, float f16, float f17, float f18, Drawable drawable) {
        boolean z16;
        VaProfileGate$LoverSvipExtInfo vaProfileGate$LoverSvipExtInfo;
        URLImageView uRLImageView = new URLImageView(this.mActivity);
        int i3 = (int) f16;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, (int) f17);
        layoutParams.leftMargin = (int) f18;
        layoutParams.gravity = 16;
        uRLImageView.setLayoutParams(layoutParams);
        if (privilegeInfo.iType == 119) {
            z16 = false;
            try {
                byte[] bytes = privilegeInfo.strExtInfo.getBytes(Charsets.UTF_8);
                vaProfileGate$LoverSvipExtInfo = new VaProfileGate$LoverSvipExtInfo();
                vaProfileGate$LoverSvipExtInfo.mergeFrom(bytes);
            } catch (Exception e16) {
                QLog.e(TAG, 1, e16, new Object[0]);
            }
            if (vaProfileGate$LoverSvipExtInfo.iIconType.get() == 1) {
                ArrayList arrayList = new ArrayList();
                List<String> list = vaProfileGate$LoverSvipExtInfo.sDiyContents.get();
                for (int i16 = 0; i16 < list.size(); i16++) {
                    arrayList.add(list.get(i16));
                }
                uRLImageView.setImageDrawable(((ILoverVipIconDrawable) QRoute.api(ILoverVipIconDrawable.class)).getDrawable(i3, Integer.parseInt(vaProfileGate$LoverSvipExtInfo.sMaterialId.get()), privilegeInfo.iLevel, arrayList));
                if (z16) {
                    uRLImageView.setImageDrawable(a.a().l(VasDynamicDrawableCache.INSTANCE).k(str).a());
                }
                if (str.isEmpty()) {
                    QLog.e("QVipSettingMe.BaseProfileDiamondWallComponent", 1, "iconUrl:" + str);
                }
                uRLImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                return uRLImageView;
            }
        }
        z16 = true;
        if (z16) {
        }
        if (str.isEmpty()) {
        }
        uRLImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        return uRLImageView;
    }

    private View generateMedalLinerLayout(PrivilegeInfo privilegeInfo, String str, float f16, float f17, float f18, Drawable drawable) {
        int J2 = VipInfoHandler.J2(this.mQQAppInterface, this.mApp.getCurrentUin(), false);
        if (QLog.isDebugVersion()) {
            QLog.d(LevelUtil.PROFILE_CARD_TAG, 2, String.format("generateMedalLinerLayout , info.strTipsIconUrl: %s info.iRemindTime: %s info.iTipsTimes: %s info.iIsRemind: %s", privilegeInfo.strTipsIconUrl, Integer.valueOf(privilegeInfo.iRemindTime), Integer.valueOf(privilegeInfo.iTipsTimes), Integer.valueOf(privilegeInfo.iIsRemind)));
        }
        LinearLayout linearLayout = new LinearLayout(this.mActivity);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        String str2 = privilegeInfo.strTipsIconUrl;
        if (privilegeInfo.iIsRemind != 0 && isNeedShowPop(privilegeInfo.iRemindTime, privilegeInfo.iType) && !TextUtils.isEmpty(str2)) {
            float f19 = f17 / 2.0f;
            linearLayout.addView(generateMedalImageView(privilegeInfo, str2, f16, f19, f18, drawable));
            layoutParams.topMargin = (int) (-f19);
            if (privilegeInfo.iType == 1) {
                reportAction("0X800B27B", J2);
            }
        }
        View generateMedalImageView = generateMedalImageView(privilegeInfo, str, f16, f17, f18, drawable);
        if (privilegeInfo.iIsRemind != 0) {
            this.handler.removeMessages(privilegeInfo.iType);
            Message obtain = Message.obtain();
            obtain.what = privilegeInfo.iType;
            obtain.obj = generateMedalImageView;
            obtain.arg1 = 1;
            Bundle bundle = new Bundle();
            bundle.putLong(REMIND_TIME, privilegeInfo.iRemindTime);
            bundle.putInt(TIPS_TIMES, privilegeInfo.iTipsTimes);
            obtain.setData(bundle);
            this.handler.sendMessageDelayed(obtain, 500L);
            if (privilegeInfo.iType == 1) {
                reportAction("0X800B27D", J2);
            }
        }
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        linearLayout.addView(generateMedalImageView);
        return linearLayout;
    }

    private String getActionNameByType(boolean z16, String str, int i3, String str2, String str3) {
        int i16 = this.isMedalExposure;
        if ((i16 & i3) == 0) {
            if (z16) {
                str = str2;
            } else {
                str = str3;
            }
            this.isMedalExposure = i16 | i3;
        }
        return str;
    }

    private String getActionNameString(PrivilegeInfo privilegeInfo, boolean z16, String str) {
        int i3 = privilegeInfo.iType;
        if (i3 != 1) {
            if (i3 != 102) {
                if (i3 != 113) {
                    return getActionNameByType(z16, str, 8, "0X800A136", "0X800A12E");
                }
                return getActionNameByType(z16, str, 4, "0X800A130", "0X800A128");
            }
            return getActionNameByType(z16, str, 2, "0X800A134", "0X800A12C");
        }
        return getActionNameByType(z16, str, 1, "0X800A132", "0X800A12A");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public String getOldPrivilegeJumpUrl() {
        String str = ((ProfileCardInfo) this.mData).card.privilegeJumpUrl;
        if (TextUtils.isEmpty(str)) {
            if (((ProfileCardInfo) this.mData).allInOne.f260789pa == 0) {
                return "https://mc.vip.qq.com/privilegelist/index";
            }
            return "https://mc.vip.qq.com/privilegelist/other?friend=" + ((ProfileCardInfo) this.mData).allInOne.uin;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public String getTogglePrivilegeJumpUrl(String str) {
        boolean z16;
        String str2;
        String str3;
        if (((ProfileCardInfo) this.mData).allInOne.f260789pa == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            str2 = ProfileCardComponentConstant.TOGGLE_KEY_QQ_DIAMOND_HOST_URL;
        } else {
            str2 = ProfileCardComponentConstant.TOGGLE_KEY_QQ_DIAMOND_GUEST_URL;
        }
        if (z16) {
            str3 = ProfileCardComponentConstant.DEFAULT_QQ_DIAMOND_HOST_URL;
        } else {
            str3 = ProfileCardComponentConstant.DEFAULT_QQ_DIAMOND_GUEST_URL;
        }
        IFeatureRuntimeService iFeatureRuntimeService = (IFeatureRuntimeService) this.mApp.getRuntimeService(IFeatureRuntimeService.class, "all");
        if (!iFeatureRuntimeService.isFeatureSwitchEnable(ProfileCardComponentConstant.TOGGLE_SWITCH_QQ_VALUE, false)) {
            QLog.e(TAG, 1, "getToggleUrl, toggle is not enable.");
            return str;
        }
        JSONObject jSONObject = iFeatureRuntimeService.getJSONObject(ProfileCardComponentConstant.TOGGLE_SWITCH_QQ_VALUE, "");
        if (jSONObject != null && !TextUtils.isEmpty(jSONObject.toString())) {
            return jSONObject.optString(str2, str3).replace(ElegantProfileAccountLevelComponent.URL_REPLACE_FRIEND_QQ, ((ProfileCardInfo) this.mData).allInOne.uin);
        }
        QLog.e(TAG, 1, "getToggleUrl, jsonObject is empty.");
        return str3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isNeedShowPop(long j3, int i3) {
        if (j3 == BaseApplication.getContext().getSharedPreferences(SP_ICON_TWINKLE, 0).getLong(SP_SHOW_POP_BEGIN_TIME + i3, 0L)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean openByJumpParser(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith(SchemaUtils.SCHEMA_MQQAPI)) {
            ax c16 = bi.c((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime(), this.mActivity, str);
            if (c16 != null) {
                c16.b();
                return true;
            }
            QLog.e(TAG, 1, "openByJumpParser, parse mqqAPI url failed.");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportAction(String str, int i3) {
        AppInterface appInterface = this.mApp;
        ReportController.o(appInterface, "dc00898", "", appInterface.getCurrentUin(), str, str, i3, 0, String.valueOf(i3), "", "", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportCardIconClick(PrivilegeInfo privilegeInfo) {
        if (privilegeInfo.iType == 117) {
            ((IMobileReportManager) QRoute.api(IMobileReportManager.class)).reportAction(SearchConstants.PLATFORM, "\u8d44\u6599\u5361\u9875", "icon_badge", "", "" + privilegeInfo.iLevel, "", "58", 102, 0, 0, "", "", "");
        }
    }

    private void reportClickEvent(PrivilegeInfo privilegeInfo, String str) {
        int i3;
        int i16;
        String valueOf;
        if (!TextUtils.isEmpty(str)) {
            if (privilegeInfo.iIsBig == 1) {
                if (privilegeInfo.isOpen) {
                    i16 = 1;
                    if (privilegeInfo.iType != 1 && !str.equals("0X800A136")) {
                        valueOf = "";
                        ReportController.o(this.mApp, "dc00898", "", "", "qvip", str, i16, 0, valueOf, "", "", "");
                    }
                    valueOf = String.valueOf(VipInfoHandler.J2(this.mQQAppInterface, this.mApp.getCurrentUin(), false));
                    ReportController.o(this.mApp, "dc00898", "", "", "qvip", str, i16, 0, valueOf, "", "", "");
                }
                i3 = 2;
            } else if (privilegeInfo.isOpen) {
                i3 = 3;
            } else {
                i3 = 4;
            }
            i16 = i3;
            if (privilegeInfo.iType != 1) {
                valueOf = "";
                ReportController.o(this.mApp, "dc00898", "", "", "qvip", str, i16, 0, valueOf, "", "", "");
            }
            valueOf = String.valueOf(VipInfoHandler.J2(this.mQQAppInterface, this.mApp.getCurrentUin(), false));
            ReportController.o(this.mApp, "dc00898", "", "", "qvip", str, i16, 0, valueOf, "", "", "");
        }
    }

    public static void saveShowPopTime(long j3, int i3) {
        BaseApplication.getContext().getSharedPreferences(SP_ICON_TWINKLE, 0).edit().putLong(SP_SHOW_POP_BEGIN_TIME + i3, j3).apply();
    }

    private void setDescription(StringBuilder sb5, List<PrivilegeInfo> list) {
        if (sb5 == null || list == null) {
            return;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            setDescription(sb5, list.get(i3));
        }
    }

    protected int attachMetalImageItemToContainer(List<PrivilegeInfo> list, LinearLayout linearLayout, int i3, int[] iArr, int i16, int i17, Drawable drawable, boolean z16) {
        String str;
        int i18;
        int i19;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, this, list, linearLayout, Integer.valueOf(i3), iArr, Integer.valueOf(i16), Integer.valueOf(i17), drawable, Boolean.valueOf(z16))).intValue();
        }
        int i26 = 0;
        for (int i27 = 0; i27 < list.size(); i27++) {
            PrivilegeInfo privilegeInfo = list.get(i27);
            if (!TextUtils.isEmpty(privilegeInfo.strDeluxeIconUrl)) {
                if (i26 == 0) {
                    i19 = 0;
                } else {
                    i19 = i3;
                }
                int i28 = i26 + 1;
                int i29 = (iArr[0] - i16) - i19;
                iArr[0] = i29;
                if (i29 < 0) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 1, "medal list layout is big =" + privilegeInfo.iIsBig + " icon index=" + i28);
                    }
                    return i28;
                }
                String str2 = privilegeInfo.strDeluxeIconUrl;
                str = TAG;
                attachMetalImageToContainer(privilegeInfo, str2, linearLayout, i16, i17, i19, drawable, z16);
                i26 = i28;
            } else {
                str = TAG;
            }
            if (!TextUtils.isEmpty(privilegeInfo.strIconUrl)) {
                if (i26 == 0) {
                    i18 = 0;
                } else {
                    i18 = i3;
                }
                int i36 = i26 + 1;
                int i37 = (iArr[0] - i16) - i18;
                iArr[0] = i37;
                if (i37 < 0) {
                    if (QLog.isColorLevel()) {
                        QLog.d(str, 1, "medal list layout is big =" + privilegeInfo.iIsBig + " icon index=" + i36);
                    }
                    return i36;
                }
                attachMetalImageToContainer(privilegeInfo, privilegeInfo.strIconUrl, linearLayout, i16, i17, i18, drawable, z16);
                i26 = i36;
            }
        }
        return i26;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void attachMetalImageToContainer(PrivilegeInfo privilegeInfo, String str, LinearLayout linearLayout, int i3, int i16, int i17, Drawable drawable, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, privilegeInfo, str, linearLayout, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), drawable, Boolean.valueOf(z16));
            return;
        }
        View generateMedalLinerLayout = generateMedalLinerLayout(privilegeInfo, str, i3, i16, i17, drawable);
        linearLayout.addView(generateMedalLinerLayout);
        if (!TextUtils.isEmpty(privilegeInfo.strJumpUrl)) {
            generateMedalLinerLayout.setClickable(true);
            generateMedalLinerLayout.setTag(new b(93, privilegeInfo));
            generateMedalLinerLayout.setOnClickListener(this.mOnClickListener);
        } else {
            generateMedalLinerLayout.setTag(null);
            generateMedalLinerLayout.setOnClickListener(null);
            generateMedalLinerLayout.setClickable(false);
        }
        StringBuilder sb5 = new StringBuilder();
        setDescription(sb5, privilegeInfo);
        sb5.append("\u5fbd\u7ae0");
        if (privilegeInfo.isOpen) {
            sb5.append(" \u5df2\u5f00\u901a");
        } else {
            sb5.append(" \u672a\u5f00\u901a");
        }
        generateMedalLinerLayout.setContentDescription(sb5);
        reportClickEvent(privilegeInfo, getActionNameString(privilegeInfo, z16, ""));
        ProfileVipReport.reportDiamond((ProfileCardInfo) this.mData, privilegeInfo.iType, false);
        if (privilegeInfo.iType == 117) {
            ((IMobileReportManager) QRoute.api(IMobileReportManager.class)).reportAction(SearchConstants.PLATFORM, "\u8d44\u6599\u5361\u9875", "icon_badge", "", "" + privilegeInfo.iLevel, "", "58", 101, 0, 0, "", "", "");
        }
        if (!TextUtils.isEmpty(privilegeInfo.strDeluxeIconUrl) && privilegeInfo.iType == 1) {
            VasSvipPrivilegeAnimateHelper.addSvipPrivilegeAnimateView(generateMedalLinerLayout);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public String getComponentName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return TAG;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public int getComponentType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 1019;
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent, com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent
    public String getProfileContentKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return IProfileContentKey.MAP_KEY_DIAMOND;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v15, types: [android.view.View, VIEW] */
    public boolean makeOrRefreshMedalAndDiamond(ProfileCardInfo profileCardInfo, boolean z16) {
        Card card;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z18 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, this, profileCardInfo, Boolean.valueOf(z16))).booleanValue();
        }
        if (profileCardInfo == null) {
            card = null;
        } else {
            card = profileCardInfo.card;
        }
        if (card == null) {
            if (this.mViewContainer == 0) {
                z18 = false;
            }
            this.mViewContainer = null;
            return z18;
        }
        if (card.switchPrivilege == 0 && !Utils.G(profileCardInfo.allInOne.uin) && !ProfilePAUtils.isFromGuild(profileCardInfo.allInOne.f260789pa)) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LevelUtil.PROFILE_CARD_TAG, 2, String.format("makeAccountLineThree, , diamond: %s", Boolean.valueOf(z17)));
        }
        if (!z17) {
            if (this.mViewContainer == 0) {
                z18 = false;
            }
            this.mViewContainer = null;
            return z18;
        }
        if (this.mViewContainer == 0) {
            this.mViewContainer = LayoutInflater.from(this.mActivity).inflate(R.layout.b07, (ViewGroup) null);
        } else {
            z18 = false;
        }
        ImageView imageView = (ImageView) ((View) this.mViewContainer).findViewById(R.id.f164472yw);
        View findViewById = ((View) this.mViewContainer).findViewById(R.id.icon);
        findViewById.setBackgroundResource(TokenResUtils.getTokenRes(R.drawable.qq_profilecard_item_privilege, R.drawable.qui_super_member));
        View findViewById2 = ((View) this.mViewContainer).findViewById(R.id.bkm);
        if (z17) {
            updateDiamondView(profileCardInfo, findViewById2);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) findViewById2.getLayoutParams();
            marginLayoutParams.leftMargin = 0;
            findViewById2.setLayoutParams(marginLayoutParams);
        } else {
            findViewById2.setVisibility(8);
            ((View) this.mViewContainer).setTag(null);
        }
        if (z17) {
            ((View) this.mViewContainer).setTag(new b(26, null));
            ((View) this.mViewContainer).setOnClickListener(this.mOnClickListener);
        }
        updateItemTheme((View) this.mViewContainer, null, findViewById, null, imageView);
        IDiyMoreInfoManager diyMoreInfoManager = ProfileTemplateApi.getDiyMoreInfoManager(this.mComponentCenter);
        if (diyMoreInfoManager.isDiy()) {
            ((View) this.mViewContainer).setBackgroundResource(R.drawable.f160556k2);
            diyMoreInfoManager.updateMetalForDeepDiy((View) this.mViewContainer);
        }
        return z18;
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent, com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onCreate(QBaseActivity qBaseActivity, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qBaseActivity, (Object) bundle);
            return;
        }
        super.onCreate(qBaseActivity, bundle);
        Resources resources = this.mActivity.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        this.mDensity = displayMetrics.density;
        this.mItemInfoWidth = (Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels) - ((resources.getDimensionPixelSize(R.dimen.f159041uo) + resources.getDimensionPixelSize(R.dimen.a07)) + resources.getDimensionPixelSize(R.dimen.a08))) - (((this.mDensity * 7.0f) + resources.getDimensionPixelSize(R.dimen.f159312a04)) + resources.getDimensionPixelSize(R.dimen.f159313a05));
    }

    protected void showDiamondImage(List<PrivilegeInfo> list, LinearLayout linearLayout, boolean z16) {
        boolean z17;
        LinearLayout.LayoutParams layoutParams;
        float f16;
        float f17;
        float f18;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        LinearLayout linearLayout4;
        LinearLayout.LayoutParams layoutParams2;
        float f19;
        int attachMetalImageItemToContainer;
        int i3;
        LinearLayout.LayoutParams layoutParams3;
        LinearLayout.LayoutParams layoutParams4;
        int i16;
        boolean z18;
        List<PrivilegeInfo> list2 = list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, list2, linearLayout, Boolean.valueOf(z16));
            return;
        }
        float f26 = this.mDensity;
        float f27 = f26 * 20.0f;
        float f28 = f26 * 20.0f;
        float f29 = f26 * 2.0f;
        float f36 = f26 * 5.0f;
        float f37 = f26 * 6.0f;
        float f38 = f26 * 8.0f;
        float f39 = f26 * 16.0f;
        float f46 = f26 * 36.0f;
        if (linearLayout != null && list2 != null && list.size() >= 1) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int i17 = 0;
            while (i17 < list.size()) {
                PrivilegeInfo privilegeInfo = list2.get(i17);
                if (privilegeInfo.iIsBig == 1) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (z18) {
                    arrayList.add(privilegeInfo);
                } else {
                    arrayList2.add(privilegeInfo);
                }
                i17++;
                list2 = list;
            }
            ColorDrawable colorDrawable = new ColorDrawable(16777215);
            LinearLayout linearLayout5 = new LinearLayout(this.mActivity);
            LinearLayout linearLayout6 = new LinearLayout(this.mActivity);
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
            LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
            linearLayout5.setOrientation(0);
            linearLayout5.setLayoutParams(layoutParams5);
            linearLayout6.setOrientation(0);
            linearLayout6.setLayoutParams(layoutParams6);
            int[] iArr = new int[1];
            if (QzoneConfig.getInstance().getConfig("qqsetting", QVipConfigManager.SECONDARY_KEY_PROFILE_MEDAL_ICON, 0) == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                iArr[0] = (int) (this.mItemInfoWidth - f29);
                int i18 = (int) f29;
                int i19 = (int) f46;
                linearLayout4 = linearLayout5;
                linearLayout3 = linearLayout6;
                layoutParams = layoutParams5;
                f17 = f38;
                f16 = f29;
                f18 = f37;
                i3 = attachMetalImageItemToContainer(arrayList, linearLayout6, i18, iArr, i19, i19, colorDrawable, z16);
                if (i3 > 0) {
                    iArr[0] = iArr[0] - ((int) f18);
                }
                if (i3 > 0) {
                    i16 = (int) f17;
                } else {
                    i16 = (int) f36;
                }
                attachMetalImageItemToContainer = attachMetalImageItemToContainer(arrayList2, linearLayout4, i16, iArr, (int) f27, (int) f28, colorDrawable, z16);
                linearLayout2 = linearLayout;
                linearLayout2.setOrientation(0);
                layoutParams2 = layoutParams6;
            } else {
                layoutParams = layoutParams5;
                f16 = f29;
                f17 = f38;
                f18 = f37;
                linearLayout2 = linearLayout;
                linearLayout3 = linearLayout6;
                linearLayout4 = linearLayout5;
                iArr[0] = (int) (this.mItemInfoWidth - f16);
                int i26 = (int) f46;
                layoutParams2 = layoutParams6;
                int attachMetalImageItemToContainer2 = attachMetalImageItemToContainer(arrayList, linearLayout3, 0, iArr, i26, i26, colorDrawable, z16);
                iArr[0] = (int) ((this.mItemInfoWidth - f17) - f16);
                if (attachMetalImageItemToContainer2 > 0) {
                    f19 = f39;
                } else {
                    f19 = f36;
                }
                attachMetalImageItemToContainer = attachMetalImageItemToContainer(arrayList2, linearLayout4, (int) f19, iArr, (int) f27, (int) f28, colorDrawable, z16);
                linearLayout2.setOrientation(1);
                i3 = attachMetalImageItemToContainer2;
            }
            View view = linearLayout3;
            if (i3 > 0) {
                linearLayout2.addView(view);
            }
            if (attachMetalImageItemToContainer > 0) {
                if (i3 > 0) {
                    if (z17) {
                        layoutParams3 = layoutParams;
                        layoutParams3.leftMargin = (int) f18;
                    } else {
                        layoutParams3 = layoutParams;
                        layoutParams3.leftMargin = (int) f17;
                    }
                } else {
                    layoutParams3 = layoutParams;
                }
                if (z17) {
                    layoutParams4 = layoutParams2;
                    layoutParams4.gravity = 16;
                    layoutParams3.gravity = 16;
                } else {
                    layoutParams4 = layoutParams2;
                    layoutParams3.topMargin = (int) f16;
                }
                view.setLayoutParams(layoutParams4);
                View view2 = linearLayout4;
                view2.setLayoutParams(layoutParams3);
                linearLayout2.addView(view2);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void updateDiamondView(ProfileCardInfo profileCardInfo, View view) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) profileCardInfo, (Object) view);
            return;
        }
        if (profileCardInfo != null && profileCardInfo.card != null && view != null) {
            view.setVisibility(0);
            Card card = profileCardInfo.card;
            List<PrivilegeInfo> privilegeOpenInfo = card.getPrivilegeOpenInfo();
            List<PrivilegeInfo> privilegeCloseInfo = card.getPrivilegeCloseInfo();
            TextView textView = (TextView) view.findViewById(R.id.g2l);
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.bkn);
            linearLayout.removeAllViews();
            StringBuilder sb5 = new StringBuilder(24);
            sb5.append(this.mActivity.getString(R.string.f171034bv4));
            this.noDiamond = false;
            if (profileCardInfo.allInOne.f260789pa != 0 && !this.mApp.getCurrentAccountUin().equals(profileCardInfo.allInOne.uin)) {
                if (privilegeOpenInfo != null && !privilegeOpenInfo.isEmpty()) {
                    linearLayout.setVisibility(0);
                    textView.setVisibility(8);
                    showDiamondImage(privilegeOpenInfo, linearLayout, true);
                    sb5.append("\u4f60\u7684\u597d\u53cb\u5df2\u5f00\u901a");
                    setDescription(sb5, privilegeOpenInfo);
                } else {
                    String str = card.privilegePromptStr;
                    if (TextUtils.isEmpty(str)) {
                        textView.setText(this.mActivity.getString(R.string.f203344zy));
                    } else {
                        textView.setText(str);
                    }
                    sb5.append("TA\u8fd8\u672a\u5f00\u901a\u4efb\u4f55\u670d\u52a1\u7279\u6743");
                    linearLayout.setVisibility(8);
                    textView.setVisibility(0);
                    this.noDiamond = true;
                }
            } else {
                List<PrivilegeInfo> arrayList = new ArrayList<>();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                if (privilegeOpenInfo != null && (privilegeOpenInfo.size() > 0 || (privilegeCloseInfo != null && !privilegeCloseInfo.isEmpty()))) {
                    linearLayout.setVisibility(0);
                    textView.setVisibility(8);
                    String str2 = "";
                    int i3 = 0;
                    for (PrivilegeInfo privilegeInfo : privilegeOpenInfo) {
                        if (privilegeInfo.iIsBig == 1) {
                            arrayList2.add(privilegeInfo);
                        } else {
                            arrayList3.add(privilegeInfo);
                        }
                        privilegeInfo.isOpen = true;
                        i3++;
                        str2 = "\u4f60\u5df2\u5f00\u901a";
                    }
                    if (i3 == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    this.noDiamond = z16;
                    sb5.append(str2);
                    setDescription(sb5, privilegeOpenInfo);
                } else {
                    linearLayout.setVisibility(8);
                    textView.setVisibility(0);
                    textView.setText(this.mActivity.getString(R.string.f203354zz));
                    sb5.append("\u4f60\u672a\u5f00\u901a\u7279\u6743\u670d\u52a1\uff0c\u5feb\u53bb\u5f00\u901avip\u670d\u52a1\u5427\uff01");
                    this.noDiamond = true;
                }
                if (privilegeCloseInfo != null && !privilegeCloseInfo.isEmpty()) {
                    for (PrivilegeInfo privilegeInfo2 : privilegeCloseInfo) {
                        if (privilegeInfo2.iIsBig == 1) {
                            arrayList2.add(privilegeInfo2);
                        } else {
                            arrayList3.add(privilegeInfo2);
                        }
                        privilegeInfo2.isOpen = false;
                    }
                }
                arrayList.addAll(arrayList2);
                arrayList.addAll(arrayList3);
                showDiamondImage(arrayList, linearLayout, false);
            }
            linearLayout.setContentDescription(sb5);
            updateItemTheme(null, null, null, textView, null);
            ProfileVipReport.reportDiamondItem((ProfileCardInfo) this.mData, false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: onDataUpdate, reason: merged with bridge method [inline-methods] */
    public boolean lambda$checkValidComponent$3(ProfileCardInfo profileCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) profileCardInfo)).booleanValue();
        }
        boolean lambda$checkValidComponent$3 = super.lambda$checkValidComponent$3((BaseProfileDiamondWallComponent) profileCardInfo);
        DATA data = this.mData;
        boolean makeOrRefreshMedalAndDiamond = lambda$checkValidComponent$3 | makeOrRefreshMedalAndDiamond((ProfileCardInfo) data, ((ProfileCardInfo) data).isNetRet);
        if (makeOrRefreshMedalAndDiamond && !this.isInitDtReport) {
            this.isInitDtReport = true;
            ProfileCardDtReportUtil.initElementWithExposure((View) this.mViewContainer, ProfileCardDtReportUtil.DT_REPORT_VIP);
        }
        return makeOrRefreshMedalAndDiamond;
    }

    private void setDescription(StringBuilder sb5, PrivilegeInfo privilegeInfo) {
        if (privilegeInfo == null) {
            return;
        }
        int i3 = privilegeInfo.iType;
        if (i3 == 1) {
            sb5.append("\u4f1a\u5458");
            return;
        }
        if (i3 == 2) {
            sb5.append("\u8d85\u7ea7QQ");
            return;
        }
        if (i3 == 3) {
            sb5.append("\u8d85\u7ea7\u4f1a\u5458");
            return;
        }
        if (i3 == 4) {
            sb5.append("\u597d\u83b1\u575e\u4f1a\u5458");
            return;
        }
        if (i3 == 5) {
            sb5.append("\u817e\u8baf\u56fe\u4e66VIP");
            return;
        }
        if (i3 == 107 || i3 == 109) {
            sb5.append("SVIP\u8054\u5408\u4f1a\u5458");
            return;
        }
        if (i3 == 113) {
            sb5.append("\u5927\u4f1a\u5458");
            return;
        }
        if (i3 != 117) {
            switch (i3) {
                case 101:
                    sb5.append("\u7ea2\u94bb");
                    return;
                case 102:
                    sb5.append("\u9ec4\u94bb");
                    return;
                case 103:
                    sb5.append("\u7eff\u94bb");
                    return;
                case 104:
                    sb5.append("\u60c5\u4fa3\u9ec4\u94bb");
                    return;
                case 105:
                    sb5.append("\u8d85\u7ea7\u661f\u94bb");
                    return;
                default:
                    return;
            }
        }
        sb5.append("QQ\u96c6\u5361");
    }
}
