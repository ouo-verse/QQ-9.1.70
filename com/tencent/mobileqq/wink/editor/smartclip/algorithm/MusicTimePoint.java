package com.tencent.mobileqq.wink.editor.smartclip.algorithm;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0017B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u00c6\u0001J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/smartclip/algorithm/MusicTimePoint;", "", "Lcom/tencent/mobileqq/wink/editor/smartclip/algorithm/MusicTimePoint$MusicTimePointType;", "type", "", "timeInMillis", "a", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/wink/editor/smartclip/algorithm/MusicTimePoint$MusicTimePointType;", "d", "()Lcom/tencent/mobileqq/wink/editor/smartclip/algorithm/MusicTimePoint$MusicTimePointType;", "b", "J", "c", "()J", "<init>", "(Lcom/tencent/mobileqq/wink/editor/smartclip/algorithm/MusicTimePoint$MusicTimePointType;J)V", "MusicTimePointType", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final /* data */ class MusicTimePoint {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final MusicTimePointType type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final long timeInMillis;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/smartclip/algorithm/MusicTimePoint$MusicTimePointType;", "", "(Ljava/lang/String;I)V", "BEAT_TYPE_PUCKING_DRUM", "BEAT_TYPE_SLOW_RHYTHM", "BEAT_TYPE_PARAGRAPH", "BEAT_TYPE_HIGHLIGHT_VAL", "BEAT_TYPE_FAST_RHYTHM", "BEAT_TYPE_OTHER", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public enum MusicTimePointType {
        BEAT_TYPE_PUCKING_DRUM,
        BEAT_TYPE_SLOW_RHYTHM,
        BEAT_TYPE_PARAGRAPH,
        BEAT_TYPE_HIGHLIGHT_VAL,
        BEAT_TYPE_FAST_RHYTHM,
        BEAT_TYPE_OTHER
    }

    public MusicTimePoint(@NotNull MusicTimePointType type, long j3) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.timeInMillis = j3;
    }

    public static /* synthetic */ MusicTimePoint b(MusicTimePoint musicTimePoint, MusicTimePointType musicTimePointType, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            musicTimePointType = musicTimePoint.type;
        }
        if ((i3 & 2) != 0) {
            j3 = musicTimePoint.timeInMillis;
        }
        return musicTimePoint.a(musicTimePointType, j3);
    }

    @NotNull
    public final MusicTimePoint a(@NotNull MusicTimePointType type, long timeInMillis) {
        Intrinsics.checkNotNullParameter(type, "type");
        return new MusicTimePoint(type, timeInMillis);
    }

    /* renamed from: c, reason: from getter */
    public final long getTimeInMillis() {
        return this.timeInMillis;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final MusicTimePointType getType() {
        return this.type;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MusicTimePoint)) {
            return false;
        }
        MusicTimePoint musicTimePoint = (MusicTimePoint) other;
        if (this.type == musicTimePoint.type && this.timeInMillis == musicTimePoint.timeInMillis) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.type.hashCode() * 31) + androidx.fragment.app.a.a(this.timeInMillis);
    }

    @NotNull
    public String toString() {
        return "MusicTimePoint(type=" + this.type + ", timeInMillis=" + this.timeInMillis + ")";
    }
}
