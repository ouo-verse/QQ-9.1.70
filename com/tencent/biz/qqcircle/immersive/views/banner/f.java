package com.tencent.biz.qqcircle.immersive.views.banner;

import android.graphics.drawable.ColorDrawable;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.widgets.multitouchimg.QCircleMultiTouchImageView;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class f extends k<a> {
    private FeedCloudMeta$StFeed G;
    private QCircleMultiTouchImageView H;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class a extends RecyclerView.ViewHolder {
        public QCircleMultiTouchImageView E;

        public a(@NonNull QCircleMultiTouchImageView qCircleMultiTouchImageView) {
            super(qCircleMultiTouchImageView);
            this.E = qCircleMultiTouchImageView;
        }
    }

    private void v0(final int i3) {
        QCircleMultiTouchImageView qCircleMultiTouchImageView;
        if (this.G != null && (qCircleMultiTouchImageView = this.H) != null) {
            VideoReport.setElementId(qCircleMultiTouchImageView, QCircleDaTongConstant.ElementId.EM_XSJ_MULTIMEDIA);
            VideoReport.setEventDynamicParams(this.H, new IDynamicParams() { // from class: com.tencent.biz.qqcircle.immersive.views.banner.e
                @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
                public final Map getDynamicParams(String str) {
                    Map x06;
                    x06 = f.this.x0(i3, str);
                    return x06;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Map x0(int i3, String str) {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PICTURE_ID, this.G.f398449id.get());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PICTURE_INDEX, Integer.valueOf(i3 + 1));
        return buildElementParams;
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.k
    public int k0() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.G;
        if (feedCloudMeta$StFeed == null) {
            return 0;
        }
        return feedCloudMeta$StFeed.images.size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.views.banner.k
    /* renamed from: u0, reason: merged with bridge method [inline-methods] */
    public void i0(a aVar, int i3) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.G;
        if (feedCloudMeta$StFeed != null && aVar.E != null) {
            QCircleFeedPicLoader.g().loadImage(Option.obtain().setTargetView(aVar.E).setUrl(feedCloudMeta$StFeed.images.get(i3).picUrl.get()).setFailDrawable(com.tencent.biz.qqcircle.immersive.manager.d.c().d(R.drawable.naw)).setLoadingDrawable(new ColorDrawable(aVar.E.getContext().getResources().getColor(R.color.black))).setPredecode(true));
            this.H = aVar.E;
            v0(i3);
        }
    }

    public QCircleMultiTouchImageView w0() {
        return this.H;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: y0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        QCircleMultiTouchImageView qCircleMultiTouchImageView = new QCircleMultiTouchImageView(viewGroup.getContext());
        qCircleMultiTouchImageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
        return new a(qCircleMultiTouchImageView);
    }

    public void z0(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.G = feedCloudMeta$StFeed;
    }
}
