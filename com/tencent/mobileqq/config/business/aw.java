package com.tencent.mobileqq.config.business;

import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class aw {

    /* renamed from: a, reason: collision with root package name */
    private boolean f202556a = true;

    /* renamed from: b, reason: collision with root package name */
    private boolean f202557b = false;

    /* renamed from: c, reason: collision with root package name */
    private boolean f202558c = true;

    /* renamed from: d, reason: collision with root package name */
    private boolean f202559d = false;

    /* renamed from: e, reason: collision with root package name */
    private long f202560e = 2000;

    /* renamed from: f, reason: collision with root package name */
    private long f202561f = 60000;

    public static aw b(String str) {
        boolean z16;
        boolean z17;
        boolean z18;
        if (str == null) {
            return null;
        }
        try {
            aw awVar = new aw();
            JSONObject jSONObject = new JSONObject(str);
            boolean z19 = true;
            if (jSONObject.optInt("useNewLog", 1) == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            awVar.f202556a = z16;
            if (jSONObject.optInt("compressAndEncrypt", 0) == 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            awVar.f202557b = z17;
            if (jSONObject.optInt("enableConsole", 1) == 1) {
                z18 = true;
            } else {
                z18 = false;
            }
            awVar.f202558c = z18;
            if (jSONObject.optInt("enableCheckPermission", 1) != 1) {
                z19 = false;
            }
            awVar.f202559d = z19;
            awVar.f202560e = jSONObject.optLong("locationSdkCallbackIntervalMillis", 2000L);
            awVar.f202561f = jSONObject.optLong("locationBgTimeoutMillis", 60000L);
            return awVar;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public boolean a() {
        return this.f202559d;
    }

    public String toString() {
        return "QConfLogBean{useNewLog=" + this.f202556a + ", compressAndEncrypt=" + this.f202557b + ", enableConsole=" + this.f202558c + ",enableCheckPermission=" + this.f202559d + ",locationSdkCallbackIntervalMillis=" + this.f202560e + ",locationBgTimeoutMillis=" + this.f202561f + '}';
    }
}
