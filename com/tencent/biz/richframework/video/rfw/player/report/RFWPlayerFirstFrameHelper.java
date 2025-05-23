package com.tencent.biz.richframework.video.rfw.player.report;

import androidx.annotation.NonNull;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.video.rfw.RFWVideoUtils;
import com.tencent.biz.richframework.video.rfw.player.stinfo.RFWPlayerReportInfo;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.minigame.report.StartupReportKey;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleReportHelper;
import feedcloud.FeedCloudCommon$Entry;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import uq3.c;

/* loaded from: classes5.dex */
public class RFWPlayerFirstFrameHelper {
    private static volatile RFWPlayerFirstFrameHelper INSTANCE = null;
    private static long mMinNetworkBandWidth = 800000;
    private static int mMinPlayingHitCacheTime = 4;
    private static int mStartMinPreparedFastNetConfigTime = 2;
    private static int mStartMinPreparedHitCacheConfigTime = 1;
    private boolean mIsHitFirstFrameMonitorRatio;

    /* loaded from: classes5.dex */
    public static class RFWFirstFrameBufferReportParam {
        public int mPlayerScene;
        public int mTriggerScene = 1;
        public int mStartPreparedTime = 0;
        public String mFileId = "";
        public boolean isPreparedSuccess = false;
        public int mPlayerBufferTime = 0;
        public int mPlayerDurationTime = 0;
        public int mPlayerState = 1;
        public int mPlayerErrorCode = 0;
        public int mVideoRate = 0;
        public int mDrawFrames = 0;
        public RFWPlayerReportInfo mReportObj = null;
        public long mVideoPlayerId = 0;
        public long mPlayFileLength = 0;
        public int mPlayFileTimeCost = 0;
        public long mPrepareFileLength = 0;
        public String mPlayUrl = "";
        public String mVid = "";

        public void setFileId(String str) {
            this.mFileId = str;
        }

        public void setPlayFileLength(long j3) {
            this.mPlayFileLength = j3;
        }

        public void setPlayFileTimeCost(int i3) {
            this.mPlayFileTimeCost = i3;
        }

        public void setPlayUrl(String str) {
            this.mPlayUrl = str;
        }

        public void setPlayerBufferTime(int i3) {
            this.mPlayerBufferTime = i3;
        }

        public void setPlayerDurationTime(int i3) {
            this.mPlayerDurationTime = i3;
        }

        public void setPlayerErrorCode(int i3) {
            this.mPlayerErrorCode = i3;
        }

        public void setPlayerScene(int i3) {
            this.mPlayerScene = i3;
        }

        public void setPlayerState(int i3) {
            this.mPlayerState = i3;
        }

        public void setPrepareFileLength(long j3) {
            this.mPrepareFileLength = j3;
        }

        public void setPreparedSuccess(boolean z16) {
            this.isPreparedSuccess = z16;
        }

        public void setReportFeed(RFWPlayerReportInfo rFWPlayerReportInfo) {
            this.mReportObj = rFWPlayerReportInfo;
        }

        public void setStartPreparedTime(int i3) {
            this.mStartPreparedTime = i3;
        }

        public void setTriggerScene(int i3) {
            this.mTriggerScene = i3;
        }

        public void setVid(String str) {
            this.mVid = str;
        }

        public void setVideoPlayerId(long j3) {
            this.mVideoPlayerId = j3;
        }

        public void setVideoRate(int i3) {
            this.mVideoRate = i3;
        }

        public String toString() {
            return "RFWFirstFrameBufferReportParam{mTriggerScene=" + this.mTriggerScene + ", mStartPreparedTime=" + this.mStartPreparedTime + ", mFileId='" + this.mFileId + "', mPlayerScene=" + this.mPlayerScene + ", isPreparedSuccess=" + this.isPreparedSuccess + ", mPlayerBufferTime=" + this.mPlayerBufferTime + ", mPlayerDurationTime=" + this.mPlayerDurationTime + ", mPlayerState=" + this.mPlayerState + ", mPlayerErrorCode=" + this.mPlayerErrorCode + ", mVideoRate=" + this.mVideoRate + ", mDrawFrames=" + this.mDrawFrames + ", mVideoPlayerId=" + this.mVideoPlayerId + ", mPlayFileLength=" + this.mPlayFileLength + ", mPlayFileTimeCost=" + this.mPlayFileTimeCost + ", mPrepareFileLength=" + this.mPrepareFileLength + ", mPlayUrl='" + this.mPlayUrl + "', mVid='" + this.mVid + "'}";
        }
    }

