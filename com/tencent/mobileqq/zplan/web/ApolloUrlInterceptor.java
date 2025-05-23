package com.tencent.mobileqq.zplan.web;

import android.net.Uri;
import android.net.http.Headers;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.zplan.web.ApolloSSOConfig;
import com.tencent.mobileqq.zplan.web.ApolloUrlConnection;
import com.tencent.mobileqq.zplan.web.api.IZPlanWebDataHandler;
import com.tencent.mobileqq.zplan.web.api.impl.ZPlanWebDataHandlerImpl;
import com.tencent.mobileqq.zplan.web.d;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes34.dex */
public class ApolloUrlInterceptor implements d.a, Handler.Callback {
    public static String W = HardCodeUtil.qqStr(R.string.jla);
    private static long X = new Random().nextInt(263167);
    private final String E;
    public final String G;
    private String H;
    private volatile CustomWebView I;
    private String J;
    private volatile ApolloUrlConnection L;
    private Message M;
    private volatile InputStream N;
    private String Q;
    private boolean S;
    private String T;
    private boolean U;

    /* renamed from: d, reason: collision with root package name */
    private final AtomicInteger f335997d = new AtomicInteger(0);

    /* renamed from: e, reason: collision with root package name */
    private final AtomicBoolean f335998e = new AtomicBoolean(false);

    /* renamed from: f, reason: collision with root package name */
    private final AtomicBoolean f335999f = new AtomicBoolean(false);

    /* renamed from: h, reason: collision with root package name */
    private final AtomicBoolean f336000h = new AtomicBoolean(false);

    /* renamed from: i, reason: collision with root package name */
    private final AtomicBoolean f336001i = new AtomicBoolean(false);

