package com.tencent.biz.richframework.network.quic.manager;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.network.quic.VSNetLightQUICPingRequest;
import com.tencent.biz.richframework.network.quic.strategy.VSNetWorkStrategy;
import com.tencent.biz.richframework.network.request.VSNetQUICEvent;
import com.tencent.biz.richframework.network.request.VSNetQUICExp;
import com.tencent.component.network.module.common.NetworkState;
import com.tencent.libra.download.LibraDns;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkpublish.api.IUploadApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.lifecycle.IProcessStateChangeCallback;
import com.tencent.richframework.lifecycle.RFWLifecycleHelper;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.util.Pair;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import uq3.d;
import uq3.o;

/* loaded from: classes5.dex */
public class VSNetLightQUICIPStrategyManager {
    private static final long ASYNC_QUIC_DNS_PARSE_THRESHOLD = 180000;
    public static final String FAIL_SCENE_FORWARD = "fail_scene_forward";
    public static final String FAIL_SCENE_PING = "fail_scene_ping";
    private static volatile VSNetLightQUICIPStrategyManager INSTANCE = null;
    public static final int IP_STACK_DUAL = 3;
    public static final int IP_STACK_IPV6 = 2;
    private static final long SYNC_QUIC_DNS_PARSE_THRESHOLD = 3600000;
    private static final String TAG = "QUIC-VSNetLightQUICIPStrategyManager";
    private final AtomicBoolean mCurrentNetConnect;
    private final AtomicInteger mCurrentNetType;
    private final LibraDns mDNS;
    private final Map<String, VSNetAsyncDNSRefreshTask> mVSNetAsyncDNSRefreshTaskMap;
    private final Map<String, Pair<List<String>, List<String>>> mHostIPConfigMap = new ConcurrentHashMap();
    private final Map<String, List<String>> mSortNormalIpMap = new ConcurrentHashMap();
    private final Map<String, List<String>> mReqFailIpMap = new ConcurrentHashMap();
    private final Map<String, Long> mParseDNSTimeMap = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class VSNetAsyncDNSRefreshTask implements Runnable {
        private String mHost;

        public VSNetAsyncDNSRefreshTask(String str) {
            this.mHost = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VSNetLightQUICIPStrategyManager.instance().parseDNSIPList(this.mHost);
        }
    }

    VSNetLightQUICIPStrategyManager() {
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        this.mCurrentNetConnect = atomicBoolean;
        AtomicInteger atomicInteger = new AtomicInteger();
        this.mCurrentNetType = atomicInteger;
        this.mVSNetAsyncDNSRefreshTaskMap = new ConcurrentHashMap();
        this.mDNS = new LibraDns(new VSNetWorkStrategy());
        atomicBoolean.set(NetworkState.g().isNetworkConnected());
        atomicInteger.set(NetworkState.g().getNetworkType());
        NetworkState.g().addListener(new NetworkState.NetworkStateListener() { // from class: com.tencent.biz.richframework.network.quic.manager.a
            @Override // com.tencent.component.network.module.common.NetworkState.NetworkStateListener
            public final void onNetworkConnect(boolean z16) {
                VSNetLightQUICIPStrategyManager.this.lambda$new$0(z16);
            }
        });
        atomicBoolean.set(NetworkState.g().isNetworkConnected());
        RFWLifecycleHelper.getInstance().registerProcessChangeListener(new IProcessStateChangeCallback() { // from class: com.tencent.biz.richframework.network.quic.manager.VSNetLightQUICIPStrategyManager.1
            @Override // com.tencent.richframework.lifecycle.IProcessStateChangeCallback
            public void onProcessBackground() {
                com.tencent.richframework.lifecycle.a.a(this);
                VSNetLightQUICIPStrategyManager.this.handlerApplicationChange(true);
            }

            @Override // com.tencent.richframework.lifecycle.IProcessStateChangeCallback
            public void onProcessForeground() {
                com.tencent.richframework.lifecycle.a.b(this);
                VSNetLightQUICIPStrategyManager.this.handlerApplicationChange(false);
            }
        });
    }

