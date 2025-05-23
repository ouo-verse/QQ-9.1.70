package com.tencent.mapsdk.core.components.protocol.service.net.annotation;

import android.support.annotation.Keep;
import com.qq.taf.jce.MapJceStruct;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: P */
@Target({ElementType.METHOD})
@Keep
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes9.dex */
public @interface NetJceResolver {
    Class<? extends MapJceStruct> inJce();

    Class<? extends MapJceStruct> outJce();

    int[] queryRange();
}
