package com.tencent.biz.qqcircle.list.bizblocks;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QFSMessageItemInfo;
import com.tencent.biz.qqcircle.events.QFSMessageLoadEmptyBlockEvent;
import com.tencent.biz.qqcircle.helpers.q;
import com.tencent.biz.qqcircle.requests.QFSMessageNoticeCategoriesRequest;
import com.tencent.biz.qqcircle.richframework.part.list.base.PublicListInnerFragment;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudRead$StGetNoticeCategoriesPageRsp;
import java.util.List;

/* loaded from: classes4.dex */
public class QFSPrivateMessageListBlock extends QFSMessageListBlock {
    private static final String TAG = "QFSPrivateMessageListBlock";
    private boolean emptyBlockLoaded;

    /* loaded from: classes4.dex */
    class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i3) {
            com.tencent.biz.qqcircle.j.f().e();
        }
    }

    public QFSPrivateMessageListBlock(Bundle bundle) {
        super(bundle);
        this.emptyBlockLoaded = false;
    }

    private void loadEmptyBlock() {
        QLog.d(getLogTag(), 1, "[loadEmptyBlock]");
        this.emptyBlockLoaded = true;
        SimpleEventBus.getInstance().dispatchEvent(new QFSMessageLoadEmptyBlockEvent(true, "0"));
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.list.bizblocks.QFSPrivateMessageListBlock.1
            @Override // java.lang.Runnable
            public void run() {
                QFSPrivateMessageListBlock.this.notifyAfterHandleListData(true, false, true);
                PublicListInnerFragment hostFragment = QFSPrivateMessageListBlock.this.getHostFragment();
                if (hostFragment != null) {
                    hostFragment.Gh();
                }
            }
        });
    }

    private void unloadEmptyBlock() {
        QLog.d(getLogTag(), 1, "[unloadEmptyBlock]");
        this.emptyBlockLoaded = false;
        SimpleEventBus.getInstance().dispatchEvent(new QFSMessageLoadEmptyBlockEvent(false, ""));
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.list.bizblocks.QFSPrivateMessageListBlock.2
            @Override // java.lang.Runnable
            public void run() {
                PublicListInnerFragment hostFragment = QFSPrivateMessageListBlock.this.getHostFragment();
                if (hostFragment != null) {
                    hostFragment.vh();
                }
            }
        });
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSMessageListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.qqcircle.bizparts.a
    public String getLogTag() {
        return TAG;
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSMessageListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public String getTitle() {
        return com.tencent.biz.qqcircle.utils.h.a(R.string.f184393lr);
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public void handleListData(@NonNull List<QFSMessageItemInfo> list, boolean z16, boolean z17, boolean z18) {
        Object obj;
        String logTag = getLogTag();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[handleListData] fromCache: ");
        sb5.append(z16);
        sb5.append(" | isLoadMore: ");
        sb5.append(z17);
        sb5.append(" | isFinish: ");
        sb5.append(z18);
        sb5.append(" | launchTo: ");
        QCircleInitBean qCircleInitBean = ((QFSBaseMessageListBlock) this).mInitBean;
        if (qCircleInitBean != null) {
            obj = Integer.valueOf(qCircleInitBean.getLaunchTo());
        } else {
            obj = "-1";
        }
        sb5.append(obj);
        sb5.append(" | size: ");
        sb5.append(list.size());
        boolean z19 = true;
        QLog.d(logTag, 1, sb5.toString());
        boolean a16 = com.tencent.biz.qqcircle.utils.n.a();
        if (!list.isEmpty() || !q.r().s().isEmpty()) {
            z19 = false;
        }
        if (!a16 && z19 && !z16 && !z17 && z18) {
            if (!this.emptyBlockLoaded) {
                loadEmptyBlock();
            }
        } else {
            unloadEmptyBlock();
            super.handleListData(list, z16, z17, z18);
        }
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSBaseMessageListBlock, com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
        super.onInitBlock(bundle);
        NestScrollRecyclerView nestScrollRecyclerView = ((QFSBaseMessageListBlock) this).mRecyclerView;
        if (nestScrollRecyclerView != null) {
            nestScrollRecyclerView.addOnScrollListener(new a());
        }
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSMessageListBlock, com.tencent.biz.qqcircle.list.bizblocks.QFSBaseMessageListBlock, com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public /* bridge */ /* synthetic */ void onPartSaveInstanceState(Activity activity, Bundle bundle) {
        com.tencent.biz.richframework.part.b.e(this, activity, bundle);
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSMessageListBlock, com.tencent.biz.qqcircle.list.bizblocks.QFSBaseMessageListBlock, com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public /* bridge */ /* synthetic */ void onPartStart(Activity activity) {
        com.tencent.biz.richframework.part.b.f(this, activity);
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSMessageListBlock, com.tencent.biz.qqcircle.list.bizblocks.QFSBaseMessageListBlock, com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public /* bridge */ /* synthetic */ void onPartStop(Activity activity) {
        com.tencent.biz.richframework.part.b.g(this, activity);
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSMessageListBlock, com.tencent.biz.qqcircle.list.bizblocks.QFSBaseMessageListBlock, com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    @WorkerThread
    public List<QFSMessageItemInfo> getListDataFromRsp(@NonNull FeedCloudRead$StGetNoticeCategoriesPageRsp feedCloudRead$StGetNoticeCategoriesPageRsp, boolean z16) {
        return q.r().v(feedCloudRead$StGetNoticeCategoriesPageRsp, z16, getLoadInfo() != null && getLoadInfo().isRefreshState(), null);
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSMessageListBlock, com.tencent.biz.qqcircle.list.bizblocks.QFSBaseMessageListBlock, com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public BaseRequest getRequest(String str) {
        return new QFSMessageNoticeCategoriesRequest(str, ((QFSBaseMessageListBlock) this).mInitBean, this.mDrawerId, 0);
    }
}
