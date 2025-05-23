package com.tencent.open.agent.auth.model;

import android.text.TextUtils;
import com.tencent.open.agent.util.t;
import com.tencent.open.model.VirtualInfo;
import com.tencent.open.virtual.OpenSdkVirtualUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class k {

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a implements fp3.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f340165a;

        a(b bVar) {
            this.f340165a = bVar;
        }

        @Override // fp3.d
        public boolean a(boolean z16, String str, int i3, String str2) {
            if (!z16) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optInt("ErrorCode") == 0) {
                    ArrayList arrayList = new ArrayList();
                    JSONArray optJSONArray = jSONObject.optJSONArray("rpt_msg_virtual_data");
                    if (optJSONArray != null) {
                        for (int i16 = 0; i16 < optJSONArray.length(); i16++) {
                            JSONObject jSONObject2 = optJSONArray.getJSONObject(i16);
                            long j3 = jSONObject2.getLong("uint64_vuid");
                            String string = jSONObject2.getString("str_nick");
                            String string2 = jSONObject2.getString("str_head_url");
                            if (j3 > 0 && !TextUtils.isEmpty(string)) {
                                VirtualInfo virtualInfo = new VirtualInfo();
                                virtualInfo.f341675d = j3;
                                virtualInfo.f341676e = string;
                                virtualInfo.f341677f = string2;
                                arrayList.add(virtualInfo);
                            }
                        }
                    }
                    b bVar = this.f340165a;
                    if (bVar != null) {
                        bVar.a(true, arrayList, i3);
                    }
                    return false;
                }
            } catch (JSONException e16) {
                t.a("VirtualFetcherDataSourceImpl", "OpenVirtual.fetchVirtual.e:", e16);
            }
            b bVar2 = this.f340165a;
            if (bVar2 != null) {
                bVar2.a(false, null, i3);
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface b {
        void a(boolean z16, List<VirtualInfo> list, int i3);
    }

    public static void b(String str, boolean z16, b bVar) {
        new k().a(str, String.valueOf(0), z16, new a(bVar));
    }

    public void a(String str, String str2, boolean z16, fp3.d dVar) {
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
        OpenSdkVirtualUtil.e("oidb_0xd19_2", String.valueOf(0), str, jSONObject.toString(), dVar, z16);
    }
}
