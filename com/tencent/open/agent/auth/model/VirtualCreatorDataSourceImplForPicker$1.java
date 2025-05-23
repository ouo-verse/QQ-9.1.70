package com.tencent.open.agent.auth.model;

import com.tencent.open.agent.util.t;
import com.tencent.open.virtual.OpenSdkVirtualUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes22.dex */
class VirtualCreatorDataSourceImplForPicker$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ long f340140d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ String f340141e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ String f340142f;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ com.tencent.open.model.a f340143h;

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ fp3.d f340144i;

    /* renamed from: m, reason: collision with root package name */
    final /* synthetic */ boolean f340145m;
    final /* synthetic */ j this$0;

    @Override // java.lang.Runnable
    public void run() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uint64_appid", this.f340140d);
            jSONObject.put("str_nick", this.f340141e);
            jSONObject.put("str_head_id", this.f340142f);
        } catch (JSONException e16) {
            t.a("VirtualCreatorPresenter", "createVirtual.e:", e16);
        }
        OpenSdkVirtualUtil.e("oidb_0xd17_1", String.valueOf(this.f340140d), this.f340143h.f341678a, jSONObject.toString(), this.f340144i, this.f340145m);
    }
}
