package com.tencent.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Thrower<T> {
    static IPatchRedirector $redirector_;
    private Action<T> mAction;
    private long mInterval;
    private long startTime;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface Action<T> {
        void execute(T t16);
    }

    Thrower(Action<T> action) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) action);
        } else {
            this.startTime = 0L;
            this.mAction = action;
        }
    }

    public static <T> Thrower<T> create(Action<T> action) {
        return new Thrower<>(action);
    }

    public Thrower<T> action(T t16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Thrower) iPatchRedirector.redirect((short) 3, (Object) this, (Object) t16);
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.startTime > this.mInterval) {
            this.startTime = currentTimeMillis;
            Action<T> action = this.mAction;
            if (action != null) {
                action.execute(t16);
            }
        }
        return this;
    }

    public Thrower<T> throwttle(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Thrower) iPatchRedirector.redirect((short) 2, (Object) this, j3);
        }
        this.mInterval = j3;
        return this;
    }
}
