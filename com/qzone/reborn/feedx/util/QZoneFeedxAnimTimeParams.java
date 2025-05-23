package com.qzone.reborn.feedx.util;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J1\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0002H\u00c6\u0001J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\t\u0010\u000b\u001a\u00020\nH\u00d6\u0001J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0004\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u0017\u0010\u0005\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011R\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011\u00a8\u0006\u0018"}, d2 = {"Lcom/qzone/reborn/feedx/util/p;", "", "", "totalDuration", "totalStartDelay", "alphaDuration", "alphaStartDelay", "a", "", "toString", "", "hashCode", "other", "", "equals", "J", "e", "()J", "b", "f", "c", "d", "<init>", "(JJJJ)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.qzone.reborn.feedx.util.p, reason: from toString */
/* loaded from: classes37.dex */
public final /* data */ class QZoneFeedxAnimTimeParams {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final long totalDuration;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final long totalStartDelay;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final long alphaDuration;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final long alphaStartDelay;

    public QZoneFeedxAnimTimeParams() {
        this(0L, 0L, 0L, 0L, 15, null);
    }

    public final QZoneFeedxAnimTimeParams a(long totalDuration, long totalStartDelay, long alphaDuration, long alphaStartDelay) {
        return new QZoneFeedxAnimTimeParams(totalDuration, totalStartDelay, alphaDuration, alphaStartDelay);
    }

    /* renamed from: c, reason: from getter */
    public final long getAlphaDuration() {
        return this.alphaDuration;
    }

    /* renamed from: d, reason: from getter */
    public final long getAlphaStartDelay() {
        return this.alphaStartDelay;
    }

    /* renamed from: e, reason: from getter */
    public final long getTotalDuration() {
        return this.totalDuration;
    }

    /* renamed from: f, reason: from getter */
    public final long getTotalStartDelay() {
        return this.totalStartDelay;
    }

    public int hashCode() {
        return (((((com.qzone.proxy.feedcomponent.model.n.a(this.totalDuration) * 31) + com.qzone.proxy.feedcomponent.model.n.a(this.totalStartDelay)) * 31) + com.qzone.proxy.feedcomponent.model.n.a(this.alphaDuration)) * 31) + com.qzone.proxy.feedcomponent.model.n.a(this.alphaStartDelay);
    }

    public String toString() {
        return "QZoneFeedxAnimTimeParams(totalDuration=" + this.totalDuration + ", totalStartDelay=" + this.totalStartDelay + ", alphaDuration=" + this.alphaDuration + ", alphaStartDelay=" + this.alphaStartDelay + ")";
    }

    public QZoneFeedxAnimTimeParams(long j3, long j16, long j17, long j18) {
        this.totalDuration = j3;
        this.totalStartDelay = j16;
        this.alphaDuration = j17;
        this.alphaStartDelay = j18;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QZoneFeedxAnimTimeParams)) {
            return false;
        }
        QZoneFeedxAnimTimeParams qZoneFeedxAnimTimeParams = (QZoneFeedxAnimTimeParams) other;
        return this.totalDuration == qZoneFeedxAnimTimeParams.totalDuration && this.totalStartDelay == qZoneFeedxAnimTimeParams.totalStartDelay && this.alphaDuration == qZoneFeedxAnimTimeParams.alphaDuration && this.alphaStartDelay == qZoneFeedxAnimTimeParams.alphaStartDelay;
    }

    public /* synthetic */ QZoneFeedxAnimTimeParams(long j3, long j16, long j17, long j18, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 200L : j3, (i3 & 2) != 0 ? 0L : j16, (i3 & 4) != 0 ? 67L : j17, (i3 & 8) == 0 ? j18 : 0L);
    }
}
