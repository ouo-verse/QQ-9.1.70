package com.tencent.turingcam;

import android.util.Log;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class qtIFA {
    public static UMDtK a(UMDtK uMDtK, byte[] bArr) {
        Object obj;
        if (bArr != null && bArr.length != 0) {
            byte[] a16 = VBlVU.a(bArr, VBlVU.a());
            if (a16 != null && a16.length != 0) {
                byte[] b16 = Bp8QH.b(a16);
                if (b16 != null && b16.length != 0) {
                    OF1Jz oF1Jz = new OF1Jz();
                    new HashMap();
                    HashMap hashMap = new HashMap();
                    oF1Jz.f381963a = (short) 3;
                    oF1Jz.f381966d = 3;
                    if (b16.length >= 4) {
                        try {
                            YunKQ yunKQ = new YunKQ(b16, 4);
                            yunKQ.f382114b = "UTF-8";
                            oF1Jz.a(yunKQ);
                            yunKQ.f382113a = ByteBuffer.wrap(oF1Jz.f381969g);
                            if (AV6dE.f381723c == null) {
                                HashMap<String, byte[]> hashMap2 = new HashMap<>();
                                AV6dE.f381723c = hashMap2;
                                hashMap2.put("", new byte[0]);
                            }
                            HashMap a17 = yunKQ.a((Map) AV6dE.f381723c, 0, false);
                            try {
                                if (a17.containsKey("resp")) {
                                    if (hashMap.containsKey("resp")) {
                                        obj = hashMap.get("resp");
                                    } else {
                                        byte[] bArr2 = (byte[]) a17.get("resp");
                                        try {
                                            YunKQ yunKQ2 = new YunKQ();
                                            yunKQ2.f382113a = ByteBuffer.wrap(bArr2);
                                            yunKQ2.f382114b = "UTF-8";
                                            obj = yunKQ2.a((YunKQ) uMDtK, 0, true);
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
                                return (UMDtK) obj;
                            } catch (Throwable th5) {
                                Log.w("TuringDebug", th5);
                                return uMDtK;
                            }
                        } catch (Exception e17) {
                            throw new RuntimeException(e17);
                        }
                    }
                    throw new IllegalArgumentException("decode package must include size head");
                }
                Log.w("TuringDebug", "u3");
                return uMDtK;
            }
            Log.w("TuringDebug", "u2");
            return uMDtK;
        }
        Log.w("TuringDebug", "u1");
        return uMDtK;
    }
}
