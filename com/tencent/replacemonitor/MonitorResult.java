package com.tencent.replacemonitor;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes25.dex */
public class MonitorResult {
    static IPatchRedirector $redirector_;
    public MonitorType monitorType;
    public String replaceChannelId;
    public String replaceFileMD5;
    public long replaceTime;
    public long replacedFileSize;
    public String replacedPkgName;
    public long replacedVersionCode;
    public int resultCode;
    public String resultMsg;
    public MonitorStep step;

    public MonitorResult(MonitorStep monitorStep, int i3, String str, MonitorType monitorType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, monitorStep, Integer.valueOf(i3), str, monitorType);
            return;
        }
        this.step = monitorStep;
        this.monitorType = monitorType;
        this.resultCode = i3;
        this.resultMsg = str;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        StringBuffer stringBuffer = new StringBuffer(" step = ");
        stringBuffer.append(this.step);
        stringBuffer.append(" resultCode = ");
        stringBuffer.append(this.resultCode);
        stringBuffer.append(" resultMsg = ");
        stringBuffer.append(this.resultMsg);
        stringBuffer.append(" monitorType = ");
        stringBuffer.append(this.monitorType);
        stringBuffer.append(" replacedPkgName = ");
        stringBuffer.append(this.replacedPkgName);
        stringBuffer.append(" replacedVersionCode = ");
        stringBuffer.append(this.replacedVersionCode);
        stringBuffer.append(" replacedFileSize = ");
        stringBuffer.append(this.replacedFileSize);
        stringBuffer.append(" replaceChannelId = ");
        stringBuffer.append(this.replaceChannelId);
        stringBuffer.append(" replaceFileMD5 = ");
        stringBuffer.append(this.replaceFileMD5);
        stringBuffer.append(" replaceTime = ");
        stringBuffer.append(this.replaceTime);
        return stringBuffer.toString();
    }
}
