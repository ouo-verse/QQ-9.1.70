package com.qzone.reborn.feedx.widget.ad;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class QZoneAdFeedxCarouselCardVideoWidgetView extends QZoneAdVideoItemWidgetView {

    /* renamed from: o0, reason: collision with root package name */
    private int f55967o0;

    /* renamed from: p0, reason: collision with root package name */
    private int f55968p0;

    /* renamed from: q0, reason: collision with root package name */
    private boolean f55969q0;

    public QZoneAdFeedxCarouselCardVideoWidgetView(Context context, int i3, int i16) {
        super(context);
        this.f55967o0 = i3;
        this.f55968p0 = i16;
        ImageView imageView = this.G;
        if (imageView != null) {
            imageView.setImageResource(R.drawable.f15538f);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.feedx.widget.picmixvideo.QZoneVideoItemWidgetView
    public void F0() {
        ViewGroup.LayoutParams layoutParams = this.E.getLayoutParams();
        int i3 = this.f55967o0;
        layoutParams.width = i3;
        int i16 = this.f55968p0;
        layoutParams.height = i16;
        i1(this.F, i3, i16);
        i1(this.E, layoutParams.width, layoutParams.height);
        QLog.i("PSLink-QZoneAdFeedxCarouselCardVideoWidgetView", 2, "[adjustViewSize]  | position = " + this.f56455f + " | videoWidth = " + this.D.width + " | videoHeight = " + this.D.height + " | realWidth = " + layoutParams.width + " | realHeight = " + layoutParams.height);
        this.f56457i.setRadius(0.0f);
    }

    @Override // com.qzone.reborn.feedx.widget.ad.QZoneAdVideoItemWidgetView, com.qzone.reborn.feedx.widget.picmixvideo.QZoneVideoItemWidgetView
    protected boolean X0() {
        return this.f55969q0;
    }

    @Override // com.qzone.reborn.feedx.widget.ad.QZoneAdVideoItemWidgetView, com.qzone.reborn.feedx.widget.picmixvideo.QZoneVideoItemWidgetView, gf.r
    public void a() {
        this.D.playType = G1(false);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[releasePlayer] playType:");
        VideoInfo videoInfo = this.D;
        sb5.append((int) (videoInfo != null ? videoInfo.playType : (byte) -2147483648));
        QLog.i("PSLink-QZoneAdFeedxCarouselCardVideoWidgetView", 2, sb5.toString());
        super.a();
    }

    @Override // com.qzone.reborn.feedx.widget.picmixvideo.QZoneVideoItemWidgetView, com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.chq;
    }

    @Override // com.qzone.reborn.feedx.widget.ad.QZoneAdVideoItemWidgetView, com.qzone.reborn.feedx.widget.picmixvideo.QZoneVideoItemWidgetView, gf.r
    public void pause() {
        this.D.playType = G1(false);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[pause] playType:");
        VideoInfo videoInfo = this.D;
        sb5.append((int) (videoInfo != null ? videoInfo.playType : (byte) -2147483648));
        QLog.i("PSLink-QZoneAdFeedxCarouselCardVideoWidgetView", 2, sb5.toString());
        super.pause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.feedx.widget.picmixvideo.QZoneVideoItemWidgetView
    public void j1(boolean z16) {
        super.j1(false);
    }

    @Override // com.qzone.reborn.feedx.widget.ad.QZoneAdVideoItemWidgetView, com.qzone.reborn.feedx.widget.picmixvideo.QZoneVideoItemWidgetView, gf.r
    public void play() {
        H1(false);
    }

    private static byte G1(boolean z16) {
        return (z16 || i.H().m()) ? (byte) 1 : (byte) 0;
    }

    public void H1(boolean z16) {
        boolean z17 = z16 || this.f55983n0;
        VideoInfo videoInfo = this.D;
        if (videoInfo != null) {
            videoInfo.playType = G1(z17);
        }
        this.f55969q0 = z17;
        super.play();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[play] forced:");
        sb5.append(z17);
        sb5.append(" playType:");
        VideoInfo videoInfo2 = this.D;
        sb5.append((int) (videoInfo2 != null ? videoInfo2.playType : (byte) -2147483648));
        QLog.i("PSLink-QZoneAdFeedxCarouselCardVideoWidgetView", 2, sb5.toString());
    }
}
