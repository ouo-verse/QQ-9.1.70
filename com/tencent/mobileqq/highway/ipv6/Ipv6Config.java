package com.tencent.mobileqq.highway.ipv6;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes9.dex */
public class Ipv6Config {
    static IPatchRedirector $redirector_ = null;
    public static final String SP_KEY_IPV6_STRATEGY_BDH = "ipv6_strategy_bdh";
    public static final String SP_KEY_IPV6_STRATEGY_CAD = "ipv6_strategy_cad";
    public static final String SP_KEY_IPV6_STRATEGY_RMD = "ipv6_strategy_rm_down";
    public static final int STRATEGY_FIRST_AS_MSF = 3;
    public static final int STRATEGY_V4_FIRST = 1;
    public static final int STRATEGY_V6_FIRST = 2;
    private static volatile Ipv6Flags sIpv6Flags;

    public Ipv6Config() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static synchronized Ipv6Flags getFlags() {
        Ipv6Flags ipv6Flags;
        synchronized (Ipv6Config.class) {
            if (sIpv6Flags == null) {
                sIpv6Flags = readFromSP();
            }
            ipv6Flags = sIpv6Flags;
        }
        return ipv6Flags;
    }

    private static void persistCfg(Context context, int i3, int i16, int i17) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt(SP_KEY_IPV6_STRATEGY_RMD, i3);
        edit.putInt(SP_KEY_IPV6_STRATEGY_BDH, i16);
        edit.putInt(SP_KEY_IPV6_STRATEGY_CAD, i17);
        edit.commit();
    }

    private static Ipv6Flags readFromSP() {
        Ipv6Flags ipv6Flags = new Ipv6Flags();
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
        ipv6Flags.mRMDownStrategy = defaultSharedPreferences.getInt(SP_KEY_IPV6_STRATEGY_RMD, 0);
        ipv6Flags.mBdhStrategy = defaultSharedPreferences.getInt(SP_KEY_IPV6_STRATEGY_BDH, 0);
        ipv6Flags.mConnAttemptDelay = defaultSharedPreferences.getInt(SP_KEY_IPV6_STRATEGY_CAD, 0);
        BdhLogUtil.LogEvent("E", "readFromSP: sRMDownStrategy = " + ipv6Flags.mRMDownStrategy + ", sBdhStrategy = " + ipv6Flags.mBdhStrategy + ", sConnAttemptDelay = " + ipv6Flags.mConnAttemptDelay);
        return ipv6Flags;
    }

    public static synchronized void updateCfgFromSrv(Context context, int i3, int i16, int i17) {
        synchronized (Ipv6Config.class) {
            BdhLogUtil.LogEvent("E", "Ipv6Config.updateCfgFromSrv: rmDownStrategy = " + i3 + ", bdhStrategy = " + i16 + ", connAttemptDelay = " + i17);
            sIpv6Flags = new Ipv6Flags(i3, i16, i17);
            persistCfg(context, i3, i16, i17);
        }
    }
}
