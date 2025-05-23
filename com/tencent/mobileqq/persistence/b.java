package com.tencent.mobileqq.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.mobileqq.data.ExpiredPushBanner;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b extends OGAbstractDao {
    public b() {
        this.columnLen = 3;
    }

    @Override // com.tencent.mobileqq.persistence.OGAbstractDao
    public Entity cursor2Entity(Entity entity, Cursor cursor, boolean z16, NoColumnErrorHandler noColumnErrorHandler) {
        ExpiredPushBanner expiredPushBanner = (ExpiredPushBanner) entity;
        if (noColumnErrorHandler == null) {
            int columnIndex = cursor.getColumnIndex("cid");
            int columnIndex2 = cursor.getColumnIndex("md5");
            int columnIndex3 = cursor.getColumnIndex(AEEditorConstants.VIDEO_CLIP_END_TIME);
            if (columnIndex >= 0) {
                expiredPushBanner.cid = cursor.getLong(columnIndex);
            }
            if (columnIndex2 >= 0) {
                expiredPushBanner.md5 = cursor.getString(columnIndex2);
            }
            if (columnIndex3 >= 0) {
                expiredPushBanner.endtime = cursor.getLong(columnIndex3);
            }
        } else {
            int columnIndex4 = cursor.getColumnIndex("cid");
            if (columnIndex4 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("cid", Long.TYPE));
            } else {
                expiredPushBanner.cid = cursor.getLong(columnIndex4);
            }
            int columnIndex5 = cursor.getColumnIndex("md5");
            if (columnIndex5 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("md5", String.class));
            } else {
                expiredPushBanner.md5 = cursor.getString(columnIndex5);
            }
            int columnIndex6 = cursor.getColumnIndex(AEEditorConstants.VIDEO_CLIP_END_TIME);
            if (columnIndex6 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError(AEEditorConstants.VIDEO_CLIP_END_TIME, Long.TYPE));
            } else {
                expiredPushBanner.endtime = cursor.getLong(columnIndex6);
            }
        }
        return expiredPushBanner;
    }

    @Override // com.tencent.mobileqq.persistence.OGAbstractDao
    public void entity2ContentValues(Entity entity, ContentValues contentValues) {
        ExpiredPushBanner expiredPushBanner = (ExpiredPushBanner) entity;
        contentValues.put("cid", Long.valueOf(expiredPushBanner.cid));
        contentValues.put("md5", expiredPushBanner.md5);
        contentValues.put(AEEditorConstants.VIDEO_CLIP_END_TIME, Long.valueOf(expiredPushBanner.endtime));
    }

    @Override // com.tencent.mobileqq.persistence.OGAbstractDao
    public String getCreateTableSql(String str) {
        return "CREATE TABLE IF NOT EXISTS " + str + " (_id INTEGER PRIMARY KEY AUTOINCREMENT ,cid INTEGER UNIQUE ,md5 TEXT ,endtime INTEGER)";
    }
}
