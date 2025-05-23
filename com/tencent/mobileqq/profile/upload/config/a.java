package com.tencent.mobileqq.profile.upload.config;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.upload.uinterface.IUploadConfig;
import com.tencent.upload.uinterface.UploadSdkConst;
import common.config.service.QzoneConfig;
import cooperation.qzone.PlatformInfor;
import cooperation.qzone.QUA;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a implements IUploadConfig {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private long f260320a;

    public a(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, j3);
        } else {
            this.f260320a = j3;
        }
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public boolean canHoldSystemLock() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return ((Boolean) iPatchRedirector.redirect((short) 40, (Object) this)).booleanValue();
        }
        if (QzoneConfig.getInstance().getConfig("PhotoUpload", QzoneConfig.SECONDARY_KEY_CAN_HOLD_SYSTEM_LOCK, 0) != 1) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public boolean checkApnChangeForInit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return ((Boolean) iPatchRedirector.redirect((short) 44, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public boolean enableBitmapNativeAlloc() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public boolean enableV6Route() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return ((Boolean) iPatchRedirector.redirect((short) 43, (Object) this)).booleanValue();
        }
        if (QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_UPLOAD, QzoneConfig.SECONDARY_UPLOAD_ENABLE_V6_ROUTE, 0) != 1) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public int getAppId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Integer) iPatchRedirector.redirect((short) 1, (Object) this)).intValue();
        }
        return 1000027;
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String getChangeRouteRetCodes() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return (String) iPatchRedirector.redirect((short) 41, (Object) this);
        }
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_UPLOAD, QzoneConfig.SECONDARY_UPLOAD_CHANGEROUTE_RETCODE, QzoneConfig.DEFAULT_UPLOAD_CHANGEROUTE_RETCODE);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public int getCompressToWebpFlag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return QzoneConfig.getInstance().getConfig("PhotoUpload", QzoneConfig.SECONDARY_COMPRESS_TO_WEBP, 0);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public int getConnectTimeout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return QzoneConfig.getInstance().getConfig("PhotoUpload", QzoneConfig.SECONDARY_UPLOAD_CONNECT_TIMEOUT, 20);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public long getCurrentUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
        return this.f260320a;
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public int getDataTimeout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return QzoneConfig.getInstance().getConfig("PhotoUpload", QzoneConfig.SECONDARY_UPLOAD_DATA_TIMEOUT, 60);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String getDeviceInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return PlatformInfor.g().getDeviceInfor();
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public int getDoNotFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_WNSSETTINGS, QzoneConfig.SECONDARY_IP_NO_PMTU_DISC, 1);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String getExifTagCode(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        }
        return null;
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public int getGifUploadLimit(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Integer) iPatchRedirector.redirect((short) 25, (Object) this, i3)).intValue();
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 6) {
                        return 0;
                    }
                    return QzoneConfig.getInstance().getConfig("PhotoUpload", QzoneConfig.SECONDARY_GIF_UPLOAD_LIMIT_4G, 5242880);
                }
                return QzoneConfig.getInstance().getConfig("PhotoUpload", QzoneConfig.SECONDARY_GIF_UPLOAD_LIMIT_2G, 819200);
            }
            return QzoneConfig.getInstance().getConfig("PhotoUpload", QzoneConfig.SECONDARY_GIF_UPLOAD_LIMIT_3G, 2097152);
        }
        return QzoneConfig.getInstance().getConfig("PhotoUpload", QzoneConfig.SECONDARY_GIF_UPLOAD_LIMIT_WIFI, 5242880);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String getMaxSegmentSizeArray() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String getMobileLogUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (String) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return QzoneConfig.getInstance().getConfig("PhotoSvrList", QzoneConfig.SECONDARY_NEWTYPE_UPLOAD_MOBILE_LOG_HOST, UploadSdkConst.DEFAULT_LOG_HOST);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String getMobileLogUrlV6() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (String) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        return QzoneConfig.getInstance().getConfig("PhotoSvrList", QzoneConfig.SECONDARY_LOG_UPLOAD_OPT_IP_V6);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String getNetworkUnavailableRetCodes() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return (String) iPatchRedirector.redirect((short) 42, (Object) this);
        }
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_UPLOAD, QzoneConfig.SECONDARY_UPLOAD_NETWORK_UNAVAILABLE_RETCODE, QzoneConfig.DEFAULT_UPLOAD_NETWORK_UNAVAILABLE_RETCODE);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String getOtherBakUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return (String) iPatchRedirector.redirect((short) 38, (Object) this);
        }
        return QzoneConfig.getInstance().getConfig("PhotoSvrList", QzoneConfig.SECONDARY_OTHER_UPLOAD_BAK_IP);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String getOtherHostUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return (String) iPatchRedirector.redirect((short) 37, (Object) this);
        }
        return QzoneConfig.getInstance().getConfig("PhotoSvrList", QzoneConfig.SECONDARY_OTHER_UPLOAD_HOST_IP);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String getOtherOptUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return (String) iPatchRedirector.redirect((short) 36, (Object) this);
        }
        return QzoneConfig.getInstance().getConfig("PhotoSvrList", QzoneConfig.SECONDARY_OTHER_UPLOAD_OPT_IP);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String getOtherOptUrlV6() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return (String) iPatchRedirector.redirect((short) 39, (Object) this);
        }
        return QzoneConfig.getInstance().getConfig("PhotoSvrList", QzoneConfig.SECONDARY_OTHER_UPLOAD_OPT_IP_V6);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String getPhotoBakUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (String) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        return QzoneConfig.getInstance().getConfig("PhotoSvrList", QzoneConfig.SECONDARY_IMAGE_UPLOAD_BAK_IP);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String getPhotoHostUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (String) iPatchRedirector.redirect((short) 27, (Object) this);
        }
        return QzoneConfig.getInstance().getConfig("PhotoSvrList", QzoneConfig.SECONDARY_IMAGE_UPLOAD_HOST_IP);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String getPhotoHostUrlV6() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (String) iPatchRedirector.redirect((short) 30, (Object) this);
        }
        return QzoneConfig.getInstance().getConfig("PhotoSvrList", QzoneConfig.SECONDARY_IMAGE_UPLOAD_HOST_IP_V6);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String getPhotoOptUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (String) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        return QzoneConfig.getInstance().getConfig("PhotoSvrList", QzoneConfig.SECONDARY_IMAGE_UPLOAD_OPT_IP);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String getPhotoOptUrlV6() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (String) iPatchRedirector.redirect((short) 29, (Object) this);
        }
        return QzoneConfig.getInstance().getConfig("PhotoSvrList", QzoneConfig.SECONDARY_IMAGE_UPLOAD_OPT_IP_V6);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public float getPictureQuality(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Float) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str)).floatValue();
        }
        return 0.0f;
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String getQUA3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return QUA.getQUA3();
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public long getRecentRouteExpire() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Long) iPatchRedirector.redirect((short) 12, (Object) this)).longValue();
        }
        return 604800000L;
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public int getTimeoutRetryCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return QzoneConfig.getInstance().getConfig("PhotoUpload", QzoneConfig.SECONDARY_UPLOAD_TIMEOUT_RETRY_COUNT, 3);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String getUploadPort() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return QzoneConfig.getInstance().getConfig("PhotoSvrList", QzoneConfig.SECONDARY_SERVER_PORT_LIST, QzoneConfig.DefaultValue.SERVER_PORT_LIST);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String getVideoBakUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return (String) iPatchRedirector.redirect((short) 33, (Object) this);
        }
        return QzoneConfig.getInstance().getConfig("PhotoSvrList", QzoneConfig.SECONDARY_VIDEO_UPLOAD_BAK_IP);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String getVideoHostUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (String) iPatchRedirector.redirect((short) 32, (Object) this);
        }
        return QzoneConfig.getInstance().getConfig("PhotoSvrList", QzoneConfig.SECONDARY_VIDEO_UPLOAD_HOST_IP);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String getVideoHostUrlV6() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return (String) iPatchRedirector.redirect((short) 35, (Object) this);
        }
        return QzoneConfig.getInstance().getConfig("PhotoSvrList", QzoneConfig.SECONDARY_VIDEO_UPLOAD_HOST_IP_V6);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String getVideoOptUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (String) iPatchRedirector.redirect((short) 31, (Object) this);
        }
        return QzoneConfig.getInstance().getConfig("PhotoSvrList", QzoneConfig.SECONDARY_VIDEO_UPLOAD_OPT_IP);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String getVideoOptUrlV6() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (String) iPatchRedirector.redirect((short) 34, (Object) this);
        }
        return QzoneConfig.getInstance().getConfig("PhotoSvrList", QzoneConfig.SECONDARY_VIDEO_UPLOAD_OPT_IP_V6);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public int getWifiOperator() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_EXTRA_CONFIG, QzoneConfig.SECONDARY_WIFI_OPERATOR_CRARRY, 0);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public long getWtAppId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Long) iPatchRedirector.redirect((short) 15, (Object) this)).longValue();
        }
        return 0L;
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public boolean isNeedReleasePool() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return ((Boolean) iPatchRedirector.redirect((short) 45, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public boolean isPictureNeedToCompress(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this, (Object) str)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public boolean isReleaseMode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public boolean isSwitchOn(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            return ((Boolean) iPatchRedirector.redirect((short) 46, (Object) this, (Object) str)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String loadAsString(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            return (String) iPatchRedirector.redirect((short) 47, (Object) this, (Object) str, (Object) str2);
        }
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString(str, str2);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public boolean useNewCopyExif() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        return false;
    }
}
