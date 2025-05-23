package com.tencent.mobileqq.vas.avatar;

/* compiled from: P */
/* loaded from: classes20.dex */
public final /* synthetic */ class h {
    public static String a(int i3, String str) {
        return "face." + i3 + "." + str;
    }

    public static String b(int i3) {
        if (i3 != 200) {
            if (i3 != 640) {
                return NtFaceConstant.SMALL;
            }
            return NtFaceConstant.LARGE;
        }
        return "medium";
    }

    public static int c(String str) {
        str.hashCode();
        if (!str.equals("medium")) {
            if (!str.equals(NtFaceConstant.LARGE)) {
                return 100;
            }
            return 640;
        }
        return 200;
    }
}
