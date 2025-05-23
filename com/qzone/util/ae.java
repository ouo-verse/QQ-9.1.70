package com.qzone.util;

import androidx.collection.LruCache;
import com.qzone.preview.PictureViewerFactory;
import com.tencent.mobileqq.qzoneplayer.video.VideoPlayInfo;
import com.tencent.oskplayer.model.SegmentVideoInfo;
import cooperation.qzone.model.PictureUrl;
import cooperation.qzone.model.VideoInfo;
import cooperation.qzone.util.QZLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes37.dex */
public class ae {

    /* renamed from: a, reason: collision with root package name */
    private static final LruCache<String, Boolean> f59772a = new LruCache<>(100);

    public static LruCache<String, Boolean> b() {
        return f59772a;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00fd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static VideoPlayInfo a(VideoInfo videoInfo) {
        PictureUrl pictureUrl;
        PictureUrl pictureUrl2;
        long j3;
        long j16;
        long j17;
        String[] split;
        if (videoInfo == null) {
            return null;
        }
        VideoPlayInfo videoPlayInfo = new VideoPlayInfo();
        videoPlayInfo.videoTime = videoInfo.videoTime;
        videoPlayInfo.validVideoTime = videoInfo.validVideoTime;
        videoPlayInfo.isFeedFirstComplete = videoInfo.isFeedFirstComplete;
        VideoInfo.VideoRemark videoRemark = videoInfo.videoRemark;
        if (videoRemark != null) {
            videoPlayInfo.orgwebsite = videoRemark.orgwebsite;
            videoPlayInfo.displayRemark = videoRemark.getDisplayRemark();
            videoPlayInfo.actionurl = videoInfo.videoRemark.actionurl;
        }
        videoPlayInfo.isFeedFirst = videoInfo.isFeedFirst;
        videoPlayInfo.videoId = videoInfo.videoId;
        videoPlayInfo.showVideoTime = videoInfo.showVideoTime;
        videoPlayInfo.validVideoTimeDesc = videoInfo.validVideoTimeDesc;
        videoPlayInfo.isCircle = videoInfo.isCircle();
        videoPlayInfo.isAutoPlay = videoInfo.isAutoPlay();
        videoPlayInfo.width = videoInfo.width;
        videoPlayInfo.height = videoInfo.height;
        videoPlayInfo.originVideoSize = videoInfo.originVideoSize;
        videoPlayInfo.videoStatus = videoInfo.videoStatus;
        videoPlayInfo.writeFrom = videoInfo.writeFrom;
        videoPlayInfo.playCount = videoInfo.videoplaycnt;
        String str = videoPlayInfo.videoId;
        if (str != null && str.contains("local_")) {
            long j18 = 0;
            try {
                split = videoPlayInfo.videoId.split("[#]");
            } catch (Exception e16) {
                e = e16;
                j3 = 0;
            }
            if (split.length == 3) {
                j3 = Long.parseLong(split[1]);
                try {
                    j16 = Long.parseLong(split[2]);
                } catch (Exception e17) {
                    e = e17;
                    if (QZLog.isColorLevel()) {
                        QZLog.d("QZoneOriginalPhotoVideoHelper", 2, "convertToVideoPlayInfo " + e);
                    }
                    j16 = 0;
                    j18 = j3;
                    j17 = j16;
                    videoPlayInfo.playPositionA = (int) Math.round((j18 * 1.0d) / 1000.0d);
                    videoPlayInfo.playPositionB = (int) Math.round(((j18 + j17) * 1.0d) / 1000.0d);
                    HashMap<Integer, SegmentVideoInfo.StreamInfo> hashMap = new HashMap<>();
                    com.qzone.commoncode.module.videorecommend.utils.a.b(hashMap, PictureViewerFactory.n(videoInfo));
                    videoPlayInfo.segmentVideoInfo.setStreams(hashMap);
                    com.tencent.mobileqq.qzoneplayer.video.PictureUrl pictureUrl3 = new com.tencent.mobileqq.qzoneplayer.video.PictureUrl();
                    pictureUrl = videoInfo.coverUrl;
                    if (pictureUrl != null) {
                    }
                    videoPlayInfo.coverUrl = pictureUrl3;
                    com.tencent.mobileqq.qzoneplayer.video.PictureUrl pictureUrl4 = new com.tencent.mobileqq.qzoneplayer.video.PictureUrl();
                    pictureUrl2 = videoInfo.currentUrl;
                    if (pictureUrl2 != null) {
                    }
                    videoPlayInfo.currentUrl = pictureUrl4;
                    return videoPlayInfo;
                }
                j18 = j3;
                j17 = j16;
                videoPlayInfo.playPositionA = (int) Math.round((j18 * 1.0d) / 1000.0d);
                videoPlayInfo.playPositionB = (int) Math.round(((j18 + j17) * 1.0d) / 1000.0d);
            } else {
                j17 = 0;
                videoPlayInfo.playPositionA = (int) Math.round((j18 * 1.0d) / 1000.0d);
                videoPlayInfo.playPositionB = (int) Math.round(((j18 + j17) * 1.0d) / 1000.0d);
            }
        }
        HashMap<Integer, SegmentVideoInfo.StreamInfo> hashMap2 = new HashMap<>();
        com.qzone.commoncode.module.videorecommend.utils.a.b(hashMap2, PictureViewerFactory.n(videoInfo));
        videoPlayInfo.segmentVideoInfo.setStreams(hashMap2);
        com.tencent.mobileqq.qzoneplayer.video.PictureUrl pictureUrl32 = new com.tencent.mobileqq.qzoneplayer.video.PictureUrl();
        pictureUrl = videoInfo.coverUrl;
        if (pictureUrl != null) {
            pictureUrl32.width = pictureUrl.width;
            pictureUrl32.height = pictureUrl.height;
            pictureUrl32.url = pictureUrl.url;
        }
        videoPlayInfo.coverUrl = pictureUrl32;
        com.tencent.mobileqq.qzoneplayer.video.PictureUrl pictureUrl42 = new com.tencent.mobileqq.qzoneplayer.video.PictureUrl();
        pictureUrl2 = videoInfo.currentUrl;
        if (pictureUrl2 != null) {
            pictureUrl42.width = pictureUrl2.width;
            pictureUrl42.height = pictureUrl2.height;
            pictureUrl42.url = pictureUrl2.url;
        }
        videoPlayInfo.currentUrl = pictureUrl42;
        return videoPlayInfo;
    }
}
