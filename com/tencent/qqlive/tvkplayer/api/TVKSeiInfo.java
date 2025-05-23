package com.tencent.qqlive.tvkplayer.api;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKSeiInfo {
    public static final int VIDEO_CODEC_TYPE_AVC = 26;
    public static final int VIDEO_CODEC_TYPE_HEVC = 172;
    public static final int VIDEO_CODEC_TYPE_UNKNOWN = -1;
    public static final int VIDEO_SEI_TYPE_PICTURE_TIMING = 1;
    public static final int VIDEO_SEI_TYPE_UNKNOWN = -1;
    public static final int VIDEO_SEI_TYPE_USER_DATA_UNREGISTERED = 5;
    public int codecType;
    public byte[] seiData;
    public int seiType;

    public String toString() {
        return "TVKSeiInfo, codecType=" + this.codecType + ", seiType=" + this.seiType + ", seiData=" + this.seiData;
    }
}
