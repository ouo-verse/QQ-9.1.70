package com.tencent.qmethod.pandoraex.monitor;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanSettings;
import android.location.Criteria;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Looper;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityTdscdma;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.NetworkScan;
import android.telephony.NetworkScanRequest;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import android.telephony.TelephonyScanManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import androidx.annotation.RequiresApi;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.tencent.bugly.common.utils.DeviceInfoUtil;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.qmethod.pandoraex.core.MonitorReporter;
import com.tencent.qmethod.pandoraex.core.strategy.CacheStrategyFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executor;
import vr3.a;

/* compiled from: P */
/* loaded from: classes22.dex */
public class LocationMonitor {
    private static final int DEF_CID = -1;
    public static final String TAG = "LocationMonitor";
    public static List<CellInfo> lastCellLInfo;
    public static CellLocation lastCellLocation;
    public static Location lastLocation;
    private static final List<CellInfo> defaultLastCellLInfo = new ArrayList();
    private static NetworkScan lastNetworkScan = null;
    private static ServiceState lastServiceState = null;
    private static final ServiceState defaultLastServiceState = new ServiceState();
    private static WifiInfo sWifiInfo = null;
    private static float lastAccuracy = 0.0f;
    private static com.tencent.qmethod.pandoraex.core.l<Integer> sCidCache = new com.tencent.qmethod.pandoraex.core.l<>();
    private static final Object lockWifiInfo = new Object();

    @SuppressLint({"MissingPermission"})
    public static boolean addGpsStatusListener(LocationManager locationManager, GpsStatus.Listener listener) {
        if (com.tencent.qmethod.pandoraex.core.x.C(MonitorReporter.getStrategyAndReport("location", "LM#AD_GPS_LIS", new a.C11438a().b("ban").b("cache_only").d(), null))) {
            return locationManager.addGpsStatusListener(listener);
        }
        return false;
    }

    public static float getAccuracy(Location location) {
        com.tencent.qmethod.pandoraex.api.d strategyAndReport = MonitorReporter.getStrategyAndReport("location", "LOC#G_ACC", new a.C11438a().b("ban").b("cache_only").b("memory").d(), null);
        if (com.tencent.qmethod.pandoraex.core.x.C(strategyAndReport)) {
            float accuracy = location.getAccuracy();
            lastAccuracy = accuracy;
            return accuracy;
        }
        if (com.tencent.qmethod.pandoraex.core.x.A(strategyAndReport)) {
            return lastAccuracy;
        }
        return 0.0f;
    }

    @SuppressLint({"MissingPermission", "NewApi"})
    public static List<CellInfo> getAllCellInfo(TelephonyManager telephonyManager) {
        com.tencent.qmethod.pandoraex.api.d strategyAndReport = MonitorReporter.getStrategyAndReport("location", "TM#G_ALL_CI", new a.C11438a().b("ban").b("cache_only").b("memory").a("android.permission.ACCESS_FINE_LOCATION").d(), null);
        if (com.tencent.qmethod.pandoraex.core.x.C(strategyAndReport)) {
            lastCellLInfo = telephonyManager.getAllCellInfo();
            MonitorReporter.handleEventReport("TM#G_ALL_CI", "");
            return lastCellLInfo;
        }
        if (com.tencent.qmethod.pandoraex.core.x.A(strategyAndReport)) {
            List<CellInfo> list = lastCellLInfo;
            if (list == null) {
                return defaultLastCellLInfo;
            }
            return list;
        }
        return defaultLastCellLInfo;
    }

    public static int getBaseStationId(CdmaCellLocation cdmaCellLocation) {
        return getBaseStationIdForCdma(cdmaCellLocation);
    }

    public static int getBaseStationIdForCdma(final Object obj) {
        return getCidImpl(new com.tencent.qmethod.pandoraex.core.k<Integer>() { // from class: com.tencent.qmethod.pandoraex.monitor.LocationMonitor.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.tencent.qmethod.pandoraex.core.k
            public Integer call() {
                MonitorReporter.handleEventReport("CCL#G_BASE_STAT_ID", "");
                Object obj2 = obj;
                if (obj2 instanceof CdmaCellLocation) {
                    return Integer.valueOf(((CdmaCellLocation) obj2).getBaseStationId());
                }
                if (obj2 instanceof CellIdentityCdma) {
                    return Integer.valueOf(((CellIdentityCdma) obj2).getBasestationId());
                }
                return -1;
            }
        }, "CCL#G_BASE_STAT_ID");
    }

