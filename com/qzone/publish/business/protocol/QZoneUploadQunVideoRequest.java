package com.qzone.publish.business.protocol;

import FileUpload.UploadVideoInfoRsp;
import com.qq.jce.wup.UniAttribute;
import com.qzone.common.account.LoginData;
import com.qzone.common.protocol.request.QZoneRequest;
import com.qzone.publish.business.model.UploadVideoObject;
import com.qzone.publish.business.process.base.QZoneProcessType;
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
public class QZoneUploadQunVideoRequest extends QzoneUploadRequest {
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
    public class QunVideoUploadTask extends VideoUploadTask {
        public QunVideoUploadTask(String str) {
            super(str);
            this.iIsNew = QZoneUploadQunVideoRequest.this.mVideoInfo.getIsNew();
            QZoneUploadQunVideoRequest.this.iBusinessType = 101;
            this.mAppid = "qun_video";
        }

        @Override // com.tencent.upload.uinterface.data.VideoUploadTask, com.tencent.upload.task.UploadTask
        /* renamed from: getUploadTaskType */
        public TaskTypeConfig getMTaskTypeConfig() {
            return new TaskTypeConfig(38, RouteFactory.VIDEO_ROUTE_TABLE);
        }
    }

    public QZoneUploadQunVideoRequest() {
        this.timeStamp = 0L;
        this.mProgressTime = 0L;
        this.callback = new a();
    }

    private void initTaskAdapter(byte[] bArr) {
        QunVideoUploadTask qunVideoUploadTask = new QunVideoUploadTask(this.mVideoInfo.getFilePath());
        this.mVideoUploadTask = qunVideoUploadTask;
        UploadVideoObject uploadVideoObject = this.mVideoInfo;
        qunVideoUploadTask.flowId = subFlowId((int) this.batchId, uploadVideoObject.getFilePath());
        qunVideoUploadTask.iUin = LoginData.getInstance().getUin();
        qunVideoUploadTask.sRefer = "mqq";
        qunVideoUploadTask.vLoginData = bArr;
        qunVideoUploadTask.uploadFilePath = uploadVideoObject.getFilePath();
        qunVideoUploadTask.md5 = uploadVideoObject.getFileMd5();
        qunVideoUploadTask.sTitle = uploadVideoObject.getTitle();
        qunVideoUploadTask.sDesc = uploadVideoObject.getDesc();
        qunVideoUploadTask.iFlag = uploadVideoObject.getFlag();
        qunVideoUploadTask.sCoverUrl = uploadVideoObject.getCoverUrl();
        qunVideoUploadTask.iPlayTime = (int) uploadVideoObject.getDuration();
        qunVideoUploadTask.iUploadTime = this.timeStamp;
        qunVideoUploadTask.uploadTaskCallback = this.callback;
        qunVideoUploadTask.iBusiNessType = this.iBusinessType;
        qunVideoUploadTask.vBusiNessData = this.vdata;
        qunVideoUploadTask.iIsOriginalVideo = uploadVideoObject.getIsUploadOrigin();
        qunVideoUploadTask.iIsFormatF20 = uploadVideoObject.getHasCompressed();
        qunVideoUploadTask.uploadEntrance = this.uploadEntrance;
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
        this.mListner.onProtocolResponse(QZoneProcessType.PROCESS_TYPE_UPLOAD, uniAttribute, i3, i3, str, false);
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
            if (((QZoneRequest) QZoneUploadQunVideoRequest.this).mUploadQueueListener != null) {
                ((QZoneRequest) QZoneUploadQunVideoRequest.this).mUploadQueueListener.onUploadError(abstractUploadTask, i3, str);
            }
            QZoneUploadQunVideoRequest.this.sendResponse(i3, null, str);
        }

        @Override // com.tencent.upload.uinterface.IUploadTaskCallback
        public void onUploadProgress(AbstractUploadTask abstractUploadTask, long j3, long j16) {
            long currentTimeMillis = System.currentTimeMillis();
            if (((QZoneRequest) QZoneUploadQunVideoRequest.this).mUploadQueueListener != null) {
                ((QZoneRequest) QZoneUploadQunVideoRequest.this).mUploadQueueListener.onUpdateDataSize(j16 / 1024, j3 / 1024);
                if (((QZoneRequest) QZoneUploadQunVideoRequest.this).mUploadQueueListener.getState() != 1) {
                    ((QZoneRequest) QZoneUploadQunVideoRequest.this).mUploadQueueListener.onStateChanged(1);
                }
            }
            if (j16 == j3) {
                QZoneUploadQunVideoRequest.this.mProgressTime = 0L;
                currentTimeMillis = 0;
            }
            if (currentTimeMillis - QZoneUploadQunVideoRequest.this.mProgressTime < 200) {
                int i3 = (QZoneUploadQunVideoRequest.this.mProgressTime > 0L ? 1 : (QZoneUploadQunVideoRequest.this.mProgressTime == 0L ? 0 : -1));
            }
            QZLog.i(QZLog.PUBLISH_QUEUE_TAG, 1, "uploading shuoshuo Video {" + QZoneUploadQunVideoRequest.this.mVideoInfo.getFilePath() + "} recvDataSize : " + j16 + " totalSize : " + j3);
        }

        @Override // com.tencent.upload.uinterface.IUploadTaskCallback
        public void onUploadStateChange(AbstractUploadTask abstractUploadTask, int i3) {
            QZLog.i(QZLog.PUBLISH_QUEUE_TAG, 1, "OnUploadCallback.onUploadStateChange. " + i3);
            if (((QZoneRequest) QZoneUploadQunVideoRequest.this).mUploadQueueListener == null || ((QZoneRequest) QZoneUploadQunVideoRequest.this).mUploadQueueListener.getState() == i3) {
                return;
            }
            ((QZoneRequest) QZoneUploadQunVideoRequest.this).mUploadQueueListener.onStateChanged(i3);
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
            QZoneUploadQunVideoRequest.this.sendResponse(0, uploadVideoInfoRsp, "");
        }
    }

    public QZoneUploadQunVideoRequest(UploadVideoObject uploadVideoObject, long j3, long j16, int i3, byte[] bArr, String str, String str2, int i16) {
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
