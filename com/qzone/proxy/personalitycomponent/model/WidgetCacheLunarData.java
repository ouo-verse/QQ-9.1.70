package com.qzone.proxy.personalitycomponent.model;

import NS_MOBILE_WIDGET.LunarWidgetInfo;
import android.content.ContentValues;
import android.database.Cursor;
import com.qzone.component.cache.database.a;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;

/* compiled from: P */
/* loaded from: classes39.dex */
public class WidgetCacheLunarData extends a {
    public static final String ANIMAL = "animal";
    public static final String CACHETIME = "cachetime";
    public static final String CHENG = "cheng";
    public static final String CHONG = "chong";
    public static final IDBCacheDataWrapper.a<WidgetCacheLunarData> DB_CREATOR = new IDBCacheDataWrapper.a<WidgetCacheLunarData>() { // from class: com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData.1
        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public String sortOrder() {
            return null;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public IDBCacheDataWrapper.c[] structure() {
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c(WidgetCacheLunarData.ANIMAL, "INTEGER"), new IDBCacheDataWrapper.c(WidgetCacheLunarData.LUNAR_M, "TEXT"), new IDBCacheDataWrapper.c(WidgetCacheLunarData.LUNAR_D, "TEXT"), new IDBCacheDataWrapper.c(WidgetCacheLunarData.LUNAR_EX, "TEXT"), new IDBCacheDataWrapper.c(WidgetCacheLunarData.SOLAR, "TEXT"), new IDBCacheDataWrapper.c(WidgetCacheLunarData.WEEK, "TEXT"), new IDBCacheDataWrapper.c(WidgetCacheLunarData.YI, "TEXT"), new IDBCacheDataWrapper.c(WidgetCacheLunarData.JI, "TEXT"), new IDBCacheDataWrapper.c(WidgetCacheLunarData.YI_EX, "TEXT"), new IDBCacheDataWrapper.c(WidgetCacheLunarData.JI_EX, "TEXT"), new IDBCacheDataWrapper.c(WidgetCacheLunarData.CHONG, "TEXT"), new IDBCacheDataWrapper.c(WidgetCacheLunarData.SHA, "TEXT"), new IDBCacheDataWrapper.c(WidgetCacheLunarData.CHENG, "TEXT"), new IDBCacheDataWrapper.c(WidgetCacheLunarData.ZHENGCHONG, "TEXT"), new IDBCacheDataWrapper.c(WidgetCacheLunarData.TAISHEN, "TEXT"), new IDBCacheDataWrapper.c("cachetime", "INTEGER"), new IDBCacheDataWrapper.c("updatetime", "INTEGER")};
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 2;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public WidgetCacheLunarData createFromCursor(Cursor cursor) {
            WidgetCacheLunarData widgetCacheLunarData = new WidgetCacheLunarData();
            widgetCacheLunarData.animal = cursor.getInt(cursor.getColumnIndex(WidgetCacheLunarData.ANIMAL));
            widgetCacheLunarData.lunar_m = cursor.getString(cursor.getColumnIndex(WidgetCacheLunarData.LUNAR_M));
            widgetCacheLunarData.lunar_d = cursor.getString(cursor.getColumnIndex(WidgetCacheLunarData.LUNAR_D));
            widgetCacheLunarData.lunar_ex = cursor.getString(cursor.getColumnIndex(WidgetCacheLunarData.LUNAR_EX));
            widgetCacheLunarData.solar = cursor.getString(cursor.getColumnIndex(WidgetCacheLunarData.SOLAR));
            widgetCacheLunarData.week = cursor.getString(cursor.getColumnIndex(WidgetCacheLunarData.WEEK));
            widgetCacheLunarData.f50989yi = cursor.getString(cursor.getColumnIndex(WidgetCacheLunarData.YI));
            widgetCacheLunarData.f50988ji = cursor.getString(cursor.getColumnIndex(WidgetCacheLunarData.JI));
            widgetCacheLunarData.yi_ex = cursor.getString(cursor.getColumnIndex(WidgetCacheLunarData.YI_EX));
            widgetCacheLunarData.ji_ex = cursor.getString(cursor.getColumnIndex(WidgetCacheLunarData.JI_EX));
            widgetCacheLunarData.chong = cursor.getString(cursor.getColumnIndex(WidgetCacheLunarData.CHONG));
            widgetCacheLunarData.sha = cursor.getString(cursor.getColumnIndex(WidgetCacheLunarData.SHA));
            widgetCacheLunarData.cheng = cursor.getString(cursor.getColumnIndex(WidgetCacheLunarData.CHENG));
            widgetCacheLunarData.zhengchong = cursor.getString(cursor.getColumnIndex(WidgetCacheLunarData.ZHENGCHONG));
            widgetCacheLunarData.taishen = cursor.getString(cursor.getColumnIndex(WidgetCacheLunarData.TAISHEN));
            widgetCacheLunarData.cachetime = cursor.getInt(cursor.getColumnIndex("cachetime"));
            widgetCacheLunarData.updatetime = cursor.getInt(cursor.getColumnIndex("updatetime"));
            return widgetCacheLunarData;
        }
    };
    public static final String JI = "ji";
    public static final String JI_EX = "ji_ex";
    public static final String LUNAR_D = "lunar_d";
    public static final String LUNAR_EX = "lunar_ex";
    public static final String LUNAR_M = "lunar_m";
    public static final String SHA = "sha";
    public static final String SOLAR = "solar";
    public static final String TAISHEN = "taishen";
    public static final String TYPE_ANIMAL = "INTEGER";
    public static final String TYPE_CACHETIME = "INTEGER";
    public static final String TYPE_CHENG = "TEXT";
    public static final String TYPE_CHONG = "TEXT";
    public static final String TYPE_JI = "TEXT";
    public static final String TYPE_JI_EX = "TEXT";
    public static final String TYPE_LUNAR_D = "TEXT";
    public static final String TYPE_LUNAR_EX = "TEXT";
    public static final String TYPE_LUNAR_M = "TEXT";
    public static final String TYPE_SHA = "TEXT";
    public static final String TYPE_SOLAR = "TEXT";
    public static final String TYPE_TAISHEN = "TEXT";
    public static final String TYPE_UPDATETIME = "INTEGER";
    public static final String TYPE_WEEK = "TEXT";
    public static final String TYPE_YI = "TEXT";
    public static final String TYPE_YI_EX = "TEXT";
    public static final String TYPE_ZHENGCHONG = "TEXT";
    public static final String UPDATETIME = "updatetime";
    public static final int VERSION = 2;
    public static final String WEEK = "week";
    public static final String YI = "yi";
    public static final String YI_EX = "yi_ex";
    public static final String ZHENGCHONG = "zhengchong";
    public int animal;
    public String lunar_d;
    public String lunar_ex;
    public String lunar_m;
    public String solar;
    public String week;

    /* renamed from: yi, reason: collision with root package name */
    public String f50989yi = "";

    /* renamed from: ji, reason: collision with root package name */
    public String f50988ji = "";
    public String yi_ex = "";
    public String ji_ex = "";
    public String chong = "";
    public String sha = "";
    public String cheng = "";
    public String zhengchong = "";
    public String taishen = "";
    public int cachetime = 0;
    public int updatetime = 0;

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        contentValues.put(ANIMAL, Integer.valueOf(this.animal));
        contentValues.put(LUNAR_M, this.lunar_m);
        contentValues.put(LUNAR_D, this.lunar_d);
        contentValues.put(LUNAR_EX, this.lunar_ex);
        contentValues.put(SOLAR, this.solar);
        contentValues.put(WEEK, this.week);
        contentValues.put(YI, this.f50989yi);
        contentValues.put(JI, this.f50988ji);
        contentValues.put(YI_EX, this.yi_ex);
        contentValues.put(JI_EX, this.ji_ex);
        contentValues.put(CHONG, this.chong);
        contentValues.put(SHA, this.sha);
        contentValues.put(CHENG, this.cheng);
        contentValues.put(ZHENGCHONG, this.zhengchong);
        contentValues.put(TAISHEN, this.taishen);
        contentValues.put("cachetime", Integer.valueOf(this.cachetime));
        contentValues.put("updatetime", Integer.valueOf(this.updatetime));
    }

