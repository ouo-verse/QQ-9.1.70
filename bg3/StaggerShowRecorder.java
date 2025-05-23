package bg3;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001R\"\u0010\u000f\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0011\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\f\"\u0004\b\u0010\u0010\u000eR\"\u0010\u0014\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0012\u0010\f\"\u0004\b\u0013\u0010\u000e\u00a8\u0006\u0017"}, d2 = {"Lbg3/d;", "", "other", "", "equals", "", "toString", "", "hashCode", "a", "I", "b", "()I", "e", "(I)V", "viewCreateNum", "d", "viewBindNum", "c", "f", "viewReuseNum", "<init>", "(III)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: bg3.d, reason: from toString */
/* loaded from: classes39.dex */
public final /* data */ class StaggerShowRecorder {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private int viewCreateNum;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private int viewBindNum;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private int viewReuseNum;

    public StaggerShowRecorder() {
        this(0, 0, 0, 7, null);
    }

    /* renamed from: a, reason: from getter */
    public final int getViewBindNum() {
        return this.viewBindNum;
    }

    /* renamed from: b, reason: from getter */
    public final int getViewCreateNum() {
        return this.viewCreateNum;
    }

    /* renamed from: c, reason: from getter */
    public final int getViewReuseNum() {
        return this.viewReuseNum;
    }

    public final void d(int i3) {
        this.viewBindNum = i3;
    }

    public final void e(int i3) {
        this.viewCreateNum = i3;
    }

    public boolean equals(Object other) {
        StaggerShowRecorder staggerShowRecorder = other instanceof StaggerShowRecorder ? (StaggerShowRecorder) other : null;
        return staggerShowRecorder != null && staggerShowRecorder.viewBindNum == this.viewBindNum && staggerShowRecorder.viewCreateNum == this.viewCreateNum && staggerShowRecorder.viewReuseNum == this.viewReuseNum;
    }

    public final void f(int i3) {
        this.viewReuseNum = i3;
    }

    public int hashCode() {
        return (((this.viewCreateNum * 31) + this.viewBindNum) * 31) + this.viewReuseNum;
    }

    public String toString() {
        return "StaggerShowRecorder(viewCreateNum=" + this.viewCreateNum + ", viewBindNum=" + this.viewBindNum + ", viewReuseNum=" + this.viewReuseNum + ")";
    }

    public StaggerShowRecorder(int i3, int i16, int i17) {
        this.viewCreateNum = i3;
        this.viewBindNum = i16;
        this.viewReuseNum = i17;
    }

    public /* synthetic */ StaggerShowRecorder(int i3, int i16, int i17, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this((i18 & 1) != 0 ? 0 : i3, (i18 & 2) != 0 ? 0 : i16, (i18 & 4) != 0 ? 0 : i17);
    }
}
