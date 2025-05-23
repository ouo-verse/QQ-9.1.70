package com.qq.e.comm.plugin.k;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class x {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f39665a;

    public x() {
        this.f39665a = new JSONObject();
    }

    public x a(String str, int i3) {
        try {
            if (!TextUtils.isEmpty(str)) {
                this.f39665a.put(str, i3);
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return this;
    }

    public String toString() {
        return this.f39665a.toString();
    }

    public x(String str) {
        JSONObject jSONObject;
        if (str != null) {
            try {
                if (!str.trim().isEmpty() && !str.toLowerCase().equals("null")) {
                    jSONObject = new JSONObject(str);
                    this.f39665a = jSONObject;
                }
            } catch (JSONException e16) {
                e16.printStackTrace();
                this.f39665a = new JSONObject();
                return;
            }
        }
        jSONObject = new JSONObject();
        this.f39665a = jSONObject;
    }

    public x a(String str, long j3) {
        try {
            if (!TextUtils.isEmpty(str)) {
                this.f39665a.put(str, j3);
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return this;
    }

    public x(JSONObject jSONObject) {
        if (jSONObject == null) {
            this.f39665a = new JSONObject();
        } else {
            this.f39665a = jSONObject;
        }
    }

    public x a(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                this.f39665a.put(str, str2);
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return this;
    }

    public x a(String str, Object obj) {
        try {
            if (!TextUtils.isEmpty(str) && obj != null) {
                this.f39665a.put(str, obj);
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return this;
    }

    public JSONObject a() {
        return this.f39665a;
    }
}
