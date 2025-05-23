package com.qzone.album.protocol;

import FileUpload.PicExtendInfo;
import com.qzone.common.account.LoginData;
import com.qzone.publish.business.protocol.QZoneUploadPicRequest;
import com.qzone.publish.business.protocol.QzoneUploadRequest;
import com.qzone.publish.business.publishqueue.h;
import com.qzone.publish.business.task.intimate.QZoneImageUploadTask;
import com.qzone.util.image.b;
import com.tencent.image.JpegExifReader;
import com.tencent.upload.uinterface.IUploadTaskCallback;
import com.tencent.upload.uinterface.data.ImageUploadTask;
import cooperation.qzone.util.QZLog;
import java.util.UUID;
import r7.a;

/* loaded from: classes39.dex */
public class QZoneUploadFirstDynamicPhotoRequest extends QzoneUploadRequest {
    private String mFirstPhotoPath;
    private int mTarget;
    private ImageUploadTask mUploadTask;
    private IUploadTaskCallback mUploadTaskCallback;
    private long uploadTime = 0;
    private long batchId = a.a();

    public QZoneUploadFirstDynamicPhotoRequest(int i3, String str, IUploadTaskCallback iUploadTaskCallback) {
        this.mTarget = i3;
        this.mFirstPhotoPath = str;
        this.mUploadTaskCallback = iUploadTaskCallback;
    }

    private ImageUploadTask initImageTaskAdapter(byte[] bArr, String str) {
        String uuid = UUID.randomUUID().toString();
        QZoneImageUploadTask qZoneImageUploadTask = new QZoneImageUploadTask(false, str, uuid);
        qZoneImageUploadTask.iUin = LoginData.getInstance().getUin();
        qZoneImageUploadTask.sRefer = "mqq";
        qZoneImageUploadTask.vLoginData = bArr;
        qZoneImageUploadTask.uploadFilePath = str;
        qZoneImageUploadTask.md5 = createFileMD5(str);
        qZoneImageUploadTask.iSync = 0;
        qZoneImageUploadTask.sAlbumName = "";
        qZoneImageUploadTask.sPicTitle = "";
        qZoneImageUploadTask.sPicDesc = "";
        qZoneImageUploadTask.bWaterType = false;
        qZoneImageUploadTask.autoRotate = true;
        qZoneImageUploadTask.clientFakeKey = uuid;
        qZoneImageUploadTask.preupload = 0;
        qZoneImageUploadTask.iBusiNessType = 2;
        qZoneImageUploadTask.sAlbumID = "";
        qZoneImageUploadTask.iAlbumTypeID = 7;
        qZoneImageUploadTask.iDistinctUse = QZoneUploadPicRequest.SHUOSHUO_SRC;
        qZoneImageUploadTask.iUploadType = 0;
        qZoneImageUploadTask.iUpPicType = 1;
        long j3 = this.batchId;
        qZoneImageUploadTask.iBatchID = j3;
        qZoneImageUploadTask.iUploadTime = this.uploadTime;
        qZoneImageUploadTask.flowId = subFlowId((int) j3, str);
        if (qZoneImageUploadTask.stExtendInfo == null) {
            qZoneImageUploadTask.stExtendInfo = new PicExtendInfo();
        }
        try {
            if (!JpegExifReader.isCrashJpeg(qZoneImageUploadTask.uploadFilePath)) {
                b bVar = new b(qZoneImageUploadTask.uploadFilePath);
                qZoneImageUploadTask.stExtendInfo.mapExif = com.qzone.util.image.a.b(bVar);
                qZoneImageUploadTask.exifTime = appendShootTime(bVar, str);
            }
        } catch (Exception unused) {
            QZLog.e(QZLog.TO_DEVICE_TAG, "read pic exif error");
        }
        appendPhotoShootParamsByExif(qZoneImageUploadTask);
        qZoneImageUploadTask.uploadTaskCallback = this.mUploadTaskCallback;
        qZoneImageUploadTask.uploadEntrance = 34;
        return qZoneImageUploadTask;
    }

    @Override // com.qzone.publish.business.protocol.QzoneUploadRequest, y8.a
    public String getFlowMessage() {
        ImageUploadTask imageUploadTask = this.mUploadTask;
        if (imageUploadTask == null) {
            return "";
        }
        return imageUploadTask.getFlowMessage();
    }

    @Override // com.qzone.publish.business.protocol.QzoneUploadRequest
    public void upload(byte[] bArr) {
        if (this.uploadTime == 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            this.uploadTime = currentTimeMillis;
            h.i(this.batchId, currentTimeMillis);
            QZLog.i("UploadTaskBatchUtil", " -- saveBatchUploadTime:" + this.uploadTime);
        }
        ImageUploadTask initImageTaskAdapter = initImageTaskAdapter(bArr, this.mFirstPhotoPath);
        this.mUploadTask = initImageTaskAdapter;
        validAndUpload(initImageTaskAdapter);
    }
}
