package com.qzone.proxy.personalitycomponent.model;

import NS_MOBILE_WIDGET.FlowerWidgetInfo;
import android.content.ContentValues;
import android.database.Cursor;
import com.qzone.component.cache.database.a;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;

/* compiled from: P */
/* loaded from: classes39.dex */
public class WidgetCacheFlowerData extends a {
    public static final String CACHE_TIME = "cache_time";
    public static final IDBCacheDataWrapper.a<WidgetCacheFlowerData> DB_CREATOR = new IDBCacheDataWrapper.a<WidgetCacheFlowerData>() { // from class: com.qzone.proxy.personalitycomponent.model.WidgetCacheFlowerData.1
        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public String sortOrder() {
            return null;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public IDBCacheDataWrapper.c[] structure() {
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c(WidgetCacheFlowerData.SUNSHINE, "INTEGER"), new IDBCacheDataWrapper.c(WidgetCacheFlowerData.SUNSHINE_MAX, "INTEGER"), new IDBCacheDataWrapper.c(WidgetCacheFlowerData.WATER, "INTEGER"), new IDBCacheDataWrapper.c(WidgetCacheFlowerData.WATER_MAX, "INTEGER"), new IDBCacheDataWrapper.c("love", "INTEGER"), new IDBCacheDataWrapper.c(WidgetCacheFlowerData.LOVE_MAX, "INTEGER"), new IDBCacheDataWrapper.c(WidgetCacheFlowerData.NUTRITION, "INTEGER"), new IDBCacheDataWrapper.c(WidgetCacheFlowerData.NUTRITION_MAX, "INTEGER"), new IDBCacheDataWrapper.c("icon", "STRING"), new IDBCacheDataWrapper.c("cache_time", "INTEGER"), new IDBCacheDataWrapper.c("update_time", "INTEGER")};
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 1;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public WidgetCacheFlowerData createFromCursor(Cursor cursor) {
            WidgetCacheFlowerData widgetCacheFlowerData = new WidgetCacheFlowerData();
            widgetCacheFlowerData.sunshine = cursor.getInt(cursor.getColumnIndex(WidgetCacheFlowerData.SUNSHINE));
            widgetCacheFlowerData.sunshineMax = cursor.getInt(cursor.getColumnIndex(WidgetCacheFlowerData.SUNSHINE_MAX));
            widgetCacheFlowerData.water = cursor.getInt(cursor.getColumnIndex(WidgetCacheFlowerData.WATER));
            widgetCacheFlowerData.waterMax = cursor.getInt(cursor.getColumnIndex(WidgetCacheFlowerData.WATER_MAX));
            widgetCacheFlowerData.love = cursor.getInt(cursor.getColumnIndex("love"));
            widgetCacheFlowerData.loveMax = cursor.getInt(cursor.getColumnIndex(WidgetCacheFlowerData.LOVE_MAX));
            widgetCacheFlowerData.nutrition = cursor.getInt(cursor.getColumnIndex(WidgetCacheFlowerData.NUTRITION));
            widgetCacheFlowerData.nutritionMax = cursor.getInt(cursor.getColumnIndex(WidgetCacheFlowerData.NUTRITION_MAX));
            widgetCacheFlowerData.icon = cursor.getString(cursor.getColumnIndex("icon"));
            widgetCacheFlowerData.cachetime = cursor.getInt(cursor.getColumnIndex("cache_time"));
            widgetCacheFlowerData.updatetime = cursor.getInt(cursor.getColumnIndex("update_time"));
            return widgetCacheFlowerData;
        }
    };
    public static final String ICON = "icon";
    public static final String LOVE = "love";
    public static final String LOVE_MAX = "love_max";
    public static final String NUTRITION = "nutrition";
    public static final String NUTRITION_MAX = "nutrition_max";
    public static final String SUNSHINE = "sunshine";
    public static final String SUNSHINE_MAX = "sunshine_max";
    public static final String TYPE_CACHE_TIME = "INTEGER";
    public static final String TYPE_ICON = "STRING";
    public static final String TYPE_LOVE = "INTEGER";
    public static final String TYPE_LOVE_MAX = "INTEGER";
    public static final String TYPE_NUTRITION = "INTEGER";
    public static final String TYPE_NUTRITION_MAX = "INTEGER";
    public static final String TYPE_SUNSHINE = "INTEGER";
    public static final String TYPE_SUNSHINE_MAX = "INTEGER";
    public static final String TYPE_UPDATE_TIME = "INTEGER";
    public static final String TYPE_WATER = "INTEGER";
    public static final String TYPE_WATER_MAX = "INTEGER";
    public static final String UPDATE_TIME = "update_time";
    public static final int VERSION = 1;
    public static final String WATER = "water";
    public static final String WATER_MAX = "water_max";
    public String icon;
    public int love;
    public int loveMax;
    public int nutrition;
    public int nutritionMax;
    public int sunshine;
    public int sunshineMax;
    public int water;
    public int waterMax;
    public int cachetime = 0;
    public int updatetime = 0;

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        contentValues.put(SUNSHINE, Integer.valueOf(this.sunshine));
        contentValues.put(SUNSHINE_MAX, Integer.valueOf(this.sunshineMax));
        contentValues.put(WATER, Integer.valueOf(this.water));
        contentValues.put(WATER_MAX, Integer.valueOf(this.waterMax));
        contentValues.put("love", Integer.valueOf(this.love));
        contentValues.put(LOVE_MAX, Integer.valueOf(this.loveMax));
        contentValues.put(NUTRITION, Integer.valueOf(this.nutrition));
        contentValues.put(NUTRITION_MAX, Integer.valueOf(this.nutritionMax));
        contentValues.put("icon", this.icon);
        contentValues.put("cache_time", Integer.valueOf(this.cachetime));
        contentValues.put("update_time", Integer.valueOf(this.updatetime));
    }

