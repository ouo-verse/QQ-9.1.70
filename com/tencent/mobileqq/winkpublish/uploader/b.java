package com.tencent.mobileqq.winkpublish.uploader;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.winkpublish.util.d;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.common.UploadConfiguration;
import com.tencent.upload.uinterface.IUploadEnv;
import com.tencent.upload.uinterface.IUploadSoLoader;
import common.config.service.QzoneConfig;

/* compiled from: P */
/* loaded from: classes35.dex */
public class b implements IUploadEnv, IUploadSoLoader {

    /* renamed from: a, reason: collision with root package name */
    private volatile boolean f327403a = true;

    /* renamed from: b, reason: collision with root package name */
    AUploadSoDownloader f327404b;

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class a implements d.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ UploadConfiguration.NetworkStateObserver f327405d;

        a(UploadConfiguration.NetworkStateObserver networkStateObserver) {
            this.f327405d = networkStateObserver;
        }

        @Override // com.tencent.mobileqq.winkpublish.util.d.b
        public void onNetworkConnect(boolean z16) {
            if (QLog.isColorLevel()) {
                QLog.d("[upload2]AUploadEnv", 2, "upload2: onNetworkConnect registerNetworkStateObserver|onNetworkConnect\uff1a" + z16);
            }
            b.this.f327403a = z16;
            this.f327405d.onStateChanged(z16);
        }
    }

    public b() {
        AUploadSoDownloader aUploadSoDownloader = new AUploadSoDownloader();
        this.f327404b = aUploadSoDownloader;
        aUploadSoDownloader.h();
    }

    private static NetworkInfo c(Context context) {
        String networkInfo;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                networkInfo = "getActiveNetworkInfo null";
            } else {
                networkInfo = activeNetworkInfo.toString();
            }
            QLog.d("[upload2]AUploadEnv", 1, networkInfo);
            return activeNetworkInfo;
        } catch (Throwable th5) {
            QLog.d("[upload2]AUploadEnv", 1, "fail to get active network info " + th5.getMessage());
            return null;
        }
    }

    public static boolean d(Context context) {
        NetworkInfo c16 = c(context);
        return c16 != null && c16.isConnected();
    }

    @Override // com.tencent.upload.uinterface.IUploadEnv
    public String getApnName() {
        return com.tencent.mobileqq.winkpublish.util.d.c();
    }

    @Override // com.tencent.upload.uinterface.IUploadEnv
    public int getBatchControlCount() {
        return 8;
    }

    @Override // com.tencent.upload.uinterface.IUploadEnv
    public int getCurrentNetworkCategory() {
        int h16 = com.tencent.mobileqq.winkpublish.util.d.h();
        int i3 = 1;
        if (h16 != 1) {
            i3 = 3;
            if (h16 != 2) {
                if (h16 == 3) {
                    return 2;
                }
                if (h16 != 4) {
                    return h16 != 5 ? 0 : 7;
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
        int d16 = com.tencent.mobileqq.winkpublish.util.d.d();
        int i3 = 1;
        if (d16 != 1) {
            i3 = 2;
            if (d16 != 2) {
                i3 = 3;
                if (d16 != 3) {
                    return 0;
                }
            }
        }
        return i3;
    }

    @Override // com.tencent.upload.uinterface.IUploadEnv
    public String getProviderName() {
        return com.tencent.mobileqq.winkpublish.util.d.i();
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
        boolean k3 = com.tencent.mobileqq.winkpublish.util.d.k();
        this.f327403a = d(RFWApplication.getApplication());
        QLog.d("[upload2]AUploadEnv", 1, "msf network isAvailable:" + k3 + " observer:" + this.f327403a);
        return k3 && this.f327403a;
    }

    @Override // com.tencent.upload.uinterface.IUploadEnv
    public boolean isMobile() {
        return com.tencent.mobileqq.winkpublish.util.d.j();
    }

    @Override // com.tencent.upload.uinterface.IUploadEnv
    public boolean isWap() {
        return com.tencent.mobileqq.winkpublish.util.d.l();
    }

    @Override // com.tencent.upload.uinterface.IUploadEnv
    public boolean isWifi() {
        return com.tencent.mobileqq.winkpublish.util.d.m();
    }

    @Override // com.tencent.upload.uinterface.IUploadSoLoader
    public boolean loadLibrary(String str) {
        boolean k3 = this.f327404b.k(str);
        QLog.d("[upload2]AUploadEnv", 1, "useDownloadedSo " + k3);
        if (k3) {
            return true;
        }
        try {
            QLog.d("[upload2]AUploadEnv", 1, "try to load library: " + str + " from system lib");
            System.loadLibrary(str);
            return true;
        } catch (Throwable th5) {
            QLog.e("[upload2]AUploadEnv", 1, "cannot load library " + str + " from system lib", th5);
            return false;
        }
    }

    @Override // com.tencent.upload.uinterface.IUploadEnv
    public void registerNetworkStateObserver(UploadConfiguration.NetworkStateObserver networkStateObserver) {
        if (QLog.isColorLevel()) {
            QLog.d("[upload2]AUploadEnv", 2, "registerNetworkStateObserver");
        }
        com.tencent.mobileqq.winkpublish.util.d.b(new a(networkStateObserver));
    }

    public static boolean b(int i3) {
        int intValue = uq3.c.X0(QzoneConfig.MAIN_KEY_UPLOAD, QzoneConfig.SECONDARY_UPLOAD_ENABLE_V6_ROUTE_FOR_ALL, 7).intValue();
        if (i3 != 1) {
            QLog.d("[upload2]AUploadEnv", 1, "enableV6Switch:" + ((intValue >> i3) & 1) + " type:" + i3);
        }
        return ((intValue >> i3) & 1) == 1;
    }
}
