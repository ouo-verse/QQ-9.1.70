package com.qzone.publish.business.protocol;

import FileUpload.UploadUpsInfoRsp;
import com.qq.jce.wup.UniAttribute;
import com.qzone.common.account.LoginData;
import com.qzone.common.protocol.request.QZoneRequest;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadTaskCallback;
import com.tencent.upload.uinterface.UploadServiceBuilder;
import com.tencent.upload.uinterface.data.UpsImageUploadResult;
import com.tencent.upload.uinterface.data.UpsImageUploadTask;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneUploadUpsInfoRequest extends QzoneUploadRequest {
    private String aPhotoFilePath;
    private boolean isKeepRaw;
    private boolean isNeedHD;
    private long mStartTime;
    public UpsImageUploadTask mTaskAdapter;
    private String path;
    private String realFileName;
    private String sBusinessId;
    private int uploadType;
    private byte[] vData;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements IUploadTaskCallback {
        a() {
        }

        @Override // com.tencent.upload.uinterface.IUploadTaskCallback
        public void onUploadError(AbstractUploadTask abstractUploadTask, int i3, String str) {
            QZLog.i(QZLog.PUBLISH_QUEUE_TAG, 1, "OnUploadCallback.onUploadError upload pic retCode:" + i3 + " msg:" + str);
            if (str == null) {
                str = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "UploadFail", "\u4e0a\u4f20\u5931\u8d25");
            }
            QZoneUploadUpsInfoRequest.this.sendResponse(i3, null, str);
            if (((QZoneRequest) QZoneUploadUpsInfoRequest.this).mUploadQueueListener != null) {
                ((QZoneRequest) QZoneUploadUpsInfoRequest.this).mUploadQueueListener.onUploadError(abstractUploadTask, i3, str);
            }
        }

        @Override // com.tencent.upload.uinterface.IUploadTaskCallback
        public void onUploadProgress(AbstractUploadTask abstractUploadTask, long j3, long j16) {
            if (((QZoneRequest) QZoneUploadUpsInfoRequest.this).mUploadQueueListener != null) {
                ((QZoneRequest) QZoneUploadUpsInfoRequest.this).mUploadQueueListener.onUpdateDataSize(j16 / 1024, j3 / 1024);
                if (((QZoneRequest) QZoneUploadUpsInfoRequest.this).mUploadQueueListener.getState() != 1) {
                    ((QZoneRequest) QZoneUploadUpsInfoRequest.this).mUploadQueueListener.onStateChanged(1);
                    ((QZoneRequest) QZoneUploadUpsInfoRequest.this).mUploadQueueListener.setTime(System.currentTimeMillis());
                }
                ((QZoneRequest) QZoneUploadUpsInfoRequest.this).mUploadQueueListener.resetTime();
            }
            if (-1 == QZoneUploadUpsInfoRequest.this.mStartTime) {
                QZoneUploadUpsInfoRequest.this.mStartTime = System.currentTimeMillis();
            }
            QZLog.i(QZLog.PUBLISH_QUEUE_TAG, 1, "upload photo {" + QZoneUploadUpsInfoRequest.this.realFileName + "} recvDataSize : " + j16 + " totalSize : " + j3);
            if (j16 != j3 || j3 == 0) {
                return;
            }
            QZLog.i(QZLog.PUBLISH_QUEUE_TAG, 1, "upload file: {" + QZoneUploadUpsInfoRequest.this.realFileName + "} succeed use time : " + (((float) (System.currentTimeMillis() - QZoneUploadUpsInfoRequest.this.mStartTime)) / 1000.0f) + ReportConstant.COSTREPORT_PREFIX);
        }

        @Override // com.tencent.upload.uinterface.IUploadTaskCallback
        public void onUploadStateChange(AbstractUploadTask abstractUploadTask, int i3) {
            QZLog.i(QZLog.PUBLISH_QUEUE_TAG, 1, "OnUploadCallback.onUploadStateChange upload photo state:" + i3);
            if (((QZoneRequest) QZoneUploadUpsInfoRequest.this).mUploadQueueListener == null || ((QZoneRequest) QZoneUploadUpsInfoRequest.this).mUploadQueueListener.getState() == i3) {
                return;
            }
            ((QZoneRequest) QZoneUploadUpsInfoRequest.this).mUploadQueueListener.onStateChanged(i3);
        }

        @Override // com.tencent.upload.uinterface.IUploadTaskCallback
        public void onUploadSucceed(AbstractUploadTask abstractUploadTask, Object obj) {
            QZLog.i(QZLog.PUBLISH_QUEUE_TAG, 1, "OnUploadCallback.onUploadSucceed(upload photo)");
            UpsImageUploadResult upsImageUploadResult = (UpsImageUploadResult) obj;
            if (upsImageUploadResult != null) {
                QZoneUploadUpsInfoRequest.this.sendResponse(0, upsImageUploadResult, "");
                if (((QZoneRequest) QZoneUploadUpsInfoRequest.this).mUploadQueueListener != null) {
                    ((QZoneRequest) QZoneUploadUpsInfoRequest.this).mUploadQueueListener.onUploadSucceed(obj);
                }
            }
        }
    }

    public QZoneUploadUpsInfoRequest() {
        this.mStartTime = -1L;
        this.realFileName = "";
    }

    private String generateRandomFileID(String str) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(LoginData.getInstance().getUin());
        sb5.append(System.currentTimeMillis());
        return sb5.toString();
    }

    private void initTaskAdapter(byte[] bArr) {
        UpsImageUploadTask upsImageUploadTask = new UpsImageUploadTask(this.aPhotoFilePath);
        this.mTaskAdapter = upsImageUploadTask;
        upsImageUploadTask.iUin = LoginData.getInstance().getUin();
        UpsImageUploadTask upsImageUploadTask2 = this.mTaskAdapter;
        upsImageUploadTask2.sRefer = "mqq";
        upsImageUploadTask2.vLoginData = bArr;
        upsImageUploadTask2.flowId = subFlowId(this.path);
        UpsImageUploadTask upsImageUploadTask3 = this.mTaskAdapter;
        upsImageUploadTask3.keepRaw = this.isKeepRaw ? 1 : 0;
        upsImageUploadTask3.sBusinessId = this.sBusinessId;
        upsImageUploadTask3.iUploadType = this.isNeedHD ? 2 : 0;
        upsImageUploadTask3.dataType = 2;
        upsImageUploadTask3.fileId = generateRandomFileID(this.path);
        UpsImageUploadTask upsImageUploadTask4 = this.mTaskAdapter;
        upsImageUploadTask4.vBusiNessData = this.vData;
        upsImageUploadTask4.uploadTaskCallback = new a();
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
        UpsImageUploadTask upsImageUploadTask = this.mTaskAdapter;
        if (upsImageUploadTask == null) {
            return "";
        }
        return upsImageUploadTask.getFlowMessage();
    }

    @Override // com.qzone.publish.business.protocol.QzoneUploadRequest, com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public boolean needReport() {
        return false;
    }

    @Override // com.qzone.publish.business.protocol.QzoneUploadRequest, com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return "null";
    }

    @Override // com.qzone.publish.business.protocol.QzoneUploadRequest
    public void upload(byte[] bArr) {
        initTaskAdapter(bArr);
        validAndUpload(this.mTaskAdapter);
    }

    protected static int subFlowId(String str) {
        if (str == null) {
            str = "";
        }
        return (str + System.currentTimeMillis()).hashCode();
    }

    public QZoneUploadUpsInfoRequest(String str, int i3, boolean z16, boolean z17, byte[] bArr, String str2) {
        super(null);
        this.mStartTime = -1L;
        this.realFileName = "";
        this.aPhotoFilePath = str2;
        this.sBusinessId = str;
        this.uploadType = i3;
        this.isNeedHD = z16;
        this.isKeepRaw = z17;
        this.vData = bArr;
        this.path = str2;
    }

    protected void sendResponse(int i3, UpsImageUploadResult upsImageUploadResult, String str) {
        String str2;
        if (upsImageUploadResult == null) {
            return;
        }
        this.rsp = new UploadUpsInfoRsp(upsImageUploadResult.dataType, upsImageUploadResult.vBusiNessData, upsImageUploadResult.url, upsImageUploadResult.rawWidth, upsImageUploadResult.rawHeight, upsImageUploadResult.photoType, null);
        UniAttribute uniAttribute = new UniAttribute();
        uniAttribute.setEncodeName("utf8");
        uniAttribute.put("ReplyCode", Integer.valueOf(i3 == 0 ? 0 : -1));
        if (i3 == 0) {
            str2 = "success";
        } else {
            str2 = "fail";
        }
        uniAttribute.put("StrResult", str2);
        uniAttribute.put("response", this.rsp);
        this.mListner.onProtocolResponse(uniAttribute, i3, i3, str, false);
    }
}
