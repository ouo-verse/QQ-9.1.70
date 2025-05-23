package com.tencent.android.androidbypass.codeblock.config;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0016R\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u001b\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010!\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/android/androidbypass/codeblock/config/b;", "Lcom/tencent/android/androidbypass/codeblock/config/c;", "Lcom/tencent/android/androidbypass/codeblock/config/global/b;", "getGlobalConfig", "Lcom/tencent/android/androidbypass/codeblock/config/highlight/a;", "b", "Lcom/tencent/android/androidbypass/codeblock/config/bottom/b;", "a", "Lcom/tencent/android/androidbypass/codeblock/config/background/b;", "c", "Lcom/tencent/android/androidbypass/codeblock/config/global/b;", "getCodeBlockGlobalConfig", "()Lcom/tencent/android/androidbypass/codeblock/config/global/b;", "f", "(Lcom/tencent/android/androidbypass/codeblock/config/global/b;)V", "codeBlockGlobalConfig", "Lcom/tencent/android/androidbypass/codeblock/config/highlight/a;", "getCodeBlockHighlightConfig", "()Lcom/tencent/android/androidbypass/codeblock/config/highlight/a;", "g", "(Lcom/tencent/android/androidbypass/codeblock/config/highlight/a;)V", "codeBlockHighlightConfig", "Lcom/tencent/android/androidbypass/codeblock/config/background/b;", "getCodeBlockBackgroundConfig", "()Lcom/tencent/android/androidbypass/codeblock/config/background/b;", "d", "(Lcom/tencent/android/androidbypass/codeblock/config/background/b;)V", "codeBlockBackgroundConfig", "Lcom/tencent/android/androidbypass/codeblock/config/bottom/b;", "getCodeBlockBottomConfig", "()Lcom/tencent/android/androidbypass/codeblock/config/bottom/b;", "e", "(Lcom/tencent/android/androidbypass/codeblock/config/bottom/b;)V", "codeBlockBottomConfig", "<init>", "()V", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class b implements c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public com.tencent.android.androidbypass.codeblock.config.global.b codeBlockGlobalConfig;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public com.tencent.android.androidbypass.codeblock.config.highlight.a codeBlockHighlightConfig;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.android.androidbypass.codeblock.config.background.b codeBlockBackgroundConfig;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.android.androidbypass.codeblock.config.bottom.b codeBlockBottomConfig;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        }
    }

    @Override // com.tencent.android.androidbypass.codeblock.config.c
    @Nullable
    public com.tencent.android.androidbypass.codeblock.config.bottom.b a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (com.tencent.android.androidbypass.codeblock.config.bottom.b) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.codeBlockBottomConfig;
    }

    @Override // com.tencent.android.androidbypass.codeblock.config.c
    @NotNull
    public com.tencent.android.androidbypass.codeblock.config.highlight.a b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (com.tencent.android.androidbypass.codeblock.config.highlight.a) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        com.tencent.android.androidbypass.codeblock.config.highlight.a aVar = this.codeBlockHighlightConfig;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("codeBlockHighlightConfig");
        }
        return aVar;
    }

    @Override // com.tencent.android.androidbypass.codeblock.config.c
    @Nullable
    public com.tencent.android.androidbypass.codeblock.config.background.b c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (com.tencent.android.androidbypass.codeblock.config.background.b) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.codeBlockBackgroundConfig;
    }

    public final void d(@Nullable com.tencent.android.androidbypass.codeblock.config.background.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) bVar);
        } else {
            this.codeBlockBackgroundConfig = bVar;
        }
    }

    public final void e(@Nullable com.tencent.android.androidbypass.codeblock.config.bottom.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) bVar);
        } else {
            this.codeBlockBottomConfig = bVar;
        }
    }

    public final void f(@NotNull com.tencent.android.androidbypass.codeblock.config.global.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar);
        } else {
            Intrinsics.checkNotNullParameter(bVar, "<set-?>");
            this.codeBlockGlobalConfig = bVar;
        }
    }

    public final void g(@NotNull com.tencent.android.androidbypass.codeblock.config.highlight.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
        } else {
            Intrinsics.checkNotNullParameter(aVar, "<set-?>");
            this.codeBlockHighlightConfig = aVar;
        }
    }

    @Override // com.tencent.android.androidbypass.codeblock.config.c
    @NotNull
    public com.tencent.android.androidbypass.codeblock.config.global.b getGlobalConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (com.tencent.android.androidbypass.codeblock.config.global.b) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        com.tencent.android.androidbypass.codeblock.config.global.b bVar = this.codeBlockGlobalConfig;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("codeBlockGlobalConfig");
        }
        return bVar;
    }
}
