package m94;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\t\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0014\u001a\u0004\b\n\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lm94/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "Ljava/util/List;", "b", "()Ljava/util/List;", "dressList", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "step", "Lorg/json/JSONObject;", "Lorg/json/JSONObject;", "()Lorg/json/JSONObject;", "clickedItem", "<init>", "(Ljava/util/List;Ljava/lang/String;Lorg/json/JSONObject;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: m94.c, reason: from toString */
/* loaded from: classes38.dex */
public final /* data */ class DressCallbackData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<String> dressList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String step;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final JSONObject clickedItem;

    public DressCallbackData(List<String> dressList, String str, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(dressList, "dressList");
        this.dressList = dressList;
        this.step = str;
        this.clickedItem = jSONObject;
    }

    /* renamed from: a, reason: from getter */
    public final JSONObject getClickedItem() {
        return this.clickedItem;
    }

    public final List<String> b() {
        return this.dressList;
    }

    /* renamed from: c, reason: from getter */
    public final String getStep() {
        return this.step;
    }

    public int hashCode() {
        int hashCode = this.dressList.hashCode() * 31;
        String str = this.step;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        JSONObject jSONObject = this.clickedItem;
        return hashCode2 + (jSONObject != null ? jSONObject.hashCode() : 0);
    }

    public String toString() {
        return "DressCallbackData(dressList=" + this.dressList + ", step=" + this.step + ", clickedItem=" + this.clickedItem + ")";
    }

    public /* synthetic */ DressCallbackData(List list, String str, JSONObject jSONObject, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, str, (i3 & 4) != 0 ? null : jSONObject);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DressCallbackData)) {
            return false;
        }
        DressCallbackData dressCallbackData = (DressCallbackData) other;
        return Intrinsics.areEqual(this.dressList, dressCallbackData.dressList) && Intrinsics.areEqual(this.step, dressCallbackData.step) && Intrinsics.areEqual(this.clickedItem, dressCallbackData.clickedItem);
    }
}
