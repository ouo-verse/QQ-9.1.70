package com.tencent.weiyun.poi;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.weiyun.data.PoiItem;
import com.tencent.weiyun.utils.IOUtils;
import com.tencent.weiyun.utils.WyLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes27.dex */
public final class PoiHelper {
    static IPatchRedirector $redirector_ = null;
    private static final String[] PROJ_ALL;
    private static final String[] PROJ_KEY;
    private static final int SINGLE_QUERY_LIMIT = 200;
    private static final String TAG = "PoiHelper";

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11121);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            PROJ_KEY = new String[]{"longitude", "latitude"};
            PROJ_ALL = new String[]{"longitude", "latitude", PoiDbManager.COL_POI_NATION_TYPE, PoiDbManager.COL_POI_NATION_NAME, PoiDbManager.COL_POI_CITY_ID, "city_name", PoiDbManager.COL_POI_POI_ID, "poi_name", "address"};
        }
    }

    PoiHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String generateKey(double d16, double d17) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(d16);
        sb5.append(',');
        sb5.append(d17);
        return sb5.toString();
    }

    public static void insertPoi(List<PoiItem> list) {
        if (list != null && !list.isEmpty()) {
            PoiDbWrapper openPoiDb = PoiDbManager.getInstance().openPoiDb(true);
            if (openPoiDb == null) {
                WyLog.e(TAG, "insertPoi: Job db is null.");
                return;
            }
            openPoiDb.beginTransaction();
            for (PoiItem poiItem : list) {
                if (poiItem != null && (!TextUtils.isEmpty(poiItem.poiId) || !TextUtils.isEmpty(poiItem.poiName))) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("longitude", Double.valueOf(poiItem.longitude));
                    contentValues.put("latitude", Double.valueOf(poiItem.latitude));
                    contentValues.put(PoiDbManager.COL_POI_NATION_TYPE, Integer.valueOf(poiItem.nationType));
                    contentValues.put(PoiDbManager.COL_POI_NATION_NAME, poiItem.nationName);
                    contentValues.put(PoiDbManager.COL_POI_CITY_ID, Integer.valueOf(poiItem.cityId));
                    contentValues.put("city_name", poiItem.cityName);
                    contentValues.put(PoiDbManager.COL_POI_POI_ID, poiItem.poiId);
                    contentValues.put("poi_name", poiItem.poiName);
                    contentValues.put("address", poiItem.address);
                    openPoiDb.insert(PoiDbManager.TBL_POI, null, contentValues);
                }
            }
            openPoiDb.setTransactionSuccessful();
            openPoiDb.endTransaction();
            PoiDbManager.getInstance().closePoiDb(openPoiDb);
        }
    }

    public static List<PoiItem> queryPoi(List<PoiItem> list) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            PoiDbWrapper openPoiDb = PoiDbManager.getInstance().openPoiDb(false);
            if (openPoiDb == null) {
                WyLog.e(TAG, "queryPoi: Poi db is null.");
            } else {
                PoiItem poiItem = list.get(0);
                double d16 = poiItem.longitude;
                double d17 = poiItem.latitude;
                double d18 = d16;
                double d19 = d17;
                for (PoiItem poiItem2 : list) {
                    double d26 = poiItem2.longitude;
                    if (d26 < d16) {
                        d16 = d26;
                    }
                    if (d26 > d18) {
                        d18 = d26;
                    }
                    double d27 = poiItem2.latitude;
                    if (d27 < d17) {
                        d17 = d27;
                    }
                    if (d27 > d19) {
                        d19 = d27;
                    }
                }
                double d28 = d16;
                double d29 = d17;
                boolean z16 = true;
                while (z16) {
                    List<PoiItem> singleQuery = singleQuery(openPoiDb, d28, d18, d29, d19);
                    if (singleQuery != null && singleQuery.size() >= 200) {
                        PoiItem poiItem3 = singleQuery.get(singleQuery.size() - 1);
                        double d36 = poiItem3.longitude;
                        if (d36 > d28) {
                            d28 = d36;
                        }
                        if (d36 == d18) {
                            d29 = poiItem3.latitude;
                        }
                    } else {
                        z16 = false;
                    }
                    if (singleQuery != null && !singleQuery.isEmpty()) {
                        singleQuery.retainAll(list);
                        arrayList.addAll(singleQuery);
                        list.removeAll(singleQuery);
                        if (list.isEmpty()) {
                            z16 = false;
                        }
                    }
                }
                PoiDbManager.getInstance().closePoiDb(openPoiDb);
            }
            return arrayList;
        }
        return null;
    }

    public static HashSet<String> queryPoiKeys() {
        HashSet<String> hashSet = new HashSet<>();
        PoiDbWrapper openPoiDb = PoiDbManager.getInstance().openPoiDb(false);
        if (openPoiDb == null) {
            WyLog.e(TAG, "queryPoiKeys: Poi db is null.");
        } else {
            Cursor cursor = null;
            try {
                cursor = openPoiDb.query(PoiDbManager.TBL_POI, PROJ_KEY, null, null, null, null, null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        hashSet.add(generateKey(cursor.getDouble(0), cursor.getDouble(1)));
                    }
                }
            } finally {
                try {
                    IOUtils.closeSilently(cursor);
                    PoiDbManager.getInstance().closePoiDb(openPoiDb);
                } catch (Throwable th5) {
                }
            }
            IOUtils.closeSilently(cursor);
            PoiDbManager.getInstance().closePoiDb(openPoiDb);
        }
        return hashSet;
    }

    private static List<PoiItem> singleQuery(PoiDbWrapper poiDbWrapper, double d16, double d17, double d18, double d19) {
        ArrayList arrayList;
        Cursor cursor = null;
        ArrayList arrayList2 = null;
        try {
            Cursor query = poiDbWrapper.query(PoiDbManager.TBL_POI, PROJ_ALL, "longitude between ? and ? and latitude between ? and ? ", new String[]{Double.toString(d16), Double.toString(d17), Double.toString(d18), Double.toString(d19)}, null, null, "longitude,latitude ASC LIMIT 200");
            if (query != null) {
                try {
                    arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        try {
                            PoiItem createGpsInfo = PoiItem.createGpsInfo(query.getDouble(0), query.getDouble(1));
                            createGpsInfo.nationType = query.getInt(2);
                            createGpsInfo.nationName = query.getString(3);
                            createGpsInfo.cityId = query.getInt(4);
                            createGpsInfo.cityName = query.getString(5);
                            createGpsInfo.poiId = query.getString(6);
                            createGpsInfo.poiName = query.getString(7);
                            createGpsInfo.address = query.getString(8);
                            arrayList.add(createGpsInfo);
                        } catch (Throwable th5) {
                            th = th5;
                            cursor = query;
                            try {
                                WyLog.e(TAG, th);
                                IOUtils.closeSilently(cursor);
                                return arrayList;
                            } catch (Throwable th6) {
                                IOUtils.closeSilently(cursor);
                                throw th6;
                            }
                        }
                    }
                    arrayList2 = arrayList;
                } catch (Throwable th7) {
                    th = th7;
                    arrayList = null;
                }
            }
            IOUtils.closeSilently(query);
            return arrayList2;
        } catch (Throwable th8) {
            th = th8;
            arrayList = null;
        }
    }

    public static int updatePoi(PoiItem poiItem) {
        if (poiItem == null || (TextUtils.isEmpty(poiItem.poiId) && TextUtils.isEmpty(poiItem.poiName))) {
            return 0;
        }
        PoiDbWrapper openPoiDb = PoiDbManager.getInstance().openPoiDb(true);
        if (openPoiDb == null) {
            WyLog.e(TAG, "updatePoi: Poi db is null.");
            return 0;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("longitude", Double.valueOf(poiItem.longitude));
        contentValues.put("latitude", Double.valueOf(poiItem.latitude));
        contentValues.put(PoiDbManager.COL_POI_NATION_TYPE, Integer.valueOf(poiItem.nationType));
        contentValues.put(PoiDbManager.COL_POI_NATION_NAME, poiItem.nationName);
        contentValues.put(PoiDbManager.COL_POI_CITY_ID, Integer.valueOf(poiItem.cityId));
        contentValues.put("city_name", poiItem.cityName);
        contentValues.put(PoiDbManager.COL_POI_POI_ID, poiItem.poiId);
        contentValues.put("poi_name", poiItem.poiName);
        contentValues.put("address", poiItem.address);
        String[] strArr = {Double.toString(poiItem.longitude), Double.toString(poiItem.latitude)};
        openPoiDb.beginTransaction();
        int update = openPoiDb.update(PoiDbManager.TBL_POI, contentValues, "longitude=? AND latitude=?", strArr);
        openPoiDb.setTransactionSuccessful();
        openPoiDb.endTransaction();
        PoiDbManager.getInstance().closePoiDb(openPoiDb);
        return update;
    }
}
