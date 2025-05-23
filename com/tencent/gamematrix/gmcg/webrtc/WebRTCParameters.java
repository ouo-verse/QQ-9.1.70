package com.tencent.gamematrix.gmcg.webrtc;

import org.tencwebrtc.Loggable;
import org.tencwebrtc.Logging;

/* loaded from: classes6.dex */
public class WebRTCParameters {
    public static final int DEFAULT_MAX_BITRATE_SDP = 15000;
    public static final int DEFAULT_MIN_BITRATE_SDP = 300;
    public static final int DEFAULT_START_BITRATE_SDP = 4000;
    private static boolean enableLogToDebugOutput = false;
    private static int reportStatsPeriod = 30;
    private static int samplingStatsPeriod = 1;
    private Integer audioSource;
    private int networkIgnoreMask;
    private VideoFilterParams videofilter;
    private Logging.Severity loggingSeverity = Logging.Severity.LS_NONE;
    private boolean rtcEventLog = true;
    private boolean rtcEventLogOutput = false;
    private boolean hwDecode = false;
    private boolean preferH265 = false;
    private boolean dumpReceivedBitstream = false;
    private int dumpSize = 536870912;
    private String dumpPath = "/storage/emulated/0/Movies";
    private int currAudioVolume = 0;
    private int maxAudioVolume = 10;
    private int minBitRate = 300;
    private int startBitRate = 4000;
    private int maxBitRate = 15000;
    private int connectionTimeOut = 10;
    private boolean imgQualityPreferred = false;
    private boolean enableGetBatteryInfo = true;
    private Logging.Severity customLoggingSeverity = Logging.Severity.LS_ERROR;
    private Loggable customLoggable = null;

    public static int getReportStatsPeriod() {
        return reportStatsPeriod;
    }

    public static int getSamplingStatsPeriod() {
        return samplingStatsPeriod;
    }

    public static boolean isEnableLogToDebugOutput() {
        return enableLogToDebugOutput;
    }

    public static void setEnableLogToDebugOutput(boolean z16) {
        enableLogToDebugOutput = z16;
    }

    public static void setReportStatsPeriod(int i3) {
        reportStatsPeriod = i3;
    }

    public static void setSamplingStatsPeriod(int i3) {
        samplingStatsPeriod = i3;
    }

    public void enableRtcEventLog(boolean z16) {
        this.rtcEventLog = z16;
    }

    public void enableRtcEventLogOutput(boolean z16) {
        this.rtcEventLogOutput = z16;
    }

    public Integer getAudioSource() {
        return this.audioSource;
    }

    public int getConnectionTimeOut() {
        return this.connectionTimeOut;
    }

    public int getCurrAudioVolume() {
        return this.currAudioVolume;
    }

    public Loggable getCustomLoggable() {
        return this.customLoggable;
    }

    public Logging.Severity getCustomLoggingSeverity() {
        return this.customLoggingSeverity;
    }

    public String getDumpPath() {
        return this.dumpPath;
    }

    public int getDumpSize() {
        return this.dumpSize;
    }

    public boolean getImgQualityPreferred() {
        return this.imgQualityPreferred;
    }

    public Logging.Severity getLoggingSeverity() {
        return this.loggingSeverity;
    }

    public int getMaxAudioVolume() {
        return this.maxAudioVolume;
    }

    public int getMaxBitRate() {
        return this.maxBitRate;
    }

    public int getMinBitRate() {
        return this.minBitRate;
    }

    public int getNetworkIgnoreMask() {
        return this.networkIgnoreMask;
    }

    public boolean getRtcEventLogOutputStatus() {
        return this.rtcEventLogOutput;
    }

    public boolean getRtcEventLogStatus() {
        return this.rtcEventLog;
    }

    public int getStartBitRate() {
        return this.startBitRate;
    }

    public VideoFilterParams getVideofilterParams() {
        return this.videofilter;
    }

    public boolean isDumpReceivedBitstream() {
        return this.dumpReceivedBitstream;
    }

    public boolean isEnableGetBatteryInfo() {
        return this.enableGetBatteryInfo;
    }

    public boolean isHwDecode() {
        return this.hwDecode;
    }

    public boolean isPreferH265() {
        return this.preferH265;
    }

    public void setAudioSource(Integer num) {
        this.audioSource = num;
    }

    public void setConnectionTimeOut(int i3) {
        this.connectionTimeOut = i3;
    }

    public void setCurrAudioVolume(int i3) {
        this.currAudioVolume = i3;
    }

    public void setCustomLogger(Loggable loggable) {
        this.customLoggable = loggable;
    }

    public void setDumpPath(String str) {
        this.dumpPath = str;
    }

    public void setDumpReceivedBitstream(boolean z16) {
        this.dumpReceivedBitstream = z16;
    }

    public void setDumpSize(int i3) {
        this.dumpSize = i3;
    }

    public void setEnableGetBatteryInfo(boolean z16) {
        this.enableGetBatteryInfo = z16;
    }

    public void setHwDecode(boolean z16) {
        this.hwDecode = z16;
    }

    public void setImgQualityPreferred(boolean z16) {
        this.imgQualityPreferred = z16;
    }

    public void setLoggingSeverity(int i3) {
        if (i3 > 4) {
            i3 = 4;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        this.loggingSeverity = Logging.Severity.values()[i3];
    }

    public void setMaxAudioVolume(int i3) {
        this.maxAudioVolume = i3;
    }

    public void setMaxBitRate(int i3) {
        this.maxBitRate = i3;
    }

    public void setMinBitRate(int i3) {
        this.minBitRate = i3;
    }

    public void setNetworkIgnoreMask(int i3) {
        this.networkIgnoreMask = i3;
    }

    public void setPreferH265(boolean z16) {
        this.preferH265 = z16;
    }

    public void setStartBitRate(int i3) {
        this.startBitRate = i3;
    }

    public void setVideofilterParams(VideoFilterParams videoFilterParams) {
        this.videofilter = videoFilterParams;
    }

    public void setLoggingSeverity(Logging.Severity severity) {
        this.customLoggingSeverity = severity;
    }
}
