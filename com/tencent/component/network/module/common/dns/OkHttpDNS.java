package com.tencent.component.network.module.common.dns;

import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.utils.http.pool.CustomDnsResolve;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import okhttp3.Dns;

/* compiled from: P */
/* loaded from: classes5.dex */
public class OkHttpDNS implements Dns {
    private OkHttpDNSManager okHttpDNSManager;

    public OkHttpDNS(CustomDnsResolve customDnsResolve) {
        this.okHttpDNSManager = new OkHttpDNSManager(customDnsResolve);
    }

    @Override // okhttp3.Dns
    public List<InetAddress> lookup(String str) throws UnknownHostException {
        QDLog.i(QDLog.TAG_DOWNLOAD, "OkHttpDNS lookup:" + str);
        return this.okHttpDNSManager.getAllByName(str);
    }
}
