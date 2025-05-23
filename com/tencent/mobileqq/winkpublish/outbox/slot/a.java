package com.tencent.mobileqq.winkpublish.outbox.slot;

import com.tencent.mobileqq.winkpublish.outbox.task.BaseTask;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J#\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/outbox/slot/a;", "", "Lcom/tencent/mobileqq/winkpublish/outbox/task/BaseTask;", "task", "", "a", "", "expectState", "", "b", "(Lcom/tencent/mobileqq/winkpublish/outbox/task/BaseTask;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public interface a {
    boolean a(BaseTask task);

    Object b(BaseTask baseTask, int i3, Continuation<? super Unit> continuation);
}
