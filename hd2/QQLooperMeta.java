package hd2;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u0011\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lhd2/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lorg/json/JSONObject;", "a", "Lorg/json/JSONObject;", "getLooperParams", "()Lorg/json/JSONObject;", "setLooperParams", "(Lorg/json/JSONObject;)V", "looperParams", "<init>", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: hd2.b, reason: from toString */
/* loaded from: classes16.dex */
public final /* data */ class QQLooperMeta {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private JSONObject looperParams;

    public QQLooperMeta(@Nullable JSONObject jSONObject) {
        this.looperParams = jSONObject;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof QQLooperMeta) && Intrinsics.areEqual(this.looperParams, ((QQLooperMeta) other).looperParams)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        JSONObject jSONObject = this.looperParams;
        if (jSONObject == null) {
            return 0;
        }
        return jSONObject.hashCode();
    }

    @NotNull
    public String toString() {
        return "QQLooperMeta(looperParams=" + this.looperParams + ')';
    }
}
