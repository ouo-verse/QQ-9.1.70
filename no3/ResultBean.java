package no3;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u0000 \f2\u00020\u0001:\u0001\tB\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0011\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\r\u00a8\u0006\u0014"}, d2 = {"Lno3/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "c", "(I)V", "leftResult", "b", "d", "rightResult", "<init>", "(II)V", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: no3.d, reason: from toString */
/* loaded from: classes22.dex */
public final /* data */ class ResultBean {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private int leftResult;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private int rightResult;

    public ResultBean(int i3, int i16) {
        this.leftResult = i3;
        this.rightResult = i16;
    }

    /* renamed from: a, reason: from getter */
    public final int getLeftResult() {
        return this.leftResult;
    }

    /* renamed from: b, reason: from getter */
    public final int getRightResult() {
        return this.rightResult;
    }

    public final void c(int i3) {
        this.leftResult = i3;
    }

    public final void d(int i3) {
        this.rightResult = i3;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ResultBean)) {
            return false;
        }
        ResultBean resultBean = (ResultBean) other;
        if (this.leftResult == resultBean.leftResult && this.rightResult == resultBean.rightResult) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.leftResult * 31) + this.rightResult;
    }

    @NotNull
    public String toString() {
        return "ResultBean(leftResult=" + this.leftResult + ", rightResult=" + this.rightResult + ")";
    }
}
