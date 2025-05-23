package k5;

import FileUpload.stPoi;
import common.config.service.QzoneConfig;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.model.GpsInfo4LocalImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a {
    public static long a(int i3) {
        return i3 * 86400000;
    }

    public static int c() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_POI_CACHE_TIME, 7);
    }

    public static double h(double d16) {
        return (d16 * 3.141592653589793d) / 180.0d;
    }

    public static boolean g(LbsDataV2.GpsInfo gpsInfo) {
        return gpsInfo != null && gpsInfo.isValid();
    }

    public static stPoi d(LbsDataV2.PoiInfo poiInfo) {
        if (poiInfo == null) {
            return null;
        }
        stPoi stpoi = new stPoi();
        if (poiInfo.gpsInfo != null) {
            stpoi.poi_x = String.valueOf(r1.lon / 1000000.0d);
            stpoi.poi_y = String.valueOf(poiInfo.gpsInfo.lat / 1000000.0d);
        }
        String str = poiInfo.poiName;
        stpoi.poi_name = str;
        String str2 = poiInfo.address;
        stpoi.poi_address = str2;
        String str3 = poiInfo.poiId;
        stpoi.poi_id = str3;
        stpoi.show_poi = poiInfo.show_poi;
        if (str == null) {
            stpoi.poi_name = "";
        }
        if (str2 == null) {
            stpoi.poi_address = "";
        }
        if (str3 == null) {
            stpoi.poi_id = "";
        }
        return stpoi;
    }

    public static LbsDataV2.GpsInfo e(GpsInfo4LocalImage gpsInfo4LocalImage) {
        if (gpsInfo4LocalImage == null) {
            return null;
        }
        LbsDataV2.GpsInfo gpsInfo = new LbsDataV2.GpsInfo();
        gpsInfo.gpsType = 0;
        gpsInfo.alt = 0;
        gpsInfo.lat = (int) (gpsInfo4LocalImage.latitude * 1000000.0f);
        gpsInfo.lon = (int) (gpsInfo4LocalImage.longtitude * 1000000.0f);
        return gpsInfo;
    }

    public static ArrayList<LbsDataV2.GpsInfo> f(List<GpsInfo4LocalImage> list) {
        if (list == null) {
            return null;
        }
        ArrayList<LbsDataV2.GpsInfo> arrayList = new ArrayList<>(list.size());
        Iterator<GpsInfo4LocalImage> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(e(it.next()));
        }
        return arrayList;
    }

    public static double b(double d16, double d17, double d18, double d19) {
        double h16 = h(d16 / 1000000.0d);
        double h17 = h(d18 / 1000000.0d);
        return Math.asin(Math.sqrt(Math.pow(Math.sin((h16 - h17) / 2.0d), 2.0d) + (Math.cos(h16) * Math.cos(h17) * Math.pow(Math.sin((h(d17 / 1000000.0d) - h(d19 / 1000000.0d)) / 2.0d), 2.0d)))) * 2.0d * 6378.137d * 1000.0d;
    }
}
