package com.tencent.halley.common.d.a.a;

import android.text.TextUtils;
import com.tencent.halley.common.a.b;
import com.tencent.halley.common.a.c;
import com.tencent.halley.common.d.e;
import com.tencent.halley.common.d.h;
import com.tencent.halley.common.utils.d;
import com.tencent.halley.common.utils.j;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.java_websocket.WebSocketImpl;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class a extends com.tencent.halley.common.d.a.a implements e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    com.tencent.halley.common.d.b.b.c.a f113412a;

    /* renamed from: b, reason: collision with root package name */
    com.tencent.halley.common.a.c.a f113413b;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f113412a = new com.tencent.halley.common.d.b.b.c.a("HttpSchedulerClient");
        }
    }

    private void d() {
        com.tencent.halley.common.a.h().post(new Runnable() { // from class: com.tencent.halley.common.d.a.a.a.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                String b16 = c.b();
                a aVar = a.this;
                byte[] a16 = aVar.f113412a.a(b16);
                try {
                    if (!TextUtils.isEmpty(b16) && !j.a(a16)) {
                        JSONObject jSONObject = new JSONObject(new String(a16));
                        com.tencent.halley.common.a.c.a aVar2 = new com.tencent.halley.common.a.c.a(b16);
                        jSONObject.getString("ipInfo");
                        JSONObject optJSONObject = jSONObject.optJSONObject("resultMap");
                        if (optJSONObject != null) {
                            Iterator keys = optJSONObject.keys();
                            while (keys.hasNext()) {
                                JSONArray optJSONArray = optJSONObject.optJSONArray((String) keys.next());
                                if (optJSONArray != null) {
                                    a.a(aVar2, optJSONArray);
                                }
                            }
                        }
                        aVar.f113413b = aVar2;
                        d.c("halley-cloud-HttpSchedulerClient", "update cached DirectAccessInfo succ...");
                        b.c();
                    }
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
        });
    }

    @Override // com.tencent.halley.common.a.c.c
    public final List<com.tencent.halley.common.a.c.b> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        com.tencent.halley.common.a.c.a aVar = this.f113413b;
        if (aVar == null || !aVar.f113257a.equals(c.b())) {
            d();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, com.tencent.halley.common.a.c.b>> it = this.f113413b.f113258b.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getValue());
        }
        return arrayList;
    }

    @Override // com.tencent.halley.common.d.a.a
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "accessscheduler";
    }

    @Override // com.tencent.halley.common.d.a.a, com.tencent.halley.common.d.c
    public final void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            h.d().a();
        }
    }

    static void a(com.tencent.halley.common.a.c.a aVar, JSONArray jSONArray) {
        JSONArray jSONArray2;
        boolean z16;
        String string;
        int i3;
        int i16;
        com.tencent.halley.common.a.a aVar2;
        for (int i17 = 0; i17 < jSONArray.length(); i17++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i17);
                JSONArray optJSONArray = jSONObject.optJSONArray("domains");
                JSONArray optJSONArray2 = jSONObject.optJSONArray("iplist");
                JSONArray optJSONArray3 = jSONObject.optJSONArray("ipv6list");
                String optString = jSONObject.optString("schedulecode");
                int optInt = jSONObject.optInt("httpsport", WebSocketImpl.DEFAULT_WSS_PORT);
                if (optJSONArray != null) {
                    ArrayList arrayList = new ArrayList();
                    boolean z17 = true;
                    if (optJSONArray3 != null) {
                        int i18 = 0;
                        while (i18 < optJSONArray3.length()) {
                            try {
                                JSONObject jSONObject2 = optJSONArray3.getJSONObject(i18);
                                string = jSONObject2.getString("ip");
                                i3 = jSONObject2.getInt("port");
                                i16 = jSONObject2.getInt("type");
                                jSONArray2 = optJSONArray3;
                                try {
                                    aVar2 = new com.tencent.halley.common.a.a();
                                    z16 = z17;
                                    try {
                                    } catch (Throwable unused) {
                                    }
                                } catch (Throwable unused2) {
                                    z16 = z17;
                                    z17 = z16;
                                    i18++;
                                    optJSONArray3 = jSONArray2;
                                }
                            } catch (Throwable unused3) {
                                jSONArray2 = optJSONArray3;
                            }
                            if (aVar2.a(string + ":" + i3)) {
                                aVar2.f113198e = (byte) i16;
                                arrayList.add(aVar2);
                                z17 = false;
                                i18++;
                                optJSONArray3 = jSONArray2;
                            }
                            z17 = z16;
                            i18++;
                            optJSONArray3 = jSONArray2;
                        }
                    }
                    if (z17 && optJSONArray2 != null) {
                        for (int i19 = 0; i19 < optJSONArray2.length(); i19++) {
                            try {
                                JSONObject jSONObject3 = optJSONArray2.getJSONObject(i19);
                                String string2 = jSONObject3.getString("ip");
                                int i26 = jSONObject3.getInt("port");
                                int i27 = jSONObject3.getInt("type");
                                com.tencent.halley.common.a.a aVar3 = new com.tencent.halley.common.a.a();
                                if (aVar3.a(string2 + ":" + i26)) {
                                    aVar3.f113198e = (byte) i27;
                                    arrayList.add(aVar3);
                                }
                            } catch (Throwable unused4) {
                            }
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        for (int i28 = 0; i28 < optJSONArray.length(); i28++) {
                            try {
                                com.tencent.halley.common.a.c.b bVar = new com.tencent.halley.common.a.c.b(optJSONArray.getString(i28), optString);
                                bVar.f113262d = optInt;
                                bVar.f113261c.addAll(arrayList);
                                try {
                                    aVar.f113258b.put(bVar.f113259a, bVar);
                                } catch (Throwable unused5) {
                                }
                            } catch (Throwable unused6) {
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

    @Override // com.tencent.halley.common.d.a.a, com.tencent.halley.common.d.b
    public final void a(String str, byte[] bArr, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, bArr, str2);
        } else {
            this.f113412a.a(str, bArr);
            d();
        }
    }
}
