package com.tencent.mobileqq.flock.share;

import com.tencent.mobileqq.forward.api.IForwardApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.wxapi.api.IWXShareHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0018B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0017\u0010\u000b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0015\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\f8F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\rR\u0015\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\f8F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\rR\u0011\u0010\u0013\u001a\u00020\u00108F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0015\u001a\u00020\u00108F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/flock/share/c;", "", "Lcom/tencent/mobileqq/forward/api/IForwardApi;", "b", "Lcom/tencent/mobileqq/forward/api/IForwardApi;", "forwardApi", "Lcom/tencent/mobileqq/wxapi/api/IWXShareHelper;", "c", "Lcom/tencent/mobileqq/wxapi/api/IWXShareHelper;", "d", "()Lcom/tencent/mobileqq/wxapi/api/IWXShareHelper;", "wxShareHelper", "Ljava/lang/Class;", "()Ljava/lang/Class;", "forwardRecentActivityClass", "forwardRecentTranslucentActivity", "", "e", "()Z", "isWXInstalled", "f", "isWXSupportApi", "<init>", "()V", "a", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f210421a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final IForwardApi forwardApi;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final IWXShareHelper wxShareHelper;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0011\u0010\t\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u000b\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u0004R\u0011\u0010\r\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\u0004R\u0011\u0010\u000f\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u0004R\u0011\u0010\u0011\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\b\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/flock/share/c$a;", "", "", "c", "()Ljava/lang/String;", "KEY_REQ", "", "e", "()I", "REQ_DIRECT_SHOW_DIALOG", "b", "KEY_DIRECT_SHOW_UIN_TYPE", "a", "KEY_DIRECT_SHOW_UIN", "d", "KEY_SELECTION_MODE", "f", "SELECTION_MODE_MULTI", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f210424a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48996);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 8)) {
                redirector.redirect((short) 8);
            } else {
                f210424a = new a();
            }
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @NotNull
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            String KEY_DIRECT_SHOW_UIN = c.forwardApi.KEY_DIRECT_SHOW_UIN();
            Intrinsics.checkNotNullExpressionValue(KEY_DIRECT_SHOW_UIN, "forwardApi.KEY_DIRECT_SHOW_UIN()");
            return KEY_DIRECT_SHOW_UIN;
        }

        @NotNull
        public final String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            String KEY_DIRECT_SHOW_UIN_TYPE = c.forwardApi.KEY_DIRECT_SHOW_UIN_TYPE();
            Intrinsics.checkNotNullExpressionValue(KEY_DIRECT_SHOW_UIN_TYPE, "forwardApi.KEY_DIRECT_SHOW_UIN_TYPE()");
            return KEY_DIRECT_SHOW_UIN_TYPE;
        }

        @NotNull
        public final String c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            String KEY_REQ = c.forwardApi.KEY_REQ();
            Intrinsics.checkNotNullExpressionValue(KEY_REQ, "forwardApi.KEY_REQ()");
            return KEY_REQ;
        }

        @NotNull
        public final String d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (String) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            String SELECTION_MODE = c.forwardApi.SELECTION_MODE();
            Intrinsics.checkNotNullExpressionValue(SELECTION_MODE, "forwardApi.SELECTION_MODE()");
            return SELECTION_MODE;
        }

        public final int e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return c.forwardApi.REQ_DIRECT_SHOW_DIALOG();
        }

        public final int f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
            }
            return c.forwardApi.SELECTION_MODE_MULTI();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49000);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        f210421a = new c();
        QRouteApi api = QRoute.api(IForwardApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IForwardApi::class.java)");
        forwardApi = (IForwardApi) api;
        QRouteApi api2 = QRoute.api(IWXShareHelper.class);
        Intrinsics.checkNotNullExpressionValue(api2, "api(IWXShareHelper::class.java)");
        wxShareHelper = (IWXShareHelper) api2;
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final Class<?> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        Class<?> forwardRecentActivityClass = forwardApi.getForwardRecentActivityClass();
        Intrinsics.checkNotNullExpressionValue(forwardRecentActivityClass, "forwardApi.forwardRecentActivityClass");
        return forwardRecentActivityClass;
    }

    @NotNull
    public final Class<?> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Class) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        Class<?> forwardRecentTranslucentActivityClass = forwardApi.getForwardRecentTranslucentActivityClass();
        Intrinsics.checkNotNullExpressionValue(forwardRecentTranslucentActivityClass, "forwardApi.forwardRecentTranslucentActivityClass");
        return forwardRecentTranslucentActivityClass;
    }

    @NotNull
    public final IWXShareHelper d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (IWXShareHelper) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return wxShareHelper;
    }

    public final boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return wxShareHelper.isWXInstalled();
    }

    public final boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return wxShareHelper.isWXsupportApi();
    }
}
