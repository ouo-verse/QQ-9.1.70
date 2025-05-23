package com.qzone.proxy.personalitycomponent.canvasui;

import android.text.TextUtils;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.util.FileUtils;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.io.IOException;
import mqq.util.WeakReference;

/* loaded from: classes39.dex */
public class QZoneCanvasPersonalityDownLoader implements Downloader.DownloadListener {

    /* renamed from: c, reason: collision with root package name */
    private static QZoneCanvasPersonalityDownLoader f50959c;

    /* renamed from: a, reason: collision with root package name */
    private Downloader f50960a;

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<OnPersonalityLoadListener> f50961b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class DownloadEntity {

        /* renamed from: a, reason: collision with root package name */
        String f50962a;

        /* renamed from: b, reason: collision with root package name */
        String f50963b;

        /* renamed from: c, reason: collision with root package name */
        String f50964c;

        public DownloadEntity(String str) {
            this.f50962a = str;
            this.f50963b = String.valueOf(str.hashCode());
            this.f50964c = CacheManager.getPersonalityWidgetCacheService().getPath(this.f50963b);
        }
    }

    /* loaded from: classes39.dex */
    public interface OnPersonalityLoadListener {
        void onLoadFail(String str);

        void onLoadSuccess(String str);
    }

    QZoneCanvasPersonalityDownLoader() {
        this.f50960a = null;
        this.f50960a = DownloaderFactory.getInstance(BaseApplication.context).getCommonDownloader();
    }

    private boolean a(DownloadEntity downloadEntity) {
        File file;
        return (TextUtils.isEmpty(downloadEntity.f50964c) || (file = CacheManager.getPersonalityWidgetCacheService().getFile(downloadEntity.f50963b)) == null || !file.exists() || file.isDirectory()) ? false : true;
    }

    private void b(String str) {
        WeakReference<OnPersonalityLoadListener> weakReference;
        OnPersonalityLoadListener onPersonalityLoadListener;
        File file;
        String str2;
        if (TextUtils.isEmpty(str) || (weakReference = this.f50961b) == null || (onPersonalityLoadListener = weakReference.get()) == null || (file = CacheManager.getPersonalityWidgetCacheService().getFile(str)) == null || !file.exists() || file.isDirectory()) {
            return;
        }
        try {
            str2 = FileUtils.readStringFromFile(file);
        } catch (IOException e16) {
            e16.printStackTrace();
            str2 = null;
        }
        if (TextUtils.isEmpty(str2)) {
            onPersonalityLoadListener.onLoadFail("file content is Empty");
        } else {
            onPersonalityLoadListener.onLoadSuccess(str2);
        }
    }

    public static QZoneCanvasPersonalityDownLoader getInstance() {
        QZoneCanvasPersonalityDownLoader qZoneCanvasPersonalityDownLoader = f50959c;
        if (qZoneCanvasPersonalityDownLoader != null) {
            return qZoneCanvasPersonalityDownLoader;
        }
        synchronized (QZoneCanvasPersonalityDownLoader.class) {
            QZoneCanvasPersonalityDownLoader qZoneCanvasPersonalityDownLoader2 = f50959c;
            if (qZoneCanvasPersonalityDownLoader2 != null) {
                return qZoneCanvasPersonalityDownLoader2;
            }
            QZoneCanvasPersonalityDownLoader qZoneCanvasPersonalityDownLoader3 = new QZoneCanvasPersonalityDownLoader();
            f50959c = qZoneCanvasPersonalityDownLoader3;
            return qZoneCanvasPersonalityDownLoader3;
        }
    }

    public void loadPersonalityFile(String str, OnPersonalityLoadListener onPersonalityLoadListener) {
        if (TextUtils.isEmpty(str) || onPersonalityLoadListener == null || this.f50960a == null) {
            return;
        }
        this.f50961b = new WeakReference<>(onPersonalityLoadListener);
        DownloadEntity downloadEntity = new DownloadEntity(str);
        if (a(downloadEntity)) {
            b(downloadEntity.f50963b);
        } else {
            this.f50960a.download(downloadEntity.f50962a, downloadEntity.f50964c, this);
        }
    }

    @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
    public void onDownloadCanceled(String str) {
        OnPersonalityLoadListener onPersonalityLoadListener;
        if (QZLog.isColorLevel()) {
            QZLog.e("QZCPersonalityDownLoader", "onDownloadCanceled: " + str);
        }
        WeakReference<OnPersonalityLoadListener> weakReference = this.f50961b;
        if (weakReference == null || (onPersonalityLoadListener = weakReference.get()) == null) {
            return;
        }
        onPersonalityLoadListener.onLoadFail("onDownloadCanceled");
    }

    @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
    public void onDownloadFailed(String str, DownloadResult downloadResult) {
        OnPersonalityLoadListener onPersonalityLoadListener;
        if (QZLog.isColorLevel()) {
            QZLog.e("QZCPersonalityDownLoader", "onDownloadFailed: " + str);
        }
        WeakReference<OnPersonalityLoadListener> weakReference = this.f50961b;
        if (weakReference == null || (onPersonalityLoadListener = weakReference.get()) == null) {
            return;
        }
        onPersonalityLoadListener.onLoadFail("onDownloadFailed");
    }

    @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
    public void onDownloadSucceed(String str, DownloadResult downloadResult) {
        if (QZLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onDownloadSucceed: ");
            sb5.append(downloadResult == null);
            QZLog.i("QZCPersonalityDownLoader", sb5.toString());
        }
        if (downloadResult != null) {
            b(String.valueOf(str.hashCode()));
        }
    }

    @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
    public void onDownloadProgress(String str, long j3, float f16) {
    }
}
