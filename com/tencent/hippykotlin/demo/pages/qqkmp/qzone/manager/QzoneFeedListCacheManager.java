package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager;

import c45.i;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.cache.QzoneProtocolCacheManager;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.GetFeedsRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.GetMainPageFeedsRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.GetShuoshuoListRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service.QzoneBaseServiceKt;
import com.tencent.hippykotlin.demo.pages.qzone.module.QZoneComposePlatformModule;
import com.tencent.kuikly.core.kmp.a;
import com.tencent.kuikly.core.log.KLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\r\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0011\u001a\u00020\u000fJ\u0006\u0010\u0012\u001a\u00020\u000fJ\u0006\u0010\u0013\u001a\u00020\u000fJ\u0006\u0010\u0014\u001a\u00020\u000fJ\b\u0010\u0015\u001a\u00020\u0004H\u0002J\u0006\u0010\u0016\u001a\u00020\u0004J\u0006\u0010\u0017\u001a\u00020\u0004J\u0006\u0010\u0018\u001a\u00020\u0004JY\u0010\u0019\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u0001H\u001a2\u0006\u0010\u001c\u001a\u00020\u00042\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0006\u0012\u0004\u0018\u0001H\u001a0\u001e2\u0014\u0010 \u001a\u0010\u0012\u0004\u0012\u0002H\u001a\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u001e2\u0006\u0010!\u001a\u00020\u0004H\u0002\u00a2\u0006\u0002\u0010\"J#\u0010#\u001a\u00020\u000f2\u0014\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u001eH\u0000\u00a2\u0006\u0002\b$J#\u0010%\u001a\u00020\u000f2\u0014\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u001eH\u0000\u00a2\u0006\u0002\b&J#\u0010'\u001a\u00020\u000f2\u0014\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u001eH\u0000\u00a2\u0006\u0002\b(J\u0006\u0010)\u001a\u00020\u000fJ\u0006\u0010*\u001a\u00020\u000fJ\u0006\u0010+\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006,"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/QzoneFeedListCacheManager;", "", "()V", QzoneFeedListCacheManager.FRIEND_FEED_LIST_CACHE_KEY, "", QzoneFeedListCacheManager.MAIN_PAGE_LIST_CACHE_KEY, QzoneFeedListCacheManager.MOOD_LIST_CACHE_KEY, "TAG", "friendFeedCache", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/GetFeedsRsp;", "masterMoodListCache", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/GetShuoshuoListRsp;", "masterPageRspCache", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/GetMainPageFeedsRsp;", "clearAllCache", "", "clearDiskCache", "clearFriendFeedMemoryCache", "clearMainPageMemoryCache", "clearMemoryCache", "clearMoodListMemoryCache", "getCacheKeyPrefix", "getFriendFeedCacheKey", "getMainPageCacheKey", "getMoodListCacheKey", "loadCache", "T", "cache", "cacheKey", "decodeFunc", "Lkotlin/Function1;", "", "callback", "logPrefix", "(Ljava/lang/Object;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Ljava/lang/String;)V", "loadFriendFeedCache", "loadFriendFeedCache$qecommerce_biz_release", "loadMainPageCache", "loadMainPageCache$qecommerce_biz_release", "loadMoodListCache", "loadMoodListCache$qecommerce_biz_release", "preloadFriendFeedCache", "preloadMainPageCache", "preloadMoodListCache", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QzoneFeedListCacheManager {
    private static final String FRIEND_FEED_LIST_CACHE_KEY = "FRIEND_FEED_LIST_CACHE_KEY";
    private static final String MAIN_PAGE_LIST_CACHE_KEY = "MAIN_PAGE_LIST_CACHE_KEY";
    private static final String MOOD_LIST_CACHE_KEY = "MOOD_LIST_CACHE_KEY";
    public static final String TAG = "QzoneFeedListCacheManager";
    private static GetFeedsRsp friendFeedCache;
    private static GetShuoshuoListRsp masterMoodListCache;
    private static GetMainPageFeedsRsp masterPageRspCache;
    public static final QzoneFeedListCacheManager INSTANCE = new QzoneFeedListCacheManager();
    public static final int $stable = 8;

    QzoneFeedListCacheManager() {
    }

    private final String getCacheKeyPrefix() {
        return QZoneComposePlatformModule.Companion.getUin() + util.base64_pad_url;
    }

    public final void clearAllCache() {
        clearMemoryCache();
        clearDiskCache();
    }

    public final void clearDiskCache() {
        a.a(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFeedListCacheManager$clearDiskCache$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                QzoneProtocolCacheManager qzoneProtocolCacheManager = QzoneProtocolCacheManager.INSTANCE;
                QzoneFeedListCacheManager qzoneFeedListCacheManager = QzoneFeedListCacheManager.INSTANCE;
                qzoneProtocolCacheManager.clearCache(qzoneFeedListCacheManager.getFriendFeedCacheKey());
                qzoneProtocolCacheManager.clearCache(qzoneFeedListCacheManager.getMainPageCacheKey());
                qzoneProtocolCacheManager.clearCache(qzoneFeedListCacheManager.getMoodListCacheKey());
            }
        });
    }

    public final String getFriendFeedCacheKey() {
        return OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0.m(new StringBuilder(), getCacheKeyPrefix(), FRIEND_FEED_LIST_CACHE_KEY);
    }

    public final String getMainPageCacheKey() {
        return OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0.m(new StringBuilder(), getCacheKeyPrefix(), MAIN_PAGE_LIST_CACHE_KEY);
    }

    public final String getMoodListCacheKey() {
        return OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0.m(new StringBuilder(), getCacheKeyPrefix(), MOOD_LIST_CACHE_KEY);
    }

    public final void loadFriendFeedCache$qecommerce_biz_release(Function1<? super GetFeedsRsp, Unit> callback) {
        loadCache(friendFeedCache, getFriendFeedCacheKey(), new Function1<byte[], GetFeedsRsp>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFeedListCacheManager$loadFriendFeedCache$1
            @Override // kotlin.jvm.functions.Function1
            public final GetFeedsRsp invoke(byte[] bArr) {
                return (GetFeedsRsp) i.b(new GetFeedsRsp(null, null, null, false, 0, 31, null), bArr);
            }
        }, callback, "loadFriendFeed");
    }

    public final void loadMainPageCache$qecommerce_biz_release(Function1<? super GetMainPageFeedsRsp, Unit> callback) {
        loadCache(masterPageRspCache, getMainPageCacheKey(), new Function1<byte[], GetMainPageFeedsRsp>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFeedListCacheManager$loadMainPageCache$1
            @Override // kotlin.jvm.functions.Function1
            public final GetMainPageFeedsRsp invoke(byte[] bArr) {
                return (GetMainPageFeedsRsp) i.b(new GetMainPageFeedsRsp(null, null, null, false, null, null, 0, 127, null), bArr);
            }
        }, callback, "loadMainPage");
    }

    public final void loadMoodListCache$qecommerce_biz_release(Function1<? super GetShuoshuoListRsp, Unit> callback) {
        loadCache(masterMoodListCache, getMoodListCacheKey(), new Function1<byte[], GetShuoshuoListRsp>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFeedListCacheManager$loadMoodListCache$1
            @Override // kotlin.jvm.functions.Function1
            public final GetShuoshuoListRsp invoke(byte[] bArr) {
                return (GetShuoshuoListRsp) i.b(new GetShuoshuoListRsp(null, null, null, false, 0, null, 63, null), bArr);
            }
        }, callback, "loadMoodList");
    }

    public final void clearFriendFeedMemoryCache() {
        friendFeedCache = null;
    }

    public final void clearMainPageMemoryCache() {
        masterPageRspCache = null;
    }

    public final void clearMemoryCache() {
        friendFeedCache = null;
        masterPageRspCache = null;
        masterMoodListCache = null;
    }

    public final void clearMoodListMemoryCache() {
        masterMoodListCache = null;
    }

    public final void preloadFriendFeedCache() {
        loadFriendFeedCache$qecommerce_biz_release(null);
    }

    public final void preloadMainPageCache() {
        loadMainPageCache$qecommerce_biz_release(null);
    }

    public final void preloadMoodListCache() {
        loadMoodListCache$qecommerce_biz_release(null);
    }

    private final <T> void loadCache(final T cache, final String cacheKey, final Function1<? super byte[], ? extends T> decodeFunc, final Function1<? super T, Unit> callback, final String logPrefix) {
        if (cache != null) {
            QzoneBaseServiceKt.runOnUIThread(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFeedListCacheManager$loadCache$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Function1<T, Unit> function1;
                    T t16 = cache;
                    if (t16 == 0 || (function1 = callback) == 0) {
                        return;
                    }
                    function1.invoke(t16);
                }
            });
        } else {
            a.a(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFeedListCacheManager$loadCache$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Unit unit;
                    try {
                        KLog kLog = KLog.INSTANCE;
                        kLog.d(QzoneFeedListCacheManager.TAG, "Start " + logPrefix + "Cache");
                        byte[] loadRspCache = QzoneProtocolCacheManager.INSTANCE.loadRspCache(cacheKey);
                        if (loadRspCache != null) {
                            Function1<byte[], T> function1 = decodeFunc;
                            final Function1<T, Unit> function12 = callback;
                            kLog.d(QzoneFeedListCacheManager.TAG, "Successfully obtained cache data, start decoding");
                            final Object invoke = function1.invoke(loadRspCache);
                            QzoneBaseServiceKt.runOnUIThread(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFeedListCacheManager$loadCache$2$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    Function1<T, Unit> function13;
                                    T t16 = invoke;
                                    if (t16 == 0 || (function13 = function12) == 0) {
                                        return;
                                    }
                                    function13.invoke(t16);
                                }
                            });
                            kLog.d(QzoneFeedListCacheManager.TAG, "Cache data processing completed");
                            unit = Unit.INSTANCE;
                        } else {
                            unit = null;
                        }
                        if (unit == null) {
                            QzoneFeedListCacheManager qzoneFeedListCacheManager = QzoneFeedListCacheManager.INSTANCE;
                            kLog.d(QzoneFeedListCacheManager.TAG, "No cache data obtained");
                        }
                    } catch (Exception e16) {
                        KLog kLog2 = KLog.INSTANCE;
                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("Error occurred while loading cache data: ");
                        m3.append(e16.getMessage());
                        kLog2.e(QzoneFeedListCacheManager.TAG, m3.toString());
                    }
                }
            });
        }
    }
}
