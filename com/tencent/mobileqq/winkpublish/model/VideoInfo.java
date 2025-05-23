package com.tencent.mobileqq.winkpublish.model;

import android.text.TextUtils;
import com.tencent.component.media.image.ImageProcessor;
import com.tencent.component.media.image.ImageUrl;
import com.tencent.mobileqq.winkpublish.util.DateUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smartparcelable.NeedParcel;
import com.tencent.smartparcelable.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes21.dex */
public class VideoInfo implements a {
    public static final int STATUS_AUDITING = 5;
    public static final int STATUS_AUDIT_FAILED = 8;
    public static final int STATUS_AUDIT_FINISHED = 6;
    public static final int STATUS_BANNED = 7;
    public static final int STATUS_INIT = 0;
    public static final int STATUS_SPECIAL = 9;
    public static final int STATUS_TRANSCODE_FAILED = 4;
    public static final int STATUS_TRANSCODE_FINISHED = 3;
    public static final int STATUS_TRANSCODING = 2;
    public static final int STATUS_UPLOADING = 1;

    @NeedParcel
    public int actionType;

    @NeedParcel
    public String actionUrl;

    @NeedParcel
    public int advDelayTime;

    @NeedParcel
    public String[] advPriority;

    @NeedParcel
    public String albumid;

    @NeedParcel
    public boolean allowShowPasterVideoAdv;

    @NeedParcel
    public int anonymity;

    @NeedParcel
    public PictureUrl bigUrl;

    @NeedParcel
    public PictureUrl coverUrl;

    @NeedParcel
    public PictureUrl currentUrl;

    @NeedParcel
    public int currentVideoRate;

    @NeedParcel
    public String desc;

    @NeedParcel
    public PictureUrl dynamicCoverUrl;

    @NeedParcel
    public int fileType;

    @NeedParcel
    public boolean forceUseCache;

    @NeedParcel
    public ImageUrl gauseBackgroudImageUrl;

    @NeedParcel
    public String gauseBackgroudUrl;

    @NeedParcel
    public VideoUrl h265NormalUrl;

    @NeedParcel
    public boolean hasSetPlayOnWifi;

    @NeedParcel
    public boolean hasVideoPlayed;

    @NeedParcel
    public int height;

    @NeedParcel
    public VideoUrl highBrUrl;

    @NeedParcel
    public boolean is360Video;

    @NeedParcel
    public boolean isAutoPlay;

    @NeedParcel
    public boolean isCircle;

    @NeedParcel
    public boolean isFakeFeed;
    public boolean isFeedComplete;

    @NeedParcel
    public boolean isFeedFirstComplete;

    @NeedParcel
    public boolean isGdtAdVideoPlaying;

    @NeedParcel
    public boolean isGdtVideoVolumeOpened;

    @NeedParcel
    public int isGetRecommAfterPlay;

    @NeedParcel
    public boolean isOnWifiPlay;
    public boolean isTranscoding;
    public boolean isUploading;

    @NeedParcel
    public long lastUseTime;

    @NeedParcel
    public String lloc;

    @NeedParcel
    public VideoUrl lowBrUrl;

    @NeedParcel
    public boolean mOpenFullScreen;

    @NeedParcel
    public String nativeLikeUrl;

    @NeedParcel
    public boolean needDeleteLocal;

    @NeedParcel
    public PictureUrl originUrl;

    @NeedParcel
    public long originVideoSize;

    @NeedParcel
    public VideoUrl originVideoUrl;

    @NeedParcel
    public String perfKey;

    @NeedParcel
    public byte playType;
    public ImageProcessor processor;

    @NeedParcel
    public long shootTime;

    @NeedParcel
    public String showVideoTime;

    @NeedParcel
    public String sloc;

    @NeedParcel
    public String toast;

    @NeedParcel
    public String validVideoTimeDesc;

    @NeedParcel
    public String videoDesc;
    public Map<String, String> videoFloatReportParam;

    @NeedParcel
    public String videoHeaderDesc;

    @NeedParcel
    public String videoId;

