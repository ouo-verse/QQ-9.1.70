package com.tencent.thumbplayer.api.surface;

import com.tencent.thumbplayer.api.common.TPVideoCropInfo;

/* loaded from: classes26.dex */
public class TPSurfaceRenderInfo {
    private int mDisplayWidth = -1;
    private int mDisplayHeight = -1;
    private TPVideoCropInfo mVideoCropInfo = null;

    public int getDisplayHeight() {
        return this.mDisplayHeight;
    }

    public int getDisplayWidth() {
        return this.mDisplayWidth;
    }

    public TPVideoCropInfo getVideoCropInfo() {
        return this.mVideoCropInfo;
    }

    public void setDisplayHeight(int i3) {
        this.mDisplayHeight = i3;
    }

    public void setDisplayWidth(int i3) {
        this.mDisplayWidth = i3;
    }

    public void setVideoCropInfo(TPVideoCropInfo tPVideoCropInfo) {
        this.mVideoCropInfo = tPVideoCropInfo;
    }
}
