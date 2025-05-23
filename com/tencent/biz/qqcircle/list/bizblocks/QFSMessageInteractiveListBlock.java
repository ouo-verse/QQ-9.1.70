package com.tencent.biz.qqcircle.list.bizblocks;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QFSMessageItemInfo;
import com.tencent.biz.qqcircle.broadcast.action.QCircleClearRedPointAction;
import com.tencent.biz.qqcircle.events.QCircleAtUpdateEvent;
import com.tencent.biz.qqcircle.events.QCircleCommentUpdateEvent;
import com.tencent.biz.qqcircle.events.QFSMessageLoadEmptyBlockEvent;
import com.tencent.biz.qqcircle.events.QFSMessageQuickThankEvent;
import com.tencent.biz.qqcircle.helpers.QFSPublicListTabCommonHelper;
import com.tencent.biz.qqcircle.helpers.q;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.requests.QFSMessageNoticeCategoriesRequest;
import com.tencent.biz.qqcircle.requests.QFSQuickThankPSVRequest;
import com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock;
import com.tencent.biz.qqcircle.richframework.part.list.base.PublicListInnerFragment;
import com.tencent.biz.qqcircle.utils.bh;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.IRefreshViewProvider;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.R;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StNotice;
import feedcloud.FeedCloudMeta$StNoticeCategory;
import feedcloud.FeedCloudRead$StGetNoticeCategoriesPageRsp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import qqcircle.QQCircleFeedBase$StNoticeBusiData;
import qqcircle.QQCircleFeedBase$StTabInfo;
import qqcircle.QQCircleThank$QuickThankPSVRsp;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSMessageInteractiveListBlock extends QFSBaseMessageListBlock<FeedCloudRead$StGetNoticeCategoriesPageRsp> implements SimpleEventReceiver {
    private static final String TAG = "QFSMessageInteractiveListBlock";
    private boolean emptyBlockLoaded;
    private String eventKey;
    private boolean isFirstSelected;
    private boolean mAllowQuickThank;
    private boolean mIsAutoRefresh;
    private boolean mNeedAddSpilt;
    private final Map<Integer, String> mRspAndTraceIdMap;
    private long mSplitTime;
    private String mSubTabName;
    private int mSubTabType;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements VSDispatchObserver.OnVSRspCallBack<QQCircleThank$QuickThankPSVRsp> {
        a() {
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleThank$QuickThankPSVRsp qQCircleThank$QuickThankPSVRsp) {
            QLog.d(QFSMessageInteractiveListBlock.this.getLogTag(), 1, "[handleMessageQuickThankEvent] onReceive, traceId:" + baseRequest.getTraceId() + " | isSuccess:" + z16 + " | retCode:" + j3 + " | errMsg:" + str);
            if (z16 && j3 == 0) {
                QFSMessageInteractiveListBlock.this.handleQuickThankSuccess();
                QFSMessageInteractiveListBlock.this.triggerAutoRefresh(false);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i3) {
            com.tencent.biz.qqcircle.j.f().e();
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class c implements VSDispatchObserver.OnVSRspCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QFSMessageItemInfo f91442a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f91443b;

        c(QFSMessageItemInfo qFSMessageItemInfo, int i3) {
            this.f91442a = qFSMessageItemInfo;
            this.f91443b = i3;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
            if (j3 == 0 && z16) {
                QLog.d(QFSMessageInteractiveListBlock.TAG, 1, "[handleDeleteMessage] request delete success");
                List<QFSMessageItemInfo> dataList = QFSMessageInteractiveListBlock.this.getDataList();
                if (dataList != null && !dataList.isEmpty()) {
                    dataList.remove(this.f91442a);
                    QFSMessageInteractiveListBlock.this.notifyItemRemoved(this.f91443b);
                    QFSMessageInteractiveListBlock.this.tryDeleteSplitLineAndQuickThankItem();
                    if (dataList.isEmpty()) {
                        QFSMessageInteractiveListBlock.this.triggerAutoRefresh(false);
                    }
                }
            }
        }
    }

    public QFSMessageInteractiveListBlock(Bundle bundle) {
        super(bundle);
        this.mNeedAddSpilt = true;
        this.mIsAutoRefresh = false;
        this.mRspAndTraceIdMap = new HashMap();
        this.isFirstSelected = true;
        this.emptyBlockLoaded = false;
        this.eventKey = "";
        initParams(bundle);
    }

    private void fillDiffInfo(List<QFSMessageItemInfo> list, boolean z16) {
        FeedCloudMeta$StNoticeCategory feedCloudMeta$StNoticeCategory;
        if (!z16 && list != null) {
            for (QFSMessageItemInfo qFSMessageItemInfo : list) {
                if (qFSMessageItemInfo != null) {
                    feedCloudMeta$StNoticeCategory = qFSMessageItemInfo.getStNoticeCategory();
                } else {
                    feedCloudMeta$StNoticeCategory = null;
                }
                if (feedCloudMeta$StNoticeCategory != null && feedCloudMeta$StNoticeCategory.f398455id.get() == 4) {
                    qFSMessageItemInfo.setNeedTop(true);
                    qFSMessageItemInfo.setForceRightArrow(true);
                    qFSMessageItemInfo.setUseSmallAvatar(true);
                    qFSMessageItemInfo.setIsHideTime(true);
                    qFSMessageItemInfo.setRightAreaVerticalCenter(true);
                    return;
                }
            }
        }
    }

    private void fillStatusInfo(List<QFSMessageItemInfo> list) {
        boolean z16;
        if (list == null) {
            return;
        }
        for (QFSMessageItemInfo qFSMessageItemInfo : list) {
            if (qFSMessageItemInfo != null) {
                long j3 = this.mSplitTime;
                if (j3 > 0 && j3 < qFSMessageItemInfo.getMessageTimestamp()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                qFSMessageItemInfo.setIsNewMessage(z16);
                qFSMessageItemInfo.setCanShowHighLightUiStyle(true);
            }
        }
    }

    private long getSplitTime(long j3, long j16) {
        long j17 = this.mSplitTime;
        if (j17 <= 0 && j3 > 0) {
            return j3;
        }
        if (this.mIsAutoRefresh) {
            return j17;
        }
        return j16;
    }

    private void handleCommentUpdateEvent(QCircleCommentUpdateEvent qCircleCommentUpdateEvent) {
        if (qCircleCommentUpdateEvent.eventStatus == 5 && this.isOnResume) {
            QCircleToast.l(QCircleToast.f91646f, QCircleApplication.APP.getResources().getString(R.string.f1917245k), 0, true, false);
        }
    }

    private void handleMessageQuickThankEvent(QFSMessageQuickThankEvent qFSMessageQuickThankEvent) {
        if (qFSMessageQuickThankEvent.getLaunch() != this.launchTo) {
            return;
        }
        QLog.d(getLogTag(), 1, "[handleMessageQuickThankEvent] request quick thanks, launchTo:" + this.launchTo);
        VSNetworkHelper.getInstance().sendRequest(new QFSQuickThankPSVRequest(this.mSplitTime, qFSMessageQuickThankEvent.getLaunch()), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleQuickThankSuccess() {
        QCircleToast.l(QCircleToast.f91646f, uq3.o.g0("msgAllThanksConfirmTxt"), 0, true, false);
        Iterator<QFSMessageItemInfo> it = getDataList().iterator();
        while (it.hasNext()) {
            QFSMessageItemInfo next = it.next();
            if (next.getType() == -1004) {
                it.remove();
            } else {
                FeedCloudMeta$StNotice stNotice = next.getStNotice();
                QQCircleFeedBase$StNoticeBusiData noticeBusiData = next.getNoticeBusiData();
                if (stNotice != null && noticeBusiData != null && stNotice.createTime.get() > this.mSplitTime) {
                    noticeBusiData.thanked.set(true);
                    next.setConsumed();
                }
            }
        }
        notifyDataSetChanged();
    }

    private void initParams(Bundle bundle) {
        String str;
        int i3 = -1;
        int i16 = bundle.getInt(BaseListBlock.PAGE_BLOCK_POSITION, -1);
        if (i16 == -1) {
            return;
        }
        QQCircleFeedBase$StTabInfo qQCircleFeedBase$StTabInfo = (QQCircleFeedBase$StTabInfo) RFSafeListUtils.get(QFSPublicListTabCommonHelper.e(bundle), i16);
        if (qQCircleFeedBase$StTabInfo != null) {
            i3 = qQCircleFeedBase$StTabInfo.tabType.get();
        }
        this.mSubTabType = i3;
        if (qQCircleFeedBase$StTabInfo != null) {
            str = qQCircleFeedBase$StTabInfo.tabName.get();
        } else {
            str = "";
        }
        this.mSubTabName = str;
        QLog.d(getLogTag(), 1, "[initParams] pos:" + i16 + " | subTabType:" + this.mSubTabType + " | mSubTabName:" + this.mSubTabName);
    }

    private void loadEmptyBlock() {
        QLog.d(getLogTag(), 1, "[loadEmptyBlock] " + this.eventKey);
        SimpleEventBus.getInstance().dispatchEvent(new QFSMessageLoadEmptyBlockEvent(true, this.eventKey));
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.list.bizblocks.QFSMessageInteractiveListBlock.1
            @Override // java.lang.Runnable
            public void run() {
                QFSMessageInteractiveListBlock.this.notifyAfterHandleListData(true, false, true);
                PublicListInnerFragment hostFragment = QFSMessageInteractiveListBlock.this.getHostFragment();
                if (hostFragment != null) {
                    hostFragment.Gh();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryDeleteSplitLineAndQuickThankItem() {
        boolean z16;
        QFSMessageItemInfo qFSMessageItemInfo;
        List<QFSMessageItemInfo> dataList = getDataList();
        if (dataList != null && !dataList.isEmpty()) {
            Iterator<QFSMessageItemInfo> it = dataList.iterator();
            int i3 = 0;
            int i16 = 0;
            int i17 = 0;
            while (true) {
                if (it.hasNext()) {
                    QFSMessageItemInfo next = it.next();
                    if (next != null) {
                        if (next.getType() == -1000) {
                            break;
                        }
                        if (!next.isListTopItem() && next.isNewMessage()) {
                            i16++;
                            if (next.isEnableThank()) {
                                i17++;
                            }
                        }
                    }
                    i3++;
                } else {
                    i3 = -1;
                    break;
                }
            }
            boolean z17 = true;
            if (i3 >= 0 && i16 <= 0 && i3 < dataList.size()) {
                dataList.remove(i3);
                z16 = true;
            } else {
                z16 = false;
            }
            if (i17 <= 0 && dataList.size() > 0 && (qFSMessageItemInfo = dataList.get(0)) != null && qFSMessageItemInfo.getType() == -1004) {
                dataList.remove(0);
            } else {
                z17 = z16;
            }
            if (z17) {
                notifyDataSetChanged();
            }
        }
    }

    private void unloadEmptyBlock() {
        QLog.d(getLogTag(), 1, "[unloadEmptyBlock] " + this.eventKey);
        SimpleEventBus.getInstance().dispatchEvent(new QFSMessageLoadEmptyBlockEvent(false, this.eventKey));
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.list.bizblocks.QFSMessageInteractiveListBlock.2
            @Override // java.lang.Runnable
            public void run() {
                PublicListInnerFragment hostFragment = QFSMessageInteractiveListBlock.this.getHostFragment();
                if (hostFragment != null) {
                    hostFragment.vh();
                }
            }
        });
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSBaseMessageListBlock
    protected void dtReportDeletePopMenuClick(View view, QFSMessageItemInfo qFSMessageItemInfo) {
        VideoReport.setElementId(view, "em_xsj_delete_button");
        VideoReport.reportEvent("ev_xsj_abnormal_clck", view, getDtReportElementParams(qFSMessageItemInfo));
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSBaseMessageListBlock
    protected void dtReportDeletePopMenuImp(View view, QFSMessageItemInfo qFSMessageItemInfo) {
        VideoReport.setElementId(view, "em_xsj_delete_button");
        VideoReport.reportEvent("ev_xsj_abnormal_imp", view, getDtReportElementParams(qFSMessageItemInfo));
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public Map<String, Object> getChildDaTongPageParams() {
        HashMap hashMap = new HashMap();
        if (((QFSBaseMessageListBlock) this).mInitBean != null) {
            QLog.d(getLogTag(), 1, "[getChildDaTongPageParams] launchTo:" + ((QFSBaseMessageListBlock) this).mInitBean.getLaunchTo() + ", subTabType:" + this.mSubTabType + ", subTanName:" + this.mSubTabName);
            hashMap.put("xsj_msg_entrance_name_new", this.mSubTabName);
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_MSG_ENTRANCE_NAME, Integer.valueOf(this.mSubTabType));
        } else {
            QLog.e(getLogTag(), 1, "[getChildDaTongPageParams] mInitBean is null");
        }
        hashMap.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
        return hashMap;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public String getDaTongPageId() {
        return QCircleDaTongConstant.PageId.PG_XSJ_NEW_MESSAGE_FEATURE_PAGE;
    }

    protected Map<String, Object> getDtReportElementParams(QFSMessageItemInfo qFSMessageItemInfo) {
        FeedCloudMeta$StNotice stNotice;
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        if (qFSMessageItemInfo != null) {
            if (qFSMessageItemInfo.getStNotice() == null) {
                stNotice = null;
            } else {
                stNotice = qFSMessageItemInfo.getStNotice();
            }
            if (stNotice != null && stNotice.feedId != null) {
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_MSG_ID, qFSMessageItemInfo.getStNotice().feedId.get());
            }
            if (stNotice != null && stNotice.noticeType != null) {
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_MSG_TYPE, Integer.valueOf(qFSMessageItemInfo.getStNotice().noticeType.get()));
            }
        }
        return buildElementParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock
    public String getEmptyStateActionText() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock
    public String getEmptyStateDescText() {
        return uq3.c.n3();
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock
    protected int getEmptyStateImageType() {
        return 16;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QCircleCommentUpdateEvent.class);
        arrayList.add(QFSMessageQuickThankEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.qqcircle.bizparts.a
    public String getLogTag() {
        return TAG;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public String getTitle() {
        return "";
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSBaseMessageListBlock
    public void handleDeleteMessage(QFSMessageItemInfo qFSMessageItemInfo, int i3) {
        q.r().j(qFSMessageItemInfo, new c(qFSMessageItemInfo, i3));
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public void handleListData(@NonNull List<QFSMessageItemInfo> list, boolean z16, boolean z17, boolean z18) {
        if (com.tencent.biz.qqcircle.utils.n.a()) {
            QLog.d(getLogTag(), 1, "[preHandleListData] use old exp");
            super.handleListData(list, z16, z17, z18);
        } else {
            if (!z16 && list.isEmpty() && !z17 && z18) {
                loadEmptyBlock();
                return;
            }
            QLog.d(getLogTag(), 1, "[preHandleListData] has data, use old exp");
            unloadEmptyBlock();
            super.handleListData(list, z16, z17, z18);
        }
    }

    public void handlePageSelected(int i3) {
        if (this.isFirstSelected) {
            QLog.d(getLogTag(), 1, "[handlePageSelected] first selected, not auto refresh, pos:" + i3);
            this.isFirstSelected = false;
            return;
        }
        if (RFSafeListUtils.isEmpty(getDataList())) {
            return;
        }
        QLog.d(getLogTag(), 1, "[handlePageSelected] auto refresh, pos:" + i3);
        triggerAutoRefresh(true);
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        if (257 == i3) {
            SimpleEventBus.getInstance().dispatchEvent(new QCircleAtUpdateEvent(getContext(), intent));
        }
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSBaseMessageListBlock, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        super.onBindViewHolder(viewHolder, i3);
        List<QFSMessageItemInfo> dataList = getDataList();
        if (dataList != null && !dataList.isEmpty() && dataList.size() > i3 && (viewHolder instanceof BaseListBlock.BaseListVH)) {
            handleItemOnLongClick((BaseListBlock.BaseListVH) viewHolder, dataList.get(i3), i3);
        }
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSBaseMessageListBlock, com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
        super.onInitBlock(bundle);
        NestScrollRecyclerView nestScrollRecyclerView = ((QFSBaseMessageListBlock) this).mRecyclerView;
        if (nestScrollRecyclerView != null) {
            nestScrollRecyclerView.addOnScrollListener(new b());
        }
        this.launchTo = this.mSubTabType;
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSBaseMessageListBlock, com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        q.r().Q(0L);
        q.r().M();
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSBaseMessageListBlock, com.tencent.biz.qqcircle.bizparts.a, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        QCircleClearRedPointAction.d();
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSBaseMessageListBlock, com.tencent.biz.qqcircle.bizparts.a, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        if (this.mIsFirstResume) {
            QLog.d(getLogTag(), 1, "onPartResume registerReceiver");
            SimpleEventBus.getInstance().registerReceiver(this);
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

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QCircleCommentUpdateEvent) {
            handleCommentUpdateEvent((QCircleCommentUpdateEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSMessageQuickThankEvent) {
            handleMessageQuickThankEvent((QFSMessageQuickThankEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    protected void preHandleListData(List<QFSMessageItemInfo> list, boolean z16, boolean z17, boolean z18) {
        Object obj;
        String logTag = getLogTag();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[preHandleListData] fromCache: ");
        sb5.append(z16);
        sb5.append(" | isLoadMore: ");
        sb5.append(z17);
        sb5.append(" | isFinish: ");
        sb5.append(z18);
        sb5.append(" | mSubTabType: ");
        sb5.append(this.mSubTabType);
        sb5.append(" | launchTo: ");
        QCircleInitBean qCircleInitBean = ((QFSBaseMessageListBlock) this).mInitBean;
        if (qCircleInitBean != null) {
            obj = Integer.valueOf(qCircleInitBean.getLaunchTo());
        } else {
            obj = "-1";
        }
        sb5.append(obj);
        sb5.append(" | drawerId: ");
        sb5.append(this.mDrawerId);
        QLog.d(logTag, 1, sb5.toString());
        fillDiffInfo(list, z17);
        fillStatusInfo(list);
        if (!z17 && !z16 && this.mAllowQuickThank) {
            QFSMessageItemInfo qFSMessageItemInfo = new QFSMessageItemInfo(-1004);
            list.add(0, qFSMessageItemInfo);
            qFSMessageItemInfo.setIsListTopItem(true);
            qFSMessageItemInfo.setNeedTop(true);
        }
    }

    public void setEventKey(String str) {
        this.eventKey = str;
    }

    public void triggerAutoRefresh(boolean z16) {
        IRefreshViewProvider iRefreshViewProvider;
        this.mIsAutoRefresh = z16;
        onDoubleClickTitle();
        if (getBlockMerger() != null) {
            iRefreshViewProvider = getBlockMerger().getRefreshViewProvider();
        } else {
            iRefreshViewProvider = null;
        }
        if (iRefreshViewProvider != null) {
            iRefreshViewProvider.setState(4);
        } else {
            QLog.e(getLogTag(), 1, "[triggerAutoRefresh] refreshViewProvider is null");
        }
        onRefreshData();
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSBaseMessageListBlock, com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public String getAttachInfoFromRsp(FeedCloudRead$StGetNoticeCategoriesPageRsp feedCloudRead$StGetNoticeCategoriesPageRsp) {
        return feedCloudRead$StGetNoticeCategoriesPageRsp.attach_info.get();
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSBaseMessageListBlock, com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public boolean getIsFinishFromRsp(FeedCloudRead$StGetNoticeCategoriesPageRsp feedCloudRead$StGetNoticeCategoriesPageRsp) {
        return !feedCloudRead$StGetNoticeCategoriesPageRsp.has_more.get();
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSBaseMessageListBlock, com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public List<QFSMessageItemInfo> getListDataFromRsp(FeedCloudRead$StGetNoticeCategoriesPageRsp feedCloudRead$StGetNoticeCategoriesPageRsp, boolean z16) {
        return q.r().v(feedCloudRead$StGetNoticeCategoriesPageRsp, z16, getLoadInfo() != null && getLoadInfo().isRefreshState(), this.mRspAndTraceIdMap.get(Integer.valueOf(feedCloudRead$StGetNoticeCategoriesPageRsp.hashCode())));
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSBaseMessageListBlock, com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public BaseRequest getRequest(String str) {
        QFSMessageNoticeCategoriesRequest qFSMessageNoticeCategoriesRequest = new QFSMessageNoticeCategoriesRequest(str, ((QFSBaseMessageListBlock) this).mInitBean, this.mSubTabType == 0 ? this.mDrawerId : 0, this.mSubTabType);
        long splitTime = getSplitTime(q.r().t(), 0L);
        if (splitTime > 0) {
            QLog.d(getLogTag(), 1, "[getRequest] requestSplitTime:" + splitTime);
            qFSMessageNoticeCategoriesRequest.setQuickThankTimestamp(splitTime);
        }
        return qFSMessageNoticeCategoriesRequest;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public void handleResponse(boolean z16, boolean z17, long j3, BaseRequest baseRequest, String str, FeedCloudRead$StGetNoticeCategoriesPageRsp feedCloudRead$StGetNoticeCategoriesPageRsp) {
        if (feedCloudRead$StGetNoticeCategoriesPageRsp != null && baseRequest != null) {
            this.mRspAndTraceIdMap.put(Integer.valueOf(feedCloudRead$StGetNoticeCategoriesPageRsp.hashCode()), baseRequest.getTraceId());
        }
        if (z16 && j3 == 0 && feedCloudRead$StGetNoticeCategoriesPageRsp != null && !z17 && !VSNetworkHelper.isProtocolCache(str)) {
            long j16 = feedCloudRead$StGetNoticeCategoriesPageRsp.last_read_timestamp.get();
            long t16 = q.r().t();
            this.mAllowQuickThank = TextUtils.equals(bh.d(feedCloudRead$StGetNoticeCategoriesPageRsp.ext.mapInfo.get(), "allow_quick_thank"), String.valueOf(1));
            QLog.d(getLogTag(), 1, "[handleResponse] cache split time:" + t16 + ", rsp split time:" + j16 + ", mSplitTime:" + this.mSplitTime + ", isAutoRefresh:" + this.mIsAutoRefresh + ", subName:" + this.mSubTabName + ", allowQuickThank:" + this.mAllowQuickThank);
            if (!this.mIsAutoRefresh && t16 <= 0) {
                QLog.d(getLogTag(), 1, "[handleResponse] set split time ");
                q.r().Q(j16);
            }
            this.mSplitTime = getSplitTime(t16, j16);
        }
        this.mIsAutoRefresh = false;
        super.handleResponse(z16, z17, j3, baseRequest, str, (String) feedCloudRead$StGetNoticeCategoriesPageRsp);
    }
}
