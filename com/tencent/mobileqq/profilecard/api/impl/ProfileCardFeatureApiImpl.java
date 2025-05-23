package com.tencent.mobileqq.profilecard.api.impl;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelInfo;
import com.tencent.mobileqq.profile.PersonalityLabel.ProfilePersonalityLabelInfo;
import com.tencent.mobileqq.profile.ProfileCardManager;
import com.tencent.mobileqq.profilecard.api.IProfileCardFeatureApi;
import com.tencent.mobileqq.profilecard.api.IProfileDataService;
import com.tencent.mobileqq.profilecard.api.IRelationBlacklistApi;
import com.tencent.mobileqq.profilecard.container.titlecontainer.ElegantProfileTitleContainer;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.data.ProfileCardPhotoWallData;
import com.tencent.mobileqq.profilecard.listener.CheckBlacklistListener;
import com.tencent.mobileqq.profilecard.listener.RelationBlacklistListener;
import com.tencent.mobileqq.profilecard.more.ProfileCardMoreFragment;
import com.tencent.mobileqq.profilecard.multyple.ProfileCardVersion;
import com.tencent.mobileqq.profilecard.preload.IProfileViewLoader;
import com.tencent.mobileqq.profilecard.preload.ProfileViewLoader;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.profilecard.utils.ProfileCardFeatureSwitch;
import com.tencent.mobileqq.profilecard.version.ProfileCardVersionController;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.relation.common.utils.i;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmdBlacklist.RelationBlacklist$CheckRsp;

/* loaded from: classes35.dex */
public class ProfileCardFeatureApiImpl implements IProfileCardFeatureApi {
    private static final String KEY_HAS_GUIDE = "hasGuide";
    private static final String TAG = "ProfileCardFeatureApiImpl";
    private static final String VALUE_HAS_GUIDE = "1";

