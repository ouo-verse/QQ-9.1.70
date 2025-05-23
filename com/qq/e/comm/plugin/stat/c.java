package com.qq.e.comm.plugin.stat;

import android.text.TextUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f39704a;

    public c(Map map) {
        this.f39704a = new JSONObject(map);
    }

    public c a(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        try {
            this.f39704a.putOpt(str, obj);
        } catch (JSONException e16) {
            e16.printStackTrace();
        } catch (Throwable th5) {
            th5.getStackTrace();
        }
        return this;
    }

    public c(JSONObject jSONObject) {
        this.f39704a = jSONObject;
    }

    public c() {
        this(new JSONObject());
    }

    public JSONObject a() {
        JSONObject jSONObject = this.f39704a;
        if (jSONObject == null || jSONObject.length() <= 0) {
            return null;
        }
        return this.f39704a;
    }
}
