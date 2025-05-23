package com.tencent.qqmini.sdk.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: P */
@Target({ElementType.TYPE})
@MiniKeep
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes23.dex */
public @interface RuntimeLoaderConfig {
    public static final int RUNTIME_TYPE_ALL = -1;
    public static final int RUNTIME_TYPE_ALL_APP = 3;
    public static final int RUNTIME_TYPE_APP = 1;
    public static final int RUNTIME_TYPE_FLUTTER = 2;
    public static final int RUNTIME_TYPE_GAME = 4;

    @MiniKeep
    RuntimeLoaderInfo[] loaders();
}
