package com.tencent.biz.videostory.entrancewidget;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.util.cu;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.f;
import com.tencent.mobileqq.vip.g;
import com.tencent.mobileqq.vip.h;
import cooperation.qzone.util.FileUtils;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mf0.c;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    public static String f97085b;

    /* renamed from: c, reason: collision with root package name */
    private static a f97086c;

    /* renamed from: a, reason: collision with root package name */
    private Map<String, b> f97087a = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.biz.videostory.entrancewidget.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0987a extends f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Downloader.DownloadListener f97088a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f97089b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f97090c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f97091d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f97092e;

        C0987a(Downloader.DownloadListener downloadListener, String str, b bVar, String str2, String str3) {
            this.f97088a = downloadListener;
            this.f97089b = str;
            this.f97090c = bVar;
            this.f97091d = str2;
            this.f97092e = str3;
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onCancel(g gVar) {
            Downloader.DownloadListener downloadListener = this.f97088a;
            if (downloadListener != null) {
                downloadListener.onDownloadCanceled(this.f97089b);
            }
            this.f97090c.f97094a = 3;
            QZLog.e("Q.videostory.config.VSEntranceWidgetDownLoadHelper", 1, "onDownloadCanceled");
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onDone(g gVar) {
            if (gVar.f313006d == 0) {
                if (new File(a.f97085b).exists()) {
                    boolean unzip = FileUtils.unzip(new File(this.f97089b), new File(a.f97085b + "/" + this.f97091d));
                    if (!unzip) {
                        this.f97090c.f97094a = 2;
                    } else {
                        Downloader.DownloadListener downloadListener = this.f97088a;
                        if (downloadListener != null) {
                            downloadListener.onDownloadSucceed(this.f97089b, new DownloadResult(this.f97092e));
                        }
                        new File(this.f97089b).delete();
                        this.f97090c.f97094a = 0;
                    }
                    QZLog.i("Q.videostory.config.VSEntranceWidgetDownLoadHelper", 1, "downLoadByIdsuccess:" + unzip);
                    return;
                }
                return;
            }
            Downloader.DownloadListener downloadListener2 = this.f97088a;
            if (downloadListener2 != null) {
                downloadListener2.onDownloadFailed(this.f97089b, new DownloadResult(this.f97092e));
            }
            this.f97090c.f97094a = 2;
            QZLog.e("Q.videostory.config.VSEntranceWidgetDownLoadHelper", 1, "downLoadByIdonDownloadFailed:");
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onProgress(g gVar) {
            Downloader.DownloadListener downloadListener = this.f97088a;
            if (downloadListener != null) {
                downloadListener.onDownloadProgress(this.f97089b, 0L, 0.0f);
            }
            this.f97090c.f97094a = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        private int f97094a = -1;

        b() {
        }
    }

    a() {
        i();
    }

    public static synchronized a e() {
        a aVar;
        synchronized (a.class) {
            if (f97086c == null) {
                f97086c = new a();
            }
            aVar = f97086c;
        }
        return aVar;
    }

    private void i() {
        if (cu.e()) {
            f97085b = new File(BaseApplicationImpl.getApplication().getExternalCacheDir(), "video_story").getAbsolutePath();
        } else {
            f97085b = new File(BaseApplicationImpl.getApplication().getCacheDir(), "video_story").getAbsolutePath();
        }
        QZLog.i("Q.videostory.config.VSEntranceWidgetDownLoadHelper", 1, "intDownLoadRoot" + f97085b);
    }

    public void a(mf0.b bVar) {
        if (bVar != null) {
            c(bVar.b(), null);
        }
    }

    public void b(c cVar) {
        if (cVar != null) {
            c(cVar.a(), null);
        }
    }

    public void c(String str, Downloader.DownloadListener downloadListener) {
        QZLog.i("Q.videostory.config.VSEntranceWidgetDownLoadHelper", 1, "downLoadByUrl:" + str);
        if (TextUtils.isEmpty(str)) {
            QZLog.e("Q.videostory.config.VSEntranceWidgetDownLoadHelper", 1, "downLoadByUrl:url is empty");
            return;
        }
        String f16 = f(str);
        if (TextUtils.isEmpty(f16)) {
            QZLog.e("Q.videostory.config.VSEntranceWidgetDownLoadHelper", 1, "downLoadByUrl:prefixId is empty");
            return;
        }
        QZLog.d("Q.videostory.config.VSEntranceWidgetDownLoadHelper", 1, "downLoadByUrl:prefixId:" + f16);
        if (g(f16)) {
            QZLog.d("Q.videostory.config.VSEntranceWidgetDownLoadHelper", 1, "downLoadByUrl:resource has download");
            return;
        }
        if (j(f16)) {
            QZLog.d("Q.videostory.config.VSEntranceWidgetDownLoadHelper", 1, "downLoadByUrl:resource on download");
            return;
        }
        if (TextUtils.isEmpty(f97085b)) {
            QZLog.e("Q.videostory.config.VSEntranceWidgetDownLoadHelper", 1, "downLoadByUrl:mDownLoadRoot is empty");
            return;
        }
        String str2 = f97085b + "/" + f16 + ".zip";
        if (!TextUtils.isEmpty(str)) {
            b bVar = new b();
            this.f97087a.put(f16, bVar);
            h u16 = ((DownloaderFactory) ((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.DOWNLOADER_FACTORY)).u(1);
            if (u16 != null) {
                g gVar = new g(str, new File(str2));
                gVar.f313008f = 1;
                u16.startDownload(gVar, new C0987a(downloadListener, str2, bVar, f16, str), new Bundle());
            }
        }
    }

    public String d(String str) {
        return f97085b + "/" + f(str);
    }

    public String f(String str) {
        try {
            String str2 = str.split("/")[r3.length - 1];
            return str2.substring(0, str2.indexOf(".zip"));
        } catch (Exception e16) {
            e16.printStackTrace();
            return "";
        }
    }

    public boolean g(String str) {
        String str2 = f97085b + "/" + str;
        if (new File(str2 + ".zip").exists()) {
            QZLog.d("Q.videostory.config.VSEntranceWidgetDownLoadHelper", 1, "upZip failed:" + str);
            return false;
        }
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        boolean exists = new File(str2).exists();
        if (exists) {
            b bVar = new b();
            bVar.f97094a = 0;
            this.f97087a.put(str, bVar);
        }
        return exists;
    }

    public boolean h(String str) {
        String f16 = f(str);
        if (!TextUtils.isEmpty(f16)) {
            return g(f16);
        }
        return false;
    }

    public boolean j(String str) {
        b bVar = this.f97087a.get(str);
        if (bVar == null) {
            return false;
        }
        if (bVar.f97094a != -1 && bVar.f97094a != 1) {
            return false;
        }
        return true;
    }
}
