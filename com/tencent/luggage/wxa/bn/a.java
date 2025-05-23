package com.tencent.luggage.wxa.bn;

import com.tencent.luggage.wxa.h1.e;
import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {
    public static void a(String str, int i3, int i16) {
        ((com.tencent.luggage.wxa.zj.d) e.c(com.tencent.luggage.wxa.zj.d.class)).a(13711, 0, str, Integer.valueOf(i3), Integer.valueOf(i16));
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0019, code lost:
    
        if (r13 != 1004) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(int i3, int i16, long j3) {
        int i17 = 4;
        if (i16 == 4) {
            i17 = 1;
        } else if (i16 == 6) {
            i17 = 3;
        } else if (i16 == 1001) {
            i17 = 5;
        } else if (i16 == 1023) {
            if (i3 == 3) {
                i17 = 0;
            }
            i17 = -1;
        } else if (i16 == 1003) {
            i17 = 2;
        }
        if (i17 != -1) {
            w.d("SoterLuggageReportManager", "luggage soter idkey report id: %d, key: %d, value: %d", 672, Integer.valueOf(i17), Long.valueOf(j3));
            ((com.tencent.luggage.wxa.zj.b) e.c(com.tencent.luggage.wxa.zj.b.class)).a(672L, i17, j3, false);
        }
    }
}
