package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager;

import c45.a;
import com.qzone.module.feedcomponent.manage.FeedManager;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyAdModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView$contentComments$1$1$7$1$2$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsViewModel$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.consts.QzoneDataUpdateAction;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeedKt;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.IQzoneFeedUpdateCallback;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.ClientFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.GetFeedsRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.GetFriendFeedPageHeadRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service.QzoneFriendFeedService;
import com.tencent.kuikly.core.kmp.d;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.b;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b.\u0010/J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0006\u0010\f\u001a\u00020\u0006J\u001e\u0010\u0011\u001a\u00020\u00062\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0018\u00010\rJ\u001e\u0010\u0012\u001a\u00020\u00062\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0018\u00010\rJ\u0014\u0010\u0014\u001a\u00020\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00130\rJ\u0006\u0010\u0015\u001a\u00020\bJ\b\u0010\u0016\u001a\u00020\u0006H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016J\b\u0010\u0018\u001a\u00020\bH\u0016R\u0014\u0010\u0019\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\"\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001a\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010 \u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0016\u0010'\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\"\u0010)\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b)\u0010+\"\u0004\b,\u0010-\u00a8\u00060"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/QzoneFriendFeedManager;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/QzoneBaseFeedManager;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/GetFeedsRsp;", "rsp", "", "action", "", "handleRefreshRsp", "", "isFirstPageReq", "Lc45/a;", "getAdvReqByteArr", "loadCache", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "dataCallback", "refresh", FeedManager.LOAD_MORE, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/GetFriendFeedPageHeadRsp;", "fetchFriendFeedHead", "hasFeedMemoryCache", QCircleLpReportDc05507.KEY_CLEAR, "getLogTag", "enableInsertFakeFeed", "TAG", "Ljava/lang/String;", "attachInfo", "getAttachInfo", "()Ljava/lang/String;", "setAttachInfo", "(Ljava/lang/String;)V", "headInfoCache", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/GetFriendFeedPageHeadRsp;", "getHeadInfoCache", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/GetFriendFeedPageHeadRsp;", "setHeadInfoCache", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/GetFriendFeedPageHeadRsp;)V", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/service/QzoneFriendFeedService;", "feedService", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/service/QzoneFriendFeedService;", "isListFinish", "Z", "()Z", "setListFinish", "(Z)V", "<init>", "()V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QzoneFriendFeedManager extends QzoneBaseFeedManager {
    public static final String TAG = "QzoneFriendFeedManager";
    private static GetFriendFeedPageHeadRsp headInfoCache;
    private static boolean isListFinish;
    public static final QzoneFriendFeedManager INSTANCE = new QzoneFriendFeedManager();
    private static String attachInfo = "";
    private static QzoneFriendFeedService feedService = new QzoneFriendFeedService();
    public static final int $stable = 8;

    QzoneFriendFeedManager() {
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029 A[Catch: all -> 0x005e, TryCatch #1 {all -> 0x005e, blocks: (B:3:0x0005, B:6:0x0008, B:8:0x0010, B:10:0x0029, B:12:0x004a, B:14:0x0059, B:19:0x004d, B:21:0x0051, B:23:0x0056, B:28:0x0018, B:31:0x0023), top: B:2:0x0005, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final a getAdvReqByteArr(boolean isFirstPageReq) {
        QQKuiklyAdModule qQKuiklyAdModule;
        byte[] bArr;
        byte[] bArr2;
        b g16;
        a aVar = a.f30290b;
        try {
            QQKuiklyAdModule.Companion companion = QQKuiklyAdModule.Companion;
            try {
                g16 = c.f117352a.g();
            } catch (Exception e16) {
                KLog kLog = KLog.INSTANCE;
                String message = e16.getMessage();
                if (message == null) {
                    message = "";
                }
                kLog.e("QQKuiklyAdModule", message);
            }
            if (g16 != null) {
                qQKuiklyAdModule = (QQKuiklyAdModule) g16.acquireModule("QQKuiklyAdModule");
                if (qQKuiklyAdModule != null) {
                    return aVar;
                }
                Object syncToNativeMethod = qQKuiklyAdModule.syncToNativeMethod("getQZoneAdReqParam", new Object[]{new e().w("is_first_screen", isFirstPageReq).toString()}, (Function1<Object, Unit>) null);
                if (syncToNativeMethod == null) {
                    bArr2 = new byte[0];
                } else {
                    bArr = syncToNativeMethod instanceof byte[] ? (byte[]) syncToNativeMethod : null;
                    if (bArr == null) {
                        bArr2 = new byte[0];
                    }
                    return new a(bArr);
                }
                bArr = bArr2;
                return new a(bArr);
            }
            qQKuiklyAdModule = null;
            if (qQKuiklyAdModule != null) {
            }
        } catch (Throwable th5) {
            AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0.m("getAdvReqByteArr error, ", th5, KLog.INSTANCE, TAG);
            return aVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleRefreshRsp(GetFeedsRsp rsp, String action) {
        ArrayList arrayList;
        List<ClientFeed> list = rsp.feeds;
        if (list != null) {
            arrayList = new ArrayList();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                CommonFeed commonFeed = CommonFeedKt.toCommonFeed(((ClientFeed) it.next()).feed);
                if (commonFeed != null) {
                    arrayList.add(commonFeed);
                }
            }
        } else {
            arrayList = null;
        }
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("refresh success, count: ");
        m3.append(arrayList != null ? Integer.valueOf(arrayList.size()) : null);
        m3.append(", attachInfo: ");
        m3.append(rsp.attachInfo);
        kLog.d(TAG, m3.toString());
        getFeedList().clear();
        if (arrayList != null) {
            List<CommonFeed> cacheFakeFeedList = QzoneFakeFeedLogicManager.INSTANCE.getCacheFakeFeedList(arrayList);
            QzoneFriendFeedManager qzoneFriendFeedManager = INSTANCE;
            qzoneFriendFeedManager.getFeedList().addAll(cacheFakeFeedList);
            qzoneFriendFeedManager.getFeedList().addAll(arrayList);
        }
        attachInfo = rsp.attachInfo;
        IQzoneFeedUpdateCallback dataUpdateCallback = getDataUpdateCallback();
        if (dataUpdateCallback != null) {
            IQzoneFeedUpdateCallback.DefaultImpls.onListUpdate$default(dataUpdateCallback, getFeedList(), action, 0, 4, null);
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneBaseFeedManager
    public boolean enableInsertFakeFeed() {
        return true;
    }

    public final void fetchFriendFeedHead(final DataCallback<GetFriendFeedPageHeadRsp> dataCallback) {
        feedService.fetchFriendFeedHead$qecommerce_biz_release(new DataCallback<GetFriendFeedPageHeadRsp>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFriendFeedManager$fetchFriendFeedHead$1
            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onFailure(long errorCode, String errorMsg) {
                dataCallback.onFailure(errorCode, errorMsg);
            }

            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onSuccess(GetFriendFeedPageHeadRsp t16, long retCode, String msg2, boolean isFinish) {
                QzoneFriendFeedManager.INSTANCE.setHeadInfoCache(t16);
                dataCallback.onSuccess(t16, retCode, msg2, isFinish);
            }
        });
    }

    public final String getAttachInfo() {
        return attachInfo;
    }

    public final GetFriendFeedPageHeadRsp getHeadInfoCache() {
        return headInfoCache;
    }

    @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneBaseFeedManager
    public String getLogTag() {
        return TAG;
    }

    public final boolean hasFeedMemoryCache() {
        return !getFeedList().isEmpty();
    }

    public final boolean isListFinish() {
        return isListFinish;
    }

    public final void loadCache() {
        d<CommonFeed> feedList = getFeedList();
        if (feedList == null || feedList.isEmpty()) {
            QzoneFeedListCacheManager.INSTANCE.loadFriendFeedCache$qecommerce_biz_release(new Function1<GetFeedsRsp, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFriendFeedManager$loadCache$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(GetFeedsRsp getFeedsRsp) {
                    invoke2(getFeedsRsp);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(GetFeedsRsp getFeedsRsp) {
                    QzoneFriendFeedManager qzoneFriendFeedManager = QzoneFriendFeedManager.INSTANCE;
                    d<CommonFeed> feedList2 = qzoneFriendFeedManager.getFeedList();
                    if (feedList2 == null || feedList2.isEmpty()) {
                        qzoneFriendFeedManager.handleRefreshRsp(getFeedsRsp, QzoneDataUpdateAction.MEMORY_CACHE);
                    }
                }
            });
        }
    }

    public final void loadMore(final DataCallback<List<CommonFeed>> dataCallback) {
        NBPFeedCommentsViewModel$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("start loadMore, attachInfo: "), attachInfo, KLog.INSTANCE, TAG);
        QzoneFriendFeedService.fetchFriendFeed$qecommerce_biz_release$default(feedService, attachInfo, getAdvReqByteArr(false), null, new DataCallback<GetFeedsRsp>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFriendFeedManager$loadMore$1
            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onFailure(long errorCode, String errorMsg) {
                KLog.INSTANCE.d(QzoneFriendFeedManager.TAG, "loadMore fail, errorCode: " + errorCode + ", errorMsg: " + errorMsg);
                DataCallback<List<CommonFeed>> dataCallback2 = dataCallback;
                if (dataCallback2 != null) {
                    dataCallback2.onFailure(errorCode, errorMsg);
                }
            }

            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onSuccess(GetFeedsRsp rsp, long retCode, String msg2, boolean isFinish) {
                ArrayList arrayList;
                List<ClientFeed> list = rsp.feeds;
                if (list != null) {
                    ArrayList arrayList2 = new ArrayList();
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        CommonFeed commonFeed = CommonFeedKt.toCommonFeed(((ClientFeed) it.next()).feed);
                        if (commonFeed != null) {
                            arrayList2.add(commonFeed);
                        }
                    }
                    arrayList = arrayList2;
                } else {
                    arrayList = null;
                }
                KLog kLog = KLog.INSTANCE;
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("loadMore success, count: ");
                m3.append(arrayList != null ? Integer.valueOf(arrayList.size()) : null);
                m3.append(", attachInfo: ");
                m3.append(rsp.attachInfo);
                m3.append(", hasMore: ");
                NBPFeedCommentsView$contentComments$1$1$7$1$2$1$$ExternalSyntheticOutline0.m(m3, rsp.hasMore, kLog, QzoneFriendFeedManager.TAG);
                if (arrayList != null) {
                    DataCallback<List<CommonFeed>> dataCallback2 = dataCallback;
                    QzoneFriendFeedManager qzoneFriendFeedManager = QzoneFriendFeedManager.INSTANCE;
                    qzoneFriendFeedManager.getFeedList().addAll(arrayList);
                    qzoneFriendFeedManager.setAttachInfo(rsp.attachInfo);
                    qzoneFriendFeedManager.setListFinish(!rsp.hasMore);
                    IQzoneFeedUpdateCallback dataUpdateCallback = qzoneFriendFeedManager.getDataUpdateCallback();
                    if (dataUpdateCallback != null) {
                        IQzoneFeedUpdateCallback.DefaultImpls.onListUpdate$default(dataUpdateCallback, qzoneFriendFeedManager.getFeedList(), QzoneDataUpdateAction.LOAD_MORE, 0, 4, null);
                    }
                    if (dataCallback2 != null) {
                        dataCallback2.onSuccess(arrayList, retCode, msg2, isFinish);
                    }
                }
            }
        }, 4, null);
    }

    public final void refresh(final DataCallback<List<CommonFeed>> dataCallback) {
        KLog.INSTANCE.d(TAG, "start refresh");
        feedService.fetchFriendFeed$qecommerce_biz_release("", getAdvReqByteArr(true), QzoneFeedListCacheManager.INSTANCE.getFriendFeedCacheKey(), new DataCallback<GetFeedsRsp>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFriendFeedManager$refresh$1
            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onFailure(long errorCode, String errorMsg) {
                KLog.INSTANCE.d(QzoneFriendFeedManager.TAG, "refresh fail, errorCode: " + errorCode + ", errorMsg: " + errorMsg);
                DataCallback<List<CommonFeed>> dataCallback2 = dataCallback;
                if (dataCallback2 != null) {
                    dataCallback2.onFailure(errorCode, errorMsg);
                }
            }

            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onSuccess(GetFeedsRsp rsp, long retCode, String msg2, boolean isFinish) {
                QzoneFriendFeedManager qzoneFriendFeedManager = QzoneFriendFeedManager.INSTANCE;
                qzoneFriendFeedManager.handleRefreshRsp(rsp, "REFRESH");
                DataCallback<List<CommonFeed>> dataCallback2 = dataCallback;
                if (dataCallback2 != null) {
                    dataCallback2.onSuccess(qzoneFriendFeedManager.getFeedList(), retCode, msg2, isFinish);
                }
            }
        });
    }

    public final void setAttachInfo(String str) {
        attachInfo = str;
    }

    public final void setHeadInfoCache(GetFriendFeedPageHeadRsp getFriendFeedPageHeadRsp) {
        headInfoCache = getFriendFeedPageHeadRsp;
    }

    public final void setListFinish(boolean z16) {
        isListFinish = z16;
    }

    @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneBaseFeedManager
    public void clear() {
        QzoneBaseFeedManager.unregisterFeedUpdateCallback$default(this, null, 1, null);
        getFeedList().clear();
        attachInfo = "";
        headInfoCache = null;
        isListFinish = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void loadMore$default(QzoneFriendFeedManager qzoneFriendFeedManager, DataCallback dataCallback, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            dataCallback = null;
        }
        qzoneFriendFeedManager.loadMore(dataCallback);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void refresh$default(QzoneFriendFeedManager qzoneFriendFeedManager, DataCallback dataCallback, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            dataCallback = null;
        }
        qzoneFriendFeedManager.refresh(dataCallback);
    }
}
