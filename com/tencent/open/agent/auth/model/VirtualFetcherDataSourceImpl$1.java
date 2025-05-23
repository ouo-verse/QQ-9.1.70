package com.tencent.open.agent.auth.model;

import com.tencent.open.agent.util.t;
import com.tencent.open.virtual.OpenSdkVirtualUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
class VirtualFetcherDataSourceImpl$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f340152d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ fp3.d f340153e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ boolean f340154f;
    final /* synthetic */ k this$0;

    @Override // java.lang.Runnable
    public void run() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uint64_req_appid", 0);
            jSONObject.put("uint32_req_nick", 1);
            jSONObject.put("uint32_req_head_url", 1);
            jSONObject.put("uint32_req_head_update_time", 1);
            jSONObject.put("str_spec", "30");
        } catch (JSONException e16) {
            t.a("VirtualFetcherDataSourceImpl", "fetchVirtual.e:", e16);
        }
        OpenSdkVirtualUtil.e("oidb_0xd19_2", String.valueOf(0), this.f340152d, jSONObject.toString(), this.f340153e, this.f340154f);
    }
}
