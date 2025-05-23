package ok1;

import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pk1.b;

/* compiled from: P */
/* loaded from: classes13.dex */
public abstract class a<T extends pk1.b<?>> {

    /* renamed from: d, reason: collision with root package name */
    private JSONObject f423063d;

    /* renamed from: e, reason: collision with root package name */
    protected c f423064e;

    /* renamed from: f, reason: collision with root package name */
    private String f423065f;

    public JSONArray a(String str) {
        return this.f423063d.optJSONArray(str);
    }

    public boolean b(String str) {
        return this.f423063d.optBoolean(str);
    }

    public boolean c(String str, boolean z16) {
        return this.f423063d.optBoolean(str, z16);
    }

    public int d(String str) {
        return this.f423063d.optInt(str);
    }

    public int e(String str, int i3) {
        return this.f423063d.optInt(str, i3);
    }

    public long f(String str) {
        return this.f423063d.optLong(str);
    }

    public String g(String str) {
        return this.f423063d.optString(str);
    }

    public String h(String str, String str2) {
        return this.f423063d.optString(str, str2);
    }

    public void i(String str) {
        if (QLog.isDevelopLevel()) {
            QLog.d("Guild_Feed_BaseGuildJsBridgeMethod", 1, "tag: " + k() + " ,callbackId->" + this.f423065f + " callbackOk:" + str);
        }
        c cVar = this.f423064e;
        if (cVar != null) {
            cVar.callJs(this.f423065f, str);
        }
    }

    public String j() {
        return this.f423063d.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract String k();

    /* JADX INFO: Access modifiers changed from: protected */
    public T l() {
        WebViewPlugin.b bVar;
        c cVar = this.f423064e;
        if (cVar == null || (bVar = cVar.mRuntime) == null) {
            return null;
        }
        WebViewProvider f16 = bVar.f();
        if (f16 instanceof pk1.b) {
            T t16 = (T) f16;
            if (t16.available()) {
                return t16;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean n(c cVar, String str, String str2, String str3, String... strArr) {
        if (QLog.isDevelopLevel()) {
            QLog.d("Guild_Feed_BaseGuildJsBridgeMethod", 1, "onJsBridge invoke, tag: " + k() + " ,method: ", str3, " args: ", Arrays.toString(strArr));
        }
        if (strArr != null) {
            try {
                if (strArr.length > 0) {
                    JSONObject jSONObject = new JSONObject(strArr[0]);
                    this.f423063d = jSONObject;
                    this.f423065f = jSONObject.optString("callback");
                }
            } catch (JSONException unused) {
                return false;
            }
        }
        this.f423064e = cVar;
        return o(str, str2, str3);
    }

    protected abstract boolean o(String str, String str2, String str3);

    /* JADX INFO: Access modifiers changed from: protected */
    public void m() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDestroy() {
    }
}
