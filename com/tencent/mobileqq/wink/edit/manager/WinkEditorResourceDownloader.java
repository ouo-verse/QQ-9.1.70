package com.tencent.mobileqq.wink.edit.manager;

import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.gson.reflect.TypeToken;
import com.tencent.aelight.camera.report.api.IAEBaseDataReporter;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.wink.edit.bean.AEEditorDownloadResBean;
import com.tencent.mobileqq.wink.event.ResourcePreDownFinishEvent;
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
import y53.a;

/* compiled from: P */
/* loaded from: classes21.dex */
public abstract class WinkEditorResourceDownloader {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    protected final String f318256a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    protected final String f318257b;

    /* renamed from: c, reason: collision with root package name */
    protected final int f318258c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    protected final String f318259d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    protected final Map<String, AEEditorDownloadResBean> f318260e = new LinkedHashMap();

    /* renamed from: f, reason: collision with root package name */
    protected volatile boolean f318261f = false;

    /* renamed from: g, reason: collision with root package name */
    protected volatile boolean f318262g = false;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    protected final Map<String, AtomicBoolean> f318263h = new HashMap();

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    protected final Map<String, List<d>> f318264i = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class a extends TypeToken<List<AEEditorDownloadResBean>> {
        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class b implements a.InterfaceC11592a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f318272a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f318273b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f318274c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AEEditorDownloadResBean f318275d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f318276e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f318277f;

        b(d dVar, String str, long j3, AEEditorDownloadResBean aEEditorDownloadResBean, String str2, String str3) {
            this.f318272a = dVar;
            this.f318273b = str;
            this.f318274c = j3;
            this.f318275d = aEEditorDownloadResBean;
            this.f318276e = str2;
            this.f318277f = str3;
        }

        @Override // y53.a.InterfaceC11592a
        public void a(NetResp netResp) {
            boolean z16;
            com.tencent.mobileqq.winkpublish.report.b bVar;
            boolean z17 = false;
            if (netResp == null) {
                d dVar = this.f318272a;
                if (dVar != null) {
                    dVar.onDownloadFinish(false);
                }
                WinkEditorResourceDownloader.this.B(this.f318273b, false);
                return;
            }
            p83.a.f425783a.h(this.f318275d.getUrl(), netResp, System.currentTimeMillis() - this.f318274c);
            if (netResp.mResult == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            com.tencent.mobileqq.winkpublish.report.b bVar2 = null;
            if (z16) {
                String calcMd5 = FileUtils.calcMd5(this.f318276e);
                if (calcMd5 != null && calcMd5.equalsIgnoreCase(this.f318273b)) {
                    try {
                        z17 = WinkEditorResourceDownloader.this.C(this.f318276e, this.f318277f, this.f318275d.getId(), this.f318273b);
                    } catch (Exception e16) {
                        bVar = new com.tencent.mobileqq.winkpublish.report.b(com.tencent.mobileqq.winkpublish.report.b.C, e16.getMessage());
                        w53.b.d(WinkEditorResourceDownloader.this.f318259d, "downLoadOneResInternal-onDownloadFinish---unZipFile failed, id=" + this.f318275d.getId(), e16);
                    }
                } else {
                    bVar = new com.tencent.mobileqq.winkpublish.report.b(com.tencent.mobileqq.winkpublish.report.b.f327391m, null);
                    w53.b.c(WinkEditorResourceDownloader.this.f318259d, "downLoadOneResInternal-onDownloadFinish---MD5 check failed, id=" + this.f318275d.getId());
                }
                bVar2 = bVar;
            }
            if (!z17) {
                FileUtils.deleteDirectory(this.f318277f);
            }
            FileUtils.deleteFile(this.f318276e);
            w53.b.f(WinkEditorResourceDownloader.this.f318259d, "downLoadOneResInternal-onDownloadFinish respIsSuccess=" + z16 + ",result=" + z17 + ", id=" + this.f318275d.getId());
            d dVar2 = this.f318272a;
            if (dVar2 != null) {
                dVar2.onDownloadFinish(z17);
            }
            WinkEditorResourceDownloader.this.B(this.f318273b, z17);
            p83.a.f425783a.f(this.f318275d.getUrl(), bVar2);
        }

        @Override // y53.a.InterfaceC11592a
        public void onProgressUpdate(int i3) {
            d dVar = this.f318272a;
            if (dVar != null) {
                dVar.onProgressUpdate(i3);
            }
            p83.a.f425783a.g(this.f318275d.getUrl(), i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class c implements a.InterfaceC11592a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f318279a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f318280b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f318281c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ MetaMaterial f318282d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f318283e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f318284f;

        c(d dVar, String str, long j3, MetaMaterial metaMaterial, String str2, String str3) {
            this.f318279a = dVar;
            this.f318280b = str;
            this.f318281c = j3;
            this.f318282d = metaMaterial;
            this.f318283e = str2;
            this.f318284f = str3;
        }

        @Override // y53.a.InterfaceC11592a
        public void a(NetResp netResp) {
            boolean z16;
            boolean z17 = false;
            if (netResp == null) {
                d dVar = this.f318279a;
                if (dVar != null) {
                    dVar.onDownloadFinish(false);
                }
                WinkEditorResourceDownloader.this.B(this.f318280b, false);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis() - this.f318281c;
            p83.a.f425783a.h(this.f318282d.packageUrl, netResp, currentTimeMillis);
            if (netResp.mResult == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            com.tencent.mobileqq.winkpublish.report.b bVar = null;
            if (z16) {
                String calcMd5 = FileUtils.calcMd5(this.f318283e);
                if (calcMd5 != null && calcMd5.equalsIgnoreCase(this.f318280b)) {
                    try {
                        z17 = WinkEditorResourceDownloader.this.C(this.f318283e, this.f318284f, this.f318282d.f30533id, this.f318280b);
                        WinkEditorResourceDownloader.this.z(this.f318283e, this.f318282d, currentTimeMillis, this.f318280b, netResp.mErrCode, netResp.mTotalFileLen);
                    } catch (Exception e16) {
                        bVar = new com.tencent.mobileqq.winkpublish.report.b(com.tencent.mobileqq.winkpublish.report.b.C, e16.getMessage());
                        w53.b.d(WinkEditorResourceDownloader.this.f318259d, "downLoadOneResInternal-onDownloadFinish---unZipFile failed, id=" + this.f318282d.f30533id, e16);
                    }
                } else {
                    com.tencent.mobileqq.winkpublish.report.b bVar2 = new com.tencent.mobileqq.winkpublish.report.b(com.tencent.mobileqq.winkpublish.report.b.f327391m, null);
                    w53.b.c(WinkEditorResourceDownloader.this.f318259d, "downLoadOneResInternal-onDownloadFinish---MD5 check failed, id=" + this.f318282d.f30533id);
                    bVar = bVar2;
                }
            }
            if (!z17) {
                FileUtils.deleteDirectory(this.f318284f);
            }
            FileUtils.deleteFile(this.f318283e);
            w53.b.a(WinkEditorResourceDownloader.this.f318259d, "downLoadOneResInternal-onDownloadFinish respIsSuccess=" + z16 + ",result=" + z17 + ", id=" + this.f318282d.f30533id);
            d dVar2 = this.f318279a;
            if (dVar2 != null) {
                dVar2.onDownloadFinish(z17);
            }
            WinkEditorResourceDownloader.this.B(this.f318280b, z17);
            p83.a.f425783a.f(this.f318282d.packageUrl, bVar);
        }

        @Override // y53.a.InterfaceC11592a
        public void onProgressUpdate(int i3) {
            d dVar = this.f318279a;
            if (dVar != null) {
                dVar.onProgressUpdate(i3);
            }
            p83.a.f425783a.g(this.f318282d.packageUrl, i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public interface d {
        void onDownloadFinish(boolean z16);

        void onProgressUpdate(int i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public interface e {
        boolean a(MetaMaterial metaMaterial);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public WinkEditorResourceDownloader(@NonNull String str, @NonNull String str2, int i3, @NonNull String str3) {
        this.f318256a = str;
        this.f318257b = str2;
        this.f318258c = i3;
        this.f318259d = "[AEEditor2]" + str3;
    }

    private void g(@NonNull MetaMaterial metaMaterial, d dVar, e eVar) {
        AtomicBoolean atomicBoolean;
        w53.b.f(this.f318259d, "downLoadOneResInternal---BEGIN: id=" + metaMaterial.f30533id);
        p83.a aVar = p83.a.f425783a;
        aVar.a(metaMaterial.packageUrl);
        String str = metaMaterial.packageMd5;
        synchronized (this.f318263h) {
            if (this.f318263h.get(str) == null) {
                this.f318263h.put(str, new AtomicBoolean(false));
            }
            atomicBoolean = this.f318263h.get(str);
        }
        synchronized (atomicBoolean) {
            if (atomicBoolean.get()) {
                List<d> list = this.f318264i.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                    this.f318264i.put(str, list);
                }
                if (dVar != null) {
                    list.add(dVar);
                }
                w53.b.f(this.f318259d, "downLoadOneResInternal---is DOWNLOADING: id=" + metaMaterial.f30533id);
                aVar.e(metaMaterial.packageUrl, new com.tencent.mobileqq.winkpublish.report.b(com.tencent.mobileqq.winkpublish.report.b.f327387e, null));
                return;
            }
            atomicBoolean.compareAndSet(false, true);
            if (eVar.a(metaMaterial)) {
                if (dVar != null) {
                    dVar.onDownloadFinish(true);
                }
                B(str, true);
                w53.b.f(this.f318259d, "downLoadOneResInternal---is DOWNLOADED by other: id=" + metaMaterial.f30533id);
                return;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(this.f318257b);
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
            long currentTimeMillis = System.currentTimeMillis();
            aVar.i(metaMaterial.packageUrl);
            y53.a.c().b(metaMaterial.packageUrl, str3, new c(dVar, str, currentTimeMillis, metaMaterial, str3, sb6));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean t(MetaMaterial metaMaterial, MetaMaterial metaMaterial2) {
        return q(metaMaterial);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean u(MetaMaterial metaMaterial, MetaMaterial metaMaterial2) {
        return s(metaMaterial);
    }

    private boolean w(String str, String str2, String str3) {
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    if (file2.getName().replaceAll("\\p{C}", "").equals(str2)) {
                        w53.b.a(this.f318259d, "begin rename zip folder---from: " + file2.getName() + ", to: " + str3);
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(str);
                        sb5.append(file2.getName());
                        return FileUtils.rename(sb5.toString(), str + str3);
                    }
                }
                w53.b.c(this.f318259d, "reNameFile--NOT found folder named " + str2);
            }
        } else {
            w53.b.c(this.f318259d, "reNameFile--toDir not exists or not a directory: " + file);
        }
        return false;
    }

    @WorkerThread
    public static String y(@NonNull String str) {
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
            str2 = com.tencent.biz.common.util.k.h(fileInputStream);
            fileInputStream.close();
        } catch (Throwable th6) {
            th = th6;
            fileInputStream2 = fileInputStream;
            try {
                w53.b.d("WinkEditorResourceDownloader", "readSdCardFileContent---read file json exception: filePath=" + str, th);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void z(String str, @NonNull MetaMaterial metaMaterial, long j3, String str2, int i3, long j16) {
        if (!TextUtils.isEmpty(str) && metaMaterial != null) {
            ((IAEBaseDataReporter) QRoute.api(IAEBaseDataReporter.class)).reportMaterialDownLoad(metaMaterial.f30533id, i3, j3, j16, str2);
        } else {
            w53.b.c(this.f318259d, "reportDownloadInfo has error ");
        }
    }

    public void A(boolean z16) {
        this.f318262g = z16;
    }

    protected void B(String str, boolean z16) {
        AtomicBoolean atomicBoolean = this.f318263h.get(str);
        if (atomicBoolean == null) {
            return;
        }
        synchronized (atomicBoolean) {
            atomicBoolean.compareAndSet(true, false);
            List<d> list = this.f318264i.get(str);
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

    protected boolean C(String str, String str2, String str3, String str4) {
        if (D(str, str2, str3, str4) || E(str, str2, str3, str4)) {
            return true;
        }
        return false;
    }

    protected boolean D(String str, String str2, String str3, String str4) {
        try {
            ZipUtils.unZipFile(new File(str), str2);
            return w(str2, str3, str4);
        } catch (Exception e16) {
            w53.b.d(this.f318259d, "unZipHasPackage--exception ", e16);
            return false;
        }
    }

    protected boolean E(String str, String str2, String str3, String str4) {
        File file = new File(str2 + str3);
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            ZipUtils.unZipFile(new File(str), str2 + str3 + "/");
        } catch (Exception e16) {
            w53.b.d(this.f318259d, "unZipNoPackage-- exception ", e16);
        }
        w53.b.c(this.f318259d, "unZipNoPackage-- zipPath: " + str2 + str3);
        return w(str2, str3, str4);
    }

    protected abstract void d(@NonNull List<AEEditorDownloadResBean> list);

    protected abstract void e(@NonNull List<AEEditorDownloadResBean> list);

    public void f(@NonNull final MetaMaterial metaMaterial, d dVar) {
        g(metaMaterial, dVar, new e() { // from class: com.tencent.mobileqq.wink.edit.manager.l
            @Override // com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader.e
            public final boolean a(MetaMaterial metaMaterial2) {
                boolean t16;
                t16 = WinkEditorResourceDownloader.this.t(metaMaterial, metaMaterial2);
                return t16;
            }
        });
    }

    public void h(@NonNull AEEditorDownloadResBean aEEditorDownloadResBean, d dVar) {
        AtomicBoolean atomicBoolean;
        w53.b.f(this.f318259d, "downLoadOneResInternal---BEGIN: id=" + aEEditorDownloadResBean.getId());
        p83.a aVar = p83.a.f425783a;
        aVar.a(aEEditorDownloadResBean.getUrl());
        String md5 = aEEditorDownloadResBean.getMd5();
        synchronized (this.f318263h) {
            if (this.f318263h.get(md5) == null) {
                this.f318263h.put(md5, new AtomicBoolean(false));
            }
            atomicBoolean = this.f318263h.get(md5);
        }
        synchronized (atomicBoolean) {
            if (atomicBoolean.get()) {
                List<d> list = this.f318264i.get(md5);
                if (list == null) {
                    list = new ArrayList<>();
                    this.f318264i.put(md5, list);
                }
                if (dVar != null) {
                    list.add(dVar);
                }
                w53.b.f(this.f318259d, "downLoadOneResInternal---is DOWNLOADING: id=" + aEEditorDownloadResBean.getId());
                aVar.e(aEEditorDownloadResBean.getUrl(), new com.tencent.mobileqq.winkpublish.report.b(com.tencent.mobileqq.winkpublish.report.b.f327387e, null));
                return;
            }
            atomicBoolean.compareAndSet(false, true);
            if (r(aEEditorDownloadResBean)) {
                if (dVar != null) {
                    dVar.onDownloadFinish(true);
                }
                B(md5, true);
                w53.b.f(this.f318259d, "downLoadOneResInternal---is DOWNLOADED by other: id=" + aEEditorDownloadResBean.getId());
                aVar.e(aEEditorDownloadResBean.getUrl(), new com.tencent.mobileqq.winkpublish.report.b(com.tencent.mobileqq.winkpublish.report.b.f327388f, null));
                return;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(this.f318257b);
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
            long currentTimeMillis = System.currentTimeMillis();
            aVar.i(aEEditorDownloadResBean.getUrl());
            y53.a.c().b(aEEditorDownloadResBean.getUrl(), str2, new b(dVar, md5, currentTimeMillis, aEEditorDownloadResBean, str2, sb6));
        }
    }

    public void i(final String str, final d dVar) {
        if (TextUtils.isEmpty(str)) {
            if (dVar != null) {
                dVar.onDownloadFinish(false);
                return;
            }
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader.3
            @Override // java.lang.Runnable
            public void run() {
                w53.b.f(WinkEditorResourceDownloader.this.f318259d, "downLoadResource--by user--BEGIN id: " + str);
                WinkEditorResourceDownloader.this.k();
                AEEditorDownloadResBean aEEditorDownloadResBean = WinkEditorResourceDownloader.this.f318260e.get(str);
                if (aEEditorDownloadResBean != null) {
                    WinkEditorResourceDownloader.this.h(aEEditorDownloadResBean, dVar);
                    return;
                }
                w53.b.c(WinkEditorResourceDownloader.this.f318259d, "downLoadResource--by user--FAIL, no download config for id: " + str);
                d dVar2 = dVar;
                if (dVar2 != null) {
                    dVar2.onDownloadFinish(false);
                }
            }
        }, 128, null, false);
    }

    public void j(@NonNull final MetaMaterial metaMaterial, d dVar) {
        g(metaMaterial, dVar, new e() { // from class: com.tencent.mobileqq.wink.edit.manager.m
            @Override // com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader.e
            public final boolean a(MetaMaterial metaMaterial2) {
                boolean u16;
                u16 = WinkEditorResourceDownloader.this.u(metaMaterial, metaMaterial2);
                return u16;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public void k() {
        Object valueOf;
        synchronized (this.f318260e) {
            if (this.f318261f) {
                return;
            }
            this.f318261f = true;
            w53.b.f(this.f318259d, "ensureSetupDownloadConfig--BEGIN");
            String x16 = x(this.f318256a);
            if (TextUtils.isEmpty(x16)) {
                w53.b.c(this.f318259d, "ensureSetupDownloadConfig---read assets json content empty");
                return;
            }
            List<AEEditorDownloadResBean> list = (List) GsonUtils.json2Obj(x16, new a().getType());
            String str = this.f318259d;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("ensureSetupDownloadConfig---size = ");
            if (list == null) {
                valueOf = "null";
            } else {
                valueOf = Integer.valueOf(list.size());
            }
            sb5.append(valueOf);
            w53.b.f(str, sb5.toString());
            if (list != null) {
                for (AEEditorDownloadResBean aEEditorDownloadResBean : list) {
                    this.f318260e.put(aEEditorDownloadResBean.getId(), aEEditorDownloadResBean);
                }
            }
        }
    }

    public String l() {
        return this.f318257b + File.separator;
    }

    @NonNull
    public String m(MetaMaterial metaMaterial) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.f318257b);
        String str = File.separator;
        sb5.append(str);
        sb5.append(metaMaterial.f30533id);
        sb5.append(str);
        sb5.append(metaMaterial.packageMd5);
        return sb5.toString();
    }

    @NonNull
    public String n(AEEditorDownloadResBean aEEditorDownloadResBean) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.f318257b);
        String str = File.separator;
        sb5.append(str);
        sb5.append(aEEditorDownloadResBean.getId());
        sb5.append(str);
        sb5.append(aEEditorDownloadResBean.getMd5());
        return sb5.toString();
    }

    public boolean o() {
        return this.f318262g;
    }

    public boolean p(@NonNull AEEditorDownloadResBean aEEditorDownloadResBean) {
        return new File(n(aEEditorDownloadResBean) + File.separator + "effectInfo.json").exists();
    }

    public boolean q(@NonNull MetaMaterial metaMaterial) {
        return new File(m(metaMaterial)).exists();
    }

    public boolean r(@NonNull AEEditorDownloadResBean aEEditorDownloadResBean) {
        if (AEEditorDownloadResBean.RES_TYPE_FILTER.equals(aEEditorDownloadResBean.getResType())) {
            return p(aEEditorDownloadResBean);
        }
        return new File(n(aEEditorDownloadResBean)).exists();
    }

    public boolean s(@NonNull MetaMaterial metaMaterial) {
        return new File(WinkEditorResourceManager.a1().X0(metaMaterial)).exists();
    }

    public void v() {
        if (this.f318262g) {
            return;
        }
        this.f318262g = true;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader.2
            @Override // java.lang.Runnable
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                w53.b.f(WinkEditorResourceDownloader.this.f318259d, "preDownloadAllRes---BEGIN");
                WinkEditorResourceDownloader.this.k();
                w53.b.f(WinkEditorResourceDownloader.this.f318259d, "preDownloadAllRes---ensureSetupDownloadConfig finish");
                ArrayList arrayList = new ArrayList();
                WinkEditorResourceDownloader.this.d(arrayList);
                for (AEEditorDownloadResBean aEEditorDownloadResBean : WinkEditorResourceDownloader.this.f318260e.values()) {
                    if (aEEditorDownloadResBean != null && aEEditorDownloadResBean.getPreDownload() == 1 && !WinkEditorResourceDownloader.this.r(aEEditorDownloadResBean)) {
                        arrayList.add(aEEditorDownloadResBean);
                    }
                }
                WinkEditorResourceDownloader.this.e(arrayList);
                w53.b.f(WinkEditorResourceDownloader.this.f318259d, "preDownloadAllRes---needDownloads size=" + arrayList.size());
                int i3 = 0;
                while (i3 < arrayList.size()) {
                    int min = Math.min(WinkEditorResourceDownloader.this.f318258c, arrayList.size() - i3);
                    CountDownLatch countDownLatch = new CountDownLatch(min);
                    int i16 = 0;
                    while (i16 < min) {
                        AEEditorDownloadResBean aEEditorDownloadResBean2 = (AEEditorDownloadResBean) arrayList.get(i3);
                        w53.b.a(WinkEditorResourceDownloader.this.f318259d, "preDownloadAllRes---[begin] " + i3 + ", id=" + aEEditorDownloadResBean2.getId());
                        WinkEditorResourceDownloader.this.h(aEEditorDownloadResBean2, new a(i3, aEEditorDownloadResBean2, countDownLatch));
                        i16++;
                        i3++;
                    }
                    try {
                        countDownLatch.await();
                    } catch (InterruptedException e16) {
                        e16.printStackTrace();
                    }
                    w53.b.f(WinkEditorResourceDownloader.this.f318259d, "preDownloadAllRes--------------------finish a little group---------------------");
                }
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                w53.b.f(WinkEditorResourceDownloader.this.f318259d, "preDownloadAllRes---END cost=" + currentTimeMillis2);
                SimpleEventBus.getInstance().dispatchEvent(new ResourcePreDownFinishEvent());
            }

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader$2$a */
            /* loaded from: classes21.dex */
            class a implements d {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ int f318265a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ AEEditorDownloadResBean f318266b;

                /* renamed from: c, reason: collision with root package name */
                final /* synthetic */ CountDownLatch f318267c;

                a(int i3, AEEditorDownloadResBean aEEditorDownloadResBean, CountDownLatch countDownLatch) {
                    this.f318265a = i3;
                    this.f318266b = aEEditorDownloadResBean;
                    this.f318267c = countDownLatch;
                }

                @Override // com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader.d
                public void onDownloadFinish(boolean z16) {
                    w53.b.a(WinkEditorResourceDownloader.this.f318259d, "preDownloadAllRes---[finish] " + this.f318265a + ", id=" + this.f318266b.getId());
                    this.f318267c.countDown();
                }

                @Override // com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader.d
                public void onProgressUpdate(int i3) {
                }
            }
        }, 128, null, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public String x(String str) {
        InputStream inputStream = null;
        try {
            inputStream = com.tencent.mobileqq.wink.b.c().getAssets().open(str);
            String h16 = com.tencent.biz.common.util.k.h(inputStream);
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
                w53.b.d(this.f318259d, "readAssetsFileContent---read assets json exception: fileName=" + str, th5);
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
}
