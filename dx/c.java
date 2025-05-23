package dx;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000f\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001f\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0012\u0012\u0006\u0010\u001d\u001a\u00020\u0012\u00a2\u0006\u0004\b\u001e\u0010\u001fB\t\b\u0016\u00a2\u0006\u0004\b\u001e\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0011\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0000H\u0096\u0002J\t\u0010\u0007\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\bH\u00d6\u0003R\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001d\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018\u00a8\u0006!"}, d2 = {"Ldx/c;", "", "", "toString", "other", "", "c", "hashCode", "", "", "equals", "d", "Ljava/lang/String;", h.F, "()Ljava/lang/String;", "k", "(Ljava/lang/String;)V", "bgName", "", "e", "J", "j", "()J", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(J)V", "startTime", "f", "i", "l", "endTime", "<init>", "(Ljava/lang/String;JJ)V", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final /* data */ class c implements Comparable<c> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String bgName;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long startTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long endTime;

    public c(@NotNull String bgName, long j3, long j16) {
        Intrinsics.checkNotNullParameter(bgName, "bgName");
        this.bgName = bgName;
        this.startTime = j3;
        this.endTime = j16;
    }

    @Override // java.lang.Comparable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(@NotNull c other) {
        Intrinsics.checkNotNullParameter(other, "other");
        long j3 = this.startTime;
        long j16 = other.startTime;
        if (j3 > j16) {
            return 1;
        }
        if (j3 < j16) {
            return -1;
        }
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof c)) {
            return false;
        }
        c cVar = (c) other;
        if (Intrinsics.areEqual(this.bgName, cVar.bgName) && this.startTime == cVar.startTime && this.endTime == cVar.endTime) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final String getBgName() {
        return this.bgName;
    }

    public int hashCode() {
        return (((this.bgName.hashCode() * 31) + androidx.fragment.app.a.a(this.startTime)) * 31) + androidx.fragment.app.a.a(this.endTime);
    }

    /* renamed from: i, reason: from getter */
    public final long getEndTime() {
        return this.endTime;
    }

    /* renamed from: j, reason: from getter */
    public final long getStartTime() {
        return this.startTime;
    }

    public final void k(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.bgName = str;
    }

    public final void l(long j3) {
        this.endTime = j3;
    }

    public final void m(long j3) {
        this.startTime = j3;
    }

    @NotNull
    public String toString() {
        return "{ZplanAvatarBgConfig bgName: " + this.bgName + ", startTime: " + this.startTime + ", endTime: " + this.endTime + "}";
    }

    public c() {
        this("", 0L, 0L);
    }
}
