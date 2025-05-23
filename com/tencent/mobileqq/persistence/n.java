package com.tencent.mobileqq.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import com.qzone.module.covercomponent.model.CoverDBCacheData;
import com.tencent.mobileqq.data.QZoneCover;

/* compiled from: P */
/* loaded from: classes16.dex */
public class n extends OGAbstractDao {
    public n() {
        this.columnLen = 5;
    }

    @Override // com.tencent.mobileqq.persistence.OGAbstractDao
    public Entity cursor2Entity(Entity entity, Cursor cursor, boolean z16, NoColumnErrorHandler noColumnErrorHandler) {
        QZoneCover qZoneCover = (QZoneCover) entity;
        if (noColumnErrorHandler == null) {
            qZoneCover.uin = cursor.getString(cursor.getColumnIndex("uin"));
            qZoneCover.type = cursor.getString(cursor.getColumnIndex("type"));
            qZoneCover.jigsaw = cursor.getInt(cursor.getColumnIndex(CoverDBCacheData.JIGSAW));
            qZoneCover.vCoverInfo = cursor.getBlob(cursor.getColumnIndex("vCoverInfo"));
            qZoneCover.vPhotoInfo = cursor.getBlob(cursor.getColumnIndex("vPhotoInfo"));
        } else {
            int columnIndex = cursor.getColumnIndex("uin");
            if (columnIndex == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("uin", String.class));
            } else {
                qZoneCover.uin = cursor.getString(columnIndex);
            }
            int columnIndex2 = cursor.getColumnIndex("type");
            if (columnIndex2 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("type", String.class));
            } else {
                qZoneCover.type = cursor.getString(columnIndex2);
            }
            int columnIndex3 = cursor.getColumnIndex(CoverDBCacheData.JIGSAW);
            if (columnIndex3 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError(CoverDBCacheData.JIGSAW, Integer.TYPE));
            } else {
                qZoneCover.jigsaw = cursor.getInt(columnIndex3);
            }
            int columnIndex4 = cursor.getColumnIndex("vCoverInfo");
            if (columnIndex4 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("vCoverInfo", byte[].class));
            } else {
                qZoneCover.vCoverInfo = cursor.getBlob(columnIndex4);
            }
            int columnIndex5 = cursor.getColumnIndex("vPhotoInfo");
            if (columnIndex5 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("vPhotoInfo", byte[].class));
            } else {
                qZoneCover.vPhotoInfo = cursor.getBlob(columnIndex5);
            }
        }
        return qZoneCover;
    }

    @Override // com.tencent.mobileqq.persistence.OGAbstractDao
    public void entity2ContentValues(Entity entity, ContentValues contentValues) {
        QZoneCover qZoneCover = (QZoneCover) entity;
        contentValues.put("uin", qZoneCover.uin);
        contentValues.put("type", qZoneCover.type);
        contentValues.put(CoverDBCacheData.JIGSAW, Integer.valueOf(qZoneCover.jigsaw));
        contentValues.put("vCoverInfo", qZoneCover.vCoverInfo);
        contentValues.put("vPhotoInfo", qZoneCover.vPhotoInfo);
    }

    @Override // com.tencent.mobileqq.persistence.OGAbstractDao
    public String getCreateTableSql(String str) {
        return "CREATE TABLE IF NOT EXISTS " + str + " (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT UNIQUE ,type TEXT ,jigsaw INTEGER ,vCoverInfo BLOB ,vPhotoInfo BLOB)";
    }
}
