package com.tencent.biz.qqcircle.adapter;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.beans.QFSCommentAreaTabItemInfo;
import com.tencent.biz.qqcircle.comment.widget.QFSCommentAreaLikePushItemView;
import com.tencent.biz.qqcircle.widgets.QCircleHostPushListHeadWidget;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class q extends MultiViewBlock<QFSCommentAreaTabItemInfo> {
    private int C;

    /* renamed from: m, reason: collision with root package name */
    private com.tencent.biz.qqcircle.viewmodels.m f82661m;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    private static class a extends RecyclerView.ViewHolder {
        public a(@NonNull View view) {
            super(view);
        }

        public void l(QFSCommentAreaTabItemInfo qFSCommentAreaTabItemInfo, int i3) {
            View view = this.itemView;
            if (view instanceof BaseWidgetView) {
                BaseWidgetView baseWidgetView = (BaseWidgetView) view;
                baseWidgetView.setData(qFSCommentAreaTabItemInfo, i3);
                if (qFSCommentAreaTabItemInfo != null) {
                    baseWidgetView.setTag(R.id.f52332_i, Boolean.valueOf(qFSCommentAreaTabItemInfo.getNeedTopAnimation()));
                }
            }
        }
    }

    public q(Bundle bundle) {
        super(bundle);
    }

    private String getLogTag() {
        return "QFSCommentAreaTabVPAdapter";
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        List<E> list = this.mDataList;
        if (list == 0) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        List<E> list = this.mDataList;
        if (list != 0 && list.size() > i3) {
            QFSCommentAreaTabItemInfo qFSCommentAreaTabItemInfo = (QFSCommentAreaTabItemInfo) this.mDataList.get(i3);
            if (qFSCommentAreaTabItemInfo != null) {
                return qFSCommentAreaTabItemInfo.getItemViewType();
            }
            return 0;
        }
        return this.C;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public LoadInfo getLoadInfo() {
        return super.getLoadInfo();
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public int getViewTypeCount() {
        return 2;
    }

    public void i0(com.tencent.biz.qqcircle.viewmodels.m mVar) {
        this.f82661m = mVar;
    }

    public void j0(int i3) {
        this.C = i3;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadMoreData(LoadInfo loadInfo) {
        super.loadMoreData(loadInfo);
        QLog.d(getLogTag(), 1, "loadMoreData");
        if (!loadInfo.isFinish() && loadInfo.isLoadMoreState()) {
            com.tencent.biz.qqcircle.viewmodels.m mVar = this.f82661m;
            if (mVar == null) {
                QLog.d(getLogTag(), 1, "loadMore viewModel is null. ");
                return;
            }
            int i3 = this.C;
            if (i3 == 1) {
                mVar.a2(null, true, null, "");
                return;
            } else {
                if (i3 == 2) {
                    mVar.b2(null, true, null, "");
                    return;
                }
                return;
            }
        }
        QLog.d(getLogTag(), 1, "isFinish: " + loadInfo.isFinish() + ", isLoadMore: " + loadInfo.isLoadMoreState());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        List<E> list = this.mDataList;
        if (list != 0 && i3 <= list.size() && (viewHolder instanceof a)) {
            ((a) viewHolder).l((QFSCommentAreaTabItemInfo) this.mDataList.get(i3), i3);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        QFSCommentAreaLikePushItemView qFSCommentAreaLikePushItemView;
        if (i3 == 1) {
            QCircleHostPushListHeadWidget qCircleHostPushListHeadWidget = new QCircleHostPushListHeadWidget(viewGroup.getContext());
            qCircleHostPushListHeadWidget.setPushRocketDrawer(QCircleSkinHelper.getInstance().getDrawable(viewGroup.getContext(), R.drawable.qvideo_skin_rocketpanel_icon_rocket));
            qFSCommentAreaLikePushItemView = qCircleHostPushListHeadWidget;
        } else {
            qFSCommentAreaLikePushItemView = new QFSCommentAreaLikePushItemView(viewGroup.getContext());
        }
        qFSCommentAreaLikePushItemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        return new a(qFSCommentAreaLikePushItemView);
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
    }
}