    public static WidgetLunarData convertToBusinessData(WidgetCacheLunarData widgetCacheLunarData) {
        if (widgetCacheLunarData == null) {
            return null;
        }
        WidgetLunarData widgetLunarData = new WidgetLunarData();
        widgetLunarData.animal = widgetCacheLunarData.animal;
        widgetLunarData.lunar_m = widgetCacheLunarData.lunar_m;
        widgetLunarData.lunar_d = widgetCacheLunarData.lunar_d;
        widgetLunarData.lunar_ex = widgetCacheLunarData.lunar_ex;
        widgetLunarData.solar = widgetCacheLunarData.solar;
        widgetLunarData.week = widgetCacheLunarData.week;
        widgetLunarData.f50991yi = widgetCacheLunarData.f50989yi;
        widgetLunarData.f50990ji = widgetCacheLunarData.f50988ji;
        widgetLunarData.yi_ex = widgetCacheLunarData.yi_ex;
        widgetLunarData.ji_ex = widgetCacheLunarData.ji_ex;
        widgetLunarData.chong = widgetCacheLunarData.chong;
        widgetLunarData.sha = widgetCacheLunarData.sha;
        widgetLunarData.cheng = widgetCacheLunarData.cheng;
        widgetLunarData.zhengchong = widgetCacheLunarData.zhengchong;
        widgetLunarData.taishen = widgetCacheLunarData.taishen;
        widgetLunarData.cachetime = widgetCacheLunarData.cachetime;
        widgetLunarData.updatetime = widgetCacheLunarData.updatetime;
        return widgetLunarData;
    }

