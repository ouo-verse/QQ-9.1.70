package com.tencent.mapsdk.internal;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: P */
/* loaded from: classes9.dex */
public interface bw {
    void a();

    void a(float f16);

    void a(Object obj, int i3, int i16);

    void b();

    void c();

    void d();

    boolean e();

    int getHeight();

    View getView();

    int getWidth();

    void onSizeChanged(int i3, int i16, int i17, int i18);

    boolean onTouchEvent(MotionEvent motionEvent);

    void setMapOpaque(boolean z16);

    void setZOrderMediaOverlay(boolean z16);
}
