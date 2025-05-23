package com.tencent.mobileqq.app.guard;

import com.gcore.abase.utils.PatternUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class GuardState {
    static IPatchRedirector $redirector_ = null;
    protected static final int COUNT_ACTIVE_EVENT = 3;
    public static final int COUNT_STATE = 9;
    public static final int EVENT_BG = 4;
    protected static final int EVENT_ENTER = 5;
    public static final int EVENT_FG = 3;
    public static final int EVENT_MAIN = 6;
    public static final int EVENT_MSG = 0;
    public static final int EVENT_RESUME = 1;
    public static final int EVENT_TICK = 2;
    private static final String[] NAME_EVENT;
    protected static final String[] NAME_STATE;
    public static final String PROCESS_NAME_MINIAPP = "com.tencent.mobileqq:mini";
    public static final String PROCESS_NAME_PLUGINS = "com.tencent.mobileqq:plugins";
    public static final String PROCESS_NAME_QZONE = "com.tencent.mobileqq:qzone";
    public static final String PROCESS_NAME_TOOL = "com.tencent.mobileqq:tool";
    public static final String PROCESS_NAME_ZPLAN = "com.tencent.mobileqq:zplan";
    public static final int STATE_BG_FETCH = 1;
    public static final int STATE_BG_GUARD = 4;
    public static final int STATE_BG_UNGUARD = 5;
    public static final int STATE_DEAD = 8;
    public static final int STATE_EMPTY = 0;
    public static final int STATE_FG_MAIN = 2;
    public static final int STATE_FG_OTHER = 3;
    public static final int STATE_LITE_GUARD = 6;
    public static final int STATE_LITE_UNGUARD = 7;
    protected long mClearTick;
    protected long mGuardTick;
    protected int mId;
    protected GuardManager mManager;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36966);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            NAME_STATE = new String[]{PatternUtils.NO_MATCH, "BG_FETCH", "FG_MAIN", "FG_OTHER", "BG_GUARD", "BG_UNGUARD", "LITE_GUARD", "LITE_UNGUARD", "DEAD"};
            NAME_EVENT = new String[]{"MSG", "RESUME", "TICK", "FG", "BG", "ENTER", "MAIN"};
        }
    }

    public GuardState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mId = 0;
        }
    }

    protected void onBackground(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onEnter(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        } else {
            this.mClearTick = 0L;
            this.mGuardTick = 0L;
        }
    }

    public final void onEvent(int i3, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3, obj);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(GuardManager.TAG, 2, NAME_STATE[this.mId] + " onEvent " + NAME_EVENT[i3] + ", " + obj + ", " + this.mGuardTick + ", " + this.mClearTick);
        }
        switch (i3) {
            case 0:
                onMessage();
                return;
            case 1:
                onResume((String) obj);
                return;
            case 2:
                onTick();
                return;
            case 3:
                onForground((String) obj);
                return;
            case 4:
                onBackground((String) obj);
                return;
            case 5:
                onEnter((String) obj);
                return;
            case 6:
                this.mManager.nextState(2, null);
                return;
            default:
                return;
        }
    }

    protected void onForground(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
    }

    protected void onMessage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    protected void onResume(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onTick() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.mGuardTick++;
            this.mClearTick++;
        }
    }
}
