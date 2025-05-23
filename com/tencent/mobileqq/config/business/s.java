package com.tencent.mobileqq.config.business;

import com.tencent.freesia.IConfigData;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class s implements IConfigData {

    /* renamed from: d, reason: collision with root package name */
    private int f202818d;

    /* renamed from: e, reason: collision with root package name */
    private int f202819e;

    /* renamed from: f, reason: collision with root package name */
    private int f202820f;

    public static s d(String str) {
        s sVar = new s();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("gifControlOpen")) {
                sVar.f202818d = jSONObject.optInt("gifControlOpen");
            }
            if (jSONObject.has("wifiMaxSize")) {
                sVar.f202819e = jSONObject.optInt("wifiMaxSize");
            }
            if (jSONObject.has("cellularMaxSize")) {
                sVar.f202820f = jSONObject.optInt("cellularMaxSize");
            }
        } catch (Exception e16) {
            QLog.e("GifPreDownloadConfProcessor", 1, "parse e:", e16.toString());
        }
        return sVar;
    }

    public int a() {
        return this.f202820f;
    }

    public int b() {
        return this.f202818d;
    }

    public int c() {
        return this.f202819e;
    }
}
