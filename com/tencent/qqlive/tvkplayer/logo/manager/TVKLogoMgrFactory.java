package com.tencent.qqlive.tvkplayer.logo.manager;

import android.view.TextureView;
import android.view.ViewGroup;
import com.tencent.qqlive.tvkplayer.api.render.ITVKVideoViewBase;
import com.tencent.qqlive.tvkplayer.context.TVKContext;
import com.tencent.qqlive.tvkplayer.view.api.ITVKVideoViewPrivate;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKLogoMgrFactory {
    /* JADX WARN: Multi-variable type inference failed */
    public static ITVKLogoMgr createLogoMgr(TVKContext tVKContext, ViewGroup viewGroup) {
        if (!(viewGroup instanceof ITVKVideoViewBase)) {
            return new TVKLogoEmptyMgr(tVKContext);
        }
        return new TVKLogoMgr(tVKContext, ((ITVKVideoViewPrivate) viewGroup).getInnerLogoView(), shouldUseImageView((ITVKVideoViewBase) viewGroup) ? 1 : 0);
    }

    private static boolean shouldUseImageView(ITVKVideoViewBase iTVKVideoViewBase) {
        if (iTVKVideoViewBase.getLogoView() != null || (iTVKVideoViewBase.getCurrentDisplayView() instanceof TextureView)) {
            return true;
        }
        return false;
    }
}
