package com.tencent.qqlive.tvkplayer.api;

import com.tencent.qqlive.tvkplayer.api.render.ITVKDrawableContainer;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;

/* compiled from: P */
/* loaded from: classes23.dex */
public abstract class TVKVideoTrackInfo extends TVKTrackInfo {
    public TVKPlayerVideoInfo playerVideoInfo;

    protected TVKVideoTrackInfo() {
        setSelected(false);
        setTrackType(1);
    }

    public abstract long getInsertTimeMs();

    public abstract long getPlayDurationMs();

    public abstract long getVideoTrackCurrentPositionMs();

    public abstract long getVideoTrackDurationMs();

    public abstract int getVideoTrackHeight();

    public abstract TVKNetVideoInfo getVideoTrackNetVideoInfo();

    public abstract long getVideoTrackStartPositionMs();

    public abstract int getVideoTrackWidth();

    public abstract void setVideoScaleParam(float f16);

    public abstract void setVideoTrackListener(ITVKVideoTrackListener iTVKVideoTrackListener);

    public abstract void setXYaxis(int i3);

    public abstract void updateUserInfo(TVKUserInfo tVKUserInfo);

    public abstract void updateVideoView(ITVKDrawableContainer iTVKDrawableContainer);

    public abstract boolean videoTrackEnablePreload();

    /* JADX INFO: Access modifiers changed from: protected */
    public TVKVideoTrackInfo(String str, TVKPlayerVideoInfo tVKPlayerVideoInfo) {
        this();
        setTrackName(str);
        this.playerVideoInfo = tVKPlayerVideoInfo;
    }
}
