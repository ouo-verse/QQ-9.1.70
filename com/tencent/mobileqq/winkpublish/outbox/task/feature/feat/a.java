package com.tencent.mobileqq.winkpublish.outbox.task.feature.feat;

import com.tencent.mobileqq.winkpublish.model.params.MediaParams;
import com.tencent.mobileqq.winkpublish.model.params.NetVideoParams;
import com.tencent.mobileqq.winkpublish.outbox.exceptions.FinishException;
import com.tencent.mobileqq.winkpublish.outbox.task.TaskContext;
import com.tencent.mobileqq.winkpublish.report.TaskErrorCode;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.uinterface.data.ImageUploadResult;
import com.tencent.upload.uinterface.data.VideoUploadResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \t2\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/feat/a;", "Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/base/b;", "Lcom/tencent/mobileqq/winkpublish/outbox/task/TaskContext;", "taskContext", "", "a", "(Lcom/tencent/mobileqq/winkpublish/outbox/task/TaskContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "e", "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class a extends com.tencent.mobileqq.winkpublish.outbox.task.feature.base.b {
    public a() {
        super(new PublishFeedFeat());
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.task.feature.base.a
    public Object a(TaskContext taskContext, Continuation<? super Unit> continuation) {
        if (taskContext.C()) {
            MediaParams mediaParams = taskContext.x().get(0).getMediaParams();
            NetVideoParams netVideoParams = mediaParams instanceof NetVideoParams ? (NetVideoParams) mediaParams : null;
            if (netVideoParams != null) {
                VideoUploadResult videoUploadResult = new VideoUploadResult();
                videoUploadResult.sVid = netVideoParams.getVid();
                taskContext.x().get(0).F(videoUploadResult);
                ImageUploadResult imageUploadResult = new ImageUploadResult(0L, 0, 0L, null);
                imageUploadResult.sBURL = netVideoParams.getCoverUrl();
                imageUploadResult.iWidth = netVideoParams.getCoverWidth();
                imageUploadResult.iHeight = netVideoParams.getCoverHeight();
                taskContext.x().get(0).w(imageUploadResult);
                return Unit.INSTANCE;
            }
            QLog.w("MockUploadResultFeat", 1, "[run] invalid videoInfo");
            throw new FinishException(new TaskErrorCode(TaskErrorCode.ERROR_CODE_NO_SUPPORT, null, 2, null));
        }
        QLog.w("MockUploadResultFeat", 1, "[run] not video task");
        throw new FinishException(new TaskErrorCode(TaskErrorCode.ERROR_CODE_NO_SUPPORT, null, 2, null));
    }
}
