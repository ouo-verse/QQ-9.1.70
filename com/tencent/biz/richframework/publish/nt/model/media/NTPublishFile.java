package com.tencent.biz.richframework.publish.nt.model.media;

import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.publish.base.RFWPublishFile;
import com.tencent.biz.richframework.publish.base.RFWPublishModel;
import com.tencent.qqnt.kernel.nativeinterface.BatchUploadTask;
import com.tencent.qqnt.kernel.nativeinterface.BatchUploadTaskErrorInfo;
import com.tencent.qqnt.kernel.nativeinterface.FileInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u0015\u001a\u00020\u0002H\u0017R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/biz/richframework/publish/nt/model/media/NTPublishFile;", "Lcom/tencent/biz/richframework/publish/base/RFWPublishFile;", "Lcom/tencent/qqnt/kernel/nativeinterface/BatchUploadTask;", "filePath", "", "(Ljava/lang/String;)V", "height", "", "msgInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgInfo;", "getMsgInfo", "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgInfo;", "setMsgInfo", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgInfo;)V", "uploadErrorInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/BatchUploadTaskErrorInfo;", "getUploadErrorInfo", "()Lcom/tencent/qqnt/kernel/nativeinterface/BatchUploadTaskErrorInfo;", "setUploadErrorInfo", "(Lcom/tencent/qqnt/kernel/nativeinterface/BatchUploadTaskErrorInfo;)V", "width", "genUploadTask", "rfw-upload_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes32.dex */
public abstract class NTPublishFile extends RFWPublishFile<BatchUploadTask> {
    private int height;
    private MsgInfo msgInfo;
    private BatchUploadTaskErrorInfo uploadErrorInfo;
    private int width;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NTPublishFile(String filePath) {
        super(filePath);
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        this.width = 1000;
        this.height = 1000;
    }

    public final MsgInfo getMsgInfo() {
        return this.msgInfo;
    }

    public final BatchUploadTaskErrorInfo getUploadErrorInfo() {
        return this.uploadErrorInfo;
    }

    public final void setMsgInfo(MsgInfo msgInfo) {
        this.msgInfo = msgInfo;
    }

    public final void setUploadErrorInfo(BatchUploadTaskErrorInfo batchUploadTaskErrorInfo) {
        this.uploadErrorInfo = batchUploadTaskErrorInfo;
    }

    @Override // com.tencent.biz.richframework.publish.base.interfaces.IRFWUploadable
    public BatchUploadTask genUploadTask() {
        String str;
        BatchUploadTask batchUploadTask = new BatchUploadTask();
        batchUploadTask.taskId = getFileID();
        RFWPublishModel<BatchUploadTask> model = getModel();
        if (model == null || (str = model.getPublishID()) == null) {
            str = "";
        }
        batchUploadTask.sessionId = str;
        batchUploadTask.fileInfo.filePath = getFilePath();
        FileInfo fileInfo = batchUploadTask.fileInfo;
        String md5 = getMd5();
        if (md5 == null) {
            md5 = "";
        }
        fileInfo.md5 = md5;
        FileInfo fileInfo2 = batchUploadTask.fileInfo;
        String sha1 = getSha1();
        fileInfo2.sha1 = sha1 != null ? sha1 : "";
        batchUploadTask.fileInfo.fileName = getFileName();
        FileInfo fileInfo3 = batchUploadTask.fileInfo;
        fileInfo3.width = this.width;
        fileInfo3.height = this.height;
        fileInfo3.size = getFileSize();
        RFWLog.d(getLogTag(), RFWLog.DEV, "genUploadTask\uff0ctaskId=" + batchUploadTask.taskId + ",sessionId=" + batchUploadTask.sessionId + ",fileName=" + batchUploadTask.fileInfo.fileName);
        return batchUploadTask;
    }
}
