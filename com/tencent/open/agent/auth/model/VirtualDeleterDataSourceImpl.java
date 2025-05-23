package com.tencent.open.agent.auth.model;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.open.agent.util.t;
import com.tencent.open.virtual.OpenSdkVirtualUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class VirtualDeleterDataSourceImpl implements g {

    /* renamed from: a, reason: collision with root package name */
    private static String f340146a = "VirtualDeleterDataSourceImpl";

    @Override // com.tencent.open.agent.auth.model.g
    public void a(final long j3, final String str, final String str2, final boolean z16, final fp3.d dVar) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.open.agent.auth.model.VirtualDeleterDataSourceImpl.1
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("uint64_vuid", j3);
                } catch (JSONException e16) {
                    t.d(VirtualDeleterDataSourceImpl.f340146a, "deleteVirtual.e:", e16);
                }
                OpenSdkVirtualUtil.e("oidb_0xd18_1", str2, str, jSONObject.toString(), dVar, z16);
            }
        }, 128, null, true);
    }
}
