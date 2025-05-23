package com.tencent.mobileqq.transfile.ipv6;

import com.tencent.mobileqq.highway.ipv6.Ipv6Config;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.dns.api.IIpStrategy;

/* compiled from: P */
/* loaded from: classes19.dex */
public class IpStrategyFactory {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "IpStrategyFactory";

    public IpStrategyFactory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static IpStrategy createDownStrategy() {
        if (!getRichmediaIpv6Switch()) {
            return new Ipv4FirstStrategy();
        }
        int i3 = Ipv6Config.getFlags().mRMDownStrategy;
        if (i3 == 2) {
            return new Ipv6FirstStrategy();
        }
        if (i3 == 3) {
            return new IpFirstAsMSFStrategy(MsfServiceSdk.get().getConnectedIPFamily());
        }
        return new Ipv4FirstStrategy();
    }

    public static boolean createIpv6Flag() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "isIpv6Selected ");
        }
        int activeNetIpFamily = NetConnInfoCenter.getActiveNetIpFamily(true);
        if (activeNetIpFamily == 2) {
            return true;
        }
        if (activeNetIpFamily == 3) {
            return isIpv6DownFirst();
        }
        return false;
    }

    private static boolean getRichmediaIpv6Switch() {
        try {
            return ((IIpStrategy) QRoute.api(IIpStrategy.class)).isRichMediaIpv6SwitchOpen();
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "isIpv6DownFirst error", th5);
            return false;
        }
    }

    private static boolean isIpv6DownFirst() {
        if (!getRichmediaIpv6Switch()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "isIpv6DownFirst, getRichmediaIpv6Switch is false");
            }
            return false;
        }
        if (Ipv6Config.getFlags().mRMDownStrategy == 2) {
            return true;
        }
        if (Ipv6Config.getFlags().mRMDownStrategy != 3 || MsfServiceSdk.get().getConnectedIPFamily() != 2) {
            return false;
        }
        return true;
    }
}