    @RequiresApi(api = 17)
    public static int getCellCid(final CellIdentityLte cellIdentityLte) {
        return getCidImpl(new com.tencent.qmethod.pandoraex.core.k<Integer>() { // from class: com.tencent.qmethod.pandoraex.monitor.LocationMonitor.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.tencent.qmethod.pandoraex.core.k
            public Integer call() {
                return Integer.valueOf(cellIdentityLte.getCi());
            }
        }, "CIL#G_CI");
    }

    @SuppressLint({"MissingPermission"})
    public static CellLocation getCellLocation(TelephonyManager telephonyManager) {
        com.tencent.qmethod.pandoraex.api.d strategyAndReport = MonitorReporter.getStrategyAndReport("location", "TM#G_CELL_LOC", new a.C11438a().b("ban").b("cache_only").b("memory").a("android.permission.ACCESS_FINE_LOCATION").d(), null);
        if (com.tencent.qmethod.pandoraex.core.x.C(strategyAndReport)) {
            lastCellLocation = telephonyManager.getCellLocation();
            MonitorReporter.handleEventReport("TM#G_CELL_LOC", "");
            return lastCellLocation;
        }
        if (com.tencent.qmethod.pandoraex.core.x.A(strategyAndReport)) {
            CellLocation cellLocation = lastCellLocation;
            if (cellLocation == null) {
                return com.tencent.qmethod.pandoraex.api.e.d();
            }
            return cellLocation;
        }
        return com.tencent.qmethod.pandoraex.api.e.d();
    }

    public static int getCid(CellIdentityGsm cellIdentityGsm) {
        return getCidForGsmImpl(cellIdentityGsm);
    }

    public static int getCidForGsmImpl(final Object obj) {
        return getCidImpl(new com.tencent.qmethod.pandoraex.core.k<Integer>() { // from class: com.tencent.qmethod.pandoraex.monitor.LocationMonitor.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.tencent.qmethod.pandoraex.core.k
            public Integer call() {
                MonitorReporter.handleEventReport("GCL#G_CID", "");
                Object obj2 = obj;
                if (obj2 instanceof GsmCellLocation) {
                    return Integer.valueOf(((GsmCellLocation) obj2).getCid());
                }
                if (obj2 instanceof CellIdentityGsm) {
                    return Integer.valueOf(((CellIdentityGsm) obj2).getCid());
                }
                return -1;
            }
        }, "GCL#G_CID");
    }

    private static int getCidImpl(com.tencent.qmethod.pandoraex.core.k<Integer> kVar, String str) {
        com.tencent.qmethod.pandoraex.api.d strategyAndReport = MonitorReporter.getStrategyAndReport("location", str, new a.C11438a().b("ban").b("cache_only").b("memory").b(QQPermissionConstants.Permission.STORAGE_GROUP).d(), null);
        int intValue = sCidCache.a(str, -1).intValue();
        if (com.tencent.qmethod.pandoraex.core.x.C(strategyAndReport)) {
            int intValue2 = kVar.call().intValue();
            sCidCache.b(str, Integer.valueOf(intValue2));
            if (QQPermissionConstants.Permission.STORAGE_GROUP.equals(strategyAndReport.f343900a)) {
                com.tencent.qmethod.pandoraex.core.o.c(TAG, str + " systemApiCall in storage");
                com.tencent.qmethod.pandoraex.api.r.n(com.tencent.qmethod.pandoraex.api.q.b(), str, Integer.valueOf(intValue2));
                com.tencent.qmethod.pandoraex.core.e.d(str, strategyAndReport.f343902c);
                return intValue2;
            }
            return intValue2;
        }
        if (com.tencent.qmethod.pandoraex.core.x.A(strategyAndReport) && !"memory".equals(strategyAndReport.f343900a) && intValue == -1) {
            return com.tencent.qmethod.pandoraex.api.r.e(com.tencent.qmethod.pandoraex.api.q.b(), str);
        }
        return intValue;
    }

