package com.qzone.component.banner.general.view;

import android.content.Context;
import android.util.AttributeSet;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.reborn.feedx.video.view.QZoneVideoView;
import com.qzone.reborn.feedx.widget.picmixvideo.QZoneFeedxSingleVideoWidgetView;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes39.dex */
public class GeneralBigCardVideoView extends QZoneFeedxSingleVideoWidgetView {

    /* renamed from: a0, reason: collision with root package name */
    private boolean f46604a0;

    public GeneralBigCardVideoView(Context context) {
        super(context);
    }

    @Override // com.qzone.reborn.feedx.widget.picmixvideo.QZoneVideoItemWidgetView
    protected boolean X0() {
        return this.f46604a0;
    }

    @Override // com.qzone.reborn.feedx.widget.picmixvideo.QZoneVideoItemWidgetView
    protected boolean Z0() {
        return true;
    }

    @Override // com.qzone.reborn.feedx.widget.picmixvideo.QZoneVideoItemWidgetView, com.qzone.reborn.feedx.widget.picmixvideo.QZoneMixBaseWidgetView
    protected String getLogTag() {
        return "GeneralBigCardVideoView";
    }

    public boolean isPlaying() {
        QZoneVideoView qZoneVideoView = this.E;
        return (qZoneVideoView == null || qZoneVideoView.getSuperPlayer() == null || !this.E.getSuperPlayer().isPlaying()) ? false : true;
    }

    public void m1(boolean z16) {
        this.f46604a0 = z16;
        super.play();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[play] forced:");
        sb5.append(z16);
        sb5.append(" playType:");
        VideoInfo videoInfo = this.D;
        sb5.append((int) (videoInfo != null ? videoInfo.playType : (byte) -2147483648));
        QLog.i("GeneralBigCardVideoView", 2, sb5.toString());
    }

    public GeneralBigCardVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.qzone.reborn.feedx.widget.picmixvideo.QZoneVideoItemWidgetView, gf.r
    public void play() {
        m1(false);
    }
}
