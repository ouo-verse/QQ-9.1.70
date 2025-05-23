package com.tencent.paysdk.report;

import androidx.annotation.RestrictTo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.login.QAdLoginDefine$LoginCookieKey;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.paysdk.api.IUserInfoProvider;
import com.tencent.paysdk.log.c;
import com.tencent.paysdk.network.RequestWrapper;
import com.tencent.paysdk.network.d;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import cooperation.qzone.remote.ServiceConst;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/paysdk/report/InternalReport;", "", "d", "Companion", "tencentvideo_pay_sdk_debug"}, k = 1, mv = {1, 4, 2})
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes22.dex */
public final class InternalReport {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final com.tencent.paysdk.network.b f342050a;

    /* renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<Integer, Long> f342051b;

    /* renamed from: c, reason: collision with root package name */
    private static final AtomicInteger f342052c;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0007J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\bH\u0007J\b\u0010\r\u001a\u00020\bH\u0007J\b\u0010\u000e\u001a\u00020\u0004H\u0007J\u001e\u0010\u0011\u001a\u00020\u00042\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000fH\u0007R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R \u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/paysdk/report/InternalReport$Companion;", "", "", "reportData", "", "f", "Lcom/tencent/paysdk/report/b;", "e", "", "point", "i", "", "d", "c", h.F, "", "map", "g", "Lcom/tencent/paysdk/network/b;", "httpClient", "Lcom/tencent/paysdk/network/b;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_URL, "Ljava/lang/String;", "Ljava/util/concurrent/atomic/AtomicInteger;", "sRequestId", "Ljava/util/concurrent/atomic/AtomicInteger;", "Ljava/util/concurrent/ConcurrentHashMap;", "sWasteTime", "Ljava/util/concurrent/ConcurrentHashMap;", "<init>", "()V", "tencentvideo_pay_sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes22.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                return;
            }
            iPatchRedirector.redirect((short) 6, (Object) this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final b e() {
            IUserInfoProvider d16 = com.tencent.paysdk.a.l().d();
            String h16 = d16.getUserInfo().h();
            int i3 = a.f342056a[d16.type().ordinal()];
            String str = "qq";
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        str = "-";
                    } else {
                        h16 = d16.getUserInfo().a();
                    }
                } else {
                    str = "wx";
                }
            }
            com.tencent.paysdk.data.b deviceInfo = com.tencent.paysdk.a.l().getDeviceInfo();
            com.tencent.paysdk.data.a appInfo = com.tencent.paysdk.a.l().getAppInfo();
            return b.INSTANCE.a().c("video_appid", appInfo.b()).c("player_platform", appInfo.a()).c("platform", "3").c(TPReportKeys.Common.COMMON_LOGIN_TYPE, str).c("appid", d16.getUserInfo().b()).c("openid", h16).c(QAdLoginDefine$LoginCookieKey.WX_VUSERID, d16.getUserInfo().i()).c("qimei36", deviceInfo.getQimei36()).c("sdk_version", "1.2.9.12").c("app_version", appInfo.g()).c(ServiceConst.PARA_SESSION_ID, UUID.randomUUID().toString());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void f(String reportData) throws IOException {
            InternalReport.f342050a.a().b("https://h.trace.qq.com/kv?attaid=02a00057846&token=4291277828").d("text/plain", reportData).e(RequestWrapper.RequestType.POST).request();
        }

        @JvmStatic
        public final int c() {
            int incrementAndGet;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            do {
                incrementAndGet = InternalReport.f342052c.incrementAndGet();
                if (incrementAndGet > 0) {
                    return incrementAndGet;
                }
            } while (!InternalReport.f342052c.compareAndSet(incrementAndGet, 1));
            return 1;
        }

        @JvmStatic
        public final long d(int point) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Long) iPatchRedirector.redirect((short) 2, (Object) this, point)).longValue();
            }
            Long l3 = (Long) InternalReport.f342051b.remove(Integer.valueOf(point));
            if (l3 != null) {
                Intrinsics.checkNotNullExpressionValue(l3, "sWasteTime.remove(point) ?: return 0");
                return System.currentTimeMillis() - l3.longValue();
            }
            return 0L;
        }

        @JvmStatic
        public final void g(@NotNull final Map<String, ? extends Object> map) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) map);
            } else {
                Intrinsics.checkNotNullParameter(map, "map");
                d.a(new Runnable(map) { // from class: com.tencent.paysdk.report.InternalReport$Companion$report$1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ Map f342054d;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f342054d = map;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) map);
                        }
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        b e16;
                        String str;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 1)) {
                            try {
                                e16 = InternalReport.INSTANCE.e();
                                for (Map.Entry entry : this.f342054d.entrySet()) {
                                    String str2 = (String) entry.getKey();
                                    Object value = entry.getValue();
                                    if (value != null) {
                                        str = value.toString();
                                    } else {
                                        str = null;
                                    }
                                    e16.c(str2, str);
                                }
                                for (Map.Entry<String, String> entry2 : e16.b().entrySet()) {
                                    e16.c(entry2.getKey(), URLEncoder.encode(entry2.getValue(), "UTF-8"));
                                }
                                InternalReport.INSTANCE.f(e16.a());
                                return;
                            } catch (Exception e17) {
                                c.a("VideoAuthCore", String.valueOf(e17));
                                return;
                            }
                        }
                        iPatchRedirector2.redirect((short) 1, (Object) this);
                    }
                });
            }
        }

        @JvmStatic
        public final void h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                d.a(InternalReport$Companion$reportSdkInit$1.f342055d);
            }
        }

        @JvmStatic
        public final void i(int point) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, point);
            } else {
                InternalReport.f342051b.put(Integer.valueOf(point), Long.valueOf(System.currentTimeMillis()));
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
                return;
            }
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13052);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        INSTANCE = new Companion(null);
        f342050a = new com.tencent.paysdk.network.b();
        f342051b = new ConcurrentHashMap<>();
        f342052c = new AtomicInteger();
    }

    @JvmStatic
    public static final int d() {
        return INSTANCE.c();
    }

    @JvmStatic
    public static final long e(int i3) {
        return INSTANCE.d(i3);
    }

    @JvmStatic
    public static final void f(@NotNull Map<String, ? extends Object> map) {
        INSTANCE.g(map);
    }

    @JvmStatic
    public static final void g(int i3) {
        INSTANCE.i(i3);
    }
}
