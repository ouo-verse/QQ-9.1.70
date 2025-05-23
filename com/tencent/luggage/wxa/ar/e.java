package com.tencent.luggage.wxa.ar;

import com.tencent.oskplayer.cache.FileDataSink;
import com.tencent.xweb.util.BSpatch;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e extends b0 {
    @Override // com.tencent.luggage.wxa.ar.b0
    public int a(String str, String str2, String str3) {
        boolean z16;
        x0.d("BsPatchWrapper", "doBSPatch oldFile:" + str + ",patchFile:" + str2 + ",newFile:" + str3);
        long currentTimeMillis = System.currentTimeMillis();
        n0.A();
        if (str.equals(str3)) {
            str3 = str + FileDataSink.TEMP_FILE;
            z16 = true;
        } else {
            z16 = false;
        }
        int nativeDoPatch = new BSpatch().nativeDoPatch(str, str2, str3);
        if (nativeDoPatch < 0) {
            x0.d("BsPatchWrapper", "doBSPatch failed, ret = " + nativeDoPatch + ", isSamePath = " + z16 + ", newFile = " + str3);
            n0.B();
            String a16 = y.a(str);
            String a17 = y.a(str2);
            String a18 = y.a(str3);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("doBSPatch failed, oldFileMD5 = ");
            if (a16 == null) {
                a16 = "";
            }
            sb5.append(a16);
            sb5.append(", patchFileMD5 = ");
            if (a17 == null) {
                a17 = "";
            }
            sb5.append(a17);
            sb5.append(", newFileMD5 = ");
            if (a18 == null) {
                a18 = "";
            }
            sb5.append(a18);
            x0.d("BsPatchWrapper", sb5.toString());
        } else {
            x0.d("BsPatchWrapper", "doBSPatch successful");
            if (z16) {
                if (!w.a(str3, str)) {
                    x0.c("BsPatchWrapper", "doBSPatch same path, copy failed");
                    return -1;
                }
                w.b(str3);
            }
            n0.b(System.currentTimeMillis() - currentTimeMillis);
        }
        return nativeDoPatch;
    }
}
