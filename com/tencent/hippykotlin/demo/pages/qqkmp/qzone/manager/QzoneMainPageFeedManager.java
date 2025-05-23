package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager;

import com.qzone.module.feedcomponent.manage.FeedManager;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.dataline.DatalineDetailViewModel$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView$contentComments$1$1$7$1$2$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsViewModel$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.consts.QzoneDataUpdateAction;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeedKt;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonRightQuestion;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUser;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.QzoneMainPageInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.IQzoneFeedUpdateCallback;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.ClientFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.GetMainPageFeedsByTimeRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.GetMainPageFeedsRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.GetMainPageHeadRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_writer.feeds_writer.ApplyVisitRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_writer.feeds_writer.DeleteVisitRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_writer.feeds_writer.ValidateQARsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.interaction_writer.interaction_writer.RemoveSpecialRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.interaction_writer.interaction_writer.SetSpecialRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service.QzoneMainPageFeedService;
import com.tencent.hippykotlin.demo.pages.qzone.module.QZoneComposePlatformModule;
import com.tencent.kuikly.core.kmp.d;
import com.tencent.kuikly.core.log.KLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 F2\u00020\u0001:\u0001FB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J$\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00032\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fJ,\u0010!\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020&0\u001fJ\b\u0010'\u001a\u00020\u000eH\u0016J.\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020#2\n\u0010*\u001a\u00060%j\u0002`+2\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u001fH\u0002J\u0014\u0010-\u001a\u00020\u001c2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020.0\u001fJ\b\u0010/\u001a\u00020\u0003H\u0016J\u0018\u00100\u001a\u00020\u001c2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u0003H\u0002J\u0006\u00104\u001a\u00020\u001cJ\u0018\u00105\u001a\u00020\u001c2\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u000206\u0018\u00010\u001fJ \u00107\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020#2\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010\u001fJ \u00108\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020#2\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010\u001fJ\u0018\u00109\u001a\u00020\u001c2\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u000206\u0018\u00010\u001fJ \u0010:\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020#2\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010\u001fJ\"\u0010;\u001a\u00020\u001c2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020>0=2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020?0\u001fJ\"\u0010@\u001a\u00020\u001c2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020>0=2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020A0\u001fJ$\u0010B\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010C\u001a\u00020D2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020E0\u001fR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\u0004R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006G"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/QzoneMainPageFeedManager;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/QzoneBaseFeedManager;", "hostUin", "", "(Ljava/lang/String;)V", "attachInfo", "getAttachInfo", "()Ljava/lang/String;", "setAttachInfo", "feedService", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/service/QzoneMainPageFeedService;", "getHostUin", "setHostUin", "isListFinish", "", "()Z", "setListFinish", "(Z)V", "isTimeLineListFinish", "setTimeLineListFinish", "timeLineFeedList", "Lkotlin/collections/ArrayDeque;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "getTimeLineFeedList", "()Lkotlin/collections/ArrayDeque;", "setTimeLineFeedList", "(Lkotlin/collections/ArrayDeque;)V", "applyVisit", "", "msg", "dataCallback", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_writer/feeds_writer/ApplyVisitRsp;", "deleteVisit", "vtime", "", "mod", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_writer/feeds_writer/DeleteVisitRsp;", "enableInsertFakeFeed", "fetchFeedByTime", "feedTime", "directType", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/DirectType;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/GetMainPageFeedsByTimeRsp;", "fetchMainPageHead", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/GetMainPageHeadRsp;", "getLogTag", "handleRefreshRsp", "rsp", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/GetMainPageFeedsRsp;", "action", "loadCache", FeedManager.LOAD_MORE, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/QzoneMainPageInfo;", "loadMoreByTime", "loadMoreUpByTime", "refresh", "refreshByTime", "removeSpecialCare", "users", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUser;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/interaction_writer/interaction_writer/RemoveSpecialRsp;", "setSpecialCare", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/interaction_writer/interaction_writer/SetSpecialRsp;", "validateQA", "qa", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonRightQuestion;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_writer/feeds_writer/ValidateQARsp;", "Companion", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QzoneMainPageFeedManager extends QzoneBaseFeedManager {
    public static final String TAG = "QzoneMainPageFeedManager";
    private String hostUin;
    private boolean isListFinish;
    private boolean isTimeLineListFinish;
    public static final int $stable = 8;
    private String attachInfo = "";
    private ArrayDeque<CommonFeed> timeLineFeedList = new ArrayDeque<>();
    private QzoneMainPageFeedService feedService = new QzoneMainPageFeedService();

    public QzoneMainPageFeedManager(String str) {
        this.hostUin = str;
    }

    private final void fetchFeedByTime(final long feedTime, final int directType, final DataCallback<GetMainPageFeedsByTimeRsp> dataCallback) {
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("start fetchFeedByTime hostUin: ");
        m3.append(this.hostUin);
        m3.append(", feedTime: ");
        m3.append(feedTime);
        m3.append(", directType: ");
        m3.append(directType);
        kLog.d(TAG, m3.toString());
        this.feedService.fetchMainPageFeedByTime$qecommerce_biz_release(this.hostUin, "", directType, feedTime, new DataCallback<GetMainPageFeedsByTimeRsp>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneMainPageFeedManager$fetchFeedByTime$1
            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onFailure(long errorCode, String errorMsg) {
                KLog.INSTANCE.d(QzoneMainPageFeedManager.TAG, "refresh fail, errorCode: " + errorCode + ", errorMsg: " + errorMsg);
                DataCallback<GetMainPageFeedsByTimeRsp> dataCallback2 = dataCallback;
                if (dataCallback2 != null) {
                    dataCallback2.onFailure(errorCode, errorMsg);
                }
            }

            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onSuccess(GetMainPageFeedsByTimeRsp rsp, long retCode, String msg2, boolean isFinish) {
                KLog kLog2 = KLog.INSTANCE;
                StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetchFeedByTime success, hostUin: ");
                m16.append(QzoneMainPageFeedManager.this.getHostUin());
                m16.append(", feedTime: ");
                m16.append(feedTime);
                m16.append(", directType: ");
                DatalineDetailViewModel$$ExternalSyntheticOutline0.m(m16, directType, kLog2, QzoneMainPageFeedManager.TAG);
                DataCallback<GetMainPageFeedsByTimeRsp> dataCallback2 = dataCallback;
                if (dataCallback2 != null) {
                    dataCallback2.onSuccess(rsp, retCode, msg2, isFinish);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleRefreshRsp(GetMainPageFeedsRsp rsp, String action) {
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

    public final void applyVisit(String hostUin, String msg2, DataCallback<ApplyVisitRsp> dataCallback) {
        this.feedService.applyVisit$qecommerce_biz_release(hostUin, msg2, dataCallback);
    }

    public final void deleteVisit(String hostUin, long vtime, int mod, DataCallback<DeleteVisitRsp> dataCallback) {
        this.feedService.deleteVisit$qecommerce_biz_release(hostUin, vtime, mod, dataCallback);
    }

    @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneBaseFeedManager
    public boolean enableInsertFakeFeed() {
        return Intrinsics.areEqual(this.hostUin, QZoneComposePlatformModule.Companion.getUin());
    }

    public final void fetchMainPageHead(DataCallback<GetMainPageHeadRsp> dataCallback) {
        this.feedService.fetchMainPageFeedHead$qecommerce_biz_release(this.hostUin, dataCallback);
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

    public final ArrayDeque<CommonFeed> getTimeLineFeedList() {
        return this.timeLineFeedList;
    }

    /* renamed from: isListFinish, reason: from getter */
    public final boolean getIsListFinish() {
        return this.isListFinish;
    }

    /* renamed from: isTimeLineListFinish, reason: from getter */
    public final boolean getIsTimeLineListFinish() {
        return this.isTimeLineListFinish;
    }

    public final void loadCache() {
        if (Intrinsics.areEqual(this.hostUin, QQKuiklyPlatformApi.Companion.getUin())) {
            d<CommonFeed> feedList = getFeedList();
            if (feedList == null || feedList.isEmpty()) {
                QzoneFeedListCacheManager.INSTANCE.loadMainPageCache$qecommerce_biz_release(new Function1<GetMainPageFeedsRsp, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneMainPageFeedManager$loadCache$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(GetMainPageFeedsRsp getMainPageFeedsRsp) {
                        invoke2(getMainPageFeedsRsp);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(GetMainPageFeedsRsp getMainPageFeedsRsp) {
                        d<CommonFeed> feedList2 = QzoneMainPageFeedManager.this.getFeedList();
                        if (feedList2 == null || feedList2.isEmpty()) {
                            QzoneMainPageFeedManager.this.handleRefreshRsp(getMainPageFeedsRsp, QzoneDataUpdateAction.MEMORY_CACHE);
                        }
                    }
                });
            }
        }
    }

    public final void loadMore(final DataCallback<QzoneMainPageInfo> dataCallback) {
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("start loadMore, hostUin: ");
        m3.append(this.hostUin);
        m3.append(", attachInfo: ");
        NBPFeedCommentsViewModel$$ExternalSyntheticOutline0.m(m3, this.attachInfo, kLog, TAG);
        QzoneMainPageFeedService.fetchMainPageFeed$qecommerce_biz_release$default(this.feedService, this.hostUin, this.attachInfo, null, new DataCallback<GetMainPageFeedsRsp>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneMainPageFeedManager$loadMore$1
            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onFailure(long errorCode, String errorMsg) {
                KLog.INSTANCE.d(QzoneMainPageFeedManager.TAG, "loadMore fail, errorCode: " + errorCode + ", errorMsg: " + errorMsg);
                DataCallback<QzoneMainPageInfo> dataCallback2 = dataCallback;
                if (dataCallback2 != null) {
                    dataCallback2.onFailure(errorCode, errorMsg);
                }
            }

            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onSuccess(GetMainPageFeedsRsp rsp, long retCode, String msg2, boolean isFinish) {
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
                NBPFeedCommentsView$contentComments$1$1$7$1$2$1$$ExternalSyntheticOutline0.m(m16, rsp.hasMore, kLog2, QzoneMainPageFeedManager.TAG);
                if (arrayList != null) {
                    QzoneMainPageFeedManager qzoneMainPageFeedManager = QzoneMainPageFeedManager.this;
                    DataCallback<QzoneMainPageInfo> dataCallback2 = dataCallback;
                    qzoneMainPageFeedManager.getFeedList().addAll(arrayList);
                    qzoneMainPageFeedManager.setAttachInfo(rsp.attachInfo);
                    qzoneMainPageFeedManager.setListFinish(!rsp.hasMore);
                    IQzoneFeedUpdateCallback dataUpdateCallback = qzoneMainPageFeedManager.getDataUpdateCallback();
                    if (dataUpdateCallback != null) {
                        IQzoneFeedUpdateCallback.DefaultImpls.onListUpdate$default(dataUpdateCallback, qzoneMainPageFeedManager.getFeedList(), QzoneDataUpdateAction.LOAD_MORE, 0, 4, null);
                    }
                    if (dataCallback2 != null) {
                        dataCallback2.onSuccess(QzoneMainPageInfo.INSTANCE.fromRsp$qecommerce_biz_release(rsp), retCode, msg2, isFinish);
                    }
                }
            }
        }, 4, null);
    }

    public final void loadMoreByTime(final long feedTime, final DataCallback<Integer> dataCallback) {
        fetchFeedByTime(feedTime, 1, new DataCallback<GetMainPageFeedsByTimeRsp>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneMainPageFeedManager$loadMoreByTime$1
            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onFailure(long errorCode, String errorMsg) {
                DataCallback<Integer> dataCallback2 = dataCallback;
                if (dataCallback2 != null) {
                    dataCallback2.onFailure(errorCode, errorMsg);
                }
            }

            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onSuccess(GetMainPageFeedsByTimeRsp rsp, long retCode, String msg2, boolean isFinish) {
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
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("loadMoreByTime success, feedTime: ");
                m3.append(feedTime);
                m3.append(", count: ");
                m3.append(arrayList != null ? Integer.valueOf(arrayList.size()) : null);
                m3.append(", attachInfo: ");
                NBPFeedCommentsViewModel$$ExternalSyntheticOutline0.m(m3, rsp.attachInfo, kLog, QzoneMainPageFeedManager.TAG);
                if (arrayList != null) {
                    this.getTimeLineFeedList().addAll(arrayList);
                }
                this.setTimeLineListFinish(!rsp.hasMore);
                IQzoneFeedUpdateCallback dataUpdateCallback = this.getDataUpdateCallback();
                if (dataUpdateCallback != null) {
                    IQzoneFeedUpdateCallback.DefaultImpls.onListUpdate$default(dataUpdateCallback, this.getTimeLineFeedList(), QzoneDataUpdateAction.TIME_LINE_LOAD_MORE_DOWN, 0, 4, null);
                }
                DataCallback<Integer> dataCallback2 = dataCallback;
                if (dataCallback2 != null) {
                    dataCallback2.onSuccess(Integer.valueOf(rsp.feeds.size()), retCode, msg2, isFinish);
                }
            }
        });
    }

    public final void loadMoreUpByTime(final long feedTime, final DataCallback<Integer> dataCallback) {
        fetchFeedByTime(feedTime, 2, new DataCallback<GetMainPageFeedsByTimeRsp>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneMainPageFeedManager$loadMoreUpByTime$1
            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onFailure(long errorCode, String errorMsg) {
                DataCallback<Integer> dataCallback2 = dataCallback;
                if (dataCallback2 != null) {
                    dataCallback2.onFailure(errorCode, errorMsg);
                }
            }

            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onSuccess(GetMainPageFeedsByTimeRsp rsp, long retCode, String msg2, boolean isFinish) {
                ArrayList arrayList;
                List reversed;
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
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("loadMoreUpByTime success, feedTime: ");
                m3.append(feedTime);
                m3.append(", count: ");
                m3.append(arrayList != null ? Integer.valueOf(arrayList.size()) : null);
                m3.append(", attachInfo: ");
                NBPFeedCommentsViewModel$$ExternalSyntheticOutline0.m(m3, rsp.attachInfo, kLog, QzoneMainPageFeedManager.TAG);
                if (arrayList != null) {
                    ArrayDeque<CommonFeed> timeLineFeedList = this.getTimeLineFeedList();
                    reversed = CollectionsKt___CollectionsKt.reversed(arrayList);
                    timeLineFeedList.addAll(0, reversed);
                }
                IQzoneFeedUpdateCallback dataUpdateCallback = this.getDataUpdateCallback();
                if (dataUpdateCallback != null) {
                    IQzoneFeedUpdateCallback.DefaultImpls.onListUpdate$default(dataUpdateCallback, this.getTimeLineFeedList(), QzoneDataUpdateAction.TIME_LINE_LOAD_MORE_UP, 0, 4, null);
                }
                DataCallback<Integer> dataCallback2 = dataCallback;
                if (dataCallback2 != null) {
                    dataCallback2.onSuccess(Integer.valueOf(rsp.feeds.size()), retCode, msg2, isFinish);
                }
            }
        });
    }

    public final void refresh(final DataCallback<QzoneMainPageInfo> dataCallback) {
        NBPFeedCommentsViewModel$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("start refresh hostUin: "), this.hostUin, KLog.INSTANCE, TAG);
        this.feedService.fetchMainPageFeed$qecommerce_biz_release(this.hostUin, "", Intrinsics.areEqual(this.hostUin, QQKuiklyPlatformApi.Companion.getUin()) ? QzoneFeedListCacheManager.INSTANCE.getMainPageCacheKey() : null, new DataCallback<GetMainPageFeedsRsp>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneMainPageFeedManager$refresh$1
            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onFailure(long errorCode, String errorMsg) {
                KLog.INSTANCE.d(QzoneMainPageFeedManager.TAG, "refresh fail, errorCode: " + errorCode + ", errorMsg: " + errorMsg);
                DataCallback<QzoneMainPageInfo> dataCallback2 = dataCallback;
                if (dataCallback2 != null) {
                    dataCallback2.onFailure(errorCode, errorMsg);
                }
            }

            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onSuccess(GetMainPageFeedsRsp rsp, long retCode, String msg2, boolean isFinish) {
                QzoneMainPageFeedManager.this.handleRefreshRsp(rsp, "REFRESH");
                DataCallback<QzoneMainPageInfo> dataCallback2 = dataCallback;
                if (dataCallback2 != null) {
                    dataCallback2.onSuccess(QzoneMainPageInfo.INSTANCE.fromRsp$qecommerce_biz_release(rsp), retCode, msg2, isFinish);
                }
            }
        });
    }

    public final void refreshByTime(final long feedTime, final DataCallback<Integer> dataCallback) {
        fetchFeedByTime(feedTime, 1, new DataCallback<GetMainPageFeedsByTimeRsp>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneMainPageFeedManager$refreshByTime$1
            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onFailure(long errorCode, String errorMsg) {
                DataCallback<Integer> dataCallback2 = dataCallback;
                if (dataCallback2 != null) {
                    dataCallback2.onFailure(errorCode, errorMsg);
                }
            }

            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onSuccess(GetMainPageFeedsByTimeRsp rsp, long retCode, String msg2, boolean isFinish) {
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
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("refreshByTime success, feedTime: ");
                m3.append(feedTime);
                m3.append(", count: ");
                m3.append(arrayList != null ? Integer.valueOf(arrayList.size()) : null);
                m3.append(", attachInfo: ");
                NBPFeedCommentsViewModel$$ExternalSyntheticOutline0.m(m3, rsp.attachInfo, kLog, QzoneMainPageFeedManager.TAG);
                if (arrayList != null) {
                    QzoneMainPageFeedManager qzoneMainPageFeedManager = this;
                    qzoneMainPageFeedManager.getTimeLineFeedList().clear();
                    qzoneMainPageFeedManager.getTimeLineFeedList().addAll(arrayList);
                }
                IQzoneFeedUpdateCallback dataUpdateCallback = this.getDataUpdateCallback();
                if (dataUpdateCallback != null) {
                    IQzoneFeedUpdateCallback.DefaultImpls.onListUpdate$default(dataUpdateCallback, this.getTimeLineFeedList(), QzoneDataUpdateAction.TIME_LINE_REFRESH, 0, 4, null);
                }
                DataCallback<Integer> dataCallback2 = dataCallback;
                if (dataCallback2 != null) {
                    dataCallback2.onSuccess(Integer.valueOf(rsp.feeds.size()), retCode, msg2, isFinish);
                }
            }
        });
    }

    public final void removeSpecialCare(List<CommonUser> users, DataCallback<RemoveSpecialRsp> dataCallback) {
        this.feedService.removeSpecialCare$qecommerce_biz_release(users, dataCallback);
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

    public final void setSpecialCare(List<CommonUser> users, DataCallback<SetSpecialRsp> dataCallback) {
        this.feedService.setSpecialCare$qecommerce_biz_release(users, dataCallback);
    }

    public final void setTimeLineFeedList(ArrayDeque<CommonFeed> arrayDeque) {
        this.timeLineFeedList = arrayDeque;
    }

    public final void setTimeLineListFinish(boolean z16) {
        this.isTimeLineListFinish = z16;
    }

    public final void validateQA(String hostUin, CommonRightQuestion qa5, DataCallback<ValidateQARsp> dataCallback) {
        this.feedService.validateQA$qecommerce_biz_release(hostUin, qa5, dataCallback);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void fetchFeedByTime$default(QzoneMainPageFeedManager qzoneMainPageFeedManager, long j3, int i3, DataCallback dataCallback, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            dataCallback = null;
        }
        qzoneMainPageFeedManager.fetchFeedByTime(j3, i3, dataCallback);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void loadMore$default(QzoneMainPageFeedManager qzoneMainPageFeedManager, DataCallback dataCallback, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            dataCallback = null;
        }
        qzoneMainPageFeedManager.loadMore(dataCallback);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void loadMoreByTime$default(QzoneMainPageFeedManager qzoneMainPageFeedManager, long j3, DataCallback dataCallback, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            dataCallback = null;
        }
        qzoneMainPageFeedManager.loadMoreByTime(j3, dataCallback);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void loadMoreUpByTime$default(QzoneMainPageFeedManager qzoneMainPageFeedManager, long j3, DataCallback dataCallback, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            dataCallback = null;
        }
        qzoneMainPageFeedManager.loadMoreUpByTime(j3, dataCallback);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void refresh$default(QzoneMainPageFeedManager qzoneMainPageFeedManager, DataCallback dataCallback, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            dataCallback = null;
        }
        qzoneMainPageFeedManager.refresh(dataCallback);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void refreshByTime$default(QzoneMainPageFeedManager qzoneMainPageFeedManager, long j3, DataCallback dataCallback, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            dataCallback = null;
        }
        qzoneMainPageFeedManager.refreshByTime(j3, dataCallback);
    }
}