    private void asyncCheckBlackOrBlackedUin(final String str, final CheckBlacklistListener checkBlacklistListener) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.profilecard.api.impl.a
            @Override // java.lang.Runnable
            public final void run() {
                ProfileCardFeatureApiImpl.this.lambda$asyncCheckBlackOrBlackedUin$3(checkBlacklistListener, str);
            }
        }, 32, null, true);
    }

    private com.tencent.qqnt.ntrelation.friendsinfo.bean.d getFriendNTSimpleInfoByUin(String str) {
        return ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), TAG);
    }

    private boolean isSelfUinOrInvalidUin(String str) {
        AppRuntime peekAppRuntime;
        return TextUtils.isEmpty(str) || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null || str.equals(peekAppRuntime.getCurrentAccountUin());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$asyncCheckBlackOrBlackedUin$0(CheckBlacklistListener checkBlacklistListener, boolean z16) {
        checkBlacklistListener.onResult(z16);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 1, "ProfileCardBlacklistApiImpl isBlackOrBlackedUin async result is " + z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$asyncCheckBlackOrBlackedUin$1(Object obj, String str, final CheckBlacklistListener checkBlacklistListener) {
        RelationBlacklist$CheckRsp relationBlacklist$CheckRsp = (RelationBlacklist$CheckRsp) obj;
        i.c().m(str, relationBlacklist$CheckRsp.is_block.get());
        final boolean z16 = relationBlacklist$CheckRsp.is_block.get() || relationBlacklist$CheckRsp.is_blocked.get();
        i.c().n(str, z16);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.api.impl.c
            @Override // java.lang.Runnable
            public final void run() {
                ProfileCardFeatureApiImpl.lambda$asyncCheckBlackOrBlackedUin$0(CheckBlacklistListener.this, z16);
            }
        });
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardFeatureApi
    public boolean enableNewProfileCard(AppInterface appInterface) {
        return true;
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardFeatureApi
    public String getEditProfileTipsText(ProfileCardInfo profileCardInfo) {
        if (profileCardInfo == null) {
            return "";
        }
        IProfileCardFeatureApi.ProfileCardEmptyStatus profieEmptyStatus = getProfieEmptyStatus(profileCardInfo);
        if (profieEmptyStatus == IProfileCardFeatureApi.ProfileCardEmptyStatus.BOTH_EMPTY) {
            return ProfileCardFeatureSwitch.INSTANCE.getOwnerProfileCardEmptyItemFoldParam().get(ProfileCardFeatureSwitch.PROFLIE_BUBBLE_TIPS_PHOTO_LABEL_EMPTY);
        }
        if (profieEmptyStatus == IProfileCardFeatureApi.ProfileCardEmptyStatus.LABEL_EMPTY) {
            return ProfileCardFeatureSwitch.INSTANCE.getOwnerProfileCardEmptyItemFoldParam().get(ProfileCardFeatureSwitch.PROFILE_BUBBLE_TIPS_LABEL_EMPTY);
        }
        if (profieEmptyStatus != IProfileCardFeatureApi.ProfileCardEmptyStatus.PHOTO_EMPTY) {
            return "";
        }
        return ProfileCardFeatureSwitch.INSTANCE.getOwnerProfileCardEmptyItemFoldParam().get(ProfileCardFeatureSwitch.PROFILE_BUBBLE_TIPS_PHOTO_EMPTY);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardFeatureApi
    public Class getElegantProfileTitleContainerClazz() {
        return ElegantProfileTitleContainer.class;
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardFeatureApi
    public boolean getIsPhotoWallEmpty(ProfileCardInfo profileCardInfo) {
        return getPhotoWallPicNum(profileCardInfo) == 0;
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardFeatureApi
    public IProfileCardFeatureApi.ProfileCardEmptyStatus getProfieEmptyStatus(ProfileCardInfo profileCardInfo) {
        boolean isPersonalityLabelEmpty = getIsPersonalityLabelEmpty(profileCardInfo);
        boolean isPhotoWallEmpty = getIsPhotoWallEmpty(profileCardInfo);
        if (isPersonalityLabelEmpty && isPhotoWallEmpty) {
            return IProfileCardFeatureApi.ProfileCardEmptyStatus.BOTH_EMPTY;
        }
        if (isPersonalityLabelEmpty) {
            return IProfileCardFeatureApi.ProfileCardEmptyStatus.LABEL_EMPTY;
        }
        if (isPhotoWallEmpty) {
            return IProfileCardFeatureApi.ProfileCardEmptyStatus.PHOTO_EMPTY;
        }
        return IProfileCardFeatureApi.ProfileCardEmptyStatus.NOT_EMPTY;
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardFeatureApi
    public IProfileViewLoader getViewLoader() {
        return new ProfileViewLoader();
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardFeatureApi
    public boolean isBlackOrBlackedUin(String str, CheckBlacklistListener checkBlacklistListener) {
        if (!((IRelationBlacklistApi) QRoute.api(IRelationBlacklistApi.class)).isEnableBlackList() || isSelfUinOrInvalidUin(str)) {
            return false;
        }
        asyncCheckBlackOrBlackedUin(str, checkBlacklistListener);
        return i.c().f(str);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardFeatureApi
    public boolean isBlacklistUin(final String str, final CheckBlacklistListener checkBlacklistListener) {
        if (!((IRelationBlacklistApi) QRoute.api(IRelationBlacklistApi.class)).isEnableBlackList() || isSelfUinOrInvalidUin(str)) {
            return false;
        }
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendNTSimpleInfoByUin = getFriendNTSimpleInfoByUin(str);
        if (friendNTSimpleInfoByUin != null && ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(friendNTSimpleInfoByUin.getUid(), TAG)) {
            return Boolean.TRUE.equals(friendNTSimpleInfoByUin.z());
        }
        if (checkBlacklistListener == null) {
            return i.c().e(str);
        }
        ((IRelationBlacklistApi) QRoute.api(IRelationBlacklistApi.class)).sendBlacklistCheckRequest(str, new RelationBlacklistListener() { // from class: com.tencent.mobileqq.profilecard.api.impl.ProfileCardFeatureApiImpl.1
            @Override // com.tencent.mobileqq.profilecard.listener.RelationBlacklistListener
            public void onResult(boolean z16, Object obj) {
                if (z16) {
                    RelationBlacklist$CheckRsp relationBlacklist$CheckRsp = (RelationBlacklist$CheckRsp) obj;
                    i.c().n(str, relationBlacklist$CheckRsp.is_block.get() || relationBlacklist$CheckRsp.is_blocked.get());
                    boolean z17 = relationBlacklist$CheckRsp.is_block.get();
                    i.c().m(str, z17);
                    checkBlacklistListener.onResult(z17);
                    if (QLog.isColorLevel()) {
                        QLog.i(ProfileCardFeatureApiImpl.TAG, 1, "ProfileCardBlacklistApiImpl isBlacklistUin async result is " + z17);
                    }
                }
            }
        });
        return i.c().e(str);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardFeatureApi
    public boolean isContactProfileElegantVersion() {
        return isElegantVersion() || com.tencent.relation.common.config.toggle.c.f364703p.g(false);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardFeatureApi
    public boolean isElegantVersion() {
        return ProfileCardVersionController.getVersion().equals(ProfileCardVersion.V_ELEGANT);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0039  */
    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardFeatureApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean isInStepBubbleTipsEnable() {
        boolean z16;
        com.tencent.relation.common.abtest.a.b("exp_qqprofile_relation");
        com.tencent.relation.common.config.toggle.c cVar = com.tencent.relation.common.config.toggle.c.f364701n;
        boolean g16 = cVar.g(false);
        JSONObject c16 = cVar.c();
        if (c16 != null && c16.has(KEY_HAS_GUIDE)) {
            try {
                z16 = "1".equals(c16.getString(KEY_HAS_GUIDE));
            } catch (JSONException e16) {
                QLog.e(TAG, 1, e16, new Object[0]);
            }
            if (QLog.isDebugVersion()) {
                QLog.d(TAG, 4, "isInStepComponentEnable, isToggleEnable=" + g16 + ", hasBubbleTips=" + z16);
            }
            return g16 && z16;
        }
        z16 = true;
        if (QLog.isDebugVersion()) {
        }
        if (g16) {
            return false;
        }
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardFeatureApi
    public boolean isInStepComponentEnable() {
        com.tencent.relation.common.abtest.a.b("exp_qqprofile_relation");
        boolean g16 = com.tencent.relation.common.config.toggle.c.f364701n.g(false);
        if (QLog.isDebugVersion()) {
            QLog.d(TAG, 4, "isInStepComponentEnable, isToggleEnable=" + g16);
        }
        return g16;
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardFeatureApi
    public boolean isVasCustomBg(ProfileCardInfo profileCardInfo, AppInterface appInterface) {
        long j3;
        long j16;
        Card card = profileCardInfo.card;
        if (card == null) {
            AllInOne allInOne = profileCardInfo.allInOne;
            card = (allInOne == null || TextUtils.isEmpty(allInOne.uin) || !VasToggle.BUG_PROFILE_CARD_107225761.isEnable(false)) ? null : ((IProfileDataService) appInterface.getRuntimeService(IProfileDataService.class, "all")).getProfileCardFromCache(profileCardInfo.allInOne.uin);
        }
        if (card != null) {
            j3 = card.lCurrentStyleId;
            j16 = card.lCurrentBgId;
        } else {
            j3 = 0;
            j16 = 0;
        }
        return ProfileTemplateApi.isVasCustomBgTemplateStyleID(j3) && !ThemeUtil.isNowThemeIsSimple(null, false, null) && ProfileCardManager.v(appInterface.getApp(), j16) && VasToggle.VAS_PROFILE_CARD_SPRING2023.isEnable(true);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardFeatureApi
    public void openProfileCardMore(Activity activity, Intent intent, int i3) {
        ProfileCardMoreFragment.openProfileCardMore(activity, intent, i3);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardFeatureApi
    public void updateUserIsBlackedFlag(String str, boolean z16) {
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
        IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.d(uidFromUin, str);
        dVar.M();
        if (iFriendsInfoService.isFriend(uidFromUin, TAG)) {
            dVar.b0(Boolean.valueOf(z16));
            iFriendsInfoService.accurateUpdateNTFriendSimpleInfo(dVar, TAG, (hx3.c<com.tencent.qqnt.ntrelation.friendsinfo.bean.d>) null);
        } else {
            i.c().n(str, z16);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardFeatureApi
    public void updateUserIsBlacklistUinFlag(String str, boolean z16) {
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
        IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.d(uidFromUin, str);
        dVar.M();
        if (iFriendsInfoService.isFriend(uidFromUin, TAG)) {
            dVar.a0(Boolean.valueOf(z16));
            iFriendsInfoService.accurateUpdateNTFriendSimpleInfo(dVar, TAG, (hx3.c<com.tencent.qqnt.ntrelation.friendsinfo.bean.d>) null);
        } else {
            i.c().m(str, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$asyncCheckBlackOrBlackedUin$2(final String str, final CheckBlacklistListener checkBlacklistListener, boolean z16, final Object obj) {
        if (z16) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.profilecard.api.impl.d
                @Override // java.lang.Runnable
                public final void run() {
                    ProfileCardFeatureApiImpl.lambda$asyncCheckBlackOrBlackedUin$1(obj, str, checkBlacklistListener);
                }
            }, 32, null, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$asyncCheckBlackOrBlackedUin$3(final CheckBlacklistListener checkBlacklistListener, final String str) {
        if (checkBlacklistListener == null) {
            return;
        }
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendNTSimpleInfoByUin = getFriendNTSimpleInfoByUin(str);
        if (friendNTSimpleInfoByUin != null && ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(friendNTSimpleInfoByUin.getUid(), TAG)) {
            Boolean bool = Boolean.TRUE;
            boolean z16 = bool.equals(friendNTSimpleInfoByUin.A()) || bool.equals(friendNTSimpleInfoByUin.z());
            i.c().n(str, z16);
            checkBlacklistListener.onResult(z16);
            return;
        }
        ((IRelationBlacklistApi) QRoute.api(IRelationBlacklistApi.class)).sendBlacklistCheckRequest(str, new RelationBlacklistListener() { // from class: com.tencent.mobileqq.profilecard.api.impl.b
            @Override // com.tencent.mobileqq.profilecard.listener.RelationBlacklistListener
            public final void onResult(boolean z17, Object obj) {
                ProfileCardFeatureApiImpl.lambda$asyncCheckBlackOrBlackedUin$2(str, checkBlacklistListener, z17, obj);
            }
        });
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardFeatureApi
    public com.tencent.relation.common.widget.a getBlacklistRelationActionSheet(Activity activity, boolean z16) {
        if (activity == null || activity.isFinishing()) {
            return null;
        }
        com.tencent.relation.common.widget.a a16 = com.tencent.relation.common.widget.b.a(activity, null);
        a16.setMainTitle(HardCodeUtil.qqStr(z16 ? R.string.f160581ve : R.string.f160601vg));
        a16.addButton(R.string.yow, 1, 1);
        if (z16) {
            a16.addButton(R.string.f227616ri, 1, 2);
        }
        a16.addCancelButton(R.string.cancel);
        return a16;
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardFeatureApi
    public void setProfileComponentCommonBg(View view) {
        Resources resources;
        if (view == null || (resources = view.getResources()) == null) {
            return;
        }
        view.setBackground(resources.getDrawable(R.drawable.ktt));
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardFeatureApi
    public boolean getIsPersonalityLabelEmpty(ProfileCardInfo profileCardInfo) {
        ProfilePersonalityLabelInfo profilePersonalityLabelInfo;
        List<PersonalityLabelInfo> list;
        return (profileCardInfo == null || (profilePersonalityLabelInfo = (ProfilePersonalityLabelInfo) profileCardInfo.getBusinessInfo(ProfilePersonalityLabelInfo.class)) == null || (list = profilePersonalityLabelInfo.personalityLabelInfos) == null || list.size() != 0) ? false : true;
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardFeatureApi
    public int getPhotoWallPicNum(ProfileCardInfo profileCardInfo) {
        ProfileCardPhotoWallData profileCardPhotoWallData;
        if (profileCardInfo == null || (profileCardPhotoWallData = (ProfileCardPhotoWallData) profileCardInfo.getBusinessInfo(ProfileCardPhotoWallData.class)) == null) {
            return -1;
        }
        return profileCardPhotoWallData.getSize();
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardFeatureApi
    public QQCustomDialog getAddBlacklistDialog(Activity activity, boolean z16, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnClickListener onClickListener3) {
        QQCustomDialog createCustomDialog;
        if (z16) {
            createCustomDialog = DialogUtil.createDialogWithCheckBox(activity, 0, HardCodeUtil.qqStr(R.string.f160611vh), HardCodeUtil.qqStr(R.string.f160601vg), HardCodeUtil.qqStr(R.string.f160591vf), true, HardCodeUtil.qqStr(R.string.cancel), HardCodeUtil.qqStr(R.string.f171151ok), onClickListener, onClickListener2, onClickListener3);
        } else {
            createCustomDialog = DialogUtil.createCustomDialog(activity, 0, HardCodeUtil.qqStr(R.string.f160611vh), HardCodeUtil.qqStr(R.string.f160601vg), HardCodeUtil.qqStr(R.string.cancel), HardCodeUtil.qqStr(R.string.f171151ok), onClickListener2, onClickListener3);
        }
        createCustomDialog.setCanceledOnTouchOutside(false);
        createCustomDialog.setCancelable(false);
        return createCustomDialog;
    }
}
