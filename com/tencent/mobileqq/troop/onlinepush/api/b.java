package com.tencent.mobileqq.troop.onlinepush.api;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.entereffect.f;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b implements BusinessObserver {
    static IPatchRedirector $redirector_;
    public static final int TYPE_NOTIFY_TROOP_ENTER_EFFECT_PUSH;
    public static final int TYPE_NOTIFY_TROOP_MEMBER_CHANGED;
    public static final int TYPE_NOTIFY_TROOP_REWARD_CHANGE;
    public static final int TYPE_NOTIFY_UPDATE_TITLE_BTN_CALL;
    public static final int TYPE_TROOP_BLOCK_STATUS_CHANGED;
    public static final int TYPE_TROOP_DISCUSS_TO_TROOP_CHANGED;
    public static final int TYPE_TROOP_NEW_FEED_NEED_AUTO_PULL_DOWN;
    public static final int TYPE_TROOP_RANK_SWITCH_CHANGE;
    private static int sNotificationTypeStart;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28815);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
            return;
        }
        int i3 = 0 + 1;
        TYPE_NOTIFY_TROOP_ENTER_EFFECT_PUSH = 0;
        int i16 = i3 + 1;
        TYPE_NOTIFY_TROOP_MEMBER_CHANGED = i3;
        int i17 = i16 + 1;
        TYPE_NOTIFY_TROOP_REWARD_CHANGE = i16;
        int i18 = i17 + 1;
        TYPE_TROOP_NEW_FEED_NEED_AUTO_PULL_DOWN = i17;
        int i19 = i18 + 1;
        TYPE_NOTIFY_UPDATE_TITLE_BTN_CALL = i18;
        int i26 = i19 + 1;
        TYPE_TROOP_RANK_SWITCH_CHANGE = i19;
        int i27 = i26 + 1;
        TYPE_TROOP_BLOCK_STATUS_CHANGED = i26;
        sNotificationTypeStart = i27 + 1;
        TYPE_TROOP_DISCUSS_TO_TROOP_CHANGED = i27;
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void onUpdate_notifyTroopEnterEffectPush(int i3, boolean z16, Object obj) {
        if (i3 != TYPE_NOTIFY_TROOP_ENTER_EFFECT_PUSH) {
            return;
        }
        onPushTroopEnterEffect((f) obj);
    }

    private void onUpdate_notifyTroopRankSwitchUpdate(int i3, boolean z16, Object obj) {
        if (i3 == TYPE_TROOP_RANK_SWITCH_CHANGE && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length >= 2) {
                onTroopRankSwitchUpdate((String) objArr[0], ((Boolean) objArr[1]).booleanValue());
            }
        }
    }

    private void onUpdate_notifyTroopRewardChange(int i3, boolean z16, Object obj) {
        if (i3 != TYPE_NOTIFY_TROOP_REWARD_CHANGE) {
            return;
        }
        Object[] objArr = (Object[]) obj;
        onTroopRewardChangeNotify((String) objArr[0], (String) objArr[1]);
    }

    private void onUpdate_notifyUpdateTitleBtnCall(int i3, boolean z16, Object obj) {
        if (i3 != TYPE_NOTIFY_UPDATE_TITLE_BTN_CALL) {
            return;
        }
        onNotifyUpdateTitleBtnCall(z16, obj);
    }

    private void onUpdate_notify_DiscussToTroop(int i3, boolean z16, Object obj) {
        if (i3 == TYPE_TROOP_DISCUSS_TO_TROOP_CHANGED && z16 && obj != null) {
            String[] strArr = (String[]) obj;
            onDiscussToTroopChanged(strArr[0], strArr[1]);
        }
    }

    private void onUpdate_notify_TroopBlocked(int i3, boolean z16, Object obj) {
        if (i3 == TYPE_TROOP_BLOCK_STATUS_CHANGED && obj != null && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 1) {
                onTroopBlockStatusChanged((String) objArr[0]);
            }
        }
    }

    private void onUpdate_troopNewFeedNeedAutoPullDown(int i3, boolean z16, Object obj) {
        if (i3 == TYPE_TROOP_NEW_FEED_NEED_AUTO_PULL_DOWN && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 3) {
                onTroopNewFeedsAutoPullDown(z16, (String) objArr[0], (String) objArr[1], ((Integer) objArr[2]).intValue());
            }
        }
    }

    protected void onDiscussToTroopChanged(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) str2);
        }
    }

    protected void onNotifyUpdateTitleBtnCall(boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), obj);
        }
    }

    protected void onPushTroopEnterEffect(f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) fVar);
        }
    }

    protected void onTroopBlockStatusChanged(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        }
    }

    protected void onTroopNewFeedsAutoPullDown(boolean z16, String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), str, str2, Integer.valueOf(i3));
        }
    }

    protected void onTroopRankSwitchUpdate(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, Boolean.valueOf(z16));
        }
    }

    protected void onTroopRewardChangeNotify(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        onUpdate_notifyTroopEnterEffectPush(i3, z16, obj);
        onUpdate_notifyTroopRewardChange(i3, z16, obj);
        onUpdate_troopNewFeedNeedAutoPullDown(i3, z16, obj);
        onUpdate_notifyUpdateTitleBtnCall(i3, z16, obj);
        onUpdate_notifyTroopRankSwitchUpdate(i3, z16, obj);
        onUpdate_notify_TroopBlocked(i3, z16, obj);
        onUpdate_notify_DiscussToTroop(i3, z16, obj);
    }
}
