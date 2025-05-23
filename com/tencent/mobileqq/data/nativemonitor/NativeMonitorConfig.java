package com.tencent.mobileqq.data.nativemonitor;

import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.jsonconverter.Alias;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class NativeMonitorConfig implements IConfigData {

    @Alias("nativeMonitorOpened")
    private int nativeMonitorOpened = 0;

    @Alias("switchFlag")
    private long switchFlag = 0;

    @Alias("soWhiteList")
    private String soWhiteList = null;

    @Alias("androidVersionBlackList")
    private String androidVersionBlackList = null;

    @Alias("timeLimited")
    private long timeLimited = 1000000;

    @Alias("countLimted")
    private long countLimted = 1000;

    @Alias("memoryLimited")
    private long memoryLimited = 5242880;

    @Alias("processBlackList")
    private String processBlackList = null;

    @Alias("tmChance")
    private long tmChance = 0;

    @Alias("soHook")
    public int soHook = -3;

    @Alias("openBacktrace64")
    private int openBacktrace64 = 0;

    @Alias("soLoadReportRate")
    public int soLoadReportRate = 10;

    @Alias("soLoadDDReportRate")
    public int soLoadDDReportRate = 1;

    @Alias("soLoadIllegalReportRate")
    public int soLoadIllegalReportRate = 1;

    @Alias("isBanIllegalSoLoad")
    public int isBanIllegalSoLoad = 0;

    @Alias("isBanDotDotSoLoad")
    public int isBanDotDotSoLoad = 0;

    @Alias("soMonitorBlacklist")
    public List<String> soMonitorBlacklist = new ArrayList();

    @Alias("needCleanSoRegexList")
    public List<String> needCleanSoRegexList = new ArrayList();

    @Alias("allSoLoadReportRate")
    public int allSoLoadReportRate = 0;

    public String getAndroidVersionBlackList() {
        return this.androidVersionBlackList;
    }

    public long getCountLimted() {
        return this.countLimted;
    }

    public long getMemoryLimited() {
        return this.memoryLimited;
    }

    public int getNativeMonitorOpened() {
        return this.nativeMonitorOpened;
    }

    public int getOpenBacktrace64() {
        return this.openBacktrace64;
    }

    public String getProcessBlackList() {
        return this.processBlackList;
    }

    public String getSoWhiteList() {
        return this.soWhiteList;
    }

    public long getSwitchFlag() {
        return this.switchFlag;
    }

    public long getTimeLimited() {
        return this.timeLimited;
    }

    public long getTmChance() {
        return this.tmChance;
    }

    public void setCountLimitedDefault() {
        this.countLimted = 1000L;
    }

    public void setMemoryLimitedDefault() {
        this.memoryLimited = 5242880L;
    }

    public void setTimeLimitedDefault() {
        this.timeLimited = 1000000L;
    }

    public void setTmChance(long j3) {
        this.tmChance = j3;
    }

    public String toString() {
        return "nativeMonitorOpened:" + this.nativeMonitorOpened + "|switchFlag:" + this.switchFlag + "|soWhiteList:" + this.soWhiteList + "|androidVersionBlackList:" + this.androidVersionBlackList + "|timeLimited:" + this.timeLimited + "|countLimited:" + this.countLimted + "|memoryLimited:" + this.memoryLimited + "|processBlackList:" + this.processBlackList + "|tmChance:" + this.tmChance + "|openBacktrace64:" + this.openBacktrace64 + "|soLoadReportRate:" + this.soLoadReportRate + "|soLoadDDReportRate:" + this.soLoadDDReportRate + "|soLoadIllegalReportRate:" + this.soLoadIllegalReportRate + "|isBanIllegalSoLoad:" + this.isBanIllegalSoLoad + "|soMonitorBlacklist:" + this.soMonitorBlacklist + "|needCleanSoRegexList:" + this.needCleanSoRegexList + "|allSoLoadReportRate:" + this.allSoLoadReportRate;
    }

    public void update(NativeMonitorConfig nativeMonitorConfig) {
        this.nativeMonitorOpened = nativeMonitorConfig.getNativeMonitorOpened();
        this.switchFlag = nativeMonitorConfig.getSwitchFlag();
        this.soWhiteList = nativeMonitorConfig.getSoWhiteList();
        this.timeLimited = nativeMonitorConfig.getTimeLimited();
        this.countLimted = nativeMonitorConfig.getCountLimted();
        this.memoryLimited = nativeMonitorConfig.getMemoryLimited();
        this.androidVersionBlackList = nativeMonitorConfig.getAndroidVersionBlackList();
        this.processBlackList = nativeMonitorConfig.getProcessBlackList();
        this.tmChance = nativeMonitorConfig.getTmChance();
        this.openBacktrace64 = nativeMonitorConfig.getOpenBacktrace64();
        this.soLoadReportRate = nativeMonitorConfig.soLoadReportRate;
        this.soLoadDDReportRate = nativeMonitorConfig.soLoadDDReportRate;
        this.soLoadIllegalReportRate = nativeMonitorConfig.soLoadIllegalReportRate;
        this.isBanIllegalSoLoad = nativeMonitorConfig.isBanIllegalSoLoad;
        this.soMonitorBlacklist = nativeMonitorConfig.soMonitorBlacklist;
        this.needCleanSoRegexList = nativeMonitorConfig.needCleanSoRegexList;
        this.allSoLoadReportRate = nativeMonitorConfig.allSoLoadReportRate;
    }
}
