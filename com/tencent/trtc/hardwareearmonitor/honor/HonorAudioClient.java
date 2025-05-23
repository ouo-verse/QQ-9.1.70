package com.tencent.trtc.hardwareearmonitor.honor;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.trtc.hardwareearmonitor.honor.IHonorAudioService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class HonorAudioClient {
    private static final List<Integer> DEFAULT_FEATURE_LIST = new ArrayList(0);
    private static final int DEFAULT_VALUE = 0;
    private static final String ENGINE_CLASS_NAME = "com.hihonor.android.magicx.media.audioengine.HnAudioServiceImpl";
    private static final String ENGINE_PACKAGE_NAME = "com.hihonor.android.magicx.media.audioengine";
    private static final String TAG = "HnAudioEngine.HnAudioClient";
    private Context mContext;
    private HonorFeatureKitManager mFeatureKitManager;
    private IHonorAudioService mIHnAudioService = null;
    private boolean mIsServiceConnected = false;
    private IBinder mService = null;
    private List<Integer> mSupportedServiceList = new ArrayList();
    private ServiceConnection mConnection = new ServiceConnection() { // from class: com.tencent.trtc.hardwareearmonitor.honor.HonorAudioClient.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            HonorAudioClient.this.mIHnAudioService = IHonorAudioService.Stub.asInterface(iBinder);
            HonorLogUtils.info(HonorAudioClient.TAG, "onServiceConnected");
            if (HonorAudioClient.this.mIHnAudioService != null) {
                HonorAudioClient.this.mIsServiceConnected = true;
                HonorLogUtils.info(HonorAudioClient.TAG, "onServiceConnected, mIHnAudioService is not null");
                HonorAudioClient.this.mFeatureKitManager.onCallBack(0);
                HonorAudioClient honorAudioClient = HonorAudioClient.this;
                honorAudioClient.serviceInit(honorAudioClient.mContext.getPackageName(), HonorVersion.SDK_VERSION_NAME);
                HonorAudioClient.this.serviceLinkToDeath(iBinder);
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            HonorLogUtils.info(HonorAudioClient.TAG, "onServiceDisconnected");
            HonorAudioClient.this.mIHnAudioService = null;
            HonorAudioClient.this.mIsServiceConnected = false;
            HonorAudioClient.this.mFeatureKitManager.onCallBack(4);
        }
    };
    private IBinder.DeathRecipient mDeathRecipient = new IBinder.DeathRecipient() { // from class: com.tencent.trtc.hardwareearmonitor.honor.HonorAudioClient.2
        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            HonorAudioClient.this.mService.unlinkToDeath(HonorAudioClient.this.mDeathRecipient, 0);
            HonorAudioClient.this.mFeatureKitManager.onCallBack(6);
            HonorLogUtils.error(HonorAudioClient.TAG, "service binder died");
            HonorAudioClient.this.mService = null;
        }
    };

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public enum ServiceType {
        HNAUDIO_SERVICE_EARRETURN(1),
        HNAUDIO_SERVICE_ADVANCEDRECORD(2),
        HNAUDIO_SERVICE_HIGHSAMPLERATEPLAY(3),
        HNAUDIO_SERVICE_RECORDDENOISE(4);

        private int mServiceType;

        ServiceType(int i3) {
            this.mServiceType = i3;
        }

        public final int getServiceType() {
            return this.mServiceType;
        }
    }

    public HonorAudioClient(Context context, IHonorAudioServiceCallback iHonorAudioServiceCallback) {
        HonorFeatureKitManager honorFeatureKitManager = HonorFeatureKitManager.getInstance();
        this.mFeatureKitManager = honorFeatureKitManager;
        this.mContext = null;
        honorFeatureKitManager.setCallBack(iHonorAudioServiceCallback);
        this.mContext = context;
    }

    private void bindService(Context context) {
        HonorLogUtils.info(TAG, "bindService, mIsServiceConnected = " + this.mIsServiceConnected);
        HonorFeatureKitManager honorFeatureKitManager = this.mFeatureKitManager;
        if (honorFeatureKitManager != null && !this.mIsServiceConnected) {
            honorFeatureKitManager.bindService(context, this.mConnection, ENGINE_CLASS_NAME);
        }
    }

    private void filterUnsupportedService(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4 && HonorFeatureKitManager.mMinVersion >= 1000001) {
                        this.mSupportedServiceList.add(Integer.valueOf(i3));
                        return;
                    }
                    return;
                }
                if (HonorFeatureKitManager.mMinVersion >= 1000001) {
                    this.mSupportedServiceList.add(Integer.valueOf(i3));
                    return;
                }
                return;
            }
            if (HonorFeatureKitManager.mMinVersion >= 1000000) {
                this.mSupportedServiceList.add(Integer.valueOf(i3));
                return;
            }
            return;
        }
        if (HonorFeatureKitManager.mMinVersion >= 1000000) {
            this.mSupportedServiceList.add(Integer.valueOf(i3));
        }
    }

    public static boolean isDeviceSupported(Context context) {
        return HonorFeatureKitManager.isAudioKitSupport(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void serviceInit(String str, String str2) {
        HonorLogUtils.info(TAG, "serviceInit");
        try {
            IHonorAudioService iHonorAudioService = this.mIHnAudioService;
            if (iHonorAudioService != null && this.mIsServiceConnected) {
                iHonorAudioService.init(str, str2);
            }
        } catch (Throwable th5) {
            HonorLogUtils.error(TAG, "isFeatureSupported,RemoteException ex :" + th5.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void serviceLinkToDeath(IBinder iBinder) {
        this.mService = iBinder;
        if (iBinder != null) {
            try {
                iBinder.linkToDeath(this.mDeathRecipient, 0);
            } catch (RemoteException unused) {
                this.mFeatureKitManager.onCallBack(5);
                HonorLogUtils.error(TAG, "serviceLinkToDeath, RemoteException");
            }
        }
    }

    public <T extends HonorAudioFeaturesKit> T createService(ServiceType serviceType) {
        if (this.mFeatureKitManager != null && serviceType != null && this.mSupportedServiceList.contains(Integer.valueOf(serviceType.getServiceType()))) {
            return (T) this.mFeatureKitManager.createFeatureKit(serviceType.getServiceType(), this.mContext);
        }
        HonorLogUtils.error(TAG, "createService fail");
        return null;
    }

    public void destroy() {
        HonorLogUtils.info(TAG, "destroy, mIsServiceConnected = " + this.mIsServiceConnected);
        if (this.mIsServiceConnected) {
            this.mIsServiceConnected = false;
            this.mFeatureKitManager.unbindService(this.mContext, this.mConnection);
        }
    }

    public List<Integer> getSupportedServices() {
        try {
            IHonorAudioService iHonorAudioService = this.mIHnAudioService;
            if (iHonorAudioService != null && this.mIsServiceConnected) {
                List supportedServices = iHonorAudioService.getSupportedServices();
                if (supportedServices == null) {
                    HonorLogUtils.error(TAG, "list is null");
                    return DEFAULT_FEATURE_LIST;
                }
                this.mSupportedServiceList.clear();
                Iterator it = supportedServices.iterator();
                while (it.hasNext()) {
                    filterUnsupportedService(((Integer) it.next()).intValue());
                }
                HonorLogUtils.info(TAG, "getSupportedServices " + Arrays.toString(supportedServices.toArray()));
                return this.mSupportedServiceList;
            }
        } catch (RemoteException unused) {
            HonorLogUtils.error(TAG, "getSupportedServices, createFeature,wait bind service fail");
        }
        HonorLogUtils.info(TAG, "getSupportedServices, service not bind");
        return DEFAULT_FEATURE_LIST;
    }

    public void initialize() {
        HonorLogUtils.info(TAG, "initialize");
        Context context = this.mContext;
        if (context == null) {
            HonorLogUtils.info(TAG, "mContext is null");
            this.mFeatureKitManager.onCallBack(7);
        } else if (!HonorFeatureKitManager.isAudioKitSupport(context)) {
            HonorLogUtils.info(TAG, "not install AudioKitEngine");
            this.mFeatureKitManager.onCallBack(2);
        } else {
            bindService(this.mContext);
        }
    }

    public boolean isServiceSupported(ServiceType serviceType) {
        if (serviceType == null) {
            return false;
        }
        HonorLogUtils.info(TAG, "isServiceSupported, type = " + serviceType.getServiceType());
        try {
            if (this.mIHnAudioService == null || !this.mIsServiceConnected || !this.mSupportedServiceList.contains(Integer.valueOf(serviceType.getServiceType()))) {
                return false;
            }
            return this.mIHnAudioService.isServiceSupported(serviceType.getServiceType());
        } catch (RemoteException e16) {
            HonorLogUtils.error(TAG, "isServiceSupported,RemoteException ex : " + e16.getMessage());
            return false;
        }
    }
}
