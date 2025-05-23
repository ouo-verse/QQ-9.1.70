package kj0;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0015\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0011\u001a\u0004\b\t\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0018\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001e"}, d2 = {"Lkj0/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "title", "Lorg/json/JSONArray;", "Lorg/json/JSONArray;", "()Lorg/json/JSONArray;", "setDataArr", "(Lorg/json/JSONArray;)V", "dataArr", "c", "Z", "isFocusedData", "()Z", "setFocusedData", "(Z)V", "<init>", "(Ljava/lang/String;Lorg/json/JSONArray;Z)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: kj0.b, reason: from toString */
/* loaded from: classes38.dex */
public final /* data */ class ECChartViewExtData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private String title;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private JSONArray dataArr;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isFocusedData;

    public ECChartViewExtData() {
        this(null, null, false, 7, null);
    }

    /* renamed from: a, reason: from getter */
    public final JSONArray getDataArr() {
        return this.dataArr;
    }

    /* renamed from: b, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.title;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        JSONArray jSONArray = this.dataArr;
        int hashCode2 = (hashCode + (jSONArray != null ? jSONArray.hashCode() : 0)) * 31;
        boolean z16 = this.isFocusedData;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode2 + i3;
    }

    public String toString() {
        return "ECChartViewExtData(title=" + this.title + ", dataArr=" + this.dataArr + ", isFocusedData=" + this.isFocusedData + ")";
    }

    public ECChartViewExtData(String str, JSONArray jSONArray, boolean z16) {
        this.title = str;
        this.dataArr = jSONArray;
        this.isFocusedData = z16;
    }

    public /* synthetic */ ECChartViewExtData(String str, JSONArray jSONArray, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? new JSONArray() : jSONArray, (i3 & 4) != 0 ? false : z16);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECChartViewExtData)) {
            return false;
        }
        ECChartViewExtData eCChartViewExtData = (ECChartViewExtData) other;
        return Intrinsics.areEqual(this.title, eCChartViewExtData.title) && Intrinsics.areEqual(this.dataArr, eCChartViewExtData.dataArr) && this.isFocusedData == eCChartViewExtData.isFocusedData;
    }
}
