package com.tencent.mobileqq.minigame.data;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import org.apache.httpcore.message.TokenParser;

/* loaded from: classes15.dex */
public class PublishMoodInfo {
    private static final String TAG = "[minigame] PublishMoodInfo";
    public ArrayList<String> mAllImageAndVideo;
    public String mFootnote;
    public ArrayList<MediaInfo> mMediaInfo;
    public HashMap<String, LocalMediaInfo> mMediaInfoHashMap;
    public String mPath;
    public String mTag;
    public String mText;
    public static final int MOOD_MAX_TEXT_COUNT = QzoneConfig.getInstance().getConfig("qqminiapp", "MiniAppMoodMaxTextCount", 10000);
    public static final int MOOD_MAX_PHOTO_AND_VIDEO_COUNT = QzoneConfig.getInstance().getConfig("qqminiapp", "MiniAppMoodMaxPhotoAndVideoCount", 50);
    public static final int MOOD_MAX_VIDEO_COUNT = QzoneConfig.getInstance().getConfig("qqminiapp", "MiniAppMoodMaxVideoCount", 10);
    public static final int MOOD_MAX_SINGLE_PHOTO_SIZE = QzoneConfig.getInstance().getConfig("qqminiapp", "MiniAppMoodMaxSinglePhotoSize", 20971520);
    public static final int MOOD_MAX_SINGLE_VIDEO_SIZE = QzoneConfig.getInstance().getConfig("qqminiapp", "MiniAppMoodMaxSingleVideoSize", 1610612736);
    public static final int MOOD_MAX_SINGLE_VIDEO_DURATION = QzoneConfig.getInstance().getConfig("qqminiapp", "MiniAppMoodMaxSingleVideoDuration", 601000);

    /* loaded from: classes15.dex */
    public static class MediaInfo {
        public static final int TYPE_PHOTO = 1;
        public static final int TYPE_VIDEO = 2;
        public String mPath;
        public int mType;

        public MediaInfo() {
        }

        public String toString() {
            return "mType = " + this.mType + ", mPath = " + this.mPath;
        }

        MediaInfo(int i3, String str) {
            this.mType = i3;
            this.mPath = str;
        }
    }

    public PublishMoodInfo() {
        this.mMediaInfo = new ArrayList<>();
        this.mAllImageAndVideo = new ArrayList<>();
        this.mMediaInfoHashMap = new HashMap<>();
    }

    public static String filterText(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str.toString().replace("\r\n", " ").replace("\n", " "), " ");
        StringBuffer stringBuffer = new StringBuffer();
        while (stringTokenizer.hasMoreTokens()) {
            stringBuffer.append(stringTokenizer.nextToken() + TokenParser.SP);
        }
        return stringBuffer.toString().trim();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v7, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v9 */
    public static String getFileSizeDesc(long j3) {
        try {
            if (j3 < 1024) {
                j3 = j3 + "B";
            } else {
                DecimalFormat decimalFormat = new DecimalFormat("##0.0");
                double d16 = j3;
                if (d16 < 1048576.0d) {
                    j3 = decimalFormat.format(d16 / 1024.0d) + "K";
                } else if (d16 < 1.073741824E9d) {
                    j3 = decimalFormat.format(d16 / 1048576.0d) + "M";
                } else {
                    j3 = decimalFormat.format(d16 / 1.073741824E9d) + "G";
                }
            }
            return j3;
        } catch (Exception e16) {
            QLog.i(TAG, 2, "getFileSizeDesc " + j3, e16);
            return "";
        }
    }

    public String toString() {
        int i3;
        int i16;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("mText = ");
        sb5.append(this.mText);
        sb5.append(", mTag = ");
        sb5.append(this.mTag);
        sb5.append(", media.size = ");
        ArrayList<MediaInfo> arrayList = this.mMediaInfo;
        int i17 = 0;
        if (arrayList != null) {
            i3 = arrayList.size();
        } else {
            i3 = 0;
        }
        sb5.append(i3);
        sb5.append(", mAllImageAndVideo.size = ");
        ArrayList<String> arrayList2 = this.mAllImageAndVideo;
        if (arrayList2 != null) {
            i16 = arrayList2.size();
        } else {
            i16 = 0;
        }
        sb5.append(i16);
        sb5.append(", mMediaInfoHashMap.size = ");
        HashMap<String, LocalMediaInfo> hashMap = this.mMediaInfoHashMap;
        if (hashMap != null) {
            i17 = hashMap.size();
        }
        sb5.append(i17);
        return sb5.toString();
    }

    public PublishMoodInfo(String str, String str2, ArrayList<MediaInfo> arrayList) {
        this.mMediaInfo = new ArrayList<>();
        this.mAllImageAndVideo = new ArrayList<>();
        this.mMediaInfoHashMap = new HashMap<>();
        this.mText = str;
        this.mTag = str2;
        this.mMediaInfo = arrayList;
    }
}
