package com.tencent.oskplayer.util;

import android.text.TextUtils;
import com.tencent.oskplayer.PlayerConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class VideoSpeedReport {
    private static final String DOUBLE_ARROW_SEP = "<->";
    public static final String LOG_TAG = "VideoSpeedReport";
    private static final int MIN_REFRESH_INTERVAL = 30000;
    public static boolean isLaunchReported = false;
    private long launchStartTime;
    public static final ReportPoint POINT_VIDEO_LIST_IDLE = new ReportPoint("video_list_idle<->set_datasource", false);
    public static final ReportPoint POINT_VIDEO_PREPARE_ASYNC = new ReportPoint("video_prepare_async<->mediaplayer_onprepared", false);
    public static final ReportPoint POINT_UPDATE_VIDEOVIEW = new ReportPoint("video_on_prepared<->update_videoview", false);
    public static final ReportPoint POINT_VIDEO_VISIBLE = new ReportPoint("video_list_idle<->update_videoview", false);
    private ReportType currentLaunchType = null;
    private ReportType currentReportType = null;
    private long reportStartTime = 0;
    private final List<ReportPoint> mReportPoints = Collections.synchronizedList(new ArrayList());

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class ReportType {
        public static final String TYPE_VIDEO_PLAY = "videoplay";
        private static Map<String, ReportType> sReportTypeMap = new HashMap(5, 0.75f);
        private List<ReportPoint> reportPoints;
        private String tag;

        public ReportType(String str, List<ReportPoint> list) {
            this.tag = str;
            this.reportPoints = list;
        }

        public static synchronized void addToVideoReportType(String str, ReportPoint reportPoint) {
            List<ReportPoint> reportPoints;
            synchronized (ReportType.class) {
                ReportType videoReportType = getVideoReportType(str);
                if (videoReportType != null && (reportPoints = videoReportType.getReportPoints()) != null) {
                    reportPoints.add(reportPoint);
                }
            }
        }

        private List<ReportPoint> getReportPoints() {
            return this.reportPoints;
        }

        public static synchronized ReportType getVideoReportType(String str) {
            synchronized (ReportType.class) {
                if (str == null) {
                    return null;
                }
                if (sReportTypeMap.get(str) == null) {
                    ReportType reportType = new ReportType(str, new ArrayList());
                    sReportTypeMap.put(str, reportType);
                    return reportType;
                }
                return sReportTypeMap.get(str);
            }
        }

        public static synchronized void removeVideoReportType(String str) {
            synchronized (ReportType.class) {
                if (str == null) {
                    return;
                }
                sReportTypeMap.remove(str);
            }
        }

        public String getReportStr() {
            String str;
            StringBuilder sb5 = new StringBuilder();
            for (int i3 = 0; i3 < this.reportPoints.size(); i3++) {
                ReportPoint reportPoint = this.reportPoints.get(i3);
                if (reportPoint.getEndTime() - reportPoint.getStartTime() < 0 && PlayerConfig.g().isDebugVersion()) {
                    PlayerUtils.log(3, VideoSpeedReport.LOG_TAG, reportPoint.getName() + "(" + reportPoint.hashCode() + ") \u9519\u8bef\uff1a\u7ed3\u675f\u65f6\u95f4\u5c0f\u4e8e\u5f00\u59cb\u65f6\u95f4 " + reportPoint.getStartTime() + "," + reportPoint.getEndTime());
                }
                if (reportPoint.getStartTime() <= 10000000 && reportPoint.getEndTime() <= 10000000) {
                    if (reportPoint.getStartTime() == 0 && reportPoint.getEndTime() == 0) {
                        if (PlayerConfig.g().isDebugVersion()) {
                            PlayerUtils.log(3, VideoSpeedReport.LOG_TAG, reportPoint.getName() + "(" + reportPoint.hashCode() + ") \u4e22\u5f03\uff1a\u5f00\u59cb\u65f6\u95f4\u3001\u7ed3\u675f\u65f6\u95f4\u90fd\u4e3a0" + reportPoint.getStartTime() + "," + reportPoint.getEndTime());
                        }
                    } else {
                        if (sb5.length() != 0) {
                            str = ";\n";
                        } else {
                            str = "\n";
                        }
                        sb5.append(str);
                        sb5.append(reportPoint.getName() + ":");
                        sb5.append(reportPoint.getStartTime() + ",");
                        sb5.append(reportPoint.getEndTime() + ",");
                        if (reportPoint.getExtraInfo() != null) {
                            sb5.append(reportPoint.getExtraInfo());
                        }
                    }
                } else if (PlayerConfig.g().isDebugVersion()) {
                    PlayerUtils.log(3, VideoSpeedReport.LOG_TAG, reportPoint.getName() + "(" + reportPoint.hashCode() + ") \u9519\u8bef\uff1a\u5f00\u59cb\u6216\u7ed3\u675f\u65f6\u95f4\u5927\u4e8e\u6700\u5927\u503c" + reportPoint.getStartTime() + "," + reportPoint.getEndTime());
                }
            }
            String sb6 = sb5.toString();
            sb5.delete(0, sb5.length());
            return sb6;
        }

        public String getTag() {
            return this.tag;
        }

        public boolean isLaunchType() {
            return this.tag.contains("startupSpeed_");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class SpeedReportInstance {
        private static final VideoSpeedReport instance = new VideoSpeedReport();

        SpeedReportInstance() {
        }
    }

    private void cleanReport() {
        this.reportStartTime = 0L;
        this.currentReportType = null;
        synchronized (this.mReportPoints) {
            for (ReportPoint reportPoint : this.mReportPoints) {
                if (!reportPoint.isLaunchPoint) {
                    reportPoint.clean();
                }
            }
        }
    }

    private void collectReport(ReportType reportType) {
        if (reportType == null) {
            return;
        }
        String reportStr = reportType.getReportStr();
        if (TextUtils.isEmpty(reportStr)) {
            return;
        }
        PlayerUtils.log(4, LOG_TAG, "reportType: " + reportType.tag + ", reportStr: " + reportStr);
    }

    public static VideoSpeedReport g() {
        return SpeedReportInstance.instance;
    }

    public void cancelStartupReport() {
        isLaunchReported = true;
    }

    public void end(ReportPoint reportPoint) {
        long j3;
        if (!reportPoint.isEndTimeSet && ((!reportPoint.isLaunchPoint || !isLaunchReported) && (reportPoint.isLaunchPoint || (reportPoint.getEndTime() == 0 && this.reportStartTime != 0)))) {
            long currentTimeMillis = System.currentTimeMillis();
            if (reportPoint.isLaunchPoint) {
                j3 = this.launchStartTime;
            } else {
                j3 = this.reportStartTime;
            }
            reportPoint.setEndTime(currentTimeMillis - j3);
            reportPoint.isEndTimeSet = true;
            return;
        }
        PlayerUtils.log(5, LOG_TAG, "end point failed " + reportPoint.hashCode());
    }

    public boolean isLaunchTypeSet() {
        if (this.currentLaunchType != null) {
            return true;
        }
        return false;
    }

    public void launchEnd() {
        if (isLaunchReported) {
            return;
        }
        collectReport(this.currentLaunchType);
        isLaunchReported = true;
    }

    public void launchStart() {
        this.launchStartTime = System.currentTimeMillis();
    }

    public synchronized void reportEnd(ReportType reportType) {
        if (reportType.equals(this.currentReportType) && this.reportStartTime != 0) {
            collectReport(this.currentReportType);
            cleanReport();
        }
    }

    public synchronized void reportStart() {
        if (System.currentTimeMillis() - this.reportStartTime < 30000) {
            return;
        }
        cleanReport();
        this.reportStartTime = System.currentTimeMillis();
    }

    public void setReportType(ReportType reportType) {
        if (reportType.isLaunchType()) {
            this.currentLaunchType = reportType;
        } else if (this.currentReportType == null) {
            this.currentReportType = reportType;
        }
    }

    public synchronized void start(ReportPoint reportPoint) {
        long j3;
        if (!reportPoint.isStartTimeSet && (!reportPoint.isLaunchPoint || !isLaunchReported)) {
            long j16 = 0;
            if (reportPoint.isLaunchPoint || (reportPoint.getStartTime() == 0 && this.reportStartTime != 0)) {
                long currentTimeMillis = System.currentTimeMillis();
                if (reportPoint.isLaunchPoint) {
                    j3 = this.launchStartTime;
                } else {
                    j3 = this.reportStartTime;
                }
                long j17 = currentTimeMillis - j3;
                if (reportPoint.upperLimit > 0 && j17 >= reportPoint.upperLimit && reportPoint.isLaunchPoint && this.launchStartTime != 0) {
                    this.launchStartTime = System.currentTimeMillis();
                    cleanBrokenPoints();
                } else {
                    j16 = j17;
                }
                reportPoint.setStartTime(j16);
                reportPoint.isStartTimeSet = true;
                synchronized (this.mReportPoints) {
                    this.mReportPoints.add(reportPoint);
                }
                return;
            }
        }
        PlayerUtils.log(5, LOG_TAG, "start point failed " + reportPoint.hashCode());
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class ReportPoint {
        public static final String HTTP_OPEN = "http_open_start<->http_open_end";
        private long endTime;
        private String extraInfo;
        private boolean isEndTimeSet;
        private boolean isLaunchPoint;
        private boolean isStartTimeSet;
        private String name;
        private long startTime;
        private int upperLimit;

        public ReportPoint(String str) {
            this.startTime = 0L;
            this.endTime = 0L;
            this.isStartTimeSet = false;
            this.isEndTimeSet = false;
            this.isLaunchPoint = true;
            this.upperLimit = 0;
            this.name = str;
        }

        public void clean() {
            this.startTime = 0L;
            this.endTime = 0L;
            this.isStartTimeSet = false;
            this.isEndTimeSet = false;
        }

        public long getEndTime() {
            return this.endTime;
        }

        public String getExtraInfo() {
            return this.extraInfo;
        }

        public String getName() {
            return this.name;
        }

        public long getStartTime() {
            return this.startTime;
        }

        public void setEndTime(long j3) {
            this.endTime = j3;
        }

        public void setStartTime(long j3) {
            this.startTime = j3;
        }

        public ReportPoint(String str, boolean z16) {
            this(str);
            this.isLaunchPoint = z16;
        }

        public ReportPoint(String str, boolean z16, String str2) {
            this(str);
            this.isLaunchPoint = z16;
            this.extraInfo = str2;
        }

        public ReportPoint(String str, boolean z16, int i3) {
            this(str, z16, (String) null);
            this.upperLimit = i3;
        }
    }

    public void cleanBrokenPoints() {
    }
}
