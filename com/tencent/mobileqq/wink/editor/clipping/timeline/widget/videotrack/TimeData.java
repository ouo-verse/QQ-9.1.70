package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u00a2\u0006\u0004\b!\u0010\"J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\t\u0010\u0006\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0007\u001a\u00020\u0004H\u00c6\u0003JO\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u0004H\u00c6\u0001J\t\u0010\u0011\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0012H\u00d6\u0001J\u0013\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u001a\u0010\u0019R\u0017\u0010\n\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019R\u0017\u0010\u000b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u001e\u0010\u0019R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u001f\u0010\u0019R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0017\u001a\u0004\b \u0010\u0019\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/h;", "", "", "e", "", "l", "a", "b", "timelineStartTimeUs", "timelineDurationUs", "scaleDurationUs", "selectDurationUs", "selectStartTimeUs", "sourceDurationUs", "sourceStartTimeUs", "c", "", "toString", "", "hashCode", "other", "", "equals", "J", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()J", "k", "f", "d", "g", tl.h.F, "i", "j", "<init>", "(JJJJJJJ)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.h, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class TimeData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final long timelineStartTimeUs;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final long timelineDurationUs;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final long scaleDurationUs;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final long selectDurationUs;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final long selectStartTimeUs;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final long sourceDurationUs;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final long sourceStartTimeUs;

    public TimeData(long j3, long j16, long j17, long j18, long j19, long j26, long j27) {
        this.timelineStartTimeUs = j3;
        this.timelineDurationUs = j16;
        this.scaleDurationUs = j17;
        this.selectDurationUs = j18;
        this.selectStartTimeUs = j19;
        this.sourceDurationUs = j26;
        this.sourceStartTimeUs = j27;
    }

    public static /* synthetic */ TimeData d(TimeData timeData, long j3, long j16, long j17, long j18, long j19, long j26, long j27, int i3, Object obj) {
        long j28;
        long j29;
        long j36;
        long j37;
        long j38;
        long j39;
        long j46;
        if ((i3 & 1) != 0) {
            j28 = timeData.timelineStartTimeUs;
        } else {
            j28 = j3;
        }
        if ((i3 & 2) != 0) {
            j29 = timeData.timelineDurationUs;
        } else {
            j29 = j16;
        }
        if ((i3 & 4) != 0) {
            j36 = timeData.scaleDurationUs;
        } else {
            j36 = j17;
        }
        if ((i3 & 8) != 0) {
            j37 = timeData.selectDurationUs;
        } else {
            j37 = j18;
        }
        if ((i3 & 16) != 0) {
            j38 = timeData.selectStartTimeUs;
        } else {
            j38 = j19;
        }
        if ((i3 & 32) != 0) {
            j39 = timeData.sourceDurationUs;
        } else {
            j39 = j26;
        }
        if ((i3 & 64) != 0) {
            j46 = timeData.sourceStartTimeUs;
        } else {
            j46 = j27;
        }
        return timeData.c(j28, j29, j36, j37, j38, j39, j46);
    }

    /* renamed from: a, reason: from getter */
    public final long getScaleDurationUs() {
        return this.scaleDurationUs;
    }

    /* renamed from: b, reason: from getter */
    public final long getSelectDurationUs() {
        return this.selectDurationUs;
    }

    @NotNull
    public final TimeData c(long timelineStartTimeUs, long timelineDurationUs, long scaleDurationUs, long selectDurationUs, long selectStartTimeUs, long sourceDurationUs, long sourceStartTimeUs) {
        return new TimeData(timelineStartTimeUs, timelineDurationUs, scaleDurationUs, selectDurationUs, selectStartTimeUs, sourceDurationUs, sourceStartTimeUs);
    }

    public final float e() {
        long j3 = this.selectDurationUs;
        if (j3 == 0) {
            return 1.0f;
        }
        return ((float) this.scaleDurationUs) / ((float) j3);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TimeData)) {
            return false;
        }
        TimeData timeData = (TimeData) other;
        if (this.timelineStartTimeUs == timeData.timelineStartTimeUs && this.timelineDurationUs == timeData.timelineDurationUs && this.scaleDurationUs == timeData.scaleDurationUs && this.selectDurationUs == timeData.selectDurationUs && this.selectStartTimeUs == timeData.selectStartTimeUs && this.sourceDurationUs == timeData.sourceDurationUs && this.sourceStartTimeUs == timeData.sourceStartTimeUs) {
            return true;
        }
        return false;
    }

    public final long f() {
        return this.scaleDurationUs;
    }

    public final long g() {
        return this.selectDurationUs;
    }

    /* renamed from: h, reason: from getter */
    public final long getSelectStartTimeUs() {
        return this.selectStartTimeUs;
    }

    public int hashCode() {
        return (((((((((((androidx.fragment.app.a.a(this.timelineStartTimeUs) * 31) + androidx.fragment.app.a.a(this.timelineDurationUs)) * 31) + androidx.fragment.app.a.a(this.scaleDurationUs)) * 31) + androidx.fragment.app.a.a(this.selectDurationUs)) * 31) + androidx.fragment.app.a.a(this.selectStartTimeUs)) * 31) + androidx.fragment.app.a.a(this.sourceDurationUs)) * 31) + androidx.fragment.app.a.a(this.sourceStartTimeUs);
    }

    /* renamed from: i, reason: from getter */
    public final long getSourceDurationUs() {
        return this.sourceDurationUs;
    }

    /* renamed from: j, reason: from getter */
    public final long getSourceStartTimeUs() {
        return this.sourceStartTimeUs;
    }

    /* renamed from: k, reason: from getter */
    public final long getTimelineDurationUs() {
        return this.timelineDurationUs;
    }

    public final long l() {
        return this.timelineStartTimeUs + this.timelineDurationUs;
    }

    /* renamed from: m, reason: from getter */
    public final long getTimelineStartTimeUs() {
        return this.timelineStartTimeUs;
    }

    @NotNull
    public String toString() {
        return "TimeData(timelineStartTimeUs=" + this.timelineStartTimeUs + ", timelineDurationUs=" + this.timelineDurationUs + ", scaleDurationUs=" + this.scaleDurationUs + ", selectDurationUs=" + this.selectDurationUs + ", selectStartTimeUs=" + this.selectStartTimeUs + ", sourceDurationUs=" + this.sourceDurationUs + ", sourceStartTimeUs=" + this.sourceStartTimeUs + ")";
    }
}
