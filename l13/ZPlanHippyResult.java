package l13;

import com.tencent.mobileqq.vas.hippy.api.data.HippyResultCode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u000bB%\u0012\b\b\u0003\u0010\u000e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001b"}, d2 = {"Ll13/a;", "", "Lorg/json/JSONObject;", "b", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "result", "Ljava/lang/String;", "getMsg", "()Ljava/lang/String;", "msg", "c", "Lorg/json/JSONObject;", "getParams", "()Lorg/json/JSONObject;", "params", "<init>", "(ILjava/lang/String;Lorg/json/JSONObject;)V", "d", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: l13.a, reason: from toString */
/* loaded from: classes38.dex */
public final /* data */ class ZPlanHippyResult {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int result;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String msg;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final JSONObject params;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\u000b"}, d2 = {"Ll13/a$a;", "", "", "msg", "Ll13/a;", "a", "Lorg/json/JSONObject;", "params", "b", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: l13.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes38.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ZPlanHippyResult a(String msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            return new ZPlanHippyResult(-1, msg2, null, 4, null);
        }

        public final ZPlanHippyResult b(JSONObject params) {
            Intrinsics.checkNotNullParameter(params, "params");
            return new ZPlanHippyResult(0, "", params);
        }

        Companion() {
        }

        public static /* synthetic */ ZPlanHippyResult c(Companion companion, JSONObject jSONObject, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                jSONObject = new JSONObject();
            }
            return companion.b(jSONObject);
        }
    }

    public ZPlanHippyResult() {
        this(0, null, null, 7, null);
    }

    /* renamed from: a, reason: from getter */
    public final int getResult() {
        return this.result;
    }

    public final JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("result", this.result);
        jSONObject.put("msg", this.msg);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("params", this.params);
        jSONObject.put("data", jSONObject2);
        return jSONObject;
    }

    public int hashCode() {
        return (((this.result * 31) + this.msg.hashCode()) * 31) + this.params.hashCode();
    }

    public String toString() {
        return "ZPlanHippyResult(result=" + this.result + ", msg=" + this.msg + ", params=" + this.params + ")";
    }

    public ZPlanHippyResult(@HippyResultCode int i3, String msg2, JSONObject params) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(params, "params");
        this.result = i3;
        this.msg = msg2;
        this.params = params;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanHippyResult)) {
            return false;
        }
        ZPlanHippyResult zPlanHippyResult = (ZPlanHippyResult) other;
        return this.result == zPlanHippyResult.result && Intrinsics.areEqual(this.msg, zPlanHippyResult.msg) && Intrinsics.areEqual(this.params, zPlanHippyResult.params);
    }

    public /* synthetic */ ZPlanHippyResult(int i3, String str, JSONObject jSONObject, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0 : i3, (i16 & 2) != 0 ? "" : str, (i16 & 4) != 0 ? new JSONObject() : jSONObject);
    }
}
