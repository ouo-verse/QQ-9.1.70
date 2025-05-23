package com.tencent.trtc.hardwareearmonitor.daisy;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.trtc.hardwareearmonitor.daisy.IDaisyAudioKaraokeFeature;

/* compiled from: P */
/* loaded from: classes27.dex */
public class DaisyAudioKaraokeFeatureKit extends DaisyAudioFeaturesKit {
    private static final String ENGINE_CLASS_NAME = "com.huawei.multimedia.audioengine.HwAudioKaraokeFeatureService";
    private static final String TAG = "DaisyAudioKit.DaisyAudioKaraokeFeatureKit";
    private Context mContext;
    private DaisyFeatureKitManager mFeatureKitManager;
    private IDaisyAudioKaraokeFeature mIHwAudioKaraokeFeatureAidl;
    private boolean mIsServiceConnected = false;
    private IBinder mService = null;
    private ServiceConnection mConnection = new ServiceConnection() { // from class: com.tencent.trtc.hardwareearmonitor.daisy.DaisyAudioKaraokeFeatureKit.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            DaisyAudioKaraokeFeatureKit.this.mIHwAudioKaraokeFeatureAidl = IDaisyAudioKaraokeFeature.Stub.asInterface(iBinder);
            if (DaisyAudioKaraokeFeatureKit.this.mIHwAudioKaraokeFeatureAidl != null) {
                DaisyAudioKaraokeFeatureKit.this.mIsServiceConnected = true;
                DaisyAudioKaraokeFeatureKit daisyAudioKaraokeFeatureKit = DaisyAudioKaraokeFeatureKit.this;
                if (daisyAudioKaraokeFeatureKit.serviceInit(daisyAudioKaraokeFeatureKit.mContext.getPackageName())) {
                    DaisyAudioKaraokeFeatureKit.this.mFeatureKitManager.onCallBack(1000);
                    DaisyAudioKaraokeFeatureKit.this.serviceLinkToDeath(iBinder);
                } else {
                    DaisyAudioKaraokeFeatureKit.this.mFeatureKitManager.onCallBack(1002);
                }
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            DaisyAudioKaraokeFeatureKit.this.mIsServiceConnected = false;
            if (DaisyAudioKaraokeFeatureKit.this.mFeatureKitManager != null) {
                DaisyAudioKaraokeFeatureKit.this.mFeatureKitManager.onCallBack(1001);
            }
        }
    };
    private IBinder.DeathRecipient mDeathRecipient = new IBinder.DeathRecipient() { // from class: com.tencent.trtc.hardwareearmonitor.daisy.DaisyAudioKaraokeFeatureKit.2
        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            LiteavLog.e(DaisyAudioKaraokeFeatureKit.TAG, "binderDied");
            DaisyAudioKaraokeFeatureKit.this.mService.unlinkToDeath(DaisyAudioKaraokeFeatureKit.this.mDeathRecipient, 0);
            DaisyAudioKaraokeFeatureKit.this.mFeatureKitManager.onCallBack(1003);
            DaisyAudioKaraokeFeatureKit.this.mService = null;
        }
    };

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public enum ParameName {
        CMD_SET_AUDIO_EFFECT_MODE_BASE("Karaoke_reverb_mode="),
        CMD_SET_VOCAL_VOLUME_BASE("Karaoke_volume="),
        CMD_SET_VOCAL_EQUALIZER_MODE("Karaoke_eq_mode=");

        private String mParameName;

        ParameName(String str) {
            this.mParameName = str;
        }

        public final String getParameName() {
            return this.mParameName;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DaisyAudioKaraokeFeatureKit(Context context) {
        this.mFeatureKitManager = null;
        this.mFeatureKitManager = DaisyFeatureKitManager.getInstance();
        this.mContext = context;
    }

    private void bindService(Context context) {
        DaisyFeatureKitManager daisyFeatureKitManager = this.mFeatureKitManager;
        if (daisyFeatureKitManager != null && !this.mIsServiceConnected) {
            daisyFeatureKitManager.bindService(context, this.mConnection, ENGINE_CLASS_NAME);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean serviceInit(String str) {
        try {
            IDaisyAudioKaraokeFeature iDaisyAudioKaraokeFeature = this.mIHwAudioKaraokeFeatureAidl;
            if (iDaisyAudioKaraokeFeature == null || !this.mIsServiceConnected) {
                return true;
            }
            iDaisyAudioKaraokeFeature.init(str);
            return true;
        } catch (Throwable th5) {
            LiteavLog.e(TAG, "isFeatureSupported,RemoteException ex : %s", th5.getMessage());
            return false;
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
                LiteavLog.e(TAG, "serviceLinkToDeath, RemoteException");
            }
        }
    }

    public void destroy() {
        if (this.mIsServiceConnected) {
            this.mIsServiceConnected = false;
            this.mFeatureKitManager.unbindService(this.mContext, this.mConnection);
        }
    }

    public int enableKaraokeFeature(boolean z16) {
        try {
            IDaisyAudioKaraokeFeature iDaisyAudioKaraokeFeature = this.mIHwAudioKaraokeFeatureAidl;
            if (iDaisyAudioKaraokeFeature != null && this.mIsServiceConnected) {
                return iDaisyAudioKaraokeFeature.enableKaraokeFeature(z16);
            }
            return -2;
        } catch (RemoteException e16) {
            LiteavLog.e(TAG, "enableKaraokeFeature,RemoteException ex : %s", e16.getMessage());
            return -2;
        }
    }

    public int getKaraokeLatency() {
        try {
            IDaisyAudioKaraokeFeature iDaisyAudioKaraokeFeature = this.mIHwAudioKaraokeFeatureAidl;
            if (iDaisyAudioKaraokeFeature != null && this.mIsServiceConnected) {
                return iDaisyAudioKaraokeFeature.getKaraokeLatency();
            }
            return -1;
        } catch (RemoteException e16) {
            LiteavLog.e(TAG, "getKaraokeLatency,RemoteException ex : %s", e16.getMessage());
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initialize(Context context) {
        if (context == null) {
            return;
        }
        if (!DaisyFeatureKitManager.isAudioKitSupport(context)) {
            this.mFeatureKitManager.onCallBack(2);
        } else {
            bindService(context);
        }
    }

    public boolean isKaraokeFeatureSupport() {
        try {
            IDaisyAudioKaraokeFeature iDaisyAudioKaraokeFeature = this.mIHwAudioKaraokeFeatureAidl;
            if (iDaisyAudioKaraokeFeature != null && this.mIsServiceConnected) {
                return iDaisyAudioKaraokeFeature.isKaraokeFeatureSupport();
            }
        } catch (RemoteException e16) {
            LiteavLog.e(TAG, "isFeatureSupported,RemoteException ex : %s", e16.getMessage());
        }
        return false;
    }

    public int setParameter(ParameName parameName, int i3) {
        if (parameName == null) {
            return 1807;
        }
        try {
            IDaisyAudioKaraokeFeature iDaisyAudioKaraokeFeature = this.mIHwAudioKaraokeFeatureAidl;
            if (iDaisyAudioKaraokeFeature != null && this.mIsServiceConnected) {
                return iDaisyAudioKaraokeFeature.setParameter(parameName.getParameName(), i3);
            }
            return -2;
        } catch (RemoteException e16) {
            LiteavLog.e(TAG, "setParameter,RemoteException ex : %s", e16.getMessage());
            return -2;
        }
    }
}