    public static WifiInfo getConnectionInfo(WifiManager wifiManager) {
        WifiInfo wifiInfo;
        com.tencent.qmethod.pandoraex.api.d strategyAndReport = MonitorReporter.getStrategyAndReport("location", "WM#G_CON_INFO", new a.C11438a().b("ban").b("cache_only").b("memory").b(QQPermissionConstants.Permission.STORAGE_GROUP).d(), null);
        if (com.tencent.qmethod.pandoraex.core.x.C(strategyAndReport)) {
            if ("normal".equals(strategyAndReport.f343900a)) {
                WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                sWifiInfo = connectionInfo;
                return connectionInfo;
            }
            synchronized (lockWifiInfo) {
                try {
                    if (com.tencent.qmethod.pandoraex.core.d.b("WM#G_CON_INFO")) {
                        sWifiInfo = wifiManager.getConnectionInfo();
                        com.tencent.qmethod.pandoraex.core.o.c(TAG, "WM#G_CON_INFO is Really Call System API");
                        com.tencent.qmethod.pandoraex.api.r.m(com.tencent.qmethod.pandoraex.api.q.b(), "WM#G_CON_INFO_network_state", Boolean.FALSE);
                    } else {
                        if (sWifiInfo != null && !com.tencent.qmethod.pandoraex.core.e.c("WM#G_CON_INFO", strategyAndReport.f343902c)) {
                            return sWifiInfo;
                        }
                        sWifiInfo = wifiManager.getConnectionInfo();
                        com.tencent.qmethod.pandoraex.core.o.c(TAG, "WM#G_CON_INFO is Really Call System API");
                    }
                } catch (Exception e16) {
                    com.tencent.qmethod.pandoraex.core.o.d(TAG, "getConnectionInfo error:", e16);
                }
                if (QQPermissionConstants.Permission.STORAGE_GROUP.equals(strategyAndReport.f343900a)) {
                    try {
                        com.tencent.qmethod.pandoraex.api.r.l(com.tencent.qmethod.pandoraex.api.q.b(), "WM#G_CON_INFO", sWifiInfo);
                        com.tencent.qmethod.pandoraex.core.o.a(TAG, "WM#G_CON_INFO is save data into Storage");
                        com.tencent.qmethod.pandoraex.core.e.d("WM#G_CON_INFO", strategyAndReport.f343902c);
                    } catch (Exception e17) {
                        com.tencent.qmethod.pandoraex.core.o.d(TAG, "wifiInfo save storage error", e17);
                    }
                }
                return sWifiInfo;
            }
        }
        if (!com.tencent.qmethod.pandoraex.core.x.A(strategyAndReport)) {
            return null;
        }
        if ("cache_only".equals(strategyAndReport.f343900a) && (wifiInfo = sWifiInfo) != null) {
            return wifiInfo;
        }
        try {
            WifiInfo wifiInfo2 = (WifiInfo) com.tencent.qmethod.pandoraex.api.r.h(com.tencent.qmethod.pandoraex.api.q.b(), "WM#G_CON_INFO", WifiInfo.class);
            if (wifiInfo2 != null) {
                sWifiInfo = wifiInfo2;
            }
        } catch (OutOfMemoryError e18) {
            com.tencent.qmethod.pandoraex.core.o.d(TAG, "wifiInfo getParcelable OOM!", e18);
        }
        return sWifiInfo;
    }

    @SuppressLint({"MissingPermission"})
    public static Location getLastKnownLocation(LocationManager locationManager, String str) {
        com.tencent.qmethod.pandoraex.api.d strategyAndReport = MonitorReporter.getStrategyAndReport("location", "LM#G_LAST_KL", new a.C11438a().b("ban").b("cache_only").b("memory").a("android.permission.ACCESS_COARSE_LOCATION").a("android.permission.ACCESS_FINE_LOCATION").d(), null);
        if (com.tencent.qmethod.pandoraex.core.x.C(strategyAndReport)) {
            lastLocation = locationManager.getLastKnownLocation(str);
            MonitorReporter.handleEventReport("LM#G_LAST_KL", "");
            return lastLocation;
        }
        if (com.tencent.qmethod.pandoraex.core.x.A(strategyAndReport)) {
            Location location = lastLocation;
            if (location == null) {
                return com.tencent.qmethod.pandoraex.api.e.j();
            }
            return location;
        }
        return com.tencent.qmethod.pandoraex.api.e.j();
    }

