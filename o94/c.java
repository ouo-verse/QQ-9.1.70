package o94;

import com.tencent.sqshow.zootopia.nativeui.data.dress.task.DressTaskChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m94.i;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"Lo94/c;", "Lo94/a;", "Lm94/a;", "l", "", "toString", "Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/d;", "dressTaskChannel", "Lm94/i;", "callback", "<init>", "(Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/d;Lm94/i;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class c extends a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(DressTaskChannel dressTaskChannel, i callback) {
        super(dressTaskChannel, "ResetDressToSavedTask", callback);
        Intrinsics.checkNotNullParameter(dressTaskChannel, "dressTaskChannel");
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    @Override // o94.a
    public m94.a l() {
        return com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.w().b();
    }

    public String toString() {
        return "ResetDressToSavedTask, " + getCom.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet.KEY_TASKID java.lang.String();
    }
}
