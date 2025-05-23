package com.tencent.android.androidbypass.config;

import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0016\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0012\u001a\u0004\b\n\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/android/androidbypass/config/b;", "", "Lcom/tencent/android/androidbypass/config/f;", "a", "Lcom/tencent/android/androidbypass/config/f;", "()Lcom/tencent/android/androidbypass/config/f;", "d", "(Lcom/tencent/android/androidbypass/config/f;)V", "injectLog", "Lcom/tencent/android/androidbypass/config/i;", "b", "Lcom/tencent/android/androidbypass/config/i;", "c", "()Lcom/tencent/android/androidbypass/config/i;", "f", "(Lcom/tencent/android/androidbypass/config/i;)V", "injectSoLoader", "Lcom/tencent/android/androidbypass/config/h;", "Lcom/tencent/android/androidbypass/config/h;", "()Lcom/tencent/android/androidbypass/config/h;", "e", "(Lcom/tencent/android/androidbypass/config/h;)V", "injectReporter", "<init>", "()V", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static f injectLog;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static i injectSoLoader;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static h injectReporter;

    /* renamed from: d, reason: collision with root package name */
    public static final b f72055d;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "tag", "", "msg", "onLog"}, k = 3, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    static final class a implements f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final a f72056a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15094);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
            } else {
                f72056a = new a();
            }
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }

        @Override // com.tencent.android.androidbypass.config.f
        public final void onLog(int i3, @NotNull String tag, @NotNull String msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), tag, msg2);
                return;
            }
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            Log.d(tag, msg2);
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0006\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n\u00a2\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", "<anonymous parameter 2>", "", "reportTimeCost"}, k = 3, mv = {1, 4, 0})
    /* renamed from: com.tencent.android.androidbypass.config.b$b, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    static final class C0714b implements h {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final C0714b f72057a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15121);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
            } else {
                f72057a = new C0714b();
            }
        }

        C0714b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }

        @Override // com.tencent.android.androidbypass.config.h
        public final void reportTimeCost(@NotNull String str, @Nullable Map<String, String> map, double d16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, map, Double.valueOf(d16));
            } else {
                Intrinsics.checkNotNullParameter(str, "<anonymous parameter 0>");
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Z"}, k = 3, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    static final class c implements i {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final c f72058a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15129);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
            } else {
                f72058a = new c();
            }
        }

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }

        @Override // com.tencent.android.androidbypass.config.i
        public final boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return ((Boolean) iPatchRedirector.redirect((short) 1, (Object) this)).booleanValue();
            }
            return false;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15165);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
            return;
        }
        f72055d = new b();
        injectLog = a.f72056a;
        injectSoLoader = c.f72058a;
        injectReporter = C0714b.f72057a;
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        }
    }

    @NotNull
    public final f a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (f) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return injectLog;
    }

    @NotNull
    public final h b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (h) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return injectReporter;
    }

    @NotNull
    public final i c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (i) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return injectSoLoader;
    }

    public final void d(@NotNull f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) fVar);
        } else {
            Intrinsics.checkNotNullParameter(fVar, "<set-?>");
            injectLog = fVar;
        }
    }

    public final void e(@NotNull h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) hVar);
        } else {
            Intrinsics.checkNotNullParameter(hVar, "<set-?>");
            injectReporter = hVar;
        }
    }

    public final void f(@NotNull i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) iVar);
        } else {
            Intrinsics.checkNotNullParameter(iVar, "<set-?>");
            injectSoLoader = iVar;
        }
    }
}
