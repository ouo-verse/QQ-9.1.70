package com.tencent.mobileqq.qqvideoedit.edit.manager;

import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.gson.reflect.TypeToken;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.biz.common.util.k;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqvideoedit.edit.bean.AEEditorDownloadResBean;
import com.tencent.mobileqq.qqvideoedit.event.ResourcePreDownFinishEvent;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.ttpic.util.GsonUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import oj2.a;

/* compiled from: P */
/* loaded from: classes17.dex */
public abstract class VideoEditorResourceDownloader {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    protected final String f275033a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    protected final String f275034b;

    /* renamed from: c, reason: collision with root package name */
    protected final int f275035c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    protected final String f275036d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    protected final Map<String, AEEditorDownloadResBean> f275037e = new LinkedHashMap();

    /* renamed from: f, reason: collision with root package name */
    protected volatile boolean f275038f = false;

    /* renamed from: g, reason: collision with root package name */
    protected volatile boolean f275039g = false;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    protected final Map<String, AtomicBoolean> f275040h = new HashMap();

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    protected final Map<String, List<d>> f275041i = new HashMap();

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qqvideoedit.edit.manager.VideoEditorResourceDownloader$3, reason: invalid class name */
    /* loaded from: classes17.dex */
    class AnonymousClass3 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f275046d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ d f275047e;
        final /* synthetic */ VideoEditorResourceDownloader this$0;

