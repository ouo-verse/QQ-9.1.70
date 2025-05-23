package com.tencent.ad.tangram.downloader;

import android.support.annotation.Nullable;
import android.util.Pair;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class AdDownloader {
    private static volatile AdDownloader sInstance;
    private WeakReference<AdDownloaderAdapter> adapter;

    AdDownloader() {
    }

    @Nullable
    private AdDownloaderAdapter getAdapter() {
        WeakReference<AdDownloaderAdapter> weakReference = this.adapter;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public static AdDownloader getInstance() {
        if (sInstance == null) {
            synchronized (AdDownloader.class) {
                if (sInstance == null) {
                    sInstance = new AdDownloader();
                }
            }
        }
        return sInstance;
    }

    @Nullable
    public IAdDownloader getDownloader() {
        AdDownloaderAdapter adapter = getAdapter();
        if (adapter != null) {
            return adapter.getDownloader();
        }
        return null;
    }

    public int getProgress(Object obj) {
        AdDownloaderAdapter adapter = getAdapter();
        if (adapter != null) {
            return adapter.getProgress(obj);
        }
        return 0;
    }

    public boolean isCurrentPkgTask(Pair<String, String> pair, Object obj) {
        AdDownloaderAdapter adapter = getAdapter();
        if (adapter != null) {
            return adapter.isCurrentPkgTask(pair, obj);
        }
        return false;
    }

    public void setAdapter(WeakReference<AdDownloaderAdapter> weakReference) {
        this.adapter = weakReference;
    }
}
