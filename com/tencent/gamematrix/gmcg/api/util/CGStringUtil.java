package com.tencent.gamematrix.gmcg.api.util;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGStringUtil {
    public static boolean isEmpty(String str) {
        if (str != null && str.length() != 0) {
            return false;
        }
        return true;
    }

    public static boolean notEmpty(String str) {
        if (str != null && str.length() > 0) {
            return true;
        }
        return false;
    }
}
