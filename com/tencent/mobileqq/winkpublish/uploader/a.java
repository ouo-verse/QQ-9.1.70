package com.tencent.mobileqq.winkpublish.uploader;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.winkpublish.publishconst.WinkHostConstants;
import com.tencent.mobileqq.winkpublish.util.AUploadImageSizeStrategy;
import com.tencent.mobileqq.winkpublish.util.ExifUtil;
import com.tencent.mobileqq.winkpublish.util.ImageUtil;
import com.tencent.mobileqq.winkpublish.util.WinkHostFileUtils;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadConfig;
import com.tencent.upload.uinterface.TaskTypeConfig;
import com.tencent.upload.uinterface.UploadSdkConst;
import com.tencent.upload.utils.Const;
import common.config.service.QzoneConfig;
import cooperation.qzone.PlatformInfor;
import cooperation.qzone.QUA;
import java.io.File;

/* compiled from: P */
/* loaded from: classes35.dex */
public class a implements IUploadConfig {
    private int a(String str, int i3) {
        return uq3.c.X0("PhotoUpload", str, Integer.valueOf(i3)).intValue();
    }

    private String b(String str, String str2) {
        return uq3.c.b1("PhotoUpload", str, str2);
    }

    public boolean c(int i3) {
        int compressToWebpFlag = getCompressToWebpFlag();
        if (i3 == 2 && (compressToWebpFlag & 16) == 16) {
            return true;
        }
        return (i3 == 2 || i3 == 3 || (compressToWebpFlag & 1) != 1) ? false : true;
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public boolean enableBitmapNativeAlloc() {
        return false;
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public int getAppId() {
        return WinkHostConstants.QZoneAppConstants.qzoneBussinessId();
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String getChangeRouteRetCodes() {
        return uq3.c.b1(QzoneConfig.MAIN_KEY_UPLOAD, QzoneConfig.SECONDARY_UPLOAD_CHANGEROUTE_RETCODE, QzoneConfig.DEFAULT_UPLOAD_CHANGEROUTE_RETCODE);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public int getConnectTimeout() {
        return a(QzoneConfig.SECONDARY_UPLOAD_CONNECT_TIMEOUT, 20);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public long getCurrentUin() {
        return ua3.a.d().f();
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public int getDataTimeout() {
        return a(QzoneConfig.SECONDARY_UPLOAD_DATA_TIMEOUT, 60);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String getDeviceInfo() {
        return PlatformInfor.g().getDeviceInfor();
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String getExifTagCode(String str) {
        return ExifUtil.getExifTagCode(str);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String getMaxSegmentSizeArray() {
        return null;
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String getMobileLogUrl() {
        return uq3.c.b1("PhotoSvrList", QzoneConfig.SECONDARY_NEWTYPE_UPLOAD_MOBILE_LOG_HOST, UploadSdkConst.DEFAULT_LOG_HOST);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String getMobileLogUrlV6() {
        return uq3.c.a1("PhotoSvrList", QzoneConfig.SECONDARY_LOG_UPLOAD_OPT_IP_V6);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String getNetworkUnavailableRetCodes() {
        return uq3.c.b1(QzoneConfig.MAIN_KEY_UPLOAD, QzoneConfig.SECONDARY_UPLOAD_NETWORK_UNAVAILABLE_RETCODE, QzoneConfig.DEFAULT_UPLOAD_NETWORK_UNAVAILABLE_RETCODE);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String getOtherBakUrl() {
        return uq3.c.a1("PhotoSvrList", QzoneConfig.SECONDARY_OTHER_UPLOAD_BAK_IP);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String getOtherHostUrl() {
        return uq3.c.a1("PhotoSvrList", QzoneConfig.SECONDARY_OTHER_UPLOAD_HOST_IP);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String getOtherOptUrl() {
        return uq3.c.a1("PhotoSvrList", QzoneConfig.SECONDARY_OTHER_UPLOAD_OPT_IP);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String getOtherOptUrlV6() {
        return uq3.c.a1("PhotoSvrList", QzoneConfig.SECONDARY_OTHER_UPLOAD_OPT_IP_V6);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public float getPictureQuality(String str) {
        return 0.0f;
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String getQUA3() {
        return QUA.getQUA3();
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public int getTimeoutRetryCount() {
        return a(QzoneConfig.SECONDARY_UPLOAD_TIMEOUT_RETRY_COUNT, 3);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public IUploadConfig.UploadImageSize getUploadImageSize(IUploadConfig.UploadImageSize uploadImageSize, int i3, AbstractUploadTask abstractUploadTask) {
        TaskTypeConfig uploadTaskType = abstractUploadTask.getUploadTaskType();
        IUploadConfig.UploadImageSize targetSize = AUploadImageSizeStrategy.getTargetSize(new ImageUtil.Size(uploadImageSize.width, uploadImageSize.height), i3, uploadTaskType != null && uploadTaskType.uploadType == 0 ? c(i3) : false);
        if (targetSize == null) {
            return new IUploadConfig.UploadImageSize(0, 0, 0);
        }
        return i3 == 3 ? new IUploadConfig.UploadImageSize(uploadImageSize.width, uploadImageSize.height, 100) : targetSize;
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String getUploadPort() {
        return b(QzoneConfig.SECONDARY_SERVER_PORT_LIST, QzoneConfig.DefaultValue.SERVER_PORT_LIST);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public long getWtAppId() {
        return 0L;
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public boolean isPictureNeedToCompress(String str) {
        int i3;
        int i16;
        if (!WinkHostFileUtils.fileExistsAndNotEmpty(str)) {
            return true;
        }
        String[] split = uq3.c.b1("PhotoUpload", QzoneConfig.SECONDARY_COMPRESS_SIZE_LIMIT, QzoneConfig.DefaultValue.UPLOAD_PICTURE_COMPRESS_SIZE_LIMIT).split(",");
        if (split.length == 2) {
            i3 = Integer.parseInt(split[0]);
            i16 = Integer.parseInt(split[1]);
        } else {
            i3 = 200;
            i16 = 300;
        }
        uq3.c.X0("PhotoUpload", QzoneConfig.SECONDARY_COMPRESS_QUALITY_LIMIT, 70).intValue();
        long length = new File(str).length();
        if (length <= i3 * 1024) {
            return false;
        }
        if (length <= i16 * 1024) {
            try {
                if (WinkHostFileUtils.isFileJPEG(str)) {
                    return false;
                }
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
        return true;
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public boolean isReleaseMode() {
        return WinkHostConstants.AppSetting.isPublicVersion();
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public boolean isSwitchOn(String str) {
        if (Const.SwitchConfigKey.QQCIRCLE_ENABLE_NEW_CHANGE_STACKTYPE.equals(str)) {
            return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(Const.SwitchConfigKey.QQCIRCLE_ENABLE_NEW_CHANGE_STACKTYPE, true);
        }
        if (Const.SwitchConfigKey.QQCIRCLE_ENABLE_RESET.equals(str)) {
            return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(Const.SwitchConfigKey.QQCIRCLE_ENABLE_RESET, false);
        }
        if (Const.SwitchConfigKey.QQCIRCLE_CHANGE_ROUTE_FOR_IPV6.equals(str) || Const.SwitchConfigKey.QQCIRCLE_UPLOAD_GET_DOMAIN_IP_FIRST_FOR_IPV4.equals(str)) {
            return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(str, true);
        }
        return false;
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String loadAsString(String str, String str2) {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString(str, str2);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public boolean useNewCopyExif() {
        return false;
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public boolean canHoldSystemLock() {
        return uq3.c.X0("PhotoUpload", QzoneConfig.SECONDARY_KEY_CAN_HOLD_SYSTEM_LOCK, 0).intValue() == 1;
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public boolean checkApnChangeForInit() {
        return uq3.c.X0("qqcircle", "secondary_key_circle_change_apn_switch", 1).intValue() == 1;
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public boolean enableV6Route() {
        return b.b(0);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public int getCompressToWebpFlag() {
        return uq3.c.X0("PhotoUpload", QzoneConfig.SECONDARY_COMPRESS_TO_WEBP, 0).intValue();
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public int getDoNotFragment() {
        return uq3.c.X0(QzoneConfig.MAIN_KEY_WNSSETTINGS, QzoneConfig.SECONDARY_IP_NO_PMTU_DISC, 1).intValue();
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String getPhotoBakUrl() {
        if (uq3.c.X0("qqcircle", "secondary_key_circle_use_new_circle_domain", 1).intValue() == 1) {
            return uq3.c.a1("PhotoSvrList", "Circle_BackupIP_PICUP");
        }
        return uq3.c.a1("PhotoSvrList", QzoneConfig.SECONDARY_IMAGE_UPLOAD_BAK_IP);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String getPhotoHostUrl() {
        if (uq3.c.X0("qqcircle", "secondary_key_circle_use_new_circle_domain", 1).intValue() == 1) {
            return uq3.c.b1("PhotoSvrList", "CirclePhotoURL_UP", "circlepic.upqzfile.com");
        }
        return uq3.c.b1("PhotoSvrList", QzoneConfig.SECONDARY_IMAGE_UPLOAD_HOST_IP, UploadSdkConst.DEFAULT_PIC_HOST);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String getPhotoHostUrlV6() {
        if (uq3.c.X0("qqcircle", "secondary_key_circle_use_new_circle_domain", 1).intValue() == 1) {
            return uq3.c.b1("PhotoSvrList", "CirclePhotoURL_UP_V6", "v6.circlepic.upqzfile.com");
        }
        return uq3.c.b1("PhotoSvrList", QzoneConfig.SECONDARY_IMAGE_UPLOAD_HOST_IP_V6, "v6.pic.upqzfile.com");
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String getPhotoOptUrl() {
        if (uq3.c.X0("qqcircle", "secondary_key_circle_use_new_circle_domain", 1).intValue() == 1) {
            return uq3.c.a1("PhotoSvrList", "Circle_OptimumIP_PICUP");
        }
        return uq3.c.a1("PhotoSvrList", QzoneConfig.SECONDARY_IMAGE_UPLOAD_OPT_IP);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String getPhotoOptUrlV6() {
        if (uq3.c.X0("qqcircle", "secondary_key_circle_use_new_circle_domain", 1).intValue() == 1) {
            return uq3.c.a1("PhotoSvrList", "Circle_OptimumIP_PICUPV6");
        }
        return uq3.c.a1("PhotoSvrList", QzoneConfig.SECONDARY_IMAGE_UPLOAD_OPT_IP_V6);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String getVideoBakUrl() {
        if (uq3.c.X0("qqcircle", "secondary_key_circle_use_new_circle_domain", 1).intValue() == 1) {
            return uq3.c.a1("PhotoSvrList", "Circle_BackupIP_VIDEOUP");
        }
        return uq3.c.a1("PhotoSvrList", QzoneConfig.SECONDARY_VIDEO_UPLOAD_BAK_IP);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String getVideoHostUrl() {
        if (uq3.c.X0("qqcircle", "secondary_key_circle_use_new_circle_domain", 1).intValue() == 1) {
            return uq3.c.b1("PhotoSvrList", "CircleVideoURL_UP", "circlevideo.upqzfile.com");
        }
        return uq3.c.b1("PhotoSvrList", QzoneConfig.SECONDARY_VIDEO_UPLOAD_HOST_IP, UploadSdkConst.DEFAULT_VIDEO_HOST);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String getVideoHostUrlV6() {
        if (uq3.c.X0("qqcircle", "secondary_key_circle_use_new_circle_domain", 1).intValue() == 1) {
            return uq3.c.b1("PhotoSvrList", "CircleVideoURL_UP_V6", "v6.circlevideo.upqzfile.com");
        }
        return uq3.c.b1("PhotoSvrList", QzoneConfig.SECONDARY_VIDEO_UPLOAD_HOST_IP_V6, "v6.video.upqzfile.com");
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String getVideoOptUrl() {
        if (uq3.c.X0("qqcircle", "secondary_key_circle_use_new_circle_domain", 1).intValue() == 1) {
            return uq3.c.a1("PhotoSvrList", "Circle_OptimumIP_VIDEOUP");
        }
        return uq3.c.a1("PhotoSvrList", QzoneConfig.SECONDARY_VIDEO_UPLOAD_OPT_IP);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String getVideoOptUrlV6() {
        if (uq3.c.X0("qqcircle", "secondary_key_circle_use_new_circle_domain", 1).intValue() == 1) {
            return uq3.c.a1("PhotoSvrList", "Circle_OptimumIP_VIDEOUPV6");
        }
        return uq3.c.a1("PhotoSvrList", QzoneConfig.SECONDARY_VIDEO_UPLOAD_OPT_IP_V6);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public int getWifiOperator() {
        return uq3.c.X0(QzoneConfig.MAIN_KEY_EXTRA_CONFIG, QzoneConfig.SECONDARY_WIFI_OPERATOR_CRARRY, 0).intValue();
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public boolean isNeedReleasePool() {
        return uq3.c.X0("qqcircle", "secondary_key_circle_release_pool_switch", 0).intValue() == 1;
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public int getGifUploadLimit(int i3) {
        if (i3 == 1) {
            return uq3.c.X0("PhotoUpload", QzoneConfig.SECONDARY_GIF_UPLOAD_LIMIT_WIFI, 5242880).intValue();
        }
        if (i3 == 2) {
            return uq3.c.X0("PhotoUpload", QzoneConfig.SECONDARY_GIF_UPLOAD_LIMIT_3G, 2097152).intValue();
        }
        if (i3 == 3) {
            return uq3.c.X0("PhotoUpload", QzoneConfig.SECONDARY_GIF_UPLOAD_LIMIT_2G, 819200).intValue();
        }
        if (i3 != 6) {
            return 0;
        }
        return uq3.c.X0("PhotoUpload", QzoneConfig.SECONDARY_GIF_UPLOAD_LIMIT_4G, 5242880).intValue();
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public long getRecentRouteExpire() {
        return uq3.c.Z0("qqcircle", "secondary_key_circle_recent_route_expire", 7200000L).longValue();
    }
}
