package com.qzone.publish.business.protocol;

import FileUpload.PicExtendInfo;
import NS_MOBILE_OPERATION.LbsInfo;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.qzone.album.data.model.PhotoCacheData;
import com.qzone.common.account.LoginData;
import com.qzone.common.protocol.request.QZoneRequest;
import com.qzone.reborn.util.d;
import com.qzone.util.image.b;
import com.qzone.video.service.QzoneVideoUploadActionReport;
import com.tencent.biz.richframework.util.RFWFileUtils;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.mobileqq.winkpublish.publishconst.FSUploadConst;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.UploadServiceBuilder;
import com.tencent.upload.uinterface.data.ImageUploadTask;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.model.GpsInfo4LocalImage;
import cooperation.qzone.model.LocalImageShootInfo;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import r7.c;

/* compiled from: P */
/* loaded from: classes39.dex */
public abstract class QzoneUploadRequest extends QZoneRequest implements y8.a {
    public String mBusinessRefer;
    public String mTaskState;

    public QzoneUploadRequest() {
    }

    private void printFileAndDeviceInfo(String str, File file) {
        try {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(this.TAG);
            sb5.append(" checkValidValue  | filepath:");
            sb5.append(str);
            sb5.append(" | fileExist:");
            sb5.append(file.exists());
            sb5.append(" | fileLen:");
            sb5.append(file.length());
            sb5.append(" | readPermission:");
            sb5.append(ContextCompat.checkSelfPermission(BaseApplication.context, QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE));
            sb5.append(" | writePermission:");
            sb5.append(ContextCompat.checkSelfPermission(BaseApplication.context, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE));
            sb5.append(" | uriFileExists:");
            sb5.append(RFWFileUtils.uriFileExist("file://" + str));
            sb5.append(" | availableMemorySize:");
            sb5.append(d.b());
            QZLog.w(QZLog.PUBLISH_QUEUE_TAG, sb5.toString());
        } catch (Exception e16) {
            QZLog.w(QZLog.PUBLISH_QUEUE_TAG, this.TAG + "printFileAndDeviceInfo e = " + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void appendPhotoShootParamsByExif(ImageUploadTask imageUploadTask) {
        LocalImageShootInfo createFrom;
        String format;
        if (imageUploadTask.stExtendInfo.mapParams == null || (createFrom = LocalImageShootInfo.createFrom(imageUploadTask.uploadFilePath)) == null) {
            return;
        }
        LbsInfo parceToLbsInfo = LbsDataV2.parceToLbsInfo(createFrom);
        if (parceToLbsInfo != null) {
            String str = parceToLbsInfo.lbs_x;
            if (str != null) {
                imageUploadTask.stExtendInfo.mapParams.put("geo_x", String.valueOf(str));
            }
            String str2 = parceToLbsInfo.lbs_y;
            if (str2 != null) {
                imageUploadTask.stExtendInfo.mapParams.put("geo_y", String.valueOf(str2));
            }
        }
        if (createFrom.captureTime > 0) {
            try {
                format = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss").format(new Date(createFrom.captureTime));
            } catch (Exception unused) {
            }
            if (format == null) {
                imageUploadTask.stExtendInfo.mapParams.put("Exif_Time", format);
                return;
            }
            return;
        }
        format = "";
        if (format == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String appendShootTime(b bVar, long j3) {
        String format;
        String attribute = bVar.getAttribute("DateTime");
        if (attribute == null) {
            String valueOf = String.valueOf(j3);
            if (QZLog.isColorLevel()) {
                QZLog.d(this.TAG, 2, "exif is null, get lastModifyTime:" + j3);
            }
            if (valueOf.equals("0") || (format = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss").format(new Date(Long.parseLong(valueOf)))) == null) {
                return "";
            }
            if (QZLog.isColorLevel()) {
                QZLog.d(this.TAG, 2, "dateString:" + format);
            }
            return format;
        }
        if (QZLog.isColorLevel()) {
            QZLog.d(this.TAG, 2, "exif :" + attribute);
        }
        return attribute;
    }

    public boolean cancel() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int checkValidValue(AbstractUploadTask abstractUploadTask) {
        String str = abstractUploadTask.uploadFilePath;
        if (TextUtils.isEmpty(str)) {
            QZLog.w(QZLog.PUBLISH_QUEUE_TAG, this.TAG + "file length:0");
            return FSUploadConst.ERR_FILE_NOT_EXIST;
        }
        File file = new File(str);
        if (file.exists() && file.length() != 0 && !file.isDirectory()) {
            return 0;
        }
        printFileAndDeviceInfo(str, file);
        return FSUploadConst.ERR_FILE_NOT_EXIST;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String createFileMD5(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return SecUtil.getFileMd5(str);
    }

    public abstract /* synthetic */ String getFlowMessage();

    /* JADX INFO: Access modifiers changed from: protected */
    public GpsInfo4LocalImage getGpsInfoForVideo(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        GpsInfo4LocalImage gpsInfoForVideo = LocalImageShootInfo.getGpsInfoForVideo(mediaMetadataRetriever, str);
        mediaMetadataRetriever.release();
        return gpsInfoForVideo;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return "null";
    }

    public abstract void upload(byte[] bArr);

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean validAndUpload(AbstractUploadTask abstractUploadTask) {
        byte[] bArr;
        if (LoginData.getInstance().getA2Bytes() != null && (bArr = abstractUploadTask.vLoginData) != null && bArr.length != 0) {
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(this.mTaskState)) {
                hashMap.put("task_state", this.mTaskState);
            }
            String refer = getRefer();
            this.mBusinessRefer = refer;
            if (!TextUtils.isEmpty(refer)) {
                hashMap.put(FSUploadConst.KEY_REFER, this.mBusinessRefer);
            }
            if (!TextUtils.isEmpty(this.mBusinessRefer)) {
                abstractUploadTask.uiRefer = this.mBusinessRefer;
            }
            abstractUploadTask.transferData = hashMap;
            if (abstractUploadTask.flowId == 0) {
                abstractUploadTask.flowId = subFlowId(0, abstractUploadTask.getFilePath());
                QZLog.i(QZLog.PUBLISH_QUEUE_TAG, 1, "validAndUpload reset task flowId to " + abstractUploadTask.flowId);
            }
            int checkValidValue = checkValidValue(abstractUploadTask);
            if (checkValidValue != 0) {
                String a16 = c.a(checkValidValue);
                QZLog.w(QZLog.PUBLISH_QUEUE_TAG, this.TAG + " check not pass errMsg:" + a16);
                abstractUploadTask.uploadTaskCallback.onUploadError(abstractUploadTask, checkValidValue, a16);
                return false;
            }
            abstractUploadTask.transferData.put("task_state", FSUploadConst.STATE_RUNNING);
            QZLog.i(QZLog.PUBLISH_QUEUE_TAG, 1, this.TAG + ", submit upload SDK succeed ? : " + UploadServiceBuilder.getInstance().upload(abstractUploadTask) + ", flowId:" + abstractUploadTask.flowId + ", path:" + abstractUploadTask.uploadFilePath);
            return true;
        }
        QZLog.w(QZLog.PUBLISH_QUEUE_TAG, this.TAG + " no login, stop upload");
        QzoneVideoUploadActionReport.b().f("start_upload", FSUploadConst.ERR_NO_LOGIN, "", "not login", "shuoshuoORalbum");
        abstractUploadTask.uploadTaskCallback.onUploadError(abstractUploadTask, FSUploadConst.ERR_NO_LOGIN, c.a(FSUploadConst.ERR_NO_LOGIN));
        return false;
    }

    public QzoneUploadRequest(String str) {
        super(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void appendPhotoShootParams(ImageUploadTask imageUploadTask, Map<String, String> map) {
        if (map != null) {
            if (imageUploadTask.stExtendInfo.mapParams != null) {
                if (map.get("geo_x") != null) {
                    imageUploadTask.stExtendInfo.mapParams.put("geo_x", map.get("geo_x"));
                }
                if (map.get("geo_y") != null) {
                    imageUploadTask.stExtendInfo.mapParams.put("geo_y", map.get("geo_y"));
                }
                if (map.get("geo_id") != null) {
                    imageUploadTask.stExtendInfo.mapParams.put("geo_id", map.get("geo_id"));
                }
                if (map.get("geo_idname") != null) {
                    imageUploadTask.stExtendInfo.mapParams.put("geo_idname", map.get("geo_idname"));
                }
                if (map.get("geo_name") != null) {
                    imageUploadTask.stExtendInfo.mapParams.put("geo_name", map.get("geo_name"));
                }
                if (map.get(PhotoCacheData.SHOOTTIME) != null) {
                    imageUploadTask.stExtendInfo.mapParams.put("Exif_Time", map.get(PhotoCacheData.SHOOTTIME));
                }
            }
            if (imageUploadTask.stExternalMapExt == null) {
                imageUploadTask.stExternalMapExt = new HashMap<>();
            }
            if (map.get("jump_type") != null) {
                imageUploadTask.stExternalMapExt.put("jump_type", map.get("jump_type"));
            }
            if (map.get("jump_id") != null) {
                imageUploadTask.stExternalMapExt.put("jump_id", map.get("jump_id"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void appendVideoGeoToCover(ImageUploadTask imageUploadTask, GpsInfo4LocalImage gpsInfo4LocalImage) {
        PicExtendInfo picExtendInfo;
        Map<String, String> map;
        if (imageUploadTask == null || (picExtendInfo = imageUploadTask.stExtendInfo) == null || (map = picExtendInfo.mapParams) == null || gpsInfo4LocalImage == null) {
            return;
        }
        map.put("geo_x", String.valueOf(gpsInfo4LocalImage.longtitude));
        imageUploadTask.stExtendInfo.mapParams.put("geo_y", String.valueOf(gpsInfo4LocalImage.latitude));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void appendVideoShootTimeToCover(ImageUploadTask imageUploadTask, String str) {
        PicExtendInfo picExtendInfo;
        String format;
        if (imageUploadTask == null || (picExtendInfo = imageUploadTask.stExtendInfo) == null || picExtendInfo.mapParams == null) {
            return;
        }
        long lastModified = new File(str).lastModified();
        if (lastModified > 0) {
            try {
                format = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss").format(new Date(lastModified));
            } catch (Exception unused) {
            }
            if (format == null) {
                imageUploadTask.stExtendInfo.mapParams.put("Exif_Time", format);
                return;
            }
            return;
        }
        format = "";
        if (format == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int subFlowId(int i3, String str) {
        if (str == null) {
            str = "";
        }
        return i3 + (str + String.valueOf(i3)).hashCode();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String appendShootTime(b bVar, String str) {
        String format;
        String attribute = bVar.getAttribute("DateTime");
        if (attribute == null) {
            String valueOf = String.valueOf(new File(str).lastModified());
            if (QZLog.isColorLevel()) {
                QZLog.d(this.TAG, 2, "exif is null, get dateString:" + valueOf);
            }
            if (valueOf.equals("0") || (format = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss").format(new Date(Long.parseLong(valueOf)))) == null) {
                return "";
            }
            if (QZLog.isColorLevel()) {
                QZLog.d(this.TAG, 2, "dateString:" + format);
            }
            return format;
        }
        if (QZLog.isColorLevel()) {
            QZLog.d(this.TAG, 2, "exif :" + attribute);
        }
        return attribute;
    }
}
