package com.tencent.biz.qqcircle.immersive.views.mixfeed.piclayerpage;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qcircle.application.QCircleApplication;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes4.dex */
public class f extends com.tencent.biz.qqcircle.immersive.views.banner.k<a> {
    private FeedCloudMeta$StFeed G;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class a extends RecyclerView.ViewHolder {
        public ImageView E;

        public a(@NonNull ImageView imageView) {
            super(imageView);
            this.E = imageView;
        }
    }

    private Drawable u0(int i3) {
        t40.a aVar = (t40.a) l0(t40.a.class);
        if (i3 == 0 && aVar != null && aVar.getTransitionLoadingDrawable() != null) {
            return aVar.getTransitionLoadingDrawable();
        }
        return QCircleApplication.APP.getResources().getDrawable(R.drawable.trans);
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
    /* renamed from: t0, reason: merged with bridge method [inline-methods] */
    public void i0(a aVar, int i3) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.G;
        if (feedCloudMeta$StFeed != null && aVar.E != null) {
            QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(feedCloudMeta$StFeed.images.get().get(i3).picUrl.get()).setTargetView(aVar.E).setLoadingDrawable(u0(i3)).setPredecode(true));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: v0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        ImageView imageView = new ImageView(viewGroup.getContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
        return new a(imageView);
    }

    public void w0(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.G = feedCloudMeta$StFeed;
    }
}
