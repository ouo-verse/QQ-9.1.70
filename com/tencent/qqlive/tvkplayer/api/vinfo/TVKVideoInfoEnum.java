package com.tencent.qqlive.tvkplayer.api.vinfo;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKVideoInfoEnum {

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class LIVE {
        public static final int FORMAT_AUTO = 0;
        public static final int FORMAT_DASH = 8;
        public static final int FORMAT_FLV = 1;
        public static final int FORMAT_HLS = 2;
        public static final int FORMAT_RTMP = 4;
        public static final int FORMAT_TRTC = 32;
        public static final int FORMAT_WEBRTC = 16;
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes23.dex */
    public @interface LiveFormatId {
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class VOD {
        public static final int FORMAT_AUTO = 0;
        public static final int FORMAT_HLS = 3;
        public static final int FORMAT_HLS_MULTI = 8;
        public static final int FORMAT_HTTP = 1;
        public static final int FORMAT_MP4_20MIN = 5;
        public static final int FORMAT_MP4_5MIN = 4;
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes23.dex */
    public @interface VodFormatId {
    }
}
