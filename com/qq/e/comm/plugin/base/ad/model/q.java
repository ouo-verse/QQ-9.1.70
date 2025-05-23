package com.qq.e.comm.plugin.base.ad.model;

import com.qq.e.comm.plugin.k.y;
import com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.TVKDataBinder;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    private String f39091a;

    /* renamed from: b, reason: collision with root package name */
    private String f39092b;

    /* renamed from: c, reason: collision with root package name */
    private int f39093c;

    /* renamed from: d, reason: collision with root package name */
    private String f39094d;

    /* renamed from: e, reason: collision with root package name */
    private int f39095e;

    public q(JSONObject jSONObject) {
        if (!y.a(jSONObject)) {
            return;
        }
        this.f39091a = jSONObject.optString("icon_url");
        this.f39092b = jSONObject.optString("text");
        this.f39093c = jSONObject.optInt(TVKDataBinder.KEY_REPORT_TYPE);
        this.f39094d = jSONObject.optString("jump_url");
        this.f39095e = jSONObject.optInt("action_type");
    }

    public String a() {
        return this.f39091a;
    }

    public String b() {
        return this.f39092b;
    }
}
