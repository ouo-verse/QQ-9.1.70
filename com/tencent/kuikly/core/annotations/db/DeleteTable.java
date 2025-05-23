package com.tencent.kuikly.core.annotations.db;

import com.tencent.qqmini.sdk.plugins.ReportPlugin;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.Repeatable;
import kotlin.jvm.internal.RepeatableContainer;

/* compiled from: P */
@Target({ElementType.TYPE})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS})
@Retention(RetentionPolicy.SOURCE)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0087\u0002\u0018\u00002\u00020\u0001:\u0001\u0005B\b\u0012\u0006\u0010\u0002\u001a\u00020\u0003R\u000f\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/kuikly/core/annotations/db/DeleteTable;", "", ReportPlugin.KEY_TABLE_NAME, "", "()Ljava/lang/String;", "Entries", "core-annotations_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Repeatable
@java.lang.annotation.Repeatable(Container.class)
/* loaded from: classes33.dex */
public @interface DeleteTable {

    /* compiled from: P */
    @Target({ElementType.TYPE})
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    @RepeatableContainer
    /* loaded from: classes33.dex */
    public @interface Container {
        DeleteTable[] value();
    }

    /* compiled from: P */
    @Target({ElementType.TYPE})
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0014\u0012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004R\u0017\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/kuikly/core/annotations/db/DeleteTable$Entries;", "", "value", "", "Lcom/tencent/kuikly/core/annotations/db/DeleteTable;", "()[Lcom/tencent/kuikly/core/annotations/db/DeleteTable;", "core-annotations_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS})
    @Retention(RetentionPolicy.CLASS)
    @kotlin.annotation.Retention(AnnotationRetention.BINARY)
    /* loaded from: classes33.dex */
    public @interface Entries {
        DeleteTable[] value();
    }

    String tableName();
}
