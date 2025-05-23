package com.tencent.biz.richframework.video.rfw.player.playinterceptor;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.video.QUICStatus;
import com.tencent.biz.richframework.video.rfw.RFWPlayer;
import com.tencent.biz.richframework.video.rfw.RFWPlayerListenerDispatchUtils;
import com.tencent.biz.richframework.video.rfw.RFWVideoUtils;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.exp.RFWPostAtFrontUtils;
import com.tencent.biz.richframework.video.rfw.player.monitor.RFWPlayerMonitor;
import com.tencent.biz.richframework.video.rfw.player.monitor.RFWPlayerMonitorImpl;
import com.tencent.biz.richframework.video.rfw.player.playinterceptor.controller.RFWBaseInterceptorController;
import com.tencent.biz.richframework.video.rfw.player.report.RFWPlayerErrorReportHelper;
import com.tencent.biz.richframework.video.rfw.player.report.RFWPlayerNetFlowReporter;
import com.tencent.biz.richframework.video.rfw.player.stinfo.RFWPlayerReportInfo;
import com.tencent.biz.richframework.video.rfw.player.strategy.RFWVideoDataDownLoadStatistic;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.tools.DeviceInfoUtils;
import com.tencent.richframework.sender.util.EventControlUtils;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerDownOption;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.thumbplayer.api.TPPlayerMsg;
import com.tencent.thumbplayer.api.common.TPDownloadProgressInfo;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qqcircle.report.QFSNetFlowReporter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import org.json.JSONException;
import org.json.JSONObject;
import uq3.o;

/* loaded from: classes5.dex */
public class RFWPlayerPerfReportInterceptor extends RFWPlayerBaseInterceptor {
    private long mBufferBeginTime;
    private String mCDNIp;
    private RFWVideoDataDownLoadStatistic mDownLoadStatistic;
    public String mDownloadRetCode;
    private int mDownloadTime;
    private int mDownloadTotalSpeed;
    protected boolean mHasBufferEnd;
    private boolean mHasDownloadComplete;
    private boolean mHaseHitCache;
    private String mIp;
    private boolean mIsByOffset;
    private boolean mIsSeeking;
    private long mLocalCacheSize;
    private int mMaxDownLoadKBps;
    private int mMinDownLoadKBps;
    private long mMixFlowCost;
    private long mOffsetSeekCompleteTime;
    private RFWPlayerNetFlowReporter.PlayerNetFlowBean mPlayerNetFlowBean;
    private QUICStatus mQUICStatus;
    private long mReportPlayerTime;
    private int mSecondBufferCount;
    private long mSecondBufferTime;
    private long mStartPlayPositionForReport;
    private long mStartPreparedTime;
    private long mStartSeekTime;
    private TPDownloadProgressInfo mTPDownLoadProgressInfo;
    private long mTimelineAvgSpeedKB;
    private long mTotalFileSize;
    private final LinkedList<Long> mVideoPlayTimeBaseVideoPosList;
    private final LinkedList<Pair<Long, Long>> mVideoPlayTimeRangeList;
    private final Stack<Pair<Long, Long>> mVideoSoloPlayTimeRangeList;

    public RFWPlayerPerfReportInterceptor(RFWBaseInterceptorController rFWBaseInterceptorController) {
        super(rFWBaseInterceptorController);
        this.mDownloadRetCode = String.valueOf(0);
        this.mMinDownLoadKBps = 0;
        this.mMaxDownLoadKBps = 0;
        this.mHasBufferEnd = false;
        this.mVideoPlayTimeBaseVideoPosList = new LinkedList<>();
        this.mVideoSoloPlayTimeRangeList = new Stack<>();
        this.mVideoPlayTimeRangeList = new LinkedList<>();
    }

    private synchronized void addToVideoPlayTimeRangeList(long j3) {
        if (!this.mPlayer.enableReport()) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        RFWLog.d(getTag(), RFWLog.USR, "addToVideoPlayTimeRangeList: [start=", Long.valueOf(j3), ", end=", Long.valueOf(currentTimeMillis), ", timecost=", Long.valueOf(currentTimeMillis - j3), "]");
        this.mVideoPlayTimeRangeList.add(new Pair<>(Long.valueOf(j3), Long.valueOf(currentTimeMillis)));
    }

    private synchronized void addToVideoSoloPlayTimeRangeList(long j3, long j16) {
        if (!this.mPlayer.enableReport()) {
            return;
        }
        RFWLog.d(getTag(), RFWLog.USR, "addToVideoSoloPlayTimeRangeList: [start=" + j3 + ", end=" + j16 + "]");
        Iterator<Pair<Long, Long>> it = this.mVideoSoloPlayTimeRangeList.iterator();
        while (it.hasNext()) {
            Pair<Long, Long> next = it.next();
            if (((Long) next.first).longValue() <= j3 && ((Long) next.second).longValue() >= j16) {
                RFWLog.d(getTag(), RFWLog.USR, "addToVideoSoloPlayTimeRangeList: already contained [start=" + j3 + ", end=" + j16 + "]");
                return;
            }
        }
        Iterator<Pair<Long, Long>> it5 = this.mVideoSoloPlayTimeRangeList.iterator();
        while (it5.hasNext()) {
            Pair<Long, Long> next2 = it5.next();
            if (j3 <= ((Long) next2.first).longValue() && j16 >= ((Long) next2.second).longValue()) {
                RFWLog.d(getTag(), RFWLog.USR, "addToVideoSoloPlayTimeRangeList: remove [start=" + next2.first + ", end=" + next2.second + "]");
                it5.remove();
            }
        }
        Iterator<Pair<Long, Long>> it6 = this.mVideoSoloPlayTimeRangeList.iterator();
        while (it6.hasNext()) {
            Pair<Long, Long> next3 = it6.next();
            if (j3 >= ((Long) next3.first).longValue() && j3 <= ((Long) next3.second).longValue()) {
                j3 = ((Long) next3.second).longValue();
            }
            if (j16 >= ((Long) next3.first).longValue() && j16 <= ((Long) next3.second).longValue()) {
                j16 = ((Long) next3.first).longValue();
            }
        }
        if (j3 >= 0 && j3 <= j16) {
            RFWLog.d(getTag(), RFWLog.USR, "addToVideoSoloPlayTimeRangeList: already contained after adjustment [start=" + j3 + ", end=" + j16 + "]");
            this.mVideoSoloPlayTimeRangeList.add(new Pair<>(Long.valueOf(j3), Long.valueOf(j16)));
            return;
        }
        RFWLog.d(getTag(), RFWLog.USR, "addToVideoSoloPlayTimeRangeList: already contained after adjustment [start=" + j3 + ", end=" + j16 + "]");
    }

