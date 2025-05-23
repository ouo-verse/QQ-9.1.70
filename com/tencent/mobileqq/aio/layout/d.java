package com.tencent.mobileqq.aio.layout;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.oskplayer.util.SecretUtils;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\b\u0003\n\u000b\f\r\u000e\u000f\u0010B\u0011\b\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\b\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/aio/layout/d;", "", "", "a", "Ljava/lang/String;", "getDes", "()Ljava/lang/String;", SecretUtils.DES, "<init>", "(Ljava/lang/String;)V", "b", "c", "d", "e", "f", "g", tl.h.F, "Lcom/tencent/mobileqq/aio/layout/d$a;", "Lcom/tencent/mobileqq/aio/layout/d$b;", "Lcom/tencent/mobileqq/aio/layout/d$c;", "Lcom/tencent/mobileqq/aio/layout/d$d;", "Lcom/tencent/mobileqq/aio/layout/d$e;", "Lcom/tencent/mobileqq/aio/layout/d$f;", "Lcom/tencent/mobileqq/aio/layout/d$g;", "Lcom/tencent/mobileqq/aio/layout/d$h;", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public abstract class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String des;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/aio/layout/d$a;", "Lcom/tencent/mobileqq/aio/layout/d;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class a extends d {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        public static final a f189935b;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57068);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f189935b = new a();
            }
        }

        a() {
            super("bottom bar \u533a\u57df", null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/aio/layout/d$b;", "Lcom/tencent/mobileqq/aio/layout/d;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b extends d {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        public static final b f189936b;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57069);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f189936b = new b();
            }
        }

        b() {
            super("input \u533a\u57df", null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/aio/layout/d$c;", "Lcom/tencent/mobileqq/aio/layout/d;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class c extends d {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        public static final c f189937b;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57070);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f189937b = new c();
            }
        }

        c() {
            super("Input\u5360\u4f4d\u533a\u57df", null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/aio/layout/d$d;", "Lcom/tencent/mobileqq/aio/layout/d;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.layout.d$d, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static final class C7289d extends d {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        public static final C7289d f189938b;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57071);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f189938b = new C7289d();
            }
        }

        C7289d() {
            super("shortCut \u533a\u57df", null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/aio/layout/d$e;", "Lcom/tencent/mobileqq/aio/layout/d;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class e extends d {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        public static final e f189939b;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57072);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f189939b = new e();
            }
        }

        e() {
            super("top tip \u533a\u57df", null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/aio/layout/d$f;", "Lcom/tencent/mobileqq/aio/layout/d;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class f extends d {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        public static final f f189940b;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57073);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f189940b = new f();
            }
        }

        f() {
            super("\u4eceTitle\u680f\u5f39\u51fa\u7684\u533a\u57df", null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    @Deprecated(message = "use reserve1 top tip")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/aio/layout/d$g;", "Lcom/tencent/mobileqq/aio/layout/d;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class g extends d {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        public static final g f189941b;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57075);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f189941b = new g();
            }
        }

        g() {
            super("\u6d88\u606f\u5934\u90e8\u533a\u57df", null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/aio/layout/d$h;", "Lcom/tencent/mobileqq/aio/layout/d;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class h extends d {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        public static final h f189942b;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57076);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f189942b = new h();
            }
        }

        h() {
            super("Title\u680f\u4e0b\u7684\u6574\u5757\u533a\u57df", null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public /* synthetic */ d(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) defaultConstructorMarker);
    }

    d(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.des = str;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        }
    }
}
