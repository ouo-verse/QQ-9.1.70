package com.tencent.mobileqq.icgame.api.room;

/* loaded from: classes15.dex */
public class PreloadSuperPlayerParams {
    private static final String TAG = "PreloadSuperPlayerParams";
    public int playerXYAxis;
    public String url;
    public boolean useTextureView;

    public PreloadSuperPlayerParams() {
    }

    public void copyFrom(PreloadSuperPlayerParams preloadSuperPlayerParams) {
        if (preloadSuperPlayerParams == null) {
            return;
        }
        this.playerXYAxis = preloadSuperPlayerParams.playerXYAxis;
        this.useTextureView = preloadSuperPlayerParams.useTextureView;
        this.url = preloadSuperPlayerParams.url;
    }

    public String toString() {
        return "PreloadSuperPlayerParams{+ playerXYAxis=" + this.playerXYAxis + ", + useTextureView=" + this.useTextureView + ", + url='" + this.url + "'}";
    }

    public PreloadSuperPlayerParams(int i3, boolean z16, String str) {
        this.playerXYAxis = i3;
        this.useTextureView = z16;
        this.url = str;
    }
}
