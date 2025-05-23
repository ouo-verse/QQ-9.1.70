package com.tencent.gamecenter.wadl.sdk.common.d.k.b.f;

import com.tencent.gamecenter.wadl.sdk.common.b.c;
import com.tencent.gamecenter.wadl.sdk.common.e.g;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public class b extends com.tencent.gamecenter.wadl.sdk.common.d.k.b.b {

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.gamecenter.wadl.sdk.common.d.k.b.f.a f107220a = new com.tencent.gamecenter.wadl.sdk.common.d.k.b.f.a("HttpSchedulerHandler");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class a implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f107221d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ byte[] f107222e;

        a(String str, byte[] bArr) {
            this.f107221d = str;
            this.f107222e = bArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = this.f107221d;
            byte[] bArr = this.f107222e;
            if (g.e(str) || g.a(bArr)) {
                c.m();
                str = c.b();
                bArr = b.this.f107220a.a(str);
            }
            com.tencent.gamecenter.wadl.sdk.common.d.k.b.c.d().e().a(str, bArr, null);
        }
    }

    @Override // com.tencent.gamecenter.wadl.sdk.common.d.k.b.b, com.tencent.gamecenter.wadl.sdk.common.d.a
    public void b() {
        a(null, null);
    }

    @Override // com.tencent.gamecenter.wadl.sdk.common.d.k.b.b
    public String d() {
        return "accessscheduler";
    }

    public JSONObject e() {
        String str;
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        JSONObject b16 = this.f107220a.b();
        if (b16 != null) {
            JSONObject optJSONObject = b16.optJSONObject("resultMap");
            if (optJSONObject != null) {
                Iterator keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String str2 = (String) keys.next();
                    JSONArray optJSONArray = optJSONObject.optJSONArray(str2);
                    if (optJSONArray != null) {
                        JSONObject jSONObject3 = new JSONObject();
                        for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                            JSONObject jSONObject4 = optJSONArray.getJSONObject(i3);
                            jSONObject3.put(jSONObject4.optString("unit"), jSONObject4.optString("schedulecode"));
                        }
                        jSONObject2.put(str2, jSONObject3);
                    }
                }
                return jSONObject2;
            }
            str = "" + com.tencent.gamecenter.wadl.sdk.common.a.c();
            jSONObject = new JSONObject();
        } else {
            str = "" + com.tencent.gamecenter.wadl.sdk.common.a.c();
            jSONObject = new JSONObject();
        }
        jSONObject2.put(str, jSONObject);
        return jSONObject2;
    }

    @Override // com.tencent.gamecenter.wadl.sdk.common.d.k.b.b
    public void a(com.tencent.gamecenter.wadl.sdk.common.d.k.b.a aVar) {
        try {
            try {
                aVar.a("directScheduleCodes", e());
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        } catch (Exception unused) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("" + com.tencent.gamecenter.wadl.sdk.common.a.c(), new JSONObject());
            aVar.a("directScheduleCodes", jSONObject);
        }
    }

    private void a(String str, byte[] bArr) {
        com.tencent.gamecenter.wadl.sdk.common.a.g().post(new a(str, bArr));
    }

    @Override // com.tencent.gamecenter.wadl.sdk.common.d.k.b.b
    public void a(JSONObject jSONObject) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("AccessScheduleRsp");
            if (optJSONObject != null) {
                String jSONObject2 = optJSONObject.toString();
                if (g.e(jSONObject2)) {
                    return;
                }
                byte[] bytes = jSONObject2.getBytes();
                if (g.a(bytes)) {
                    return;
                }
                String b16 = c.b();
                this.f107220a.a(b16, bytes);
                a(b16, bytes);
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }
}
