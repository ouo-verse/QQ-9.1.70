package com.tencent.mobileqq.profilecard.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.tencent.biz.eqq.api.ICrmApi;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.emoticonview.EmotionReportDtImpl;
import com.tencent.mobileqq.pad.LaunchMode;
import com.tencent.mobileqq.pad.SplitViewState;
import com.tencent.mobileqq.pad.i;
import com.tencent.mobileqq.pad.l;
import com.tencent.mobileqq.profilecard.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.api.IProfileCardBusinessApi;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.api.IProfileCardFeatureApi;
import com.tencent.mobileqq.profilecard.bussiness.accountinfo.utils.ProfileAccountInfoUtils;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.utils.AnonymousRedPointUtils;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.utils.AskAnonymouslyUtil;
import com.tencent.mobileqq.profilecard.bussiness.photowall.handler.PhotoWallHandler;
import com.tencent.mobileqq.profilecard.bussiness.photowall.view.PhotoWallView;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.fragment.FriendProfileCardFragment;
import com.tencent.mobileqq.profilecard.preload.IProfileViewLoader;
import com.tencent.mobileqq.profilecard.report.ProfileCardTracer;
import com.tencent.mobileqq.profilecard.utils.ProfileCardConst;
import com.tencent.mobileqq.profilecard.utils.ProfileCardForbidAccountHelper;
import com.tencent.mobileqq.profilecard.utils.ProfileCardUtil;
import com.tencent.mobileqq.profilecard.utils.ProfileNickUpgradeSwitch;
import com.tencent.mobileqq.profilecard.version.ProfileCardVersionController;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.api.IZootopiaApi;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.model.MaintEntryType;
import com.tencent.mobileqq.zplan.model.ZPlanMaintInfo;
import com.tencent.mobileqq.zplan.utils.api.IZPlanAccessibleHelper;
import com.tencent.qidian.api.IQidianApi;
import com.tencent.qidian.api.IQidianManagerApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqnt.ntrelation.api.IFriendsTABService;
import com.tencent.state.report.SquareReportConst;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes16.dex */
public class ProfileCardApiImpl implements IProfileCardApi {
    static IPatchRedirector $redirector_ = null;
    private static final String IS_FRIEND_PROFILE_CARD = "key_is_friend_profile_card";
    private static final String QMMKV_KEY_CREATE_LABEL_VIDEO_TIPS = "show_profilecard_create_label_video_tips";
    private static final String QMMKV_KEY_QCIRCLE_COVER_TIPS = "show_profilecard_qcircle_cover_tips";
    private static final String TAG = "ProfileCardApiImpl";
    private boolean isBizPopGuideShow;
    private boolean isLogOpenSwitch;

