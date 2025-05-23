package com.tencent.ad.tangram.views;

import android.support.annotation.Nullable;
import com.tencent.ad.tangram.annotation.AdKeep;
import java.lang.ref.WeakReference;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdUISettings {
    private static final String TAG = "AdUISettings";
    public static volatile AdUISettings sInstance;
    private WeakReference<AdUISettingsAdapter> adapter;

    AdUISettings() {
    }

    public static AdUISettings getInstance() {
        if (sInstance == null) {
            synchronized (AdUISettings.class) {
                if (sInstance == null) {
                    sInstance = new AdUISettings();
                }
            }
        }
        return sInstance;
    }

    @Nullable
    public AdUISettingsAdapter getAdapter() {
        WeakReference<AdUISettingsAdapter> weakReference = this.adapter;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public boolean isNightMode() {
        AdUISettingsAdapter adapter = getAdapter();
        if (adapter != null && adapter.isNightMode()) {
            return true;
        }
        return false;
    }

    public void setAdapter(WeakReference<AdUISettingsAdapter> weakReference) {
        this.adapter = weakReference;
    }
}
