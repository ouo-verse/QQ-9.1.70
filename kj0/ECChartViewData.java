package kj0;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\t\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\t\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R(\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR(\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u000b\u001a\u0004\b\n\u0010\r\"\u0004\b\u0012\u0010\u000fR\u0017\u0010\u0015\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0019"}, d2 = {"Lkj0/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "Ljava/util/List;", "b", "()Ljava/util/List;", "d", "(Ljava/util/List;)V", "label", "", "c", "data", "Z", "isMoneyTab", "()Z", "<init>", "(Ljava/util/List;Ljava/util/List;Z)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: kj0.a, reason: from toString */
/* loaded from: classes38.dex */
public final /* data */ class ECChartViewData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private List<String> label;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private List<Long> data;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isMoneyTab;

    public ECChartViewData() {
        this(null, null, false, 7, null);
    }

    public final List<Long> a() {
        return this.data;
    }

    public final List<String> b() {
        return this.label;
    }

    public final void c(List<Long> list) {
        this.data = list;
    }

    public final void d(List<String> list) {
        this.label = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        List<String> list = this.label;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        List<Long> list2 = this.data;
        int hashCode2 = (hashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        boolean z16 = this.isMoneyTab;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode2 + i3;
    }

    public String toString() {
        return "ECChartViewData(label=" + this.label + ", data=" + this.data + ", isMoneyTab=" + this.isMoneyTab + ")";
    }

    public ECChartViewData(List<String> list, List<Long> list2, boolean z16) {
        this.label = list;
        this.data = list2;
        this.isMoneyTab = z16;
    }

    public /* synthetic */ ECChartViewData(List list, List list2, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new ArrayList() : list, (i3 & 2) != 0 ? new ArrayList() : list2, (i3 & 4) != 0 ? false : z16);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECChartViewData)) {
            return false;
        }
        ECChartViewData eCChartViewData = (ECChartViewData) other;
        return Intrinsics.areEqual(this.label, eCChartViewData.label) && Intrinsics.areEqual(this.data, eCChartViewData.data) && this.isMoneyTab == eCChartViewData.isMoneyTab;
    }
}
