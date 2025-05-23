package bh0;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lbh0/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "parserId", "b", "Ljava/lang/String;", "pageName", "c", "dataParams", "Lorg/json/JSONObject;", "d", "Lorg/json/JSONObject;", "ext", "<init>", "(ILjava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: bh0.e, reason: from toString */
/* loaded from: classes39.dex */
public final /* data */ class ECPageParserParams {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final int parserId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String pageName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final String dataParams;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final JSONObject ext;

    public ECPageParserParams(int i3, String str, String str2, JSONObject jSONObject) {
        this.parserId = i3;
        this.pageName = str;
        this.dataParams = str2;
        this.ext = jSONObject;
    }

    public int hashCode() {
        int i3 = this.parserId * 31;
        String str = this.pageName;
        int hashCode = (i3 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.dataParams;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        JSONObject jSONObject = this.ext;
        return hashCode2 + (jSONObject != null ? jSONObject.hashCode() : 0);
    }

    public String toString() {
        return "ECPageParserParams(parserId=" + this.parserId + ", pageName=" + this.pageName + ", dataParams=" + this.dataParams + ", ext=" + this.ext + ")";
    }

    public /* synthetic */ ECPageParserParams(int i3, String str, String str2, JSONObject jSONObject, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0 : i3, str, (i16 & 4) != 0 ? "" : str2, (i16 & 8) != 0 ? null : jSONObject);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECPageParserParams)) {
            return false;
        }
        ECPageParserParams eCPageParserParams = (ECPageParserParams) other;
        return this.parserId == eCPageParserParams.parserId && Intrinsics.areEqual(this.pageName, eCPageParserParams.pageName) && Intrinsics.areEqual(this.dataParams, eCPageParserParams.dataParams) && Intrinsics.areEqual(this.ext, eCPageParserParams.ext);
    }
}
