package com.tencent.component.network.downloader.strategy;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.Global;
import com.tencent.component.network.NetworkManager;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.common.IPInfo;
import com.tencent.component.network.downloader.common.Utils;
import com.tencent.component.network.downloader.impl.DownloadTask;
import com.tencent.component.network.module.base.Config;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.module.statistics.ProxyStatistics;
import com.tencent.component.network.utils.Base64;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import cooperation.qzone.util.WiFiDash;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.java_websocket.WebSocketImpl;

/* compiled from: P */
/* loaded from: classes5.dex */
public class DownloadGlobalStrategy {
    private static final String TAG = "DownloadGlobalStrategy";
    private static Context mContext;
    private final boolean mEnableCacheWifiBSSID;
    private PortConfigStrategy mPortConfig;
    private SharedPreferences mSetting;
    public static final StrategyInfo Strategy_DomainDirect = new StrategyInfo(1, false, false, false);
    public static final StrategyInfo Strategy_DomainProxy_SYS = new StrategyInfo(2, true, false, false);
    public static final StrategyInfo Strategy_DomainProxy_CON = new StrategyInfo(3, true, true, false);
    public static final StrategyInfo Strategy_BACKUPIP = new StrategyInfo(4, false, false, true);
    public static final StrategyInfo Strategy_DOMAIN_FORCE = new StrategyInfo(5, false, false, false, true);
    private static ArrayList<StrategyInfo> StrategyLib_WAP = new ArrayList<>();
    private static ArrayList<StrategyInfo> StrategyLib_WAP1 = new ArrayList<>();
    private static ArrayList<StrategyInfo> StrategyLib_NWAP = new ArrayList<>();
    private static volatile DownloadGlobalStrategy mInstance = null;
    private static final byte[] INSTANCE_LOCK = new byte[0];
    private ConcurrentHashMap<String, StrategyInfo> mapBestDomainStrategyCache = new ConcurrentHashMap<>();
    private int mHttpsFailCount = 0;
    private boolean httpsSupport = true;
    private long httpsSupportTimestamp = 0;
    private String mCacheWifiBSSID = null;
    private volatile int mCacheModifyCount = 0;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class StrategyInfo implements Parcelable {
        public static final Parcelable.Creator<StrategyInfo> CREATOR = new Parcelable.Creator<StrategyInfo>() { // from class: com.tencent.component.network.downloader.strategy.DownloadGlobalStrategy.StrategyInfo.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public StrategyInfo createFromParcel(Parcel parcel) {
                return new StrategyInfo(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public StrategyInfo[] newArray(int i3) {
                return new StrategyInfo[i3];
            }
        };
        public boolean allowProxy;
        public boolean enableBackupIP;
        public boolean forceDomain;

        /* renamed from: id, reason: collision with root package name */
        public int f99899id;
        private IPInfo mIpInfo;
        private long mIpTimestamp;
        public DownloadResult result;
        public boolean useConfigApn;

        public StrategyInfo(boolean z16, boolean z17, boolean z18) {
            this(0, z16, z17, z18, false);
        }

        public static int compare(StrategyInfo strategyInfo, StrategyInfo strategyInfo2) {
            float f16;
            DownloadResult downloadResult;
            DownloadResult downloadResult2;
            float f17;
            float f18 = 0.0f;
            if (strategyInfo != null && (downloadResult2 = strategyInfo.result) != null && downloadResult2.getProcess().duration > 0) {
                if (strategyInfo.result.getContent().size > 0) {
                    f17 = (float) strategyInfo.result.getContent().size;
                } else {
                    f17 = 0.0f;
                }
                f16 = f17 / ((float) strategyInfo.result.getProcess().duration);
            } else {
                f16 = 0.0f;
            }
            if (strategyInfo2 != null && (downloadResult = strategyInfo2.result) != null && downloadResult.getProcess().duration > 0) {
                if (strategyInfo2.result.getContent().size > 0) {
                    f18 = (float) strategyInfo2.result.getContent().size;
                }
                f18 /= (float) strategyInfo2.result.getProcess().duration;
            }
            QDLog.w(DownloadGlobalStrategy.TAG, "speed1:" + f16 + " speed2:" + f18);
            return (int) (f16 - f18);
        }

        private void filter() {
            if (this.enableBackupIP) {
                this.allowProxy = false;
            }
            if (!this.allowProxy) {
                this.useConfigApn = false;
            }
        }

        private void initID() {
            StrategyInfo strategyInfo = DownloadGlobalStrategy.Strategy_DomainDirect;
            if (equalValue(strategyInfo)) {
                this.f99899id = strategyInfo.f99899id;
                return;
            }
            StrategyInfo strategyInfo2 = DownloadGlobalStrategy.Strategy_DomainProxy_CON;
            if (equalValue(strategyInfo2)) {
                this.f99899id = strategyInfo2.f99899id;
                return;
            }
            StrategyInfo strategyInfo3 = DownloadGlobalStrategy.Strategy_DomainProxy_SYS;
            if (equalValue(strategyInfo3)) {
                this.f99899id = strategyInfo3.f99899id;
                return;
            }
            StrategyInfo strategyInfo4 = DownloadGlobalStrategy.Strategy_BACKUPIP;
            if (equalValue(strategyInfo4)) {
                this.f99899id = strategyInfo4.f99899id;
                return;
            }
            StrategyInfo strategyInfo5 = DownloadGlobalStrategy.Strategy_DOMAIN_FORCE;
            if (equalValue(strategyInfo5)) {
                this.f99899id = strategyInfo5.f99899id;
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equalValue(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !(obj instanceof StrategyInfo)) {
                return false;
            }
            StrategyInfo strategyInfo = (StrategyInfo) obj;
            if (strategyInfo.forceDomain == this.forceDomain && strategyInfo.allowProxy == this.allowProxy && strategyInfo.enableBackupIP == this.enableBackupIP && strategyInfo.useConfigApn == this.useConfigApn && equalWith(strategyInfo.mIpInfo, this.mIpInfo)) {
                return true;
            }
            return false;
        }

        public boolean equalWith(IPInfo iPInfo, IPInfo iPInfo2) {
            if (iPInfo != null) {
                return iPInfo.equals(iPInfo2);
            }
            if (iPInfo2 == null) {
                return true;
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !(obj instanceof StrategyInfo)) {
                return false;
            }
            StrategyInfo strategyInfo = (StrategyInfo) obj;
            if (strategyInfo.f99899id == this.f99899id && strategyInfo.allowProxy == this.allowProxy && strategyInfo.enableBackupIP == this.enableBackupIP && strategyInfo.useConfigApn == this.useConfigApn && equalWith(strategyInfo.mIpInfo, this.mIpInfo)) {
                return true;
            }
            return false;
        }

        public IPInfo getIPInfo() {
            return this.mIpInfo;
        }

        public long getIPValidTime() {
            if (this.f99899id == DownloadGlobalStrategy.Strategy_DOMAIN_FORCE.f99899id) {
                return 1800000L;
            }
            return 3600000L;
        }

        public boolean isIPValid() {
            long iPValidTime = getIPValidTime();
            long currentTimeMillis = System.currentTimeMillis() - this.mIpTimestamp;
            if (currentTimeMillis >= 0 && currentTimeMillis <= iPValidTime) {
                return true;
            }
            return false;
        }

        public void setIPInfo(IPInfo iPInfo) {
            this.mIpInfo = iPInfo;
        }

        public String toString() {
            String str;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("(id:");
            sb5.append(this.f99899id);
            sb5.append(";");
            sb5.append(this.allowProxy);
            sb5.append(";");
            sb5.append(this.useConfigApn);
            sb5.append(";");
            sb5.append(this.enableBackupIP);
            sb5.append(";");
            IPInfo iPInfo = this.mIpInfo;
            if (iPInfo != null) {
                str = iPInfo.toString();
            } else {
                str = WiFiDash.NOT_AVALIBLE;
            }
            sb5.append(str);
            sb5.append(")");
            return new String(sb5.toString());
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            if (parcel == null) {
                return;
            }
            parcel.writeInt(this.f99899id);
            parcel.writeInt(this.allowProxy ? 1 : 0);
            parcel.writeInt(this.useConfigApn ? 1 : 0);
            parcel.writeInt(this.enableBackupIP ? 1 : 0);
            parcel.writeInt(this.forceDomain ? 1 : 0);
            parcel.writeParcelable(this.mIpInfo, 0);
            parcel.writeLong(this.mIpTimestamp);
        }

        public StrategyInfo(int i3, boolean z16, boolean z17, boolean z18) {
            this(i3, z16, z17, z18, false);
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public StrategyInfo m107clone() {
            StrategyInfo strategyInfo = new StrategyInfo(this.f99899id, this.allowProxy, this.useConfigApn, this.enableBackupIP);
            int i3 = this.f99899id;
            if (i3 > 0) {
                strategyInfo.f99899id = i3;
            }
            return strategyInfo;
        }

        public StrategyInfo(int i3, boolean z16, boolean z17, boolean z18, boolean z19) {
            this.f99899id = i3;
            this.allowProxy = z16;
            this.useConfigApn = z17;
            this.enableBackupIP = z18;
            this.forceDomain = z19;
            this.mIpTimestamp = System.currentTimeMillis();
            filter();
            initID();
        }

        public StrategyInfo(Parcel parcel) {
            this.forceDomain = false;
            if (parcel == null) {
                return;
            }
            this.f99899id = parcel.readInt();
            this.allowProxy = parcel.readInt() == 1;
            this.useConfigApn = parcel.readInt() == 1;
            this.enableBackupIP = parcel.readInt() == 1;
            this.forceDomain = parcel.readInt() == 1;
            this.mIpInfo = (IPInfo) parcel.readParcelable(DownloadGlobalStrategy.mContext.getClassLoader());
            this.mIpTimestamp = parcel.readLong();
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class StrategyLib {
        private String mBackupIp;
        private StrategyInfo mBestStrategyInfo;
        private String mDirectIp;
        private String mDnsIP;
        private StrategyInfo mOldStrategyInfo;
        private int mPort;
        private ArrayList<StrategyInfo> mStrategyList;
        private boolean updateEnable = true;

        public StrategyLib() {
            ensureData();
            this.mPort = 80;
        }

        private void ensureData() {
            if (this.mStrategyList != null) {
                return;
            }
            if (!NetworkManager.isWap()) {
                this.mStrategyList = DownloadGlobalStrategy.StrategyLib_NWAP;
            } else {
                this.mStrategyList = DownloadGlobalStrategy.StrategyLib_WAP;
            }
        }

        private void updateStrategyLists() {
            if (!this.updateEnable) {
                return;
            }
            boolean allowProxy = ProxyStatistics.getInstance().getAllowProxy();
            boolean aPNProxy = ProxyStatistics.getInstance().getAPNProxy();
            if (!allowProxy) {
                this.mStrategyList = DownloadGlobalStrategy.StrategyLib_NWAP;
            } else if (aPNProxy) {
                this.mStrategyList = DownloadGlobalStrategy.StrategyLib_WAP;
            } else {
                this.mStrategyList = DownloadGlobalStrategy.StrategyLib_WAP1;
            }
        }

        public void addStrategy(List<StrategyInfo> list) {
            ArrayList<StrategyInfo> arrayList = this.mStrategyList;
            if (arrayList != null && list != null) {
                arrayList.addAll(list);
            }
        }

        public void copyStrageList() {
            if (this.mStrategyList == null) {
                this.mStrategyList = new ArrayList<>();
            } else {
                this.mStrategyList = new ArrayList<>(this.mStrategyList);
            }
        }

        public void enableUpdate(boolean z16) {
            this.updateEnable = z16;
        }

        public String getBackupIP() {
            return this.mBackupIp;
        }

        public int getBestId() {
            StrategyInfo strategyInfo = this.mBestStrategyInfo;
            if (strategyInfo != null) {
                return strategyInfo.f99899id;
            }
            return 0;
        }

        public StrategyInfo getBestStrategy() {
            return this.mBestStrategyInfo;
        }

        public String getDirectIP() {
            return this.mDirectIp;
        }

        public String getDnsIP() {
            return this.mDnsIP;
        }

        public StrategyInfo getOldStrategyInfo() {
            return this.mOldStrategyInfo;
        }

        public int getPort() {
            return this.mPort;
        }

        public StrategyInfo getStrategyInfo(int i3) {
            StrategyInfo strategyInfo;
            if (i3 < 0) {
                i3 = 0;
            }
            StrategyInfo strategyInfo2 = this.mBestStrategyInfo;
            if (strategyInfo2 == null) {
                ArrayList<StrategyInfo> arrayList = this.mStrategyList;
                strategyInfo2 = arrayList.get(i3 % arrayList.size());
            } else if (i3 > 0) {
                int i16 = strategyInfo2.f99899id;
                int i17 = -1;
                if (i16 != DownloadGlobalStrategy.Strategy_DomainDirect.f99899id && i16 != DownloadGlobalStrategy.Strategy_BACKUPIP.f99899id && i16 != DownloadGlobalStrategy.Strategy_DOMAIN_FORCE.f99899id) {
                    if (i3 == 1) {
                        updateStrategyLists();
                    }
                    int i18 = 0;
                    while (true) {
                        if (i18 >= this.mStrategyList.size()) {
                            break;
                        }
                        if (this.mStrategyList.get(i18).f99899id == this.mBestStrategyInfo.f99899id) {
                            i17 = i18;
                            break;
                        }
                        i18++;
                    }
                    if (i3 > 0 && i3 <= i17) {
                        strategyInfo = this.mStrategyList.get(i3 - 1);
                    } else {
                        ArrayList<StrategyInfo> arrayList2 = this.mStrategyList;
                        strategyInfo = arrayList2.get(i3 % arrayList2.size());
                    }
                    strategyInfo2 = strategyInfo;
                } else {
                    if (i3 == 1) {
                        updateStrategyLists();
                        return this.mBestStrategyInfo;
                    }
                    int i19 = -1;
                    for (int i26 = 0; i26 < this.mStrategyList.size(); i26++) {
                        if (this.mStrategyList.get(i26).f99899id == this.mBestStrategyInfo.f99899id) {
                            if (i19 < 0) {
                                i19 = i26;
                            }
                            i17 = i26;
                        }
                    }
                    if (i3 > 1 && i3 <= i17) {
                        strategyInfo2 = this.mStrategyList.get(i3 - 2);
                    } else if (i3 > i17) {
                        ArrayList<StrategyInfo> arrayList3 = this.mStrategyList;
                        strategyInfo2 = arrayList3.get(i3 % arrayList3.size());
                    } else {
                        strategyInfo2 = null;
                    }
                }
            }
            if (strategyInfo2 == null) {
                return (StrategyInfo) (NetworkManager.isWap() ? DownloadGlobalStrategy.StrategyLib_WAP : DownloadGlobalStrategy.StrategyLib_NWAP).get(0);
            }
            return strategyInfo2;
        }

        public List<StrategyInfo> getStrategyList() {
            return this.mStrategyList;
        }

        public int getSuggestMaxTimes() {
            ArrayList<StrategyInfo> arrayList = this.mStrategyList;
            if (arrayList != null) {
                return arrayList.size();
            }
            return 0;
        }

        public void setBackupIP(String str) {
            this.mBackupIp = str;
        }

        public void setDirectIP(String str) {
            this.mDirectIp = str;
        }

        public void setDnsIP(String str) {
            this.mDnsIP = str;
        }

        public void setOldStrategyInfo(StrategyInfo strategyInfo) {
            this.mOldStrategyInfo = strategyInfo;
        }

        public void setPort(int i3) {
            this.mPort = i3;
        }
    }

    DownloadGlobalStrategy(Context context) {
        this.mPortConfig = DownloaderFactory.getInstance(context).getPortStrategy();
        boolean isEnableCacheWifiBSSID = Config.isEnableCacheWifiBSSID();
        this.mEnableCacheWifiBSSID = isEnableCacheWifiBSSID;
        QDLog.d(TAG, "init enableCacheWifiBSSID:" + isEnableCacheWifiBSSID);
        ArrayList<StrategyInfo> arrayList = StrategyLib_WAP;
        StrategyInfo strategyInfo = Strategy_DomainProxy_CON;
        arrayList.add(strategyInfo);
        ArrayList<StrategyInfo> arrayList2 = StrategyLib_WAP;
        StrategyInfo strategyInfo2 = Strategy_DomainDirect;
        arrayList2.add(strategyInfo2);
        StrategyLib_WAP.add(strategyInfo2);
        ArrayList<StrategyInfo> arrayList3 = StrategyLib_WAP;
        StrategyInfo strategyInfo3 = Strategy_DOMAIN_FORCE;
        arrayList3.add(strategyInfo3);
        StrategyLib_WAP.add(strategyInfo3);
        ArrayList<StrategyInfo> arrayList4 = StrategyLib_WAP;
        StrategyInfo strategyInfo4 = Strategy_BACKUPIP;
        arrayList4.add(strategyInfo4);
        StrategyLib_WAP.add(strategyInfo4);
        ArrayList<StrategyInfo> arrayList5 = StrategyLib_WAP;
        StrategyInfo strategyInfo5 = Strategy_DomainProxy_SYS;
        arrayList5.add(strategyInfo5);
        StrategyLib_WAP1.add(strategyInfo5);
        StrategyLib_WAP1.add(strategyInfo2);
        StrategyLib_WAP1.add(strategyInfo2);
        StrategyLib_WAP1.add(strategyInfo3);
        StrategyLib_WAP1.add(strategyInfo3);
        StrategyLib_WAP1.add(strategyInfo4);
        StrategyLib_WAP1.add(strategyInfo4);
        StrategyLib_WAP1.add(strategyInfo);
        StrategyLib_NWAP.add(strategyInfo2);
        StrategyLib_NWAP.add(strategyInfo2);
        StrategyLib_NWAP.add(strategyInfo3);
        StrategyLib_NWAP.add(strategyInfo3);
        StrategyLib_NWAP.add(strategyInfo4);
        StrategyLib_NWAP.add(strategyInfo4);
        StrategyLib_NWAP.add(strategyInfo);
        StrategyLib_NWAP.add(strategyInfo5);
        mContext = context;
        if (context != null) {
            this.mSetting = Global.getSharedPreferences(context, "download_stragegy_" + getProcessName(mContext), 0);
        }
        loadStrategy();
    }

    private boolean checkStrategyValid(StrategyInfo strategyInfo, boolean z16, boolean z17) {
        if (strategyInfo == null) {
            return false;
        }
        return true;
    }

    private String getBSSIDByNetwork() {
        String bssid = NetworkManager.getBSSID();
        if (TextUtils.isEmpty(bssid)) {
            return "";
        }
        return "_" + bssid;
    }

    private String getBSSIDPreferCache() {
        String str;
        if (TextUtils.isEmpty(this.mCacheWifiBSSID)) {
            str = NetworkManager.getBSSID();
        } else {
            str = this.mCacheWifiBSSID;
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        this.mCacheWifiBSSID = str;
        return "_" + str;
    }

    private String getDomainStrategyCacheKey(String str, String str2) {
        String str3;
        if ("wifi".equals(str2)) {
            if (this.mEnableCacheWifiBSSID) {
                str3 = getBSSIDPreferCache();
            } else {
                str3 = getBSSIDByNetwork();
            }
        } else {
            str3 = "";
        }
        return str + "_" + str2 + str3;
    }

    public static DownloadGlobalStrategy getInstance(Context context) {
        if (mInstance == null) {
            synchronized (INSTANCE_LOCK) {
                if (mInstance == null) {
                    mInstance = new DownloadGlobalStrategy(context);
                }
            }
        }
        return mInstance;
    }

    private String getProcessName(Context context) {
        int lastIndexOf;
        try {
            String currentProcessName = Utils.getCurrentProcessName(context);
            if (currentProcessName != null && currentProcessName.contains(":") && (lastIndexOf = currentProcessName.lastIndexOf(":")) > 0) {
                currentProcessName = currentProcessName.substring(lastIndexOf + 1);
            }
            if (TextUtils.isEmpty(currentProcessName)) {
                return "";
            }
            return currentProcessName;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static long getRecentIPValidCacheTime() {
        return 259200L;
    }

    private void loadStrategy() {
        boolean z16;
        if (this.mSetting == null) {
            return;
        }
        this.mapBestDomainStrategyCache.clear();
        if (this.mSetting.getInt("download_support_https", 1) == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.httpsSupport = z16;
        this.httpsSupportTimestamp = this.mSetting.getLong("download_support_https_timestamp", System.currentTimeMillis());
        if (System.currentTimeMillis() - this.httpsSupportTimestamp > Config.getConfig("PhotoSvrList", Config.SECONDARY_KEY_HTTPS_DIS_VALID_TIME, 86400L) * 1000) {
            this.httpsSupport = true;
            this.httpsSupportTimestamp = System.currentTimeMillis();
        }
        Parcel parcel = null;
        String string = this.mSetting.getString("download_best_strategy", null);
        if (string != null) {
            try {
                parcel = Utils.unmarshall(Base64.decode(string, 0));
                parcel.readMap(this.mapBestDomainStrategyCache, mContext.getClassLoader());
            } catch (Throwable th5) {
                try {
                    QDLog.w(TAG, "loadStrategy", th5);
                } finally {
                    if (parcel != null) {
                        OaidMonitor.parcelRecycle(parcel);
                    }
                }
            }
        }
    }

    public StrategyInfo getBestStrategyInfo(String str, String str2) {
        StrategyInfo strategyInfo = null;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String domainStrategyCacheKey = getDomainStrategyCacheKey(str2, NetworkManager.getApnValue());
        StrategyInfo strategyInfo2 = this.mapBestDomainStrategyCache.get(domainStrategyCacheKey);
        if (strategyInfo2 != null && !strategyInfo2.isIPValid()) {
            this.mapBestDomainStrategyCache.remove(domainStrategyCacheKey);
            this.mCacheModifyCount++;
            saveStrategy();
            if (QDLog.isInfoEnable()) {
                QDLog.i(TAG, "best strategy invalid! domain:" + str2 + " threadId:" + Thread.currentThread().getId());
            }
        } else {
            strategyInfo = strategyInfo2;
        }
        boolean allowProxy = ProxyStatistics.getInstance().getAllowProxy();
        boolean aPNProxy = ProxyStatistics.getInstance().getAPNProxy();
        if (!checkStrategyValid(strategyInfo, allowProxy, aPNProxy)) {
            return new StrategyInfo(allowProxy, aPNProxy, false);
        }
        return strategyInfo;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0056, code lost:
    
        if (com.tencent.component.network.downloader.common.Utils.isPortValid(r2) == false) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public StrategyLib getStrategyLib(String str, String str2, boolean z16) {
        int i3;
        StrategyLib strategyLib = new StrategyLib();
        strategyLib.mBestStrategyInfo = getBestStrategyInfo(str, str2);
        if (!NetworkManager.isWap()) {
            strategyLib.mStrategyList = StrategyLib_NWAP;
        } else {
            strategyLib.mStrategyList = StrategyLib_WAP;
        }
        if (z16) {
            i3 = WebSocketImpl.DEFAULT_WSS_PORT;
        } else {
            PortConfigStrategy portConfigStrategy = this.mPortConfig;
            if (portConfigStrategy != null && portConfigStrategy.supportExtraPort(str2) && strategyLib.mBestStrategyInfo != null && strategyLib.mBestStrategyInfo.getIPInfo() != null && strategyLib.mBestStrategyInfo.isIPValid()) {
                i3 = strategyLib.mBestStrategyInfo.getIPInfo().port;
            }
            i3 = 80;
        }
        strategyLib.setPort(i3);
        if (strategyLib.mBestStrategyInfo != null && strategyLib.mBestStrategyInfo.getIPInfo() != null && strategyLib.mBestStrategyInfo.isIPValid() && !TextUtils.isEmpty(strategyLib.mBestStrategyInfo.getIPInfo().f99897ip)) {
            if (strategyLib.mBestStrategyInfo.f99899id == Strategy_BACKUPIP.f99899id) {
                strategyLib.setBackupIP(strategyLib.mBestStrategyInfo.getIPInfo().f99897ip);
            } else if (strategyLib.mBestStrategyInfo.f99899id == Strategy_DOMAIN_FORCE.f99899id) {
                strategyLib.setDnsIP(strategyLib.mBestStrategyInfo.getIPInfo().f99897ip);
            } else if (strategyLib.mBestStrategyInfo.f99899id == Strategy_DomainDirect.f99899id) {
                strategyLib.setDirectIP(strategyLib.mBestStrategyInfo.getIPInfo().f99897ip);
            }
        }
        return strategyLib;
    }

    public void onNetworkChanged(String str, String str2) {
        if (!this.mEnableCacheWifiBSSID) {
            return;
        }
        if (("wifi".equals(str) && !"wifi".equals(str2)) || (!"wifi".equals(str) && "wifi".equals(str2))) {
            this.mCacheWifiBSSID = null;
            QDLog.d(TAG, "onNetworkChanged,oldApn:" + str + " newApn:" + str2 + ",clear cache wifi bssid");
        }
    }

    public synchronized void report(Context context, String str, String str2, StrategyInfo strategyInfo, boolean z16) {
        int i3;
        if (!TextUtils.isEmpty(str) && strategyInfo != null) {
            String apnValue = NetworkManager.getApnValue();
            if (str2 != null) {
                String domainStrategyCacheKey = getDomainStrategyCacheKey(str2, apnValue);
                StrategyInfo strategyInfo2 = this.mapBestDomainStrategyCache.get(domainStrategyCacheKey);
                if (z16) {
                    if (!strategyInfo.equals(strategyInfo2) && StrategyInfo.compare(strategyInfo, strategyInfo2) >= 0) {
                        this.mapBestDomainStrategyCache.put(domainStrategyCacheKey, strategyInfo);
                        this.mCacheModifyCount++;
                        saveStrategy();
                    }
                } else if (strategyInfo.equals(strategyInfo2)) {
                    this.mapBestDomainStrategyCache.remove(domainStrategyCacheKey);
                    this.mCacheModifyCount++;
                    saveStrategy();
                }
                if (this.mCacheModifyCount > 0) {
                    saveStrategy();
                }
            }
            if (z16 && ((i3 = strategyInfo.f99899id) == Strategy_DomainProxy_CON.f99899id || i3 == Strategy_DomainProxy_SYS.f99899id)) {
                ProxyStatistics.getInstance().report(context, strategyInfo.allowProxy, strategyInfo.useConfigApn);
            }
        }
    }

    public synchronized void reportHttps(String str, boolean z16, boolean z17) {
        if (!z16) {
            return;
        }
        QDLog.e(TAG, "https download result:" + z17 + " failCount:" + this.mHttpsFailCount);
        if (!z17) {
            this.mHttpsFailCount++;
            if (this.mHttpsFailCount >= Config.getConfig("PhotoSvrList", Config.SECONDARY_KEY_HTTPS_FAILCOUNT, 6L) && this.httpsSupport) {
                this.httpsSupport = false;
                this.httpsSupportTimestamp = System.currentTimeMillis();
                this.mSetting.edit().putInt("download_support_https", 0);
                this.mSetting.edit().putLong("download_support_https_timestamp", this.httpsSupportTimestamp);
                this.mSetting.edit().commit();
            }
        } else {
            this.mHttpsFailCount = 0;
            if (!this.httpsSupport) {
                this.httpsSupport = true;
                this.httpsSupportTimestamp = System.currentTimeMillis();
                this.mSetting.edit().putInt("download_support_https", 1);
                this.mSetting.edit().putLong("download_support_https_timestamp", this.httpsSupportTimestamp);
                this.mSetting.edit().commit();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0060, code lost:
    
        if (r1 == null) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void saveStrategy() {
        Parcel parcel;
        if (this.mSetting != null && this.mCacheModifyCount != 0) {
            if (DownloadTask.getCurrTotalTaskCount() > 0 && this.mCacheModifyCount < 5) {
                return;
            }
            this.mCacheModifyCount = 0;
            if (QDLog.isDebugEnable()) {
                QDLog.d(TAG, "save best strategys");
            }
            try {
                parcel = Parcel.obtain();
            } catch (Throwable th5) {
                th = th5;
                parcel = null;
            }
            try {
                parcel.writeMap(this.mapBestDomainStrategyCache);
                this.mSetting.edit().putString("download_best_strategy", new String(Base64.encode(parcel.marshall(), 0))).commit();
            } catch (Throwable th6) {
                th = th6;
                try {
                    QDLog.w(TAG, "saveStrategy", th);
                } catch (Throwable th7) {
                    if (parcel != null) {
                        OaidMonitor.parcelRecycle(parcel);
                    }
                    throw th7;
                }
            }
            OaidMonitor.parcelRecycle(parcel);
        }
    }

    public boolean supportHttps() {
        return this.httpsSupport;
    }
}
