package com.tencent.qqlive.tvkplayer.view;

import android.content.Context;
import android.view.Surface;
import com.tencent.qqlive.tvkplayer.api.render.ITVKCustomVideoSurface;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.view.api.ITVKRenderSurface;

/* loaded from: classes23.dex */
public class TVKPlayerCustomVideoSurface implements ITVKCustomVideoSurface, ITVKRenderSurface {
    private static final String TAG = "TVKPlayer[TVKPlayerCustomVideoSurface]";
    private Context mContext;
    private Surface mSurface;

    public TVKPlayerCustomVideoSurface(Context context, Surface surface) {
        this.mContext = context.getApplicationContext();
        this.mSurface = surface;
    }

    @Override // com.tencent.qqlive.tvkplayer.view.api.ITVKRenderSurface
    public void addVideoSurfaceCallBack(ITVKRenderSurface.IVideoSurfaceCallback iVideoSurfaceCallback) {
        TVKLogUtil.w(TAG, "addVideoSurfaceCallback not supported here");
    }

    @Override // com.tencent.qqlive.tvkplayer.api.render.ITVKCustomVideoSurface
    public Surface getCurrentSurface() {
        return this.mSurface;
    }

    @Override // com.tencent.qqlive.tvkplayer.view.api.ITVKRenderSurface
    public Surface getRenderSurface() {
        if (isSurfaceReady()) {
            return this.mSurface;
        }
        return null;
    }

    @Override // com.tencent.qqlive.tvkplayer.view.api.ITVKRenderSurface
    public boolean isSurfaceReady() {
        Surface surface = this.mSurface;
        if (surface != null && surface.isValid()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqlive.tvkplayer.view.api.ITVKRenderSurface
    public void removeVideoSurfaceCallBack(ITVKRenderSurface.IVideoSurfaceCallback iVideoSurfaceCallback) {
        TVKLogUtil.w(TAG, "removeVideoSurfaceCallback not supported here");
    }

    @Override // com.tencent.qqlive.tvkplayer.view.api.ITVKRenderSurface
    public void setFixedSize(int i3, int i16) {
        TVKLogUtil.w(TAG, "don't support setFixedSize");
    }
}