    @NeedParcel
    public long videoMaxPlaytime;

    @NeedParcel
    public ArrayList<VideoUrl> videoRateList;

    @NeedParcel
    public VideoRemark videoRemark;

    @NeedParcel
    public int videoShowType;

    @NeedParcel
    public int videoSource;

    @NeedParcel
    public int videoStatusFromCellVideo;

    @NeedParcel
    public long videoTime;

    @NeedParcel
    public int videoType;

    @NeedParcel
    public VideoUrl videoUrl;

    @NeedParcel
    public int videoplaycnt;

    @NeedParcel
    public int width;

    @NeedParcel
    public int writeFrom;

    @NeedParcel
    public int videoStatus = 0;

    @NeedParcel
    public boolean isFrdLikeVideoContainer = false;

    @NeedParcel
    public boolean isFloatFirst = true;

    @NeedParcel
    public boolean isFeedFirst = true;

    @NeedParcel
    public long validVideoTime = -1;

    @NeedParcel
    public int autoRefreshSecond = 0;

    @NeedParcel
    public int scrollToNextDelayTime = 0;

    @NeedParcel
    public int videoForm = 0;

    @NeedParcel
    public int videoClickType = 0;

    @NeedParcel
    public String liveRefer = "";

    /* compiled from: P */
    /* loaded from: classes21.dex */
    static final class EnumVideoStatus implements Serializable {
        public static final int ENUM_CHECK_FAIL = 7;
        public static final int ENUM_CHECK_NOT_PASS = 6;
        public static final int ENUM_CHECK_PASS = 5;
        public static final int ENUM_INIT = 0;
        public static final int ENUM_NOT_CHECKED = 4;
        public static final int ENUM_TRANSFERING = 1;
        public static final int ENUM_TRANSFER_DONE = 2;
        public static final int ENUM_TRANSFER_FAIL = 3;

        EnumVideoStatus() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static class VideoRemark implements a {

        @NeedParcel
        public int actiontype;

        @NeedParcel
        public int orgwebsite;

        @NeedParcel
        public String iconurl = "";

        @NeedParcel
        public String icondesc = "";

        @NeedParcel
        public String remark = "";

        @NeedParcel
        public String actionurl = "";

        public String getDisplayRemark() {
            if (TextUtils.isEmpty(this.icondesc)) {
                return this.remark;
            }
            return this.icondesc + " -- " + this.remark;
        }

        public boolean isTencentVideo() {
            if (this.orgwebsite == 1) {
                return true;
            }
            return false;
        }
    }

    public static String getShownTimeFromNumeric(long j3) {
        StringBuilder sb5;
        String str;
        Object obj;
        if (j3 >= 60000) {
            int round = (int) Math.round(((j3 % 60000) * 1.0d) / 1000.0d);
            StringBuilder sb6 = new StringBuilder();
            sb6.append(j3 / 60000);
            sb6.append(":");
            if (round > 9) {
                obj = Integer.valueOf(round);
            } else {
                obj = "0" + round;
            }
            sb6.append(obj);
            return sb6.toString();
        }
        int round2 = (int) Math.round((j3 * 1.0d) / 1000.0d);
        if (round2 > 9) {
            sb5 = new StringBuilder();
            str = "0:";
        } else {
            sb5 = new StringBuilder();
            str = "0:0";
        }
        sb5.append(str);
        sb5.append(round2);
        return sb5.toString();
    }

    public static final String getVideoPlayTime(long j3) {
        String str;
        if (j3 < 0) {
            return "";
        }
        long round = Math.round(((float) j3) / 1000.0f);
        long j16 = round / 60;
        long j17 = round % 60;
        long j18 = j16 / 60;
        long j19 = j16 % 60;
        String str2 = ":%d";
        if (j18 > 0) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("%d");
            if (j19 >= 10) {
                str = ":%d";
            } else {
                str = ":0%d";
            }
            sb5.append(str);
            String sb6 = sb5.toString();
            StringBuilder sb7 = new StringBuilder();
            sb7.append(sb6);
            if (j17 < 10) {
                str2 = ":0%d";
            }
            sb7.append(str2);
            return String.format(sb7.toString(), Long.valueOf(j18), Long.valueOf(j19), Long.valueOf(j17));
        }
        StringBuilder sb8 = new StringBuilder();
        sb8.append("%d");
        if (j17 < 10) {
            str2 = ":0%d";
        }
        sb8.append(str2);
        return String.format(sb8.toString(), Long.valueOf(j19), Long.valueOf(j17));
    }

