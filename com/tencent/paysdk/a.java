package com.tencent.paysdk;

import android.content.Context;
import androidx.annotation.RestrictTo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.paysdk.api.IAuthTask;
import com.tencent.paysdk.api.IUserInfoProvider;
import com.tencent.paysdk.api.VideoAuthCore;
import com.tencent.paysdk.api.k;
import com.tencent.paysdk.api.n;
import com.tencent.paysdk.api.o;
import com.tencent.paysdk.api.p;
import com.tencent.paysdk.api.r;
import com.tencent.paysdk.data.b;
import com.tencent.paysdk.log.c;
import com.tencent.paysdk.network.VipAuthRequestUtil;
import com.tencent.paysdk.report.InternalReport;
import com.tencent.paysdk.util.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b?\u0010@J\b\u0010\u0002\u001a\u00020\u0000H\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0001H\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0007J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0010H\u0007J\b\u0010\u0012\u001a\u00020\nH\u0007J\b\u0010\u0013\u001a\u00020\u0004H\u0007J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\nH\u0017J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0016J\u0018\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\nH\u0016J\b\u0010 \u001a\u00020\u001fH\u0016J\b\u0010!\u001a\u00020\u0006H\u0016J\b\u0010#\u001a\u00020\"H\u0016J\n\u0010%\u001a\u0004\u0018\u00010$H\u0016J\n\u0010'\u001a\u0004\u0018\u00010&H\u0016J\u000e\u0010*\u001a\u00020\u00042\u0006\u0010)\u001a\u00020(R\u0016\u0010,\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010+R\u0016\u0010.\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010-R\u0016\u00100\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010/R\u0016\u00102\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u00101R\u0016\u0010\u0003\u001a\u00020\u00018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u00103R\u0018\u0010)\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u00104R$\u00109\u001a\u0012\u0012\u0004\u0012\u00020605j\b\u0012\u0004\u0012\u000206`78\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u00108R\u001c\u0010>\u001a\b\u0012\u0004\u0012\u00020;0:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=\u00a8\u0006A"}, d2 = {"Lcom/tencent/paysdk/a;", "Lcom/tencent/paysdk/api/n;", "l", "impl", "", "r", "Landroid/content/Context;", "context", "Lcom/tencent/paysdk/api/o;", "k", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/paysdk/api/c;", "provider", "Lcom/tencent/paysdk/api/IAuthTask;", ReportConstant.COSTREPORT_PREFIX, "", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "t", "type", "e", "a", "Lcom/tencent/paysdk/api/IUserInfoProvider;", "d", "Lcom/tencent/paysdk/data/a;", DomainData.DOMAIN_NAME, "Lcom/tencent/paysdk/data/b;", "p", "url", "b", "Lcom/tencent/paysdk/api/p;", "c", "getContext", "", "isRelease", "Lcom/tencent/paysdk/log/b;", "f", "Lcom/tencent/paysdk/api/k;", "g", "Lmq3/a;", "loginCallback", "u", "Z", "isInternalLogin", "Lcom/tencent/paysdk/data/a;", "appInfo", "Lcom/tencent/paysdk/data/b;", "deviceInfo", "Lcom/tencent/paysdk/api/p;", "webViewDelegator", "Lcom/tencent/paysdk/api/n;", "Lmq3/a;", "Ljava/util/ArrayList;", "Lcom/tencent/paysdk/api/r;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "videoPayListeners", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/paysdk/vipauth/b;", h.F, "Ljava/lang/ref/WeakReference;", "lastVipInternalJSInterface", "<init>", "()V", "tencentvideo_pay_sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes22.dex */
public final class a implements n {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static boolean isInternalLogin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static com.tencent.paysdk.data.a appInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static b deviceInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static p webViewDelegator;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static n impl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static mq3.a loginCallback;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static final ArrayList<r> videoPayListeners;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static WeakReference<com.tencent.paysdk.vipauth.b> lastVipInternalJSInterface;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public static final a f341941i;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "onCompleted"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.tencent.paysdk.a$a, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    static final class C9288a implements com.tencent.paysdk.api.h {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final C9288a f341942a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9974);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
            } else {
                f341942a = new C9288a();
            }
        }

        C9288a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }

        @Override // com.tencent.paysdk.api.h
        public final void onCompleted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            a aVar = a.f341941i;
            mq3.a h16 = a.h(aVar);
            if (h16 != null) {
                h16.h(a.i(aVar));
            }
            e.f342089b.a(a.i(aVar));
            a.loginCallback = null;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10063);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 19)) {
            redirector.redirect((short) 19);
            return;
        }
        f341941i = new a();
        videoPayListeners = new ArrayList<>();
        lastVipInternalJSInterface = new WeakReference<>(null);
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        }
    }

    public static final /* synthetic */ mq3.a h(a aVar) {
        return loginCallback;
    }

    public static final /* synthetic */ boolean i(a aVar) {
        return isInternalLogin;
    }

    @JvmStatic
    @Nullable
    public static final o k(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        a aVar = f341941i;
        o a16 = aVar.c().a(context);
        if (a16 != null) {
            a16.b(aVar.m());
        }
        return a16;
    }

    @JvmStatic
    @NotNull
    public static final a l() {
        return f341941i;
    }

    private final String m() {
        return "TenvideoUnion/" + q();
    }

    @JvmStatic
    @NotNull
    public static final List<String> o() {
        return com.tencent.paysdk.util.b.f342085b.b();
    }

    @JvmStatic
    @NotNull
    public static final String q() {
        return "1.2.9.12";
    }

    @JvmStatic
    public static final void r(@NotNull n impl2) {
        Intrinsics.checkNotNullParameter(impl2, "impl");
        impl = impl2;
        a aVar = f341941i;
        if (aVar.f() != null) {
            c.c(aVar.f());
        }
        VipAuthRequestUtil.INSTANCE.e(aVar.g());
        n nVar = impl;
        if (nVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("impl");
        }
        appInfo = new com.tencent.paysdk.data.a(nVar.getAppInfo());
        n nVar2 = impl;
        if (nVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("impl");
        }
        deviceInfo = new b(nVar2.getDeviceInfo());
        n nVar3 = impl;
        if (nVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("impl");
        }
        webViewDelegator = nVar3.c();
        c.b("AuthSDK", "SDK init finish.");
        InternalReport.INSTANCE.h();
    }

    @JvmStatic
    @NotNull
    public static final IAuthTask s(@NotNull com.tencent.paysdk.api.c provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        return new VideoAuthCore(provider);
    }

    @JvmStatic
    public static final void t() {
        f341941i.c().b(C9288a.f341942a);
        isInternalLogin = false;
    }

    @Override // com.tencent.paysdk.api.n
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        n nVar = impl;
        if (nVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("impl");
        }
        nVar.a();
    }

    @Override // com.tencent.paysdk.api.n
    public void b(@NotNull Context context, @NotNull String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) context, (Object) url);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        n nVar = impl;
        if (nVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("impl");
        }
        nVar.b(context, url);
    }

    @Override // com.tencent.paysdk.api.n
    @NotNull
    public p c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (p) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        p pVar = webViewDelegator;
        if (pVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webViewDelegator");
        }
        return pVar;
    }

    @Override // com.tencent.paysdk.api.n
    @NotNull
    public IUserInfoProvider d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (IUserInfoProvider) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        n nVar = impl;
        if (nVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("impl");
        }
        return nVar.d();
    }

    @Override // com.tencent.paysdk.api.n
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void e(@NotNull String type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) type);
            return;
        }
        Intrinsics.checkNotNullParameter(type, "type");
        isInternalLogin = true;
        n nVar = impl;
        if (nVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("impl");
        }
        nVar.e(type);
    }

    @Override // com.tencent.paysdk.api.n
    @Nullable
    public com.tencent.paysdk.log.b f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (com.tencent.paysdk.log.b) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        n nVar = impl;
        if (nVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("impl");
        }
        return nVar.f();
    }

    @Override // com.tencent.paysdk.api.n
    @Nullable
    public k g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (k) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        n nVar = impl;
        if (nVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("impl");
        }
        return nVar.g();
    }

    @Override // com.tencent.paysdk.api.n
    @NotNull
    public Context getContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Context) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        n nVar = impl;
        if (nVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("impl");
        }
        return nVar.getContext();
    }

    @Override // com.tencent.paysdk.api.n
    public boolean isRelease() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        n nVar = impl;
        if (nVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("impl");
        }
        return nVar.isRelease();
    }

    @Override // com.tencent.paysdk.api.n
    @NotNull
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public com.tencent.paysdk.data.a getAppInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.paysdk.data.a) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        com.tencent.paysdk.data.a aVar = appInfo;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appInfo");
        }
        return aVar;
    }

    @Override // com.tencent.paysdk.api.n
    @NotNull
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public b getDeviceInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (b) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        b bVar = deviceInfo;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deviceInfo");
        }
        return bVar;
    }

    public final void u(@NotNull mq3.a loginCallback2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) loginCallback2);
        } else {
            Intrinsics.checkNotNullParameter(loginCallback2, "loginCallback");
            loginCallback = loginCallback2;
        }
    }
}
