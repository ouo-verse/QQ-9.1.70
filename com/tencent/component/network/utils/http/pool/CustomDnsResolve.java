package com.tencent.component.network.utils.http.pool;

import android.text.TextUtils;
import com.tencent.component.network.downloader.strategy.IPStrategy;
import com.tencent.component.network.module.base.Config;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.module.common.DnsService;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes5.dex */
public class CustomDnsResolve {
    private static final String TAG = "downloader_CustomDnsResolve";
    private static final ConcurrentHashMap<String, Boolean> mapIPDirectEnable = new ConcurrentHashMap<>();
    private final List<IPStrategy> mIPStrategys = new ArrayList();

    private InetAddress[] getDirectIpList(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            Iterator<IPStrategy> it = this.mIPStrategys.iterator();
            while (it.hasNext()) {
                String resolveIP = it.next().resolveIP(str);
                if (!TextUtils.isEmpty(resolveIP)) {
                    InetAddress byName = InetAddress.getByName(resolveIP);
                    if (!arrayList.contains(byName)) {
                        arrayList.add(byName);
                    }
                }
            }
        } catch (Throwable th5) {
            QDLog.e(TAG, "getDirectIpList exp:", th5);
        }
        InetAddress[] inetAddressArr = new InetAddress[arrayList.size()];
        arrayList.toArray(inetAddressArr);
        return inetAddressArr;
    }

    private boolean isIPDirectEnable(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        ConcurrentHashMap<String, Boolean> concurrentHashMap = mapIPDirectEnable;
        if (!concurrentHashMap.containsKey(str)) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("enable ip direct is ");
            sb5.append(!Config.isForceDNSFirst());
            QDLog.d(TAG, sb5.toString());
            return !Config.isForceDNSFirst();
        }
        return concurrentHashMap.get(str).booleanValue();
    }

    private InetAddress[] resolveByDnsAndIpStack(String str) {
        InetAddress[] domainIpAddress = DnsService.getInstance().getDomainIpAddress(str);
        if (domainIpAddress != null && domainIpAddress.length != 0) {
            return domainIpAddress;
        }
        return new InetAddress[0];
    }

    public static void setIPDirectEnable(String str, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        mapIPDirectEnable.put(str, Boolean.valueOf(z16));
    }

    public void addIpStrategy(IPStrategy iPStrategy) {
        if (iPStrategy != null && !this.mIPStrategys.contains(iPStrategy)) {
            this.mIPStrategys.add(iPStrategy);
        }
    }

    public InetAddress[] getAllByName(String str) throws UnknownHostException {
        if (TextUtils.isEmpty(str)) {
            return new InetAddress[0];
        }
        if (isIPDirectEnable(str)) {
            QDLog.d(TAG, "getAllByName enable IP Direct first");
            return getDirectIpList(str);
        }
        QDLog.d(TAG, "getAllByName force DNS first");
        return resolveByDns(str);
    }

    public InetAddress[] resolveByDns(String str) throws UnknownHostException {
        if (TextUtils.isEmpty(str)) {
            return new InetAddress[0];
        }
        if (Config.isUseSmartIpStackStrategy()) {
            QDLog.i(TAG, "resolveByDns by smart ipstack strategy");
            return resolveByDnsAndIpStack(str);
        }
        String domainIP = DnsService.getInstance().getDomainIP(str);
        if (TextUtils.isEmpty(domainIP)) {
            return new InetAddress[0];
        }
        return new InetAddress[]{InetAddress.getByName(domainIP)};
    }
}
