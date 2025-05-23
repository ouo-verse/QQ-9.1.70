package m94;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0001\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\f\u001a\u00020\u00018\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\t\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lm94/i;", "Lm94/h;", "Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/b;", "task", "Lm94/e;", "errorMsg", "", "a", "b", "Lm94/h;", "c", "()Lm94/h;", "originCb", "<init>", "(Lm94/h;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public class i implements h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final h originCb;

    public i(h originCb) {
        Intrinsics.checkNotNullParameter(originCb, "originCb");
        this.originCb = originCb;
    }

    @Override // m94.h
    public void a(com.tencent.sqshow.zootopia.nativeui.data.dress.task.b task, DressErrorMsg errorMsg) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        this.originCb.a(task, errorMsg);
    }

    @Override // m94.h
    public void b(com.tencent.sqshow.zootopia.nativeui.data.dress.task.b task) {
        Intrinsics.checkNotNullParameter(task, "task");
        this.originCb.b(task);
    }

    /* renamed from: c, reason: from getter */
    public final h getOriginCb() {
        return this.originCb;
    }
}
