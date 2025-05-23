package com.tencent.mobileqq.tvideo.player;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.SurfaceView;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import by2.c;
import com.tencent.biz.qqcircle.immersive.views.QFSTVKVideoView;
import com.tencent.biz.richframework.video.rfw.RFWPlayer;
import com.tencent.biz.richframework.video.rfw.view.RFWBasePlayerManager;
import com.tencent.qqlive.tvkplayer.view.TVKPlayerVideoView;
import com.tencent.superplayer.view.ISPlayerVideoView;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TVideoQFSVideoView extends QFSTVKVideoView {
    public TVideoQFSVideoView(@NonNull Context context) {
        super(context);
    }

    public boolean a1() {
        View view;
        KeyEvent.Callback videoView = getQCirclePlayer().getVideoView();
        if (videoView instanceof TVKPlayerVideoView) {
            view = ((TVKPlayerVideoView) videoView).getCurrentDisplayView();
        } else if (videoView instanceof ISPlayerVideoView) {
            view = ((ISPlayerVideoView) videoView).getRenderView();
        } else {
            view = null;
        }
        return view instanceof SurfaceView;
    }

    public void b1(ISPlayerVideoView iSPlayerVideoView) {
        RFWPlayer qCirclePlayer = getQCirclePlayer();
        if (qCirclePlayer != null && iSPlayerVideoView != null) {
            qCirclePlayer.updatePlayerVideoView(iSPlayerVideoView);
            qCirclePlayer.setPlayerVideoView(iSPlayerVideoView);
            addVideoView(null);
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.view.RFWVideoView
    protected RFWBasePlayerManager getPlayerProxy() {
        if (this.mPlayerManagerProxy == null) {
            this.mPlayerManagerProxy = new c();
        }
        return this.mPlayerManagerProxy;
    }

    public TVideoQFSVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
