package com.tencent.biz.richframework.publish.nt;

import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.publish.base.interfaces.IRFWLog;
import com.tencent.mobileqq.vaswebviewplugin.ColorRingJsPlugin;
import com.tencent.qqnt.kernel.api.k;
import com.tencent.qqnt.kernel.nativeinterface.BatchUploadConfig;
import com.tencent.qqnt.kernel.nativeinterface.BatchUploadSession;
import com.tencent.qqnt.kernel.nativeinterface.BatchUploadSessionStatus;
import com.tencent.qqnt.kernel.nativeinterface.BatchUploadTask;
import com.tencent.qqnt.kernel.nativeinterface.BatchUploadTaskStatus;
import com.tencent.qqnt.kernel.nativeinterface.IBatchUploadManager;
import com.tencent.qqnt.kernel.nativeinterface.IBatchUploadManagerDelegate;
import com.tencent.upload.network.session.cache.SessionDbHelper;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010'\u001a\u00020\b\u00a2\u0006\u0004\b3\u0010,J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\bJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fJ\u001c\u0010\u0014\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u001c\u0010\u0015\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J,\u0010\u0019\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0016J\u001c\u0010\u001a\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u001c\u0010\u001b\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J&\u0010\u001e\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\u001c\u0010 \u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u001f\u001a\u0004\u0018\u00010\u000fH\u0016J&\u0010\"\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u001f\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001d\u001a\u0004\u0018\u00010!H\u0016J.\u0010&\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u001a\u0010%\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010#j\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`$H\u0016R\"\u0010'\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0018\u0010-\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u0010/\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00101\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102\u00a8\u00064"}, d2 = {"Lcom/tencent/biz/richframework/publish/nt/NTBatchUploader;", "Lcom/tencent/biz/richframework/publish/base/interfaces/IRFWLog;", "Lcom/tencent/qqnt/kernel/nativeinterface/IBatchUploadManagerDelegate;", "", "uid", "uploadDelegate", "", ColorRingJsPlugin.Method_SetUp, "Lcom/tencent/biz/richframework/publish/nt/NTBatchUploadConstants$AppType;", "getNTUploaderAppType", "Lcom/tencent/qqnt/kernel/nativeinterface/BatchUploadConfig;", "genBatchUploadConfig", "Lcom/tencent/qqnt/kernel/nativeinterface/BatchUploadTask;", "task", "updateTask", "Lcom/tencent/qqnt/kernel/nativeinterface/BatchUploadSession;", "uploadSession", QZoneJsConstants.METHOD_RECORDER_START_UPLOAD, "Lcom/tencent/qqnt/kernel/nativeinterface/IBatchUploadManager;", "manager", "taskDidStartUpload", "taskDidFinishUpload", "", "uploadedBytes", "totalBytes", "taskProgressDidUpdate", "taskDidError", "taskDidCancel", "Lcom/tencent/qqnt/kernel/nativeinterface/BatchUploadTaskStatus;", "status", "taskStatusDidUpdate", SessionDbHelper.SESSION_ID, "sessionDidFinishUpload", "Lcom/tencent/qqnt/kernel/nativeinterface/BatchUploadSessionStatus;", "sessionStatusDidUpdate", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "sessions", "onGetCachedSessions", "appType", "Lcom/tencent/biz/richframework/publish/nt/NTBatchUploadConstants$AppType;", "getAppType", "()Lcom/tencent/biz/richframework/publish/nt/NTBatchUploadConstants$AppType;", "setAppType", "(Lcom/tencent/biz/richframework/publish/nt/NTBatchUploadConstants$AppType;)V", "uploadManager", "Lcom/tencent/qqnt/kernel/nativeinterface/IBatchUploadManager;", "uploadConfig", "Lcom/tencent/qqnt/kernel/nativeinterface/BatchUploadConfig;", "uploadCallback", "Lcom/tencent/qqnt/kernel/nativeinterface/IBatchUploadManagerDelegate;", "<init>", "rfw-upload_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public abstract class NTBatchUploader implements IRFWLog, IBatchUploadManagerDelegate {
    private NTBatchUploadConstants$AppType appType;
    private IBatchUploadManagerDelegate uploadCallback;
    private BatchUploadConfig uploadConfig;
    private IBatchUploadManager uploadManager;

    public NTBatchUploader(NTBatchUploadConstants$AppType appType) {
        Intrinsics.checkNotNullParameter(appType, "appType");
        this.appType = appType;
    }

    public abstract BatchUploadConfig genBatchUploadConfig(String uid);

    public final NTBatchUploadConstants$AppType getAppType() {
        return this.appType;
    }

    public final NTBatchUploadConstants$AppType getNTUploaderAppType() {
        return this.appType;
    }

    public final void setup(String uid, IBatchUploadManagerDelegate uploadDelegate) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(uploadDelegate, "uploadDelegate");
        this.uploadCallback = uploadDelegate;
        this.uploadConfig = genBatchUploadConfig(uid);
        k batchUploadService = NTBatchUploadService.getBatchUploadService();
        this.uploadManager = batchUploadService != null ? batchUploadService.getBatchUploadManager(this.uploadConfig, this) : null;
    }

    public final void startUpload(BatchUploadSession uploadSession) {
        Intrinsics.checkNotNullParameter(uploadSession, "uploadSession");
        RFWLog.d(getLogTag(), RFWLog.DEV, "startUpload:taskList=" + uploadSession.tasks);
        IBatchUploadManager iBatchUploadManager = this.uploadManager;
        if (iBatchUploadManager != null) {
            iBatchUploadManager.startUploadSession(uploadSession);
        }
    }

    public final void updateTask(BatchUploadTask task) {
        Intrinsics.checkNotNullParameter(task, "task");
        RFWLog.d(getLogTag(), RFWLog.USR, "updateTask:task=" + task.taskId + ",session=" + task.sessionId);
        IBatchUploadManager iBatchUploadManager = this.uploadManager;
        if (iBatchUploadManager != null) {
            iBatchUploadManager.updateTaskInfo(task);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IBatchUploadManagerDelegate
    public void onGetCachedSessions(IBatchUploadManager manager, ArrayList<BatchUploadSession> sessions) {
        IBatchUploadManagerDelegate iBatchUploadManagerDelegate;
        if (manager != null && sessions != null) {
            if (Intrinsics.areEqual(this.uploadManager, manager) && (iBatchUploadManagerDelegate = this.uploadCallback) != null) {
                iBatchUploadManagerDelegate.onGetCachedSessions(manager, sessions);
                return;
            }
            return;
        }
        RFWLog.e(getLogTag(), RFWLog.USR, "onGetCachedSessions error,manager=" + manager + ",sessions=" + sessions);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IBatchUploadManagerDelegate
    public void sessionDidFinishUpload(IBatchUploadManager manager, BatchUploadSession session) {
        IBatchUploadManagerDelegate iBatchUploadManagerDelegate;
        if (manager != null && session != null) {
            if (Intrinsics.areEqual(this.uploadManager, manager) && (iBatchUploadManagerDelegate = this.uploadCallback) != null) {
                iBatchUploadManagerDelegate.sessionDidFinishUpload(manager, session);
                return;
            }
            return;
        }
        RFWLog.e(getLogTag(), RFWLog.USR, "sessionDidFinishUpload error,manager=" + manager + ",session=" + session);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IBatchUploadManagerDelegate
    public void sessionStatusDidUpdate(IBatchUploadManager manager, BatchUploadSession session, BatchUploadSessionStatus status) {
        IBatchUploadManagerDelegate iBatchUploadManagerDelegate;
        if (manager != null && session != null) {
            if (Intrinsics.areEqual(this.uploadManager, manager) && (iBatchUploadManagerDelegate = this.uploadCallback) != null) {
                iBatchUploadManagerDelegate.sessionStatusDidUpdate(manager, session, status);
                return;
            }
            return;
        }
        RFWLog.e(getLogTag(), RFWLog.USR, "sessionStatusDidUpdate error,manager=" + manager + ",session=" + session);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IBatchUploadManagerDelegate
    public void taskDidCancel(IBatchUploadManager manager, BatchUploadTask task) {
        IBatchUploadManagerDelegate iBatchUploadManagerDelegate;
        if (manager != null && task != null) {
            if (Intrinsics.areEqual(this.uploadManager, manager) && (iBatchUploadManagerDelegate = this.uploadCallback) != null) {
                iBatchUploadManagerDelegate.taskDidCancel(manager, task);
                return;
            }
            return;
        }
        String logTag = getLogTag();
        int i3 = RFWLog.USR;
        Object[] objArr = new Object[1];
        StringBuilder sb5 = new StringBuilder();
        sb5.append("taskDidCancel error,manager=");
        sb5.append(manager != null ? manager.hashCode() : 0);
        sb5.append(",task=");
        sb5.append(task);
        objArr[0] = sb5.toString();
        RFWLog.e(logTag, i3, objArr);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IBatchUploadManagerDelegate
    public void taskDidError(IBatchUploadManager manager, BatchUploadTask task) {
        IBatchUploadManagerDelegate iBatchUploadManagerDelegate;
        if (manager != null && task != null) {
            if (Intrinsics.areEqual(this.uploadManager, manager) && (iBatchUploadManagerDelegate = this.uploadCallback) != null) {
                iBatchUploadManagerDelegate.taskDidError(manager, task);
                return;
            }
            return;
        }
        String logTag = getLogTag();
        int i3 = RFWLog.USR;
        Object[] objArr = new Object[1];
        StringBuilder sb5 = new StringBuilder();
        sb5.append("taskDidError error,manager=");
        sb5.append(manager != null ? manager.hashCode() : 0);
        sb5.append(",task=");
        sb5.append(task);
        objArr[0] = sb5.toString();
        RFWLog.e(logTag, i3, objArr);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IBatchUploadManagerDelegate
    public void taskDidFinishUpload(IBatchUploadManager manager, BatchUploadTask task) {
        IBatchUploadManagerDelegate iBatchUploadManagerDelegate;
        if (manager != null && task != null) {
            if (Intrinsics.areEqual(this.uploadManager, manager) && (iBatchUploadManagerDelegate = this.uploadCallback) != null) {
                iBatchUploadManagerDelegate.taskDidFinishUpload(manager, task);
                return;
            }
            return;
        }
        String logTag = getLogTag();
        int i3 = RFWLog.USR;
        Object[] objArr = new Object[1];
        StringBuilder sb5 = new StringBuilder();
        sb5.append("taskDidFinishUpload error, manager=");
        sb5.append(manager != null ? manager.hashCode() : 0);
        sb5.append(", task=");
        sb5.append(task);
        objArr[0] = sb5.toString();
        RFWLog.e(logTag, i3, objArr);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IBatchUploadManagerDelegate
    public void taskDidStartUpload(IBatchUploadManager manager, BatchUploadTask task) {
        IBatchUploadManagerDelegate iBatchUploadManagerDelegate;
        if (manager != null && task != null) {
            if (Intrinsics.areEqual(this.uploadManager, manager) && (iBatchUploadManagerDelegate = this.uploadCallback) != null) {
                iBatchUploadManagerDelegate.taskDidStartUpload(manager, task);
                return;
            }
            return;
        }
        String logTag = getLogTag();
        int i3 = RFWLog.USR;
        Object[] objArr = new Object[1];
        StringBuilder sb5 = new StringBuilder();
        sb5.append("taskDidStartUpload error,manager=");
        sb5.append(manager != null ? manager.hashCode() : 0);
        sb5.append(",task=");
        sb5.append(task);
        objArr[0] = sb5.toString();
        RFWLog.e(logTag, i3, objArr);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IBatchUploadManagerDelegate
    public void taskProgressDidUpdate(IBatchUploadManager manager, BatchUploadTask task, long uploadedBytes, long totalBytes) {
        IBatchUploadManagerDelegate iBatchUploadManagerDelegate;
        if (manager != null && task != null) {
            if (Intrinsics.areEqual(this.uploadManager, manager) && (iBatchUploadManagerDelegate = this.uploadCallback) != null) {
                iBatchUploadManagerDelegate.taskProgressDidUpdate(manager, task, uploadedBytes, totalBytes);
                return;
            }
            return;
        }
        String logTag = getLogTag();
        int i3 = RFWLog.USR;
        Object[] objArr = new Object[1];
        StringBuilder sb5 = new StringBuilder();
        sb5.append("taskProgressDidUpdate error,manager=");
        sb5.append(manager != null ? manager.hashCode() : 0);
        sb5.append(",task=");
        sb5.append(task);
        objArr[0] = sb5.toString();
        RFWLog.e(logTag, i3, objArr);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IBatchUploadManagerDelegate
    public void taskStatusDidUpdate(IBatchUploadManager manager, BatchUploadTask task, BatchUploadTaskStatus status) {
        IBatchUploadManagerDelegate iBatchUploadManagerDelegate;
        if (manager != null && task != null) {
            if (Intrinsics.areEqual(this.uploadManager, manager) && (iBatchUploadManagerDelegate = this.uploadCallback) != null) {
                iBatchUploadManagerDelegate.taskStatusDidUpdate(manager, task, status);
                return;
            }
            return;
        }
        RFWLog.e(getLogTag(), RFWLog.USR, "taskStatusDidUpdate error,manager=" + manager + ",task=" + task);
    }
}
