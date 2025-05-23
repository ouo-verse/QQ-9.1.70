package com.tencent.ad.tangram.version;

import android.support.annotation.Nullable;
import com.tencent.ad.tangram.annotation.AdKeep;
import java.lang.ref.WeakReference;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdVersion {
    private static final String TAG = "AdAnalysis";
    private static volatile AdVersion sInstance;
    private WeakReference<AdVersionAdapter> adapter;

    AdVersion() {
    }

    @Nullable
    private AdVersionAdapter getAdapter() {
        WeakReference<AdVersionAdapter> weakReference = this.adapter;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public static AdVersion getInstance() {
        if (sInstance == null) {
            synchronized (AdVersion.class) {
                if (sInstance == null) {
                    sInstance = new AdVersion();
                }
            }
        }
        return sInstance;
    }

    @Nullable
    public String getAppVersion() {
        AdVersionAdapter adapter = getAdapter();
        if (adapter != null) {
            return adapter.getAppVersion();
        }
        return null;
    }

    public void setAdapter(WeakReference<AdVersionAdapter> weakReference) {
        this.adapter = weakReference;
    }
}
