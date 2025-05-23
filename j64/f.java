package j64;

import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\r\u001a\u00020\t\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t\u0012\b\b\u0002\u0010\u0012\u001a\u00020\t\u0012\b\b\u0002\u0010\u0014\u001a\u00020\t\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u000f\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0012\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\fR\u0017\u0010\u0014\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0010\u0010\f\u00a8\u0006\u0017"}, d2 = {"Lj64/f;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "()J", "cacheDuration", "b", "requestTimeout", "c", "getTypeTimeout", "typeTimeout", "d", "robotSlashCmdCacheDuration", "<init>", "(JJJJ)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final /* data */ class f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long cacheDuration;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final long requestTimeout;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final long typeTimeout;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long robotSlashCmdCacheDuration;

    public f() {
        this(0L, 0L, 0L, 0L, 15, null);
    }

    /* renamed from: a, reason: from getter */
    public final long getCacheDuration() {
        return this.cacheDuration;
    }

    /* renamed from: b, reason: from getter */
    public final long getRequestTimeout() {
        return this.requestTimeout;
    }

    /* renamed from: c, reason: from getter */
    public final long getRobotSlashCmdCacheDuration() {
        return this.robotSlashCmdCacheDuration;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof f)) {
            return false;
        }
        f fVar = (f) other;
        if (this.cacheDuration == fVar.cacheDuration && this.requestTimeout == fVar.requestTimeout && this.typeTimeout == fVar.typeTimeout && this.robotSlashCmdCacheDuration == fVar.robotSlashCmdCacheDuration) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((androidx.fragment.app.a.a(this.cacheDuration) * 31) + androidx.fragment.app.a.a(this.requestTimeout)) * 31) + androidx.fragment.app.a.a(this.typeTimeout)) * 31) + androidx.fragment.app.a.a(this.robotSlashCmdCacheDuration);
    }

    @NotNull
    public String toString() {
        return "RobotConfig{ cacheDuration = " + this.cacheDuration + ", requestTimeout = " + this.requestTimeout + ", typeTimeout = " + this.typeTimeout + ", robotSlashCmdCacheDuration = " + this.robotSlashCmdCacheDuration + "}";
    }

    public f(long j3, long j16, long j17, long j18) {
        this.cacheDuration = j3;
        this.requestTimeout = j16;
        this.typeTimeout = j17;
        this.robotSlashCmdCacheDuration = j18;
    }

    public /* synthetic */ f(long j3, long j16, long j17, long j18, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 300000L : j3, (i3 & 2) != 0 ? 5000L : j16, (i3 & 4) != 0 ? 1000L : j17, (i3 & 8) == 0 ? j18 : MiniBoxNoticeInfo.MIN_5);
    }
}
