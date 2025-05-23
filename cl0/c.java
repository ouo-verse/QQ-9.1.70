package cl0;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcl0/c;", "", "", "toString", "", "enableCheck", "Z", "b", "()Z", "", "checkSelect", "I", "a", "()I", "<init>", "(ZI)V", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class c {

    @SerializedName("checkSelect")
    private final int checkSelect;

    @SerializedName("enableCheck")
    private final boolean enableCheck;

    public c() {
        this(false, 0 == true ? 1 : 0, 3, null);
    }

    /* renamed from: a, reason: from getter */
    public final int getCheckSelect() {
        return this.checkSelect;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getEnableCheck() {
        return this.enableCheck;
    }

    @NotNull
    public String toString() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("enableCheck", this.enableCheck);
        jSONObject.put("checkSelect", this.checkSelect);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "json.toString()");
        return jSONObject2;
    }

    public c(boolean z16, int i3) {
        this.enableCheck = z16;
        this.checkSelect = i3;
    }

    public /* synthetic */ c(boolean z16, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? false : z16, (i16 & 2) != 0 ? 0 : i3);
    }
}
