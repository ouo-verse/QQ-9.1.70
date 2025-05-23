package com.tencent.luggage.wxa.mc;

import android.util.SparseIntArray;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final SparseIntArray f134266a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(3);
        f134266a = sparseIntArray;
        sparseIntArray.put(0, 0);
        sparseIntArray.put(1, R.string.ywp);
        sparseIntArray.put(2, R.string.ywo);
    }

    public static int a(int i3) {
        return f134266a.get(i3, 0);
    }

    public static String b(int i3) {
        int a16 = a(i3);
        if (a16 == 0) {
            return "";
        }
        return com.tencent.luggage.wxa.tn.z.j().getString(a16);
    }
}
