package com.qzone.proxy.personalitycomponent.model;

import NS_MOBILE_WIDGET.GetWidgetRsp;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import com.qzone.component.cache.database.a;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import com.qzone.proxy.feedcomponent.util.j;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import cooperation.vip.b;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes39.dex */
public class WidgetPublicCacheData extends a {
    public static final String CACHE_TIME = "cache_time";
    public static final String COLUMN_MAP_DATA = "map_data";
    public static final String COLUMN_TMP_URL = "tmp_url";
    public static final String COLUMN_WIDGET_ID = "widget_id";
    public static IDBCacheDataWrapper.a<WidgetPublicCacheData> DB_CREATOR = new IDBCacheDataWrapper.a<WidgetPublicCacheData>() { // from class: com.qzone.proxy.personalitycomponent.model.WidgetPublicCacheData.1
        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public String sortOrder() {
            return null;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public IDBCacheDataWrapper.c[] structure() {
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c(WidgetPublicCacheData.COLUMN_WIDGET_ID, "INTEGER"), new IDBCacheDataWrapper.c(WidgetPublicCacheData.COLUMN_TMP_URL, "STRING"), new IDBCacheDataWrapper.c(WidgetPublicCacheData.COLUMN_MAP_DATA, "BLOB"), new IDBCacheDataWrapper.c("cache_time", "INTEGER"), new IDBCacheDataWrapper.c("update_time", "INTEGER")};
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 1;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public WidgetPublicCacheData createFromCursor(Cursor cursor) {
            WidgetPublicCacheData widgetPublicCacheData = new WidgetPublicCacheData();
            widgetPublicCacheData.widgetId = cursor.getInt(cursor.getColumnIndex(WidgetPublicCacheData.COLUMN_WIDGET_ID));
            widgetPublicCacheData.tmpUrl = cursor.getString(cursor.getColumnIndex(WidgetPublicCacheData.COLUMN_TMP_URL));
            Parcel obtain = Parcel.obtain();
            try {
                try {
                    byte[] blob = cursor.getBlob(cursor.getColumnIndex(WidgetPublicCacheData.COLUMN_MAP_DATA));
                    if (blob != null) {
                        obtain.unmarshall(blob, 0, blob.length);
                        obtain.setDataPosition(0);
                        widgetPublicCacheData.dataMap = ParcelableWrapper.readHashMap(obtain, ParcelableWrapper.class.getClassLoader());
                    }
                } catch (Exception e16) {
                    j.d("WidgetPublicCacheData", "Exception", e16);
                }
                widgetPublicCacheData.cachetime = cursor.getInt(cursor.getColumnIndex("cache_time"));
                widgetPublicCacheData.updatetime = cursor.getInt(cursor.getColumnIndex("update_time"));
                return widgetPublicCacheData;
            } finally {
                OaidMonitor.parcelRecycle(obtain);
            }
        }
    };
    public static final int DB_VERSION = 1;
    public static final String TYPE_CACHE_TIME = "INTEGER";
    public static final String TYPE_MAP_DATA = "BLOB";
    public static final String TYPE_TMP_URL = "STRING";
    public static final String TYPE_UPDATE_TIME = "INTEGER";
    public static final String TYPE_WIDGET_ID = "INTEGER";
    public static final String UPDATE_TIME = "update_time";
    public Map<String, Object> dataMap;
    public String tmpUrl;
    public int widgetId;
    public int cachetime = 0;
    public int updatetime = 0;

    public String toString() {
        if (this.dataMap != null) {
            return "widgetId = " + this.widgetId + " dataMap = " + this.dataMap.toString();
        }
        return "widgetId = " + this.widgetId + " dataMap = null";
    }

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        contentValues.put(COLUMN_WIDGET_ID, Integer.valueOf(this.widgetId));
        contentValues.put(COLUMN_TMP_URL, this.tmpUrl);
        Parcel obtain = Parcel.obtain();
        ParcelableWrapper.writeMap(obtain, new HashMap(this.dataMap));
        byte[] marshall = obtain.marshall();
        OaidMonitor.parcelRecycle(obtain);
        contentValues.put(COLUMN_MAP_DATA, marshall);
        contentValues.put("cache_time", Integer.valueOf(this.cachetime));
        contentValues.put("update_time", Integer.valueOf(this.updatetime));
    }

    public static WidgetPublicCacheData createFromResponse(GetWidgetRsp getWidgetRsp) {
        if (getWidgetRsp == null) {
            return null;
        }
        WidgetPublicCacheData widgetPublicCacheData = new WidgetPublicCacheData();
        widgetPublicCacheData.tmpUrl = getWidgetRsp.tmp_url;
        widgetPublicCacheData.widgetId = getWidgetRsp.stored_widget_id;
        widgetPublicCacheData.dataMap = b.c(getWidgetRsp.tmp_data_json);
        widgetPublicCacheData.cachetime = getWidgetRsp.expire;
        widgetPublicCacheData.updatetime = (int) (System.currentTimeMillis() / 1000);
        return widgetPublicCacheData;
    }
}
