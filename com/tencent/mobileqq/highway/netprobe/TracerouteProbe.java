package com.tencent.mobileqq.highway.netprobe;

import android.annotation.SuppressLint;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.RuntimeMonitor;
import java.io.BufferedReader;
import java.io.InputStreamReader;

@SuppressLint({"DefaultLocale"})
/* loaded from: classes9.dex */
public class TracerouteProbe extends ProbeItem {
    static IPatchRedirector $redirector_ = null;
    public static final int DEFAULT_MAX_TTL = 30;
    public static final String PROBE_NAME = "Traceroute_Probe";

    /* renamed from: cb, reason: collision with root package name */
    private TraceroutCallback f236836cb;
    private String mHost;
    private String mIp;
    private int mMaxTTL;
    private int mTimeout;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public interface TraceroutCallback {
        void progress(String str);
    }

    public TracerouteProbe() {
        this(30, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private String getDestation() {
        if (TextUtils.isEmpty(this.mIp)) {
            return this.mHost;
        }
        return this.mIp;
    }

    private String parseDestIp(String str) {
        if (str.contains("ping")) {
            return str.substring(str.indexOf("(") + 1, str.indexOf(")"));
        }
        return "";
    }

    private String parseRespIp(String str) {
        String str2;
        int i3;
        int indexOf;
        int indexOf2 = str.indexOf("from");
        if (indexOf2 < 0 || (indexOf = str.indexOf(" ", (i3 = indexOf2 + 5))) <= 0) {
            str2 = "*";
        } else {
            str2 = str.substring(i3, indexOf);
        }
        String trim = str2.trim();
        if (trim.endsWith(":")) {
            trim = trim.substring(0, trim.length() - 1).trim();
        }
        if (TextUtils.isEmpty(trim)) {
            return "*";
        }
        return trim;
    }

    private String pingNode(String str, int i3) throws Exception {
        String str2 = "";
        Process exec = RuntimeMonitor.exec(Runtime.getRuntime(), "/system/bin/ping -c 1 -w " + this.mTimeout + " -t " + i3 + " " + str);
        try {
            try {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
                    new String();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        str2 = str2 + readLine;
                    }
                    exec.destroy();
                } catch (Exception e16) {
                    e16.printStackTrace();
                    exec.destroy();
                }
            } catch (Exception e17) {
                e17.printStackTrace();
            }
            return str2.toLowerCase();
        } catch (Throwable th5) {
            try {
                exec.destroy();
            } catch (Exception e18) {
                e18.printStackTrace();
            }
            throw th5;
        }
    }

    @Override // com.tencent.mobileqq.highway.netprobe.ProbeItem
    public void doProbe() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.mHost = this.mRequest.getIp();
            process();
        }
    }

    @Override // com.tencent.mobileqq.highway.netprobe.ProbeItem
    public String getProbeName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return PROBE_NAME;
    }

    public void logProgress(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            return;
        }
        TraceroutCallback traceroutCallback = this.f236836cb;
        if (traceroutCallback != null) {
            traceroutCallback.progress(str);
        }
    }

    public void process() {
        String str;
        String parseRespIp;
        String str2;
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        String str4 = "Traceroute to " + this.mHost + ", " + this.mMaxTTL + " hops max, " + this.mTimeout + "s timeout";
        logProgress(str4 + "\n");
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str4);
        sb5.append("\n");
        this.mResult.success = false;
        String str5 = "";
        int i3 = 0;
        while (true) {
            if (i3 > this.mMaxTTL) {
                break;
            }
            try {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                String pingNode = pingNode(getDestation(), i3);
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                String parseDestIp = parseDestIp(pingNode);
                if (TextUtils.isEmpty(this.mIp) && !TextUtils.isEmpty(parseDestIp)) {
                    this.mIp = parseDestIp;
                }
                parseRespIp = parseRespIp(pingNode);
                if (!"*".equals(parseRespIp)) {
                    str3 = String.format("(%d) %s %5dms\n", Integer.valueOf(i3), parseRespIp, Long.valueOf(elapsedRealtime2 - elapsedRealtime)).toString();
                    str2 = str3;
                } else {
                    str2 = str5;
                    str3 = String.format("(%d) %s \n", Integer.valueOf(i3), parseRespIp).toString();
                }
                try {
                    logProgress(str3);
                    sb5.append(str3);
                } catch (Exception e16) {
                    e = e16;
                    str5 = str2;
                    e.printStackTrace();
                    String str6 = "traceroute error: " + e.getMessage();
                    this.mResult.errDesc = str6;
                    sb5.append(str6);
                    sb5.append("\n");
                    i3++;
                }
            } catch (Exception e17) {
                e = e17;
            }
            if (!this.mHost.equals(parseRespIp) && !this.mIp.equals(parseRespIp)) {
                str5 = str2;
                i3++;
            }
            this.mResult.success = true;
            str5 = str2;
            break;
        }
        if (this.mResult.success) {
            str = "Traceroute succ host: " + this.mHost + "(" + this.mIp + ") hops: " + i3;
            this.mResult.appendResult(str);
        } else {
            str = "Traceroute fail host: " + this.mHost + "(" + this.mIp + ") hops: " + this.mMaxTTL;
            this.mResult.errDesc = str5;
        }
        logProgress(str + "\n");
        sb5.append(str);
        sb5.append("\n");
        this.mResult.extra = sb5.toString();
    }

    public TracerouteProbe(int i3) {
        this(i3, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, i3);
    }

    public TracerouteProbe(TraceroutCallback traceroutCallback) {
        this(30, traceroutCallback);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) traceroutCallback);
    }

    public TracerouteProbe(int i3, TraceroutCallback traceroutCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3, (Object) traceroutCallback);
            return;
        }
        this.mHost = "";
        this.mIp = null;
        this.mTimeout = 10;
        this.mMaxTTL = i3;
        this.f236836cb = traceroutCallback;
    }
}
