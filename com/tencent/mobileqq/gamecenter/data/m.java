package com.tencent.mobileqq.gamecenter.data;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    public int f212036a;

    /* renamed from: b, reason: collision with root package name */
    public String f212037b;

    /* renamed from: c, reason: collision with root package name */
    public String f212038c;

    /* renamed from: d, reason: collision with root package name */
    public String f212039d;

    /* renamed from: e, reason: collision with root package name */
    public String f212040e;

    /* renamed from: f, reason: collision with root package name */
    public String f212041f;

    /* renamed from: g, reason: collision with root package name */
    public String f212042g;

    /* renamed from: h, reason: collision with root package name */
    public String f212043h;

    /* renamed from: i, reason: collision with root package name */
    public String f212044i;

    /* renamed from: j, reason: collision with root package name */
    public String f212045j;

    public static m a(String str) {
        m mVar = new m();
        try {
            JSONObject jSONObject = new JSONObject(str);
            mVar.f212036a = jSONObject.optInt("status");
            mVar.f212037b = jSONObject.optString("activeImage");
            mVar.f212038c = jSONObject.optString("grayImage");
            mVar.f212039d = jSONObject.optString("openIconImage");
            mVar.f212040e = jSONObject.optString("senderHead");
            mVar.f212041f = jSONObject.optString("typeText");
            mVar.f212042g = jSONObject.optString("statusText");
            mVar.f212043h = jSONObject.optString("wishText");
            mVar.f212044i = jSONObject.optString("openUrl");
            mVar.f212045j = jSONObject.optString("detailUrl");
        } catch (Exception e16) {
            QLog.e("KingRedPackInfo", 1, "[parseRedPackInfo], error:" + e16);
        }
        return mVar;
    }
}
