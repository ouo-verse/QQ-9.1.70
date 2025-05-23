package com.tencent.component.network.module.common.dns;

import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.utils.http.pool.CustomDnsResolve;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;
import okhttp3.Dns;

/* compiled from: P */
/* loaded from: classes5.dex */
public class OkHttpDNSManager {
    private CustomDnsResolve customDnsResolve;

    public OkHttpDNSManager(CustomDnsResolve customDnsResolve) {
        this.customDnsResolve = customDnsResolve;
    }

    public List<InetAddress> getAllByName(String str) throws UnknownHostException {
        InetAddress[] inetAddressArr;
        List<InetAddress> lookup;
        CustomDnsResolve customDnsResolve = this.customDnsResolve;
        if (customDnsResolve != null) {
            inetAddressArr = customDnsResolve.getAllByName(str);
            if (inetAddressArr != null && inetAddressArr.length > 0) {
                QDLog.i(QDLog.TAG_DOWNLOAD, "OkHttpDNSManager customDnsResolve.getAllByName");
            } else {
                inetAddressArr = this.customDnsResolve.resolveByDns(str);
                if (inetAddressArr != null && inetAddressArr.length > 0) {
                    QDLog.i(QDLog.TAG_DOWNLOAD, "OkHttpDNSManager customDnsResolve.resolveByDns");
                }
            }
        } else {
            inetAddressArr = null;
        }
        if (inetAddressArr != null && inetAddressArr.length > 0) {
            lookup = Arrays.asList(inetAddressArr);
        } else {
            lookup = Dns.SYSTEM.lookup(str);
            QDLog.i(QDLog.TAG_DOWNLOAD, "OkHttpDNSManager Dns.SYSTEM.lookup");
        }
        StringBuilder sb5 = new StringBuilder();
        if (lookup != null) {
            for (InetAddress inetAddress : lookup) {
                if (inetAddress != null) {
                    sb5.append(inetAddress.getHostAddress());
                    sb5.append(";");
                }
            }
        }
        QDLog.i(QDLog.TAG_DOWNLOAD, "OkHttpDNSManager" + sb5.toString());
        return lookup;
    }
}
