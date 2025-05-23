package com.tencent.mobileqq.vas.pendant.drawable;

import java.util.Arrays;
import oicq.wlogin_sdk.tools.util;

/* loaded from: classes20.dex */
public final class AvatarPendantFileUtil {
    private static final long[] diyPendantArr;

    static {
        long[] jArr = {2396, 2403, 2405, 2406, 2407, 2409, 2410, 2404, 2408, 2411, 2448, 2447, 2449, 2462, 2461, 2463, 2479, 2480, 2485, 2486, 2499, 2498, 2501, 2502, 2500, 2517, 2519, 2518, 2528, 2529, 2531, 2503, 2573, 2575, 2572, util.SVN_VER, 2580, 2579, 2576, 2578, 2583, 2584, 2577, 2585, 2599, 2598, 2610, 2611, 2630, 2633, 2631, 2671, 2672, 2680, 2697, 2719, 2724, 2723, 2729, 2730, 2736, 2752, 2753, 2761, 2754, 2767, 2766, 2768, 2784, 2794, 2793, 2855, 2934, 2994, 3071, 3173, 3310, 3313, 3314, 3315, 3317, 3509, 4292, 8541};
        diyPendantArr = jArr;
        Arrays.sort(jArr);
    }

    public static boolean isDiyPendant(long j3) {
        if (Arrays.binarySearch(diyPendantArr, j3) >= 0) {
            return true;
        }
        return false;
    }
}
