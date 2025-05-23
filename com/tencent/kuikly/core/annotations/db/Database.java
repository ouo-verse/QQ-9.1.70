package com.tencent.kuikly.core.annotations.db;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

/* compiled from: P */
@Target({ElementType.TYPE})
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\u0002\u0018\u00002\u00020\u0001B2\u0012\u0010\u0010\u0002\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003R\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\u000bR\u0019\u0010\u0002\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\fR\u000f\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\rR\u000f\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/kuikly/core/annotations/db/Database;", "", "entities", "", "Lkotlin/reflect/KClass;", "name", "", "version", "", "autoMigrations", "Lcom/tencent/kuikly/core/annotations/db/AutoMigration;", "()[Lcom/tencent/kuikly/core/annotations/db/AutoMigration;", "()[Ljava/lang/Class;", "()Ljava/lang/String;", "()I", "core-annotations_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS})
@Retention(RetentionPolicy.SOURCE)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
/* loaded from: classes33.dex */
public @interface Database {
    AutoMigration[] autoMigrations() default {};

    Class<?>[] entities();

    String name();

    int version();
}
