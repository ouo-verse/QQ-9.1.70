package com.tencent.mobileqq.highway.netprobe;

import android.text.TextUtils;
import com.tencent.mobileqq.highway.netprobe.ProbeItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.RuntimeMonitor;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes9.dex */
public class PingProbe extends ProbeItem {
    static IPatchRedirector $redirector_ = null;
    public static final int DEFAULT_PING_COUNT = 3;
    public static final int DEFAULT_PING_TIMEOUT = 10;
    private static final String PING_RESULT_REGEX = "(\\d+) packets transmitted, (\\d+)[\\s\\S]* received, (\\d+).*";
    public static String PROBE_NAME = null;
    public static final int RESULT_CONN_BLOCKING = 2;
    public static final int RESULT_EXCEPTION = 1;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12844);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            PROBE_NAME = "Ping_Probe";
        }
    }

    public PingProbe() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String execPing(String str) {
        return execPing(3, 10, str);
    }

    @Override // com.tencent.mobileqq.highway.netprobe.ProbeItem
    public void doProbe() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        String execPing = execPing(this.mRequest.getIp());
        if (execPing != null && !TextUtils.isEmpty(execPing)) {
            Matcher matcher = Pattern.compile(PING_RESULT_REGEX).matcher(execPing);
            if (matcher.find() && matcher.groupCount() == 3) {
                this.mResult.extra = matcher.group();
                try {
                    if (Integer.valueOf(matcher.group(2)).intValue() > 0) {
                        ProbeItem.ProbeResult probeResult = this.mResult;
                        probeResult.success = true;
                        probeResult.appendResult(matcher.group());
                    } else {
                        ProbeItem.ProbeResult probeResult2 = this.mResult;
                        probeResult2.success = false;
                        probeResult2.errCode = 2;
                        probeResult2.errDesc = matcher.group();
                    }
                    return;
                } catch (NumberFormatException e16) {
                    e16.printStackTrace();
                    ProbeItem.ProbeResult probeResult3 = this.mResult;
                    probeResult3.success = false;
                    probeResult3.errCode = 1;
                    probeResult3.errDesc = e16.toString();
                    return;
                }
            }
            return;
        }
        ProbeItem.ProbeResult probeResult4 = this.mResult;
        probeResult4.success = false;
        probeResult4.errCode = 1;
        probeResult4.errDesc = "ping progress has exception!";
    }

    @Override // com.tencent.mobileqq.highway.netprobe.ProbeItem
    public String getProbeName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return PROBE_NAME;
    }

    public static String execPing(int i3, String str) {
        return execPing(3, i3, str);
    }

    public static String execPing(int i3, int i16, String str) {
        return execPing(i3, i16, -1, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x00d7, code lost:
    
        if (r3 == null) goto L42;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String execPing(int i3, int i16, int i17, String str) {
        String str2;
        Process process;
        BufferedReader bufferedReader;
        int waitFor;
        String sb5;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (i3 > 0) {
            str2 = "ping  -c " + i3;
        } else {
            str2 = "ping  -c 3";
        }
        if (i16 > 0) {
            str2 = str2 + " -W " + i16;
        }
        if (i17 > 0) {
            str2 = str2 + " -s " + i17;
        }
        try {
            process = RuntimeMonitor.exec(Runtime.getRuntime(), str2 + " " + str);
            try {
                waitFor = process.waitFor();
                bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            } catch (Throwable th5) {
                th = th5;
                bufferedReader = null;
            }
        } catch (Throwable th6) {
            th = th6;
            process = null;
            bufferedReader = null;
        }
        try {
            StringBuilder sb6 = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb6.append(readLine);
                sb6.append("\n");
            }
            sb5 = sb6.toString();
        } catch (Throwable th7) {
            th = th7;
            try {
                th.printStackTrace();
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception unused) {
                    }
                }
            } finally {
            }
        }
        if (waitFor != 0 && sb5.trim().length() == 0) {
            try {
                bufferedReader.close();
            } catch (Exception unused2) {
            }
            process.destroy();
            return null;
        }
        String trim = sb5.trim();
        try {
            bufferedReader.close();
        } catch (Exception unused3) {
        }
        process.destroy();
        return trim;
    }
}
