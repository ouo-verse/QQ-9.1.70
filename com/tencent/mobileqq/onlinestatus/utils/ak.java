package com.tencent.mobileqq.onlinestatus.utils;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.predownload.HttpEngineTask;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ak {

    /* renamed from: a, reason: collision with root package name */
    WeakReference<IPreDownloadController> f256345a;

    /* renamed from: b, reason: collision with root package name */
    ArrayList<String> f256346b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    ArrayList<c> f256347c = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    boolean f256348d = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class b implements HttpEngineTask.IHttpEngineTask {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f256350d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String[] f256351e;

        b(String str, String[] strArr, d dVar) {
            this.f256350d = str;
            this.f256351e = strArr;
        }

        @Override // com.tencent.mobileqq.transfile.predownload.HttpEngineTask.IHttpEngineTask
        public void onPreDownloadStart(HttpEngineTask httpEngineTask) {
            if (QLog.isColorLevel()) {
                QLog.d("ZipResourcesDownloader", 2, String.format("onPreDownloadStart url=%s", httpEngineTask.httpReq.mReqUrl));
            }
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onResp(NetResp netResp) {
            ak.this.o(netResp, this.f256350d, this.f256351e, null);
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
            if (QLog.isColorLevel()) {
                QLog.d("ZipResourcesDownloader", 2, String.format("onUpdateProgeress url=%s totalLen=%s curOffset=%s", ((HttpNetReq) netReq).mReqUrl, Long.valueOf(j16), Long.valueOf(j3)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        public String f256353a;

        public c(String str, d dVar) {
            this.f256353a = str;
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface d {
        void a(boolean z16);
    }

    private static boolean b(String str, String str2) {
        if (!new File(str).exists()) {
            return false;
        }
        String e16 = e(str);
        if (str2 == null || !str2.equalsIgnoreCase(e16)) {
            return false;
        }
        return true;
    }

    private static void c(String str) {
        FileUtils.delete(str, false);
    }

    public static String e(String str) {
        String str2 = null;
        try {
            byte[] partfileMd5 = MD5.getPartfileMd5(str, 0L);
            if (partfileMd5 != null) {
                str2 = com.tencent.qqprotect.singleupdate.a.b(partfileMd5);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.e("ZipResourcesDownloader", 2, "error ........ error getFileMD5String filePath: " + str + ", error=" + e16.getMessage());
        }
        if (QLog.isDebugVersion()) {
            QLog.e("ZipResourcesDownloader", 2, "getFileMD5String md5: " + str2);
        }
        return str2;
    }

    private static String f() {
        File filesDir = MobileQQ.sMobileQQ.getFilesDir();
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

    private static String g(String str) {
        return String.format("%s/%s", f(), str);
    }

    private static String h(String str) {
        return String.format("%s/%s.zip", f(), str);
    }

    public static String i(String str, String str2) {
        return g(str2);
    }

    private static boolean j(String str) {
        if (!new File(str).exists()) {
            return false;
        }
        return true;
    }

    public static boolean k(String str, String str2, String[] strArr) {
        return l(str, str2, strArr);
    }

    private static boolean l(String str, String str2, String[] strArr) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        String i3 = i(str, str2);
        if (!j(i3)) {
            return false;
        }
        if (strArr != null && strArr.length > 0) {
            for (String str3 : strArr) {
                String str4 = i3 + "/" + str3;
                if (!j(str4)) {
                    QLog.e("ZipResourcesDownloader", 1, String.format("isFilesExist check fail. filePath=%s", str4));
                    return false;
                }
            }
        }
        return true;
    }

    private void n(String str, String str2, boolean z16, d dVar) {
        if (QLog.isColorLevel()) {
            QLog.d("ZipResourcesDownloader", 2, "onDownloadEnd url:" + str + " success:" + z16 + " mDestroyed:" + this.f256348d);
        }
        if (this.f256348d) {
            return;
        }
        synchronized (this.f256346b) {
            this.f256346b.remove(str);
        }
        if (dVar != null) {
            dVar.a(z16);
        }
        synchronized (this.f256347c) {
            for (int size = this.f256347c.size() - 1; size >= 0; size--) {
                c cVar = this.f256347c.get(size);
                if (cVar != null && TextUtils.equals(str, cVar.f256353a)) {
                    this.f256347c.remove(size);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(NetResp netResp, String str, String[] strArr, d dVar) {
        String str2 = ((HttpNetReq) netResp.mReq).mReqUrl;
        if (QLog.isColorLevel()) {
            QLog.d("ZipResourcesDownloader", 2, String.format("onResp url=%s result=%s", str2, Integer.valueOf(netResp.mResult)));
        }
        int i3 = netResp.mResult;
        IPreDownloadController iPreDownloadController = null;
        if (i3 != 0) {
            if (i3 == 1) {
                WeakReference<IPreDownloadController> weakReference = this.f256345a;
                if (weakReference != null) {
                    iPreDownloadController = weakReference.get();
                }
                if (iPreDownloadController != null) {
                    iPreDownloadController.preDownloadSuccess(str2, -1L);
                }
                n(str2, str, false, dVar);
                return;
            }
            return;
        }
        WeakReference<IPreDownloadController> weakReference2 = this.f256345a;
        if (weakReference2 != null) {
            iPreDownloadController = weakReference2.get();
        }
        if (iPreDownloadController != null) {
            iPreDownloadController.preDownloadSuccess(str2, netResp.mTotalFileLen);
        }
        HttpNetReq httpNetReq = (HttpNetReq) netResp.mReq;
        if (b(httpNetReq.mOutPath, str)) {
            File file = new File(g(str));
            if (!file.exists()) {
                file.mkdirs();
            }
            boolean q16 = q(httpNetReq.mOutPath, g(str));
            boolean l3 = l(str2, str, strArr);
            if (QLog.isColorLevel()) {
                QLog.d("ZipResourcesDownloader", 2, String.format("onResp ResultOk unzip result=%s unzipped=%s", Boolean.valueOf(q16), Boolean.valueOf(l3)));
            }
            n(str2, str, l3, dVar);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e("ZipResourcesDownloader", 2, "onResp ResultOk file check invalid.");
        }
        c(httpNetReq.mOutPath);
        n(str2, str, false, dVar);
    }

    private void p(BaseQQAppInterface baseQQAppInterface, int i3, String str, String str2, String str3, String[] strArr, d dVar, IPreDownloadController iPreDownloadController, String str4) {
        boolean contains;
        synchronized (this.f256346b) {
            contains = this.f256346b.contains(str2);
        }
        if (contains) {
            if (dVar != null) {
                synchronized (this.f256347c) {
                    this.f256347c.add(new c(str2, dVar));
                }
                return;
            }
            return;
        }
        c(str4);
        HttpNetReq httpNetReq = new HttpNetReq();
        httpNetReq.mCallback = new a();
        httpNetReq.mReqUrl = str2;
        httpNetReq.mHttpMethod = 0;
        httpNetReq.mOutPath = str4;
        httpNetReq.mPrioty = 0;
        httpNetReq.mSupportBreakResume = true;
        iPreDownloadController.requestPreDownload(i3, str, str3, 0, str2, str4, 2, 0, false, new HttpEngineTask(baseQQAppInterface, str3, new b(str3, strArr, dVar), httpNetReq));
        synchronized (this.f256346b) {
            this.f256346b.add(str2);
        }
    }

    private static boolean q(String str, String str2) {
        try {
            com.tencent.mobileqq.ar.i.i(str, str2);
            return true;
        } catch (Exception e16) {
            QLog.e("ZipResourcesDownloader", 1, "unzipResource fail.", e16);
            return false;
        }
    }

    public void d(AppInterface appInterface, int i3, String str, String str2, String str3, String[] strArr, d dVar) {
        IPreDownloadController iPreDownloadController;
        if (QLog.isColorLevel()) {
            QLog.d("ZipResourcesDownloader", 2, String.format("downloadResource url=%s md5=%s callback=%s", str2, str3, dVar));
        }
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && appInterface != null) {
            WeakReference<IPreDownloadController> weakReference = this.f256345a;
            if (weakReference != null) {
                iPreDownloadController = weakReference.get();
            } else {
                iPreDownloadController = null;
            }
            if (iPreDownloadController == null) {
                iPreDownloadController = (IPreDownloadController) appInterface.getRuntimeService(IPreDownloadController.class, "");
                this.f256345a = new WeakReference<>(iPreDownloadController);
            }
            IPreDownloadController iPreDownloadController2 = iPreDownloadController;
            if (iPreDownloadController2 == null) {
                return;
            }
            String h16 = h(str3);
            if (!b(h16, str3)) {
                p((BaseQQAppInterface) appInterface, i3, str, str2, str3, strArr, dVar, iPreDownloadController2, h16);
                return;
            }
            boolean l3 = l(str2, str3, strArr);
            if (!l3) {
                boolean q16 = q(h16, g(str3));
                boolean l16 = l(str2, str3, strArr);
                if (QLog.isColorLevel()) {
                    QLog.d("ZipResourcesDownloader", 2, String.format("downloadResource unzip result=%s unzipped=%s", Boolean.valueOf(q16), Boolean.valueOf(l16)));
                }
                l3 = l16;
            }
            if (dVar != null) {
                dVar.a(l3);
                return;
            }
            return;
        }
        QLog.e("ZipResourcesDownloader", 1, "downloadResource invalid parameters.");
    }

    public void m() {
        this.f256348d = true;
        synchronized (this.f256346b) {
            this.f256346b.clear();
        }
        synchronized (this.f256347c) {
            this.f256347c.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class a implements INetEngineListener {
        a() {
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onResp(NetResp netResp) {
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
        }
    }
}
