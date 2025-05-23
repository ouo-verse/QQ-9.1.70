package k5;

import LBS_V2_PROTOCOL.Cell_V2;
import LBS_V2_PROTOCOL.GPS_V2;
import LBS_V2_PROTOCOL.Wifi_V2;
import com.tencent.mobileqq.soso.location.data.SosoCell;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.soso.location.data.SosoWifi;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b {
    public static ArrayList<Cell_V2> d(ArrayList<SosoCell> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        ArrayList<Cell_V2> arrayList2 = new ArrayList<>();
        Iterator<SosoCell> it = arrayList.iterator();
        while (it.hasNext()) {
            SosoCell next = it.next();
            if (next != null) {
                arrayList2.add(a(next));
            }
        }
        return arrayList2;
    }

    public static ArrayList<Wifi_V2> e(ArrayList<SosoWifi> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        ArrayList<Wifi_V2> arrayList2 = new ArrayList<>();
        Iterator<SosoWifi> it = arrayList.iterator();
        while (it.hasNext()) {
            SosoWifi next = it.next();
            if (next != null) {
                arrayList2.add(c(next));
            }
        }
        return arrayList2;
    }

    public static Cell_V2 a(SosoCell sosoCell) {
        if (sosoCell == null) {
            return null;
        }
        Cell_V2 cell_V2 = new Cell_V2();
        cell_V2.iLac = sosoCell.mLac;
        cell_V2.iRssi = sosoCell.mRss;
        cell_V2.iCellId = sosoCell.mCellId;
        cell_V2.shMcc = (short) sosoCell.mMcc;
        cell_V2.shMnc = (short) sosoCell.mMnc;
        return cell_V2;
    }

    public static GPS_V2 b(SosoLocation sosoLocation) {
        if (sosoLocation == null) {
            return null;
        }
        GPS_V2 gps_v2 = new GPS_V2();
        gps_v2.iAlt = (int) sosoLocation.altitude;
        double d16 = sosoLocation.mLon84;
        if (d16 == 0.0d && sosoLocation.mLat84 == 0.0d) {
            gps_v2.eType = 1;
            gps_v2.iLat = (int) (sosoLocation.mLat02 * 1000000.0d);
            gps_v2.iLon = (int) (sosoLocation.mLon02 * 1000000.0d);
        } else {
            gps_v2.eType = 0;
            gps_v2.iLat = (int) (sosoLocation.mLat84 * 1000000.0d);
            gps_v2.iLon = (int) (d16 * 1000000.0d);
        }
        return gps_v2;
    }

    public static Wifi_V2 c(SosoWifi sosoWifi) {
        if (sosoWifi == null) {
            return null;
        }
        Wifi_V2 wifi_V2 = new Wifi_V2();
        wifi_V2.iRssi = sosoWifi.mRssi;
        wifi_V2.strMac = sosoWifi.mMacStr;
        return wifi_V2;
    }
}
