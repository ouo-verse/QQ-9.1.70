package com.tencent.mobileqq.guild.nt.qcircle.api.impl;

import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.guild.nt.qcircle.api.IOutboxTaskQueueApi;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.outbox.QCircleReportOutboxTask;
import cooperation.qqcircle.report.outbox.QCircleReportOutboxTaskQueue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/nt/qcircle/api/impl/OutboxTaskQueueApiImpl;", "Lcom/tencent/mobileqq/guild/nt/qcircle/api/IOutboxTaskQueueApi;", "", "init", "", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/mobileqq/guild/nt/qcircle/api/IOutboxTaskQueueApi$a;", ISchemeApi.KEY_ENABLE_NEW_TASK, "addPausedTask", "<init>", "()V", "a", "qqguild-boundaries-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class OutboxTaskQueueApiImpl implements IOutboxTaskQueueApi {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/nt/qcircle/api/impl/OutboxTaskQueueApiImpl$a;", "Lcom/tencent/mobileqq/guild/nt/qcircle/api/IOutboxTaskQueueApi$a;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/biz/richframework/network/request/VSBaseRequest;", "a", "Lcom/tencent/biz/richframework/network/request/VSBaseRequest;", "()Lcom/tencent/biz/richframework/network/request/VSBaseRequest;", Const.BUNDLE_KEY_REQUEST, "<init>", "(Lcom/tencent/biz/richframework/network/request/VSBaseRequest;)V", "qqguild-boundaries-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.nt.qcircle.api.impl.OutboxTaskQueueApiImpl$a, reason: from toString */
    /* loaded from: classes14.dex */
    public static final /* data */ class Task implements IOutboxTaskQueueApi.a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final VSBaseRequest request;

        public Task(@NotNull VSBaseRequest request) {
            Intrinsics.checkNotNullParameter(request, "request");
            this.request = request;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final VSBaseRequest getRequest() {
            return this.request;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof Task) && Intrinsics.areEqual(this.request, ((Task) other).request)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.request.hashCode();
        }

        @NotNull
        public String toString() {
            return "Task(request=" + this.request + ')';
        }
    }

    @Override // com.tencent.mobileqq.guild.nt.qcircle.api.IOutboxTaskQueueApi
    public void addPausedTask(@NotNull IOutboxTaskQueueApi.a newTask) {
        Intrinsics.checkNotNullParameter(newTask, "newTask");
        if (newTask instanceof Task) {
            QCircleReportOutboxTaskQueue.getInstance().addPausedTask(new QCircleReportOutboxTask(((Task) newTask).getRequest()));
            return;
        }
        throw new IllegalArgumentException("newTask must be Task".toString());
    }

    @Override // com.tencent.mobileqq.guild.nt.qcircle.api.IOutboxTaskQueueApi
    public void init() {
        QLog.d(QCircleReportOutboxTaskQueue.TAG, 1, "initOutbox...");
        QCircleReportOutboxTaskQueue.getInstance();
    }

    @Override // com.tencent.mobileqq.guild.nt.qcircle.api.IOutboxTaskQueueApi
    @NotNull
    public IOutboxTaskQueueApi.a newTask(@NotNull Object request) {
        Intrinsics.checkNotNullParameter(request, "request");
        if (request instanceof VSBaseRequest) {
            return new Task((VSBaseRequest) request);
        }
        throw new IllegalArgumentException("request must be VSBaseRequest".toString());
    }
}
