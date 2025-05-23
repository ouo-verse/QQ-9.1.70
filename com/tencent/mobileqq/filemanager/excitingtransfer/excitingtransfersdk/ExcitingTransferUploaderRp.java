package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ExcitingTransferUploaderRp {
    public String mstrFileName;
    public String mstrFileUrl;
    public String mstrServerIp;
    public String mstrSuffix;
    public int mcXTFTransferType = -1;
    public int mwTranferPlatform = -1;
    public int mwAppType = -1;
    public long mnResult = 0;
    public long mnSrvReturCode = 0;
    public long mu64FileSize = 0;
    public long muPeerUin = 0;
    public long muGroupCode = 0;
    public boolean mbIsBigData = false;
    public long mu64TransferSpeed = 0;
    public long mu64HttpTime = 0;
    public long mu64TransferSize = 0;
    public short mwServerPort = 0;
    public int mdwProxyType = 0;

    public String toString() {
        return "TransferType:" + this.mcXTFTransferType + " m_wTranferPlatform:" + this.mwTranferPlatform + " m_wAppType:" + this.mwAppType + " m_nResult:" + this.mnResult + " m_nSrvReturCode:" + this.mnSrvReturCode + " m_strFileName:" + this.mstrFileName + " m_strSuffix:" + this.mstrSuffix + " m_u64FileSize:" + this.mu64FileSize + " m_uPeerUin:" + this.muPeerUin + " m_uGroupCode:" + this.muGroupCode + " m_bIsBigData:" + this.mbIsBigData + " m_u64TransferSpeed:" + this.mu64TransferSpeed + " m_u64HttpTime:" + this.mu64HttpTime + " m_u64TransferSize:" + this.mu64TransferSize + " m_strServerIp:" + this.mstrServerIp + " m_wServerPort:" + ((int) this.mwServerPort) + " m_dwProxyType:" + this.mdwProxyType + " m_strFileUrl:" + this.mstrFileUrl;
    }
}