    public void calcuShowVideoTime(long j3) {
        if (j3 > 0) {
            this.showVideoTime = DateUtil.getVideoPlayTime(j3);
        } else {
            this.showVideoTime = null;
        }
    }

    public PictureUrl getPicUrlDec() {
        return getUrlByPriority(new PictureUrl[]{this.originUrl, this.bigUrl, this.currentUrl});
    }

    PictureUrl getUrlByPriority(PictureUrl[] pictureUrlArr) {
        for (PictureUrl pictureUrl : pictureUrlArr) {
            if (pictureUrl != null && !TextUtils.isEmpty(pictureUrl.url)) {
                return pictureUrl;
            }
        }
        return new PictureUrl();
    }

    public boolean hasVideoPlayed() {
        return this.hasVideoPlayed;
    }

    public boolean isAdvMicroVideo() {
        if (this.videoShowType == 1) {
            return true;
        }
        return false;
    }

    public boolean isAutoPlay() {
        if ((this.playType & 1) != 0 || this.videoShowType == 1) {
            return true;
        }
        return false;
    }

    public boolean isCircle() {
        if ((this.playType & 2) != 0) {
            long j3 = this.validVideoTime;
            if (j3 <= 0 || j3 >= this.videoTime) {
                return true;
            }
        }
        return false;
    }

    public boolean isErrorState() {
        int i3 = this.videoStatus;
        if (i3 != 2 && i3 != 8 && i3 != 4 && i3 != 7) {
            return false;
        }
        return true;
    }

    public boolean isErrorStatues() {
        int i3 = this.videoStatus;
        if (i3 != 3 && i3 != 4 && i3 != 6 && i3 != 7) {
            return false;
        }
        return true;
    }

    public boolean isMaxVideo() {
        if (this.actionType == 19) {
            return true;
        }
        return false;
    }

    public boolean isOpenWithFloat() {
        int i3 = this.actionType;
        if (i3 != 19 && i3 != 3) {
            return false;
        }
        return true;
    }

    public boolean isTranscoding() {
        if (this.videoStatus == 2) {
            return true;
        }
        return false;
    }

    public boolean isUgcVideo() {
        if (this.videoSource == 1) {
            return true;
        }
        return false;
    }

    public boolean isVideoUrlIntact() {
        VideoUrl videoUrl = this.videoUrl;
        if (videoUrl != null && !TextUtils.isEmpty(videoUrl.url)) {
            if ((this.videoUrl.url.contains("http://") || this.videoUrl.url.contains("https://")) && !this.videoUrl.url.startsWith("?sid")) {
                return true;
            }
            QLog.i("feed video", 1, "url is illegal :" + this.videoUrl);
            return false;
        }
        return false;
    }

    public String toString() {
        return "VideoInfo [videoId=" + this.videoId + ", videoUrl=" + this.videoUrl + ", bigUrl=" + this.bigUrl + ", actionType=" + this.actionType + ", actionUrl=" + this.actionUrl + ", highBrUrl=" + this.highBrUrl + ", lowBrUrl=" + this.lowBrUrl + ", fileType=" + this.fileType + ", videoType=" + this.videoType + ",videoShowType=" + this.videoShowType + ", videoTime=" + this.videoTime + ", videoStatus=" + this.videoStatus + ", originVideoUrl=" + this.originVideoUrl + ", originVideoSize=" + this.originVideoSize + ", currentVideoRate=" + this.currentVideoRate + ", videoForm=" + this.videoForm + "]";
    }
}
