package com.tencent.biz.qqcircle.list.bizblocks;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qcircleshadow.lib.QCircleHostDropFrameMonitorHelper;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.events.QCircleConfigChangeEvent;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSNormalNoMoreHintView;
import com.tencent.biz.qqcircle.list.QCircleBaseListBlock;
import com.tencent.biz.qqcircle.requests.QFSMessageBoxRequest;
import com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock;
import com.tencent.biz.qqcircle.widgets.QFSDefaultItemView;
import com.tencent.biz.qqcircle.widgets.QFSMessageBoxHistoryDividerView;
import com.tencent.biz.qqcircle.widgets.QFSMessageBoxItemView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleLpReportDc05504DataBuilder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.richframework.data.idata.IDataCallBack;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StNotice;
import feedcloud.FeedCloudRead$StGetMessageListRsp;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import qqcircle.QQCircleFeedBase$StGetNoticeListRspData;
import qqcircle.QQCircleFeedBase$StNoticeBusiData;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSMessageBoxListBlock extends QCircleBaseListBlock<f30.b, FeedCloudRead$StGetMessageListRsp> implements SimpleEventReceiver {
    private static final int HISTORY_MESSAGE_DIVIDER_TYPE = 0;
    private static final String TAG = "QFSMessageBoxListBlock";
    private String mDtEntranceName;
    private String mHostNick;
    private String mHostType;
    private String mHostUin;
    private String mLaunchFrom;
    private boolean mNeedAddSpilt;
    private long mSplitTime;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
            if (i3 == 0) {
                VideoReport.traversePage(recyclerView);
            }
        }
    }

    public QFSMessageBoxListBlock(Bundle bundle) {
        super(bundle);
        this.mNeedAddSpilt = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleResponse$0(boolean z16, FeedCloudRead$StGetMessageListRsp feedCloudRead$StGetMessageListRsp) {
        if (!z16) {
            QQCircleFeedBase$StGetNoticeListRspData qQCircleFeedBase$StGetNoticeListRspData = new QQCircleFeedBase$StGetNoticeListRspData();
            try {
                qQCircleFeedBase$StGetNoticeListRspData.mergeFrom(feedCloudRead$StGetMessageListRsp.busiRspData.get().toByteArray());
                if (qQCircleFeedBase$StGetNoticeListRspData.rspTimestamp.has()) {
                    this.mSplitTime = qQCircleFeedBase$StGetNoticeListRspData.last_read_timestamp.get();
                }
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "handleResponse parse StGetNoticeListRspData error!", th5);
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public String getAttachInfoFromItemData(f30.b bVar) {
        return null;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public Map<String, Object> getChildDaTongPageParams() {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(this.mHostType)) {
            hashMap.put("xsj_msg_entrance_name_new", this.mDtEntranceName);
        } else {
            hashMap.put("xsj_target_qq", this.mHostUin);
        }
        hashMap.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
        return hashMap;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public List<Part> getCustomParts() {
        return null;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public String getDaTongPageId() {
        if (!TextUtils.isEmpty(this.mHostType)) {
            return QCircleDaTongConstant.PageId.PG_XSJ_NEW_MESSAGE_DRAWER_PAGE;
        }
        return QCircleDaTongConstant.PageId.PG_XSJ_MESSAGE_BOX_PAGE;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public String getDropFrameMonitorTag() {
        return QCircleHostDropFrameMonitorHelper._Constants.QCIRCLE_IMMERSIVE_MESSAGE_BOX_PAGE();
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public String getEmptyHint() {
        return com.tencent.biz.qqcircle.utils.h.a(R.string.f183913kg);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QCircleConfigChangeEvent.class);
        return arrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        List<E> list = this.mDataList;
        if (list != 0 && list.size() > i3) {
            if (((f30.b) this.mDataList.get(i3)).e()) {
                return 0;
            }
            QQCircleFeedBase$StNoticeBusiData qQCircleFeedBase$StNoticeBusiData = (QQCircleFeedBase$StNoticeBusiData) ((f30.b) this.mDataList.get(i3)).b("EXTRA_NOTICE_BUSI_DATA");
            if (qQCircleFeedBase$StNoticeBusiData != null) {
                return qQCircleFeedBase$StNoticeBusiData.pattonInfo.pattonType.get();
            }
        }
        QLog.e(TAG, 2, "getItemViewType() return MESSAGE_TYPE_UNSUPPORTED");
        return -1;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.qqcircle.bizparts.a
    public String getLogTag() {
        return TAG;
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public int getPageCount() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.bizparts.a
    public int getPageId() {
        return 92;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public String getTitle() {
        return this.mHostNick;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public View getTitleTabView(ViewGroup viewGroup) {
        return null;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public int getViewTypeCount() {
        return 0;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public boolean isNeedQUIBackgroundDrawable() {
        return true;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public boolean isNeedQUIColor() {
        return true;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        recyclerView.addOnScrollListener(new a());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull @NotNull RecyclerView.ViewHolder viewHolder, int i3) {
        ((BaseListBlock.BaseListVH) viewHolder).setData(this.mDataList.get(i3), i3, this.mExtraTypeInfo);
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a
    @NonNull
    public RecyclerView.ViewHolder onCreateItemViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        if (i3 == -1) {
            return new BaseListBlock.BaseListVH(new QFSDefaultItemView(viewGroup.getContext(), i3));
        }
        if (i3 == 0) {
            return new BaseListBlock.BaseListVH(new QFSMessageBoxHistoryDividerView(viewGroup.getContext()));
        }
        QFSMessageBoxItemView qFSMessageBoxItemView = new QFSMessageBoxItemView(viewGroup.getContext(), i3);
        qFSMessageBoxItemView.setHostUin(this.mHostUin);
        qFSMessageBoxItemView.setHostType(this.mHostType);
        return new BaseListBlock.BaseListVH(qFSMessageBoxItemView);
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
        super.onInitBlock(bundle);
        if (getBlockMerger() != null && getContext() != null) {
            QFSNormalNoMoreHintView qFSNormalNoMoreHintView = new QFSNormalNoMoreHintView(getContext());
            qFSNormalNoMoreHintView.setHintTextColor(getContext().getResources().getColorStateList(R.color.qui_common_text_tertiary));
            getBlockMerger().setCustomNoMoreDataView(qFSNormalNoMoreHintView);
        }
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public /* bridge */ /* synthetic */ void onPartSaveInstanceState(Activity activity, Bundle bundle) {
        com.tencent.biz.richframework.part.b.e(this, activity, bundle);
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public /* bridge */ /* synthetic */ void onPartStart(Activity activity) {
        com.tencent.biz.richframework.part.b.f(this, activity);
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public /* bridge */ /* synthetic */ void onPartStop(Activity activity) {
        com.tencent.biz.richframework.part.b.g(this, activity);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QCircleConfigChangeEvent) {
            QLog.d(getLogTag(), 4, "[onReceiveEvent] QCircleConfigChangeEvent");
            if (this.mRecyclerView.isComputingLayout()) {
                QLog.e(getLogTag(), 1, "[onReceiveEvent] config change event, recyclerView is computingLayout");
            } else {
                notifyDataSetChanged();
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public void onSingleClickTitle() {
        QCircleInitBean qCircleInitBean = new QCircleInitBean();
        qCircleInitBean.setUin(this.mHostUin);
        qCircleInitBean.setFromReportBean(getReportBean().m466clone());
        com.tencent.biz.qqcircle.launcher.c.d0(getContext(), qCircleInitBean);
        ((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setToUin(this.mHostUin).setActionType(102).setSubActionType(2).setThrActionType(2).setPageId(getPageId()));
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0043, code lost:
    
        r9 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0044, code lost:
    
        if (r9 == (-1)) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0046, code lost:
    
        r7.add(r9, f30.b.f());
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004d, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:?, code lost:
    
        return;
     */
    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void preHandleListData(List<f30.b> list, boolean z16, boolean z17, boolean z18) {
        if (!z17) {
            this.mNeedAddSpilt = true;
        }
        if (!this.mNeedAddSpilt) {
            return;
        }
        ListIterator<f30.b> listIterator = list.listIterator();
        while (true) {
            if (!listIterator.hasNext()) {
                break;
            }
            FeedCloudMeta$StNotice d16 = listIterator.next().d();
            if (d16 == null) {
                return;
            }
            if (this.mNeedAddSpilt && this.mSplitTime > d16.createTime.get()) {
                this.mNeedAddSpilt = false;
                if (z17 || listIterator.nextIndex() != 1) {
                    int i3 = listIterator.nextIndex() - 1;
                }
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public void setInitBean(Serializable serializable) {
        super.setInitBean(serializable);
        Serializable serializable2 = this.mInitBean;
        if (serializable2 instanceof QCircleInitBean) {
            this.mHostUin = ((QCircleInitBean) serializable2).getSchemeAttrs().get("uin");
            this.mHostNick = ((QCircleInitBean) this.mInitBean).getSchemeAttrs().get("name");
            this.mHostType = ((QCircleInitBean) this.mInitBean).getSchemeAttrs().get("type");
            this.mDtEntranceName = ((QCircleInitBean) this.mInitBean).getSchemeAttrs().get(QCircleSchemeAttr.MessageList.DT_ENTRANCE_NAME);
            this.mLaunchFrom = ((QCircleInitBean) this.mInitBean).getLaunchFrom();
        }
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public String getAttachInfoFromRsp(FeedCloudRead$StGetMessageListRsp feedCloudRead$StGetMessageListRsp) {
        return feedCloudRead$StGetMessageListRsp.feedAttchInfo.get();
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public boolean getIsFinishFromRsp(FeedCloudRead$StGetMessageListRsp feedCloudRead$StGetMessageListRsp) {
        return feedCloudRead$StGetMessageListRsp.isFinish.get() == 1;
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public List<f30.b> getListDataFromRsp(FeedCloudRead$StGetMessageListRsp feedCloudRead$StGetMessageListRsp, boolean z16) {
        return f30.b.i(feedCloudRead$StGetMessageListRsp.vecNotice.get());
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public BaseRequest getRequest(String str) {
        return new QFSMessageBoxRequest(this.mHostUin, this.mHostType, str, this.mLaunchFrom);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public void handleResponse(boolean z16, final boolean z17, long j3, BaseRequest baseRequest, String str, final FeedCloudRead$StGetMessageListRsp feedCloudRead$StGetMessageListRsp) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.list.bizblocks.b
            @Override // java.lang.Runnable
            public final void run() {
                QFSMessageBoxListBlock.this.lambda$handleResponse$0(z17, feedCloudRead$StGetMessageListRsp);
            }
        });
        super.handleResponse(z16, z17, j3, baseRequest, str, (String) feedCloudRead$StGetMessageListRsp);
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public void initTitleBar(View view) {
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public void getListDataAsync(IDataCallBack iDataCallBack, String str) {
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public void onTitleTabSelectedChanged(View view, boolean z16) {
    }
}
