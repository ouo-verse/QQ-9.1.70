package com.tencent.mobileqq.profilecard.component.content;

import QQService.EVIPSPEC;
import QQService.PrivilegeInfo;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.common.app.AppInterface;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.extendfriend.widget.ClickableFrameLayout;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileContentKey;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent;
import com.tencent.mobileqq.profilecard.component.ProfileCardComponentConstant;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.profilecard.widget.QQLevelView;
import com.tencent.mobileqq.profilecard.widget.QidView;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ff;
import com.tencent.mobileqq.utils.u;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.vas.image.c;
import com.tencent.mobileqq.vas.inject.VasInjectApi;
import com.tencent.mobileqq.vas.qqvaluecard.view.QQValuePagView;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.vipicon.api.IVipIconFactory;
import com.tencent.mobileqq.vip.api.f;
import com.tencent.mobileqq.widget.ah;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import m23.b;
import org.json.JSONObject;

/* loaded from: classes35.dex */
public class ElegantProfileAccountLevelComponent extends AbsQQProfileContentComponent {
    private static final int ANIMATOR_DENSITY = 500;
    private static final int MAX_SHOW_DIAMOND_NUMBER = 3;
    private static final String TAG = "ElegantProfileAccountLevelComponent";
    public static final String URL_REPLACE_FRIEND_QQ = "{friendqq}";
    private static final int[] priorityShowVIPDiamond = {113, 1, 102};
    private boolean isInitDtReport;
    protected boolean mIsFromArkBabyQ;
    protected String qqDiamondGuestUrl;
    protected String qqDiamondHostUrl;
    private ClickableFrameLayout qqDiamondLayout;
    protected String qqValueGuestUrl;
    protected String qqValueHostUrl;
    private ClickableFrameLayout qqValueLayout;

    public ElegantProfileAccountLevelComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        this.isInitDtReport = false;
        this.qqValueHostUrl = ProfileCardComponentConstant.DEFAULT_QQ_VALUE_HOST_URL;
        this.qqDiamondHostUrl = ProfileCardComponentConstant.DEFAULT_QQ_DIAMOND_HOST_URL;
        this.qqValueGuestUrl = ProfileCardComponentConstant.DEFAULT_QQ_VALUE_GUEST_URL;
        this.qqDiamondGuestUrl = ProfileCardComponentConstant.DEFAULT_QQ_DIAMOND_GUEST_URL;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void adapterNightTheme(boolean z16) {
        VIEW view = this.mViewContainer;
        if (view != 0) {
            ((View) view).setBackgroundColor(z16 ? -16777216 : -1);
            ((View) this.mViewContainer).findViewById(R.id.ovt).setBackgroundResource(z16 ? R.drawable.kut : R.drawable.kup);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void bindClickEvent(final boolean z16) {
        VIEW view = this.mViewContainer;
        if (view != 0) {
            this.qqValueLayout = (ClickableFrameLayout) ((View) view).findViewById(R.id.owo);
            this.qqDiamondLayout = (ClickableFrameLayout) ((View) this.mViewContainer).findViewById(R.id.owi);
            ClickableFrameLayout clickableFrameLayout = this.qqValueLayout;
            if (clickableFrameLayout != null) {
                clickableFrameLayout.setOnDispatchListener(new ClickableFrameLayout.a() { // from class: com.tencent.mobileqq.profilecard.component.content.ElegantProfileAccountLevelComponent.1
                    @Override // com.tencent.mobileqq.extendfriend.widget.ClickableFrameLayout.a
                    public void onActionDownTouchEvent(MotionEvent motionEvent) {
                        ((View) ((AbsComponent) ElegantProfileAccountLevelComponent.this).mViewContainer).findViewById(R.id.owp).setVisibility(0);
                    }

                    @Override // com.tencent.mobileqq.extendfriend.widget.ClickableFrameLayout.a
                    public void onActionUpTouchEvent(MotionEvent motionEvent) {
                        ((View) ((AbsComponent) ElegantProfileAccountLevelComponent.this).mViewContainer).findViewById(R.id.owp).setVisibility(8);
                    }
                });
                this.qqValueLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.component.content.ElegantProfileAccountLevelComponent.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        String str;
                        if (u.a().b()) {
                            return;
                        }
                        if (z16) {
                            str = ElegantProfileAccountLevelComponent.this.qqValueGuestUrl;
                        } else {
                            str = ElegantProfileAccountLevelComponent.this.qqValueHostUrl;
                        }
                        ElegantProfileAccountLevelComponent.this.openWebPage(str);
                        ProfileCardDtReportUtil.dtReportClick(((View) ((AbsComponent) ElegantProfileAccountLevelComponent.this).mViewContainer).findViewById(R.id.owk));
                    }
                });
            }
            ClickableFrameLayout clickableFrameLayout2 = this.qqDiamondLayout;
            if (clickableFrameLayout2 != null) {
                clickableFrameLayout2.setOnDispatchListener(new ClickableFrameLayout.a() { // from class: com.tencent.mobileqq.profilecard.component.content.ElegantProfileAccountLevelComponent.3
                    @Override // com.tencent.mobileqq.extendfriend.widget.ClickableFrameLayout.a
                    public void onActionDownTouchEvent(MotionEvent motionEvent) {
                        ((View) ((AbsComponent) ElegantProfileAccountLevelComponent.this).mViewContainer).findViewById(R.id.owj).setVisibility(0);
                    }

                    @Override // com.tencent.mobileqq.extendfriend.widget.ClickableFrameLayout.a
                    public void onActionUpTouchEvent(MotionEvent motionEvent) {
                        ((View) ((AbsComponent) ElegantProfileAccountLevelComponent.this).mViewContainer).findViewById(R.id.owj).setVisibility(8);
                    }
                });
                this.qqDiamondLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.component.content.ElegantProfileAccountLevelComponent.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        String str;
                        if (u.a().b()) {
                            return;
                        }
                        if (z16) {
                            str = ElegantProfileAccountLevelComponent.this.qqDiamondGuestUrl;
                        } else {
                            str = ElegantProfileAccountLevelComponent.this.qqDiamondHostUrl;
                        }
                        ElegantProfileAccountLevelComponent.this.openWebPage(str);
                        ProfileCardDtReportUtil.dtReportClick(view2);
                    }
                });
            }
        }
    }

    private Drawable getDefaultVIPDrawable(Card card) {
        AppInterface appInterface;
        int i3;
        if (this.mActivity == null || (appInterface = this.mApp) == null) {
            return null;
        }
        int[] d16 = ff.j.d(appInterface, card.uin);
        if (isShowDiyVipIcon(card, d16)) {
            i3 = ff.j.c(f.b(d16[0]));
        } else {
            if (!isQQVip(card)) {
                if (!isSuperVip(card)) {
                    if (isBigClubVip(card)) {
                        if (isBigClubYearVip(card)) {
                            i3 = R.drawable.bhn;
                        }
                    } else if (!card.isVipOpen(EVIPSPEC.E_SP_SUPERVIP)) {
                        if (!card.isVipOpen(EVIPSPEC.E_SP_QQVIP)) {
                            i3 = R.drawable.f4n;
                        }
                    }
                }
                i3 = R.drawable.bhl;
            }
            i3 = R.drawable.bhm;
        }
        return ResourcesCompat.getDrawable(this.mActivity.getResources(), i3, null);
    }

    private String[] getDiyVipIconUrl(Card card, int[] iArr) {
        return ff.j.e(this.mApp, card.uin, f.b(iArr[0]), ff.j.h(iArr[1]));
    }

    private void getUrlInfo() {
        JSONObject jSONObject;
        AppInterface appInterface = this.mApp;
        if (appInterface == null) {
            return;
        }
        IFeatureRuntimeService iFeatureRuntimeService = (IFeatureRuntimeService) appInterface.getRuntimeService(IFeatureRuntimeService.class, "all");
        if (!iFeatureRuntimeService.isFeatureSwitchEnable(ProfileCardComponentConstant.TOGGLE_SWITCH_QQ_VALUE, false) || (jSONObject = iFeatureRuntimeService.getJSONObject(ProfileCardComponentConstant.TOGGLE_SWITCH_QQ_VALUE, "")) == null) {
            return;
        }
        this.qqValueHostUrl = jSONObject.optString(ProfileCardComponentConstant.TOGGLE_KEY_QQ_VALUE_HOST_URL, ProfileCardComponentConstant.DEFAULT_QQ_VALUE_HOST_URL);
        this.qqDiamondHostUrl = jSONObject.optString(ProfileCardComponentConstant.TOGGLE_KEY_QQ_DIAMOND_HOST_URL, ProfileCardComponentConstant.DEFAULT_QQ_DIAMOND_HOST_URL);
        this.qqValueGuestUrl = jSONObject.optString(ProfileCardComponentConstant.TOGGLE_KEY_QQ_VALUE_GUEST_URL, ProfileCardComponentConstant.DEFAULT_QQ_VALUE_GUEST_URL);
        this.qqDiamondGuestUrl = jSONObject.optString(ProfileCardComponentConstant.TOGGLE_KEY_QQ_DIAMOND_GUEST_URL, ProfileCardComponentConstant.DEFAULT_QQ_DIAMOND_GUEST_URL);
    }

    private List<PrivilegeInfo> getVIPDiamondList(Card card, boolean z16) {
        List<PrivilegeInfo> privilegeOpenInfo = card.getPrivilegeOpenInfo();
        List<PrivilegeInfo> privilegeCloseInfo = card.getPrivilegeCloseInfo();
        ArrayList arrayList = new ArrayList(privilegeOpenInfo);
        if (!z16 && arrayList.size() < 3) {
            for (int i3 : priorityShowVIPDiamond) {
                for (int i16 = 0; i16 < privilegeCloseInfo.size(); i16++) {
                    if (privilegeCloseInfo.get(i16).iType == i3) {
                        arrayList.add(privilegeCloseInfo.get(i16));
                        if (arrayList.size() >= 3) {
                            return arrayList;
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private String[] getVipApngUrl(Card card) {
        AppInterface appInterface;
        if (this.mActivity == null || (appInterface = this.mApp) == null) {
            return null;
        }
        int[] d16 = ff.j.d(appInterface, card.uin);
        if (isShowDiyVipIcon(card, d16)) {
            return getDiyVipIconUrl(card, d16);
        }
        if (isQQVip(card)) {
            return new String[]{getVipIconUrl(card, EVIPSPEC.E_SP_QQVIP)};
        }
        if (isSuperVip(card)) {
            return new String[]{getVipIconUrl(card, EVIPSPEC.E_SP_SUPERVIP)};
        }
        if (isBigClubVip(card)) {
            return new String[]{getVipIconUrl(card, EVIPSPEC.E_SP_BIGCLUB)};
        }
        EVIPSPEC evipspec = EVIPSPEC.E_SP_SUPERVIP;
        if (card.isVipOpen(evipspec)) {
            return new String[]{getVipIconUrl(card, evipspec)};
        }
        EVIPSPEC evipspec2 = EVIPSPEC.E_SP_QQVIP;
        if (card.isVipOpen(evipspec2)) {
            return new String[]{getVipIconUrl(card, evipspec2)};
        }
        return null;
    }

    private String getVipIconUrl(Card card, EVIPSPEC evipspec) {
        return ff.j.f(getVipType(card.uin, evipspec), getVipLevel(card, evipspec), getVipTemplateId(card, evipspec));
    }

    private int getVipLevel(Card card, EVIPSPEC evipspec) {
        if (evipspec == EVIPSPEC.E_SP_QQVIP) {
            return card.iQQVipLevel;
        }
        if (evipspec == EVIPSPEC.E_SP_SUPERVIP) {
            return card.iSuperVipLevel;
        }
        if (evipspec == EVIPSPEC.E_SP_BIGCLUB) {
            return card.iBigClubVipLevel;
        }
        return 0;
    }

    private long getVipTemplateId(Card card, EVIPSPEC evipspec) {
        if (evipspec == EVIPSPEC.E_SP_QQVIP) {
            return 0L;
        }
        if (evipspec == EVIPSPEC.E_SP_SUPERVIP) {
            return card.lSuperVipTemplateId;
        }
        if (evipspec == EVIPSPEC.E_SP_BIGCLUB) {
            return card.lBigClubTemplateId;
        }
        return 0L;
    }

    private int getVipType(String str, EVIPSPEC evipspec) {
        short s16 = ff.s(this.mApp, str, evipspec);
        return ((s16 & 15) << 8) | (s16 >> 8);
    }

    private boolean isBigClubVip(Card card) {
        return card.uCurMulType == 6 && card.isVipOpen(EVIPSPEC.E_SP_BIGCLUB) && (ff.r(this.mApp, card.uin, false) >> 8) == 3;
    }

    private boolean isBigClubYearVip(Card card) {
        return (ff.r(this.mApp, card.uin, false) & 15) == 1;
    }

    private boolean isQQVip(Card card) {
        boolean isVipOpen = card.isVipOpen(EVIPSPEC.E_SP_QQVIP);
        long j3 = card.uCurMulType;
        return (j3 == 1 || j3 == 2) && isVipOpen;
    }

    private boolean isSuperVip(Card card) {
        boolean isVipOpen = card.isVipOpen(EVIPSPEC.E_SP_SUPERVIP);
        long j3 = card.uCurMulType;
        return (j3 == 3 || j3 == 4) && isVipOpen;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void openWebPage(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.contains(URL_REPLACE_FRIEND_QQ)) {
            str = str.replace(URL_REPLACE_FRIEND_QQ, ((ProfileCardInfo) this.mData).card.uin);
        }
        Intent intent = new Intent(this.mActivity, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", str);
        this.mActivity.startActivity(intent);
    }

    private void showImage(PrivilegeInfo privilegeInfo, URLImageView uRLImageView) {
        String str;
        if (TextUtils.isEmpty(privilegeInfo.strDeluxeIconUrl)) {
            str = privilegeInfo.strIconUrl;
        } else {
            str = privilegeInfo.strDeluxeIconUrl;
        }
        URLDrawable apngURLDrawable = VasApngUtil.getApngURLDrawable(str, VasApngUtil.VIP_APNG_TAGS, new ColorDrawable(16777215));
        if (apngURLDrawable != null) {
            uRLImageView.setColorFilter(0);
            if (apngURLDrawable.getStatus() == 2) {
                uRLImageView.setVisibility(8);
                apngURLDrawable.restartDownload();
            }
            if (!TextUtils.isEmpty(privilegeInfo.strTipsIconUrl) && (apngURLDrawable.getCurrDrawable() instanceof ApngDrawable)) {
                ApngImage image = ((ApngDrawable) apngURLDrawable.getCurrDrawable()).getImage();
                image.apngLoop = privilegeInfo.iTipsTimes;
                image.setDensity(500);
            }
            uRLImageView.setVisibility(0);
            uRLImageView.setImageDrawable(apngURLDrawable);
            uRLImageView.setURLDrawableDownListener(new ah(uRLImageView, str, "showDiamondImage onLoadFailed iconUrl = "));
            return;
        }
        QLog.e("QVipSettingMe.ElegantProfileAccountLevelComponent", 1, "apn drawable get null!iconUrl:" + str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void updateQID(Card card, boolean z16, boolean z17) {
        QidView qidView = (QidView) ((View) this.mViewContainer).findViewById(R.id.owh);
        qidView.update(card.qid, card.isVipOpen(EVIPSPEC.E_SP_SUPERVIP), z16, z17);
        ProfileCardDtReportUtil.initElementWithExposureClick(qidView, ProfileCardDtReportUtil.DT_REPORT_ACCOUNT);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void updateQQLevel(Card card, boolean z16) {
        QQLevelView qQLevelView = (QQLevelView) ((View) this.mViewContainer).findViewById(R.id.owk);
        qQLevelView.update(card.iQQLevel, z16);
        ProfileCardDtReportUtil.initElementWithExposureClick(qQLevelView, ProfileCardDtReportUtil.DT_REPORT_LEVEL);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void updateQQValue(Card card, boolean z16) {
        QQValuePagView qQValuePagView = (QQValuePagView) ((View) this.mViewContainer).findViewById(R.id.f163208ow2);
        qQValuePagView.B(card.uin, IndividuationUrlHelper.UrlId.CARD_HOME, false);
        if (z16) {
            qQValuePagView.setAlpha(0.7f);
        } else {
            qQValuePagView.setAlpha(1.0f);
        }
        qQValuePagView.setForeground(null);
        ProfileCardDtReportUtil.initElementWithExposureClick(qQValuePagView, ProfileCardDtReportUtil.DT_REPORT_ENERGY);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void updateVIPDiamond(Card card, boolean z16) {
        List<PrivilegeInfo> vIPDiamondList = getVIPDiamondList(card, z16);
        boolean z17 = (z16 && vIPDiamondList.size() == 0) ? false : true;
        View findViewById = ((View) this.mViewContainer).findViewById(R.id.owi);
        View findViewById2 = ((View) this.mViewContainer).findViewById(R.id.owp);
        View findViewById3 = ((View) this.mViewContainer).findViewById(R.id.owj);
        if (z17) {
            findViewById.setVisibility(0);
            findViewById2.setBackgroundResource(R.drawable.kur);
            findViewById3.setBackgroundResource(R.drawable.kus);
            ArrayList arrayList = new ArrayList();
            arrayList.add((URLImageView) ((View) this.mViewContainer).findViewById(R.id.ouu));
            arrayList.add((URLImageView) ((View) this.mViewContainer).findViewById(R.id.ouv));
            arrayList.add((URLImageView) ((View) this.mViewContainer).findViewById(R.id.ouw));
            for (int i3 = 0; i3 < 3; i3++) {
                URLImageView uRLImageView = (URLImageView) arrayList.get(i3);
                if (i3 < vIPDiamondList.size()) {
                    showImage(vIPDiamondList.get(i3), uRLImageView);
                } else {
                    uRLImageView.setVisibility(8);
                }
            }
            return;
        }
        findViewById.setVisibility(8);
        findViewById2.setBackgroundResource(R.drawable.kuq);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void updateVip(Card card, boolean z16) {
        ImageView imageView = (ImageView) ((View) this.mViewContainer).findViewById(R.id.f163220oy4);
        ProfileCardDtReportUtil.initElementWithExposureClick(imageView, ProfileCardDtReportUtil.DT_REPORT_NAMEPLATE);
        c icon = ((IVipIconFactory) QRoute.api(IVipIconFactory.class)).getIcon(imageView.getResources(), card.uin, VasInjectApi.getInstance().getVipIconInfo(card));
        if (icon != null) {
            imageView.setImageDrawable(icon);
            imageView.setContentDescription(HardCodeUtil.qqStr(R.string.vhq));
            imageView.setVisibility(0);
        } else {
            imageView.setImageDrawable(null);
            imageView.setVisibility(8);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: getComponentName */
    public String getTAG() {
        return TAG;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public int getComponentType() {
        return 1037;
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent, com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent
    public String getProfileContentKey() {
        return IProfileContentKey.MAP_KEY_ELEGANT_ACCOUNT_LEVEL;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected boolean needShow() {
        return (this.mIsFromArkBabyQ || !ProfilePAUtils.isPaTypeShowAccount(((ProfileCardInfo) this.mData).allInOne) || ProfilePAUtils.isFromGuild(((ProfileCardInfo) this.mData).allInOne.f260789pa)) ? false : true;
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent, com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onCreate(QBaseActivity qBaseActivity, Bundle bundle) {
        super.onCreate(qBaseActivity, bundle);
        Intent intent = this.mActivity.getIntent();
        if (intent != null) {
            this.mIsFromArkBabyQ = intent.getBooleanExtra(IProfileCardConst.KEY_FROM_ARK_BABYQ, false);
        }
        getUrlInfo();
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onDestroy() {
        b.b().g(IndividuationUrlHelper.UrlId.CARD_HOME);
        super.onDestroy();
    }

    private boolean isShowDiyVipIcon(Card card, int[] iArr) {
        if (ff.j.g(iArr[0])) {
            return this.mApp.getCurrentAccountUin().equals(card.uin) || !ff.j.h(iArr[1]);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: onDataUpdate, reason: merged with bridge method [inline-methods] */
    public boolean lambda$checkValidComponent$3(ProfileCardInfo profileCardInfo) {
        ClickableFrameLayout clickableFrameLayout;
        boolean makeOrRefreshAccountLevel = makeOrRefreshAccountLevel(profileCardInfo.card) | super.lambda$checkValidComponent$3((ElegantProfileAccountLevelComponent) profileCardInfo);
        if (makeOrRefreshAccountLevel && !this.isInitDtReport && this.qqValueLayout != null && (clickableFrameLayout = this.qqDiamondLayout) != null) {
            this.isInitDtReport = true;
            ProfileCardDtReportUtil.initElementWithExposure(clickableFrameLayout, ProfileCardDtReportUtil.DT_REPORT_VIP);
        }
        return makeOrRefreshAccountLevel;
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [android.view.View, VIEW] */
    private boolean makeOrRefreshAccountLevel(Card card) {
        boolean z16 = false;
        if (card == null) {
            return false;
        }
        boolean z17 = !this.mApp.getCurrentAccountUin().equals(card.uin);
        boolean isNowThemeIsNight = ThemeUtil.isNowThemeIsNight(this.mApp, false, null);
        if (needShow()) {
            if (this.mViewContainer == 0) {
                this.mViewContainer = this.mActivity.getLayoutInflater().inflate(R.layout.cyt, (ViewGroup) null);
                bindClickEvent(z17);
                z16 = true;
            }
            updateVip(card, z17);
            updateQID(card, z17, isNowThemeIsNight);
            updateQQLevel(card, isNowThemeIsNight);
            updateQQValue(card, isNowThemeIsNight);
            updateVIPDiamond(card, z17);
        } else if (this.mViewContainer != 0) {
            this.mViewContainer = null;
            z16 = true;
        }
        adapterNightTheme(isNowThemeIsNight);
        return z16;
    }
}
