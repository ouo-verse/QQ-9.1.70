package com.tencent.halley.common.d.b.b.c;

import com.tencent.halley.common.a.c;
import com.tencent.halley.common.utils.j;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class b extends com.tencent.halley.common.d.b.b.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    a f113511a;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f113511a = new a("HttpSchedulerHandler");
        }
    }

    @Override // com.tencent.halley.common.d.b.b.b, com.tencent.halley.common.d.a
    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            a(null, null);
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // com.tencent.halley.common.d.b.b.b
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "accessscheduler";
    }

    @Override // com.tencent.halley.common.d.b.b.b
    public final void a(com.tencent.halley.common.d.b.b.a aVar) {
        String sb5;
        JSONObject jSONObject;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
            return;
        }
        try {
            try {
                JSONObject jSONObject2 = new JSONObject();
                a aVar2 = this.f113511a;
                c.e();
                byte[] a16 = aVar2.a(c.b());
                JSONObject jSONObject3 = !j.a(a16) ? new JSONObject(new String(a16)) : null;
                if (jSONObject3 != null) {
                    JSONObject optJSONObject = jSONObject3.optJSONObject("resultMap");
                    if (optJSONObject != null) {
                        Iterator keys = optJSONObject.keys();
                        while (keys.hasNext()) {
                            String str = (String) keys.next();
                            JSONArray optJSONArray = optJSONObject.optJSONArray(str);
                            if (optJSONArray != null) {
                                JSONObject jSONObject4 = new JSONObject();
                                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                                    JSONObject jSONObject5 = optJSONArray.getJSONObject(i3);
                                    jSONObject4.put(jSONObject5.optString("unit"), jSONObject5.optString("schedulecode"));
                                }
                                jSONObject2.put(str, jSONObject4);
                            }
                        }
                        aVar.a("directScheduleCodes", jSONObject2);
                    }
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(com.tencent.halley.common.a.c());
                    sb5 = sb6.toString();
                    jSONObject = new JSONObject();
                } else {
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append(com.tencent.halley.common.a.c());
                    sb5 = sb7.toString();
                    jSONObject = new JSONObject();
                }
                jSONObject2.put(sb5, jSONObject);
                aVar.a("directScheduleCodes", jSONObject2);
            } catch (Exception unused) {
                JSONObject jSONObject6 = new JSONObject();
                StringBuilder sb8 = new StringBuilder();
                sb8.append(com.tencent.halley.common.a.c());
                jSONObject6.put(sb8.toString(), new JSONObject());
                aVar.a("directScheduleCodes", jSONObject6);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private void a(String str, byte[] bArr) {
        com.tencent.halley.common.a.h().post(new Runnable(str, bArr) { // from class: com.tencent.halley.common.d.b.b.c.b.1
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f113512a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ byte[] f113513b;

            {
                this.f113512a = str;
                this.f113513b = bArr;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, b.this, str, bArr);
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                String str2 = this.f113512a;
                byte[] bArr2 = this.f113513b;
                if (j.a(str2) || j.a(bArr2)) {
                    c.e();
                    str2 = c.b();
                    bArr2 = b.this.f113511a.a(str2);
                }
                com.tencent.halley.common.d.b.b.c.c().f113494a.a(str2, bArr2, null);
            }
        });
    }

    @Override // com.tencent.halley.common.d.b.b.b
    public final void a(JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) jSONObject);
            return;
        }
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("AccessScheduleRsp");
            if (optJSONObject != null) {
                String jSONObject2 = optJSONObject.toString();
                if (j.a(jSONObject2)) {
                    return;
                }
                byte[] bytes = jSONObject2.getBytes();
                if (j.a(bytes)) {
                    return;
                }
                String b16 = c.b();
                this.f113511a.a(b16, bytes);
                a(b16, bytes);
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }
}
