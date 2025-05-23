package com.tencent.mobileqq.armap.sensor;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class b {
    static IPatchRedirector $redirector_;

    public static float[] a(float[] fArr, float[] fArr2) {
        if (fArr != null && fArr2 != null && fArr.length == fArr2.length) {
            for (int i3 = 0; i3 < fArr.length; i3++) {
                fArr[i3] = (fArr2[i3] * 0.9f) + (fArr[i3] * 0.100000024f);
            }
        }
        return fArr;
    }
}
