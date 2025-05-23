package com.tencent.biz.richframework.publish.nt;

import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.publish.base.RFWPublishFile;
import com.tencent.biz.richframework.publish.base.RFWPublisher;
import com.tencent.biz.richframework.publish.base.interfaces.IRFWUploadDelegate;
import com.tencent.biz.richframework.publish.nt.model.NTPublishModel;
import com.tencent.biz.richframework.publish.nt.model.media.NTPublishFile;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqmini.miniapp.widget.InnerWebView;
import com.tencent.qqnt.kernel.nativeinterface.BatchUploadSession;
import com.tencent.qqnt.kernel.nativeinterface.BatchUploadSessionStatus;
import com.tencent.qqnt.kernel.nativeinterface.BatchUploadTask;
import com.tencent.qqnt.kernel.nativeinterface.BatchUploadTaskErrorInfo;
import com.tencent.qqnt.kernel.nativeinterface.BatchUploadTaskStatus;
import com.tencent.qqnt.kernel.nativeinterface.IBatchUploadManager;
import com.tencent.qqnt.kernel.nativeinterface.IBatchUploadManagerDelegate;
import com.tencent.qqnt.kernel.nativeinterface.IndexNode;
import com.tencent.qqnt.kernel.nativeinterface.MsgInfoBody;
import com.tencent.qqnt.kernel.nativeinterface.PictureInfo;
import com.tencent.qzonehub.api.IQZoneApiProxy;
import com.tencent.upload.network.session.cache.SessionDbHelper;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u000f\u0012\u0006\u0010,\u001a\u00020+\u00a2\u0006\u0004\b2\u00103J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u001c\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rH&J\u001a\u0010\u0013\u001a\u00020\u000f2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0011J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000bH\u0016J\u001c\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0017J\u001c\u0010\u0019\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0017J,\u0010\u001d\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aH\u0017J\u001c\u0010\u001e\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0017J\u001c\u0010\u001f\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0017J&\u0010\"\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010!\u001a\u0004\u0018\u00010 H\u0017J\u001c\u0010#\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0017J&\u0010%\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010!\u001a\u0004\u0018\u00010$H\u0017J.\u0010)\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u001a\u0010(\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010&j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`'H\u0017J\u0006\u0010*\u001a\u00020\u000bR\u0017\u0010,\u001a\u00020+8\u0006\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R$\u00100\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101\u00a8\u00064"}, d2 = {"Lcom/tencent/biz/richframework/publish/nt/NTBatchPublisher;", "Lcom/tencent/biz/richframework/publish/base/RFWPublisher;", "Lcom/tencent/biz/richframework/publish/nt/model/NTPublishModel;", "Lcom/tencent/qqnt/kernel/nativeinterface/IBatchUploadManagerDelegate;", "Lcom/tencent/qqnt/kernel/nativeinterface/BatchUploadTask;", "task", "Lcom/tencent/biz/richframework/publish/nt/model/media/NTPublishFile;", "queryPublishFileFromTask", "Lcom/tencent/qqnt/kernel/nativeinterface/BatchUploadSession;", SessionDbHelper.SESSION_ID, "queryPublishModelFromSession", "", "filePath", "", "param", "", InnerWebView.API_UPLOAD_IMAGE, "Lcom/tencent/biz/richframework/publish/base/interfaces/IRFWUploadDelegate;", "delegate", "injectDelegate", "publishID", QZoneJsConstants.METHOD_RECORDER_START_UPLOAD, "Lcom/tencent/qqnt/kernel/nativeinterface/IBatchUploadManager;", "manager", "taskDidStartUpload", "taskDidFinishUpload", "", "uploadedBytes", "totalBytes", "taskProgressDidUpdate", "taskDidError", "taskDidCancel", "Lcom/tencent/qqnt/kernel/nativeinterface/BatchUploadTaskStatus;", "status", "taskStatusDidUpdate", "sessionDidFinishUpload", "Lcom/tencent/qqnt/kernel/nativeinterface/BatchUploadSessionStatus;", "sessionStatusDidUpdate", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "sessions", "onGetCachedSessions", "getUinString", "Lcom/tencent/biz/richframework/publish/nt/NTBatchUploader;", "uploader", "Lcom/tencent/biz/richframework/publish/nt/NTBatchUploader;", "getUploader", "()Lcom/tencent/biz/richframework/publish/nt/NTBatchUploader;", "rfwUploadDelegate", "Lcom/tencent/biz/richframework/publish/base/interfaces/IRFWUploadDelegate;", "<init>", "(Lcom/tencent/biz/richframework/publish/nt/NTBatchUploader;)V", "rfw-upload_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public abstract class NTBatchPublisher extends RFWPublisher<NTPublishModel> implements IBatchUploadManagerDelegate {
    private IRFWUploadDelegate<NTPublishModel, NTPublishFile> rfwUploadDelegate;
    private final NTBatchUploader uploader;

    public NTBatchPublisher(NTBatchUploader uploader) {
        Intrinsics.checkNotNullParameter(uploader, "uploader");
        this.uploader = uploader;
    }

    private final NTPublishFile queryPublishFileFromTask(BatchUploadTask task) {
        RFWPublishFile<BatchUploadTask> rFWPublishFile;
        String publishID = task.getSessionId();
        Intrinsics.checkNotNullExpressionValue(publishID, "publishID");
        NTPublishModel fetchMission = fetchMission(publishID);
        if (fetchMission != null) {
            String taskId = task.getTaskId();
            Intrinsics.checkNotNullExpressionValue(taskId, "task.getTaskId()");
            rFWPublishFile = fetchMission.fetchPublishFile(taskId);
        } else {
            rFWPublishFile = null;
        }
        String logTag = getLogTag();
        int i3 = RFWLog.DEV;
        Object[] objArr = new Object[1];
        StringBuilder sb5 = new StringBuilder();
        sb5.append("queryPublishFileFromTask task=");
        sb5.append(task.getSessionId());
        sb5.append(",model=");
        sb5.append(fetchMission != null ? fetchMission.getPublishID() : null);
        sb5.append(",file=");
        sb5.append(rFWPublishFile != null ? rFWPublishFile.getFileID() : null);
        objArr[0] = sb5.toString();
        RFWLog.d(logTag, i3, objArr);
        return (NTPublishFile) rFWPublishFile;
    }

    private final NTPublishModel queryPublishModelFromSession(BatchUploadSession r75) {
        String publishID = r75.getSessionId();
        Intrinsics.checkNotNullExpressionValue(publishID, "publishID");
        NTPublishModel fetchMission = fetchMission(publishID);
        String logTag = getLogTag();
        int i3 = RFWLog.DEV;
        Object[] objArr = new Object[1];
        StringBuilder sb5 = new StringBuilder();
        sb5.append("queryPublishModelFromSession session=");
        sb5.append(r75.getSessionId());
        sb5.append(",model=");
        sb5.append(fetchMission != null ? fetchMission.getPublishID() : null);
        objArr[0] = sb5.toString();
        RFWLog.d(logTag, i3, objArr);
        return fetchMission;
    }

    public final String getUinString() {
        String account;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        return (peekAppRuntime == null || (account = peekAppRuntime.getAccount()) == null) ? "" : account;
    }

    public final NTBatchUploader getUploader() {
        return this.uploader;
    }

    public final void injectDelegate(IRFWUploadDelegate<NTPublishModel, NTPublishFile> delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.rfwUploadDelegate = delegate;
    }

    public void startUpload(String publishID) {
        Intrinsics.checkNotNullParameter(publishID, "publishID");
        NTPublishModel fetchMission = fetchMission(publishID);
        if (fetchMission == null) {
            return;
        }
        fetchMission.loadUploadTasks();
        this.uploader.startUpload(fetchMission.getSession());
        startPreprocess(publishID);
    }

    public abstract void uploadImage(String str, Object obj);

    @Override // com.tencent.qqnt.kernel.nativeinterface.IBatchUploadManagerDelegate
    public void sessionDidFinishUpload(IBatchUploadManager manager, BatchUploadSession r85) {
        if (manager == null || r85 == null) {
            return;
        }
        RFWLog.d(getLogTag(), RFWLog.USR, "sessionDidFinishUpload\uff0cmanager=" + manager.hashCode() + ",session=" + r85.getSessionId());
        NTPublishModel queryPublishModelFromSession = queryPublishModelFromSession(r85);
        if (queryPublishModelFromSession == null) {
            return;
        }
        queryPublishModelFromSession.updateModelAfterUpload(r85);
        IRFWUploadDelegate<NTPublishModel, NTPublishFile> iRFWUploadDelegate = this.rfwUploadDelegate;
        if (iRFWUploadDelegate != null) {
            iRFWUploadDelegate.missionDidFinish(queryPublishModelFromSession);
        }
        ((IQZoneApiProxy) QRoute.api(IQZoneApiProxy.class)).reportNTUploadMissionResult(this.uploader.getNTUploaderAppType().ordinal(), getUinString(), r85.getSessionId(), r85.getSuccessCount(), r85.getFailedCount());
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IBatchUploadManagerDelegate
    public void taskDidCancel(IBatchUploadManager manager, BatchUploadTask task) {
        if (manager == null || task == null) {
            return;
        }
        RFWLog.d(getLogTag(), RFWLog.USR, "taskDidCancel\uff0cmanager=" + manager.hashCode() + ",taskId=" + task.taskId + ",session=" + task.sessionId + ",fileInfo==" + task.fileInfo);
        NTPublishFile queryPublishFileFromTask = queryPublishFileFromTask(task);
        if (queryPublishFileFromTask == null) {
            return;
        }
        queryPublishFileFromTask.setState(RFWPublishFile.FileState.CANCEL);
        IRFWUploadDelegate<NTPublishModel, NTPublishFile> iRFWUploadDelegate = this.rfwUploadDelegate;
        if (iRFWUploadDelegate != null) {
            iRFWUploadDelegate.fileDidCancelUpload(queryPublishFileFromTask);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IBatchUploadManagerDelegate
    public void taskDidStartUpload(IBatchUploadManager manager, BatchUploadTask task) {
        if (manager == null || task == null) {
            return;
        }
        RFWLog.d(getLogTag(), RFWLog.USR, "taskDidStartUpload\uff0cmanager=" + manager.hashCode() + ",taskId=" + task.taskId + ",fileInfo=" + task.fileInfo);
        NTPublishFile queryPublishFileFromTask = queryPublishFileFromTask(task);
        if (queryPublishFileFromTask == null) {
            return;
        }
        queryPublishFileFromTask.setState(RFWPublishFile.FileState.UPLOADING);
        IRFWUploadDelegate<NTPublishModel, NTPublishFile> iRFWUploadDelegate = this.rfwUploadDelegate;
        if (iRFWUploadDelegate != null) {
            iRFWUploadDelegate.fileDidStartUpload(queryPublishFileFromTask);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IBatchUploadManagerDelegate
    public void sessionStatusDidUpdate(IBatchUploadManager manager, BatchUploadSession r75, BatchUploadSessionStatus status) {
        if (manager == null || r75 == null) {
            return;
        }
        String logTag = getLogTag();
        int i3 = RFWLog.USR;
        Object[] objArr = new Object[1];
        StringBuilder sb5 = new StringBuilder();
        sb5.append("sessionStatusDidUpdate\uff0cmanager=");
        sb5.append(manager.hashCode());
        sb5.append(",session=");
        sb5.append(r75.getSessionId());
        sb5.append(",status=");
        sb5.append(status != null ? status.name() : null);
        objArr[0] = sb5.toString();
        RFWLog.d(logTag, i3, objArr);
        NTPublishModel queryPublishModelFromSession = queryPublishModelFromSession(r75);
        if (queryPublishModelFromSession == null) {
            return;
        }
        Integer valueOf = status != null ? Integer.valueOf(status.ordinal()) : null;
        int ordinal = BatchUploadSessionStatus.KBATCHUPLOADSESSIONSTATUSRUNNING.ordinal();
        if (valueOf != null && valueOf.intValue() == ordinal) {
            IRFWUploadDelegate<NTPublishModel, NTPublishFile> iRFWUploadDelegate = this.rfwUploadDelegate;
            if (iRFWUploadDelegate != null) {
                iRFWUploadDelegate.missionDidStart(queryPublishModelFromSession);
                return;
            }
            return;
        }
        IRFWUploadDelegate<NTPublishModel, NTPublishFile> iRFWUploadDelegate2 = this.rfwUploadDelegate;
        if (iRFWUploadDelegate2 != null) {
            iRFWUploadDelegate2.missionDidStart(queryPublishModelFromSession);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IBatchUploadManagerDelegate
    public void taskDidError(IBatchUploadManager manager, BatchUploadTask task) {
        String str;
        if (manager == null || task == null) {
            return;
        }
        RFWLog.d(getLogTag(), RFWLog.USR, "taskDidError\uff0cmanager=" + manager.hashCode() + ",taskId=" + task.taskId + ",session=" + task.sessionId + ",error=" + task.errorInfo + ",fileInfo=" + task.fileInfo);
        NTPublishFile queryPublishFileFromTask = queryPublishFileFromTask(task);
        if (queryPublishFileFromTask == null) {
            return;
        }
        BatchUploadTaskErrorInfo errorInfo = task.getErrorInfo();
        queryPublishFileFromTask.setUploadErrorInfo(errorInfo);
        queryPublishFileFromTask.setState(RFWPublishFile.FileState.ERROR);
        IRFWUploadDelegate<NTPublishModel, NTPublishFile> iRFWUploadDelegate = this.rfwUploadDelegate;
        if (iRFWUploadDelegate != null) {
            iRFWUploadDelegate.fileDidFailUpload(queryPublishFileFromTask);
        }
        IQZoneApiProxy iQZoneApiProxy = (IQZoneApiProxy) QRoute.api(IQZoneApiProxy.class);
        int ordinal = this.uploader.getNTUploaderAppType().ordinal();
        String uinString = getUinString();
        long j3 = errorInfo.detailErrCode;
        long j16 = errorInfo.srvErrCode;
        int i3 = errorInfo.stepErr;
        if (TextUtils.isEmpty(errorInfo.errMsg)) {
            str = queryPublishFileFromTask.getFileID();
        } else {
            str = errorInfo.errMsg;
        }
        iQZoneApiProxy.reportNTUploadFileResult(ordinal, uinString, j3, j16, i3, str);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IBatchUploadManagerDelegate
    public void taskDidFinishUpload(IBatchUploadManager manager, BatchUploadTask task) {
        Object firstOrNull;
        Object firstOrNull2;
        String str;
        IndexNode indexNode;
        PictureInfo pictureInfo;
        if (manager == null || task == null) {
            return;
        }
        String logTag = getLogTag();
        int i3 = RFWLog.USR;
        Object[] objArr = new Object[1];
        StringBuilder sb5 = new StringBuilder();
        sb5.append("taskDidFinishUpload\uff0cmanager=");
        sb5.append(manager.hashCode());
        sb5.append(", taskId=");
        sb5.append(task.taskId);
        sb5.append(", session=");
        sb5.append(task.sessionId);
        sb5.append(", url=");
        ArrayList<MsgInfoBody> arrayList = task.msgInfo.msgInfoBody;
        Intrinsics.checkNotNullExpressionValue(arrayList, "task.msgInfo.msgInfoBody");
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
        MsgInfoBody msgInfoBody = (MsgInfoBody) firstOrNull;
        String str2 = null;
        sb5.append((msgInfoBody == null || (pictureInfo = msgInfoBody.pictureInfo) == null) ? null : pictureInfo.urlPath);
        sb5.append(",fileId=");
        ArrayList<MsgInfoBody> arrayList2 = task.msgInfo.msgInfoBody;
        Intrinsics.checkNotNullExpressionValue(arrayList2, "task.msgInfo.msgInfoBody");
        firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList2);
        MsgInfoBody msgInfoBody2 = (MsgInfoBody) firstOrNull2;
        if (msgInfoBody2 != null && (indexNode = msgInfoBody2.indexNode) != null) {
            str2 = indexNode.fileUuid;
        }
        sb5.append(str2);
        sb5.append(",rspExtInfo.size=");
        sb5.append(task.rspExtInfo.length);
        objArr[0] = sb5.toString();
        RFWLog.d(logTag, i3, objArr);
        NTPublishFile queryPublishFileFromTask = queryPublishFileFromTask(task);
        if (queryPublishFileFromTask == null) {
            return;
        }
        queryPublishFileFromTask.setMsgInfo(task.getMsgInfo());
        queryPublishFileFromTask.updateFileAfterUpload(task);
        IRFWUploadDelegate<NTPublishModel, NTPublishFile> iRFWUploadDelegate = this.rfwUploadDelegate;
        if (iRFWUploadDelegate != null) {
            iRFWUploadDelegate.fileDidFinishUpload(queryPublishFileFromTask);
        }
        BatchUploadTaskErrorInfo errorInfo = task.getErrorInfo();
        IQZoneApiProxy iQZoneApiProxy = (IQZoneApiProxy) QRoute.api(IQZoneApiProxy.class);
        int ordinal = this.uploader.getNTUploaderAppType().ordinal();
        String uinString = getUinString();
        long j3 = errorInfo.detailErrCode;
        long j16 = errorInfo.srvErrCode;
        int i16 = errorInfo.stepErr;
        if (TextUtils.isEmpty(errorInfo.errMsg)) {
            str = queryPublishFileFromTask.getFileID();
        } else {
            str = errorInfo.errMsg;
        }
        iQZoneApiProxy.reportNTUploadFileResult(ordinal, uinString, j3, j16, i16, str);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IBatchUploadManagerDelegate
    public void taskStatusDidUpdate(IBatchUploadManager manager, BatchUploadTask task, BatchUploadTaskStatus status) {
        NTPublishFile queryPublishFileFromTask;
        IRFWUploadDelegate<NTPublishModel, NTPublishFile> iRFWUploadDelegate;
        if (manager == null || task == null) {
            return;
        }
        String logTag = getLogTag();
        int i3 = RFWLog.USR;
        Object[] objArr = new Object[1];
        StringBuilder sb5 = new StringBuilder();
        sb5.append("taskStatusDidUpdate\uff0cmanager=");
        sb5.append(manager.hashCode());
        sb5.append(",taskId=");
        sb5.append(task.taskId);
        sb5.append(",session=");
        sb5.append(task.sessionId);
        sb5.append(",fileInfo==");
        sb5.append(task.fileInfo);
        sb5.append(",status=");
        sb5.append(status != null ? status.name() : null);
        objArr[0] = sb5.toString();
        RFWLog.d(logTag, i3, objArr);
        Integer valueOf = status != null ? Integer.valueOf(status.ordinal()) : null;
        int ordinal = BatchUploadTaskStatus.KBATCHUPLOADTASKSTATUSRUNING.ordinal();
        if (valueOf == null || valueOf.intValue() != ordinal || (queryPublishFileFromTask = queryPublishFileFromTask(task)) == null || (iRFWUploadDelegate = this.rfwUploadDelegate) == null) {
            return;
        }
        iRFWUploadDelegate.fileDidStartUpload(queryPublishFileFromTask);
    }

    public static /* synthetic */ void uploadImage$default(NTBatchPublisher nTBatchPublisher, String str, Object obj, int i3, Object obj2) {
        if (obj2 == null) {
            if ((i3 & 2) != 0) {
                obj = null;
            }
            nTBatchPublisher.uploadImage(str, obj);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: uploadImage");
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IBatchUploadManagerDelegate
    public void taskProgressDidUpdate(IBatchUploadManager manager, BatchUploadTask task, long uploadedBytes, long totalBytes) {
        IRFWUploadDelegate<NTPublishModel, NTPublishFile> iRFWUploadDelegate;
        if (manager == null || task == null) {
            return;
        }
        RFWLog.d(getLogTag(), RFWLog.USR, "taskProgressDidUpdate\uff0cmanager=" + manager.hashCode() + ",taskId=" + task.taskId + ",session=" + task.sessionId + ",fileInfo=" + task.fileInfo + ",uploadBytes=" + uploadedBytes + ",totalBytes=" + totalBytes);
        NTPublishFile queryPublishFileFromTask = queryPublishFileFromTask(task);
        if (queryPublishFileFromTask == null || (iRFWUploadDelegate = this.rfwUploadDelegate) == null) {
            return;
        }
        iRFWUploadDelegate.fileDidUpdateProgress(queryPublishFileFromTask, uploadedBytes, totalBytes);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IBatchUploadManagerDelegate
    public void onGetCachedSessions(IBatchUploadManager manager, ArrayList<BatchUploadSession> sessions) {
    }
}
