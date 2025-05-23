package com.tencent.bugly.library;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes5.dex */
public interface BuglyConstants {
    public static final int ANR_CRASH = 102;
    public static final int JAVA_CRASH = 100;
    public static final int NATIVE_CRASH = 101;
    public static final String TAG = "Bugly_Init";

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes5.dex */
    public @interface CrashTypeKey {
    }
}
