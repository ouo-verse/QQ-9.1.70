package com.tencent.aelight.camera.aioeditor.capture.paster;

import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.model.DoodleEmojiItem;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IOldHttpEngineProcessor;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import hr.d;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes32.dex */
public class QIMInformationPasterManager extends fr.e {
    private static String C;

    /* renamed from: m, reason: collision with root package name */
    private static File f66838m;

    /* renamed from: d, reason: collision with root package name */
    c f66839d;

    /* renamed from: e, reason: collision with root package name */
    private Context f66840e;

    /* renamed from: f, reason: collision with root package name */
    private ConcurrentLinkedQueue<d.c> f66841f = new ConcurrentLinkedQueue<>();

    /* renamed from: h, reason: collision with root package name */
    private RelativeLayout f66842h = null;

    /* renamed from: i, reason: collision with root package name */
    private WeakReference<RelativeLayout> f66843i = null;

    /* loaded from: classes32.dex */
    public interface b {
        void a(float f16, String str, int i3);

        void b(boolean z16, String str, d.c cVar);
    }

    /* loaded from: classes32.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private ConcurrentHashMap<String, ArrayList<mqq.util.WeakReference<b>>> f66849a = new ConcurrentHashMap<>();

        /* renamed from: b, reason: collision with root package name */
        private QIMInformationPasterManager f66850b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes32.dex */
        public class a implements INetEngineListener {
            a() {
            }

            @Override // com.tencent.mobileqq.transfile.INetEngineListener
            public void onResp(NetResp netResp) {
                d.c cVar = (d.c) netResp.mReq.getUserData();
                String str = cVar.f406029h;
                if (QLog.isColorLevel()) {
                    QLog.d("QIMInformationPasterManager", 2, "onResp ,url is :" + str + " http status:" + netResp.mHttpCode);
                }
                boolean z16 = false;
                if (netResp.mHttpCode == 200) {
                    String d16 = com.tencent.aelight.camera.aioeditor.capture.util.c.d(cVar);
                    QLog.d("QIMInformationPasterManager", 1, "info paster path:" + d16);
                    String calcMd5 = FileUtils.calcMd5(d16);
                    String str2 = cVar.f406030i;
                    if (str2 != null && str2.equalsIgnoreCase(calcMd5)) {
                        z16 = c.this.f66850b.o(cVar);
                    } else {
                        FileUtils.delete(d16, false);
                        if (QLog.isColorLevel()) {
                            QLog.d("QIMInformationPasterManager", 2, "info paster res md5 error, res md5:" + cVar.f406030i + ",file md5:" + calcMd5);
                        }
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d("QIMInformationPasterManager", 2, "onResp:" + netResp.mHttpCode + ",isSuccess:" + z16);
                }
                Iterator it = ((ArrayList) c.this.f66849a.get(str)).iterator();
                while (it.hasNext()) {
                    mqq.util.WeakReference weakReference = (mqq.util.WeakReference) it.next();
                    if (weakReference.get() != 0) {
                        ((b) weakReference.get()).b(z16, str, cVar);
                    }
                }
                c.this.f66849a.remove(str);
            }

            @Override // com.tencent.mobileqq.transfile.INetEngineListener
            public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
                String str = ((d.c) netReq.getUserData()).f406029h;
                float f16 = (float) ((j3 * 100) / j16);
                synchronized (c.this.f66849a) {
                    Iterator it = ((ArrayList) c.this.f66849a.get(str)).iterator();
                    while (it.hasNext()) {
                        mqq.util.WeakReference weakReference = (mqq.util.WeakReference) it.next();
                        if (weakReference.get() != 0) {
                            ((b) weakReference.get()).a(f16, str, 0);
                        }
                    }
                }
            }
        }

        public c(QIMInformationPasterManager qIMInformationPasterManager) {
            this.f66850b = qIMInformationPasterManager;
        }

        public boolean c(String str) {
            return this.f66849a.get(str) != null;
        }

