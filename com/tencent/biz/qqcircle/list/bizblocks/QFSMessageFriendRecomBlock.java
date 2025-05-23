package com.tencent.biz.qqcircle.list.bizblocks;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QFSMessageItemInfo;
import com.tencent.biz.qqcircle.events.QFSLocateHighlightEvent;
import com.tencent.biz.qqcircle.events.QFSMessageFriendRecomItemRemoveEvent;
import com.tencent.biz.qqcircle.events.QFSMessageFriendRecomRefreshCompleteEvent;
import com.tencent.biz.qqcircle.events.QFSMessageFriendRecomRefreshEvent;
import com.tencent.biz.qqcircle.events.QFSPublicListInnerBlockRegisterEvent;
import com.tencent.biz.qqcircle.fragments.message.item.QFSBaseMessageItemView;
import com.tencent.biz.qqcircle.fragments.message.item.QFSUnsupportedMessageItemView;
import com.tencent.biz.qqcircle.helpers.q;
import com.tencent.biz.qqcircle.list.bizblocks.QFSMessageFriendRecomBlock;
import com.tencent.biz.qqcircle.requests.QFSMessageNoticeCategoryDetailRequest;
import com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock;
import com.tencent.biz.qqcircle.utils.bh;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.mobileqq.qcircle.api.event.QCircleFollowUpdateEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudMeta$StNotice;
import feedcloud.FeedCloudRead$StGetNoticeCategoryDetailPageRsp;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSMessageFriendRecomBlock extends QFSMessageSecondListBlock {
    private static final String FRD_RECOM_VALUE = "1";
    private static final String TAG = "QFSMessageFriendRecomBlock";
    private static final String TOP_UP_VALUE = "1";
    private boolean mHasHighLight;
    private boolean mNeedGuideContract;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.biz.qqcircle.list.bizblocks.QFSMessageFriendRecomBlock$1, reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ NestScrollRecyclerView f91439d;

        AnonymousClass1(NestScrollRecyclerView nestScrollRecyclerView) {
            this.f91439d = nestScrollRecyclerView;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void f() {
            SimpleEventBus.getInstance().dispatchEvent(new QFSLocateHighlightEvent());
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f91439d.scrollToPosition(QFSMessageFriendRecomBlock.this.getPositionOffsetStart());
            RecyclerView.ViewHolder findViewHolderForAdapterPosition = this.f91439d.findViewHolderForAdapterPosition(QFSMessageFriendRecomBlock.this.getPositionOffsetStart());
            if (findViewHolderForAdapterPosition != null) {
                this.f91439d.smoothScrollBy(0, findViewHolderForAdapterPosition.itemView.getTop() - this.f91439d.getPaddingTop());
                RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.list.bizblocks.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        QFSMessageFriendRecomBlock.AnonymousClass1.f();
                    }
                }, 500L);
            }
        }
    }

    public QFSMessageFriendRecomBlock(Bundle bundle) {
        super(bundle);
    }

    private void handleFollowUpdateEvent(@NonNull QCircleFollowUpdateEvent qCircleFollowUpdateEvent) {
        List<QFSMessageItemInfo> dataList;
        int i3;
        if (qCircleFollowUpdateEvent.mFromNetRsp && QCirclePluginUtil.isFollow(qCircleFollowUpdateEvent.mFollowStatus) && !TextUtils.isEmpty(qCircleFollowUpdateEvent.mUserId) && (dataList = getDataList()) != null && dataList.size() > 0) {
            ListIterator<QFSMessageItemInfo> listIterator = dataList.listIterator();
            while (true) {
                if (listIterator.hasNext()) {
                    FeedCloudMeta$StNotice stNotice = listIterator.next().getStNotice();
                    if (stNotice != null && TextUtils.equals(stNotice.operation.opUser.f398463id.get(), qCircleFollowUpdateEvent.mUserId)) {
                        i3 = listIterator.nextIndex() - 1;
                        listIterator.remove();
                        break;
                    }
                } else {
                    i3 = -1;
                    break;
                }
            }
            if (i3 >= 0) {
                notifyItemRemoved(i3);
            }
            removeHeadItem();
        }
    }

    private void handleFriendRecommendShieldClick(@NonNull QFSMessageFriendRecomItemRemoveEvent qFSMessageFriendRecomItemRemoveEvent) {
        if (getDataList() != null && qFSMessageFriendRecomItemRemoveEvent.getRemovePos() <= getDataList().size() - 1) {
            getDataList().remove(qFSMessageFriendRecomItemRemoveEvent.getRemovePos());
            notifyItemRemoved(qFSMessageFriendRecomItemRemoveEvent.getRemovePos());
            removeHeadItem();
        }
    }

    private void handleMessageFriendRecomRefreshEvent(QFSMessageFriendRecomRefreshEvent qFSMessageFriendRecomRefreshEvent) {
        onRefreshData();
    }

    private void locateHighLightItem() {
        BlockContainer blockContainer;
        NestScrollRecyclerView recyclerView;
        if (!this.mHasHighLight || (blockContainer = getBlockContainer()) == null || (recyclerView = blockContainer.getRecyclerView()) == null) {
            return;
        }
        RFWThreadManager.getUIHandler().postDelayed(new AnonymousClass1(recyclerView), 500L);
    }

    private void removeHeadItem() {
        QFSMessageItemInfo qFSMessageItemInfo;
        if (getDataList() != null && getDataList().size() == 1 && (qFSMessageItemInfo = getDataList().get(0)) != null && qFSMessageItemInfo.getType() == -1002) {
            getLoadInfo().setFinish(false);
            notifyLoadingComplete(true, false);
            getDataList().remove(0);
            notifyItemRemoved(0);
        }
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSMessageSecondListBlock, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> eventClass = super.getEventClass();
        eventClass.add(QFSMessageFriendRecomItemRemoveEvent.class);
        eventClass.add(QCircleFollowUpdateEvent.class);
        eventClass.add(QFSMessageFriendRecomRefreshEvent.class);
        return eventClass;
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSMessageSecondListBlock
    protected int getItemInfoType() {
        return -104;
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSMessageSecondListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.qqcircle.bizparts.a
    public String getLogTag() {
        return TAG;
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock
    protected boolean needShowFullScreenStatusView() {
        return false;
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSBaseMessageListBlock, com.tencent.biz.qqcircle.bizparts.a
    @NonNull
    public RecyclerView.ViewHolder onCreateItemViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        FragmentActivity activity = getParentFragment().getActivity();
        int viewTypeOffsetStart = i3 + getViewTypeOffsetStart();
        Class<? extends QFSBaseMessageItemView> cls = q.r().A().get(Integer.valueOf(viewTypeOffsetStart));
        if (cls != null) {
            try {
                QFSBaseMessageItemView newInstance = cls.getConstructor(Context.class, Integer.TYPE).newInstance(activity, Integer.valueOf(viewTypeOffsetStart));
                newInstance.setReportBean(getReportBean());
                return new BaseListBlock.BaseListVH(newInstance);
            } catch (Exception e16) {
                QLog.w(getLogTag(), 1, "getItemViewConstructor reflect error: viewType=" + viewTypeOffsetStart + ", itemViewClass=" + cls + "\nerror: " + e16);
            }
        }
        QLog.e(getLogTag(), 2, "onCreateViewHolder()  return new QFSUnsupportedMessageItemView()");
        return new BaseListBlock.BaseListVH(new QFSUnsupportedMessageItemView(activity, viewTypeOffsetStart));
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSMessageSecondListBlock, com.tencent.biz.qqcircle.list.bizblocks.QFSBaseMessageListBlock, com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public /* bridge */ /* synthetic */ void onPartSaveInstanceState(Activity activity, Bundle bundle) {
        com.tencent.biz.richframework.part.b.e(this, activity, bundle);
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSMessageSecondListBlock, com.tencent.biz.qqcircle.list.bizblocks.QFSBaseMessageListBlock, com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public /* bridge */ /* synthetic */ void onPartStart(Activity activity) {
        com.tencent.biz.richframework.part.b.f(this, activity);
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSMessageSecondListBlock, com.tencent.biz.qqcircle.list.bizblocks.QFSBaseMessageListBlock, com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public /* bridge */ /* synthetic */ void onPartStop(Activity activity) {
        com.tencent.biz.richframework.part.b.g(this, activity);
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSMessageSecondListBlock, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof QFSMessageFriendRecomItemRemoveEvent) {
            handleFriendRecommendShieldClick((QFSMessageFriendRecomItemRemoveEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QCircleFollowUpdateEvent) {
            handleFollowUpdateEvent((QCircleFollowUpdateEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSMessageFriendRecomRefreshEvent) {
            handleMessageFriendRecomRefreshEvent((QFSMessageFriendRecomRefreshEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSMessageSecondListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    protected void preHandleListData(List<QFSMessageItemInfo> list, boolean z16, boolean z17, boolean z18) {
        int size;
        boolean z19;
        if (z17) {
            return;
        }
        if (this.mNeedGuideContract && uq3.k.a().c("qfs_need_show_message_contract_guide", true)) {
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(0, new QFSMessageItemInfo(-1005));
        }
        if (list == null) {
            size = 0;
        } else {
            size = list.size();
        }
        QLog.d(getLogTag(), 1, "[preHandleListData] dataSize = " + size + ", isFinish = " + z18 + ", fromCache = " + z16);
        if (size > 0) {
            list.add(0, new QFSMessageItemInfo(-1002));
        }
        locateHighLightItem();
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        if (size <= 0) {
            z19 = true;
        } else {
            z19 = false;
        }
        simpleEventBus.dispatchEvent(new QFSMessageFriendRecomRefreshCompleteEvent(z19));
        if (size <= 0 && z18 && !z16) {
            SimpleEventBus.getInstance().dispatchEvent(new QFSPublicListInnerBlockRegisterEvent(false, 4, true));
        }
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSMessageSecondListBlock, com.tencent.biz.qqcircle.list.bizblocks.QFSBaseMessageListBlock, com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public BaseRequest getRequest(String str) {
        BaseRequest request = super.getRequest(str);
        if (request instanceof QFSMessageNoticeCategoryDetailRequest) {
            QFSMessageNoticeCategoryDetailRequest qFSMessageNoticeCategoryDetailRequest = (QFSMessageNoticeCategoryDetailRequest) request;
            qFSMessageNoticeCategoryDetailRequest.setExtMapInfo("frd_recom", "1");
            qFSMessageNoticeCategoryDetailRequest.mRequest.ext.mapInfo.add(com.tencent.biz.qqcircle.helpers.k.f84627a.f());
        }
        return request;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSMessageSecondListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public void handleResponse(boolean z16, boolean z17, long j3, BaseRequest baseRequest, String str, FeedCloudRead$StGetNoticeCategoryDetailPageRsp feedCloudRead$StGetNoticeCategoryDetailPageRsp) {
        if (z16 && j3 == 0 && feedCloudRead$StGetNoticeCategoryDetailPageRsp != null) {
            this.mNeedGuideContract = com.tencent.biz.qqcircle.helpers.k.f84627a.i(feedCloudRead$StGetNoticeCategoryDetailPageRsp.ext.mapInfo.get());
            String d16 = bh.d(feedCloudRead$StGetNoticeCategoryDetailPageRsp.ext.mapInfo.get(), "top_up");
            QLog.d(getLogTag(), 1, "handleResponse topValue: ", d16, ",mNeedGuideContract: ", Boolean.valueOf(this.mNeedGuideContract));
            if ("1".equals(d16)) {
                this.mHasHighLight = true;
            }
            super.handleResponse(z16, z17, j3, baseRequest, str, feedCloudRead$StGetNoticeCategoryDetailPageRsp);
        }
    }
}
