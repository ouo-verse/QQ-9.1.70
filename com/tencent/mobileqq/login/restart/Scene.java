package com.tencent.mobileqq.login.restart;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/login/restart/Scene;", "", "(Ljava/lang/String;I)V", "SWITCH_ACCOUNT", "LOGOUT", "UNKNOWN", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public final class Scene {
    private static final /* synthetic */ Scene[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final Scene LOGOUT;
    public static final Scene SWITCH_ACCOUNT;
    public static final Scene UNKNOWN;

    private static final /* synthetic */ Scene[] $values() {
        return new Scene[]{SWITCH_ACCOUNT, LOGOUT, UNKNOWN};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24249);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        SWITCH_ACCOUNT = new Scene("SWITCH_ACCOUNT", 0);
        LOGOUT = new Scene("LOGOUT", 1);
        UNKNOWN = new Scene("UNKNOWN", 2);
        $VALUES = $values();
    }

    Scene(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static Scene valueOf(String str) {
        return (Scene) Enum.valueOf(Scene.class, str);
    }

    public static Scene[] values() {
        return (Scene[]) $VALUES.clone();
    }
}
