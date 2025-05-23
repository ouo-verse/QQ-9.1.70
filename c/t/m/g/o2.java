package c.t.m.g;

import android.net.wifi.ScanResult;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public class o2 {
    public static boolean a(List<ScanResult> list, List<ScanResult> list2) {
        boolean z16 = false;
        if (list != null && list2 != null) {
            int size = list.size();
            int size2 = list2.size();
            if (size == 0 && size2 == 0) {
                return true;
            }
            if (size != 0 && size2 != 0) {
                if (list.size() > list2.size()) {
                    list2 = list;
                    list = list2;
                }
                int i3 = 0;
                int i16 = 0;
                int i17 = 1;
                for (ScanResult scanResult : list) {
                    Iterator<ScanResult> it = list2.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        if (it.next().BSSID.equals(scanResult.BSSID)) {
                            if (i17 == 1 && scanResult.level > -50) {
                                i3++;
                            }
                            if (i17 == 2 && scanResult.level > -60) {
                                i3++;
                            }
                            if (i17 == 3 && scanResult.level > -60) {
                                i3++;
                            }
                            i16++;
                        }
                    }
                    i17++;
                }
                if (i3 == 3) {
                    o3.b("TxWifiChange", "big 3 is similar");
                    return false;
                }
                int i18 = size2 + size;
                if (i16 * 2 < i18 * 0.85d || i16 < 13) {
                    z16 = true;
                }
                o3.b("TxWifiChange", "isDiffrent:c=" + size + ",k=" + i16 + ",f=" + i18 + ",r=0.85,s=" + z16);
            }
        }
        return z16;
    }
}
