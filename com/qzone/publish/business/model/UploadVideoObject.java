package com.qzone.publish.business.model;

import android.media.MediaExtractor;
import android.os.Bundle;
import android.text.TextUtils;
import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.qzone.proxy.feedcomponent.util.j;
import com.tencent.component.annotation.NeedParcel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class UploadVideoObject extends UploadObject {
    public static final String VODEO_FORMAT_H264 = "h264";
    public static final String VODEO_FORMAT_H265 = "h265";
    public static final String VODEO_FORMAT_UNKNOW = "unkown";

    @NeedParcel
    private String mCoverUrl;

    @NeedParcel
    private String mDesc;

    @NeedParcel
    private long mDuration;

    @NeedParcel
    private int mFlag;

    @NeedParcel
    private int mHasCompressed;

    @NeedParcel
    private int mIsNew;

    @NeedParcel
    private int mIsUploadOrigin;

    @NeedParcel
    public String mOriganlVideoPath;

    @NeedParcel
    private long mSize;

    @NeedParcel
    private String mTitle;

    public UploadVideoObject(String str, String str2, String str3, int i3, long j3, long j16, String str4, int i16, int i17, int i18) {
        super(str);
        this.mTitle = str2;
        this.mDesc = str3;
        this.mFlag = i3;
        this.mDuration = j3;
        this.mSize = j16;
        this.mCoverUrl = str4;
        this.mIsNew = i16;
        this.mIsUploadOrigin = i17;
        this.mHasCompressed = i18;
    }

    public static UploadVideoObject createFromShuoshuoVideoInfo(ShuoshuoVideoInfo shuoshuoVideoInfo) {
        if (shuoshuoVideoInfo == null) {
            return null;
        }
        return new UploadVideoObject(shuoshuoVideoInfo.mVideoPath, shuoshuoVideoInfo.mTitle, shuoshuoVideoInfo.mDesc, shuoshuoVideoInfo.mFlag, shuoshuoVideoInfo.mDuration, shuoshuoVideoInfo.mSize, null, shuoshuoVideoInfo.mIsNew, shuoshuoVideoInfo.mIsUploadOrigin ? 1 : 0, shuoshuoVideoInfo.mHasCompressed ? 1 : 0);
    }

    public static String getVideoForMat(ShuoshuoVideoInfo shuoshuoVideoInfo) {
        if (shuoshuoVideoInfo == null || TextUtils.isEmpty(shuoshuoVideoInfo.mVideoPath)) {
            return VODEO_FORMAT_UNKNOW;
        }
        MediaExtractor mediaExtractor = new MediaExtractor();
        try {
            try {
                mediaExtractor.setDataSource(shuoshuoVideoInfo.mVideoPath);
                int trackCount = mediaExtractor.getTrackCount();
                for (int i3 = 0; i3 < trackCount; i3++) {
                    String string = mediaExtractor.getTrackFormat(i3).getString("mime");
                    if (string != null && string.startsWith("video")) {
                        if ("video/hevc".equalsIgnoreCase(string)) {
                            return VODEO_FORMAT_H265;
                        }
                        if (!"video/avc".equalsIgnoreCase(string)) {
                            return VODEO_FORMAT_UNKNOW;
                        }
                        return "h264";
                    }
                }
            } catch (Exception e16) {
                j.d("UploadVideoObject", "get videoMimeType error", e16);
            }
            return VODEO_FORMAT_UNKNOW;
        } finally {
            mediaExtractor.release();
        }
    }

    public static String getVideoType(ShuoshuoVideoInfo shuoshuoVideoInfo) {
        Bundle bundle;
        if (shuoshuoVideoInfo == null || (bundle = shuoshuoVideoInfo.mExtras) == null) {
            return "3";
        }
        return bundle.getString("video_type", "3");
    }

    public String getCoverUrl() {
        return this.mCoverUrl;
    }

    public String getDesc() {
        return this.mDesc;
    }

    public long getDuration() {
        return this.mDuration;
    }

    public int getFlag() {
        return this.mFlag;
    }

    public int getHasCompressed() {
        return this.mHasCompressed;
    }

    public int getIsNew() {
        return this.mIsNew;
    }

    public int getIsUploadOrigin() {
        return this.mIsUploadOrigin;
    }

    public long getSize() {
        return this.mSize;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setCoverUrl(String str) {
        this.mCoverUrl = str;
    }

    public void setDesc(String str) {
        this.mDesc = str;
    }

    public void setDuration(long j3) {
        this.mDuration = j3;
    }

    public void setFlag(int i3) {
        this.mFlag = i3;
    }

    public void setHasCompressed(int i3) {
        this.mHasCompressed = i3;
    }

    public void setIsNew(int i3) {
        this.mIsNew = i3;
    }

    public void setIsUploadOrigin(int i3) {
        this.mIsUploadOrigin = i3;
    }

    public void setSize(long j3) {
        this.mSize = j3;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public static UploadVideoObject createFromShuoshuoVideoInfo(ShuoshuoVideoInfo shuoshuoVideoInfo, String str) {
        if (shuoshuoVideoInfo == null) {
            return null;
        }
        return new UploadVideoObject(shuoshuoVideoInfo.mVideoPath, shuoshuoVideoInfo.mTitle, str, shuoshuoVideoInfo.mFlag, shuoshuoVideoInfo.mDuration, shuoshuoVideoInfo.mSize, null, shuoshuoVideoInfo.mIsNew, shuoshuoVideoInfo.mIsUploadOrigin ? 1 : 0, shuoshuoVideoInfo.mHasCompressed ? 1 : 0);
    }

    public static boolean isRecordVideo(ShuoshuoVideoInfo shuoshuoVideoInfo) {
        Bundle bundle;
        if (shuoshuoVideoInfo == null || (bundle = shuoshuoVideoInfo.mExtras) == null) {
            return false;
        }
        return bundle.getString("video_type", "3").equalsIgnoreCase("4");
    }

    public static void setVideoType(ShuoshuoVideoInfo shuoshuoVideoInfo, boolean z16) {
        String str;
        if (shuoshuoVideoInfo == null) {
            return;
        }
        if (shuoshuoVideoInfo.mExtras == null) {
            shuoshuoVideoInfo.mExtras = new Bundle();
        }
        Bundle bundle = shuoshuoVideoInfo.mExtras;
        if (z16) {
            str = "4";
        } else {
            str = "3";
        }
        bundle.putString("video_type", str);
    }

    public static ArrayList<UploadVideoObject> createListFromLocalShuoshuoVideoInfoList(List<ShuoshuoVideoInfo> list) {
        if (list == null) {
            return null;
        }
        ArrayList<UploadVideoObject> arrayList = new ArrayList<>(list.size());
        Iterator<ShuoshuoVideoInfo> it = list.iterator();
        while (it.hasNext()) {
            UploadVideoObject createFromShuoshuoVideoInfo = createFromShuoshuoVideoInfo(it.next());
            if (createFromShuoshuoVideoInfo != null) {
                arrayList.add(createFromShuoshuoVideoInfo);
            }
        }
        return arrayList;
    }
}
