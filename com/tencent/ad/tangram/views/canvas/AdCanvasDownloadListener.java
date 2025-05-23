package com.tencent.ad.tangram.views.canvas;

import android.support.annotation.Nullable;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.downloader.IAdDownloader;
import com.tencent.ad.tangram.views.canvas.components.appbutton.AdAppDownloadManager;
import java.lang.ref.WeakReference;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdCanvasDownloadListener {
    private static volatile AdCanvasDownloadListener sInstance;
    private WeakReference<AdCanvasDownloadListenerAdapter> adapter;

    AdCanvasDownloadListener() {
    }

    @Nullable
    private AdCanvasDownloadListenerAdapter getAdapter() {
        WeakReference<AdCanvasDownloadListenerAdapter> weakReference = this.adapter;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public static AdCanvasDownloadListener getInstance() {
        if (sInstance == null) {
            synchronized (AdCanvasDownloadListener.class) {
                if (sInstance == null) {
                    sInstance = new AdCanvasDownloadListener();
                }
            }
        }
        return sInstance;
    }

    @Nullable
    public IAdDownloader.Callback getDownloadListener(@Nullable AdAppDownloadManager adAppDownloadManager) {
        AdCanvasDownloadListenerAdapter adapter;
        if (adAppDownloadManager != null && (adapter = getAdapter()) != null) {
            return adapter.getDownloadListener(adAppDownloadManager);
        }
        return null;
    }

    public void removeDownloadListener(@Nullable AdAppDownloadManager adAppDownloadManager) {
        AdCanvasDownloadListenerAdapter adapter;
        if (adAppDownloadManager != null && (adapter = getAdapter()) != null) {
            adapter.removeDownloadListener(adAppDownloadManager);
        }
    }

    public void setAdapter(WeakReference<AdCanvasDownloadListenerAdapter> weakReference) {
        this.adapter = weakReference;
    }

    public void setDownloadListener(@Nullable AdAppDownloadManager adAppDownloadManager) {
        AdCanvasDownloadListenerAdapter adapter;
        if (adAppDownloadManager != null && (adapter = getAdapter()) != null) {
            adapter.setDownloadListener(adAppDownloadManager);
        }
    }
}
