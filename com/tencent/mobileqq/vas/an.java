package com.tencent.mobileqq.vas;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngSoLoader;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.soload.api.SoLoadManager;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class an extends QIPCModule implements ApngSoLoader {

    /* renamed from: i, reason: collision with root package name */
    private static an f308417i = null;

    /* renamed from: m, reason: collision with root package name */
    public static String f308418m = "action_download_apng_so";

    /* renamed from: d, reason: collision with root package name */
    private volatile boolean f308419d;

    /* renamed from: e, reason: collision with root package name */
    private volatile long f308420e;

    /* renamed from: f, reason: collision with root package name */
    private CopyOnWriteArrayList<Integer> f308421f;

    /* renamed from: h, reason: collision with root package name */
    private CopyOnWriteArrayList<URLDrawableHandler> f308422h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements EIPCResultCallback {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ URLDrawableHandler f308423d;

        a(URLDrawableHandler uRLDrawableHandler) {
            this.f308423d = uRLDrawableHandler;
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            an.this.l(this.f308423d, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b implements OnLoadListener {
        b() {
        }

        @Override // com.tencent.mobileqq.soload.biz.OnLoadListener
        public void onLoadResult(int i3, LoadExtResult loadExtResult) {
            if (i3 == 0) {
                an.this.f308419d = true;
                an.this.f308420e = System.currentTimeMillis();
                QLog.d("VasApngUtil.IPCModule", 1, "SoManager libAPNG.so load success.");
            } else {
                an.this.f308419d = false;
                an.this.f308420e = 0L;
                QLog.d("VasApngUtil.IPCModule", 1, "SoManager libAPNG.so load failed. code=" + i3);
                ReportController.o(null, "CliOper", "", "", "Font_Mall", "0X80073FE", 0, 0, "101", "", "", "");
            }
            an.this.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class c implements OnLoadListener {
        c() {
        }

        @Override // com.tencent.mobileqq.soload.biz.OnLoadListener
        public void onLoadResult(int i3, LoadExtResult loadExtResult) {
            QLog.i("VasApngUtil.IPCModule", 1, "SoManager download isSuccess:" + loadExtResult.isSucc());
        }
    }

    an(String str) {
        super(str);
        this.f308421f = new CopyOnWriteArrayList<>();
        this.f308422h = new CopyOnWriteArrayList<>();
    }

    private void e(int i3) {
        callbackResult(i3, EIPCResult.createResult(0, null));
    }

    private boolean f(QQAppInterface qQAppInterface) {
        if (k()) {
            g();
            return true;
        }
        return true;
    }

    private synchronized void g() {
        if (!j()) {
            return;
        }
        if (i()) {
            QLog.d("VasApngUtil.IPCModule", 1, "SoManager libAPNG.so loading.");
            return;
        }
        QLog.d("VasApngUtil.IPCModule", 1, "SoManager libAPNG.so load begin.");
        this.f308420e = System.currentTimeMillis();
        SoLoadManager.getInstance().load("APNG", new b());
    }

    public static synchronized an h() {
        an anVar;
        synchronized (an.class) {
            if (f308417i == null) {
                f308417i = new an("VasApngIPCModule");
            }
            anVar = f308417i;
        }
        return anVar;
    }

    private boolean i() {
        if (System.currentTimeMillis() - this.f308420e < 20000) {
            return true;
        }
        return false;
    }

    private boolean j() {
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ != null && mobileQQ.peekAppRuntime() != null) {
            boolean z16 = !TextUtils.isEmpty(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin());
            if (!z16) {
                QLog.i("VasApngUtil.IPCModule", 1, "\u672a\u767b\u5f55\uff0c\u622a\u65admanager\u914d\u7f6e\u76f8\u5173\u64cd\u4f5c.");
            }
            return z16;
        }
        QLog.i("VasApngUtil.IPCModule", 1, "\u672a\u521d\u59cb\u5316\uff0c\u622a\u65admanager\u914d\u7f6e\u76f8\u5173\u64cd\u4f5c.");
        return false;
    }

    private boolean k() {
        return VasToggle.isEnable(VasToggle.APNG_SO, false);
    }

    private boolean m() {
        if (!VasToggle.APNG_SO_LOCAL.isEnable(true)) {
            QLog.i("VasApngUtil.IPCModule", 1, "disable local so");
            return false;
        }
        try {
            System.loadLibrary("apng");
            this.f308419d = true;
            QLog.i("VasApngUtil.IPCModule", 1, "load apng-so local at " + Thread.currentThread());
            return true;
        } catch (Throwable th5) {
            QLog.e("VasApngUtil.IPCModule", 1, th5, new Object[0]);
            return false;
        }
    }

    private synchronized boolean n() {
        if (!j()) {
            return false;
        }
        if (!SoLoadManager.getInstance().isExist("APNG")) {
            SoLoadManager.getInstance().download("APNG", new c());
            return false;
        }
        boolean isSucc = SoLoadManager.getInstance().loadSync("APNG").isSucc();
        this.f308419d = isSucc;
        QLog.d("VasApngUtil.IPCModule", 1, "SoManager libAPNG.so syncLoadBySoManager isSuccess:" + isSucc);
        return isSucc;
    }

    void d() {
        ArrayList arrayList = new ArrayList();
        Iterator<URLDrawableHandler> it = this.f308422h.iterator();
        while (it.hasNext()) {
            URLDrawableHandler next = it.next();
            l(next, false);
            arrayList.add(next);
        }
        this.f308422h.removeAll(arrayList);
        ArrayList arrayList2 = new ArrayList();
        Iterator<Integer> it5 = this.f308421f.iterator();
        while (it5.hasNext()) {
            Integer next2 = it5.next();
            e(next2.intValue());
            arrayList2.add(next2);
        }
        this.f308421f.removeAll(arrayList2);
    }

    public void download() {
        l(new URLDrawableHandler.Adapter(), true);
    }

    @Override // com.tencent.image.SoLoader
    public boolean isLoaded() {
        return this.f308419d;
    }

    public void l(URLDrawableHandler uRLDrawableHandler, boolean z16) {
        if (this.f308419d) {
            QLog.e("VasApngUtil.IPCModule", 1, "load by others");
            uRLDrawableHandler.onFileDownloadSucceed(0L);
            return;
        }
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        if (application == null) {
            QLog.e("VasApngUtil.IPCModule", 1, "load fail null application");
            uRLDrawableHandler.onFileDownloadFailed(10000);
            return;
        }
        if (loadSoLib()) {
            QLog.e("VasApngUtil.IPCModule", 1, "load exists so success");
            uRLDrawableHandler.onFileDownloadSucceed(0L);
            return;
        }
        if (!z16) {
            QLog.e("VasApngUtil.IPCModule", 1, "second try so not exists");
            uRLDrawableHandler.onFileDownloadFailed(10001);
            return;
        }
        if (com.tencent.mobileqq.utils.ah.s0()) {
            QLog.e("VasApngUtil.IPCModule", 1, "isX86 can't download apng.so");
            uRLDrawableHandler.onFileDownloadFailed(10004);
            return;
        }
        AppRuntime runtime = application.getRuntime();
        if (runtime == null) {
            QLog.e("VasApngUtil.IPCModule", 1, "load fail null runtime");
            uRLDrawableHandler.onFileDownloadFailed(10002);
        } else {
            if (runtime instanceof QQAppInterface) {
                this.f308422h.add(uRLDrawableHandler);
                if (!f((QQAppInterface) runtime)) {
                    this.f308422h.remove(uRLDrawableHandler);
                    uRLDrawableHandler.onFileDownloadFailed(10003);
                    return;
                }
                return;
            }
            QLog.e("VasApngUtil.IPCModule", 1, "child progress callServer to load");
            QIPCClientHelper.getInstance().callServer("VasApngIPCModule", f308418m, null, new a(uRLDrawableHandler));
        }
    }

    @Override // com.tencent.image.SoLoader
    public void load(URLDrawableHandler uRLDrawableHandler) {
        l(uRLDrawableHandler, true);
    }

    public synchronized boolean loadSoLib() {
        boolean m3;
        if (this.f308419d) {
            if (QLog.isColorLevel()) {
                QLog.d("VasApngUtil.IPCModule", 2, "loadSoLib: already loaded");
            }
            return true;
        }
        if (k()) {
            m3 = n();
        } else {
            m3 = m();
        }
        return m3;
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        Object runtime;
        if (QLog.isColorLevel()) {
            QLog.d("VasApngUtil.IPCModule", 2, "onCall action = " + str);
        }
        if (f308418m.equals(str)) {
            this.f308421f.add(Integer.valueOf(i3));
            BaseApplicationImpl application = BaseApplicationImpl.getApplication();
            if (application == null) {
                runtime = null;
            } else {
                runtime = application.getRuntime();
            }
            if (application != null && (runtime instanceof QQAppInterface) && f((QQAppInterface) runtime)) {
                return null;
            }
            QLog.e("VasApngUtil.IPCModule", 1, "download fail to start, application:" + application + " runtime:" + runtime);
            e(i3);
            try {
                this.f308421f.remove(i3);
            } catch (Exception e16) {
                QLog.e("VasApngUtil.IPCModule", 1, "callbacks.remove error : " + e16.getMessage());
            }
        } else if (QLog.isColorLevel()) {
            QLog.d("VasApngUtil.IPCModule", 2, "onCall action = " + str);
        }
        return null;
    }
}
