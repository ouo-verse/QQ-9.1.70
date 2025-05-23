package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ExcitingTransferDownloaderResultRp {
    public boolean bIsAutoDownload;
    public boolean bIsFlashTransfer;
    public boolean bIsXTFValid;
    public int dwLastLanResult;
    public int dwLastLanSubReason;
    public int dwReserved1;
    public int dwReserved2;
    public int dwReserved3;
    public int dwReserved4;
    public int eFinalResult;
    public int eXTFInvalidReason;
    public int nLastLanUserCode;
    public int speedUpType;
    public String strFileUrl;
    public int u32FtnTimeOutDuration;
    public int u32LifeInSecond;
    public long u64FtnTransferSize;
    public long u64FtnlSpeed;
    public long u64FtnlTransferTime;
    public long u64LanSpeed;
    public long u64LanTransferSize;
    public long u64LanTransferTime;
    public long u64StartSize;
    public long u64TransferSize;
    public long u64TransferSpeed;
    public long u64TransferTime;
    public int uMaxDownloadingFtnNum;
    public int wFtnConnectCount;
    public int wFtnConnectFailCount;
    public int wFtnRetryCount;
    public int wLanConnectCount;
    public int wLanConnectFailCount;
    public int wTransferMode;

    public HashMap<String, String> getReportData() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("param_IsXTFValid", String.valueOf(this.bIsXTFValid));
        hashMap.put("param_XTFInvalidReason", String.valueOf(this.eXTFInvalidReason));
        hashMap.put("param_FinalResult", String.valueOf(this.eFinalResult));
        hashMap.put("param_FileUrl", String.valueOf(this.strFileUrl));
        hashMap.put("param_LifeInSecond", String.valueOf(this.u32LifeInSecond));
        hashMap.put("param_SpeedUpType", String.valueOf(this.speedUpType));
        hashMap.put("param_StartSize", String.valueOf(this.u64StartSize));
        hashMap.put("param_TransferSpeed", String.valueOf(this.u64TransferSpeed));
        hashMap.put("param_TransferTime", String.valueOf(this.u64TransferTime));
        hashMap.put("param_TransferSize", String.valueOf(this.u64TransferSize));
        hashMap.put("param_LanSpeed", String.valueOf(this.u64LanSpeed));
        hashMap.put("param_LanTransferTime", String.valueOf(this.u64LanTransferTime));
        hashMap.put("param_LanTransferSize", String.valueOf(this.u64LanTransferSize));
        hashMap.put("param_FtnlSpeed", String.valueOf(this.u64FtnlSpeed));
        hashMap.put("param_FtnlTransferTime", String.valueOf(this.u64FtnlTransferTime));
        hashMap.put("param_FtnTransferSize", String.valueOf(this.u64FtnTransferSize));
        hashMap.put("param_MaxDownloadingFtnNum", String.valueOf(this.uMaxDownloadingFtnNum));
        hashMap.put("param_LanConnectCount", String.valueOf(this.wLanConnectCount));
        hashMap.put("param_FtnConnectCount", String.valueOf(this.wFtnConnectCount));
        hashMap.put("param_LanConnectFailCount", String.valueOf(this.wLanConnectFailCount));
        hashMap.put("param_FtnConnectFailCount", String.valueOf(this.wFtnConnectFailCount));
        hashMap.put("param_LastLanResult", String.valueOf(this.dwLastLanResult));
        hashMap.put("param_LastLanSubReason", String.valueOf(this.dwLastLanSubReason));
        hashMap.put("param_LastLanUserCode", String.valueOf(this.nLastLanUserCode));
        hashMap.put("param_FtnRetryCount", String.valueOf(this.wFtnRetryCount));
        hashMap.put("param_FtnTimeOutDuration", String.valueOf(this.u32FtnTimeOutDuration));
        hashMap.put("param_IsFlashTransfer", String.valueOf(this.bIsFlashTransfer));
        hashMap.put("param_TransferMode", String.valueOf(this.wTransferMode));
        hashMap.put("param_IsAutoDownload", String.valueOf(this.bIsAutoDownload));
        hashMap.put("param_Reserved1", String.valueOf(this.dwReserved1));
        hashMap.put("param_Reserved2", String.valueOf(this.dwReserved2));
        hashMap.put("param_Reserved3", String.valueOf(this.dwReserved3));
        hashMap.put("param_Reserved4", String.valueOf(this.dwReserved4));
        return hashMap;
    }
}
