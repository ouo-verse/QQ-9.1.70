package com.tencent.ams.fusion.service.splash.data;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface SplashNetDataRequest extends mt.a {

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface RequestType {
        public static final int PRELOAD = 2;
        public static final int REALTIME = 1;
    }
}
