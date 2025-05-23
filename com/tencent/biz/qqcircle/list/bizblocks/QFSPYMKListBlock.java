package com.tencent.biz.qqcircle.list.bizblocks;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.beans.QFSMessageItemInfo;
import com.tencent.biz.qqcircle.events.QFSMessageFriendRecomItemRemoveEvent;
import com.tencent.biz.qqcircle.events.QFSMessageLoadEmptyBlockEvent;
import com.tencent.biz.qqcircle.fragments.message.item.QFSBaseMessageItemView;
import com.tencent.biz.qqcircle.fragments.message.item.QFSUnsupportedMessageItemView;
import com.tencent.biz.qqcircle.helpers.q;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.qqcircle.requests.QCircleGetRecomUserListRequest;
import com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock;
import com.tencent.biz.qqcircle.utils.cr;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.idata.IDataCallBack;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudMeta$StNotice;
import feedcloud.FeedCloudMeta$StOperation;
import feedcloud.FeedCloudMeta$StUser;
import feedcloud.FeedCloudMeta$StUserRecomInfo;
import feedcloud.FeedCloudRead$StGetRecomUserListRsp;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 C2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001DB\u000f\u0012\u0006\u0010@\u001a\u00020?\u00a2\u0006\u0004\bA\u0010BJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0014\u0010\u000b\u001a\u00020\n*\u00020\u00072\u0006\u0010\t\u001a\u00020\bH\u0002J\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\bJ\"\u0010\u0011\u001a\u00020\u00052\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u0012\u001a\u00020\bH\u0016J\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u0016\u001a\u00020\bH\u0016J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0002H\u0016J\u0010\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0002H\u0016J\u001e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\n0\u001c2\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0018H\u0016J\u0012\u0010 \u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010!\u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J>\u0010(\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u00182\u0006\u0010%\u001a\u00020$2\b\u0010&\u001a\u0004\u0018\u00010\u00142\b\u0010'\u001a\u0004\u0018\u00010\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002H\u0014J0\u0010,\u001a\u00020\u00052\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010)2\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\u0018H\u0016J\u0018\u00102\u001a\u0002012\u0006\u0010.\u001a\u00020-2\u0006\u00100\u001a\u00020/H\u0016R \u00104\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\b038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00106\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u00108\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010;\u001a\u00020:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010=\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010>\u00a8\u0006E"}, d2 = {"Lcom/tencent/biz/qqcircle/list/bizblocks/QFSPYMKListBlock;", "Lcom/tencent/biz/qqcircle/list/bizblocks/QFSBaseMessageListBlock;", "Lfeedcloud/FeedCloudRead$StGetRecomUserListRsp;", "Lcom/tencent/biz/qqcircle/events/QFSMessageFriendRecomItemRemoveEvent;", "event", "", "handleFriendRecommendShieldClick", "Lfeedcloud/FeedCloudMeta$StUserRecomInfo;", "", "traceId", "Lcom/tencent/biz/qqcircle/beans/QFSMessageItemInfo;", "toStGetRecomUserListRsp", "key", "setEventKey", "Lcom/tencent/richframework/data/idata/IDataCallBack;", "callBack", "attachInfo", "getListDataAsync", "getLogTag", "lastAttachInfo", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", "getRequest", "getTitle", "rsp", "", "getIsFinishFromRsp", "getAttachInfoFromRsp", "fromCache", "", "getListDataFromRsp", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "onPartDestroy", "isSuccess", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "", "retCode", Const.BUNDLE_KEY_REQUEST, "errMsg", "handleResponse", "", "listData", "isFinish", "handleListData", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onCreateItemViewHolder", "", "rspHashCodeToTraceId", "Ljava/util/Map;", "eventKey", "Ljava/lang/String;", "needLoadEmptyData", "Z", "Lcom/tencent/biz/qqcircle/utils/cr;", "eventReceiver", "Lcom/tencent/biz/qqcircle/utils/cr;", WadlProxyConsts.SCENE_ID, "I", "Landroid/os/Bundle;", "initParam", "<init>", "(Landroid/os/Bundle;)V", "Companion", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSPYMKListBlock extends QFSBaseMessageListBlock<FeedCloudRead$StGetRecomUserListRsp> {

    @NotNull
    public static final String KeySceneId = "qfs_pymk_list_request_scene_id";

    @NotNull
    private String eventKey;

    @NotNull
    private final cr eventReceiver;
    private boolean needLoadEmptyData;

    @NotNull
    private final Map<Integer, String> rspHashCodeToTraceId;
    private final int sceneId;

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J(\u0010\t\u001a\"\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00070\u0006j\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0007`\bH\u0014\u00a8\u0006\n"}, d2 = {"com/tencent/biz/qqcircle/list/bizblocks/QFSPYMKListBlock$b", "Lcom/tencent/biz/qqcircle/utils/cr;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b extends cr {
        b() {
        }

        @Override // com.tencent.biz.qqcircle.utils.cr
        @NotNull
        protected ArrayList<Class<? extends SimpleBaseEvent>> a() {
            ArrayList<Class<? extends SimpleBaseEvent>> arrayListOf;
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QFSMessageFriendRecomItemRemoveEvent.class, QFSMessageLoadEmptyBlockEvent.class);
            return arrayListOf;
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
            if (event instanceof QFSMessageLoadEmptyBlockEvent) {
                QFSMessageLoadEmptyBlockEvent qFSMessageLoadEmptyBlockEvent = (QFSMessageLoadEmptyBlockEvent) event;
                if (!Intrinsics.areEqual(qFSMessageLoadEmptyBlockEvent.getKey(), QFSPYMKListBlock.this.eventKey)) {
                    QLog.d(QFSPYMKListBlock.this.getLogTag(), 1, "onReceiveEvent QFSMessageLoadEmptyBlockEvent key not match " + qFSMessageLoadEmptyBlockEvent.getKey() + " != " + QFSPYMKListBlock.this.eventKey);
                    return;
                }
                if (qFSMessageLoadEmptyBlockEvent.getLoad()) {
                    QLog.d(QFSPYMKListBlock.this.getLogTag(), 1, "onReceiveEvent QFSMessageLoadEmptyBlockEvent");
                    QFSPYMKListBlock.this.needLoadEmptyData = true;
                    LoadInfo loadInfo = new LoadInfo();
                    loadInfo.setCurrentState(1);
                    QFSPYMKListBlock.this.loadData(loadInfo);
                    return;
                }
                return;
            }
            if (event instanceof QFSMessageFriendRecomItemRemoveEvent) {
                QFSPYMKListBlock.this.handleFriendRecommendShieldClick((QFSMessageFriendRecomItemRemoveEvent) event);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSPYMKListBlock(@NotNull Bundle initParam) {
        super(initParam);
        Intrinsics.checkNotNullParameter(initParam, "initParam");
        this.rspHashCodeToTraceId = new LinkedHashMap();
        this.eventKey = "";
        this.eventReceiver = new b();
        this.sceneId = initParam.getInt(KeySceneId, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleFriendRecommendShieldClick(QFSMessageFriendRecomItemRemoveEvent event) {
        if (getDataList() != null && event.getRemovePos() <= getDataList().size() - 1) {
            getDataList().remove(event.getRemovePos());
            notifyItemRemoved(event.getRemovePos());
            if (getDataList().size() == 1) {
                getDataList().clear();
                RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.biz.qqcircle.list.bizblocks.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        QFSPYMKListBlock.handleFriendRecommendShieldClick$lambda$2(QFSPYMKListBlock.this);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleFriendRecommendShieldClick$lambda$2(QFSPYMKListBlock this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d(this$0.getLogTag(), 1, "handleFriendRecommendShieldClick trigger reinit");
        LoadInfo loadInfo = new LoadInfo();
        loadInfo.setCurrentState(2);
        this$0.loadData(loadInfo);
    }

    private final QFSMessageItemInfo toStGetRecomUserListRsp(FeedCloudMeta$StUserRecomInfo feedCloudMeta$StUserRecomInfo, String str) {
        FeedCloudMeta$StUser feedCloudMeta$StUser = feedCloudMeta$StUserRecomInfo.user;
        String str2 = feedCloudMeta$StUserRecomInfo.recomReason.get();
        if (str2 == null) {
            str2 = "";
        }
        QFSMessageItemInfo qFSMessageItemInfo = new QFSMessageItemInfo(-1007);
        qFSMessageItemInfo.setTraceId(str);
        FeedCloudMeta$StNotice feedCloudMeta$StNotice = new FeedCloudMeta$StNotice();
        FeedCloudMeta$StOperation feedCloudMeta$StOperation = new FeedCloudMeta$StOperation();
        feedCloudMeta$StOperation.opUser = feedCloudMeta$StUser;
        feedCloudMeta$StNotice.operation = feedCloudMeta$StOperation;
        feedCloudMeta$StNotice.message.set(str2);
        qFSMessageItemInfo.setStNotice(feedCloudMeta$StNotice);
        return qFSMessageItemInfo;
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSBaseMessageListBlock, com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public void getListDataAsync(@Nullable IDataCallBack<QFSMessageItemInfo> callBack, @Nullable String attachInfo) {
        List<QFSMessageItemInfo> emptyList;
        QLog.d(getLogTag(), 1, "getListDataAsync needLoadEmptyData=" + this.needLoadEmptyData);
        if (callBack != null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            callBack.onFetchData(true, 0L, emptyList, "", false);
        }
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.qqcircle.bizparts.a
    @NotNull
    public String getLogTag() {
        return "QFSPYMKListBlock";
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    @NotNull
    public String getTitle() {
        return "\u4f60\u53ef\u80fd\u611f\u5174\u8da3\u7684\u521b\u4f5c\u8005";
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public void handleListData(@Nullable List<QFSMessageItemInfo> listData, boolean fromCache, boolean isLoadMore, boolean isFinish) {
        boolean z16;
        List<QFSMessageItemInfo> list;
        boolean z17;
        boolean z18 = true;
        if (!isLoadMore) {
            List<QFSMessageItemInfo> list2 = listData;
            if (list2 != null && !list2.isEmpty()) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (!z17) {
                z16 = true;
                QLog.d(getLogTag(), 1, "handleListData needTitle=" + z16 + " isLoadMore=" + isLoadMore + " isFinish=" + isFinish);
                if (z16 && listData != null) {
                    listData.add(0, new QFSMessageItemInfo(-1006));
                }
                list = listData;
                if (list != null && !list.isEmpty()) {
                    z18 = false;
                }
                if (!z18 && !isLoadMore && !fromCache) {
                    getBlockMerger().resetTryToLoadMoreCount();
                }
                super.handleListData(listData, fromCache, isLoadMore, isFinish);
            }
        }
        z16 = false;
        QLog.d(getLogTag(), 1, "handleListData needTitle=" + z16 + " isLoadMore=" + isLoadMore + " isFinish=" + isFinish);
        if (z16) {
            listData.add(0, new QFSMessageItemInfo(-1006));
        }
        list = listData;
        if (list != null) {
            z18 = false;
        }
        if (!z18) {
            getBlockMerger().resetTryToLoadMoreCount();
        }
        super.handleListData(listData, fromCache, isLoadMore, isFinish);
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSBaseMessageListBlock, com.tencent.biz.qqcircle.bizparts.a
    @NotNull
    public RecyclerView.ViewHolder onCreateItemViewHolder(@NotNull ViewGroup parent, int viewType) {
        String trimIndent;
        Intrinsics.checkNotNullParameter(parent, "parent");
        FragmentActivity activity = getParentFragment().getActivity();
        int viewTypeOffsetStart = viewType + getViewTypeOffsetStart();
        Class<? extends QFSBaseMessageItemView> cls = q.r().A().get(Integer.valueOf(viewTypeOffsetStart));
        if (cls != null) {
            try {
                QFSBaseMessageItemView newInstance = cls.getConstructor(Context.class, Integer.TYPE).newInstance(activity, Integer.valueOf(viewTypeOffsetStart));
                newInstance.setReportBean(getReportBean());
                return new BaseListBlock.BaseListVH(newInstance);
            } catch (Exception e16) {
                String logTag = getLogTag();
                trimIndent = StringsKt__IndentKt.trimIndent("\n                    getItemViewConstructor reflect error: viewType=" + viewTypeOffsetStart + ", itemViewClass=" + cls + "\n                    error: " + e16 + "\n                    ");
                QLog.w(logTag, 1, trimIndent);
            }
        }
        QLog.e(getLogTag(), 2, "onCreateViewHolder()  return new QFSUnsupportedMessageItemView()");
        Intrinsics.checkNotNull(activity);
        return new BaseListBlock.BaseListVH(new QFSUnsupportedMessageItemView(activity, viewTypeOffsetStart));
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSBaseMessageListBlock, com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        QLog.d(getLogTag(), 1, "onPartDestroy");
        SimpleEventBus.getInstance().unRegisterReceiver(this.eventReceiver);
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSBaseMessageListBlock, com.tencent.biz.qqcircle.bizparts.a, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void onPartResume(@Nullable Activity activity) {
        super.onPartResume(activity);
        QLog.d(getLogTag(), 1, "onPartResume");
        if (this.mIsFirstResume) {
            QLog.d(getLogTag(), 1, "onPartResume registerReceiver");
            SimpleEventBus.getInstance().registerReceiver(this.eventReceiver);
        }
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSBaseMessageListBlock, com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public /* bridge */ /* synthetic */ void onPartSaveInstanceState(Activity activity, Bundle bundle) {
        com.tencent.biz.richframework.part.b.e(this, activity, bundle);
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSBaseMessageListBlock, com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public /* bridge */ /* synthetic */ void onPartStart(Activity activity) {
        com.tencent.biz.richframework.part.b.f(this, activity);
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSBaseMessageListBlock, com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public /* bridge */ /* synthetic */ void onPartStop(Activity activity) {
        com.tencent.biz.richframework.part.b.g(this, activity);
    }

    public final void setEventKey(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        QLog.d(getLogTag(), 1, "setEventKey key=" + key);
        this.eventKey = key;
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSBaseMessageListBlock, com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    @NotNull
    public String getAttachInfoFromRsp(@NotNull FeedCloudRead$StGetRecomUserListRsp rsp) {
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        String str = rsp.attachInfo.get();
        Intrinsics.checkNotNullExpressionValue(str, "rsp.attachInfo.get()");
        return str;
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSBaseMessageListBlock, com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public boolean getIsFinishFromRsp(@NotNull FeedCloudRead$StGetRecomUserListRsp rsp) {
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        return rsp.isFinish.get() == 1;
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSBaseMessageListBlock, com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    @NotNull
    public List<QFSMessageItemInfo> getListDataFromRsp(@NotNull FeedCloudRead$StGetRecomUserListRsp rsp, boolean fromCache) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        String str = this.rspHashCodeToTraceId.get(Integer.valueOf(rsp.hashCode()));
        if (str == null) {
            str = "";
        }
        QLog.d(getLogTag(), 1, "getListDataFromRsp traceId=" + str + " size=" + rsp.userRecoms.size() + " fromCache=" + fromCache);
        List<FeedCloudMeta$StUserRecomInfo> list = rsp.userRecoms.get();
        Intrinsics.checkNotNullExpressionValue(list, "rsp.userRecoms.get()");
        List<FeedCloudMeta$StUserRecomInfo> list2 = list;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (FeedCloudMeta$StUserRecomInfo it : list2) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            arrayList.add(toStGetRecomUserListRsp(it, str));
        }
        return arrayList;
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSBaseMessageListBlock, com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    @Nullable
    public BaseRequest getRequest(@Nullable String lastAttachInfo) {
        QLog.d(getLogTag(), 1, "getRequest sceneId=" + this.sceneId + " lastAttachInfo=" + lastAttachInfo + " needLoadEmptyData=" + this.needLoadEmptyData);
        if (this.needLoadEmptyData) {
            QCircleGetRecomUserListRequest qCircleGetRecomUserListRequest = new QCircleGetRecomUserListRequest(lastAttachInfo, 1, ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount(), this.sceneId);
            qCircleGetRecomUserListRequest.setEnableCache(false);
            return qCircleGetRecomUserListRequest;
        }
        QLog.d(getLogTag(), 1, "getRequest return null");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public void handleResponse(boolean isSuccess, boolean isLoadMore, long retCode, @Nullable BaseRequest request, @Nullable String errMsg, @Nullable FeedCloudRead$StGetRecomUserListRsp rsp) {
        Map<Integer, String> map = this.rspHashCodeToTraceId;
        Integer valueOf = Integer.valueOf(rsp != null ? rsp.hashCode() : 0);
        String traceId = request != null ? request.getTraceId() : null;
        if (traceId == null) {
            traceId = "";
        }
        map.put(valueOf, traceId);
        super.handleResponse(isSuccess, isLoadMore, retCode, request, errMsg, (String) rsp);
    }
}
