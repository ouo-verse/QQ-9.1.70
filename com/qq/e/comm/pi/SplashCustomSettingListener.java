package com.qq.e.comm.pi;

import com.qq.e.tg.splash.SplashDownloadRes;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface SplashCustomSettingListener {

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface DownloadCallback {
        void onCanceled();

        void onComplete();

        void onFailed(SplashDownloadRes splashDownloadRes);

        void onPaused();

        void onProgress(long j3, long j16, int i3);

        void onStarted();
    }

    boolean setCustomDownloaderListener(List<SplashDownloadRes> list);
}
