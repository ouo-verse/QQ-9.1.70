package fi1;

import android.util.LruCache;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedConfigAPi;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeed;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0004R \u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000eR\u0018\u0010\u0012\u001a\u00020\n*\u00020\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lfi1/b;", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProContentRecommendFeed;", "feed", "", "c", "", "b", "d", "Landroid/util/LruCache;", "", "Landroid/util/LruCache;", "cache", "Lcom/tencent/mobileqq/guild/feed/api/IGuildFeedConfigAPi;", "Lcom/tencent/mobileqq/guild/feed/api/IGuildFeedConfigAPi;", DTConstants.TAG.API, "a", "(Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProContentRecommendFeed;)Ljava/lang/String;", "key", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f398763a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final LruCache<String, CharSequence> cache = new LruCache<>(50);

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final IGuildFeedConfigAPi api;

    static {
        QRouteApi api2 = QRoute.api(IGuildFeedConfigAPi.class);
        Intrinsics.checkNotNullExpressionValue(api2, "api(IGuildFeedConfigAPi::class.java)");
        api = (IGuildFeedConfigAPi) api2;
    }

    b() {
    }

    private final String a(IGProContentRecommendFeed iGProContentRecommendFeed) {
        return System.identityHashCode(iGProContentRecommendFeed) + "_" + iGProContentRecommendFeed.getIdd();
    }

    @NotNull
    public final CharSequence b(@NotNull IGProContentRecommendFeed feed) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        if (QLog.isDebugVersion()) {
            QLog.d("GuildRichTextPreloadHel", 1, "get " + System.identityHashCode(feed) + "_" + feed.getIdd());
        }
        LruCache<String, CharSequence> lruCache = cache;
        CharSequence charSequence = lruCache.get(a(feed));
        if (charSequence == null) {
            CharSequence parseMVPFeedsText = api.parseMVPFeedsText(feed);
            lruCache.put(f398763a.a(feed), parseMVPFeedsText);
            return parseMVPFeedsText;
        }
        return charSequence;
    }

    public final void c(@NotNull IGProContentRecommendFeed feed) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        if (QLog.isDebugVersion()) {
            QLog.d("GuildRichTextPreloadHel", 1, "put " + System.identityHashCode(feed) + "_" + feed.getIdd());
        }
        cache.put(a(feed), api.parseMVPFeedsText(feed));
    }

    public final void d() {
        cache.evictAll();
    }
}
