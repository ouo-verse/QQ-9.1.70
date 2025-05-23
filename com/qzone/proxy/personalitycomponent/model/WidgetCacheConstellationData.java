package com.qzone.proxy.personalitycomponent.model;

import NS_MOBILE_WIDGET.ConstellationWidgetInfo;
import android.content.ContentValues;
import android.database.Cursor;
import com.qzone.component.cache.database.a;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;

/* compiled from: P */
/* loaded from: classes39.dex */
public class WidgetCacheConstellationData extends a {
    public static final String BAD = "bad";
    public static final String CACHETIME = "cachetime";
    public static final String COLOR = "color";
    public static final String CONSTELLATIONID = "constellationId";
    public static final String DATE = "date";
    public static final IDBCacheDataWrapper.a<WidgetCacheConstellationData> DB_CREATOR = new IDBCacheDataWrapper.a<WidgetCacheConstellationData>() { // from class: com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData.1
        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public String sortOrder() {
            return null;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public IDBCacheDataWrapper.c[] structure() {
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c(WidgetCacheConstellationData.CONSTELLATIONID, "INTEGER"), new IDBCacheDataWrapper.c("name", "TEXT"), new IDBCacheDataWrapper.c(WidgetCacheConstellationData.INTERVAL, "TEXT"), new IDBCacheDataWrapper.c(WidgetCacheConstellationData.GOOD, "TEXT"), new IDBCacheDataWrapper.c(WidgetCacheConstellationData.BAD, "TEXT"), new IDBCacheDataWrapper.c("desc", "TEXT"), new IDBCacheDataWrapper.c("color", "TEXT"), new IDBCacheDataWrapper.c(WidgetCacheConstellationData.NUM, "TEXT"), new IDBCacheDataWrapper.c("love", "INTEGER"), new IDBCacheDataWrapper.c(WidgetCacheConstellationData.WORK, "INTEGER"), new IDBCacheDataWrapper.c(WidgetCacheConstellationData.MONEY, "INTEGER"), new IDBCacheDataWrapper.c(WidgetCacheConstellationData.HEALTH, "INTEGER"), new IDBCacheDataWrapper.c("date", "TEXT"), new IDBCacheDataWrapper.c(WidgetCacheConstellationData.LUCKY, "INTEGER"), new IDBCacheDataWrapper.c("cachetime", "INTEGER"), new IDBCacheDataWrapper.c("updatetime", "INTEGER")};
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 1;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public WidgetCacheConstellationData createFromCursor(Cursor cursor) {
            WidgetCacheConstellationData widgetCacheConstellationData = new WidgetCacheConstellationData();
            widgetCacheConstellationData.constellationId = cursor.getInt(cursor.getColumnIndex(WidgetCacheConstellationData.CONSTELLATIONID));
            widgetCacheConstellationData.name = cursor.getString(cursor.getColumnIndex("name"));
            widgetCacheConstellationData.interval = cursor.getString(cursor.getColumnIndex(WidgetCacheConstellationData.INTERVAL));
            widgetCacheConstellationData.good = cursor.getString(cursor.getColumnIndex(WidgetCacheConstellationData.GOOD));
            widgetCacheConstellationData.bad = cursor.getString(cursor.getColumnIndex(WidgetCacheConstellationData.BAD));
            widgetCacheConstellationData.desc = cursor.getString(cursor.getColumnIndex("desc"));
            widgetCacheConstellationData.color = cursor.getString(cursor.getColumnIndex("color"));
            widgetCacheConstellationData.num = cursor.getString(cursor.getColumnIndex(WidgetCacheConstellationData.NUM));
            widgetCacheConstellationData.love = cursor.getInt(cursor.getColumnIndex("love"));
            widgetCacheConstellationData.work = cursor.getInt(cursor.getColumnIndex(WidgetCacheConstellationData.WORK));
            widgetCacheConstellationData.money = cursor.getInt(cursor.getColumnIndex(WidgetCacheConstellationData.MONEY));
            widgetCacheConstellationData.health = cursor.getInt(cursor.getColumnIndex(WidgetCacheConstellationData.HEALTH));
            widgetCacheConstellationData.date = cursor.getString(cursor.getColumnIndex("date"));
            widgetCacheConstellationData.lucky = cursor.getInt(cursor.getColumnIndex(WidgetCacheConstellationData.LUCKY));
            widgetCacheConstellationData.cachetime = cursor.getInt(cursor.getColumnIndex("cachetime"));
            widgetCacheConstellationData.updatetime = cursor.getInt(cursor.getColumnIndex("updatetime"));
            return widgetCacheConstellationData;
        }
    };
    public static final String DESC = "desc";
    public static final String GOOD = "good";
    public static final String HEALTH = "health";
    public static final String INTERVAL = "interval";
    public static final String LOVE = "love";
    public static final String LUCKY = "lucky";
    public static final String MONEY = "money";
    public static final String NAME = "name";
    public static final String NUM = "num";
    public static final String TYPE_BAD = "TEXT";
    public static final String TYPE_CACHETIME = "INTEGER";
    public static final String TYPE_COLOR = "TEXT";
    public static final String TYPE_CONSTELLATIONID = "INTEGER";
    public static final String TYPE_DATE = "TEXT";
    public static final String TYPE_DESC = "TEXT";
    public static final String TYPE_GOOD = "TEXT";
    public static final String TYPE_HEALTH = "INTEGER";
    public static final String TYPE_INTERVAL = "TEXT";
    public static final String TYPE_LOVE = "INTEGER";
    public static final String TYPE_LUCKY = "INTEGER";
    public static final String TYPE_MONEY = "INTEGER";
    public static final String TYPE_NAME = "TEXT";
    public static final String TYPE_NUM = "TEXT";
    public static final String TYPE_UPDATETIME = "INTEGER";
    public static final String TYPE_WORK = "INTEGER";
    public static final String UPDATETIME = "updatetime";
    public static final int VERSION = 1;
    public static final String WORK = "work";
    public String bad;
    public int constellationId;
    public String desc;
    public String good;
    public String interval;
    public String name;
    public String color = "";
    public String num = "";
    public int love = 0;
    public int work = 0;
    public int money = 0;
    public int health = 0;
    public String date = "";
    public int lucky = 0;
    public int cachetime = 0;
    public int updatetime = 0;

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        contentValues.put(CONSTELLATIONID, Integer.valueOf(this.constellationId));
        contentValues.put("name", this.name);
        contentValues.put(INTERVAL, this.interval);
        contentValues.put(GOOD, this.good);
        contentValues.put(BAD, this.bad);
        contentValues.put("desc", this.desc);
        contentValues.put("color", this.color);
        contentValues.put(NUM, this.num);
        contentValues.put("love", Integer.valueOf(this.love));
        contentValues.put(WORK, Integer.valueOf(this.work));
        contentValues.put(MONEY, Integer.valueOf(this.money));
        contentValues.put(HEALTH, Integer.valueOf(this.health));
        contentValues.put("date", this.date);
        contentValues.put(LUCKY, Integer.valueOf(this.lucky));
        contentValues.put("cachetime", Integer.valueOf(this.cachetime));
        contentValues.put("updatetime", Integer.valueOf(this.updatetime));
    }

