package com.tencent.mobileqq.winkpublish.outbox.slot;

import com.tencent.mobileqq.winkpublish.outbox.task.BaseTask;
import java.util.List;
import kotlin.Metadata;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0006\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0002H&J\b\u0010\b\u001a\u00020\u0002H&J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH&J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\tH&J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\tH&J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\tH&J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\nH&J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\nH&\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/outbox/slot/b;", "", "Lcom/tencent/mobileqq/winkpublish/outbox/slot/a;", "j", "Lcom/tencent/mobileqq/winkpublish/outbox/slot/WaitingQueueSlot;", "b", "g", "d", h.F, "", "Lcom/tencent/mobileqq/winkpublish/outbox/task/BaseTask;", "getAllTasks", "e", "a", "f", "task", "", "i", "c", "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public interface b {
    List<BaseTask> a();

    WaitingQueueSlot b();

    void c(BaseTask task);

    a d();

    List<BaseTask> e();

    List<BaseTask> f();

    a g();

    List<BaseTask> getAllTasks();

    a h();

    void i(BaseTask task);

    a j();
}
