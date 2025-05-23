package fy2;

import androidx.annotation.RestrictTo;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001B+\b\u0007\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0014\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u0019\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\t\u0010\u0017\"\u0004\b\u0015\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lfy2/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "launchId", "c", "vid", "", "J", "getStartTime", "()J", "startTime", "d", "I", "()I", "(I)V", "duration", "<init>", "(Ljava/lang/String;Ljava/lang/String;JI)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* renamed from: fy2.a, reason: from toString */
/* loaded from: classes19.dex */
public final /* data */ class TVideoPlayRecordItem {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String launchId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String vid;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final long startTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private int duration;

    @JvmOverloads
    public TVideoPlayRecordItem(@NotNull String launchId, @NotNull String vid, long j3, int i3) {
        Intrinsics.checkNotNullParameter(launchId, "launchId");
        Intrinsics.checkNotNullParameter(vid, "vid");
        this.launchId = launchId;
        this.vid = vid;
        this.startTime = j3;
        this.duration = i3;
    }

    /* renamed from: a, reason: from getter */
    public final int getDuration() {
        return this.duration;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getLaunchId() {
        return this.launchId;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getVid() {
        return this.vid;
    }

    public final void d(int i3) {
        this.duration = i3;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TVideoPlayRecordItem)) {
            return false;
        }
        TVideoPlayRecordItem tVideoPlayRecordItem = (TVideoPlayRecordItem) other;
        if (Intrinsics.areEqual(this.launchId, tVideoPlayRecordItem.launchId) && Intrinsics.areEqual(this.vid, tVideoPlayRecordItem.vid) && this.startTime == tVideoPlayRecordItem.startTime && this.duration == tVideoPlayRecordItem.duration) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.launchId.hashCode() * 31) + this.vid.hashCode()) * 31) + androidx.fragment.app.a.a(this.startTime)) * 31) + this.duration;
    }

    @NotNull
    public String toString() {
        return "TVideoPlayRecordItem(launchId=" + this.launchId + ", vid=" + this.vid + ", startTime=" + this.startTime + ", duration=" + this.duration + ")";
    }

    public /* synthetic */ TVideoPlayRecordItem(String str, String str2, long j3, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, j3, (i16 & 8) != 0 ? 0 : i3);
    }
}
