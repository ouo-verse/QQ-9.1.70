package com.qzone.misc.network.downloader;

import android.text.TextUtils;
import com.tencent.component.media.image.ImageManager;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.component.network.utils.thread.PriorityThreadFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.reborn.QZoneDownloadSharedPreferencesProvider;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    private static a f48385b = null;

    /* renamed from: c, reason: collision with root package name */
    private static Object f48386c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public static boolean f48387d = true;

    /* renamed from: e, reason: collision with root package name */
    private static String f48388e;

    /* renamed from: a, reason: collision with root package name */
    Downloader f48389a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.qzone.misc.network.downloader.a$a, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    public class C0399a {

        /* renamed from: a, reason: collision with root package name */
        String f48390a;

        /* renamed from: b, reason: collision with root package name */
        String f48391b;

        /* renamed from: c, reason: collision with root package name */
        String f48392c;

        public C0399a(String str) {
            this.f48390a = str;
            this.f48391b = String.valueOf(str.hashCode());
            this.f48392c = VFSAssistantUtils.getSDKPrivatePath(CacheManager.getBatchImageDownloadCacheService().getPath(this.f48391b));
        }
    }

    a() {
        f();
        f48388e = ImageManager.getStorePath(BaseApplication.getContext(), "", false, true);
    }

    private Executor b() {
        return new BaseThreadPoolExecutor(2, 5, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new PriorityThreadFactory("batch_image_download_thread", 10));
    }

    public static a d() {
        if (f48385b == null) {
            synchronized (f48386c) {
                if (f48385b == null) {
                    f48385b = new a();
                }
            }
        }
        return f48385b;
    }

    private void f() {
        DownloaderFactory.getInstance(BaseApplication.getContext());
        DownloaderFactory.init(new f(), new c(), QZoneDownloadSharedPreferencesProvider.INSTANCE);
        Downloader createDownloader = DownloaderFactory.createDownloader("BatchDownloadManager", ThreadManagerV2.getNetExcutor(), b());
        this.f48389a = createDownloader;
        if (createDownloader == null) {
            return;
        }
        if (f48387d) {
            createDownloader.setNetworkFlowStatistics(new g());
        }
        this.f48389a.enableResumeTransfer();
        this.f48389a.setPortConfigStrategy(new QzoneDownloadPortConfig());
        this.f48389a.setDirectIPConfigStrategy(new h());
        this.f48389a.setBackupIPConfigStrategy(new d());
        this.f48389a.setKeepAliveStrategy(new e());
    }

    public void a(String str, Downloader.DownloadListener downloadListener) {
        Downloader downloader = this.f48389a;
        if (downloader != null) {
            downloader.abort(str, downloadListener);
        } else {
            QZLog.w("FileDownloaderManager", 1, "abortDownload, mDownloader is null");
        }
    }

    public String c(String str, Downloader.DownloadListener downloadListener) {
        if (this.f48389a == null) {
            QZLog.w("FileDownloaderManager", 1, "download, mDownloader is null");
            f();
            if (this.f48389a == null) {
                QZLog.e("FileDownloaderManager", 1, "download, mDownloader is null");
                return null;
            }
        }
        C0399a c0399a = new C0399a(str);
        QLog.i("BatchDownloadManager", 1, "path is " + c0399a.f48392c);
        if (e(c0399a)) {
            return c0399a.f48392c;
        }
        try {
            this.f48389a.download(c0399a.f48390a, c0399a.f48392c, downloadListener);
        } catch (RejectedExecutionException e16) {
            e16.printStackTrace();
        }
        return null;
    }

    public boolean e(C0399a c0399a) {
        File file;
        return (TextUtils.isEmpty(c0399a.f48392c) || (file = CacheManager.getBatchImageDownloadCacheService().getFile(c0399a.f48391b)) == null || !file.exists() || file.isDirectory()) ? false : true;
    }
}
