package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ExcitingTransferDownloaderRp {
    public int dwProxyType;
    public long dwSrvCode;
    public long dwSubReason;
    public int dwTimeOutDuration;
    public long nUserReturCode;
    public String strServerIp;
    public long u64EndPos;
    public long u64StartPos;
    public long u64TransferSize;
    public long u64TransferSpeed;
    public long u64TransferTime;
    public int wIPStack;
    public int wLanChannelNum;
    public int wRetryCount;
    public int wServerPort;

    public HashMap<String, String> getReportData() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("param_SubReason", String.valueOf(this.dwSubReason));
        hashMap.put("param_SrvCode", String.valueOf(this.dwSrvCode));
        hashMap.put("param_UserReturCode", String.valueOf(this.nUserReturCode));
        hashMap.put("param_RetryCount", String.valueOf(this.wRetryCount));
        hashMap.put("param_TimeOutDuration", String.valueOf(this.dwTimeOutDuration));
        hashMap.put("param_TransferSpeed", String.valueOf(this.u64TransferSpeed));
        hashMap.put("param_TransferTime", String.valueOf(this.u64TransferTime));
        hashMap.put("param_TransferSize", String.valueOf(this.u64TransferSize));
        hashMap.put("param_ServerIp", String.valueOf(this.strServerIp));
        hashMap.put("param_ServerPort", String.valueOf(this.wServerPort));
        hashMap.put("param_ProxyType", String.valueOf(this.dwProxyType));
        hashMap.put("param_StartPos", String.valueOf(this.u64StartPos));
        hashMap.put("param_EndPos", String.valueOf(this.u64EndPos));
        hashMap.put("param_LanChannelNum", String.valueOf(this.wLanChannelNum));
        hashMap.put("param_ipStack", String.valueOf(this.wIPStack));
        return hashMap;
    }
}
