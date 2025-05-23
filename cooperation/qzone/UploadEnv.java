package cooperation.qzone;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.common.UploadConfiguration;
import com.tencent.upload.network.NetworkState;
import com.tencent.upload.uinterface.IUploadEnv;
import com.tencent.upload.uinterface.IUploadSoLoader;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class UploadEnv implements IUploadEnv, IUploadSoLoader {
    private static final String TAG = "UploadEnv";
    public static final int TYPE_DOWNLOAD = 1;
    public static final int TYPE_UPLOAD = 0;
    public static final int TYPE_VIDEO = 2;
    private static final boolean sEnableUseMsfIpStack = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_ENABLE_USE_MSF_IPSTACK, false);
    private volatile boolean hasNetwork = true;
    UploadSoDownloader mSoDownloader;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface NetworkCategory {
        public static final int MOBILE_2G = 3;
        public static final int MOBILE_3G = 2;
        public static final int MOBILE_4G = 6;
        public static final int MOBILE_5G = 7;
        public static final int UNKNOWN = 0;
        public static final int WIFI = 1;
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface OperatorCategory {
        public static final int CMCC = 1;
        public static final int CMCT = 3;
        public static final int UNICOM = 2;
        public static final int UNKNOW = 0;
        public static final int WIFI = 4;
    }

    public UploadEnv() {
        UploadSoDownloader uploadSoDownloader = new UploadSoDownloader();
        this.mSoDownloader = uploadSoDownloader;
        uploadSoDownloader.downloadUploadSo();
    }

    public static boolean enableV6Switch(int i3) {
        int config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_UPLOAD, QzoneConfig.SECONDARY_UPLOAD_ENABLE_V6_ROUTE_FOR_ALL, 7, false);
        if (i3 != 1) {
            QZLog.d(TAG, 1, "enableV6Switch:" + ((config >> i3) & 1) + " type:" + i3);
        }
        if (((config >> i3) & 1) != 1) {
            return false;
        }
        return true;
    }

    private static NetworkInfo getActiveNetworkInfo() {
        String networkInfo;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) BaseApplication.context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                networkInfo = "getActiveNetworkInfo null";
            } else {
                networkInfo = activeNetworkInfo.toString();
            }
            QLog.d(TAG, 1, networkInfo);
            return activeNetworkInfo;
        } catch (Throwable th5) {
            QLog.d(TAG, 1, "fail to get active network info " + th5.toString());
            return null;
        }
    }

    public static int getIpStack(int i3) {
        int i16;
        if (!enableV6Switch(i3)) {
            return 1;
        }
        try {
            i16 = NetworkState.getNetworkStackType();
        } catch (UnsatisfiedLinkError e16) {
            QZLog.e(TAG, "getIpStack error", e16);
            i16 = 1;
        }
        boolean z16 = sEnableUseMsfIpStack;
        if (z16 && i16 == 3) {
            int connectedIPFamily = MsfServiceSdk.get().getConnectedIPFamily();
            if (QZLog.isColorLevel()) {
                QZLog.d("IPConfigStrategy", 1, "enableUseMsfIpStack:", Boolean.valueOf(z16), ",process:", Integer.valueOf(MobileQQ.sProcessId), ",ipFamily:" + connectedIPFamily);
            }
            if (connectedIPFamily != 0) {
                return connectedIPFamily;
            }
        }
        return i16;
    }

    public static boolean isNetworkAvailable(Context context) {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.upload.uinterface.IUploadEnv
    public String getApnName() {
        return cooperation.qzone.util.NetworkState.getAPN();
    }

    @Override // com.tencent.upload.uinterface.IUploadEnv
    public int getBatchControlCount() {
        return 8;
    }

    @Override // com.tencent.upload.uinterface.IUploadEnv
    public int getCurrentNetworkCategory() {
        int networkType = cooperation.qzone.util.NetworkState.getNetworkType();
        int i3 = 1;
        if (networkType != 1) {
            i3 = 3;
            if (networkType != 2) {
                if (networkType == 3) {
                    return 2;
                }
                if (networkType != 4) {
                    if (networkType != 5) {
                        return 0;
                    }
                    return 7;
                }
                return 6;
            }
        }
        return i3;
    }

    @Override // com.tencent.upload.uinterface.IUploadEnv
    public int getFileConcurrentCount() {
        return 3;
    }

    @Override // com.tencent.upload.uinterface.IUploadEnv
    public int getMobileOperatorCategory() {
        int apnValue = cooperation.qzone.util.NetworkState.getApnValue();
        int i3 = 1;
        if (apnValue != 1) {
            i3 = 2;
            if (apnValue != 2) {
                i3 = 3;
                if (apnValue != 3) {
                    return 0;
                }
            }
        }
        return i3;
    }

    @Override // com.tencent.upload.uinterface.IUploadEnv
    public String getProviderName() {
        return cooperation.qzone.util.NetworkState.getProviderName();
    }

    @Override // com.tencent.upload.uinterface.IUploadEnv
    public String getSDKPrivatePath(String str) {
        return VFSAssistantUtils.getSDKPrivatePath(str);
    }

    @Override // com.tencent.upload.uinterface.IUploadSoLoader
    public String getSoVersion() {
        return "v1.3";
    }

    @Override // com.tencent.upload.uinterface.IUploadEnv
    public int getSocketCount() {
        return 2;
    }

    @Override // com.tencent.upload.uinterface.IUploadEnv
    public boolean isAvailable() {
        boolean isNetSupport = cooperation.qzone.util.NetworkState.isNetSupport();
        this.hasNetwork = isNetworkAvailable(BaseApplication.getContext());
        QLog.d("upload2:", 2, "msf network isAvailable:" + isNetSupport + " observer:" + this.hasNetwork);
        if (isNetSupport && this.hasNetwork) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.upload.uinterface.IUploadEnv
    public boolean isMobile() {
        return cooperation.qzone.util.NetworkState.isMobile();
    }

    @Override // com.tencent.upload.uinterface.IUploadEnv
    public boolean isWap() {
        return cooperation.qzone.util.NetworkState.isWap();
    }

    @Override // com.tencent.upload.uinterface.IUploadEnv
    public boolean isWifi() {
        return cooperation.qzone.util.NetworkState.isWifiConn();
    }

    @Override // com.tencent.upload.uinterface.IUploadSoLoader
    public boolean loadLibrary(String str) {
        boolean loadLibrary = this.mSoDownloader.loadLibrary(str);
        QLog.d(TAG, 1, "useDownloadedSo " + loadLibrary);
        if (loadLibrary) {
            return true;
        }
        try {
            QLog.d(TAG, 1, "try to load library: " + str + " from system lib");
            System.loadLibrary(str);
            return true;
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "cannot load library " + str + " from system lib", th5);
            return false;
        }
    }

    @Override // com.tencent.upload.uinterface.IUploadEnv
    public void registerNetworkStateObserver(final UploadConfiguration.NetworkStateObserver networkStateObserver) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "registerNetworkStateObserver");
        }
        cooperation.qzone.util.NetworkState.addListener(new NetworkState.NetworkStateListener() { // from class: cooperation.qzone.UploadEnv.1
            @Override // cooperation.qzone.util.NetworkState.NetworkStateListener
            public void onNetworkConnect(boolean z16) {
                if (QLog.isColorLevel()) {
                    QLog.d(UploadEnv.TAG, 2, "upload2: onNetworkConnect registerNetworkStateObserver|onNetworkConnect\uff1a" + z16);
                }
                UploadEnv.this.hasNetwork = z16;
                networkStateObserver.onStateChanged(z16);
            }
        });
    }
}
