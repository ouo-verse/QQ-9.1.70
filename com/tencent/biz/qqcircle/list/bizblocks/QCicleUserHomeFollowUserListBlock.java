package com.tencent.biz.qqcircle.list.bizblocks;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.beans.QCircleFollowUserBean;
import com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock;
import com.tencent.biz.qqcircle.widgets.QCircleFollowUserListItemView;
import com.tencent.mobileqq.R;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudRead$StGetRecomUserListRsp;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCicleUserHomeFollowUserListBlock extends QCircleFollowUserListBlock {
    public QCicleUserHomeFollowUserListBlock(Bundle bundle) {
        super(bundle);
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QCircleFollowUserListBlock, com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public String getAttachInfoFromRsp(FeedCloudRead$StGetRecomUserListRsp feedCloudRead$StGetRecomUserListRsp) {
        return null;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public String getDaTongPageId() {
        return QCircleDaTongConstant.PageId.PG_XSJ_RELATED_FRIENDS_PAGE;
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QCircleFollowUserListBlock, com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public boolean getIsFinishFromRsp(FeedCloudRead$StGetRecomUserListRsp feedCloudRead$StGetRecomUserListRsp) {
        return true;
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QCircleFollowUserListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public String getTitle() {
        Serializable serializable;
        if (this.mUser == null && (serializable = this.mInitBean) != null && (serializable instanceof QCircleFollowUserBean)) {
            this.mUser = ((QCircleFollowUserBean) serializable).getUser();
            this.mListType = ((QCircleFollowUserBean) this.mInitBean).getListType();
        }
        if (this.mListType == 5) {
            return com.tencent.biz.qqcircle.utils.h.a(R.string.f183593jl);
        }
        return com.tencent.biz.qqcircle.utils.h.a(R.string.f183373j0);
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QCircleFollowUserListBlock, com.tencent.biz.qqcircle.bizparts.a
    @NonNull
    public RecyclerView.ViewHolder onCreateItemViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        return new BaseListBlock.BaseListVH(new QCircleFollowUserListItemView(getParentFragment().getActivity(), this.mUin, 0));
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QCircleFollowUserListBlock, com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
        super.onInitBlock(bundle);
        QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(11).setSubActionType(28).setThrActionType(1));
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QCircleFollowUserListBlock, com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public /* bridge */ /* synthetic */ void onPartSaveInstanceState(Activity activity, Bundle bundle) {
        com.tencent.biz.richframework.part.b.e(this, activity, bundle);
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QCircleFollowUserListBlock, com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public /* bridge */ /* synthetic */ void onPartStart(Activity activity) {
        com.tencent.biz.richframework.part.b.f(this, activity);
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QCircleFollowUserListBlock, com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public /* bridge */ /* synthetic */ void onPartStop(Activity activity) {
        com.tencent.biz.richframework.part.b.g(this, activity);
    }
}
