package com.tencent.qqlive.tvkplayer.postprocess.api;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface ITVKMonetSurfaceTexture {

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class TVKMonetDolbyVisionInfo {
        public int profile = 0;
        public int level = 0;
        public int blSignalCompatibilityId = 0;
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class TVKMonetTextureCropInfo {
        public int width = -1;
        public int height = -1;
        public int cropLeft = -1;
        public int cropRight = -1;
        public int cropTop = -1;
        public int cropBottom = -1;
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class TVKMonetVideoPacketBuffer {
        public byte[] data;
        public TVKMonetDolbyVisionInfo dolbyVisionInfo;
        public int size = -1;
        public long ptsMs = -1;
        public long dtsMs = -1;
    }

    void onFlush();

    void onRenderInfo(int i3, int i16, TVKMonetTextureCropInfo tVKMonetTextureCropInfo);

    void onVideoPacket(TVKMonetVideoPacketBuffer tVKMonetVideoPacketBuffer, long j3);
}
