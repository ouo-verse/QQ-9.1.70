package com.huawei.multimedia.audiokit.interfaces;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.huawei.multimedia.audioengine.IHwAudioKaraokeFeature;
import com.huawei.multimedia.audiokit.utils.LogUtils;

/* compiled from: P */
/* loaded from: classes2.dex */
public class HwAudioKaraokeFeatureKit extends AudioFeaturesKit {
    private static final String ENGINE_CLASS_NAME = "com.huawei.multimedia.audioengine.HwAudioKaraokeFeatureService";
    private static final String TAG = "HwAudioKit.HwAudioKaraokeFeatureKit";
    private Context mContext;
    private FeatureKitManager mFeatureKitManager;
    private IHwAudioKaraokeFeature mIHwAudioKaraokeFeatureAidl;
    private boolean mIsServiceConnected = false;
    private IBinder mService = null;
    private ServiceConnection mConnection = new ServiceConnection() { // from class: com.huawei.multimedia.audiokit.interfaces.HwAudioKaraokeFeatureKit.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            LogUtils.info(HwAudioKaraokeFeatureKit.TAG, "onServiceConnected");
            HwAudioKaraokeFeatureKit.this.mIHwAudioKaraokeFeatureAidl = IHwAudioKaraokeFeature.Stub.asInterface(iBinder);
            if (HwAudioKaraokeFeatureKit.this.mIHwAudioKaraokeFeatureAidl != null) {
                HwAudioKaraokeFeatureKit.this.mIsServiceConnected = true;
                HwAudioKaraokeFeatureKit.this.mFeatureKitManager.onCallBack(1000);
                HwAudioKaraokeFeatureKit hwAudioKaraokeFeatureKit = HwAudioKaraokeFeatureKit.this;
                hwAudioKaraokeFeatureKit.serviceInit(hwAudioKaraokeFeatureKit.mContext.getPackageName());
                HwAudioKaraokeFeatureKit.this.serviceLinkToDeath(iBinder);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            LogUtils.info(HwAudioKaraokeFeatureKit.TAG, "onServiceDisconnected");
            HwAudioKaraokeFeatureKit.this.mIsServiceConnected = false;
            if (HwAudioKaraokeFeatureKit.this.mFeatureKitManager != null) {
                HwAudioKaraokeFeatureKit.this.mFeatureKitManager.onCallBack(1001);
            }
        }
    };
    private IBinder.DeathRecipient mDeathRecipient = new IBinder.DeathRecipient() { // from class: com.huawei.multimedia.audiokit.interfaces.HwAudioKaraokeFeatureKit.2
        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            LogUtils.error(HwAudioKaraokeFeatureKit.TAG, "binderDied");
            HwAudioKaraokeFeatureKit.this.mService.unlinkToDeath(HwAudioKaraokeFeatureKit.this.mDeathRecipient, 0);
            HwAudioKaraokeFeatureKit.this.mFeatureKitManager.onCallBack(1003);
            HwAudioKaraokeFeatureKit.this.mService = null;
        }
    };

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum ParameName {
        CMD_SET_AUDIO_EFFECT_MODE_BASE("Karaoke_reverb_mode="),
        CMD_SET_VOCAL_VOLUME_BASE("Karaoke_volume="),
        CMD_SET_VOCAL_EQUALIZER_MODE("Karaoke_eq_mode=");

        private String mParameName;

        ParameName(String str) {
            this.mParameName = str;
        }

        public String getParameName() {
            return this.mParameName;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public HwAudioKaraokeFeatureKit(Context context) {
        this.mFeatureKitManager = null;
        this.mFeatureKitManager = FeatureKitManager.getInstance();
        this.mContext = context;
    }

    private void bindService(Context context) {
        LogUtils.info(TAG, "bindService");
        FeatureKitManager featureKitManager = this.mFeatureKitManager;
        if (featureKitManager != null && !this.mIsServiceConnected) {
            featureKitManager.bindService(context, this.mConnection, ENGINE_CLASS_NAME);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void serviceInit(String str) {
        try {
            IHwAudioKaraokeFeature iHwAudioKaraokeFeature = this.mIHwAudioKaraokeFeatureAidl;
            if (iHwAudioKaraokeFeature != null && this.mIsServiceConnected) {
                iHwAudioKaraokeFeature.init(str);
            }
        } catch (RemoteException e16) {
            LogUtils.error(TAG, "isFeatureSupported,RemoteException ex :" + e16.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void serviceLinkToDeath(IBinder iBinder) {
        this.mService = iBinder;
        if (iBinder != null) {
            try {
                iBinder.linkToDeath(this.mDeathRecipient, 0);
            } catch (RemoteException unused) {
                this.mFeatureKitManager.onCallBack(1002);
                LogUtils.error(TAG, "serviceLinkToDeath, RemoteException");
            }
        }
    }

    public void destroy() {
        LogUtils.info(TAG, "destroy, mIsServiceConnected = " + this.mIsServiceConnected);
        if (this.mIsServiceConnected) {
            this.mIsServiceConnected = false;
            this.mFeatureKitManager.unbindService(this.mContext, this.mConnection);
        }
    }

    public int enableKaraokeFeature(boolean z16) {
        LogUtils.info(TAG, "enableKaraokeFeature, enable = " + z16);
        try {
            IHwAudioKaraokeFeature iHwAudioKaraokeFeature = this.mIHwAudioKaraokeFeatureAidl;
            if (iHwAudioKaraokeFeature != null && this.mIsServiceConnected) {
                return iHwAudioKaraokeFeature.enableKaraokeFeature(z16);
            }
            return -2;
        } catch (RemoteException e16) {
            LogUtils.error(TAG, "enableKaraokeFeature,RemoteException ex : " + e16.getMessage());
            return -2;
        }
    }

    public int getKaraokeLatency() {
        LogUtils.info(TAG, "getKaraokeLatency");
        try {
            IHwAudioKaraokeFeature iHwAudioKaraokeFeature = this.mIHwAudioKaraokeFeatureAidl;
            if (iHwAudioKaraokeFeature != null && this.mIsServiceConnected) {
                return iHwAudioKaraokeFeature.getKaraokeLatency();
            }
            return -1;
        } catch (RemoteException e16) {
            LogUtils.error(TAG, "getKaraokeLatency,RemoteException ex : " + e16.getMessage());
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initialize(Context context) {
        LogUtils.info(TAG, "initialize");
        if (context == null) {
            LogUtils.info(TAG, "initialize, context is null");
        } else if (!this.mFeatureKitManager.isAudioKitSupport(context)) {
            this.mFeatureKitManager.onCallBack(2);
            LogUtils.info(TAG, "initialize, not install AudioEngine");
        } else {
            bindService(context);
        }
    }

    public boolean isKaraokeFeatureSupport() {
        LogUtils.info(TAG, "isKaraokeFeatureSupport");
        try {
            IHwAudioKaraokeFeature iHwAudioKaraokeFeature = this.mIHwAudioKaraokeFeatureAidl;
            if (iHwAudioKaraokeFeature != null && this.mIsServiceConnected) {
                return iHwAudioKaraokeFeature.isKaraokeFeatureSupport();
            }
            return false;
        } catch (RemoteException e16) {
            LogUtils.error(TAG, "isFeatureSupported,RemoteException ex :" + e16.getMessage());
            return false;
        }
    }

    public int setParameter(ParameName parameName, int i3) {
        if (parameName == null) {
            return 1807;
        }
        try {
            LogUtils.info(TAG, "parameValue =" + i3 + ", parame.getParameName() =" + parameName.getParameName());
            IHwAudioKaraokeFeature iHwAudioKaraokeFeature = this.mIHwAudioKaraokeFeatureAidl;
            if (iHwAudioKaraokeFeature != null && this.mIsServiceConnected) {
                return iHwAudioKaraokeFeature.setParameter(parameName.getParameName(), i3);
            }
            return -2;
        } catch (RemoteException e16) {
            LogUtils.error(TAG, "setParameter,RemoteException ex : " + e16.getMessage());
            return -2;
        }
    }
}
