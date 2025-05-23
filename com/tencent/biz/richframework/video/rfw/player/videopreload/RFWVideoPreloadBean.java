package com.tencent.biz.richframework.video.rfw.player.videopreload;

import android.text.TextUtils;
import com.tencent.biz.richframework.video.rfw.RFWVideoUtils;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.stinfo.RFWStVideo;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes5.dex */
public class RFWVideoPreloadBean {
    public static AtomicInteger sAtomicInteger = new AtomicInteger(30000);
    private boolean mIsMultiLevel;
    private boolean mIsQUIC;
    private boolean mIsSimpleFeed;
    private String mPreTag;
    private int mPreloadDuration;
    private RFWPlayerOptions mPreloadOptions;
    private String mPreloadSelectedUrl;
    private int mPreloadStatus = -1;
    private int mPreloadTaskId;
    private long mPreloadTime;
    private RFWStVideo mPreloadVideo;
    private final int mSceneId;
    private Integer mSeqId;
    private String mVid;
    private int mVideoDuration;

    RFWVideoPreloadBean(int i3) {
        this.mSceneId = i3;
    }

    public static RFWVideoPreloadBean obtainBean(int i3) {
        return new RFWVideoPreloadBean(i3).setSeqId(Integer.valueOf(sAtomicInteger.getAndIncrement()));
    }

    public RFWPlayerOptions getPlayerOptions() {
        return this.mPreloadOptions;
    }

    public String getPreTag() {
        String str;
        if (!TextUtils.isEmpty(this.mPreTag)) {
            return this.mPreTag;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("mSceneId:");
        sb5.append(this.mSceneId);
        sb5.append("preloadSeqId:");
        sb5.append(this.mSeqId);
        sb5.append(" | mPreloadTaskId ");
        sb5.append(this.mPreloadTaskId);
        sb5.append(" | preLoadVid\uff1a");
        String str2 = "";
        if (TextUtils.isEmpty(this.mVid)) {
            str = "";
        } else {
            str = this.mVid;
        }
        sb5.append(str);
        sb5.append(" | preloadUrl: ");
        if (!TextUtils.isEmpty(this.mPreloadSelectedUrl)) {
            str2 = this.mPreloadSelectedUrl;
        }
        sb5.append(str2);
        sb5.append(APLogFileUtil.SEPARATOR_LOG);
        String sb6 = sb5.toString();
        this.mPreTag = sb6;
        return sb6;
    }

    public int getPreloadDuration() {
        return this.mPreloadDuration;
    }

    public String getPreloadSelectedUrl() {
        return this.mPreloadSelectedUrl;
    }

    public int getPreloadStatus() {
        return this.mPreloadStatus;
    }

    public int getPreloadTaskId() {
        return this.mPreloadTaskId;
    }

    public RFWStVideo getPreloadVideo() {
        return this.mPreloadVideo;
    }

    public String getVid() {
        return this.mVid;
    }

    public int getVideoDuration() {
        return this.mVideoDuration;
    }

    public boolean isMultiLevel() {
        return this.mIsMultiLevel;
    }

    public boolean isPreloadDataValid() {
        boolean z16;
        boolean z17;
        boolean z18 = !RFWVideoUtils.checkVideoUrlIsNeedChange(this.mPreloadSelectedUrl);
        if (System.currentTimeMillis() - this.mPreloadTime < RFWVideoUtils.getValidIntervalTime(this.mPreloadSelectedUrl)) {
            z16 = true;
        } else {
            z16 = false;
        }
        int i3 = this.mPreloadStatus;
        if (i3 != 2 && i3 != 1) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (z18 && (z16 & z17)) {
            return true;
        }
        return false;
    }

    public boolean isQUIC() {
        return this.mIsQUIC;
    }

    public boolean isSimpleFeed() {
        return this.mIsSimpleFeed;
    }

    public RFWVideoPreloadBean setIsMultiLevel(boolean z16) {
        this.mIsMultiLevel = z16;
        return this;
    }

    public RFWVideoPreloadBean setIsQUIC(boolean z16) {
        this.mIsQUIC = z16;
        return this;
    }

    public RFWVideoPreloadBean setIsSimpleFeed(boolean z16) {
        this.mIsSimpleFeed = z16;
        return this;
    }

    public RFWVideoPreloadBean setPreloadDuration(int i3) {
        this.mPreloadDuration = i3;
        return this;
    }

    public RFWVideoPreloadBean setPreloadOptions(RFWPlayerOptions rFWPlayerOptions) {
        this.mPreloadOptions = rFWPlayerOptions;
        return this;
    }

    public RFWVideoPreloadBean setPreloadSelectedUrl(String str) {
        this.mPreloadSelectedUrl = str;
        return this;
    }

    public RFWVideoPreloadBean setPreloadStatus(int i3) {
        this.mPreloadStatus = i3;
        return this;
    }

    public RFWVideoPreloadBean setPreloadTaskId(int i3) {
        this.mPreloadTaskId = i3;
        this.mPreTag = "";
        return this;
    }

    public RFWVideoPreloadBean setPreloadTime(long j3) {
        this.mPreloadTime = j3;
        return this;
    }

    public RFWVideoPreloadBean setPreloadVideo(RFWStVideo rFWStVideo) {
        this.mPreloadVideo = rFWStVideo;
        return this;
    }

    public RFWVideoPreloadBean setSeqId(Integer num) {
        this.mSeqId = num;
        return this;
    }

    public RFWVideoPreloadBean setVid(String str) {
        this.mVid = str;
        return this;
    }

    public RFWVideoPreloadBean setVideoDuration(int i3) {
        this.mVideoDuration = i3;
        return this;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("QFSVideoPreloadRecord{");
        stringBuffer.append("mSeqId=");
        stringBuffer.append(this.mSeqId);
        stringBuffer.append(", mPreTag='");
        stringBuffer.append(this.mPreTag);
        stringBuffer.append('\'');
        stringBuffer.append(", mVid='");
        stringBuffer.append(this.mVid);
        stringBuffer.append('\'');
        stringBuffer.append(", mPreloadTaskId=");
        stringBuffer.append(this.mPreloadTaskId);
        stringBuffer.append(", mPreloadSelectedUrl='");
        stringBuffer.append(this.mPreloadSelectedUrl);
        stringBuffer.append('\'');
        stringBuffer.append(", mPreloadTime=");
        stringBuffer.append(this.mPreloadTime);
        stringBuffer.append(", mPreloadDuration=");
        stringBuffer.append(this.mPreloadDuration);
        stringBuffer.append(", mVideoDuration=");
        stringBuffer.append(this.mVideoDuration);
        stringBuffer.append(", mPreloadStatus=");
        stringBuffer.append(this.mPreloadStatus);
        stringBuffer.append(", mIsQUIC=");
        stringBuffer.append(this.mIsQUIC);
        stringBuffer.append(", mIsMultiLevel=");
        stringBuffer.append(this.mIsMultiLevel);
        stringBuffer.append(", mPreloadOptions=");
        stringBuffer.append(this.mPreloadOptions);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
