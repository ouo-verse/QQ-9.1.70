package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ExcitingTransferUploadChnConfigInfo {
    public long uMuliFileSizeLimit = 10485760;
    public int uMaxChannelNum = 3;
    public int uPieceSize = 524288;
    public int nMaxEachHostTotalUseCount = 200;
    public int nMaxEachHostErrorCount = 27;
    public int nMaxEachHostParallelUseCount = 10;
    public long nConnectTimeout = 7000;
    public long nDataTimeout = 21000;
    public long nTotoalDataTimeout = 120000;

    public String toString() {
        return "uMuliFileSizeLimit:" + this.uMuliFileSizeLimit + " uMaxChannelNum:" + this.uMaxChannelNum + " uPieceSize:" + this.uPieceSize + "nMaxEachHostTotalUseCount:" + this.nMaxEachHostTotalUseCount + " nMaxEachHostErrorCount:" + this.nMaxEachHostErrorCount + " nMaxEachHostParallelUseCount:" + this.nMaxEachHostParallelUseCount + " nConnectTimeout:" + this.nConnectTimeout + " nDataTimeout:" + this.nDataTimeout + " nTotoalDataTimeout:" + this.nTotoalDataTimeout;
    }
}
