package com.tencent.qqlive.tvkplayer.qqliveasset.feature.vod;

import android.view.SurfaceView;
import com.tencent.qqlive.tvkplayer.api.render.ITVKDrawableContainer;
import com.tencent.qqlive.tvkplayer.api.render.ITVKVideoViewBase;
import com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureBase;

/* loaded from: classes23.dex */
public class TVKVodHdrFeatureParam implements ITVKFeatureBase.ITVKFeatureParam {
    private final boolean mIsViewSupportHdr;

    public TVKVodHdrFeatureParam(ITVKDrawableContainer iTVKDrawableContainer) {
        this.mIsViewSupportHdr = isCurDrawableContainerSupportHdr(iTVKDrawableContainer);
    }

    private boolean isCurDrawableContainerSupportHdr(ITVKDrawableContainer iTVKDrawableContainer) {
        if (iTVKDrawableContainer == null) {
            return true;
        }
        if ((iTVKDrawableContainer instanceof ITVKVideoViewBase) && (((ITVKVideoViewBase) iTVKDrawableContainer).getCurrentDisplayView() instanceof SurfaceView)) {
            return true;
        }
        return false;
    }

    public boolean isViewSupportHdr() {
        return this.mIsViewSupportHdr;
    }

    public TVKVodHdrFeatureParam(boolean z16) {
        this.mIsViewSupportHdr = z16;
    }
}
