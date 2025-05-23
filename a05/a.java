package a05;

import androidx.annotation.NonNull;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f25315a;

    /* renamed from: b, reason: collision with root package name */
    public final String f25316b;

    /* renamed from: c, reason: collision with root package name */
    public final String f25317c;

    /* renamed from: d, reason: collision with root package name */
    public final long f25318d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f25319e;

    /* renamed from: f, reason: collision with root package name */
    public final int f25320f;

    /* renamed from: g, reason: collision with root package name */
    public final String f25321g;

    public a(String str, String str2, String str3, long j3, boolean z16, int i3, String str4) {
        this.f25315a = str;
        this.f25316b = str2;
        this.f25317c = str3;
        this.f25318d = j3;
        this.f25319e = z16;
        this.f25320f = i3;
        this.f25321g = str4;
    }

    public static a a(@NonNull String str) {
        JSONObject jSONObject = new JSONObject(str);
        return new a(jSONObject.optString("appVersion"), jSONObject.optString(com.heytap.mcssdk.a.a.f36095e), jSONObject.optString("sdkVersion"), jSONObject.getLong(PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY), jSONObject.getBoolean("valid"), jSONObject.getInt("errorCode"), jSONObject.optString("errorMessage"));
    }

    public final JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("appVersion", this.f25315a);
        jSONObject.putOpt(com.heytap.mcssdk.a.a.f36095e, this.f25316b);
        jSONObject.putOpt("sdkVersion", this.f25317c);
        jSONObject.putOpt(PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, Long.valueOf(this.f25318d));
        jSONObject.putOpt("valid", Boolean.valueOf(this.f25319e));
        jSONObject.putOpt("errorCode", Integer.valueOf(this.f25320f));
        jSONObject.putOpt("errorMessage", this.f25321g);
        return jSONObject;
    }
}
