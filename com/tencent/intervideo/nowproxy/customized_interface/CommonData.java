package com.tencent.intervideo.nowproxy.customized_interface;

import android.os.Build;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;

/* compiled from: P */
/* loaded from: classes7.dex */
public class CommonData {
    static IPatchRedirector $redirector_;
    public String appid;
    public String deviceid;
    public String guid;
    public String hostUid;
    public String hostVersion;
    public String macversion;
    public String platform;
    public String pmVersion;
    public String sysversion;

    public CommonData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.platform = "2";
        this.appid = "";
        this.deviceid = "";
        this.hostVersion = "";
        this.sysversion = Build.VERSION.RELEASE;
        this.macversion = DeviceInfoMonitor.getModel();
        this.hostUid = "";
        this.pmVersion = String.valueOf(12);
        this.guid = "";
    }
}
