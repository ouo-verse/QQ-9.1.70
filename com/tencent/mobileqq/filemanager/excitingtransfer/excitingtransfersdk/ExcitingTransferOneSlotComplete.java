package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ExcitingTransferOneSlotComplete {
    public long mConnectTimes;
    public long mDownloadedSize;
    public int mPort;
    public int mSrvRetCode;

    @Deprecated
    public int mSubReason;
    public long mTotalTimes;

    @Deprecated
    public int mUserRetCode;
    public String mstrIp;

    public HashMap<String, String> getReportData() {
        String str;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("param_strIp", String.valueOf(this.mstrIp));
        hashMap.put("param_Port", String.valueOf(this.mPort));
        hashMap.put("param_SrvRetCode", String.valueOf(this.mSrvRetCode));
        hashMap.put("param_ConnectTimes", String.valueOf(this.mConnectTimes));
        hashMap.put("param_TotalTimes", String.valueOf(this.mTotalTimes));
        hashMap.put("param_DownloadedSize", String.valueOf(this.mDownloadedSize));
        long j3 = this.mTotalTimes;
        if (j3 != 0) {
            str = String.valueOf(((float) this.mDownloadedSize) / ((float) j3));
        } else {
            str = "0";
        }
        hashMap.put("param_speed", str);
        return hashMap;
    }

    public String toString() {
        return "m_strIp:" + this.mstrIp + " m_Port:" + this.mPort + " m_SubReason:" + this.mSubReason + " m_SrvRetCode:" + this.mSrvRetCode + " m_UserRetCode:" + this.mUserRetCode + " m_ConnectTimes:" + this.mConnectTimes + " m_TotalTimes:" + this.mTotalTimes + " m_DownloadedSize:" + this.mDownloadedSize;
    }
}
