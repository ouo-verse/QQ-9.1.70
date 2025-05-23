package com.tencent.mobileqq.troop.api.observer;

import android.os.Bundle;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberCardInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.kernel.nativeinterface.GroupExt;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes19.dex */
public class e implements BusinessObserver, mqq.observer.BusinessObserver {
    static IPatchRedirector $redirector_;
    public static final int TYPE_BATCH_ADD_FRIEND_SECURITY_CHECK;
    public static final int TYPE_BATCH_GET_TROOPCARD_DEAFULTNICK;
    public static final int TYPE_DEL_TROOP_MEMBER;
    public static final int TYPE_GEN_NEW_TROOP_NAME;
    public static final int TYPE_GET_MULTI_TROOP_INFO;
    public static final int TYPE_GET_TROOPMEMEBER_CARD_LIST;
    public static final int TYPE_GET_TROOP_AUTH;
    public static final int TYPE_GET_TROOP_INFO;
    public static final int TYPE_GET_TROOP_INFO_AFTER_CREATE;
    public static final int TYPE_GET_TROOP_INFO_EXT_COMPLETE;
    public static final int TYPE_GET_TROOP_LIST;
    public static final int TYPE_GET_TROOP_MEMBER_AUTO_REMARK;
    public static final int TYPE_GET_TROOP_MEMBER_CARD;
    public static final int TYPE_GET_TROOP_MEMBER_LIST_BY_787;
    public static final int TYPE_GET_UIN_BY_OPEN_ID;
    public static final int TYPE_MODIFY_TROOPMEMEBER_CARD;
    public static final int TYPE_MODIFY_TROOPMEMEBER_CARD_PUSH;
    public static final int TYPE_NOTIFY_BATCH_ADDFRDS_DATA_PREPARE_ERR;
    public static final int TYPE_NOTIFY_BATCH_GET_TROOP_PROFILE;
    public static final int TYPE_NOTIFY_BATCH_REQ_COMMFRDS;
    public static final int TYPE_NOTIFY_OIDB_0XD22_1;
    public static final int TYPE_NOTIFY_OIDB_0XD22_2;
    public static final int TYPE_NOTIFY_OIDB_0XD23_2;
    public static final int TYPE_NOTIFY_READY_FOR_TROOP_BATCHADD_TIP;
    public static final int TYPE_NOTIFY_TROOP_OPEN_API_TOKEN_VERIFY;
    public static final int TYPE_NOTIFY_TROOP_RANK_TITLE_UPDATE;
    public static final int TYPE_NOTIFY_UPDATE_RECENT_LIST;
    public static final int TYPE_NOTIFY_UPDATE_TROOP_CLASS_INFO;
    public static final int TYPE_OPERATE_SPECIAL_FOCUS;
    public static final int TYPE_TROOP_ADMIN_CHANGED;
    public static final int TYPE_TROOP_MEMBER_LEVEL_GLOBAL_CHANGED;
    public static final int TYPE_TROOP_MEMBER_LEVEL_INFO_CHANGED;
    public static final int TYPE_TROOP_MEMBER_LEVEL_SINGLE_CHANGED;
    public static final int TYPE_TROOP_MEMBER_LIST_FIRST_INIT;
    private static int sNotificationTypeStart;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42061);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 41)) {
            redirector.redirect((short) 41);
            return;
        }
        int i3 = 0 + 1;
        TYPE_GET_TROOP_LIST = 0;
        int i16 = i3 + 1;
        TYPE_NOTIFY_UPDATE_RECENT_LIST = i3;
        int i17 = i16 + 1;
        TYPE_GET_TROOP_INFO = i16;
        int i18 = i17 + 1;
        TYPE_GET_MULTI_TROOP_INFO = i17;
        int i19 = i18 + 1;
        TYPE_GET_TROOP_INFO_AFTER_CREATE = i18;
        int i26 = i19 + 1;
        TYPE_GEN_NEW_TROOP_NAME = i19;
        int i27 = i26 + 1;
        TYPE_GET_TROOP_AUTH = i26;
        int i28 = i27 + 1;
        TYPE_GET_TROOP_INFO_EXT_COMPLETE = i27;
        int i29 = i28 + 1;
        TYPE_DEL_TROOP_MEMBER = i28;
        int i36 = i29 + 1;
        TYPE_GET_TROOPMEMEBER_CARD_LIST = i29;
        int i37 = i36 + 1;
        TYPE_GET_TROOP_MEMBER_CARD = i36;
        int i38 = i37 + 1;
        TYPE_GET_TROOP_MEMBER_LIST_BY_787 = i37;
        int i39 = i38 + 1;
        TYPE_MODIFY_TROOPMEMEBER_CARD = i38;
        int i46 = i39 + 1;
        TYPE_MODIFY_TROOPMEMEBER_CARD_PUSH = i39;
        int i47 = i46 + 1;
        TYPE_GET_TROOP_MEMBER_AUTO_REMARK = i46;
        int i48 = i47 + 1;
        TYPE_NOTIFY_OIDB_0XD22_1 = i47;
        int i49 = i48 + 1;
        TYPE_NOTIFY_OIDB_0XD22_2 = i48;
        int i56 = i49 + 1;
        TYPE_NOTIFY_OIDB_0XD23_2 = i49;
        int i57 = i56 + 1;
        TYPE_NOTIFY_TROOP_OPEN_API_TOKEN_VERIFY = i56;
        int i58 = i57 + 1;
        TYPE_BATCH_ADD_FRIEND_SECURITY_CHECK = i57;
        int i59 = i58 + 1;
        TYPE_NOTIFY_BATCH_REQ_COMMFRDS = i58;
        int i65 = i59 + 1;
        TYPE_NOTIFY_UPDATE_TROOP_CLASS_INFO = i59;
        int i66 = i65 + 1;
        TYPE_BATCH_GET_TROOPCARD_DEAFULTNICK = i65;
        int i67 = i66 + 1;
        TYPE_NOTIFY_BATCH_GET_TROOP_PROFILE = i66;
        int i68 = i67 + 1;
        TYPE_GET_UIN_BY_OPEN_ID = i67;
        int i69 = i68 + 1;
        TYPE_NOTIFY_READY_FOR_TROOP_BATCHADD_TIP = i68;
        int i75 = i69 + 1;
        TYPE_NOTIFY_BATCH_ADDFRDS_DATA_PREPARE_ERR = i69;
        int i76 = i75 + 1;
        TYPE_NOTIFY_TROOP_RANK_TITLE_UPDATE = i75;
        int i77 = i76 + 1;
        TYPE_OPERATE_SPECIAL_FOCUS = i76;
        int i78 = i77 + 1;
        TYPE_TROOP_MEMBER_LEVEL_INFO_CHANGED = i77;
        int i79 = i78 + 1;
        TYPE_TROOP_MEMBER_LEVEL_GLOBAL_CHANGED = i78;
        int i85 = i79 + 1;
        TYPE_TROOP_MEMBER_LEVEL_SINGLE_CHANGED = i79;
        int i86 = i85 + 1;
        TYPE_TROOP_ADMIN_CHANGED = i85;
        sNotificationTypeStart = i86 + 1;
        TYPE_TROOP_MEMBER_LIST_FIRST_INIT = i86;
    }

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void onUpdate_batchAddFriendSecurityCheck(int i3, boolean z16, Object obj) {
        if (i3 != TYPE_BATCH_ADD_FRIEND_SECURITY_CHECK) {
            return;
        }
        Object[] objArr = (Object[]) obj;
        onBAFSecurityCheckResult(z16, ((Integer) objArr[0]).intValue(), (String) objArr[1], (String) objArr[2], ((Long) objArr[3]).longValue(), ((Integer) objArr[4]).intValue());
    }

    private void onUpdate_batchGetTroopCardDeafultNick(int i3, boolean z16, Object obj) {
        if (i3 != TYPE_BATCH_GET_TROOPCARD_DEAFULTNICK) {
            return;
        }
        onBatchTroopCardDefaultNick(z16, obj);
    }

    private void onUpdate_delTroopMember(int i3, boolean z16, Object obj) {
        if (i3 == TYPE_DEL_TROOP_MEMBER && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            int intValue = ((Integer) objArr[0]).intValue();
            ArrayList<String> arrayList = (ArrayList) objArr[1];
            if (objArr.length > 2) {
                onDeleteTroopMember(z16, intValue, arrayList, (String) objArr[2]);
            } else {
                onDeleteTroopMember(z16, intValue, arrayList, null);
            }
        }
    }

    private void onUpdate_genNewTroopName(int i3, boolean z16, Object obj) {
        if (i3 != TYPE_GEN_NEW_TROOP_NAME) {
            return;
        }
        Object[] objArr = (Object[]) obj;
        onGenNewTroopName((String) objArr[0], (String) objArr[1]);
    }

    private void onUpdate_getMultiTroopInfo(int i3, boolean z16, Object obj) {
        if (i3 != TYPE_GET_MULTI_TROOP_INFO) {
            return;
        }
        onUpdateTroopNickname(z16);
        if (obj != null) {
            onGetMutilTroopInfoResult(z16, (ArrayList) obj);
        }
    }

    private void onUpdate_getSimpleTroopInfo(int i3, boolean z16, Object obj) {
        if (i3 == TYPE_GET_TROOP_INFO_AFTER_CREATE && (obj instanceof TroopInfo)) {
            onGetTroopInfoResultAfterCreate(z16, (TroopInfo) obj);
        }
    }

    private void onUpdate_getTroopAuth(int i3, boolean z16, Object obj) {
        long j3;
        String str;
        byte[] bArr;
        if (i3 == TYPE_GET_TROOP_AUTH && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length >= 1) {
                j3 = ((Long) objArr[0]).longValue();
            } else {
                j3 = 0;
            }
            long j16 = j3;
            if (objArr.length >= 2) {
                str = (String) objArr[1];
            } else {
                str = "";
            }
            String str2 = str;
            if (objArr.length >= 3) {
                bArr = (byte[]) objArr[2];
            } else {
                bArr = null;
            }
            onGetTroopAuth(z16, j16, str2, bArr);
        }
    }

    private void onUpdate_getTroopInfo(int i3, boolean z16, Object obj) {
        if (i3 != TYPE_GET_TROOP_INFO) {
            return;
        }
        onGetTroopInfoResult(z16, (String) obj);
    }

    private void onUpdate_getTroopList(int i3, boolean z16, Object obj) {
        if (i3 != TYPE_GET_TROOP_LIST) {
            return;
        }
        onUpdateTroopList(z16);
        onUpdateRecentList();
    }

    private void onUpdate_getTroopMemberAutoRemark(int i3, boolean z16, Object obj) {
        if (i3 != TYPE_GET_TROOP_MEMBER_AUTO_REMARK) {
            return;
        }
        Object[] objArr = (Object[]) obj;
        onGetTroopMemberAutoRemark(z16, (String) objArr[0], (String) objArr[1]);
    }

    private void onUpdate_getTroopMemberCard(int i3, boolean z16, Object obj) {
        if (i3 != TYPE_GET_TROOP_MEMBER_CARD) {
            return;
        }
        onGetTroopMemberCard(z16, obj);
    }

    private void onUpdate_getTroopMemberCardList(int i3, boolean z16, Object obj) {
        if (i3 != TYPE_GET_TROOPMEMEBER_CARD_LIST) {
            return;
        }
        if (obj != null) {
            Object[] objArr = (Object[]) obj;
            ArrayList<TroopMemberCardInfo> arrayList = (ArrayList) objArr[0];
            Boolean bool = (Boolean) objArr[1];
            onGetTroopMemberCardInfoResult(z16, arrayList);
            onGetTroopMemberCardInfoResult(z16, arrayList, bool.booleanValue());
            return;
        }
        onGetTroopMemberCardInfoResult(z16, null);
        onGetTroopMemberCardInfoResult(z16, null, false);
    }

    private void onUpdate_getUinByOpenId(int i3, boolean z16, Object obj) {
        if (i3 == TYPE_GET_UIN_BY_OPEN_ID && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            onGetUinByOpenId(z16, ((Integer) objArr[0]).intValue(), (String) objArr[1], (String) objArr[2], (String) objArr[3], ((Integer) objArr[4]).intValue(), ((Integer) objArr[5]).intValue(), objArr[6]);
        }
    }

    private void onUpdate_modifyTroopMemberCard(int i3, boolean z16, Object obj) {
        if (i3 != TYPE_MODIFY_TROOPMEMEBER_CARD) {
            return;
        }
        Object[] objArr = (Object[]) obj;
        if (objArr != null && objArr.length > 1) {
            onModifyTroopInfoResult(z16, (ArrayList) objArr[0], (String) objArr[1]);
        } else {
            onModifyTroopInfoResult(z16, null, "");
        }
    }

    private void onUpdate_modifyTroopMemberCardPush(int i3, boolean z16, Object obj) {
        if (i3 != TYPE_MODIFY_TROOPMEMEBER_CARD_PUSH) {
            return;
        }
        onModifyTroopInfoPushResult(z16, (ArrayList) obj);
    }

    private void onUpdate_notifyBatchAddfrdsDataPrepareErr(int i3, boolean z16, Object obj) {
        if (i3 != TYPE_NOTIFY_BATCH_ADDFRDS_DATA_PREPARE_ERR) {
            return;
        }
        Object[] objArr = (Object[]) obj;
        onTroopBatchAddFrdsDataPrepareErr(z16, (String) objArr[0], ((Long) objArr[1]).longValue(), ((Integer) objArr[2]).intValue());
    }

    private void onUpdate_notifyBatchGetTroopProfile(int i3, boolean z16, Object obj) {
        boolean z17;
        if (i3 != TYPE_NOTIFY_BATCH_GET_TROOP_PROFILE) {
            return;
        }
        if (obj instanceof Object[]) {
            z17 = ((Boolean) ((Object[]) obj)[0]).booleanValue();
        } else {
            z17 = true;
        }
        onGetOnePageTroopInfo(z16, z17);
    }

    private void onUpdate_notifyBatchReqCommfrds(int i3, boolean z16, Object obj) {
        if (i3 != TYPE_NOTIFY_BATCH_REQ_COMMFRDS) {
            return;
        }
        Object[] objArr = (Object[]) obj;
        onTroopBatchReqMemberCmnFrds(z16, (String) objArr[0], (String) objArr[1], ((Long) objArr[2]).longValue(), ((Integer) objArr[3]).intValue(), ((Boolean) objArr[4]).booleanValue(), ((Boolean) objArr[5]).booleanValue(), (HashMap) objArr[6], (List) objArr[7]);
    }

    private void onUpdate_notifyGetTroopInfoExtComplete(int i3, boolean z16, Object obj) {
        if (i3 == TYPE_GET_TROOP_INFO_EXT_COMPLETE && obj != null && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 2) {
                Object obj2 = objArr[0];
                if (obj2 instanceof String) {
                    Object obj3 = objArr[1];
                    if (obj3 instanceof GroupExt) {
                        onGetTroopInfoExtComplete(z16, (String) obj2, (GroupExt) obj3);
                    }
                }
            }
        }
    }

    private void onUpdate_notifyOidb_0xD22_1(int i3, boolean z16, Object obj) {
        String str;
        if (i3 != TYPE_NOTIFY_OIDB_0XD22_1) {
            return;
        }
        if (obj instanceof Object[]) {
            str = (String) ((Object[]) obj)[0];
        } else {
            str = "";
        }
        onGetCreateTroopTokenForThirdApp(z16, str);
    }

    private void onUpdate_notifyOidb_0xD22_2(int i3, boolean z16, Object obj) {
        String str;
        String str2;
        if (i3 != TYPE_NOTIFY_OIDB_0XD22_2) {
            return;
        }
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            str = (String) objArr[0];
            str2 = (String) objArr[1];
        } else {
            str = "";
            str2 = "";
        }
        onGetJoinTroopTokenForThirdApp(z16, str, str2);
    }

    private void onUpdate_notifyOidb_0xD23_2(int i3, boolean z16, Object obj) {
        int i16;
        long j3;
        if (i3 != TYPE_NOTIFY_OIDB_0XD23_2) {
            return;
        }
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            i16 = ((Integer) objArr[0]).intValue();
            j3 = ((Long) objArr[1]).longValue();
        } else {
            i16 = -1;
            j3 = 0;
        }
        onBindTroopForThirdApp(z16, i16, j3);
    }

    private void onUpdate_notifyReadyForTroopBatchAddTip(int i3, boolean z16, Object obj) {
        List<String> list;
        if (i3 != TYPE_NOTIFY_READY_FOR_TROOP_BATCHADD_TIP) {
            return;
        }
        Object[] objArr = (Object[]) obj;
        Object obj2 = objArr[2];
        if (obj2 != null) {
            list = (List) obj2;
        } else {
            list = null;
        }
        onTroopBatchAddFrdsReadyForTip(z16, (String) objArr[0], ((Integer) objArr[1]).intValue(), list);
    }

    private void onUpdate_notifyTroopOpenApiTokenVerify(int i3, boolean z16, Object obj) {
        if (i3 == TYPE_NOTIFY_TROOP_OPEN_API_TOKEN_VERIFY && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            onTroopOpenApiVerifyed(z16, ((Integer) objArr[0]).intValue(), (String) objArr[1], (String) objArr[2], (String) objArr[3], ((Integer) objArr[4]).intValue(), ((Integer) objArr[5]).intValue(), (ArrayList) objArr[6], ((Integer) objArr[7]).intValue(), ((Integer) objArr[8]).intValue());
        }
    }

    private void onUpdate_notifyTroopRankTitleUpdate(int i3, boolean z16, Object obj) {
        if (i3 == TYPE_NOTIFY_TROOP_RANK_TITLE_UPDATE && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length >= 3) {
                onTroopRankTitleUpdate((String) objArr[0], (String) objArr[1], ((Integer) objArr[2]).intValue());
            }
        }
    }

    private void onUpdate_notifyUpdateRecentList(int i3, boolean z16, Object obj) {
        if (i3 != TYPE_NOTIFY_UPDATE_RECENT_LIST) {
            return;
        }
        onUpdateRecentList();
    }

    private void onUpdate_notifyUpdateTroopClassInfo(int i3, boolean z16, Object obj) {
        if (i3 != TYPE_NOTIFY_UPDATE_TROOP_CLASS_INFO) {
            return;
        }
        onTroopClassInfoUpdate((String) ((Object[]) obj)[0]);
    }

    private void onUpdate_operateSpecialFocus(int i3, boolean z16, Object obj) {
        if (i3 == TYPE_OPERATE_SPECIAL_FOCUS && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            onOperateSpecialFocus(z16, (String) objArr[0], ((Integer) objArr[1]).intValue(), (long[]) objArr[2]);
        }
    }

    private void onUpdate_troopAdminChanged(int i3, Object obj) {
        if (i3 == TYPE_TROOP_ADMIN_CHANGED && (obj instanceof String)) {
            onAdminUpdate((String) obj);
        }
    }

    private void onUpdate_troopMemberLevelGlobalChanged(int i3, boolean z16, Object obj) {
        if (i3 != TYPE_TROOP_MEMBER_LEVEL_GLOBAL_CHANGED) {
            return;
        }
        onTroopMemberLevelGlobalChanged(z16);
    }

    private void onUpdate_troopMemberLevelInfoChanged(int i3, boolean z16, Object obj) {
        if (i3 == TYPE_TROOP_MEMBER_LEVEL_INFO_CHANGED && (obj instanceof String)) {
            onTroopMemberLevelInfoChanged(z16, (String) obj);
        }
    }

    private void onUpdate_troopMemberLevelSingleChanged(int i3, boolean z16, Object obj) {
        if (i3 == TYPE_TROOP_MEMBER_LEVEL_SINGLE_CHANGED && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length > 1) {
                Object obj2 = objArr[0];
                if (obj2 instanceof String) {
                    Object obj3 = objArr[1];
                    if (obj3 instanceof String) {
                        onTroopMemberLevelSingleChanged(z16, (String) obj2, (String) obj3);
                    }
                }
            }
        }
    }

    private void onUpdate_troopMemberListFirstInited(int i3, Object obj) {
        if (i3 == TYPE_TROOP_MEMBER_LIST_FIRST_INIT && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            onTroopMemberListFirstInited((String) objArr[0], (List) objArr[1]);
        }
    }

    protected void onAdminUpdate(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, (Object) str);
        }
    }

    protected void onBAFSecurityCheckResult(boolean z16, int i3, String str, String str2, long j3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, this, Boolean.valueOf(z16), Integer.valueOf(i3), str, str2, Long.valueOf(j3), Integer.valueOf(i16));
        }
    }

    protected void onBatchTroopCardDefaultNick(boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Boolean.valueOf(z16), obj);
        }
    }

    protected void onBindTroopForThirdApp(boolean z16, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, Boolean.valueOf(z16), Integer.valueOf(i3), Long.valueOf(j3));
        }
    }

    protected void onDeleteTroopMember(boolean z16, int i3, ArrayList<String> arrayList, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Boolean.valueOf(z16), Integer.valueOf(i3), arrayList, str);
        }
    }

    protected void onGenNewTroopName(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) str2);
        }
    }

    protected void onGetCreateTroopTokenForThirdApp(boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, Boolean.valueOf(z16), str);
        }
    }

    protected void onGetJoinTroopTokenForThirdApp(boolean z16, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, Boolean.valueOf(z16), str, str2);
        }
    }

    protected void onGetMutilTroopInfoResult(boolean z16, ArrayList<TroopInfo> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), arrayList);
        }
    }

    protected void onGetOnePageTroopInfo(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
    }

    protected void onGetTroopAuth(boolean z16, long j3, String str, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Boolean.valueOf(z16), Long.valueOf(j3), str, bArr);
        }
    }

    protected void onGetTroopInfoExtComplete(boolean z16, String str, GroupExt groupExt) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Boolean.valueOf(z16), str, groupExt);
        }
    }

    protected void onGetTroopInfoResult(boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), str);
        }
    }

    protected void onGetTroopInfoResultAfterCreate(boolean z16, TroopInfo troopInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), troopInfo);
        }
    }

    protected void onGetTroopMemberAutoRemark(boolean z16, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Boolean.valueOf(z16), str, str2);
        }
    }

    protected void onGetTroopMemberCard(boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Boolean.valueOf(z16), obj);
        }
    }

    protected void onGetTroopMemberCardInfoResult(boolean z16, ArrayList<TroopMemberCardInfo> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) {
            return;
        }
        iPatchRedirector.redirect((short) 13, this, Boolean.valueOf(z16), arrayList);
    }

    public void onGetUinByOpenId(boolean z16, int i3, String str, String str2, String str3, int i16, int i17, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, Boolean.valueOf(z16), Integer.valueOf(i3), str, str2, str3, Integer.valueOf(i16), Integer.valueOf(i17), obj);
        }
    }

    protected void onModifyTroopInfoPushResult(boolean z16, ArrayList<TroopMemberCardInfo> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Boolean.valueOf(z16), arrayList);
        }
    }

    protected void onModifyTroopInfoResult(boolean z16, ArrayList<TroopMemberCardInfo> arrayList, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Boolean.valueOf(z16), arrayList, str);
        }
    }

    protected void onOperateSpecialFocus(boolean z16, String str, int i3, long[] jArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Boolean.valueOf(z16), str, Integer.valueOf(i3), jArr);
        }
    }

    @Override // mqq.observer.BusinessObserver
    public void onReceive(int i3, boolean z16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
            return;
        }
        if (i3 == 0) {
            if (z16) {
                onSetTroopAdminSuccess(bundle.getString(AppConstants.Key.TROOP_CODE), bundle.getString("troop_member_uin"), bundle.getByte(QCircleDaTongConstant.ElementParamValue.OPERATION));
                return;
            }
            if (bundle != null) {
                i16 = bundle.getInt("error_code");
            }
            onSetTroopAdminFail(i16);
        }
    }

    protected void onSetTroopAdminFail(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, i3);
        }
    }

    protected void onSetTroopAdminSuccess(String str, String str2, byte b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, this, str, str2, Byte.valueOf(b16));
        }
    }

    protected void onTroopBatchAddFrdsDataPrepareErr(boolean z16, String str, long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, this, Boolean.valueOf(z16), str, Long.valueOf(j3), Integer.valueOf(i3));
        }
    }

    protected void onTroopBatchAddFrdsReadyForTip(boolean z16, String str, int i3, List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, this, Boolean.valueOf(z16), str, Integer.valueOf(i3), list);
        }
    }

    protected void onTroopBatchReqMemberCmnFrds(boolean z16, String str, String str2, long j3, int i3, boolean z17, boolean z18, HashMap<String, Integer> hashMap, List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, Boolean.valueOf(z16), str, str2, Long.valueOf(j3), Integer.valueOf(i3), Boolean.valueOf(z17), Boolean.valueOf(z18), hashMap, list);
        }
    }

    protected void onTroopClassInfoUpdate(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) str);
        }
    }

    protected void onTroopMemberLevelGlobalChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, z16);
        }
    }

    protected void onTroopMemberLevelInfoChanged(boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Boolean.valueOf(z16), str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onTroopMemberLevelSingleChanged(boolean z16, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, Boolean.valueOf(z16), str, str2);
        }
    }

    protected void onTroopMemberListFirstInited(String str, List<TroopMemberInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, (Object) str, (Object) list);
        }
    }

    public void onTroopOpenApiVerifyed(boolean z16, int i3, String str, String str2, String str3, int i16, int i17, ArrayList<String> arrayList, int i18, int i19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, Boolean.valueOf(z16), Integer.valueOf(i3), str, str2, str3, Integer.valueOf(i16), Integer.valueOf(i17), arrayList, Integer.valueOf(i18), Integer.valueOf(i19));
        }
    }

    protected void onTroopRankTitleUpdate(String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, this, str, str2, Integer.valueOf(i3));
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        onUpdate_getTroopList(i3, z16, obj);
        onUpdate_notifyUpdateRecentList(i3, z16, obj);
        onUpdate_getMultiTroopInfo(i3, z16, obj);
        onUpdate_getSimpleTroopInfo(i3, z16, obj);
        onUpdate_getTroopInfo(i3, z16, obj);
        onUpdate_notifyGetTroopInfoExtComplete(i3, z16, obj);
        onUpdate_genNewTroopName(i3, z16, obj);
        onUpdate_getTroopAuth(i3, z16, obj);
        onUpdate_modifyTroopMemberCard(i3, z16, obj);
        onUpdate_getTroopMemberCardList(i3, z16, obj);
        onUpdate_getTroopMemberCard(i3, z16, obj);
        onUpdate_modifyTroopMemberCardPush(i3, z16, obj);
        onUpdate_getTroopMemberAutoRemark(i3, z16, obj);
        onUpdate_batchGetTroopCardDeafultNick(i3, z16, obj);
        onUpdate_notifyTroopRankTitleUpdate(i3, z16, obj);
        onUpdate_delTroopMember(i3, z16, obj);
        onUpdate_notifyOidb_0xD22_1(i3, z16, obj);
        onUpdate_notifyOidb_0xD22_2(i3, z16, obj);
        onUpdate_notifyOidb_0xD23_2(i3, z16, obj);
        onUpdate_notifyTroopOpenApiTokenVerify(i3, z16, obj);
        onUpdate_notifyBatchGetTroopProfile(i3, z16, obj);
        onUpdate_getUinByOpenId(i3, z16, obj);
        onUpdate_notifyBatchReqCommfrds(i3, z16, obj);
        onUpdate_batchAddFriendSecurityCheck(i3, z16, obj);
        onUpdate_notifyReadyForTroopBatchAddTip(i3, z16, obj);
        onUpdate_notifyBatchAddfrdsDataPrepareErr(i3, z16, obj);
        onUpdate_operateSpecialFocus(i3, z16, obj);
        onUpdate_notifyUpdateTroopClassInfo(i3, z16, obj);
        onUpdate_troopMemberLevelInfoChanged(i3, z16, obj);
        onUpdate_troopMemberLevelGlobalChanged(i3, z16, obj);
        onUpdate_troopMemberLevelSingleChanged(i3, z16, obj);
        onUpdate_troopAdminChanged(i3, obj);
        onUpdate_troopMemberListFirstInited(i3, obj);
    }

    protected void onUpdateRecentList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    protected void onUpdateTroopList(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        }
    }

    protected void onUpdateTroopNickname(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        }
    }

    protected void onGetTroopMemberCardInfoResult(boolean z16, ArrayList<TroopMemberCardInfo> arrayList, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
            return;
        }
        iPatchRedirector.redirect((short) 12, this, Boolean.valueOf(z16), arrayList, Boolean.valueOf(z17));
    }
}
