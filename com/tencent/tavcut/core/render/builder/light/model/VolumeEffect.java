package com.tencent.tavcut.core.render.builder.light.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0002\u0010\u000bJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\rJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\rJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\rJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0010J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0010J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\nH\u00c6\u0003JV\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH\u00c6\u0001\u00a2\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\"\u001a\u00020#H\u00d6\u0001J\t\u0010$\u001a\u00020\nH\u00d6\u0001R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0012\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0015\u0010\u0010R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0016\u0010\r\u00a8\u0006%"}, d2 = {"Lcom/tencent/tavcut/core/render/builder/light/model/VolumeEffect;", "", "startOffset", "", "endOffset", "duration", "start", "", "end", "interpolationType", "", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;)V", "getDuration", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getEnd", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getEndOffset", "getInterpolationType", "()Ljava/lang/String;", "getStart", "getStartOffset", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;)Lcom/tencent/tavcut/core/render/builder/light/model/VolumeEffect;", "equals", "", "other", "hashCode", "", "toString", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final /* data */ class VolumeEffect {

    @Nullable
    private final Long duration;

    @Nullable
    private final Float end;

    @Nullable
    private final Long endOffset;

    @Nullable
    private final String interpolationType;

    @Nullable
    private final Float start;

    @Nullable
    private final Long startOffset;

    public VolumeEffect() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ VolumeEffect copy$default(VolumeEffect volumeEffect, Long l3, Long l16, Long l17, Float f16, Float f17, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            l3 = volumeEffect.startOffset;
        }
        if ((i3 & 2) != 0) {
            l16 = volumeEffect.endOffset;
        }
        Long l18 = l16;
        if ((i3 & 4) != 0) {
            l17 = volumeEffect.duration;
        }
        Long l19 = l17;
        if ((i3 & 8) != 0) {
            f16 = volumeEffect.start;
        }
        Float f18 = f16;
        if ((i3 & 16) != 0) {
            f17 = volumeEffect.end;
        }
        Float f19 = f17;
        if ((i3 & 32) != 0) {
            str = volumeEffect.interpolationType;
        }
        return volumeEffect.copy(l3, l18, l19, f18, f19, str);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Long getStartOffset() {
        return this.startOffset;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Long getEndOffset() {
        return this.endOffset;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Long getDuration() {
        return this.duration;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Float getStart() {
        return this.start;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final Float getEnd() {
        return this.end;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getInterpolationType() {
        return this.interpolationType;
    }

    @NotNull
    public final VolumeEffect copy(@Nullable Long startOffset, @Nullable Long endOffset, @Nullable Long duration, @Nullable Float start, @Nullable Float end, @Nullable String interpolationType) {
        return new VolumeEffect(startOffset, endOffset, duration, start, end, interpolationType);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof VolumeEffect) {
                VolumeEffect volumeEffect = (VolumeEffect) other;
                if (!Intrinsics.areEqual(this.startOffset, volumeEffect.startOffset) || !Intrinsics.areEqual(this.endOffset, volumeEffect.endOffset) || !Intrinsics.areEqual(this.duration, volumeEffect.duration) || !Intrinsics.areEqual((Object) this.start, (Object) volumeEffect.start) || !Intrinsics.areEqual((Object) this.end, (Object) volumeEffect.end) || !Intrinsics.areEqual(this.interpolationType, volumeEffect.interpolationType)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Nullable
    public final Long getDuration() {
        return this.duration;
    }

    @Nullable
    public final Float getEnd() {
        return this.end;
    }

    @Nullable
    public final Long getEndOffset() {
        return this.endOffset;
    }

    @Nullable
    public final String getInterpolationType() {
        return this.interpolationType;
    }

    @Nullable
    public final Float getStart() {
        return this.start;
    }

    @Nullable
    public final Long getStartOffset() {
        return this.startOffset;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        Long l3 = this.startOffset;
        int i26 = 0;
        if (l3 != null) {
            i3 = l3.hashCode();
        } else {
            i3 = 0;
        }
        int i27 = i3 * 31;
        Long l16 = this.endOffset;
        if (l16 != null) {
            i16 = l16.hashCode();
        } else {
            i16 = 0;
        }
        int i28 = (i27 + i16) * 31;
        Long l17 = this.duration;
        if (l17 != null) {
            i17 = l17.hashCode();
        } else {
            i17 = 0;
        }
        int i29 = (i28 + i17) * 31;
        Float f16 = this.start;
        if (f16 != null) {
            i18 = f16.hashCode();
        } else {
            i18 = 0;
        }
        int i36 = (i29 + i18) * 31;
        Float f17 = this.end;
        if (f17 != null) {
            i19 = f17.hashCode();
        } else {
            i19 = 0;
        }
        int i37 = (i36 + i19) * 31;
        String str = this.interpolationType;
        if (str != null) {
            i26 = str.hashCode();
        }
        return i37 + i26;
    }

    @NotNull
    public String toString() {
        return "VolumeEffect(startOffset=" + this.startOffset + ", endOffset=" + this.endOffset + ", duration=" + this.duration + ", start=" + this.start + ", end=" + this.end + ", interpolationType=" + this.interpolationType + ")";
    }

    public VolumeEffect(@Nullable Long l3, @Nullable Long l16, @Nullable Long l17, @Nullable Float f16, @Nullable Float f17, @Nullable String str) {
        this.startOffset = l3;
        this.endOffset = l16;
        this.duration = l17;
        this.start = f16;
        this.end = f17;
        this.interpolationType = str;
    }

    public /* synthetic */ VolumeEffect(Long l3, Long l16, Long l17, Float f16, Float f17, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : l3, (i3 & 2) != 0 ? null : l16, (i3 & 4) != 0 ? null : l17, (i3 & 8) != 0 ? null : f16, (i3 & 16) != 0 ? null : f17, (i3 & 32) != 0 ? null : str);
    }
}