    /* renamed from: m, reason: collision with root package name */
    private final AtomicBoolean f336002m = new AtomicBoolean(false);
    private final AtomicBoolean C = new AtomicBoolean(false);
    private final AtomicBoolean D = new AtomicBoolean(false);
    private volatile boolean F = false;
    private final Handler K = new Handler(Looper.getMainLooper(), this);
    private boolean P = true;
    private b R = new b();
    private ConcurrentHashMap<String, PreloadCGITask> V = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class PreloadCGITask {

        /* renamed from: a, reason: collision with root package name */
        private ApolloSSOConfig.c f336004a;

        /* renamed from: b, reason: collision with root package name */
        private ApolloUrlConnection f336005b;

        /* renamed from: c, reason: collision with root package name */
        private d f336006c;

        /* renamed from: f, reason: collision with root package name */
        private long f336009f;

        /* renamed from: g, reason: collision with root package name */
        private volatile boolean f336010g;

        /* renamed from: d, reason: collision with root package name */
        private AtomicBoolean f336007d = new AtomicBoolean(false);

        /* renamed from: e, reason: collision with root package name */
        private AtomicInteger f336008e = new AtomicInteger(0);

        /* renamed from: h, reason: collision with root package name */
        private HashMap<String, String> f336011h = new HashMap<>();

        PreloadCGITask(ApolloSSOConfig.c cVar) {
            this.f336004a = cVar;
        }

        private void b(long j3) {
            JSONObject optJSONObject;
            try {
                if (ApolloUrlInterceptor.this.R == null || this.f336004a == null || (optJSONObject = ApolloUrlInterceptor.this.R.f336036l.optJSONObject(this.f336004a.f335974a)) == null) {
                    return;
                }
                optJSONObject.put("costTime", j3);
                ApolloUrlInterceptor.this.R.f336036l.put(this.f336004a.f335974a, optJSONObject);
            } catch (Exception e16) {
                QLog.e("[zplan]Apollo_client_PreloadCGITask", 1, e16, new Object[0]);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e() {
            String str;
            ApolloSSOConfig.c cVar = this.f336004a;
            if (cVar == null || !cVar.a()) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            ApolloSSOConfig.c cVar2 = this.f336004a;
            this.f336005b = new ApolloUrlConnection(cVar2.f335974a, true, cVar2, a.f(ApolloUrlInterceptor.this.J));
            long currentTimeMillis2 = System.currentTimeMillis();
            if (this.f336010g) {
                return;
            }
            int b16 = this.f336005b.b();
            this.f336008e.set(1);
            if (b16 == 0) {
                if (QLog.isColorLevel()) {
                    QLog.d("[zplan]Apollo_client_PreloadCGITask", 2, "task(" + this.f336004a.f335974a + ") connection connect cost = " + (System.currentTimeMillis() - currentTimeMillis2) + " ms.");
                }
                long currentTimeMillis3 = System.currentTimeMillis();
                b16 = this.f336005b.d();
                if (QLog.isColorLevel()) {
                    QLog.d("[zplan]Apollo_client_PreloadCGITask", 2, "task(" + this.f336004a.f335974a + ") connection response cost = " + (System.currentTimeMillis() - currentTimeMillis3) + " ms.");
                }
                long currentTimeMillis4 = System.currentTimeMillis();
                Map<String, List<String>> f16 = this.f336005b.f();
                if (QLog.isColorLevel()) {
                    QLog.d("[zplan]Apollo_client_PreloadCGITask", 2, "task(" + this.f336004a.f335974a + ") connection get header fields cost = " + (System.currentTimeMillis() - currentTimeMillis4) + " ms.");
                }
                if (f16 != null) {
                    if (f16.containsKey("Set-Cookie")) {
                        str = "Set-Cookie";
                    } else {
                        str = f16.containsKey(Headers.SET_COOKIE) ? Headers.SET_COOKIE : null;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        a.i(this.f336004a.f335974a, f16.get(str));
                    }
                    for (Map.Entry<String, List<String>> entry : f16.entrySet()) {
                        String key = entry.getKey();
                        List<String> value = entry.getValue();
                        if (value != null && value.size() > 0) {
                            this.f336011h.put(key, value.get(0));
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("[zplan]Apollo_client_PreloadCGITask", 2, "task(" + this.f336004a.f335974a + ") mHeaderMap:" + this.f336011h);
                    }
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("[zplan]Apollo_client_PreloadCGITask", 4, "task(" + this.f336004a.f335974a + ") handleFlow_Connection: respCode = " + b16 + ", cost " + (System.currentTimeMillis() - currentTimeMillis) + " ms.");
            }
            if (ApolloUrlInterceptor.this.z()) {
                if (QLog.isColorLevel()) {
                    QLog.d("[zplan]Apollo_client_PreloadCGITask", 6, "task(" + this.f336004a.f335974a + ") handleFlow_Connection: destroy before server response.");
                }
                ApolloUrlConnection apolloUrlConnection = this.f336005b;
                if (apolloUrlConnection != null) {
                    apolloUrlConnection.c();
                    this.f336005b = null;
                }
                this.f336008e.set(2);
                synchronized (this.f336008e) {
                    this.f336008e.notifyAll();
                }
                long currentTimeMillis5 = System.currentTimeMillis() - currentTimeMillis;
                this.f336009f = currentTimeMillis5;
                b(currentTimeMillis5);
                return;
            }
            if (200 != b16) {
                ApolloUrlConnection apolloUrlConnection2 = this.f336005b;
                if (apolloUrlConnection2 != null) {
                    apolloUrlConnection2.c();
                    this.f336005b = null;
                }
                this.f336006c = null;
                if (QLog.isColorLevel()) {
                    QLog.d("[zplan]Apollo_client_PreloadCGITask", 4, "task(" + this.f336004a.f335974a + ") handleFlow_Connection: response code not 200, response code = " + b16);
                }
                this.f336008e.set(2);
                synchronized (this.f336008e) {
                    this.f336008e.notifyAll();
                }
                long currentTimeMillis6 = System.currentTimeMillis() - currentTimeMillis;
                this.f336009f = currentTimeMillis6;
                b(currentTimeMillis6);
                return;
            }
            if (this.f336010g) {
                return;
            }
            ApolloUrlConnection.a e16 = this.f336005b.e(this.f336007d, null);
            if (e16 == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("[zplan]Apollo_client_PreloadCGITask", 2, "task(" + this.f336004a.f335974a + ") handleFlow_FirstLoad error:responseDataTuple is null!");
                }
                this.f336006c = null;
                this.f336008e.set(2);
                synchronized (this.f336008e) {
                    this.f336008e.notifyAll();
                }
                long currentTimeMillis7 = System.currentTimeMillis() - currentTimeMillis;
                this.f336009f = currentTimeMillis7;
                b(currentTimeMillis7);
                return;
            }
            if (this.f336010g) {
                return;
            }
            this.f336006c = new d(null, e16.f335996c, e16.f335995b);
            this.f336008e.set(2);
            synchronized (this.f336008e) {
                this.f336008e.notifyAll();
            }
            long currentTimeMillis8 = System.currentTimeMillis() - currentTimeMillis;
            this.f336009f = currentTimeMillis8;
            b(currentTimeMillis8);
            if (QLog.isColorLevel()) {
                QLog.d("[zplan]Apollo_client_PreloadCGITask", 2, "task(" + this.f336004a.f335974a + ") mCostTime:" + this.f336009f);
            }
        }

        public void c() {
            ApolloUrlConnection apolloUrlConnection = this.f336005b;
            if (apolloUrlConnection != null) {
                apolloUrlConnection.c();
                this.f336005b = null;
            }
            if (this.f336006c != null) {
                this.f336006c = null;
            }
            QLog.d("[zplan]Apollo_client_PreloadCGITask", 1, "PreloadCGITask onDestroy ");
        }

        public void d() {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.web.ApolloUrlInterceptor.PreloadCGITask.1
                @Override // java.lang.Runnable
                public void run() {
                    PreloadCGITask.this.e();
                }
            }, 128, null, false);
        }
    }

    public ApolloUrlInterceptor(String str, String str2) {
        this.E = str2;
        long j3 = X;
        X = 1 + j3;
        String valueOf = String.valueOf(j3);
        this.G = valueOf;
        String a16 = a.a(str, "apollo_task_id", String.valueOf(valueOf));
        this.H = a16;
        this.J = a16;
        if (QLog.isColorLevel()) {
            QLog.d("[zplan]apollo_client_ApolloUrlInterceptor", 2, "task(" + valueOf + ") create:id=" + valueOf + ", url = " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean D() {
        if (!this.C.get() || !j()) {
            return false;
        }
        this.K.sendEmptyMessage(10);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        long currentTimeMillis = System.currentTimeMillis();
        AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
        if (appInterface != null && !TextUtils.isEmpty(this.E)) {
            ZPlanWebDataHandlerImpl zPlanWebDataHandlerImpl = (ZPlanWebDataHandlerImpl) QRoute.api(IZPlanWebDataHandler.class);
            zPlanWebDataHandlerImpl.preLoadSSOCmd(BaseApplication.getContext(), this.E, this.J, appInterface, this.R);
            List<ApolloSSOConfig.c> cGIConfigs = zPlanWebDataHandlerImpl.getCGIConfigs(this.E);
            if (cGIConfigs != null && !cGIConfigs.isEmpty()) {
                for (ApolloSSOConfig.c cVar : cGIConfigs) {
                    if (cVar.a()) {
                        PreloadCGITask preloadCGITask = new PreloadCGITask(cVar);
                        this.V.put(cVar.f335974a, preloadCGITask);
                        preloadCGITask.d();
                    }
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("[zplan]apollo_client_ApolloUrlInterceptor", 2, "preloadSSOData use:" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        if (1 != this.f335997d.get()) {
            if (QLog.isColorLevel()) {
                QLog.d("[zplan]apollo_client_ApolloUrlInterceptor", 2, "task(" + this.G + ") runDataTask error:sessionState=" + this.f335997d.get() + ".");
            }
            this.S = true;
            this.D.set(false);
            this.K.sendEmptyMessage(3);
            return;
        }
        this.K.removeMessages(255);
        long currentTimeMillis = System.currentTimeMillis();
        String c16 = a.c(this.J);
        this.Q = c16;
        if (TextUtils.isEmpty(c16)) {
            if (QLog.isColorLevel()) {
                QLog.d("[zplan]apollo_client_ApolloUrlInterceptor", 2, "task(" + this.G + ") runDataTask error:fileName is null");
            }
            this.S = true;
            this.D.set(false);
            this.K.sendEmptyMessage(3);
            return;
        }
        String d16 = a.d(this.Q);
        if (QLog.isColorLevel()) {
            QLog.d("[zplan]apollo_client_ApolloUrlInterceptor", 2, "task(" + this.G + ") runDataTask url is " + this.J + " filePath is " + d16);
        }
        File file = new File(d16);
        String h16 = a.h(file);
        this.R.f336029e = System.currentTimeMillis() - currentTimeMillis;
        boolean z16 = !TextUtils.isEmpty(h16);
        if (z16) {
            long currentTimeMillis2 = System.currentTimeMillis();
            if (!((ZPlanWebDataHandlerImpl) QRoute.api(IZPlanWebDataHandler.class)).verifyCache(this.E, h16)) {
                file.delete();
                if (QLog.isColorLevel()) {
                    QLog.d("[zplan]apollo_client_ApolloUrlInterceptor", 2, "task(" + this.G + ") runDataTask md5 not match delete localFile! url is " + this.J);
                }
                this.R.f336033i = 1;
                h16 = null;
                z16 = false;
            } else {
                this.R.f336033i = 2;
            }
            this.R.f336030f = System.currentTimeMillis() - currentTimeMillis2;
            if (QLog.isColorLevel()) {
                QLog.d("[zplan]apollo_client_ApolloUrlInterceptor", 2, "verify use:" + (System.currentTimeMillis() - currentTimeMillis2));
            }
        } else {
            this.R.f336033i = 0;
        }
        if (QLog.isColorLevel()) {
            QLog.d("[zplan]apollo_client_ApolloUrlInterceptor", 2, "get LocalFile use:" + (System.currentTimeMillis() - currentTimeMillis));
        }
        Message obtainMessage = this.K.obtainMessage(1);
        this.M = obtainMessage;
        if (z16) {
            obtainMessage.arg1 = 2;
            obtainMessage.obj = h16;
            this.K.sendMessage(obtainMessage);
            if (QLog.isColorLevel()) {
                QLog.d("[zplan]apollo_client_ApolloUrlInterceptor", 2, "task(" + this.G + ") runDataTask hasHtmlCache:" + z16);
            }
            this.T = h16;
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("[zplan]apollo_client_ApolloUrlInterceptor", 2, "task(" + this.G + ") runDataTask has no cache, do first load flow.");
            }
            obtainMessage.arg1 = 1;
            this.K.sendMessage(obtainMessage);
            if (!NetworkUtil.isNetworkAvailable(BaseApplication.getContext())) {
                if (!TextUtils.isEmpty(W)) {
                    this.K.sendEmptyMessageDelayed(255, 1500L);
                }
                if (QLog.isColorLevel()) {
                    QLog.d("[zplan]apollo_client_ApolloUrlInterceptor", 1, "task(" + this.G + ") runDataTask error:network is not valid!");
                }
            } else {
                t();
            }
        }
        I(1, 2, true);
        this.D.set(false);
        if (D() && QLog.isColorLevel()) {
            QLog.d("[zplan]apollo_client_ApolloUrlInterceptor", 4, "task(" + this.G + ") runDataTask:send force destroy message.");
        }
    }

    private boolean I(int i3, int i16, boolean z16) {
        if (!this.f335997d.compareAndSet(i3, i16)) {
            return false;
        }
        if (!z16) {
            return true;
        }
        synchronized (this.f335997d) {
            this.f335997d.notify();
        }
        return true;
    }

    private boolean j() {
        if (!this.D.get() && !this.f336002m.get()) {
            return true;
        }
        if (!QLog.isColorLevel()) {
            return false;
        }
        QLog.d("[zplan]apollo_client_ApolloUrlInterceptor", 2, "task(" + this.G + ") canDestroy:false, isWaitingForSessionThread=" + this.D.get() + ", isWaitingForBlinkCloseStream=" + this.f336002m.get() + " isWaitingForDestroy:" + this.C);
        return false;
    }

    public static ApolloUrlInterceptor k(boolean z16, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ZPlanWebDataHandlerImpl zPlanWebDataHandlerImpl = (ZPlanWebDataHandlerImpl) QRoute.api(IZPlanWebDataHandler.class);
        String apolloClientId = zPlanWebDataHandlerImpl.getApolloClientId(str);
        if (!zPlanWebDataHandlerImpl.isApolloClientId(apolloClientId)) {
            return null;
        }
        ApolloUrlInterceptor apolloUrlInterceptor = new ApolloUrlInterceptor(str, apolloClientId);
        if (QLog.isColorLevel()) {
            QLog.d("[zplan]apollo_client_ApolloUrlInterceptor", 2, "createInterceptor startSessionNewThread:" + z16 + ",use:" + (System.currentTimeMillis() - currentTimeMillis));
        }
        apolloUrlInterceptor.H(z16);
        return apolloUrlInterceptor;
    }

    private void m(boolean z16) {
        int i3 = this.f335997d.get();
        if (3 == i3) {
            return;
        }
        this.I = null;
        this.N = null;
        this.T = null;
        if (this.M != null) {
            this.M = null;
        }
        if (!z16 && !j()) {
            this.K.removeMessages(255);
            if (this.C.compareAndSet(false, true)) {
                this.K.sendEmptyMessageDelayed(10, 6000L);
                if (QLog.isColorLevel()) {
                    QLog.d("[zplan]apollo_client_ApolloUrlInterceptor", 2, "task(" + this.G + ") waiting for destroy, current state =" + i3 + ".");
                    return;
                }
                return;
            }
            return;
        }
        if (this.L != null && !z16) {
            this.L.c();
            this.L = null;
        }
        this.f335997d.set(3);
        synchronized (this.f335997d) {
            this.f335997d.notify();
        }
        this.K.removeMessages(10);
        this.C.set(false);
        if (QLog.isColorLevel()) {
            QLog.d("[zplan]apollo_client_ApolloUrlInterceptor", 2, "task(" + this.G + ") final destroy, force=" + z16 + ".");
        }
        this.K.removeMessages(255);
        Iterator<PreloadCGITask> it = this.V.values().iterator();
        while (it.hasNext()) {
            it.next().c();
        }
        this.V.clear();
    }

    private boolean n(Message message) {
        int i3 = message.what;
        if (i3 == 1) {
            int i16 = message.arg1;
            if (i16 == 1) {
                x();
                return false;
            }
            if (i16 != 2) {
                return false;
            }
            y(message);
            return false;
        }
        if (i3 == 2) {
            int i17 = message.arg1;
            if (i17 == 1) {
                r();
                return false;
            }
            if (i17 != 2) {
                return false;
            }
            s(message);
            return false;
        }
        if (i3 == 3 || i3 == 5) {
            q();
            return false;
        }
        if (i3 != 255) {
            if (QLog.isColorLevel()) {
                QLog.d("[zplan]apollo_client_ApolloUrlInterceptor", 2, "msg.what " + message.what);
            }
            return true;
        }
        v();
        return false;
    }

    private void q() {
        if (this.f336000h.compareAndSet(false, true)) {
            if (QLog.isColorLevel()) {
                QLog.d("[zplan]apollo_client_ApolloUrlInterceptor", 2, "handleClientCoreMessage_ConnectionError: load src url.");
            }
            if (this.I != null) {
                this.I.loadUrlOriginal(this.J);
            }
        }
    }

    private void r() {
        if (this.f335998e.get()) {
            if (QLog.isColorLevel()) {
                QLog.d("[zplan]apollo_client_ApolloUrlInterceptor", 2, "task(" + this.G + ") handleClientCoreMessage_FirstLoad:FIRST_LOAD_NO_CACHE.");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("[zplan]apollo_client_ApolloUrlInterceptor", 2, "task(" + this.G + ") handleClientCoreMessage_FirstLoad:url was not invoked.");
        }
    }

    private void s(Message message) {
        if (this.f336000h.compareAndSet(false, true)) {
            if (QLog.isColorLevel()) {
                QLog.d("[zplan]apollo_client_ApolloUrlInterceptor", 2, "task(\" + id + \") handleClientCoreMessage_FirstLoad with cache, url:" + this.J);
            }
            this.U = true;
            this.R.f336035k = System.currentTimeMillis();
            if (this.I != null) {
                if (this.I.getX5WebViewExtension() != null) {
                    CustomWebView customWebView = this.I;
                    String str = this.J;
                    customWebView.loadDataWithBaseURL(str, (String) message.obj, "text/html", "utf-8", str);
                    return;
                } else {
                    this.I.loadUrlOriginal(this.J);
                    QLog.e("[zplan]apollo_client_ApolloUrlInterceptor", 1, "handleMessage CLIENT_CORE_MSG_FIRST_LOAD PRE_LOAD_WITH_CACHE but not x5 Core");
                    return;
                }
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("[zplan]apollo_client_ApolloUrlInterceptor", 2, "task(" + this.G + ") FIRST_LOAD_WITH_CACHE load url was invoked.");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x00ce, code lost:
    
        if (r11.containsKey(android.net.http.Headers.SET_COOKIE) != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void t() {
        long currentTimeMillis = System.currentTimeMillis();
        String str = null;
        this.L = new ApolloUrlConnection(this.J, true, null, null);
        long currentTimeMillis2 = System.currentTimeMillis();
        int b16 = this.L.b();
        if (b16 == 0) {
            if (QLog.isColorLevel()) {
                QLog.d("[zplan]apollo_client_ApolloUrlInterceptor", 2, "task(" + this.G + ") connection connect cost = " + (System.currentTimeMillis() - currentTimeMillis2) + " ms.");
            }
            long currentTimeMillis3 = System.currentTimeMillis();
            b16 = this.L.d();
            if (QLog.isColorLevel()) {
                QLog.d("[zplan]apollo_client_ApolloUrlInterceptor", 2, "task(" + this.G + ") connection response cost = " + (System.currentTimeMillis() - currentTimeMillis3) + " ms.");
            }
            long currentTimeMillis4 = System.currentTimeMillis();
            Map<String, List<String>> f16 = this.L.f();
            if (QLog.isColorLevel()) {
                QLog.d("[zplan]apollo_client_ApolloUrlInterceptor", 2, "task(" + this.G + ") connection get header fields cost = " + (System.currentTimeMillis() - currentTimeMillis4) + " ms.");
            }
            if (f16 != null) {
                String str2 = "Set-Cookie";
                if (!f16.containsKey("Set-Cookie")) {
                    str2 = Headers.SET_COOKIE;
                }
                str = str2;
                if (!TextUtils.isEmpty(str)) {
                    a.i(this.J, f16.get(str));
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("[zplan]apollo_client_ApolloUrlInterceptor", 4, "task(" + this.G + ") handleFlow_Connection: respCode = " + b16 + ", cost " + (System.currentTimeMillis() - currentTimeMillis) + " ms.");
        }
        if (z()) {
            if (QLog.isColorLevel()) {
                QLog.d("[zplan]apollo_client_ApolloUrlInterceptor", 6, "task(" + this.G + ") handleFlow_Connection: destroy before server response.");
                return;
            }
            return;
        }
        if (200 != b16) {
            if (this.P) {
                this.K.removeMessages(1);
                Message obtainMessage = this.K.obtainMessage(5);
                obtainMessage.arg1 = b16;
                this.K.sendMessage(obtainMessage);
            }
            if (QLog.isColorLevel()) {
                QLog.d("[zplan]apollo_client_ApolloUrlInterceptor", 4, "task(" + this.G + ") handleFlow_Connection: response code not 200, response code = " + b16);
                return;
            }
            return;
        }
        u();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00c7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void u() {
        String str;
        boolean z16;
        String str2 = null;
        ApolloUrlConnection.a e16 = this.L.e(this.f335998e, null);
        if (e16 == null) {
            if (QLog.isColorLevel()) {
                QLog.d("[zplan]apollo_client_ApolloUrlInterceptor", 2, "task(" + this.G + ") handleFlow_FirstLoad error:responseDataTuple is null!");
            }
            this.S = true;
            this.K.sendEmptyMessage(3);
            return;
        }
        this.N = new d(this, e16.f335996c, e16.f335995b);
        if (e16.f335994a) {
            try {
                str = e16.f335996c.toString("UTF-8");
            } catch (Throwable th5) {
                th = th5;
                str = null;
            }
            try {
                this.T = str;
            } catch (Throwable th6) {
                th = th6;
                this.N = null;
                if (QLog.isColorLevel()) {
                    QLog.d("[zplan]apollo_client_ApolloUrlInterceptor", 2, "task(" + this.G + ") handleFlow_FirstLoad error:" + th.getMessage() + ".");
                }
                str2 = str;
                z16 = !TextUtils.isEmpty(str2);
                if (QLog.isColorLevel()) {
                }
                this.K.removeMessages(1);
                Message obtainMessage = this.K.obtainMessage(2);
                obtainMessage.obj = str2;
                obtainMessage.arg1 = z16 ? 2 : 1;
                this.M = obtainMessage;
                this.K.sendMessage(obtainMessage);
                if (z16) {
                    return;
                } else {
                    return;
                }
            }
            str2 = str;
        }
        z16 = !TextUtils.isEmpty(str2);
        if (QLog.isColorLevel()) {
            QLog.d("[zplan]apollo_client_ApolloUrlInterceptor", 4, "task(" + this.G + ") handleFlow_FirstLoad:hasCacheData=" + z16 + ".");
        }
        this.K.removeMessages(1);
        Message obtainMessage2 = this.K.obtainMessage(2);
        obtainMessage2.obj = str2;
        obtainMessage2.arg1 = z16 ? 2 : 1;
        this.M = obtainMessage2;
        this.K.sendMessage(obtainMessage2);
        if (z16 || this.F) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        ((ZPlanWebDataHandlerImpl) QRoute.api(IZPlanWebDataHandler.class)).saveHtml(this.J, str2);
        this.F = true;
        if (QLog.isColorLevel()) {
            QLog.d("[zplan]apollo_client_ApolloUrlInterceptor", 4, "task(" + this.G + ") handleFlow_FirstLoad :save htmlString " + (System.currentTimeMillis() - currentTimeMillis) + " ms.");
        }
    }

    private void v() {
        if (!this.f335999f.get() || z() || TextUtils.isEmpty(W)) {
            return;
        }
        Toast.makeText(BaseApplication.getContext(), W, 1).show();
    }

    private boolean w(Message message) {
        int i3 = message.what;
        if (i3 <= 0 || i3 >= 7 || this.f335999f.get()) {
            return false;
        }
        this.M = Message.obtain(message);
        if (!QLog.isColorLevel()) {
            return true;
        }
        QLog.d("[zplan]apollo_client_ApolloUrlInterceptor", 2, "task(" + this.G + ") handleMessage: client not ready, core msg = " + message.what + ".");
        return true;
    }

    private void x() {
        if (this.f336000h.compareAndSet(false, true)) {
            if (QLog.isColorLevel()) {
                QLog.d("[zplan]apollo_client_ApolloUrlInterceptor", 2, "task(" + this.G + ") handleClientCoreMessage_PreLoad:PRE_LOAD_NO_CACHE load url.");
            }
            this.R.f336035k = System.currentTimeMillis();
            if (this.I != null) {
                this.I.loadUrlOriginal(this.J);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("[zplan]apollo_client_ApolloUrlInterceptor", 2, "task(" + this.G + ") handleClientCoreMessage_PreLoad:wasLoadUrlInvoked = true.");
        }
    }

    private void y(Message message) {
        if (this.f336001i.compareAndSet(false, true)) {
            if (QLog.isColorLevel()) {
                QLog.d("[zplan]apollo_client_ApolloUrlInterceptor", 2, "task(" + this.G + ") handleClientCoreMessage_PreLoad:PRE_LOAD_WITH_CACHE load data.");
            }
            String str = (String) message.obj;
            this.R.f336035k = System.currentTimeMillis();
            if (this.I != null) {
                if (this.I.getX5WebViewExtension() != null) {
                    CustomWebView customWebView = this.I;
                    String str2 = this.J;
                    customWebView.loadDataWithBaseURL(str2, str, "text/html", "utf-8", str2);
                    return;
                } else {
                    this.I.loadUrlOriginal(this.J);
                    QLog.e("[zplan]apollo_client_ApolloUrlInterceptor", 1, "handleMessage CLIENT_CORE_MSG_PRE_LOAD PRE_LOAD_WITH_CACHE but not x5 Core");
                    return;
                }
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("[zplan]apollo_client_ApolloUrlInterceptor", 2, "task(" + this.G + ") handleClientCoreMessage_PreLoad:wasLoadDataInvoked = true.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean z() {
        return 3 == this.f335997d.get() || this.C.get();
    }

    public boolean A(String str) {
        try {
            Uri parse = Uri.parse(this.J);
            Uri parse2 = Uri.parse(str);
            String str2 = parse.getHost() + parse.getPath();
            String str3 = parse2.getHost() + parse2.getPath();
            if (!parse.getHost().equalsIgnoreCase(parse2.getHost())) {
                return false;
            }
            if (!str2.endsWith("/")) {
                str2 = str2 + "/";
            }
            if (!str3.endsWith("/")) {
                str3 = str3 + "/";
            }
            return str2.equalsIgnoreCase(str3);
        } catch (Throwable th5) {
            QLog.e("[zplan]apollo_client_ApolloUrlInterceptor", 2, "isMatchCurrentUrl error:" + th5.getMessage());
            return false;
        }
    }

    public boolean B() {
        return !this.S;
    }

    public boolean C(String str) {
        if (this.S || !A(str) || !this.f335999f.compareAndSet(false, true)) {
            return false;
        }
        this.J = a.a(str, "apollo_task_id", String.valueOf(this.G));
        this.R.f336034j = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("task(");
            sb5.append(this.G);
            sb5.append(") onWebViewInited: mPendingClientCoreMessage not null:");
            sb5.append(this.M != null);
            sb5.append(",currUrl:");
            sb5.append(this.J);
            QLog.d("[zplan]apollo_client_ApolloUrlInterceptor", 2, sb5.toString());
        }
        Message message = this.M;
        if (message != null) {
            this.M = null;
            handleMessage(message);
        } else if (this.f335997d.get() == 0) {
            H(true);
        }
        return true;
    }

    public boolean G(CustomWebView customWebView) {
        if (this.I != null) {
            return false;
        }
        this.I = customWebView;
        QLog.d("[zplan]apollo_client_ApolloUrlInterceptor", 2, "task(" + this.G + ") bind client.");
        return true;
    }

    public void H(boolean z16) {
        if (!this.f335997d.compareAndSet(0, 1)) {
            if (QLog.isColorLevel()) {
                QLog.d("[zplan]apollo_client_ApolloUrlInterceptor", 2, "task(" + this.G + ") start error:sessionState=" + this.f335997d.get() + ".");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("[zplan]apollo_client_ApolloUrlInterceptor", 2, "task(" + this.G + ") now post task flow task.");
        }
        this.D.set(true);
        if (z16) {
            ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.mobileqq.zplan.web.ApolloUrlInterceptor.1
                @Override // java.lang.Runnable
                public void run() {
                    if (QLog.isColorLevel()) {
                        QLog.d("[zplan]apollo_client_ApolloUrlInterceptor", 2, "runDataTask in AsyncThread start!");
                    }
                    b bVar = ApolloUrlInterceptor.this.R;
                    long currentTimeMillis = System.currentTimeMillis();
                    bVar.f336031g = currentTimeMillis;
                    ApolloUrlInterceptor.this.E();
                    ApolloUrlInterceptor.this.F();
                    if (QLog.isColorLevel()) {
                        QLog.d("[zplan]apollo_client_ApolloUrlInterceptor", 2, "runDataTask use:" + (System.currentTimeMillis() - currentTimeMillis));
                    }
                    ApolloUrlInterceptor.this.R.f336032h = System.currentTimeMillis();
                }
            }, null, true);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("[zplan]apollo_client_ApolloUrlInterceptor", 2, "runDataTask in AsyncThread start!");
        }
        b bVar = this.R;
        long currentTimeMillis = System.currentTimeMillis();
        bVar.f336031g = currentTimeMillis;
        E();
        F();
        if (QLog.isColorLevel()) {
            QLog.d("[zplan]apollo_client_ApolloUrlInterceptor", 2, "runDataTask use:" + (System.currentTimeMillis() - currentTimeMillis));
        }
        this.R.f336032h = System.currentTimeMillis();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (p(message)) {
            return true;
        }
        if (z()) {
            if (!QLog.isColorLevel()) {
                return false;
            }
            QLog.d("[zplan]apollo_client_ApolloUrlInterceptor", 2, "task(" + this.G + ") handleMessage error: is destroyed or waiting for destroy.");
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("[zplan]apollo_client_ApolloUrlInterceptor", 2, "task(" + this.G + ") handleMessage: msg what = " + message.what + ".");
        }
        if (w(message)) {
            return true;
        }
        if (message == this.M) {
            this.M = null;
        }
        return !n(message);
    }

    public b o() {
        return this.R;
    }

    @Override // com.tencent.mobileqq.zplan.web.d.a
    public void onClose(boolean z16, final ByteArrayOutputStream byteArrayOutputStream) {
        if (this.N != null) {
            this.N = null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("[zplan]apollo_client_ApolloUrlInterceptor", 1, "task(" + this.G + ") onClose:readComplete:" + z16);
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (z16 && byteArrayOutputStream != null) {
            ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.zplan.web.ApolloUrlInterceptor.2
                @Override // java.lang.Runnable
                public void run() {
                    String str;
                    if (QLog.isColorLevel()) {
                        QLog.d("[zplan]apollo_client_ApolloUrlInterceptor", 1, "task(" + ApolloUrlInterceptor.this.G + ") onClose:cachedStream size:" + byteArrayOutputStream.size());
                    }
                    if (!ApolloUrlInterceptor.this.F) {
                        try {
                            str = byteArrayOutputStream.toString("UTF-8");
                            byteArrayOutputStream.close();
                        } catch (Throwable th5) {
                            QLog.e("[zplan]apollo_client_ApolloUrlInterceptor", 1, "task(" + ApolloUrlInterceptor.this.G + ") onClose error:" + th5.getMessage());
                            str = null;
                        }
                        if (!TextUtils.isEmpty(str)) {
                            long currentTimeMillis2 = System.currentTimeMillis();
                            ((ZPlanWebDataHandlerImpl) QRoute.api(IZPlanWebDataHandler.class)).saveHtml(ApolloUrlInterceptor.this.J, str);
                            ApolloUrlInterceptor.this.F = true;
                            if (QLog.isColorLevel()) {
                                QLog.d("[zplan]apollo_client_ApolloUrlInterceptor", 4, "task(" + ApolloUrlInterceptor.this.G + ") onClose:save bridgeStream " + (System.currentTimeMillis() - currentTimeMillis2) + " ms. htmlString.length:" + str.length());
                            }
                        }
                    }
                    ApolloUrlInterceptor.this.f336002m.set(false);
                    if (ApolloUrlInterceptor.this.D() && QLog.isColorLevel()) {
                        QLog.d("[zplan]apollo_client_ApolloUrlInterceptor", 4, "task(" + ApolloUrlInterceptor.this.G + ") onClose: postForceDestroyIfNeed send destroy message.");
                    }
                }
            }, 3000L);
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("task(");
            sb5.append(this.G);
            sb5.append(") onClose error:readComplete =");
            sb5.append(z16);
            sb5.append(", outputStream is null -> ");
            sb5.append(byteArrayOutputStream == null);
            QLog.e("[zplan]apollo_client_ApolloUrlInterceptor", 6, sb5.toString());
        }
        this.f336002m.set(false);
        if (D()) {
            QLog.d("[zplan]apollo_client_ApolloUrlInterceptor", 2, "task(" + this.G + ") onClose: postForceDestroyIfNeed send destroy message in chromium_io thread.");
        }
        if (QLog.isColorLevel()) {
            QLog.d("[zplan]apollo_client_ApolloUrlInterceptor", 6, "task(" + this.G + ") onClose cost " + (System.currentTimeMillis() - currentTimeMillis) + " ms.");
        }
    }

    public void l() {
        m(false);
    }

    private boolean p(Message message) {
        if (10 != message.what) {
            return false;
        }
        m(true);
        if (QLog.isColorLevel()) {
            QLog.d("[zplan]apollo_client_ApolloUrlInterceptor", 2, "task(" + this.G + ") handleMessage:force destroy.");
        }
        return true;
    }
}
