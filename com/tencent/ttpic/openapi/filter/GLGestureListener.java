package com.tencent.ttpic.openapi.filter;

import android.view.MotionEvent;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface GLGestureListener {
    public static final int PRIORITY_2D = 1030;
    public static final int PRIORITY_2D_GROUP = 1031;
    public static final int PRIORITY_3D = 1040;
    public static final int PRIORITY_ARPARTICLE = 1020;
    public static final int PRIORITY_HEIGHTEN_LINE = 1032;
    public static final int PRIORITY_MAX_VALUE = Integer.MAX_VALUE;
    public static final int PRIORITY_MIN_VALUE = 0;
    public static final int PRIORITY_MOVIE = 1050;
    public static final int PRIORITY_SWITCH_CAMERA = 1011;
    public static final int PRIORITY_SWITCH_FILTER = 1012;
    public static final int PRIORITY_TOUCH_TRIGGER = 1010;
    public static final int PROVIDER_VIEW_DISSMISS = 1060;
    public static final String TAG = "GLGestureListener";

    int onGetPriority();

    boolean onTouchEvent(MotionEvent motionEvent, boolean z16);
}
