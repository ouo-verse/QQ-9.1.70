package com.tencent.richframework.widget.refresh.layout.listener;

import android.view.View;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface ScrollBoundaryDecider {
    boolean canLoadMore(View view);

    boolean canRefresh(View view);
}
