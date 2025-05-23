package com.tencent.mapsdk.core.components.protocol.service.net.annotation;

import android.support.annotation.Keep;
import com.tencent.map.tools.json.JsonComposer;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: P */
@Target({ElementType.METHOD})
@Keep
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes9.dex */
public @interface NetJsonResolver {
    Class<? extends JsonComposer> outModel();

    int[] queryRange();
}
