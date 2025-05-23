package com.tencent.mobileqq.zplan.polling.task;

import com.tencent.mobileqq.zootopia.api.e;
import com.tencent.mobileqq.zplan.video.api.bean.TXVideoInfo;
import com.tencent.mobileqq.zplan.video.api.bean.UpdateFrom;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \t2\u00020\u0001:\u0001\u0005B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\u000b\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/zplan/polling/task/b;", "Lcom/tencent/mobileqq/zplan/polling/task/a;", "Lcom/tencent/mobileqq/zplan/polling/task/TaskIdEnum;", "getTaskId", "", "a", "", "c", "", "b", "J", "internalTime", "<init>", "(J)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class b implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long internalTime;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u001a\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zplan/polling/task/b$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "", "Lcom/tencent/mobileqq/zplan/video/api/bean/b;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.polling.task.b$b, reason: collision with other inner class name */
    /* loaded from: classes34.dex */
    public static final class C9190b implements e<List<? extends TXVideoInfo>> {
        C9190b() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(List<TXVideoInfo> result) {
            Intrinsics.checkNotNullParameter(result, "result");
            for (TXVideoInfo tXVideoInfo : result) {
                ((zk3.a) vb3.a.f441346a.a(zk3.a.class)).B0(UpdateFrom.HEART, tXVideoInfo.getPlayInfo().getComponentId(), tXVideoInfo.getMediaInfo());
            }
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.e("HeartBeatTask", 1, "executeTask :: failed , error == " + error + " , message == " + message);
        }
    }

    public b(long j3) {
        this.internalTime = j3;
    }

    @Override // com.tencent.mobileqq.zplan.polling.task.a
    /* renamed from: a, reason: from getter */
    public long getInternalTime() {
        return this.internalTime;
    }

    @Override // com.tencent.mobileqq.zplan.polling.task.a
    public boolean c() {
        return ((zk3.a) vb3.a.f441346a.a(zk3.a.class)).J0().a().isEmpty();
    }

    @Override // com.tencent.mobileqq.zplan.polling.task.a
    public TaskIdEnum getTaskId() {
        return TaskIdEnum.LIVE_STREAM_HEART_BEAT_TASK;
    }

    @Override // com.tencent.mobileqq.zplan.polling.task.a
    public void b() {
        QLog.d("HeartBeatTask", 1, "executeTask :: start");
        bl3.a.f28625a.h(((zk3.a) vb3.a.f441346a.a(zk3.a.class)).J0().a(), new C9190b());
    }
}
