package com.tencent.richframework.widget.refresh.layout.api;

import android.view.ViewGroup;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface IRefreshLayout {
    IRefreshLayout finishRefresh();

    @NonNull
    ViewGroup getLayout();

    IRefreshLayout setEnableAutoLoadMore(boolean z16);

    IRefreshLayout setEnableLoadMore(boolean z16);

    IRefreshLayout setEnableOverScrollBounce(boolean z16);

    IRefreshLayout setEnableOverScrollDrag(boolean z16);
}
