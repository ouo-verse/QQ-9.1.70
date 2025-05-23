package com.qzone.module.covercomponent.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import com.qzone.proxy.covercomponent.QzoneCoverConst;
import com.qzone.proxy.covercomponent.adapter.CoverLog;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import cooperation.qzone.model.CoverCacheData;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CoverDBCacheData implements IDBCacheDataWrapper {
    public static final String ALIAN = "alian";
    public static final String BACKUP_MAP_EXTEND_INFO = "backup_map_extend_info";
    public static final String COVER_ID = "coverId";
    public static final IDBCacheDataWrapper.a<CoverDBCacheData> DB_CREATOR = new IDBCacheDataWrapper.a<CoverDBCacheData>() { // from class: com.qzone.module.covercomponent.model.CoverDBCacheData.1
        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public String sortOrder() {
            return null;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public IDBCacheDataWrapper.c[] structure() {
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c("uin", "INTEGER UNIQUE"), new IDBCacheDataWrapper.c("coverId", "TEXT"), new IDBCacheDataWrapper.c("type", "TEXT"), new IDBCacheDataWrapper.c(CoverDBCacheData.LOCAL_URL, "TEXT"), new IDBCacheDataWrapper.c(CoverDBCacheData.URLS, "BLOB"), new IDBCacheDataWrapper.c(CoverDBCacheData.PACKAGE_INFO, "BLOB"), new IDBCacheDataWrapper.c(CoverDBCacheData.GAME_COVER_INFO, "BLOB"), new IDBCacheDataWrapper.c(CoverDBCacheData.PHOTO_WALL, "BLOB"), new IDBCacheDataWrapper.c(CoverDBCacheData.JIGSAW, "INTEGER"), new IDBCacheDataWrapper.c(CoverDBCacheData.MAP_EXTEND_INFO, "BLOB"), new IDBCacheDataWrapper.c(CoverDBCacheData.BACKUP_MAP_EXTEND_INFO, "BLOB"), new IDBCacheDataWrapper.c(CoverDBCacheData.ALIAN, "TEXT")};
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 13;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public CoverDBCacheData createFromCursor(Cursor cursor) {
            CoverCacheData coverCacheData = new CoverCacheData();
            int columnIndex = cursor.getColumnIndex("uin");
            if (columnIndex >= 0) {
                coverCacheData.uin = cursor.getLong(columnIndex);
            }
            int columnIndex2 = cursor.getColumnIndex("coverId");
            if (columnIndex2 >= 0) {
                coverCacheData.coverId = cursor.getString(columnIndex2);
            }
            int columnIndex3 = cursor.getColumnIndex("type");
            if (columnIndex3 >= 0) {
                coverCacheData.type = cursor.getString(columnIndex3);
            }
            int columnIndex4 = cursor.getColumnIndex(CoverDBCacheData.LOCAL_URL);
            if (columnIndex4 >= 0) {
                coverCacheData.local_url = cursor.getString(columnIndex4);
            }
            int columnIndex5 = cursor.getColumnIndex(CoverDBCacheData.JIGSAW);
            if (columnIndex5 >= 0) {
                coverCacheData.isJigsawOpen = cursor.getInt(columnIndex5);
            }
            int columnIndex6 = cursor.getColumnIndex(CoverDBCacheData.ALIAN);
            if (columnIndex6 >= 0) {
                coverCacheData.alian = cursor.getInt(columnIndex6);
            }
            byte[] blob = cursor.getBlob(cursor.getColumnIndex(CoverDBCacheData.URLS));
            try {
                Parcel obtain = Parcel.obtain();
                obtain.unmarshall(blob, 0, blob.length);
                obtain.setDataPosition(0);
                coverCacheData.urls = obtain.readHashMap(getClass().getClassLoader());
                OaidMonitor.parcelRecycle(obtain);
            } catch (Exception e16) {
                if (CoverLog.isColorLevel()) {
                    CoverLog.e(QzoneCoverConst.PARAM_CACHE_DATA, "failed to read cover.urls:", e16);
                }
            }
            byte[] blob2 = cursor.getBlob(cursor.getColumnIndex(CoverDBCacheData.PACKAGE_INFO));
            try {
                Parcel obtain2 = Parcel.obtain();
                obtain2.unmarshall(blob2, 0, blob2.length);
                obtain2.setDataPosition(0);
                coverCacheData.packageInfo = (CoverCacheData.PackageInfo) obtain2.readParcelable(getClass().getClassLoader());
                OaidMonitor.parcelRecycle(obtain2);
            } catch (Exception e17) {
                if (CoverLog.isColorLevel()) {
                    CoverLog.e(QzoneCoverConst.PARAM_CACHE_DATA, "failed to read cover.packageInfo:", e17);
                }
            }
            byte[] blob3 = cursor.getBlob(cursor.getColumnIndex(CoverDBCacheData.GAME_COVER_INFO));
            try {
                Parcel obtain3 = Parcel.obtain();
                obtain3.unmarshall(blob3, 0, blob3.length);
                obtain3.setDataPosition(0);
                coverCacheData.gameCoverInfo = (CoverCacheData.GameCoverInfo) obtain3.readParcelable(getClass().getClassLoader());
                OaidMonitor.parcelRecycle(obtain3);
            } catch (Exception e18) {
                if (CoverLog.isColorLevel()) {
                    CoverLog.e(QzoneCoverConst.PARAM_CACHE_DATA, "failed to read cover.gameCoverInfo:", e18);
                }
            }
            byte[] blob4 = cursor.getBlob(cursor.getColumnIndex(CoverDBCacheData.PHOTO_WALL));
            try {
                Parcel obtain4 = Parcel.obtain();
                obtain4.unmarshall(blob4, 0, blob4.length);
                obtain4.setDataPosition(0);
                coverCacheData.photoWall = obtain4.readArrayList(getClass().getClassLoader());
                OaidMonitor.parcelRecycle(obtain4);
            } catch (Exception e19) {
                if (CoverLog.isColorLevel()) {
                    CoverLog.e(QzoneCoverConst.PARAM_CACHE_DATA, "failed to read cover.photoWall:", e19);
                }
            }
            byte[] blob5 = cursor.getBlob(cursor.getColumnIndex(CoverDBCacheData.MAP_EXTEND_INFO));
            try {
                Parcel obtain5 = Parcel.obtain();
                obtain5.unmarshall(blob5, 0, blob5.length);
                obtain5.setDataPosition(0);
                coverCacheData.mapExtInfo = obtain5.readHashMap(getClass().getClassLoader());
                OaidMonitor.parcelRecycle(obtain5);
            } catch (Exception e26) {
                if (CoverLog.isColorLevel()) {
                    CoverLog.e(QzoneCoverConst.PARAM_CACHE_DATA, "failed to read cover.mapExtendInfo:", e26);
                }
            }
            try {
                byte[] blob6 = cursor.getBlob(cursor.getColumnIndex(CoverDBCacheData.BACKUP_MAP_EXTEND_INFO));
                if (blob6 != null) {
                    Parcel obtain6 = Parcel.obtain();
                    obtain6.unmarshall(blob6, 0, blob6.length);
                    obtain6.setDataPosition(0);
                    coverCacheData.backupMapExtInfo = obtain6.readHashMap(getClass().getClassLoader());
                    OaidMonitor.parcelRecycle(obtain6);
                }
            } catch (Exception e27) {
                if (CoverLog.isColorLevel()) {
                    CoverLog.e(QzoneCoverConst.PARAM_CACHE_DATA, "failed to read cover.backupMapExtInfo:", e27);
                }
            }
            return new CoverDBCacheData(coverCacheData);
        }
    };
    public static final String GAME_COVER_INFO = "game_cover_info";
    public static final String JIGSAW = "jigsaw";
    public static final String LOCAL_URL = "local_url";
    public static final String MAP_EXTEND_INFO = "map_extend_info";
    public static final String PACKAGE_INFO = "package_info";
    public static final String PHOTO_WALL = "photo_wall";
    public static final String TYPE = "type";
    public static final String TYPE_ALIAN = "TEXT";
    public static final String TYPE_BACKUP_MAP_EXTEND_INFO = "BLOB";
    public static final String TYPE_COVER_ID = "TEXT";
    public static final String TYPE_GAME_COVER_INFO = "BLOB";
    public static final String TYPE_JIGSAW = "INTEGER";
    public static final String TYPE_LOCAL_URL = "TEXT";
    public static final String TYPE_MAP_EXTEND_INFO = "BLOB";
    public static final String TYPE_PACKAGE_DATA = "BLOB";
    public static final String TYPE_PHOTO_WALL = "BLOB";
    public static final String TYPE_TYPE = "TEXT";
    public static final String TYPE_UIN = "INTEGER UNIQUE";
    public static final String TYPE_URLS = "BLOB";
    public static final String UIN = "uin";
    public static final String URLS = "urls";
    public static final int VERSION = 13;

    /* renamed from: d, reason: collision with root package name */
    private CoverCacheData f48648d;

    public CoverDBCacheData(CoverCacheData coverCacheData) {
        this.f48648d = coverCacheData;
    }

    public CoverCacheData getCoverCacheData() {
        return this.f48648d;
    }

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void readFrom(ContentValues contentValues) {
        CoverLog.e(QzoneCoverConst.PARAM_CACHE_DATA, "readFrom not have implement", null);
    }

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        CoverCacheData coverCacheData = this.f48648d;
        if (coverCacheData == null) {
            return;
        }
        contentValues.put("uin", Long.valueOf(coverCacheData.uin));
        contentValues.put("coverId", this.f48648d.coverId);
        contentValues.put("type", this.f48648d.type);
        contentValues.put(LOCAL_URL, this.f48648d.local_url);
        contentValues.put(JIGSAW, Integer.valueOf(this.f48648d.isJigsawOpen));
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        obtain.writeMap(this.f48648d.urls);
        byte[] marshall = obtain.marshall();
        OaidMonitor.parcelRecycle(obtain);
        contentValues.put(URLS, marshall);
        Parcel obtain2 = Parcel.obtain();
        obtain2.setDataPosition(0);
        obtain2.writeParcelable(this.f48648d.packageInfo, 0);
        byte[] marshall2 = obtain2.marshall();
        OaidMonitor.parcelRecycle(obtain2);
        contentValues.put(PACKAGE_INFO, marshall2);
        Parcel obtain3 = Parcel.obtain();
        obtain3.setDataPosition(0);
        obtain3.writeParcelable(this.f48648d.gameCoverInfo, 0);
        byte[] marshall3 = obtain3.marshall();
        OaidMonitor.parcelRecycle(obtain3);
        contentValues.put(GAME_COVER_INFO, marshall3);
        Parcel obtain4 = Parcel.obtain();
        obtain4.setDataPosition(0);
        obtain4.writeList(this.f48648d.photoWall);
        byte[] marshall4 = obtain4.marshall();
        OaidMonitor.parcelRecycle(obtain4);
        contentValues.put(PHOTO_WALL, marshall4);
        Parcel obtain5 = Parcel.obtain();
        obtain5.setDataPosition(0);
        obtain5.writeMap(this.f48648d.mapExtInfo);
        byte[] marshall5 = obtain5.marshall();
        OaidMonitor.parcelRecycle(obtain5);
        contentValues.put(MAP_EXTEND_INFO, marshall5);
        Parcel obtain6 = Parcel.obtain();
        obtain6.setDataPosition(0);
        obtain6.writeMap(this.f48648d.backupMapExtInfo);
        byte[] marshall6 = obtain6.marshall();
        OaidMonitor.parcelRecycle(obtain6);
        contentValues.put(BACKUP_MAP_EXTEND_INFO, marshall6);
        contentValues.put(ALIAN, Integer.valueOf(this.f48648d.alian));
    }
}
