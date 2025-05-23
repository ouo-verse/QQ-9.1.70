package com.tencent.richmediabrowser.listener;

import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface IGalleryScaleListener {
    boolean onDoubleTap(MotionEvent motionEvent);

    boolean onScale(ScaleGestureDetector scaleGestureDetector);
}
