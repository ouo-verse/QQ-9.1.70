package com.tencent.biz.richframework.network.request;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ResponseSourceType {
    public static final int CACHE_THEN_NETWORK = 1;
    public static final int ONLY_CACHE = 2;

    public static String convertToHumanText(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                return "unknown responseSourceType";
            }
            return "ONLY_CACHE";
        }
        return "CACHE_THEN_NETWORK";
    }
}
