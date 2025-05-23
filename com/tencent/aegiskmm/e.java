package com.tencent.aegiskmm;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\u0006\u0010\u0015\u001a\u00020\t\u0012\u0006\u0010\u0018\u001a\u00020\t\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0010\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0012\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0011\u0010\fR\u0017\u0010\u0014\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0013\u0010\fR\u0017\u0010\u0015\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0018\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\f\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/aegiskmm/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "()J", "fetchContextCost", "b", "c", "initRenderContextCost", "d", "pageBuildCost", "e", "pageLayoutCost", "firstFramePaintCost", "f", "getFirstFrameAllCost", "firstFrameAllCost", "<init>", "(JJJJJJ)V", "ShiplyCS-KuiklyAegis_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes37.dex */
public final /* data */ class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long fetchContextCost;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final long initRenderContextCost;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final long pageBuildCost;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long pageLayoutCost;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final long firstFramePaintCost;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final long firstFrameAllCost;

    public e(long j3, long j16, long j17, long j18, long j19, long j26) {
        this.fetchContextCost = j3;
        this.initRenderContextCost = j16;
        this.pageBuildCost = j17;
        this.pageLayoutCost = j18;
        this.firstFramePaintCost = j19;
        this.firstFrameAllCost = j26;
    }

    /* renamed from: a, reason: from getter */
    public final long getFetchContextCost() {
        return this.fetchContextCost;
    }

    /* renamed from: b, reason: from getter */
    public final long getFirstFramePaintCost() {
        return this.firstFramePaintCost;
    }

    /* renamed from: c, reason: from getter */
    public final long getInitRenderContextCost() {
        return this.initRenderContextCost;
    }

    /* renamed from: d, reason: from getter */
    public final long getPageBuildCost() {
        return this.pageBuildCost;
    }

    /* renamed from: e, reason: from getter */
    public final long getPageLayoutCost() {
        return this.pageLayoutCost;
    }

    public int hashCode() {
        return (((((((((d.a(this.fetchContextCost) * 31) + d.a(this.initRenderContextCost)) * 31) + d.a(this.pageBuildCost)) * 31) + d.a(this.pageLayoutCost)) * 31) + d.a(this.firstFramePaintCost)) * 31) + d.a(this.firstFrameAllCost);
    }

    public String toString() {
        return "[LaunchCost]:fetchContextCost:" + this.fetchContextCost + ",initRenderContextCost: " + this.initRenderContextCost + ",pageBuildCost: " + this.pageBuildCost + ",pageLayoutCost: " + this.pageLayoutCost + ",firstFramePaintCost: " + this.firstFramePaintCost + ",firstFrameAllCost: " + this.firstFrameAllCost;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof e)) {
            return false;
        }
        e eVar = (e) other;
        return this.fetchContextCost == eVar.fetchContextCost && this.initRenderContextCost == eVar.initRenderContextCost && this.pageBuildCost == eVar.pageBuildCost && this.pageLayoutCost == eVar.pageLayoutCost && this.firstFramePaintCost == eVar.firstFramePaintCost && this.firstFrameAllCost == eVar.firstFrameAllCost;
    }
}
