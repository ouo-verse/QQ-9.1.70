package com.tencent.biz.richframework.video.rfw.player.report;

import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.video.rfw.RFWPlayerListenerDispatchUtils;
import com.tencent.biz.richframework.video.rfw.RFWVideoUtils;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC;
import com.tencent.biz.richframework.video.rfw.player.monitor.RFWJsonBinder;
import com.tencent.biz.richframework.video.rfw.player.stinfo.RFWPlayerReportInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleReportHelper;
import java.util.ArrayList;
import mqq.app.MobileQQ;

/* loaded from: classes5.dex */
public class RFWPlayerErrorReportHelper {

    /* loaded from: classes5.dex */
    public static final class ReportAttachInfo {
        public String avgSpeed;
        public long downGrade;
        public int errorCode;
        public boolean isDirectIP;
        public boolean isNetworkAvailable;
        public boolean isPreloadTask;
        public int networkType;
        public String traceId;
        public String videoId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class ReportParamBean {
        private boolean isPreloadTask;
        private String mAvgSpeedString;
        private int mErrorCode;
        private RFWPlayerReportInfo mFeed;
        private boolean mIsIpDirect;
        private String mRealPlayUrl;
        private long mVideoPlayId;

        ReportParamBean() {
        }

        public String getAvgSpeedString() {
            return this.mAvgSpeedString;
        }

        public int getErrorCode() {
            return this.mErrorCode;
        }

        public String getRealPlayUrl() {
            return this.mRealPlayUrl;
        }

        public RFWPlayerReportInfo getReportData() {
            return this.mFeed;
        }

        public long getVideoPlayId() {
            return this.mVideoPlayId;
        }

        public boolean isIpDirect() {
            return this.mIsIpDirect;
        }

        public boolean isPreloadTask() {
            return this.isPreloadTask;
        }

        public ReportParamBean setAvgSpeedString(String str) {
            this.mAvgSpeedString = str;
            return this;
        }

        public ReportParamBean setErrorCode(int i3) {
            this.mErrorCode = i3;
            return this;
        }

        public ReportParamBean setIsIPDirect(boolean z16) {
            this.mIsIpDirect = z16;
            return this;
        }

        public ReportParamBean setPreloadTask(boolean z16) {
            this.isPreloadTask = z16;
            return this;
        }

        public ReportParamBean setRealPlayUrl(String str) {
            this.mRealPlayUrl = str;
            return this;
        }

        public ReportParamBean setReportData(RFWPlayerReportInfo rFWPlayerReportInfo) {
            this.mFeed = rFWPlayerReportInfo;
            return this;
        }

        public ReportParamBean setVideoPlayId(long j3) {
            this.mVideoPlayId = j3;
            return this;
        }
    }

    private static RFWPlayerReportInfo getReportData(RFWPlayerOptions rFWPlayerOptions) {
        RFWPlayerIOC ioc;
        if (rFWPlayerOptions == null) {
            ioc = null;
        } else {
            ioc = rFWPlayerOptions.getIOC();
        }
        if (ioc == null) {
            return null;
        }
        return ioc.getBusinessReportInfo();
    }

    private static boolean isPreloadTask(RFWPlayerOptions rFWPlayerOptions) {
        RFWPlayerIOC ioc;
        if (rFWPlayerOptions == null) {
            ioc = null;
        } else {
            ioc = rFWPlayerOptions.getIOC();
        }
        if (ioc != null && ioc.isPreloadTask()) {
            return true;
        }
        return false;
    }

    public static void reportError(RFWPlayerOptions rFWPlayerOptions, long j3, int i3, String str) {
        RFWPlayerReportInfo reportData = getReportData(rFWPlayerOptions);
        if (reportData == null) {
            QLog.e("RFWPlayerErrorReportHelper", 1, "[reportError] feed should not be null.");
            return;
        }
        ReportParamBean reportParamBean = new ReportParamBean();
        reportParamBean.setReportData(reportData);
        reportParamBean.setPreloadTask(isPreloadTask(rFWPlayerOptions));
        reportParamBean.setVideoPlayId(j3);
        reportParamBean.setErrorCode(i3);
        reportParamBean.setAvgSpeedString(str);
        reportParamBean.setRealPlayUrl(TextUtils.isEmpty(rFWPlayerOptions.getTargetIPURL()) ? rFWPlayerOptions.getRealPlayUrl() : rFWPlayerOptions.getTargetIPURL());
        reportParamBean.setIsIPDirect(rFWPlayerOptions.isPlayerByDirectIP());
        reportError(rFWPlayerOptions, reportParamBean, rFWPlayerOptions.getSceneId());
    }

    private static void reportError(RFWPlayerOptions rFWPlayerOptions, ReportParamBean reportParamBean, int i3) {
        if (reportParamBean == null) {
            QLog.d("RFWPlayerErrorReportHelper", 1, "[reportError] report param bean should not be null.");
            return;
        }
        String realPlayUrl = reportParamBean.getRealPlayUrl();
        if (realPlayUrl == null) {
            realPlayUrl = "";
        }
        RFWPlayerReportInfo reportData = reportParamBean.getReportData();
        String videoId = reportData.getVideoId();
        int errorCode = reportParamBean.getErrorCode();
        ReportAttachInfo reportAttachInfo = new ReportAttachInfo();
        reportAttachInfo.videoId = videoId;
        reportAttachInfo.errorCode = errorCode;
        reportAttachInfo.avgSpeed = reportParamBean.getAvgSpeedString();
        reportAttachInfo.isPreloadTask = reportParamBean.isPreloadTask();
        reportAttachInfo.traceId = reportData.getTraceId();
        reportAttachInfo.isDirectIP = reportParamBean.isIpDirect();
        try {
            reportAttachInfo.isNetworkAvailable = NetworkUtil.isNetworkAvailable(MobileQQ.sMobileQQ);
            reportAttachInfo.networkType = NetworkUtil.getNetworkType(RFWApplication.getApplication());
            reportAttachInfo.downGrade = RFWVideoUtils.getPredictSpeedWithOutDownGrade(i3);
        } catch (Throwable th5) {
            QLog.d("RFWPlayerErrorReportHelper", 1, "[reportError] error: ", th5);
        }
        String json = RFWJsonBinder.getInstance().toJson(reportAttachInfo);
        ArrayList arrayList = new ArrayList();
        arrayList.add(QCircleReportHelper.newEntry("video_url", realPlayUrl));
        String feedId = reportData.getFeedId();
        arrayList.add(QCircleReportHelper.newEntry("feed_id", feedId));
        arrayList.add(QCircleReportHelper.newEntry("attach_info", json));
        QLog.d("RFWPlayerErrorReportHelper", 1, "[reportError] report player error attachJson: " + json + " | feedId: " + feedId + " | realPlayerUrl: " + realPlayUrl);
        RFWVideoReporter.getInstance().report(reportParamBean.getVideoPlayId(), "video_play_error", reportData, arrayList);
        RFWPlayerListenerDispatchUtils.notifyReportFront(rFWPlayerOptions, reportParamBean.getVideoPlayId(), "video_play_error", arrayList);
    }
}
