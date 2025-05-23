package com.qzone.widget.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.qzone.misc.network.downloader.FileDownloaderManager;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes37.dex */
public class ImageDownloadDirector implements Downloader.DownloadListener {

    /* renamed from: a, reason: collision with root package name */
    private final String f61083a;

    /* renamed from: b, reason: collision with root package name */
    private final String f61084b;

    /* renamed from: c, reason: collision with root package name */
    private final int f61085c;

    /* renamed from: d, reason: collision with root package name */
    private final a f61086d;

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f61087e;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface a {
        void a(String str, Bitmap bitmap);
    }

    public ImageDownloadDirector(Context context, String str, int i3, a aVar) {
        if (str != null && aVar != null) {
            this.f61083a = str;
            this.f61086d = aVar;
            this.f61084b = CacheManager.getImageFilePath(context, str);
            this.f61085c = i3;
            this.f61087e = false;
            return;
        }
        throw new NullPointerException("null url or listener");
    }

    private void e(final boolean z16) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).post(new Runnable() { // from class: com.qzone.widget.util.ImageDownloadDirector.1
            @Override // java.lang.Runnable
            public void run() {
                final Bitmap f16 = ImageDownloadDirector.this.f();
                if (f16 != null) {
                    QzoneHandlerThreadFactory.getMainHandler().post(new Runnable() { // from class: com.qzone.widget.util.ImageDownloadDirector.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ImageDownloadDirector.this.f61086d.a(ImageDownloadDirector.this.f61083a, f16);
                        }
                    });
                } else if (z16) {
                    ImageDownloadDirector.this.g();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Bitmap f() {
        BufferedInputStream bufferedInputStream;
        StringBuilder sb5;
        File file = new File(this.f61084b);
        Bitmap bitmap = null;
        if (!file.exists()) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = this.f61085c;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file), 8192);
        } catch (Throwable th5) {
            th = th5;
            bufferedInputStream = null;
        }
        try {
            bitmap = BitmapFactory.decodeStream(bufferedInputStream, null, options);
            try {
                bufferedInputStream.close();
            } catch (IOException e16) {
                e = e16;
                sb5 = new StringBuilder();
                sb5.append("decodeImage: failed to close stream ");
                sb5.append(this.f61084b);
                QZLog.w("ImageDownloadDirector", sb5.toString(), e);
                if (bitmap == null) {
                }
                return bitmap;
            }
        } catch (Throwable th6) {
            th = th6;
            try {
                QZLog.w("ImageDownloadDirector", "occur an error in decoding bitmap " + this.f61084b, th);
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e17) {
                        e = e17;
                        sb5 = new StringBuilder();
                        sb5.append("decodeImage: failed to close stream ");
                        sb5.append(this.f61084b);
                        QZLog.w("ImageDownloadDirector", sb5.toString(), e);
                        if (bitmap == null) {
                        }
                        return bitmap;
                    }
                }
                if (bitmap == null) {
                }
                return bitmap;
            } catch (Throwable th7) {
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e18) {
                        QZLog.w("ImageDownloadDirector", "decodeImage: failed to close stream " + this.f61084b, e18);
                    }
                }
                throw th7;
            }
        }
        if (bitmap == null) {
            QZLog.w("ImageDownloadDirector", "decodeImageSync: failed to decode bitmap " + this.f61084b);
        }
        return bitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.f61087e = FileDownloaderManager.g().getDownloader().download(this.f61083a, this.f61084b, this);
    }

    public String h() {
        return this.f61083a;
    }

    public boolean i() {
        return this.f61087e;
    }

    public void j() {
        if (this.f61087e) {
            return;
        }
        e(true);
    }

    @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
    public void onDownloadCanceled(String str) {
        QZLog.d("ImageDownloadDirector", 4, "onDownloadCanceled: " + str);
        this.f61087e = false;
    }

    @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
    public void onDownloadFailed(String str, DownloadResult downloadResult) {
        QZLog.d("ImageDownloadDirector", 4, "onDownloadFailed: " + str + " " + downloadResult.getStatus());
        this.f61087e = false;
    }

    @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
    public void onDownloadSucceed(String str, DownloadResult downloadResult) {
        QZLog.d("ImageDownloadDirector", 4, "onDownloadSucceed: " + str);
        this.f61087e = false;
        e(false);
    }

    @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
    public void onDownloadProgress(String str, long j3, float f16) {
    }
}
