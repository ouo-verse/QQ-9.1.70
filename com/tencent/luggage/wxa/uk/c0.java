package com.tencent.luggage.wxa.uk;

import android.util.Base64;
import com.tencent.luggage.wxa.tn.w0;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class c0 {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a implements com.tencent.luggage.wxa.xd.l {

        /* renamed from: a, reason: collision with root package name */
        public String f142662a = "__nativeBuffers__";

        /* renamed from: b, reason: collision with root package name */
        public String f142663b = "key";

        /* renamed from: c, reason: collision with root package name */
        public String f142664c = "id";

        /* renamed from: d, reason: collision with root package name */
        public String f142665d = "base64";

        /* renamed from: e, reason: collision with root package name */
        public int f142666e = Integer.MAX_VALUE;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum b {
        OK,
        FAIL_SIZE_EXCEED_LIMIT
    }

    public static ByteBuffer a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bArr.length);
        allocateDirect.put(bArr, 0, bArr.length);
        allocateDirect.rewind();
        return allocateDirect;
    }

    public static ByteBuffer a(ByteBuffer byteBuffer) {
        return (byteBuffer == null || byteBuffer.isDirect() || !byteBuffer.hasArray()) ? byteBuffer : a(byteBuffer.array());
    }

    public static final b a(com.tencent.luggage.wxa.ei.j jVar, Map map, a aVar) {
        int p16;
        if (jVar != null && map != null) {
            if (aVar == null) {
                aVar = new a();
            }
            com.tencent.luggage.wxa.ei.l lVar = (com.tencent.luggage.wxa.ei.l) jVar.a(com.tencent.luggage.wxa.ei.l.class);
            JSONArray jSONArray = new JSONArray();
            Iterator it = map.entrySet().iterator();
            int i3 = 0;
            boolean z16 = false;
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                String str = (String) entry.getKey();
                Object value = entry.getValue();
                if (value != null && (value instanceof ByteBuffer)) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(aVar.f142663b, str);
                        if (lVar != null && (p16 = lVar.p()) != -1) {
                            ByteBuffer byteBuffer = (ByteBuffer) value;
                            lVar.a(p16, byteBuffer);
                            jSONObject.put(aVar.f142664c, p16);
                            i3 += byteBuffer.capacity();
                        } else {
                            jSONObject.put(aVar.f142665d, new String(Base64.encode(com.tencent.luggage.wxa.tk.c.a((ByteBuffer) value), 2), StandardCharsets.UTF_8));
                        }
                        jSONArray.mo162put(jSONObject);
                        z16 = true;
                    } catch (JSONException e16) {
                        com.tencent.luggage.wxa.tn.w.h("MicroMsg.NativeBufferUtil", "processNativeBuffer JSONException :%s", e16.getMessage());
                    }
                    it.remove();
                }
            }
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(lVar != null);
            objArr[1] = Integer.valueOf(i3);
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.NativeBufferUtil", "ToJs useX5JSCore %b,bufferSize %d", objArr);
            if (i3 > aVar.f142666e) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.NativeBufferUtil", "bufferSize exceed the limit, bufferSize = %d, limit = %d", Integer.valueOf(i3), Integer.valueOf(aVar.f142666e));
                return b.FAIL_SIZE_EXCEED_LIMIT;
            }
            if (z16) {
                map.put(aVar.f142662a, jSONArray);
            }
            return b.OK;
        }
        Object[] objArr2 = new Object[2];
        objArr2[0] = Boolean.valueOf(jVar == null);
        objArr2[1] = Boolean.valueOf(map == null);
        com.tencent.luggage.wxa.tn.w.b("MicroMsg.NativeBufferUtil", "processNativeBufferToJs fail, invalid argument, jsruntime is null:[%b], map is null:[%b]", objArr2);
        return b.OK;
    }

    public static final b a(com.tencent.luggage.wxa.ei.j jVar, JSONObject jSONObject, a aVar) {
        return a(jVar, null, jSONObject, aVar);
    }

    public static final b a(com.tencent.luggage.wxa.ei.j jVar, com.tencent.luggage.wxa.xd.o oVar, JSONObject jSONObject, a aVar) {
        if (jVar != null && jSONObject != null) {
            if (aVar == null) {
                aVar = new a();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray(aVar.f142662a);
            if (optJSONArray == null) {
                return b.OK;
            }
            jSONObject.remove(aVar.f142662a);
            int length = optJSONArray.length();
            int i3 = 0;
            for (int i16 = 0; i16 < length; i16++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i16);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString(aVar.f142663b);
                    if (!w0.c(optString)) {
                        int optInt = optJSONObject.optInt(aVar.f142664c, -1);
                        if (optInt == -1) {
                            try {
                                String optString2 = optJSONObject.optString(aVar.f142665d, "");
                                if (w0.c(optString2)) {
                                    com.tencent.luggage.wxa.tn.w.d("MicroMsg.NativeBufferUtil", "processNativeBufferFromJs base64 is null");
                                    jSONObject.put(optString, ByteBuffer.allocate(0));
                                } else {
                                    jSONObject.put(optString, ByteBuffer.wrap(Base64.decode(optString2.getBytes(Charset.forName("UTF-8")), 2)));
                                }
                            } catch (JSONException e16) {
                                com.tencent.luggage.wxa.tn.w.h("MicroMsg.NativeBufferUtil", "processNativeBufferFromJs JSONException :%s", e16.getMessage());
                            }
                        } else {
                            com.tencent.luggage.wxa.ei.l lVar = (com.tencent.luggage.wxa.ei.l) jVar.a(com.tencent.luggage.wxa.ei.l.class);
                            if (lVar == null) {
                                com.tencent.luggage.wxa.tn.w.f("MicroMsg.NativeBufferUtil", "processNativeBufferFromJs bufferAddon is null, not support");
                            } else {
                                ByteBuffer a16 = oVar == null ? lVar.a(optInt, false) : oVar.processNativeBuffer(optString, lVar, optInt);
                                if (a16 == null) {
                                    com.tencent.luggage.wxa.tn.w.f("MicroMsg.NativeBufferUtil", "processNativeBufferFromJs byteBuffer is null");
                                } else {
                                    a16.position(0);
                                    jSONObject.put(optString, a16);
                                    i3 += a16.capacity();
                                }
                            }
                        }
                    }
                }
            }
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.NativeBufferUtil", "processNativeBufferFromJs bufferSize %d", Integer.valueOf(i3));
            if (i3 > aVar.f142666e) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.NativeBufferUtil", "processNativeBufferFromJs fail, size exceed limit, bufferSize = %d, limit = %d", Integer.valueOf(i3), Integer.valueOf(aVar.f142666e));
                return b.FAIL_SIZE_EXCEED_LIMIT;
            }
            return b.OK;
        }
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(jVar == null);
        objArr[1] = Boolean.valueOf(jSONObject == null);
        com.tencent.luggage.wxa.tn.w.b("MicroMsg.NativeBufferUtil", "processNativeBufferToJs fail, invalid argument, jsruntime is null:[%b], data is null:[%b]", objArr);
        return b.OK;
    }

    public static void a(com.tencent.luggage.wxa.xd.d dVar, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("message", "convert native buffer parameter fail, event=" + str + ", error=native buffer exceed size limit");
        hashMap.put("stack", "");
        dVar.a("onError", new JSONObject(hashMap).toString());
    }
}
