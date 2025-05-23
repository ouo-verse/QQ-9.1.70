package com.tencent.mobileqq.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.data.ShieldListInfo;

/* compiled from: P */
/* loaded from: classes16.dex */
public class p extends OGAbstractDao {
    public p() {
        this.columnLen = 4;
    }

    @Override // com.tencent.mobileqq.persistence.OGAbstractDao
    public Entity cursor2Entity(Entity entity, Cursor cursor, boolean z16, NoColumnErrorHandler noColumnErrorHandler) {
        ShieldListInfo shieldListInfo = (ShieldListInfo) entity;
        if (noColumnErrorHandler == null) {
            shieldListInfo.uin = cursor.getString(cursor.getColumnIndex("uin"));
            shieldListInfo.flags = cursor.getInt(cursor.getColumnIndex(WadlProxyConsts.FLAGS));
            shieldListInfo.source_id = cursor.getInt(cursor.getColumnIndex("source_id"));
            shieldListInfo.source_sub_id = cursor.getInt(cursor.getColumnIndex("source_sub_id"));
        } else {
            int columnIndex = cursor.getColumnIndex("uin");
            if (columnIndex == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("uin", String.class));
            } else {
                shieldListInfo.uin = cursor.getString(columnIndex);
            }
            int columnIndex2 = cursor.getColumnIndex(WadlProxyConsts.FLAGS);
            if (columnIndex2 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError(WadlProxyConsts.FLAGS, Integer.TYPE));
            } else {
                shieldListInfo.flags = cursor.getInt(columnIndex2);
            }
            int columnIndex3 = cursor.getColumnIndex("source_id");
            if (columnIndex3 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("source_id", Integer.TYPE));
            } else {
                shieldListInfo.source_id = cursor.getInt(columnIndex3);
            }
            int columnIndex4 = cursor.getColumnIndex("source_sub_id");
            if (columnIndex4 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("source_sub_id", Integer.TYPE));
            } else {
                shieldListInfo.source_sub_id = cursor.getInt(columnIndex4);
            }
        }
        return shieldListInfo;
    }

    @Override // com.tencent.mobileqq.persistence.OGAbstractDao
    public void entity2ContentValues(Entity entity, ContentValues contentValues) {
        ShieldListInfo shieldListInfo = (ShieldListInfo) entity;
        contentValues.put("uin", shieldListInfo.uin);
        contentValues.put(WadlProxyConsts.FLAGS, Integer.valueOf(shieldListInfo.flags));
        contentValues.put("source_id", Integer.valueOf(shieldListInfo.source_id));
        contentValues.put("source_sub_id", Integer.valueOf(shieldListInfo.source_sub_id));
    }

    @Override // com.tencent.mobileqq.persistence.OGAbstractDao
    public String getCreateTableSql(String str) {
        return "CREATE TABLE IF NOT EXISTS " + str + " (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT ,flags INTEGER ,source_id INTEGER ,source_sub_id INTEGER,UNIQUE(uin) ON CONFLICT REPLACE)";
    }
}