        @Override // java.lang.Runnable
        public void run() {
            mj2.a.d(this.this$0.f275036d, "downLoadResource--by user--BEGIN id: " + this.f275046d);
            this.this$0.e();
            AEEditorDownloadResBean aEEditorDownloadResBean = this.this$0.f275037e.get(this.f275046d);
            if (aEEditorDownloadResBean != null) {
                this.this$0.d(aEEditorDownloadResBean, this.f275047e);
                return;
            }
            mj2.a.b(this.this$0.f275036d, "downLoadResource--by user--FAIL, no download config for id: " + this.f275046d);
            d dVar = this.f275047e;
            if (dVar != null) {
                dVar.onDownloadFinish(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class a extends TypeToken<List<AEEditorDownloadResBean>> {
        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class b implements a.InterfaceC10920a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f275049a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f275050b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ AEEditorDownloadResBean f275051c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f275052d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f275053e;

        b(d dVar, String str, AEEditorDownloadResBean aEEditorDownloadResBean, String str2, String str3) {
            this.f275049a = dVar;
            this.f275050b = str;
            this.f275051c = aEEditorDownloadResBean;
            this.f275052d = str2;
            this.f275053e = str3;
        }

        @Override // oj2.a.InterfaceC10920a
        public void a(NetResp netResp) {
            boolean z16;
            boolean z17 = false;
            if (netResp == null) {
                d dVar = this.f275049a;
                if (dVar != null) {
                    dVar.onDownloadFinish(false);
                }
                VideoEditorResourceDownloader.this.o(this.f275050b, false);
                return;
            }
            if (netResp.mResult == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            mj2.a.d(VideoEditorResourceDownloader.this.f275036d, "downLoadOneResInternal-onDownloadFinish---isSuccess=" + z16 + ", id=" + this.f275051c.getId());
            if (z16) {
                String calcMd5 = FileUtils.calcMd5(this.f275052d);
                if (calcMd5 != null && calcMd5.equalsIgnoreCase(this.f275050b)) {
                    try {
                        z17 = VideoEditorResourceDownloader.this.p(this.f275052d, this.f275053e, this.f275051c.getId(), this.f275050b);
                    } catch (Exception e16) {
                        mj2.a.c(VideoEditorResourceDownloader.this.f275036d, "downLoadOneResInternal-onDownloadFinish---unZipFile failed, id=" + this.f275051c.getId(), e16);
                        e16.printStackTrace();
                    }
                } else {
                    mj2.a.b(VideoEditorResourceDownloader.this.f275036d, "downLoadOneResInternal-onDownloadFinish---MD5 check failed, id=" + this.f275051c.getId());
                }
            }
            if (!z17) {
                FileUtils.deleteDirectory(this.f275053e);
            }
            FileUtils.deleteFile(this.f275052d);
            mj2.a.d(VideoEditorResourceDownloader.this.f275036d, "downLoadOneResInternal-onDownloadFinish---REAL result=" + z17 + ", id=" + this.f275051c.getId());
            d dVar2 = this.f275049a;
            if (dVar2 != null) {
                dVar2.onDownloadFinish(z17);
            }
            VideoEditorResourceDownloader.this.o(this.f275050b, z17);
        }

        @Override // oj2.a.InterfaceC10920a
        public void onProgressUpdate(int i3) {
            d dVar = this.f275049a;
            if (dVar != null) {
                dVar.onProgressUpdate(i3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class c implements a.InterfaceC10920a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f275055a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f275056b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ MetaMaterial f275057c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f275058d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f275059e;

        c(d dVar, String str, MetaMaterial metaMaterial, String str2, String str3) {
            this.f275055a = dVar;
            this.f275056b = str;
            this.f275057c = metaMaterial;
            this.f275058d = str2;
            this.f275059e = str3;
        }

        @Override // oj2.a.InterfaceC10920a
        public void a(NetResp netResp) {
            boolean z16;
            boolean z17 = false;
            if (netResp == null) {
                d dVar = this.f275055a;
                if (dVar != null) {
                    dVar.onDownloadFinish(false);
                }
                VideoEditorResourceDownloader.this.o(this.f275056b, false);
                return;
            }
            if (netResp.mResult == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            mj2.a.d(VideoEditorResourceDownloader.this.f275036d, "downLoadOneResInternal-onDownloadFinish---isSuccess=" + z16 + ", id=" + this.f275057c.f30533id);
            if (z16) {
                String calcMd5 = FileUtils.calcMd5(this.f275058d);
                if (calcMd5 != null && calcMd5.equalsIgnoreCase(this.f275056b)) {
                    try {
                        z17 = VideoEditorResourceDownloader.this.p(this.f275058d, this.f275059e, this.f275057c.f30533id, this.f275056b);
                    } catch (Exception e16) {
                        mj2.a.c(VideoEditorResourceDownloader.this.f275036d, "downLoadOneResInternal-onDownloadFinish---unZipFile failed, id=" + this.f275057c.f30533id, e16);
                        e16.printStackTrace();
                    }
                } else {
                    mj2.a.b(VideoEditorResourceDownloader.this.f275036d, "downLoadOneResInternal-onDownloadFinish---MD5 check failed, id=" + this.f275057c.f30533id);
                }
            }
            if (!z17) {
                FileUtils.deleteDirectory(this.f275059e);
            }
            FileUtils.deleteFile(this.f275058d);
            mj2.a.d(VideoEditorResourceDownloader.this.f275036d, "downLoadOneResInternal-onDownloadFinish---REAL result=" + z17 + ", id=" + this.f275057c.f30533id);
            d dVar2 = this.f275055a;
            if (dVar2 != null) {
                dVar2.onDownloadFinish(z17);
            }
            VideoEditorResourceDownloader.this.o(this.f275056b, z17);
        }

        @Override // oj2.a.InterfaceC10920a
        public void onProgressUpdate(int i3) {
            d dVar = this.f275055a;
            if (dVar != null) {
                dVar.onProgressUpdate(i3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public interface d {
        void onDownloadFinish(boolean z16);

        void onProgressUpdate(int i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public VideoEditorResourceDownloader(@NonNull String str, @NonNull String str2, int i3, @NonNull String str3) {
        this.f275033a = str;
        this.f275034b = str2;
        this.f275035c = i3;
        this.f275036d = "[AEEditor2]" + str3;
    }

    private boolean k(String str, String str2, String str3) {
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    if (file2.getName().replaceAll("\\p{C}", "").equals(str2)) {
                        mj2.a.d(this.f275036d, "begin rename zip folder---from: " + file2.getName() + ", to: " + str3);
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(str);
                        sb5.append(file2.getName());
                        return FileUtils.rename(sb5.toString(), str + str3);
                    }
                }
                mj2.a.b(this.f275036d, "reNameFile--NOT found folder named " + str2);
            }
        } else {
            mj2.a.b(this.f275036d, "reNameFile--toDir not exists or not a directory: " + file);
        }
        return false;
    }

    @WorkerThread
    public static String m(@NonNull String str) {
        FileInputStream fileInputStream;
        File file = new File(str);
        String str2 = "";
        if (!file.exists()) {
            return "";
        }
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (IOException e16) {
            e16.printStackTrace();
        }
        try {
            str2 = k.h(fileInputStream);
            fileInputStream.close();
        } catch (Throwable th6) {
            th = th6;
            fileInputStream2 = fileInputStream;
            try {
                mj2.a.c("VideoEditorResourceDownloader", "readSdCardFileContent---read file json exception: filePath=" + str, th);
                th.printStackTrace();
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
                return str2;
            } catch (Throwable th7) {
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e17) {
                        e17.printStackTrace();
                    }
                }
                throw th7;
            }
        }
        return str2;
    }

    private boolean q(String str, String str2, String str3, String str4) {
        try {
            ZipUtils.unZipFile(new File(str), str2);
            return k(str2, str3, str4);
        } catch (Exception e16) {
            mj2.a.c(this.f275036d, "unZipHasPackage--exception ", e16);
            return false;
        }
    }

    protected abstract void a(@NonNull List<AEEditorDownloadResBean> list);

    protected abstract void b(@NonNull List<AEEditorDownloadResBean> list);

    public void c(@NonNull MetaMaterial metaMaterial, d dVar) {
        AtomicBoolean atomicBoolean;
        mj2.a.d(this.f275036d, "downLoadOneResInternal---BEGIN: id=" + metaMaterial.f30533id);
        String str = metaMaterial.packageMd5;
        synchronized (this.f275040h) {
            if (this.f275040h.get(str) == null) {
                this.f275040h.put(str, new AtomicBoolean(false));
            }
            atomicBoolean = this.f275040h.get(str);
        }
        synchronized (atomicBoolean) {
            if (atomicBoolean.get()) {
                List<d> list = this.f275041i.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                    this.f275041i.put(str, list);
                }
                if (dVar != null) {
                    list.add(dVar);
                }
                mj2.a.d(this.f275036d, "downLoadOneResInternal---is DOWNLOADING: id=" + metaMaterial.f30533id);
                return;
            }
            atomicBoolean.compareAndSet(false, true);
            if (h(metaMaterial)) {
                if (dVar != null) {
                    dVar.onDownloadFinish(true);
                }
                o(str, true);
                mj2.a.d(this.f275036d, "downLoadOneResInternal---is DOWNLOADED by other: id=" + metaMaterial.f30533id);
                return;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(this.f275034b);
            String str2 = File.separator;
            sb5.append(str2);
            sb5.append(metaMaterial.f30533id);
            sb5.append(str2);
            String sb6 = sb5.toString();
            FileUtils.deleteDirectory(sb6);
            String str3 = sb6 + str + ".zip";
            if (dVar != null) {
                dVar.onProgressUpdate(0);
            }
            oj2.a.b().a(metaMaterial.packageUrl, str3, new c(dVar, str, metaMaterial, str3, sb6));
        }
    }

    public void d(@NonNull AEEditorDownloadResBean aEEditorDownloadResBean, d dVar) {
        AtomicBoolean atomicBoolean;
        mj2.a.d(this.f275036d, "downLoadOneResInternal---BEGIN: id=" + aEEditorDownloadResBean.getId());
        String md5 = aEEditorDownloadResBean.getMd5();
        synchronized (this.f275040h) {
            if (this.f275040h.get(md5) == null) {
                this.f275040h.put(md5, new AtomicBoolean(false));
            }
            atomicBoolean = this.f275040h.get(md5);
        }
        synchronized (atomicBoolean) {
            if (atomicBoolean.get()) {
                List<d> list = this.f275041i.get(md5);
                if (list == null) {
                    list = new ArrayList<>();
                    this.f275041i.put(md5, list);
                }
                if (dVar != null) {
                    list.add(dVar);
                }
                mj2.a.d(this.f275036d, "downLoadOneResInternal---is DOWNLOADING: id=" + aEEditorDownloadResBean.getId());
                return;
            }
            atomicBoolean.compareAndSet(false, true);
            if (i(aEEditorDownloadResBean)) {
                if (dVar != null) {
                    dVar.onDownloadFinish(true);
                }
                o(md5, true);
                mj2.a.d(this.f275036d, "downLoadOneResInternal---is DOWNLOADED by other: id=" + aEEditorDownloadResBean.getId());
                return;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(this.f275034b);
            String str = File.separator;
            sb5.append(str);
            sb5.append(aEEditorDownloadResBean.getId());
            sb5.append(str);
            String sb6 = sb5.toString();
            FileUtils.deleteDirectory(sb6);
            String str2 = sb6 + md5 + ".zip";
            if (dVar != null) {
                dVar.onProgressUpdate(0);
            }
            oj2.a.b().a(aEEditorDownloadResBean.getUrl(), str2, new b(dVar, md5, aEEditorDownloadResBean, str2, sb6));
        }
    }

    @WorkerThread
    protected void e() {
        Object valueOf;
        synchronized (this.f275037e) {
            if (this.f275038f) {
                return;
            }
            this.f275038f = true;
            mj2.a.d(this.f275036d, "ensureSetupDownloadConfig--BEGIN");
            String l3 = l(this.f275033a);
            if (TextUtils.isEmpty(l3)) {
                mj2.a.b(this.f275036d, "ensureSetupDownloadConfig---read assets json content empty");
                return;
            }
            List<AEEditorDownloadResBean> list = (List) GsonUtils.json2Obj(l3, new a().getType());
            String str = this.f275036d;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("ensureSetupDownloadConfig---size = ");
            if (list == null) {
                valueOf = "null";
            } else {
                valueOf = Integer.valueOf(list.size());
            }
            sb5.append(valueOf);
            mj2.a.d(str, sb5.toString());
            if (list != null) {
                for (AEEditorDownloadResBean aEEditorDownloadResBean : list) {
                    this.f275037e.put(aEEditorDownloadResBean.getId(), aEEditorDownloadResBean);
                }
            }
        }
    }

    @NonNull
    public String f(MetaMaterial metaMaterial) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.f275034b);
        String str = File.separator;
        sb5.append(str);
        sb5.append(metaMaterial.f30533id);
        sb5.append(str);
        sb5.append(metaMaterial.packageMd5);
        return sb5.toString();
    }

    @NonNull
    public String g(AEEditorDownloadResBean aEEditorDownloadResBean) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.f275034b);
        String str = File.separator;
        sb5.append(str);
        sb5.append(aEEditorDownloadResBean.getId());
        sb5.append(str);
        sb5.append(aEEditorDownloadResBean.getMd5());
        return sb5.toString();
    }

    public boolean h(@NonNull MetaMaterial metaMaterial) {
        return new File(f(metaMaterial)).exists();
    }

    public boolean i(@NonNull AEEditorDownloadResBean aEEditorDownloadResBean) {
        return new File(g(aEEditorDownloadResBean)).exists();
    }

    public void j() {
        if (this.f275039g) {
            return;
        }
        this.f275039g = true;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqvideoedit.edit.manager.VideoEditorResourceDownloader.2
            @Override // java.lang.Runnable
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                mj2.a.d(VideoEditorResourceDownloader.this.f275036d, "preDownloadAllRes---BEGIN");
                VideoEditorResourceDownloader.this.e();
                mj2.a.d(VideoEditorResourceDownloader.this.f275036d, "preDownloadAllRes---ensureSetupDownloadConfig finish");
                ArrayList arrayList = new ArrayList();
                VideoEditorResourceDownloader.this.a(arrayList);
                for (AEEditorDownloadResBean aEEditorDownloadResBean : VideoEditorResourceDownloader.this.f275037e.values()) {
                    if (aEEditorDownloadResBean != null && aEEditorDownloadResBean.getPreDownload() == 1 && !VideoEditorResourceDownloader.this.i(aEEditorDownloadResBean)) {
                        arrayList.add(aEEditorDownloadResBean);
                    }
                }
                VideoEditorResourceDownloader.this.b(arrayList);
                mj2.a.d(VideoEditorResourceDownloader.this.f275036d, "preDownloadAllRes---needDownloads size=" + arrayList.size());
                int i3 = 0;
                while (i3 < arrayList.size()) {
                    int min = Math.min(VideoEditorResourceDownloader.this.f275035c, arrayList.size() - i3);
                    CountDownLatch countDownLatch = new CountDownLatch(min);
                    int i16 = 0;
                    while (i16 < min) {
                        AEEditorDownloadResBean aEEditorDownloadResBean2 = (AEEditorDownloadResBean) arrayList.get(i3);
                        mj2.a.d(VideoEditorResourceDownloader.this.f275036d, "preDownloadAllRes---[begin] " + i3 + ", id=" + aEEditorDownloadResBean2.getId());
                        VideoEditorResourceDownloader.this.d(aEEditorDownloadResBean2, new a(i3, aEEditorDownloadResBean2, countDownLatch));
                        i16++;
                        i3++;
                    }
                    try {
                        countDownLatch.await();
                    } catch (InterruptedException e16) {
                        e16.printStackTrace();
                    }
                    mj2.a.d(VideoEditorResourceDownloader.this.f275036d, "preDownloadAllRes--------------------finish a little group---------------------");
                }
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                mj2.a.d(VideoEditorResourceDownloader.this.f275036d, "preDownloadAllRes---END cost=" + currentTimeMillis2);
                SimpleEventBus.getInstance().dispatchEvent(new ResourcePreDownFinishEvent());
            }

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.qqvideoedit.edit.manager.VideoEditorResourceDownloader$2$a */
            /* loaded from: classes17.dex */
            class a implements d {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ int f275042a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ AEEditorDownloadResBean f275043b;

                /* renamed from: c, reason: collision with root package name */
                final /* synthetic */ CountDownLatch f275044c;

                a(int i3, AEEditorDownloadResBean aEEditorDownloadResBean, CountDownLatch countDownLatch) {
                    this.f275042a = i3;
                    this.f275043b = aEEditorDownloadResBean;
                    this.f275044c = countDownLatch;
                }

                @Override // com.tencent.mobileqq.qqvideoedit.edit.manager.VideoEditorResourceDownloader.d
                public void onDownloadFinish(boolean z16) {
                    mj2.a.d(VideoEditorResourceDownloader.this.f275036d, "preDownloadAllRes---[finish] " + this.f275042a + ", id=" + this.f275043b.getId());
                    this.f275044c.countDown();
                }

                @Override // com.tencent.mobileqq.qqvideoedit.edit.manager.VideoEditorResourceDownloader.d
                public void onProgressUpdate(int i3) {
                }
            }
        }, 128, null, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public String l(String str) {
        InputStream inputStream = null;
        try {
            inputStream = com.tencent.mobileqq.qqvideoedit.a.c().getAssets().open(str);
            String h16 = k.h(inputStream);
            if (inputStream != null) {
                try {
                    inputStream.close();
                    return h16;
                } catch (IOException e16) {
                    e16.printStackTrace();
                    return h16;
                }
            }
            return h16;
        } catch (Throwable th5) {
            try {
                mj2.a.c(this.f275036d, "readAssetsFileContent---read assets json exception: fileName=" + str, th5);
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

    public void n(boolean z16) {
        this.f275039g = z16;
    }

    protected void o(String str, boolean z16) {
        AtomicBoolean atomicBoolean = this.f275040h.get(str);
        if (atomicBoolean == null) {
            return;
        }
        synchronized (atomicBoolean) {
            atomicBoolean.compareAndSet(true, false);
            List<d> list = this.f275041i.get(str);
            if (list != null) {
                for (d dVar : list) {
                    if (dVar != null) {
                        dVar.onDownloadFinish(z16);
                    }
                }
                list.clear();
            }
        }
    }

    protected boolean p(String str, String str2, String str3, String str4) {
        if (q(str, str2, str3, str4) || r(str, str2, str3, str4)) {
            return true;
        }
        return false;
    }

    protected boolean r(String str, String str2, String str3, String str4) {
        File file = new File(str2 + str3);
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            ZipUtils.unZipFile(new File(str), str2 + str3 + "/");
        } catch (IOException e16) {
            mj2.a.c(this.f275036d, "unZipNoPackage-- exception ", e16);
        }
        mj2.a.b(this.f275036d, "unZipNoPackage-- zipPath: " + str2 + str3);
        return k(str2, str3, str4);
    }
}
