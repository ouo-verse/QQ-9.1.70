package com.tencent.gdtad.kuikly.dex;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.DexResInfo;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyDexResApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtKuiklyDexManager {

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface a {
        void a(int i3, b bVar, c cVar);
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public String f109268a;

        /* renamed from: b, reason: collision with root package name */
        public String f109269b;

        /* renamed from: c, reason: collision with root package name */
        public long f109270c = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;

        /* renamed from: d, reason: collision with root package name */
        public WeakReference<a> f109271d;

        /* renamed from: e, reason: collision with root package name */
        public Handler f109272e;

        public boolean a() {
            if (!TextUtils.isEmpty(this.f109268a) && !TextUtils.isEmpty(this.f109269b)) {
                return true;
            }
            return false;
        }

        @NonNull
        public String toString() {
            return "GdtKuiklyDexValidator.Params(bundleName=" + this.f109268a + ", pageName=" + this.f109269b + ", minVersion=" + this.f109270c + ")";
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public DexResInfo f109273a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f109274b = false;

        /* renamed from: c, reason: collision with root package name */
        public long f109275c = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;

        /* renamed from: d, reason: collision with root package name */
        public long f109276d = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;

        @NonNull
        public String toString() {
            return "GdtKuiklyDexValidator.Result(localDexResInfo=" + this.f109273a + ", isDexPageExist=" + this.f109274b + ", fetchedVersion=" + this.f109275c + ", lastRequestServerTimeMillis=" + this.f109276d + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int d(b bVar, c cVar) {
        long j3;
        if (bVar != null && bVar.a() && bVar.f109270c >= 0) {
            if (cVar == null) {
                QLog.e("GdtKuiklyDexManager", 1, "[check] error, result is null, params:" + bVar + " result:" + cVar);
                return 1;
            }
            DexResInfo dexResInfo = cVar.f109273a;
            if (dexResInfo != null) {
                j3 = dexResInfo.getResVersion();
            } else {
                j3 = -2147483648L;
            }
            int i3 = 16;
            if (cVar.f109274b && j3 != WebViewConstants.WV.ENABLE_WEBAIO_SWITCH) {
                i3 = j3 < bVar.f109270c ? 14 : 0;
            }
            QLog.i("GdtKuiklyDexManager", 1, "[check] errorCode:" + i3 + " params:" + bVar + " result:" + cVar);
            return i3;
        }
        QLog.e("GdtKuiklyDexManager", 1, "[check] error, params is not valid, params:" + bVar + " result:" + cVar);
        return 4;
    }

    public static void e(final b bVar) {
        QLog.i("GdtKuiklyDexManager", 1, "[checkAsync] params:" + bVar);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gdtad.kuikly.dex.GdtKuiklyDexManager.1
            @Override // java.lang.Runnable
            public void run() {
                c f16 = GdtKuiklyDexManager.f(b.this);
                GdtKuiklyDexManager.g(b.this, f16, GdtKuiklyDexManager.d(b.this, f16));
            }
        }, 64, null, true);
    }

    public static c f(b bVar) {
        if (bVar != null && bVar.a()) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                QLog.e("GdtKuiklyDexManager", 1, "[getLocalInfo] error, should not run on main thread, params:" + bVar);
                return null;
            }
            try {
                c cVar = new c();
                cVar.f109273a = ((IQQKuiklyDexResApi) QRoute.api(IQQKuiklyDexResApi.class)).getDexResInfo(bVar.f109268a);
                cVar.f109274b = ((IQQKuiklyDexResApi) QRoute.api(IQQKuiklyDexResApi.class)).isDexPageExist(bVar.f109268a, bVar.f109269b);
                cVar.f109275c = ((IQQKuiklyDexResApi) QRoute.api(IQQKuiklyDexResApi.class)).getFetchedResVersion(bVar.f109268a);
                cVar.f109276d = ((IQQKuiklyDexResApi) QRoute.api(IQQKuiklyDexResApi.class)).getLastRequestServerTime(bVar.f109268a);
                QLog.i("GdtKuiklyDexManager", 1, "[getLocalInfo] params:" + bVar + " result:" + cVar);
                return cVar;
            } catch (Throwable th5) {
                QLog.e("GdtKuiklyDexManager", 1, "[getLocalInfo]", th5);
                return null;
            }
        }
        QLog.e("GdtKuiklyDexManager", 1, "[getLocalInfo] error, params is not valid, params:" + bVar);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(final b bVar, final c cVar, final int i3) {
        if (bVar == null) {
            QLog.e("GdtKuiklyDexManager", 1, "[notifyListenerImpl] error, params is null, errorCode:" + i3 + " params:" + bVar + " result:" + cVar);
            return;
        }
        Handler handler = bVar.f109272e;
        if (handler == null) {
            h(bVar, cVar, i3);
        } else {
            handler.post(new Runnable() { // from class: com.tencent.gdtad.kuikly.dex.GdtKuiklyDexManager.2
                @Override // java.lang.Runnable
                public void run() {
                    GdtKuiklyDexManager.h(b.this, cVar, i3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h(b bVar, c cVar, int i3) {
        a aVar;
        if (bVar == null) {
            QLog.e("GdtKuiklyDexManager", 1, "[notifyListenerImpl] error, params is null, errorCode:" + i3 + " params:" + bVar + " result:" + cVar);
            return;
        }
        WeakReference<a> weakReference = bVar.f109271d;
        if (weakReference != null) {
            aVar = weakReference.get();
        } else {
            aVar = null;
        }
        if (aVar == null) {
            QLog.e("GdtKuiklyDexManager", 1, "[notifyListenerImpl] error, listener is null, errorCode:" + i3 + " params:" + bVar + " result:" + cVar);
            return;
        }
        QLog.i("GdtKuiklyDexManager", 1, "[notifyListenerImpl] errorCode:" + i3 + " params:" + bVar + " result:" + cVar);
        aVar.a(i3, bVar, cVar);
    }
}
