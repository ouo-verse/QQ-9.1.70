package com.tencent.cache.api;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

@Retention(RetentionPolicy.RUNTIME)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005R\u000f\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0006R\u000f\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/cache/api/Page;", "", "business", "Lcom/tencent/cache/api/Business;", "type", "Lcom/tencent/cache/api/PageHierarchy;", "()Lcom/tencent/cache/api/Business;", "()Lcom/tencent/cache/api/PageHierarchy;", "Library_release"}, k = 1, mv = {1, 4, 2})
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
/* loaded from: classes5.dex */
public @interface Page {
    Business business();

    PageHierarchy type();
}
