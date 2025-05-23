package com.tencent.ad.tangram.views.floatwindow;

import android.app.Activity;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.log.AdLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdFloatWindow {
    private static final String TAG = "AdFloatWindow";
    private static volatile AdFloatWindow sInstance;
    private WeakReference<AdFloatWindowAdapter> mAdapter;

    AdFloatWindow() {
    }

    private AdFloatWindowAdapter getAdapter() {
        WeakReference<AdFloatWindowAdapter> weakReference = this.mAdapter;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public static AdFloatWindow getInstance() {
        if (sInstance == null) {
            synchronized (AdFloatWindow.class) {
                if (sInstance == null) {
                    sInstance = new AdFloatWindow();
                }
            }
        }
        return sInstance;
    }

    public void close(WeakReference<Activity> weakReference) {
        AdFloatWindowAdapter adapter = getAdapter();
        if (adapter == null) {
            AdLog.e(TAG, "[close] error, adapter is null");
        } else {
            adapter.close(weakReference);
        }
    }

    public void setAdapter(WeakReference<AdFloatWindowAdapter> weakReference) {
        this.mAdapter = weakReference;
    }
}
