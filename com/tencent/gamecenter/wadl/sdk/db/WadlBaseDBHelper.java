package com.tencent.gamecenter.wadl.sdk.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.gamecenter.wadl.biz.db.a;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.sdk.dlmgr.WadlTask;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

/* compiled from: P */
/* loaded from: classes6.dex */
public abstract class WadlBaseDBHelper extends a implements Observer {
    public static final int ACTION_INSERT = 0;
    public static final int ACTION_UPDATE = 1;
    public static final String TAG = "Wadl_WadlBaseDBHelper";
    protected String tableName;

    public WadlBaseDBHelper(Context context, String str) {
        super(context, str);
        this.tableName = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long addWadlTask(WadlResult wadlResult) {
        QLog.d(TAG, 1, "addWadlTask to db: " + wadlResult);
        ContentValues contentValue = getContentValue(wadlResult, 0);
        if (contentValue != null) {
            return execInsertSQL(contentValue);
        }
        QLog.w(TAG, 1, "addWadlTask error task error");
        return 0L;
    }

    public List<WadlTask> execQueryAllSQL() {
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase readableDatabase = getReadableDatabase();
        if (readableDatabase == null) {
            return arrayList;
        }
        Cursor cursor = null;
        try {
            cursor = readableDatabase.rawQuery("select * from " + this.tableName, null);
            while (cursor != null) {
                if (!cursor.moveToNext()) {
                    break;
                }
                WadlTask parseCursorToTask = parseCursorToTask(cursor);
                if (parseCursorToTask != null) {
                    arrayList.add(parseCursorToTask);
                }
            }
        } finally {
            try {
                return arrayList;
            } finally {
            }
        }
        return arrayList;
    }

    public List<WadlTask> execQuerySQL(String str, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase readableDatabase = getReadableDatabase();
        if (readableDatabase == null) {
            return arrayList;
        }
        Cursor cursor = null;
        try {
            cursor = readableDatabase.query(this.tableName, new String[]{"*"}, str, strArr, null, null, null);
            while (cursor != null) {
                if (!cursor.moveToNext()) {
                    break;
                }
                WadlTask parseCursorToTask = parseCursorToTask(cursor);
                if (parseCursorToTask != null) {
                    arrayList.add(parseCursorToTask);
                }
            }
        } finally {
            try {
                return arrayList;
            } finally {
            }
        }
        return arrayList;
    }

    abstract ContentValues getContentValue(WadlResult wadlResult, int i3);

    abstract WadlTask parseCursorToTask(Cursor cursor);
}
