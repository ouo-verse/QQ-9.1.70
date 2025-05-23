package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ExcitingTransferUploadResultRp {
    public long mdwFileCookieId;
    public String mstrFileIdCrc;
    public String mstrFileName;
    public String mstrFileUrl;
    public String mstrServerIp;
    public String mstrSuffix;
    public int mcXTFTransferType = -1;
    public int mwTranferPlatform = -1;
    public int mwAppType = -1;
    public long mu64ReportVer = 0;
    public long mnResult = 0;
    public long mnSrvReturCode = 0;
    public long mu64FileSize = 0;
    public long muPeerUin = 0;
    public long muGroupCode = 0;
    public boolean mbIsXTFValid = false;
    public int meInvalidReason = 0;
    public long mu64StartSize = 0;
    public long mu64TransferSpeed = 0;
    public long mu64HttpTime = 0;
    public long mu64TransferSize = 0;
    public long muSecurityTime = 0;
    public long muHashCaculateTime = 0;
    public long muFullHashCaculateTime = 0;
    public long muTotalTime = 0;
    public short mwServerPort = 0;
    public int mdwProxyType = 0;
    public long muMaxUploadingFtnNum = 0;
    public boolean mbIsFlashTransfer = false;
    public long muRetryCount = 0;
    public long muIpChangeCount = 0;
    public long muRollBackCount = 0;
    public long muQueryHoleCount = 0;
    public long muRangDiffCount = 0;
    public long muDelayTotoalCount = 0;
    public int mnTcpCnnCode = 0;
    public int mnTcpSocketCode = 0;
    public short mwHttpsSupport = 0;

    public String toString() {
        return "m_dwFileCookieId:" + this.mdwFileCookieId + "TransferType:" + this.mcXTFTransferType + " m_wTranferPlatform:" + this.mwTranferPlatform + " m_wAppType:" + this.mwAppType + " m_nResult:" + this.mnResult + " m_nSrvReturCode:" + this.mnSrvReturCode + " m_strFileName:" + this.mstrFileName + " m_strSuffix:" + this.mstrSuffix + " m_u64FileSize:" + this.mu64FileSize + " m_uPeerUin:" + this.muPeerUin + " m_uGroupCode:" + this.muGroupCode + " m_bIsXTFValid:" + this.mbIsXTFValid + " m_u64TransferSpeed:" + this.mu64TransferSpeed + " m_u64HttpTime:" + this.mu64HttpTime + " m_u64TransferSize:" + this.mu64TransferSize + " m_strServerIp:" + this.mstrServerIp + " m_wServerPort:" + ((int) this.mwServerPort) + " m_dwProxyType:" + this.mdwProxyType + " m_strFileUrl:" + this.mstrFileUrl + " m_u64StartSize:" + this.mu64StartSize + " m_u64ReportVer:" + this.mu64ReportVer + " m_eInvalidReason:" + this.meInvalidReason + " m_uMaxUploadingFtnNum:" + this.muMaxUploadingFtnNum + " m_uRetryCount:" + this.muRetryCount + " m_uIpChangeCount:" + this.muIpChangeCount + " m_uRollBackCount:" + this.muRollBackCount + " m_uQueryHoleCount:" + this.muQueryHoleCount + " m_uRangDiffCount:" + this.muRangDiffCount + " m_uDelayTotoalCount:" + this.muDelayTotoalCount + " m_nTcpCnnCode:" + this.mnTcpCnnCode + " m_nTcpSocketCode:" + this.mnTcpSocketCode + " m_wHttpsSupport:" + ((int) this.mwHttpsSupport) + " m_uTotalTime:" + this.muTotalTime + " m_uFullHashCaculateTime:" + this.muFullHashCaculateTime;
    }
}
