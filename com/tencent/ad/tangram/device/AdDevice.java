package com.tencent.ad.tangram.device;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import com.tencent.ad.tangram.annotation.AdKeep;
import java.lang.ref.WeakReference;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdDevice {
    private static final String TAG = "AdDevice";
    private static volatile AdDevice sInstance;
    private WeakReference<AdDeviceAdapter> mAdapter;
    private String mManufacturerOSVersion;

    AdDevice() {
    }

    private AdDeviceAdapter getAdapter() {
        WeakReference<AdDeviceAdapter> weakReference = this.mAdapter;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public static AdDevice getInstance() {
        if (sInstance == null) {
            synchronized (AdDevice.class) {
                if (sInstance == null) {
                    sInstance = new AdDevice();
                }
            }
        }
        return sInstance;
    }

    public int getDeviceType(Context context) {
        AdDeviceAdapter adapter = getAdapter();
        if (adapter != null) {
            return adapter.getDeviceType(context);
        }
        return 0;
    }

    public String getManufacturerOSVersion() {
        return this.mManufacturerOSVersion;
    }

    public boolean isInMultiWindowMode(Activity activity) {
        boolean isInMultiWindowMode;
        if (activity != null && Build.VERSION.SDK_INT >= 24) {
            isInMultiWindowMode = activity.isInMultiWindowMode();
            if (isInMultiWindowMode) {
                return true;
            }
        }
        return false;
    }

    public void setAdapter(WeakReference<AdDeviceAdapter> weakReference) {
        this.mAdapter = weakReference;
    }

    public void setManufacturerOSVersion(String str) {
        this.mManufacturerOSVersion = str;
    }
}
