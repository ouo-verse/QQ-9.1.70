package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager;

import com.tencent.hippykotlin.demo.pages.foundation.module.CacheDiskLru$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qqkmp.base.cache.LruCache;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellCommon;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUnionID;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event.IEventObserver;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event.QzoneBaseEvent;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event.QzoneEventBus;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event.QzoneOperateEvent;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.fake.QzoneFakeOperateHelper;
import com.tencent.kuikly.core.log.KLog;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import zz0.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\rJ\u001a\u0010\u000e\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u000bJ\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0016\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R&\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t0\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/QzoneDetailCacheManager;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/event/IEventObserver;", "()V", "MAX_SIZE", "", "TAG", "", "feedCache", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/base/cache/LruCache;", "Lkotlin/Pair;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "", QCircleLpReportDc05507.KEY_CLEAR, "", "getFeedData", "key", "expireThreshold", "onEvent", "event", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/event/QzoneBaseEvent;", "saveFeedDetailData", "cacheKey", "feedData", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QzoneDetailCacheManager implements IEventObserver {
    public static final int $stable;
    public static final QzoneDetailCacheManager INSTANCE;
    private static final int MAX_SIZE = 20;
    public static final String TAG = "QZoneFeedDetailCacheManager";
    private static LruCache<String, Pair<CommonFeed, Long>> feedCache;

    static {
        QzoneDetailCacheManager qzoneDetailCacheManager = new QzoneDetailCacheManager();
        INSTANCE = qzoneDetailCacheManager;
        feedCache = new LruCache<>(20, null, 2, null);
        QzoneEventBus.INSTANCE.register(qzoneDetailCacheManager);
        $stable = 8;
    }

    QzoneDetailCacheManager() {
    }

    public final void clear() {
        QzoneEventBus.INSTANCE.unregister(this);
        feedCache.clear();
    }

    public final CommonFeed getFeedData(String key, long expireThreshold) {
        Pair<CommonFeed, Long> pair = feedCache.get(key);
        if (pair == null) {
            return null;
        }
        CommonFeed component1 = pair.component1();
        long longValue = pair.component2().longValue();
        if (expireThreshold < 0) {
            KLog kLog = KLog.INSTANCE;
            StringBuilder m3 = CacheDiskLru$$ExternalSyntheticOutline0.m("getFeedData: ", key, ", feed: ");
            m3.append(component1.hashCode());
            kLog.d(TAG, m3.toString());
            return component1;
        }
        if (a.f453719a.a() - longValue > expireThreshold) {
            feedCache.remove(key);
            return null;
        }
        KLog kLog2 = KLog.INSTANCE;
        StringBuilder m16 = CacheDiskLru$$ExternalSyntheticOutline0.m("getFeedData: ", key, ", feed: ");
        m16.append(component1.hashCode());
        kLog2.d(TAG, m16.toString());
        return component1;
    }

    @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event.IEventObserver
    public void onEvent(QzoneBaseEvent event) {
        Object obj;
        List<CommonFeed> mutableListOf;
        CommonUnionID unionId;
        KLog.INSTANCE.d(QzoneFeedDetailManager.TAG, "onEvent: " + event);
        if (event instanceof QzoneOperateEvent) {
            Iterator<T> it = feedCache.getCache().values().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                CommonCellCommon cellCommon = ((CommonFeed) ((Pair) obj).getFirst()).getCellCommon();
                if (Intrinsics.areEqual((cellCommon == null || (unionId = cellCommon.getUnionId()) == null) ? null : unionId.getUfKey(), ((QzoneOperateEvent) event).getUnionID().getUfKey())) {
                    break;
                }
            }
            Pair pair = (Pair) obj;
            CommonFeed commonFeed = pair != null ? (CommonFeed) pair.getFirst() : null;
            if (commonFeed != null) {
                mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(commonFeed);
                QzoneFakeOperateHelper.INSTANCE.onOperateEvent$qecommerce_biz_release((QzoneOperateEvent) event, mutableListOf, new Function1<CommonFeed, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneDetailCacheManager$onEvent$1
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(CommonFeed commonFeed2) {
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(CommonFeed commonFeed2) {
                        invoke2(commonFeed2);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                KLog.INSTANCE.d(TAG, "receive event but no feed match");
            }
        }
    }

    public final void saveFeedDetailData(String cacheKey, CommonFeed feedData) {
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = CacheDiskLru$$ExternalSyntheticOutline0.m("saveFeedDetailData: ", cacheKey, ", feedData: ");
        m3.append(feedData.hashCode());
        kLog.d(TAG, m3.toString());
        feedCache.put(cacheKey, new Pair<>(feedData, Long.valueOf(a.f453719a.a())));
    }

    public static /* synthetic */ CommonFeed getFeedData$default(QzoneDetailCacheManager qzoneDetailCacheManager, String str, long j3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            j3 = -1;
        }
        return qzoneDetailCacheManager.getFeedData(str, j3);
    }
}
