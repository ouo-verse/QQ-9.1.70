package com.tencent.ad.tangram.downloader;

import android.support.annotation.Nullable;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class AdDownloadTask {
    private static volatile AdDownloadTask sInstance;
    private WeakReference<AdDownloadTaskAdapter> adapter;

    AdDownloadTask() {
    }

    @Nullable
    private AdDownloadTaskAdapter getAdapter() {
        WeakReference<AdDownloadTaskAdapter> weakReference = this.adapter;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public static AdDownloadTask getInstance() {
        if (sInstance == null) {
            synchronized (AdDownloadTask.class) {
                if (sInstance == null) {
                    sInstance = new AdDownloadTask();
                }
            }
        }
        return sInstance;
    }

    @Nullable
    public Object getDownloadTask() {
        AdDownloadTaskAdapter adapter = getAdapter();
        if (adapter != null) {
            return adapter.getDownloadTask();
        }
        return null;
    }

    public void setAdapter(WeakReference<AdDownloadTaskAdapter> weakReference) {
        this.adapter = weakReference;
    }

    public void setDownloadTask(Object obj) {
        AdDownloadTaskAdapter adapter = getAdapter();
        if (adapter != null) {
            adapter.setDownloadTask(obj);
        }
    }

    public void setDownloadUrl(String str) {
        AdDownloadTaskAdapter adapter = getAdapter();
        if (adapter != null) {
            adapter.setDownloadUrl(str);
        }
    }
}
