package k34;

import com.tencent.qqnt.kernel.nativeinterface.RobotBase;
import k34.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lk34/c;", "Lk34/a;", "", "getItemType", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotBase;", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotBase;", "a", "()Lcom/tencent/qqnt/kernel/nativeinterface/RobotBase;", "robotBase", "", "e", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "troopUin", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/RobotBase;Ljava/lang/String;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class c implements a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RobotBase robotBase;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String troopUin;

    public c(@NotNull RobotBase robotBase, @NotNull String troopUin) {
        Intrinsics.checkNotNullParameter(robotBase, "robotBase");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        this.robotBase = robotBase;
        this.troopUin = troopUin;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final RobotBase getRobotBase() {
        return this.robotBase;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getTroopUin() {
        return this.troopUin;
    }

    @Override // k34.a
    @NotNull
    public String getItemId() {
        return a.C10631a.a(this);
    }

    @Override // k34.a
    public int getItemType() {
        return 6;
    }
}