        public void d(d.c cVar, b bVar) {
            String str = cVar.f406029h;
            if (str != null && !TextUtils.isEmpty(str)) {
                if (QLog.isColorLevel()) {
                    QLog.i("QIMInformationPasterManager", 2, "startDownloadDynamicText res url: " + str);
                }
                synchronized (this.f66849a) {
                    ArrayList<mqq.util.WeakReference<b>> arrayList = this.f66849a.get(str);
                    boolean z16 = false;
                    if (arrayList != null) {
                        Iterator<mqq.util.WeakReference<b>> it = arrayList.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            } else if (it.next().get() == bVar) {
                                z16 = true;
                                break;
                            }
                        }
                        if (!z16) {
                            arrayList.add(new mqq.util.WeakReference<>(bVar));
                        }
                        if (QLog.isColorLevel()) {
                            QLog.i("QIMInformationPasterManager", 2, "already put url " + str);
                        }
                        return;
                    }
                    ArrayList<mqq.util.WeakReference<b>> arrayList2 = new ArrayList<>();
                    arrayList2.add(new mqq.util.WeakReference<>(bVar));
                    this.f66849a.put(str, arrayList2);
                    HttpNetReq httpNetReq = new HttpNetReq();
                    httpNetReq.mCallback = new a();
                    httpNetReq.mReqUrl = str;
                    httpNetReq.mHttpMethod = 0;
                    httpNetReq.mOutPath = com.tencent.aelight.camera.aioeditor.capture.util.c.d(cVar);
                    httpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
                    httpNetReq.setUserData(cVar);
                    ((IOldHttpEngineProcessor) QRoute.api(IOldHttpEngineProcessor.class)).sendReq(httpNetReq);
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.i("QIMInformationPasterManager", 2, "startDownloadDynamicTextRes fontInfo is null or resUrl is empty.");
            }
        }
    }

    public QIMInformationPasterManager() {
        this.f66839d = null;
        this.f66839d = new c(this);
    }

    private boolean i(d.c cVar) {
        File file = f66838m;
        if (file != null) {
            if (!file.exists()) {
                f66838m.mkdirs();
            } else if (!f66838m.isDirectory()) {
                f66838m.delete();
                f66838m.mkdirs();
            }
            String[] list = f66838m.list();
            if (list != null) {
                boolean z16 = false;
                for (String str : list) {
                    if (str.startsWith(cVar.f406031j)) {
                        if (str.endsWith(".zip")) {
                            FileUtils.delete(f66838m + str, false);
                        } else if (str.endsWith(cVar.f406030i)) {
                            z16 = true;
                        } else if (!str.endsWith("png") && !str.endsWith("tmp")) {
                            FileUtils.delete(C + str, false);
                        }
                    }
                }
                return z16;
            }
        }
        return false;
    }

    @Override // fr.e
    public void e() {
        this.f66840e = BaseApplication.getContext();
        f66838m = com.tencent.aelight.camera.aioeditor.capture.util.c.a();
        C = com.tencent.aelight.camera.aioeditor.capture.util.c.b();
    }

    public void h(final List<d.c> list) {
        ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.capture.paster.QIMInformationPasterManager.2
            @Override // java.lang.Runnable
            public void run() {
                QIMInformationPasterManager.this.f66841f.clear();
                if (QLog.isColorLevel()) {
                    QLog.d("QIMInformationPasterManager", 2, "patch pull res");
                }
                if (!NetworkUtil.isNetworkAvailable(QIMInformationPasterManager.this.f66840e)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("QIMInformationPasterManager", 2, "network is unavailable");
                        return;
                    }
                    return;
                }
                for (d.c cVar : list) {
                    if (!TextUtils.isEmpty(cVar.f406029h) && !QIMInformationPasterManager.this.k(cVar) && cVar.f406028g != 2) {
                        QIMInformationPasterManager.this.f66841f.add(cVar);
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d("QIMInformationPasterManager", 2, "need download size:" + QIMInformationPasterManager.this.f66841f.size());
                }
                Iterator it = QIMInformationPasterManager.this.f66841f.iterator();
                while (it.hasNext()) {
                    QIMInformationPasterManager.this.f66839d.d((d.c) it.next(), new a());
                }
            }

            /* renamed from: com.tencent.aelight.camera.aioeditor.capture.paster.QIMInformationPasterManager$2$a */
            /* loaded from: classes32.dex */
            class a implements b {
                a() {
                }

                @Override // com.tencent.aelight.camera.aioeditor.capture.paster.QIMInformationPasterManager.b
                public void b(boolean z16, String str, d.c cVar) {
                    if (QLog.isColorLevel()) {
                        QLog.d("QIMInformationPasterManager", 2, "isSucess:" + z16 + " url:" + str + " item:" + cVar);
                    }
                    if (cVar.a() != null) {
                        cVar.a().b(z16);
                    }
                }

                @Override // com.tencent.aelight.camera.aioeditor.capture.paster.QIMInformationPasterManager.b
                public void a(float f16, String str, int i3) {
                }
            }
        }, null, true);
    }

    public boolean j(d.c cVar) {
        return this.f66839d.c(cVar.f406029h);
    }

    public boolean k(d.c cVar) {
        String[] list;
        if (TextUtils.isEmpty(cVar.f406029h)) {
            return cVar.f406025d != 7;
        }
        if (!i(cVar)) {
            return false;
        }
        String c16 = com.tencent.aelight.camera.aioeditor.capture.util.c.c(cVar);
        if (QLog.isColorLevel()) {
            QLog.d("QIMInformationPasterManager", 2, "checkDir:" + c16);
        }
        File file = new File(c16);
        return file.exists() && file.isDirectory() && (list = file.list()) != null && list.length == hr.c.a(cVar);
    }

    public void l(DoodleEmojiItem doodleEmojiItem) {
        for (d.c cVar : doodleEmojiItem.mInfoItemList) {
            if (cVar.f406028g == 1 && !k(cVar)) {
                n(cVar, new a());
            }
        }
    }

    public void m() {
        WeakReference<RelativeLayout> weakReference;
        RelativeLayout relativeLayout;
        if (this.f66842h == null || (weakReference = this.f66843i) == null || (relativeLayout = weakReference.get()) == null) {
            return;
        }
        relativeLayout.removeView(this.f66842h);
        this.f66843i = null;
        this.f66842h = null;
    }

    public void n(final d.c cVar, final b bVar) {
        if (!NetworkUtil.isNetworkAvailable(this.f66840e)) {
            if (QLog.isColorLevel()) {
                QLog.d("QIMInformationPasterManager", 2, "network is unavailable");
                return;
            }
            return;
        }
        ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.capture.paster.QIMInformationPasterManager.1
            @Override // java.lang.Runnable
            public void run() {
                QIMInformationPasterManager.this.f66839d.d(cVar, bVar);
            }
        }, null, true);
    }

    public boolean o(d.c cVar) {
        try {
            File file = new File(C + cVar.f406031j + "_" + cVar.f406030i);
            if (!file.exists()) {
                file.mkdir();
            }
            if (QLog.isColorLevel()) {
                QLog.d("QIMInformationPasterManager", 2, "unzipDir:" + file.getAbsolutePath());
            }
            ZipUtils.unZipFile(new File(com.tencent.aelight.camera.aioeditor.capture.util.c.d(cVar)), file.getAbsolutePath() + File.separator);
            return true;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("QIMInformationPasterManager", 2, e16, new Object[0]);
            }
            return false;
        }
    }

    @Override // fr.e
    public void d() {
    }

    /* loaded from: classes32.dex */
    class a implements b {
        a() {
        }

        @Override // com.tencent.aelight.camera.aioeditor.capture.paster.QIMInformationPasterManager.b
        public void b(boolean z16, String str, d.c cVar) {
            if (QLog.isColorLevel()) {
                QLog.d("QIMInformationPasterManager", 2, "preload:" + str + " item:" + cVar.toString());
            }
        }

        @Override // com.tencent.aelight.camera.aioeditor.capture.paster.QIMInformationPasterManager.b
        public void a(float f16, String str, int i3) {
        }
    }
}
