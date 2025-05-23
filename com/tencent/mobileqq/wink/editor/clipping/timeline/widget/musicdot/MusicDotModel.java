package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.musicdot;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\r\u001a\u00020\t\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/musicdot/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "()J", "dotTimeUs", "b", "Z", "()Z", "needAttract", "<init>", "(JZ)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.editor.clipping.timeline.widget.musicdot.b, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class MusicDotModel {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final long dotTimeUs;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean needAttract;

    public MusicDotModel(long j3, boolean z16) {
        this.dotTimeUs = j3;
        this.needAttract = z16;
    }

    /* renamed from: a, reason: from getter */
    public final long getDotTimeUs() {
        return this.dotTimeUs;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getNeedAttract() {
        return this.needAttract;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MusicDotModel)) {
            return false;
        }
        MusicDotModel musicDotModel = (MusicDotModel) other;
        if (this.dotTimeUs == musicDotModel.dotTimeUs && this.needAttract == musicDotModel.needAttract) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int a16 = androidx.fragment.app.a.a(this.dotTimeUs) * 31;
        boolean z16 = this.needAttract;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return a16 + i3;
    }

    @NotNull
    public String toString() {
        return "MusicDotModel(dotTimeUs=" + this.dotTimeUs + ", needAttract=" + this.needAttract + ")";
    }
}
