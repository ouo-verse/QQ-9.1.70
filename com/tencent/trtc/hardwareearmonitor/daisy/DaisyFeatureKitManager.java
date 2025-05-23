package com.tencent.trtc.hardwareearmonitor.daisy;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;

/* compiled from: P */
/* loaded from: classes27.dex */
public class DaisyFeatureKitManager {
    private static final String ENGINE_PACKAGE_NAME = "com.huawei.multimedia.audioengine";
    private static final int PACKAGE_INFO_FLAG = 0;
    private static final String TAG = "DaisyAudioKit.DaisyFeatureKitManager";
    private static DaisyFeatureKitManager sInstance;
    private IDaisyAudioKitCallback mCallBack = null;
    private static final Object SET_CALL_BACK_LOCK = new Object();
    private static final Object NEW_FEATUREMANAGER_LOCK = new Object();
    private static final Object BIND_SERVICE_LOCK = new Object();
    private static final Object UNBIND_SERVICE_LOCK = new Object();

    /* JADX INFO: Access modifiers changed from: protected */
    public static DaisyFeatureKitManager getInstance() {
        DaisyFeatureKitManager daisyFeatureKitManager;
        synchronized (NEW_FEATUREMANAGER_LOCK) {
            if (sInstance == null) {
                sInstance = new DaisyFeatureKitManager();
            }
            daisyFeatureKitManager = sInstance;
        }
        return daisyFeatureKitManager;
    }

    public static boolean isAudioKitSupport(Context context) {
        if (context == null) {
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            try {
                if (InstalledAppListMonitor.getPackageInfo(packageManager, ENGINE_PACKAGE_NAME, 0) == null) {
                    return false;
                }
                return true;
            } catch (PackageManager.NameNotFoundException unused) {
                LiteavLog.e(TAG, "isAudioKitSupport ,NameNotFoundException");
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bindService(Context context, ServiceConnection serviceConnection, String str) {
        synchronized (BIND_SERVICE_LOCK) {
            if (context == null) {
                return;
            }
            Intent intent = new Intent();
            intent.setClassName(ENGINE_PACKAGE_NAME, str);
            try {
                context.bindService(intent, serviceConnection, 1);
            } catch (SecurityException e16) {
                LiteavLog.e(TAG, "bindService, SecurityException, %s", e16.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <T extends DaisyAudioFeaturesKit> T createFeatureKit(int i3, Context context) {
        if (context == null || i3 != 1) {
            return null;
        }
        DaisyAudioKaraokeFeatureKit daisyAudioKaraokeFeatureKit = new DaisyAudioKaraokeFeatureKit(context);
        daisyAudioKaraokeFeatureKit.initialize(context);
        return daisyAudioKaraokeFeatureKit;
    }

    protected IDaisyAudioKitCallback getCallBack() {
        return this.mCallBack;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onCallBack(int i3) {
        synchronized (SET_CALL_BACK_LOCK) {
            if (getCallBack() != null) {
                getCallBack().onResult(i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setCallBack(IDaisyAudioKitCallback iDaisyAudioKitCallback) {
        this.mCallBack = iDaisyAudioKitCallback;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void unbindService(Context context, ServiceConnection serviceConnection) {
        synchronized (UNBIND_SERVICE_LOCK) {
            if (context != null) {
                context.unbindService(serviceConnection);
            }
        }
    }
}
