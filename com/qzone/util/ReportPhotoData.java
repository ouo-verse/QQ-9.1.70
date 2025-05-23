package com.qzone.util;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.io.File;

/* loaded from: classes37.dex */
public class ReportPhotoData extends com.qzone.component.cache.database.a implements SmartParcelable {
    public static String CLIENT_TIME_TYPE = "INTEGER";
    public static String COLUMN_CLIENT_TIME = "CLIENTTIME";
    public static String COLUMN_OPERATION_ID = "OPERATIONID";
    public static String COLUMN_OPERATION_PRIORITY = "OPERATION_PRIORITY";
    public static String COLUMN_OPERATION_TYPE = "OPERATIONTYPE";
    public static String COLUMN_PHOTO_ID = "PHOTOID";
    public static String COLUMN_PHOTO_PATH = "PHOTOPATH";
    public static IDBCacheDataWrapper.a<ReportPhotoData> DB_CREATOR = new a();
    public static int DB_VERSION = 2;
    private static final String GroupTableName = "ReadyToReportPhotoData";
    public static String OPERATION_ID_TYPE = "INTEGER";
    public static String OPERATION_PRIORITY_TYPE = "INTEGER";
    public static String OPERATION_TYPE_TYPE = "INTEGER";
    public static String PHOTO_ID_TYPE = "INTEGER";
    public static String PHOTO_PATH_TYPE = "TEXT";
    private static final String TAG = "MLRP|ReportPhotoData";

    @NeedParcel
    public long clientTime;
    public long operationId;

    @NeedParcel
    public long operationPriority;

    @NeedParcel
    public long operationType;

    @NeedParcel
    public int photoID;

    @NeedParcel
    public String photoPath;

    /* loaded from: classes37.dex */
    class a implements IDBCacheDataWrapper.a<ReportPhotoData> {
        a() {
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ReportPhotoData createFromCursor(Cursor cursor) {
            ReportPhotoData reportPhotoData = new ReportPhotoData();
            reportPhotoData.clientTime = cursor.getLong(cursor.getColumnIndex(ReportPhotoData.COLUMN_CLIENT_TIME));
            reportPhotoData.operationType = cursor.getLong(cursor.getColumnIndex(ReportPhotoData.COLUMN_OPERATION_TYPE));
            reportPhotoData.operationPriority = cursor.getLong(cursor.getColumnIndex(ReportPhotoData.COLUMN_OPERATION_PRIORITY));
            reportPhotoData.photoID = cursor.getInt(cursor.getColumnIndex(ReportPhotoData.COLUMN_PHOTO_ID));
            reportPhotoData.photoPath = cursor.getString(cursor.getColumnIndex(ReportPhotoData.COLUMN_PHOTO_PATH));
            reportPhotoData.operationId = cursor.getLong(cursor.getColumnIndex(ReportPhotoData.COLUMN_OPERATION_ID));
            return reportPhotoData;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public String sortOrder() {
            return null;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public IDBCacheDataWrapper.c[] structure() {
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c(ReportPhotoData.COLUMN_OPERATION_TYPE, ReportPhotoData.OPERATION_TYPE_TYPE), new IDBCacheDataWrapper.c(ReportPhotoData.COLUMN_PHOTO_PATH, ReportPhotoData.PHOTO_PATH_TYPE), new IDBCacheDataWrapper.c(ReportPhotoData.COLUMN_PHOTO_ID, ReportPhotoData.PHOTO_ID_TYPE), new IDBCacheDataWrapper.c(ReportPhotoData.COLUMN_CLIENT_TIME, ReportPhotoData.CLIENT_TIME_TYPE), new IDBCacheDataWrapper.c(ReportPhotoData.COLUMN_OPERATION_PRIORITY, ReportPhotoData.OPERATION_PRIORITY_TYPE), new IDBCacheDataWrapper.c(ReportPhotoData.COLUMN_OPERATION_ID, ReportPhotoData.OPERATION_ID_TYPE)};
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return ReportPhotoData.DB_VERSION;
        }
    }

    public static ReportPhotoData createReportPhotoData(long j3, long j16, String str, int i3, long j17) {
        ReportPhotoData reportPhotoData = new ReportPhotoData();
        reportPhotoData.operationType = j3;
        reportPhotoData.operationId = j16;
        reportPhotoData.photoPath = str;
        reportPhotoData.photoID = i3;
        reportPhotoData.clientTime = j17;
        reportPhotoData.calculatePriority(j3);
        return reportPhotoData;
    }

    public boolean isPhotoDataValid() {
        if (TextUtils.isEmpty(this.photoPath)) {
            return false;
        }
        return new File(this.photoPath).exists();
    }

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        contentValues.put(COLUMN_OPERATION_TYPE, Long.valueOf(this.operationType));
        contentValues.put(COLUMN_PHOTO_PATH, this.photoPath);
        contentValues.put(COLUMN_PHOTO_ID, Integer.valueOf(this.photoID));
        contentValues.put(COLUMN_CLIENT_TIME, Long.valueOf(this.clientTime));
        contentValues.put(COLUMN_OPERATION_PRIORITY, Long.valueOf(this.operationPriority));
        contentValues.put(COLUMN_OPERATION_ID, Long.valueOf(this.operationId));
    }

    public void calculatePriority(long j3) {
        this.operationPriority = j3 * 1;
    }
}
