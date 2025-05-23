package com.tencent.biz.richframework.video.rfw.player.monitor;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.video.rfw.RFWPlayer;
import com.tencent.biz.richframework.video.rfw.RFWVideoUtils;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.videoplatform.api.ILog;
import com.tencent.mobileqq.videoplatform.util.LogUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import uq3.c;
import uq3.o;

/* loaded from: classes5.dex */
public class RFWPlayerMonitor {
    private static volatile RFWPlayerMonitor sInstance;
    private boolean mIsInteriorAppVersion;
    private boolean mIsOpenCLR;
    private long mPreCheckOpenMonitorTime = 0;
    private boolean isOpenMonitor = false;
    private final InnerLogImpl mWhiteListColorLogImpl = new InnerLogImpl(true);
    private final Runnable mCloseForceCLR = new Runnable() { // from class: com.tencent.biz.richframework.video.rfw.player.monitor.RFWPlayerMonitor.1
        @Override // java.lang.Runnable
        public void run() {
            RFWPlayerMonitor.this.mIsOpenCLR = false;
            RFWLog.enableCLR(false);
            RFWPlayerMonitor.this.injectColorLog(false);
        }
    };
    private final Runnable mFirstFrameRenderedCLR = new Runnable() { // from class: com.tencent.biz.richframework.video.rfw.player.monitor.RFWPlayerMonitor.2
        @Override // java.lang.Runnable
        public void run() {
            RFWPlayerMonitor.this.upgradeLogLevel(true);
        }
    };
    private final Map<Long, QFSPlayInnerRecord> mPlayRecord = new ConcurrentHashMap();
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class InnerLogImpl implements ILog {
        private final boolean mForceColorLevel;

        InnerLogImpl(boolean z16) {
            this.mForceColorLevel = z16;
        }

        private int redirectLevel(int i3) {
            if (i3 == 2 && this.mForceColorLevel) {
                return 1;
            }
            return i3;
        }

        @Override // com.tencent.mobileqq.videoplatform.api.ILog
        public void d(String str, int i3, String str2) {
            QLog.d(str, redirectLevel(i3), str2);
        }

        @Override // com.tencent.mobileqq.videoplatform.api.ILog
        public void e(String str, int i3, String str2) {
            QLog.e(str, redirectLevel(i3), str2);
        }

        @Override // com.tencent.mobileqq.videoplatform.api.ILog
        public void i(String str, int i3, String str2) {
            QLog.i(str, redirectLevel(i3), str2);
        }

        @Override // com.tencent.mobileqq.videoplatform.api.ILog
        public boolean isColorLevel() {
            if (!this.mForceColorLevel && !QLog.isColorLevel()) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mobileqq.videoplatform.api.ILog
        public void v(String str, int i3, String str2) {
            QLog.d(str, redirectLevel(i3), str2);
        }

        @Override // com.tencent.mobileqq.videoplatform.api.ILog
        public void w(String str, int i3, String str2) {
            QLog.w(str, redirectLevel(i3), str2);
        }

        @Override // com.tencent.mobileqq.videoplatform.api.ILog
        public void e(String str, int i3, String str2, Throwable th5) {
            QLog.e(str, redirectLevel(i3), str2, th5);
        }
    }

    /* loaded from: classes5.dex */
    public static class QFSPlayInnerRecord {
        public static Gson sGson = new Gson();

        @SerializedName("gtl")
        public List<GapTimeBean> mGapTimeList = new ArrayList();

        @SerializedName("lp")
        public long mLastPosition;

        @SerializedName("lt")
        public long mLastUpdateTime;

        @SerializedName("pgt")
        public GapTimeBean mPendingGapTimeBean;

        /* loaded from: classes5.dex */
        public static class GapTimeBean {

            @SerializedName("gt")
            public long mGapTime;

            @SerializedName(DomainData.DOMAIN_NAME)
            public boolean mNetworkAvailable = NetworkUtil.isNetworkAvailable();

            @SerializedName(ReportConstant.COSTREPORT_PREFIX)
            public long mSpeed;

            GapTimeBean(long j3, int i3) {
                this.mGapTime = j3;
                this.mSpeed = RFWVideoUtils.getPredictSpeedWithOutDownGrade(i3);
            }
        }

        QFSPlayInnerRecord(long j3) {
            updatePosition(j3);
        }

        private void resetPendGapTime() {
            this.mPendingGapTimeBean = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updatePosition(long j3) {
            this.mLastPosition = j3;
            updateRecordTime();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updateRecordTime() {
            this.mLastUpdateTime = System.currentTimeMillis();
            resetPendGapTime();
        }

        public GapTimeBean startRecordGapTime(long j3, int i3) {
            GapTimeBean gapTimeBean = this.mPendingGapTimeBean;
            if (gapTimeBean == null) {
                GapTimeBean gapTimeBean2 = new GapTimeBean(j3, i3);
                this.mPendingGapTimeBean = gapTimeBean2;
                this.mGapTimeList.add(gapTimeBean2);
            } else {
                gapTimeBean.mGapTime = j3;
            }
            return this.mPendingGapTimeBean;
        }

        public String toJson() {
            try {
                return sGson.toJson(this);
            } catch (Exception unused) {
                return "";
            }
        }
    }

    RFWPlayerMonitor() {
        boolean z16 = false;
        this.mIsInteriorAppVersion = false;
        IAppSettingApi iAppSettingApi = (IAppSettingApi) QRoute.api(IAppSettingApi.class);
        if (!iAppSettingApi.isPublicVersion() && !iAppSettingApi.isGrayVersion()) {
            z16 = true;
        }
        this.mIsInteriorAppVersion = z16;
        if (z16) {
            RFWLog.enableCLR(true);
            injectColorLog(true);
            QLog.d("QFSPlayerMonitor", 1, "[QFSPlayerMonitor] print player color log.");
        }
    }

    public static RFWPlayerMonitor g() {
        if (sInstance == null) {
            synchronized (RFWPlayerMonitor.class) {
                if (sInstance == null) {
                    sInstance = new RFWPlayerMonitor();
                }
            }
        }
        return sInstance;
    }

    private int getPlayerOpenLogCLRGapTime() {
        return c.Q2();
    }

    private int getReportTempCLRDuration() {
        return c.j4();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void injectColorLog(boolean z16) {
        if (isConfigColorUserWhiteList()) {
            LogUtil.setLogImp(this.mWhiteListColorLogImpl);
        } else {
            LogUtil.setLogImp(new InnerLogImpl(z16));
        }
    }

    private boolean isConfigColorUserWhiteList() {
        return o.a1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logInner(String str) {
        RFWLog.i("QFSPlayerMonitor", RFWLog.USR, str);
    }

    private boolean openPlayerProgressMonitor() {
        if (System.currentTimeMillis() - this.mPreCheckOpenMonitorTime >= 500) {
            this.mPreCheckOpenMonitorTime = System.currentTimeMillis();
            this.isOpenMonitor = c.Z6();
        }
        return this.isOpenMonitor;
    }

    public void cancelFirstFrameRenderedColorLog() {
        if (!c.k6() || this.mIsInteriorAppVersion) {
            return;
        }
        logInner("[cancelFirstFrameRenderedColorLog]");
        this.mHandler.removeCallbacks(this.mFirstFrameRenderedCLR);
    }

    public void clearPlayRecord() {
        this.mPlayRecord.clear();
    }

    public QFSPlayInnerRecord removePlayRecord(RFWPlayer rFWPlayer) {
        return this.mPlayRecord.remove(Long.valueOf(rFWPlayer.getVideoPlayId()));
    }

    public void resetPosition(RFWPlayerOptions rFWPlayerOptions) {
        QFSPlayInnerRecord qFSPlayInnerRecord;
        if (!openPlayerProgressMonitor()) {
            return;
        }
        logInner("resetPosition");
        if (rFWPlayerOptions == null) {
            return;
        }
        String tag = rFWPlayerOptions.tag();
        if (!TextUtils.isEmpty(tag) && (qFSPlayInnerRecord = this.mPlayRecord.get(tag)) != null) {
            qFSPlayInnerRecord.updateRecordTime();
        }
    }

    public void startPlayColorLog() {
        if (isConfigColorUserWhiteList()) {
            injectColorLog(true);
            return;
        }
        if (!c.k6() || this.mIsInteriorAppVersion) {
            return;
        }
        logInner("[startFirstFrameRenderedColorLog]");
        long I2 = c.I2(5000L);
        this.mHandler.removeCallbacks(this.mFirstFrameRenderedCLR);
        this.mHandler.postDelayed(this.mFirstFrameRenderedCLR, I2);
    }

    public void updatePosition(RFWPlayer rFWPlayer, RFWPlayerOptions rFWPlayerOptions, long j3) {
        long videoPlayId;
        if (!openPlayerProgressMonitor()) {
            return;
        }
        if (rFWPlayer == null) {
            videoPlayId = 0;
        } else {
            videoPlayId = rFWPlayer.getVideoPlayId();
        }
        if (videoPlayId == 0) {
            return;
        }
        QFSPlayInnerRecord qFSPlayInnerRecord = this.mPlayRecord.get(Long.valueOf(videoPlayId));
        if (qFSPlayInnerRecord == null) {
            this.mPlayRecord.put(Long.valueOf(videoPlayId), new QFSPlayInnerRecord(j3));
            return;
        }
        if (j3 != qFSPlayInnerRecord.mLastPosition) {
            qFSPlayInnerRecord.updatePosition(j3);
            return;
        }
        if (qFSPlayInnerRecord.mLastUpdateTime == 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - qFSPlayInnerRecord.mLastUpdateTime;
        if (currentTimeMillis >= 500) {
            qFSPlayInnerRecord.startRecordGapTime(currentTimeMillis, rFWPlayerOptions.getSceneId());
            if (currentTimeMillis >= getPlayerOpenLogCLRGapTime()) {
                upgradeLogLevel(true);
            }
        }
    }

    public void upgradeLogLevel(boolean z16) {
        if (this.mIsOpenCLR || !openPlayerProgressMonitor() || this.mIsInteriorAppVersion || !NetworkUtil.isNetworkAvailable()) {
            return;
        }
        this.mHandler.post(new Runnable() { // from class: com.tencent.biz.richframework.video.rfw.player.monitor.RFWPlayerMonitor.3
            @Override // java.lang.Runnable
            public void run() {
                RFWPlayerMonitor.this.logInner("upgradeLogLevel");
                RFWPlayerMonitor.this.mIsOpenCLR = true;
                RFWLog.enableCLR(true);
                RFWPlayerMonitor.this.injectColorLog(true);
            }
        });
        if (z16) {
            this.mHandler.removeCallbacks(this.mCloseForceCLR);
            this.mHandler.postDelayed(this.mCloseForceCLR, getReportTempCLRDuration());
        }
    }
}
