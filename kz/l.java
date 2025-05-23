package kz;

import kz.e;

/* compiled from: P */
/* loaded from: classes38.dex */
public class l {
    private static int a(boolean z16, boolean z17) {
        if (z16) {
            return 1;
        }
        if (z17) {
            return 3;
        }
        return 2;
    }

    public static e.b b(String str, boolean z16, boolean z17, boolean z18) {
        e.b bVar = new e.b();
        bVar.f413456a = str;
        bVar.f413457b = z17;
        if (z17) {
            bVar.f413459d = z18;
        } else {
            bVar.f413458c = z18;
        }
        bVar.f413460e = a(z16, z17);
        return bVar;
    }
}
