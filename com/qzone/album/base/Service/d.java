package com.qzone.album.base.Service;

import android.text.TextUtils;
import com.qzone.album.util.j;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.util.QZLog;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class d {

    /* renamed from: b, reason: collision with root package name */
    private static d f42038b;

    /* renamed from: a, reason: collision with root package name */
    private HashMap<String, Downloader.DownloadListener> f42039a = new HashMap<>();

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class a implements Downloader.DownloadListener {

        /* renamed from: a, reason: collision with root package name */
        public String f42040a;

        /* renamed from: b, reason: collision with root package name */
        public int f42041b;

        /* renamed from: c, reason: collision with root package name */
        public int f42042c;

        /* renamed from: d, reason: collision with root package name */
        public int f42043d;

        /* renamed from: e, reason: collision with root package name */
        public int f42044e;

        /* renamed from: f, reason: collision with root package name */
        public int f42045f;

        /* renamed from: g, reason: collision with root package name */
        public com.qzone.homepage.ui.Facade.a f42046g;

        public a(String str, int i3, com.qzone.homepage.ui.Facade.a aVar) {
            this.f42040a = str;
            this.f42043d = i3;
            this.f42046g = aVar;
        }

        public void a() {
            int i3 = this.f42043d;
            if (i3 == 1) {
                this.f42046g.c(this.f42040a, this.f42041b, this.f42042c);
                return;
            }
            int i16 = this.f42044e;
            if (i16 == i3) {
                this.f42046g.c(this.f42040a, this.f42041b, this.f42042c);
                return;
            }
            int i17 = (int) ((i16 / i3) * 100.0f);
            this.f42045f = i17;
            this.f42046g.a(this.f42040a, i17);
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadCanceled(String str) {
            this.f42041b++;
            int i3 = this.f42044e + 1;
            this.f42044e = i3;
            QZLog.d("[PhotoAlbum]downloadPhotoAndVideo", 1, "onDownloadCanceled:", Integer.valueOf(i3), " url:", str);
            this.f42046g.d(this.f42040a, this.f42043d, this.f42044e, str);
            a();
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public synchronized void onDownloadFailed(String str, DownloadResult downloadResult) {
            this.f42041b++;
            int i3 = this.f42044e + 1;
            this.f42044e = i3;
            QZLog.d("[PhotoAlbum]downloadPhotoAndVideo", 1, "onDownloadFailed downloadedCount:", Integer.valueOf(i3), " failCount:", Integer.valueOf(this.f42041b), " url:", str);
            this.f42046g.b(this.f42040a, this.f42043d, this.f42044e, str);
            a();
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadProgress(String str, long j3, float f16) {
            if (this.f42043d == 1) {
                int i3 = (int) (f16 * 100.0f);
                this.f42045f = i3;
                this.f42046g.a(this.f42040a, i3);
            }
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public synchronized void onDownloadSucceed(String str, DownloadResult downloadResult) {
            this.f42042c++;
            int i3 = this.f42044e + 1;
            this.f42044e = i3;
            QZLog.d("[PhotoAlbum]downloadPhotoAndVideo", 1, "onDownloadSucceed downloadedCount:", Integer.valueOf(i3), " successCount:", Integer.valueOf(this.f42042c), " url:", str);
            this.f42046g.e(this.f42040a, this.f42043d, this.f42044e, str);
            if (downloadResult != null) {
                QZLog.d("[PhotoAlbum]downloadPhotoAndVideo", 1, "onDownloadSucceed savePath:", j.a(CacheManager.getBatchImageDownloadCacheService().getPath(String.valueOf(str.hashCode()))));
            }
            a();
        }
    }

    d() {
    }

    public static synchronized d e() {
        d dVar;
        synchronized (d.class) {
            if (f42038b == null) {
                f42038b = new d();
            }
            dVar = f42038b;
        }
        return dVar;
    }

    public void b(String str, List<String> list) {
        Downloader.DownloadListener d16 = d(str);
        if (d16 == null) {
            QZLog.e("QzoneBatchPhotoDownloadService", 2, "status == null taskId:", str);
            return;
        }
        for (String str2 : list) {
            if (!TextUtils.isEmpty(str2)) {
                com.qzone.misc.network.downloader.a.d().a(str2, d16);
            }
        }
    }

    public void c(String str, List<String> list, com.qzone.homepage.ui.Facade.a aVar) {
        if (d(str) != null) {
            QZLog.d("QzoneBatchPhotoDownloadService", 2, "status != null taskId:", str);
            return;
        }
        if (list != null) {
            a aVar2 = new a(str, list.size(), aVar);
            a(str, aVar2);
            for (String str2 : list) {
                if (QZLog.isColorLevel()) {
                    QZLog.d("QzoneBatchPhotoDownloadService", 2, "url:" + str2);
                }
                String c16 = com.qzone.misc.network.downloader.a.d().c(str2, aVar2);
                if (!TextUtils.isEmpty(c16)) {
                    if (QZLog.isColorLevel()) {
                        QZLog.d("QzoneBatchPhotoDownloadService", 2, "f.exists()");
                    }
                    DownloadResult downloadResult = new DownloadResult(str2);
                    downloadResult.setPath(c16);
                    aVar2.onDownloadSucceed(str2, downloadResult);
                }
            }
        }
    }

    protected boolean a(String str, Downloader.DownloadListener downloadListener) {
        if (str == null) {
            return false;
        }
        synchronized (this.f42039a) {
            this.f42039a.put(str, downloadListener);
        }
        return true;
    }

    public Downloader.DownloadListener d(String str) {
        Downloader.DownloadListener downloadListener;
        if (str == null) {
            return null;
        }
        synchronized (this.f42039a) {
            downloadListener = this.f42039a.get(str);
        }
        return downloadListener;
    }
}
