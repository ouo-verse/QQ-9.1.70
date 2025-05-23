package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class VideoInfo implements Parcelable {
    public static final Parcelable.Creator<VideoInfo> CREATOR = new Parcelable.Creator<VideoInfo>() { // from class: cooperation.qzone.model.VideoInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VideoInfo createFromParcel(Parcel parcel) {
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.videoId = parcel.readString();
            videoInfo.videoUrl = (VideoUrl) parcel.readParcelable(getClass().getClassLoader());
            videoInfo.originUrl = (PictureUrl) parcel.readParcelable(getClass().getClassLoader());
            videoInfo.bigUrl = (PictureUrl) parcel.readParcelable(getClass().getClassLoader());
            videoInfo.currentUrl = (PictureUrl) parcel.readParcelable(getClass().getClassLoader());
            videoInfo.coverUrl = (PictureUrl) parcel.readParcelable(getClass().getClassLoader());
            videoInfo.actionType = parcel.readInt();
            videoInfo.actionUrl = parcel.readString();
            videoInfo.highBrUrl = (VideoUrl) parcel.readParcelable(getClass().getClassLoader());
            videoInfo.lowBrUrl = (VideoUrl) parcel.readParcelable(getClass().getClassLoader());
            videoInfo.originVideoUrl = (VideoUrl) parcel.readParcelable(getClass().getClassLoader());
            videoInfo.h265NormalUrl = (VideoUrl) parcel.readParcelable(getClass().getClassLoader());
            videoInfo.videoRateList = parcel.readArrayList(getClass().getClassLoader());
            videoInfo.currentVideoRate = parcel.readInt();
            videoInfo.originVideoSize = parcel.readLong();
            videoInfo.fileType = parcel.readInt();
            videoInfo.videoType = parcel.readInt();
            videoInfo.videoTime = parcel.readLong();
            videoInfo.showVideoTime = parcel.readString();
            videoInfo.playType = parcel.readByte();
            videoInfo.videoShowType = parcel.readInt();
            videoInfo.videoStatus = parcel.readInt();
            videoInfo.lastUseTime = parcel.readLong();
            videoInfo.width = parcel.readInt();
            videoInfo.height = parcel.readInt();
            videoInfo.toast = parcel.readString();
            videoInfo.isFakeFeed = parcel.readInt() == 1;
            videoInfo.videoRemark = (VideoRemark) parcel.readParcelable(getClass().getClassLoader());
            videoInfo.validVideoTime = parcel.readLong();
            videoInfo.validVideoTimeDesc = parcel.readString();
            videoInfo.isCircle = parcel.readInt() == 1;
            videoInfo.isAutoPlay = parcel.readInt() == 1;
            videoInfo.writeFrom = parcel.readInt();
            videoInfo.desc = parcel.readString();
            videoInfo.videoSource = parcel.readInt();
            videoInfo.advDelayTime = parcel.readInt();
            videoInfo.isGetRecommAfterPlay = parcel.readInt();
            videoInfo.shootTime = parcel.readLong();
            videoInfo.videoplaycnt = parcel.readInt();
            videoInfo.allowShowPasterVideoAdv = parcel.readInt() == 1;
            videoInfo.needDeleteLocal = parcel.readInt() == 1;
            videoInfo.seekPosition = parcel.readLong();
            videoInfo.lloc = parcel.readString();
            videoInfo.albumid = parcel.readString();
            videoInfo.pull_weishi_mask = parcel.readInt();
            videoInfo.weishi_download_url = parcel.readString();
            videoInfo.weishi_pull_schema = parcel.readString();
            videoInfo.weishi_clipbrd = parcel.readString();
            videoInfo.pull_weishi_alg_id = parcel.readString();
            videoInfo.downloadVideoUrl = (VideoUrl) parcel.readParcelable(getClass().getClassLoader());
            return videoInfo;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VideoInfo[] newArray(int i3) {
            return new VideoInfo[i3];
        }
    };
    public static final int STATUS_AUDITING = 4;
    public static final int STATUS_AUDIT_FAILED = 7;
    public static final int STATUS_AUDIT_FINISHED = 5;
    public static final int STATUS_BANNED = 6;
    public static final int STATUS_INIT = 0;
    public static final int STATUS_TRANSCODE_FAILED = 3;
    public static final int STATUS_TRANSCODE_FINISHED = 2;
    public static final int STATUS_TRANSCODING = 1;
    public int actionType;
    public String actionUrl;
    public int advDelayTime;
    public String albumid;
    public boolean allowShowPasterVideoAdv;
    public PictureUrl bigUrl;
    public PictureUrl coverUrl;
    public PictureUrl currentUrl;
    public int currentVideoRate;
    public String desc;
    public VideoUrl downloadVideoUrl;
    public int fileType;
    public VideoUrl h265NormalUrl;
    public int height;
    public VideoUrl highBrUrl;
    public boolean isAutoPlay;
    public boolean isCircle;
    public int isGetRecommAfterPlay;
    public String lloc;
    public VideoUrl lowBrUrl;
    public String nativeLikeUrl;
    public boolean needDeleteLocal;
    public PictureUrl originUrl;
    public long originVideoSize;
    public VideoUrl originVideoUrl;
    public byte playType;
    public String pull_weishi_alg_id;
    public int pull_weishi_mask;
    public long scrollToNextDelayTime;
    public long seekPosition;
    public long shootTime;
    public String showVideoTime;
    public String toast;
    public String validVideoTimeDesc;
    public Map<String, String> videoFloatReportParam;
    public String videoId;
    public ArrayList<VideoUrl> videoRateList;
    public VideoRemark videoRemark;
    public int videoShowType;
    public int videoSource;
    public long videoTime;
    public int videoType;
    public VideoUrl videoUrl;
    public int videoplaycnt;
    public String weishi_clipbrd;
    public String weishi_download_url;
    public String weishi_pull_schema;
    public int width;
    public int writeFrom;
    public boolean hasVideoPlayed = false;
    public int videoStatus = 0;
    public long lastUseTime = 0;
    public boolean isFakeFeed = false;
    public boolean isFloatFirst = true;
    public boolean isFeedFirst = true;
    public boolean isFeedFirstComplete = false;
    public boolean isFeedComplete = false;
    public boolean isTranscoding = false;
    public boolean isUploading = false;
    public long validVideoTime = -1;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class VideoRemark implements Parcelable {
        public static final Parcelable.Creator<VideoRemark> CREATOR = new Parcelable.Creator<VideoRemark>() { // from class: cooperation.qzone.model.VideoInfo.VideoRemark.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public VideoRemark createFromParcel(Parcel parcel) {
                VideoRemark videoRemark = new VideoRemark();
                videoRemark.iconurl = parcel.readString();
                videoRemark.icondesc = parcel.readString();
                videoRemark.remark = parcel.readString();
                videoRemark.actiontype = parcel.readInt();
                videoRemark.actionurl = parcel.readString();
                videoRemark.orgwebsite = parcel.readInt();
                return videoRemark;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public VideoRemark[] newArray(int i3) {
                return new VideoRemark[i3];
            }
        };
        public String iconurl = "";
        public String icondesc = "";
        public String remark = "";
        public int actiontype = 0;
        public String actionurl = "";
        public int orgwebsite = 0;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getDisplayRemark() {
            if (TextUtils.isEmpty(this.icondesc)) {
                return this.remark;
            }
            return this.icondesc + " -- " + this.remark;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeString(this.iconurl);
            parcel.writeString(this.icondesc);
            parcel.writeString(this.remark);
            parcel.writeInt(this.actiontype);
            parcel.writeString(this.actionurl);
            parcel.writeInt(this.orgwebsite);
        }
    }

    public static String getShownTimeFromNumeric(long j3) {
        int i3;
        Object obj;
        if (j3 >= 60000) {
            int round = (int) Math.round(((j3 % 60000) * 1.0d) / 1000.0d);
            if (round >= 60) {
                i3 = round / 60;
                round %= 60;
            } else {
                i3 = 0;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append((j3 / 60000) + i3);
            sb5.append(":");
            if (round > 9) {
                obj = Integer.valueOf(round);
            } else {
                obj = "0" + round;
            }
            sb5.append(obj);
            return sb5.toString();
        }
        int round2 = (int) Math.round((j3 * 1.0d) / 1000.0d);
        if (round2 > 9) {
            return "0:" + round2;
        }
        return "0:0" + round2;
    }

    private PictureUrl getUrlByPriority(PictureUrl[] pictureUrlArr) {
        for (PictureUrl pictureUrl : pictureUrlArr) {
            if (pictureUrl != null && !TextUtils.isEmpty(pictureUrl.url)) {
                return pictureUrl;
            }
        }
        return new PictureUrl();
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
            this.showVideoTime = getVideoPlayTime(j3);
        } else {
            this.showVideoTime = null;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PictureUrl getPicUrlDec() {
        return getUrlByPriority(new PictureUrl[]{this.originUrl, this.bigUrl, this.currentUrl});
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
        if (i3 == 1 || i3 == 7 || i3 == 3 || i3 == 6) {
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
        if (this.videoStatus == 1) {
            return true;
        }
        return false;
    }

    public boolean isVideoUrlIntact() {
        VideoUrl videoUrl = this.videoUrl;
        if (videoUrl != null && !TextUtils.isEmpty(videoUrl.url) && this.videoUrl.url.contains("https://") && !this.videoUrl.url.startsWith("?sid")) {
            return true;
        }
        return false;
    }

    public String toDebugString() {
        return "VideoInfo{\nvideoId='" + this.videoId + "'\n, videoUrl=" + this.videoUrl + "\n, originUrl=" + this.originUrl + "\n, bigUrl=" + this.bigUrl + "\n, currentUrl=" + this.currentUrl + "\n, coverUrl=" + this.coverUrl + "\n, actionType=" + this.actionType + "\n, actionUrl='" + this.actionUrl + "'\n, nativeLikeUrl='" + this.nativeLikeUrl + "'\n, highBrUrl=" + this.highBrUrl + "\n, lowBrUrl=" + this.lowBrUrl + "\n, originVideoUrl=" + this.originVideoUrl + "\n, h265NormalUrl=" + this.h265NormalUrl + "\n, originVideoSize=" + this.originVideoSize + "\n, downloadVideoUrl" + this.downloadVideoUrl + "\n, fileType=" + this.fileType + "\n, videoType=" + this.videoType + "\n, videoTime=" + this.videoTime + "\n, showVideoTime='" + this.showVideoTime + "'\n, playType=" + ((int) this.playType) + "\n, videoShowType=" + this.videoShowType + "\n, hasVideoPlayed=" + this.hasVideoPlayed + "\n, videoStatus=" + this.videoStatus + "\n, lastUseTime=" + this.lastUseTime + "\n, width=" + this.width + "\n, height=" + this.height + "\n, toast='" + this.toast + "'\n, isFakeFeed=" + this.isFakeFeed + "\n, isFloatFirst=" + this.isFloatFirst + "\n, isFeedFirst=" + this.isFeedFirst + "\n, isFeedFirstComplete=" + this.isFeedFirstComplete + "\n, isFeedComplete=" + this.isFeedComplete + "\n, isTranscoding=" + this.isTranscoding + "\n, isUploading=" + this.isUploading + "\n, videoFloatReportParam=" + this.videoFloatReportParam + "\n, videoRemark=" + this.videoRemark + "\n, validVideoTime=" + this.validVideoTime + "\n, validVideoTimeDesc='" + this.validVideoTimeDesc + "'\n, isCircle=" + this.isCircle + "\n, isAutoPlay=" + this.isAutoPlay + "\n, writeFrom=" + this.writeFrom + "\n, desc='" + this.desc + "'\n, videoSource=" + this.videoSource + "\n, advDelayTime=" + this.advDelayTime + "\n, isGetRecommAfterPlay=" + this.isGetRecommAfterPlay + "\n, shootTime=" + this.shootTime + "\n, videoplaycnt=" + this.videoplaycnt + "\n, allowShowPasterVideoAdv=" + this.allowShowPasterVideoAdv + "\n, needDeleteLocal=" + this.needDeleteLocal + "\n, scrollToNextDelayTime=" + this.scrollToNextDelayTime + "\n, seekPosition=" + this.seekPosition + "\n}";
    }

    public String toString() {
        return "VideoInfo [videoId=" + this.videoId + ", videoUrl=" + this.videoUrl + ", bigUrl=" + this.bigUrl + ", actionType=" + this.actionType + ", actionUrl=" + this.actionUrl + ", highBrUrl=" + this.highBrUrl + ", lowBrUrl=" + this.lowBrUrl + ", fileType=" + this.fileType + ", videoType=" + this.videoType + ",videoShowType=" + this.videoShowType + ", videoTime=" + this.videoTime + ", videoStatus=" + this.videoStatus + ", originVideoUrl=" + this.originVideoUrl + ", originVideoSize=" + this.originVideoSize + ", downloadVideoUrl=" + this.downloadVideoUrl + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.videoId);
        parcel.writeParcelable(this.videoUrl, i3);
        parcel.writeParcelable(this.originUrl, i3);
        parcel.writeParcelable(this.bigUrl, i3);
        parcel.writeParcelable(this.currentUrl, i3);
        parcel.writeParcelable(this.coverUrl, i3);
        parcel.writeInt(this.actionType);
        parcel.writeString(this.actionUrl);
        parcel.writeParcelable(this.highBrUrl, i3);
        parcel.writeParcelable(this.lowBrUrl, i3);
        parcel.writeParcelable(this.originVideoUrl, i3);
        parcel.writeParcelable(this.h265NormalUrl, i3);
        parcel.writeList(this.videoRateList);
        parcel.writeInt(this.currentVideoRate);
        parcel.writeLong(this.originVideoSize);
        parcel.writeInt(this.fileType);
        parcel.writeInt(this.videoType);
        parcel.writeLong(this.videoTime);
        parcel.writeString(this.showVideoTime);
        parcel.writeByte(this.playType);
        parcel.writeInt(this.videoShowType);
        parcel.writeInt(this.videoStatus);
        parcel.writeLong(this.lastUseTime);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeString(this.toast);
        parcel.writeInt(this.isFakeFeed ? 1 : 0);
        parcel.writeParcelable(this.videoRemark, i3);
        parcel.writeLong(this.validVideoTime);
        parcel.writeString(this.validVideoTimeDesc);
        parcel.writeInt(this.isCircle ? 1 : 0);
        parcel.writeInt(this.isAutoPlay ? 1 : 0);
        parcel.writeInt(this.writeFrom);
        parcel.writeString(this.desc);
        parcel.writeInt(this.videoSource);
        parcel.writeInt(this.advDelayTime);
        parcel.writeInt(this.isGetRecommAfterPlay);
        parcel.writeLong(this.shootTime);
        parcel.writeInt(this.videoplaycnt);
        parcel.writeInt(this.allowShowPasterVideoAdv ? 1 : 0);
        parcel.writeInt(this.needDeleteLocal ? 1 : 0);
        parcel.writeLong(this.seekPosition);
        parcel.writeString(this.lloc);
        parcel.writeString(this.albumid);
        parcel.writeInt(this.pull_weishi_mask);
        parcel.writeString(this.weishi_download_url);
        parcel.writeString(this.weishi_pull_schema);
        parcel.writeString(this.weishi_clipbrd);
        parcel.writeString(this.pull_weishi_alg_id);
        parcel.writeParcelable(this.downloadVideoUrl, i3);
    }
}
