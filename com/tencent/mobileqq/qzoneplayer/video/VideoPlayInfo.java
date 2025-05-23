package com.tencent.mobileqq.qzoneplayer.video;

import android.text.TextUtils;
import com.tencent.component.media.image.ImageProcessor;
import com.tencent.component.media.image.ImageUrl;
import com.tencent.component.utils.Pair;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.oskplayer.model.SegmentVideoInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes35.dex */
public class VideoPlayInfo {
    public static final int COOKIE_KEY_TYPE_UGC_KEY = 1;
    public static final String PasterVidLabel = "_paster";
    public static final int VIDEO_FEEDS_TYPE_LIVE = 1;
    public static final int VIDEO_FEEDS_TYPE_LIVE_REPLAY = 2;
    public static final int VIDEO_FEEDS_TYPE_VOD = 0;
    public static final String VIDEO_REFER_DEFAULT = "default";
    public static final String VIDEO_REFER_VERTICAL = "vertical";
    public String advTips;
    public String authorNickname;
    public long authorUin;
    public String cellId;
    public Map<Integer, String> cookie;
    public int coverMaxWidth;
    public PictureUrl coverUrl;
    public PictureUrl currentUrl;
    public String displayFeedTime;
    public String downloadUrl;
    public long enterLivePagePosition;
    public String feedKey;
    public Map<Integer, String> feedReportCookie;
    public long feedTime;
    public int feedsAppId;
    public String feedsUrl;
    public ImageUrl gauseBackgroudImageUrl;
    public String gaussBackgroundUrl;
    public int height;
    public boolean isAdFeeds;
    public boolean isAdvMicro;
    public boolean isAutoPlay;
    public boolean isCircle;
    public boolean isFeedFirstComplete;
    public boolean isFrdLikeVideo;
    public boolean isFromFeedVideoAdv;
    public boolean isGdtAd;
    public boolean isGdtVideoPlaySuccess;
    public boolean isLandingPageVideoTop;
    public boolean isNotRecordProgress;
    public boolean isPasterVideoAdv;
    public boolean isVideoAdv;
    public long launcherUin;
    public ArrayList<Pair<Integer, Integer>> lightSpotInfo;
    public int liveAppid;
    public int livePage;
    public int liveSource;
    public int liveState;
    public int liveUserType;
    public boolean needAdvReport;
    public String openFreeTrafficJumpUrl;
    public String openFreeTrafficText;
    public int orgwebsite;
    public long originVideoSize;
    public int playCount;
    public String playId;
    public ImageProcessor processor;
    public int recomtype;
    public long repostUin;
    public long reposterUin;
    public String s_vid;
    public int seq;
    public boolean showOpenFreeTraffic;
    public String showVideoTime;
    public String triggerHud;
    public String validVideoTimeDesc;
    public String videoDesc;
    public int videoFeedType;
    public Map<String, String> videoFeedsReportParam;
    public Map<String, String> videoFloatReportParam;
    public String videoId;
    public VideoPlayInfoHolder videoPlayInfoHolder;
    public String videoPlayScene;
    public int videoPlaySource;
    public String videoReportInfo;
    public String videoSource;
    public int videoStatus;
    public long videoTime;
    public long videoTimeOrg;
    public int width;
    public int writeFrom;
    public boolean isFeedFirst = true;
    public long validVideoTime = -1;
    public String displayRemark = "";
    public String actionurl = "";
    public int adv_pos = -1;
    public boolean isForceAdvReport = false;
    public boolean isGdtAdClicked = false;
    public SegmentVideoInfo segmentVideoInfo = new SegmentVideoInfo();
    public boolean needVideoExtendedAnimation = false;
    public boolean is360Video = false;
    public boolean isFloatVideo = false;
    public int playPositionA = -1;
    public int playPositionB = -1;
    public boolean videoPlayOnWifi = false;
    public boolean videoHasSetPlayOnWifi = false;
    public String originCellId = null;
    public long originFeedTime = 0;
    public long ugcFeedsCreateTime = 0;
    public int hideOperationContainerTime = 3000;
    public int videoDescLineNum = -1;
    public boolean isWeishiShareVideo = false;
    public boolean isNeedSwitchSurfaceFeature = true;
    public int itemPosition = -1;
    public boolean showCoverImage = true;
    public boolean isLiveVideo = false;
    public boolean isMiniVideo = false;
    public boolean allowSeek = true;
    public String videoRefer = "default";
    public boolean isLiveVideoPreview = false;
    public int liveVideoPreviewRoomState = 0;
    public int currentVideoTime = 0;
    public int videoFeedsType = 0;
    public boolean isCanvasAdvVideo = false;
    public boolean isOriginalContent = false;
    public boolean isShowRapidForwardIcon = false;
    public boolean isInFullScreenPlay = false;
    public long scrollNextItemDelayTime = 3000;
    public boolean isVerticalVideo = false;
    public boolean shield321VVReport = false;

