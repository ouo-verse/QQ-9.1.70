package com.qzone.commoncode.module.videorecommend.utils;

import android.text.TextUtils;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.proxy.feedcomponent.model.VideoUrl;
import com.tencent.oskplayer.model.SegmentVideoInfo;
import com.tencent.oskplayer.model.VideoDecoderType;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a {
    public static boolean c(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.contains("hlstype=live")) {
                return true;
            }
            str.contains("hlstype=vod");
        }
        return false;
    }

    public static void b(HashMap<Integer, SegmentVideoInfo.StreamInfo> hashMap, VideoInfo videoInfo) {
        if (hashMap == null || videoInfo == null) {
            return;
        }
        VideoUrl videoUrl = videoInfo.videoUrl;
        if (videoUrl != null && !TextUtils.isEmpty(videoUrl.url)) {
            SegmentVideoInfo.StreamInfo streamInfo = new SegmentVideoInfo.StreamInfo(videoInfo.videoUrl.url, (int) videoInfo.videoTime);
            streamInfo.isHLSLive = c(videoInfo.videoUrl.url);
            streamInfo.streamType = 0;
            hashMap.put(0, streamInfo);
        }
        VideoUrl videoUrl2 = videoInfo.highBrUrl;
        if (videoUrl2 != null && !TextUtils.isEmpty(videoUrl2.url)) {
            SegmentVideoInfo.StreamInfo streamInfo2 = new SegmentVideoInfo.StreamInfo(videoInfo.highBrUrl.url, (int) videoInfo.videoTime);
            streamInfo2.isHLSLive = c(videoInfo.highBrUrl.url);
            streamInfo2.streamType = 1;
            hashMap.put(1, streamInfo2);
        }
        VideoUrl videoUrl3 = videoInfo.lowBrUrl;
        if (videoUrl3 != null && !TextUtils.isEmpty(videoUrl3.url)) {
            SegmentVideoInfo.StreamInfo streamInfo3 = new SegmentVideoInfo.StreamInfo(videoInfo.lowBrUrl.url, (int) videoInfo.videoTime);
            streamInfo3.isHLSLive = c(videoInfo.lowBrUrl.url);
            streamInfo3.streamType = 2;
            hashMap.put(2, streamInfo3);
        }
        VideoUrl videoUrl4 = videoInfo.originVideoUrl;
        if (videoUrl4 != null && !TextUtils.isEmpty(videoUrl4.url)) {
            SegmentVideoInfo.StreamInfo streamInfo4 = new SegmentVideoInfo.StreamInfo(videoInfo.originVideoUrl.url, (int) videoInfo.videoTime);
            streamInfo4.isHLSLive = c(videoInfo.originVideoUrl.url);
            streamInfo4.streamType = 3;
            hashMap.put(3, streamInfo4);
        }
        VideoUrl videoUrl5 = videoInfo.h265NormalUrl;
        if (videoUrl5 == null || TextUtils.isEmpty(videoUrl5.url)) {
            return;
        }
        VideoUrl videoUrl6 = videoInfo.h265NormalUrl;
        SegmentVideoInfo.StreamInfo streamInfo5 = new SegmentVideoInfo.StreamInfo(videoUrl6.url, (int) videoInfo.videoTime, a(videoUrl6.decoderType));
        streamInfo5.isHLSLive = c(videoInfo.h265NormalUrl.url);
        streamInfo5.streamType = 3;
        hashMap.put(4, streamInfo5);
    }

    public static VideoDecoderType.DecoderType a(int i3) {
        if (i3 == 0) {
            return VideoDecoderType.DecoderType.UNKNOWN;
        }
        if (i3 == 1) {
            return VideoDecoderType.DecoderType.H264;
        }
        if (i3 == 2) {
            return VideoDecoderType.DecoderType.H265_SW;
        }
        if (i3 != 3) {
            return VideoDecoderType.DecoderType.UNKNOWN;
        }
        return VideoDecoderType.DecoderType.H265_HW;
    }
}
