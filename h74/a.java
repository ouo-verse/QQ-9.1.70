package h74;

import com.tencent.robot.write.vb.WriteListVB;
import com.tencent.robot.write.vb.b;
import com.tencent.robot.write.vb.d;
import com.tencent.robot.write.vb.delegate.WriteListUIState;
import com.tencent.robot.write.vb.delegate.WriteListVBDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import u54.c;
import w64.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J<\u0010\u000f\u001a.\u0012*\u0012(\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b\u0012\u0006\b\u0000\u0012\u00020\u00020\u000bj\n\u0012\u0006\b\u0000\u0012\u00020\u0002`\u000e0\n2\u0006\u0010\t\u001a\u00020\bH\u0016JD\u0010\u0013\u001a6\u00122\u00120\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\u00100\u0011j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003`\u00120\n2\u0006\u0010\t\u001a\u00020\u0010H\u0016\u00a8\u0006\u0016"}, d2 = {"Lh74/a;", "Lcom/tencent/robot/write/vb/a;", "Lcom/tencent/robot/write/vb/d;", "Lw64/e;", "Lu54/c;", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "a", "Lcom/tencent/robot/write/vb/b;", "host", "", "Lcom/tencent/input/base/mvicompat/c;", "Lcom/tencent/robot/write/vb/delegate/a;", "Lcom/tencent/robot/write/vb/delegate/WriteListUIState;", "Lcom/tencent/robot/write/vb/IWriteListVBDelegate;", "b", "Lcom/tencent/robot/write/vb/c;", "Lcom/tencent/input/base/mvicompat/e;", "Lcom/tencent/robot/write/vb/IWriteListVMDelegate;", "c", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a implements com.tencent.robot.write.vb.a<d, e<c>> {
    @Override // com.tencent.robot.write.vb.a
    @NotNull
    public d a(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        return WriteListVB.INSTANCE.c(createViewParams);
    }

    @Override // com.tencent.robot.write.vb.a
    @NotNull
    public List<com.tencent.input.base.mvicompat.c<com.tencent.robot.write.vb.delegate.a, WriteListUIState, b, ? super d>> b(@NotNull b host) {
        List<com.tencent.input.base.mvicompat.c<com.tencent.robot.write.vb.delegate.a, WriteListUIState, b, ? super d>> listOf;
        Intrinsics.checkNotNullParameter(host, "host");
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new WriteListVBDelegate(host));
        return listOf;
    }

    @Override // com.tencent.robot.write.vb.a
    @NotNull
    public List<com.tencent.input.base.mvicompat.e<com.tencent.robot.write.vb.delegate.a, WriteListUIState, e<c>, com.tencent.robot.write.vb.c>> c(@NotNull com.tencent.robot.write.vb.c host) {
        List<com.tencent.input.base.mvicompat.e<com.tencent.robot.write.vb.delegate.a, WriteListUIState, e<c>, com.tencent.robot.write.vb.c>> listOf;
        Intrinsics.checkNotNullParameter(host, "host");
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new com.tencent.robot.write.vb.delegate.b(host));
        return listOf;
    }
}
