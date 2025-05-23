package com.qzone.proxy.personalitycomponent.model;

import NS_MOBILE_WIDGET.Visitor;
import NS_MOBILE_WIDGET.VisitorWidgetInfo;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import com.qzone.component.cache.database.a;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import com.qzone.proxy.personalitycomponent.model.WidgetVisitorsData;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes39.dex */
public class WidgetCacheVisitorData extends a {
    public static final String CACHETIME = "cachetime";
    public static final IDBCacheDataWrapper.a<WidgetCacheVisitorData> DB_CREATOR = new IDBCacheDataWrapper.a<WidgetCacheVisitorData>() { // from class: com.qzone.proxy.personalitycomponent.model.WidgetCacheVisitorData.1
        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public String sortOrder() {
            return null;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public IDBCacheDataWrapper.c[] structure() {
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c(WidgetCacheVisitorData.TODAY_DELTA, "INTEGER"), new IDBCacheDataWrapper.c(WidgetCacheVisitorData.TODAY_VISITOR, "INTEGER"), new IDBCacheDataWrapper.c(WidgetCacheVisitorData.TOTAL_VISITOR, "INTEGER"), new IDBCacheDataWrapper.c("uin", "INTEGER"), new IDBCacheDataWrapper.c("cachetime", "INTEGER"), new IDBCacheDataWrapper.c("updatetime", "INTEGER"), new IDBCacheDataWrapper.c(WidgetCacheVisitorData.NAME_PLATE_FLAG, "INTEGER"), new IDBCacheDataWrapper.c(WidgetCacheVisitorData.VISITOR, "BLOB"), new IDBCacheDataWrapper.c(WidgetCacheVisitorData.NAME_NEED_REDPACKET, "INTEGER")};
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 5;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public WidgetCacheVisitorData createFromCursor(Cursor cursor) {
            WidgetCacheVisitorData widgetCacheVisitorData = new WidgetCacheVisitorData();
            widgetCacheVisitorData.todayDelta = cursor.getInt(cursor.getColumnIndex(WidgetCacheVisitorData.TODAY_DELTA));
            widgetCacheVisitorData.todayVistor = cursor.getInt(cursor.getColumnIndex(WidgetCacheVisitorData.TODAY_VISITOR));
            widgetCacheVisitorData.totalVistor = cursor.getInt(cursor.getColumnIndex(WidgetCacheVisitorData.TOTAL_VISITOR));
            widgetCacheVisitorData.uin = cursor.getLong(cursor.getColumnIndex("uin"));
            widgetCacheVisitorData.cachetime = cursor.getInt(cursor.getColumnIndex("cachetime"));
            widgetCacheVisitorData.updatetime = cursor.getInt(cursor.getColumnIndex("updatetime"));
            widgetCacheVisitorData.nameplateFlag = cursor.getInt(cursor.getColumnIndex(WidgetCacheVisitorData.NAME_PLATE_FLAG));
            widgetCacheVisitorData.needRedPacket = cursor.getInt(cursor.getColumnIndex(WidgetCacheVisitorData.NAME_NEED_REDPACKET));
            byte[] blob = cursor.getBlob(cursor.getColumnIndex(WidgetCacheVisitorData.VISITOR));
            try {
                Parcel obtain = Parcel.obtain();
                obtain.unmarshall(blob, 0, blob.length);
                obtain.setDataPosition(0);
                widgetCacheVisitorData.deltaList = ParcelableWrapper.createArrayListFromParcel(obtain);
                OaidMonitor.parcelRecycle(obtain);
            } catch (Exception e16) {
                QZLog.w("WidgetCacheVisitor", "createFromCursor error", e16);
            }
            return widgetCacheVisitorData;
        }
    };
    public static final String NAME_NEED_REDPACKET = "name_need_redpacket";
    public static final String NAME_PLATE_FLAG = "name_plate_flag";
    public static final String TODAY_DELTA = "today_delta";
    public static final String TODAY_VISITOR = "today_visitor";
    public static final String TOTAL_VISITOR = "total_visitor";
    public static final String TYPE_CACHETIME = "INTEGER";
    public static final String TYPE_DELTA = "INTEGER";
    public static final String TYPE_NAME_NEED_REDPACKET = "INTEGER";
    public static final String TYPE_NAME_PLATE_FLAG = "INTEGER";
    public static final String TYPE_TODAYVISITOR = "INTEGER";
    public static final String TYPE_TOTALVISITOR = "INTEGER";
    public static final String TYPE_UIN = "INTEGER";
    public static final String TYPE_UPDATETIME = "INTEGER";
    public static final String TYPE_VISITOR = "BLOB";
    public static final String UIN = "uin";
    public static final String UPDATETIME = "updatetime";
    public static final int VERSION = 5;
    public static final String VISITOR = "vistor_list";
    public int todayDelta;
    public int todayVistor;
    public int totalVistor;
    public long uin = 0;
    public int cachetime = 0;
    public int updatetime = 0;
    public int nameplateFlag = 0;
    public int needRedPacket = 0;
    public ArrayList<WidgetVisitorsData.WidgetVistor> deltaList = new ArrayList<>();

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        contentValues.put(TODAY_DELTA, Integer.valueOf(this.todayDelta));
        contentValues.put(TODAY_VISITOR, Integer.valueOf(this.todayVistor));
        contentValues.put(TOTAL_VISITOR, Integer.valueOf(this.totalVistor));
        contentValues.put("uin", Long.valueOf(this.uin));
        contentValues.put("cachetime", Integer.valueOf(this.cachetime));
        contentValues.put("updatetime", Integer.valueOf(this.updatetime));
        contentValues.put(NAME_PLATE_FLAG, Integer.valueOf(this.nameplateFlag));
        contentValues.put(NAME_NEED_REDPACKET, Integer.valueOf(this.needRedPacket));
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        ParcelableWrapper.writeArrayListToParcel(obtain, 0, this.deltaList);
        byte[] marshall = obtain.marshall();
        OaidMonitor.parcelRecycle(obtain);
        contentValues.put(VISITOR, marshall);
    }

