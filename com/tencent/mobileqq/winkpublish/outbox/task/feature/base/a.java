package com.tencent.mobileqq.winkpublish.outbox.task.feature.base;

import com.tencent.mobileqq.winkpublish.outbox.task.TaskContext;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/base/a;", "", "Lcom/tencent/mobileqq/winkpublish/outbox/task/TaskContext;", "taskContext", "", "a", "(Lcom/tencent/mobileqq/winkpublish/outbox/task/TaskContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public interface a {
    Object a(TaskContext taskContext, Continuation<? super Unit> continuation);
}
