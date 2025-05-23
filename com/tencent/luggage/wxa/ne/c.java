package com.tencent.luggage.wxa.ne;

import com.tencent.raft.codegenmeta.utils.Constants;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public String f135726a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f135727b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f135728c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f135729d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f135730e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f135731f;

    /* renamed from: g, reason: collision with root package name */
    public int f135732g;

    /* renamed from: h, reason: collision with root package name */
    public JSONObject f135733h;

    public JSONObject a() {
        boolean z16;
        if (this.f135733h == null) {
            JSONObject jSONObject = new JSONObject();
            this.f135733h = jSONObject;
            jSONObject.put("uuid", this.f135726a);
            this.f135733h.put("handle", this.f135732g);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(com.tencent.mobileqq.msf.core.auth.k.f247491e, this.f135727b);
            if (!this.f135728c && !this.f135729d) {
                z16 = false;
            } else {
                z16 = true;
            }
            jSONObject2.put(com.tencent.mobileqq.msf.core.auth.k.f247492f, z16);
            jSONObject2.put("notify", this.f135730e);
            jSONObject2.put("indicate", this.f135731f);
            jSONObject2.put("writeNoResponse", this.f135729d);
            jSONObject2.put("writeDefault", this.f135728c);
            this.f135733h.put(Constants.Service.PROPERTIES, jSONObject2);
        }
        return this.f135733h;
    }
}
