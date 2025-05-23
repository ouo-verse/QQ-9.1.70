package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop;

import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\r\u001a\u00020\t\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t\u0012\b\b\u0002\u0010\u0012\u001a\u00020\t\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u000f\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0012\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/v;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", UserInfo.SEX_FEMALE, "()F", "trackHeight", "b", "trackMargin", "c", "getContentTopMargin", "contentTopMargin", "<init>", "(FFF)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.v, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class TrackConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final float trackHeight;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final float trackMargin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final float contentTopMargin;

    public TrackConfig() {
        this(0.0f, 0.0f, 0.0f, 7, null);
    }

    /* renamed from: a, reason: from getter */
    public final float getTrackHeight() {
        return this.trackHeight;
    }

    /* renamed from: b, reason: from getter */
    public final float getTrackMargin() {
        return this.trackMargin;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackConfig)) {
            return false;
        }
        TrackConfig trackConfig = (TrackConfig) other;
        if (Float.compare(this.trackHeight, trackConfig.trackHeight) == 0 && Float.compare(this.trackMargin, trackConfig.trackMargin) == 0 && Float.compare(this.contentTopMargin, trackConfig.contentTopMargin) == 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((Float.floatToIntBits(this.trackHeight) * 31) + Float.floatToIntBits(this.trackMargin)) * 31) + Float.floatToIntBits(this.contentTopMargin);
    }

    @NotNull
    public String toString() {
        return "TrackConfig(trackHeight=" + this.trackHeight + ", trackMargin=" + this.trackMargin + ", contentTopMargin=" + this.contentTopMargin + ")";
    }

    public TrackConfig(float f16, float f17, float f18) {
        this.trackHeight = f16;
        this.trackMargin = f17;
        this.contentTopMargin = f18;
    }

    public /* synthetic */ TrackConfig(float f16, float f17, float f18, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 36.0f : f16, (i3 & 2) != 0 ? 12.0f : f17, (i3 & 4) != 0 ? 5.0f : f18);
    }
}
