package com.tenpay.sdk.paynet;

import com.tencent.mobileqq.qwallet.impl.TenpayJumpActivity;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.QwLog;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TenpayHostnameVerifier implements HostnameVerifier {
    private static final String TAG = "TenpayHostnameVerifier";
    private final String tenReg = String.format("^[A-Za-z]+.%s", TenpayJumpActivity.TENPAY_SCHEME);

    private boolean isIp(String str) {
        try {
            InetAddress byName = InetAddress.getByName(str);
            if (!(byName instanceof Inet4Address)) {
                if (!(byName instanceof Inet6Address)) {
                    return false;
                }
            }
            return true;
        } catch (UnknownHostException e16) {
            QLog.e(TAG, 1, "", e16);
            return false;
        }
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        QwLog.i("hostname = " + str + " session = " + sSLSession);
        if (str == null) {
            return false;
        }
        if (isIp(str) || str.matches(this.tenReg)) {
            return true;
        }
        QwLog.i("verify no tenpay host: " + str);
        return false;
    }
}
