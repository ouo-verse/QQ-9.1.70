package f64;

import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mvi.api.runtime.b;
import com.tencent.robot.slash.dialog.content.list.CommonListExecutor;
import com.tencent.robot.widget.list.vb.e;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u000f\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\f"}, d2 = {"Lf64/b;", "Lcom/tencent/mvi/api/runtime/b;", BdhLogUtil.LogTag.Tag_Conn, "Lc74/c;", "context", "Ljava/util/concurrent/Executor;", "g", "(Lcom/tencent/mvi/api/runtime/b;)Ljava/util/concurrent/Executor;", "Lcom/tencent/robot/widget/list/vb/e;", "host", "<init>", "(Lcom/tencent/robot/widget/list/vb/e;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b<C extends com.tencent.mvi.api.runtime.b> extends c74.c<C> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull e host) {
        super(host);
        Intrinsics.checkNotNullParameter(host, "host");
    }

    @Override // c74.c
    @NotNull
    public Executor g(@NotNull C context) {
        Intrinsics.checkNotNullParameter(context, "context");
        LifecycleOwner d16 = context.d();
        Intrinsics.checkNotNullExpressionValue(d16, "context.lifecycleOwner");
        return new CommonListExecutor(d16);
    }
}
