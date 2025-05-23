package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.extension.ListExtKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NearbyMiddlePosterData$Companion$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsViewModel$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.consts.QzoneDataUpdateAction;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellAdv;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeedKt;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event.IEventObserver;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event.QzoneBaseEvent;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event.QzoneDeleteEvent;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event.QzoneEventBus;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event.QzoneInsertFakeEvent;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event.QzoneOperateEvent;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event.QzoneUpdateListFeedEvent;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.fake.QzoneFakeOperateHelper;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.IQzoneFeedUpdateCallback;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedExtKt;
import com.tencent.kuikly.core.kmp.d;
import com.tencent.kuikly.core.log.KLog;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b'\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b%\u0010&J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u000bH\u0016J\u0016\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0012\u0010\u0012\u001a\u00020\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u000e\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\b\u0010\u0016\u001a\u00020\u0015H&J\b\u0010\u0017\u001a\u00020\u000fH&R(\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010\u001f\u001a\u0004\u0018\u00010\r8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$\u00a8\u0006'"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/QzoneBaseFeedManager;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/event/IEventObserver;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "commonFeed", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/event/QzoneOperateEvent;", "event", "", "notifyFeedChange", "onDeleteFeed", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/event/QzoneUpdateListFeedEvent;", "onUpdateFeed", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/event/QzoneBaseEvent;", "onEvent", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/IQzoneFeedUpdateCallback;", "callback", "", "applyCache", "registerFeedUpdateCallback", "unregisterFeedUpdateCallback", "onInsertFakeFeed", QCircleLpReportDc05507.KEY_CLEAR, "", "getLogTag", "enableInsertFakeFeed", "Lcom/tencent/kuikly/core/kmp/d;", "feedList", "Lcom/tencent/kuikly/core/kmp/d;", "getFeedList", "()Lcom/tencent/kuikly/core/kmp/d;", "setFeedList", "(Lcom/tencent/kuikly/core/kmp/d;)V", "dataUpdateCallback", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/IQzoneFeedUpdateCallback;", "getDataUpdateCallback", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/IQzoneFeedUpdateCallback;", "setDataUpdateCallback", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/IQzoneFeedUpdateCallback;)V", "<init>", "()V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class QzoneBaseFeedManager implements IEventObserver {
    public static final int $stable = 8;
    private IQzoneFeedUpdateCallback dataUpdateCallback;
    private d<CommonFeed> feedList = new d<>();

    public QzoneBaseFeedManager() {
        QzoneEventBus.INSTANCE.register(this);
    }

    public final void notifyFeedChange(CommonFeed commonFeed, QzoneOperateEvent event) {
        KLog kLog = KLog.INSTANCE;
        String logTag = getLogTag();
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("notifyFeedChange, commonFeed@");
        m3.append(commonFeed.hashCode());
        m3.append(", event: ");
        m3.append(event);
        kLog.d(logTag, m3.toString());
        IQzoneFeedUpdateCallback iQzoneFeedUpdateCallback = this.dataUpdateCallback;
        if (iQzoneFeedUpdateCallback != null) {
            IQzoneFeedUpdateCallback.DefaultImpls.onDataUpdate$default(iQzoneFeedUpdateCallback, commonFeed, event.getAction(), 0, 4, null);
        }
    }

    private final void onDeleteFeed(final CommonFeed commonFeed) {
        KLog kLog = KLog.INSTANCE;
        String logTag = getLogTag();
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("checkDeleteFeed feed: ");
        m3.append(commonFeed.hashCode());
        m3.append(", uniKey: ");
        m3.append(CommonFeedExtKt.getFeedUniqueKey(commonFeed));
        kLog.d(logTag, m3.toString());
        int findIndex = ListExtKt.findIndex(this.feedList, new Function1<CommonFeed, Boolean>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneBaseFeedManager$onDeleteFeed$deleteIndex$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(CommonFeed commonFeed2) {
                boolean areEqual;
                CommonCellAdv cellAdv;
                if (CommonFeedExtKt.isAdFeed(CommonFeed.this) && CommonFeedExtKt.isAdFeed(commonFeed2)) {
                    if (CommonFeed.this.getCellAdv() != null && commonFeed2.getCellAdv() != null) {
                        CommonFeed commonFeed3 = CommonFeed.this;
                        String advFeedId = (commonFeed3 == null || (cellAdv = commonFeed3.getCellAdv()) == null) ? null : cellAdv.getAdvFeedId();
                        CommonCellAdv cellAdv2 = commonFeed2.getCellAdv();
                        if (Intrinsics.areEqual(advFeedId, cellAdv2 != null ? cellAdv2.getAdvFeedId() : null)) {
                            areEqual = true;
                        }
                    }
                    areEqual = false;
                } else {
                    areEqual = Intrinsics.areEqual(CommonFeedExtKt.getFeedUniqueKey(CommonFeed.this), CommonFeedExtKt.getFeedUniqueKey(commonFeed2));
                }
                return Boolean.valueOf(areEqual);
            }
        });
        if (findIndex < 0 || findIndex >= this.feedList.size()) {
            return;
        }
        if (CommonFeedExtKt.isAdFeed(commonFeed)) {
            String logTag2 = getLogTag();
            StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onDeleteAdvFeed success, feed: ");
            m16.append(commonFeed.hashCode());
            m16.append(", advId: ");
            CommonCellAdv cellAdv = commonFeed.getCellAdv();
            NBPFeedCommentsViewModel$$ExternalSyntheticOutline0.m(m16, cellAdv != null ? cellAdv.getAdvFeedId() : null, kLog, logTag2);
        } else {
            String logTag3 = getLogTag();
            StringBuilder m17 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onDeleteFeed success, feed: ");
            m17.append(commonFeed.hashCode());
            m17.append(", uniKey: ");
            m17.append(CommonFeedExtKt.getFeedUniqueKey(commonFeed));
            kLog.d(logTag3, m17.toString());
        }
        this.feedList.remove(findIndex);
        IQzoneFeedUpdateCallback iQzoneFeedUpdateCallback = this.dataUpdateCallback;
        if (iQzoneFeedUpdateCallback != null) {
            iQzoneFeedUpdateCallback.onListUpdate(this.feedList, "DELETE", findIndex);
        }
    }

    private final void onUpdateFeed(QzoneUpdateListFeedEvent event) {
        CommonFeed copyFeed = CommonFeedKt.copyFeed(event.getNewFeed());
        Iterator<CommonFeed> it = this.feedList.iterator();
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                i3 = -1;
                break;
            } else if (Intrinsics.areEqual(CommonFeedExtKt.getFeedUniqueKey(it.next()), event.getOldFeedId())) {
                break;
            } else {
                i3++;
            }
        }
        if (copyFeed != null && i3 != -1) {
            this.feedList.remove(i3);
            this.feedList.add(i3, copyFeed);
            IQzoneFeedUpdateCallback iQzoneFeedUpdateCallback = this.dataUpdateCallback;
            if (iQzoneFeedUpdateCallback != null) {
                iQzoneFeedUpdateCallback.onListUpdate(this.feedList, QzoneDataUpdateAction.UPDATE, i3);
            }
            KLog kLog = KLog.INSTANCE;
            String logTag = getLogTag();
            StringBuilder m3 = NearbyMiddlePosterData$Companion$$ExternalSyntheticOutline0.m("onUpdateFeed replaced feed at position:", i3, ", oldFeedId:");
            m3.append(event.getOldFeedId());
            m3.append(", newFeedId:");
            m3.append(CommonFeedExtKt.getFeedUniqueKey(copyFeed));
            kLog.d(logTag, m3.toString());
            return;
        }
        KLog kLog2 = KLog.INSTANCE;
        String logTag2 = getLogTag();
        StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onUpdateFeed failed to find feed for update: ");
        m16.append(event.getOldFeedId());
        m16.append(", newFeed: ");
        m16.append(copyFeed);
        kLog2.e(logTag2, m16.toString());
    }

    public void clear() {
        this.feedList.clear();
        QzoneEventBus.INSTANCE.unregister(this);
    }

    public abstract boolean enableInsertFakeFeed();

    public final IQzoneFeedUpdateCallback getDataUpdateCallback() {
        return this.dataUpdateCallback;
    }

    public final d<CommonFeed> getFeedList() {
        return this.feedList;
    }

    public abstract String getLogTag();

    @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event.IEventObserver
    public void onEvent(final QzoneBaseEvent event) {
        KLog.INSTANCE.d(getLogTag(), "onEvent: " + event);
        if (event instanceof QzoneOperateEvent) {
            QzoneFakeOperateHelper.INSTANCE.onOperateEvent$qecommerce_biz_release((QzoneOperateEvent) event, this.feedList, new Function1<CommonFeed, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneBaseFeedManager$onEvent$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(CommonFeed commonFeed) {
                    invoke2(commonFeed);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(CommonFeed commonFeed) {
                    QzoneBaseFeedManager.this.notifyFeedChange(commonFeed, (QzoneOperateEvent) event);
                }
            });
            return;
        }
        if (event instanceof QzoneDeleteEvent) {
            onDeleteFeed(((QzoneDeleteEvent) event).getCommonFeed());
        } else if (event instanceof QzoneInsertFakeEvent) {
            onInsertFakeFeed(((QzoneInsertFakeEvent) event).getCommonFeed());
        } else if (event instanceof QzoneUpdateListFeedEvent) {
            onUpdateFeed((QzoneUpdateListFeedEvent) event);
        }
    }

    public final void onInsertFakeFeed(CommonFeed commonFeed) {
        if (enableInsertFakeFeed()) {
            KLog kLog = KLog.INSTANCE;
            String logTag = getLogTag();
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onInsertFeed feed: ");
            m3.append(commonFeed.hashCode());
            m3.append(", uniKey: ");
            m3.append(CommonFeedExtKt.getFeedUniqueKey(commonFeed));
            kLog.d(logTag, m3.toString());
            this.feedList.add(0, commonFeed);
            IQzoneFeedUpdateCallback iQzoneFeedUpdateCallback = this.dataUpdateCallback;
            if (iQzoneFeedUpdateCallback != null) {
                iQzoneFeedUpdateCallback.onListUpdate(this.feedList, QzoneDataUpdateAction.INSERT_FAKE, 0);
                return;
            }
            return;
        }
        KLog.INSTANCE.d(getLogTag(), "insertFakeFeed disabled");
    }

    public final void registerFeedUpdateCallback(IQzoneFeedUpdateCallback callback, boolean applyCache) {
        this.dataUpdateCallback = callback;
        if (applyCache && (!this.feedList.isEmpty())) {
            IQzoneFeedUpdateCallback.DefaultImpls.onListUpdate$default(callback, this.feedList, QzoneDataUpdateAction.MEMORY_CACHE, 0, 4, null);
        }
    }

    public final void setDataUpdateCallback(IQzoneFeedUpdateCallback iQzoneFeedUpdateCallback) {
        this.dataUpdateCallback = iQzoneFeedUpdateCallback;
    }

    public final void setFeedList(d<CommonFeed> dVar) {
        this.feedList = dVar;
    }

    public final void unregisterFeedUpdateCallback(IQzoneFeedUpdateCallback callback) {
        this.dataUpdateCallback = null;
    }

    public static /* synthetic */ void unregisterFeedUpdateCallback$default(QzoneBaseFeedManager qzoneBaseFeedManager, IQzoneFeedUpdateCallback iQzoneFeedUpdateCallback, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                iQzoneFeedUpdateCallback = null;
            }
            qzoneBaseFeedManager.unregisterFeedUpdateCallback(iQzoneFeedUpdateCallback);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: unregisterFeedUpdateCallback");
    }
}
