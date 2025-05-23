package com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.poi;

/* loaded from: classes31.dex */
public final class NBPPOIMarkerViewModelKt {
    /* JADX WARN: Removed duplicated region for block: B:24:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x003f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean access$isSmallSize(String str) {
        boolean z16;
        int i3 = 0;
        int i16 = 0;
        while (true) {
            int i17 = 1;
            if (i3 >= str.length()) {
                break;
            }
            char charAt = str.charAt(i3);
            if (!('\u4e00' <= charAt && charAt < '\u9fa6')) {
                if (!('\u3000' <= charAt && charAt < '\u3040')) {
                    if (!('\uff00' <= charAt && charAt < '\ufff0')) {
                        z16 = false;
                        if (!z16) {
                            i17 = 2;
                        }
                        i16 += i17;
                        i3++;
                    }
                }
            }
            z16 = true;
            if (!z16) {
            }
            i16 += i17;
            i3++;
        }
        return i16 <= 8;
    }
}
