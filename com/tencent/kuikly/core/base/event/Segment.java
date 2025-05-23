package com.tencent.kuikly.core.base.event;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\t\b\u0080\b\u0018\u00002\u00020\u0001B/\u0012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t\u0012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R#\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR#\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\f\u001a\u0004\b\u000b\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/kuikly/core/base/event/i;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lkotlin/Pair;", "", "a", "Lkotlin/Pair;", "b", "()Lkotlin/Pair;", "start", "end", "<init>", "(Lkotlin/Pair;Lkotlin/Pair;)V", "core_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.kuikly.core.base.event.i, reason: from toString */
/* loaded from: classes33.dex */
public final /* data */ class Segment {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final Pair<Float, Float> start;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final Pair<Float, Float> end;

    public Segment(Pair<Float, Float> start, Pair<Float, Float> end) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(end, "end");
        this.start = start;
        this.end = end;
    }

    public final Pair<Float, Float> a() {
        return this.end;
    }

    public final Pair<Float, Float> b() {
        return this.start;
    }

    public int hashCode() {
        return (this.start.hashCode() * 31) + this.end.hashCode();
    }

    public String toString() {
        return "Segment(start=" + this.start + ", end=" + this.end + ')';
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Segment)) {
            return false;
        }
        Segment segment = (Segment) other;
        return Intrinsics.areEqual(this.start, segment.start) && Intrinsics.areEqual(this.end, segment.end);
    }
}
