package com.tencent.biz.qqcircle.immersive.views.banner;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.utils.v;
import com.tencent.libra.decode.LibraRequestKey;
import com.tencent.libra.download.LibraDownloadKey;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.qcircle.api.utils.QCircleDeviceInfoUtils;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StImage;

/* compiled from: P */
/* loaded from: classes4.dex */
public class i extends k<a> {
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

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.k
    public boolean isCanLoop() {
        if (uq3.c.G()) {
            if (k0() > 0 && n0() && !m0()) {
                return true;
            }
            return false;
        }
        return super.isCanLoop();
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
        DecodeFormat decodeFormat;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.G;
        if (feedCloudMeta$StFeed != null && aVar.E != null) {
            FeedCloudMeta$StImage feedCloudMeta$StImage = feedCloudMeta$StFeed.images.get().get(i3);
            aVar.E.setScaleType(v.a(feedCloudMeta$StImage.width.get(), feedCloudMeta$StImage.height.get()));
            Option supportRecycler = Option.obtain().setUrl(feedCloudMeta$StImage.picUrl.get()).setTargetView(aVar.E).setNeedShowLoadingDrawable(false).setPredecode(true).setSupportRecycler(true);
            if (QCircleDeviceInfoUtils.isLowDevice()) {
                decodeFormat = DecodeFormat.PREFER_RGB_565;
            } else {
                decodeFormat = DecodeFormat.PREFER_ARGB_8888;
            }
            Option preferDecodeFormat = supportRecycler.setPreferDecodeFormat(decodeFormat);
            preferDecodeFormat.setCacheKey(new LibraRequestKey.Builder(new LibraDownloadKey(QCircleFeedPicLoader.g().getPicLocalPath(preferDecodeFormat))).build());
            QCircleFeedPicLoader.g().loadImage(preferDecodeFormat);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: u0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        ImageView imageView = new ImageView(viewGroup.getContext());
        imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
        return new a(imageView);
    }

    public void v0(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.G = feedCloudMeta$StFeed;
    }
}
