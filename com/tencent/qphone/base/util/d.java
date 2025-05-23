package com.tencent.qphone.base.util;

import LBS.Attr;
import LBS.Cell;
import LBS.GPS;
import LBS.LBSInfo;
import LBS.Wifi;
import android.annotation.TargetApi;
import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.LocationMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static final String f344430a = "LocationUtil";

    /* renamed from: b, reason: collision with root package name */
    private static TelephonyManager f344431b;

    /* renamed from: c, reason: collision with root package name */
    private static GPS f344432c;

    /* renamed from: d, reason: collision with root package name */
    private static ArrayList<Cell> f344433d;

    /* renamed from: e, reason: collision with root package name */
    private static PhoneStateListener f344434e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a extends PhoneStateListener {

        /* renamed from: a, reason: collision with root package name */
        private short f344435a = 0;

        a() {
        }

        @Override // android.telephony.PhoneStateListener
        public void onCellLocationChanged(CellLocation cellLocation) {
            if (cellLocation == null) {
                return;
            }
            try {
                if (cellLocation instanceof GsmCellLocation) {
                    ArrayList unused = d.f344433d = new ArrayList();
                    Cell cell = new Cell();
                    cell.iLac = ((GsmCellLocation) cellLocation).getLac();
                    cell.iCellId = LocationMonitor.getCid((GsmCellLocation) cellLocation);
                    String networkOperator = DeviceInfoMonitor.getNetworkOperator(d.f344431b);
                    if (networkOperator != null && networkOperator.length() >= 5) {
                        try {
                            cell.shMcc = Short.valueOf(networkOperator.substring(0, 3)).shortValue();
                            cell.shMnc = Short.valueOf(networkOperator.substring(3, 5)).shortValue();
                        } catch (NumberFormatException e16) {
                            e16.printStackTrace();
                        }
                    }
                    cell.shRssi = this.f344435a;
                    if (cell.iLac != -1 && cell.iCellId != -1) {
                        d.f344433d.add(0, cell);
                    }
                }
            } catch (Exception e17) {
                if (QLog.isColorLevel()) {
                    QLog.i(d.f344430a, 2, "onCellLocationChanged exception:" + e17.getMessage());
                }
            }
            super.onCellLocationChanged(cellLocation);
        }

        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            if (signalStrength.isGsm()) {
                if (signalStrength.getGsmSignalStrength() != 99) {
                    this.f344435a = (short) ((signalStrength.getGsmSignalStrength() * 2) - 113);
                } else {
                    this.f344435a = (short) signalStrength.getGsmSignalStrength();
                }
            } else {
                this.f344435a = (short) signalStrength.getCdmaDbm();
            }
            super.onSignalStrengthsChanged(signalStrength);
        }
    }

    private static void c() {
        f344434e = new a();
    }

    @TargetApi(8)
    public static LBSInfo a(Context context) {
        List<ScanResult> scanResults;
        ArrayList arrayList = new ArrayList();
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager != null && (scanResults = NetworkMonitor.getScanResults(wifiManager)) != null && scanResults.size() > 0) {
                for (ScanResult scanResult : scanResults) {
                    if (scanResult.level > -70) {
                        if (arrayList.size() > 20) {
                            break;
                        }
                        arrayList.add(new Wifi(!TextUtils.isEmpty(scanResult.BSSID) ? Long.parseLong(scanResult.BSSID.replace(":", ""), 16) : 0L, (short) scanResult.level));
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.i(f344430a, 2, arrayList.toString());
                }
            }
            f344431b = (TelephonyManager) context.getSystemService("phone");
            c();
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            f344431b = telephonyManager;
            LocationMonitor.listen(telephonyManager, f344434e, 256);
            LocationMonitor.listen(f344431b, f344434e, 16);
            if (LocationMonitor.getCellLocation(f344431b) != null) {
                f344434e.onCellLocationChanged(LocationMonitor.getCellLocation(f344431b));
            }
            Attr attr = new Attr(DeviceInfoMonitor.getDeviceId(f344431b), DeviceInfoMonitor.getSubscriberId(f344431b), "");
            if (QLog.isColorLevel()) {
                QLog.i(f344430a, 2, attr.toString());
            }
            GPS gps = new GPS();
            f344432c = gps;
            return new LBSInfo(gps, arrayList, f344433d, attr);
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.e(f344430a, 2, th5.getMessage());
            }
            return new LBSInfo(new GPS(), arrayList, f344433d, null);
        }
    }

    private static void a(Cell cell) {
        ArrayList<Cell> arrayList;
        if (cell == null || (arrayList = f344433d) == null || arrayList.size() >= 3) {
            return;
        }
        for (int i3 = 0; i3 < f344433d.size(); i3++) {
            if (cell.iCellId == f344433d.get(i3).iCellId) {
                return;
            }
        }
        f344433d.add(cell);
    }
}
