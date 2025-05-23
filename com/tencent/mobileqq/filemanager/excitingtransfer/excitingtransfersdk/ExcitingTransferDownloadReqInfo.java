package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

import com.tencent.commonsdk.util.HexUtil;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ExcitingTransferDownloadReqInfo {
    public byte[] md5;
    public String strFileName;
    public String strSaveFileDir;
    public String strTempFilePath;
    public long fileSize = 0;
    public ExcitingTransferHostInfo[] mHosts = null;
    public String serverPath = null;
    public String strCookie = null;
    public boolean isSupportHttps = false;
    public String sslCName = null;
    public String mLanHost = null;
    public int mLanPort = 0;
    public byte[] bufLanUuid = null;
    public long mSRKey = 0;

    public String toString() {
        ExcitingTransferHostInfo[] excitingTransferHostInfoArr = this.mHosts;
        String str = "";
        if (excitingTransferHostInfoArr != null) {
            for (ExcitingTransferHostInfo excitingTransferHostInfo : excitingTransferHostInfoArr) {
                str = str + "[" + excitingTransferHostInfo.mstrIp + ":" + excitingTransferHostInfo.mport + "] ";
            }
        }
        return "strFileName:" + this.strFileName + " fileSize:" + this.fileSize + " serverPath:" + this.serverPath + " strCookie:" + this.strCookie + " hostList:" + str + " isSupportHttps:" + this.isSupportHttps + " sslCName:" + this.sslCName + " strSaveFileDir:" + this.strSaveFileDir + " strTempFilePath:" + this.strTempFilePath + " md5:" + HexUtil.bytes2HexStr(this.md5);
    }
}
