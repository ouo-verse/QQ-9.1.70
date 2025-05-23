package com.tx.x2j.ano;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: P */
@Target({ElementType.TYPE})
@Repeatable(X2JViews.class)
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes27.dex */
public @interface X2JView {
    String[] value();
}
