package com.tencent.ad.tangram.downloader;

import android.support.annotation.Nullable;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.annotation.AdKeep;
import java.lang.ref.WeakReference;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdDownloaderV2 {
    private static volatile AdDownloaderV2 sInstance;
    private WeakReference<AdDownloaderAdapterV2> adapter;

    /* compiled from: P */
    @AdKeep
    /* loaded from: classes3.dex */
    public interface OnQueryListener {
        void onQuery(String str, int i3);

        void onQuery(String str, int i3, int i16);
    }

    /* compiled from: P */
    @AdKeep
    /* loaded from: classes3.dex */
    public interface OnStatusChangedListener {
        void onStatusChanged(String str, int i3);

        void onStatusChanged(String str, int i3, int i16);
    }

    /* compiled from: P */
    @AdKeep
    /* loaded from: classes3.dex */
    public static final class Task {
        public int progress;
        public int status = Integer.MIN_VALUE;
        public String url;
    }

    AdDownloaderV2() {
    }

    @Nullable
    private AdDownloaderAdapterV2 getAdapter() {
        WeakReference<AdDownloaderAdapterV2> weakReference = this.adapter;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public static AdDownloaderV2 getInstance() {
        if (sInstance == null) {
            synchronized (AdDownloaderV2.class) {
                if (sInstance == null) {
                    sInstance = new AdDownloaderV2();
                }
            }
        }
        return sInstance;
    }

    public void cancelDownload(String str, Ad ad5, int i3) {
        AdDownloaderAdapterV2 adapter = getAdapter();
        if (adapter != null) {
            adapter.cancelDownload(str, ad5, i3);
        }
    }

    public void installDownload(String str, Ad ad5, int i3) {
        AdDownloaderAdapterV2 adapter = getAdapter();
        if (adapter != null) {
            adapter.installDownload(str, ad5, i3);
        }
    }

    public void pauseDownload(String str, Ad ad5, int i3) {
        AdDownloaderAdapterV2 adapter = getAdapter();
        if (adapter != null) {
            adapter.pauseDownload(str, ad5, i3);
        }
    }

    public void queryDownload(String str, Ad ad5, int i3, WeakReference<OnQueryListener> weakReference) {
        AdDownloaderAdapterV2 adapter = getAdapter();
        if (adapter != null) {
            adapter.queryDownload(str, ad5, i3, weakReference);
        }
    }

    public void registerListener(WeakReference<OnStatusChangedListener> weakReference) {
        AdDownloaderAdapterV2 adapter = getAdapter();
        if (adapter != null) {
            adapter.registerListener(weakReference);
        }
    }

    public void setAdapter(WeakReference<AdDownloaderAdapterV2> weakReference) {
        this.adapter = weakReference;
    }

    public void startDownload(String str, Ad ad5, int i3) {
        AdDownloaderAdapterV2 adapter = getAdapter();
        if (adapter != null) {
            adapter.startDownload(str, ad5, i3);
        }
    }

    public void unregisterListener(WeakReference<OnStatusChangedListener> weakReference) {
        AdDownloaderAdapterV2 adapter = getAdapter();
        if (adapter != null) {
            adapter.unregisterListener(weakReference);
        }
    }
}
