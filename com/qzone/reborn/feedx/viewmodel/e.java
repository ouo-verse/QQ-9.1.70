package com.qzone.reborn.feedx.viewmodel;

import androidx.collection.LruCache;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneDetailCacheManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0006J\u0006\u0010\u000b\u001a\u00020\nR\"\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\rR$\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0016"}, d2 = {"Lcom/qzone/reborn/feedx/viewmodel/e;", "", "", "key", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "", "d", "b", "a", "", "c", "Landroidx/collection/LruCache;", "Landroidx/collection/LruCache;", "feedCache", "Ljava/lang/Boolean;", "isEnable", "()Ljava/lang/Boolean;", "setEnable", "(Ljava/lang/Boolean;)V", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f55883a = new e();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static LruCache<String, BusinessFeedData> feedCache = new LruCache<>(20);

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static Boolean isEnable;

    e() {
    }

    public final void a() {
        if (c()) {
            feedCache.evictAll();
        }
    }

    public final BusinessFeedData b(String key) {
        BusinessFeedData businessFeedData;
        Intrinsics.checkNotNullParameter(key, "key");
        if (c() && (businessFeedData = feedCache.get(key)) != null) {
            return businessFeedData;
        }
        return null;
    }

    public final boolean c() {
        if (isEnable == null) {
            isEnable = Boolean.valueOf(com.qzone.reborn.configx.g.f53821a.b().D());
        }
        Boolean bool = isEnable;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public final void d(String key, BusinessFeedData feedData) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        if (c()) {
            RFWLog.d(QzoneDetailCacheManager.TAG, RFWLog.USR, "saveFeedDetailData: " + key + ", feedData: " + feedData.hashCode());
            feedCache.put(key, feedData);
        }
    }
}
