package com.tencent.mobileqq.nearby.redtouch;

import android.util.SparseIntArray;

/* compiled from: P */
/* loaded from: classes15.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public static final SparseIntArray f253084a;

    /* renamed from: b, reason: collision with root package name */
    public static final SparseIntArray f253085b;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(4);
        f253084a = sparseIntArray;
        SparseIntArray sparseIntArray2 = new SparseIntArray(4);
        f253085b = sparseIntArray2;
        sparseIntArray.put(1, 0);
        sparseIntArray.put(2, 5);
        sparseIntArray.put(3, 3);
        sparseIntArray.put(4, 4);
        sparseIntArray2.put(0, 1);
        sparseIntArray2.put(5, 2);
        sparseIntArray2.put(3, 3);
        sparseIntArray2.put(4, 4);
    }

    public static void a(RedTouchItem redTouchItem, RedTouchItem redTouchItem2) {
        redTouchItem.count = redTouchItem2.count;
        redTouchItem.receiveTime = redTouchItem2.receiveTime;
        redTouchItem.redtouchType = redTouchItem2.redtouchType;
        redTouchItem.curSeq = redTouchItem2.curSeq;
        redTouchItem.icon = redTouchItem2.icon;
        redTouchItem.unReadFlag = redTouchItem2.unReadFlag;
        redTouchItem.validTimeRemained = redTouchItem2.validTimeRemained;
        redTouchItem.isClosed = redTouchItem2.isClosed;
    }

    public static int b(int i3) {
        if (i3 >= 1 && i3 <= 4) {
            return f253084a.get(i3);
        }
        return f253084a.get(1);
    }
}
