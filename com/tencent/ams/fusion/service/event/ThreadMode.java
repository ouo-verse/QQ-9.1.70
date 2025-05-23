package com.tencent.ams.fusion.service.event;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes3.dex */
public final class ThreadMode {
    private static final /* synthetic */ ThreadMode[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final ThreadMode BACKGROUND;
    public static final ThreadMode MAIN;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55437);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ThreadMode threadMode = new ThreadMode("MAIN", 0);
        MAIN = threadMode;
        ThreadMode threadMode2 = new ThreadMode("BACKGROUND", 1);
        BACKGROUND = threadMode2;
        $VALUES = new ThreadMode[]{threadMode, threadMode2};
    }

    ThreadMode(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static ThreadMode valueOf(String str) {
        return (ThreadMode) Enum.valueOf(ThreadMode.class, str);
    }

    public static ThreadMode[] values() {
        return (ThreadMode[]) $VALUES.clone();
    }
}