    @SuppressLint({"NewApi", "MissingPermission"})
    public static ServiceState getServiceState(TelephonyManager telephonyManager) {
        ServiceState serviceState;
        com.tencent.qmethod.pandoraex.api.d strategyAndReport = MonitorReporter.getStrategyAndReport("location", "TM#G_SER_STATE", new a.C11438a().b("ban").b("cache_only").b("memory").a(DeviceInfoUtil.PERMISSION_READ_PHONE).a("android.permission.ACCESS_COARSE_LOCATION").d(), null);
        if (com.tencent.qmethod.pandoraex.core.x.C(strategyAndReport)) {
            serviceState = telephonyManager.getServiceState();
            lastServiceState = serviceState;
            return serviceState;
        }
        if (com.tencent.qmethod.pandoraex.core.x.A(strategyAndReport)) {
            ServiceState serviceState2 = lastServiceState;
            if (serviceState2 == null) {
                return defaultLastServiceState;
            }
            return serviceState2;
        }
        return defaultLastServiceState;
    }

    private static WifiInfo getWifiInfoFromStorage() {
        if (!com.tencent.qmethod.pandoraex.api.r.c(com.tencent.qmethod.pandoraex.api.q.b(), "WM#G_CON_INFO").booleanValue()) {
            return null;
        }
        try {
            return (WifiInfo) new GsonBuilder().registerTypeAdapter(CharSequence.class, new CacheStrategyFactory.CharSequenceAdapter()).create().fromJson(com.tencent.qmethod.pandoraex.api.r.j(com.tencent.qmethod.pandoraex.api.q.b(), "WM#G_CON_INFO"), new TypeToken<WifiInfo>() { // from class: com.tencent.qmethod.pandoraex.monitor.LocationMonitor.6
            }.getType());
        } catch (Exception e16) {
            com.tencent.qmethod.pandoraex.core.o.d(TAG, "getWifiInfoFromStorage error:", e16);
            return null;
        }
    }

    @SuppressLint({"DefaultLocale"})
    public static void listen(TelephonyManager telephonyManager, PhoneStateListener phoneStateListener, int i3) {
        if ((i3 & 16) == 0 && (i3 & 1) == 0 && (i3 & 1024) == 0) {
            telephonyManager.listen(phoneStateListener, i3);
        } else if (com.tencent.qmethod.pandoraex.core.x.C(MonitorReporter.getStrategyAndReport("location", "TM#LIS#PI", new a.C11438a().b("ban").b("cache_only").d(), null))) {
            telephonyManager.listen(phoneStateListener, i3);
        }
    }

    @SuppressLint({"MissingPermission"})
    public static void removeUpdates(LocationManager locationManager, LocationListener locationListener) {
        if (com.tencent.qmethod.pandoraex.core.x.C(MonitorReporter.getStrategyAndReport("location", "LM#RE_UP#L", new a.C11438a().b("ban").b("cache_only").d(), null))) {
            locationManager.removeUpdates(locationListener);
        }
    }

    @SuppressLint({"MissingPermission", "NewApi"})
    public static void requestCellInfoUpdate(TelephonyManager telephonyManager, Executor executor, TelephonyManager.CellInfoCallback cellInfoCallback) {
        if (com.tencent.qmethod.pandoraex.core.x.C(MonitorReporter.getStrategyAndReport("location", "TM#REQ_CELL_UP#EC", new a.C11438a().b("ban").b("cache_only").d(), null))) {
            telephonyManager.requestCellInfoUpdate(executor, cellInfoCallback);
            MonitorReporter.handleEventReport("TM#REQ_CELL_UP#EC", "");
        }
    }

    @SuppressLint({"MissingPermission"})
    public static void requestLocationUpdates(LocationManager locationManager, String str, long j3, float f16, LocationListener locationListener) {
        if (com.tencent.qmethod.pandoraex.core.x.C(MonitorReporter.getStrategyAndReport("location", "LM#REQ_LOC_UP#SLFL", new a.C11438a().b("ban").b("cache_only").a("android.permission.ACCESS_COARSE_LOCATION").a("android.permission.ACCESS_FINE_LOCATION").d(), null))) {
            locationManager.requestLocationUpdates(str, j3, f16, locationListener);
            MonitorReporter.handleEventReport("LM#REQ_LOC_UP#SLFL", "");
        }
    }

