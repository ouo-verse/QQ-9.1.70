package com.tencent.turingfd.sdk.xq;

import android.util.Log;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class q {
    public static Taurus a(Taurus taurus, byte[] bArr) {
        Object obj;
        if (bArr != null && bArr.length != 0) {
            byte[] a16 = Cdefault.a(bArr, Cdefault.a());
            if (a16 != null && a16.length != 0) {
                byte[] b16 = Cstatic.b(a16);
                if (b16 != null && b16.length != 0) {
                    Foxnut foxnut = new Foxnut();
                    new HashMap();
                    HashMap hashMap = new HashMap();
                    foxnut.f382770a = (short) 3;
                    foxnut.f382773d = 3;
                    if (b16.length >= 4) {
                        try {
                            Serpens serpens = new Serpens(b16, 4);
                            serpens.f383068b = "UTF-8";
                            foxnut.a(serpens);
                            serpens.f383067a = ByteBuffer.wrap(foxnut.f382776g);
                            if (p.f383409d == null) {
                                HashMap<String, byte[]> hashMap2 = new HashMap<>();
                                p.f383409d = hashMap2;
                                hashMap2.put("", new byte[0]);
                            }
                            HashMap a17 = serpens.a((Map) p.f383409d, 0, false);
                            try {
                                if (a17.containsKey("resp")) {
                                    if (hashMap.containsKey("resp")) {
                                        obj = hashMap.get("resp");
                                    } else {
                                        byte[] bArr2 = (byte[]) a17.get("resp");
                                        try {
                                            Serpens serpens2 = new Serpens();
                                            serpens2.f383067a = ByteBuffer.wrap(bArr2);
                                            serpens2.f383068b = "UTF-8";
                                            obj = serpens2.a((Serpens) taurus, 0, true);
                                            if (obj != null) {
                                                hashMap.put("resp", obj);
                                            }
                                        } catch (Exception e16) {
                                            throw new Exception(e16);
                                        }
                                    }
                                } else {
                                    obj = null;
                                }
                                return (Taurus) obj;
                            } catch (Throwable th5) {
                                Log.w("TuringDebug", th5);
                                return taurus;
                            }
                        } catch (Exception e17) {
                            throw new RuntimeException(e17);
                        }
                    }
                    throw new IllegalArgumentException("decode package must include size head");
                }
                Log.w("TuringDebug", "u3");
                return taurus;
            }
            Log.w("TuringDebug", "u2");
            return taurus;
        }
        Log.w("TuringDebug", "u1");
        return taurus;
    }
}
