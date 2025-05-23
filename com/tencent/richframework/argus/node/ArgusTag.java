package com.tencent.richframework.argus.node;

import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* compiled from: P */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0087\u0002\u0018\u00002\u00020\u0001B*\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004R\u0015\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0007R\u000f\u0010\u0006\u001a\u00020\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\bR\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007\u00a8\u0006\t"}, d2 = {"Lcom/tencent/richframework/argus/node/ArgusTag;", "", ComicCancelRedPointPopItemData.JSON_KEY_TAGS, "", "", "testTags", "testConfigKey", "()[Ljava/lang/String;", "()Ljava/lang/String;", "lifecycle_debug"}, k = 1, mv = {1, 4, 1})
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
/* loaded from: classes25.dex */
public @interface ArgusTag {
    String[] tags() default {};

    String testConfigKey() default "";

    String[] testTags() default {};
}
