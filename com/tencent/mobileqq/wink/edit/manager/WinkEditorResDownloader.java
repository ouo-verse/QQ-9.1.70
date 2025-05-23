package com.tencent.mobileqq.wink.edit.manager;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.gson.reflect.TypeToken;
import com.tencent.aelight.camera.report.api.IAEBaseDataReporter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.wink.edit.bean.AEEditorDownloadResBean;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResDownloader;
import com.tencent.mobileqq.wink.listener.ResDownLoadListener;
import com.tencent.ttpic.util.GsonUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;
import y53.a;

/* compiled from: P */
/* loaded from: classes21.dex */
public abstract class WinkEditorResDownloader {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    protected final String f318231a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    protected final String f318232b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    protected final String f318233c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    protected final Map<String, Integer> f318234d = new ConcurrentHashMap();

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    protected final Map<String, List<WeakReference<ResDownLoadListener>>> f318235e = new ConcurrentHashMap();

    /* renamed from: f, reason: collision with root package name */
    protected volatile Integer f318236f = 0;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    protected final Map<String, AEEditorDownloadResBean> f318237g = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.wink.edit.manager.WinkEditorResDownloader$2, reason: invalid class name */
    /* loaded from: classes21.dex */
    public class AnonymousClass2 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AEEditorDownloadResBean f318238d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ResDownLoadListener f318239e;

