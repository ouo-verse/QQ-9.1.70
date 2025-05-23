package com.tencent.mtt.hippy.views.hippylist.recyclerview.helper.skikcy;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;

/* compiled from: P */
/* loaded from: classes20.dex */
public interface IHeaderHost {
    void addOnLayoutListener(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener);

    void attachHeader(View view, FrameLayout.LayoutParams layoutParams);

    void removeOnLayoutListener(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener);
}
