package com.tencent.gamematrix.gmcg.api;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes6.dex */
public @interface GmCgShutterLatencyState {
    public static final int StateBad = 3;
    public static final int StateGood = 1;
    public static final int StateNone = 0;
    public static final int StateNormal = 2;
}
