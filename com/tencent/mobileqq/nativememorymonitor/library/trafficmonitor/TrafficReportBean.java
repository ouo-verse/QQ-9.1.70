package com.tencent.mobileqq.nativememorymonitor.library.trafficmonitor;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class TrafficReportBean {
    static IPatchRedirector $redirector_;
    public long bgMobileDownloadTraffic;
    public long bgMobileUploadTraffic;
    public long bgWifiDownloadTraffic;
    public long bgWifiUploadTraffic;

    /* renamed from: ip, reason: collision with root package name */
    public String f252487ip;
    public long mobileDownLoadTraffic;
    public long mobileUpLoadTraffic;
    public int port;
    public String threadName;
    public String threadStack;
    public int trafficAlertType;
    public long wifiDownLoadTraffic;
    public long wifiUploadTraffic;

    public TrafficReportBean(String str, int i3, String str2, String str3, long j3, long j16, long j17, long j18, long j19, long j26, long j27, long j28, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), str2, str3, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), Long.valueOf(j18), Long.valueOf(j19), Long.valueOf(j26), Long.valueOf(j27), Long.valueOf(j28), Integer.valueOf(i16));
            return;
        }
        this.f252487ip = str;
        this.port = i3;
        this.threadName = str2;
        this.threadStack = str3;
        this.mobileDownLoadTraffic = j3;
        this.mobileUpLoadTraffic = j16;
        this.wifiDownLoadTraffic = j17;
        this.wifiUploadTraffic = j18;
        this.bgMobileDownloadTraffic = j19;
        this.bgMobileUploadTraffic = j26;
        this.bgWifiDownloadTraffic = j27;
        this.bgWifiUploadTraffic = j28;
        this.trafficAlertType = i16;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "TrafficReportBean{ip='" + this.f252487ip + "', port=" + this.port + ", threadName='" + this.threadName + "', threadStack='" + this.threadStack + "', mobileDownLoadTraffic=" + this.mobileDownLoadTraffic + ", mobileUpLoadTraffic=" + this.mobileUpLoadTraffic + ", wifiDownLoadTraffic=" + this.wifiDownLoadTraffic + ", wifiUploadTraffic=" + this.wifiUploadTraffic + ", bgMobileDownloadTraffic=" + this.bgMobileDownloadTraffic + ", bgMobileUploadTraffic=" + this.bgMobileUploadTraffic + ", bgWifiDownloadTraffic=" + this.bgWifiDownloadTraffic + ", bgWifiUploadTraffic=" + this.bgWifiUploadTraffic + ", trafficAlertType=" + this.trafficAlertType + '}';
    }
}
