package com.qzone.component.banner;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a {
    public static boolean a(int i3) {
        if (i3 != 18 && i3 != 5 && i3 != 26) {
            return false;
        }
        return true;
    }

    public static boolean b(BusinessADBannerData businessADBannerData) {
        if (businessADBannerData == null) {
            return false;
        }
        int i3 = businessADBannerData.patternId;
        return i3 == 1039 || i3 == 1040;
    }
}
