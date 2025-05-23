package c7;

import android.content.Context;
import android.text.TextUtils;
import com.qzone.homepage.diy.preload.DIYPreloadData;
import com.qzone.homepage.diy.protocol.QzoneDIYData;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.ImageManager;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.upload.uinterface.data.UppUploadTask;
import cooperation.qzone.util.QZLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a {

    /* renamed from: f, reason: collision with root package name */
    private static a f30406f;

    /* renamed from: a, reason: collision with root package name */
    private final Downloader f30407a;

    /* renamed from: b, reason: collision with root package name */
    private Context f30408b;

    /* renamed from: d, reason: collision with root package name */
    private String f30410d;

    /* renamed from: c, reason: collision with root package name */
    private final String f30409c = UppUploadTask.sfUppAppId;

    /* renamed from: e, reason: collision with root package name */
    private Downloader.DownloadListener f30411e = new C0173a();

    public a() {
        BaseApplication context = BaseApplication.getContext();
        this.f30408b = context;
        this.f30407a = DownloaderFactory.getInstance(context).getCommonDownloader();
    }

    private void a(String str) {
        if (QZLog.isColorLevel()) {
            QZLog.i("QzoneDIYPreloadService", 2, " start download url = " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(b(str));
        if (QZLog.isColorLevel()) {
            QZLog.i("QzoneDIYPreloadService", 2, " download file path = " + file.getPath() + " is fileExisted = " + file.exists());
        }
        if (file.exists()) {
            return;
        }
        this.f30407a.download(str, file.getPath(), false, this.f30411e);
    }

    public static synchronized a c() {
        a aVar;
        synchronized (a.class) {
            if (f30406f == null) {
                f30406f = new a();
            }
            aVar = f30406f;
        }
        return aVar;
    }

    public void d(QzoneDIYData qzoneDIYData) {
        DIYPreloadData dIYPreloadData;
        if (QZLog.isColorLevel()) {
            QZLog.i("QzoneDIYPreloadService", 2, " preloadResources ");
        }
        if (qzoneDIYData != null && (dIYPreloadData = qzoneDIYData.prealoadData) != null && dIYPreloadData.isParseData()) {
            DIYPreloadData dIYPreloadData2 = qzoneDIYData.prealoadData;
            if (dIYPreloadData2 != null) {
                if (TextUtils.isEmpty(dIYPreloadData2.mImageUrl)) {
                    ImageLoader.getInstance().downloadImage(dIYPreloadData2.mImageUrl, null, null);
                }
                a(dIYPreloadData2.mVideoUrl);
                if (TextUtils.isEmpty(dIYPreloadData2.mVideoFrameUrl)) {
                    ImageLoader.getInstance().downloadImage(dIYPreloadData2.mVideoFrameUrl, null, null);
                    return;
                }
                return;
            }
            return;
        }
        QZLog.e("QzoneDIYPreloadService", 1, "preloadResources with data = null");
    }

    public String b(String str) {
        if (str == null) {
            str = "";
        }
        if (TextUtils.isEmpty(this.f30410d)) {
            this.f30410d = ImageManager.getCachePath(BaseApplication.getContext(), UppUploadTask.sfUppAppId);
        }
        return this.f30410d + str.hashCode();
    }

    /* compiled from: P */
    /* renamed from: c7.a$a, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    class C0173a implements Downloader.DownloadListener {
        C0173a() {
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadFailed(String str, DownloadResult downloadResult) {
            if (QZLog.isColorLevel()) {
                QZLog.i("QzoneDIYPreloadService", 2, "diy data download fail url = " + str);
            }
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadSucceed(String str, DownloadResult downloadResult) {
            if (QZLog.isColorLevel()) {
                QZLog.i("QzoneDIYPreloadService", 2, "diy data download success url = " + str);
            }
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadCanceled(String str) {
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadProgress(String str, long j3, float f16) {
        }
    }
}
