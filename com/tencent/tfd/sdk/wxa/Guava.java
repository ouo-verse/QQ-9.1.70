package com.tencent.tfd.sdk.wxa;

import android.util.Log;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class Guava {
    public static CanisMinor a(CanisMinor canisMinor, byte[] bArr) {
        Object obj;
        if (bArr != null && bArr.length != 0) {
            byte[] a16 = Cimport.a(bArr, Cimport.a());
            if (a16 != null && a16.length != 0) {
                byte[] a17 = Csuper.a(a16);
                if (a17 != null && a17.length != 0) {
                    Sagittarius sagittarius = new Sagittarius();
                    new HashMap();
                    HashMap hashMap = new HashMap();
                    sagittarius.f375669a = (short) 3;
                    sagittarius.f375672d = 3;
                    if (a17.length >= 4) {
                        try {
                            Caelum caelum = new Caelum(a17, 4);
                            caelum.f375491b = "UTF-8";
                            sagittarius.a(caelum);
                            caelum.f375490a = ByteBuffer.wrap(sagittarius.f375675g);
                            if (Grapefruit.f375636a == null) {
                                HashMap<String, byte[]> hashMap2 = new HashMap<>();
                                Grapefruit.f375636a = hashMap2;
                                hashMap2.put("", new byte[0]);
                            }
                            HashMap a18 = caelum.a((Map) Grapefruit.f375636a, 0, false);
                            try {
                                if (a18.containsKey("resp")) {
                                    if (hashMap.containsKey("resp")) {
                                        obj = hashMap.get("resp");
                                    } else {
                                        byte[] bArr2 = (byte[]) a18.get("resp");
                                        try {
                                            Caelum caelum2 = new Caelum();
                                            caelum2.f375490a = ByteBuffer.wrap(bArr2);
                                            caelum2.f375491b = "UTF-8";
                                            obj = caelum2.a((Caelum) canisMinor, 0, true);
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
                                return (CanisMinor) obj;
                            } catch (Throwable th5) {
                                Log.w("TuringDebug", th5);
                                return canisMinor;
                            }
                        } catch (Exception e17) {
                            throw new RuntimeException(e17);
                        }
                    }
                    throw new IllegalArgumentException("decode package must include size head");
                }
                Log.w("TuringDebug", "u3");
                return canisMinor;
            }
            Log.w("TuringDebug", "u2");
            return canisMinor;
        }
        Log.w("TuringDebug", "u1");
        return canisMinor;
    }
}
