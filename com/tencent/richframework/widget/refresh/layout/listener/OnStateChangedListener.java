package com.tencent.richframework.widget.refresh.layout.listener;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.constant.RefreshState;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface OnStateChangedListener {
    @RestrictTo({RestrictTo.Scope.LIBRARY, RestrictTo.Scope.LIBRARY_GROUP, RestrictTo.Scope.SUBCLASSES})
    void onStateChanged(@NonNull IRefreshLayout iRefreshLayout, @NonNull RefreshState refreshState, @NonNull RefreshState refreshState2);
}
