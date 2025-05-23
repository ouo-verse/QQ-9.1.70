package nu3;

import com.tencent.ark.ark;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u0002J\u001a\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u0016\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f\u00a8\u0006\u0011"}, d2 = {"Lnu3/h;", "", "Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;", "req", "", "b", "c", "obj", "e", "Lorg/json/JSONObject;", ark.ARKMETADATA_JSON, "d", "", "methodName", "a", "<init>", "()V", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f421343a = new h();

    h() {
    }

    private final void b(RequestEvent req) {
        JSONObject jSONObject = new JSONObject();
        e eVar = e.f421339a;
        jSONObject.put("lightSDKVersion", eVar.b());
        jSONObject.put("lightSDKCapacityLevel", eVar.a());
        ee4.b.a("WS_TavUtils", "LightSdkVersio=" + eVar.b() + ", LightSdkComponentLevel=" + eVar.a());
        e(req, jSONObject);
    }

    private final void c(RequestEvent req) {
        JSONObject jSONObject = new JSONObject();
        e eVar = e.f421339a;
        jSONObject.put("pagSDKVersion", eVar.d());
        jSONObject.put("pagSDKCapacityLevel", eVar.c());
        ee4.b.a("WS_TavUtils", "PagSdkVersion=" + eVar.d() + ", PagSdkComponentLevel=" + eVar.c());
        e(req, jSONObject);
    }

    private final void d(RequestEvent req, JSONObject json) {
        ee4.b.i("WS_TavUtils", "returnOk() called with: json = [" + json + "]");
        if (req != null) {
            req.ok(json);
        }
    }

    private final void e(RequestEvent req, Object obj) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("value", obj);
        d(req, jSONObject);
    }

    public final void a(RequestEvent req, String methodName) {
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        if (Intrinsics.areEqual(methodName, "lightSdkInfo")) {
            b(req);
        } else if (Intrinsics.areEqual(methodName, "pagSdkInfo")) {
            c(req);
        } else {
            ee4.b.a("WS_TavUtils", "No match method!");
        }
    }
}
