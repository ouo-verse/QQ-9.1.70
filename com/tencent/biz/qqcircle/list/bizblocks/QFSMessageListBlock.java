package com.tencent.biz.qqcircle.list.bizblocks;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.beans.QFSMessageItemInfo;
import com.tencent.biz.qqcircle.broadcast.action.QCircleClearRedPointAction;
import com.tencent.biz.qqcircle.helpers.q;
import com.tencent.biz.qqcircle.requests.QFSMessageNoticeCategoriesRequest;
import com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.data.IQCircleMessageFacadeListener;
import com.tencent.mobileqq.qcircle.api.data.QCircleRecentDataInterface;
import com.tencent.mobileqq.qcircle.api.utils.EeveeRedpointUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.eevee.QCircleEeveeMananger;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StNotice;
import feedcloud.FeedCloudRead$StGetNoticeCategoriesPageReq;
import feedcloud.FeedCloudRead$StGetNoticeCategoriesPageRsp;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSMessageListBlock extends QFSBaseMessageListBlock<FeedCloudRead$StGetNoticeCategoriesPageRsp> implements IQCircleMessageFacadeListener {
    private static final String TAG = "QFSMessageListBlock";
    private boolean mNeedRefreshChatData;

    public QFSMessageListBlock(Bundle bundle) {
        super(bundle);
        HostDataTransUtils.addMsgFacadeObserver(this);
    }

    private void fillDiffInfo(List<QFSMessageItemInfo> list, boolean z16) {
        FeedCloudMeta$StNotice feedCloudMeta$StNotice;
        if (!z16 && list != null) {
            for (QFSMessageItemInfo qFSMessageItemInfo : list) {
                if (qFSMessageItemInfo != null) {
                    feedCloudMeta$StNotice = qFSMessageItemInfo.getStNotice();
                } else {
                    feedCloudMeta$StNotice = null;
                }
                if (feedCloudMeta$StNotice != null && feedCloudMeta$StNotice.noticeType.get() == 33) {
                    qFSMessageItemInfo.setNeedTop(true);
                }
            }
        }
    }

    private void hookRecordMessageCoreIndicator(BaseRequest baseRequest, boolean z16) {
        com.tencent.biz.qqcircle.immersive.report.a.a("message", "", "");
        if (!z16) {
            com.tencent.biz.qqcircle.immersive.report.a.b("message", baseRequest.getCmd(), baseRequest.getTraceId());
        }
    }

    private void notifyInMainThread() {
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.biz.qqcircle.list.bizblocks.QFSMessageListBlock.2
            @Override // java.lang.Runnable
            public void run() {
                QFSMessageListBlock.this.notifyDataSetChanged();
            }
        });
    }

    private void refreshChatData() {
        this.mNeedRefreshChatData = false;
        QLog.d(getLogTag(), 1, "refreshChatData ");
        if (RFSafeListUtils.isEmpty(getDataList())) {
            QLog.e(getLogTag(), 1, "refreshChatData dataList is empty");
            return;
        }
        q.r().N(getDataList());
        q.r().c(getDataList(), this.launchTo);
        q.r().S(getDataList());
        notifyInMainThread();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void triggerEveeRefresh(BaseRequest baseRequest) {
        FeedCloudRead$StGetNoticeCategoriesPageReq feedCloudRead$StGetNoticeCategoriesPageReq;
        boolean z16;
        if (!(baseRequest instanceof QFSMessageNoticeCategoriesRequest) || (feedCloudRead$StGetNoticeCategoriesPageReq = ((QFSMessageNoticeCategoriesRequest) baseRequest).mRequest) == null) {
            return;
        }
        if (feedCloudRead$StGetNoticeCategoriesPageReq.attach_info == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (q.r().F(this.launchTo) && z16) {
            QCircleEeveeMananger.getInstance().onSend(1003, null, null);
        }
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public Map<String, Object> getChildDaTongPageParams() {
        return q.r().w(((QFSBaseMessageListBlock) this).mInitBean);
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public String getDaTongPageId() {
        return QCircleDaTongConstant.PageId.PG_XSJ_NEW_MESSAGE_PAGE;
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSBaseMessageListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public String getEmptyHint() {
        return com.tencent.biz.qqcircle.utils.h.a(R.string.f183913kg);
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.qqcircle.bizparts.a
    public String getLogTag() {
        return TAG;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public BaseRequest getRequestWithLoadInfo(LoadInfo loadInfo, String str) {
        BaseRequest requestWithLoadInfo = super.getRequestWithLoadInfo(loadInfo, str);
        if (loadInfo.isInitState() && (requestWithLoadInfo instanceof QFSMessageNoticeCategoriesRequest)) {
            ((QFSMessageNoticeCategoriesRequest) requestWithLoadInfo).enableTransRedPointInfo();
        }
        return requestWithLoadInfo;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public String getTitle() {
        return com.tencent.biz.qqcircle.utils.h.a(R.string.f183923kh);
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSBaseMessageListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public boolean isNeedQUIBackgroundDrawable() {
        return true;
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSBaseMessageListBlock, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        if (getDataList() != null && (viewHolder instanceof BaseListBlock.BaseListVH)) {
            handleItemOnLongClick((BaseListBlock.BaseListVH) viewHolder, getDataList().get(i3), i3);
        }
        super.onBindViewHolder(viewHolder, i3);
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSBaseMessageListBlock, com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        HostDataTransUtils.removeMsgFacadeObserver(this);
        q.r().g();
        q.r().h();
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSBaseMessageListBlock, com.tencent.biz.qqcircle.bizparts.a, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        QCircleClearRedPointAction.d();
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSBaseMessageListBlock, com.tencent.biz.qqcircle.bizparts.a, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        if (this.mNeedRefreshChatData) {
            refreshChatData();
        }
        HostDataTransUtils.clearRedDotInfo();
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

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    @WorkerThread
    protected void preHandleListData(@NonNull List<QFSMessageItemInfo> list, boolean z16, boolean z17, boolean z18) {
        if (z17) {
            q.r().d(getDataList(), list, this.launchTo);
        } else {
            q.r().c(list, this.launchTo);
        }
        fillDiffInfo(list, z17);
        q.r().S(list);
    }

    @Override // com.tencent.mobileqq.qcircle.api.data.IQCircleMessageFacadeListener
    public void tryRefreshData(List<QCircleRecentDataInterface> list) {
        QLog.d(getLogTag(), 1, "tryRefreshData mIsActive = " + this.isOnResume);
        q.r().J(list);
        if (this.isOnResume) {
            refreshChatData();
            HostDataTransUtils.clearRedDotInfo();
        } else {
            this.mNeedRefreshChatData = true;
        }
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
    @WorkerThread
    public List<QFSMessageItemInfo> getListDataFromRsp(@NonNull FeedCloudRead$StGetNoticeCategoriesPageRsp feedCloudRead$StGetNoticeCategoriesPageRsp, boolean z16) {
        return q.r().u(feedCloudRead$StGetNoticeCategoriesPageRsp, z16, getLoadInfo() != null && getLoadInfo().isRefreshState());
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSBaseMessageListBlock, com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public BaseRequest getRequest(String str) {
        return new QFSMessageNoticeCategoriesRequest(str, ((QFSBaseMessageListBlock) this).mInitBean);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public void handleResponse(final boolean z16, final boolean z17, final long j3, final BaseRequest baseRequest, String str, final FeedCloudRead$StGetNoticeCategoriesPageRsp feedCloudRead$StGetNoticeCategoriesPageRsp) {
        super.handleResponse(z16, z17, j3, baseRequest, str, (String) feedCloudRead$StGetNoticeCategoriesPageRsp);
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.list.bizblocks.QFSMessageListBlock.1
            @Override // java.lang.Runnable
            public void run() {
                if (q.r().K(z16, z17, j3, feedCloudRead$StGetNoticeCategoriesPageRsp)) {
                    EeveeRedpointUtil.saveNoticeFeedListLastRspTimestamp(feedCloudRead$StGetNoticeCategoriesPageRsp.rsp_timestamp.get());
                }
                QCircleClearRedPointAction.d();
                QFSMessageListBlock.this.triggerEveeRefresh(baseRequest);
            }
        });
        if (z16 && j3 == 0) {
            hookRecordMessageCoreIndicator(baseRequest, VSNetworkHelper.isProtocolCache(str));
        }
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSBaseMessageListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public void initTitleBar(View view) {
    }
}