    public static WidgetConstellationData convertToBusinessData(WidgetCacheConstellationData widgetCacheConstellationData) {
        if (widgetCacheConstellationData == null) {
            return null;
        }
        WidgetConstellationData widgetConstellationData = new WidgetConstellationData();
        widgetConstellationData.constellationId = widgetCacheConstellationData.constellationId;
        widgetConstellationData.name = widgetCacheConstellationData.name;
        widgetConstellationData.interval = widgetCacheConstellationData.interval;
        widgetConstellationData.good = widgetCacheConstellationData.good;
        widgetConstellationData.bad = widgetCacheConstellationData.bad;
        widgetConstellationData.desc = widgetCacheConstellationData.desc;
        widgetConstellationData.color = widgetCacheConstellationData.color;
        widgetConstellationData.num = widgetCacheConstellationData.num;
        widgetConstellationData.love = widgetCacheConstellationData.love;
        widgetConstellationData.work = widgetCacheConstellationData.work;
        widgetConstellationData.money = widgetCacheConstellationData.money;
        widgetConstellationData.health = widgetCacheConstellationData.health;
        widgetConstellationData.date = widgetCacheConstellationData.date;
        widgetConstellationData.lucky = widgetCacheConstellationData.lucky;
        widgetConstellationData.cachetime = widgetCacheConstellationData.cachetime;
        widgetConstellationData.updatetime = widgetCacheConstellationData.updatetime;
        return widgetConstellationData;
    }

