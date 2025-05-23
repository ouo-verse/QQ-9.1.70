package com.tencent.gdtad.kuikly.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.ad.tangram.statistics.metric.AdMetricID;
import com.tencent.ad.tangram.statistics.metric.AdMetricService;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.kuikly.dex.GdtKuiklyDexManager;
import com.tencent.gdtad.params.InitGdtContextParams;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes6.dex */
public abstract class a {

    /* renamed from: b, reason: collision with root package name */
    private volatile GdtBaseKuiklyFragmentFallbackIPCHandler f109293b;

    /* renamed from: a, reason: collision with root package name */
    private volatile boolean f109292a = false;

    /* renamed from: c, reason: collision with root package name */
    private final ConcurrentHashMap<Integer, d> f109294c = new ConcurrentHashMap<>();

    /* compiled from: P */
    /* renamed from: com.tencent.gdtad.kuikly.fragment.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private static final class C1163a implements GdtKuiklyDexManager.a {

        /* renamed from: a, reason: collision with root package name */
        private final d f109295a;

        public C1163a(d dVar) {
            this.f109295a = dVar;
        }

        @Override // com.tencent.gdtad.kuikly.dex.GdtKuiklyDexManager.a
        public void a(int i3, GdtKuiklyDexManager.b bVar, GdtKuiklyDexManager.c cVar) {
            GdtAd gdtAd;
            String str;
            String str2;
            GdtAd gdtAd2;
            String str3;
            long j3 = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
            String str4 = null;
            if (i3 == 0) {
                String str5 = "[GdtKuiklyFragmentValidator][onResult] success, errorCode:" + i3 + " validatorParams:" + bVar + " validatorResult:" + cVar;
                d dVar = this.f109295a;
                if (dVar != null) {
                    gdtAd2 = dVar.b();
                } else {
                    gdtAd2 = null;
                }
                d dVar2 = this.f109295a;
                if (dVar2 != null) {
                    str3 = dVar2.i();
                } else {
                    str3 = null;
                }
                d dVar3 = this.f109295a;
                if (dVar3 != null) {
                    str4 = dVar3.getPageName();
                }
                String str6 = str4;
                d dVar4 = this.f109295a;
                if (dVar4 != null) {
                    j3 = dVar4.h();
                }
                com.tencent.gdtad.kuikly.a.h("GdtBaseKuiklyFragmentLauncher", str5, AdMetricID.Kuikly.FragmentLauncher.CHECK_SUCCESS, AdMetricID.Kuikly.FragmentLauncher.CHECK_SUCCESS_TIME_MILLIS, gdtAd2, str3, str6, j3);
                a.d(this.f109295a);
            } else {
                String str7 = "[GdtKuiklyFragmentValidator][onResult] failed, errorCode:" + i3 + " validatorParams:" + bVar + " validatorResult:" + cVar;
                d dVar5 = this.f109295a;
                if (dVar5 != null) {
                    gdtAd = dVar5.b();
                } else {
                    gdtAd = null;
                }
                d dVar6 = this.f109295a;
                if (dVar6 != null) {
                    str = dVar6.i();
                } else {
                    str = null;
                }
                d dVar7 = this.f109295a;
                if (dVar7 != null) {
                    str2 = dVar7.getPageName();
                } else {
                    str2 = null;
                }
                d dVar8 = this.f109295a;
                if (dVar8 != null) {
                    j3 = dVar8.h();
                }
                com.tencent.gdtad.kuikly.a.c("GdtBaseKuiklyFragmentLauncher", str7, null, AdMetricID.Kuikly.FragmentLauncher.CHECK_FAILED, AdMetricID.Kuikly.FragmentLauncher.CHECK_FAILED_TIME_MILLIS, gdtAd, str, str2, j3, i3);
                a.e(this.f109295a, i3);
            }
            AdMetricService.getInstance().flush(new WeakReference<>(BaseApplication.getContext()));
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface b {
        int a(d dVar);
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface c {
        int a(d dVar, int i3);
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface d {
        c a();

        GdtAd b();

        void c(GdtKuiklyDexManager.a aVar);

        long d();

        long e();

        long f();

        b g();

        Activity getActivity();

        String getPageName();

        long h();

        String i();

        boolean isValid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(d dVar) {
        b bVar;
        GdtAd gdtAd;
        String str;
        GdtAd gdtAd2;
        String str2;
        GdtAd gdtAd3;
        String str3;
        String str4 = null;
        if (dVar != null && dVar.isValid()) {
            bVar = dVar.g();
        } else {
            bVar = null;
        }
        long j3 = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        if (bVar == null) {
            if (dVar != null) {
                gdtAd3 = dVar.b();
            } else {
                gdtAd3 = null;
            }
            if (dVar != null) {
                str3 = dVar.i();
            } else {
                str3 = null;
            }
            if (dVar != null) {
                str4 = dVar.getPageName();
            }
            String str5 = str4;
            if (dVar != null) {
                j3 = dVar.h();
            }
            com.tencent.gdtad.kuikly.a.c("GdtBaseKuiklyFragmentLauncher", "[display] error, displayProcessor is null, ", null, AdMetricID.Kuikly.FragmentLauncher.DISPLAY_FAILED, AdMetricID.Kuikly.FragmentLauncher.DISPLAY_FAILED_TIME_MILLIS, gdtAd3, str3, str5, j3, 1);
            e(dVar, 1);
            return;
        }
        QLog.i("GdtBaseKuiklyFragmentLauncher", 1, "[display] start");
        int a16 = bVar.a(dVar);
        if (a16 == 0) {
            if (dVar != null) {
                gdtAd2 = dVar.b();
            } else {
                gdtAd2 = null;
            }
            if (dVar != null) {
                str2 = dVar.i();
            } else {
                str2 = null;
            }
            if (dVar != null) {
                str4 = dVar.getPageName();
            }
            String str6 = str4;
            if (dVar != null) {
                j3 = dVar.h();
            }
            com.tencent.gdtad.kuikly.a.h("GdtBaseKuiklyFragmentLauncher", "[display] success", AdMetricID.Kuikly.FragmentLauncher.DISPLAY_SUCCESS, AdMetricID.Kuikly.FragmentLauncher.DISPLAY_SUCCESS_TIME_MILLIS, gdtAd2, str2, str6, j3);
            return;
        }
        String str7 = "[display] failed, displayErrorCode:" + a16;
        if (dVar != null) {
            gdtAd = dVar.b();
        } else {
            gdtAd = null;
        }
        if (dVar != null) {
            str = dVar.i();
        } else {
            str = null;
        }
        if (dVar != null) {
            str4 = dVar.getPageName();
        }
        String str8 = str4;
        if (dVar != null) {
            j3 = dVar.h();
        }
        com.tencent.gdtad.kuikly.a.c("GdtBaseKuiklyFragmentLauncher", str7, null, AdMetricID.Kuikly.FragmentLauncher.DISPLAY_FAILED, AdMetricID.Kuikly.FragmentLauncher.DISPLAY_FAILED_TIME_MILLIS, gdtAd, str, str8, j3, a16);
        e(dVar, a16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int e(d dVar, int i3) {
        c cVar;
        GdtAd gdtAd;
        String str;
        GdtAd gdtAd2;
        String str2;
        long j3;
        GdtAd gdtAd3;
        String str3;
        String str4 = null;
        if (dVar != null) {
            cVar = dVar.a();
        } else {
            cVar = null;
        }
        long j16 = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        if (cVar == null) {
            String str5 = "[fallback] error, fallbackProcessor is null, errorCode:" + i3;
            if (dVar != null) {
                gdtAd3 = dVar.b();
            } else {
                gdtAd3 = null;
            }
            if (dVar != null) {
                str3 = dVar.i();
            } else {
                str3 = null;
            }
            if (dVar != null) {
                str4 = dVar.getPageName();
            }
            String str6 = str4;
            if (dVar != null) {
                j16 = dVar.h();
            }
            com.tencent.gdtad.kuikly.a.c("GdtBaseKuiklyFragmentLauncher", str5, null, AdMetricID.Kuikly.FragmentLauncher.FALLBACK_FAILED, AdMetricID.Kuikly.FragmentLauncher.FALLBACK_FAILED_TIME_MILLIS, gdtAd3, str3, str6, j16, 1);
            return 1;
        }
        QLog.i("GdtBaseKuiklyFragmentLauncher", 1, "[fallback] start, errorCode:" + i3);
        int a16 = cVar.a(dVar, i3);
        if (a16 == 0) {
            String str7 = "[fallback] success, errorCode:" + i3;
            if (dVar != null) {
                gdtAd2 = dVar.b();
            } else {
                gdtAd2 = null;
            }
            if (dVar != null) {
                str2 = dVar.i();
            } else {
                str2 = null;
            }
            if (dVar != null) {
                str4 = dVar.getPageName();
            }
            String str8 = str4;
            if (dVar != null) {
                j3 = dVar.h();
            } else {
                j3 = -2147483648L;
            }
            com.tencent.gdtad.kuikly.a.i("GdtBaseKuiklyFragmentLauncher", str7, AdMetricID.Kuikly.FragmentLauncher.FALLBACK_SUCCESS, AdMetricID.Kuikly.FragmentLauncher.FALLBACK_SUCCESS_TIME_MILLIS, gdtAd2, str2, str8, j3, i3);
            return a16;
        }
        String str9 = "[fallback] failed, errorCode:" + i3 + " result:" + a16;
        if (dVar != null) {
            gdtAd = dVar.b();
        } else {
            gdtAd = null;
        }
        if (dVar != null) {
            str = dVar.i();
        } else {
            str = null;
        }
        if (dVar != null) {
            str4 = dVar.getPageName();
        }
        String str10 = str4;
        if (dVar != null) {
            j16 = dVar.h();
        }
        com.tencent.gdtad.kuikly.a.c("GdtBaseKuiklyFragmentLauncher", str9, null, AdMetricID.Kuikly.FragmentLauncher.FALLBACK_FAILED, AdMetricID.Kuikly.FragmentLauncher.FALLBACK_FAILED_TIME_MILLIS, gdtAd, str, str10, j16, a16);
        return a16;
    }

    public static boolean i(d dVar) {
        if (dVar != null && dVar.getActivity() != null && dVar.b() != null && !TextUtils.isEmpty(dVar.i()) && !TextUtils.isEmpty(dVar.getPageName()) && dVar.f() >= 0 && dVar.a() != null && dVar.g() != null) {
            return true;
        }
        return false;
    }

    private void k(d dVar) {
        if (dVar != null && dVar.isValid()) {
            this.f109294c.put(Integer.valueOf(dVar.hashCode()), dVar);
        } else {
            QLog.e("GdtBaseKuiklyFragmentLauncher", 1, "[register] error, not valid");
        }
    }

    protected abstract GdtBaseKuiklyFragmentFallbackIPCHandler c();

    public int f(Context context, int i3, int i16, String str) {
        try {
            ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).initGdtContext(context, new InitGdtContextParams());
            if (this.f109293b == null) {
                QLog.e("GdtBaseKuiklyFragmentLauncher", 1, "[fallbackByIPC] error, mIPCHandler is null");
                return 1;
            }
            return this.f109293b.a(context, i3, i16, str);
        } catch (Throwable th5) {
            QLog.e("GdtBaseKuiklyFragmentLauncher", 1, "[fallbackByIPC] errorCode:" + i3 + " hashCode:" + i16 + " toProcessName:" + str, th5);
            return 15;
        }
    }

    public d g(int i3) {
        return this.f109294c.get(Integer.valueOf(i3));
    }

    public void h() {
        if (this.f109292a) {
            return;
        }
        synchronized (this) {
            if (this.f109292a) {
                return;
            }
            this.f109292a = true;
            QLog.i("GdtBaseKuiklyFragmentLauncher", 1, "[init]");
            this.f109293b = c();
        }
    }

    public int j(d dVar) {
        GdtAd gdtAd;
        String str;
        if (dVar != null && dVar.isValid()) {
            C1163a c1163a = new C1163a(dVar);
            dVar.c(c1163a);
            k(dVar);
            GdtKuiklyDexManager.b bVar = new GdtKuiklyDexManager.b();
            bVar.f109268a = dVar.i();
            bVar.f109269b = dVar.getPageName();
            bVar.f109270c = dVar.f();
            bVar.f109271d = new WeakReference<>(c1163a);
            bVar.f109272e = new Handler(Looper.getMainLooper());
            GdtKuiklyDexManager.e(bVar);
            com.tencent.gdtad.kuikly.a.k("GdtBaseKuiklyFragmentLauncher", "[launch]", AdMetricID.Kuikly.FragmentLauncher.LAUNCH_SUCCESS, dVar.b(), dVar.i(), dVar.getPageName());
            return 0;
        }
        String str2 = null;
        if (dVar != null) {
            gdtAd = dVar.b();
        } else {
            gdtAd = null;
        }
        if (dVar != null) {
            str = dVar.i();
        } else {
            str = null;
        }
        if (dVar != null) {
            str2 = dVar.getPageName();
        }
        com.tencent.gdtad.kuikly.a.f("GdtBaseKuiklyFragmentLauncher", "[launch] error, not valid", null, AdMetricID.Kuikly.FragmentLauncher.LAUNCH_FAILED, gdtAd, str, str2, 4);
        return e(dVar, 4);
    }
}
