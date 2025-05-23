package com.tencent.biz.qqcircle.list.bizblocks;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.util.Consumer;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.qq.wx.voice.util.ErrorCode;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.events.QFSVideoPlayEndEvent;
import com.tencent.biz.qqcircle.events.QFSWatchLaterEvent;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.immersive.views.QFSWatchLaterHintView;
import com.tencent.biz.qqcircle.immersive.views.QFSWatchLaterItemView;
import com.tencent.biz.qqcircle.j;
import com.tencent.biz.qqcircle.list.QCircleBaseListBlock;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.requests.QFSBatchDelFromWatchLaterRequest;
import com.tencent.biz.qqcircle.requests.QFSBatchUpdateFeedStatusRequest;
import com.tencent.biz.qqcircle.requests.QFSGetWatchLaterListRequest;
import com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock;
import com.tencent.biz.qqcircle.richframework.part.list.base.PublicListInnerFragment;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.qqcircle.widgets.QCircleFullScreenStatusView;
import com.tencent.biz.qqcircle.widgets.QCirclePanelLoadingView;
import com.tencent.biz.richframework.compat.RFWThemeUtil;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.IStatusViewProvider;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.data.idata.IDataCallBack;
import com.tencent.richframework.data.idata.IDataDisplaySurface;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudWatchlater$BatchDelFromWatchLaterRsp;
import feedcloud.FeedCloudWatchlater$BatchUpdateFeedStatusRsp;
import feedcloud.FeedCloudWatchlater$Feed;
import feedcloud.FeedCloudWatchlater$GetWatchLaterListRsp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ee\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 \u008f\u00012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0012\u0004\u0012\u00020\u00070\u0006:\u0002\u0090\u0001B\u0012\u0012\u0007\u0010\u008c\u0001\u001a\u00020.\u00a2\u0006\u0006\b\u008d\u0001\u0010\u008e\u0001J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\bH\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0003H\u0002J\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000fH\u0002J\u0018\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u001d\u001a\u00020\bH\u0002J0\u0010#\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u00152\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001f2\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010!H\u0002J\b\u0010$\u001a\u00020\bH\u0002J\u000e\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020\u001fH\u0002J\u0010\u0010(\u001a\u00020\b2\u0006\u0010'\u001a\u00020&H\u0002J\u0010\u0010*\u001a\u00020\b2\u0006\u0010'\u001a\u00020)H\u0002J\u0010\u0010+\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010,\u001a\u00020\u0019H\u0016J\b\u0010-\u001a\u00020\rH\u0016J\u0012\u00100\u001a\u00020\b2\b\u0010/\u001a\u0004\u0018\u00010.H\u0016J\u0012\u00103\u001a\u0002022\b\u00101\u001a\u0004\u0018\u00010\u0019H\u0016J\u001e\u00107\u001a\u0004\u0018\u0001022\b\u00105\u001a\u0004\u0018\u0001042\b\u00106\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u00108\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u00109\u001a\u00020\u00192\b\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0016J \u0010;\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010:\u001a\u00020\rH\u0016J>\u0010B\u001a\u00020\b2\u0006\u0010<\u001a\u00020\r2\u0006\u0010=\u001a\u00020\r2\u0006\u0010?\u001a\u00020>2\b\u0010@\u001a\u0004\u0018\u0001022\b\u0010A\u001a\u0004\u0018\u00010\u00192\b\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0014J0\u0010D\u001a\u00020\b2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000f2\u0006\u0010:\u001a\u00020\r2\u0006\u0010=\u001a\u00020\r2\u0006\u0010C\u001a\u00020\rH\u0014J\u001a\u0010E\u001a\u00020\b2\b\u0010A\u001a\u0004\u0018\u00010\u00192\u0006\u0010?\u001a\u00020>H\u0014J\b\u0010F\u001a\u00020\bH\u0016J\u0018\u0010K\u001a\u00020J2\u0006\u0010H\u001a\u00020G2\u0006\u0010I\u001a\u00020\u0015H\u0016J\u0018\u0010N\u001a\u00020\b2\u0006\u0010L\u001a\u00020J2\u0006\u0010M\u001a\u00020\u0015H\u0016J\b\u0010O\u001a\u00020\u0015H\u0016J\u0010\u0010P\u001a\u00020\u00152\u0006\u0010M\u001a\u00020\u0015H\u0016J\b\u0010Q\u001a\u00020\u0019H\u0016J\b\u0010R\u001a\u00020\u0019H\u0016J\b\u0010S\u001a\u00020\u0019H\u0016J\u000e\u0010U\u001a\b\u0012\u0004\u0012\u00020T0\u000fH\u0016J\b\u0010V\u001a\u00020\u0019H\u0016J\b\u0010W\u001a\u00020\u0015H\u0016J\u0012\u0010Y\u001a\u00020\u00192\b\u0010X\u001a\u0004\u0018\u00010\u0002H\u0016J\"\u0010]\u001a\u00020\b2\u000e\u0010[\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010Z2\b\u0010\\\u001a\u0004\u0018\u00010\u0019H\u0016J\u0014\u0010_\u001a\u0004\u0018\u00010\u00132\b\u0010^\u001a\u0004\u0018\u00010GH\u0016J\u001a\u0010b\u001a\u00020\b2\b\u0010`\u001a\u0004\u0018\u00010\u00132\u0006\u0010a\u001a\u00020\rH\u0016J\u0012\u0010d\u001a\u00020\b2\b\u0010c\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010e\u001a\u00020\u0015H\u0016J9\u0010k\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000f0j0i2\u0016\u0010h\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010g0f\"\u0004\u0018\u00010gH\u0016\u00a2\u0006\u0004\bk\u0010lJ'\u0010m\u001a\u00020\b2\u0016\u0010h\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010g0f\"\u0004\u0018\u00010gH\u0016\u00a2\u0006\u0004\bm\u0010nJ\u0012\u0010q\u001a\u00020\b2\b\u0010p\u001a\u0004\u0018\u00010oH\u0016J\u0012\u0010r\u001a\u00020\b2\b\u0010p\u001a\u0004\u0018\u00010oH\u0016J\u0012\u0010s\u001a\u00020\b2\b\u0010p\u001a\u0004\u0018\u00010oH\u0016J\u0012\u0010t\u001a\u00020\b2\b\u0010p\u001a\u0004\u0018\u00010oH\u0016J\u0012\u0010u\u001a\u00020\b2\b\u0010'\u001a\u0004\u0018\u00010\u0007H\u0016J$\u0010y\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070w0vj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070w`xH\u0016J\u0010\u0010|\u001a\u00020\b2\u0006\u0010{\u001a\u00020zH\u0016J\b\u0010}\u001a\u00020\rH\u0016J\b\u0010~\u001a\u00020\u0015H\u0016R\u0019\u0010\\\u001a\u0004\u0018\u00010\u007f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\\\u0010\u0080\u0001R\u001c\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0081\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0019\u0010\u0084\u0001\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001R)\u0010\u0086\u0001\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000f0j0i8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0086\u0001\u0010\u0087\u0001R\u001d\u0010\u0088\u0001\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0088\u0001\u0010\u0089\u0001R\u0019\u0010\u008a\u0001\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001\u00a8\u0006\u0091\u0001"}, d2 = {"Lcom/tencent/biz/qqcircle/list/bizblocks/QFSWatchLaterListBlock;", "Lcom/tencent/biz/qqcircle/list/QCircleBaseListBlock;", "Lfeedcloud/FeedCloudWatchlater$Feed;", "Lfeedcloud/FeedCloudWatchlater$GetWatchLaterListRsp;", "Lcom/tencent/richframework/data/idata/IDataDisplaySurface;", "Le30/b;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "handleLoading", "showLoadingView", "hideLoadingView", "rsp", "", "checkHasHiddenFeed", "", "listData", "Lfeedcloud/FeedCloudMeta$StFeed;", "getStFeedsFromRsp", "Landroid/view/View;", "itemView", "", com.tencent.luggage.wxa.c8.c.G, "handleLongClick", "handleSingleDelete", "", "feedId", "updateDeletedFeedBlockData", "deleteSingleFeedFromDataList", "clearAllHiddenFeeds", "delMode", "", "feedIdList", "Landroidx/core/util/Consumer;", "resultListener", "requestDelWatchLaterFeed", "requestUpdate", "getUpdateDataList", "Lcom/tencent/biz/qqcircle/events/QFSVideoPlayEndEvent;", "event", "handlePlayEndEvent", "Lcom/tencent/biz/qqcircle/events/QFSWatchLaterEvent;", "handleWatchLaterEvent", "findPosByFeedId", "getDaTongPageId", "isEnableRefresh", "Landroid/os/Bundle;", "initParams", "onInitBlock", "lastAttachInfo", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", "getRequest", "Lcom/tencent/biz/richframework/part/block/base/LoadInfo;", "loadInfo", "mLastAttachInfo", "getRequestWithLoadInfo", "getIsFinishFromRsp", "getAttachInfoFromRsp", "fromCache", "getListDataFromRsp", "isSuccess", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "", "retCode", Const.BUNDLE_KEY_REQUEST, "errMsg", "handleResponse", "isFinish", "preHandleListData", "showErrorView", "showEmptyView", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onCreateItemViewHolder", "holder", "position", "onBindViewHolder", "getViewTypeCount", "getItemViewType", "getLogTag", "getTitle", "getEmptyHint", "Lcom/tencent/biz/richframework/part/Part;", "getCustomParts", "getDropFrameMonitorTag", "getPageCount", "data", "getAttachInfoFromItemData", "Lcom/tencent/richframework/data/idata/IDataCallBack;", "callBack", "attachInfo", "getListDataAsync", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "getTitleTabView", "view", "isSelected", "onTitleTabSelectedChanged", "titleContainer", "initTitleBar", "getDisplaySurfaceType", "", "", "args", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/richframework/data/base/UIStateData;", "getDisplaySurfaceData", "([Ljava/lang/Object;)Landroidx/lifecycle/MutableLiveData;", "loadMoreForDisplaySurface", "([Ljava/lang/Object;)V", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartStart", "onPartDestroy", "onPartResume", "onPartPause", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "onAttachedToRecyclerView", "isNeedQUIColor", "getBackgroundColor", "Lcom/tencent/mobileqq/pb/ByteStringMicro;", "Lcom/tencent/mobileqq/pb/ByteStringMicro;", "Lcom/tencent/biz/qqcircle/widgets/QCirclePanelLoadingView;", "loadingView", "Lcom/tencent/biz/qqcircle/widgets/QCirclePanelLoadingView;", "hiddenFeedHint", "Ljava/lang/String;", "feedBlockDataListLiveData", "Landroidx/lifecycle/MutableLiveData;", "allFeedsData", "Ljava/util/List;", "hasWatchLast", "Z", "initBean", "<init>", "(Landroid/os/Bundle;)V", "Companion", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSWatchLaterListBlock extends QCircleBaseListBlock<FeedCloudWatchlater$Feed, FeedCloudWatchlater$GetWatchLaterListRsp> implements IDataDisplaySurface<e30.b>, SimpleEventReceiver<SimpleBaseEvent> {

    @NotNull
    private static final String DROP_FRAME_MONITOR_TAG_WATCH_LATER = "qcircle_watch_later_page";

    @NotNull
    private static final String TAG = "QFSWatchLaterListBlock";
    private static final int VIEW_TYPE_BOTTOM_HINT = 2;
    private static final int VIEW_TYPE_COUNT = 2;
    private static final int VIEW_TYPE_NORMAL_FEED = 1;

    @NotNull
    private static final String WATCH_LATER_ATTACH_INFO = "watch_later_attach_info";
    private static final int WATCH_LATER_VALID_DIFF_FOR_UPDATE_TIME = 2000;

    @NotNull
    private final List<e30.b> allFeedsData;

    @Nullable
    private ByteStringMicro attachInfo;

    @NotNull
    private final MutableLiveData<UIStateData<List<e30.b>>> feedBlockDataListLiveData;
    private boolean hasWatchLast;

    @NotNull
    private String hiddenFeedHint;

    @Nullable
    private QCirclePanelLoadingView loadingView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/biz/qqcircle/list/bizblocks/QFSWatchLaterListBlock$b", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == 0) {
                VideoReport.traversePage(recyclerView);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSWatchLaterListBlock(@NotNull Bundle initBean) {
        super(initBean);
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        this.hiddenFeedHint = "";
        this.feedBlockDataListLiveData = new MutableLiveData<>();
        this.allFeedsData = new ArrayList();
    }

    private final boolean checkHasHiddenFeed(FeedCloudWatchlater$GetWatchLaterListRsp rsp) {
        String str;
        if (!rsp.is_finished.get() || !rsp.has_hidden.get() || TextUtils.isEmpty(rsp.bottom_text.get())) {
            str = "";
        } else {
            str = rsp.bottom_text.get();
            Intrinsics.checkNotNullExpressionValue(str, "{\n             rsp.bottom_text.get()\n        }");
        }
        this.hiddenFeedHint = str;
        return !Intrinsics.areEqual(str, "");
    }

    private final void clearAllHiddenFeeds() {
        requestDelWatchLaterFeed(3, null, new Consumer() { // from class: com.tencent.biz.qqcircle.list.bizblocks.m
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                QFSWatchLaterListBlock.clearAllHiddenFeeds$lambda$6(QFSWatchLaterListBlock.this, (Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void clearAllHiddenFeeds$lambda$6(QFSWatchLaterListBlock this$0, Boolean bool) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (bool.booleanValue() && !this$0.mDataList.isEmpty()) {
            int size = this$0.mDataList.size() - 1;
            this$0.mDataList.remove(size);
            this$0.notifyItemRemoved(size);
            BlockContainer blockContainer = this$0.getBlockContainer();
            if (blockContainer != null) {
                blockContainer.setEnableLoadMore(true);
            }
            this$0.hiddenFeedHint = "";
        }
    }

    private final void deleteSingleFeedFromDataList(int pos) {
        this.mDataList.remove(pos);
        notifyItemRemoved(pos);
        this.allFeedsData.remove(pos);
        UIStateData<List<e30.b>> pos2 = UIStateData.obtainSuccess(false).setData(getLoadInfo().isLoadMoreState(), this.allFeedsData).setLatestModifyRecord(UIStateData.ModifyListRecord.obtainNotifyDataSetChanged()).setFinish(getLoadInfo().isFinish()).setPos(0);
        Intrinsics.checkNotNullExpressionValue(pos2, "obtainSuccess<MutableLis\u2026               .setPos(0)");
        this.feedBlockDataListLiveData.postValue(pos2);
    }

    private final int findPosByFeedId(String feedId) {
        ArrayList arrayList = new ArrayList();
        Collection mDataList = this.mDataList;
        Intrinsics.checkNotNullExpressionValue(mDataList, "mDataList");
        arrayList.addAll(mDataList);
        Iterator it = arrayList.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            int i16 = i3 + 1;
            if (!((FeedCloudWatchlater$Feed) it.next()).feed_info.f398449id.get().equals(feedId)) {
                i3 = i16;
            } else {
                return i3;
            }
        }
        return -1;
    }

    private final List<FeedCloudMeta$StFeed> getStFeedsFromRsp(List<FeedCloudWatchlater$Feed> listData) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(listData);
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            FeedCloudMeta$StFeed stFeed = ((FeedCloudWatchlater$Feed) it.next()).feed_info.get();
            if (!stFeed.opMask2.get().contains(60)) {
                stFeed.opMask2.get().add(60);
            }
            Intrinsics.checkNotNullExpressionValue(stFeed, "stFeed");
            arrayList.add(stFeed);
        }
        return arrayList;
    }

    private final List<FeedCloudWatchlater$Feed> getUpdateDataList() {
        long longValue;
        ArrayList<FeedCloudWatchlater$Feed> arrayList = new ArrayList();
        Collection mDataList = this.mDataList;
        Intrinsics.checkNotNullExpressionValue(mDataList, "mDataList");
        arrayList.addAll(mDataList);
        ArrayList arrayList2 = new ArrayList();
        for (FeedCloudWatchlater$Feed feedCloudWatchlater$Feed : arrayList) {
            Long e16 = com.tencent.biz.qqcircle.immersive.manager.f.f().e(r.N(feedCloudWatchlater$Feed.feed_info.video.playUrl.get()));
            if (e16 == null) {
                longValue = 0;
            } else {
                longValue = e16.longValue();
            }
            if (Math.abs(feedCloudWatchlater$Feed.watch_time.get() - longValue) > 2000) {
                FeedCloudWatchlater$Feed feedCloudWatchlater$Feed2 = new FeedCloudWatchlater$Feed();
                if (com.tencent.biz.qqcircle.immersive.manager.f.f().h(feedCloudWatchlater$Feed.feed_info.f398449id.get()) || feedCloudWatchlater$Feed.is_completed.get()) {
                    feedCloudWatchlater$Feed2.is_completed.set(true);
                }
                feedCloudWatchlater$Feed2.watch_time.set(longValue);
                FeedCloudMeta$StFeed feedCloudMeta$StFeed = new FeedCloudMeta$StFeed();
                feedCloudMeta$StFeed.f398449id.set(feedCloudWatchlater$Feed.feed_info.f398449id.get());
                feedCloudWatchlater$Feed2.feed_info.set(feedCloudMeta$StFeed);
                arrayList2.add(feedCloudWatchlater$Feed2);
            }
        }
        return arrayList2;
    }

    private final void handleLoading() {
        Lifecycle lifecycle;
        PublicListInnerFragment hostFragment = getHostFragment();
        if (hostFragment != null && (lifecycle = hostFragment.getLifecycle()) != null) {
            lifecycle.addObserver(new LifecycleEventObserver() { // from class: com.tencent.biz.qqcircle.list.bizblocks.QFSWatchLaterListBlock$handleLoading$1
                @Override // androidx.lifecycle.LifecycleEventObserver
                public void onStateChanged(@NotNull LifecycleOwner source, @NotNull Lifecycle.Event event) {
                    Lifecycle lifecycle2;
                    Intrinsics.checkNotNullParameter(source, "source");
                    Intrinsics.checkNotNullParameter(event, "event");
                    if (event == Lifecycle.Event.ON_START) {
                        QFSWatchLaterListBlock.this.showLoadingView();
                        PublicListInnerFragment hostFragment2 = QFSWatchLaterListBlock.this.getHostFragment();
                        if (hostFragment2 != null && (lifecycle2 = hostFragment2.getLifecycle()) != null) {
                            lifecycle2.removeObserver(this);
                        }
                    }
                }
            });
        }
    }

    private final void handleLongClick(View itemView, final int pos) {
        com.tencent.biz.qqcircle.j.f().j(itemView, new j.f() { // from class: com.tencent.biz.qqcircle.list.bizblocks.l
            @Override // com.tencent.biz.qqcircle.j.f
            public final void onClick(int i3) {
                QFSWatchLaterListBlock.handleLongClick$lambda$3(QFSWatchLaterListBlock.this, pos, i3);
            }
        }, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleLongClick$lambda$3(QFSWatchLaterListBlock this$0, int i3, int i16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.handleSingleDelete(i3);
    }

    private final void handlePlayEndEvent(QFSVideoPlayEndEvent event) {
        if (ab0.a.a(event.mPos, getDataList())) {
            return;
        }
        int i3 = event.mPos;
        int size = getDataList().size() - 1;
        if (!TextUtils.isEmpty(this.hiddenFeedHint)) {
            size--;
        }
        if (i3 >= size) {
            if (!this.hasWatchLast) {
                this.hasWatchLast = true;
                QCircleToast.o(com.tencent.biz.qqcircle.utils.h.a(R.string.f196534hk), 0);
            }
            com.tencent.biz.qqcircle.immersive.manager.f.f().n(r.N(getDataList().get(i3).feed_info.video.playUrl.get()), 0L);
        }
        com.tencent.biz.qqcircle.immersive.manager.f.f().o(event.mFeedId);
    }

    private final void handleSingleDelete(final int pos) {
        Object orNull;
        final String str;
        List<String> listOf;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        PBStringField pBStringField;
        List<E> mDataList = this.mDataList;
        Intrinsics.checkNotNullExpressionValue(mDataList, "mDataList");
        orNull = CollectionsKt___CollectionsKt.getOrNull(mDataList, pos);
        FeedCloudWatchlater$Feed feedCloudWatchlater$Feed = (FeedCloudWatchlater$Feed) orNull;
        if (feedCloudWatchlater$Feed != null && (feedCloudMeta$StFeed = feedCloudWatchlater$Feed.feed_info) != null && (pBStringField = feedCloudMeta$StFeed.f398449id) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        if (str != null) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(str);
            requestDelWatchLaterFeed(0, listOf, new Consumer() { // from class: com.tencent.biz.qqcircle.list.bizblocks.j
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    QFSWatchLaterListBlock.handleSingleDelete$lambda$4(QFSWatchLaterListBlock.this, pos, str, (Boolean) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleSingleDelete$lambda$4(QFSWatchLaterListBlock this$0, int i3, String feedId, Boolean bool) {
        String str;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        PBStringField pBStringField;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(feedId, "$feedId");
        if (!bool.booleanValue()) {
            return;
        }
        this$0.deleteSingleFeedFromDataList(i3);
        this$0.updateDeletedFeedBlockData(feedId);
        boolean z16 = false;
        if (this$0.mDataList.size() == 1) {
            FeedCloudWatchlater$Feed feedCloudWatchlater$Feed = (FeedCloudWatchlater$Feed) this$0.mDataList.get(0);
            if (feedCloudWatchlater$Feed != null && (feedCloudMeta$StFeed = feedCloudWatchlater$Feed.feed_info) != null && (pBStringField = feedCloudMeta$StFeed.f398449id) != null) {
                str = pBStringField.get();
            } else {
                str = null;
            }
            if (TextUtils.isEmpty(str)) {
                z16 = true;
            }
        }
        if (this$0.mDataList.isEmpty() || z16) {
            this$0.showEmptyView();
        }
    }

    private final void handleWatchLaterEvent(QFSWatchLaterEvent event) {
        int findPosByFeedId;
        if (!event.getIsDelete() || (findPosByFeedId = findPosByFeedId(event.getFeedId())) < 0) {
            return;
        }
        deleteSingleFeedFromDataList(findPosByFeedId);
        if (this.mDataList.isEmpty()) {
            showEmptyView();
        }
    }

    private final void hideLoadingView() {
        NestScrollRecyclerView nestScrollRecyclerView;
        QCirclePanelLoadingView qCirclePanelLoadingView = this.loadingView;
        if (qCirclePanelLoadingView != null) {
            qCirclePanelLoadingView.k0();
        }
        BlockContainer blockContainer = getBlockContainer();
        if (blockContainer != null) {
            nestScrollRecyclerView = blockContainer.getRecyclerView();
        } else {
            nestScrollRecyclerView = null;
        }
        if (nestScrollRecyclerView != null) {
            nestScrollRecyclerView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onBindViewHolder$lambda$2(QFSWatchLaterListBlock this$0, int i3, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.handleLongClick(it, i3);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateItemViewHolder$lambda$1(QFSWatchLaterListBlock this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.clearAllHiddenFeeds();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void requestDelWatchLaterFeed(final int delMode, List<String> feedIdList, final Consumer<Boolean> resultListener) {
        VSNetworkHelper.getInstance().sendRequest(new QFSBatchDelFromWatchLaterRequest(delMode, this.attachInfo, feedIdList), new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.qqcircle.list.bizblocks.n
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                QFSWatchLaterListBlock.requestDelWatchLaterFeed$lambda$7(delMode, resultListener, baseRequest, z16, j3, str, (FeedCloudWatchlater$BatchDelFromWatchLaterRsp) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestDelWatchLaterFeed$lambda$7(int i3, Consumer consumer, BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudWatchlater$BatchDelFromWatchLaterRsp feedCloudWatchlater$BatchDelFromWatchLaterRsp) {
        boolean z17;
        if (z16 && j3 == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z17) {
            if (TextUtils.isEmpty(str)) {
                str = com.tencent.biz.qqcircle.utils.h.a(R.string.f19228473);
            }
        } else if (i3 == 0) {
            str = com.tencent.biz.qqcircle.utils.h.a(R.string.f181463du);
        } else {
            str = com.tencent.biz.qqcircle.utils.h.a(R.string.f196494hg);
        }
        QCircleToast.o(str, 0);
        if (consumer != null) {
            consumer.accept(Boolean.valueOf(z17));
        }
    }

    private final void requestUpdate() {
        if (getUpdateDataList().isEmpty()) {
            return;
        }
        VSNetworkHelper.getInstance().sendRequest(new QFSBatchUpdateFeedStatusRequest(getUpdateDataList()), new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.qqcircle.list.bizblocks.i
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                QFSWatchLaterListBlock.requestUpdate$lambda$8(baseRequest, z16, j3, str, (FeedCloudWatchlater$BatchUpdateFeedStatusRsp) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestUpdate$lambda$8(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudWatchlater$BatchUpdateFeedStatusRsp feedCloudWatchlater$BatchUpdateFeedStatusRsp) {
        if (z16 && j3 == 0) {
            com.tencent.xaction.log.b.a(TAG, 1, "requestUpdate success.");
            return;
        }
        com.tencent.xaction.log.b.a(TAG, 1, "requestUpdate fail, errCode: " + j3 + ", errMsg: " + str + ".");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showEmptyView$lambda$0(boolean z16, QFSWatchLaterListBlock this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16) {
            this$0.hiddenFeedHint = "";
            this$0.clearAllHiddenFeeds();
            this$0.showEmptyView();
        } else if (!this$0.mIsFinish) {
            this$0.getLoadInfo().setCurrentState(3);
            this$0.loadMoreData(this$0.getLoadInfo());
        } else {
            this$0.onRefreshData();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showLoadingView() {
        View view;
        FrameLayout frameLayout;
        NestScrollRecyclerView nestScrollRecyclerView = null;
        if (this.loadingView == null) {
            QCirclePanelLoadingView qCirclePanelLoadingView = new QCirclePanelLoadingView(getContext());
            qCirclePanelLoadingView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            PublicListInnerFragment hostFragment = getHostFragment();
            if (hostFragment != null) {
                view = hostFragment.getView();
            } else {
                view = null;
            }
            if (view instanceof FrameLayout) {
                frameLayout = (FrameLayout) view;
            } else {
                frameLayout = null;
            }
            if (frameLayout != null) {
                frameLayout.addView(qCirclePanelLoadingView);
            }
            this.loadingView = qCirclePanelLoadingView;
        }
        BlockContainer blockContainer = getBlockContainer();
        if (blockContainer != null) {
            blockContainer.setBackgroundColor(getBackgroundColor());
        }
        BlockContainer blockContainer2 = getBlockContainer();
        if (blockContainer2 != null) {
            nestScrollRecyclerView = blockContainer2.getRecyclerView();
        }
        if (nestScrollRecyclerView != null) {
            nestScrollRecyclerView.setVisibility(8);
        }
        QCirclePanelLoadingView qCirclePanelLoadingView2 = this.loadingView;
        if (qCirclePanelLoadingView2 != null) {
            qCirclePanelLoadingView2.setVisibility(0);
        }
        QCirclePanelLoadingView qCirclePanelLoadingView3 = this.loadingView;
        if (qCirclePanelLoadingView3 != null) {
            qCirclePanelLoadingView3.setHintText(com.tencent.biz.qqcircle.utils.h.a(R.string.f1918345v));
        }
        QCirclePanelLoadingView qCirclePanelLoadingView4 = this.loadingView;
        if (qCirclePanelLoadingView4 != null) {
            qCirclePanelLoadingView4.n0();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void updateDeletedFeedBlockData(String feedId) {
        FeedCloudMeta$StFeed g16;
        PBRepeatField<Integer> pBRepeatField;
        List<Integer> list;
        MutableLiveData globalData = w20.a.j().getGlobalData(e30.b.class, feedId);
        if (globalData != null) {
            e30.b bVar = (e30.b) globalData.getValue();
            if (bVar != null && (g16 = bVar.g()) != null && (pBRepeatField = g16.opMask2) != null && (list = pBRepeatField.get()) != null) {
                list.remove((Object) 60);
            }
            w20.a.j().initOrUpdateGlobalState((w20.a) globalData.getValue(), true);
        }
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    @NotNull
    public String getAttachInfoFromItemData(@Nullable FeedCloudWatchlater$Feed data) {
        return "";
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public int getBackgroundColor() {
        return QFSQUIUtilsKt.d(getContext(), R.color.qui_common_bg_bottom_standard);
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    @NotNull
    public List<Part> getCustomParts() {
        return new ArrayList();
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    @NotNull
    public String getDaTongPageId() {
        return QCircleDaTongConstant.PageId.PG_XSJ_WAIT_WATCH_PAGE;
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    @NotNull
    public MutableLiveData<UIStateData<List<e30.b>>> getDisplaySurfaceData(@NotNull Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        return this.feedBlockDataListLiveData;
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public int getDisplaySurfaceType() {
        return 0;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    @NotNull
    public String getDropFrameMonitorTag() {
        return DROP_FRAME_MONITOR_TAG_WATCH_LATER;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    @NotNull
    public String getEmptyHint() {
        String a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f196544hl);
        Intrinsics.checkNotNullExpressionValue(a16, "qqStr(R.string.qfs_watch_later_no_more)");
        return a16;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QFSVideoPlayEndEvent.class, QFSWatchLaterEvent.class);
        Intrinsics.checkNotNull(arrayListOf, "null cannot be cast to non-null type java.util.ArrayList<java.lang.Class<com.tencent.biz.richframework.eventbus.SimpleBaseEvent>>{ kotlin.collections.TypeAliasesKt.ArrayList<java.lang.Class<com.tencent.biz.richframework.eventbus.SimpleBaseEvent>> }");
        return arrayListOf;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        if (position != this.mDataList.size() - 1 || !TextUtils.isEmpty(((FeedCloudWatchlater$Feed) this.mDataList.get(position)).feed_info.f398449id.get())) {
            return 1;
        }
        return 2;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.qqcircle.bizparts.a
    @NotNull
    public String getLogTag() {
        return TAG;
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public int getPageCount() {
        return 10;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    @Nullable
    public BaseRequest getRequestWithLoadInfo(@Nullable LoadInfo loadInfo, @Nullable String mLastAttachInfo) {
        if (loadInfo == null) {
            return null;
        }
        if (!loadInfo.isInitState() && !loadInfo.isRefreshState()) {
            if (!loadInfo.isLoadMoreState()) {
                return null;
            }
            return getRequest(mLastAttachInfo);
        }
        return getRequest((String) null);
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    @NotNull
    public String getTitle() {
        String a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f196474he);
        Intrinsics.checkNotNullExpressionValue(a16, "qqStr(R.string.qfs_watch_later)");
        return a16;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    @Nullable
    public View getTitleTabView(@Nullable ViewGroup rootView) {
        return null;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public int getViewTypeCount() {
        return 2;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public void initTitleBar(@Nullable View titleContainer) {
        if (titleContainer != null) {
            titleContainer.setBackgroundColor(QCircleSkinHelper.getInstance().getColor(R.color.qui_common_bg_bottom_standard));
        }
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public boolean isEnableRefresh() {
        return false;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public boolean isNeedQUIColor() {
        return true;
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public void loadMoreForDisplaySurface(@NotNull Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        getLoadInfo().setCurrentState(3);
        loadMoreData(getLoadInfo());
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        recyclerView.addOnScrollListener(new b());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, final int position) {
        BaseListBlock.BaseListVH baseListVH;
        View view;
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (ab0.a.a(position, getDataList())) {
            return;
        }
        if (holder instanceof BaseListBlock.BaseListVH) {
            baseListVH = (BaseListBlock.BaseListVH) holder;
        } else {
            baseListVH = null;
        }
        if (baseListVH != null) {
            baseListVH.setData(getDataList().get(position), position, this.mExtraTypeInfo);
        }
        if (getItemViewType(position) != 2 && baseListVH != null && (view = baseListVH.itemView) != null) {
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.biz.qqcircle.list.bizblocks.o
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view2) {
                    boolean onBindViewHolder$lambda$2;
                    onBindViewHolder$lambda$2 = QFSWatchLaterListBlock.onBindViewHolder$lambda$2(QFSWatchLaterListBlock.this, position, view2);
                    return onBindViewHolder$lambda$2;
                }
            });
        }
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a
    @NotNull
    public RecyclerView.ViewHolder onCreateItemViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 2) {
            Context context = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "parent.context");
            QFSWatchLaterHintView qFSWatchLaterHintView = new QFSWatchLaterHintView(context);
            qFSWatchLaterHintView.setClearClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.list.bizblocks.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QFSWatchLaterListBlock.onCreateItemViewHolder$lambda$1(QFSWatchLaterListBlock.this, view);
                }
            });
            qFSWatchLaterHintView.setReportBean(getReportBean());
            return new BaseListBlock.BaseListVH(qFSWatchLaterHintView);
        }
        Context context2 = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "parent.context");
        QFSWatchLaterItemView qFSWatchLaterItemView = new QFSWatchLaterItemView(context2);
        qFSWatchLaterItemView.setReportBean(getReportBean());
        return new BaseListBlock.BaseListVH(qFSWatchLaterItemView);
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(@Nullable Bundle initParams) {
        super.onInitBlock(initParams);
        setReportBean(new QCircleReportBean());
        getReportBean().setPageId(ErrorCode.ERROR_SDK_CLI_TYPE_INVALID);
        getReportBean().setDtPageId(getDaTongPageId());
        QCircleExtraTypeInfo qCircleExtraTypeInfo = this.mExtraTypeInfo;
        if (qCircleExtraTypeInfo != null) {
            qCircleExtraTypeInfo.sourceType = ErrorCode.ERROR_SDK_CLI_TYPE_INVALID;
        }
        if (qCircleExtraTypeInfo != null) {
            qCircleExtraTypeInfo.mGlobalViewModelKey = TAG;
        }
        w20.a.j().registerDisplaySurface(TAG, this);
        handleLoading();
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        com.tencent.biz.qqcircle.immersive.manager.f.f().a();
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void onPartPause(@Nullable Activity activity) {
        super.onPartPause(activity);
        requestUpdate();
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void onPartResume(@Nullable Activity activity) {
        super.onPartResume(activity);
        RFWThemeUtil.setStatusBarColor(getActivity(), getBackgroundColor());
        notifyDataSetChanged();
        this.hasWatchLast = false;
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public /* bridge */ /* synthetic */ void onPartSaveInstanceState(Activity activity, Bundle bundle) {
        com.tencent.biz.richframework.part.b.e(this, activity, bundle);
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void onPartStart(@Nullable Activity activity) {
        super.onPartStart(activity);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public /* bridge */ /* synthetic */ void onPartStop(Activity activity) {
        com.tencent.biz.richframework.part.b.g(this, activity);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if (event instanceof QFSVideoPlayEndEvent) {
            handlePlayEndEvent((QFSVideoPlayEndEvent) event);
        } else if (event instanceof QFSWatchLaterEvent) {
            handleWatchLaterEvent((QFSWatchLaterEvent) event);
        }
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    protected void preHandleListData(@Nullable List<FeedCloudWatchlater$Feed> listData, boolean fromCache, boolean isLoadMore, boolean isFinish) {
        UIStateData.ModifyListRecord obtainNotifyDataSetChanged;
        if (listData == null) {
            return;
        }
        if (!isLoadMore) {
            this.allFeedsData.clear();
        }
        if (isLoadMore) {
            obtainNotifyDataSetChanged = UIStateData.ModifyListRecord.obtainNotifyItemRangeInsert(this.allFeedsData.size(), listData.size());
        } else {
            obtainNotifyDataSetChanged = UIStateData.ModifyListRecord.obtainNotifyDataSetChanged();
        }
        ArrayList<e30.b> feedBlockDataList = e30.d.b(getStFeedsFromRsp(listData));
        List<e30.b> list = this.allFeedsData;
        Intrinsics.checkNotNullExpressionValue(feedBlockDataList, "feedBlockDataList");
        list.addAll(feedBlockDataList);
        UIStateData<List<e30.b>> pos = UIStateData.obtainSuccess(false).setData(isLoadMore, this.allFeedsData).setLatestModifyRecord(obtainNotifyDataSetChanged).setFinish(isFinish).setPos(0);
        Intrinsics.checkNotNullExpressionValue(pos, "obtainSuccess<MutableLis\u2026               .setPos(0)");
        this.feedBlockDataListLiveData.postValue(pos);
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public void showEmptyView() {
        View view;
        String str;
        IStatusViewProvider statusInterface;
        BlockContainer blockContainer = getBlockContainer();
        QCircleFullScreenStatusView qCircleFullScreenStatusView = null;
        if (blockContainer != null && (statusInterface = blockContainer.getStatusInterface()) != null) {
            view = statusInterface.getStatusView();
        } else {
            view = null;
        }
        if (view instanceof QCircleFullScreenStatusView) {
            qCircleFullScreenStatusView = (QCircleFullScreenStatusView) view;
        }
        final boolean z16 = !TextUtils.isEmpty(this.hiddenFeedHint);
        if (z16) {
            if (qCircleFullScreenStatusView != null) {
                qCircleFullScreenStatusView.setEmptyImageAndText(16, this.hiddenFeedHint, "", com.tencent.biz.qqcircle.utils.h.a(R.string.f196504hh));
            }
        } else {
            if (this.mIsFinish) {
                str = "";
            } else {
                str = com.tencent.biz.qqcircle.utils.h.a(R.string.f183003i0);
            }
            if (qCircleFullScreenStatusView != null) {
                qCircleFullScreenStatusView.setEmptyImageAndText(16, getEmptyHint(), com.tencent.biz.qqcircle.utils.h.a(R.string.f196484hf), str);
            }
        }
        if (qCircleFullScreenStatusView != null) {
            qCircleFullScreenStatusView.setOnRetryClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.list.bizblocks.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    QFSWatchLaterListBlock.showEmptyView$lambda$0(z16, this, view2);
                }
            });
        }
        if (qCircleFullScreenStatusView != null) {
            qCircleFullScreenStatusView.showEmptyView("");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public void showErrorView(@Nullable String errMsg, long retCode) {
        super.showErrorView(errMsg, retCode);
        MutableLiveData<UIStateData<List<e30.b>>> mutableLiveData = this.feedBlockDataListLiveData;
        if (TextUtils.isEmpty(errMsg)) {
            errMsg = "";
        }
        mutableLiveData.postValue(UIStateData.obtainError(errMsg).setRetCode(retCode).setLoadMore(false));
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    @NotNull
    public String getAttachInfoFromRsp(@Nullable FeedCloudWatchlater$GetWatchLaterListRsp rsp) {
        PBBytesField pBBytesField;
        this.attachInfo = (rsp == null || (pBBytesField = rsp.attach_info) == null) ? null : pBBytesField.get();
        return WATCH_LATER_ATTACH_INFO;
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public boolean getIsFinishFromRsp(@Nullable FeedCloudWatchlater$GetWatchLaterListRsp rsp) {
        PBBoolField pBBoolField;
        if (rsp == null || (pBBoolField = rsp.is_finished) == null) {
            return true;
        }
        return pBBoolField.get();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x003b, code lost:
    
        if ((!r0.isEmpty()) != false) goto L11;
     */
    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<FeedCloudWatchlater$Feed> getListDataFromRsp(@Nullable FeedCloudWatchlater$GetWatchLaterListRsp rsp, boolean fromCache) {
        if (rsp == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        List<FeedCloudWatchlater$Feed> list = rsp.feeds.get();
        Intrinsics.checkNotNullExpressionValue(list, "rsp.feeds.get()");
        arrayList.addAll(list);
        if (checkHasHiddenFeed(rsp)) {
            if (!(!arrayList.isEmpty())) {
                Collection mDataList = this.mDataList;
                Intrinsics.checkNotNullExpressionValue(mDataList, "mDataList");
            }
            FeedCloudWatchlater$Feed feedCloudWatchlater$Feed = new FeedCloudWatchlater$Feed();
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = new FeedCloudMeta$StFeed();
            feedCloudMeta$StFeed.content.set(rsp.bottom_text.get());
            feedCloudWatchlater$Feed.feed_info.set(feedCloudMeta$StFeed);
            arrayList.add(feedCloudWatchlater$Feed);
            BlockContainer blockContainer = getBlockContainer();
            if (blockContainer != null) {
                blockContainer.setEnableLoadMore(false);
            }
            return arrayList;
        }
        BlockContainer blockContainer2 = getBlockContainer();
        if (blockContainer2 != null) {
            blockContainer2.setEnableLoadMore(true);
        }
        return arrayList;
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    @NotNull
    public BaseRequest getRequest(@Nullable String lastAttachInfo) {
        if (lastAttachInfo == null) {
            return new QFSGetWatchLaterListRequest(null);
        }
        return new QFSGetWatchLaterListRequest(this.attachInfo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public void handleResponse(boolean isSuccess, boolean isLoadMore, long retCode, @Nullable BaseRequest request, @Nullable String errMsg, @Nullable FeedCloudWatchlater$GetWatchLaterListRsp rsp) {
        super.handleResponse(isSuccess, isLoadMore, retCode, request, errMsg, (String) rsp);
        hideLoadingView();
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public void getListDataAsync(@Nullable IDataCallBack<FeedCloudWatchlater$Feed> callBack, @Nullable String attachInfo) {
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public void onTitleTabSelectedChanged(@Nullable View view, boolean isSelected) {
    }
}
