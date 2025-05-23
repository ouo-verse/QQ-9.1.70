package com.tencent.ad.tangram.downloader;

import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.downloader.AdDownloaderV2;
import java.lang.ref.WeakReference;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public interface AdDownloaderAdapterV2 {
    void cancelDownload(String str, Ad ad5, int i3);

    void installDownload(String str, Ad ad5, int i3);

    void pauseDownload(String str, Ad ad5, int i3);

    void queryDownload(String str, Ad ad5, int i3, WeakReference<AdDownloaderV2.OnQueryListener> weakReference);

    void registerListener(WeakReference<AdDownloaderV2.OnStatusChangedListener> weakReference);

    void startDownload(String str, Ad ad5, int i3);

    void unregisterListener(WeakReference<AdDownloaderV2.OnStatusChangedListener> weakReference);
}