    public VideoPlayInfo a() {
        VideoPlayInfo videoPlayInfo = new VideoPlayInfo();
        videoPlayInfo.segmentVideoInfo = this.segmentVideoInfo;
        videoPlayInfo.videoId = this.videoId;
        videoPlayInfo.orgwebsite = this.orgwebsite;
        videoPlayInfo.videoTime = this.videoTime;
        videoPlayInfo.isPasterVideoAdv = this.isPasterVideoAdv;
        videoPlayInfo.itemPosition = this.itemPosition;
        return videoPlayInfo;
    }

    public String b() {
        return ((((((((((((this.segmentVideoInfo.toString() + ", coverUrl=" + this.coverUrl.url) + ", coverWidth=" + this.coverUrl.width) + ", coverHeight=" + this.coverUrl.height) + ", videoPlayScene=" + this.videoPlayScene) + ", videoSource=" + this.videoSource) + ", videoStatus=" + this.videoStatus) + ", width=" + this.width) + ", height=" + this.height) + ", videoTime=" + this.videoTime) + ", videoTimeOrg=" + this.videoTimeOrg) + ", validVideoTime=" + this.validVideoTime) + ", showVideoTime=" + this.showVideoTime) + ", playCount=" + this.playCount;
    }

    public String c() {
        int i3 = this.playCount;
        if (i3 <= 0) {
            return null;
        }
        if (i3 < 10000) {
            return "" + this.playCount;
        }
        if (i3 >= 10000 && i3 < 100000000) {
            long round = Math.round((i3 * 1.0d) / 10000.0d);
            if (round == 10000) {
                return "1\u4ebf";
            }
            return String.valueOf(round) + "\u4e07";
        }
        if (i3 <= 100000000) {
            return null;
        }
        long round2 = Math.round(((i3 * 1.0d) / 10000.0d) / 10000.0d);
        if (round2 > AppConstants.LBS_HELLO_UIN_LONGVALUE) {
            round2 = 9999;
        }
        return String.valueOf(round2) + "\u4ebf";
    }

    public boolean d() {
        return FeedVideoEnv.externalFunc.isEnable360Video() && this.is360Video;
    }

    public boolean e() {
        return this.isAdFeeds;
    }

    public boolean f() {
        return this.isAutoPlay;
    }

    public boolean g() {
        return this.isCircle;
    }

    public String getDisplayRemark() {
        return this.displayRemark;
    }

    public boolean h() {
        return this.isLiveVideo;
    }

    public boolean i() {
        return this.isLiveVideoPreview;
    }

    public boolean isInvalidState() {
        SegmentVideoInfo segmentVideoInfo;
        int i3 = this.videoStatus;
        return i3 == 1 || i3 == 3 || i3 == 6 || i3 == 7 || (segmentVideoInfo = this.segmentVideoInfo) == null || segmentVideoInfo.getSegmentCount() < 1;
    }

    public boolean j() {
        return this.orgwebsite == 1;
    }

    public boolean k() {
        return this.isVideoAdv;
    }

    public void m(String str, boolean z16) {
        SegmentVideoInfo.StreamInfo streamInfo = new SegmentVideoInfo.StreamInfo(str, 0);
        streamInfo.isHLSLive = z16;
        HashMap hashMap = new HashMap();
        hashMap.put(0, streamInfo);
        this.segmentVideoInfo = new SegmentVideoInfo(hashMap);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof VideoPlayInfo) {
            return !TextUtils.isEmpty(this.videoId) && this.videoId.equals(((VideoPlayInfo) obj).videoId);
        }
        return false;
    }

    public void l(long j3) {
        if (j3 < 0) {
            return;
        }
        this.scrollNextItemDelayTime = j3;
    }
}
