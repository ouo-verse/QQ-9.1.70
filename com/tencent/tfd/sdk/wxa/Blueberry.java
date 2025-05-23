package com.tencent.tfd.sdk.wxa;

import android.os.Process;
import com.tencent.tfd.sdk.wxa.Norma;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class Blueberry {
    public static String a() {
        StringBuilder sb5 = new StringBuilder();
        int myPid = Process.myPid();
        Norma.Cdo b16 = Norma.b(myPid);
        if (b16 == null) {
            return sb5.toString();
        }
        int i3 = b16.f375659e;
        if (i3 == 0) {
            return sb5.toString();
        }
        if (i3 == myPid) {
            return sb5.toString();
        }
        sb5.append(myPid);
        sb5.append(",");
        sb5.append(b16.f375656b);
        sb5.append(",");
        sb5.append(b16.f375657c);
        sb5.append(",");
        sb5.append(i3);
        sb5.append(",");
        Norma.Cdo b17 = Norma.b(i3);
        if (b17 != null) {
            sb5.append(b17.f375658d);
            sb5.append(",");
            sb5.append(b17.f375657c);
            sb5.append(",");
            sb5.append(b17.f375656b);
        }
        return sb5.toString();
    }
}