    public RFWPlayerFirstFrameHelper() {
        this.mIsHitFirstFrameMonitorRatio = false;
        this.mIsHitFirstFrameMonitorRatio = generateMonitorRatio();
        mStartMinPreparedHitCacheConfigTime = c.X0("qqcircle", "qqcircle_start_min_prepared_hit_cache_config_time", 1).intValue();
        mStartMinPreparedFastNetConfigTime = c.X0("qqcircle", "qqcircle_start_min_prepared_fast_net_config_time", 2).intValue();
        mMinPlayingHitCacheTime = c.X0("qqcircle", "qqcircle_min_playing_hit_cache_time", 4).intValue();
        mMinNetworkBandWidth = c.Z0("qqcircle", "qqcircle_min_network_band_width", 800000L).longValue();
    }

    private boolean generateMonitorRatio() {
        boolean z16;
        try {
            if (Math.random() <= c.R1()) {
                z16 = true;
            } else {
                z16 = false;
            }
            QLog.d("FFR-RFWPlayerFirstFrameHelper", 1, "[generateMonitorRatio] isHitFirstFrameMonitorRatio: " + z16);
            return z16;
        } catch (Throwable th5) {
            QLog.e("FFR-RFWPlayerFirstFrameHelper", 1, "[isEnabledFirstFrameMonitor] error: ", th5);
            return false;
        }
    }

    @NonNull
    private List<FeedCloudCommon$Entry> getFirstFrameEntryList(@NonNull RFWFirstFrameBufferReportParam rFWFirstFrameBufferReportParam) {
        File videoCacheFile = getVideoCacheFile(rFWFirstFrameBufferReportParam.mPlayerScene, rFWFirstFrameBufferReportParam.mPlayUrl, rFWFirstFrameBufferReportParam.mVid);
        ArrayList arrayList = new ArrayList();
        arrayList.add(QCircleReportHelper.newEntry("ext3", videoCacheFile.getName()));
        arrayList.add(QCircleReportHelper.newEntry("ext4", String.valueOf(rFWFirstFrameBufferReportParam.mStartPreparedTime)));
        arrayList.add(QCircleReportHelper.newEntry("ext5", String.valueOf(rFWFirstFrameBufferReportParam.isPreparedSuccess)));
        arrayList.add(QCircleReportHelper.newEntry("ext6", String.valueOf(rFWFirstFrameBufferReportParam.mPlayFileLength)));
        arrayList.add(QCircleReportHelper.newEntry("ext7", String.valueOf(rFWFirstFrameBufferReportParam.mPlayFileTimeCost)));
        arrayList.add(QCircleReportHelper.newEntry("ext8", String.valueOf(rFWFirstFrameBufferReportParam.mPlayerBufferTime)));
        arrayList.add(QCircleReportHelper.newEntry("ext9", String.valueOf(rFWFirstFrameBufferReportParam.mPlayerDurationTime)));
        arrayList.add(QCircleReportHelper.newEntry("ext10", String.valueOf(rFWFirstFrameBufferReportParam.mPlayerState)));
        arrayList.add(QCircleReportHelper.newEntry("ext11", String.valueOf(rFWFirstFrameBufferReportParam.mPlayerErrorCode)));
        arrayList.add(QCircleReportHelper.newEntry("ext12", String.valueOf(rFWFirstFrameBufferReportParam.mTriggerScene)));
        arrayList.add(QCircleReportHelper.newEntry("uin", String.valueOf(RFWApplication.getAccountId())));
        arrayList.add(QCircleReportHelper.newEntry("all_frames", String.valueOf(rFWFirstFrameBufferReportParam.mPrepareFileLength)));
        arrayList.add(QCircleReportHelper.newEntry("draw_frames", String.valueOf(0)));
        arrayList.add(QCircleReportHelper.newEntry(StartupReportKey.COLD_LAUNCH, String.valueOf(0)));
        arrayList.add(QCircleReportHelper.newEntry("time_cost", String.valueOf(rFWFirstFrameBufferReportParam.mStartPreparedTime)));
        arrayList.add(QCircleReportHelper.newEntry("app_version", ((IAppSettingApi) QRoute.api(IAppSettingApi.class)).getReportVersionName()));
        arrayList.add(QCircleReportHelper.newEntry("os_version", String.valueOf(ah.t())));
        return arrayList;
    }

    private File getVideoCacheFile(int i3, String str, String str2) {
        return new File(RFWVideoUtils.getLocalCachePath(i3, str, str2));
    }

    public static RFWPlayerFirstFrameHelper instance() {
        if (INSTANCE == null) {
            synchronized (RFWPlayerFirstFrameHelper.class) {
                if (INSTANCE == null) {
                    INSTANCE = new RFWPlayerFirstFrameHelper();
                }
            }
        }
        return INSTANCE;
    }

