package com.tencent.trtc.hardwareearmonitor.honor;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;

/* compiled from: P */
/* loaded from: classes27.dex */
public class HonorFeatureKitManager {
    private static final String ENGINE_PACKAGE_NAME = "com.hihonor.android.magicx.media.audioengine";
    private static final int PACKAGE_INFO_FLAG = 0;
    private static final int SUB_VERSION_MASK = 1000;
    private static final String TAG = "HnAudioEngine.FeatureKitManager";
    public static long mMinVersion;
    private static HonorFeatureKitManager sInstance;
    private IHonorAudioServiceCallback mCallBack = null;
    private static final Object SET_CALL_BACK_LOCK = new Object();
    private static final Object NEW_FEATUREMANAGER_LOCK = new Object();
    private static final Object BIND_SERVICE_LOCK = new Object();
    private static final Object UNBIND_SERVICE_LOCK = new Object();

    HonorFeatureKitManager() {
    }

    public static HonorFeatureKitManager getInstance() {
        HonorFeatureKitManager honorFeatureKitManager;
        synchronized (NEW_FEATUREMANAGER_LOCK) {
            if (sInstance == null) {
                sInstance = new HonorFeatureKitManager();
            }
            honorFeatureKitManager = sInstance;
        }
        return honorFeatureKitManager;
    }

    public static boolean isAudioKitSupport(Context context) {
        if (context == null) {
            HonorLogUtils.error(TAG, "context is null");
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            if (packageManager != null) {
                int i3 = InstalledAppListMonitor.getPackageInfo(packageManager, ENGINE_PACKAGE_NAME, 0).versionCode / 1000;
                long j3 = i3;
                if (j3 > 1000001) {
                    j3 = 1000001;
                }
                mMinVersion = j3;
                HonorLogUtils.info(TAG, " isDeviceSupport is true, enginVersionCode=" + i3 + " audioKitVersionCode=1000001");
                return true;
            }
            HonorLogUtils.error(TAG, "packageManager is null");
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            HonorLogUtils.error(TAG, "isAudioKitSupport ,NameNotFoundException");
            return false;
        }
    }

    public void bindService(Context context, ServiceConnection serviceConnection, String str) {
        synchronized (BIND_SERVICE_LOCK) {
            if (context == null) {
                return;
            }
            Intent intent = new Intent();
            intent.setClassName(ENGINE_PACKAGE_NAME, str);
            try {
                HonorLogUtils.info(TAG, "bindService");
                context.bindService(intent, serviceConnection, 1);
            } catch (SecurityException e16) {
                HonorLogUtils.error(TAG, "bindService, SecurityException, " + e16.getMessage());
            }
        }
    }

    public <T extends HonorAudioFeaturesKit> T createFeatureKit(int i3, Context context) {
        HonorLogUtils.info(TAG, "createFeatureKit, type =".concat(String.valueOf(i3)));
        if (context == null) {
            return null;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        HonorLogUtils.info(TAG, "createFeatureKit, type error");
                        return null;
                    }
                } else {
                    HonorAudioPlayClient honorAudioPlayClient = new HonorAudioPlayClient(context);
                    honorAudioPlayClient.initialize(context);
                    return honorAudioPlayClient;
                }
            }
            HonorAdvancedRecordClient honorAdvancedRecordClient = new HonorAdvancedRecordClient(context);
            honorAdvancedRecordClient.initialize(context);
            return honorAdvancedRecordClient;
        }
        HonorEarReturnClient honorEarReturnClient = new HonorEarReturnClient(context);
        honorEarReturnClient.initialize(context);
        return honorEarReturnClient;
    }

    protected IHonorAudioServiceCallback getCallBack() {
        return this.mCallBack;
    }

    public void onCallBack(int i3) {
        HonorLogUtils.info(TAG, "onCallBack, result =".concat(String.valueOf(i3)));
        synchronized (SET_CALL_BACK_LOCK) {
            if (getCallBack() != null) {
                getCallBack().onResult(i3);
            }
        }
    }

    public void setCallBack(IHonorAudioServiceCallback iHonorAudioServiceCallback) {
        this.mCallBack = iHonorAudioServiceCallback;
    }

    public void unbindService(Context context, ServiceConnection serviceConnection) {
        HonorLogUtils.info(TAG, "unbindService");
        synchronized (UNBIND_SERVICE_LOCK) {
            if (context != null) {
                context.unbindService(serviceConnection);
            }
        }
    }
}
