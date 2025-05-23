package com.tencent.aelight.camera.aeeditor.manage;

import android.text.TextUtils;
import com.google.gson.reflect.TypeToken;
import com.tencent.aelight.camera.ae.util.d;
import com.tencent.aelight.camera.aeeditor.data.AEEditorDownloadResBean;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.biz.common.util.k;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.ttpic.util.GsonUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class AEEditorResourceDownloader {

    /* renamed from: a, reason: collision with root package name */
    protected final String f66135a;

    /* renamed from: b, reason: collision with root package name */
    protected final String f66136b;

    /* renamed from: c, reason: collision with root package name */
    protected final int f66137c;

    /* renamed from: d, reason: collision with root package name */
    protected final String f66138d;

    /* renamed from: e, reason: collision with root package name */
    protected final Map<String, AEEditorDownloadResBean> f66139e = new LinkedHashMap();

    /* renamed from: f, reason: collision with root package name */
    protected volatile boolean f66140f = false;

    /* renamed from: g, reason: collision with root package name */
    protected volatile boolean f66141g = false;

    /* renamed from: h, reason: collision with root package name */
    protected final Map<String, AtomicBoolean> f66142h = new HashMap();

    /* renamed from: i, reason: collision with root package name */
    protected final Map<String, List<c>> f66143i = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a extends TypeToken<List<AEEditorDownloadResBean>> {
        a() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface c {
        void onDownloadFinish(boolean z16);

        void onProgressUpdate(int i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AEEditorResourceDownloader(String str, String str2, int i3, String str3) {
        this.f66135a = str;
        this.f66136b = str2;
        this.f66137c = i3;
        this.f66138d = "[AEEditor2]" + str3;
    }

    private boolean h(String str, String str2, String str3) {
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    if (file2.getName().replaceAll("\\p{C}", "").equals(str2)) {
                        ms.a.f(this.f66138d, "begin rename zip folder---from: " + file2.getName() + ", to: " + str3);
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(str);
                        sb5.append(file2.getName());
                        return FileUtils.rename(sb5.toString(), str + str3);
                    }
                }
                ms.a.c(this.f66138d, "reNameFile--NOT found folder named " + str2);
            }
        } else {
            ms.a.c(this.f66138d, "reNameFile--toDir not exists or not a directory: " + file);
        }
        return false;
    }

    private boolean m(String str, String str2, String str3, String str4) {
        try {
            ZipUtils.unZipFile(new File(str), str2);
            return h(str2, str3, str4);
        } catch (Exception e16) {
            ms.a.d(this.f66138d, "unZipHasPackage--exception ", e16);
            return false;
        }
    }

    protected abstract void a(List<AEEditorDownloadResBean> list);

    protected abstract void b(List<AEEditorDownloadResBean> list);

    public void c(AEEditorDownloadResBean aEEditorDownloadResBean, c cVar) {
        AtomicBoolean atomicBoolean;
        ms.a.f(this.f66138d, "downLoadOneResInternal---BEGIN: id=" + aEEditorDownloadResBean.getId());
        String md5 = aEEditorDownloadResBean.getMd5();
        synchronized (this.f66142h) {
            if (this.f66142h.get(md5) == null) {
                this.f66142h.put(md5, new AtomicBoolean(false));
            }
            atomicBoolean = this.f66142h.get(md5);
        }
        synchronized (atomicBoolean) {
            if (atomicBoolean.get()) {
                List<c> list = this.f66143i.get(md5);
                if (list == null) {
                    list = new ArrayList<>();
                    this.f66143i.put(md5, list);
                }
                if (cVar != null) {
                    list.add(cVar);
                }
                ms.a.f(this.f66138d, "downLoadOneResInternal---is DOWNLOADING: id=" + aEEditorDownloadResBean.getId());
                return;
            }
            atomicBoolean.compareAndSet(false, true);
            if (g(aEEditorDownloadResBean)) {
                if (cVar != null) {
                    cVar.onDownloadFinish(true);
                }
                k(md5, true);
                ms.a.f(this.f66138d, "downLoadOneResInternal---is DOWNLOADED by other: id=" + aEEditorDownloadResBean.getId());
                return;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(this.f66136b);
            String str = File.separator;
            sb5.append(str);
            sb5.append(aEEditorDownloadResBean.getId());
            sb5.append(str);
            String sb6 = sb5.toString();
            FileUtils.deleteDirectory(sb6);
            String str2 = sb6 + md5 + ".zip";
            if (cVar != null) {
                cVar.onProgressUpdate(0);
            }
            d.b().a(aEEditorDownloadResBean.getUrl(), str2, new b(cVar, md5, aEEditorDownloadResBean, str2, sb6));
        }
    }

    public void d(final String str, final c cVar) {
        if (!TextUtils.isEmpty(str)) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.aeeditor.manage.AEEditorResourceDownloader.3
                @Override // java.lang.Runnable
                public void run() {
                    ms.a.f(AEEditorResourceDownloader.this.f66138d, "downLoadResource--by user--BEGIN id: " + str);
                    AEEditorResourceDownloader.this.e();
                    AEEditorDownloadResBean aEEditorDownloadResBean = AEEditorResourceDownloader.this.f66139e.get(str);
                    if (aEEditorDownloadResBean != null) {
                        AEEditorResourceDownloader.this.c(aEEditorDownloadResBean, cVar);
                        return;
                    }
                    ms.a.c(AEEditorResourceDownloader.this.f66138d, "downLoadResource--by user--FAIL, no download config for id: " + str);
                    c cVar2 = cVar;
                    if (cVar2 != null) {
                        cVar2.onDownloadFinish(false);
                    }
                }
            }, 128, null, false);
        } else if (cVar != null) {
            cVar.onDownloadFinish(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
        Object valueOf;
        synchronized (this.f66139e) {
            if (this.f66140f) {
                return;
            }
            this.f66140f = true;
            ms.a.f(this.f66138d, "ensureSetupDownloadConfig--BEGIN");
            String i3 = i(this.f66135a);
            if (TextUtils.isEmpty(i3)) {
                ms.a.c(this.f66138d, "ensureSetupDownloadConfig---read assets json content empty");
                return;
            }
            List<AEEditorDownloadResBean> list = (List) GsonUtils.json2Obj(i3, new a().getType());
            String str = this.f66138d;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("ensureSetupDownloadConfig---size = ");
            if (list == null) {
                valueOf = "null";
            } else {
                valueOf = Integer.valueOf(list.size());
            }
            sb5.append(valueOf);
            ms.a.f(str, sb5.toString());
            if (list != null) {
                for (AEEditorDownloadResBean aEEditorDownloadResBean : list) {
                    this.f66139e.put(aEEditorDownloadResBean.getId(), aEEditorDownloadResBean);
                }
            }
        }
    }

    public String f(AEEditorDownloadResBean aEEditorDownloadResBean) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.f66136b);
        String str = File.separator;
        sb5.append(str);
        sb5.append(aEEditorDownloadResBean.getId());
        sb5.append(str);
        sb5.append(aEEditorDownloadResBean.getMd5());
        return sb5.toString();
    }

    public boolean g(AEEditorDownloadResBean aEEditorDownloadResBean) {
        return new File(f(aEEditorDownloadResBean)).exists();
    }

    protected abstract void j(boolean z16, int i3, long j3, String str);

    protected void k(String str, boolean z16) {
        AtomicBoolean atomicBoolean = this.f66142h.get(str);
        if (atomicBoolean == null) {
            return;
        }
        synchronized (atomicBoolean) {
            atomicBoolean.compareAndSet(true, false);
            List<c> list = this.f66143i.get(str);
            if (list != null) {
                for (c cVar : list) {
                    if (cVar != null) {
                        cVar.onDownloadFinish(z16);
                    }
                }
                list.clear();
            }
        }
    }

    protected boolean l(String str, String str2, String str3, String str4) {
        return m(str, str2, str3, str4) || n(str, str2, str3, str4);
    }

    protected boolean n(String str, String str2, String str3, String str4) {
        File file = new File(str2 + str3);
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            ZipUtils.unZipFile(new File(str), str2 + str3 + "/");
        } catch (IOException e16) {
            ms.a.d(this.f66138d, "unZipNoPackage-- exception ", e16);
        }
        ms.a.c(this.f66138d, "unZipNoPackage-- zipPath: " + str2 + str3);
        return h(str2, str3, str4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String i(String str) {
        InputStream inputStream = null;
        try {
            inputStream = BaseApplication.getContext().getAssets().open(str);
            String h16 = k.h(inputStream);
            if (inputStream == null) {
                return h16;
            }
            try {
                inputStream.close();
                return h16;
            } catch (IOException e16) {
                e16.printStackTrace();
                return h16;
            }
        } catch (Throwable th5) {
            try {
                ms.a.d(this.f66138d, "readAssetsFileContent---read assets json exception: fileName=" + str, th5);
                th5.printStackTrace();
                return "";
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e17) {
                        e17.printStackTrace();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b implements d.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f66151a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f66152b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ AEEditorDownloadResBean f66153c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f66154d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f66155e;

        b(c cVar, String str, AEEditorDownloadResBean aEEditorDownloadResBean, String str2, String str3) {
            this.f66151a = cVar;
            this.f66152b = str;
            this.f66153c = aEEditorDownloadResBean;
            this.f66154d = str2;
            this.f66155e = str3;
        }

        @Override // com.tencent.aelight.camera.ae.util.d.a
        public void onProgressUpdate(int i3) {
            c cVar = this.f66151a;
            if (cVar != null) {
                cVar.onProgressUpdate(i3);
            }
        }

        @Override // com.tencent.aelight.camera.ae.util.d.a
        public void a(NetResp netResp) {
            boolean z16 = false;
            if (netResp == null) {
                c cVar = this.f66151a;
                if (cVar != null) {
                    cVar.onDownloadFinish(false);
                }
                AEEditorResourceDownloader.this.k(this.f66152b, false);
                return;
            }
            boolean z17 = netResp.mResult == 0;
            ms.a.f(AEEditorResourceDownloader.this.f66138d, "downLoadOneResInternal-onDownloadFinish---isSuccess=" + z17 + ", id=" + this.f66153c.getId());
            if (z17) {
                String calcMd5 = FileUtils.calcMd5(this.f66154d);
                if (calcMd5 != null && calcMd5.equalsIgnoreCase(this.f66152b)) {
                    try {
                        z16 = AEEditorResourceDownloader.this.l(this.f66154d, this.f66155e, this.f66153c.getId(), this.f66152b);
                    } catch (Exception e16) {
                        ms.a.d(AEEditorResourceDownloader.this.f66138d, "downLoadOneResInternal-onDownloadFinish---unZipFile failed, id=" + this.f66153c.getId(), e16);
                        e16.printStackTrace();
                    }
                } else {
                    ms.a.c(AEEditorResourceDownloader.this.f66138d, "downLoadOneResInternal-onDownloadFinish---MD5 check failed, id=" + this.f66153c.getId());
                }
            }
            AEEditorResourceDownloader.this.j(z17, netResp.mErrCode, netResp.reqCost, this.f66153c.getId());
            if (!z16) {
                FileUtils.deleteDirectory(this.f66155e);
            }
            FileUtils.deleteFile(this.f66154d);
            ms.a.f(AEEditorResourceDownloader.this.f66138d, "downLoadOneResInternal-onDownloadFinish---REAL result=" + z16 + ", id=" + this.f66153c.getId());
            c cVar2 = this.f66151a;
            if (cVar2 != null) {
                cVar2.onDownloadFinish(z16);
            }
            AEEditorResourceDownloader.this.k(this.f66152b, z16);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.aelight.camera.aeeditor.manage.AEEditorResourceDownloader$2, reason: invalid class name */
    /* loaded from: classes32.dex */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ AEEditorResourceDownloader this$0;

        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            this.this$0.e();
            ms.a.f(this.this$0.f66138d, "preDownloadAllRes---ensureSetupDownloadConfig finish");
            ArrayList arrayList = new ArrayList();
            this.this$0.a(arrayList);
            for (AEEditorDownloadResBean aEEditorDownloadResBean : this.this$0.f66139e.values()) {
                if (aEEditorDownloadResBean != null && aEEditorDownloadResBean.getPreDownload() == 1 && !this.this$0.g(aEEditorDownloadResBean)) {
                    arrayList.add(aEEditorDownloadResBean);
                }
            }
            this.this$0.b(arrayList);
            ms.a.f(this.this$0.f66138d, "preDownloadAllRes---needDownloads size=" + arrayList.size());
            int i3 = 0;
            while (i3 < arrayList.size()) {
                int min = Math.min(this.this$0.f66137c, arrayList.size() - i3);
                CountDownLatch countDownLatch = new CountDownLatch(min);
                int i16 = 0;
                while (i16 < min) {
                    AEEditorDownloadResBean aEEditorDownloadResBean2 = (AEEditorDownloadResBean) arrayList.get(i3);
                    this.this$0.c(aEEditorDownloadResBean2, new a(i3, aEEditorDownloadResBean2, countDownLatch));
                    i16++;
                    i3++;
                }
                try {
                    countDownLatch.await();
                } catch (InterruptedException e16) {
                    e16.printStackTrace();
                }
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            ms.a.f(this.this$0.f66138d, "preDownloadAllRes---END cost=" + currentTimeMillis2);
        }

        /* compiled from: P */
        /* renamed from: com.tencent.aelight.camera.aeeditor.manage.AEEditorResourceDownloader$2$a */
        /* loaded from: classes32.dex */
        class a implements c {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f66144a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ AEEditorDownloadResBean f66145b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ CountDownLatch f66146c;

            a(int i3, AEEditorDownloadResBean aEEditorDownloadResBean, CountDownLatch countDownLatch) {
                this.f66144a = i3;
                this.f66145b = aEEditorDownloadResBean;
                this.f66146c = countDownLatch;
            }

            @Override // com.tencent.aelight.camera.aeeditor.manage.AEEditorResourceDownloader.c
            public void onDownloadFinish(boolean z16) {
                ms.a.f(AnonymousClass2.this.this$0.f66138d, "preDownloadAllRes---[finish] " + this.f66144a + ", id=" + this.f66145b.getId());
                this.f66146c.countDown();
            }

            @Override // com.tencent.aelight.camera.aeeditor.manage.AEEditorResourceDownloader.c
            public void onProgressUpdate(int i3) {
            }
        }
    }
}
