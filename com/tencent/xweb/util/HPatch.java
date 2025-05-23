package com.tencent.xweb.util;

import com.tencent.luggage.wxa.ar.b0;
import com.tencent.luggage.wxa.ar.n0;
import com.tencent.luggage.wxa.ar.w;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.oskplayer.cache.FileDataSink;
import com.tencent.xweb.LibraryLoader;

/* loaded from: classes27.dex */
public class HPatch extends b0 {
    static {
        LibraryLoader.loadLibrary("xweb_hpatchz");
    }

    @Override // com.tencent.luggage.wxa.ar.b0
    public int a(String str, String str2, String str3) {
        boolean z16;
        x0.d("HPatch", "doHPatch oldFile:" + str + ",patchFile:" + str2 + ",newFile:" + str3);
        long currentTimeMillis = System.currentTimeMillis();
        n0.A();
        if (str.equals(str3)) {
            str3 = str + FileDataSink.TEMP_FILE;
            z16 = true;
        } else {
            z16 = false;
        }
        int patch = new HPatch().patch(str, str2, str3, 262144L);
        if (patch != 0) {
            x0.d("HPatch", "doHPatch failed");
            n0.B();
        } else {
            x0.d("HPatch", "doHPatch successful");
            if (z16) {
                if (!w.a(str3, str)) {
                    x0.c("HPatch", "doHPatch same path, copy failed");
                    return -1;
                }
                w.b(str3);
            }
            n0.b(System.currentTimeMillis() - currentTimeMillis);
        }
        return patch;
    }

    public native int patch(String str, String str2, String str3, long j3);
}
