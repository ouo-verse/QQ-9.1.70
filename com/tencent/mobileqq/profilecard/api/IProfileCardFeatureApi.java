package com.tencent.mobileqq.profilecard.api;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.listener.CheckBlacklistListener;
import com.tencent.mobileqq.profilecard.preload.IProfileViewLoader;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.relation.common.widget.a;

@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IProfileCardFeatureApi extends QRouteApi {
    public static final int ADD_BLACKLIST_VIEW_TAG = 1;
    public static final int TRANSFER_VIEW_TAG = 2;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes16.dex */
    public static final class ProfileCardEmptyStatus {
        private static final /* synthetic */ ProfileCardEmptyStatus[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final ProfileCardEmptyStatus BOTH_EMPTY;
        public static final ProfileCardEmptyStatus LABEL_EMPTY;
        public static final ProfileCardEmptyStatus NOT_EMPTY;
        public static final ProfileCardEmptyStatus PHOTO_EMPTY;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25857);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            ProfileCardEmptyStatus profileCardEmptyStatus = new ProfileCardEmptyStatus("NOT_EMPTY", 0);
            NOT_EMPTY = profileCardEmptyStatus;
            ProfileCardEmptyStatus profileCardEmptyStatus2 = new ProfileCardEmptyStatus("BOTH_EMPTY", 1);
            BOTH_EMPTY = profileCardEmptyStatus2;
            ProfileCardEmptyStatus profileCardEmptyStatus3 = new ProfileCardEmptyStatus("PHOTO_EMPTY", 2);
            PHOTO_EMPTY = profileCardEmptyStatus3;
            ProfileCardEmptyStatus profileCardEmptyStatus4 = new ProfileCardEmptyStatus("LABEL_EMPTY", 3);
            LABEL_EMPTY = profileCardEmptyStatus4;
            $VALUES = new ProfileCardEmptyStatus[]{profileCardEmptyStatus, profileCardEmptyStatus2, profileCardEmptyStatus3, profileCardEmptyStatus4};
        }

        ProfileCardEmptyStatus(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static ProfileCardEmptyStatus valueOf(String str) {
            return (ProfileCardEmptyStatus) Enum.valueOf(ProfileCardEmptyStatus.class, str);
        }

        public static ProfileCardEmptyStatus[] values() {
            return (ProfileCardEmptyStatus[]) $VALUES.clone();
        }
    }

    boolean enableNewProfileCard(AppInterface appInterface);

    QQCustomDialog getAddBlacklistDialog(Activity activity, boolean z16, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnClickListener onClickListener3);

    a getBlacklistRelationActionSheet(Activity activity, boolean z16);

    String getEditProfileTipsText(ProfileCardInfo profileCardInfo);

    Class getElegantProfileTitleContainerClazz();

    boolean getIsPersonalityLabelEmpty(ProfileCardInfo profileCardInfo);

    boolean getIsPhotoWallEmpty(ProfileCardInfo profileCardInfo);

    int getPhotoWallPicNum(ProfileCardInfo profileCardInfo);

    ProfileCardEmptyStatus getProfieEmptyStatus(ProfileCardInfo profileCardInfo);

    IProfileViewLoader getViewLoader();

    boolean isBlackOrBlackedUin(String str, CheckBlacklistListener checkBlacklistListener);

    boolean isBlacklistUin(String str, CheckBlacklistListener checkBlacklistListener);

    boolean isContactProfileElegantVersion();

    boolean isElegantVersion();

    boolean isInStepBubbleTipsEnable();

    boolean isInStepComponentEnable();

    boolean isVasCustomBg(ProfileCardInfo profileCardInfo, AppInterface appInterface);

    void openProfileCardMore(Activity activity, Intent intent, int i3);

    void setProfileComponentCommonBg(View view);

    void updateUserIsBlackedFlag(String str, boolean z16);

    void updateUserIsBlacklistUinFlag(String str, boolean z16);
}
