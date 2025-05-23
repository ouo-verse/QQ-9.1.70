package com.tencent.luggage.wxa.ne;

import android.os.ParcelUuid;
import android.util.Base64;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.luggage.wxa.oe.n;
import com.tencent.luggage.wxa.oe.o;
import com.tencent.luggage.wxa.tn.w0;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public String f135734a;

    /* renamed from: b, reason: collision with root package name */
    public String f135735b;

    /* renamed from: c, reason: collision with root package name */
    public int f135736c;

    /* renamed from: d, reason: collision with root package name */
    public LinkedHashMap f135737d;

    /* renamed from: e, reason: collision with root package name */
    public List f135738e;

    /* renamed from: f, reason: collision with root package name */
    public String f135739f;

    /* renamed from: g, reason: collision with root package name */
    public Map f135740g;

    /* renamed from: h, reason: collision with root package name */
    public Boolean f135741h;

    public d(String str, String str2) {
        this.f135734a = str;
        this.f135735b = str2;
        this.f135741h = null;
    }

    public byte[] a(int i3) {
        return new byte[]{(byte) (i3 & 255), (byte) ((i3 >> 8) & 255)};
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(Constants.SP_DEVICE_ID, this.f135735b);
        jSONObject.put("name", this.f135734a);
        jSONObject.put("RSSI", this.f135736c);
        Boolean bool = this.f135741h;
        if (bool != null) {
            jSONObject.put("connectable", bool);
        }
        byte[] bArr = new byte[0];
        StringBuilder sb5 = new StringBuilder();
        LinkedHashMap linkedHashMap = this.f135737d;
        if (linkedHashMap != null && !linkedHashMap.isEmpty()) {
            for (Map.Entry entry : this.f135737d.entrySet()) {
                bArr = a(bArr, a(((Integer) entry.getKey()).intValue()), (byte[]) entry.getValue());
            }
        }
        sb5.append(new String(Base64.encode(bArr, 2)));
        jSONObject.put("advertisData", sb5);
        JSONArray jSONArray = new JSONArray();
        List list = this.f135738e;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                jSONArray.mo162put(((ParcelUuid) it.next()).getUuid().toString().toUpperCase());
            }
        }
        jSONObject.put("advertisServiceUUIDs", jSONArray);
        jSONObject.put("localName", this.f135739f);
        JSONObject jSONObject2 = new JSONObject();
        Map map = this.f135740g;
        if (map != null && map.size() > 0) {
            for (ParcelUuid parcelUuid : this.f135740g.keySet()) {
                jSONObject2.put(parcelUuid.getUuid().toString().toUpperCase(), new String(Base64.encode((byte[]) this.f135740g.get(parcelUuid), 2)));
            }
        }
        jSONObject.put("serviceData", jSONObject2);
        return jSONObject;
    }

    public d(o oVar) {
        this.f135734a = w0.d(oVar.a().getName());
        this.f135735b = w0.d(oVar.a().getAddress());
        this.f135736c = oVar.b();
        this.f135741h = oVar.e();
        n c16 = oVar.c();
        if (c16 != null) {
            this.f135737d = c16.d();
            this.f135738e = c16.f();
            this.f135739f = w0.d(c16.b());
            this.f135740g = c16.e();
            return;
        }
        this.f135739f = "";
    }

    public byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        byte[] bArr4 = new byte[bArr.length + bArr2.length + bArr3.length];
        System.arraycopy(bArr, 0, bArr4, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr4, bArr.length, bArr2.length);
        System.arraycopy(bArr3, 0, bArr4, bArr.length + bArr2.length, bArr3.length);
        return bArr4;
    }
}
