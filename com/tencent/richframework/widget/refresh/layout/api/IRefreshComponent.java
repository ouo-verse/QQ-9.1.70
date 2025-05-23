package com.tencent.richframework.widget.refresh.layout.api;

import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.tencent.richframework.widget.refresh.layout.constant.SpinnerStyle;
import com.tencent.richframework.widget.refresh.layout.listener.OnStateChangedListener;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface IRefreshComponent extends OnStateChangedListener {
    boolean autoOpen(int i3, float f16, boolean z16);

    @NonNull
    SpinnerStyle getSpinnerStyle();

    @NonNull
    View getView();

    boolean isSupportHorizontalDrag();

    @RestrictTo({RestrictTo.Scope.LIBRARY, RestrictTo.Scope.LIBRARY_GROUP, RestrictTo.Scope.SUBCLASSES})
    int onFinish(@NonNull IRefreshLayout iRefreshLayout, boolean z16);

    @RestrictTo({RestrictTo.Scope.LIBRARY, RestrictTo.Scope.LIBRARY_GROUP, RestrictTo.Scope.SUBCLASSES})
    void onHorizontalDrag(float f16, int i3, int i16);

    @RestrictTo({RestrictTo.Scope.LIBRARY, RestrictTo.Scope.LIBRARY_GROUP, RestrictTo.Scope.SUBCLASSES})
    void onInitialized(@NonNull IRefreshKernel iRefreshKernel, int i3, int i16);

    @RestrictTo({RestrictTo.Scope.LIBRARY, RestrictTo.Scope.LIBRARY_GROUP, RestrictTo.Scope.SUBCLASSES})
    void onMoving(boolean z16, float f16, int i3, int i16, int i17);

    @RestrictTo({RestrictTo.Scope.LIBRARY, RestrictTo.Scope.LIBRARY_GROUP, RestrictTo.Scope.SUBCLASSES})
    void onReleased(@NonNull IRefreshLayout iRefreshLayout, int i3, int i16);

    @RestrictTo({RestrictTo.Scope.LIBRARY, RestrictTo.Scope.LIBRARY_GROUP, RestrictTo.Scope.SUBCLASSES})
    void onStartAnimator(@NonNull IRefreshLayout iRefreshLayout, int i3, int i16);

    @RestrictTo({RestrictTo.Scope.LIBRARY, RestrictTo.Scope.LIBRARY_GROUP, RestrictTo.Scope.SUBCLASSES})
    void setPrimaryColors(@ColorInt int... iArr);
}
