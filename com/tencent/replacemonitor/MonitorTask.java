package com.tencent.replacemonitor;

import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tmassistantbase.util.b;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes25.dex */
public class MonitorTask {
    static IPatchRedirector $redirector_;
    public String additionalId;
    public String appName;
    public int appType;
    public String cpChannelId;
    public String downloadUrl;
    public Map<String, String> externalParams;
    public String fileMd5;
    public String filePath;
    public long fileSize;

    /* renamed from: id, reason: collision with root package name */
    public long f364885id;
    public String installDir;
    public boolean isTencentDownload;
    public long lastModifedTime;
    public MonitorStep lastStep;
    public String packageName;
    public String traceId;
    public int versionCode;
    public long yybApkId;
    public long yybAppId;

    public MonitorTask() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        StringBuffer stringBuffer = new StringBuffer("MonitorTask:");
        stringBuffer.append(" id = ");
        stringBuffer.append(this.f364885id);
        stringBuffer.append(" packageName = ");
        stringBuffer.append(this.packageName);
        stringBuffer.append(" versionCode = ");
        stringBuffer.append(this.versionCode);
        stringBuffer.append(" appName = ");
        stringBuffer.append(this.appName);
        stringBuffer.append(" fileSize = ");
        stringBuffer.append(this.fileSize);
        stringBuffer.append(" fileMd5 = ");
        stringBuffer.append(this.fileMd5);
        stringBuffer.append(" cpChannelId = ");
        stringBuffer.append(this.cpChannelId);
        stringBuffer.append(" filePath = ");
        stringBuffer.append(this.filePath);
        stringBuffer.append(" downloadUrl = ");
        stringBuffer.append(this.downloadUrl);
        stringBuffer.append(" yybAppId = ");
        stringBuffer.append(this.yybAppId);
        stringBuffer.append(" yybApkId = ");
        stringBuffer.append(this.yybApkId);
        stringBuffer.append(" installDir = ");
        stringBuffer.append(this.installDir);
        stringBuffer.append(" lastModifedTime = ");
        stringBuffer.append(this.lastModifedTime);
        stringBuffer.append(" additionalId = ");
        stringBuffer.append(this.additionalId);
        stringBuffer.append(" traceId = ");
        stringBuffer.append(this.traceId);
        stringBuffer.append(" appType = ");
        stringBuffer.append(this.appType);
        stringBuffer.append(" lastStep = ");
        stringBuffer.append(this.lastStep);
        stringBuffer.append(" isTencentDownload = ");
        stringBuffer.append(this.isTencentDownload);
        stringBuffer.append(" externalParams = ");
        stringBuffer.append(b.a(this.externalParams, ContainerUtils.FIELD_DELIMITER));
        return stringBuffer.toString();
    }

    public MonitorTask(String str, int i3, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), str2, str3);
            return;
        }
        this.packageName = str;
        this.versionCode = i3;
        this.downloadUrl = str2;
        this.filePath = str3;
    }

    public MonitorTask(String str, int i3, String str2, String str3, long j3, String str4) {
        this(str, i3, str2, str3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), str2, str3, Long.valueOf(j3), str4);
        } else {
            this.fileSize = j3;
            this.fileMd5 = str4;
        }
    }
}
