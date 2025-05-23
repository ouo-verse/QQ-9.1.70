package com.huawei.multimedia.audiokit.interfaces;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import com.huawei.multimedia.audiokit.utils.LogUtils;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;

/* compiled from: P */
/* loaded from: classes2.dex */
public class FeatureKitManager {
    private static final String ENGINE_PACKAGE_NAME = "com.huawei.multimedia.audioengine";
    private static final int PACKAGE_INFO_FLAG = 0;
    private static final String TAG = "HwAudioKit.FeatureKitManager";
    private static FeatureKitManager sInstance;
    private IAudioKitCallback mCallBack = null;
    private static final Object SET_CALL_BACK_LOCK = new Object();
    private static final Object NEW_FEATUREMANAGER_LOCK = new Object();
    private static final Object BIND_SERVICE_LOCK = new Object();
    private static final Object UNBIND_SERVICE_LOCK = new Object();

    FeatureKitManager() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static FeatureKitManager getInstance() {
        FeatureKitManager featureKitManager;
        synchronized (NEW_FEATUREMANAGER_LOCK) {
            if (sInstance == null) {
                sInstance = new FeatureKitManager();
            }
            featureKitManager = sInstance;
        }
        return featureKitManager;
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
                LogUtils.info(TAG, "bindService");
                context.bindService(intent, serviceConnection, 1);
            } catch (SecurityException e16) {
                LogUtils.error(TAG, "bindService, SecurityException, " + e16.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <T extends AudioFeaturesKit> T createFeatureKit(int i3, Context context) {
        LogUtils.info(TAG, "createFeatureKit, type =" + i3);
        if (context == null) {
            return null;
        }
        if (i3 != 1) {
            LogUtils.info(TAG, "createFeatureKit, type error");
            return null;
        }
        HwAudioKaraokeFeatureKit hwAudioKaraokeFeatureKit = new HwAudioKaraokeFeatureKit(context);
        hwAudioKaraokeFeatureKit.initialize(context);
        return hwAudioKaraokeFeatureKit;
    }

    protected IAudioKitCallback getCallBack() {
        return this.mCallBack;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isAudioKitSupport(Context context) {
        if (context == null) {
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            try {
                if (InstalledAppListMonitor.getPackageInfo(packageManager, ENGINE_PACKAGE_NAME, 0) == null) {
                    LogUtils.info(TAG, "packageInfo is null");
                    return false;
                }
                return true;
            } catch (PackageManager.NameNotFoundException unused) {
                LogUtils.error(TAG, "isAudioKitSupport ,NameNotFoundException");
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onCallBack(int i3) {
        LogUtils.info(TAG, "onCallBack, result =" + i3);
        synchronized (SET_CALL_BACK_LOCK) {
            if (getCallBack() != null) {
                getCallBack().onResult(i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setCallBack(IAudioKitCallback iAudioKitCallback) {
        this.mCallBack = iAudioKitCallback;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void unbindService(Context context, ServiceConnection serviceConnection) {
        LogUtils.info(TAG, "unbindService");
        synchronized (UNBIND_SERVICE_LOCK) {
            if (context != null) {
                context.unbindService(serviceConnection);
            }
        }
    }
}
