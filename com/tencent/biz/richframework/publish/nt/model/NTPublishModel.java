package com.tencent.biz.richframework.publish.nt.model;

import com.qzone.album.data.model.PhotoCategorySinglePicInfo;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.publish.base.RFWPublishFile;
import com.tencent.biz.richframework.publish.base.RFWPublishModel;
import com.tencent.biz.richframework.publish.base.interfaces.IRFWPublishFileStateHandler;
import com.tencent.biz.richframework.publish.nt.handler.NTPublishFilePreprocessStateHandler;
import com.tencent.biz.richframework.publish.nt.handler.NTPublishFileRawStateHandler;
import com.tencent.biz.richframework.publish.nt.model.NTPublishModel;
import com.tencent.biz.richframework.publish.nt.model.media.NTPublishFile;
import com.tencent.qqnt.kernel.nativeinterface.BatchUploadSession;
import com.tencent.qqnt.kernel.nativeinterface.BatchUploadTask;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.upload.network.session.cache.SessionDbHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010!\n\u0002\b\b\b&\u0018\u0000 *2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001*B\t\b\u0016\u00a2\u0006\u0004\b(\u0010)J\u001c\u0010\b\u001a\u00020\u00072\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\u0002J\u0006\u0010\t\u001a\u00020\u0007J\u001a\u0010\r\u001a\u00020\u00072\u0010\u0010\f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000b0\nH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0016J\u000e\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011R\"\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001b\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R#\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040#8\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\u00a8\u0006+"}, d2 = {"Lcom/tencent/biz/richframework/publish/nt/model/NTPublishModel;", "Lcom/tencent/biz/richframework/publish/base/RFWPublishModel;", "Lcom/tencent/qqnt/kernel/nativeinterface/BatchUploadTask;", "", "Lcom/tencent/biz/richframework/publish/base/interfaces/IRFWPublishFileStateHandler;", "Lcom/tencent/biz/richframework/publish/nt/model/media/NTPublishFile;", "handlers", "", "initStateHandlers", "loadUploadTasks", "Lcom/tencent/biz/richframework/publish/base/RFWPublishFile;", "", "file", "preProcessFile", "", "getLogTag", "toString", "Lcom/tencent/qqnt/kernel/nativeinterface/BatchUploadSession;", SessionDbHelper.SESSION_ID, "updateModelAfterUpload", "", "batchID", "J", "getBatchID", "()J", "setBatchID", "(J)V", PhotoCategorySinglePicInfo.UPLOAD_TIME, "getUploadTime", "setUploadTime", "Lcom/tencent/qqnt/kernel/nativeinterface/BatchUploadSession;", "getSession", "()Lcom/tencent/qqnt/kernel/nativeinterface/BatchUploadSession;", "setSession", "(Lcom/tencent/qqnt/kernel/nativeinterface/BatchUploadSession;)V", "", "stateHandlers", "Ljava/util/List;", "getStateHandlers", "()Ljava/util/List;", "<init>", "()V", "Companion", "rfw-upload_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public abstract class NTPublishModel extends RFWPublishModel<BatchUploadTask> {
    private long batchID;
    private BatchUploadSession session = new BatchUploadSession();
    private final List<IRFWPublishFileStateHandler<NTPublishFile>> stateHandlers = new ArrayList();
    private long uploadTime;

    public NTPublishModel() {
        List<? extends IRFWPublishFileStateHandler<NTPublishFile>> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new IRFWPublishFileStateHandler[]{new NTPublishFileRawStateHandler(), new NTPublishFilePreprocessStateHandler()});
        initStateHandlers(listOf);
        this.session.sessionId = getPublishID();
        this.batchID = Random.INSTANCE.nextLong(0L, Long.MAX_VALUE);
    }

    private final void initStateHandlers(List<? extends IRFWPublishFileStateHandler<NTPublishFile>> handlers) {
        CollectionsKt__MutableCollectionsKt.addAll(this.stateHandlers, handlers);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void preProcessFile$lambda$0(RFWPublishFile file, NTPublishModel this$0) {
        Intrinsics.checkNotNullParameter(file, "$file");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if ((file instanceof NTPublishFile ? (NTPublishFile) file : null) == null) {
            RFWLog.e(this$0.getLogTag(), RFWLog.USR, "processFile error!session is null!");
            return;
        }
        RFWPublishFile.FileState state = file.getState();
        for (IRFWPublishFileStateHandler<NTPublishFile> iRFWPublishFileStateHandler : this$0.stateHandlers) {
            if (state == RFWPublishFile.FileState.UPLOADED) {
                break;
            } else {
                state = iRFWPublishFileStateHandler.handle(file);
            }
        }
        if (state == RFWPublishFile.FileState.READY_TO_UPLOAD) {
            file.setReadyUpload(true);
            RFWLog.d(this$0.getLogTag(), RFWLog.DEV, "processFile into ready to upload," + file);
        }
    }

    public final long getBatchID() {
        return this.batchID;
    }

    @Override // com.tencent.biz.richframework.publish.base.interfaces.IRFWLog
    public String getLogTag() {
        return "NTPublishModel";
    }

    public final BatchUploadSession getSession() {
        return this.session;
    }

    public final long getUploadTime() {
        return this.uploadTime;
    }

    public final void loadUploadTasks() {
        this.session.tasks = genUploadTasks();
    }

    @Override // com.tencent.biz.richframework.publish.base.RFWPublishModel
    public void preProcessFile(final RFWPublishFile<? extends Object> file) {
        Intrinsics.checkNotNullParameter(file, "file");
        RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: oe0.a
            @Override // java.lang.Runnable
            public final void run() {
                NTPublishModel.preProcessFile$lambda$0(RFWPublishFile.this, this);
            }
        });
    }

    public final void setUploadTime(long j3) {
        this.uploadTime = j3;
    }

    public String toString() {
        return "publishID=" + getPublishID() + ", batchID=" + this.batchID + ", uploadTime=" + this.uploadTime + ", session=(" + this.session.sessionId + ", fileList=" + getFileList().size();
    }

    public final void updateModelAfterUpload(BatchUploadSession session) {
        Intrinsics.checkNotNullParameter(session, "session");
        BatchUploadSession batchUploadSession = this.session;
        batchUploadSession.timeInfo = session.timeInfo;
        batchUploadSession.status = session.status;
        batchUploadSession.successCount = session.getSuccessCount();
        this.session.failedCount = session.getFailedCount();
        this.session.bizInfo = session.getBizInfo();
    }
}
