package com.tencent.mobileqq.qqlive.framework.eventbroadcaster.annotation;

import com.tencent.mobileqq.qqlive.framework.eventbroadcaster.b;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

/* compiled from: P */
@Target({ElementType.TYPE, ElementType.FIELD})
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0018\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00030\u0002R\u001f\u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00030\u00028\u0006\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/framework/eventbroadcaster/annotation/ComponentEvent;", "", "", "Lkotlin/reflect/KClass;", "Lcom/tencent/mobileqq/qqlive/framework/eventbroadcaster/b;", "eventList", "()[Ljava/lang/Class;", "qq-live-base-impl_release"}, k = 1, mv = {1, 7, 1})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.FIELD, AnnotationTarget.CLASS})
@Retention(RetentionPolicy.RUNTIME)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
/* loaded from: classes17.dex */
public @interface ComponentEvent {
    Class<? extends b>[] eventList() default {};
}
