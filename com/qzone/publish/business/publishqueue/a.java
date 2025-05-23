package com.qzone.publish.business.publishqueue;

import com.qzone.publish.business.task.IQueueTask;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public interface a {
    CopyOnWriteArrayList<IQueueTask> a();

    void b(IQueueTask iQueueTask);

    void c(IQueueTask iQueueTask);

    void d(IQueueTask iQueueTask);

    CopyOnWriteArrayList<IQueueTask> e();

    boolean f(IQueueTask iQueueTask);

    void g(IQueueTask iQueueTask, boolean z16);

    boolean h(IQueueTask iQueueTask, boolean z16);

    void i(b bVar);

    void j(IQueueTask iQueueTask);
}
