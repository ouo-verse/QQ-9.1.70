package com.tencent.mobileqq.qqlive.base.room.service.lifecycle;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/qqlive/base/room/service/lifecycle/ActivityLifecycle;", "", "(Ljava/lang/String;I)V", "NONE", "ON_CREATE", "ON_START", "ON_RESUME", "ON_PAUSE", "ON_STOP", "ON_DESTROY", "qq-live-room-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public final class ActivityLifecycle {
    private static final /* synthetic */ ActivityLifecycle[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final ActivityLifecycle NONE;
    public static final ActivityLifecycle ON_CREATE;
    public static final ActivityLifecycle ON_DESTROY;
    public static final ActivityLifecycle ON_PAUSE;
    public static final ActivityLifecycle ON_RESUME;
    public static final ActivityLifecycle ON_START;
    public static final ActivityLifecycle ON_STOP;

    private static final /* synthetic */ ActivityLifecycle[] $values() {
        return new ActivityLifecycle[]{NONE, ON_CREATE, ON_START, ON_RESUME, ON_PAUSE, ON_STOP, ON_DESTROY};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30626);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        NONE = new ActivityLifecycle("NONE", 0);
        ON_CREATE = new ActivityLifecycle("ON_CREATE", 1);
        ON_START = new ActivityLifecycle("ON_START", 2);
        ON_RESUME = new ActivityLifecycle("ON_RESUME", 3);
        ON_PAUSE = new ActivityLifecycle("ON_PAUSE", 4);
        ON_STOP = new ActivityLifecycle("ON_STOP", 5);
        ON_DESTROY = new ActivityLifecycle("ON_DESTROY", 6);
        $VALUES = $values();
    }

    ActivityLifecycle(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static ActivityLifecycle valueOf(String str) {
        return (ActivityLifecycle) Enum.valueOf(ActivityLifecycle.class, str);
    }

    public static ActivityLifecycle[] values() {
        return (ActivityLifecycle[]) $VALUES.clone();
    }
}
