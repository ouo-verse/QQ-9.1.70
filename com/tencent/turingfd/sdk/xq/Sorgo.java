package com.tencent.turingfd.sdk.xq;

import android.os.Process;
import com.tencent.turingfd.sdk.xq.Casaba;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Sorgo {
    public static String a() {
        StringBuilder sb5 = new StringBuilder();
        int myPid = Process.myPid();
        Casaba.Cdo b16 = Casaba.b(myPid);
        if (b16 == null) {
            return sb5.toString();
        }
        int i3 = b16.f382641e;
        if (i3 == 0) {
            return sb5.toString();
        }
        if (i3 == myPid) {
            return sb5.toString();
        }
        sb5.append(myPid);
        sb5.append(",");
        sb5.append(b16.f382638b);
        sb5.append(",");
        sb5.append(b16.f382639c);
        sb5.append(",");
        sb5.append(i3);
        sb5.append(",");
        Casaba.Cdo b17 = Casaba.b(i3);
        if (b17 != null) {
            sb5.append(b17.f382640d);
            sb5.append(",");
            sb5.append(b17.f382639c);
            sb5.append(",");
            sb5.append(b17.f382638b);
        }
        return sb5.toString();
    }
}