    private synchronized void addTomVideoPlayTimeBaseVideoPosList(long j3) {
        if (!this.mPlayer.enableReport()) {
            return;
        }
        this.mVideoPlayTimeBaseVideoPosList.add(Long.valueOf(j3));
    }

    private String appendAttachInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        boolean isFirstPlayer = this.mPlayerOptions.isFirstPlayer();
        RFWLog.d(getTag(), RFWLog.DEV, "appendAttachInfo:" + (isFirstPlayer ? 1 : 0));
        return str + ",isFirst:" + (isFirstPlayer ? 1 : 0);
    }

    private void checkIsCompleteCache() {
        this.mHaseHitCache = RFWVideoUtils.checkCacheExist(this.mPlayerOptions.getSceneId(), this.mPlayerOptions.getRealPlayUrl(), this.mPlayerOptions.getFileId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: doOnPause, reason: merged with bridge method [inline-methods] */
    public void lambda$onPause$0(long j3) {
        if (this.mReportPlayerTime > 0) {
            addToVideoSoloPlayTimeRangeList(this.mStartPlayPositionForReport, j3);
            addToVideoPlayTimeRangeList(this.mReportPlayerTime);
            addTomVideoPlayTimeBaseVideoPosList(j3);
            RFWPlayerListenerDispatchUtils.onVideoPassivePause(this.mPlayerOptions, 0, 0, getPlayTime(), getVideoSoloPlayTime(), getPlayTimeBaseVideoPos());
        }
        this.mReportPlayerTime = 0L;
    }

    private void downGradeVideoIfNeed() {
        if (this.mSecondBufferCount < uq3.c.i1() || this.mSecondBufferTime < uq3.c.j1()) {
            return;
        }
        RFWPlayerListenerDispatchUtils.onDowngradeVideoUrl(this.mPlayerOptions);
    }

    private void firstFrameRender() {
        String valueOf;
        if (this.mOffsetSeekCompleteTime > 0) {
            valueOf = String.valueOf(((float) (System.currentTimeMillis() - this.mOffsetSeekCompleteTime)) / 1000.0f);
            RFWLog.d(getTag(), RFWLog.USR, "firstFrameRender by seekComplete timeCost= " + valueOf + "|isFromPreload:" + this.mPlayerOptions.isPreloadPlayer() + " |enableReport:" + this.mPlayer.enableReport());
            this.mOffsetSeekCompleteTime = 0L;
        } else {
            valueOf = String.valueOf(((float) (System.currentTimeMillis() - this.mStartPreparedTime)) / 1000.0f);
            RFWLog.d(getTag(), RFWLog.USR, "firstFrameRender timeCost= " + valueOf + "|isFromPreload:" + this.mPlayerOptions.isPreloadPlayer() + " |enableReport:" + this.mPlayer.enableReport());
        }
        if (!this.mPlayer.enableReport()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(QCircleReportHelper.newEntry("time_cost", valueOf));
        if (!TextUtils.isEmpty(getDtCustomPageId())) {
            String appendAttachInfo = appendAttachInfo("dtCustomPageId:" + getDtCustomPageId());
            String schemeToPlayTotalTime = getSchemeToPlayTotalTime();
            if (this.mPlayerOptions.isFirstPlayer()) {
                appendAttachInfo = appendAttachInfo + ",rt:" + schemeToPlayTotalTime;
                RFWLog.d(getTag(), RFWLog.CLR, "firstFrameRender timeCost schemeToPlayTotalTime= " + schemeToPlayTotalTime);
            }
            arrayList.add(QCircleReportHelper.newEntry("attach_info", appendAttachInfo));
        }
        report(QCircleFolderFunnelCollect.PERIOD_FOLDER_VIDEO_FIRST_RENDER, arrayList);
    }

    private long getAverageDownloadSpeeds() {
        if (this.mDownloadTime == 0) {
            return 0L;
        }
        return this.mDownloadTotalSpeed / r0;
    }

    private String getAvgSpeedString() {
        return getAverageDownloadSpeeds() + "|" + this.mMaxDownLoadKBps + "|" + this.mMinDownLoadKBps + "|" + this.mTimelineAvgSpeedKB;
    }

    private String getSchemeToPlayTotalTime() {
        if (this.mPlayerOptions.getIOC() != null && this.mPlayerOptions.getIOC().getUpperData() != null && (this.mPlayerOptions.getIOC().getUpperData().getValue("KEY_PAGE_START_TIME_MS") instanceof Long)) {
            return String.valueOf(((float) (System.currentTimeMillis() - ((Long) this.mPlayerOptions.getIOC().getUpperData().getValue("KEY_PAGE_START_TIME_MS")).longValue())) / 1000.0f);
        }
        return "";
    }

    private void handleCDNUrlInfo(TPPlayerMsg.TPCDNURLInfo tPCDNURLInfo) {
        this.mCDNIp = tPCDNURLInfo.cdnIp;
        this.mIp = tPCDNURLInfo.uIp;
    }

    private void handleDownloadInfo(TPDownloadProgressInfo tPDownloadProgressInfo) {
        int downloadSpeedbps = (int) tPDownloadProgressInfo.getDownloadSpeedbps();
        if (isDownloadChange(tPDownloadProgressInfo) && EventControlUtils.throttlingAtOnce(getTag(), 5000L)) {
            RFWLog.d(getTag(), RFWLog.USR, "extra info handleDownloadInfo = " + tPDownloadProgressInfo.getExtraInfo());
        }
        this.mTotalFileSize = tPDownloadProgressInfo.getFileTotalBytes();
        if (!this.mHasDownloadComplete) {
            this.mMinDownLoadKBps = Math.min(downloadSpeedbps, this.mMinDownLoadKBps);
            this.mMaxDownLoadKBps = Math.max(downloadSpeedbps, this.mMaxDownLoadKBps);
            this.mDownloadTime++;
            this.mDownloadTotalSpeed += downloadSpeedbps;
            parseExtraInfo(tPDownloadProgressInfo);
        }
    }

    private void initDownLoadStatic() {
        if (this.mDownLoadStatistic != null) {
            return;
        }
        this.mDownLoadStatistic = new RFWVideoDataDownLoadStatistic();
    }

    private void initQUICStatus() {
        QUICStatus qUICStatus = new QUICStatus(this.mPlayerOptions.getRealPlayUrl());
        this.mQUICStatus = qUICStatus;
        qUICStatus.setQUICListener(new QUICStatus.QUICListener() { // from class: com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerPerfReportInterceptor.1
            @Override // com.tencent.biz.richframework.video.QUICStatus.QUICListener
            public void reportQUICTOHttp(QUICStatus qUICStatus2) {
                RFWPlayerPerfReportInterceptor.this.report("video_quic_to_http", null);
            }
        });
    }

    private boolean isDownloadChange(TPDownloadProgressInfo tPDownloadProgressInfo) {
        boolean z16 = true;
        if (tPDownloadProgressInfo != null && this.mTPDownLoadProgressInfo != null && tPDownloadProgressInfo.getAvailablePositionMs() == this.mTPDownLoadProgressInfo.getAvailablePositionMs() && tPDownloadProgressInfo.getDownloadSpeedbps() == this.mTPDownLoadProgressInfo.getDownloadSpeedbps() && tPDownloadProgressInfo.getDownloadBytes() == this.mTPDownLoadProgressInfo.getDownloadBytes() && tPDownloadProgressInfo.getFileTotalBytes() == this.mTPDownLoadProgressInfo.getFileTotalBytes()) {
            z16 = false;
        }
        this.mTPDownLoadProgressInfo = tPDownloadProgressInfo;
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onPause$1(RFWPlayer rFWPlayer) {
        final long currentPositionMs = rFWPlayer.getCurrentPositionMs();
        RFWPostAtFrontUtils.post(RFWThreadManager.getUIHandler(), new Runnable() { // from class: com.tencent.biz.richframework.video.rfw.player.playinterceptor.d
            @Override // java.lang.Runnable
            public final void run() {
                RFWPlayerPerfReportInterceptor.this.lambda$onPause$0(currentPositionMs);
            }
        });
    }

    private void onQUICComplete(JSONObject jSONObject) throws JSONException {
        if (jSONObject.has("downloadComplete") && this.mQUICStatus != null) {
            String string = jSONObject.getString("downloadComplete");
            if (TextUtils.equals(string, "quic")) {
                this.mQUICStatus.increaseQUICCompleteCount();
            } else if (TextUtils.equals(string, "http")) {
                this.mQUICStatus.increaseHttpCompleteCount();
            }
        }
    }

    private void onQUICDownload(JSONObject jSONObject) {
        QUICStatus qUICStatus;
        if (jSONObject.has("isDownloadByQuic") && (qUICStatus = this.mQUICStatus) != null) {
            qUICStatus.setIsDownLoadByQUIC();
        }
    }

    private void onQUICFailed(JSONObject jSONObject) throws JSONException {
        if (jSONObject.has("downloadFailed") && this.mQUICStatus != null) {
            String string = jSONObject.getString("downloadFailed");
            if (TextUtils.equals(string, "quic")) {
                this.mQUICStatus.increaseQUICFailedCount();
            } else if (TextUtils.equals(string, "http")) {
                this.mQUICStatus.increaseHTTPFailedCount();
            }
        }
    }

    private void onQUICInfoUpdate(String str) {
        if (this.mQUICStatus == null) {
            RFWLog.d(getTag(), RFWLog.USR, "mQUICStatus null ");
        }
        if (TextUtils.isEmpty(str)) {
            RFWLog.d(getTag(), RFWLog.USR, "onQUICInfoUpdate np json");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            onQUICDownload(jSONObject);
            onQUICComplete(jSONObject);
            onQUICFailed(jSONObject);
        } catch (JSONException unused) {
            RFWLog.d(getTag(), RFWLog.USR, "onQUICInfoUpdate error");
        }
    }

    private void parseExtraInfo(TPDownloadProgressInfo tPDownloadProgressInfo) {
        if (tPDownloadProgressInfo == null) {
            return;
        }
        long downloadBytes = tPDownloadProgressInfo.getDownloadBytes() - this.mLocalCacheSize;
        if (downloadBytes > 0 && tPDownloadProgressInfo.getDownloadSpeedbps() > 0) {
            QFSNetFlowReporter.reportFlowCost(QFSNetFlowReporter.QFS_FLOW_COST_SCENE_SPLIT_VIDEO_DOWNLOAD, this.mPlayerOptions.getPlayUrl(), "", downloadBytes, downloadBytes / tPDownloadProgressInfo.getDownloadSpeedbps(), getTag(), "");
        }
        try {
            JSONObject jSONObject = new JSONObject(tPDownloadProgressInfo.getExtraInfo());
            if (jSONObject.has("hitDownloaded")) {
                boolean z16 = true;
                if (jSONObject.getInt("hitDownloaded") != 1) {
                    z16 = false;
                }
                this.mHaseHitCache = z16;
                QLog.d(getTag(), 2, "extra info isHasHitCache = " + this.mHaseHitCache);
            }
            long downloadBytes2 = tPDownloadProgressInfo.getDownloadBytes();
            this.mLocalCacheSize = downloadBytes2;
            if (downloadBytes2 == 0 && jSONObject.has("localCacheSize")) {
                this.mLocalCacheSize = jSONObject.getLong("localCacheSize");
            }
            if (jSONObject.has("httpAvgSpeedKB")) {
                this.mTimelineAvgSpeedKB = jSONObject.getLong("httpAvgSpeedKB");
            }
            RFWVideoDataDownLoadStatistic rFWVideoDataDownLoadStatistic = this.mDownLoadStatistic;
            if (rFWVideoDataDownLoadStatistic != null) {
                rFWVideoDataDownLoadStatistic.updateDownLoadInfo(jSONObject);
                this.mMixFlowCost = this.mDownLoadStatistic.getHttpCount() + this.mDownLoadStatistic.getP2PCount() + this.mDownLoadStatistic.getPCDNCount();
                updateNetFlowReportBean(this.mDownLoadStatistic.getHttpCount() - this.mDownLoadStatistic.getPCDNCount(), this.mDownLoadStatistic.getPCDNCount());
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private void playerReport() {
        RFWPlayer rFWPlayer;
        if (this.mReportPlayerTime > 0 && (rFWPlayer = this.mPlayer) != null) {
            addToVideoSoloPlayTimeRangeList(this.mStartPlayPositionForReport, rFWPlayer.getCurrentPositionMs());
            addToVideoPlayTimeRangeList(this.mReportPlayerTime);
            addTomVideoPlayTimeBaseVideoPosList(this.mPlayer.getCurrentPositionMs());
            RFWPlayerListenerDispatchUtils.onVideoPassivePause(this.mPlayerOptions, 0, 0, getPlayTime(), getVideoSoloPlayTime(), getPlayTimeBaseVideoPos());
            this.mReportPlayerTime = 0L;
            this.mStartPlayPositionForReport = 0L;
            double durationMs = this.mPlayer.getDurationMs();
            long totalPlayTime = getTotalPlayTime();
            double min = Math.min(100.0d, (totalPlayTime / durationMs) * 100.0d);
            ArrayList arrayList = new ArrayList();
            arrayList.add(QCircleReportHelper.newEntry("ret_code", String.valueOf(0)));
            long j3 = totalPlayTime / 1000;
            arrayList.add(QCircleReportHelper.newEntry("time_cost", String.valueOf(j3)));
            String str = "";
            if (!TextUtils.isEmpty(this.mCDNIp)) {
                arrayList.add(QCircleReportHelper.newEntry("server_ip", this.mCDNIp));
                str = "cdnIp:" + this.mCDNIp;
            }
            if (!TextUtils.isEmpty(this.mIp)) {
                str = str + ",ip:" + this.mIp;
            }
            if (!TextUtils.isEmpty(getDtCustomPageId())) {
                str = str + ",dtCustomPageId:" + getDtCustomPageId();
            }
            arrayList.add(QCircleReportHelper.newEntry("attach_info", appendAttachInfo(str)));
            report("video_play_ret", arrayList);
            reportCacheHit();
            String avgSpeedString = getAvgSpeedString();
            RFWLog.i(getTag(), RFWLog.USR, "ReportCurrentAvgSpeed:" + avgSpeedString);
            report("video_download_avg_speed", Collections.singletonList(QCircleReportHelper.newEntry("attach_info", avgSpeedString)));
            report("video_play_time_duration", Collections.singletonList(QCircleReportHelper.newEntry("time_cost", String.valueOf(j3))));
            report("video_play_complete_rate", Collections.singletonList(QCircleReportHelper.newEntry("rate", String.format("%.2f", Double.valueOf(min)))));
            reportVideoBufferPercent();
            reportSecondBufferCount();
            reportDownloadRet();
            reportP2PEnable();
            reportP2pDownLoadCount();
            reportPlayNoChangeError();
        }
        totalTimeReport();
        reportRMonit();
        reportDownLoadSize();
        reportPlayerNetFlow();
        flushDcReport();
    }

    private void printIpInfo(@NonNull TPPlayerMsg.TPCDNURLInfo tPCDNURLInfo) {
        if (TextUtils.isEmpty(this.mCDNIp) || TextUtils.isEmpty(this.mIp) || !this.mCDNIp.equals(tPCDNURLInfo.cdnIp) || !this.mIp.equals(tPCDNURLInfo.uIp)) {
            RFWLog.i(getTag(), RFWLog.USR, "TPPlayerMsg.TPCDNURLInfo:cdnIp:" + tPCDNURLInfo.cdnIp + " |errStr:" + tPCDNURLInfo.errorStr + " |ip:" + tPCDNURLInfo.uIp + " |url:" + tPCDNURLInfo.url);
        }
    }

    private void reportCacheHit() {
        String valueOf;
        ArrayList arrayList = new ArrayList();
        if (this.mPlayer.isHasHitCache()) {
            valueOf = String.valueOf(1);
        } else {
            valueOf = String.valueOf(0);
        }
        arrayList.add(QCircleReportHelper.newEntry("ret_code", valueOf));
        if (!TextUtils.isEmpty(getDtCustomPageId())) {
            arrayList.add(QCircleReportHelper.newEntry("attach_info", appendAttachInfo("dtCustomPageId:" + getDtCustomPageId())));
        }
        report("video_play_cache", arrayList);
    }

    private void reportDownLoadSize() {
        if (this.mMixFlowCost > 0) {
            RFWLog.d(getTag(), RFWLog.DEV, "[parseExtraInfo] -> all flow cost size = " + this.mMixFlowCost);
            QFSNetFlowReporter.reportFlowCost(QFSNetFlowReporter.QFS_FLOW_COST_SCENE_VIDEO_MIX_FLOW_COUNT, this.mPlayerOptions.getPlayUrl(), "", this.mMixFlowCost, 0L, getTag(), "");
        }
    }

    private void reportDownloadRet() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(QCircleReportHelper.newEntry("ret_code", this.mDownloadRetCode));
        if (!TextUtils.isEmpty(getDtCustomPageId())) {
            arrayList.add(QCircleReportHelper.newEntry("attach_info", appendAttachInfo("dtCustomPageId:" + getDtCustomPageId())));
        }
        report("video_download_ret", arrayList);
    }

    private void reportP2PEnable() {
        SuperPlayerOption superPlayerOption = this.mPlayer.getSuperPlayerOption();
        if (superPlayerOption == null) {
            return;
        }
        SuperPlayerDownOption superPlayerDownOption = superPlayerOption.superPlayerDownOption;
        boolean z16 = superPlayerDownOption.enableP2P;
        boolean z17 = superPlayerDownOption.enablePcdn;
        report("video_enable_p2p", Collections.singletonList(QCircleReportHelper.newEntry("attach_info", String.valueOf(z16))));
        report("video_enable_pcdn", Collections.singletonList(QCircleReportHelper.newEntry("attach_info", String.valueOf(z17))));
    }

    private void reportP2pDownLoadCount() {
        RFWVideoDataDownLoadStatistic rFWVideoDataDownLoadStatistic = this.mDownLoadStatistic;
        if (rFWVideoDataDownLoadStatistic == null) {
            return;
        }
        report("video_http_download_count", Collections.singletonList(QCircleReportHelper.newEntry("attach_info", String.valueOf(rFWVideoDataDownLoadStatistic.getHttpCount()))));
        report("video_pcdn_download_count", Collections.singletonList(QCircleReportHelper.newEntry("attach_info", String.valueOf(this.mDownLoadStatistic.getPCDNCount()))));
        report("video_p2p_download_count", Collections.singletonList(QCircleReportHelper.newEntry("attach_info", String.valueOf(this.mDownLoadStatistic.getP2PCount()))));
    }

    private void reportPlayNoChangeError() {
        List<RFWPlayerMonitor.QFSPlayInnerRecord.GapTimeBean> list;
        RFWPlayerMonitor.QFSPlayInnerRecord removePlayRecord = RFWPlayerMonitor.g().removePlayRecord(this.mPlayer);
        if (removePlayRecord != null && (list = removePlayRecord.mGapTimeList) != null && !list.isEmpty()) {
            String json = removePlayRecord.toJson();
            RFWLog.d(getTag(), RFWLog.USR, "reportPlayNoChangeError id:" + this.mPlayer.getVideoPlayId() + "recordInfo:" + json);
            StringBuilder sb5 = new StringBuilder();
            sb5.append(this.mPlayer.getRealPlayer().getCurrentPlayerState());
            sb5.append("_");
            sb5.append(NetworkUtil.getNetworkType(RFWApplication.getApplication()));
            report("video_progress_no_change", Arrays.asList(QCircleReportHelper.newEntry("server_ip", json), QCircleReportHelper.newEntry("attach_info", sb5.toString())));
        }
    }

    private void reportPlayerNetFlow() {
        RFWPlayerNetFlowReporter.reportPlayerNetFlow(this.mPlayerNetFlowBean);
    }

    private void reportRMonit() {
        RFWPlayerMonitorImpl.instance().handleReport(this.mPlayerOptions.getIOC().getBusinessReportInfo(), this.mPlayerOptions.getRealPlayUrl());
    }

    private void reportSecondBufferCount() {
        String str;
        if (!TextUtils.isEmpty(getDtCustomPageId())) {
            str = appendAttachInfo("dtCustomPageId:" + getDtCustomPageId());
        } else {
            str = "";
        }
        if (this.mSecondBufferCount > 0) {
            if (!this.mHasBufferEnd && this.mBufferBeginTime > 0) {
                this.mSecondBufferTime += System.currentTimeMillis() - this.mBufferBeginTime;
                RFWLog.i(getTag(), RFWLog.USR, "PLAYER_INFO_BUFFERING_HAS_NOT_END mSecondBufferCount:" + this.mSecondBufferCount + "mSecondBufferTime" + (this.mSecondBufferTime / 1000));
            }
            RFWLog.i(getTag(), RFWLog.USR, "PLAYER_INFO_BUFFERING_REPORT mSecondBufferCount:" + this.mSecondBufferCount + "mSecondBufferTime:" + (this.mSecondBufferTime / 1000));
            ArrayList arrayList = new ArrayList();
            arrayList.add(QCircleReportHelper.newEntry("buffer_count", String.valueOf(this.mSecondBufferCount)));
            report("video_play_occur_buffer_times", arrayList);
            arrayList.add(QCircleReportHelper.newEntry("attach_info", str));
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(QCircleReportHelper.newEntry("time_cost", String.valueOf(this.mSecondBufferTime / 1000)));
            arrayList2.add(QCircleReportHelper.newEntry("buffer_count", String.valueOf(this.mSecondBufferCount)));
            arrayList2.add(QCircleReportHelper.newEntry("attach_info", str));
            report("video_buffer_time_consuming", arrayList2);
            return;
        }
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(QCircleReportHelper.newEntry("buffer_count", String.valueOf(0)));
        arrayList3.add(QCircleReportHelper.newEntry("attach_info", str));
        report("video_play_occur_buffer_times", arrayList3);
    }

    private void totalTimeReport() {
        if (this.mPlayer.enableReport() && this.mStartPreparedTime > 0) {
            String valueOf = String.valueOf((System.currentTimeMillis() - this.mStartPreparedTime) / 1000);
            ArrayList arrayList = new ArrayList();
            arrayList.add(QCircleReportHelper.newEntry("time_cost", valueOf));
            report("video_total_time_consuming", arrayList);
            RFWLog.d(getTag(), RFWLog.USR, "video total time: " + valueOf);
        }
    }

    private void updateNetFlowReportBean(long j3, long j16) {
        if (this.mPlayerOptions != null && this.mPlayer != null) {
            if (this.mPlayerNetFlowBean == null) {
                this.mPlayerNetFlowBean = new RFWPlayerNetFlowReporter.PlayerNetFlowBean();
            }
            RFWPlayerNetFlowReporter.updateNetflowReportBean(this.mPlayerNetFlowBean, this.mPlayerOptions, this.mPlayer.getVideoPlayId(), 2, j3, j16);
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void afterOpenMedia(SuperPlayerOption superPlayerOption, ISuperPlayer iSuperPlayer) {
        super.afterOpenMedia(superPlayerOption, iSuperPlayer);
        playerStartPlayState();
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void beforeOpenMedia(SuperPlayerOption superPlayerOption, ISuperPlayer iSuperPlayer) {
        super.beforeOpenMedia(superPlayerOption, iSuperPlayer);
        initQUICStatus();
        initDownLoadStatic();
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void downloadComplete() {
        super.downloadComplete();
        this.mHasDownloadComplete = true;
        long averageDownloadSpeeds = getAverageDownloadSpeeds();
        if (averageDownloadSpeeds != 0) {
            RFWPlayer.sLastDownloadAvgSpeed = averageDownloadSpeeds;
            String playUrl = this.mPlayerOptions.getPlayUrl();
            long j3 = this.mTotalFileSize;
            QFSNetFlowReporter.reportFlowCost(QFSNetFlowReporter.QFS_FLOW_COST_SCENE_VIDEO_DOWNLOAD, playUrl, "", j3, j3 / averageDownloadSpeeds, getTag(), "");
        } else {
            this.mHaseHitCache = true;
        }
        RFWLog.d(getTag(), RFWLog.USR, "DownloadComplete DownLoadSpeed:" + getAverageDownloadSpeeds() + " KB/s");
    }

    public long getPlayTime() {
        if (this.mVideoPlayTimeRangeList.isEmpty()) {
            return 0L;
        }
        Pair<Long, Long> last = this.mVideoPlayTimeRangeList.getLast();
        long longValue = ((Long) last.second).longValue() - ((Long) last.first).longValue();
        RFWLog.d(getTag(), RFWLog.USR, "getPlayTime :", Long.valueOf(longValue));
        return longValue;
    }

    public synchronized long getPlayTimeBaseVideoPos() {
        long j3;
        j3 = 0;
        for (int size = this.mVideoPlayTimeBaseVideoPosList.size() - 1; size > 0; size--) {
            long longValue = this.mVideoPlayTimeBaseVideoPosList.get(size).longValue() - this.mVideoPlayTimeBaseVideoPosList.get(size - 1).longValue();
            if (longValue >= 0) {
                j3 += longValue;
            }
        }
        this.mVideoPlayTimeBaseVideoPosList.clear();
        return j3;
    }

    public long getTotalPlayTime() {
        Iterator<Pair<Long, Long>> it = this.mVideoPlayTimeRangeList.iterator();
        long j3 = 0;
        while (it.hasNext()) {
            Pair<Long, Long> next = it.next();
            j3 += ((Long) next.second).longValue() - ((Long) next.first).longValue();
        }
        RFWLog.d(getTag(), RFWLog.USR, "getTotalPlayTime :", Long.valueOf(j3));
        return j3;
    }

    public synchronized long getVideoSoloPlayTime() {
        long j3;
        Iterator<Pair<Long, Long>> it = this.mVideoSoloPlayTimeRangeList.iterator();
        j3 = 0;
        while (it.hasNext()) {
            Pair<Long, Long> next = it.next();
            j3 += ((Long) next.second).longValue() - ((Long) next.first).longValue();
        }
        RFWLog.d(getTag(), RFWLog.USR, "getVideoSoloPlayTime :", Long.valueOf(j3));
        return j3;
    }

    public boolean hasHitCache() {
        return this.mHaseHitCache;
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public boolean onError(ISuperPlayer iSuperPlayer, int i3, int i16, int i17, String str) {
        String str2 = "module:" + i3 + ", errorType:" + i16 + ", errorCode:" + i17 + ", extraInfo:" + str;
        if (!String.valueOf(i17).startsWith("140") && !String.valueOf(i17).startsWith("160")) {
            if (!this.mPlayer.enableReport()) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(QCircleReportHelper.newEntry("ret_code", String.valueOf(i17)));
            if (!TextUtils.isEmpty(this.mCDNIp)) {
                arrayList.add(QCircleReportHelper.newEntry("server_ip", this.mCDNIp));
                str2 = str2 + ",cdnIp:" + this.mCDNIp;
            }
            if (!TextUtils.isEmpty(this.mIp)) {
                str2 = str2 + ",ip:" + this.mIp;
            }
            if (!TextUtils.isEmpty(getDtCustomPageId())) {
                str2 = str2 + ",dtCustomPageId:" + getDtCustomPageId();
            }
            arrayList.add(QCircleReportHelper.newEntry("attach_info", appendAttachInfo(str2)));
            report("video_play_ret", arrayList);
        } else {
            this.mDownloadRetCode = String.valueOf(i17);
            reportDownloadRet();
        }
        RFWPlayerErrorReportHelper.reportError(this.mPlayerOptions, this.mPlayer.getVideoPlayId(), i17, getAvgSpeedString());
        return false;
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void onPause() {
        super.onPause();
        final RFWPlayer rFWPlayer = this.mPlayer;
        if (rFWPlayer == null) {
            return;
        }
        if (RFWThreadManager.getUIHandler().getLooper().isCurrentThread() && this.mIsSystemPlayer && o.T0()) {
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.richframework.video.rfw.player.playinterceptor.c
                @Override // java.lang.Runnable
                public final void run() {
                    RFWPlayerPerfReportInterceptor.this.lambda$onPause$1(rFWPlayer);
                }
            });
        } else {
            lambda$onPause$0(rFWPlayer.getCurrentPositionMs());
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void onPlayerCDNInfoUpdate(Object obj) {
        super.onPlayerCDNInfoUpdate(obj);
        if (obj instanceof TPPlayerMsg.TPCDNURLInfo) {
            TPPlayerMsg.TPCDNURLInfo tPCDNURLInfo = (TPPlayerMsg.TPCDNURLInfo) obj;
            printIpInfo(tPCDNURLInfo);
            handleCDNUrlInfo(tPCDNURLInfo);
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void onPlayerCurrentLoopStart() {
        super.onPlayerCurrentLoopStart();
        this.mStartPlayPositionForReport = 0L;
        addTomVideoPlayTimeBaseVideoPosList(this.mPlayer.getCurrentPositionMs());
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void onPlayerInfoBufferingEnd() {
        super.onPlayerInfoBufferingEnd();
        if (!this.mIsSeeking && this.mBufferBeginTime > 0 && o.U0()) {
            this.mHasBufferEnd = true;
            this.mSecondBufferTime += System.currentTimeMillis() - this.mBufferBeginTime;
            downGradeVideoIfNeed();
            RFWLog.i(getTag(), RFWLog.USR, "PLAYER_INFO_BUFFERING_END mSecondBufferCount:" + this.mSecondBufferCount + " |mSecondBufferTime:" + this.mSecondBufferTime);
            RFWPlayerListenerDispatchUtils.onSecondBufferEnd(this.mPlayerOptions);
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void onPlayerInfoBufferingStart() {
        super.onPlayerInfoBufferingStart();
        if (!this.mPlayer.enableReport()) {
            return;
        }
        this.mBufferBeginTime = System.currentTimeMillis();
        if (!this.mIsSeeking) {
            this.mHasBufferEnd = false;
            int i3 = this.mSecondBufferCount + 1;
            this.mSecondBufferCount = i3;
            QCircleFolderFunnelCollect.setVideoSecondBufferCount(i3);
            RFWPlayerListenerDispatchUtils.onSecondBufferStart(this.mPlayerOptions);
            RFWLog.i(getTag(), RFWLog.USR, "PLAYER_INFO_BUFFERING_START mSecondBufferCount:" + this.mSecondBufferCount + " |mSecondBufferTime:" + this.mBufferBeginTime + " |updateBuffingTimeStamp");
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void onPlayerInfoCurrentLoopEnd() {
        super.onPlayerInfoCurrentLoopEnd();
        addToVideoSoloPlayTimeRangeList(this.mStartPlayPositionForReport, this.mPlayer.getDurationMs());
        addTomVideoPlayTimeBaseVideoPosList(this.mPlayer.getDurationMs());
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void onPlayerInfoDownloadProgressUpdate(ISuperPlayer iSuperPlayer, Object obj) {
        super.onPlayerInfoDownloadProgressUpdate(iSuperPlayer, obj);
        if (obj instanceof TPDownloadProgressInfo) {
            handleDownloadInfo((TPDownloadProgressInfo) obj);
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void onPlayerInfoFirstVideoFrameRendered() {
        super.onPlayerInfoFirstVideoFrameRendered();
        firstFrameRender();
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void onPlayerParamsReset() {
        super.onPlayerParamsReset();
        this.mHasDownloadComplete = RFWVideoUtils.checkCacheExist(this.mPlayerOptions.getSceneId(), this.mPlayerOptions.getRealPlayUrl(), this.mPlayerOptions.getFileId());
        this.mTimelineAvgSpeedKB = 0L;
        this.mTotalFileSize = 0L;
        this.mIsSeeking = false;
        this.mHaseHitCache = false;
        this.mBufferBeginTime = 0L;
        this.mSecondBufferCount = 0;
        this.mSecondBufferTime = 0L;
        this.mDownloadRetCode = String.valueOf(0);
        this.mHasDownloadComplete = false;
        this.mDownloadTotalSpeed = 0;
        this.mDownloadTime = 0;
        this.mMinDownLoadKBps = Integer.MAX_VALUE;
        this.mMaxDownLoadKBps = Integer.MIN_VALUE;
        this.mHasBufferEnd = true;
        this.mMixFlowCost = 0L;
        this.mCDNIp = null;
        this.mIp = null;
        this.mDownLoadStatistic = null;
        this.mVideoSoloPlayTimeRangeList.clear();
        this.mVideoPlayTimeRangeList.clear();
        checkIsCompleteCache();
        this.mPlayerNetFlowBean = null;
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void onPlayerQUICUpdate(Object obj) {
        super.onPlayerQUICUpdate(obj);
        if (obj instanceof String) {
            onQUICInfoUpdate((String) obj);
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void onRelease(int i3) {
        super.onRelease(i3);
        if (!this.mPlayer.enableReport()) {
            return;
        }
        playerReport();
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void onSeekComplete(ISuperPlayer iSuperPlayer) {
        String fileId;
        super.onSeekComplete(iSuperPlayer);
        this.mIsSeeking = false;
        if (this.mIsByOffset) {
            this.mOffsetSeekCompleteTime = System.currentTimeMillis();
            this.mIsByOffset = false;
        }
        if (this.mStartSeekTime > 0) {
            long j3 = this.mReportPlayerTime;
            if (j3 > 0) {
                this.mReportPlayerTime = j3 + (System.currentTimeMillis() - this.mStartSeekTime);
                this.mStartSeekTime = 0L;
            }
        }
        this.mStartPlayPositionForReport = iSuperPlayer.getCurrentPositionMs();
        RFWPlayerListenerDispatchUtils.onSeekCompletion(this.mPlayerOptions, this.mPlayer.getRealPlayer());
        RFWPlayerOptions rFWPlayerOptions = this.mPlayerOptions;
        if (rFWPlayerOptions == null) {
            fileId = "";
        } else {
            fileId = rFWPlayerOptions.getFileId();
        }
        QLog.d(getTag(), 1, "[onSeekComplete] seek cost:" + this.mReportPlayerTime + " | filedId:" + fileId);
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void onStart() {
        super.onStart();
        this.mPlayerOptions.getRealPlayUrl();
        if (!this.mPlayer.isPausing()) {
            this.mStartPlayPositionForReport = this.mPlayer.getCurrentPositionMs();
        }
        this.mReportPlayerTime = System.currentTimeMillis();
        addTomVideoPlayTimeBaseVideoPosList(this.mPlayer.getCurrentPositionMs());
        RFWPlayerNetFlowReporter.updateScreenFileId(this.mPlayerOptions.getFileId());
        RFWLog.d(getTag(), RFWLog.USR, "[start] time:", Long.valueOf(this.mReportPlayerTime));
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void onStop() {
        super.onStop();
        if (!this.mPlayer.enableReport()) {
            return;
        }
        playerReport();
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void onStopTrackingTouch(int i3, int i16) {
        super.onStopTrackingTouch(i3, i16);
        this.mStartSeekTime = System.currentTimeMillis();
        this.mIsSeeking = true;
        addToVideoSoloPlayTimeRangeList(this.mStartPlayPositionForReport, this.mPlayer.getCurrentPositionMs());
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void onVideoPrepare() {
        super.onVideoPrepare();
        String valueOf = String.valueOf(((float) (System.currentTimeMillis() - this.mStartPreparedTime)) / 1000.0f);
        RFWLog.d(getTag(), RFWLog.USR, "[prepared], preparedTime = " + valueOf);
        if (!this.mPlayer.enableReport()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(QCircleReportHelper.newEntry("time_cost", valueOf));
        report("video_first_buffer_time_consuming", arrayList);
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void playerStartPlayState() {
        int i3;
        this.mStartPreparedTime = System.currentTimeMillis();
        report(AEEditorConstants.VIDEO_RESOLUTION, null);
        if (!this.mPlayer.enableReport()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (this.mPlayerOptions.getRealPlayBean() != null) {
            i3 = this.mPlayerOptions.getRealPlayBean().mLevelType;
        } else {
            i3 = 8;
        }
        arrayList.add(QCircleReportHelper.newEntry("attach_info", ("grade=" + i3) + "|hwlevel=" + DeviceInfoUtils.getPerfLevel()));
        report(QCircleFolderFunnelCollect.PERIOD_FOLDER_VIDEO_START_PLAY, arrayList);
    }

    protected void reportVideoBufferPercent() {
        double d16;
        RFWPlayerOptions rFWPlayerOptions = this.mPlayerOptions;
        if (rFWPlayerOptions != null && rFWPlayerOptions.getIOC().getBusinessReportInfo() != null) {
            RFWPlayerReportInfo businessReportInfo = this.mPlayerOptions.getIOC().getBusinessReportInfo();
            long j3 = this.mTotalFileSize;
            if (j3 == 0) {
                j3 = businessReportInfo.getFileSize();
            }
            ArrayList arrayList = new ArrayList();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("videoDuration");
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append(businessReportInfo.getDuration());
            sb5.append("|");
            sb5.append("fileSize");
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append(j3);
            if (this.mHasDownloadComplete) {
                this.mLocalCacheSize = j3;
            }
            long j16 = this.mLocalCacheSize;
            if (j16 > 0 && j3 > 0) {
                d16 = Math.min(100.0d, (j16 / j3) * 100.0d);
                arrayList.add(QCircleReportHelper.newEntry("rate", String.valueOf(d16)));
                sb5.append("|");
                sb5.append("cacheSize");
                sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb5.append(this.mLocalCacheSize);
                sb5.append("|");
                sb5.append("bufferRate");
                sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb5.append(d16);
            } else {
                d16 = 0.0d;
            }
            arrayList.add(QCircleReportHelper.newEntry("attach_info", sb5.toString()));
            report("video_buffer_percent", arrayList);
            RFWLog.d(getTag(), RFWLog.USR, "reportVideoBufferPercent localCacheSize:" + this.mLocalCacheSize + ",FileSize:" + j3 + ",rate:" + d16);
            return;
        }
        RFWLog.w(getTag(), RFWLog.USR, "[reportVideoBufferPercent] invalid mPlayerCallback");
    }

    public void upDateSeekState(boolean z16) {
        this.mIsSeeking = true;
        this.mIsByOffset = z16;
        RFWLog.d(getTag(), RFWLog.DEV, "upDateSeekState:" + z16);
    }
}
