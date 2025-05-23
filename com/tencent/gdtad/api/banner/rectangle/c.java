package com.tencent.gdtad.api.banner.rectangle;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.ad.tangram.AdError;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.video.GdtVideoData;
import com.tencent.gdtad.views.video.GdtVideoView;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes6.dex */
public final class c extends a implements GdtVideoView.GdtVideoListener {
    private GdtVideoView E;

    public c(Context context, GdtHandler.Params params) {
        super(context, params);
    }

    private void q(boolean z16) {
        if (this.E == null) {
            return;
        }
        GdtLog.d("GdtBannerViewWithOneVideo", "notifyVideoViewVisible:" + z16);
        this.E.setVideoViewVisible(z16);
        r(z16);
    }

    private void r(boolean z16) {
        GdtVideoView gdtVideoView = this.E;
        if (gdtVideoView != null) {
            if (z16) {
                gdtVideoView.play(false);
            } else {
                gdtVideoView.pause(false);
            }
        }
    }

    @Override // com.tencent.gdtad.api.banner.rectangle.a, com.tencent.gdtad.api.GdtAdView
    public void destroy(Context context) {
        super.destroy(context);
        r(false);
        GdtVideoView gdtVideoView = this.E;
        if (gdtVideoView != null) {
            gdtVideoView.destroy();
        }
    }

    @Override // com.tencent.gdtad.api.banner.rectangle.a
    protected View g(Context context, GdtHandler.Params params) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = -5;
        layoutParams.addRule(9);
        GdtVideoData gdtVideoData = new GdtVideoData();
        gdtVideoData.setUrl(params.f108486ad.getVideoUrl());
        gdtVideoData.setStartPositionMillis(0L);
        gdtVideoData.setLoop(true);
        gdtVideoData.setVolumOpen(false);
        gdtVideoData.setVisibleDirectPlay(true);
        gdtVideoData.setAd(params.f108486ad);
        gdtVideoData.setVideoDefaultBackgroundColor(0);
        gdtVideoData.setCoverUrl(params.f108486ad.getBasic_img());
        GdtVideoView gdtVideoView = new GdtVideoView(context, gdtVideoData);
        this.E = gdtVideoView;
        gdtVideoView.addVideoListener(new WeakReference<>(this));
        this.E.setId(R.id.f165339vm2);
        addView(this.E, layoutParams);
        return this.E;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        q(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        q(false);
    }

    @Override // com.tencent.gdtad.views.video.GdtVideoView.GdtVideoListener
    public void onError(AdError adError) {
        GdtLog.e("GdtBannerViewWithOneVideo", "video onError :" + adError);
    }

    @Override // com.tencent.gdtad.api.banner.rectangle.a, com.tencent.gdtad.api.GdtAdView
    public void pause(Context context) {
        super.pause(context);
        QLog.d("GdtBannerViewWithOneVideo", 1, "pause: pause video");
        r(false);
    }

    @Override // android.view.View
    public boolean performClick() {
        GdtVideoView gdtVideoView = this.E;
        if (gdtVideoView != null) {
            gdtVideoView.click();
        }
        return super.performClick();
    }

    @Override // com.tencent.gdtad.api.banner.rectangle.a, com.tencent.gdtad.api.GdtAdView
    public void resume(Context context) {
        super.resume(context);
        if (com.tencent.mobileqq.ad.cardad.utils.d.f186735a.c(this, false) == 0.0d) {
            QLog.d("GdtBannerViewWithOneVideo", 1, "resume: invisible");
        } else {
            QLog.d("GdtBannerViewWithOneVideo", 1, "resume: start video");
            r(true);
        }
    }

    @Override // com.tencent.gdtad.api.banner.rectangle.a, com.tencent.gdtad.api.GdtAdView
    public View getView() {
        return this;
    }

    @Override // com.tencent.gdtad.views.video.GdtVideoView.GdtVideoListener
    public void onCompletion() {
    }

    @Override // com.tencent.gdtad.views.video.GdtVideoView.GdtVideoListener
    public void onCurrentLoopStart() {
    }

    @Override // com.tencent.gdtad.views.video.GdtVideoView.GdtVideoListener
    public void onFirstFrameRendered() {
    }

    @Override // com.tencent.gdtad.views.video.GdtVideoView.GdtVideoListener
    public void onFirstTimeLoopEnd() {
    }

    @Override // com.tencent.gdtad.views.video.GdtVideoView.GdtVideoListener
    public void onVideoPrepared() {
    }
}
