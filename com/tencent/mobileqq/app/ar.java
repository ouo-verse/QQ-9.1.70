package com.tencent.mobileqq.app;

import QQService.SvcRspGetDevLoginInfo;
import android.os.Bundle;
import com.tencent.mobileqq.app.proxy.GroupActionResp;
import com.tencent.mobileqq.data.SysSuspiciousMsg;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.qphone.base.util.QLog;
import friendlist.GetOnlineInfoResp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import tencent.im.oidb.cmd0x777.cmd0x777$AddFrdInfo;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ar implements com.tencent.mobileqq.friend.observer.b {
    static IPatchRedirector $redirector_ = null;
    public static final int ERROR_INVITE_BAD_USERS = 9;
    public static final int ERROR_INVITE_FRIENDS_FORBIDDEN = 7;
    public static final int ERROR_INVITE_FRIENDS_FREQUENT = 1;
    static int[] NOTIFY_TYPES_1;
    static int[] NOTIFY_TYPES_2;
    static int[] NOTIFY_TYPES_3;
    static int[] NOTIFY_TYPES_4;
    static int[] NOTIFY_TYPES_5;
    static int[] NOTIFY_TYPES_6;
    static int[] NOTIFY_TYPES_7;
    static int[] NOTIFY_TYPES_8;
    static int[] NOTIFY_TYPES_9;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69734);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 86)) {
            redirector.redirect((short) 86);
            return;
        }
        NOTIFY_TYPES_1 = new int[]{114, 115, 116, 117, 118, 119, 120, 123, 124};
        NOTIFY_TYPES_2 = new int[]{107, 64, 110, 54, 92, 93, 94, 121, 122, 96};
        NOTIFY_TYPES_3 = new int[]{58, 50, 48, 70, 27, 61, 60};
        NOTIFY_TYPES_4 = new int[]{99, 101, 102, 106, 109, 108};
        NOTIFY_TYPES_5 = new int[]{82, 88, 104, 103, 89, 91, 111, 90, 97, 95};
        NOTIFY_TYPES_6 = new int[]{47, 73, 74, 81, 72, 85, 75, 77, 78, 79, 80, 76, 86, 87};
        NOTIFY_TYPES_7 = new int[]{49, 56, 57, 65, 66, 59, 62, 18, 19, 21, 22, 67};
        NOTIFY_TYPES_8 = new int[]{13, 14, 15, 28, 98, 13, 28};
        NOTIFY_TYPES_9 = new int[]{1, 2, 46, 51, 3, 63, 7, 8, 9, 10, 11};
    }

    public ar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static boolean contains(int[] iArr, int i3) {
        for (int i16 : iArr) {
            if (i16 == i3) {
                return true;
            }
        }
        return false;
    }

    private void onUpdateBatch1(int i3, boolean z16, Object obj) {
        if (!contains(NOTIFY_TYPES_1, i3) || !(obj instanceof Object[])) {
            return;
        }
        Object[] objArr = (Object[]) obj;
        switch (i3) {
            case 114:
                onGetFriendsHasBindPhone(z16, ((Integer) objArr[0]).intValue(), (List) objArr[1]);
                return;
            case 115:
                if (objArr.length > 1) {
                    onSuspiciousGetUnreadNum(z16, ((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue());
                    return;
                }
                return;
            case 116:
                if (objArr.length > 3) {
                    onSuspiciousGetList(z16, ((Integer) objArr[0]).intValue(), (ArrayList) objArr[1], (byte[]) objArr[2], objArr[3]);
                    return;
                }
                return;
            case 117:
                if (objArr.length > 1) {
                    onSuspiciousDel(z16, ((Integer) objArr[0]).intValue(), ((Long) objArr[1]).longValue());
                    return;
                }
                return;
            case 118:
                if (objArr.length > 0) {
                    onSuspiciousClear(z16, ((Integer) objArr[0]).intValue());
                    return;
                }
                return;
            case 119:
                if (objArr.length > 0) {
                    onSuspiciousSendReadReport(z16, ((Integer) objArr[0]).intValue());
                    return;
                }
                return;
            case 120:
                if (objArr.length > 1) {
                    onAgreeSuspiciousMsg(z16, ((Integer) objArr[0]).intValue(), ((Long) objArr[1]).longValue());
                    return;
                }
                return;
            case 121:
            case 122:
            default:
                return;
            case 123:
                if (objArr.length > 2) {
                    onGetConnectionsPerson(z16, ((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
                    return;
                }
                return;
            case 124:
                addFriendByContact(z16, objArr);
                return;
        }
    }

    private void onUpdateBatch2(int i3, boolean z16, Object obj) {
        if (!contains(NOTIFY_TYPES_2, i3) || !(obj instanceof Object[])) {
            return;
        }
        Object[] objArr = (Object[]) obj;
        if (i3 != 54) {
            if (i3 != 64) {
                if (i3 != 96) {
                    if (i3 != 107) {
                        if (i3 != 110) {
                            if (i3 != 121) {
                                if (i3 != 122) {
                                    switch (i3) {
                                        case 92:
                                            onSetSpecialCareSwitch_global(z16, objArr);
                                            return;
                                        case 93:
                                            onSetSpecialCareSwitch_specialRing(z16, objArr);
                                            return;
                                        case 94:
                                            onSetSpecialCareSwitch_qzone(z16, objArr);
                                            return;
                                        default:
                                            return;
                                    }
                                }
                                onSetMessageNotification(z16, objArr);
                                return;
                            }
                            onSetHiddenChatSwitch(z16, objArr);
                            return;
                        }
                        if (objArr != null && objArr.length == 3) {
                            onReqRecheckInHotReactive(z16, (String) objArr[0], (String) objArr[1], ((Integer) objArr[2]).intValue());
                            return;
                        } else {
                            onReqRecheckInHotReactive(false, "", "", 0);
                            return;
                        }
                    }
                    onAddBatchTroopFrd(z16, (String) objArr[0], (ArrayList) objArr[1]);
                    return;
                }
                onSetSpecialCareSwitchesOfAPerson(z16, objArr);
                return;
            }
            int length = objArr.length;
            if (length == 2) {
                onGetOnlineInfoByUinOrMobile(z16, ((Long) objArr[0]).longValue(), (String) objArr[1], null);
                return;
            } else {
                if (length == 3) {
                    onGetOnlineInfoByUinOrMobile(z16, ((Long) objArr[0]).longValue(), (String) objArr[1], (GetOnlineInfoResp) objArr[2]);
                    return;
                }
                return;
            }
        }
        onUpdateFriendShieldFlag(((Long) objArr[0]).longValue(), ((Boolean) objArr[1]).booleanValue(), ((Boolean) objArr[2]).booleanValue(), ((Boolean) objArr[3]).booleanValue(), (String) objArr[4]);
    }

    private void onUpdateBatch3(int i3, boolean z16, Object obj) {
        if (!contains(NOTIFY_TYPES_3, i3) || !(obj instanceof Object[])) {
            return;
        }
        Object[] objArr = (Object[]) obj;
        if (i3 != 27) {
            if (i3 != 48) {
                if (i3 != 50) {
                    if (i3 != 58) {
                        if (i3 != 70) {
                            if (i3 != 60) {
                                if (i3 == 61) {
                                    onUpdateStrangerRichStatus(z16, (String[]) objArr[0], (Map) objArr[1]);
                                    return;
                                }
                                return;
                            }
                            onUpdateCircleRichStatus(z16, (String[]) objArr[0], (Bundle) objArr[1]);
                            return;
                        }
                        onCondSearchFriendResult(((Long) objArr[0]).longValue(), z16, objArr[1], ((Integer) objArr[2]).intValue(), ((Integer) objArr[3]).intValue());
                        return;
                    }
                    onDelDevResult(z16, (String) objArr[0], (byte[]) objArr[1]);
                    return;
                }
                onKickOutDevFResult(z16, ((Long) objArr[0]).longValue(), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
                return;
            }
            onSearchFriendResult(z16, ((Integer) objArr[0]).intValue(), objArr[1], ((Integer) objArr[2]).intValue(), (String) objArr[3], ((Boolean) objArr[4]).booleanValue(), ((Long) objArr[5]).longValue(), ((Integer) objArr[6]).intValue(), (List) objArr[7]);
            return;
        }
        onSetComment(z16, (String) objArr[0], (String) objArr[1], ((Byte) objArr[2]).byteValue());
    }

    private void onUpdateBatch4(int i3, boolean z16, Object obj) {
        if (!contains(NOTIFY_TYPES_4, i3)) {
            return;
        }
        if (i3 != 99) {
            if (i3 != 106) {
                if (i3 != 101) {
                    if (i3 != 102) {
                        if (i3 != 108) {
                            if (i3 == 109) {
                                if (obj instanceof List) {
                                    try {
                                        onMayKnowListPushDel(z16, (List) obj);
                                        return;
                                    } catch (Throwable unused) {
                                        onMayKnowListPushDel(z16, null);
                                        return;
                                    }
                                }
                                onMayKnowListPushDel(z16, null);
                                return;
                            }
                            return;
                        }
                        if (obj instanceof Bundle) {
                            onMayKnowEntryStateChanged(z16, (Bundle) obj);
                            return;
                        } else {
                            onMayKnowEntryStateChanged(z16, null);
                            return;
                        }
                    }
                    if (obj != null && (obj instanceof ArrayList)) {
                        onUpdateHotFriendLevel(z16, (ArrayList) obj);
                        return;
                    }
                    return;
                }
                if (obj != null && (obj instanceof Boolean)) {
                    onUpdateOlympicTorchList(((Boolean) obj).booleanValue());
                    return;
                }
                return;
            }
            onAddBatchQIMFriend(z16, (List) obj);
            return;
        }
        onGroupDataInited();
    }

    private void onUpdateBatch5(int i3, boolean z16, Object obj) {
        if (!contains(NOTIFY_TYPES_5, i3)) {
            return;
        }
        if (i3 != 82) {
            if (i3 != 95) {
                if (i3 != 97) {
                    if (i3 != 111) {
                        if (i3 != 103) {
                            if (i3 != 104) {
                                switch (i3) {
                                    case 88:
                                        if (obj instanceof Bundle) {
                                            onGetMayKnowRecommend(z16, (Bundle) obj);
                                            return;
                                        } else {
                                            onGetMayKnowRecommend(z16, null);
                                            return;
                                        }
                                    case 89:
                                        onCancelMayKnowRecommend(z16, (String) obj);
                                        return;
                                    case 90:
                                        onGetSigZanInfo(z16, obj);
                                        return;
                                    case 91:
                                        if (z16) {
                                            onGetSpecialCareRecommend(true, obj);
                                            return;
                                        } else {
                                            onGetSpecialCareRecommend(false, null);
                                            return;
                                        }
                                    default:
                                        return;
                                }
                            }
                            onGetPushRecommend(z16);
                            return;
                        }
                        onMayknowStateChanged(z16);
                        return;
                    }
                    Object[] objArr = (Object[]) obj;
                    if (objArr != null && objArr.length == 3) {
                        onReqLastChatTime(z16, (String) objArr[0], (String) objArr[1], Long.valueOf(((Long) objArr[2]).longValue()));
                        return;
                    } else {
                        onReqLastChatTime(false, "", "", 0L);
                        return;
                    }
                }
                onSetMessageRaoam(z16);
                return;
            }
            if (z16) {
                Object[] objArr2 = (Object[]) obj;
                onUpdateSpecialCareList(z16, ((Boolean) objArr2[0]).booleanValue(), (ArrayList) objArr2[1], (ArrayList) objArr2[2]);
                return;
            } else {
                onUpdateSpecialCareList(false, false, null, null);
                return;
            }
        }
        List list = (List) obj;
        if (list != null && list.size() == 2) {
            onGetBothDongtaiPermissions(z16, ((Boolean) list.get(0)).booleanValue(), ((Boolean) list.get(1)).booleanValue());
        } else {
            onGetBothDongtaiPermissions(false, false, false);
        }
    }

    private void onUpdateBatch6(int i3, boolean z16, Object obj) {
        if (!contains(NOTIFY_TYPES_6, i3)) {
            return;
        }
        boolean z17 = true;
        if (i3 != 47) {
            switch (i3) {
                case 72:
                    onGetFriendNickBatch(z16, obj);
                    return;
                case 73:
                    onSetVisibilityForNetWorkStatus(z16, ((Boolean) obj).booleanValue());
                    return;
                case 74:
                    onGetVisibilityForNetWorkStatus(z16, ((Boolean) obj).booleanValue());
                    return;
                case 75:
                    Object[] objArr = (Object[]) obj;
                    onUpdateGatherFriendList(z16, ((Boolean) objArr[0]).booleanValue(), ((Boolean) objArr[1]).booleanValue());
                    return;
                case 76:
                    onUpdateRecommGatherFriendList(z16, ((Boolean) obj).booleanValue());
                    return;
                case 77:
                    onSetNotAllowedSeeMyDongtai(z16, ((Boolean) obj).booleanValue());
                    return;
                case 78:
                    onGetNotAllowedSeeMyDongtai(z16, ((Boolean) obj).booleanValue());
                    return;
                case 79:
                    onSetShieldHisDongtai(z16, ((Boolean) obj).booleanValue());
                    return;
                case 80:
                    onGetShieldHisDongtai(z16, ((Boolean) obj).booleanValue());
                    return;
                case 81:
                    onSetBothDongtaiPermissions(z16);
                    return;
                default:
                    switch (i3) {
                        case 85:
                            Object[] objArr2 = (Object[]) obj;
                            onGetFriendDateNick(z16, (String) objArr2[0], (String) objArr2[1]);
                            return;
                        case 86:
                            onSetAsUncommonlyUsedContacts(z16, (List) obj);
                            return;
                        case 87:
                            onSetAsNormalContacts(z16, (List) obj);
                            return;
                        default:
                            return;
                    }
            }
        }
        if (z16) {
            z17 = ((Boolean) obj).booleanValue();
        }
        onUpdateLastLoginInfo(z16, z17);
    }

    private void onUpdateBatch7(int i3, boolean z16, Object obj) {
        if (!contains(NOTIFY_TYPES_7, i3)) {
            return;
        }
        if (i3 != 18) {
            if (i3 != 19) {
                if (i3 != 21) {
                    if (i3 != 22) {
                        if (i3 != 56) {
                            if (i3 != 57) {
                                if (i3 != 59) {
                                    if (i3 != 62) {
                                        switch (i3) {
                                            case 65:
                                                if (z16) {
                                                    onGetRecommendDeviceList(z16, (ArrayList) obj);
                                                    return;
                                                } else {
                                                    onGetRecommendDeviceList(z16, null);
                                                    return;
                                                }
                                            case 66:
                                                onUpdateServerAuthDeviceList(z16);
                                                return;
                                            case 67:
                                                Bundle bundle = (Bundle) obj;
                                                onQueryUinSafetyFlag(z16, bundle.getLong("uin"), 146, bundle.getInt(FriendListHandler.KEY_SAFETY_FLAG));
                                                return;
                                            default:
                                                return;
                                        }
                                    }
                                    onGetStrangerInfo(z16, obj);
                                    return;
                                }
                                if (z16 && obj != null && (obj instanceof String)) {
                                    onAddFriend((String) obj);
                                    return;
                                }
                                return;
                            }
                            onGetRecentLoginAndLoginDevResult(z16, (SvcRspGetDevLoginInfo) obj);
                            return;
                        }
                        onGetLoginDevResult(z16, (SvcRspGetDevLoginInfo) obj);
                        return;
                    }
                    onResortGroupResp(z16, (GroupActionResp) obj);
                    return;
                }
                onDeleteGroupResp(z16, (GroupActionResp) obj);
                return;
            }
            onRenameGroupResp(z16, (GroupActionResp) obj);
            return;
        }
        onAddGroupResp(z16, (GroupActionResp) obj);
    }

    private void onUpdateBatch8(int i3, boolean z16, Object obj) {
        if (!contains(NOTIFY_TYPES_8, i3)) {
            return;
        }
        if (i3 != 28) {
            if (i3 != 98) {
                switch (i3) {
                    case 13:
                        onUpdateOnlineFriend(z16, (String[]) obj);
                        return;
                    case 14:
                        onUpdateGetVideoAbility(z16);
                        return;
                    case 15:
                        onUpdateDelFriend(z16, obj);
                        return;
                    default:
                        return;
                }
            }
            onPullIpad();
            return;
        }
        onSetSelfSignatureResult(z16);
    }

    private void onUpdateBatch9(int i3, boolean z16, Object obj) {
        if (!contains(NOTIFY_TYPES_9, i3)) {
            return;
        }
        boolean z17 = true;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 46) {
                        if (i3 != 51) {
                            if (i3 != 63) {
                                switch (i3) {
                                    case 7:
                                        onUpdateRecentList();
                                        return;
                                    case 8:
                                        onUpdateC2ChatStatus(z16, (HashMap) obj);
                                        return;
                                    case 9:
                                        Object[] objArr = (Object[]) obj;
                                        if (z16) {
                                            onUpdateMoveGroup((String) objArr[0], ((Byte) objArr[1]).byteValue(), ((Byte) objArr[2]).byteValue());
                                            return;
                                        } else {
                                            onUpdateMoveGroup(null, (byte) 0, (byte) 0);
                                            return;
                                        }
                                    case 10:
                                        if (z16) {
                                            Object[] objArr2 = (Object[]) obj;
                                            onUpdateAnswerAddedFriend(z16, (String) objArr2[0], ((Integer) objArr2[1]).intValue());
                                            return;
                                        } else {
                                            onUpdateAnswerAddedFriend(z16, "", 0);
                                            return;
                                        }
                                    default:
                                        return;
                                }
                            }
                            onUpdateFriendInfoFinished((ArrayList) obj, z16);
                            return;
                        }
                        Bundle bundle = (Bundle) obj;
                        onUpdateTroopHeadDownloadUrl(z16, bundle.getString("troopUin"), bundle.getString("url"));
                        return;
                    }
                    onGetStoreFace(z16, (HashSet) obj);
                    return;
                }
                onUpdateFriendInfo((String) obj, z16);
                return;
            }
            onUpdateSignature(z16, (String[]) obj);
            return;
        }
        if (obj != null && (obj instanceof Boolean)) {
            if (!z16 || !((Boolean) obj).booleanValue()) {
                z17 = false;
            }
            onUpdateFriendList(z16, z17);
            return;
        }
        onUpdateFriendList(z16, false);
    }

    public void addFriendByContact(boolean z16, Object[] objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 74)) {
            iPatchRedirector.redirect((short) 74, this, Boolean.valueOf(z16), objArr);
        } else if (z16 && objArr != null && objArr.length == 1) {
            onAddFriendByContact((String) objArr[0]);
        }
    }

    public void onAddBatchQIMFriend(boolean z16, List<Long> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 77)) {
            iPatchRedirector.redirect((short) 77, this, Boolean.valueOf(z16), list);
        }
    }

    public void onAddBatchTroopFrd(boolean z16, String str, ArrayList<cmd0x777$AddFrdInfo> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 78)) {
            iPatchRedirector.redirect((short) 78, this, Boolean.valueOf(z16), str, arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onAddFriend(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, (Object) str);
        }
    }

    public void onAddFriendByContact(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 75)) {
            iPatchRedirector.redirect((short) 75, (Object) this, (Object) str);
        }
    }

    protected void onAddGroupResp(boolean z16, GroupActionResp groupActionResp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Boolean.valueOf(z16), groupActionResp);
        }
    }

    public void onAgreeSuspiciousMsg(boolean z16, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 84)) {
            iPatchRedirector.redirect((short) 84, this, Boolean.valueOf(z16), Integer.valueOf(i3), Long.valueOf(j3));
        }
    }

    protected void onCancelMayKnowRecommend(boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, this, Boolean.valueOf(z16), str);
        }
    }

    protected void onCondSearchFriendResult(long j3, boolean z16, Object obj, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, this, Long.valueOf(j3), Boolean.valueOf(z16), obj, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    protected void onDelDevResult(boolean z16, String str, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, this, Boolean.valueOf(z16), str, bArr);
        }
    }

    protected void onDeleteGroupResp(boolean z16, GroupActionResp groupActionResp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Boolean.valueOf(z16), groupActionResp);
        }
    }

    protected void onGetBothDongtaiPermissions(boolean z16, boolean z17, boolean z18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18));
        }
    }

    public void onGetConnectionsPerson(boolean z16, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 85)) {
            iPatchRedirector.redirect((short) 85, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }

    protected void onGetFriendDateNick(boolean z16, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, this, Boolean.valueOf(z16), str, str2);
        }
    }

    protected void onGetFriendNickBatch(boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, this, Boolean.valueOf(z16), obj);
        }
    }

    public void onGetFriendsHasBindPhone(boolean z16, int i3, List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 76)) {
            iPatchRedirector.redirect((short) 76, this, Boolean.valueOf(z16), Integer.valueOf(i3), list);
        }
    }

    protected void onGetLoginDevResult(boolean z16, SvcRspGetDevLoginInfo svcRspGetDevLoginInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, this, Boolean.valueOf(z16), svcRspGetDevLoginInfo);
        }
    }

    protected void onGetMayKnowRecommend(boolean z16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            iPatchRedirector.redirect((short) 53, this, Boolean.valueOf(z16), bundle);
        }
    }

    protected void onGetNotAllowedSeeMyDongtai(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onGetOnlineInfoByUinOrMobile(boolean z16, long j3, String str, GetOnlineInfoResp getOnlineInfoResp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, Boolean.valueOf(z16), Long.valueOf(j3), str, getOnlineInfoResp);
        }
    }

    protected void onGetPushRecommend(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            iPatchRedirector.redirect((short) 56, (Object) this, z16);
        }
    }

    protected void onGetRecentLoginAndLoginDevResult(boolean z16, SvcRspGetDevLoginInfo svcRspGetDevLoginInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, this, Boolean.valueOf(z16), svcRspGetDevLoginInfo);
        }
    }

    protected void onGetRecommendDeviceList(boolean z16, ArrayList<com.tencent.mobileqq.antiphing.b> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, this, Boolean.valueOf(z16), arrayList);
        }
    }

    protected void onGetShieldHisDongtai(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
    }

    protected void onGetSigZanInfo(boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            iPatchRedirector.redirect((short) 62, this, Boolean.valueOf(z16), obj);
        }
    }

    protected void onGetSpecialCareRecommend(boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            iPatchRedirector.redirect((short) 59, this, Boolean.valueOf(z16), obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onGetStoreFace(boolean z16, HashSet<String> hashSet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Boolean.valueOf(z16), hashSet);
        }
    }

    protected void onGetStrangerInfo(boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, this, Boolean.valueOf(z16), obj);
        }
    }

    protected void onGetVisibilityForNetWorkStatus(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
    }

    protected void onGroupDataInited() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 70)) {
            iPatchRedirector.redirect((short) 70, (Object) this);
        }
    }

    protected void onKickOutDevFResult(boolean z16, long j3, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, this, Boolean.valueOf(z16), Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onMayKnowEntryStateChanged(boolean z16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            iPatchRedirector.redirect((short) 57, this, Boolean.valueOf(z16), bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onMayKnowListPushDel(boolean z16, List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            iPatchRedirector.redirect((short) 58, this, Boolean.valueOf(z16), list);
        }
    }

    protected void onMayknowStateChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            iPatchRedirector.redirect((short) 55, (Object) this, z16);
        }
    }

    protected void onPullIpad() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
        }
    }

    protected void onQueryUinSafetyFlag(boolean z16, long j3, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, this, Boolean.valueOf(z16), Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    protected void onRenameGroupResp(boolean z16, GroupActionResp groupActionResp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Boolean.valueOf(z16), groupActionResp);
        }
    }

    protected void onReqLastChatTime(boolean z16, String str, String str2, Long l3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            iPatchRedirector.redirect((short) 61, this, Boolean.valueOf(z16), str, str2, l3);
        }
    }

    protected void onReqRecheckInHotReactive(boolean z16, String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            iPatchRedirector.redirect((short) 60, this, Boolean.valueOf(z16), str, str2, Integer.valueOf(i3));
        }
    }

    protected void onResortGroupResp(boolean z16, GroupActionResp groupActionResp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Boolean.valueOf(z16), groupActionResp);
        }
    }

    protected void onSearchFriendResult(boolean z16, int i3, Object obj, int i16, String str, boolean z17, long j3, int i17, List<com.tencent.mobileqq.search.model.x> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, Boolean.valueOf(z16), Integer.valueOf(i3), obj, Integer.valueOf(i16), str, Boolean.valueOf(z17), Long.valueOf(j3), Integer.valueOf(i17), list);
        }
    }

    protected void onSetAsNormalContacts(boolean z16, List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, this, Boolean.valueOf(z16), list);
        }
    }

    protected void onSetAsUncommonlyUsedContacts(boolean z16, List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, this, Boolean.valueOf(z16), list);
        }
    }

    protected void onSetBothDongtaiPermissions(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, (Object) this, z16);
        }
    }

    protected void onSetComment(boolean z16, String str, String str2, byte b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, Boolean.valueOf(z16), str, str2, Byte.valueOf(b16));
        }
    }

    protected void onSetHiddenChatSwitch(boolean z16, Object[] objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 67)) {
            iPatchRedirector.redirect((short) 67, this, Boolean.valueOf(z16), objArr);
        }
    }

    protected void onSetMessageNotification(boolean z16, Object[] objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 68)) {
            iPatchRedirector.redirect((short) 68, this, Boolean.valueOf(z16), objArr);
        }
    }

    protected void onSetMessageRaoam(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, z16);
        }
    }

    protected void onSetNotAllowedSeeMyDongtai(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
    }

    protected void onSetSelfSignatureResult(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, z16);
        }
    }

    protected void onSetShieldHisDongtai(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
    }

    protected void onSetSpecialCareSwitch_global(boolean z16, Object[] objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            iPatchRedirector.redirect((short) 63, this, Boolean.valueOf(z16), objArr);
        }
    }

    protected void onSetSpecialCareSwitch_qzone(boolean z16, Object[] objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            iPatchRedirector.redirect((short) 65, this, Boolean.valueOf(z16), objArr);
        }
    }

    protected void onSetSpecialCareSwitch_specialRing(boolean z16, Object[] objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            iPatchRedirector.redirect((short) 64, this, Boolean.valueOf(z16), objArr);
        }
    }

    protected void onSetSpecialCareSwitchesOfAPerson(boolean z16, Object[] objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
            iPatchRedirector.redirect((short) 66, this, Boolean.valueOf(z16), objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSetVisibilityForNetWorkStatus(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
    }

    public void onSuspiciousClear(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 82)) {
            iPatchRedirector.redirect((short) 82, this, Boolean.valueOf(z16), Integer.valueOf(i3));
        }
    }

    public void onSuspiciousDel(boolean z16, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 81)) {
            iPatchRedirector.redirect((short) 81, this, Boolean.valueOf(z16), Integer.valueOf(i3), Long.valueOf(j3));
        }
    }

    public void onSuspiciousGetList(boolean z16, int i3, ArrayList<SysSuspiciousMsg> arrayList, byte[] bArr, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 80)) {
            iPatchRedirector.redirect((short) 80, this, Boolean.valueOf(z16), Integer.valueOf(i3), arrayList, bArr, obj);
        }
    }

    public void onSuspiciousGetUnreadNum(boolean z16, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 79)) {
            iPatchRedirector.redirect((short) 79, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    public void onSuspiciousSendReadReport(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 83)) {
            iPatchRedirector.redirect((short) 83, this, Boolean.valueOf(z16), Integer.valueOf(i3));
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public final void onUpdate(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 73)) {
            iPatchRedirector.redirect((short) 73, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        onUpdateBatch1(i3, z16, obj);
        onUpdateBatch2(i3, z16, obj);
        onUpdateBatch3(i3, z16, obj);
        onUpdateBatch4(i3, z16, obj);
        onUpdateBatch5(i3, z16, obj);
        onUpdateBatch6(i3, z16, obj);
        onUpdateBatch7(i3, z16, obj);
        onUpdateBatch8(i3, z16, obj);
        onUpdateBatch9(i3, z16, obj);
    }

    protected void onUpdateAnswerAddedFriend(boolean z16, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Boolean.valueOf(z16), str, Integer.valueOf(i3));
        }
    }

    protected void onUpdateC2ChatStatus(boolean z16, HashMap<String, String> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Boolean.valueOf(z16), hashMap);
        }
    }

    protected void onUpdateCircleRichStatus(boolean z16, String[] strArr, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(z16), strArr, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onUpdateDelFriend(boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, Boolean.valueOf(z16), obj);
        }
    }

    protected void onUpdateFriendInfo(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, str, Boolean.valueOf(z16));
        }
    }

    protected void onUpdateFriendInfoFinished(ArrayList arrayList, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, arrayList, Boolean.valueOf(z16));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onUpdateFriendList(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
    }

    protected void onUpdateFriendShieldFlag(long j3, boolean z16, boolean z17, boolean z18, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, this, Long.valueOf(j3), Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Shield", 2, "FriendShield : send_oidb_0x5d1_0 : uin : " + j3 + " isSetOrClear:" + z16 + " isSuc:" + z17 + " isPush:" + z18 + " errMsg:" + str);
        }
    }

    protected void onUpdateGatherFriendList(boolean z16, boolean z17, boolean z18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18));
        }
    }

    protected void onUpdateGetVideoAbility(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onUpdateHotFriendLevel(boolean z16, ArrayList<String> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 72)) {
            iPatchRedirector.redirect((short) 72, this, Boolean.valueOf(z16), arrayList);
        }
    }

    protected void onUpdateLastLoginInfo(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
    }

    protected void onUpdateMoveGroup(String str, byte b16, byte b17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, str, Byte.valueOf(b16), Byte.valueOf(b17));
        }
    }

    protected void onUpdateOlympicTorchList(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 71)) {
            iPatchRedirector.redirect((short) 71, (Object) this, z16);
        }
    }

    protected void onUpdateOnlineFriend(boolean z16, String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, Boolean.valueOf(z16), strArr);
        }
    }

    protected void onUpdateRecentList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    protected void onUpdateRecommGatherFriendList(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
    }

    protected void onUpdateServerAuthDeviceList(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, z16);
        }
    }

    protected void onUpdateSignature(boolean z16, String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), strArr);
        }
    }

    protected void onUpdateSpecialCareList(boolean z16, boolean z17, ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> arrayList, ArrayList<com.tencent.qqnt.ntrelation.otherinfo.bean.c> arrayList2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 69)) {
            iPatchRedirector.redirect((short) 69, this, Boolean.valueOf(z16), Boolean.valueOf(z17), arrayList, arrayList2);
        }
    }

    protected void onUpdateStrangerRichStatus(boolean z16, String[] strArr, Map<String, RichStatus> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Boolean.valueOf(z16), strArr, map);
        }
    }

    protected void onUpdateTroopHeadDownloadUrl(boolean z16, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Boolean.valueOf(z16), str, str2);
        }
    }
}
