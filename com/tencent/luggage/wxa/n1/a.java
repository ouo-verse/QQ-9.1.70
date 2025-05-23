package com.tencent.luggage.wxa.n1;

import android.util.Base64;
import com.tencent.luggage.wxa.tk.g;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.d;
import com.tencent.luggage.wxa.xd.k0;
import com.tencent.qbar.QbarNative;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a extends k0 {
    private static final int CTRL_INDEX = 455;
    public static final String NAME = "onCameraScanCode";

    /* renamed from: a, reason: collision with root package name */
    public static a f135113a = new a();

    public static void a(d dVar, int i3, String str, int i16, String str2, byte[] bArr, QbarNative.QBarPoint qBarPoint) {
        HashMap hashMap = new HashMap();
        hashMap.put("cameraId", Integer.valueOf(i3));
        hashMap.put("type", str);
        hashMap.put("result", str2);
        hashMap.put("codeVersion", Integer.valueOf(Math.max(0, i16)));
        if (qBarPoint != null) {
            hashMap.put("scanArea", new float[]{g.b(qBarPoint.f342416x0), g.b(qBarPoint.f342420y0), g.b(qBarPoint.f342417x1 - qBarPoint.f342416x0), g.b(qBarPoint.f342423y3 - qBarPoint.f342420y0)});
        }
        if (bArr != null && bArr.length > 0) {
            String encodeToString = Base64.encodeToString(bArr, 2);
            hashMap.put("charSet", "utf-8");
            hashMap.put("rawData", encodeToString);
        }
        String jSONObject = new JSONObject(hashMap).toString();
        w.a("MicroMsg.JsApiCameraScanCode", "onCameraScanCode:%s", jSONObject);
        dVar.a(f135113a.getName(), jSONObject, (int[]) null);
    }
}
