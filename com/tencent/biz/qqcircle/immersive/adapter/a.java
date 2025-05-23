package com.tencent.biz.qqcircle.immersive.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.part.TagData;
import com.tencent.biz.richframework.video.rfw.drive.RFWBaseVideoAdapter;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleReportBean;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class a<E> extends RFWBaseVideoAdapter<E> {
    public a() {
    }

    private Object getViewTagData() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            return null;
        }
        return ab0.b.a(TagData.TAG_DATA_ID, recyclerView);
    }

    public QCircleReportBean getReportBean() {
        Object viewTagData = getViewTagData();
        if (!(viewTagData instanceof QCircleReportBean)) {
            QLog.e("QFSBaseListViewAdapter", 1, "getReportBean but FSReportBean is null");
            return new QCircleReportBean();
        }
        return (QCircleReportBean) viewTagData;
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWViewPager2AdapterDrive
    public int getSceneId() {
        return QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO();
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.RFWBaseVideoAdapter, com.tencent.biz.richframework.video.rfw.drive.IRFWViewPager2AdapterDrive
    public String getUniquePageId() {
        return String.valueOf(getReportBean().getPageId());
    }

    @NonNull
    public abstract RecyclerView.ViewHolder onCreateItemViewHolder(@NonNull ViewGroup viewGroup, int i3);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        RecyclerView.ViewHolder onCreateItemViewHolder = onCreateItemViewHolder(viewGroup, i3);
        if (onCreateItemViewHolder != null) {
            View view = onCreateItemViewHolder.itemView;
            if (view instanceof BaseWidgetView) {
                ((BaseWidgetView) view).setParentView(viewGroup);
            }
        }
        return onCreateItemViewHolder;
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.RFWBaseVideoAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@NonNull RecyclerView.ViewHolder viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
        View view = viewHolder.itemView;
        if (!(view instanceof QCircleBaseWidgetView)) {
            return;
        }
        ((QCircleBaseWidgetView) view).setCacheReportBean(getReportBean());
    }

    public a(Fragment fragment) {
        super(fragment);
    }
}
