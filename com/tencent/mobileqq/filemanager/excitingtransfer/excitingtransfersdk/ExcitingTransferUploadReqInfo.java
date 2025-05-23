package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ExcitingTransferUploadReqInfo {
    public boolean bSupportHttps = false;
    public String strSSLCName;
    public ExcitingTransferHostInfo[] vecSrvIpAndPorts;

    public String toString() {
        ExcitingTransferHostInfo[] excitingTransferHostInfoArr = this.vecSrvIpAndPorts;
        String str = "";
        if (excitingTransferHostInfoArr != null) {
            for (ExcitingTransferHostInfo excitingTransferHostInfo : excitingTransferHostInfoArr) {
                str = str + "[" + excitingTransferHostInfo.mstrIp + ":" + excitingTransferHostInfo.mport + "] ";
            }
        }
        return "BigData Host:" + str + " strSSLCName:" + this.strSSLCName + " bSupportHttps:" + this.bSupportHttps;
    }
}