    @SuppressLint({"MissingPermission", "NewApi"})
    public static NetworkScan requestNetworkScan(TelephonyManager telephonyManager, NetworkScanRequest networkScanRequest, Executor executor, TelephonyScanManager.NetworkScanCallback networkScanCallback) {
        NetworkScan requestNetworkScan;
        com.tencent.qmethod.pandoraex.api.d strategyAndReport = MonitorReporter.getStrategyAndReport("location", "TM#REQ_NW_SC#REC", new a.C11438a().b("ban").b("cache_only").b("memory").d(), null);
        if (com.tencent.qmethod.pandoraex.core.x.C(strategyAndReport)) {
            requestNetworkScan = telephonyManager.requestNetworkScan(networkScanRequest, executor, networkScanCallback);
            lastNetworkScan = requestNetworkScan;
            return requestNetworkScan;
        }
        if (!com.tencent.qmethod.pandoraex.core.x.A(strategyAndReport)) {
            return null;
        }
        return lastNetworkScan;
    }

    @SuppressLint({"MissingPermission"})
    public static void requestSingleUpdate(LocationManager locationManager, String str, LocationListener locationListener, Looper looper) {
        if (com.tencent.qmethod.pandoraex.core.x.C(MonitorReporter.getStrategyAndReport("location", "LM#REQ_SIN_UP#SLL", new a.C11438a().b("ban").b("cache_only").a("android.permission.ACCESS_COARSE_LOCATION").a("android.permission.ACCESS_FINE_LOCATION").d(), null))) {
            locationManager.requestSingleUpdate(str, locationListener, looper);
            MonitorReporter.handleEventReport("LM#REQ_SIN_UP#SLL", "");
        }
    }

    public static boolean requiresCell(LocationProvider locationProvider) {
        if (com.tencent.qmethod.pandoraex.core.x.C(MonitorReporter.getStrategyAndReport("location", "LP#REQ_CELL", new a.C11438a().b("ban").b("cache_only").d(), null))) {
            return locationProvider.requiresCell();
        }
        return false;
    }

    public static boolean requiresNetwork(LocationProvider locationProvider) {
        if (com.tencent.qmethod.pandoraex.core.x.C(MonitorReporter.getStrategyAndReport("location", "LP#REQ_NET", new a.C11438a().b("ban").b("cache_only").d(), null))) {
            return locationProvider.requiresNetwork();
        }
        return false;
    }

    public static boolean requiresSatellite(LocationProvider locationProvider) {
        if (com.tencent.qmethod.pandoraex.core.x.C(MonitorReporter.getStrategyAndReport("location", "LP#REQ_SAT", new a.C11438a().b("ban").b("cache_only").d(), null))) {
            return locationProvider.requiresSatellite();
        }
        return false;
    }

    @SuppressLint({"MissingPermission", "NewApi"})
    public static boolean startDiscovery(BluetoothAdapter bluetoothAdapter) {
        if (com.tencent.qmethod.pandoraex.core.x.C(MonitorReporter.getStrategyAndReport("location", "BA#STRT_DIS_COV", new a.C11438a().b("ban").b("cache_only").d(), null))) {
            return bluetoothAdapter.startDiscovery();
        }
        return false;
    }

    @SuppressLint({"MissingPermission", "NewApi"})
    public static boolean startLeScan(BluetoothAdapter bluetoothAdapter, BluetoothAdapter.LeScanCallback leScanCallback) {
        if (com.tencent.qmethod.pandoraex.core.x.C(MonitorReporter.getStrategyAndReport("location", "BA#STRT_LE_SC#L", new a.C11438a().b("ban").b("cache_only").d(), null))) {
            return bluetoothAdapter.startLeScan(leScanCallback);
        }
        return false;
    }

    @SuppressLint({"NewApi", "MissingPermission"})
    public static void startScan(BluetoothLeScanner bluetoothLeScanner, ScanCallback scanCallback) {
        if (com.tencent.qmethod.pandoraex.core.x.C(MonitorReporter.getStrategyAndReport("location", "BLS#STRT_SC#S", new a.C11438a().b("ban").b("cache_only").d(), null))) {
            bluetoothLeScanner.startScan(scanCallback);
        }
    }