    public static WidgetFlowerData convertToBusinessData(WidgetCacheFlowerData widgetCacheFlowerData) {
        if (widgetCacheFlowerData == null) {
            return null;
        }
        WidgetFlowerData widgetFlowerData = new WidgetFlowerData();
        widgetFlowerData.sunshine = widgetCacheFlowerData.sunshine;
        widgetFlowerData.sunshineMax = widgetCacheFlowerData.sunshineMax;
        widgetFlowerData.water = widgetCacheFlowerData.water;
        widgetFlowerData.waterMax = widgetCacheFlowerData.waterMax;
        widgetFlowerData.love = widgetCacheFlowerData.love;
        widgetFlowerData.loveMax = widgetCacheFlowerData.loveMax;
        widgetFlowerData.nutrition = widgetCacheFlowerData.nutrition;
        widgetFlowerData.nutritionMax = widgetCacheFlowerData.nutritionMax;
        widgetFlowerData.icon = widgetCacheFlowerData.icon;
        widgetFlowerData.cachetime = widgetCacheFlowerData.cachetime;
        widgetFlowerData.updatetime = widgetCacheFlowerData.updatetime;
        return widgetFlowerData;
    }

    public static WidgetCacheFlowerData createFromBusinessData(WidgetFlowerData widgetFlowerData) {
        if (widgetFlowerData == null) {
            return null;
        }
        WidgetCacheFlowerData widgetCacheFlowerData = new WidgetCacheFlowerData();
        widgetCacheFlowerData.sunshine = widgetFlowerData.sunshine;
        widgetCacheFlowerData.sunshineMax = widgetFlowerData.sunshineMax;
        widgetCacheFlowerData.water = widgetFlowerData.water;
        widgetCacheFlowerData.waterMax = widgetFlowerData.waterMax;
        widgetCacheFlowerData.love = widgetFlowerData.love;
        widgetCacheFlowerData.loveMax = widgetFlowerData.loveMax;
        widgetCacheFlowerData.nutrition = widgetFlowerData.nutrition;
        widgetCacheFlowerData.nutritionMax = widgetFlowerData.nutritionMax;
        widgetCacheFlowerData.icon = widgetFlowerData.icon;
        widgetCacheFlowerData.cachetime = widgetFlowerData.cachetime;
        widgetCacheFlowerData.updatetime = widgetFlowerData.updatetime;
        return widgetCacheFlowerData;
    }

    public static WidgetFlowerData createFromResponse(FlowerWidgetInfo flowerWidgetInfo) {
        if (flowerWidgetInfo == null) {
            return null;
        }
        WidgetFlowerData widgetFlowerData = new WidgetFlowerData();
        widgetFlowerData.sunshine = flowerWidgetInfo.sun;
        widgetFlowerData.sunshineMax = flowerWidgetInfo.sunmax;
        widgetFlowerData.water = flowerWidgetInfo.rain;
        widgetFlowerData.waterMax = flowerWidgetInfo.rainmax;
        widgetFlowerData.love = flowerWidgetInfo.love;
        widgetFlowerData.loveMax = flowerWidgetInfo.lovemax;
        widgetFlowerData.nutrition = flowerWidgetInfo.nutri;
        widgetFlowerData.nutritionMax = flowerWidgetInfo.nutrimax;
        widgetFlowerData.icon = flowerWidgetInfo.flowerpicurl;
        widgetFlowerData.cachetime = 0;
        widgetFlowerData.updatetime = (int) (System.currentTimeMillis() / 1000);
        return widgetFlowerData;
    }
}
