package com.google.errorprone.annotations.concurrent;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: P */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes2.dex */
public @interface GuardedBy {
    String value();
}
