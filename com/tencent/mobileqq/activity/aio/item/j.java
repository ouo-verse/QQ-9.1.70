package com.tencent.mobileqq.activity.aio.item;

import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes10.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private static final int[][] f179476a = {new int[]{2000, R.string.ivk, 0, 4}, new int[]{2002, R.string.ivl, R.drawable.bhl, 2}, new int[]{2003, R.string.ivj, R.drawable.nui, 3}, new int[]{2001, R.string.ivm, R.drawable.bhm, 1}};

    public static int a(int i3) {
        for (int[] iArr : f179476a) {
            if (iArr[0] == i3) {
                return iArr[3];
            }
        }
        return 0;
    }
}
