package com.tencent.mobileqq.highway.netprobe;

import android.text.TextUtils;
import com.tencent.mobileqq.highway.netprobe.ProbeItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes9.dex */
public class MtuProbe extends ProbeItem {
    static IPatchRedirector $redirector_ = null;
    private static final int MAX_MTU = 1472;
    private static final int MIN_MTU = 56;
    private static final int[] MTU_COMMON_VALUES;
    private static final int PACKAGE_RECEIVED_INDEX = 2;
    private static final Pattern PING_RESULT_PATTERN;
    public static final String PROBE_NAME = "Mtu_Probe";
    public static final int RESULT_BLOCKING_CONNECT = 1;
    public static final int RESULT_OK = 0;
    private String mPeerIp;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12806);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            PING_RESULT_PATTERN = Pattern.compile("---\\n(\\d+) packets transmitted, (\\d+)[\\s\\S]* received, (\\d+).*");
            MTU_COMMON_VALUES = new int[]{1390, 1400, 1492};
        }
    }

    public MtuProbe() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private int findMaxMtu() {
        int i3 = 56;
        int i16 = MAX_MTU;
        int i17 = 0;
        while (true) {
            int[] iArr = MTU_COMMON_VALUES;
            if (i17 < iArr.length) {
                int i18 = iArr[i17] - 28;
                String execPing = PingProbe.execPing(3, 10, i18, this.mPeerIp);
                if (execPing == null) {
                    return -1;
                }
                if (!isSuccess(execPing)) {
                    if (i18 < i16) {
                        i16 = i18;
                    }
                } else if (i18 >= i3) {
                    i3 = i18;
                }
                i17++;
            } else {
                while (i3 < i16) {
                    int i19 = (int) (((i3 + i16) / 2.0f) + 0.5d);
                    String execPing2 = PingProbe.execPing(3, 10, i19, this.mPeerIp);
                    if (execPing2 == null) {
                        return -1;
                    }
                    if (isSuccess(execPing2)) {
                        i3 = i19;
                    } else {
                        i16 = i19 - 1;
                    }
                }
                return i3 + 28;
            }
        }
    }

    @Override // com.tencent.mobileqq.highway.netprobe.ProbeItem
    public void doProbe() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.mPeerIp = this.mRequest.getIp();
        if (isConnecting()) {
            onFinish(0, Integer.valueOf(findMaxMtu()));
        } else {
            onFinish(1, null);
        }
    }

    @Override // com.tencent.mobileqq.highway.netprobe.ProbeItem
    public String getProbeName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return PROBE_NAME;
    }

    public int getRecvPkgNum(String str) {
        Matcher matcher;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str)).intValue();
        }
        if ((str == null && TextUtils.isEmpty(str)) || (matcher = PING_RESULT_PATTERN.matcher(str)) == null || !matcher.find() || matcher.groupCount() != 3) {
            return -1;
        }
        return Integer.valueOf(matcher.group(2)).intValue();
    }

    public boolean isConnecting() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return isSuccess(PingProbe.execPing(56, this.mPeerIp));
    }

    public boolean isSuccess(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str)).booleanValue();
        }
        if (getRecvPkgNum(str) > 0) {
            return true;
        }
        return false;
    }

    public void onFinish(int i3, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3, obj);
            return;
        }
        if (i3 != 0) {
            if (i3 == 1) {
                this.mResult.errDesc = "the ip " + this.mPeerIp + " can't transmit package!";
                ProbeItem.ProbeResult probeResult = this.mResult;
                probeResult.success = false;
                probeResult.errCode = 1;
                return;
            }
            return;
        }
        this.mResult.appendResult("successful find the max mtu : " + ((Integer) obj));
        this.mResult.success = true;
    }
}
