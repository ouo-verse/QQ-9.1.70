package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ExcitingTransferDownloadCompletedInfo {
    public int mnSrvReturnCode = 0;
    public String mstrFileSavePath;
    public String mstrLastServerHost;
    public long muDownloadedSize;
    public int muFirstRecvDataSize;
    public long muFirstRecvDataTime;
    public int muFullWatingNum;
    public int muProxyType;
    public int muReAllocatedNum;
    public int muRetryTimes;
    public long muStartSize;
    public long muStartTime;
    public long muTotalTimes;

    public HashMap<String, String> getReportData() {
        String str;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("param_FileSavePath", String.valueOf(this.mstrFileSavePath));
        hashMap.put("param_StartSize", String.valueOf(this.muStartSize));
        hashMap.put("param_TotalTimes", String.valueOf(this.muTotalTimes));
        hashMap.put("param_DownloadedSize", String.valueOf(this.muDownloadedSize));
        hashMap.put("param_StartTime", String.valueOf(this.muStartTime));
        hashMap.put("param_FirstRecvDataTime", String.valueOf(this.muFirstRecvDataTime));
        hashMap.put("param_FirstRecvDataSize", String.valueOf(this.muFirstRecvDataSize));
        hashMap.put("param_FullWatingNum", String.valueOf(this.muFullWatingNum));
        hashMap.put("param_ReAllocatedNum", String.valueOf(this.muReAllocatedNum));
        hashMap.put("param_RetryTimes", String.valueOf(this.muRetryTimes));
        hashMap.put("param_ProxyType", String.valueOf(this.muProxyType));
        hashMap.put("param_LastServerHost", String.valueOf(this.mstrLastServerHost));
        long j3 = this.muTotalTimes;
        if (j3 != 0) {
            str = String.valueOf(((float) this.muDownloadedSize) / ((float) j3));
        } else {
            str = "0";
        }
        hashMap.put("param_speed", str);
        hashMap.put("param_SrvRetCode", String.valueOf(this.mnSrvReturnCode));
        return hashMap;
    }

    public String toString() {
        return "m_strFileSavePath:" + this.mstrFileSavePath + " m_uStartSize:" + this.muStartSize + " m_uTotalTimes:" + this.muTotalTimes + " m_uDownloadedSize:" + this.muDownloadedSize + " m_uReAllocatedNum:" + this.muReAllocatedNum + " m_uStartTime:" + this.muStartTime + " m_uFirstRecvDataTime:" + this.muFirstRecvDataTime + " m_uFirstRecvDataSize:" + this.muFirstRecvDataSize + " m_uFullWatingNum:" + this.muFullWatingNum + " m_uRetryTimes:" + this.muRetryTimes + " m_uProxyType:" + this.muProxyType + " m_strLastServerHost:" + this.mstrLastServerHost + " m_nSrvReturnCode:" + this.mnSrvReturnCode;
    }
}
