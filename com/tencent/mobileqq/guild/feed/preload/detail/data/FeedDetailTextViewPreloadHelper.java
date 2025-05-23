package com.tencent.mobileqq.guild.feed.preload.detail.data;

import android.util.LruCache;
import com.tencent.aio.widget.textView.param.b;
import com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xq0.a;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\bH\u0016R \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\rR\u0016\u0010\u0010\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/preload/detail/data/FeedDetailTextViewPreloadHelper;", "Lxq0/a;", "", NodeProps.MAX_WIDTH, "", "c", "Lcom/tencent/aio/widget/textView/param/b;", "key", "Lxq0/b;", "a", "value", "b", "Landroid/util/LruCache;", "Landroid/util/LruCache;", "drawInfoCache", "I", "maxFeedContentWidth", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedDetailTextViewPreloadHelper implements a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final FeedDetailTextViewPreloadHelper f222783a = new FeedDetailTextViewPreloadHelper();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final LruCache<b, xq0.b> drawInfoCache = new LruCache<>(10);

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static int maxFeedContentWidth;

    static {
        Integer feedContentWidth = ((IQQGuildSPUtilsApi) QRoute.api(IQQGuildSPUtilsApi.class)).getFeedContentWidth();
        Intrinsics.checkNotNullExpressionValue(feedContentWidth, "api(IQQGuildSPUtilsApi::\u2026ss.java).feedContentWidth");
        maxFeedContentWidth = feedContentWidth.intValue();
    }

    FeedDetailTextViewPreloadHelper() {
    }

    @Override // xq0.a
    @Nullable
    public xq0.b a(@Nullable b key) {
        xq0.b bVar;
        if (key == null || (bVar = drawInfoCache.get(key)) == null) {
            return null;
        }
        return bVar.a();
    }

    @Override // xq0.a
    public void b(@NotNull b key, @NotNull xq0.b value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        if (value.g(key)) {
            drawInfoCache.put(key, value.a());
        }
    }

    public final void c(int maxWidth) {
        if (maxFeedContentWidth != maxWidth) {
            maxFeedContentWidth = maxWidth;
            CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.d.f261782e);
            if (f16 != null) {
                CorountineFunKt.e(f16, "FeedDetailTextViewPreloadHelper_addFeedContentLayoutWidth", null, null, null, new FeedDetailTextViewPreloadHelper$storeMainContentMaxWidth$1(maxWidth, null), 14, null);
            }
        }
    }
}
