package com.tencent.mobileqq.icgame.api.room;

import android.text.TextUtils;

/* loaded from: classes15.dex */
public class IcgRoomPlayerConfig {
    public static final String KEY_STREAM_TYPE = "streamtype";
    public long roomId;
    public int roomType;
    public int streamType;
    public final PreloadSuperPlayerParams superPlayerParams;
    public final PreloadTRTCPlayerParams trtcPlayerParams;

    public IcgRoomPlayerConfig() {
        this.streamType = 0;
        this.superPlayerParams = new PreloadSuperPlayerParams();
        this.trtcPlayerParams = new PreloadTRTCPlayerParams();
    }

    public void copyFrom(IcgRoomPlayerConfig icgRoomPlayerConfig) {
        this.roomId = icgRoomPlayerConfig.roomId;
        this.roomType = icgRoomPlayerConfig.roomType;
        this.streamType = icgRoomPlayerConfig.streamType;
        this.superPlayerParams.copyFrom(icgRoomPlayerConfig.superPlayerParams);
        this.trtcPlayerParams.copyFrom(icgRoomPlayerConfig.trtcPlayerParams);
    }

    public boolean isSupportTRTCPlay() {
        if (this.streamType == StreamType.TRTC.value && !TextUtils.isEmpty(this.trtcPlayerParams.trtcSig) && !TextUtils.isEmpty(this.trtcPlayerParams.anchorId) && this.roomId != 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "IcgRoomPlayerConfig{+ roomId=" + this.roomId + ", + roomType=" + this.roomType + ", + streamType=" + this.streamType + ", + superPlayerParams=" + this.superPlayerParams + ", + trtcPlayerParams=" + this.trtcPlayerParams + '}';
    }

    public IcgRoomPlayerConfig(long j3, int i3, int i16, PreloadSuperPlayerParams preloadSuperPlayerParams, PreloadTRTCPlayerParams preloadTRTCPlayerParams) {
        this.streamType = 0;
        PreloadSuperPlayerParams preloadSuperPlayerParams2 = new PreloadSuperPlayerParams();
        this.superPlayerParams = preloadSuperPlayerParams2;
        PreloadTRTCPlayerParams preloadTRTCPlayerParams2 = new PreloadTRTCPlayerParams();
        this.trtcPlayerParams = preloadTRTCPlayerParams2;
        this.roomId = j3;
        this.roomType = i3;
        this.streamType = i16;
        preloadSuperPlayerParams2.copyFrom(preloadSuperPlayerParams);
        preloadTRTCPlayerParams2.copyFrom(preloadTRTCPlayerParams);
    }
}
