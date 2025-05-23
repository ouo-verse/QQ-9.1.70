package com.tencent.mobileqq.app;

import NS_MOBILE_MAIN_PAGE.mobile_sub_get_cover_rsp;
import android.os.Bundle;
import com.qzone.personalize.floatobject.business.model.FloatCacheData;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.CardProfile;
import com.tencent.mobileqq.data.LikeRankingInfo;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearpeople.mytab.NearbyMyTabCard;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.profilecard.observer.ICardObserver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.qidian.data.BmqqAccountType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes11.dex */
public class CardObserver implements ICardObserver {
    static IPatchRedirector $redirector_;

    public CardObserver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void onUpdate_onAnonymousSettingMeRedPoint(int i3, boolean z16, Object obj) {
        boolean z17;
        if (i3 != 110) {
            return;
        }
        if (obj instanceof Boolean) {
            z17 = ((Boolean) obj).booleanValue();
        } else {
            z17 = false;
        }
        onAnonymousSettingMeRedPoint(z16, z17);
    }

    private void onUpdate_onCardInBlackList(int i3, boolean z16, Object obj) {
        if (i3 != 2) {
            return;
        }
        onCardInBlackList(z16, ((Bundle) obj).getString("uin"));
    }

    private void onUpdate_onCardLabelUpdate(int i3, boolean z16, Object obj) {
        if (i3 != 52) {
            return;
        }
        onCardLabelUpdate(z16, obj);
    }

    private void onUpdate_onDeletePortrait(int i3, boolean z16, Object obj) {
        if (i3 != 12) {
            return;
        }
        if (z16) {
            Object[] objArr = (Object[]) obj;
            Bundle bundle = (Bundle) objArr[0];
            Card card = (Card) objArr[1];
            bundle.getString("uin");
            onDeletePortrait(z16, card, bundle.getInt("result", -1), bundle.getByteArray(PreDownloadConstants.RPORT_KEY_FILE_KEY));
            return;
        }
        Object[] objArr2 = (Object[]) obj;
        Bundle bundle2 = (Bundle) objArr2[0];
        Card card2 = (Card) objArr2[1];
        bundle2.getString("uin");
        onDeletePortrait(z16, card2, bundle2.getInt("result", -1), bundle2.getByteArray(PreDownloadConstants.RPORT_KEY_FILE_KEY));
    }

    private void onUpdate_onFavoritorsList(int i3, boolean z16, Object obj) {
        if (i3 != 42) {
            return;
        }
        if (z16) {
            Object[] objArr = (Object[]) obj;
            Card card = (Card) objArr[0];
            Bundle bundle = (Bundle) objArr[1];
            ArrayList<CardProfile> arrayList = (ArrayList) objArr[2];
            onFavoritorsList(true, bundle.getString("uin"), arrayList, bundle.getLong("startMid"), bundle.getLong("nextMid"), bundle.getByteArray("strCookie"), card);
            return;
        }
        onFavoritorsList(false, ((Bundle) ((Object[]) obj)[1]).getString("uin"), null, -1L, -1L, null, null);
    }

    private void onUpdate_onForceUpdateNearbyProfile(int i3, boolean z16, Object obj) {
        if (i3 != 62) {
            return;
        }
        onForceUpdateNearbyProfile(z16, (NearbyPeopleCard) obj);
    }

    private void onUpdate_onGetAccountType(int i3, boolean z16, Object obj) {
        if (i3 != 87) {
            return;
        }
        onGetAccountType(z16, (BmqqAccountType) obj);
    }

    private void onUpdate_onGetAllowActivateFriend(int i3, boolean z16, Object obj) {
        if (i3 != 58) {
            return;
        }
        onGetAllowActivateFriend(z16, ((Boolean) obj).booleanValue());
    }

