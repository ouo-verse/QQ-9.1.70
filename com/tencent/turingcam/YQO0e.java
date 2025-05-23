package com.tencent.turingcam;

/* compiled from: P */
/* loaded from: classes27.dex */
public class YQO0e {
    public static <T extends UMDtK> T a(byte[] bArr, T t16, boolean z16) {
        if (bArr != null && t16 != null) {
            if (z16) {
                try {
                    t16 = (T) t16.a();
                } catch (Exception unused) {
                }
            }
            t16.getClass();
            YunKQ yunKQ = new YunKQ(bArr);
            yunKQ.f382114b = "UTF-8";
            t16.a(yunKQ);
            return t16;
        }
        return null;
    }
}