    /* renamed from: com.tencent.mobileqq.profilecard.api.impl.ProfileCardApiImpl$2, reason: invalid class name */
    /* loaded from: classes16.dex */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$mobileqq$profilecard$api$IProfileCardApi$ZPlanJumpMode;
        static IPatchRedirector $redirector_;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20492);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[IProfileCardApi.ZPlanJumpMode.values().length];
            $SwitchMap$com$tencent$mobileqq$profilecard$api$IProfileCardApi$ZPlanJumpMode = iArr;
            try {
                iArr[IProfileCardApi.ZPlanJumpMode.PORTAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tencent$mobileqq$profilecard$api$IProfileCardApi$ZPlanJumpMode[IProfileCardApi.ZPlanJumpMode.SMALL_HOME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public ProfileCardApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.isLogOpenSwitch = ((IFriendsTABService) QRoute.api(IFriendsTABService.class)).getIsLogOpen();
            this.isBizPopGuideShow = false;
        }
    }

    private boolean isFromQCircleNotFlatState(AllInOne allInOne) {
        Bundle bundle;
        if (allInOne == null || (bundle = allInOne.extras) == null || bundle.getInt(ProfileCardConst.ENTER_PAGE_SOURCE_ID) != 4 || com.tencent.mobileqq.pad.e.a() == SplitViewState.STATE_FLAT) {
            return false;
        }
        return true;
    }

    private boolean isQidianMaster(AllInOne allInOne) {
        if (!isQidianSplitFixSwitchOn() || allInOne == null) {
            return false;
        }
        try {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                return false;
            }
            ICrmApi iCrmApi = (ICrmApi) peekAppRuntime.getRuntimeService(ICrmApi.class, "");
            IQidianManagerApi iQidianManagerApi = (IQidianManagerApi) peekAppRuntime.getRuntimeService(IQidianManagerApi.class, "");
            if (!iCrmApi.isCrmMainUinAndGetSimpleInfoIfNeed(allInOne.uin) && !iQidianManagerApi.isQidianMaster(allInOne.uin)) {
                if (!iQidianManagerApi.isCrmMasterUin(allInOne.uin)) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "isQidianMaster exception ", th5);
            return false;
        }
    }

    private boolean isQidianMasterIntent(Intent intent) {
        if (!isQidianSplitFixSwitchOn() || intent == null || !intent.getBooleanExtra("gotoCrmMainProfileIntent", false)) {
            return false;
        }
        return true;
    }

    private boolean isQidianSplitFixSwitchOn() {
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qidian_profile_split_fix_switch", false);
        QLog.d(TAG, 2, "isQidianSplitFixSwitchOn: " + isSwitchOn);
        return isSwitchOn;
    }

    private boolean needOpenStandInPad(AllInOne allInOne) {
        Bundle bundle;
        if (allInOne == null || (bundle = allInOne.extras) == null) {
            return false;
        }
        return bundle.getBoolean(ProfileCardConst.ENTER_PAGE_OPEN_STAND_IN_PAD, false);
    }

    private void openProfileCardInPad(Context context, AllInOne allInOne) {
        i.e(context, getProfileCardBundle(context, allInOne, null), FriendProfileCardFragment.class, new com.tencent.mobileqq.pad.b().e(false).g(false).h(LaunchMode.singleTop).a());
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardApi
    public boolean checkProfessionShow(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            return ((Boolean) iPatchRedirector.redirect((short) 55, (Object) this, i3)).booleanValue();
        }
        com.tencent.relation.common.config.toggle.c cVar = com.tencent.relation.common.config.toggle.c.C;
        if (!cVar.g(false) || cVar.a(0) == 2) {
            return false;
        }
        if (cVar.a(0) == 1 && i3 <= 0) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardApi
    public void checkToCleanSettingMeRedPointGuide(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) appInterface);
        } else {
            AnonymousRedPointUtils.checkToCleanSettingMeRedPointGuide(appInterface);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardApi
    public short getAgeWithPrivacy(ProfileCardInfo profileCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Short) iPatchRedirector.redirect((short) 20, (Object) this, (Object) profileCardInfo)).shortValue();
        }
        return ProfileAccountInfoUtils.getAgeWithPrivacy(profileCardInfo);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardApi
    public long getBirthdayWithPrivacy(ProfileCardInfo profileCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Long) iPatchRedirector.redirect((short) 22, (Object) this, (Object) profileCardInfo)).longValue();
        }
        return ProfileAccountInfoUtils.getBirthdayWithPrivacy(profileCardInfo);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardApi
    public String getCompanyWithPrivacy(ProfileCardInfo profileCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (String) iPatchRedirector.redirect((short) 30, (Object) this, (Object) profileCardInfo);
        }
        return ProfileAccountInfoUtils.getCompanyWithPrivacy(profileCardInfo);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardApi
    public String getConstellationWithPrivacy(ProfileCardInfo profileCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, (Object) this, (Object) profileCardInfo);
        }
        return ProfileAccountInfoUtils.getConstellationWithPrivacy(profileCardInfo);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardApi
    public String getEmailWithPrivacy(ProfileCardInfo profileCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return (String) iPatchRedirector.redirect((short) 33, (Object) this, (Object) profileCardInfo);
        }
        return ProfileAccountInfoUtils.getEmailWithPrivacy(profileCardInfo);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardApi
    public short getGenderWithPrivacy(ProfileCardInfo profileCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Short) iPatchRedirector.redirect((short) 19, (Object) this, (Object) profileCardInfo)).shortValue();
        }
        return ProfileAccountInfoUtils.getGenderWithPrivacy(profileCardInfo);
    }

    public boolean getHasClickedZplanRedDot(String str, String str2, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            return ((Boolean) iPatchRedirector.redirect((short) 53, this, str, str2, Long.valueOf(j3))).booleanValue();
        }
        String str3 = str + j3;
        QMMKV.migrateToSpAdapter(BaseApplication.getContext(), str3, "common_mmkv_configurations");
        return QMMKV.fromSpAdapter(BaseApplication.getContext(), str3, "common_mmkv_configurations").getBoolean(str2, false);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardApi
    public String getHometownCityWithPrivacy(ProfileCardInfo profileCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (String) iPatchRedirector.redirect((short) 29, (Object) this, (Object) profileCardInfo);
        }
        return ProfileAccountInfoUtils.getHometownCityWithPrivacy(profileCardInfo);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardApi
    public String getHometownProvinceWithPrivacy(ProfileCardInfo profileCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (String) iPatchRedirector.redirect((short) 28, (Object) this, (Object) profileCardInfo);
        }
        return ProfileAccountInfoUtils.getHometownProvinceWithPrivacy(profileCardInfo);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardApi
    public String getHometownWithPrivacy(ProfileCardInfo profileCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (String) iPatchRedirector.redirect((short) 27, (Object) this, (Object) profileCardInfo);
        }
        return ProfileAccountInfoUtils.getHometownWithPrivacy(profileCardInfo);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardApi
    public boolean getIsShowCreateLabelTipsBubble() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            return ((Boolean) iPatchRedirector.redirect((short) 52, (Object) this)).booleanValue();
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return false;
        }
        return QMMKV.from(peekAppRuntime.getApplicationContext(), QMMKVFile.FILE_QCIRCLE).decodeBool(QMMKV_KEY_CREATE_LABEL_VIDEO_TIPS, true);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardApi
    public boolean getIsShowQCircleSettingBubble() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            return ((Boolean) iPatchRedirector.redirect((short) 48, (Object) this)).booleanValue();
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || !uq3.c.c7()) {
            return false;
        }
        return QMMKV.from(peekAppRuntime.getApplicationContext(), QMMKVFile.FILE_QCIRCLE).decodeBool(QMMKV_KEY_QCIRCLE_COVER_TIPS, true);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardApi
    public boolean getIsShowZplanSettingRedDotOrBubble(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            return ((Boolean) iPatchRedirector.redirect((short) 47, (Object) this, (Object) str, (Object) str2)).booleanValue();
        }
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime == null) {
            return false;
        }
        long longAccountUin = waitAppRuntime.getLongAccountUin();
        boolean isZplanAccessibleWithoutSetting = ((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).isZplanAccessibleWithoutSetting(1004L, longAccountUin);
        if (((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).isZPlanAccessible(1004L, longAccountUin) || !isZplanAccessibleWithoutSetting || getHasClickedZplanRedDot(str, str2, longAccountUin)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardApi
    public String getLocationCityWithPrivacy(ProfileCardInfo profileCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (String) iPatchRedirector.redirect((short) 26, (Object) this, (Object) profileCardInfo);
        }
        return ProfileAccountInfoUtils.getLocationCityWithPrivacy(profileCardInfo);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardApi
    public String getLocationCountryWithPrivacy(ProfileCardInfo profileCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (String) iPatchRedirector.redirect((short) 24, (Object) this, (Object) profileCardInfo);
        }
        return ProfileAccountInfoUtils.getLocationCountryWithPrivacy(profileCardInfo);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardApi
    public String getLocationProvinceWithPrivacy(ProfileCardInfo profileCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (String) iPatchRedirector.redirect((short) 25, (Object) this, (Object) profileCardInfo);
        }
        return ProfileAccountInfoUtils.getLocationProvinceWithPrivacy(profileCardInfo);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardApi
    public ArrayList<Integer> getPreloadResIds() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            return (ArrayList) iPatchRedirector.redirect((short) 58, (Object) this);
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(R.layout.h0c));
        arrayList.add(Integer.valueOf(R.layout.b0i));
        return arrayList;
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardApi
    public String getProfessionTagWithPrivacy(ProfileCardInfo profileCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (String) iPatchRedirector.redirect((short) 32, (Object) this, (Object) profileCardInfo);
        }
        return ProfileAccountInfoUtils.getProfessionTagWithPrivacy(profileCardInfo);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardApi
    public String getProfessionWithPrivacy(ProfileCardInfo profileCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (String) iPatchRedirector.redirect((short) 31, (Object) this, (Object) profileCardInfo);
        }
        return ProfileAccountInfoUtils.getProfessionWithPrivacy(profileCardInfo);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardApi
    public Class<?> getProfileCardActivityClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Class) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return FriendProfileCardActivity.class;
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardApi
    public Bundle getProfileCardBundle(Context context, AllInOne allInOne, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Bundle) iPatchRedirector.redirect((short) 5, this, context, allInOne, bundle);
        }
        if (context != null && allInOne != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putParcelable(IProfileCardConst.KEY_ALL_IN_ONE, allInOne);
            Serializable serializable = allInOne.extras.getSerializable(IProfileCardConst.KEY_WZRY_DATA);
            if (serializable != null) {
                bundle.putSerializable(IProfileCardConst.KEY_WZRY_DATA, serializable);
            }
            Bundle bundle2 = allInOne.extras.getBundle("flc_extra_param");
            if (bundle2 != null) {
                bundle.putBundle("flc_extra_param", bundle2);
            }
        }
        return bundle;
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardApi
    public Class<? extends Fragment> getProfileCardFragmentClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Class) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return FriendProfileCardFragment.class;
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardApi
    public Intent getProfileCardIntent(Context context, AllInOne allInOne) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Intent) iPatchRedirector.redirect((short) 6, (Object) this, (Object) context, (Object) allInOne);
        }
        if (context != null && allInOne != null) {
            Intent profileCardIntent = ((IQidianApi) QRoute.api(IQidianApi.class)).getProfileCardIntent(context, allInOne);
            if (profileCardIntent == null) {
                profileCardIntent = ((IProfileCardBusinessApi) QRoute.api(IProfileCardBusinessApi.class)).getBabyQProfileCardIntent(context, allInOne);
            }
            if (profileCardIntent == null) {
                ProfileCardTracer.tagNode("ITEM_CLICK");
                Intent intent = new Intent(context, getProfileCardActivityClass());
                intent.putExtra(IS_FRIEND_PROFILE_CARD, true);
                intent.putExtra(IProfileCardConst.KEY_ALL_IN_ONE, allInOne);
                Serializable serializable = allInOne.extras.getSerializable(IProfileCardConst.KEY_WZRY_DATA);
                if (serializable != null) {
                    intent.putExtra(IProfileCardConst.KEY_WZRY_DATA, serializable);
                }
                Bundle bundle = allInOne.extras.getBundle("flc_extra_param");
                if (bundle != null) {
                    intent.putExtra("flc_extra_param", bundle);
                }
                if (!TextUtils.isEmpty(allInOne.troopCode)) {
                    intent.putExtra("troopUin", allInOne.troopCode);
                }
                return intent;
            }
            return profileCardIntent;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardApi
    public Intent getProfileCardIntentOnly(Context context, AllInOne allInOne) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Intent) iPatchRedirector.redirect((short) 7, (Object) this, (Object) context, (Object) allInOne);
        }
        ProfileCardTracer.tagNode("ITEM_CLICK");
        Intent intent = new Intent(context, getProfileCardActivityClass());
        if (allInOne != null) {
            intent.putExtra(IProfileCardConst.KEY_ALL_IN_ONE, allInOne);
        }
        return intent;
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardApi
    public String getSchoolWithPrivacy(ProfileCardInfo profileCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (String) iPatchRedirector.redirect((short) 23, (Object) this, (Object) profileCardInfo);
        }
        return ProfileAccountInfoUtils.getSchoolWithPrivacy(profileCardInfo);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardApi
    public String getStringTrim(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return (String) iPatchRedirector.redirect((short) 35, (Object) this, (Object) str);
        }
        return ProfileAccountInfoUtils.getStringTrim(str);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardApi
    public int getVersionCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            return ((Integer) iPatchRedirector.redirect((short) 56, (Object) this)).intValue();
        }
        return ProfileCardVersionController.getVersionCode();
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardApi
    public IProfileViewLoader getViewHolder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            return (IProfileViewLoader) iPatchRedirector.redirect((short) 57, (Object) this);
        }
        return ((IProfileCardFeatureApi) QRoute.api(IProfileCardFeatureApi.class)).getViewLoader();
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardApi
    public IProfileCardApi.ZplanMaintenanceInfo getZplanMaintenanceInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return (IProfileCardApi.ZplanMaintenanceInfo) iPatchRedirector.redirect((short) 40, (Object) this);
        }
        IProfileCardApi.ZplanMaintenanceInfo zplanMaintenanceInfo = new IProfileCardApi.ZplanMaintenanceInfo();
        ZPlanMaintInfo maintenanceInfo = ((IZPlanApi) QRoute.api(IZPlanApi.class)).getMaintenanceInfo(MaintEntryType.ALL);
        zplanMaintenanceInfo.maintenanceTitle = maintenanceInfo.f();
        zplanMaintenanceInfo.maintenanceMessage = maintenanceInfo.g();
        return zplanMaintenanceInfo;
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardApi
    public void initNameArray(AppInterface appInterface, ProfileCardInfo profileCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            iPatchRedirector.redirect((short) 61, (Object) this, (Object) appInterface, (Object) profileCardInfo);
        } else {
            ProfileCardUtil.initNameArray(appInterface, profileCardInfo);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardApi
    public void inviteAskAnonymously(Activity activity, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, activity, Boolean.valueOf(z16));
        } else {
            AskAnonymouslyUtil.INSTANCE.inviteAskAnonymously(activity, z16);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardApi
    public boolean isBizPopGuideShow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            return ((Boolean) iPatchRedirector.redirect((short) 62, (Object) this)).booleanValue();
        }
        return this.isBizPopGuideShow;
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardApi
    public boolean isFieldVisible(int i3, ProfileCardInfo profileCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Boolean) iPatchRedirector.redirect((short) 34, (Object) this, i3, (Object) profileCardInfo)).booleanValue();
        }
        return ProfileAccountInfoUtils.isFieldVisible(i3, profileCardInfo);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardApi
    public boolean isForbidByAnyType(ProfileCardInfo profileCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            return ((Boolean) iPatchRedirector.redirect((short) 59, (Object) this, (Object) profileCardInfo)).booleanValue();
        }
        return ProfileCardForbidAccountHelper.isForbidByAnyType(profileCardInfo);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardApi
    public boolean isFriend(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            return ((Boolean) iPatchRedirector.redirect((short) 60, (Object) this, (Object) str)).booleanValue();
        }
        return ProfileCardUtil.isFriend(str);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardApi
    public boolean isInZplanProfileCardWhiteList(boolean z16) {
        boolean z17;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return ((Boolean) iPatchRedirector.redirect((short) 38, (Object) this, z16)).booleanValue();
        }
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (z16) {
            z17 = ((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).isZPlanAccessible(1004L, waitAppRuntime.getLongAccountUin());
        } else {
            z17 = true;
        }
        IZPlanAccessibleHelper iZPlanAccessibleHelper = (IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class);
        if (z16) {
            i3 = 2;
        } else {
            i3 = 3;
        }
        boolean enableZPlanNativeAppFilament = iZPlanAccessibleHelper.enableZPlanNativeAppFilament(i3);
        if (z17 && enableZPlanNativeAppFilament) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardApi
    public boolean isMyCard(ProfileCardInfo profileCardInfo) {
        AllInOne allInOne;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return ((Boolean) iPatchRedirector.redirect((short) 42, (Object) this, (Object) profileCardInfo)).booleanValue();
        }
        if (profileCardInfo != null && (allInOne = profileCardInfo.allInOne) != null && allInOne.f260789pa != 0) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardApi
    public boolean isProfileCardActivity(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) context)).booleanValue();
        }
        return context instanceof FriendProfileCardActivity;
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardApi
    public boolean isProfileCardFragment(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, obj)).booleanValue();
        }
        return obj instanceof FriendProfileCardFragment;
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardApi
    public boolean isProfileCardShowQCircleCover(ProfileCardInfo profileCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return ((Boolean) iPatchRedirector.redirect((short) 36, (Object) this, (Object) profileCardInfo)).booleanValue();
        }
        if (profileCardInfo == null) {
            QLog.e(TAG, 1, "[isProfileCardShowQCircleCover] cardInfo == null");
            return false;
        }
        if (ProfileCardForbidAccountHelper.isForbidByAnyType(profileCardInfo)) {
            return false;
        }
        Card card = profileCardInfo.card;
        if (card != null && card.isShowQCircleCover) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardApi
    public boolean isProfileCardShowZplanCover(ProfileCardInfo profileCardInfo) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Boolean) iPatchRedirector.redirect((short) 37, (Object) this, (Object) profileCardInfo)).booleanValue();
        }
        if (((IZootopiaApi) QRoute.api(IZootopiaApi.class)).ignoreProfileCardCheckForDev()) {
            return true;
        }
        if (profileCardInfo == null || ProfileCardForbidAccountHelper.isForbidByAnyType(profileCardInfo)) {
            return false;
        }
        boolean isMyCard = isMyCard(profileCardInfo);
        boolean isInZplanProfileCardWhiteList = isInZplanProfileCardWhiteList(isMyCard);
        if (isMyCard) {
            return isInZplanProfileCardWhiteList;
        }
        Card card = profileCardInfo.card;
        if (card != null && card.isZplanMasterShow && card.isZplanProfileCardShow) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (isInZplanProfileCardWhiteList && z16) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardApi
    public boolean isProfileNickUpgradeEnable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            return ((Boolean) iPatchRedirector.redirect((short) 51, (Object) this)).booleanValue();
        }
        return ProfileNickUpgradeSwitch.getInstance().isEnable();
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardApi
    public boolean isZplanServerUpdating() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return ((Boolean) iPatchRedirector.redirect((short) 41, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardApi
    public boolean isZplanUnderMaintenance() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Boolean) iPatchRedirector.redirect((short) 39, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardApi
    public void jumpToZplanLoadingPage(Context context, ProfileCardInfo profileCardInfo, IProfileCardApi.ZPlanJumpSource zPlanJumpSource) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, this, context, profileCardInfo, zPlanJumpSource);
            return;
        }
        if (isZplanUnderMaintenance()) {
            showProfileZplanServerUnavailableDialog(context);
        } else {
            if (isMyCard(profileCardInfo)) {
                ((IZootopiaApi) QRoute.api(IZootopiaApi.class)).startPortalActivity(context, ZootopiaSource.create(Source.ProfileEntry, ZootopiaSource.SUB_SOURCE_PROFILE_OWNER), null);
            } else if (profileCardInfo != null && profileCardInfo.card != null) {
                Bundle bundle = new Bundle();
                bundle.putString("uin", profileCardInfo.card.uin);
                bundle.putString("nick", profileCardInfo.card.strNick);
                if (profileCardInfo.card.shGender == 0) {
                    i3 = 1;
                } else {
                    i3 = 2;
                }
                bundle.putInt("sex", i3);
                ((IZootopiaApi) QRoute.api(IZootopiaApi.class)).startProfileCustomerActivity(context, ZootopiaSource.create(Source.ProfileEntry, ZootopiaSource.SUB_SOURCE_PROFILE_VISITOR), bundle);
            }
            updateProfileZplanUserGuideStatus();
        }
        updateProfileZplanUserGuideStatus();
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardApi
    public void openProfileCard(Context context, AllInOne allInOne) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            openProfileCard(context, allInOne, true);
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) allInOne);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardApi
    public void openProfileCardForResult(Activity activity, AllInOne allInOne, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, activity, allInOne, Integer.valueOf(i3));
            return;
        }
        if (activity != null && allInOne != null) {
            try {
                if (((IProfileCardBusinessApi) QRoute.api(IProfileCardBusinessApi.class)).openRobotProfileCard(activity, allInOne)) {
                    return;
                }
                if (AppSetting.t(activity) && !isFromQCircleNotFlatState(allInOne) && i3 != 1023 && !isQidianMaster(allInOne)) {
                    ProfileCardTracer.tagNode("ITEM_CLICK");
                    openProfileCardInPad(activity, allInOne);
                } else {
                    Intent profileCardIntent = getProfileCardIntent(activity, allInOne);
                    profileCardIntent.addFlags(536870912);
                    activity.startActivityForResult(profileCardIntent, i3);
                }
            } catch (Exception e16) {
                QLog.e(TAG, 1, "openProfileCardForResult fail.", e16);
            }
        }
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardApi
    public void photoWallDelQzonePhotoWall(AppInterface appInterface, String str, String str2, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, appInterface, str, str2, Long.valueOf(j3));
            return;
        }
        PhotoWallHandler photoWallHandler = (PhotoWallHandler) appInterface.getBusinessHandler(PhotoWallHandler.class.getName());
        if (photoWallHandler != null) {
            photoWallHandler.delQzonePhotoWall(str, str2, j3);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardApi
    public void photoWallJump(Activity activity, String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, activity, str, Boolean.valueOf(z16));
        } else {
            PhotoWallView.jumpToPhotoWall(activity, str, z16);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardApi
    public void reportDtZplanEntranceClick(ProfileCardInfo profileCardInfo, IProfileCardApi.ZPlanJumpSource zPlanJumpSource, IProfileCardApi.ZPlanJumpMode zPlanJumpMode, String str, int i3) {
        String str2;
        String str3;
        Card card;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, this, profileCardInfo, zPlanJumpSource, zPlanJumpMode, str, Integer.valueOf(i3));
            return;
        }
        boolean isMyCard = isMyCard(profileCardInfo);
        HashMap hashMap = new HashMap();
        int i16 = AnonymousClass2.$SwitchMap$com$tencent$mobileqq$profilecard$api$IProfileCardApi$ZPlanJumpMode[zPlanJumpMode.ordinal()];
        if (i16 != 1) {
            if (i16 != 2) {
                QLog.w(TAG, 1, "[reportDtZplanEntranceClick] jumpMode invalid");
                str2 = "";
            } else if (isMyCard) {
                str2 = "em_zplan_xiaowo_entrance_zhutai_actionsheet";
            } else {
                str2 = "em_zplan_xiaowo_entrance_ketai_actionsheet";
            }
        } else {
            if (i3 == 3) {
                if (isMyCard) {
                    str2 = "em_zplan_portal_entrance_zhutai_actionsheet";
                } else {
                    str2 = "em_zplan_portal_entrance_ketai_actionsheet";
                }
            } else if (isMyCard) {
                str2 = ZootopiaSource.SUB_SOURCE_PROFILE_OWNER;
            } else {
                str2 = ZootopiaSource.SUB_SOURCE_PROFILE_VISITOR;
            }
            hashMap.put("zplan_ziliaodongtai_portal_entrance_split", Integer.valueOf(i3));
        }
        if (zPlanJumpSource == IProfileCardApi.ZPlanJumpSource.CLICK) {
            hashMap.put("zplan_qqusercard_xiaowo_backgroundstyle", str);
        }
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        hashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, str2);
        hashMap.put("zplan_action_type", "click");
        if (!isMyCard && (card = profileCardInfo.card) != null) {
            hashMap.put("zplan_other_user_qq", card.uin);
        }
        if (isZplanUnderMaintenance()) {
            str3 = "maintaining";
        } else {
            str3 = "serviceable";
        }
        hashMap.put("zplan_entrance_status", str3);
        hashMap.put(EmotionReportDtImpl.IS_RED_TIPS_BEFORE, 0);
        VideoReport.reportEvent("ev_zplan_external_entrance_action", hashMap);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardApi
    public void setBizPopGuideShow(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            iPatchRedirector.redirect((short) 63, (Object) this, z16);
        } else {
            this.isBizPopGuideShow = z16;
        }
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardApi
    public void shareInviteToQZone(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) activity);
        } else {
            AskAnonymouslyUtil.INSTANCE.shareInviteToQZone(activity);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardApi
    public boolean showProfileRedPointGuide(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, (Object) appInterface)).booleanValue();
        }
        return AnonymousRedPointUtils.showProfileRedPointGuide(appInterface);
    }

    public void showProfileZplanServerUnavailableDialog(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, (Object) this, (Object) context);
            return;
        }
        if (!(context instanceof Activity)) {
            return;
        }
        Activity activity = (Activity) context;
        IProfileCardApi.ZplanMaintenanceInfo zplanMaintenanceInfo = getZplanMaintenanceInfo();
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(activity, 230);
        String str = zplanMaintenanceInfo.maintenanceTitle;
        createCustomDialog.setTitle(str).setMessage(zplanMaintenanceInfo.maintenanceMessage).setPositiveButton("\u6211\u77e5\u9053\u4e86", new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.api.impl.ProfileCardApiImpl.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ProfileCardApiImpl.this);
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                } else {
                    dialogInterface.dismiss();
                }
            }
        });
        try {
            if (!activity.isFinishing()) {
                createCustomDialog.show();
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "[showProfileZplanServerUnavailableDialog] show dialog error", e16);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardApi
    public boolean showProfileZplanUserGuide() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return ((Boolean) iPatchRedirector.redirect((short) 44, (Object) this)).booleanValue();
        }
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        String currentAccountUin = waitAppRuntime.getCurrentAccountUin();
        if (PreferenceManager.getDefaultSharedPreferences(waitAppRuntime.getApp()).getInt(IProfileCardConst.KEY_PROFILE_ZPLAN_GUIDE + currentAccountUin, 0) != 0) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardApi
    public boolean showSettingMeRedPointGuide(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, (Object) appInterface)).booleanValue();
        }
        return AnonymousRedPointUtils.showSettingMeRedPointGuide(appInterface);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardApi
    public void updateProfileZplanUserGuideStatus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this);
            return;
        }
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        String currentAccountUin = waitAppRuntime.getCurrentAccountUin();
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(waitAppRuntime.getApp()).edit();
        edit.putInt(IProfileCardConst.KEY_PROFILE_ZPLAN_GUIDE + currentAccountUin, 1);
        edit.commit();
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardApi
    public void updateShowCreateLabelTipsBubbleSp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, (Object) this);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        QMMKV.from(peekAppRuntime.getApplicationContext(), QMMKVFile.FILE_QCIRCLE).encodeBool(QMMKV_KEY_CREATE_LABEL_VIDEO_TIPS, false);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardApi
    public void updateShowQCircleSettingBubbleSp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, (Object) this);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        QMMKV.from(peekAppRuntime.getApplicationContext(), QMMKVFile.FILE_QCIRCLE).encodeBool(QMMKV_KEY_QCIRCLE_COVER_TIPS, false);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardApi
    public void openProfileCard(Context context, AllInOne allInOne, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, allInOne, Boolean.valueOf(z16));
            return;
        }
        if (context != null && allInOne != null) {
            try {
                if (((IProfileCardBusinessApi) QRoute.api(IProfileCardBusinessApi.class)).openRobotProfileCard(context, allInOne)) {
                    return;
                }
                Intent profileCardIntent = getProfileCardIntent(context, allInOne);
                if (z16) {
                    profileCardIntent.addFlags(536870912);
                }
                if (!(context instanceof Activity)) {
                    profileCardIntent.addFlags(268435456);
                }
                if (AppSetting.t(context) && !isFromQCircleNotFlatState(allInOne) && !isQidianMasterIntent(profileCardIntent) && !needOpenStandInPad(allInOne) && (context instanceof l)) {
                    if (this.isLogOpenSwitch) {
                        QLog.i(TAG, 1, "openProfileCardInPad");
                    }
                    openProfileCardInPad(context, allInOne);
                    return;
                } else {
                    if (this.isLogOpenSwitch) {
                        QLog.i(TAG, 1, "context.startActivity");
                    }
                    context.startActivity(profileCardIntent);
                    return;
                }
            } catch (Exception e16) {
                QLog.e(TAG, 1, "openProfileCard fail.", e16);
                return;
            }
        }
        if (context == null && this.isLogOpenSwitch) {
            QLog.i(TAG, 1, "context == null");
        }
        if (allInOne == null && this.isLogOpenSwitch) {
            QLog.i(TAG, 1, "allInOne == null");
        }
    }
}
