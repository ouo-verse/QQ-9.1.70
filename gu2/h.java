package gu2;

import android.content.Context;
import com.tencent.ams.dynamic.IDynamicApi;
import com.tencent.hippy.qq.api.IHippyLibrary;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdConfigDefine$APPID;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdConfigDefine$CHID;
import com.tencent.mobileqq.tvideo.net.utils.TVideoConfig;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.playerinterface.IQAdPlayerView;
import pw2.n;
import qv2.c;

/* compiled from: P */
/* loaded from: classes19.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f403371a;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class a implements n.a {
        @Override // pw2.n.a
        public int a(String str, Throwable th5, String str2) {
            return 0;
        }

        @Override // pw2.n.a
        public int b(String str, Throwable th5, String str2) {
            return 0;
        }

        @Override // pw2.n.a
        public int d(String str, String str2) {
            QLog.d(str, 1, str2);
            return -1;
        }

        @Override // pw2.n.a
        public int e(String str, Throwable th5) {
            return 0;
        }

        @Override // pw2.n.a
        public int i(String str, String str2) {
            QLog.i(str, 1, str2);
            return -1;
        }

        @Override // pw2.n.a
        public int v(String str, String str2) {
            return 0;
        }

        @Override // pw2.n.a
        public int w(String str, String str2) {
            QLog.w(str, 1, str2);
            return -1;
        }

        @Override // pw2.n.a
        public int e(String str, String str2) {
            QLog.e(str, 1, str2);
            return -1;
        }
    }

    public static synchronized void a() {
        synchronized (h.class) {
            if (!f403371a) {
                c.a u16 = new c.a().r(QCircleApplication.APP).v(true).u(true);
                TVideoConfig tVideoConfig = TVideoConfig.f304492a;
                qv2.b.f(u16.y(tVideoConfig.n()).q(QAdConfigDefine$APPID.TVIDEO).t(QAdConfigDefine$CHID.QQ).w(tVideoConfig.k()).x("wxf0a80d0ac2e82aa7").s());
                n.f(new a());
                b();
                pu2.a.L(new kt3.c() { // from class: gu2.g
                    @Override // kt3.c
                    public final kt3.b a(Context context, IQAdPlayerView iQAdPlayerView) {
                        return new hu2.h(context, iQAdPlayerView);
                    }
                });
                ((IDynamicApi) QRoute.api(IDynamicApi.class)).initDynamicSDK();
                ((IHippyLibrary) QRoute.api(IHippyLibrary.class)).loadLibraryIfNeed(null);
                com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.b.e();
            }
            f403371a = true;
        }
    }

    private static void b() {
        dv2.b d16 = dv2.b.d();
        d16.c(new gu2.a());
        d16.c(new b());
        d16.c(new e());
        d16.c(new i());
        d16.c(new k());
        d16.c(new l());
        d16.c(new f());
        d16.c(new d());
    }
}
