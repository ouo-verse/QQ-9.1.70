package com.tencent.mobileqq.login.restart;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/login/restart/Stage;", "", "(Ljava/lang/String;I)V", "LOGOUT", "CAPTURE", "LOADING", "RESTART", "COLD_START_END", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public final class Stage {
    private static final /* synthetic */ Stage[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final Stage CAPTURE;
    public static final Stage COLD_START_END;
    public static final Stage LOADING;
    public static final Stage LOGOUT;
    public static final Stage RESTART;

    private static final /* synthetic */ Stage[] $values() {
        return new Stage[]{LOGOUT, CAPTURE, LOADING, RESTART, COLD_START_END};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24252);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        LOGOUT = new Stage("LOGOUT", 0);
        CAPTURE = new Stage("CAPTURE", 1);
        LOADING = new Stage("LOADING", 2);
        RESTART = new Stage("RESTART", 3);
        COLD_START_END = new Stage("COLD_START_END", 4);
        $VALUES = $values();
    }

    Stage(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static Stage valueOf(String str) {
        return (Stage) Enum.valueOf(Stage.class, str);
    }

    public static Stage[] values() {
        return (Stage[]) $VALUES.clone();
    }
}
