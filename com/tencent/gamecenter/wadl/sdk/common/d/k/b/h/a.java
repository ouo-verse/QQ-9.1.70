package com.tencent.gamecenter.wadl.sdk.common.d.k.b.h;

import android.text.TextUtils;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.gamecenter.wadl.sdk.common.d.i;
import com.tencent.gamecenter.wadl.sdk.common.d.k.b.b;
import com.tencent.gamecenter.wadl.sdk.common.d.k.b.e.c;
import com.tencent.gamecenter.wadl.sdk.common.e.g;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a extends b {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f107227a = false;

    /* renamed from: b, reason: collision with root package name */
    private static volatile boolean f107228b = false;

    /* renamed from: c, reason: collision with root package name */
    private static volatile boolean f107229c = false;

    /* JADX WARN: Removed duplicated region for block: B:12:0x003a A[Catch: Exception -> 0x0100, TRY_LEAVE, TryCatch #0 {Exception -> 0x0100, blocks: (B:3:0x000f, B:6:0x001a, B:9:0x001f, B:10:0x0032, B:12:0x003a, B:14:0x0042, B:16:0x004a, B:18:0x0052, B:19:0x005d, B:21:0x0065, B:23:0x006d, B:25:0x0075, B:27:0x0088, B:29:0x0090, B:31:0x0098, B:33:0x00a0, B:35:0x00a8, B:37:0x00c2, B:39:0x00d4, B:41:0x00de, B:45:0x0028), top: B:2:0x000f }] */
    @Override // com.tencent.gamecenter.wadl.sdk.common.d.k.b.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(com.tencent.gamecenter.wadl.sdk.common.d.k.b.a aVar) {
        c cVar = new c();
        com.tencent.gamecenter.wadl.sdk.common.d.k.b.e.b bVar = new com.tencent.gamecenter.wadl.sdk.common.d.k.b.e.b();
        com.tencent.gamecenter.wadl.sdk.common.d.k.b.e.a aVar2 = new com.tencent.gamecenter.wadl.sdk.common.d.k.b.e.a();
        try {
            if (!g.e(bVar.f107212b) && f107227a) {
                aVar.a("needUpdateState", 0);
                if (g.e(bVar.f107212b)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("model", cVar.f107214a);
                    jSONObject.put("osVersion", cVar.f107215b);
                    jSONObject.put("pseudoId", cVar.f107216c);
                    aVar.a("RegistDeviceInfo", jSONObject);
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("platform", (int) bVar.f107211a);
                jSONObject2.put(Constants.SP_DEVICE_ID, bVar.f107212b);
                jSONObject2.put("sdkVersion", bVar.f107213c);
                aVar.a("BindDeviceInfo", jSONObject2);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("bundle", aVar2.f107206a);
                jSONObject3.put("verCode", aVar2.f107207b);
                jSONObject3.put("verName", aVar2.f107208c);
                jSONObject3.put("appId", aVar2.f107210e);
                jSONObject3.put("uuid", aVar2.f107209d);
                JSONArray jSONArray = new JSONArray();
                jSONArray.mo162put(jSONObject3);
                aVar.a("AppState", jSONArray);
                aVar.a("netType", i.a(com.tencent.gamecenter.wadl.sdk.common.b.c.d()));
                aVar.a("oper", com.tencent.gamecenter.wadl.sdk.common.d.k.a.b.a(com.tencent.gamecenter.wadl.sdk.common.b.c.f().intValue()));
                com.tencent.gamecenter.wadl.sdk.common.e.b.a("HttpStateHandler", "isInit:" + f107228b + " isReport:" + f107229c);
            }
            aVar.a("needUpdateState", 1);
            f107227a = true;
            if (g.e(bVar.f107212b)) {
            }
            JSONObject jSONObject22 = new JSONObject();
            jSONObject22.put("platform", (int) bVar.f107211a);
            jSONObject22.put(Constants.SP_DEVICE_ID, bVar.f107212b);
            jSONObject22.put("sdkVersion", bVar.f107213c);
            aVar.a("BindDeviceInfo", jSONObject22);
            JSONObject jSONObject32 = new JSONObject();
            jSONObject32.put("bundle", aVar2.f107206a);
            jSONObject32.put("verCode", aVar2.f107207b);
            jSONObject32.put("verName", aVar2.f107208c);
            jSONObject32.put("appId", aVar2.f107210e);
            jSONObject32.put("uuid", aVar2.f107209d);
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.mo162put(jSONObject32);
            aVar.a("AppState", jSONArray2);
            aVar.a("netType", i.a(com.tencent.gamecenter.wadl.sdk.common.b.c.d()));
            aVar.a("oper", com.tencent.gamecenter.wadl.sdk.common.d.k.a.b.a(com.tencent.gamecenter.wadl.sdk.common.b.c.f().intValue()));
            com.tencent.gamecenter.wadl.sdk.common.e.b.a("HttpStateHandler", "isInit:" + f107228b + " isReport:" + f107229c);
        } catch (Exception unused) {
        }
    }

    @Override // com.tencent.gamecenter.wadl.sdk.common.d.k.b.b
    public String d() {
        return "state";
    }

    @Override // com.tencent.gamecenter.wadl.sdk.common.d.k.b.b
    public void a(JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString("result");
            if (!TextUtils.isEmpty(optString)) {
                try {
                    if (Integer.parseInt(optString) == 1002) {
                        i.a("");
                        return;
                    }
                } catch (Throwable unused) {
                }
            }
            String optString2 = jSONObject.optString(Constants.SP_DEVICE_ID);
            if (TextUtils.isEmpty(optString2)) {
                i.a("");
            } else {
                String a16 = i.a();
                if (!TextUtils.isEmpty(optString2) && !optString2.equals(a16)) {
                    i.a(optString2);
                }
            }
            String optString3 = jSONObject.optString("oper");
            if (TextUtils.isEmpty(optString3)) {
                return;
            }
            com.tencent.gamecenter.wadl.sdk.common.d.k.a.b.a().a(com.tencent.gamecenter.wadl.sdk.common.b.c.b(), optString3);
        } catch (Throwable th5) {
            com.tencent.gamecenter.wadl.sdk.common.e.b.a("Wadl-cloud-", "HttpStateHandler.onHttpRsp error.", th5);
        }
    }
}
