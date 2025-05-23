package com.qzone.publish.business.protocol;

import com.qzone.common.account.LoginData;
import com.tencent.upload.uinterface.IUploadTaskCallback;
import com.tencent.upload.uinterface.UploadServiceBuilder;
import com.tencent.upload.uinterface.data.PhotoWallUploadTask;

/* loaded from: classes39.dex */
public class QzonePhotoWallUploadRequest extends QzoneUploadRequest {
    private PhotoWallUploadTask mTaskAdapter;

    private void initTaskAdapter(String str, int i3, IUploadTaskCallback iUploadTaskCallback) {
        PhotoWallUploadTask photoWallUploadTask = new PhotoWallUploadTask(str);
        photoWallUploadTask.flowId = ((int) System.currentTimeMillis()) / 1000;
        photoWallUploadTask.sRefer = "mqq";
        photoWallUploadTask.iUin = LoginData.getInstance().getUin();
        photoWallUploadTask.vLoginData = LoginData.getInstance().getA2Bytes();
        photoWallUploadTask.f383923op = 1;
        photoWallUploadTask.source = i3;
        photoWallUploadTask.uploadTaskCallback = iUploadTaskCallback;
        photoWallUploadTask.uploadFilePath = str;
        photoWallUploadTask.md5 = createFileMD5(str);
        photoWallUploadTask.autoRotate = true;
        this.mTaskAdapter = photoWallUploadTask;
    }

    @Override // com.qzone.publish.business.protocol.QzoneUploadRequest
    public boolean cancel() {
        if (this.mTaskAdapter != null) {
            return UploadServiceBuilder.getInstance().cancel(this.mTaskAdapter);
        }
        return false;
    }

    @Override // com.qzone.publish.business.protocol.QzoneUploadRequest, y8.a
    public String getFlowMessage() {
        PhotoWallUploadTask photoWallUploadTask = this.mTaskAdapter;
        if (photoWallUploadTask == null) {
            return "";
        }
        return photoWallUploadTask.getFlowMessage();
    }

    public boolean retry() {
        PhotoWallUploadTask photoWallUploadTask = this.mTaskAdapter;
        if (photoWallUploadTask == null) {
            return false;
        }
        validAndUpload(photoWallUploadTask);
        return true;
    }

    @Override // com.qzone.publish.business.protocol.QzoneUploadRequest
    public void upload(byte[] bArr) {
    }

    public QzonePhotoWallUploadRequest() {
        super(null);
    }

    public void upload(String str, int i3, IUploadTaskCallback iUploadTaskCallback) {
        initTaskAdapter(str, i3, iUploadTaskCallback);
        validAndUpload(this.mTaskAdapter);
    }
}
