package com.tencent.biz.qqcircle.list.bizblocks;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qcircleshadow.lib.QCircleHostDropFrameMonitorHelper;
import com.tencent.biz.qqcircle.beans.QCircleFollowUserBean;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.list.QCircleBaseListBlock;
import com.tencent.biz.qqcircle.requests.QCircleGetRecomUserListRequest;
import com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.qqcircle.widgets.QCircleFollowUserListItemView;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.richframework.data.idata.IDataCallBack;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import feedcloud.FeedCloudMeta$StUser;
import feedcloud.FeedCloudMeta$StUserRecomInfo;
import feedcloud.FeedCloudRead$StGetRecomUserListRsp;
import java.io.Serializable;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleFollowUserListBlock extends QCircleBaseListBlock<FeedCloudMeta$StUserRecomInfo, FeedCloudRead$StGetRecomUserListRsp> {
    private static final int LOAD_COUNT_PER_PAGE = 20;
    private static final String TAG = "QCircleFollowUserListBlock";
    protected int mListType;
    protected String mUin;
    protected FeedCloudMeta$StUser mUser;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
            if (i3 == 0) {
                VideoReport.traverseExposure();
            }
        }
    }

    public QCircleFollowUserListBlock(Bundle bundle) {
        super(bundle);
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public String getAttachInfoFromItemData(FeedCloudMeta$StUserRecomInfo feedCloudMeta$StUserRecomInfo) {
        return null;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public List<Part> getCustomParts() {
        return null;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public String getDropFrameMonitorTag() {
        return QCircleHostDropFrameMonitorHelper._Constants.QCIRCLE_FOLLOW_USER_LIST();
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public String getEmptyHint() {
        return null;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.qqcircle.bizparts.a
    public String getLogTag() {
        return TAG;
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public int getPageCount() {
        return 20;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public String getTitle() {
        return com.tencent.biz.qqcircle.utils.h.a(R.string.f183363iz);
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public View getTitleTabView(ViewGroup viewGroup) {
        return null;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public void initTitleBar(View view) {
        if (view == null) {
            return;
        }
        view.setBackgroundColor(QFSQUIUtilsKt.d(view.getContext(), R.color.qui_common_bg_bottom_standard));
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public boolean isNeedQUIColor() {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        List<E> list = this.mDataList;
        if (list != 0) {
            ((BaseListBlock.BaseListVH) viewHolder).setData(list.get(i3), i3, this.mExtraTypeInfo);
        }
        QLog.d(TAG, 4, "onBindViewHolder:" + i3 + "  " + viewHolder + "  " + this);
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a
    @NonNull
    public RecyclerView.ViewHolder onCreateItemViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        return new BaseListBlock.BaseListVH(new QCircleFollowUserListItemView(getParentFragment().getActivity(), this.mUin, 1));
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
        super.onInitBlock(bundle);
        Serializable serializable = this.mInitBean;
        if (serializable instanceof QCircleInitBean) {
            QCircleInitBean qCircleInitBean = (QCircleInitBean) serializable;
            if (qCircleInitBean.getUser() != null && !TextUtils.isEmpty(qCircleInitBean.getUser().f398463id.get())) {
                this.mUser = qCircleInitBean.getUser();
                this.mUin = qCircleInitBean.getUser().f398463id.get();
                this.mListType = ((QCircleFollowUserBean) this.mInitBean).getListType();
            }
        }
        QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(11).setSubActionType(30).setThrActionType(1));
        if (getBlockContainer() == null && getBlockContainer().getRecyclerView() == null) {
            return;
        }
        getBlockContainer().getRecyclerView().addOnScrollListener(new a());
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        QFSQUIUtilsKt.h(activity);
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

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public String getAttachInfoFromRsp(FeedCloudRead$StGetRecomUserListRsp feedCloudRead$StGetRecomUserListRsp) {
        return feedCloudRead$StGetRecomUserListRsp.attachInfo.get();
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public boolean getIsFinishFromRsp(FeedCloudRead$StGetRecomUserListRsp feedCloudRead$StGetRecomUserListRsp) {
        return feedCloudRead$StGetRecomUserListRsp.isFinish.get() == 1;
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public List<FeedCloudMeta$StUserRecomInfo> getListDataFromRsp(FeedCloudRead$StGetRecomUserListRsp feedCloudRead$StGetRecomUserListRsp, boolean z16) {
        return feedCloudRead$StGetRecomUserListRsp.userRecoms.get();
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public BaseRequest getRequest(String str) {
        return new QCircleGetRecomUserListRequest(str, this.mListType, this.mUin);
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public void getListDataAsync(IDataCallBack<FeedCloudMeta$StUserRecomInfo> iDataCallBack, String str) {
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public void onTitleTabSelectedChanged(View view, boolean z16) {
    }
}
