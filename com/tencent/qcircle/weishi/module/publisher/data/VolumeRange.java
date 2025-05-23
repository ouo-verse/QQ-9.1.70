package com.tencent.qcircle.weishi.module.publisher.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.autotemplate.model.TAVVolumeRange;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\t\u0010\f\u001a\u00020\rH\u00d6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\rH\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\rH\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/qcircle/weishi/module/publisher/data/VolumeRange;", "Landroid/os/Parcelable;", "start", "", "end", "(FF)V", "getEnd", "()F", "getStart", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", WadlProxyConsts.FLAGS, "Companion", "libtavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes22.dex */
public final /* data */ class VolumeRange implements Parcelable {
    private final float end;
    private final float start;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator CREATOR = new Creator();

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qcircle/weishi/module/publisher/data/VolumeRange$Companion;", "", "()V", "from", "Lcom/tencent/qcircle/weishi/module/publisher/data/VolumeRange;", "it", "Lcom/tencent/autotemplate/model/TAVVolumeRange;", "libtavcut_debug"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes22.dex */
    public static final class Companion {
        Companion() {
        }

        @NotNull
        public final VolumeRange from(@NotNull TAVVolumeRange it) {
            Intrinsics.checkParameterIsNotNull(it, "it");
            return new VolumeRange(it.start, it.end);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes22.dex */
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Object createFromParcel(@NotNull Parcel in5) {
            Intrinsics.checkParameterIsNotNull(in5, "in");
            return new VolumeRange(in5.readFloat(), in5.readFloat());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Object[] newArray(int i3) {
            return new VolumeRange[i3];
        }
    }

    public VolumeRange(float f16, float f17) {
        this.start = f16;
        this.end = f17;
    }

    public static /* synthetic */ VolumeRange copy$default(VolumeRange volumeRange, float f16, float f17, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f16 = volumeRange.start;
        }
        if ((i3 & 2) != 0) {
            f17 = volumeRange.end;
        }
        return volumeRange.copy(f16, f17);
    }

    /* renamed from: component1, reason: from getter */
    public final float getStart() {
        return this.start;
    }

    /* renamed from: component2, reason: from getter */
    public final float getEnd() {
        return this.end;
    }

    @NotNull
    public final VolumeRange copy(float start, float end) {
        return new VolumeRange(start, end);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof VolumeRange) {
                VolumeRange volumeRange = (VolumeRange) other;
                if (Float.compare(this.start, volumeRange.start) != 0 || Float.compare(this.end, volumeRange.end) != 0) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final float getEnd() {
        return this.end;
    }

    public final float getStart() {
        return this.start;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.start) * 31) + Float.floatToIntBits(this.end);
    }

    @NotNull
    public String toString() {
        return "VolumeRange(start=" + this.start + ", end=" + this.end + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeFloat(this.start);
        parcel.writeFloat(this.end);
    }
}
