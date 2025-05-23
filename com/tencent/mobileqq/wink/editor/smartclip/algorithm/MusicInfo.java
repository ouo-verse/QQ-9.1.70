package com.tencent.mobileqq.wink.editor.smartclip.algorithm;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b\n\u0010\rR\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/smartclip/algorithm/f;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "b", "()J", "selectedStartInMillis", "selectedDurationInMillis", "", "Lcom/tencent/mobileqq/wink/editor/smartclip/algorithm/MusicTimePoint;", "c", "Ljava/util/List;", "()Ljava/util/List;", "timePoints", "<init>", "(JJLjava/util/List;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.editor.smartclip.algorithm.f, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class MusicInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final long selectedStartInMillis;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final long selectedDurationInMillis;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<MusicTimePoint> timePoints;

    public MusicInfo(long j3, long j16, @NotNull List<MusicTimePoint> timePoints) {
        Intrinsics.checkNotNullParameter(timePoints, "timePoints");
        this.selectedStartInMillis = j3;
        this.selectedDurationInMillis = j16;
        this.timePoints = timePoints;
    }

    /* renamed from: a, reason: from getter */
    public final long getSelectedDurationInMillis() {
        return this.selectedDurationInMillis;
    }

    /* renamed from: b, reason: from getter */
    public final long getSelectedStartInMillis() {
        return this.selectedStartInMillis;
    }

    @NotNull
    public final List<MusicTimePoint> c() {
        return this.timePoints;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MusicInfo)) {
            return false;
        }
        MusicInfo musicInfo = (MusicInfo) other;
        if (this.selectedStartInMillis == musicInfo.selectedStartInMillis && this.selectedDurationInMillis == musicInfo.selectedDurationInMillis && Intrinsics.areEqual(this.timePoints, musicInfo.timePoints)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((androidx.fragment.app.a.a(this.selectedStartInMillis) * 31) + androidx.fragment.app.a.a(this.selectedDurationInMillis)) * 31) + this.timePoints.hashCode();
    }

    @NotNull
    public String toString() {
        return "MusicInfo(selectedStartInMillis=" + this.selectedStartInMillis + ", selectedDurationInMillis=" + this.selectedDurationInMillis + ", timePoints=" + this.timePoints + ")";
    }
}
