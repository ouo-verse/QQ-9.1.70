package com.tencent.biz.qqcircle.immersive.views.mixfeed;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSMixFeedAlignLiveItemView extends QFSMixFeedAlignBaseItemView implements com.tencent.biz.qqcircle.immersive.scrollers.a {
    private TextView I;
    private ImageView J;
    private ImageView K;
    private ImageView L;
    private QCircleAvatarView M;
    private FrameLayout N;
    private Animatable P;
    private int Q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends QCirclePicStateListener {
        a() {
        }

        @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(LoadState loadState, Option option) {
            if (loadState.isFinishSuccess() && option.getAnimatable() != null) {
                QFSMixFeedAlignLiveItemView.this.P = option.getAnimatable();
                QFSMixFeedAlignLiveItemView.this.P.start();
            }
        }
    }

    public QFSMixFeedAlignLiveItemView(Context context) {
        super(context);
    }

    private void D0() {
        ImageView imageView = this.L;
        if (imageView != null && this.N != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams.width = ImmersiveUtils.dpToPx(58.0f);
            layoutParams.height = ImmersiveUtils.dpToPx(20.0f);
            layoutParams.topMargin = ImmersiveUtils.dpToPx(6.0f);
            layoutParams.leftMargin = ImmersiveUtils.dpToPx(6.0f);
            this.L.setLayoutParams(layoutParams);
            this.L.setScaleType(ImageView.ScaleType.CENTER_CROP);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.N.getLayoutParams();
            layoutParams2.width = -2;
            this.N.setLayoutParams(layoutParams2);
        }
    }

    private void E0() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.D;
        if (feedCloudMeta$StFeed != null && this.N != null && !TextUtils.isEmpty(feedCloudMeta$StFeed.live.liveStatusCornerPendent.button_url.get())) {
            this.N.setVisibility(0);
            this.L.setVisibility(0);
            Option loadingDrawableColor = Option.obtain().setUrl(this.D.live.liveStatusCornerPendent.button_url.get()).setRequestWidth(ImmersiveUtils.dpToPx(58.0f)).setRequestHeight(ImmersiveUtils.dpToPx(20.0f)).setTargetView(this.L).setEnableAutoDeleteLocalCache(false).setLoadingDrawableColor(0);
            loadingDrawableColor.setSupportRecycler(true);
            QCircleFeedPicLoader.g().loadImage(loadingDrawableColor, new a());
        }
    }

    private void F0() {
        ImageView imageView = this.J;
        if (imageView != null && this.K != null && this.M != null) {
            imageView.setImageDrawable(QCircleSkinHelper.getInstance().getDrawable(R.drawable.qvideo_skin_icon_general_person_secondary));
            if (this.Q != 1) {
                this.K.setVisibility(0);
                this.M.setVisibility(8);
            } else {
                this.K.setVisibility(8);
                this.M.setVisibility(0);
            }
        }
    }

    private void G0() {
        int i3;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.D;
        if (feedCloudMeta$StFeed != null && this.I != null && this.J != null) {
            if (feedCloudMeta$StFeed.visitorInfo.viewCount.get() <= 0) {
                i3 = 8;
            } else {
                i3 = 0;
            }
            this.I.setVisibility(i3);
            this.J.setVisibility(i3);
        }
    }

    private void H0() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.D;
        if (feedCloudMeta$StFeed != null && feedCloudMeta$StFeed.type.get() == 4) {
            FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = this.D;
            feedCloudMeta$StFeed2.video.playUrl.set(feedCloudMeta$StFeed2.live.room.rtmpUrl.get());
            QLog.d("QFSMixFeedAlignLiveItemView", 1, "feed type=" + this.D.type.get() + JefsClass.INDEX_URL + this.D.video.playUrl.get());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.views.mixfeed.QFSMixFeedAlignBaseItemView, com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSMixFeedAlignLiveItemView";
    }

    @Override // com.tencent.biz.qqcircle.immersive.scrollers.a
    public void pause() {
        Animatable animatable = this.P;
        if (animatable != null) {
            animatable.stop();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.scrollers.a
    public void play() {
        Animatable animatable = this.P;
        if (animatable != null) {
            animatable.start();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.mixfeed.QFSMixFeedAlignBaseItemView
    protected void q0(View view) {
        if (view == null) {
            return;
        }
        this.N = (FrameLayout) view.findViewById(R.id.v88);
        this.L = (ImageView) view.findViewById(R.id.y9p);
        this.I = (TextView) view.findViewById(R.id.slm);
        this.J = (ImageView) view.findViewById(R.id.slj);
        this.K = (ImageView) view.findViewById(R.id.sli);
        this.M = (QCircleAvatarView) view.findViewById(R.id.f85674pl);
        D0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.views.mixfeed.QFSMixFeedAlignBaseItemView, com.tencent.biz.richframework.widget.BaseWidgetView
    public void bindData(e30.b bVar, int i3) {
        super.bindData(bVar, i3);
        this.Q = this.D.feedType.get();
        G0();
        F0();
        E0();
        H0();
    }

    @Override // com.tencent.biz.qqcircle.immersive.scrollers.a
    public void a() {
    }
}