    public static WidgetVisitorsData convertToBusinessData(WidgetCacheVisitorData widgetCacheVisitorData) {
        if (widgetCacheVisitorData == null) {
            return null;
        }
        WidgetVisitorsData widgetVisitorsData = new WidgetVisitorsData();
        widgetVisitorsData.today_visitor = widgetCacheVisitorData.todayVistor;
        widgetVisitorsData.total_visitor = widgetCacheVisitorData.totalVistor;
        widgetVisitorsData.cachetime = widgetCacheVisitorData.cachetime;
        widgetVisitorsData.updatetime = widgetCacheVisitorData.updatetime;
        widgetVisitorsData.uin = widgetCacheVisitorData.uin;
        widgetVisitorsData.namePlateFlag = widgetCacheVisitorData.nameplateFlag;
        widgetVisitorsData.needRedPacket = widgetCacheVisitorData.needRedPacket;
        ArrayList<WidgetVisitorsData.WidgetVistor> arrayList = widgetCacheVisitorData.deltaList;
        if (arrayList != null) {
            widgetVisitorsData.deltaList.addAll(arrayList);
        }
        return widgetVisitorsData;
    }

    public static WidgetCacheVisitorData createFromBusinessData(WidgetVisitorsData widgetVisitorsData) {
        if (widgetVisitorsData == null) {
            return null;
        }
        WidgetCacheVisitorData widgetCacheVisitorData = new WidgetCacheVisitorData();
        widgetCacheVisitorData.todayDelta = widgetVisitorsData.today_delta;
        widgetCacheVisitorData.todayVistor = widgetVisitorsData.today_visitor;
        widgetCacheVisitorData.totalVistor = widgetVisitorsData.total_visitor;
        widgetCacheVisitorData.cachetime = widgetVisitorsData.cachetime;
        widgetCacheVisitorData.updatetime = widgetVisitorsData.updatetime;
        widgetCacheVisitorData.uin = widgetVisitorsData.uin;
        widgetCacheVisitorData.nameplateFlag = widgetVisitorsData.namePlateFlag;
        widgetCacheVisitorData.needRedPacket = widgetVisitorsData.needRedPacket;
        ArrayList<WidgetVisitorsData.WidgetVistor> arrayList = widgetVisitorsData.deltaList;
        if (arrayList != null) {
            widgetCacheVisitorData.deltaList.addAll(arrayList);
        }
        return widgetCacheVisitorData;
    }

    public static WidgetVisitorsData createFromResponse(VisitorWidgetInfo visitorWidgetInfo, int i3, long j3, int i16, int i17) {
        if (visitorWidgetInfo == null) {
            return null;
        }
        WidgetVisitorsData widgetVisitorsData = new WidgetVisitorsData();
        widgetVisitorsData.today_delta = visitorWidgetInfo.today_delta;
        widgetVisitorsData.today_visitor = visitorWidgetInfo.today_visitor;
        widgetVisitorsData.total_visitor = visitorWidgetInfo.total_visitor;
        widgetVisitorsData.blocked_visitor_count = visitorWidgetInfo.blocked_visitor_count;
        widgetVisitorsData.updatetime = (int) (System.currentTimeMillis() / 1000);
        widgetVisitorsData.cachetime = i16;
        widgetVisitorsData.uin = j3;
        widgetVisitorsData.namePlateFlag = i3;
        widgetVisitorsData.needRedPacket = i17;
        String str = ("today_delta:" + visitorWidgetInfo.today_delta + "today_visitor:" + visitorWidgetInfo.today_visitor + "total_visitor:" + visitorWidgetInfo.total_visitor) + "uins: ";
        ArrayList<Visitor> arrayList = visitorWidgetInfo.delta_visitor;
        if (arrayList != null) {
            Iterator<Visitor> it = arrayList.iterator();
            while (it.hasNext()) {
                Visitor next = it.next();
                WidgetVisitorsData.WidgetVistor widgetVistor = new WidgetVisitorsData.WidgetVistor();
                widgetVistor.uin = next.uin;
                widgetVistor.visit_time = next.visit_time;
                widgetVisitorsData.deltaList.add(widgetVistor);
                str = (str + next.uin) + "|";
            }
        }
        if (QZLog.isColorLevel()) {
            QZLog.d("JUMP QZONE", 2, "reponse info from server:" + str);
        }
        return widgetVisitorsData;
    }
}
