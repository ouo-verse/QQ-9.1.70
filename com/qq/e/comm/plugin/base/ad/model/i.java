package com.qq.e.comm.plugin.base.ad.model;

import com.qq.e.comm.plugin.k.y;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private int f39047a;

    /* renamed from: b, reason: collision with root package name */
    private String f39048b;

    /* renamed from: c, reason: collision with root package name */
    private String f39049c;

    /* renamed from: d, reason: collision with root package name */
    private String f39050d;

    /* renamed from: e, reason: collision with root package name */
    private String f39051e;

    public void a(JSONObject jSONObject) {
        if (y.a(jSONObject)) {
            this.f39047a = jSONObject.optInt("feature_type");
            this.f39048b = jSONObject.optString("hippy_cdn_url");
            this.f39049c = jSONObject.optString("dest_url_reflection_id");
            this.f39050d = jSONObject.optString("hippy_module_id");
            this.f39051e = y.e(jSONObject, "reward_landing_page_url");
        }
    }

    public String a() {
        return this.f39051e;
    }
}
