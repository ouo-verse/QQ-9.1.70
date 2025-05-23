package com.tencent.biz.qqcircle.list.bizblocks;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qcircleshadow.lib.QCircleHostDropFrameMonitorHelper;
import com.tencent.biz.qqcircle.list.QCircleBaseListBlock;
import com.tencent.biz.qqcircle.requests.QCircleGetCircleUnCareListRequest;
import com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock;
import com.tencent.biz.qqcircle.widgets.QCircleBlackListItemView;
import com.tencent.biz.richframework.compat.RFWThemeUtil;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.idata.IDataCallBack;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import feedcloud.FeedCloudMeta$StUser;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCircleRight$GetCircleUnCareListRsp;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleBlackListBlock extends QCircleBaseListBlock<FeedCloudMeta$StUser, QQCircleRight$GetCircleUnCareListRsp> {
    private static final int LOAD_COUNT_PER_PAGE = 20;
    private static final String TAG = "QCircleBlackListBlock";

    public QCircleBlackListBlock(Bundle bundle) {
        super(bundle);
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public String getAttachInfoFromItemData(FeedCloudMeta$StUser feedCloudMeta$StUser) {
        return null;
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public String getAttachInfoFromRsp(QQCircleRight$GetCircleUnCareListRsp qQCircleRight$GetCircleUnCareListRsp) {
        return null;
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public int getBackgroundColor() {
        return QCircleSkinHelper.getInstance().getColor(R.color.qvideo_skin_color_bg_backplate);
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public List<Part> getCustomParts() {
        return null;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public String getDropFrameMonitorTag() {
        return QCircleHostDropFrameMonitorHelper._Constants.QCIRLE_BLACK_LIST_PAGE();
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public String getEmptyHint() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock
    public String getEmptyStateActionText() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock
    public String getEmptyStateDescText() {
        return com.tencent.biz.qqcircle.utils.h.a(R.string.f181683ef);
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public boolean getIsFinishFromRsp(QQCircleRight$GetCircleUnCareListRsp qQCircleRight$GetCircleUnCareListRsp) {
        return true;
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
        return com.tencent.biz.qqcircle.utils.h.a(R.string.f181693eg);
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
        view.setBackgroundColor(getBackgroundColor());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        List<E> list = this.mDataList;
        if (list != 0) {
            ((BaseListBlock.BaseListVH) viewHolder).setData(list.get(i3), i3, this.mExtraTypeInfo);
        }
        QLog.d(TAG, 4, "onBindViewHolder:" + i3 + "  " + viewHolder + "  " + this);
        if (!(viewHolder.itemView instanceof QCircleBlackListItemView)) {
            return;
        }
        if (getNUM_BACKGOURND_ICON() == 1) {
            ((QCircleBlackListItemView) viewHolder.itemView).setItemBGType(0);
            return;
        }
        if (i3 == 0) {
            ((QCircleBlackListItemView) viewHolder.itemView).setItemBGType(1);
        } else if (i3 == getNUM_BACKGOURND_ICON() - 1) {
            ((QCircleBlackListItemView) viewHolder.itemView).setItemBGType(3);
        } else {
            ((QCircleBlackListItemView) viewHolder.itemView).setItemBGType(2);
        }
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a
    @NonNull
    public RecyclerView.ViewHolder onCreateItemViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        return new BaseListBlock.BaseListVH(new QCircleBlackListItemView(getParentFragment().getActivity()));
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
        super.onInitBlock(bundle);
        getBlockMerger().setNoMoreHint(RFWApplication.getApplication().getString(R.string.f188443wp, Integer.valueOf(QCircleGetCircleUnCareListRequest.MAX_NUM)));
        QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(11).setSubActionType(40).setThrActionType(1));
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        QLog.d(TAG, 4, "onPartResume");
        RFWThemeUtil.setStatusBarColor(getActivity(), QCircleSkinHelper.getInstance().getColor(R.color.qvideo_skin_color_bg_backplate));
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
    public List<FeedCloudMeta$StUser> getListDataFromRsp(QQCircleRight$GetCircleUnCareListRsp qQCircleRight$GetCircleUnCareListRsp, boolean z16) {
        List<FeedCloudMeta$StUser> list = qQCircleRight$GetCircleUnCareListRsp.userlist.get();
        Iterator<FeedCloudMeta$StUser> it = list.iterator();
        while (it.hasNext()) {
            it.next().blackState.set(1);
        }
        return list;
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public BaseRequest getRequest(String str) {
        return new QCircleGetCircleUnCareListRequest(1);
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public void getListDataAsync(IDataCallBack<FeedCloudMeta$StUser> iDataCallBack, String str) {
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public void onTitleTabSelectedChanged(View view, boolean z16) {
    }
}
