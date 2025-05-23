package com.tencent.mobileqq.zplan.ipc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationTarget;

/* compiled from: P */
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0016\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005R\u0013\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0006R\u000f\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/zplan/ipc/annotation/ServletImpl;", "", "impl", "Lkotlin/reflect/KClass;", "process", "", "()Ljava/lang/Class;", "()Ljava/lang/String;", "zplan_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CLASS})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes21.dex */
public @interface ServletImpl {
    Class<?> impl();

    String process() default "com.tencent.mobileqq";
}
