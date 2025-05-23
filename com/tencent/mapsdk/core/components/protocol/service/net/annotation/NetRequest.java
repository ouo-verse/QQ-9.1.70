package com.tencent.mapsdk.core.components.protocol.service.net.annotation;

import android.support.annotation.Keep;
import com.tencent.map.tools.net.NetMethod;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: P */
@Target({ElementType.METHOD})
@Keep
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes9.dex */
public @interface NetRequest {
    String authority() default "";

    String constQuery() default "";

    NetHead head() default @NetHead;

    NetMethod method();

    String path() default "";

    String[] queryKeys() default {};

    int retry() default 1;

    boolean useExtraQuery() default true;

    String userAgent() default "androidsdk";
}
