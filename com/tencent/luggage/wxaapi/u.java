package com.tencent.luggage.wxaapi;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes9.dex */
public class u {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x022b, code lost:
    
        if (r10.equals("getInstalledApplications") == false) goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0100, code lost:
    
        if (r10.equals("getConfiguredNetworks") == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0138, code lost:
    
        if (r10.equals("getInstalledApplications") == false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01bb, code lost:
    
        if (r10.equals("getDeviceId") == false) goto L78;
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object a(@NonNull String str, @NonNull String str2, @Nullable Object obj, @Nullable Object[] objArr, @NonNull boolean[] zArr) {
        zArr[0] = false;
        String canonicalName = obj.getClass().getCanonicalName();
        canonicalName.hashCode();
        if (canonicalName.equals("android.bluetooth.BluetoothAdapter")) {
            str.hashCode();
            if (str.equals("startLeScan") || str.equals("startDiscovery")) {
                return null;
            }
            throw new IllegalArgumentException(String.format("not implemented method [%s]", str));
        }
        if (canonicalName.equals("android.provider.Settings$Secure")) {
            str.hashCode();
            if (str.equals("getString")) {
                return null;
            }
            throw new IllegalArgumentException(String.format("not implemented method [%s]", str));
        }
        if (canonicalName.equals("android.provider.Settings$System")) {
            str.hashCode();
            if (str.equals("getString")) {
                return null;
            }
            throw new IllegalArgumentException(String.format("not implemented method [%s]", str));
        }
        if (canonicalName.equals("java.net.NetworkInterface")) {
            str.hashCode();
            if (str.equals("getHardwareAddress")) {
                return null;
            }
            throw new IllegalArgumentException(String.format("not implemented method [%s]", str));
        }
        char c16 = 2;
        if (canonicalName.equals("android.content.pm.PackageManager")) {
            str.hashCode();
            switch (str.hashCode()) {
                case -150905391:
                    if (str.equals("getInstalledPackages")) {
                        c16 = 0;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 1374193809:
                    if (str.equals("queryIntentActivities")) {
                        c16 = 1;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 1600494599:
                    break;
                default:
                    c16 = '\uffff';
                    break;
            }
            switch (c16) {
                case 0:
                case 1:
                case 2:
                    return null;
                default:
                    throw new IllegalArgumentException(String.format("not implemented method [%s]", str));
            }
        }
        if (canonicalName.equals("android.bluetooth.le.BluetoothLeScanner")) {
            str.hashCode();
            if (str.equals("startScan")) {
                return null;
            }
            throw new IllegalArgumentException(String.format("not implemented method [%s]", str));
        }
        if (canonicalName.equals("android.hardware.SystemSensorManager")) {
            str.hashCode();
            if (str.equals("getDefaultSensor")) {
                return null;
            }
            throw new IllegalArgumentException(String.format("not implemented method [%s]", str));
        }
        if (canonicalName.equals("android.telephony.TelephonyManager")) {
            str.hashCode();
            switch (str.hashCode()) {
                case -2105682274:
                    if (str.equals("getSimSerialNumber")) {
                        c16 = 0;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -1384328005:
                    if (str.equals("getAllCellInfo")) {
                        c16 = 1;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -1107875961:
                    break;
                case -1102508601:
                    if (str.equals("listen")) {
                        c16 = 3;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -75445954:
                    if (str.equals("getImei")) {
                        c16 = 4;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -75334359:
                    if (str.equals("getMeid")) {
                        c16 = 5;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 702848429:
                    if (str.equals("getCellLocation")) {
                        c16 = 6;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 964598576:
                    if (str.equals("getLine1Number")) {
                        c16 = 7;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 1954344473:
                    if (str.equals("getSubscriberId")) {
                        c16 = '\b';
                        break;
                    }
                    c16 = '\uffff';
                    break;
                default:
                    c16 = '\uffff';
                    break;
            }
            switch (c16) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case '\b':
                    return null;
                default:
                    throw new IllegalArgumentException(String.format("not implemented method [%s]", str));
            }
        }
        if (canonicalName.equals("android.app.ApplicationPackageManager")) {
            str.hashCode();
            switch (str.hashCode()) {
                case -150905391:
                    if (str.equals("getInstalledPackages")) {
                        c16 = 0;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 1374193809:
                    if (str.equals("queryIntentActivities")) {
                        c16 = 1;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 1600494599:
                    break;
                default:
                    c16 = '\uffff';
                    break;
            }
            switch (c16) {
                case 0:
                case 1:
                case 2:
                    return null;
                default:
                    throw new IllegalArgumentException(String.format("not implemented method [%s]", str));
            }
        }
        if (!canonicalName.equals("android.net.wifi.WifiManager")) {
            if (canonicalName.equals("android.net.wifi.WifiInfo")) {
                str.hashCode();
                if (str.equals("getMacAddress")) {
                    return null;
                }
                throw new IllegalArgumentException(String.format("not implemented method [%s]", str));
            }
            if (canonicalName.equals("java.lang.Runtime")) {
                str.hashCode();
                if (str.equals("exec")) {
                    return null;
                }
                throw new IllegalArgumentException(String.format("not implemented method [%s]", str));
            }
            throw new IllegalArgumentException(String.format("not implemented class [%s]", obj.getClass().getCanonicalName()));
        }
        str.hashCode();
        switch (str.hashCode()) {
            case -2129330689:
                if (str.equals("startScan")) {
                    c16 = 0;
                    break;
                }
                c16 = '\uffff';
                break;
            case -1437827709:
                if (str.equals("getScanResults")) {
                    c16 = 1;
                    break;
                }
                c16 = '\uffff';
                break;
            case -703033767:
                break;
            case 977831330:
                if (str.equals("getConnectionInfo")) {
                    c16 = 3;
                    break;
                }
                c16 = '\uffff';
                break;
            default:
                c16 = '\uffff';
                break;
        }
        switch (c16) {
            case 0:
            case 1:
            case 2:
            case 3:
                return null;
            default:
                throw new IllegalArgumentException(String.format("not implemented method [%s]", str));
        }
    }
}
