package a24;

import com.tencent.qqnt.kernel.nativeinterface.RobotSummary;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\r\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001a\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u0005\u0010\u0010\"\u0004\b\u0019\u0010\u0012\u00a8\u0006\u001d"}, d2 = {"La24/d;", "La24/b;", "", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotSummary;", "b", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotSummary;", "d", "()Lcom/tencent/qqnt/kernel/nativeinterface/RobotSummary;", tl.h.F, "(Lcom/tencent/qqnt/kernel/nativeinterface/RobotSummary;)V", "summary", "", "c", "Ljava/lang/String;", "getSelfUid", "()Ljava/lang/String;", "f", "(Ljava/lang/String;)V", "selfUid", "J", "()J", "g", "(J)V", "selfUin", "e", "selfNick", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class d extends b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long selfUin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private RobotSummary summary = new RobotSummary();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String selfUid = "";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String selfNick = "";

    @Override // a24.b
    public long a() {
        return -1L;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getSelfNick() {
        return this.selfNick;
    }

    /* renamed from: c, reason: from getter */
    public final long getSelfUin() {
        return this.selfUin;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final RobotSummary getSummary() {
        return this.summary;
    }

    public final void e(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.selfNick = str;
    }

    public final void f(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.selfUid = str;
    }

    public final void g(long j3) {
        this.selfUin = j3;
    }

    public final void h(@NotNull RobotSummary robotSummary) {
        Intrinsics.checkNotNullParameter(robotSummary, "<set-?>");
        this.summary = robotSummary;
    }
}
