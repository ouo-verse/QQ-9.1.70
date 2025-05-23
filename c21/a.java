package c21;

import com.tencent.luggage.wxa.b8.j;

/* compiled from: P */
/* loaded from: classes8.dex */
public final /* synthetic */ class a {
    public static /* synthetic */ void a(j jVar, com.tencent.luggage.wxa.b8.a aVar, int i3, String str, String str2, boolean z16, int i16, Object obj) {
        int i17;
        String str3;
        String str4;
        boolean z17;
        if (obj == null) {
            if ((i16 & 2) != 0) {
                i17 = 0;
            } else {
                i17 = i3;
            }
            if ((i16 & 4) != 0) {
                str3 = "";
            } else {
                str3 = str;
            }
            if ((i16 & 8) != 0) {
                str4 = "";
            } else {
                str4 = str2;
            }
            if ((i16 & 16) != 0) {
                z17 = false;
            } else {
                z17 = z16;
            }
            jVar.a(aVar, i17, str3, str4, z17);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: handleReport");
    }
}
