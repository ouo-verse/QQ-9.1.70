package com.tencent.mobileqq.troop.troopgame.api;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.troopgame.data.ProfileGameInfo;
import com.tencent.mobileqq.troop.troopgame.data.TroopGameActivityInfo;
import com.tencent.mobileqq.troop.troopgame.data.TroopGameInfo;
import com.tencent.mobileqq.troop.troopgame.data.TroopMetaDreamGameInfo;
import com.tencent.trpcprotocol.gamecenter.QqCardSvrPB$GetSwitchRsp;
import com.tencent.trpcprotocol.gamecenter.QqCardSvrPB$SetSwitchRsp;
import com.tencent.trpcprotocol.gamecenter.QqCardSvrPB$ShowQuickAuthorizeRsp;
import com.tencent.trpcprotocol.gamecenter.metadream.metadream_qgroup_datacard$GetGroupUserInfoRsp;
import com.tencent.trpcprotocol.gamecenter.metadream.metadream_qgroup_datacard$GetGroupUserSwitchRsp;
import com.tencent.trpcprotocol.gamecenter.metadream.metadream_qgroup_datacard$SetGroupUserSwitchRsp;
import com.tencent.trpcprotocol.gamecenter.sgameSkinWall.sgame_skin_wall$MDUserProfile;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b implements BusinessObserver {
    static IPatchRedirector $redirector_;
    public static final int TYPE_GET_TROOP_GAME_ACTIVITY_INFO;
    public static final int TYPE_NOTIFY_GET_MEMBER_GAME_CARD;
    public static final int TYPE_NOTIFY_GET_MEMBER_GAME_CARD_SWITCH;
    public static final int TYPE_NOTIFY_GET_MEMBER_GAME_INFO_QUICK_AUTH;
    public static final int TYPE_NOTIFY_GET_MEMBER_GAME_INFO_SWITCH;
    public static final int TYPE_NOTIFY_GET_MEMBER_META_DREAM_SWITCH;
    public static final int TYPE_NOTIFY_GET_MEMBER_YUAN_MENG_CARD;
    public static final int TYPE_NOTIFY_GET_TROOP_GAME_CARD;
    public static final int TYPE_NOTIFY_GET_TROOP_MEMBER_META_DREAM_CARD;
    public static final int TYPE_NOTIFY_GET_TROOP_META_DREAM_CARD;
    public static final int TYPE_NOTIFY_MODIFY_MEMBER_GAME_CARD_SWITCH;
    public static final int TYPE_NOTIFY_MODIFY_TROOP_GAME_CARD_SWITCH;
    public static final int TYPE_NOTIFY_SET_MEMBER_GAME_INFO_SWITCH;
    public static final int TYPE_NOTIFY_SET_MEMBER_META_DREAM_SWITCH;
    private static int sNotificationTypeStart;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29511);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
            return;
        }
        int i3 = 0 + 1;
        TYPE_NOTIFY_MODIFY_TROOP_GAME_CARD_SWITCH = 0;
        int i16 = i3 + 1;
        TYPE_NOTIFY_GET_MEMBER_GAME_CARD = i3;
        int i17 = i16 + 1;
        TYPE_NOTIFY_GET_MEMBER_YUAN_MENG_CARD = i16;
        int i18 = i17 + 1;
        TYPE_NOTIFY_MODIFY_MEMBER_GAME_CARD_SWITCH = i17;
        int i19 = i18 + 1;
        TYPE_NOTIFY_GET_MEMBER_GAME_CARD_SWITCH = i18;
        int i26 = i19 + 1;
        TYPE_NOTIFY_GET_TROOP_GAME_CARD = i19;
        int i27 = i26 + 1;
        TYPE_GET_TROOP_GAME_ACTIVITY_INFO = i26;
        int i28 = i27 + 1;
        TYPE_NOTIFY_GET_TROOP_META_DREAM_CARD = i27;
        int i29 = i28 + 1;
        TYPE_NOTIFY_GET_TROOP_MEMBER_META_DREAM_CARD = i28;
        int i36 = i29 + 1;
        TYPE_NOTIFY_GET_MEMBER_META_DREAM_SWITCH = i29;
        int i37 = i36 + 1;
        TYPE_NOTIFY_SET_MEMBER_META_DREAM_SWITCH = i36;
        int i38 = i37 + 1;
        TYPE_NOTIFY_GET_MEMBER_GAME_INFO_SWITCH = i37;
        int i39 = i38 + 1;
        TYPE_NOTIFY_SET_MEMBER_GAME_INFO_SWITCH = i38;
        sNotificationTypeStart = i39 + 1;
        TYPE_NOTIFY_GET_MEMBER_GAME_INFO_QUICK_AUTH = i39;
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void onUpdate_notifyGetGameInfoSwitch(int i3, boolean z16, Object obj) {
        String str;
        QqCardSvrPB$GetSwitchRsp qqCardSvrPB$GetSwitchRsp;
        boolean z17;
        if (i3 != TYPE_NOTIFY_GET_MEMBER_GAME_INFO_SWITCH) {
            return;
        }
        boolean z18 = true;
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 2) {
                str = (String) objArr[0];
                qqCardSvrPB$GetSwitchRsp = (QqCardSvrPB$GetSwitchRsp) objArr[1];
                z17 = true;
                if (z16 || !z17) {
                    z18 = false;
                }
                onGetGameInfoCardSwitch(z18, str, qqCardSvrPB$GetSwitchRsp);
            }
        }
        str = null;
        qqCardSvrPB$GetSwitchRsp = null;
        z17 = false;
        if (z16) {
        }
        z18 = false;
        onGetGameInfoCardSwitch(z18, str, qqCardSvrPB$GetSwitchRsp);
    }

    private void onUpdate_notifyGetMemberGameCard(int i3, boolean z16, Object obj) {
        String str;
        String str2;
        if (i3 != TYPE_NOTIFY_GET_MEMBER_GAME_CARD) {
            return;
        }
        ProfileGameInfo profileGameInfo = null;
        if (obj != null && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 3) {
                Object obj2 = objArr[0];
                if (obj2 instanceof String) {
                    str = (String) obj2;
                } else {
                    str = null;
                }
                Object obj3 = objArr[1];
                if (obj3 instanceof String) {
                    str2 = (String) obj3;
                } else {
                    str2 = null;
                }
                Object obj4 = objArr[2];
                if (obj4 instanceof ProfileGameInfo) {
                    profileGameInfo = (ProfileGameInfo) obj4;
                }
                onGetTroopMemberGameCard(z16, str, str2, profileGameInfo);
                return;
            }
            onGetTroopMemberGameCard(z16, null, null, null);
            return;
        }
        onGetTroopMemberGameCard(z16, null, null, null);
    }

    private void onUpdate_notifyGetMemberGameCardSwitch(int i3, boolean z16, Object obj) {
        if (i3 != TYPE_NOTIFY_GET_MEMBER_GAME_CARD_SWITCH) {
            return;
        }
        if (obj != null && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 3) {
                Long l3 = 0L;
                Object obj2 = objArr[0];
                if (obj2 instanceof Long) {
                    l3 = (Long) obj2;
                }
                Long l16 = 0L;
                Object obj3 = objArr[1];
                if (obj3 instanceof Long) {
                    l16 = (Long) obj3;
                }
                Long l17 = 0L;
                Object obj4 = objArr[2];
                if (obj4 instanceof Long) {
                    l17 = (Long) obj4;
                }
                onGetMemberGameCardSwitch(z16, l3.longValue(), l16.longValue(), l17.longValue());
                return;
            }
            onGetMemberGameCardSwitch(false, 0L, 0L, 0L);
            return;
        }
        onGetMemberGameCardSwitch(false, 0L, 0L, 0L);
    }

    private void onUpdate_notifyGetMemberYuanMengCard(int i3, boolean z16, Object obj) {
        String str;
        String str2;
        if (i3 != TYPE_NOTIFY_GET_MEMBER_YUAN_MENG_CARD) {
            return;
        }
        sgame_skin_wall$MDUserProfile sgame_skin_wall_mduserprofile = null;
        if (obj != null && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 3) {
                Object obj2 = objArr[0];
                if (obj2 instanceof String) {
                    str = (String) obj2;
                } else {
                    str = null;
                }
                Object obj3 = objArr[1];
                if (obj3 instanceof String) {
                    str2 = (String) obj3;
                } else {
                    str2 = null;
                }
                Object obj4 = objArr[2];
                if (obj4 instanceof sgame_skin_wall$MDUserProfile) {
                    sgame_skin_wall_mduserprofile = (sgame_skin_wall$MDUserProfile) obj4;
                }
                onGetTroopMemberYuanMengCard(z16, str, str2, sgame_skin_wall_mduserprofile);
                return;
            }
            onGetTroopMemberYuanMengCard(z16, null, null, null);
            return;
        }
        onGetTroopMemberYuanMengCard(z16, null, null, null);
    }

    private void onUpdate_notifyGetMyGameInfoQuickAuth(int i3, boolean z16, Object obj) {
        QqCardSvrPB$ShowQuickAuthorizeRsp qqCardSvrPB$ShowQuickAuthorizeRsp;
        boolean z17;
        if (i3 != TYPE_NOTIFY_GET_MEMBER_GAME_INFO_QUICK_AUTH) {
            return;
        }
        boolean z18 = true;
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 1) {
                qqCardSvrPB$ShowQuickAuthorizeRsp = (QqCardSvrPB$ShowQuickAuthorizeRsp) objArr[0];
                z17 = true;
                if (z16 || !z17) {
                    z18 = false;
                }
                onGetMyGameInfoQuickAuth(z18, qqCardSvrPB$ShowQuickAuthorizeRsp);
            }
        }
        qqCardSvrPB$ShowQuickAuthorizeRsp = null;
        z17 = false;
        if (z16) {
        }
        z18 = false;
        onGetMyGameInfoQuickAuth(z18, qqCardSvrPB$ShowQuickAuthorizeRsp);
    }

    private void onUpdate_notifyGetMyMetaDreamSwitch(int i3, boolean z16, Object obj) {
        String str;
        metadream_qgroup_datacard$GetGroupUserSwitchRsp metadream_qgroup_datacard_getgroupuserswitchrsp;
        boolean z17;
        if (i3 != TYPE_NOTIFY_GET_MEMBER_META_DREAM_SWITCH) {
            return;
        }
        boolean z18 = true;
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 3) {
                str = (String) objArr[0];
                metadream_qgroup_datacard_getgroupuserswitchrsp = (metadream_qgroup_datacard$GetGroupUserSwitchRsp) objArr[2];
                z17 = true;
                if (z16 || !z17) {
                    z18 = false;
                }
                onGetMyMetaDreamCardSwitch(z18, str, metadream_qgroup_datacard_getgroupuserswitchrsp);
            }
        }
        str = null;
        metadream_qgroup_datacard_getgroupuserswitchrsp = null;
        z17 = false;
        if (z16) {
        }
        z18 = false;
        onGetMyMetaDreamCardSwitch(z18, str, metadream_qgroup_datacard_getgroupuserswitchrsp);
    }

    private void onUpdate_notifyGetTroopGameActivityInfo(int i3, boolean z16, Object obj) {
        String str;
        if (i3 != TYPE_GET_TROOP_GAME_ACTIVITY_INFO) {
            return;
        }
        int i16 = 0;
        TroopGameActivityInfo troopGameActivityInfo = null;
        if (obj != null) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 3) {
                Object obj2 = objArr[0];
                if (obj2 instanceof String) {
                    str = (String) obj2;
                } else {
                    str = null;
                }
                Object obj3 = objArr[1];
                if (obj3 instanceof Integer) {
                    i16 = ((Integer) obj3).intValue();
                }
                Object obj4 = objArr[2];
                if (obj4 instanceof TroopGameActivityInfo) {
                    troopGameActivityInfo = (TroopGameActivityInfo) obj4;
                }
                onGetTroopGameActivityInfo(str, i16, troopGameActivityInfo);
                return;
            }
            onGetTroopGameActivityInfo(null, 0, null);
            return;
        }
        onGetTroopGameActivityInfo(null, 0, null);
    }

    private void onUpdate_notifyGetTroopGameCard(int i3, boolean z16, Object obj) {
        if (i3 != TYPE_NOTIFY_GET_TROOP_GAME_CARD) {
            return;
        }
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 2) {
                Object obj2 = objArr[0];
                if (obj2 instanceof String) {
                    Object obj3 = objArr[1];
                    if (obj3 instanceof TroopGameInfo) {
                        onGetTroopGameGameCard(z16, (String) obj2, (TroopGameInfo) obj3);
                        return;
                    } else {
                        onGetTroopGameGameCard(z16, (String) obj2, null);
                        return;
                    }
                }
            }
            onGetTroopGameGameCard(z16, null, null);
            return;
        }
        onGetTroopGameGameCard(z16, null, null);
    }

    private void onUpdate_notifyGetTroopMemberMetaDreamCard(int i3, boolean z16, Object obj) {
        String str;
        metadream_qgroup_datacard$GetGroupUserInfoRsp metadream_qgroup_datacard_getgroupuserinforsp;
        String str2;
        boolean z17;
        if (i3 != TYPE_NOTIFY_GET_TROOP_MEMBER_META_DREAM_CARD) {
            return;
        }
        boolean z18 = true;
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 3) {
                str = (String) objArr[0];
                str2 = (String) objArr[1];
                metadream_qgroup_datacard_getgroupuserinforsp = (metadream_qgroup_datacard$GetGroupUserInfoRsp) objArr[2];
                z17 = true;
                if (z16 || !z17) {
                    z18 = false;
                }
                onGetTroopMemberMetaDreamCard(z18, str, str2, metadream_qgroup_datacard_getgroupuserinforsp);
            }
        }
        str = null;
        metadream_qgroup_datacard_getgroupuserinforsp = null;
        str2 = null;
        z17 = false;
        if (z16) {
        }
        z18 = false;
        onGetTroopMemberMetaDreamCard(z18, str, str2, metadream_qgroup_datacard_getgroupuserinforsp);
    }

    private void onUpdate_notifyGetTroopMetaDreamCard(int i3, boolean z16, Object obj) {
        if (i3 != TYPE_NOTIFY_GET_TROOP_META_DREAM_CARD) {
            return;
        }
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 2) {
                Object obj2 = objArr[0];
                if (obj2 instanceof String) {
                    Object obj3 = objArr[1];
                    if (obj3 instanceof TroopMetaDreamGameInfo) {
                        onGetTroopGameMetaDreamCard(z16, (String) obj2, (TroopMetaDreamGameInfo) obj3);
                        return;
                    } else {
                        onGetTroopGameMetaDreamCard(z16, (String) obj2, null);
                        return;
                    }
                }
            }
            onGetTroopGameMetaDreamCard(z16, null, null);
            return;
        }
        onGetTroopGameMetaDreamCard(z16, null, null);
    }

    private void onUpdate_notifyModifyMemberGameCardSwitch(int i3, boolean z16, Object obj) {
        String str;
        if (i3 != TYPE_NOTIFY_MODIFY_MEMBER_GAME_CARD_SWITCH) {
            return;
        }
        if (obj != null && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 3) {
                Long l3 = 0L;
                Object obj2 = objArr[0];
                if (obj2 instanceof Long) {
                    l3 = (Long) obj2;
                }
                Long l16 = 0L;
                Object obj3 = objArr[1];
                if (obj3 instanceof Long) {
                    l16 = (Long) obj3;
                }
                Object obj4 = objArr[2];
                if (obj4 instanceof String) {
                    str = (String) obj4;
                } else {
                    str = "";
                }
                onModifyMemberGameCardSwitch(z16, l3.longValue(), l16.longValue(), str);
                return;
            }
            onModifyMemberGameCardSwitch(false, 0L, 0L, "");
            return;
        }
        onModifyMemberGameCardSwitch(false, 0L, 0L, "");
    }

    private void onUpdate_notifyModifyTroopGameCardSwitch(int i3, boolean z16, Object obj) {
        long j3;
        String str;
        if (i3 != TYPE_NOTIFY_MODIFY_TROOP_GAME_CARD_SWITCH) {
            return;
        }
        if (obj != null && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 3) {
                Object obj2 = objArr[0];
                long j16 = 0;
                if (obj2 instanceof Long) {
                    j3 = ((Long) obj2).longValue();
                } else {
                    j3 = 0;
                }
                Object obj3 = objArr[1];
                if (obj3 instanceof Integer) {
                    j16 = ((Integer) obj3).longValue();
                }
                long j17 = j16;
                Object obj4 = objArr[2];
                if (obj4 instanceof String) {
                    str = (String) obj4;
                } else {
                    str = "";
                }
                onModifyTroopGameCardSwitch(z16, j3, j17, str);
                return;
            }
            onModifyTroopGameCardSwitch(false, 0L, 0L, "");
            return;
        }
        onModifyTroopGameCardSwitch(false, 0L, 0L, "");
    }

    private void onUpdate_notifySetMyGameInfoSwitch(int i3, boolean z16, Object obj) {
        QqCardSvrPB$SetSwitchRsp qqCardSvrPB$SetSwitchRsp;
        boolean z17;
        if (i3 != TYPE_NOTIFY_SET_MEMBER_GAME_INFO_SWITCH) {
            return;
        }
        boolean z18 = true;
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 1) {
                qqCardSvrPB$SetSwitchRsp = (QqCardSvrPB$SetSwitchRsp) objArr[0];
                z17 = true;
                if (z16 || !z17) {
                    z18 = false;
                }
                onSetMyGameInfoCardSwitch(z18, qqCardSvrPB$SetSwitchRsp);
            }
        }
        qqCardSvrPB$SetSwitchRsp = null;
        z17 = false;
        if (z16) {
        }
        z18 = false;
        onSetMyGameInfoCardSwitch(z18, qqCardSvrPB$SetSwitchRsp);
    }

    private void onUpdate_notifySetMyMetaDreamSwitch(int i3, boolean z16, Object obj) {
        String str;
        metadream_qgroup_datacard$SetGroupUserSwitchRsp metadream_qgroup_datacard_setgroupuserswitchrsp;
        boolean z17;
        if (i3 != TYPE_NOTIFY_SET_MEMBER_META_DREAM_SWITCH) {
            return;
        }
        boolean z18 = true;
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 3) {
                str = (String) objArr[0];
                metadream_qgroup_datacard_setgroupuserswitchrsp = (metadream_qgroup_datacard$SetGroupUserSwitchRsp) objArr[2];
                z17 = true;
                if (z16 || !z17) {
                    z18 = false;
                }
                onSetMyMetaDreamCardSwitch(z18, str, metadream_qgroup_datacard_setgroupuserswitchrsp);
            }
        }
        str = null;
        metadream_qgroup_datacard_setgroupuserswitchrsp = null;
        z17 = false;
        if (z16) {
        }
        z18 = false;
        onSetMyMetaDreamCardSwitch(z18, str, metadream_qgroup_datacard_setgroupuserswitchrsp);
    }

    protected void onGetGameInfoCardSwitch(boolean z16, String str, QqCardSvrPB$GetSwitchRsp qqCardSvrPB$GetSwitchRsp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Boolean.valueOf(z16), str, qqCardSvrPB$GetSwitchRsp);
        }
    }

    protected void onGetMemberGameCardSwitch(boolean z16, long j3, long j16, long j17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(z16), Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17));
        }
    }

    protected void onGetMyGameInfoQuickAuth(boolean z16, QqCardSvrPB$ShowQuickAuthorizeRsp qqCardSvrPB$ShowQuickAuthorizeRsp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Boolean.valueOf(z16), qqCardSvrPB$ShowQuickAuthorizeRsp);
        }
    }

    protected void onGetMyMetaDreamCardSwitch(boolean z16, String str, metadream_qgroup_datacard$GetGroupUserSwitchRsp metadream_qgroup_datacard_getgroupuserswitchrsp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Boolean.valueOf(z16), str, metadream_qgroup_datacard_getgroupuserswitchrsp);
        }
    }

    public void onGetTroopGameActivityInfo(String str, int i3, TroopGameActivityInfo troopGameActivityInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, str, Integer.valueOf(i3), troopGameActivityInfo);
        }
    }

    protected void onGetTroopGameGameCard(boolean z16, String str, TroopGameInfo troopGameInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, troopGameInfo);
        }
    }

    protected void onGetTroopGameMetaDreamCard(boolean z16, String str, TroopMetaDreamGameInfo troopMetaDreamGameInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str, troopMetaDreamGameInfo);
        }
    }

    protected void onGetTroopMemberGameCard(boolean z16, String str, String str2, ProfileGameInfo profileGameInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), str, str2, profileGameInfo);
        }
    }

    protected void onGetTroopMemberMetaDreamCard(boolean z16, String str, String str2, metadream_qgroup_datacard$GetGroupUserInfoRsp metadream_qgroup_datacard_getgroupuserinforsp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), str, str2, metadream_qgroup_datacard_getgroupuserinforsp);
        }
    }

    protected void onGetTroopMemberYuanMengCard(boolean z16, String str, String str2, sgame_skin_wall$MDUserProfile sgame_skin_wall_mduserprofile) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), str, str2, sgame_skin_wall_mduserprofile);
        }
    }

    protected void onModifyMemberGameCardSwitch(boolean z16, long j3, long j16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), Long.valueOf(j3), Long.valueOf(j16), str);
        }
    }

    protected void onModifyTroopGameCardSwitch(boolean z16, long j3, long j16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Boolean.valueOf(z16), Long.valueOf(j3), Long.valueOf(j16), str);
        }
    }

    protected void onSetMyGameInfoCardSwitch(boolean z16, QqCardSvrPB$SetSwitchRsp qqCardSvrPB$SetSwitchRsp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Boolean.valueOf(z16), qqCardSvrPB$SetSwitchRsp);
        }
    }

    protected void onSetMyMetaDreamCardSwitch(boolean z16, String str, metadream_qgroup_datacard$SetGroupUserSwitchRsp metadream_qgroup_datacard_setgroupuserswitchrsp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Boolean.valueOf(z16), str, metadream_qgroup_datacard_setgroupuserswitchrsp);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        onUpdate_notifyGetTroopGameCard(i3, z16, obj);
        onUpdate_notifyGetTroopMetaDreamCard(i3, z16, obj);
        onUpdate_notifyGetMyMetaDreamSwitch(i3, z16, obj);
        onUpdate_notifySetMyMetaDreamSwitch(i3, z16, obj);
        onUpdate_notifySetMyMetaDreamSwitch(i3, z16, obj);
        onUpdate_notifyGetTroopMemberMetaDreamCard(i3, z16, obj);
        onUpdate_notifyGetMemberYuanMengCard(i3, z16, obj);
        onUpdate_notifyGetMemberGameCard(i3, z16, obj);
        onUpdate_notifyModifyMemberGameCardSwitch(i3, z16, obj);
        onUpdate_notifyGetMemberGameCardSwitch(i3, z16, obj);
        onUpdate_notifyModifyTroopGameCardSwitch(i3, z16, obj);
        onUpdate_notifyGetTroopGameActivityInfo(i3, z16, obj);
        onUpdate_notifyGetGameInfoSwitch(i3, z16, obj);
        onUpdate_notifySetMyGameInfoSwitch(i3, z16, obj);
        onUpdate_notifyGetMyGameInfoQuickAuth(i3, z16, obj);
    }
}
