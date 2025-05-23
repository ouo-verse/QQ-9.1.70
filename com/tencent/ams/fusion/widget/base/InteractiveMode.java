package com.tencent.ams.fusion.widget.base;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes3.dex */
public @interface InteractiveMode {
    public static final int CLICK = 1;
    public static final int FLIP = 3;
    public static final int LEAN_FORWARD = 4;
    public static final int SCROLL = 6;
    public static final int SHAKE = 5;
    public static final int SLIDE = 2;
    public static final int TILT = 9;
    public static final int UNKNOWN = 0;
}
