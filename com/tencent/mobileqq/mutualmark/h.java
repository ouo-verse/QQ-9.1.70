package com.tencent.mobileqq.mutualmark;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ar.i;
import com.tencent.mobileqq.portal.o;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.predownload.HttpEngineTask;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes15.dex */
public class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    WeakReference<IPreDownloadController> f252057a;

    /* renamed from: b, reason: collision with root package name */
    ArrayList<String> f252058b;

    /* renamed from: c, reason: collision with root package name */
    ArrayList<c> f252059c;

    /* renamed from: d, reason: collision with root package name */
    boolean f252060d;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements INetEngineListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) h.this);
            }
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onResp(NetResp netResp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) netResp);
            }
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, netReq, Long.valueOf(j3), Long.valueOf(j16));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class b implements HttpEngineTask.IHttpEngineTask {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f252062d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String[] f252063e;

        b(String str, String[] strArr, d dVar) {
            this.f252062d = str;
            this.f252063e = strArr;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, h.this, str, strArr, dVar);
            }
        }

        @Override // com.tencent.mobileqq.transfile.predownload.HttpEngineTask.IHttpEngineTask
        public void onPreDownloadStart(HttpEngineTask httpEngineTask) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) httpEngineTask);
            } else if (QLog.isColorLevel()) {
                QLog.d("ZipResourcesDownloader", 2, String.format("onPreDownloadStart url=%s", httpEngineTask.httpReq.mReqUrl));
            }
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onResp(NetResp netResp) {
            IPreDownloadController iPreDownloadController;
            IPreDownloadController iPreDownloadController2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) netResp);
                return;
            }
            String str = ((HttpNetReq) netResp.mReq).mReqUrl;
            if (QLog.isColorLevel()) {
                QLog.d("ZipResourcesDownloader", 2, String.format("onResp url=%s result=%s", str, Integer.valueOf(netResp.mResult)));
            }
            int i3 = netResp.mResult;
            if (i3 != 0) {
                if (i3 == 1) {
                    WeakReference<IPreDownloadController> weakReference = h.this.f252057a;
                    if (weakReference != null) {
                        iPreDownloadController2 = weakReference.get();
                    } else {
                        iPreDownloadController2 = null;
                    }
                    if (iPreDownloadController2 != null) {
                        iPreDownloadController2.preDownloadSuccess(str, -1L);
                    }
                    h.this.r(str, this.f252062d, false, null);
                    return;
                }
                return;
            }
            WeakReference<IPreDownloadController> weakReference2 = h.this.f252057a;
            if (weakReference2 != null) {
                iPreDownloadController = weakReference2.get();
            } else {
                iPreDownloadController = null;
            }
            if (iPreDownloadController != null) {
                iPreDownloadController.preDownloadSuccess(str, netResp.mTotalFileLen);
            }
            HttpNetReq httpNetReq = (HttpNetReq) netResp.mReq;
            if (h.g(httpNetReq.mOutPath, this.f252062d)) {
                File file = new File(h.k(this.f252062d));
                if (!file.exists()) {
                    file.mkdirs();
                }
                boolean s16 = h.s(httpNetReq.mOutPath, h.k(this.f252062d));
                boolean p16 = h.p(str, this.f252062d, this.f252063e);
                if (QLog.isColorLevel()) {
                    QLog.d("ZipResourcesDownloader", 2, String.format("onResp ResultOk unzip result=%s unzipped=%s", Boolean.valueOf(s16), Boolean.valueOf(p16)));
                }
                h.this.r(str, this.f252062d, p16, null);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.e("ZipResourcesDownloader", 2, "onResp ResultOk file check invalid.");
            }
            h.h(httpNetReq.mOutPath);
            h.this.r(str, this.f252062d, false, null);
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, netReq, Long.valueOf(j3), Long.valueOf(j16));
            } else if (QLog.isColorLevel()) {
                QLog.d("ZipResourcesDownloader", 2, String.format("onUpdateProgeress url=%s totalLen=%s curOffset=%s", ((HttpNetReq) netReq).mReqUrl, Long.valueOf(j16), Long.valueOf(j3)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f252065a;

        public c(String str, d dVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, h.this, str, dVar);
            } else {
                this.f252065a = str;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface d {
        void a(boolean z16);
    }

    public h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f252058b = new ArrayList<>();
        this.f252059c = new ArrayList<>();
        this.f252060d = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean g(String str, String str2) {
        if (!new File(str).exists()) {
            return false;
        }
        String e16 = o.e(str);
        if (str2 == null || !str2.equalsIgnoreCase(e16)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h(String str) {
        FileUtils.delete(str, false);
    }

    private static String j() {
        File filesDir = BaseApplicationImpl.sApplication.getFilesDir();
        if (filesDir != null) {
            String str = filesDir.getAbsolutePath() + "/pddata/prd/common_resources";
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
                return str;
            }
            return str;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String k(String str) {
        return String.format("%s/%s", j(), str);
    }

    private static String l(String str) {
        return String.format("%s/%s.zip", j(), str);
    }

    public static String m(String str, String str2) {
        return k(str2);
    }

    private static boolean n(String str) {
        if (!new File(str).exists()) {
            return false;
        }
        return true;
    }

    public static boolean o(String str, String str2, String[] strArr) {
        return p(str, str2, strArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean p(String str, String str2, String[] strArr) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        String m3 = m(str, str2);
        if (!n(m3)) {
            return false;
        }
        if (strArr != null && strArr.length > 0) {
            for (String str3 : strArr) {
                String str4 = m3 + "/" + str3;
                if (!n(str4)) {
                    QLog.e("ZipResourcesDownloader", 1, String.format("isFilesExist check fail. filePath=%s", str4));
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(String str, String str2, boolean z16, d dVar) {
        if (QLog.isColorLevel()) {
            QLog.d("ZipResourcesDownloader", 2, "onDownloadEnd url:" + str + " success:" + z16 + " mDestroyed:" + this.f252060d);
        }
        if (this.f252060d) {
            return;
        }
        synchronized (this.f252058b) {
            this.f252058b.remove(str);
        }
        if (dVar != null) {
            dVar.a(z16);
        }
        synchronized (this.f252059c) {
            for (int size = this.f252059c.size() - 1; size >= 0; size--) {
                c cVar = this.f252059c.get(size);
                if (cVar != null && TextUtils.equals(str, cVar.f252065a)) {
                    this.f252059c.remove(size);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean s(String str, String str2) {
        try {
            i.i(str, str2);
            return true;
        } catch (Exception e16) {
            QLog.e("ZipResourcesDownloader", 1, "unzipResource fail.", e16);
            return false;
        }
    }

    public void i(QQAppInterface qQAppInterface, int i3, String str, String str2, String str3, String[] strArr, d dVar) {
        IPreDownloadController iPreDownloadController;
        boolean contains;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, qQAppInterface, Integer.valueOf(i3), str, str2, str3, strArr, dVar);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ZipResourcesDownloader", 2, String.format("downloadResource url=%s md5=%s callback=%s", str2, str3, dVar));
        }
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && qQAppInterface != null) {
            WeakReference<IPreDownloadController> weakReference = this.f252057a;
            if (weakReference != null) {
                iPreDownloadController = weakReference.get();
            } else {
                iPreDownloadController = null;
            }
            if (iPreDownloadController == null) {
                iPreDownloadController = (IPreDownloadController) qQAppInterface.getRuntimeService(IPreDownloadController.class);
                this.f252057a = new WeakReference<>(iPreDownloadController);
            }
            if (iPreDownloadController == null) {
                return;
            }
            String l3 = l(str3);
            if (!g(l3, str3)) {
                synchronized (this.f252058b) {
                    contains = this.f252058b.contains(str2);
                }
                if (contains) {
                    if (dVar != null) {
                        synchronized (this.f252059c) {
                            this.f252059c.add(new c(str2, dVar));
                        }
                        return;
                    }
                    return;
                }
                h(l3);
                HttpNetReq httpNetReq = new HttpNetReq();
                httpNetReq.mCallback = new a();
                httpNetReq.mReqUrl = str2;
                httpNetReq.mHttpMethod = 0;
                httpNetReq.mOutPath = l3;
                httpNetReq.mPrioty = 0;
                httpNetReq.mSupportBreakResume = true;
                iPreDownloadController.requestPreDownload(i3, str, str3, 0, str2, l3, 2, 0, false, new HttpEngineTask(qQAppInterface, str3, new b(str3, strArr, dVar), httpNetReq));
                synchronized (this.f252058b) {
                    this.f252058b.add(str2);
                }
                return;
            }
            boolean p16 = p(str2, str3, strArr);
            if (!p16) {
                boolean s16 = s(l3, k(str3));
                boolean p17 = p(str2, str3, strArr);
                if (QLog.isColorLevel()) {
                    QLog.d("ZipResourcesDownloader", 2, String.format("downloadResource unzip result=%s unzipped=%s", Boolean.valueOf(s16), Boolean.valueOf(p17)));
                }
                p16 = p17;
            }
            if (dVar != null) {
                dVar.a(p16);
                return;
            }
            return;
        }
        QLog.e("ZipResourcesDownloader", 1, "downloadResource invalid parameters.");
    }

    public void q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.f252060d = true;
        synchronized (this.f252058b) {
            this.f252058b.clear();
        }
        synchronized (this.f252059c) {
            this.f252059c.clear();
        }
    }
}
