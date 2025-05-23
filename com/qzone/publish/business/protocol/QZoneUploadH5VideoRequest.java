package com.qzone.publish.business.protocol;

import FileUpload.UploadVideoInfoRsp;
import com.qq.jce.wup.UniAttribute;
import com.qzone.common.account.LoginData;
import com.qzone.common.protocol.request.QZoneRequest;
import com.qzone.publish.business.model.UploadVideoObject;
import com.tencent.upload.network.route.RouteFactory;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadTaskCallback;
import com.tencent.upload.uinterface.TaskTypeConfig;
import com.tencent.upload.uinterface.UploadServiceBuilder;
import com.tencent.upload.uinterface.data.VideoUploadResult;
import com.tencent.upload.uinterface.data.VideoUploadTask;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneUploadH5VideoRequest extends QzoneUploadRequest {
    private static final String TAG = "QZoneUploadH5VideoRequest";
    private long batchId;
    private IUploadTaskCallback callback;
    private int iBusinessType;
    private long mProgressTime;
    private UploadVideoObject mVideoInfo;
    private VideoUploadTask mVideoUploadTask;
    private long timeStamp;
    private int uploadEntrance;
    private byte[] vdata;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class H5VideoUploadTask extends VideoUploadTask {
        public H5VideoUploadTask(String str) {
            super(str);
            this.iIsNew = QZoneUploadH5VideoRequest.this.mVideoInfo.getIsNew();
            QZoneUploadH5VideoRequest.this.iBusinessType = 101;
        }

        @Override // com.tencent.upload.uinterface.data.VideoUploadTask, com.tencent.upload.task.UploadTask
        /* renamed from: getUploadTaskType */
        public TaskTypeConfig getMTaskTypeConfig() {
            return new TaskTypeConfig(38, RouteFactory.VIDEO_ROUTE_TABLE);
        }
    }

    public QZoneUploadH5VideoRequest() {
        this.timeStamp = 0L;
        this.mProgressTime = 0L;
        this.callback = new a();
    }

    private void initTaskAdapter(byte[] bArr) {
        H5VideoUploadTask h5VideoUploadTask = new H5VideoUploadTask(this.mVideoInfo.getFilePath());
        this.mVideoUploadTask = h5VideoUploadTask;
        UploadVideoObject uploadVideoObject = this.mVideoInfo;
        h5VideoUploadTask.flowId = subFlowId((int) this.batchId, uploadVideoObject.getFilePath());
        h5VideoUploadTask.iUin = LoginData.getInstance().getUin();
        h5VideoUploadTask.sRefer = "mqq";
        h5VideoUploadTask.vLoginData = bArr;
        h5VideoUploadTask.uploadFilePath = uploadVideoObject.getFilePath();
        h5VideoUploadTask.md5 = uploadVideoObject.getFileMd5();
        h5VideoUploadTask.sTitle = uploadVideoObject.getTitle();
        h5VideoUploadTask.sDesc = uploadVideoObject.getDesc();
        h5VideoUploadTask.iFlag = uploadVideoObject.getFlag();
        h5VideoUploadTask.sCoverUrl = uploadVideoObject.getCoverUrl();
        h5VideoUploadTask.iPlayTime = (int) uploadVideoObject.getDuration();
        h5VideoUploadTask.iUploadTime = this.timeStamp;
        h5VideoUploadTask.uploadTaskCallback = this.callback;
        h5VideoUploadTask.iBusiNessType = this.iBusinessType;
        h5VideoUploadTask.vBusiNessData = this.vdata;
        h5VideoUploadTask.iIsOriginalVideo = uploadVideoObject.getIsUploadOrigin();
        h5VideoUploadTask.iIsFormatF20 = uploadVideoObject.getHasCompressed();
        h5VideoUploadTask.uploadEntrance = this.uploadEntrance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendResponse(int i3, UploadVideoInfoRsp uploadVideoInfoRsp, String str) {
        String str2;
        UniAttribute uniAttribute = new UniAttribute();
        uniAttribute.setEncodeName("utf8");
        uniAttribute.put("ReplyCode", Integer.valueOf(i3 == 0 ? 0 : -1));
        if (i3 == 0) {
            str2 = "success";
        } else {
            str2 = "fail";
        }
        uniAttribute.put("StrResult", str2);
        if (uploadVideoInfoRsp != null) {
            uniAttribute.put("response", uploadVideoInfoRsp);
        }
        this.mListner.onProtocolResponse(uniAttribute, i3, i3, str, false);
    }

    @Override // com.qzone.publish.business.protocol.QzoneUploadRequest
    public boolean cancel() {
        if (this.mVideoUploadTask != null) {
            return UploadServiceBuilder.getInstance().cancel(this.mVideoUploadTask);
        }
        return false;
    }

    public IUploadTaskCallback getCallback() {
        return this.callback;
    }

    @Override // com.qzone.publish.business.protocol.QzoneUploadRequest, y8.a
    public String getFlowMessage() {
        VideoUploadTask videoUploadTask = this.mVideoUploadTask;
        if (videoUploadTask == null) {
            return "";
        }
        return videoUploadTask.getFlowMessage();
    }

    public void setCallback(IUploadTaskCallback iUploadTaskCallback) {
        this.callback = iUploadTaskCallback;
    }

    @Override // com.qzone.publish.business.protocol.QzoneUploadRequest
    public void upload(byte[] bArr) {
        initTaskAdapter(bArr);
        validAndUpload(this.mVideoUploadTask);
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements IUploadTaskCallback {
        a() {
        }

        @Override // com.tencent.upload.uinterface.IUploadTaskCallback
        public void onUploadError(AbstractUploadTask abstractUploadTask, int i3, String str) {
            QZLog.e(QZLog.TO_DEVICE_TAG, "OnUploadCallback.onUploadError errorCode=" + i3 + " errorMsg=" + str + "type:" + abstractUploadTask.getMTaskTypeConfig());
            if (((QZoneRequest) QZoneUploadH5VideoRequest.this).mUploadQueueListener != null) {
                ((QZoneRequest) QZoneUploadH5VideoRequest.this).mUploadQueueListener.onUploadError(abstractUploadTask, i3, str);
            }
            QZoneUploadH5VideoRequest.this.sendResponse(i3, null, str);
        }

        @Override // com.tencent.upload.uinterface.IUploadTaskCallback
        public void onUploadProgress(AbstractUploadTask abstractUploadTask, long j3, long j16) {
            long currentTimeMillis = System.currentTimeMillis();
            if (((QZoneRequest) QZoneUploadH5VideoRequest.this).mUploadQueueListener != null) {
                ((QZoneRequest) QZoneUploadH5VideoRequest.this).mUploadQueueListener.onUpdateDataSize(j16 / 1024, j3 / 1024);
                if (((QZoneRequest) QZoneUploadH5VideoRequest.this).mUploadQueueListener.getState() != 1) {
                    ((QZoneRequest) QZoneUploadH5VideoRequest.this).mUploadQueueListener.onStateChanged(1);
                }
            }
            if (j16 == j3) {
                QZoneUploadH5VideoRequest.this.mProgressTime = 0L;
                currentTimeMillis = 0;
            }
            if (currentTimeMillis - QZoneUploadH5VideoRequest.this.mProgressTime < 200) {
                int i3 = (QZoneUploadH5VideoRequest.this.mProgressTime > 0L ? 1 : (QZoneUploadH5VideoRequest.this.mProgressTime == 0L ? 0 : -1));
            }
            QZLog.i(QZLog.PUBLISH_QUEUE_TAG, 1, "uploading shuoshuo Video {" + QZoneUploadH5VideoRequest.this.mVideoInfo.getFilePath() + "} recvDataSize : " + j16 + " totalSize : " + j3);
        }

        @Override // com.tencent.upload.uinterface.IUploadTaskCallback
        public void onUploadStateChange(AbstractUploadTask abstractUploadTask, int i3) {
            QZLog.i(QZLog.PUBLISH_QUEUE_TAG, 1, "OnUploadCallback.onUploadStateChange. " + i3);
            if (((QZoneRequest) QZoneUploadH5VideoRequest.this).mUploadQueueListener == null || ((QZoneRequest) QZoneUploadH5VideoRequest.this).mUploadQueueListener.getState() == i3) {
                return;
            }
            ((QZoneRequest) QZoneUploadH5VideoRequest.this).mUploadQueueListener.onStateChanged(i3);
        }

        @Override // com.tencent.upload.uinterface.IUploadTaskCallback
        public void onUploadSucceed(AbstractUploadTask abstractUploadTask, Object obj) {
            if (obj == null) {
                return;
            }
            VideoUploadResult videoUploadResult = (VideoUploadResult) obj;
            UploadVideoInfoRsp uploadVideoInfoRsp = new UploadVideoInfoRsp();
            uploadVideoInfoRsp.iBusiNessType = videoUploadResult.iBusiNessType;
            uploadVideoInfoRsp.sVid = videoUploadResult.sVid;
            uploadVideoInfoRsp.vBusiNessData = videoUploadResult.vBusiNessData;
            QZLog.i(QZLog.PUBLISH_QUEUE_TAG, 1, "OnUploadCallback.onUploadSucceed(" + obj.toString() + ")");
            QZoneUploadH5VideoRequest.this.sendResponse(0, uploadVideoInfoRsp, "");
        }
    }

    public QZoneUploadH5VideoRequest(UploadVideoObject uploadVideoObject, long j3, long j16, int i3, byte[] bArr, String str, String str2, int i16) {
        super(null);
        this.timeStamp = 0L;
        this.mProgressTime = 0L;
        this.callback = new a();
        this.mVideoInfo = uploadVideoObject;
        this.timeStamp = j3;
        this.batchId = j16;
        this.mBusinessRefer = str;
        this.mTaskState = str2;
        this.iBusinessType = i3;
        this.vdata = bArr;
        this.uploadEntrance = i16;
    }
}
