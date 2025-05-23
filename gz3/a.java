package gz3;

import cooperation.qzone.LbsDataV2;
import cooperation.qzone.model.GpsInfo4LocalImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a {
    public static LbsDataV2.GpsInfo a(GpsInfo4LocalImage gpsInfo4LocalImage) {
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

    public static ArrayList<LbsDataV2.GpsInfo> b(List<GpsInfo4LocalImage> list) {
        if (list == null) {
            return null;
        }
        ArrayList<LbsDataV2.GpsInfo> arrayList = new ArrayList<>(list.size());
        Iterator<GpsInfo4LocalImage> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(a(it.next()));
        }
        return arrayList;
    }
}
