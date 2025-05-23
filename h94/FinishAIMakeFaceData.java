package h94;

import com.epicgames.ue4.GameActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u0000 \u00132\u00020\u0001:\u0001\tB\u0019\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\t\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lh94/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "result", "Ljava/lang/String;", "()Ljava/lang/String;", "itemsBase64", "<init>", "(ILjava/lang/String;)V", "c", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: h94.a, reason: from toString */
/* loaded from: classes38.dex */
public final /* data */ class FinishAIMakeFaceData {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int result;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String itemsBase64;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lh94/a$a;", "", "Lorg/json/JSONObject;", "jsonObject", "Lh94/a;", "a", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: h94.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes38.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FinishAIMakeFaceData a(JSONObject jsonObject) {
            Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
            int optInt = jsonObject.optInt(GameActivity.DOWNLOAD_RETURN_NAME, -1);
            String itemsBase64 = jsonObject.optString("Items");
            Intrinsics.checkNotNullExpressionValue(itemsBase64, "itemsBase64");
            return new FinishAIMakeFaceData(optInt, itemsBase64);
        }

        Companion() {
        }
    }

    public FinishAIMakeFaceData(int i3, String itemsBase64) {
        Intrinsics.checkNotNullParameter(itemsBase64, "itemsBase64");
        this.result = i3;
        this.itemsBase64 = itemsBase64;
    }

    /* renamed from: a, reason: from getter */
    public final String getItemsBase64() {
        return this.itemsBase64;
    }

    /* renamed from: b, reason: from getter */
    public final int getResult() {
        return this.result;
    }

    public int hashCode() {
        return (this.result * 31) + this.itemsBase64.hashCode();
    }

    public String toString() {
        return "FinishAIMakeFaceData(result=" + this.result + ", itemsBase64=" + this.itemsBase64 + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FinishAIMakeFaceData)) {
            return false;
        }
        FinishAIMakeFaceData finishAIMakeFaceData = (FinishAIMakeFaceData) other;
        return this.result == finishAIMakeFaceData.result && Intrinsics.areEqual(this.itemsBase64, finishAIMakeFaceData.itemsBase64);
    }
}
