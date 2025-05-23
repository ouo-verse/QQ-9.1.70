package com.tencent.biz.qqcircle.immersive.floatingwindow.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.biz.qqcircle.immersive.adapter.m;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a extends m {
    public static int D = 1;

    private View L0(ViewGroup viewGroup, int i3) {
        QFSFloatingItemView qFSFloatingItemView = new QFSFloatingItemView(viewGroup.getContext(), i3);
        qFSFloatingItemView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        qFSFloatingItemView.setReportBean(getReportBean());
        return qFSFloatingItemView;
    }

    @Override // com.tencent.biz.qqcircle.immersive.adapter.m
    protected View D0(ViewGroup viewGroup, int i3) {
        return L0(viewGroup, i3);
    }

    @Override // com.tencent.biz.qqcircle.immersive.adapter.m, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        return D;
    }

    @Override // com.tencent.biz.qqcircle.immersive.adapter.m, com.tencent.biz.richframework.video.rfw.drive.RFWBaseVideoAdapter, com.tencent.biz.richframework.video.rfw.drive.IRFWViewPager2AdapterDrive
    public String getSourceType() {
        return QCircleDaTongConstant.PageId.PG_XSJ_SMALL_WINDOW_PLAY_PAGE;
    }
}
