package com.tencent.kuikly.core.annotations.db;

import com.tencent.qqmini.sdk.plugins.ReportPlugin;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

/* compiled from: P */
@Target({ElementType.METHOD})
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0087\u0002\u0018\u00002\u00020\u0001B:\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003R\u000f\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\tR\u000f\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\tR\u000f\u0010\b\u001a\u00020\u0003\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000f\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u000f\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\tR\u000f\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/kuikly/core/annotations/db/Select;", "", ReportPlugin.KEY_TABLE_NAME, "", "where", "groupBy", "having", "orderBy", "limit", "()Ljava/lang/String;", "core-annotations_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.FUNCTION})
@Retention(RetentionPolicy.SOURCE)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
/* loaded from: classes33.dex */
public @interface Select {
    String groupBy() default "";

    String having() default "";

    String limit() default "";

    String orderBy() default "";

    String tableName();

    String where() default "";
}