    private void asyncResetAllHostDNSParse() {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.richframework.network.quic.manager.b
            @Override // java.lang.Runnable
            public final void run() {
                VSNetLightQUICIPStrategyManager.this.resetAllHostDNSParse();
            }
        });
    }

    private void checkedHostDNSAsync(String str) {
        if (!isDNSParseRefresh(str, 180000L)) {
            return;
        }
        VSNetAsyncDNSRefreshTask vSNetAsyncDNSRefreshTask = this.mVSNetAsyncDNSRefreshTaskMap.get(str);
        if (vSNetAsyncDNSRefreshTask != null) {
            RFWThreadManager.getInstance().remove(vSNetAsyncDNSRefreshTask);
        }
        VSNetAsyncDNSRefreshTask vSNetAsyncDNSRefreshTask2 = new VSNetAsyncDNSRefreshTask(str);
        this.mVSNetAsyncDNSRefreshTaskMap.put(str, vSNetAsyncDNSRefreshTask2);
        RFWThreadManager.getInstance().execOnSubThread(vSNetAsyncDNSRefreshTask2);
    }

    private void filterFailIpAddress(@NonNull String str) {
        List<String> list = this.mSortNormalIpMap.get(str);
        List<String> list2 = this.mReqFailIpMap.get(str);
        if (list == null) {
            QLog.w(TAG, 1, "[filterFailIpAddress] normal ip adress list should not null.");
            return;
        }
        if (list2 != null && !list2.isEmpty()) {
            Iterator<String> it = list2.iterator();
            while (it.hasNext()) {
                list.remove(it.next());
            }
            QLog.d(TAG, 1, "[filterFailIpAddress] host: " + str + " filter fail ip address, normal ip list size: " + list.size() + " req failed ip size: " + list2);
            return;
        }
        QLog.d(TAG, 4, "[filterFailIpAddress] current failed list is empty, end flow.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlerApplicationChange(boolean z16) {
        if (z16) {
            return;
        }
        asyncResetAllHostDNSParse();
    }

    private void handlerNetworkChange(boolean z16, int i3, boolean z17) {
        if (this.mCurrentNetConnect.get() == z16 && this.mCurrentNetType.get() == i3) {
            return;
        }
        QLog.d(TAG, 1, "[handlerNetworkChange] isConnected: " + z16 + " | currentConnect: " + this.mCurrentNetConnect.get() + " | networkType: " + i3 + " | currentNetType: " + this.mCurrentNetType.get() + " | dualStack: " + z17);
        asyncResetAllHostDNSParse();
    }

    private void initIpAndHostConfig(String str) {
        List<String> list;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            Pair<List<String>, List<String>> pair = d.a().get(str);
            if (pair == null) {
                list = null;
            } else {
                list = pair.first;
            }
            if (list != null && !list.isEmpty()) {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    QLog.d(TAG, 1, "[initIpAndHostConfig] config ip: " + it.next());
                }
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "[initIpAndHostConfig] ex: ", th5);
        }
    }

    public static VSNetLightQUICIPStrategyManager instance() {
        if (INSTANCE == null) {
            synchronized (VSNetLightQUICIPStrategyManager.class) {
                if (INSTANCE == null) {
                    INSTANCE = new VSNetLightQUICIPStrategyManager();
                }
            }
        }
        return INSTANCE;
    }

    private boolean isDNSParseRefresh(@NonNull String str, long j3) {
        Long l3 = this.mParseDNSTimeMap.get(str);
        if (l3 == null || System.currentTimeMillis() - l3.longValue() < j3) {
            return false;
        }
        return true;
    }

    private boolean isDualStack() {
        try {
            int netWorkStackType = ((IUploadApi) QRoute.api(IUploadApi.class)).getNetWorkStackType();
            if (netWorkStackType != 2 && netWorkStackType != 3) {
                return false;
            }
            return true;
        } catch (Throwable th5) {
            QLog.d(TAG, 1, "[isDualStack] ex:", th5);
            return false;
        }
    }

    private boolean isEnabledQuicIPV4Priority() {
        return o.E1();
    }

    private boolean isIpv4Address(String str) {
        try {
            return InetAddress.getByName(str) instanceof Inet4Address;
        } catch (Throwable unused) {
            return false;
        }
    }

    private boolean isIpv6Address(String str) {
        try {
            return InetAddress.getByName(str) instanceof Inet6Address;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(boolean z16) {
        handlerNetworkChange(z16, NetworkState.g().getNetworkType(), isDualStack());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> parseDNSIPList(@NonNull String str) {
        List<InetAddress> lookup;
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            lookup = this.mDNS.lookup(str);
            QLog.d(TAG, 1, "[parseDNSIPList] dns look up time: " + (System.currentTimeMillis() - currentTimeMillis));
        } catch (Throwable unused) {
        }
        if (lookup.isEmpty()) {
            QLog.e(TAG, 1, "[parseDNSIPList] ip list should not be null.");
            return copyOnWriteArrayList;
        }
        Iterator<InetAddress> it = lookup.iterator();
        while (it.hasNext()) {
            copyOnWriteArrayList.add(it.next().getHostAddress());
        }
        this.mParseDNSTimeMap.put(str, Long.valueOf(System.currentTimeMillis()));
        return copyOnWriteArrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetAllHostDNSParse() {
        try {
            if (this.mSortNormalIpMap.isEmpty() || !VSNetQUICExp.isEnabledQUICNetReq()) {
                return;
            }
            ArrayList arrayList = new ArrayList(this.mSortNormalIpMap.keySet());
            this.mSortNormalIpMap.clear();
            this.mReqFailIpMap.clear();
            this.mHostIPConfigMap.clear();
            this.mParseDNSTimeMap.clear();
            QLog.d(TAG, 1, "[resetAllHostDNSParse] history host size: " + arrayList.size());
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                updateInetAddressList((String) it.next(), true);
            }
        } catch (Throwable unused) {
            QLog.e(TAG, 1, "[resetAllHostParse]");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void retryPingRequest() {
        try {
            if (!o.N1()) {
                return;
            }
            new VSNetLightQUICPingRequest().startRequest();
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "[retryPingRequest] ex: ", th5);
        }
    }

    private void sortIpAddressOrder(String str, boolean z16) {
        if (!isDualStack()) {
            return;
        }
        try {
            List<String> list = this.mSortNormalIpMap.get(str);
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (String str2 : list) {
                    if (isIpv4Address(str2)) {
                        arrayList.add(str2);
                    } else if (isIpv6Address(str2)) {
                        arrayList2.add(str2);
                    }
                }
                list.clear();
                if (z16) {
                    list.addAll(arrayList);
                    list.addAll(arrayList2);
                    return;
                } else {
                    list.addAll(arrayList2);
                    list.addAll(arrayList);
                    return;
                }
            }
            QLog.w(TAG, 1, "[sortIpAddressOrder] normal ip address list should not be null.");
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "[sortIpAddressOrder] error: ", th5);
        }
    }

    private void updateConfigIpAddress(@NonNull String str) {
        List<String> list;
        initIpAndHostConfig(str);
        Pair<List<String>, List<String>> pair = this.mHostIPConfigMap.get(str);
        if (pair == null) {
            list = null;
        } else {
            list = pair.first;
        }
        if (list != null && !list.isEmpty()) {
            List<String> list2 = this.mSortNormalIpMap.get(str);
            if (list2 == null) {
                list2 = new CopyOnWriteArrayList<>();
                this.mSortNormalIpMap.put(str, list2);
            }
            QLog.d(TAG, 1, "[updateConfigIpAddress]  host: " + str + " | config ip list size: " + list.size() + " | ip list size: " + list2.size());
            for (String str2 : list) {
                if (!list2.contains(str2)) {
                    QLog.d(TAG, 1, "[updateConfigIpAddress] config ip: " + str2);
                    list2.add(str2);
                }
            }
        }
    }

    private void updateHostInetAddress(@NonNull String str, boolean z16) {
        List<String> parseDNSIPList;
        List<String> list = this.mSortNormalIpMap.get(str);
        if (list == null) {
            list = new CopyOnWriteArrayList<>();
            this.mSortNormalIpMap.put(str, list);
        }
        if (!list.isEmpty() && !isDNSParseRefresh(str, 3600000L) && !z16) {
            parseDNSIPList = null;
        } else {
            parseDNSIPList = parseDNSIPList(str);
        }
        if (parseDNSIPList == null) {
            return;
        }
        QLog.d(TAG, 1, "[updateHostInetAddress] host: " + str + " | ip length: " + parseDNSIPList.size());
        for (String str2 : parseDNSIPList) {
            if (!list.contains(str2)) {
                QLog.d(TAG, 1, "[updateHostInetAddress] normal ip: " + str2);
                list.add(str2);
            }
        }
    }

    public void asyncRetryPingReq() {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.richframework.network.quic.manager.c
            @Override // java.lang.Runnable
            public final void run() {
                VSNetLightQUICIPStrategyManager.this.retryPingRequest();
            }
        });
    }

    public String obtainRequestIp(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.w(TAG, 1, "[obtainRequestIp] host should not be null.");
            return null;
        }
        List<String> list = this.mSortNormalIpMap.get(str);
        if (list == null || list.size() == 0) {
            return null;
        }
        return list.get(0);
    }

    public void recordFailedIpToMap(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            QLog.w(TAG, 1, "[recordFailedIpToMap] current host should not be null.");
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            QLog.w(TAG, 1, "[recordFailedIpToMap] current ip should not be null.");
            return;
        }
        QLog.d(TAG, 1, "[recordFailedIpToMap] host: " + str + " | ip: " + str2 + " | scene: " + str3);
        List<String> list = this.mReqFailIpMap.get(str);
        if (list == null) {
            list = new CopyOnWriteArrayList<>();
        }
        if (!list.contains(str2)) {
            list.add(str2);
        }
        this.mReqFailIpMap.put(str, list);
    }

    public void updateInetAddressList(String str, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 1, "[updateInetAddressList] current host should not be null.");
            return;
        }
        try {
            updateHostInetAddress(str, z16);
            checkedHostDNSAsync(str);
            updateConfigIpAddress(str);
            filterFailIpAddress(str);
            sortIpAddressOrder(str, isEnabledQuicIPV4Priority());
        } catch (Throwable th5) {
            QLog.d(TAG, 1, "[updateInetAddressList] ex: ", th5);
        }
    }

    public void recordFailedIpToMap(String str, Map<String, VSNetQUICEvent> map, String str2) {
        VSNetQUICEvent vSNetQUICEvent;
        if (map == null || map.isEmpty() || (vSNetQUICEvent = map.get(VSNetQUICEvent.EVENT_ID_DNS_SUCCESS)) == null) {
            return;
        }
        recordFailedIpToMap(str, vSNetQUICEvent.getDNSIP(), str2);
    }
}
