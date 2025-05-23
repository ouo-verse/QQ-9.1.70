package com.tencent.android.androidbypass.config;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u0014\u0010\u0003\u001a\u00020\u00008\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0001\u0010\u0002\"\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\"\u0014\u0010\u000b\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\f"}, d2 = {"Lcom/tencent/android/androidbypass/config/g;", "a", "Lcom/tencent/android/androidbypass/config/g;", "BypassLog", "Lcom/tencent/android/androidbypass/config/i;", "b", "Lcom/tencent/android/androidbypass/config/i;", "BypassSoLoader", "Lcom/tencent/android/androidbypass/config/h;", "c", "Lcom/tencent/android/androidbypass/config/h;", "BypassReporter", "bypass_release"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final g f72049a;

    /* renamed from: b, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final i f72050b;

    /* renamed from: c, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final h f72051c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15080);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        BypassConfig bypassConfig = BypassConfig.f72045d;
        f72049a = bypassConfig;
        f72050b = bypassConfig;
        f72051c = bypassConfig;
    }
}
