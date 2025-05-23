package com.tencent.mobileqq.qzoneplayer.cover.data;

import com.tencent.mobileqq.qzoneplayer.video.PictureUrl;
import com.tencent.mobileqq.qzoneplayer.video.VideoPlayInfo;

/* compiled from: P */
/* loaded from: classes35.dex */
public class VideoData {
    public BaseVideoCoverData baseVideoCoverData = null;

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public static class BaseVideoCoverData {
        public PictureUrl picUrl = null;
        public String timeDes = null;
        public VideoPlayInfo videoPlayInfo = null;
    }

    public static boolean isAdvData(VideoData videoData) {
        BaseVideoCoverData baseVideoCoverData;
        VideoPlayInfo videoPlayInfo;
        return (videoData == null || (baseVideoCoverData = videoData.baseVideoCoverData) == null || (videoPlayInfo = baseVideoCoverData.videoPlayInfo) == null || (!videoPlayInfo.k() && !videoData.baseVideoCoverData.videoPlayInfo.isAdFeeds)) ? false : true;
    }
}
