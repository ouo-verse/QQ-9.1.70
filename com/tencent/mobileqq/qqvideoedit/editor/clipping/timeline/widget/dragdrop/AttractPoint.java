package com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\u001c\u0010\u001dJ3\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\bH\u00c6\u0001J\t\u0010\u000b\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\f\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u000e\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018R\u0017\u0010\t\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/a;", "", "", "time", "", "px", "", "id", "", "isStart", "a", "toString", "hashCode", "other", "equals", "J", "e", "()J", "b", "I", "d", "()I", "c", "Ljava/lang/String;", "()Ljava/lang/String;", "Z", "f", "()Z", "<init>", "(JILjava/lang/String;Z)V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.a, reason: from toString */
/* loaded from: classes17.dex */
public final /* data */ class AttractPoint {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final long time;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int px;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String id;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isStart;

    public AttractPoint(long j3, int i3, @Nullable String str, boolean z16) {
        this.time = j3;
        this.px = i3;
        this.id = str;
        this.isStart = z16;
    }

    public static /* synthetic */ AttractPoint b(AttractPoint attractPoint, long j3, int i3, String str, boolean z16, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            j3 = attractPoint.time;
        }
        long j16 = j3;
        if ((i16 & 2) != 0) {
            i3 = attractPoint.px;
        }
        int i17 = i3;
        if ((i16 & 4) != 0) {
            str = attractPoint.id;
        }
        String str2 = str;
        if ((i16 & 8) != 0) {
            z16 = attractPoint.isStart;
        }
        return attractPoint.a(j16, i17, str2, z16);
    }

    @NotNull
    public final AttractPoint a(long time, int px5, @Nullable String id5, boolean isStart) {
        return new AttractPoint(time, px5, id5, isStart);
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: d, reason: from getter */
    public final int getPx() {
        return this.px;
    }

    /* renamed from: e, reason: from getter */
    public final long getTime() {
        return this.time;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AttractPoint)) {
            return false;
        }
        AttractPoint attractPoint = (AttractPoint) other;
        if (this.time == attractPoint.time && this.px == attractPoint.px && Intrinsics.areEqual(this.id, attractPoint.id) && this.isStart == attractPoint.isStart) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getIsStart() {
        return this.isStart;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int a16 = ((androidx.fragment.app.a.a(this.time) * 31) + this.px) * 31;
        String str = this.id;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i3 = (a16 + hashCode) * 31;
        boolean z16 = this.isStart;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        return i3 + i16;
    }

    @NotNull
    public String toString() {
        return "AttractPoint(time=" + this.time + ", px=" + this.px + ", id=" + this.id + ", isStart=" + this.isStart + ")";
    }
}
