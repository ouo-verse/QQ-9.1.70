package com.tencent.weiyun.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.weiyun.poi.PoiDbManager;

/* loaded from: classes27.dex */
public class PoiItem extends CNativeObject {
    static IPatchRedirector $redirector_ = null;
    public static final int NATION_TYPE_DOMESTIC = 1;
    public static final int NATION_TYPE_FOREIGN = 2;
    public String address;
    public int cityId;
    public String cityName;
    public double latitude;
    public double longitude;
    public String nationName;
    public int nationType;
    public String poiId;
    public String poiName;

    PoiItem() {
        super(0L);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public static PoiItem createGpsInfo(double d16, double d17) {
        PoiItem poiItem = new PoiItem();
        poiItem.longitude = d16;
        poiItem.latitude = d17;
        return poiItem;
    }

    public static PoiItem newInstance(long j3) {
        if (j3 == 0) {
            return null;
        }
        PoiItem poiItem = new PoiItem(j3);
        poiItem.longitude = CBundleReader.getDouble(j3, "longitude", 0.0d);
        poiItem.latitude = CBundleReader.getDouble(j3, "latitude", 0.0d);
        poiItem.nationName = CBundleReader.getString(j3, PoiDbManager.COL_POI_NATION_NAME);
        poiItem.cityName = CBundleReader.getString(j3, "city_name");
        poiItem.poiId = CBundleReader.getString(j3, PoiDbManager.COL_POI_POI_ID);
        poiItem.poiName = CBundleReader.getString(j3, "name");
        poiItem.address = CBundleReader.getString(j3, "addr");
        poiItem.releaseNative();
        return poiItem;
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, obj)).booleanValue();
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PoiItem)) {
            return false;
        }
        PoiItem poiItem = (PoiItem) obj;
        if (Double.compare(poiItem.longitude, this.longitude) == 0 && Double.compare(poiItem.latitude, this.latitude) == 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        long doubleToLongBits = Double.doubleToLongBits(this.longitude);
        int i3 = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
        long doubleToLongBits2 = Double.doubleToLongBits(this.latitude);
        return (i3 * 31) + ((int) ((doubleToLongBits2 >>> 32) ^ doubleToLongBits2));
    }

    @Override // com.tencent.weiyun.data.CNativeObject
    public /* bridge */ /* synthetic */ void releaseNative() {
        super.releaseNative();
    }

    PoiItem(long j3) {
        super(j3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, j3);
    }
}
