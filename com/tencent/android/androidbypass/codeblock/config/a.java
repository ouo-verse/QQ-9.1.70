package com.tencent.android.androidbypass.codeblock.config;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0006\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\b\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\u000bR\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/android/androidbypass/codeblock/config/a;", "", "Lcom/tencent/android/androidbypass/codeblock/config/highlight/a;", DownloadInfo.spKey_Config, "e", "Lcom/tencent/android/androidbypass/codeblock/config/background/b;", "a", "Lcom/tencent/android/androidbypass/codeblock/config/bottom/b;", "b", "Lcom/tencent/android/androidbypass/codeblock/config/global/b;", "d", "Lcom/tencent/android/androidbypass/codeblock/config/c;", "c", "Lcom/tencent/android/androidbypass/codeblock/config/b;", "Lcom/tencent/android/androidbypass/codeblock/config/b;", "codeBlockStyleConfigImpl", "<init>", "()V", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final b codeBlockStyleConfigImpl;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.codeBlockStyleConfigImpl = new b();
        }
    }

    @NotNull
    public final a a(@Nullable com.tencent.android.androidbypass.codeblock.config.background.b config) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) config);
        }
        this.codeBlockStyleConfigImpl.d(config);
        return this;
    }

    @NotNull
    public final a b(@Nullable com.tencent.android.androidbypass.codeblock.config.bottom.b config) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (a) iPatchRedirector.redirect((short) 3, (Object) this, (Object) config);
        }
        this.codeBlockStyleConfigImpl.e(config);
        return this;
    }

    @NotNull
    public final c c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (c) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.codeBlockStyleConfigImpl;
    }

    @NotNull
    public final a d(@NotNull com.tencent.android.androidbypass.codeblock.config.global.b config) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (a) iPatchRedirector.redirect((short) 4, (Object) this, (Object) config);
        }
        Intrinsics.checkNotNullParameter(config, "config");
        this.codeBlockStyleConfigImpl.f(config);
        return this;
    }

    @NotNull
    public final a e(@NotNull com.tencent.android.androidbypass.codeblock.config.highlight.a config) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (a) iPatchRedirector.redirect((short) 1, (Object) this, (Object) config);
        }
        Intrinsics.checkNotNullParameter(config, "config");
        this.codeBlockStyleConfigImpl.g(config);
        return this;
    }
}
