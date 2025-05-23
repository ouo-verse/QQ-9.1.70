package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager;

import com.qzone.module.feedcomponent.manage.FeedManager;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView$contentComments$1$1$7$1$2$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsViewModel$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.consts.QzoneDataUpdateAction;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeedKt;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.QzoneMoodListInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event.QzoneEventBus;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.IQzoneFeedUpdateCallback;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.ClientFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.GetShuoshuoListRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service.QzoneMoodListService;
import com.tencent.hippykotlin.demo.pages.qzone.module.QZoneComposePlatformModule;
import com.tencent.kuikly.core.kmp.d;
import com.tencent.kuikly.core.log.KLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0003H\u0002J\u0006\u0010\u0019\u001a\u00020\u0015J\u0018\u0010\u001a\u001a\u00020\u00152\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cJ\u0018\u0010\u001e\u001a\u00020\u00152\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\u0004R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006 "}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/QzoneMoodListManager;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/QzoneBaseFeedManager;", "hostUin", "", "(Ljava/lang/String;)V", "attachInfo", "getAttachInfo", "()Ljava/lang/String;", "setAttachInfo", "feedService", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/service/QzoneMoodListService;", "getHostUin", "setHostUin", "isListFinish", "", "()Z", "setListFinish", "(Z)V", "enableInsertFakeFeed", "getLogTag", "handleRefreshRsp", "", "rsp", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/GetShuoshuoListRsp;", "action", "loadCache", FeedManager.LOAD_MORE, "dataCallback", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/QzoneMoodListInfo;", "refresh", "Companion", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QzoneMoodListManager extends QzoneBaseFeedManager {
    public static final String TAG = "QzoneMoodListManager";
    private String attachInfo = "";
    private QzoneMoodListService feedService = new QzoneMoodListService();
    private String hostUin;
    private boolean isListFinish;
    public static final int $stable = 8;

    public QzoneMoodListManager(String str) {
        this.hostUin = str;
        QzoneEventBus.INSTANCE.register(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleRefreshRsp(GetShuoshuoListRsp rsp, String action) {
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
            if (Intrinsics.areEqual(this.hostUin, QZoneComposePlatformModule.Companion.getUin())) {
                getFeedList().addAll(QzoneFakeFeedLogicManager.INSTANCE.getCacheFakeFeedList(arrayList));
            }
            getFeedList().addAll(arrayList);
        }
        this.attachInfo = rsp.attachInfo;
        IQzoneFeedUpdateCallback dataUpdateCallback = getDataUpdateCallback();
        if (dataUpdateCallback != null) {
            IQzoneFeedUpdateCallback.DefaultImpls.onListUpdate$default(dataUpdateCallback, getFeedList(), action, 0, 4, null);
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneBaseFeedManager
    public boolean enableInsertFakeFeed() {
        return Intrinsics.areEqual(this.hostUin, QZoneComposePlatformModule.Companion.getUin());
    }

    public final String getAttachInfo() {
        return this.attachInfo;
    }

    public final String getHostUin() {
        return this.hostUin;
    }

    @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneBaseFeedManager
    public String getLogTag() {
        return TAG;
    }

    /* renamed from: isListFinish, reason: from getter */
    public final boolean getIsListFinish() {
        return this.isListFinish;
    }

    public final void loadCache() {
        if (Intrinsics.areEqual(this.hostUin, QQKuiklyPlatformApi.Companion.getUin())) {
            d<CommonFeed> feedList = getFeedList();
            if (feedList == null || feedList.isEmpty()) {
                QzoneFeedListCacheManager.INSTANCE.loadMoodListCache$qecommerce_biz_release(new Function1<GetShuoshuoListRsp, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneMoodListManager$loadCache$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(GetShuoshuoListRsp getShuoshuoListRsp) {
                        invoke2(getShuoshuoListRsp);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(GetShuoshuoListRsp getShuoshuoListRsp) {
                        d<CommonFeed> feedList2 = QzoneMoodListManager.this.getFeedList();
                        if (feedList2 == null || feedList2.isEmpty()) {
                            QzoneMoodListManager.this.handleRefreshRsp(getShuoshuoListRsp, QzoneDataUpdateAction.MEMORY_CACHE);
                        }
                    }
                });
            }
        }
    }

    public final void loadMore(final DataCallback<QzoneMoodListInfo> dataCallback) {
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("start loadMore, hostUin: ");
        m3.append(this.hostUin);
        m3.append(", attachInfo: ");
        NBPFeedCommentsViewModel$$ExternalSyntheticOutline0.m(m3, this.attachInfo, kLog, TAG);
        QzoneMoodListService.fetchMoodListFeed$qecommerce_biz_release$default(this.feedService, this.hostUin, this.attachInfo, null, new DataCallback<GetShuoshuoListRsp>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneMoodListManager$loadMore$1
            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onFailure(long errorCode, String errorMsg) {
                KLog.INSTANCE.d(QzoneMoodListManager.TAG, "loadMore fail, errorCode: " + errorCode + ", errorMsg: " + errorMsg);
                DataCallback<QzoneMoodListInfo> dataCallback2 = dataCallback;
                if (dataCallback2 != null) {
                    dataCallback2.onFailure(errorCode, errorMsg);
                }
            }

            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onSuccess(GetShuoshuoListRsp rsp, long retCode, String msg2, boolean isFinish) {
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
                KLog kLog2 = KLog.INSTANCE;
                StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("loadMore success, count: ");
                m16.append(arrayList != null ? Integer.valueOf(arrayList.size()) : null);
                m16.append(", attachInfo: ");
                m16.append(rsp.attachInfo);
                m16.append(", hasMore: ");
                NBPFeedCommentsView$contentComments$1$1$7$1$2$1$$ExternalSyntheticOutline0.m(m16, rsp.hasMore, kLog2, QzoneMoodListManager.TAG);
                if (arrayList != null) {
                    QzoneMoodListManager qzoneMoodListManager = QzoneMoodListManager.this;
                    DataCallback<QzoneMoodListInfo> dataCallback2 = dataCallback;
                    qzoneMoodListManager.getFeedList().addAll(arrayList);
                    qzoneMoodListManager.setAttachInfo(rsp.attachInfo);
                    qzoneMoodListManager.setListFinish(!rsp.hasMore);
                    IQzoneFeedUpdateCallback dataUpdateCallback = qzoneMoodListManager.getDataUpdateCallback();
                    if (dataUpdateCallback != null) {
                        IQzoneFeedUpdateCallback.DefaultImpls.onListUpdate$default(dataUpdateCallback, qzoneMoodListManager.getFeedList(), QzoneDataUpdateAction.LOAD_MORE, 0, 4, null);
                    }
                    if (dataCallback2 != null) {
                        dataCallback2.onSuccess(QzoneMoodListInfo.INSTANCE.fromRsp$qecommerce_biz_release(rsp), retCode, msg2, isFinish);
                    }
                }
            }
        }, 4, null);
    }

    public final void refresh(final DataCallback<QzoneMoodListInfo> dataCallback) {
        NBPFeedCommentsViewModel$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("start refresh hostUin: "), this.hostUin, KLog.INSTANCE, TAG);
        this.feedService.fetchMoodListFeed$qecommerce_biz_release(this.hostUin, "", Intrinsics.areEqual(this.hostUin, QQKuiklyPlatformApi.Companion.getUin()) ? QzoneFeedListCacheManager.INSTANCE.getMoodListCacheKey() : null, new DataCallback<GetShuoshuoListRsp>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneMoodListManager$refresh$1
            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onFailure(long errorCode, String errorMsg) {
                KLog.INSTANCE.d(QzoneMoodListManager.TAG, "refresh fail, errorCode: " + errorCode + ", errorMsg: " + errorMsg);
                DataCallback<QzoneMoodListInfo> dataCallback2 = dataCallback;
                if (dataCallback2 != null) {
                    dataCallback2.onFailure(errorCode, errorMsg);
                }
            }

            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onSuccess(GetShuoshuoListRsp rsp, long retCode, String msg2, boolean isFinish) {
                QzoneMoodListManager.this.handleRefreshRsp(rsp, "REFRESH");
                DataCallback<QzoneMoodListInfo> dataCallback2 = dataCallback;
                if (dataCallback2 != null) {
                    dataCallback2.onSuccess(QzoneMoodListInfo.INSTANCE.fromRsp$qecommerce_biz_release(rsp), retCode, msg2, isFinish);
                }
            }
        });
    }

    public final void setAttachInfo(String str) {
        this.attachInfo = str;
    }

    public final void setHostUin(String str) {
        this.hostUin = str;
    }

    public final void setListFinish(boolean z16) {
        this.isListFinish = z16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void loadMore$default(QzoneMoodListManager qzoneMoodListManager, DataCallback dataCallback, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            dataCallback = null;
        }
        qzoneMoodListManager.loadMore(dataCallback);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void refresh$default(QzoneMoodListManager qzoneMoodListManager, DataCallback dataCallback, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            dataCallback = null;
        }
        qzoneMoodListManager.refresh(dataCallback);
    }
}
