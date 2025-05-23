package a24;

import com.tencent.qqnt.kernel.nativeinterface.RobotActivity;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\t\u00a8\u0006\r"}, d2 = {"La24/a;", "La24/b;", "", "a", "", "toString", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotActivity;", "b", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotActivity;", "()Lcom/tencent/qqnt/kernel/nativeinterface/RobotActivity;", "robotActivity", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/RobotActivity;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a extends b {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final RobotActivity robotActivity;

    public a(@Nullable RobotActivity robotActivity) {
        this.robotActivity = robotActivity;
    }

    @Override // a24.b
    public long a() {
        return -4L;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final RobotActivity getRobotActivity() {
        return this.robotActivity;
    }

    @NotNull
    public String toString() {
        String obj;
        RobotActivity robotActivity = this.robotActivity;
        if (robotActivity == null || (obj = robotActivity.toString()) == null) {
            return "";
        }
        return obj;
    }
}
