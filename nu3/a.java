package nu3;

import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.vivo.push.PushClientConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\b&\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0019\u0010\u0017J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u001c\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\b\u0010\t\u001a\u00020\u0002H\u0016R$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR$\u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001a"}, d2 = {"Lnu3/a;", "", "", "objName", "f", "Lorg/json/JSONObject;", "dataObj", "c", "d", "toString", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "g", "(Ljava/lang/String;)V", PushClientConstants.TAG_CLASS_NAME, "b", "setMethodName", "methodName", "Lorg/json/JSONObject;", "e", "()Lorg/json/JSONObject;", "setParam", "(Lorg/json/JSONObject;)V", "param", "<init>", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String className;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private String methodName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private JSONObject param;

    public a(JSONObject dataObj) {
        Intrinsics.checkNotNullParameter(dataObj, "dataObj");
        if (dataObj.has("methodName")) {
            this.methodName = dataObj.getString("methodName");
        }
        if (dataObj.has("param")) {
            this.param = dataObj.getJSONObject("param");
        }
    }

    /* renamed from: a, reason: from getter */
    public final String getClassName() {
        return this.className;
    }

    /* renamed from: b, reason: from getter */
    public final String getMethodName() {
        return this.methodName;
    }

    public final String c(JSONObject dataObj) throws JSONException {
        return d(dataObj, "tavobject");
    }

    public final String d(JSONObject dataObj, String objName) throws JSONException {
        Intrinsics.checkNotNull(dataObj);
        if (dataObj.has(objName)) {
            return dataObj.getJSONObject(objName).getString(IECDtReport.ACTION_IDENTIFIER);
        }
        return null;
    }

    /* renamed from: e, reason: from getter */
    public final JSONObject getParam() {
        return this.param;
    }

    public final Object f(String objName) throws JSONException {
        return g.f421341a.a(d(this.param, objName));
    }

    public final void g(String str) {
        this.className = str;
    }

    public String toString() {
        return "BaseEvent{className='" + this.className + "', methodName='" + this.methodName + "', param=" + this.param + ", objPool=" + g.f421341a + "}";
    }
}
