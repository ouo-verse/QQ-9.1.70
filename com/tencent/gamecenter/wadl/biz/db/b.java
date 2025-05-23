package com.tencent.gamecenter.wadl.biz.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.gamecenter.wadl.biz.entity.GameNoticeInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes6.dex */
public class b extends a {
    public b() {
        super(MobileQQ.sMobileQQ, WadlProxyConsts.TABLE_NAME_NOTICE);
        a();
    }

    private void a() {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        if (writableDatabase == null) {
            QLog.w("Wadl_QQGameNoticeDBHelper", 1, "clearOldTable dbWriter is null");
            return;
        }
        try {
            writableDatabase.execSQL("DROP TABLE IF EXISTS NOTICE");
        } finally {
            try {
            } finally {
            }
        }
    }

    private ContentValues c(GameNoticeInfo gameNoticeInfo) {
        if (gameNoticeInfo == null) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("appId", gameNoticeInfo.f106722d);
        contentValues.put("packageName", gameNoticeInfo.f106724f);
        contentValues.put("versionCode", Integer.valueOf(gameNoticeInfo.f106725h));
        contentValues.put(WadlProxyConsts.CHANNEL, gameNoticeInfo.f106726i);
        contentValues.put("name", gameNoticeInfo.f106723e);
        contentValues.put("savePath", gameNoticeInfo.f106727m);
        contentValues.put(WadlProxyConsts.BANNER_TYPE, Integer.valueOf(gameNoticeInfo.F));
        contentValues.put(WadlProxyConsts.CREATE_TIME, Long.valueOf(gameNoticeInfo.C));
        contentValues.put("actionFrom", Integer.valueOf(gameNoticeInfo.D));
        contentValues.put("iconUrl", gameNoticeInfo.E);
        contentValues.put(WadlProxyConsts.LAST_UPDATE_TIME, Long.valueOf(gameNoticeInfo.G));
        return contentValues;
    }

    public boolean b(String str) {
        if (execDelSQL("appId=?", new String[]{str}) > 0) {
            return true;
        }
        return false;
    }

    public List<GameNoticeInfo> d() {
        String str;
        String str2;
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase readableDatabase = getReadableDatabase();
        String str3 = "Wadl_QQGameNoticeDBHelper";
        if (readableDatabase == null) {
            QLog.w("Wadl_QQGameNoticeDBHelper", 1, "queryAll dbReader is null");
            return arrayList;
        }
        QLog.w("Wadl_QQGameNoticeDBHelper", 1, "queryAll dbReader version=" + readableDatabase.getVersion());
        Cursor cursor = null;
        try {
            cursor = readableDatabase.rawQuery("select * from " + this.tableName, null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    int columnIndex = cursor.getColumnIndex("appId");
                    int columnIndex2 = cursor.getColumnIndex("packageName");
                    int columnIndex3 = cursor.getColumnIndex("versionCode");
                    int columnIndex4 = cursor.getColumnIndex(WadlProxyConsts.CHANNEL);
                    int columnIndex5 = cursor.getColumnIndex("name");
                    int columnIndex6 = cursor.getColumnIndex("savePath");
                    int columnIndex7 = cursor.getColumnIndex(WadlProxyConsts.BANNER_TYPE);
                    int columnIndex8 = cursor.getColumnIndex(WadlProxyConsts.CREATE_TIME);
                    int columnIndex9 = cursor.getColumnIndex("actionFrom");
                    int columnIndex10 = cursor.getColumnIndex("iconUrl");
                    int columnIndex11 = cursor.getColumnIndex(WadlProxyConsts.LAST_UPDATE_TIME);
                    if (columnIndex >= 0 && columnIndex2 >= 0 && columnIndex3 >= 0 && columnIndex4 >= 0 && columnIndex5 >= 0 && columnIndex6 >= 0 && columnIndex7 >= 0 && columnIndex8 >= 0 && columnIndex9 >= 0 && columnIndex10 >= 0 && columnIndex11 >= 0) {
                        str = str3;
                        try {
                            GameNoticeInfo gameNoticeInfo = new GameNoticeInfo();
                            gameNoticeInfo.f106722d = cursor.getString(columnIndex);
                            gameNoticeInfo.f106724f = cursor.getString(columnIndex2);
                            gameNoticeInfo.f106725h = cursor.getInt(columnIndex3);
                            gameNoticeInfo.f106726i = cursor.getString(columnIndex4);
                            gameNoticeInfo.f106723e = cursor.getString(columnIndex5);
                            gameNoticeInfo.f106727m = cursor.getString(columnIndex6);
                            gameNoticeInfo.F = cursor.getInt(columnIndex7);
                            gameNoticeInfo.C = cursor.getLong(columnIndex8);
                            gameNoticeInfo.D = cursor.getInt(columnIndex9);
                            gameNoticeInfo.E = cursor.getString(columnIndex10);
                            gameNoticeInfo.G = cursor.getLong(columnIndex11);
                            gameNoticeInfo.o();
                            arrayList.add(gameNoticeInfo);
                            str3 = str;
                        } catch (Throwable th5) {
                            th = th5;
                            try {
                                str2 = str;
                                QLog.e(str2, 1, "queryAll " + this.tableName + " exception:" + th.getMessage());
                                QLog.i(str2, 1, "queryAll list size=" + arrayList.size());
                                return arrayList;
                            } finally {
                                GameCenterUtil.closeIO(cursor);
                                GameCenterUtil.closeIO(readableDatabase);
                            }
                        }
                    }
                }
            }
            GameCenterUtil.closeIO(cursor);
            GameCenterUtil.closeIO(readableDatabase);
            str2 = str3;
        } catch (Throwable th6) {
            th = th6;
            str = str3;
        }
        QLog.i(str2, 1, "queryAll list size=" + arrayList.size());
        return arrayList;
    }

    public boolean e(GameNoticeInfo gameNoticeInfo) {
        long j3;
        ContentValues c16 = c(gameNoticeInfo);
        if (c16 != null) {
            j3 = execReplaceSQL(c16);
        } else {
            QLog.w("Wadl_QQGameNoticeDBHelper", 1, "replace error, cv is null");
            j3 = 0;
        }
        if (j3 > 0) {
            return true;
        }
        return false;
    }

    public boolean f(GameNoticeInfo gameNoticeInfo) {
        if (execUpdSQL("appId=?", new String[]{gameNoticeInfo.f106722d}, c(gameNoticeInfo)) > 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.gamecenter.wadl.biz.db.a
    public String getCreateTableFields() {
        return WadlProxyConsts.NOTICE_TABLE_FIELDS;
    }

    @Override // com.tencent.gamecenter.wadl.biz.db.a
    public String getTableKey() {
        return "appId";
    }
}
