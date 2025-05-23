package com.google.android.filament.proguard;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/* compiled from: P */
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.TYPE, ElementType.CONSTRUCTOR})
/* loaded from: classes2.dex */
public @interface UsedByReflection {
    String value();
}
