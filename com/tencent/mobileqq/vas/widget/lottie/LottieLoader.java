package com.tencent.mobileqq.vas.widget.lottie;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.airbnb.lottie.ImageAssetDelegate;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.OnCompositionLoadedListener;
import com.tencent.ams.dsdk.utils.DBHelper;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.onlinestatus.utils.LottieHelper;
import com.tencent.mobileqq.qroute.annotation.PluginInterface;
import com.tencent.mobileqq.vas.VasConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;

/* compiled from: P */
@PluginInterface
@Deprecated
/* loaded from: classes20.dex */
public class LottieLoader implements Handler.Callback {
    public static final String FILE_DATA_JSON = "data.json";
    public static final String FILE_IMAGES = "images/";
    public static final String FILE_IMAGE_CACHE_PREFIX = "apollo://lottie_";
    private static final int MSG_CODE_PLAY_ANIMATION = 1;
    public static final int STATE_FAILED = 2;
    public static final int STATE_INIT = 0;
    public static final int STATE_LOADING = 1;
    public static final int STATE_RES_DONE = 3;
    public static final String TAG = "LottieLoader";
    private boolean mAutoPlay;
    private WeakReference<Context> mContextRef;
    private Downloader mDownloader;
    private String mLocalZipPath;
    private WeakReference<LottieAnimationView> mLottieAnimView;
    private WeakReferenceHandler mMainHandler;
    private String mZipUrl;
    private boolean mIsLottieJsonLoaded = false;
    private boolean mIsDestroy = false;
    protected int mState = 0;
    private DecoderRunnable mDecoderRunnable = new DecoderRunnable();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class DecoderRunnable implements Runnable {
        private boolean mAutoPlay;
        private String mLocalFilePath;
        private WeakReference<LottieLoader> mLottieAnimRef;
        private String mZipUrl;

        DecoderRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            WeakReference<LottieLoader> weakReference = this.mLottieAnimRef;
            if (weakReference != null && weakReference.get() != null) {
                this.mLottieAnimRef.get().setZipData(this.mZipUrl, this.mLocalFilePath, this.mAutoPlay);
            }
        }

        public void setZipData(LottieLoader lottieLoader, String str, String str2, boolean z16) {
            this.mZipUrl = str;
            this.mLocalFilePath = str2;
            this.mAutoPlay = z16;
            this.mLottieAnimRef = new WeakReference<>(lottieLoader);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements OnCompositionLoadedListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LottieAnimationView f311423a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f311424b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f311425c;

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.vas.widget.lottie.LottieLoader$a$a, reason: collision with other inner class name */
        /* loaded from: classes20.dex */
        class C8931a implements ImageAssetDelegate {
            C8931a() {
            }

            @Override // com.airbnb.lottie.ImageAssetDelegate
            @Nullable
            public Bitmap fetchBitmap(LottieImageAsset lottieImageAsset) {
                String str = a.this.f311424b + "/images/" + lottieImageAsset.getFileName();
                if (!new File(str).exists()) {
                    if (QLog.isDevelopLevel()) {
                        QLog.w(LottieLoader.TAG, 1, "fetchBitmap  bitmapPath is not exists: " + str);
                        return null;
                    }
                    return null;
                }
                return LottieHelper.a(str);
            }
        }

        a(LottieAnimationView lottieAnimationView, String str, boolean z16) {
            this.f311423a = lottieAnimationView;
            this.f311424b = str;
            this.f311425c = z16;
        }

        @Override // com.airbnb.lottie.OnCompositionLoadedListener
        public void onCompositionLoaded(LottieComposition lottieComposition) {
            if (lottieComposition == null) {
                if (QLog.isColorLevel()) {
                    QLog.d(LottieLoader.TAG, 2, "composition is null ,return");
                }
            } else if (LottieLoader.this.mIsDestroy) {
                if (QLog.isColorLevel()) {
                    QLog.d(LottieLoader.TAG, 2, "anim is destroy ,return");
                }
            } else {
                this.f311423a.setImageAssetDelegate(new C8931a());
                this.f311423a.setComposition(lottieComposition);
                if (this.f311425c) {
                    this.f311423a.setVisibility(0);
                    this.f311423a.playAnimation();
                }
                LottieLoader.this.mIsLottieJsonLoaded = true;
            }
        }
    }