    public static WidgetCacheConstellationData createFromBusinessData(WidgetConstellationData widgetConstellationData) {
        if (widgetConstellationData == null) {
            return null;
        }
        WidgetCacheConstellationData widgetCacheConstellationData = new WidgetCacheConstellationData();
        widgetCacheConstellationData.constellationId = widgetConstellationData.constellationId;
        widgetCacheConstellationData.name = widgetConstellationData.name;
        widgetCacheConstellationData.interval = widgetConstellationData.interval;
        widgetCacheConstellationData.good = widgetConstellationData.good;
        widgetCacheConstellationData.bad = widgetConstellationData.bad;
        widgetCacheConstellationData.desc = widgetConstellationData.desc;
        widgetCacheConstellationData.color = widgetConstellationData.color;
        widgetCacheConstellationData.num = widgetConstellationData.num;
        widgetCacheConstellationData.love = widgetConstellationData.love;
        widgetCacheConstellationData.work = widgetConstellationData.work;
        widgetCacheConstellationData.money = widgetConstellationData.money;
        widgetCacheConstellationData.health = widgetConstellationData.health;
        widgetCacheConstellationData.date = widgetConstellationData.date;
        widgetCacheConstellationData.lucky = widgetConstellationData.lucky;
        widgetCacheConstellationData.cachetime = widgetConstellationData.cachetime;
        widgetCacheConstellationData.updatetime = widgetConstellationData.updatetime;
        return widgetCacheConstellationData;
    }

    public static WidgetConstellationData createFromResponse(ConstellationWidgetInfo constellationWidgetInfo, int i3) {
        if (constellationWidgetInfo == null) {
            return null;
        }
        WidgetConstellationData widgetConstellationData = new WidgetConstellationData();
        widgetConstellationData.constellationId = constellationWidgetInfo.consid;
        widgetConstellationData.name = constellationWidgetInfo.name;
        widgetConstellationData.interval = constellationWidgetInfo.interval;
        widgetConstellationData.good = constellationWidgetInfo.good;
        widgetConstellationData.bad = constellationWidgetInfo.bad;
        widgetConstellationData.desc = constellationWidgetInfo.desc;
        widgetConstellationData.color = constellationWidgetInfo.color;
        widgetConstellationData.num = constellationWidgetInfo.num;
        widgetConstellationData.love = constellationWidgetInfo.love;
        widgetConstellationData.work = constellationWidgetInfo.work;
        widgetConstellationData.money = constellationWidgetInfo.money;
        widgetConstellationData.health = constellationWidgetInfo.health;
        widgetConstellationData.date = constellationWidgetInfo.date;
        widgetConstellationData.lucky = constellationWidgetInfo.lucky;
        widgetConstellationData.cachetime = i3;
        widgetConstellationData.updatetime = (int) (System.currentTimeMillis() / 1000);
        return widgetConstellationData;
    }
}
