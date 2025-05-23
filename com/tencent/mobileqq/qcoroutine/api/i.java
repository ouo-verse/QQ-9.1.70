package com.tencent.mobileqq.qcoroutine.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0003\t\u0005\u000f\u0018\u0019B%\b\u0002\u0012\u0006\u0010\f\u001a\u00020\b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0003\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0015\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0013\u001a\u0004\b\t\u0010\u0014\u0082\u0001\b\u001a\u001b\u001c\u001d\u001e\u001f !\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/qcoroutine/api/i;", "", "", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "name", "", "b", "I", "()I", "concurrency", "", "Z", "d", "()Z", "permanent", "Lcom/tencent/mobileqq/qcoroutine/api/DispatcherType;", "Lcom/tencent/mobileqq/qcoroutine/api/DispatcherType;", "()Lcom/tencent/mobileqq/qcoroutine/api/DispatcherType;", "dispatcherType", "<init>", "(IZLcom/tencent/mobileqq/qcoroutine/api/DispatcherType;)V", "e", "f", "Lcom/tencent/mobileqq/qcoroutine/api/f;", "Lcom/tencent/mobileqq/qcoroutine/api/b;", "Lcom/tencent/mobileqq/qcoroutine/api/i$e;", "Lcom/tencent/mobileqq/qcoroutine/api/i$a;", "Lcom/tencent/mobileqq/qcoroutine/api/i$b;", "Lcom/tencent/mobileqq/qcoroutine/api/i$d;", "Lcom/tencent/mobileqq/qcoroutine/api/i$c;", "Lcom/tencent/mobileqq/qcoroutine/api/i$f;", "QCoroutine_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes16.dex */
public abstract class i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String name;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int concurrency;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final boolean permanent;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final DispatcherType dispatcherType;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/qcoroutine/api/i$a;", "Lcom/tencent/mobileqq/qcoroutine/api/i;", "<init>", "()V", "QCoroutine_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes16.dex */
    public static final class a extends i {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        @NotNull
        public static final a f261779e;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7875);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f261779e = new a();
            }
        }

        a() {
            super(j.a(), true, DispatcherType.CPU, null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/qcoroutine/api/i$b;", "Lcom/tencent/mobileqq/qcoroutine/api/i;", "<init>", "()V", "QCoroutine_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes16.dex */
    public static final class b extends i {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        @NotNull
        public static final b f261780e;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7957);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f261780e = new b();
            }
        }

        b() {
            super(j.a() * 6, true, DispatcherType.CPU, null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/qcoroutine/api/i$c;", "Lcom/tencent/mobileqq/qcoroutine/api/i;", "<init>", "()V", "QCoroutine_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes16.dex */
    public static final class c extends i {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        @NotNull
        public static final c f261781e;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7962);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f261781e = new c();
            }
        }

        c() {
            super(j.a() * 4, true, DispatcherType.IO, null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/qcoroutine/api/i$d;", "Lcom/tencent/mobileqq/qcoroutine/api/i;", "<init>", "()V", "QCoroutine_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes16.dex */
    public static final class d extends i {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        @NotNull
        public static final d f261782e;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7995);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f261782e = new d();
            }
        }

        d() {
            super(j.a() * 2, true, DispatcherType.IO, null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/qcoroutine/api/i$e;", "Lcom/tencent/mobileqq/qcoroutine/api/i;", "<init>", "()V", "QCoroutine_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes16.dex */
    public static final class e extends i {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        @NotNull
        public static final e f261783e;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(8066);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f261783e = new e();
            }
        }

        e() {
            super(1, true ? 1 : 0, DispatcherType.MAIN, null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/qcoroutine/api/i$f;", "Lcom/tencent/mobileqq/qcoroutine/api/i;", "<init>", "()V", "QCoroutine_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes16.dex */
    public static final class f extends i {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        @NotNull
        public static final f f261784e;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(8123);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f261784e = new f();
            }
        }

        f() {
            super(j.a() * 4, true, DispatcherType.IO, null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    i(int i3, boolean z16, DispatcherType dispatcherType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Boolean.valueOf(z16), dispatcherType);
            return;
        }
        this.concurrency = i3;
        this.permanent = z16;
        this.dispatcherType = dispatcherType;
        String simpleName = getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "this.javaClass.simpleName");
        this.name = simpleName;
    }

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.concurrency;
    }

    @NotNull
    public final DispatcherType b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (DispatcherType) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.dispatcherType;
    }

    @NotNull
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (String) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.name;
    }

    public final boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.permanent;
    }

    public /* synthetic */ i(int i3, boolean z16, DispatcherType dispatcherType, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, z16, dispatcherType);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            return;
        }
        iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Boolean.valueOf(z16), dispatcherType, defaultConstructorMarker);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ i(int i3, boolean z16, DispatcherType dispatcherType, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i16 & 2) != 0 ? false : z16, (i16 & 4) != 0 ? DispatcherType.IO : dispatcherType);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            return;
        }
        iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Boolean.valueOf(z16), dispatcherType, Integer.valueOf(i16), defaultConstructorMarker);
    }
}