    public LottieLoader(Context context) {
        this.mMainHandler = new WeakReferenceHandler(context.getMainLooper(), this);
        this.mContextRef = new WeakReference<>(context);
        this.mDownloader = DownloaderFactory.getInstance(context).getCommonDownloader();
    }

    private void init(boolean z16, File file, String str) {
        if (z16) {
            try {
                unZipFile(file, str);
            } catch (Exception e16) {
                QLog.e(TAG, 2, e16.getMessage());
                this.mState = 2;
                return;
            }
        }
        if (!isLottieAnimJsonDone(str)) {
            QLog.e(TAG, 1, "Lottie Anim data.json not exit");
            return;
        }
        this.mState = 3;
        stop();
        sendPlayAnimMsg(str);
    }

    public static String makeApolloZipPath(String str) {
        String Crc64String = Utils.Crc64String(str);
        return VasConstant.FILE_PATH_LOTTIE_DOWNLOAD + Crc64String + ".zip";
    }

    private void sendPlayAnimMsg(String str) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        Bundle bundle = new Bundle();
        bundle.putString(DBHelper.COL_FOLDER, str);
        obtain.setData(bundle);
        this.mMainHandler.sendMessage(obtain);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setZipData(String str, String str2, boolean z16) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.mAutoPlay = z16;
        if (!str2.equals(this.mLocalZipPath)) {
            this.mLocalZipPath = str2;
            this.mState = 0;
        }
        String zipPath2UnzipDir = zipPath2UnzipDir(this.mLocalZipPath);
        new File(zipPath2UnzipDir).mkdirs();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "setZipData mState:", Integer.valueOf(this.mState), ",zipUrl:", str, ",localZipPath:", this.mLocalZipPath);
        }
        boolean isLottieAnimJsonDone = isLottieAnimJsonDone(zipPath2UnzipDir);
        if (!isLottieAnimJsonDone) {
            QLog.w(TAG, 1, "setZipData Lottie Anim data.json not exit");
            this.mState = 0;
        }
        int i3 = this.mState;
        if (i3 != 2 && i3 != 0) {
            if (i3 == 3) {
                init(false, null, zipPath2UnzipDir);
                return;
            }
            return;
        }
        this.mIsLottieJsonLoaded = false;
        File file = new File(this.mLocalZipPath);
        if (isLottieAnimJsonDone) {
            init(false, file, zipPath2UnzipDir);
        } else if (file.exists()) {
            init(true, file, zipPath2UnzipDir);
        } else {
            download(str, this.mLocalZipPath, zipPath2UnzipDir);
        }
    }

    private void unZipFile(File file, String str) throws IOException {
        if (file.exists() && !TextUtils.isEmpty(str) && ZipUtils.getUncompressedFileSize(file.getAbsolutePath()) < 838860800) {
            ZipUtils.unZipFile(file, str);
        }
    }

    private String zipPath2UnzipDir(String str) {
        if (!TextUtils.isEmpty(str)) {
            int lastIndexOf = str.lastIndexOf(".zip");
            if (lastIndexOf > 0) {
                str = str.substring(0, lastIndexOf);
            }
            return str + File.separator;
        }
        return "";
    }

    public void destroy() {
        stop();
        this.mIsLottieJsonLoaded = false;
        this.mIsDestroy = true;
    }

    protected void download(String str, String str2, String str3) {
        this.mState = 1;
        this.mDownloader.download(str, str2, false, (Downloader.DownloadListener) new b(str2, str3));
    }

    public void fromFileWithCacheBitmap(Context context, @NonNull LottieAnimationView lottieAnimationView, String str, boolean z16) {
        try {
            if (this.mLottieAnimView == null) {
                this.mLottieAnimView = new WeakReference<>(lottieAnimationView);
            }
            fromInputStreamWithCacheBitmap(context, lottieAnimationView, str, new FileInputStream(str + FILE_DATA_JSON), z16);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "fromFileWithCacheBitmap:" + e16);
        }
    }

    public void fromInputStreamWithCacheBitmap(Context context, @NonNull LottieAnimationView lottieAnimationView, String str, InputStream inputStream, boolean z16) {
        if (context != null && !TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "fromFileWithCacheBitmap animPathFolder:", str);
            }
            if (lottieAnimationView.isAnimating()) {
                return;
            }
            if (this.mIsLottieJsonLoaded && z16) {
                lottieAnimationView.playAnimation();
                return;
            }
            try {
                LottieComposition.Factory.fromInputStream(inputStream, new a(lottieAnimationView, str, z16));
            } catch (Exception e16) {
                QLog.e(TAG, 1, "playApolloGameBoxLottieAnim:" + e16);
            } catch (OutOfMemoryError e17) {
                QLog.e(TAG, 1, "playApolloGameBoxLottieAnim: out of memory" + e17);
            }
        }
    }

    public void fromNetworkWithCacheBitmap(@NonNull LottieAnimationView lottieAnimationView, String str) {
        fromNetworkWithCacheBitmap(lottieAnimationView, str, makeApolloZipPath(str), true);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        WeakReference<Context> weakReference;
        WeakReference<LottieAnimationView> weakReference2;
        if (message.what == 1 && (weakReference = this.mContextRef) != null && weakReference.get() != null && (weakReference2 = this.mLottieAnimView) != null && weakReference2.get() != null) {
            fromFileWithCacheBitmap(this.mContextRef.get(), this.mLottieAnimView.get(), message.getData().getString(DBHelper.COL_FOLDER), this.mAutoPlay);
            return false;
        }
        return false;
    }

    public boolean isLottieAnimJsonDone(String str) {
        return new File(str + FILE_DATA_JSON).exists();
    }

    protected void onDownloadFinish(boolean z16, String str, String str2, String str3) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onDownloadFinish\uff0cresult:" + z16 + " url:" + str + " zipFile:" + str2 + " folder:" + str3);
        }
        String str4 = this.mLocalZipPath;
        if (str4 != null && !str4.equals(str2)) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "onDownloadFinish\uff0czipFile unEqual mLocalZipPath:" + this.mLocalZipPath);
                return;
            }
            return;
        }
        if (z16) {
            File file = new File(str2);
            if (file.exists()) {
                init(true, file, str3);
                return;
            } else {
                this.mState = 2;
                return;
            }
        }
        this.mState = 2;
    }

    public void stop() {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.vas.widget.lottie.LottieLoader.3
            @Override // java.lang.Runnable
            public void run() {
                if (LottieLoader.this.mLottieAnimView != null && LottieLoader.this.mLottieAnimView.get() != null) {
                    ((LottieAnimationView) LottieLoader.this.mLottieAnimView.get()).cancelAnimation();
                }
            }
        });
        WeakReferenceHandler weakReferenceHandler = this.mMainHandler;
        if (weakReferenceHandler != null) {
            weakReferenceHandler.removeCallbacksAndMessages(null);
        }
    }

    public void fromNetworkWithCacheBitmap(@NonNull LottieAnimationView lottieAnimationView, String str, String str2, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mLottieAnimView = new WeakReference<>(lottieAnimationView);
        this.mZipUrl = str;
        this.mDecoderRunnable.setZipData(this, str, str2, z16);
        ThreadManagerV2.removeJobFromThreadPool(this.mDecoderRunnable, 16);
        ThreadManagerV2.excute(this.mDecoderRunnable, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b implements Downloader.DownloadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f311428a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f311429b;

        b(String str, String str2) {
            this.f311428a = str;
            this.f311429b = str2;
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadFailed(String str, DownloadResult downloadResult) {
            if (QLog.isColorLevel()) {
                QLog.i(LottieLoader.TAG, 2, "diy data download fail url = " + str);
            }
            LottieLoader lottieLoader = LottieLoader.this;
            lottieLoader.mState = 2;
            lottieLoader.onDownloadFinish(false, str, this.f311428a, this.f311429b);
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadSucceed(String str, DownloadResult downloadResult) {
            if (QLog.isColorLevel()) {
                QLog.i(LottieLoader.TAG, 2, "diy data download success url = " + str);
            }
            LottieLoader.this.onDownloadFinish(true, str, this.f311428a, this.f311429b);
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadCanceled(String str) {
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadProgress(String str, long j3, float f16) {
        }
    }
}
