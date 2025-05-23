package com.tencent.luggage.wxa.jg;

import android.os.Build;
import android.util.DisplayMetrics;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerMsg;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class m extends com.tencent.luggage.wxa.xd.v {
    public static final int CTRL_INDEX = 40;
    public static final String NAME = "getSystemInfo";

    /* renamed from: a, reason: collision with root package name */
    public final c f131113a;

    public m() {
        this(null);
    }

    @Override // com.tencent.luggage.wxa.xd.v
    public final String a(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject) {
        boolean z16;
        Map a16;
        long a17 = w0.a();
        try {
            c cVar = this.f131113a;
            if (cVar == null) {
                a16 = null;
            } else {
                a16 = cVar.a(dVar, jSONObject);
            }
            if (a16 != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (a16 == null) {
                try {
                    a16 = b(dVar);
                } catch (Throwable th5) {
                    th = th5;
                    com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsApiGetSystemInfo", "invoke cost:%dms, byNewImpl?:%b", Long.valueOf(w0.a() - a17), Boolean.valueOf(z16));
                    throw th;
                }
            }
            String makeReturnJson = makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, (Map<String, ? extends Object>) a16);
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsApiGetSystemInfo", "invoke cost:%dms, byNewImpl?:%b", Long.valueOf(w0.a() - a17), Boolean.valueOf(z16));
            return makeReturnJson;
        } catch (Throwable th6) {
            th = th6;
            z16 = false;
        }
    }

    public Map b(com.tencent.luggage.wxa.xd.d dVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("brand", Build.BRAND);
        hashMap.put("model", com.tencent.luggage.wxa.t9.l.g());
        hashMap.put("abi", Build.CPU_ABI);
        String[] strArr = Build.SUPPORTED_ABIS;
        if (strArr != null && strArr.length > 0) {
            hashMap.put("deviceAbi", strArr[0]);
        }
        hashMap.put(TVKPlayerMsg.PLAYER_CHOICE_SYSTEM, "Android " + Build.VERSION.RELEASE);
        DisplayMetrics displayMetrics = dVar.getContext().getResources().getDisplayMetrics();
        hashMap.put("pixelRatio", Float.valueOf(displayMetrics.density));
        hashMap.put("screenWidth", Integer.valueOf(com.tencent.luggage.wxa.tk.g.a(dVar.getContext(), displayMetrics.widthPixels)));
        hashMap.put("screenHeight", Integer.valueOf(com.tencent.luggage.wxa.tk.g.a(dVar.getContext(), displayMetrics.heightPixels)));
        hashMap.put("memorySize", Integer.valueOf(com.tencent.luggage.wxa.uk.m.a(dVar)));
        String b16 = com.tencent.luggage.wxa.t9.i.b();
        if (b16 == null) {
            b16 = "unknown";
        }
        hashMap.put("cpuType", b16);
        return hashMap;
    }

    public m(c cVar) {
        this.f131113a = cVar;
    }
}
