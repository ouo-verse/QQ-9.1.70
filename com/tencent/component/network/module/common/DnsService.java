package com.tencent.component.network.module.common;

import android.text.TextUtils;
import com.tencent.component.network.NetworkManager;
import com.tencent.component.network.downloader.common.Utils;
import com.tencent.component.network.module.base.Config;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.module.common.dns.DnsMain;
import com.tencent.component.network.utils.http.pool.CustomDnsResolve;
import com.tencent.component.network.utils.thread.ThreadPool;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes5.dex */
public class DnsService {
    private static final int CACHE_TIME = 3600000;
    private static final int SLEEP_INTERVAL = 20;
    private static final String TAG = "DnsService";
    private static final String THREADPOOL_NAME_COMMON = "resolver_threadpool_name_common";
    private static final String THREADPOOL_NAME_INTERNAL = "resolver_threadpool_name_internal";
    private static final int THREADPOOL_SIZE_COMMON = 2;
    private static final int THREADPOOL_SIZE_INTERANL = 4;
    private static final int TIME_OUT = 20000;
    private static final int TRY_TIMES = 1;
    private static DnsService sIntance;
    private Executor mExecutor;
    private List<Pattern> mFilter;
    private static final byte[] INSTANCE_LOCK = new byte[0];
    private static final byte[] DATA_LOCK = new byte[0];
    private static final byte[] TASKLIST_LOCK = new byte[0];
    private static final Pattern ipReg = Pattern.compile("((\\d{1,3}\\.){3}\\d{1,3}|(\\w{1,4}:){5}\\w{1,4})", 2);
    private final HashMap<String, ThreadPool> mThreadPoolMap = new HashMap<>();
    private String mKey = "none";
    private List<String> waitingList = Collections.synchronizedList(new ArrayList());
    private final ConcurrentHashMap<String, IpRecord> mDomainMap = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, InetAddressRecord> mDomainV4Map = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, InetAddressRecord> mDomainV6Map = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, InetAddressRecord> mDomainV4V6Map = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Boolean> mDomainPreferV4Map = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, ConcurrentHashMap<Long, Integer>> mTryTimes = new ConcurrentHashMap<>();
    private List<ResolverDomainTask> mActiveTaskList = Collections.synchronizedList(new ArrayList());

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class InetAddressRecord {
        public List<InetAddress> list = new ArrayList();
        public long createTime = System.currentTimeMillis();

        public InetAddressRecord() {
        }

        public InetAddressRecord add(InetAddress inetAddress) {
            if (inetAddress == null) {
                return this;
            }
            this.list.add(inetAddress);
            return this;
        }

        public boolean isValid() {
            List<InetAddress> list;
            long currentTimeMillis = System.currentTimeMillis() - this.createTime;
            if (currentTimeMillis >= 0 && currentTimeMillis <= 3600000 && (list = this.list) != null && !list.isEmpty()) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class IpRecord {
        public long createTime;

        /* renamed from: ip, reason: collision with root package name */
        public String f99900ip;

        public IpRecord(String str, long j3) {
            this.f99900ip = str;
            this.createTime = j3;
        }

        public boolean isValid() {
            long currentTimeMillis = System.currentTimeMillis() - this.createTime;
            if (currentTimeMillis >= 0 && currentTimeMillis <= 3600000 && !TextUtils.isEmpty(this.f99900ip)) {
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class ResolverDomainTask implements ThreadPool.Job<Object> {
        private String mApn;
        private String mDomain;
        private volatile boolean mIsExpired = false;

        public ResolverDomainTask(String str, String str2) {
            this.mDomain = str;
            this.mApn = str2;
        }

        /* JADX WARN: Removed duplicated region for block: B:131:0x0241  */
        /* JADX WARN: Removed duplicated region for block: B:134:0x02aa  */
        /* JADX WARN: Removed duplicated region for block: B:171:0x04b3  */
        /* JADX WARN: Removed duplicated region for block: B:174:0x051c  */
        /* JADX WARN: Removed duplicated region for block: B:209:0x037a  */
        /* JADX WARN: Removed duplicated region for block: B:212:0x03e3  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x0528 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:90:0x05f3  */
        /* JADX WARN: Removed duplicated region for block: B:93:0x065c  */
        /* JADX WARN: Removed duplicated region for block: B:95:0x0664  */
        @Override // com.tencent.component.network.utils.thread.ThreadPool.Job
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Object run(ThreadPool.JobContext jobContext) {
            InetAddress[] inetAddressArr;
            String apnValue;
            InetAddress[] inetAddressArr2;
            String apnValue2;
            InetAddress[] inetAddressArr3;
            String apnValue3;
            InetAddress[] inetAddressArr4;
            String apnValue4;
            InetAddress[] inetAddressArr5;
            synchronized (DnsService.TASKLIST_LOCK) {
                DnsService.this.mActiveTaskList.add(this);
            }
            String apnValue5 = NetworkManager.getApnValue();
            if ("wifi".equals(apnValue5) && !TextUtils.isEmpty(NetworkManager.getBSSID())) {
                apnValue5 = NetworkManager.getBSSID();
            }
            long currentTimeMillis = System.currentTimeMillis();
            long j3 = 5000;
            try {
                try {
                    if (!TextUtils.isEmpty(this.mDomain)) {
                        inetAddressArr5 = InetAddress.getAllByName(this.mDomain);
                    } else {
                        inetAddressArr5 = null;
                    }
                    if (QDLog.isInfoEnable()) {
                        QDLog.i(DnsService.TAG, "Inet Address Analyze result by sys api,domain:" + this.mDomain + " ip:" + DnsService.this.getIpListStr(inetAddressArr5));
                    }
                    if (!DnsService.this.hasValidIpAddress(inetAddressArr5) && DnsService.this.enableCustomDns()) {
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        try {
                            String str = this.mDomain;
                            long j16 = 20000 - currentTimeMillis2;
                            if (j16 >= 5000) {
                                j3 = j16;
                            }
                            inetAddressArr5 = DnsMain.getBetterHostByName(str, j3);
                            if (DnsService.this.hasValidIpAddress(inetAddressArr5) && QDLog.isInfoEnable()) {
                                QDLog.i(DnsService.TAG, "Inet Address Analyze result from WnsBaseLib,domain:" + this.mDomain + " ip:" + DnsService.this.getIpListStr(inetAddressArr5));
                            }
                        } catch (Throwable th5) {
                            CustomDnsResolve.setIPDirectEnable(this.mDomain, true);
                            QDLog.e(DnsService.TAG, "dns resolve fail, choose ip direct ", th5);
                        }
                    }
                    String apnValue6 = NetworkManager.getApnValue();
                    if ("wifi".equals(apnValue6) && !TextUtils.isEmpty(NetworkManager.getBSSID())) {
                        apnValue6 = NetworkManager.getBSSID();
                    }
                    if (QDLog.isInfoEnable()) {
                        QDLog.i(DnsService.TAG, "InetAddress.getByName domain:" + this.mDomain + " ip:" + DnsService.this.getIpListStr(inetAddressArr5) + " time:" + (System.currentTimeMillis() - currentTimeMillis) + " origApn:" + apnValue5 + " currApn:" + apnValue6 + " threadId:" + Thread.currentThread().getId() + " IsExpired:" + this.mIsExpired);
                    }
                } catch (Error e16) {
                    QDLog.e(DnsService.TAG, "Inet Address Analyze fail error : ", e16);
                    if (QDLog.isInfoEnable()) {
                        QDLog.i(DnsService.TAG, "Inet Address Analyze result by sys api,domain:" + this.mDomain + " ip:" + DnsService.this.getIpListStr(null));
                    }
                    if (!DnsService.this.hasValidIpAddress(null) && DnsService.this.enableCustomDns()) {
                        long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                        try {
                            String str2 = this.mDomain;
                            long j17 = 20000 - currentTimeMillis3;
                            if (j17 >= 5000) {
                                j3 = j17;
                            }
                            inetAddressArr3 = DnsMain.getBetterHostByName(str2, j3);
                        } catch (Throwable th6) {
                            th = th6;
                            inetAddressArr3 = null;
                        }
                        try {
                            if (DnsService.this.hasValidIpAddress(inetAddressArr3) && QDLog.isInfoEnable()) {
                                QDLog.i(DnsService.TAG, "Inet Address Analyze result from WnsBaseLib,domain:" + this.mDomain + " ip:" + DnsService.this.getIpListStr(inetAddressArr3));
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            CustomDnsResolve.setIPDirectEnable(this.mDomain, true);
                            QDLog.e(DnsService.TAG, "dns resolve fail, choose ip direct ", th);
                            apnValue3 = NetworkManager.getApnValue();
                            if ("wifi".equals(apnValue3) && !TextUtils.isEmpty(NetworkManager.getBSSID())) {
                                apnValue3 = NetworkManager.getBSSID();
                            }
                            if (QDLog.isInfoEnable()) {
                                QDLog.i(DnsService.TAG, "InetAddress.getByName domain:" + this.mDomain + " ip:" + DnsService.this.getIpListStr(inetAddressArr3) + " time:" + (System.currentTimeMillis() - currentTimeMillis) + " origApn:" + apnValue5 + " currApn:" + apnValue3 + " threadId:" + Thread.currentThread().getId() + " IsExpired:" + this.mIsExpired);
                            }
                            if (!this.mIsExpired) {
                                DnsService.this.setResolveResult(this.mDomain, inetAddressArr3);
                                synchronized (DnsService.TASKLIST_LOCK) {
                                }
                            }
                            DnsService.this.setResolveResult(this.mDomain, null);
                            synchronized (DnsService.TASKLIST_LOCK) {
                            }
                        }
                    } else {
                        inetAddressArr3 = null;
                    }
                    apnValue3 = NetworkManager.getApnValue();
                    if ("wifi".equals(apnValue3)) {
                        apnValue3 = NetworkManager.getBSSID();
                    }
                    if (QDLog.isInfoEnable()) {
                    }
                    if (!this.mIsExpired) {
                    }
                } catch (UnknownHostException e17) {
                    QDLog.e(DnsService.TAG, "Inet Address Analyze fail exception : ", e17);
                    if (QDLog.isInfoEnable()) {
                        QDLog.i(DnsService.TAG, "Inet Address Analyze result by sys api,domain:" + this.mDomain + " ip:" + DnsService.this.getIpListStr(null));
                    }
                    if (!DnsService.this.hasValidIpAddress(null) && DnsService.this.enableCustomDns()) {
                        long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis;
                        try {
                            String str3 = this.mDomain;
                            long j18 = 20000 - currentTimeMillis4;
                            if (j18 >= 5000) {
                                j3 = j18;
                            }
                            inetAddressArr2 = DnsMain.getBetterHostByName(str3, j3);
                            try {
                                if (DnsService.this.hasValidIpAddress(inetAddressArr2) && QDLog.isInfoEnable()) {
                                    QDLog.i(DnsService.TAG, "Inet Address Analyze result from WnsBaseLib,domain:" + this.mDomain + " ip:" + DnsService.this.getIpListStr(inetAddressArr2));
                                }
                            } catch (Throwable th8) {
                                th = th8;
                                CustomDnsResolve.setIPDirectEnable(this.mDomain, true);
                                QDLog.e(DnsService.TAG, "dns resolve fail, choose ip direct ", th);
                                apnValue2 = NetworkManager.getApnValue();
                                if ("wifi".equals(apnValue2) && !TextUtils.isEmpty(NetworkManager.getBSSID())) {
                                    apnValue2 = NetworkManager.getBSSID();
                                }
                                if (QDLog.isInfoEnable()) {
                                    QDLog.i(DnsService.TAG, "InetAddress.getByName domain:" + this.mDomain + " ip:" + DnsService.this.getIpListStr(inetAddressArr2) + " time:" + (System.currentTimeMillis() - currentTimeMillis) + " origApn:" + apnValue5 + " currApn:" + apnValue2 + " threadId:" + Thread.currentThread().getId() + " IsExpired:" + this.mIsExpired);
                                }
                                if (!this.mIsExpired) {
                                    DnsService.this.setResolveResult(this.mDomain, inetAddressArr2);
                                    synchronized (DnsService.TASKLIST_LOCK) {
                                    }
                                }
                                DnsService.this.setResolveResult(this.mDomain, null);
                                synchronized (DnsService.TASKLIST_LOCK) {
                                }
                            }
                        } catch (Throwable th9) {
                            th = th9;
                            inetAddressArr2 = null;
                        }
                    } else {
                        inetAddressArr2 = null;
                    }
                    apnValue2 = NetworkManager.getApnValue();
                    if ("wifi".equals(apnValue2)) {
                        apnValue2 = NetworkManager.getBSSID();
                    }
                    if (QDLog.isInfoEnable()) {
                    }
                    if (!this.mIsExpired) {
                    }
                } catch (Exception e18) {
                    QDLog.e(DnsService.TAG, "Inet Address Analyze fail exception : ", e18);
                    if (QDLog.isInfoEnable()) {
                        QDLog.i(DnsService.TAG, "Inet Address Analyze result by sys api,domain:" + this.mDomain + " ip:" + DnsService.this.getIpListStr(null));
                    }
                    if (!DnsService.this.hasValidIpAddress(null) && DnsService.this.enableCustomDns()) {
                        long currentTimeMillis5 = System.currentTimeMillis() - currentTimeMillis;
                        try {
                            String str4 = this.mDomain;
                            long j19 = 20000 - currentTimeMillis5;
                            if (j19 >= 5000) {
                                j3 = j19;
                            }
                            inetAddressArr = DnsMain.getBetterHostByName(str4, j3);
                        } catch (Throwable th10) {
                            th = th10;
                            inetAddressArr = null;
                        }
                        try {
                            if (DnsService.this.hasValidIpAddress(inetAddressArr) && QDLog.isInfoEnable()) {
                                QDLog.i(DnsService.TAG, "Inet Address Analyze result from WnsBaseLib,domain:" + this.mDomain + " ip:" + DnsService.this.getIpListStr(inetAddressArr));
                            }
                        } catch (Throwable th11) {
                            th = th11;
                            CustomDnsResolve.setIPDirectEnable(this.mDomain, true);
                            QDLog.e(DnsService.TAG, "dns resolve fail, choose ip direct ", th);
                            apnValue = NetworkManager.getApnValue();
                            if ("wifi".equals(apnValue) && !TextUtils.isEmpty(NetworkManager.getBSSID())) {
                                apnValue = NetworkManager.getBSSID();
                            }
                            if (QDLog.isInfoEnable()) {
                                QDLog.i(DnsService.TAG, "InetAddress.getByName domain:" + this.mDomain + " ip:" + DnsService.this.getIpListStr(inetAddressArr) + " time:" + (System.currentTimeMillis() - currentTimeMillis) + " origApn:" + apnValue5 + " currApn:" + apnValue + " threadId:" + Thread.currentThread().getId() + " IsExpired:" + this.mIsExpired);
                            }
                            if (!this.mIsExpired) {
                                DnsService.this.setResolveResult(this.mDomain, inetAddressArr);
                                synchronized (DnsService.TASKLIST_LOCK) {
                                }
                            }
                            DnsService.this.setResolveResult(this.mDomain, null);
                            synchronized (DnsService.TASKLIST_LOCK) {
                            }
                        }
                    } else {
                        inetAddressArr = null;
                    }
                    apnValue = NetworkManager.getApnValue();
                    if ("wifi".equals(apnValue)) {
                        apnValue = NetworkManager.getBSSID();
                    }
                    if (QDLog.isInfoEnable()) {
                    }
                    if (!this.mIsExpired) {
                    }
                }
                if (!this.mIsExpired) {
                    DnsService.this.setResolveResult(this.mDomain, inetAddressArr5);
                    synchronized (DnsService.TASKLIST_LOCK) {
                        DnsService.this.mActiveTaskList.remove(this);
                    }
                    return null;
                }
                DnsService.this.setResolveResult(this.mDomain, null);
                synchronized (DnsService.TASKLIST_LOCK) {
                }
            } catch (Throwable th12) {
                if (QDLog.isInfoEnable()) {
                    QDLog.i(DnsService.TAG, "Inet Address Analyze result by sys api,domain:" + this.mDomain + " ip:" + DnsService.this.getIpListStr(null));
                }
                if (!DnsService.this.hasValidIpAddress(null) && DnsService.this.enableCustomDns()) {
                    long currentTimeMillis6 = System.currentTimeMillis() - currentTimeMillis;
                    try {
                        String str5 = this.mDomain;
                        long j26 = 20000 - currentTimeMillis6;
                        if (j26 >= 5000) {
                            j3 = j26;
                        }
                        inetAddressArr4 = DnsMain.getBetterHostByName(str5, j3);
                        try {
                            if (DnsService.this.hasValidIpAddress(inetAddressArr4) && QDLog.isInfoEnable()) {
                                QDLog.i(DnsService.TAG, "Inet Address Analyze result from WnsBaseLib,domain:" + this.mDomain + " ip:" + DnsService.this.getIpListStr(inetAddressArr4));
                            }
                        } catch (Throwable th13) {
                            th = th13;
                            CustomDnsResolve.setIPDirectEnable(this.mDomain, true);
                            QDLog.e(DnsService.TAG, "dns resolve fail, choose ip direct ", th);
                            apnValue4 = NetworkManager.getApnValue();
                            if ("wifi".equals(apnValue4)) {
                                apnValue4 = NetworkManager.getBSSID();
                            }
                            if (QDLog.isInfoEnable()) {
                            }
                            if (this.mIsExpired) {
                            }
                        }
                    } catch (Throwable th14) {
                        th = th14;
                        inetAddressArr4 = null;
                    }
                } else {
                    inetAddressArr4 = null;
                }
                apnValue4 = NetworkManager.getApnValue();
                if ("wifi".equals(apnValue4) && !TextUtils.isEmpty(NetworkManager.getBSSID())) {
                    apnValue4 = NetworkManager.getBSSID();
                }
                if (QDLog.isInfoEnable()) {
                    QDLog.i(DnsService.TAG, "InetAddress.getByName domain:" + this.mDomain + " ip:" + DnsService.this.getIpListStr(inetAddressArr4) + " time:" + (System.currentTimeMillis() - currentTimeMillis) + " origApn:" + apnValue5 + " currApn:" + apnValue4 + " threadId:" + Thread.currentThread().getId() + " IsExpired:" + this.mIsExpired);
                }
                if (this.mIsExpired) {
                    DnsService.this.setResolveResult(this.mDomain, inetAddressArr4);
                    throw th12;
                }
                DnsService.this.setResolveResult(this.mDomain, null);
                throw th12;
            }
        }

        public void setIsExpired(boolean z16) {
            this.mIsExpired = z16;
        }
    }

    DnsService() {
        initFilter();
    }

    private void addCurrTryTimes(String str) {
        int i3;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (DATA_LOCK) {
            if (this.mTryTimes.get(str) != null) {
                ConcurrentHashMap<Long, Integer> concurrentHashMap = this.mTryTimes.get(str);
                for (Map.Entry<Long, Integer> entry : concurrentHashMap.entrySet()) {
                    Long key = entry.getKey();
                    Integer value = entry.getValue();
                    if (value != null) {
                        i3 = value.intValue();
                    } else {
                        i3 = 0;
                    }
                    int i16 = i3 + 1;
                    concurrentHashMap.put(key, Integer.valueOf(i16));
                    if (QDLog.isInfoEnable()) {
                        QDLog.i(TAG, "DNSService domain:" + str + " key:" + key + " times:" + i16);
                    }
                }
            }
        }
    }

    private void clearCurrTryTimes(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (DATA_LOCK) {
            if (this.mTryTimes.get(str) != null) {
                ConcurrentHashMap<Long, Integer> concurrentHashMap = this.mTryTimes.get(str);
                Long valueOf = Long.valueOf(Thread.currentThread().getId());
                if (concurrentHashMap.get(valueOf) != null) {
                    concurrentHashMap.remove(valueOf);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean enableCustomDns() {
        return Config.enableDns114();
    }

    private boolean ensureNotRepeat(String str) {
        return !isQuerying(str);
    }

    private int getCurrTryTimes(String str) {
        int i3 = 0;
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        synchronized (DATA_LOCK) {
            if (this.mTryTimes.get(str) != null) {
                ConcurrentHashMap<Long, Integer> concurrentHashMap = this.mTryTimes.get(str);
                Long valueOf = Long.valueOf(Thread.currentThread().getId());
                if (concurrentHashMap.get(valueOf) != null) {
                    Integer num = concurrentHashMap.get(valueOf);
                    if (num != null) {
                        i3 = num.intValue();
                    } else {
                        concurrentHashMap.put(valueOf, 0);
                    }
                } else {
                    concurrentHashMap.put(valueOf, 0);
                }
            } else {
                ConcurrentHashMap<Long, Integer> concurrentHashMap2 = new ConcurrentHashMap<>();
                concurrentHashMap2.put(Long.valueOf(Thread.currentThread().getId()), 0);
                this.mTryTimes.put(str, concurrentHashMap2);
            }
        }
        return i3;
    }

    private ThreadPool getDomainResolverThreadPool(String str) {
        int i3;
        String threadPoolName = getThreadPoolName(str);
        ThreadPool threadPool = this.mThreadPoolMap.get(threadPoolName);
        if (threadPool == null) {
            if (THREADPOOL_NAME_INTERNAL.equals(threadPoolName)) {
                i3 = 4;
            } else {
                i3 = 2;
            }
            if (this.mExecutor != null) {
                threadPool = new ThreadPool(this.mExecutor);
            } else {
                threadPool = new ThreadPool(threadPoolName, i3, i3, new LinkedBlockingQueue());
            }
            this.mThreadPoolMap.put(threadPoolName, threadPool);
        }
        return threadPool;
    }

    private InetAddress[] getIPAddressFromCache(String str, boolean z16) {
        boolean z17;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList<InetAddress> arrayList = new ArrayList<>();
        if (z16) {
            if (this.mDomainPreferV4Map.containsKey(str)) {
                z17 = this.mDomainPreferV4Map.get(str).booleanValue();
            } else {
                z17 = false;
            }
            if (z17) {
                wrapInetAddressRecord(str, arrayList, this.mDomainV4Map);
                wrapInetAddressRecord(str, arrayList, this.mDomainV6Map);
            } else {
                wrapInetAddressRecord(str, arrayList, this.mDomainV4V6Map);
            }
        } else {
            wrapInetAddressRecord(str, arrayList, this.mDomainV4Map);
        }
        if (arrayList.size() <= 0) {
            return null;
        }
        InetAddress[] inetAddressArr = new InetAddress[arrayList.size()];
        arrayList.toArray(inetAddressArr);
        return inetAddressArr;
    }

    private String getIPFromCache(String str) {
        IpRecord ipRecord;
        if (TextUtils.isEmpty(str) || (ipRecord = this.mDomainMap.get(str)) == null) {
            return null;
        }
        if (ipRecord.isValid()) {
            return ipRecord.f99900ip;
        }
        this.mDomainMap.remove(str);
        return null;
    }

    public static synchronized DnsService getInstance() {
        DnsService dnsService;
        synchronized (DnsService.class) {
            if (sIntance == null) {
                synchronized (INSTANCE_LOCK) {
                    if (sIntance == null) {
                        sIntance = new DnsService();
                    }
                }
            }
            dnsService = sIntance;
        }
        return dnsService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getIpListStr(InetAddress[] inetAddressArr) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[");
        if (inetAddressArr != null && inetAddressArr.length > 0) {
            for (InetAddress inetAddress : inetAddressArr) {
                if (inetAddress != null) {
                    sb5.append(inetAddress.getHostAddress());
                    sb5.append(";");
                }
            }
        }
        sb5.append("]");
        return sb5.toString();
    }

    private String getKey() {
        return NetworkManager.getApnValue();
    }

    private String getThreadPoolName(String str) {
        if (TextUtils.isEmpty(str)) {
            return THREADPOOL_NAME_COMMON;
        }
        Iterator<Pattern> it = this.mFilter.iterator();
        while (it.hasNext()) {
            if (Utils.match(it.next(), str)) {
                return THREADPOOL_NAME_INTERNAL;
            }
        }
        return THREADPOOL_NAME_COMMON;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasValidIpAddress(InetAddress[] inetAddressArr) {
        if (inetAddressArr != null && inetAddressArr.length != 0) {
            for (InetAddress inetAddress : inetAddressArr) {
                if (inetAddress != null && isIPValid(inetAddress.getHostAddress())) {
                    return true;
                }
            }
        }
        return false;
    }

    private void initFilter() {
        String[] strArr = {"a[0-9].qpic.cn", "m.qpic.cn", "t[0-9].qpic.cn", "qlogo[0-9].store.qq.com", "mmsns.qpic.cn", "ugc.qpic.cn", "b\\d+.photo.store.qq.com"};
        this.mFilter = new ArrayList();
        for (int i3 = 0; i3 < 7; i3++) {
            this.mFilter.add(Pattern.compile(strArr[i3], 2));
        }
    }

    private boolean isIPValid(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if ((Config.getConfig("PhotoSvrList", Config.SECONDARY_KEY_ENABLE_FILTER_IPV6_LOCAL_BACK_ADDR, 1L) == 1 && (TextUtils.equals(str, "::1") || TextUtils.equals(str, "0:0:0:0:0:0:0:1"))) || str.startsWith("192.168") || str.equals("127.0.0.1") || str.equals("0.0.0.0") || str.equals("255.255.255.255")) {
            return false;
        }
        return true;
    }

    private void parseInetAddressInner(String str, InetAddress[] inetAddressArr) {
        if (inetAddressArr == null) {
            return;
        }
        InetAddress inetAddress = null;
        for (InetAddress inetAddress2 : inetAddressArr) {
            if (inetAddress2 != null && isIPValid(inetAddress2.getHostAddress())) {
                if (inetAddress == null) {
                    inetAddress = inetAddress2;
                }
                if (inetAddress2 instanceof Inet4Address) {
                    recordInetAddress(str, inetAddress2, this.mDomainV4Map);
                    recordInetAddress(str, inetAddress2, this.mDomainV4V6Map);
                } else if (inetAddress2 instanceof Inet6Address) {
                    recordInetAddress(str, inetAddress2, this.mDomainV6Map);
                    recordInetAddress(str, inetAddress2, this.mDomainV4V6Map);
                }
            }
        }
        if (inetAddress != null) {
            this.mDomainMap.put(str, new IpRecord(inetAddress.getHostAddress(), System.currentTimeMillis()));
        }
    }

    private void recordInetAddress(String str, InetAddress inetAddress, ConcurrentHashMap<String, InetAddressRecord> concurrentHashMap) {
        InetAddressRecord inetAddressRecord;
        if (concurrentHashMap.containsKey(str)) {
            inetAddressRecord = concurrentHashMap.get(str);
        } else {
            inetAddressRecord = null;
        }
        if (inetAddressRecord == null) {
            inetAddressRecord = new InetAddressRecord();
        }
        inetAddressRecord.add(inetAddress);
        concurrentHashMap.put(str, inetAddressRecord);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResolveResult(String str, InetAddress[] inetAddressArr) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        parseInetAddressInner(str, inetAddressArr);
        this.waitingList.remove(str);
        addCurrTryTimes(str);
    }

    private void wrapInetAddressRecord(String str, ArrayList<InetAddress> arrayList, ConcurrentHashMap<String, InetAddressRecord> concurrentHashMap) {
        InetAddressRecord inetAddressRecord;
        if (concurrentHashMap != null && (inetAddressRecord = concurrentHashMap.get(str)) != null) {
            if (inetAddressRecord.isValid()) {
                arrayList.addAll(inetAddressRecord.list);
            } else {
                concurrentHashMap.remove(str);
            }
        }
    }

    public void addQuery(String str) {
        if (!TextUtils.isEmpty(str) && ensureNotRepeat(str)) {
            this.waitingList.add(str);
            ThreadPool domainResolverThreadPool = getDomainResolverThreadPool(str);
            if (QDLog.isInfoEnable()) {
                QDLog.i(TAG, "add query:" + str);
            }
            String apnValue = NetworkManager.getApnValue();
            if ("wifi".equals(apnValue) && !TextUtils.isEmpty(NetworkManager.getBSSID())) {
                apnValue = NetworkManager.getBSSID();
            }
            try {
                domainResolverThreadPool.submit(new ResolverDomainTask(str, apnValue));
            } catch (Throwable th5) {
                QDLog.e(TAG, "exception when add query to DNSService.", th5);
            }
        }
    }

    public String getDomainIP(String str) {
        String iPFromCache;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (ipReg.matcher(str).find()) {
            return str;
        }
        long currentTimeMillis = System.currentTimeMillis();
        String iPFromCache2 = getIPFromCache(str);
        if (TextUtils.isEmpty(iPFromCache2)) {
            long j3 = 0;
            while (true) {
                iPFromCache = getIPFromCache(str);
                if (!TextUtils.isEmpty(iPFromCache) || j3 > 20000 || getCurrTryTimes(str) >= 1) {
                    break;
                }
                try {
                    addQuery(str);
                    LockMethodProxy.sleep(20L);
                    j3 += 20;
                } catch (InterruptedException e16) {
                    QDLog.e(TAG, "getDomainIP InterruptedException", e16);
                }
            }
            iPFromCache2 = iPFromCache;
        }
        clearCurrTryTimes(str);
        QDLog.w(TAG, "getDomainIP domain:" + str + " ipStack :" + Config.getNetworkStackType() + " ip:" + iPFromCache2 + " time:" + (System.currentTimeMillis() - currentTimeMillis) + " threadId:" + Thread.currentThread().getId());
        return iPFromCache2;
    }

    public InetAddress[] getDomainIpAddress(String str) {
        InetAddress[] iPAddressFromCache;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (ipReg.matcher(str).find()) {
            try {
                return new InetAddress[]{InetAddress.getByName(str)};
            } catch (UnknownHostException e16) {
                QDLog.e(TAG, "getDomainIpAddress error,domain:" + str + ",exp:" + e16);
                return null;
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean isIpV6Stack = Config.isIpV6Stack();
        InetAddress[] iPAddressFromCache2 = getIPAddressFromCache(str, isIpV6Stack);
        if (iPAddressFromCache2 == null) {
            long j3 = 0;
            while (true) {
                iPAddressFromCache = getIPAddressFromCache(str, isIpV6Stack);
                if (iPAddressFromCache != null || j3 > 20000 || getCurrTryTimes(str) >= 1) {
                    break;
                }
                try {
                    addQuery(str);
                    LockMethodProxy.sleep(20L);
                    j3 += 20;
                } catch (InterruptedException e17) {
                    QDLog.e(TAG, "getDomainIpAddress InterruptedException", e17);
                }
            }
            iPAddressFromCache2 = iPAddressFromCache;
        }
        clearCurrTryTimes(str);
        QDLog.w(TAG, "getDomainIpAddress domain:" + str + " ipStack :" + Config.getNetworkStackType() + " adds :" + getIpListStr(iPAddressFromCache2) + " time:" + (System.currentTimeMillis() - currentTimeMillis) + " threadId:" + Thread.currentThread().getId());
        return iPAddressFromCache2;
    }

    public boolean isQuerying(String str) {
        return this.waitingList.contains(str);
    }

    public void reset() {
        String key = getKey();
        if (QDLog.isInfoEnable()) {
            QDLog.i(TAG, "DNSService reset. Key:" + this.mKey + " currKey:" + key);
        }
        if (key == null || !key.equalsIgnoreCase(this.mKey)) {
            synchronized (TASKLIST_LOCK) {
                Iterator<ResolverDomainTask> it = this.mActiveTaskList.iterator();
                while (it.hasNext()) {
                    it.next().setIsExpired(true);
                }
            }
        }
        this.mKey = key;
        this.mDomainMap.clear();
        this.mDomainV4Map.clear();
        this.mDomainV6Map.clear();
        this.mDomainV4V6Map.clear();
        this.mDomainPreferV4Map.clear();
        addQuery("m.qpic.cn");
    }

    public void setThreadPoolExecutor(Executor executor) {
        if (this.mExecutor != null) {
            this.mExecutor = executor;
        }
    }

    public void updatePreferV4(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mDomainPreferV4Map.put(str, Boolean.TRUE);
        QDLog.i(TAG, "updatePreferV4 ipStack:" + Config.getNetworkStackType() + ",domain:" + str);
    }
}
