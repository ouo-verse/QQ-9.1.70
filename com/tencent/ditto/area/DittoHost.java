package com.tencent.ditto.area;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public interface DittoHost {

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface SilentRequestCallback {
        void onResponse(Object obj);
    }

    View getContainerView();

    Context getContext();

    Object getCurrentViewModel();

    int getPaddingBottom();

    int getPaddingLeft();

    int getPaddingRight();

    int getPaddingTop();

    void handleSilentRequest(String str, String str2, int i3, DittoArea dittoArea, MotionEvent motionEvent);

    void handleSilentUri(String str, DittoArea dittoArea, MotionEvent motionEvent);

    void handleUri(String str, DittoArea dittoArea, MotionEvent motionEvent);

    void invalidate();

    void invalidate(int i3, int i16, int i17, int i18);

    void invokeAreaClick(String str, MotionEvent motionEvent);

    void onContentDescriptionChanged(DittoArea dittoArea);

    void postInvalidate();

    void postInvalidateDelayed(long j3);

    void removeAccessibilityArea(List<DittoArea> list);

    void requestLayout();

    void storageViewModel(boolean z16);

    void turnOffHardwareAcceleration();
}
