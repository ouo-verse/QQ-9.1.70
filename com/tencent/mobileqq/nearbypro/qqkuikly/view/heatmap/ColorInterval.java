package com.tencent.mobileqq.nearbypro.qqkuikly.view.heatmap;

import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/qqkuikly/view/heatmap/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "colorStart", "colorEnd", "", "c", UserInfo.SEX_FEMALE, "()F", "duration", "<init>", "(IIF)V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.nearbypro.qqkuikly.view.heatmap.a, reason: from toString */
/* loaded from: classes15.dex */
final /* data */ class ColorInterval {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int colorStart;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int colorEnd;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final float duration;

    public ColorInterval(int i3, int i16, float f16) {
        this.colorStart = i3;
        this.colorEnd = i16;
        this.duration = f16;
    }

    /* renamed from: a, reason: from getter */
    public final int getColorEnd() {
        return this.colorEnd;
    }

    /* renamed from: b, reason: from getter */
    public final int getColorStart() {
        return this.colorStart;
    }

    /* renamed from: c, reason: from getter */
    public final float getDuration() {
        return this.duration;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ColorInterval)) {
            return false;
        }
        ColorInterval colorInterval = (ColorInterval) other;
        if (this.colorStart == colorInterval.colorStart && this.colorEnd == colorInterval.colorEnd && Float.compare(this.duration, colorInterval.duration) == 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.colorStart * 31) + this.colorEnd) * 31) + Float.floatToIntBits(this.duration);
    }

    @NotNull
    public String toString() {
        return "ColorInterval(colorStart=" + this.colorStart + ", colorEnd=" + this.colorEnd + ", duration=" + this.duration + ")";
    }
}
