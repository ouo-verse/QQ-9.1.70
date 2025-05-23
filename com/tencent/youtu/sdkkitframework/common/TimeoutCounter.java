package com.tencent.youtu.sdkkitframework.common;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.youtu.sdkkitframework.common.StateEvent;
import com.tencent.youtu.sdkkitframework.framework.YtFSM;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TimeoutCounter {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "TimeoutCounter";
    private long elaspeTimeMs;
    private String name;
    private boolean needShowTimer;
    private boolean needTimer;
    private long targetTimeoutMs;

    public TimeoutCounter(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.elaspeTimeMs = 0L;
        this.targetTimeoutMs = 0L;
        this.needTimer = false;
        this.needShowTimer = true;
        this.name = str;
    }

    public void cancel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        YtLogger.i(TAG, this.name + " cancel");
        this.needTimer = false;
    }

    public boolean checkTimeout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (!this.needTimer || this.targetTimeoutMs <= 0 || System.currentTimeMillis() - this.elaspeTimeMs <= this.targetTimeoutMs) {
            return false;
        }
        return true;
    }

    public void init(long j3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), Boolean.valueOf(z16));
            return;
        }
        this.targetTimeoutMs = j3;
        this.needShowTimer = z16;
        YtLogger.i(TAG, this.name + " init with " + this.targetTimeoutMs);
    }

    public boolean isRunning() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        if (this.needTimer && this.targetTimeoutMs > 0) {
            return true;
        }
        return false;
    }

    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        YtLogger.i(TAG, this.name + " reset");
        this.needTimer = true;
        if (this.targetTimeoutMs > 0 && this.needShowTimer) {
            YtFSM.getInstance().sendFSMEvent(new HashMap<String, Object>() { // from class: com.tencent.youtu.sdkkitframework.common.TimeoutCounter.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TimeoutCounter.this);
                    } else {
                        put(StateEvent.Name.UI_ACTION, StateEvent.ActionValue.TIMEOUT_COUNTDOWN_BEGIN);
                        put(StateEvent.Name.COUNTDOWN_TIME, Long.valueOf(TimeoutCounter.this.targetTimeoutMs));
                    }
                }
            });
        }
        this.elaspeTimeMs = System.currentTimeMillis();
    }

    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            reset();
        }
    }
}