        AnonymousClass2(AEEditorDownloadResBean aEEditorDownloadResBean, ResDownLoadListener resDownLoadListener) {
            this.f318238d = aEEditorDownloadResBean;
            this.f318239e = resDownLoadListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean b(AEEditorDownloadResBean aEEditorDownloadResBean, AEEditorDownloadResBean aEEditorDownloadResBean2) {
            return k.e(WinkEditorResDownloader.this.f318232b, aEEditorDownloadResBean);
        }

        @Override // java.lang.Runnable
        public void run() {
            WinkEditorResDownloader winkEditorResDownloader = WinkEditorResDownloader.this;
            final AEEditorDownloadResBean aEEditorDownloadResBean = this.f318238d;
            winkEditorResDownloader.c(aEEditorDownloadResBean, this.f318239e, new c() { // from class: com.tencent.mobileqq.wink.edit.manager.j
                @Override // com.tencent.mobileqq.wink.edit.manager.WinkEditorResDownloader.c
                public final boolean a(AEEditorDownloadResBean aEEditorDownloadResBean2) {
                    boolean b16;
                    b16 = WinkEditorResDownloader.AnonymousClass2.this.b(aEEditorDownloadResBean, aEEditorDownloadResBean2);
                    return b16;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class a implements a.InterfaceC11592a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f318240a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f318241b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f318242c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AEEditorDownloadResBean f318243d;

        a(String str, long j3, String str2, AEEditorDownloadResBean aEEditorDownloadResBean) {
            this.f318240a = str;
            this.f318241b = j3;
            this.f318242c = str2;
            this.f318243d = aEEditorDownloadResBean;
        }

        @Override // y53.a.InterfaceC11592a
        public void a(NetResp netResp) {
            boolean z16;
            boolean z17 = false;
            if (netResp == null) {
                WinkEditorResDownloader.this.f(this.f318240a, false);
                return;
            }
            if (netResp.mResult == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                long currentTimeMillis = System.currentTimeMillis() - this.f318241b;
                if (FileUtils.calcMd5(this.f318242c) != null) {
                    try {
                        z17 = k.h(this.f318242c, FileUtils.getFileDirectoryOf(this.f318242c), this.f318243d.getId(), this.f318243d.getMd5(), WinkEditorResDownloader.this.f318233c);
                        WinkEditorResDownloader.this.i(this.f318242c, this.f318243d.getId(), currentTimeMillis, this.f318240a, netResp.mErrCode, netResp.mTotalFileLen);
                    } catch (Exception e16) {
                        w53.b.d(WinkEditorResDownloader.this.f318233c, "downLoadOneResInternal-onDownloadFinish---unZipFile failed, id=" + this.f318243d.getId(), e16);
                        e16.printStackTrace();
                    }
                } else {
                    w53.b.f(WinkEditorResDownloader.this.f318233c, "downLoadOneResInternal-onDownloadFinish---MD5 check failed, id=" + this.f318243d.getId());
                }
            }
            k.a(z17, WinkEditorResDownloader.this.f318232b, this.f318243d);
            w53.b.a(WinkEditorResDownloader.this.f318233c, "downLoadOneResInternal-onDownloadFinish respIsSuccess=" + z16 + ",result=" + z17 + ", id=" + this.f318243d.getId());
            WinkEditorResDownloader.this.f(this.f318240a, z17);
        }

        @Override // y53.a.InterfaceC11592a
        public void onProgressUpdate(int i3) {
            WinkEditorResDownloader.this.g(this.f318240a, i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class b extends TypeToken<List<AEEditorDownloadResBean>> {
        b() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public interface c {
        boolean a(AEEditorDownloadResBean aEEditorDownloadResBean);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public WinkEditorResDownloader(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        this.f318231a = str;
        this.f318233c = str2;
        this.f318232b = str3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(@NonNull AEEditorDownloadResBean aEEditorDownloadResBean, ResDownLoadListener resDownLoadListener, c cVar) {
        w53.b.f(this.f318233c, "downLoadOneResInternal---BEGIN: id=" + aEEditorDownloadResBean.getId());
        String md5 = aEEditorDownloadResBean.getMd5();
        h(md5, resDownLoadListener);
        if (e(md5).intValue() == 1) {
            w53.b.f(this.f318233c, "downLoadOneResInternal---is DOWNLOADING: id=" + aEEditorDownloadResBean.getId());
            return;
        }
        l(md5, 1);
        if (cVar.a(aEEditorDownloadResBean)) {
            f(md5, true);
            w53.b.f(this.f318233c, "downLoadOneResInternal---is DOWNLOADED by other: id=" + aEEditorDownloadResBean.getId());
            return;
        }
        g(md5, 0);
        k.b(this.f318232b, aEEditorDownloadResBean.getId());
        String d16 = k.d(this.f318232b, aEEditorDownloadResBean.getId());
        y53.a.c().a(aEEditorDownloadResBean.getUrl(), d16, new a(md5, System.currentTimeMillis(), d16, aEEditorDownloadResBean));
    }

    private void h(String str, ResDownLoadListener resDownLoadListener) {
        if (resDownLoadListener == null) {
            return;
        }
        List<WeakReference<ResDownLoadListener>> list = this.f318235e.get(str);
        if (list == null) {
            list = new ArrayList<>();
            this.f318235e.put(str, list);
        }
        list.add(new WeakReference<>(resDownLoadListener));
    }

    private void k(List<AEEditorDownloadResBean> list) {
        if (list != null && !list.isEmpty()) {
            for (AEEditorDownloadResBean aEEditorDownloadResBean : list) {
                if (aEEditorDownloadResBean != null) {
                    this.f318237g.put(aEEditorDownloadResBean.getId(), aEEditorDownloadResBean);
                }
            }
        }
    }

    public void b(AEEditorDownloadResBean aEEditorDownloadResBean, ResDownLoadListener resDownLoadListener) {
        j(new AnonymousClass2(aEEditorDownloadResBean, resDownLoadListener));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AEEditorDownloadResBean d(String str) {
        if (this.f318237g.containsKey(str)) {
            return this.f318237g.get(str);
        }
        return null;
    }

    public Integer e(String str) {
        if (str == null) {
            return 0;
        }
        return this.f318234d.get(str);
    }

    protected void f(String str, boolean z16) {
        if (e(str) == null) {
            return;
        }
        l(str, 2);
        List<WeakReference<ResDownLoadListener>> list = this.f318235e.get(str);
        if (list != null) {
            for (WeakReference<ResDownLoadListener> weakReference : list) {
                if (weakReference != null && weakReference.get() != null) {
                    weakReference.get().onDownloadFinish(z16);
                }
            }
            list.clear();
            this.f318235e.remove(str);
        }
    }

    protected void g(String str, int i3) {
        List<WeakReference<ResDownLoadListener>> list;
        if (e(str) != null && (list = this.f318235e.get(str)) != null) {
            for (WeakReference<ResDownLoadListener> weakReference : list) {
                if (weakReference != null && weakReference.get() != null) {
                    weakReference.get().onProgressUpdate(i3);
                }
            }
        }
    }

    void i(String str, @NonNull String str2, long j3, String str3, int i3, long j16) {
        if (TextUtils.isEmpty(str)) {
            w53.b.c(this.f318233c, "reportDownloadInfo has error ");
        } else {
            ((IAEBaseDataReporter) QRoute.api(IAEBaseDataReporter.class)).reportMaterialDownLoad(str2, i3, j3, j16, str3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(Runnable runnable) {
        ThreadManagerV2.excute(runnable, 128, null, false);
    }

    public void l(String str, Integer num) {
        this.f318234d.put(str, num);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean m(String str) {
        Object valueOf;
        if (!this.f318237g.isEmpty()) {
            return true;
        }
        w53.b.f(this.f318233c, "setupDownloadConfig--BEGIN");
        String g16 = k.g(str, this.f318233c);
        if (TextUtils.isEmpty(g16)) {
            w53.b.f(this.f318233c, "setupDownloadConfig---read assets json content empty");
            return false;
        }
        List<AEEditorDownloadResBean> list = (List) GsonUtils.json2Obj(g16, new b().getType());
        String str2 = this.f318233c;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("setupDownloadConfig---size = ");
        if (list == null) {
            valueOf = "null";
        } else {
            valueOf = Integer.valueOf(list.size());
        }
        sb5.append(valueOf);
        w53.b.f(str2, sb5.toString());
        k(list);
        return true;
    }
}
