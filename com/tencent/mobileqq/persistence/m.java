package com.tencent.mobileqq.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.config.operation.QQOperationViopTipTask;

/* compiled from: P */
/* loaded from: classes16.dex */
public class m extends OGAbstractDao {
    public m() {
        this.columnLen = 16;
    }

    @Override // com.tencent.mobileqq.persistence.OGAbstractDao
    public Entity cursor2Entity(Entity entity, Cursor cursor, boolean z16, NoColumnErrorHandler noColumnErrorHandler) {
        QQOperationViopTipTask qQOperationViopTipTask = (QQOperationViopTipTask) entity;
        if (noColumnErrorHandler == null) {
            qQOperationViopTipTask.taskid = cursor.getInt(cursor.getColumnIndex("taskid"));
            qQOperationViopTipTask.uinType = cursor.getInt(cursor.getColumnIndex("uinType"));
            qQOperationViopTipTask.tipType = cursor.getInt(cursor.getColumnIndex("tipType"));
            qQOperationViopTipTask.adwords = cursor.getString(cursor.getColumnIndex("adwords"));
            qQOperationViopTipTask.clickableWord = cursor.getString(cursor.getColumnIndex("clickableWord"));
            qQOperationViopTipTask.linkOffset = cursor.getInt(cursor.getColumnIndex("linkOffset"));
            qQOperationViopTipTask.url = cursor.getString(cursor.getColumnIndex("url"));
            qQOperationViopTipTask.limitDayAIOCount = cursor.getInt(cursor.getColumnIndex("limitDayAIOCount"));
            qQOperationViopTipTask.limitDayAIOShowCount = cursor.getInt(cursor.getColumnIndex("limitDayAIOShowCount"));
            qQOperationViopTipTask.limitTotalAIOCount = cursor.getInt(cursor.getColumnIndex("limitTotalAIOCount"));
            qQOperationViopTipTask.limitTotalShowCount = cursor.getInt(cursor.getColumnIndex("limitTotalShowCount"));
            qQOperationViopTipTask.keywordString = cursor.getString(cursor.getColumnIndex("keywordString"));
            qQOperationViopTipTask.begin = cursor.getString(cursor.getColumnIndex("begin"));
            qQOperationViopTipTask.end = cursor.getString(cursor.getColumnIndex("end"));
            qQOperationViopTipTask.frequencyTime = cursor.getInt(cursor.getColumnIndex("frequencyTime"));
            qQOperationViopTipTask.frequencyMessage = cursor.getInt(cursor.getColumnIndex("frequencyMessage"));
        } else {
            int columnIndex = cursor.getColumnIndex("taskid");
            if (columnIndex == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("taskid", Integer.TYPE));
            } else {
                qQOperationViopTipTask.taskid = cursor.getInt(columnIndex);
            }
            int columnIndex2 = cursor.getColumnIndex("uinType");
            if (columnIndex2 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("uinType", Integer.TYPE));
            } else {
                qQOperationViopTipTask.uinType = cursor.getInt(columnIndex2);
            }
            int columnIndex3 = cursor.getColumnIndex("tipType");
            if (columnIndex3 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("tipType", Integer.TYPE));
            } else {
                qQOperationViopTipTask.tipType = cursor.getInt(columnIndex3);
            }
            int columnIndex4 = cursor.getColumnIndex("adwords");
            if (columnIndex4 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("adwords", String.class));
            } else {
                qQOperationViopTipTask.adwords = cursor.getString(columnIndex4);
            }
            int columnIndex5 = cursor.getColumnIndex("clickableWord");
            if (columnIndex5 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("clickableWord", String.class));
            } else {
                qQOperationViopTipTask.clickableWord = cursor.getString(columnIndex5);
            }
            int columnIndex6 = cursor.getColumnIndex("linkOffset");
            if (columnIndex6 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("linkOffset", Integer.TYPE));
            } else {
                qQOperationViopTipTask.linkOffset = cursor.getInt(columnIndex6);
            }
            int columnIndex7 = cursor.getColumnIndex("url");
            if (columnIndex7 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("url", String.class));
            } else {
                qQOperationViopTipTask.url = cursor.getString(columnIndex7);
            }
            int columnIndex8 = cursor.getColumnIndex("limitDayAIOCount");
            if (columnIndex8 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("limitDayAIOCount", Integer.TYPE));
            } else {
                qQOperationViopTipTask.limitDayAIOCount = cursor.getInt(columnIndex8);
            }
            int columnIndex9 = cursor.getColumnIndex("limitDayAIOShowCount");
            if (columnIndex9 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("limitDayAIOShowCount", Integer.TYPE));
            } else {
                qQOperationViopTipTask.limitDayAIOShowCount = cursor.getInt(columnIndex9);
            }
            int columnIndex10 = cursor.getColumnIndex("limitTotalAIOCount");
            if (columnIndex10 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("limitTotalAIOCount", Integer.TYPE));
            } else {
                qQOperationViopTipTask.limitTotalAIOCount = cursor.getInt(columnIndex10);
            }
            int columnIndex11 = cursor.getColumnIndex("limitTotalShowCount");
            if (columnIndex11 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("limitTotalShowCount", Integer.TYPE));
            } else {
                qQOperationViopTipTask.limitTotalShowCount = cursor.getInt(columnIndex11);
            }
            int columnIndex12 = cursor.getColumnIndex("keywordString");
            if (columnIndex12 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("keywordString", String.class));
            } else {
                qQOperationViopTipTask.keywordString = cursor.getString(columnIndex12);
            }
            int columnIndex13 = cursor.getColumnIndex("begin");
            if (columnIndex13 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("begin", String.class));
            } else {
                qQOperationViopTipTask.begin = cursor.getString(columnIndex13);
            }
            int columnIndex14 = cursor.getColumnIndex("end");
            if (columnIndex14 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("end", String.class));
            } else {
                qQOperationViopTipTask.end = cursor.getString(columnIndex14);
            }
            int columnIndex15 = cursor.getColumnIndex("frequencyTime");
            if (columnIndex15 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("frequencyTime", Integer.TYPE));
            } else {
                qQOperationViopTipTask.frequencyTime = cursor.getInt(columnIndex15);
            }
            int columnIndex16 = cursor.getColumnIndex("frequencyMessage");
            if (columnIndex16 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("frequencyMessage", Integer.TYPE));
            } else {
                qQOperationViopTipTask.frequencyMessage = cursor.getInt(columnIndex16);
            }
        }
        return qQOperationViopTipTask;
    }

    @Override // com.tencent.mobileqq.persistence.OGAbstractDao
    public void entity2ContentValues(Entity entity, ContentValues contentValues) {
        QQOperationViopTipTask qQOperationViopTipTask = (QQOperationViopTipTask) entity;
        contentValues.put("taskid", Integer.valueOf(qQOperationViopTipTask.taskid));
        contentValues.put("uinType", Integer.valueOf(qQOperationViopTipTask.uinType));
        contentValues.put("tipType", Integer.valueOf(qQOperationViopTipTask.tipType));
        contentValues.put("adwords", qQOperationViopTipTask.adwords);
        contentValues.put("clickableWord", qQOperationViopTipTask.clickableWord);
        contentValues.put("linkOffset", Integer.valueOf(qQOperationViopTipTask.linkOffset));
        contentValues.put("url", qQOperationViopTipTask.url);
        contentValues.put("limitDayAIOCount", Integer.valueOf(qQOperationViopTipTask.limitDayAIOCount));
        contentValues.put("limitDayAIOShowCount", Integer.valueOf(qQOperationViopTipTask.limitDayAIOShowCount));
        contentValues.put("limitTotalAIOCount", Integer.valueOf(qQOperationViopTipTask.limitTotalAIOCount));
        contentValues.put("limitTotalShowCount", Integer.valueOf(qQOperationViopTipTask.limitTotalShowCount));
        contentValues.put("keywordString", qQOperationViopTipTask.keywordString);
        contentValues.put("begin", qQOperationViopTipTask.begin);
        contentValues.put("end", qQOperationViopTipTask.end);
        contentValues.put("frequencyTime", Integer.valueOf(qQOperationViopTipTask.frequencyTime));
        contentValues.put("frequencyMessage", Integer.valueOf(qQOperationViopTipTask.frequencyMessage));
    }

    @Override // com.tencent.mobileqq.persistence.OGAbstractDao
    public String getCreateTableSql(String str) {
        return "CREATE TABLE IF NOT EXISTS " + str + " (_id INTEGER PRIMARY KEY AUTOINCREMENT ,taskid INTEGER ,uinType INTEGER ,tipType INTEGER ,adwords TEXT ,clickableWord TEXT ,linkOffset INTEGER ,url TEXT ,limitDayAIOCount INTEGER ,limitDayAIOShowCount INTEGER ,limitTotalAIOCount INTEGER ,limitTotalShowCount INTEGER ,keywordString TEXT ,begin TEXT ,end TEXT ,frequencyTime INTEGER ,frequencyMessage INTEGER,UNIQUE(taskid) ON CONFLICT REPLACE)";
    }
}
