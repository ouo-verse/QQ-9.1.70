package com.qzone.publish.business.protocol;

import android.text.TextUtils;
import com.qq.jce.wup.UniAttribute;
import com.qzone.common.account.LoginData;
import com.qzone.common.protocol.request.QZoneRequest;
import com.qzone.publish.business.publishqueue.c;
import com.tencent.mobileqq.winkpublish.publishconst.FSUploadConst;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadTaskCallback;
import com.tencent.upload.uinterface.UploadServiceBuilder;
import com.tencent.upload.uinterface.data.MobileLogUploadTask;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneReportRequest extends QzoneUploadRequest {
    private int flowId;
    private MobileLogUploadTask mTaskAdapter;
    private String path;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements IUploadTaskCallback {
        a() {
        }

        @Override // com.tencent.upload.uinterface.IUploadTaskCallback
        public void onUploadError(AbstractUploadTask abstractUploadTask, int i3, String str) {
            QZoneReportRequest.this.sendResponse(i3, str);
            if (((QZoneRequest) QZoneReportRequest.this).mUploadQueueListener != null) {
                ((QZoneRequest) QZoneReportRequest.this).mUploadQueueListener.onUploadError(abstractUploadTask, i3, str);
            }
        }

        @Override // com.tencent.upload.uinterface.IUploadTaskCallback
        public void onUploadProgress(AbstractUploadTask abstractUploadTask, long j3, long j16) {
            if (((QZoneRequest) QZoneReportRequest.this).mUploadQueueListener != null) {
                ((QZoneRequest) QZoneReportRequest.this).mUploadQueueListener.resetTime();
            }
        }

        @Override // com.tencent.upload.uinterface.IUploadTaskCallback
        public void onUploadStateChange(AbstractUploadTask abstractUploadTask, int i3) {
            if (((QZoneRequest) QZoneReportRequest.this).mUploadQueueListener == null || ((QZoneRequest) QZoneReportRequest.this).mUploadQueueListener.getState() == i3) {
                return;
            }
            ((QZoneRequest) QZoneReportRequest.this).mUploadQueueListener.onStateChanged(i3);
        }

        @Override // com.tencent.upload.uinterface.IUploadTaskCallback
        public void onUploadSucceed(AbstractUploadTask abstractUploadTask, Object obj) {
            QZoneReportRequest.this.sendResponse(0, QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "UploadSuccess", "\u4e0a\u4f20\u6210\u529f"));
            if (((QZoneRequest) QZoneReportRequest.this).mUploadQueueListener != null) {
                ((QZoneRequest) QZoneReportRequest.this).mUploadQueueListener.onUploadSucceed(obj);
            }
        }
    }

    public QZoneReportRequest() {
    }

    private void initTaskAdapter(byte[] bArr) {
        if (TextUtils.isEmpty(this.path)) {
            c cVar = this.mUploadQueueListener;
            if (cVar != null) {
                cVar.onUploadError(this, FSUploadConst.ERR_FILE_NOT_EXIST, r7.c.a(FSUploadConst.ERR_FILE_NOT_EXIST));
                return;
            }
            return;
        }
        MobileLogUploadTask mobileLogUploadTask = new MobileLogUploadTask(this.path);
        this.mTaskAdapter = mobileLogUploadTask;
        mobileLogUploadTask.flowId = this.flowId;
        if (QZLog.isDevelopLevel()) {
            QZLog.d(QZLog.REPORT_QUEUE_TAG, 2, " uploadTask.flowId:" + mobileLogUploadTask.flowId + " path:" + this.path);
        }
        mobileLogUploadTask.iUin = LoginData.getInstance().getUin();
        mobileLogUploadTask.sRefer = "mqq";
        mobileLogUploadTask.vLoginData = bArr;
        String str = this.path;
        mobileLogUploadTask.uploadFilePath = str;
        mobileLogUploadTask.md5 = createFileMD5(str);
        mobileLogUploadTask.uploadTaskCallback = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendResponse(int i3, String str) {
        String str2;
        UniAttribute uniAttribute = new UniAttribute();
        uniAttribute.setEncodeName("utf8");
        uniAttribute.put("ReplyCode", Integer.valueOf(i3));
        if (i3 == 0) {
            str2 = "success";
        } else {
            str2 = "fail";
        }
        uniAttribute.put("StrResult", str2);
        QZLog.i(QZLog.REPORT_QUEUE_TAG, 2, "resCode:" + i3 + " ,errorMsg:" + str);
        this.mListner.onProtocolResponse(uniAttribute, i3, i3, str, false);
    }

    @Override // com.qzone.publish.business.protocol.QzoneUploadRequest
    public boolean cancel() {
        if (this.mTaskAdapter == null) {
            return false;
        }
        boolean cancel = UploadServiceBuilder.getInstance().cancel(this.mTaskAdapter);
        QZLog.i(QZLog.REPORT_QUEUE_TAG, 2, "QZoneReportRequest.cancel path:" + this.path);
        return cancel;
    }

    @Override // com.qzone.publish.business.protocol.QzoneUploadRequest, y8.a
    public String getFlowMessage() {
        return "";
    }

    @Override // com.qzone.publish.business.protocol.QzoneUploadRequest
    public void upload(byte[] bArr) {
        initTaskAdapter(bArr);
        validAndUpload(this.mTaskAdapter);
    }

    public QZoneReportRequest(String str) {
        this.path = str;
        this.flowId = subFlowId(0, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.publish.business.protocol.QzoneUploadRequest
    public boolean validAndUpload(AbstractUploadTask abstractUploadTask) {
        byte[] bArr;
        if (abstractUploadTask == null) {
            return false;
        }
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
            int checkValidValue = checkValidValue(abstractUploadTask);
            if (checkValidValue != 0) {
                String a16 = r7.c.a(checkValidValue);
                QZLog.w(QZLog.REPORT_QUEUE_TAG, this.TAG + " check not pass errMsg:" + a16);
                abstractUploadTask.uploadTaskCallback.onUploadError(abstractUploadTask, checkValidValue, a16);
                return false;
            }
            abstractUploadTask.transferData.put("task_state", FSUploadConst.STATE_RUNNING);
            QZLog.i(QZLog.REPORT_QUEUE_TAG, 1, this.TAG + "upload result : " + UploadServiceBuilder.getInstance().upload(abstractUploadTask));
            return true;
        }
        QZLog.w(QZLog.REPORT_QUEUE_TAG, this.TAG + " no login, stop upload");
        abstractUploadTask.uploadTaskCallback.onUploadError(abstractUploadTask, FSUploadConst.ERR_NO_LOGIN, r7.c.a(FSUploadConst.ERR_NO_LOGIN));
        return false;
    }
}
