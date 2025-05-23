package com.qzone.reborn.comment.utils.cachedata;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\bB\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\t"}, d2 = {"Lcom/qzone/reborn/comment/utils/cachedata/QZoneCommentCacheFactory;", "", "", "type", "Lcom/qzone/reborn/comment/utils/cachedata/a;", "a", "<init>", "()V", "MemoryType", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneCommentCacheFactory {

    /* renamed from: a, reason: collision with root package name */
    public static final QZoneCommentCacheFactory f53797a = new QZoneCommentCacheFactory();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000\u00a8\u0006\u0004"}, d2 = {"Lcom/qzone/reborn/comment/utils/cachedata/QZoneCommentCacheFactory$MemoryType;", "", "Companion", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: classes37.dex */
    public @interface MemoryType {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.f53798a;
        public static final int DB = 1;
        public static final int MMKV = 0;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/qzone/reborn/comment/utils/cachedata/QZoneCommentCacheFactory$MemoryType$a;", "", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.qzone.reborn.comment.utils.cachedata.QZoneCommentCacheFactory$MemoryType$a, reason: from kotlin metadata */
        /* loaded from: classes37.dex */
        public static final class Companion {

            /* renamed from: a, reason: collision with root package name */
            static final /* synthetic */ Companion f53798a = new Companion();

            Companion() {
            }
        }
    }

    QZoneCommentCacheFactory() {
    }

    public final a a(int type) {
        if (type == 1) {
            return new b();
        }
        return new d();
    }
}