    public boolean checkFirstBufferForBandWidth(@NonNull RFWFirstFrameBufferReportParam rFWFirstFrameBufferReportParam) {
        if (rFWFirstFrameBufferReportParam.mStartPreparedTime <= mStartMinPreparedFastNetConfigTime) {
            return false;
        }
        long predictSpeedWithOutDownGrade = RFWVideoUtils.getPredictSpeedWithOutDownGrade(rFWFirstFrameBufferReportParam.mPlayerScene);
        if (predictSpeedWithOutDownGrade <= mMinNetworkBandWidth) {
            QLog.d("FFR-RFWPlayerFirstFrameHelper", 4, "[checkFirstBufferForBandWidth] preDictSpeed <= MIN_NETWORK_BAND_WIDTH,preDictSpeed: " + predictSpeedWithOutDownGrade);
            return false;
        }
        List<FeedCloudCommon$Entry> firstFrameEntryList = getFirstFrameEntryList(rFWFirstFrameBufferReportParam);
        firstFrameEntryList.add(QCircleReportHelper.newEntry("event_name", "first_buffer_fast_net_event"));
        RFWVideoReporter.getInstance().report(rFWFirstFrameBufferReportParam.mVideoPlayerId, "first_buffer_fast_net_event", 11011, rFWFirstFrameBufferReportParam.mReportObj, firstFrameEntryList);
        QLog.d("FFR-RFWPlayerFirstFrameHelper", 1, "[checkFirstBufferForBandWidth] report success, startPreparedTime: " + rFWFirstFrameBufferReportParam.mStartPreparedTime + " | preDictSpeed: " + predictSpeedWithOutDownGrade);
        return true;
    }

    public boolean checkFirstBufferForCacheFlow(@NonNull RFWFirstFrameBufferReportParam rFWFirstFrameBufferReportParam) {
        if (rFWFirstFrameBufferReportParam.mStartPreparedTime <= mStartMinPreparedHitCacheConfigTime) {
            return false;
        }
        int i3 = rFWFirstFrameBufferReportParam.mPlayerBufferTime;
        int i16 = mMinPlayingHitCacheTime;
        if (i3 <= i16) {
            QLog.d("FFR-RFWPlayerFirstFrameHelper", 4, "[checkFirstBufferForCacheFlow] param.mPlayerBufferTime <= MIN_PLAYING_HIT_CACHE_TIME, mPlayerBufferTime: " + rFWFirstFrameBufferReportParam.mPlayerBufferTime);
            return false;
        }
        if (rFWFirstFrameBufferReportParam.mPlayFileTimeCost <= i16) {
            QLog.d("FFR-RFWPlayerFirstFrameHelper", 4, "[checkFirstBufferForCacheFlow] param.mPlayerBufferTime <= MIN_PLAYING_HIT_CACHE_TIME, mPlayFileTimeCost: " + rFWFirstFrameBufferReportParam.mPlayFileTimeCost);
            return false;
        }
        List<FeedCloudCommon$Entry> firstFrameEntryList = getFirstFrameEntryList(rFWFirstFrameBufferReportParam);
        firstFrameEntryList.add(QCircleReportHelper.newEntry("event_name", "first_buffer_hit_cache_event"));
        RFWVideoReporter.getInstance().report(rFWFirstFrameBufferReportParam.mVideoPlayerId, "first_buffer_hit_cache_event", 11011, rFWFirstFrameBufferReportParam.mReportObj, firstFrameEntryList);
        QLog.d("FFR-RFWPlayerFirstFrameHelper", 1, "[checkFirstBufferForCacheFlow] report success, startPreparedTime: " + rFWFirstFrameBufferReportParam.mStartPreparedTime + " | mPlayerBufferTime: " + rFWFirstFrameBufferReportParam.mPlayerBufferTime + " | playFileTimeCost: " + rFWFirstFrameBufferReportParam.mPlayFileTimeCost);
        return true;
    }

    public long getFileNameLength(int i3, String str, String str2) {
        try {
            File videoCacheFile = getVideoCacheFile(i3, str, str2);
            long length = videoCacheFile.length();
            if (!videoCacheFile.exists()) {
                QLog.d("FFR-RFWPlayerFirstFrameHelper", 1, "[getFileNameLength] fileName: " + videoCacheFile.getName() + " | file exists: false | localFileLength: " + length);
            }
            if (length <= 0) {
                return 0L;
            }
            return length;
        } catch (Throwable th5) {
            QLog.e("FFR-RFWPlayerFirstFrameHelper", 1, "[getFileNameLength] ex: ", th5);
            return 0L;
        }
    }

    public boolean isEnabledFirstFrameMonitor() {
        if (!c.J5()) {
            return false;
        }
        return this.mIsHitFirstFrameMonitorRatio;
    }
}
