package com.tencent.hippy.qq.view.tkd.doublescrollview;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface IDoubleScroll {
    int getLayoutHeight();

    int getNestViewScrollY();

    int getRealHeight();

    void notifyNestViewToFling(int i3, int i16);

    void scrollNestViewBy(int i3, int i16);

    void scrollNestViewTo(int i3, int i16);
}
