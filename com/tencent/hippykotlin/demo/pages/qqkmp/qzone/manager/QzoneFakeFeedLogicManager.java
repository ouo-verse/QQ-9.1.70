package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.QUISkinImage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.module.CacheDiskLru$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.bean.QzoneCommonFakeFeedBean;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellCommon;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeedKt;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event.QzoneDeleteEvent;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event.QzoneEventBus;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event.QzoneInsertFakeEvent;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event.QzoneUpdateListFeedEvent;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFakeFeedCache;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFakeFeedLogicManager;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.ClientFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.GetUpdateFeedRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service.QzoneFeedUpdateService;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedExtKt;
import com.tencent.hippykotlin.demo.pages.qzone.module.QZoneComposePlatformModule;
import com.tencent.kuikly.core.kmp.e;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.timer.TimerKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c7\u0002\u0018\u00002\u00020\u0001:\u0001$B\t\b\u0002\u00a2\u0006\u0004\b\"\u0010#J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J.\u0010\u000f\u001a\u00020\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J*\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\u0010\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\bJ\u001a\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fJ\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0014J\u0006\u0010\u0017\u001a\u00020\u000eJ\u001c\u0010\u0019\u001a\u00020\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0018J\u001c\u0010\u001a\u001a\u00020\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0018J\u0010\u0010\u001c\u001a\u00020\u000e2\b\u0010\u001b\u001a\u0004\u0018\u00010\bR\u0014\u0010\u001d\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR \u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/QzoneFakeFeedLogicManager;", "", "", "uin", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/QzoneFakeFeedCache;", "getFakeFeedCache", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/bean/QzoneCommonFakeFeedBean;", "fakeFeedBean", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "transferCommonFeed", "clientKey", "pollAttachInfo", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/QzoneFakeFeedLogicManager$OnFetchFeedCompleteCallback;", "callback", "", "pollingFetchRealFeed", "feed", "handleFetchRealFeedSuccess", "insertFakeFeed", "fetchRealFeed", "", "rspFeedList", "getCacheFakeFeedList", "restoreDbFakeFeedList", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/QzoneFakeFeedCache$OnOperateResultCallback;", "saveDbSingleFakeFeed", "restoreDbSingleFakeFeed", "commonFeed", "deleteFakeFeed", "TAG", "Ljava/lang/String;", "Lcom/tencent/kuikly/core/kmp/e;", "fakeFeedCacheMap", "Lcom/tencent/kuikly/core/kmp/e;", "<init>", "()V", "OnFetchFeedCompleteCallback", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QzoneFakeFeedLogicManager {
    private static final String TAG = "QzoneFakeFeedLogicManager";
    public static final QzoneFakeFeedLogicManager INSTANCE = new QzoneFakeFeedLogicManager();
    private static final e<String, QzoneFakeFeedCache> fakeFeedCacheMap = new e<>();
    public static final int $stable = 8;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/QzoneFakeFeedLogicManager$OnFetchFeedCompleteCallback;", "", "onComplete", "", "isSuccess", "", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes37.dex */
    public interface OnFetchFeedCompleteCallback {
        void onComplete(boolean isSuccess);
    }

    QzoneFakeFeedLogicManager() {
    }

    private final QzoneFakeFeedCache getFakeFeedCache(String uin) {
        e<String, QzoneFakeFeedCache> eVar = fakeFeedCacheMap;
        QzoneFakeFeedCache qzoneFakeFeedCache = eVar.get(uin);
        if (qzoneFakeFeedCache != null) {
            return qzoneFakeFeedCache;
        }
        QzoneFakeFeedCache qzoneFakeFeedCache2 = new QzoneFakeFeedCache(uin);
        eVar.g(uin, qzoneFakeFeedCache2);
        return qzoneFakeFeedCache2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleFetchRealFeedSuccess(String clientKey, CommonFeed feed, String uin, OnFetchFeedCompleteCallback callback) {
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = CacheDiskLru$$ExternalSyntheticOutline0.m("handleFetchRealFeedSuccess | clientKey: ", clientKey, " | feed=");
        m3.append(CommonFeedExtKt.getFeedUniqueKey(feed));
        m3.append(" | uin=");
        m3.append(uin);
        kLog.i(TAG, m3.toString());
        QZoneComposePlatformModule.Companion companion = QZoneComposePlatformModule.Companion;
        if (!Intrinsics.areEqual(companion.getUin(), uin)) {
            StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("handleFetchRealFeedSuccess uin has change, loginUin=");
            m16.append(companion.getUin());
            kLog.e(TAG, m16.toString());
        } else {
            getFakeFeedCache(uin).deleteFakeFeedCache(clientKey);
            QzoneEventBus.INSTANCE.postEvent(new QzoneUpdateListFeedEvent(clientKey, feed));
            if (callback != null) {
                callback.onComplete(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void pollingFetchRealFeed(final String clientKey, String pollAttachInfo, final String uin, final OnFetchFeedCompleteCallback callback) {
        KLog.INSTANCE.i(TAG, QUISkinImage$$ExternalSyntheticOutline0.m("pollingFetchRealFeed clientKey:", clientKey, ", pollAttachInfo:", pollAttachInfo));
        QzoneFeedUpdateService qzoneFeedUpdateService = new QzoneFeedUpdateService();
        String str = clientKey == null ? "" : clientKey;
        if (pollAttachInfo == null) {
            pollAttachInfo = "";
        }
        qzoneFeedUpdateService.fetchRealFeed$qecommerce_biz_release(str, pollAttachInfo, new DataCallback<GetUpdateFeedRsp>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFakeFeedLogicManager$pollingFetchRealFeed$1
            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onFailure(long errorCode, String errorMsg) {
                KLog.INSTANCE.e("QzoneFakeFeedLogicManager", "onFailure errorCode=" + errorCode + ", errorMsg=" + errorMsg + ", clientKey: " + clientKey);
                QzoneFakeFeedLogicManager.OnFetchFeedCompleteCallback onFetchFeedCompleteCallback = callback;
                if (onFetchFeedCompleteCallback != null) {
                    onFetchFeedCompleteCallback.onComplete(false);
                }
            }

            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onSuccess(final GetUpdateFeedRsp t16, long retCode, String msg2, boolean isFinish) {
                ClientFeed clientFeed = t16.feed;
                CommonFeed commonFeed = CommonFeedKt.toCommonFeed(clientFeed != null ? clientFeed.feed : null);
                KLog kLog = KLog.INSTANCE;
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("pollingFetchRealFeed onSuccess | clientKey: ");
                m3.append(clientKey);
                m3.append(" | retryTimeInterval:");
                m3.append(t16.retryTimeInterval);
                m3.append(" | attachInfo:");
                m3.append(t16.attachInfo);
                m3.append(" | feed:");
                m3.append(commonFeed);
                m3.append(" | uin:");
                AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(m3, uin, kLog, "QzoneFakeFeedLogicManager");
                int i3 = t16.retryTimeInterval;
                if (i3 > 0) {
                    final String str2 = uin;
                    final String str3 = clientKey;
                    final QzoneFakeFeedLogicManager.OnFetchFeedCompleteCallback onFetchFeedCompleteCallback = callback;
                    TimerKt.c(i3 * 1000, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFakeFeedLogicManager$pollingFetchRealFeed$1$onSuccess$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            QZoneComposePlatformModule.Companion companion = QZoneComposePlatformModule.Companion;
                            if (Intrinsics.areEqual(companion.getUin(), str2)) {
                                QzoneFakeFeedLogicManager.INSTANCE.pollingFetchRealFeed(str3, t16.attachInfo, str2, onFetchFeedCompleteCallback);
                                return;
                            }
                            KLog kLog2 = KLog.INSTANCE;
                            StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("pollingFetchRealFeed uin has change, loginUin=");
                            m16.append(companion.getUin());
                            kLog2.e("QzoneFakeFeedLogicManager", m16.toString());
                        }
                    });
                    return;
                }
                if (commonFeed == null) {
                    kLog.e("QzoneFakeFeedLogicManager", "pollingFetchRealFeed onSuccess error, feed == null");
                    return;
                }
                QzoneFakeFeedLogicManager qzoneFakeFeedLogicManager = QzoneFakeFeedLogicManager.INSTANCE;
                String str4 = clientKey;
                if (str4 == null) {
                    str4 = "";
                }
                qzoneFakeFeedLogicManager.handleFetchRealFeedSuccess(str4, commonFeed, uin, callback);
            }
        });
    }

    public final void deleteFakeFeed(CommonFeed commonFeed) {
        AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("deleteFakeFeed clientKey: "), commonFeed != null ? CommonFeedExtKt.getFeedUniqueKey(commonFeed) : null, KLog.INSTANCE, TAG);
        if (commonFeed == null || CommonFeedExtKt.getFeedUniqueKey(commonFeed) == null) {
            return;
        }
        getFakeFeedCache(QZoneComposePlatformModule.Companion.getUin()).deleteFakeFeedCache(CommonFeedExtKt.getFeedUniqueKey(commonFeed));
        QzoneEventBus.INSTANCE.postEvent(new QzoneDeleteEvent(commonFeed));
    }

    public final void fetchRealFeed(String clientKey, OnFetchFeedCompleteCallback callback) {
        DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0.m("fetchRealFeed clientKey: ", clientKey, KLog.INSTANCE, TAG);
        pollingFetchRealFeed(clientKey, "", QZoneComposePlatformModule.Companion.getUin(), callback);
    }

    public final List<CommonFeed> getCacheFakeFeedList(List<CommonFeed> rspFeedList) {
        Set set;
        try {
            List<CommonFeed> cacheFakeFeedList = getFakeFeedCache(QZoneComposePlatformModule.Companion.getUin()).getCacheFakeFeedList();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it = rspFeedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                CommonCellCommon cellCommon = ((CommonFeed) it.next()).getCellCommon();
                String clientKey = cellCommon != null ? cellCommon.getClientKey() : null;
                if (clientKey != null) {
                    arrayList2.add(clientKey);
                }
            }
            set = CollectionsKt___CollectionsKt.toSet(arrayList2);
            ArrayList arrayList3 = new ArrayList();
            for (CommonFeed commonFeed : cacheFakeFeedList) {
                CommonCellCommon cellCommon2 = commonFeed.getCellCommon();
                String clientKey2 = cellCommon2 != null ? cellCommon2.getClientKey() : null;
                if (clientKey2 != null && set.contains(clientKey2)) {
                    arrayList3.add(clientKey2);
                    KLog.INSTANCE.d(TAG, "getCacheFakeFeedList, mark delete fakeFeed with clientKey: " + clientKey2);
                } else {
                    arrayList.add(commonFeed);
                    KLog.INSTANCE.d(TAG, "getCacheFakeFeedList, page refresh, add fakeFeed clientKey: " + clientKey2);
                }
            }
            if (!arrayList3.isEmpty()) {
                getFakeFeedCache(QZoneComposePlatformModule.Companion.getUin()).batchDeleteFakeFeedCache(arrayList3);
            }
            return arrayList;
        } catch (Exception e16) {
            KLog.INSTANCE.e(TAG, "getCacheFakeFeedList, e:" + e16);
            return new ArrayList();
        }
    }

    public final void insertFakeFeed(QzoneCommonFakeFeedBean fakeFeedBean) {
        CommonCellCommon cellCommon;
        AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("insertFakeFeed bean, clientKey: "), (fakeFeedBean == null || (cellCommon = fakeFeedBean.getCellCommon()) == null) ? null : cellCommon.getClientKey(), KLog.INSTANCE, TAG);
        CommonFeed transferCommonFeed = transferCommonFeed(fakeFeedBean);
        if (transferCommonFeed == null) {
            return;
        }
        QzoneEventBus.INSTANCE.postEvent(new QzoneInsertFakeEvent(transferCommonFeed));
        getFakeFeedCache(QZoneComposePlatformModule.Companion.getUin()).addFakeFeedCache(transferCommonFeed);
    }

    public final void restoreDbFakeFeedList() {
        getFakeFeedCache(QZoneComposePlatformModule.Companion.getUin()).restoreDbFakeFeedList();
    }

    public final void restoreDbSingleFakeFeed(String clientKey, QzoneFakeFeedCache.OnOperateResultCallback callback) {
        DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0.m("restoreDbSingleFakeFeed | clientKey=", clientKey, KLog.INSTANCE, TAG);
        QzoneFakeFeedCache fakeFeedCache = getFakeFeedCache(QZoneComposePlatformModule.Companion.getUin());
        if (clientKey == null) {
            clientKey = "";
        }
        fakeFeedCache.restoreDbSingleFakeFeed(clientKey, callback);
    }

    public final void saveDbSingleFakeFeed(QzoneCommonFakeFeedBean fakeFeedBean, QzoneFakeFeedCache.OnOperateResultCallback callback) {
        CommonCellCommon cellCommon;
        AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("saveDbSingleFakeFeed clientKey: "), (fakeFeedBean == null || (cellCommon = fakeFeedBean.getCellCommon()) == null) ? null : cellCommon.getClientKey(), KLog.INSTANCE, TAG);
        CommonFeed transferCommonFeed = transferCommonFeed(fakeFeedBean);
        if (transferCommonFeed == null) {
            return;
        }
        getFakeFeedCache(QZoneComposePlatformModule.Companion.getUin()).saveDbSingleFakeFeed(transferCommonFeed, callback);
    }

    private final CommonFeed transferCommonFeed(QzoneCommonFakeFeedBean fakeFeedBean) {
        if (fakeFeedBean == null) {
            return null;
        }
        CommonFeed commonFeed = new CommonFeed();
        commonFeed.setCellCommon(fakeFeedBean.getCellCommon());
        commonFeed.setCellUserInfo(fakeFeedBean.getCellUserInfo());
        commonFeed.setCellLbs(fakeFeedBean.getCellLbs());
        commonFeed.setCellSummary(fakeFeedBean.getCellSummary());
        commonFeed.setCellRemark(fakeFeedBean.getCellRemark());
        commonFeed.setCellPermission(fakeFeedBean.getCellPermission());
        commonFeed.setCellMedia(fakeFeedBean.getCellMedia());
        commonFeed.setRptCellBigTail(fakeFeedBean.getRptCellBigTail());
        commonFeed.setCellLocalInfo(fakeFeedBean.getCellLocalInfo());
        return commonFeed;
    }

    public static /* synthetic */ void fetchRealFeed$default(QzoneFakeFeedLogicManager qzoneFakeFeedLogicManager, String str, OnFetchFeedCompleteCallback onFetchFeedCompleteCallback, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            onFetchFeedCompleteCallback = null;
        }
        qzoneFakeFeedLogicManager.fetchRealFeed(str, onFetchFeedCompleteCallback);
    }

    public static /* synthetic */ void restoreDbSingleFakeFeed$default(QzoneFakeFeedLogicManager qzoneFakeFeedLogicManager, String str, QzoneFakeFeedCache.OnOperateResultCallback onOperateResultCallback, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            onOperateResultCallback = null;
        }
        qzoneFakeFeedLogicManager.restoreDbSingleFakeFeed(str, onOperateResultCallback);
    }

    public static /* synthetic */ void saveDbSingleFakeFeed$default(QzoneFakeFeedLogicManager qzoneFakeFeedLogicManager, QzoneCommonFakeFeedBean qzoneCommonFakeFeedBean, QzoneFakeFeedCache.OnOperateResultCallback onOperateResultCallback, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            onOperateResultCallback = null;
        }
        qzoneFakeFeedLogicManager.saveDbSingleFakeFeed(qzoneCommonFakeFeedBean, onOperateResultCallback);
    }

    public final void insertFakeFeed(CommonFeed feed) {
        AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("insertFakeFeed feed, clientKey: "), feed != null ? CommonFeedExtKt.getFeedUniqueKey(feed) : null, KLog.INSTANCE, TAG);
        if (feed == null) {
            return;
        }
        QzoneEventBus.INSTANCE.postEvent(new QzoneInsertFakeEvent(feed));
        getFakeFeedCache(QZoneComposePlatformModule.Companion.getUin()).addFakeFeedCache(feed);
    }
}
