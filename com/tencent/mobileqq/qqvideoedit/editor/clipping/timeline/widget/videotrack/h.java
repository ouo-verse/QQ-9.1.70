package com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u0012\u0006\u0010\u0019\u001a\u00020\u0004\u0012\u0006\u0010\u001b\u001a\u00020\u0004\u0012\u0006\u0010\u001c\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u000fR\u0017\u0010\u0015\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u0017\u0010\u0017\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\r\u001a\u0004\b\u0014\u0010\u000fR\u0017\u0010\u0019\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\r\u001a\u0004\b\u0016\u0010\u000fR\u0017\u0010\u001b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\r\u001a\u0004\b\u0018\u0010\u000fR\u0017\u0010\u001c\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u001a\u0010\u000f\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/h;", "", "", "a", "", tl.h.F, "", "toString", "", "hashCode", "other", "", "equals", "J", "i", "()J", "timelineStartTimeUs", "b", "g", "timelineDurationUs", "c", "scaleDurationUs", "d", "selectDurationUs", "e", "selectStartTimeUs", "f", "sourceDurationUs", "sourceStartTimeUs", "<init>", "(JJJJJJJ)V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final /* data */ class h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final long timelineStartTimeUs;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final long timelineDurationUs;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final long scaleDurationUs;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long selectDurationUs;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final long selectStartTimeUs;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final long sourceDurationUs;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final long sourceStartTimeUs;

    public h(long j3, long j16, long j17, long j18, long j19, long j26, long j27) {
        this.timelineStartTimeUs = j3;
        this.timelineDurationUs = j16;
        this.scaleDurationUs = j17;
        this.selectDurationUs = j18;
        this.selectStartTimeUs = j19;
        this.sourceDurationUs = j26;
        this.sourceStartTimeUs = j27;
    }

    public final float a() {
        long j3 = this.selectDurationUs;
        if (j3 == 0) {
            return 1.0f;
        }
        return ((float) this.scaleDurationUs) / ((float) j3);
    }

    /* renamed from: b, reason: from getter */
    public final long getScaleDurationUs() {
        return this.scaleDurationUs;
    }

    /* renamed from: c, reason: from getter */
    public final long getSelectDurationUs() {
        return this.selectDurationUs;
    }

    /* renamed from: d, reason: from getter */
    public final long getSelectStartTimeUs() {
        return this.selectStartTimeUs;
    }

    /* renamed from: e, reason: from getter */
    public final long getSourceDurationUs() {
        return this.sourceDurationUs;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof h)) {
            return false;
        }
        h hVar = (h) other;
        if (this.timelineStartTimeUs == hVar.timelineStartTimeUs && this.timelineDurationUs == hVar.timelineDurationUs && this.scaleDurationUs == hVar.scaleDurationUs && this.selectDurationUs == hVar.selectDurationUs && this.selectStartTimeUs == hVar.selectStartTimeUs && this.sourceDurationUs == hVar.sourceDurationUs && this.sourceStartTimeUs == hVar.sourceStartTimeUs) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final long getSourceStartTimeUs() {
        return this.sourceStartTimeUs;
    }

    /* renamed from: g, reason: from getter */
    public final long getTimelineDurationUs() {
        return this.timelineDurationUs;
    }

    public final long h() {
        return this.timelineStartTimeUs + this.timelineDurationUs;
    }

    public int hashCode() {
        return (((((((((((androidx.fragment.app.a.a(this.timelineStartTimeUs) * 31) + androidx.fragment.app.a.a(this.timelineDurationUs)) * 31) + androidx.fragment.app.a.a(this.scaleDurationUs)) * 31) + androidx.fragment.app.a.a(this.selectDurationUs)) * 31) + androidx.fragment.app.a.a(this.selectStartTimeUs)) * 31) + androidx.fragment.app.a.a(this.sourceDurationUs)) * 31) + androidx.fragment.app.a.a(this.sourceStartTimeUs);
    }

    /* renamed from: i, reason: from getter */
    public final long getTimelineStartTimeUs() {
        return this.timelineStartTimeUs;
    }

    @NotNull
    public String toString() {
        return "timelineStartTimeUs=" + this.timelineStartTimeUs + " timelineDurationUs=" + this.timelineDurationUs + " selectStartTimeUs=" + this.selectStartTimeUs + " selectDurationUs=" + this.selectDurationUs + " sourceStartTimeUs=" + this.sourceStartTimeUs + " sourceDurationUs=" + this.sourceDurationUs;
    }
}
