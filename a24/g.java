package a24;

import com.tencent.qqnt.kernel.nativeinterface.MyRobotListInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\"\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u000b\u001a\u0004\b\u0005\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"La24/g;", "La24/b;", "", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/MyRobotListInfo;", "b", "Lcom/tencent/qqnt/kernel/nativeinterface/MyRobotListInfo;", "c", "()Lcom/tencent/qqnt/kernel/nativeinterface/MyRobotListInfo;", "robotInfo", "", "I", "()I", "d", "(I)V", "index", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/MyRobotListInfo;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class g extends b {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MyRobotListInfo robotInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int index;

    public g(@NotNull MyRobotListInfo robotInfo) {
        Intrinsics.checkNotNullParameter(robotInfo, "robotInfo");
        this.robotInfo = robotInfo;
    }

    @Override // a24.b
    public long a() {
        return this.robotInfo.robotUin;
    }

    /* renamed from: b, reason: from getter */
    public final int getIndex() {
        return this.index;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final MyRobotListInfo getRobotInfo() {
        return this.robotInfo;
    }

    public final void d(int i3) {
        this.index = i3;
    }
}