    private void onUpdate_onGetAllowSeeLoginDays(int i3, boolean z16, Object obj) {
        if (i3 != 44) {
            return;
        }
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 2) {
                onGetAllowSeeLoginDays(z16, ((Boolean) objArr[0]).booleanValue(), (String) objArr[1]);
                return;
            } else {
                onGetAllowSeeLoginDays(false, false, null);
                return;
            }
        }
        onGetAllowSeeLoginDays(false, false, null);
    }

    private void onUpdate_onGetAllowStrangerInviteToGroupSwitch(int i3, boolean z16, Object obj) {
        if (i3 != 93) {
            return;
        }
        if (obj != null && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            onGetAllowStrangerInviteToGroupSwitch(z16, ((Boolean) objArr[0]).booleanValue(), ((Boolean) objArr[1]).booleanValue());
        } else {
            onGetAllowStrangerInviteToGroupSwitch(false, false, false);
        }
    }

    private void onUpdate_onGetAutoReplyList(int i3, boolean z16, Object obj) {
        if (i3 == 95 && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            onGetAutoReplyList(z16, (List) objArr[0], ((Integer) objArr[1]).intValue());
        }
    }

    private void onUpdate_onGetBabyQSwitch(int i3, boolean z16, Object obj) {
        if (i3 != 73) {
            return;
        }
        onGetBabyQSwitch(z16, ((Boolean) obj).booleanValue());
    }

    private void onUpdate_onGetCalReactiveDays(int i3, boolean z16, Object obj) {
        if (i3 != 70) {
            return;
        }
        onGetCalReactiveDays(z16, ((Boolean) obj).booleanValue());
    }

    private void onUpdate_onGetCardSwitch(int i3, boolean z16, Object obj) {
        boolean z17;
        if (i3 != 33) {
            return;
        }
        Bundle bundle = (Bundle) obj;
        String string = bundle.getString("uin");
        long j3 = bundle.getLong("uCloseNeighborVote", 0L);
        long j16 = bundle.getLong("uColseTimeEntityManager", 0L);
        boolean z18 = true;
        if (j3 == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (j16 != 0) {
            z18 = false;
        }
        onGetCardSwitch(z16, string, z17, z18);
    }

    private void onUpdate_onGetCareBarEnable(int i3, boolean z16, Object obj) {
        if (i3 != 101) {
            return;
        }
        ThreadManager.getUIHandler().post(new Runnable(z16, obj) { // from class: com.tencent.mobileqq.app.CardObserver.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Object val$data;
            final /* synthetic */ boolean val$isSuccess;

            {
                this.val$isSuccess = z16;
                this.val$data = obj;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, CardObserver.this, Boolean.valueOf(z16), obj);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    CardObserver.this.onGetCareBarEnable(this.val$isSuccess, Boolean.parseBoolean(this.val$data.toString()));
                }
            }
        });
    }

    private void onUpdate_onGetCommonSwitchFromDetailInfo(int i3, boolean z16, Object obj) {
        if (i3 == 83 && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            onGetCommonSwitchFromDetailInfo(z16, (short[]) objArr[0], (Map) objArr[1]);
        }
    }

    private void onUpdate_onGetEducationList(int i3, boolean z16, Object obj) {
        if (i3 == 99 && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length >= 2) {
                onGetEducationList(z16, ((Long) objArr[0]).longValue(), (ArrayList) objArr[1]);
            }
        }
    }

    private void onUpdate_onGetHelloLiveMessageState(int i3, boolean z16, Object obj) {
        if (i3 != 86) {
            return;
        }
        onGetHelloLiveMessageState(z16, Boolean.parseBoolean(obj.toString()));
    }

    private void onUpdate_onGetHiddenSession(int i3, boolean z16, Object obj) {
        if (i3 != 104) {
            return;
        }
        onGetHiddenSession(z16);
    }

    private void onUpdate_onGetKplCard(int i3, boolean z16, Object obj) {
        if (i3 != 88) {
            return;
        }
        onGetKplCard(z16, obj);
    }

    private void onUpdate_onGetLocationDescription(int i3, boolean z16, Object obj) {
        if (i3 == 43 && z16 && obj != null) {
            Card card = (Card) obj;
            onGetLocationDescription(true, card.uin, card);
        }
    }

    private void onUpdate_onGetMedal(int i3, boolean z16, Object obj) {
        if (i3 != 75) {
            return;
        }
        onGetMedal(z16, ((Boolean) obj).booleanValue());
    }

    private void onUpdate_onGetNearbyMyTabCard(int i3, boolean z16, Object obj) {
        if (i3 != 65) {
            return;
        }
        if (z16 && (obj instanceof Object[])) {
            onGetNearbyMyTabCard(z16, (NearbyMyTabCard) ((Object[]) obj)[0]);
        } else {
            onGetNearbyMyTabCard(false, null);
        }
    }

    private void onUpdate_onGetNotDisturb(int i3, boolean z16, Object obj) {
        String[] strArr;
        if (i3 == 96 && (strArr = (String[]) obj) != null && strArr.length == 2) {
            onGetNotDisturb(z16, strArr[0], strArr[1]);
        }
    }

    private void onUpdate_onGetNotifyOnLikeRankingList(int i3, boolean z16, Object obj) {
        if (i3 != 77) {
            return;
        }
        onGetNotifyOnLikeRankingList(z16, ((Boolean) obj).booleanValue());
    }

    private void onUpdate_onGetPCActiveState(int i3, boolean z16, Object obj) {
        if (i3 != 54) {
            return;
        }
        onGetPCActiveState(z16, Boolean.parseBoolean(obj.toString()));
    }

    private void onUpdate_onGetPartakeLikeRankingList(int i3, boolean z16, Object obj) {
        if (i3 != 81) {
            return;
        }
        onGetPartakeLikeRankingList(z16, ((Boolean) obj).booleanValue());
    }

    private void onUpdate_onGetPhoneNumSearchable(int i3, boolean z16, Object obj) {
        if (i3 != 38) {
            return;
        }
        onGetPhoneNumSearchable(z16, ((Boolean) obj).booleanValue());
    }

    private void onUpdate_onGetPrettyOwnerFlag(int i3, boolean z16, Object obj) {
        if (i3 != 107) {
            return;
        }
        onGetPrettyOwnerFlag(z16, obj);
    }

    private void onUpdate_onGetQZoneCover(int i3, boolean z16, Object obj) {
        if (i3 == 40 && obj != null) {
            Object[] objArr = (Object[]) obj;
            onGetQZoneCover(z16, (String) objArr[0], (mobile_sub_get_cover_rsp) objArr[1]);
        }
    }

    private void onUpdate_onGetSignInInfo(int i3, boolean z16, Object obj) {
        if (i3 != 82) {
            return;
        }
        onGetSignInInfo(z16);
    }

    private void onUpdate_onGetTroopHonorSwitch(int i3, boolean z16, Object obj) {
        if (i3 == 109 && obj != null) {
            onGetTroopHonorSwitch(z16, ((Boolean) obj).booleanValue());
        }
    }

    private void onUpdate_onGetWholePeopleVoteLebaSwitch(int i3, boolean z16, Object obj) {
        if (i3 == 89 && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            onGetWholePeopleVoteLebaSwitch(z16, ((Boolean) objArr[0]).booleanValue(), ((Boolean) objArr[1]).booleanValue());
        }
    }

    private void onUpdate_onGreetingRecv(int i3, boolean z16, Object obj) {
        if (i3 != 29) {
            return;
        }
        onGreetingRecv(z16, ((Bundle) obj).getString("uin"));
    }

    private void onUpdate_onGreetingSent(int i3, boolean z16, Object obj) {
        if (i3 != 22) {
            return;
        }
        onGreetingSent(z16, ((Bundle) obj).getString("uin"));
    }

    private void onUpdate_onImpeach(int i3, boolean z16, Object obj) {
        if (i3 != 23) {
            return;
        }
        onImpeach(z16, ((Bundle) obj).getString("uin"));
    }

    private void onUpdate_onIsQiDianExt(int i3, boolean z16, Object obj) {
        if (i3 != 68) {
            return;
        }
        onGetAccountType(z16, (BmqqAccountType) obj);
    }

    private void onUpdate_onLabelLikeSet(int i3, boolean z16, Object obj) {
        if (i3 != 53) {
            return;
        }
        if (z16) {
            if (obj instanceof Object[]) {
                Object[] objArr = (Object[]) obj;
                onLabelLikeSet(z16, (Card) objArr[0], ((Long) objArr[1]).longValue());
                return;
            }
            return;
        }
        if (obj instanceof Card) {
            onLabelLikeSet(z16, (Card) obj, -1L);
        }
    }

    private void onUpdate_onMedalChange(int i3, boolean z16, Object obj) {
        if (i3 != 51) {
            return;
        }
        onMedalChange(z16, (Card) obj);
    }

    private void onUpdate_onMedalGuest(int i3, boolean z16, Object obj) {
        if (i3 != 121) {
            return;
        }
        onMedalCountGuest(z16, ((Integer) obj).intValue());
    }

    private void onUpdate_onNearByProfileSymbolGet(int i3, boolean z16, Object obj) {
        if (i3 != 56) {
            return;
        }
        onNearByProfileSymbolGet(z16, ((Integer) obj).intValue());
    }

    private void onUpdate_onNewVotePush(int i3, boolean z16, Object obj) {
        if (i3 == 28 && z16) {
            Object[] objArr = (Object[]) obj;
            Card card = (Card) objArr[0];
            Bundle bundle = (Bundle) objArr[1];
            bundle.getString("uin");
            onNewVotePush(z16, bundle.getString("voteeUin"), bundle.getInt("newVoteCount"), card);
        }
    }

    private void onUpdate_onReqApplyUploadVoice(int i3, boolean z16, Object obj) {
        if (i3 != 36) {
            return;
        }
        onReqApplyUploadVoice(z16, ((Bundle) obj).getString("pttcenter_selfuin"));
    }

    private void onUpdate_onReqFavoriteResult(int i3, boolean z16, Object obj) {
        if (i3 == 32 && (obj instanceof Bundle)) {
            Bundle bundle = (Bundle) obj;
            if (bundle.getInt("favoriteSource") == 43) {
                onReqFavoriteResultRank(z16, bundle.getString("selfUin"), bundle.getString(IProfileProtocolConst.PARAM_TARGET_UIN), bundle.getInt("toplist_type"), bundle.getInt(FloatCacheData.ICOUNT, 0));
            } else {
                onReqFavoriteResult(z16, bundle.getString("selfUin"), bundle.getString(IProfileProtocolConst.PARAM_TARGET_UIN), bundle.getInt(FloatCacheData.ICOUNT, 0), bundle.getInt("from", 0));
            }
        }
    }

    private void onUpdate_onReqLikeRankingListResult(int i3, boolean z16, Object obj) {
        if (i3 != 76) {
            return;
        }
        if (z16) {
            Object[] objArr = (Object[]) obj;
            onReqLikeRankingListResult(true, (String) objArr[3], (List) objArr[0], ((Integer) objArr[1]).intValue(), ((Boolean) objArr[2]).booleanValue());
            return;
        }
        onReqLikeRankingListResult(false, (String) obj, null, 0, false);
    }

    private void onUpdate_onSetAllowActivateFriend(int i3, boolean z16, Object obj) {
        if (i3 != 57) {
            return;
        }
        onSetAllowActivateFriend(z16, ((Boolean) obj).booleanValue());
    }

    private void onUpdate_onSetAllowSeeLoginDays(int i3, boolean z16, Object obj) {
        if (i3 != 45) {
            return;
        }
        onSetAllowSeeLoginDays(z16);
    }

    private void onUpdate_onSetAutoReplyList(int i3, boolean z16, Object obj) {
        if (i3 != 97) {
            return;
        }
        onSetAutoReplyList(z16);
    }

    private void onUpdate_onSetBabyQSwitch(int i3, boolean z16, Object obj) {
        if (i3 != 72) {
            return;
        }
        onSetBabyQSwitch(z16, ((Boolean) obj).booleanValue());
    }

    private void onUpdate_onSetCalReactiveDays(int i3, boolean z16, Object obj) {
        if (i3 != 71) {
            return;
        }
        onSetCalReactiveDays(z16);
    }

    private void onUpdate_onSetCardSwitch(int i3, boolean z16, Object obj) {
        if (i3 != 34) {
            return;
        }
        Bundle bundle = (Bundle) obj;
        onSetCardSwitch(z16, bundle.getString("uin"), bundle.getBoolean("modify_switch_for_near_people"), bundle.getBoolean("target_switch"));
    }

    private void onUpdate_onSetCardTemplateReturn(int i3, boolean z16, Object obj) {
        if (i3 != 41) {
            return;
        }
        onSetCardTemplateReturn(z16, obj);
    }

    private void onUpdate_onSetCareBarEnable(int i3, boolean z16, Object obj) {
        if (i3 != 100) {
            return;
        }
        onSetCareBarEnable(z16, Boolean.parseBoolean(obj.toString()));
    }

    private void onUpdate_onSetCommonSwitchFromDetailInfo(int i3, boolean z16, Object obj) {
        if (i3 == 84 && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            onSetCommonSwitchFromDetailInfo(z16, ((Short) objArr[0]).shortValue(), ((Short) objArr[1]).shortValue());
        }
    }

    private void onUpdate_onSetConnectionsSwitch(int i3, boolean z16, Object obj) {
        if (i3 == 108 && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length >= 2) {
                onSetConnectionsSwitch(z16, ((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue());
            }
        }
    }

    private void onUpdate_onSetEmotionRecSwitch(int i3, boolean z16, Object obj) {
        if (i3 != 102) {
            return;
        }
        onSetEmotionRecSwitch(z16, Boolean.parseBoolean(obj.toString()));
    }

    private void onUpdate_onSetHelloLiveMessageState(int i3, boolean z16, Object obj) {
        if (i3 == 85 && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            onSetHelloLiveMessageState(z16, Boolean.parseBoolean(objArr[0].toString()), objArr[1].toString(), objArr[2].toString());
        }
    }

    private void onUpdate_onSetHiddenSession(int i3, boolean z16, Object obj) {
        int intValue;
        if (i3 != 105) {
            return;
        }
        if (obj == null) {
            intValue = 0;
        } else {
            intValue = ((Integer) obj).intValue();
        }
        onSetHiddenSession(z16, intValue);
    }

    private void onUpdate_onSetMedal(int i3, boolean z16, Object obj) {
        if (i3 != 74) {
            return;
        }
        onSetMedal(z16);
    }

    private void onUpdate_onSetNick(int i3, boolean z16, Object obj) {
        if (i3 != 92) {
            return;
        }
        onSetNick(z16, (String) obj);
    }

    private void onUpdate_onSetNotDisturb(int i3, boolean z16, Object obj) {
        String[] strArr;
        if (i3 == 94 && (strArr = (String[]) obj) != null && strArr.length == 2) {
            onSetNotDisturb(z16, strArr[0], strArr[1]);
        }
    }

    private void onUpdate_onSetNotifyOnLikeRankingList(int i3, boolean z16, Object obj) {
        if (i3 != 78) {
            return;
        }
        onSetNotifyOnLikeRankingList(z16, ((Boolean) obj).booleanValue());
    }

    private void onUpdate_onSetPCActiveState(int i3, boolean z16, Object obj) {
        if (i3 == 55 && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            onSetPCActiveState(z16, Boolean.parseBoolean(objArr[0].toString()), objArr[1].toString(), objArr[2].toString());
        }
    }

    private void onUpdate_onSetPartakeLikeRankingList(int i3, boolean z16, Object obj) {
        if (i3 != 80) {
            return;
        }
        onSetPartakeLikeRankingList(z16, ((Boolean) obj).booleanValue());
    }

    private void onUpdate_onSetPhoneNumSearchable(int i3, boolean z16, Object obj) {
        if (i3 != 39) {
            return;
        }
        onSetPhoneNumSearchable(z16, ((Boolean) obj).booleanValue());
    }

    private void onUpdate_onSetPrettyOwnerFlag(int i3, boolean z16, Object obj) {
        if (i3 != 106) {
            return;
        }
        onSetPrettyOwnerFlag(z16, obj);
    }

    private void onUpdate_onSetPttAutoToTxtSwitch(int i3, boolean z16, Object obj) {
        if (i3 != 103) {
            return;
        }
        onSetPttAutoToTxtSwitch(z16, obj);
    }

    private void onUpdate_onSetShowPushNotice(int i3, boolean z16, Object obj) {
        if (i3 != 90) {
            return;
        }
        onSetShowPushNotice(z16, ((Boolean) obj).booleanValue());
    }

    private void onUpdate_onSetSubaccountDisplayThirdQQ(int i3, boolean z16, Object obj) {
        if (i3 != 79) {
            return;
        }
        onSetSubaccountDisplayThirdQQ(z16);
    }

    private void onUpdate_onTransferVoice(int i3, boolean z16, Object obj) {
        if (i3 != 37) {
            return;
        }
        Bundle bundle = (Bundle) obj;
        onTransferVoice(z16, bundle.getString("pttcenter_selfuin"), bundle.getString("pttcenter_filekey"), bundle.getInt("pttcenter_voice_optype"));
    }

    private void onUpdate_onUpdateAvatar(int i3, boolean z16, Object obj) {
        if (i3 != 8) {
            return;
        }
        Bundle bundle = (Bundle) obj;
        onUpdateAvatar(z16, bundle.getString("uin"), bundle.getInt("result"));
    }

    private void onUpdate_onUpdateCard(int i3, boolean z16, Object obj) {
        if (i3 != 3) {
            return;
        }
        if (z16) {
            onUpdateCard(z16, (Card) obj);
        } else {
            onUpdateCard(z16, null);
        }
    }

    private void onUpdate_onUpdateSetCallTabVisible(int i3, boolean z16, Object obj) {
        if (i3 != 59) {
            return;
        }
        onUpdateSetCallTabVisible(z16, ((Boolean) obj).booleanValue());
    }

    private void onUpdate_onUploadQZonePhotoWall(int i3, boolean z16, Object obj) {
        if (i3 == 69 && obj != null) {
            onUploadQZonePhotoWall(z16, obj);
        }
    }

    private void onUpdate_onVoiceManager(int i3, boolean z16, Object obj) {
        if (i3 == 35 && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            onVoiceManager(z16, (String) objArr[0], ((Integer) objArr[1]).intValue(), (Card) objArr[2]);
        }
    }

    private void onUpdate_onVoterList(int i3, boolean z16, Object obj) {
        if (i3 != 6) {
            return;
        }
        if (z16) {
            Object[] objArr = (Object[]) obj;
            Card card = (Card) objArr[0];
            Bundle bundle = (Bundle) objArr[1];
            ArrayList<CardProfile> arrayList = (ArrayList) objArr[2];
            ArrayList<Long> arrayList2 = (ArrayList) objArr[3];
            int intValue = ((Integer) objArr[4]).intValue();
            int intValue2 = ((Integer) objArr[5]).intValue();
            int intValue3 = ((Integer) objArr[6]).intValue();
            int intValue4 = ((Integer) objArr[7]).intValue();
            int intValue5 = ((Integer) objArr[8]).intValue();
            onVoterList(true, bundle.getString("uin"), arrayList, arrayList2, intValue, intValue2, intValue3, intValue4, intValue5, bundle.getLong("startMid"), bundle.getLong("nextMid"), bundle.getByteArray("strCookie"), card);
            return;
        }
        onVoterList(false, ((Bundle) ((Object[]) obj)[1]).getString("uin"), null, null, -1, -1, -1, -1, -1, -1L, -1L, null, null);
    }

    private void onupdateOnreqdelvoterecord(int i3, boolean z16, Object obj) {
        if (i3 != 91) {
            return;
        }
        Object[] objArr = (Object[]) obj;
        onReqDelVoteRecord(z16, ((Long) objArr[0]).longValue(), ((Long) objArr[1]).longValue(), ((Integer) objArr[2]).intValue());
    }

    protected void onAnonymousSettingMeRedPoint(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 83)) {
            iPatchRedirector.redirect((short) 83, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
    }

    protected void onCardInBlackList(boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Boolean.valueOf(z16), str);
        }
    }

    protected void onCardLabelUpdate(boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Boolean.valueOf(z16), obj);
        }
    }

    protected void onDeletePortrait(boolean z16, Card card, int i3, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, Boolean.valueOf(z16), card, Integer.valueOf(i3), bArr);
        }
    }

    protected void onFavoritorsList(boolean z16, String str, ArrayList<CardProfile> arrayList, long j3, long j16, byte[] bArr, Card card) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, Boolean.valueOf(z16), str, arrayList, Long.valueOf(j3), Long.valueOf(j16), bArr, card);
        }
    }

    protected void onForceUpdateNearbyProfile(boolean z16, NearbyPeopleCard nearbyPeopleCard) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            iPatchRedirector.redirect((short) 64, this, Boolean.valueOf(z16), nearbyPeopleCard);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onGetAccountType(boolean z16, BmqqAccountType bmqqAccountType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
            iPatchRedirector.redirect((short) 66, this, Boolean.valueOf(z16), bmqqAccountType);
        }
    }

    protected void onGetAllowActivateFriend(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            iPatchRedirector.redirect((short) 60, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
    }

    protected void onGetAllowSeeLoginDays(boolean z16, boolean z17, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, this, Boolean.valueOf(z16), Boolean.valueOf(z17), str);
        }
    }

    protected void onGetAllowStrangerInviteToGroupSwitch(boolean z16, boolean z17, boolean z18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 73)) {
            iPatchRedirector.redirect((short) 73, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18));
        }
    }

    protected void onGetAutoReplyList(boolean z16, List<AutoReplyText> list, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 74)) {
            iPatchRedirector.redirect((short) 74, this, Boolean.valueOf(z16), list, Integer.valueOf(i3));
        }
    }

    protected void onGetBabyQSwitch(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            iPatchRedirector.redirect((short) 62, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
    }

    protected void onGetCalReactiveDays(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
    }

    protected void onGetCardSwitch(boolean z16, String str, boolean z17, boolean z18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Boolean.valueOf(z16), str, Boolean.valueOf(z17), Boolean.valueOf(z18));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onGetCareBarEnable(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 77)) {
            iPatchRedirector.redirect((short) 77, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
    }

    protected void onGetCommonSwitchFromDetailInfo(boolean z16, short[] sArr, Map<Short, Short> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), sArr, map);
        }
    }

    protected void onGetDetailInfo(boolean z16, String str, Card card) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, Boolean.valueOf(z16), str, card);
        }
    }

    protected void onGetEducationList(boolean z16, long j3, ArrayList<com.tencent.mobileqq.profile.i> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Long.valueOf(j3), arrayList);
        }
    }

    protected void onGetHelloLiveMessageState(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
    }

    protected void onGetHiddenSession(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            iPatchRedirector.redirect((short) 59, (Object) this, z16);
        }
    }

    protected void onGetKplCard(boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Boolean.valueOf(z16), obj);
        }
    }

    protected void onGetLocationDescription(boolean z16, String str, Card card) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, this, Boolean.valueOf(z16), str, card);
        }
    }

    protected void onGetMedal(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 68)) {
            iPatchRedirector.redirect((short) 68, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
    }

    protected void onGetNearbyMyTabCard(boolean z16, NearbyMyTabCard nearbyMyTabCard) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            iPatchRedirector.redirect((short) 65, this, Boolean.valueOf(z16), nearbyMyTabCard);
        }
    }

    public void onGetNotDisturb(boolean z16, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            iPatchRedirector.redirect((short) 56, this, Boolean.valueOf(z16), str, str2);
        }
    }

    protected void onGetNotifyOnLikeRankingList(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
    }

    protected void onGetPCActiveState(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
    }

    protected void onGetPartakeLikeRankingList(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
    }

    protected void onGetPhoneNumSearchable(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
    }

    protected void onGetPrettyOwnerFlag(boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 80)) {
            iPatchRedirector.redirect((short) 80, this, Boolean.valueOf(z16), obj);
        }
    }

    protected void onGetQZoneCover(boolean z16, String str, mobile_sub_get_cover_rsp mobile_sub_get_cover_rspVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, this, Boolean.valueOf(z16), str, mobile_sub_get_cover_rspVar);
        }
    }

    protected void onGetShoppingInfo(boolean z16, String str, List<com.tencent.mobileqq.profile.j> list, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, this, Boolean.valueOf(z16), str, list, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }

    protected void onGetSignInInfo(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 70)) {
            iPatchRedirector.redirect((short) 70, (Object) this, z16);
        }
    }

    protected void onGetTroopHonorSwitch(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
    }

    protected void onGetWholePeopleVoteLebaSwitch(boolean z16, boolean z17, boolean z18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18));
        }
    }

    protected void onGreetingRecv(boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, Boolean.valueOf(z16), str);
        }
    }

    protected void onGreetingSent(boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, Boolean.valueOf(z16), str);
        }
    }

    protected void onImpeach(boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, this, Boolean.valueOf(z16), str);
        }
    }

    protected void onLabelLikeSet(boolean z16, Card card, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Boolean.valueOf(z16), card, Long.valueOf(j3));
        }
    }

    protected void onMedalChange(boolean z16, Card card) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), card);
        }
    }

    protected void onMedalCountGuest(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Integer.valueOf(i3));
        }
    }

    protected void onNearByProfileSymbolGet(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, this, Boolean.valueOf(z16), Integer.valueOf(i3));
        }
    }

    protected void onNewVotePush(boolean z16, String str, int i3, Card card) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, this, Boolean.valueOf(z16), str, Integer.valueOf(i3), card);
        }
    }

    protected void onReqApplyUploadVoice(boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, this, Boolean.valueOf(z16), str);
        }
    }

    protected void onReqDelVoteRecord(boolean z16, long j3, long j16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Boolean.valueOf(z16), Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3));
        }
    }

    protected void onReqFavoriteResult(boolean z16, String str, String str2, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Boolean.valueOf(z16), str, str2, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    protected void onReqFavoriteResultRank(boolean z16, String str, String str2, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, Boolean.valueOf(z16), str, str2, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    protected void onReqLikeRankingListResult(boolean z16, String str, List<LikeRankingInfo> list, int i3, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Boolean.valueOf(z16), str, list, Integer.valueOf(i3), Boolean.valueOf(z17));
        }
    }

    protected void onSetAllowActivateFriend(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            iPatchRedirector.redirect((short) 55, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
    }

    protected void onSetAllowSeeLoginDays(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, z16);
        }
    }

    protected void onSetAutoReplyList(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 75)) {
            iPatchRedirector.redirect((short) 75, (Object) this, z16);
        }
    }

    protected void onSetBabyQSwitch(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            iPatchRedirector.redirect((short) 61, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
    }

    protected void onSetCalReactiveDays(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this, z16);
        }
    }

    protected void onSetCardSwitch(boolean z16, String str, boolean z17, boolean z18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Boolean.valueOf(z16), str, Boolean.valueOf(z17), Boolean.valueOf(z18));
        }
    }

    public void onSetCardTemplateReturn(boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Boolean.valueOf(z16), obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSetCareBarEnable(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 76)) {
            iPatchRedirector.redirect((short) 76, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
    }

    protected void onSetCommonSwitchFromDetailInfo(boolean z16, short s16, short s17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(z16), Short.valueOf(s16), Short.valueOf(s17));
        }
    }

    protected void onSetConnectionsSwitch(boolean z16, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 82)) {
            iPatchRedirector.redirect((short) 82, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    protected void onSetEmotionRecSwitch(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 78)) {
            iPatchRedirector.redirect((short) 78, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
    }

    protected void onSetHelloLiveMessageState(boolean z16, boolean z17, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            iPatchRedirector.redirect((short) 53, this, Boolean.valueOf(z16), Boolean.valueOf(z17), str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSetHiddenSession(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            iPatchRedirector.redirect((short) 58, this, Boolean.valueOf(z16), Integer.valueOf(i3));
        }
    }

    protected void onSetMedal(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 67)) {
            iPatchRedirector.redirect((short) 67, (Object) this, z16);
        }
    }

    protected void onSetNick(boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 72)) {
            iPatchRedirector.redirect((short) 72, this, Boolean.valueOf(z16), str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSetNotDisturb(boolean z16, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            iPatchRedirector.redirect((short) 57, this, Boolean.valueOf(z16), str, str2);
        }
    }

    protected void onSetNotifyOnLikeRankingList(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
    }

    protected void onSetPCActiveState(boolean z16, boolean z17, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, this, Boolean.valueOf(z16), Boolean.valueOf(z17), str, str2);
        }
    }

    protected void onSetPartakeLikeRankingList(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
    }

    protected void onSetPhoneNumSearchable(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
    }

    protected void onSetPrettyOwnerFlag(boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 81)) {
            iPatchRedirector.redirect((short) 81, this, Boolean.valueOf(z16), obj);
        }
    }

    protected void onSetPttAutoToTxtSwitch(boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 79)) {
            iPatchRedirector.redirect((short) 79, this, Boolean.valueOf(z16), obj);
        }
    }

    protected void onSetShowPushNotice(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 71)) {
            iPatchRedirector.redirect((short) 71, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
    }

    protected void onSetSubaccountDisplayThirdQQ(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 69)) {
            iPatchRedirector.redirect((short) 69, (Object) this, z16);
        }
    }

    protected void onTransferVoice(boolean z16, String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, this, Boolean.valueOf(z16), str, str2, Integer.valueOf(i3));
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        onUpdate_onCardLabelUpdate(i3, z16, obj);
        onUpdate_onLabelLikeSet(i3, z16, obj);
        onUpdate_onVoiceManager(i3, z16, obj);
        onUpdate_onCardInBlackList(i3, z16, obj);
        onUpdate_onUpdateCard(i3, z16, obj);
        onUpdate_onReqFavoriteResult(i3, z16, obj);
        onUpdate_onVoterList(i3, z16, obj);
        onUpdate_onFavoritorsList(i3, z16, obj);
        onupdateOnreqdelvoterecord(i3, z16, obj);
        onUpdate_onReqLikeRankingListResult(i3, z16, obj);
        onUpdate_onUpdateAvatar(i3, z16, obj);
        onUpdate_onDeletePortrait(i3, z16, obj);
        onUpdate_onGreetingSent(i3, z16, obj);
        onUpdate_onGreetingRecv(i3, z16, obj);
        onUpdate_onGetLocationDescription(i3, z16, obj);
        onUpdate_onImpeach(i3, z16, obj);
        onUpdate_onSetCardTemplateReturn(i3, z16, obj);
        onUpdate_onNewVotePush(i3, z16, obj);
        onUpdate_onSetCardSwitch(i3, z16, obj);
        onUpdate_onGetCardSwitch(i3, z16, obj);
        onUpdate_onReqApplyUploadVoice(i3, z16, obj);
        onUpdate_onTransferVoice(i3, z16, obj);
        onUpdate_onGetPhoneNumSearchable(i3, z16, obj);
        onUpdate_onSetPhoneNumSearchable(i3, z16, obj);
        onUpdate_onGetQZoneCover(i3, z16, obj);
        onUpdate_onUploadQZonePhotoWall(i3, z16, obj);
        onUpdate_onGetPCActiveState(i3, z16, obj);
        onUpdate_onSetPCActiveState(i3, z16, obj);
        onUpdate_onSetHelloLiveMessageState(i3, z16, obj);
        onUpdate_onGetHelloLiveMessageState(i3, z16, obj);
        onUpdate_onGetAllowSeeLoginDays(i3, z16, obj);
        onUpdate_onSetAllowSeeLoginDays(i3, z16, obj);
        onUpdate_onGetNotifyOnLikeRankingList(i3, z16, obj);
        onUpdate_onSetNotifyOnLikeRankingList(i3, z16, obj);
        onUpdate_onSetPartakeLikeRankingList(i3, z16, obj);
        onUpdate_onGetPartakeLikeRankingList(i3, z16, obj);
        onUpdate_onGetCalReactiveDays(i3, z16, obj);
        onUpdate_onSetCalReactiveDays(i3, z16, obj);
        onUpdate_onNearByProfileSymbolGet(i3, z16, obj);
        onUpdate_onGetAllowActivateFriend(i3, z16, obj);
        onUpdate_onSetAllowActivateFriend(i3, z16, obj);
        onUpdate_onGetNotDisturb(i3, z16, obj);
        onUpdate_onSetNotDisturb(i3, z16, obj);
        onUpdate_onGetHiddenSession(i3, z16, obj);
        onUpdate_onSetHiddenSession(i3, z16, obj);
        onUpdate_onGetBabyQSwitch(i3, z16, obj);
        onUpdate_onSetBabyQSwitch(i3, z16, obj);
        onUpdate_onUpdateSetCallTabVisible(i3, z16, obj);
        onUpdate_onForceUpdateNearbyProfile(i3, z16, obj);
        onUpdate_onSetMedal(i3, z16, obj);
        onUpdate_onGetMedal(i3, z16, obj);
        onUpdate_onGetNearbyMyTabCard(i3, z16, obj);
        onUpdate_onIsQiDianExt(i3, z16, obj);
        onUpdate_onSetSubaccountDisplayThirdQQ(i3, z16, obj);
        onUpdate_onGetSignInInfo(i3, z16, obj);
        onUpdate_onGetAccountType(i3, z16, obj);
        onUpdate_onGetKplCard(i3, z16, obj);
        onUpdate_onGetCommonSwitchFromDetailInfo(i3, z16, obj);
        onUpdate_onSetCommonSwitchFromDetailInfo(i3, z16, obj);
        onUpdate_onGetWholePeopleVoteLebaSwitch(i3, z16, obj);
        onUpdate_onMedalChange(i3, z16, obj);
        onUpdate_onMedalGuest(i3, z16, obj);
        onUpdate_onSetShowPushNotice(i3, z16, obj);
        onUpdate_onSetNick(i3, z16, obj);
        onUpdate_onGetAllowStrangerInviteToGroupSwitch(i3, z16, obj);
        onUpdate_onGetAutoReplyList(i3, z16, obj);
        onUpdate_onSetAutoReplyList(i3, z16, obj);
        onUpdate_onGetEducationList(i3, z16, obj);
        onUpdate_onSetCareBarEnable(i3, z16, obj);
        onUpdate_onGetCareBarEnable(i3, z16, obj);
        onUpdate_onSetEmotionRecSwitch(i3, z16, obj);
        onUpdate_onSetPttAutoToTxtSwitch(i3, z16, obj);
        onUpdate_onGetPrettyOwnerFlag(i3, z16, obj);
        onUpdate_onSetPrettyOwnerFlag(i3, z16, obj);
        onUpdate_onSetConnectionsSwitch(i3, z16, obj);
        onUpdate_onGetTroopHonorSwitch(i3, z16, obj);
        onUpdate_onAnonymousSettingMeRedPoint(i3, z16, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onUpdateAvatar(boolean z16, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, Boolean.valueOf(z16), str, Integer.valueOf(i3));
        }
    }

    protected void onUpdateCard(boolean z16, Card card) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Boolean.valueOf(z16), card);
        }
    }

    protected void onUpdateSetCallTabVisible(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            iPatchRedirector.redirect((short) 63, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
    }

    protected void onUploadQZonePhotoWall(boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, this, Boolean.valueOf(z16), obj);
        }
    }

    protected void onVisitorList(boolean z16, String str, ArrayList<CardProfile> arrayList, long j3, long j16, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, Boolean.valueOf(z16), str, arrayList, Long.valueOf(j3), Long.valueOf(j16), bArr);
        }
    }

    protected void onVoiceManager(boolean z16, String str, int i3, Card card) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Boolean.valueOf(z16), str, Integer.valueOf(i3), card);
        }
    }

    protected void onVoterList(boolean z16, String str, ArrayList<CardProfile> arrayList, ArrayList<Long> arrayList2, int i3, int i16, int i17, int i18, int i19, long j3, long j16, byte[] bArr, Card card) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, Boolean.valueOf(z16), str, arrayList, arrayList2, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Long.valueOf(j3), Long.valueOf(j16), bArr, card);
        }
    }

    protected void reqShoppingInfo(boolean z16, int i3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, this, Boolean.valueOf(z16), Integer.valueOf(i3), str, str2);
        }
    }
}
