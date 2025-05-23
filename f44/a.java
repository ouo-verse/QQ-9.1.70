package f44;

import com.tencent.robot.draw.vb.DrawListVB;
import com.tencent.robot.draw.vb.b;
import com.tencent.robot.draw.vb.d;
import com.tencent.robot.draw.vb.delegate.DrawListUIState;
import com.tencent.robot.draw.vb.e;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import u54.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J<\u0010\u000f\u001a.\u0012*\u0012(\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b\u0012\u0006\b\u0000\u0012\u00020\u00020\u000bj\n\u0012\u0006\b\u0000\u0012\u00020\u0002`\u000e0\n2\u0006\u0010\t\u001a\u00020\bH\u0016JD\u0010\u0013\u001a6\u00122\u00120\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\u00100\u0011j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003`\u00120\n2\u0006\u0010\t\u001a\u00020\u0010H\u0016\u00a8\u0006\u0016"}, d2 = {"Lf44/a;", "Lcom/tencent/robot/draw/vb/b;", "Lcom/tencent/robot/draw/vb/e;", "Lw64/e;", "Lu54/c;", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "a", "Lcom/tencent/robot/draw/vb/c;", "host", "", "Lcom/tencent/input/base/mvicompat/c;", "Le44/a;", "Lcom/tencent/robot/draw/vb/delegate/DrawListUIState;", "Lcom/tencent/robot/draw/vb/IDrawListVBDelegate;", "b", "Lcom/tencent/robot/draw/vb/d;", "Lcom/tencent/input/base/mvicompat/e;", "Lcom/tencent/robot/draw/vb/IDrawListVMDelegate;", "c", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a implements b<e, w64.e<c>> {
    @Override // com.tencent.robot.draw.vb.b
    @NotNull
    public e a(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        return DrawListVB.INSTANCE.c(createViewParams);
    }

    @Override // com.tencent.robot.draw.vb.b
    @NotNull
    public List<com.tencent.input.base.mvicompat.c<e44.a, DrawListUIState, com.tencent.robot.draw.vb.c, ? super e>> b(@NotNull com.tencent.robot.draw.vb.c host) {
        List<com.tencent.input.base.mvicompat.c<e44.a, DrawListUIState, com.tencent.robot.draw.vb.c, ? super e>> listOf;
        Intrinsics.checkNotNullParameter(host, "host");
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new e44.b(host));
        return listOf;
    }

    @Override // com.tencent.robot.draw.vb.b
    @NotNull
    public List<com.tencent.input.base.mvicompat.e<e44.a, DrawListUIState, w64.e<c>, d>> c(@NotNull d host) {
        List<com.tencent.input.base.mvicompat.e<e44.a, DrawListUIState, w64.e<c>, d>> listOf;
        Intrinsics.checkNotNullParameter(host, "host");
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new e44.c(host));
        return listOf;
    }
}
