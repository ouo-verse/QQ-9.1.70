package com.tencent.replacemonitor.replace.st;

import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.replacemonitor.MonitorStep;
import com.tencent.replacemonitor.MonitorType;
import com.tencent.tmassistantbase.util.b;

/* compiled from: P */
/* loaded from: classes25.dex */
public class ReplaceMonitorLog extends ReplaceBaseLog {
    static IPatchRedirector $redirector_;
    public String additionalId;
    public int appType;
    public String channelId;
    public long fileSize;
    public MonitorType monitorType;
    public String replaceChannelId;
    public String replaceFileMd5;
    public long replaceFileSize;
    public long replaceInterval;
    public String replacePackageName;
    public long replaceVersionCode;
    public MonitorStep step;

    public ReplaceMonitorLog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.replacemonitor.replace.st.ReplaceBaseLog, com.tencent.tmassistant.st.a
    public String build() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.packageName + "|" + this.versionCode + "|" + this.fileSize + "|" + this.channelId + "|" + this.yybAppId + "|" + this.yybApkId + "|" + this.replacePackageName + "|" + this.replaceVersionCode + "|" + this.replaceFileSize + "|" + this.replaceChannelId + "|" + this.replaceFileMd5 + "|" + this.additionalId + "|" + this.traceId + "|" + this.appType + "|" + this.replaceInterval + "|" + this.step + "|" + this.monitorType + "|" + this.isTDownloadApp + "|" + b.a(this.externalParams, ContainerUtils.FIELD_DELIMITER);
    }

    @Override // com.tencent.tmassistant.st.a
    protected int getType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 5001;
    }
}
