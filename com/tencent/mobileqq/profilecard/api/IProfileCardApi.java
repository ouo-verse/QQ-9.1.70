package com.tencent.mobileqq.profilecard.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.nearbypro.profile.avatar.MyNearbyProBizScene;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.preload.IProfileViewLoader;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;

@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IProfileCardApi extends QRouteApi {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes16.dex */
    public static final class ZPlanJumpMode {
        private static final /* synthetic */ ZPlanJumpMode[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final ZPlanJumpMode PORTAL;
        public static final ZPlanJumpMode SMALL_HOME;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32916);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            ZPlanJumpMode zPlanJumpMode = new ZPlanJumpMode("PORTAL", 0);
            PORTAL = zPlanJumpMode;
            ZPlanJumpMode zPlanJumpMode2 = new ZPlanJumpMode("SMALL_HOME", 1);
            SMALL_HOME = zPlanJumpMode2;
            $VALUES = new ZPlanJumpMode[]{zPlanJumpMode, zPlanJumpMode2};
        }

        ZPlanJumpMode(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static ZPlanJumpMode valueOf(String str) {
            return (ZPlanJumpMode) Enum.valueOf(ZPlanJumpMode.class, str);
        }

        public static ZPlanJumpMode[] values() {
            return (ZPlanJumpMode[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes16.dex */
    public static final class ZPlanJumpSource {
        private static final /* synthetic */ ZPlanJumpSource[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final ZPlanJumpSource CLICK;
        public static final ZPlanJumpSource PULL;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32917);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            ZPlanJumpSource zPlanJumpSource = new ZPlanJumpSource("PULL", 0);
            PULL = zPlanJumpSource;
            ZPlanJumpSource zPlanJumpSource2 = new ZPlanJumpSource(MyNearbyProBizScene.CLICK, 1);
            CLICK = zPlanJumpSource2;
            $VALUES = new ZPlanJumpSource[]{zPlanJumpSource, zPlanJumpSource2};
        }

        ZPlanJumpSource(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static ZPlanJumpSource valueOf(String str) {
            return (ZPlanJumpSource) Enum.valueOf(ZPlanJumpSource.class, str);
        }

        public static ZPlanJumpSource[] values() {
            return (ZPlanJumpSource[]) $VALUES.clone();
        }
    }

    /* loaded from: classes16.dex */
    public static class ZplanMaintenanceInfo {
        static IPatchRedirector $redirector_;
        public String maintenanceMessage;
        public String maintenanceTitle;

        public ZplanMaintenanceInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    boolean checkProfessionShow(int i3);

    void checkToCleanSettingMeRedPointGuide(AppInterface appInterface);

    short getAgeWithPrivacy(ProfileCardInfo profileCardInfo);

    long getBirthdayWithPrivacy(ProfileCardInfo profileCardInfo);

    String getCompanyWithPrivacy(ProfileCardInfo profileCardInfo);

    String getConstellationWithPrivacy(ProfileCardInfo profileCardInfo);

    String getEmailWithPrivacy(ProfileCardInfo profileCardInfo);

    short getGenderWithPrivacy(ProfileCardInfo profileCardInfo);

    String getHometownCityWithPrivacy(ProfileCardInfo profileCardInfo);

    String getHometownProvinceWithPrivacy(ProfileCardInfo profileCardInfo);

    String getHometownWithPrivacy(ProfileCardInfo profileCardInfo);

    boolean getIsShowCreateLabelTipsBubble();

    boolean getIsShowQCircleSettingBubble();

    boolean getIsShowZplanSettingRedDotOrBubble(String str, String str2);

    String getLocationCityWithPrivacy(ProfileCardInfo profileCardInfo);

    String getLocationCountryWithPrivacy(ProfileCardInfo profileCardInfo);

    String getLocationProvinceWithPrivacy(ProfileCardInfo profileCardInfo);

    ArrayList<Integer> getPreloadResIds();

    String getProfessionTagWithPrivacy(ProfileCardInfo profileCardInfo);

    String getProfessionWithPrivacy(ProfileCardInfo profileCardInfo);

    @Deprecated
    Class<?> getProfileCardActivityClass();

    Bundle getProfileCardBundle(Context context, AllInOne allInOne, Bundle bundle);

    Class<? extends Fragment> getProfileCardFragmentClass();

    @Deprecated
    Intent getProfileCardIntent(Context context, AllInOne allInOne);

    @Deprecated
    Intent getProfileCardIntentOnly(Context context, AllInOne allInOne);

    String getSchoolWithPrivacy(ProfileCardInfo profileCardInfo);

    String getStringTrim(String str);

    int getVersionCode();

    IProfileViewLoader getViewHolder();

    ZplanMaintenanceInfo getZplanMaintenanceInfo();

    void initNameArray(AppInterface appInterface, ProfileCardInfo profileCardInfo);

    void inviteAskAnonymously(Activity activity, boolean z16);

    boolean isBizPopGuideShow();

    boolean isFieldVisible(int i3, ProfileCardInfo profileCardInfo);

    boolean isForbidByAnyType(ProfileCardInfo profileCardInfo);

    boolean isFriend(String str);

    boolean isInZplanProfileCardWhiteList(boolean z16);

    boolean isMyCard(ProfileCardInfo profileCardInfo);

    @Deprecated
    boolean isProfileCardActivity(Context context);

    boolean isProfileCardFragment(Object obj);

    boolean isProfileCardShowQCircleCover(ProfileCardInfo profileCardInfo);

    boolean isProfileCardShowZplanCover(ProfileCardInfo profileCardInfo);

    boolean isProfileNickUpgradeEnable();

    boolean isZplanServerUpdating();

    boolean isZplanUnderMaintenance();

    void jumpToZplanLoadingPage(Context context, ProfileCardInfo profileCardInfo, ZPlanJumpSource zPlanJumpSource);

    void openProfileCard(Context context, AllInOne allInOne);

    void openProfileCard(Context context, AllInOne allInOne, boolean z16);

    void openProfileCardForResult(Activity activity, AllInOne allInOne, int i3);

    void photoWallDelQzonePhotoWall(AppInterface appInterface, String str, String str2, long j3);

    void photoWallJump(Activity activity, String str, boolean z16);

    void reportDtZplanEntranceClick(ProfileCardInfo profileCardInfo, ZPlanJumpSource zPlanJumpSource, ZPlanJumpMode zPlanJumpMode, String str, int i3);

    void setBizPopGuideShow(boolean z16);

    void shareInviteToQZone(Activity activity);

    boolean showProfileRedPointGuide(AppInterface appInterface);

    boolean showProfileZplanUserGuide();

    boolean showSettingMeRedPointGuide(AppInterface appInterface);

    void updateProfileZplanUserGuideStatus();

    void updateShowCreateLabelTipsBubbleSp();

    void updateShowQCircleSettingBubbleSp();
}
