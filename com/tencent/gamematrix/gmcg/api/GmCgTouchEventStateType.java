package com.tencent.gamematrix.gmcg.api;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes6.dex */
public @interface GmCgTouchEventStateType {
    public static final int GmCgLongTimeNoTouchEvent = 2;
    public static final int GmCgLongTimeNoTouchEventCountdown = 3;
    public static final int GmCgTouchEventNotReceived = 0;
    public static final int GmCgTouchEventReceived = 1;
}
