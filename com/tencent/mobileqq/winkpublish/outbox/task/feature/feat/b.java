package com.tencent.mobileqq.winkpublish.outbox.task.feature.feat;

import com.tencent.mobileqq.winkpublish.outbox.exceptions.PreUploadException;
import com.tencent.mobileqq.winkpublish.outbox.task.TaskContext;
import com.tencent.mobileqq.winkpublish.report.TaskErrorCode;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\u0005B\u0013\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\u0004\b\b\u0010\tJ\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/feat/b;", "Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/base/b;", "Lcom/tencent/mobileqq/winkpublish/outbox/task/TaskContext;", "taskContext", "", "a", "(Lcom/tencent/mobileqq/winkpublish/outbox/task/TaskContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "next", "<init>", "(Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/base/b;)V", "e", "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class b extends com.tencent.mobileqq.winkpublish.outbox.task.feature.base.b {
    public b(com.tencent.mobileqq.winkpublish.outbox.task.feature.base.b bVar) {
        super(bVar);
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.task.feature.base.a
    public Object a(TaskContext taskContext, Continuation<? super Unit> continuation) {
        if (taskContext.getPublishParams().isTruePublish()) {
            QLog.i("WinkPublish-upload2-PreUploadWaitingFeat", 1, "[run] true upload");
            return Unit.INSTANCE;
        }
        throw new PreUploadException(new TaskErrorCode(TaskErrorCode.ERROR_CODE_PRE_TASK_WAITING, null, 2, null));
    }
}