    public static WidgetCacheLunarData createFromBusinessData(WidgetLunarData widgetLunarData) {
        if (widgetLunarData == null) {
            return null;
        }
        WidgetCacheLunarData widgetCacheLunarData = new WidgetCacheLunarData();
        widgetCacheLunarData.animal = widgetLunarData.animal;
        widgetCacheLunarData.lunar_m = widgetLunarData.lunar_m;
        widgetCacheLunarData.lunar_d = widgetLunarData.lunar_d;
        widgetCacheLunarData.lunar_ex = widgetLunarData.lunar_ex;
        widgetCacheLunarData.solar = widgetLunarData.solar;
        widgetCacheLunarData.week = widgetLunarData.week;
        widgetCacheLunarData.f50989yi = widgetLunarData.f50991yi;
        widgetCacheLunarData.f50988ji = widgetLunarData.f50990ji;
        widgetCacheLunarData.yi_ex = widgetLunarData.yi_ex;
        widgetCacheLunarData.ji_ex = widgetLunarData.ji_ex;
        widgetCacheLunarData.chong = widgetLunarData.chong;
        widgetCacheLunarData.sha = widgetLunarData.sha;
        widgetCacheLunarData.cheng = widgetLunarData.cheng;
        widgetCacheLunarData.zhengchong = widgetLunarData.zhengchong;
        widgetCacheLunarData.taishen = widgetLunarData.taishen;
        widgetCacheLunarData.cachetime = widgetLunarData.cachetime;
        widgetCacheLunarData.updatetime = widgetLunarData.updatetime;
        return widgetCacheLunarData;
    }

    public static WidgetLunarData createFromResponse(LunarWidgetInfo lunarWidgetInfo, int i3) {
        if (lunarWidgetInfo == null) {
            return null;
        }
        WidgetLunarData widgetLunarData = new WidgetLunarData();
        widgetLunarData.animal = lunarWidgetInfo.animal;
        widgetLunarData.lunar_m = lunarWidgetInfo.lunar_m;
        widgetLunarData.lunar_d = lunarWidgetInfo.lunar_d;
        widgetLunarData.lunar_ex = lunarWidgetInfo.lunar_ex;
        widgetLunarData.solar = lunarWidgetInfo.solar;
        widgetLunarData.week = lunarWidgetInfo.week;
        widgetLunarData.f50991yi = lunarWidgetInfo.f25060yi;
        widgetLunarData.f50990ji = lunarWidgetInfo.f25059ji;
        widgetLunarData.yi_ex = lunarWidgetInfo.yiex;
        widgetLunarData.ji_ex = lunarWidgetInfo.jiex;
        widgetLunarData.chong = lunarWidgetInfo.chong;
        widgetLunarData.sha = lunarWidgetInfo.sha;
        widgetLunarData.cheng = lunarWidgetInfo.cheng;
        widgetLunarData.zhengchong = lunarWidgetInfo.zhengchong;
        widgetLunarData.taishen = lunarWidgetInfo.taishen;
        widgetLunarData.cachetime = i3;
        widgetLunarData.updatetime = (int) (System.currentTimeMillis() / 1000);
        return widgetLunarData;
    }
}
