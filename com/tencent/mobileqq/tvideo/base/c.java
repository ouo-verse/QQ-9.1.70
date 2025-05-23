package com.tencent.mobileqq.tvideo.base;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qqcircle.immersive.adapter.m;
import com.tencent.biz.qqcircle.widgets.feed.QCircleDefaultFeedItemView;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.mobileqq.tvideo.ad.QFSLayerTVideoFeedAdView;
import com.tencent.mobileqq.tvideo.view.QFSLayerTVideoFeedItemView;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c extends m {

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a extends v30.a {
        a() {
        }

        @Override // v30.a, androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(@NonNull e30.b bVar, @NonNull e30.b bVar2) {
            if (bVar.g() == bVar2.g()) {
                return true;
            }
            return false;
        }

        @Override // v30.a, androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b */
        public boolean areItemsTheSame(@NonNull e30.b bVar, @NonNull e30.b bVar2) {
            if (bVar.g() != bVar2.g() && !d(bVar2)) {
                return false;
            }
            return true;
        }

        @Override // v30.a
        public boolean c(@NonNull e30.b bVar, @NonNull e30.b bVar2) {
            return false;
        }

        public boolean d(@NonNull e30.b bVar) {
            if (bVar.g() == null) {
                return false;
            }
            return bVar.g().f398449id.get().contains("tvideo_feed_id_replace_");
        }
    }

    public c(Fragment fragment) {
        super(fragment);
    }

    private View L0(ViewGroup viewGroup, int i3) {
        QFSLayerTVideoFeedAdView qFSLayerTVideoFeedAdView = new QFSLayerTVideoFeedAdView(viewGroup.getContext(), i3);
        qFSLayerTVideoFeedAdView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        qFSLayerTVideoFeedAdView.setReportBean(getReportBean());
        return qFSLayerTVideoFeedAdView;
    }

    private View M0(ViewGroup viewGroup, int i3) {
        QFSLayerTVideoFeedItemView qFSLayerTVideoFeedItemView = new QFSLayerTVideoFeedItemView(viewGroup.getContext(), i3);
        qFSLayerTVideoFeedItemView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        qFSLayerTVideoFeedItemView.setReportBean(getReportBean());
        return qFSLayerTVideoFeedItemView;
    }

    private View o0(ViewGroup viewGroup, int i3) {
        QCircleDefaultFeedItemView qCircleDefaultFeedItemView = new QCircleDefaultFeedItemView(viewGroup.getContext(), i3);
        qCircleDefaultFeedItemView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return qCircleDefaultFeedItemView;
    }

    @Override // com.tencent.biz.qqcircle.immersive.adapter.m
    protected View D0(ViewGroup viewGroup, int i3) {
        if (i3 != 10001) {
            if (i3 != 10002) {
                return o0(viewGroup, i3);
            }
            return L0(viewGroup, i3);
        }
        return M0(viewGroup, i3);
    }

    @Override // com.tencent.biz.qqcircle.immersive.adapter.m
    public boolean E0() {
        if (getNUM_BACKGOURND_ICON() == 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.qqcircle.immersive.adapter.m, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    protected DiffUtil.ItemCallback<e30.b> getDiffCallBack() {
        return new a();
    }

    @Override // com.tencent.biz.qqcircle.immersive.adapter.m, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        if (jy2.g.v(getItem(i3))) {
            return 10002;
        }
        return 10001;
    }

    @Override // com.tencent.biz.qqcircle.immersive.adapter.a, com.tencent.biz.richframework.video.rfw.drive.IRFWViewPager2AdapterDrive
    public int getSceneId() {
        return QCircleHostConstants._SceneID.TENCENT_VIDEO_PLAYER();
    }

    @Override // com.tencent.biz.qqcircle.immersive.adapter.m, com.tencent.biz.qqcircle.immersive.adapter.a
    @NonNull
    public RecyclerView.ViewHolder onCreateItemViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        return new m.b(D0(viewGroup, i3));
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.RFWBaseVideoAdapter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedSelected(rFWFeedSelectInfo);
    }
}
