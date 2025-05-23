package com.tencent.mobileqq.qwallet;

import com.tencent.mobileqq.pskey.api.IPskeyManager;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.sdk.Cgi;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002\f\tB\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ$\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qwallet/e;", "", "", "ignoredCache", "", "domain", "Lcom/tencent/mobileqq/qwallet/e$a;", "callback", "", "b", "<init>", "()V", "a", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f277146a = new e();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J&\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/qwallet/e$a;", "", "", "code", "", "errMsg", "pskey", "", "onFinish", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public interface a {

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: com.tencent.mobileqq.qwallet.e$a$a, reason: collision with other inner class name */
        /* loaded from: classes16.dex */
        public static final class C8454a {
            public static /* synthetic */ void a(a aVar, int i3, String str, String str2, int i16, Object obj) {
                if (obj == null) {
                    if ((i16 & 4) != 0) {
                        str2 = null;
                    }
                    aVar.onFinish(i3, str, str2);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onFinish");
            }
        }

        void onFinish(int code, @Nullable String errMsg, @Nullable String pskey);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/qwallet/e$b;", "", "", "ignoredCache", "", "domain", "Lcom/tencent/mobileqq/qwallet/e$a;", "callback", "", "a", "<init>", "()V", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final b f277147a = new b();

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/qwallet/e$b$a", "Lsd2/a;", "", "", "domainToKeyMap", "", "onSuccess", "errMsg", "onFail", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes16.dex */
        public static final class a implements sd2.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ a f277148a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f277149b;

            a(a aVar, String str) {
                this.f277148a = aVar;
                this.f277149b = str;
            }

            @Override // sd2.a
            public void onFail(@NotNull String errMsg) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                QLog.i("QWalletHttp-QWalletPskey", 1, "onFail: " + errMsg);
                a.C8454a.a(this.f277148a, -1, errMsg, null, 4, null);
            }

            @Override // sd2.a
            public void onSuccess(@NotNull Map<String, String> domainToKeyMap) {
                Intrinsics.checkNotNullParameter(domainToKeyMap, "domainToKeyMap");
                QLog.i("QWalletHttp-QWalletPskey", 1, "onSuccess: size=" + domainToKeyMap.size());
                this.f277148a.onFinish(0, null, domainToKeyMap.get(this.f277149b));
            }
        }

        b() {
        }

        public void a(boolean ignoredCache, @NotNull String domain, @NotNull a callback) {
            Intrinsics.checkNotNullParameter(domain, "domain");
            Intrinsics.checkNotNullParameter(callback, "callback");
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                a.C8454a.a(callback, -1, "runtime is null", null, 4, null);
                return;
            }
            IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IPskeyManager.class, "all");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(\n \u2026onstant.ALL\n            )");
            IPskeyManager iPskeyManager = (IPskeyManager) runtimeService;
            a aVar = new a(callback, domain);
            if (ignoredCache) {
                iPskeyManager.replacePskey(new String[]{domain}, aVar);
            } else {
                iPskeyManager.getPskey(new String[]{domain}, aVar);
            }
        }
    }

    e() {
    }

    @JvmStatic
    @JvmOverloads
    public static final void a(@NotNull a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        c(false, null, callback, 3, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void b(boolean ignoredCache, @NotNull String domain, @NotNull a callback) {
        Intrinsics.checkNotNullParameter(domain, "domain");
        Intrinsics.checkNotNullParameter(callback, "callback");
        try {
            b.f277147a.a(ignoredCache, domain, callback);
        } catch (Exception e16) {
            QLog.w("QWalletHttp-QWalletPskey", 1, "getPskeyAsync error", e16);
            a.C8454a.a(callback, -1, "occur error", null, 4, null);
        }
    }

    public static /* synthetic */ void c(boolean z16, String str, a aVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        if ((i3 & 2) != 0) {
            str = Cgi.TENPAY_DOMAIN;
        }
        b(z16, str, aVar);
    }
}
