package com.tencent.biz.qqcircle.report.check.qfsimpl.api;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: P */
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes5.dex */
public @interface QFSTestRegisterEvent {
    String id();
}