    public static int getBaseStationId(CellIdentityCdma cellIdentityCdma) {
        return getBaseStationIdForCdma(cellIdentityCdma);
    }

    @RequiresApi(api = 18)
    public static int getCellCid(final CellIdentityWcdma cellIdentityWcdma) {
        return getCidImpl(new com.tencent.qmethod.pandoraex.core.k<Integer>() { // from class: com.tencent.qmethod.pandoraex.monitor.LocationMonitor.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.tencent.qmethod.pandoraex.core.k
            public Integer call() {
                return Integer.valueOf(cellIdentityWcdma.getCid());
            }
        }, "CIW#G_CID");
    }

    public static int getCid(GsmCellLocation gsmCellLocation) {
        return getCidForGsmImpl(gsmCellLocation);
    }

    public static int getCellCid(final CellIdentityTdscdma cellIdentityTdscdma) {
        return getCidImpl(new com.tencent.qmethod.pandoraex.core.k<Integer>() { // from class: com.tencent.qmethod.pandoraex.monitor.LocationMonitor.5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.tencent.qmethod.pandoraex.core.k
            @RequiresApi(api = 28)
            public Integer call() {
                int cid;
                cid = cellIdentityTdscdma.getCid();
                return Integer.valueOf(cid);
            }
        }, "CIT#G_CID");
    }

    @SuppressLint({"MissingPermission"})
    public static void removeUpdates(LocationManager locationManager, PendingIntent pendingIntent) {
        if (com.tencent.qmethod.pandoraex.core.x.C(MonitorReporter.getStrategyAndReport("location", "LM#RE_UP#P", new a.C11438a().b("ban").b("cache_only").d(), null))) {
            locationManager.removeUpdates(pendingIntent);
        }
    }

    @SuppressLint({"MissingPermission", "NewApi"})
    public static boolean startLeScan(BluetoothAdapter bluetoothAdapter, UUID[] uuidArr, BluetoothAdapter.LeScanCallback leScanCallback) {
        if (com.tencent.qmethod.pandoraex.core.x.C(MonitorReporter.getStrategyAndReport("location", "BA#STRT_LE_SC#UL", new a.C11438a().b("ban").b("cache_only").d(), null))) {
            return bluetoothAdapter.startLeScan(uuidArr, leScanCallback);
        }
        return false;
    }

    @SuppressLint({"NewApi", "MissingPermission"})
    public static void startScan(BluetoothLeScanner bluetoothLeScanner, List<ScanFilter> list, ScanSettings scanSettings, ScanCallback scanCallback) {
        if (com.tencent.qmethod.pandoraex.core.x.C(MonitorReporter.getStrategyAndReport("location", "BLS#STRT_SC#LSS", new a.C11438a().b("ban").b("cache_only").d(), null))) {
            bluetoothLeScanner.startScan(list, scanSettings, scanCallback);
        }
    }

    @SuppressLint({"MissingPermission"})
    public static void requestLocationUpdates(LocationManager locationManager, String str, long j3, float f16, LocationListener locationListener, Looper looper) {
        if (com.tencent.qmethod.pandoraex.core.x.C(MonitorReporter.getStrategyAndReport("location", "LM#REQ_LOC_UP#SLFLL", new a.C11438a().b("ban").b("cache_only").a("android.permission.ACCESS_COARSE_LOCATION").a("android.permission.ACCESS_FINE_LOCATION").d(), null))) {
            locationManager.requestLocationUpdates(str, j3, f16, locationListener, looper);
            MonitorReporter.handleEventReport("LM#REQ_LOC_UP#SLFLL", "");
        }
    }

    @SuppressLint({"MissingPermission"})
    public static void requestSingleUpdate(LocationManager locationManager, Criteria criteria, LocationListener locationListener, Looper looper) {
        if (com.tencent.qmethod.pandoraex.core.x.C(MonitorReporter.getStrategyAndReport("location", "LM#REQ_SIN_UP#CLL", new a.C11438a().b("ban").b("cache_only").a("android.permission.ACCESS_COARSE_LOCATION").a("android.permission.ACCESS_FINE_LOCATION").d(), null))) {
            locationManager.requestSingleUpdate(criteria, locationListener, looper);
            MonitorReporter.handleEventReport("LM#REQ_SIN_UP#CLL", "");
        }
    }

