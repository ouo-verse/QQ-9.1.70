package n94;

import com.tencent.sqshow.zootopia.nativeui.data.dress.task.DressTaskChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m94.i;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u000e"}, d2 = {"Ln94/c;", "Ln94/b;", "Lm94/a;", "l", "", "toString", "Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/d;", "dressTaskChannel", "", "targetSlot", "Lm94/i;", "callback", "<init>", "(Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/d;ILm94/i;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class c extends b {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(DressTaskChannel dressTaskChannel, int i3, i callback) {
        super(dressTaskChannel, i3, "ResetColorInfoToDefaultTask", callback);
        Intrinsics.checkNotNullParameter(dressTaskChannel, "dressTaskChannel");
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    @Override // n94.b
    public m94.a l() {
        return com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.p().b();
    }

    public String toString() {
        return "ResetColorInfoToDefaultTask, " + getCom.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet.KEY_TASKID java.lang.String() + ", slot:" + getTargetSlot();
    }
}
