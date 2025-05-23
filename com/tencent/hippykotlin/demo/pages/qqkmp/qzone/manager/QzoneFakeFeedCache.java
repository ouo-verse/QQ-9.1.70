package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager;

import c45.i;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.foundation.module.CacheDiskLru$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NearbyMiddlePosterData$Companion$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsViewModel$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellCommon;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeedKt;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeedList;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeedListKt;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFakeFeedCache;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.local.StFeedList;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedExtKt;
import com.tencent.hippykotlin.demo.pages.qzone.module.QZoneComposePlatformModule;
import com.tencent.kuikly.core.kmp.a;
import com.tencent.kuikly.core.kmp.d;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 32\u00020\u0001:\u000234B\u000f\u0012\u0006\u0010)\u001a\u00020\u000b\u00a2\u0006\u0004\b1\u00102J\u0016\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0016\u0010\u0010\u001a\u00020\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0003H\u0002J\b\u0010\u0012\u001a\u00020\u0003H\u0002J\u001a\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002J\u001a\u0010\u0017\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u000bH\u0002J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\b\u0010!\u001a\u00020\u000bH\u0002J\u000e\u0010\"\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010#\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bJ\u0014\u0010$\u001a\u00020\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000eJ\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\b0\u000eJ\u0006\u0010&\u001a\u00020\u0003J\u0018\u0010'\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014J\u0018\u0010(\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014R\u0017\u0010)\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020\b0-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R \u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u0010/\u00a8\u00065"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/QzoneFakeFeedCache;", "", "Lkotlin/Function0;", "", "task", "postTask", "processNextTask", "checkUinAfterTask", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "commonFeed", "performAddFakeFeed", "", "clientKey", "performDeleteFakeFeed", "", "clientKeys", "performBatchDelete", "saveDbFakeFeedList", "performRestoreDbFakeFeedList", "feed", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/QzoneFakeFeedCache$OnOperateResultCallback;", "callback", "performSaveDbSingleFakeFeed", "performRestoreDbSingleFakeFeed", "cacheKey", "deleteDbSingleFakeFeed", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/local/StFeedList;", "stFeedList", "setFakeFeedCacheList", "", "invalidTime", "", "isInvalidTime", "printFakeFeedIdList", "addFakeFeedCache", "deleteFakeFeedCache", "batchDeleteFakeFeedCache", "getCacheFakeFeedList", "restoreDbFakeFeedList", "saveDbSingleFakeFeed", "restoreDbSingleFakeFeed", "uin", "Ljava/lang/String;", "getUin", "()Ljava/lang/String;", "Lcom/tencent/kuikly/core/kmp/d;", "fakeFeedCacheList", "Lcom/tencent/kuikly/core/kmp/d;", "taskQueue", "<init>", "(Ljava/lang/String;)V", "Companion", "OnOperateResultCallback", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QzoneFakeFeedCache {
    private static final long INVALID_TIME_FAKE_FEED_NORMAL = 2100;
    private static final String KEY_QZONE_PRO_FAKE_FEED_LIST_DB_CACHE = "key_qzone_pro_fake_feed_list_db_cache_";
    private static final String KEY_QZONE_PRO_SINGLE_FAKE_FEED_DB_CACHE = "key_qzone_pro_single_fake_feed_db_cache_";
    private static final String TAG = "QzoneFakeFeedCache";
    private final d<CommonFeed> fakeFeedCacheList = new d<>();
    private final d<Function0<Unit>> taskQueue = new d<>();
    private final String uin;
    public static final int $stable = 8;

    public QzoneFakeFeedCache(String str) {
        this.uin = str;
    }

    private final void checkUinAfterTask() {
        String uin = QZoneComposePlatformModule.Companion.getUin();
        if (Intrinsics.areEqual(this.uin, uin)) {
            return;
        }
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("checkUinAfterTask uin changed! clean cache. old:");
        m3.append(this.uin);
        m3.append(", new:");
        m3.append(uin);
        kLog.e(TAG, m3.toString());
        this.fakeFeedCacheList.clear();
    }

    private final void deleteDbSingleFakeFeed(String cacheKey) {
        ((e) c.f117352a.g().acquireModule("KRDiskCacheModule")).d(cacheKey);
        KLog.INSTANCE.d(TAG, "deleteDbSingleFakeFeed cacheKey=" + cacheKey);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void performAddFakeFeed(CommonFeed commonFeed) {
        this.fakeFeedCacheList.add(0, commonFeed);
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("performAddFakeFeed clientKey: ");
        CommonCellCommon cellCommon = commonFeed.getCellCommon();
        m3.append(cellCommon != null ? cellCommon.getClientKey() : null);
        m3.append(" | size=");
        m3.append(this.fakeFeedCacheList.size());
        m3.append(" | feedIdList=");
        AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(m3, printFakeFeedIdList(), kLog, TAG);
        saveDbFakeFeedList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void performBatchDelete(List<String> clientKeys) {
        String joinToString$default;
        boolean contains;
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        for (CommonFeed commonFeed : this.fakeFeedCacheList) {
            CommonCellCommon cellCommon = commonFeed.getCellCommon();
            contains = CollectionsKt___CollectionsKt.contains(clientKeys, cellCommon != null ? cellCommon.getClientKey() : null);
            if (contains) {
                arrayList.add(commonFeed);
                i3++;
            }
        }
        this.fakeFeedCacheList.removeAll(arrayList);
        if (i3 > 0) {
            KLog kLog = KLog.INSTANCE;
            StringBuilder m3 = NearbyMiddlePosterData$Companion$$ExternalSyntheticOutline0.m("performBatchDelete deleted ", i3, " items  | keys=");
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(clientKeys, null, null, null, 0, null, null, 63, null);
            m3.append(joinToString$default);
            m3.append(" | size=");
            m3.append(this.fakeFeedCacheList.size());
            m3.append(" | feedIdList=");
            AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(m3, printFakeFeedIdList(), kLog, TAG);
            saveDbFakeFeedList();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void performDeleteFakeFeed(String clientKey) {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(clientKey);
        performBatchDelete(listOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void performRestoreDbFakeFeedList() {
        KLog kLog = KLog.INSTANCE;
        NBPFeedCommentsViewModel$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("performRestoreDbFakeFeedList  restore... , uin="), this.uin, kLog, TAG);
        e eVar = (e) c.f117352a.g().acquireModule("KRDiskCacheModule");
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m(KEY_QZONE_PRO_FAKE_FEED_LIST_DB_CACHE);
        m3.append(this.uin);
        byte[] a16 = eVar.a(m3.toString());
        int i3 = 1;
        if (a16.length == 0) {
            kLog.d(TAG, "performRestoreDbFakeFeedList cacheByteArrayData == null");
            return;
        }
        StFeedList stFeedList = null;
        try {
            stFeedList = (StFeedList) i.b(new StFeedList(0 == true ? 1 : 0, i3, 0 == true ? 1 : 0), a16);
        } catch (Exception e16) {
            KLog.INSTANCE.e(TAG, "performRestoreDbFakeFeedList e: " + e16);
        }
        if (stFeedList == null) {
            return;
        }
        KLog kLog2 = KLog.INSTANCE;
        StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("performRestoreDbFakeFeedList stFeedList.size=");
        m16.append(stFeedList.feedItems.size());
        kLog2.d(TAG, m16.toString());
        setFakeFeedCacheList(stFeedList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void performSaveDbSingleFakeFeed(CommonFeed feed, final OnOperateResultCallback callback) {
        byte[] d16;
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("performSaveDbSingleFakeFeed  save... , feedId=");
        CommonCellCommon cellCommon = feed.getCellCommon();
        m3.append(cellCommon != null ? cellCommon.getClientKey() : null);
        m3.append(", uin=");
        m3.append(this.uin);
        kLog.d(TAG, m3.toString());
        try {
            StFeed pbFeed = CommonFeedKt.toPbFeed(feed);
            if (pbFeed != null && (d16 = i.d(pbFeed)) != null) {
                e eVar = (e) c.f117352a.g().acquireModule("KRDiskCacheModule");
                StringBuilder sb5 = new StringBuilder();
                sb5.append(KEY_QZONE_PRO_SINGLE_FAKE_FEED_DB_CACHE);
                sb5.append(this.uin);
                sb5.append(util.base64_pad_url);
                CommonCellCommon cellCommon2 = feed.getCellCommon();
                sb5.append(cellCommon2 != null ? cellCommon2.getClientKey() : null);
                eVar.e(sb5.toString(), d16);
            }
            a.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFakeFeedCache$performSaveDbSingleFakeFeed$2
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
                    QzoneFakeFeedCache.OnOperateResultCallback onOperateResultCallback = QzoneFakeFeedCache.OnOperateResultCallback.this;
                    if (onOperateResultCallback != null) {
                        QzoneFakeFeedCache.OnOperateResultCallback.DefaultImpls.onResult$default(onOperateResultCallback, true, null, 2, null);
                    }
                }
            });
        } catch (Exception e16) {
            KLog.INSTANCE.e(TAG, "performSaveDbSingleFakeFeed e=" + e16);
            a.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFakeFeedCache$performSaveDbSingleFakeFeed$3
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
                    QzoneFakeFeedCache.OnOperateResultCallback onOperateResultCallback = QzoneFakeFeedCache.OnOperateResultCallback.this;
                    if (onOperateResultCallback != null) {
                        QzoneFakeFeedCache.OnOperateResultCallback.DefaultImpls.onResult$default(onOperateResultCallback, false, null, 2, null);
                    }
                }
            });
        }
    }

    private final void postTask(Function0<Unit> task) {
        this.taskQueue.add(task);
        a.a(new QzoneFakeFeedCache$postTask$1(this));
    }

    private final String printFakeFeedIdList() {
        StringBuilder sb5 = new StringBuilder();
        Iterator<CommonFeed> it = this.fakeFeedCacheList.iterator();
        while (it.hasNext()) {
            sb5.append(CommonFeedExtKt.getFeedUniqueKey(it.next()));
            if (it.hasNext()) {
                sb5.append("\u3001");
            }
        }
        return sb5.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void processNextTask() {
        try {
        } catch (Exception e16) {
            KLog.INSTANCE.e(TAG, "processNextTask, e:" + e16);
        }
        if (this.taskQueue.size() == 0) {
            checkUinAfterTask();
        } else {
            this.taskQueue.remove(0).invoke();
            a.a(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFakeFeedCache$processNextTask$1
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
                    QzoneFakeFeedCache.this.processNextTask();
                }
            });
        }
    }

    private final void saveDbFakeFeedList() {
        List<CommonFeed> mutableList;
        byte[] d16;
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("saveDbFakeFeedList  save... , uin=");
        m3.append(this.uin);
        m3.append(", size=");
        m3.append(this.fakeFeedCacheList.size());
        kLog.d(TAG, m3.toString());
        CommonFeedList commonFeedList = new CommonFeedList();
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) getCacheFakeFeedList());
        commonFeedList.setFeedItems(mutableList);
        StFeedList pb5 = CommonFeedListKt.toPb(commonFeedList);
        if (pb5 == null || (d16 = i.d(pb5)) == null) {
            return;
        }
        e eVar = (e) c.f117352a.g().acquireModule("KRDiskCacheModule");
        StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m(KEY_QZONE_PRO_FAKE_FEED_LIST_DB_CACHE);
        m16.append(this.uin);
        eVar.e(m16.toString(), d16);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0014, code lost:
    
        if ((!r6.isEmpty()) == true) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void setFakeFeedCacheList(StFeedList stFeedList) {
        CommonFeedList common2 = CommonFeedListKt.toCommon(stFeedList);
        List<CommonFeed> feedItems = common2 != null ? common2.getFeedItems() : null;
        boolean z16 = feedItems != null;
        if (z16) {
            Iterator<CommonFeed> it = feedItems.iterator();
            while (it.hasNext()) {
                if (isInvalidTime(it.next(), INVALID_TIME_FAKE_FEED_NORMAL)) {
                    it.remove();
                    KLog.INSTANCE.d(TAG, "setFakeFeedCacheList, remove invalid fake feed");
                }
            }
            this.fakeFeedCacheList.clear();
            this.fakeFeedCacheList.addAll(feedItems);
            KLog kLog = KLog.INSTANCE;
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("setFakeFeedCacheList size=");
            m3.append(this.fakeFeedCacheList.size());
            m3.append(" | feedIdList=");
            AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(m3, printFakeFeedIdList(), kLog, TAG);
            saveDbFakeFeedList();
        }
    }

    public final void addFakeFeedCache(final CommonFeed commonFeed) {
        postTask(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFakeFeedCache$addFakeFeedCache$1
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
                QzoneFakeFeedCache.this.performAddFakeFeed(commonFeed);
            }
        });
    }

    public final void batchDeleteFakeFeedCache(final List<String> clientKeys) {
        postTask(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFakeFeedCache$batchDeleteFakeFeedCache$1
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
                QzoneFakeFeedCache.this.performBatchDelete(clientKeys);
            }
        });
    }

    public final void deleteFakeFeedCache(final String clientKey) {
        postTask(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFakeFeedCache$deleteFakeFeedCache$1
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
                QzoneFakeFeedCache.this.performDeleteFakeFeed(clientKey);
            }
        });
    }

    public final List<CommonFeed> getCacheFakeFeedList() {
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("getCacheFakeFeedList size=");
        m3.append(this.fakeFeedCacheList.size());
        m3.append(" | feedIdList=");
        AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(m3, printFakeFeedIdList(), kLog, TAG);
        if (this.fakeFeedCacheList.size() > 0) {
            d<CommonFeed> dVar = this.fakeFeedCacheList;
            return dVar.subList(0, dVar.size());
        }
        return new ArrayList();
    }

    public final String getUin() {
        return this.uin;
    }

    public final void restoreDbFakeFeedList() {
        postTask(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFakeFeedCache$restoreDbFakeFeedList$1
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
                QzoneFakeFeedCache.this.performRestoreDbFakeFeedList();
            }
        });
    }

    public final void restoreDbSingleFakeFeed(final String clientKey, final OnOperateResultCallback callback) {
        postTask(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFakeFeedCache$restoreDbSingleFakeFeed$1
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
                QzoneFakeFeedCache.this.performRestoreDbSingleFakeFeed(clientKey, callback);
            }
        });
    }

    public final void saveDbSingleFakeFeed(final CommonFeed feed, final OnOperateResultCallback callback) {
        postTask(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFakeFeedCache$saveDbSingleFakeFeed$1
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
                QzoneFakeFeedCache.this.performSaveDbSingleFakeFeed(feed, callback);
            }
        });
    }

    private final boolean isInvalidTime(CommonFeed feed, long invalidTime) {
        CommonCellCommon cellCommon;
        if (feed != null && (cellCommon = feed.getCellCommon()) != null) {
            cellCommon.getTime();
            long a16 = zz0.a.f453719a.a() / 1000;
            CommonCellCommon cellCommon2 = feed.getCellCommon();
            Intrinsics.checkNotNull(cellCommon2);
            r0 = a16 - cellCommon2.getTime() > invalidTime;
            if (r0) {
                KLog kLog = KLog.INSTANCE;
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("isInvalidTime | feedKey=");
                m3.append(CommonFeedExtKt.getFeedUniqueKey(feed));
                m3.append(" | currentTimestamp=");
                m3.append(a16);
                m3.append(" | feedTime=");
                CommonCellCommon cellCommon3 = feed.getCellCommon();
                Intrinsics.checkNotNull(cellCommon3);
                m3.append(cellCommon3.getTime());
                kLog.d(TAG, m3.toString());
            }
        }
        return r0;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0001H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/QzoneFakeFeedCache$OnOperateResultCallback;", "", "onResult", "", "isSuccess", "", "resultData", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes37.dex */
    public interface OnOperateResultCallback {
        void onResult(boolean isSuccess, Object resultData);

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes37.dex */
        public static final class DefaultImpls {
            public static /* synthetic */ void onResult$default(OnOperateResultCallback onOperateResultCallback, boolean z16, Object obj, int i3, Object obj2) {
                if (obj2 == null) {
                    if ((i3 & 2) != 0) {
                        obj = null;
                    }
                    onOperateResultCallback.onResult(z16, obj);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onResult");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void performRestoreDbSingleFakeFeed(String clientKey, final OnOperateResultCallback callback) {
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = CacheDiskLru$$ExternalSyntheticOutline0.m("performRestoreDbSingleFakeFeed  restore...  clientKey=", clientKey, ", uin=");
        m3.append(this.uin);
        kLog.d(TAG, m3.toString());
        String str = KEY_QZONE_PRO_SINGLE_FAKE_FEED_DB_CACHE + this.uin + util.base64_pad_url + clientKey;
        byte[] a16 = ((e) c.f117352a.g().acquireModule("KRDiskCacheModule")).a(str);
        if (a16.length == 0) {
            kLog.e(TAG, "performRestoreDbSingleFakeFeed cacheByteArrayData == null");
            a.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFakeFeedCache$performRestoreDbSingleFakeFeed$1
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
                    QzoneFakeFeedCache.OnOperateResultCallback onOperateResultCallback = QzoneFakeFeedCache.OnOperateResultCallback.this;
                    if (onOperateResultCallback != null) {
                        QzoneFakeFeedCache.OnOperateResultCallback.DefaultImpls.onResult$default(onOperateResultCallback, false, null, 2, null);
                    }
                }
            });
            return;
        }
        try {
            final CommonFeed commonFeed = CommonFeedKt.toCommonFeed((StFeed) i.b(new StFeed(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Integer.MAX_VALUE, null), a16));
            NBPFeedCommentsViewModel$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("performRestoreDbSingleFakeFeed feedId="), commonFeed != null ? CommonFeedExtKt.getFeedUniqueKey(commonFeed) : null, kLog, TAG);
            deleteDbSingleFakeFeed(str);
            a.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFakeFeedCache$performRestoreDbSingleFakeFeed$2
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
                    QzoneFakeFeedCache.OnOperateResultCallback onOperateResultCallback = QzoneFakeFeedCache.OnOperateResultCallback.this;
                    if (onOperateResultCallback != null) {
                        onOperateResultCallback.onResult(true, commonFeed);
                    }
                }
            });
        } catch (Exception e16) {
            KLog.INSTANCE.e(TAG, "performRestoreDbSingleFakeFeed e: " + e16);
            a.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFakeFeedCache$performRestoreDbSingleFakeFeed$feed$1
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
                    QzoneFakeFeedCache.OnOperateResultCallback onOperateResultCallback = QzoneFakeFeedCache.OnOperateResultCallback.this;
                    if (onOperateResultCallback != null) {
                        QzoneFakeFeedCache.OnOperateResultCallback.DefaultImpls.onResult$default(onOperateResultCallback, false, null, 2, null);
                    }
                }
            });
        }
    }
}