    @SuppressLint({"NewApi", "MissingPermission"})
    public static int startScan(BluetoothLeScanner bluetoothLeScanner, List<ScanFilter> list, ScanSettings scanSettings, PendingIntent pendingIntent) {
        int startScan;
        if (!com.tencent.qmethod.pandoraex.core.x.C(MonitorReporter.getStrategyAndReport("location", "BLS#STRT_SC#LSP", new a.C11438a().b("ban").b("cache_only").d(), null))) {
            return 1;
        }
        startScan = bluetoothLeScanner.startScan((List<ScanFilter>) list, scanSettings, pendingIntent);
        return startScan;
    }

    @SuppressLint({"MissingPermission"})
    public static void requestLocationUpdates(LocationManager locationManager, long j3, float f16, Criteria criteria, LocationListener locationListener, Looper looper) {
        if (com.tencent.qmethod.pandoraex.core.x.C(MonitorReporter.getStrategyAndReport("location", "LM#REQ_LOC_UP#LFCLL", new a.C11438a().b("ban").b("cache_only").a("android.permission.ACCESS_COARSE_LOCATION").a("android.permission.ACCESS_FINE_LOCATION").d(), null))) {
            locationManager.requestLocationUpdates(j3, f16, criteria, locationListener, looper);
            MonitorReporter.handleEventReport("LM#REQ_LOC_UP#LFCLL", "");
        }
    }

    @SuppressLint({"MissingPermission"})
    public static void requestSingleUpdate(LocationManager locationManager, String str, PendingIntent pendingIntent) {
        if (com.tencent.qmethod.pandoraex.core.x.C(MonitorReporter.getStrategyAndReport("location", "LM#REQ_SIN_UP#SP", new a.C11438a().b("ban").b("cache_only").a("android.permission.ACCESS_COARSE_LOCATION").a("android.permission.ACCESS_FINE_LOCATION").d(), null))) {
            locationManager.requestSingleUpdate(str, pendingIntent);
            MonitorReporter.handleEventReport("LM#REQ_SIN_UP#SP", "");
        }
    }

    @SuppressLint({"MissingPermission"})
    public static void requestLocationUpdates(LocationManager locationManager, String str, long j3, float f16, PendingIntent pendingIntent) {
        if (com.tencent.qmethod.pandoraex.core.x.C(MonitorReporter.getStrategyAndReport("location", "LM#REQ_LOC_UP#SLFP", new a.C11438a().b("ban").b("cache_only").a("android.permission.ACCESS_COARSE_LOCATION").a("android.permission.ACCESS_FINE_LOCATION").d(), null))) {
            locationManager.requestLocationUpdates(str, j3, f16, pendingIntent);
            MonitorReporter.handleEventReport("LM#REQ_LOC_UP#SLFP", "");
        }
    }

    @SuppressLint({"MissingPermission"})
    public static void requestSingleUpdate(LocationManager locationManager, Criteria criteria, PendingIntent pendingIntent) {
        if (com.tencent.qmethod.pandoraex.core.x.C(MonitorReporter.getStrategyAndReport("location", "LM#REQ_SIN_UP#CP", new a.C11438a().b("ban").b("cache_only").a("android.permission.ACCESS_COARSE_LOCATION").a("android.permission.ACCESS_FINE_LOCATION").d(), null))) {
            locationManager.requestSingleUpdate(criteria, pendingIntent);
            MonitorReporter.handleEventReport("LM#REQ_SIN_UP#CP", "");
        }
    }

    @SuppressLint({"MissingPermission"})
    public static void requestLocationUpdates(LocationManager locationManager, long j3, float f16, Criteria criteria, PendingIntent pendingIntent) {
        if (com.tencent.qmethod.pandoraex.core.x.C(MonitorReporter.getStrategyAndReport("location", "LM#REQ_LOC_UP#LFCP", new a.C11438a().b("ban").b("cache_only").a("android.permission.ACCESS_COARSE_LOCATION").a("android.permission.ACCESS_FINE_LOCATION").d(), null))) {
            locationManager.requestLocationUpdates(j3, f16, criteria, pendingIntent);
            MonitorReporter.handleEventReport("LM#REQ_LOC_UP#LFCP", "");
        }
    }
}
