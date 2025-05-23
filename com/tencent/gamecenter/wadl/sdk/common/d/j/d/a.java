package com.tencent.gamecenter.wadl.sdk.common.d.j.d;

import android.text.TextUtils;
import com.tencent.gamecenter.wadl.sdk.common.b.c;
import com.tencent.gamecenter.wadl.sdk.common.b.k.b;
import com.tencent.gamecenter.wadl.sdk.common.d.e;
import com.tencent.gamecenter.wadl.sdk.common.d.h;
import com.tencent.gamecenter.wadl.sdk.common.e.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.java_websocket.WebSocketImpl;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a extends com.tencent.gamecenter.wadl.sdk.common.d.j.a implements e {

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.gamecenter.wadl.sdk.common.d.k.b.f.a f107137a = new com.tencent.gamecenter.wadl.sdk.common.d.k.b.f.a("HttpSchedulerClient");

    /* renamed from: b, reason: collision with root package name */
    private b f107138b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.gamecenter.wadl.sdk.common.d.j.d.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class RunnableC1126a implements Runnable {
        RunnableC1126a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String b16 = c.b();
            a aVar = a.this;
            aVar.a(aVar.f107137a.a(b16), b16);
        }
    }

    private void e() {
        com.tencent.gamecenter.wadl.sdk.common.a.g().post(new RunnableC1126a());
    }

    @Override // com.tencent.gamecenter.wadl.sdk.common.d.e
    public List<com.tencent.gamecenter.wadl.sdk.common.b.k.a> b() {
        return null;
    }

    @Override // com.tencent.gamecenter.wadl.sdk.common.d.j.a
    public String c() {
        return "accessscheduler";
    }

    @Override // com.tencent.gamecenter.wadl.sdk.common.d.j.a, com.tencent.gamecenter.wadl.sdk.common.d.c
    public void d() {
        h.e().b();
    }

    @Override // com.tencent.gamecenter.wadl.sdk.common.b.k.d
    public List<com.tencent.gamecenter.wadl.sdk.common.b.k.c> a() {
        b bVar = this.f107138b;
        if (bVar == null || !bVar.a().equals(c.b())) {
            e();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, com.tencent.gamecenter.wadl.sdk.common.b.k.c>> it = this.f107138b.b().entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getValue());
        }
        return arrayList;
    }

    private List<com.tencent.gamecenter.wadl.sdk.common.b.a> a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i3);
                    String string = jSONObject.getString("ip");
                    int i16 = jSONObject.getInt("port");
                    int i17 = jSONObject.getInt("type");
                    com.tencent.gamecenter.wadl.sdk.common.b.a aVar = new com.tencent.gamecenter.wadl.sdk.common.b.a();
                    if (aVar.b(string + ":" + i16)) {
                        aVar.a((byte) i17);
                        arrayList.add(aVar);
                    }
                } catch (Throwable unused) {
                }
            }
        }
        return arrayList;
    }

    private void a(b bVar, JSONArray jSONArray) {
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                JSONArray optJSONArray = jSONObject.optJSONArray("domains");
                JSONArray optJSONArray2 = jSONObject.optJSONArray("iplist");
                JSONArray optJSONArray3 = jSONObject.optJSONArray("ipv6list");
                String optString = jSONObject.optString("schedulecode");
                int optInt = jSONObject.optInt("httpsport", WebSocketImpl.DEFAULT_WSS_PORT);
                if (optJSONArray != null) {
                    new ArrayList();
                    List<com.tencent.gamecenter.wadl.sdk.common.b.a> a16 = a(optJSONArray3);
                    if (a16.isEmpty()) {
                        a16 = a(optJSONArray2);
                    }
                    if (!a16.isEmpty()) {
                        for (int i16 = 0; i16 < optJSONArray.length(); i16++) {
                            try {
                                com.tencent.gamecenter.wadl.sdk.common.b.k.c cVar = new com.tencent.gamecenter.wadl.sdk.common.b.k.c(optJSONArray.getString(i16), optString);
                                cVar.f107058d = optInt;
                                cVar.f107057c.addAll(a16);
                                bVar.a(cVar);
                            } catch (Throwable unused) {
                            }
                        }
                    }
                }
            } catch (Exception e16) {
                e16.printStackTrace();
                return;
            }
        }
    }

    @Override // com.tencent.gamecenter.wadl.sdk.common.d.j.a, com.tencent.gamecenter.wadl.sdk.common.d.b
    public void a(String str, byte[] bArr, String str2) {
        this.f107137a.a(str, bArr);
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(byte[] bArr, String str) {
        try {
            if (TextUtils.isEmpty(str) || g.a(bArr)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(new String(bArr));
            b bVar = new b(str);
            jSONObject.getString("ipInfo");
            JSONObject optJSONObject = jSONObject.optJSONObject("resultMap");
            if (optJSONObject != null) {
                Iterator keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    JSONArray optJSONArray = optJSONObject.optJSONArray((String) keys.next());
                    if (optJSONArray != null) {
                        a(bVar, optJSONArray);
                    }
                }
            }
            this.f107138b = bVar;
            com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-cloud-HttpSchedulerClient", "update cached DirectAccessInfo succ...");
            com.tencent.gamecenter.wadl.sdk.common.b.b.f();
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }
}
