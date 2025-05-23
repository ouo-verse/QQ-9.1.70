package com.tencent.mobileqq.troop.troopmanager.api;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b implements BusinessObserver {
    static IPatchRedirector $redirector_;
    public static final int OBSERVER_TYPE_TROOP_LINK;
    public static final int TYPE_GET_GLOBAL_TROOP_LEVEL;
    public static final int TYPE_GET_PAY_TO_JOIN_TROOP_STATUS;
    public static final int TYPE_GET_TROOP_MEMBER_MAX_NUM;
    public static final int TYPE_NOTIFY_ACTIVE_EXT_TROOP_SUCCESS;
    public static final int TYPE_NOTIFY_MODIFY_TROOP_NICK_RULE;
    public static final int TYPE_NOTIFY_TROOP_UPGRADE_SUCCESS;
    public static final int TYPE_OIDB_0X903_2;
    private static int sNotificationTypeStart;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29535);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        int i3 = 0 + 1;
        TYPE_NOTIFY_MODIFY_TROOP_NICK_RULE = 0;
        int i16 = i3 + 1;
        TYPE_GET_PAY_TO_JOIN_TROOP_STATUS = i3;
        int i17 = i16 + 1;
        TYPE_GET_TROOP_MEMBER_MAX_NUM = i16;
        int i18 = i17 + 1;
        TYPE_NOTIFY_ACTIVE_EXT_TROOP_SUCCESS = i17;
        int i19 = i18 + 1;
        TYPE_OIDB_0X903_2 = i18;
        int i26 = i19 + 1;
        OBSERVER_TYPE_TROOP_LINK = i19;
        int i27 = i26 + 1;
        TYPE_GET_GLOBAL_TROOP_LEVEL = i26;
        sNotificationTypeStart = i27 + 1;
        TYPE_NOTIFY_TROOP_UPGRADE_SUCCESS = i27;
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void onUpdate_getGlobalTroopLevel(int i3, boolean z16, Object obj) {
        if (i3 != TYPE_GET_GLOBAL_TROOP_LEVEL) {
            return;
        }
        Object[] objArr = (Object[]) obj;
        onGetGolbalTroopLevel(z16, ((Long) objArr[0]).longValue(), ((Integer) objArr[1]).intValue());
    }

    private void onUpdate_notifyActiveExtTroopSuccess(int i3, boolean z16, Object obj) {
        if (i3 == TYPE_NOTIFY_ACTIVE_EXT_TROOP_SUCCESS && (obj instanceof Object[])) {
            onActiveExtTroop(z16, (String) ((Object[]) obj)[0]);
        }
    }

    private void onUpdate_notifyModifyTroopNickRule(int i3, boolean z16, Object obj) {
        long j3;
        String str;
        if (i3 != TYPE_NOTIFY_MODIFY_TROOP_NICK_RULE) {
            return;
        }
        if (obj instanceof Object[]) {
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
                    j16 = ((Integer) obj3).intValue();
                }
                long j17 = j16;
                Object obj4 = objArr[2];
                if (obj4 instanceof String) {
                    str = (String) obj4;
                } else {
                    str = "";
                }
                onModifyTroopNickRule(z16, j3, j17, str);
                return;
            }
            onModifyTroopNickRule(false, 0L, 0L, "");
            return;
        }
        onModifyTroopNickRule(false, 0L, 0L, "");
    }

    private void onUpdate_notifyTroopUpgradeSuccess(int i3, boolean z16, Object obj) {
        if (i3 == TYPE_NOTIFY_TROOP_UPGRADE_SUCCESS && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            onNotifyTroopUpgradeSuccess((String) objArr[0], ((Integer) objArr[1]).intValue());
        }
    }

    private void onUpdate_oidb_0x903_2(int i3, boolean z16, Object obj) {
        if (i3 != TYPE_OIDB_0X903_2) {
            return;
        }
        try {
            Object[] objArr = (Object[]) obj;
            onGetInvitedUinList(z16, (Long) objArr[0], (List) objArr[1]);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("onGetInvitedUinList", 2, e16.toString());
            }
        }
    }

    private void onUpdate_troopLink(int i3, boolean z16, Object obj) {
        if (i3 != OBSERVER_TYPE_TROOP_LINK) {
            return;
        }
        onTroopShareLink(z16, (com.tencent.mobileqq.troop.troopshare.a) obj);
    }

    protected void onActiveExtTroop(boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str);
        }
    }

    protected void onGetGolbalTroopLevel(boolean z16, long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), Long.valueOf(j3), Integer.valueOf(i3));
        }
    }

    protected void onGetInvitedUinList(boolean z16, Long l3, List<Long> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), l3, list);
        }
    }

    protected void onModifyTroopNickRule(boolean z16, long j3, long j16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Long.valueOf(j3), Long.valueOf(j16), str);
        }
    }

    protected void onNotifyTroopUpgradeSuccess(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, i3);
        }
    }

    public void onTroopShareLink(boolean z16, com.tencent.mobileqq.troop.troopshare.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), aVar);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        onUpdate_notifyModifyTroopNickRule(i3, z16, obj);
        onUpdate_notifyActiveExtTroopSuccess(i3, z16, obj);
        onUpdate_oidb_0x903_2(i3, z16, obj);
        onUpdate_troopLink(i3, z16, obj);
        onUpdate_getGlobalTroopLevel(i3, z16, obj);
        onUpdate_notifyTroopUpgradeSuccess(i3, z16, obj);
    }
}
