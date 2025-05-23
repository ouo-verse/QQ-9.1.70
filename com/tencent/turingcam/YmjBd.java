package com.tencent.turingcam;

import android.os.Process;
import com.tencent.turingcam.oqKCa;

/* compiled from: P */
/* loaded from: classes27.dex */
public class YmjBd {
    public static String a() {
        StringBuilder sb5 = new StringBuilder();
        int myPid = Process.myPid();
        oqKCa.spXPg b16 = oqKCa.b(myPid);
        if (b16 == null) {
            return sb5.toString();
        }
        int i3 = b16.f382334e;
        if (i3 == 0) {
            return sb5.toString();
        }
        if (i3 == myPid) {
            return sb5.toString();
        }
        sb5.append(myPid);
        sb5.append(",");
        sb5.append(b16.f382331b);
        sb5.append(",");
        sb5.append(b16.f382332c);
        sb5.append(",");
        sb5.append(i3);
        sb5.append(",");
        oqKCa.spXPg b17 = oqKCa.b(i3);
        if (b17 != null) {
            sb5.append(b17.f382333d);
            sb5.append(",");
            sb5.append(b17.f382332c);
            sb5.append(",");
            sb5.append(b17.f382331b);
        }
        return sb5.toString();
    }
}
