package com.tencent.android.androidbypass.config;

import com.tencent.android.androidbypass.BypassSoEngine;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 \u000b2\u00020\u0001:\u0001\u0003B\u0015\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\f"}, d2 = {"Lcom/tencent/android/androidbypass/config/e;", "Lcom/tencent/android/androidbypass/config/i;", "", "a", "Lkotlin/Function0;", "Lkotlin/jvm/functions/Function0;", "getImpl", "()Lkotlin/jvm/functions/Function0;", "impl", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "c", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class e implements i {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static volatile boolean f72062b;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<i> impl;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/android/androidbypass/config/e$a;", "", "Lcom/tencent/android/androidbypass/config/i;", "loader", "", "b", "soLoaded", "Z", "a", "()Z", "c", "(Z)V", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "bypass_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.android.androidbypass.config.e$a, reason: from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this);
        }

        public final boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return e.f72062b;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 1, (Object) this)).booleanValue();
        }

        public final synchronized boolean b(@NotNull i loader) {
            Object m476constructorimpl;
            String stackTraceToString;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) loader)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(loader, "loader");
            if (a()) {
                return true;
            }
            try {
                Result.Companion companion = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(Boolean.valueOf(loader.a()));
            } catch (Throwable th5) {
                Result.Companion companion2 = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
            Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
            if (m479exceptionOrNullimpl != null) {
                g gVar = a.f72049a;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("loadBypassLibrary error: ");
                stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(m479exceptionOrNullimpl);
                sb5.append(stackTraceToString);
                gVar.e("BypassSoLoader", sb5.toString());
                m476constructorimpl = Boolean.FALSE;
            }
            boolean booleanValue = ((Boolean) m476constructorimpl).booleanValue();
            a.f72049a.i("BypassSoLoader", "loadBypassLibrary: " + booleanValue);
            if (booleanValue) {
                c(true);
                BypassSoEngine.INSTANCE.start();
            }
            return booleanValue;
        }

        public final void c(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                e.f72062b = z16;
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15407);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(@NotNull Function0<? extends i> impl) {
        Intrinsics.checkNotNullParameter(impl, "impl");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) impl);
        } else {
            this.impl = impl;
        }
    }

    @Override // com.tencent.android.androidbypass.config.i
    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Boolean) iPatchRedirector.redirect((short) 1, (Object) this)).booleanValue();
        }
        return INSTANCE.b(this.impl.invoke());
    }
}
