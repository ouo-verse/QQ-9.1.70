package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

import java.util.HashMap;

/* loaded from: classes12.dex */
public class ExcitingTransferDownloaderFirstPkgRp {
    public long mCSEndTime;
    public long mCSStartTime;
    public long mHttpFirstTime = 0;
    public long mHtpFirstDataSize = -1;

    public HashMap<String, String> getReportData() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("param_CSTime", String.valueOf(this.mCSEndTime - this.mCSStartTime));
        hashMap.put("param_HttpFirstTime", String.valueOf(this.mHttpFirstTime));
        hashMap.put("param_HttpFirstDataSize", String.valueOf(this.mHtpFirstDataSize));
        return hashMap;
    }
}
