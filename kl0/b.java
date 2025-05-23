package kl0;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.f;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes6.dex */
public class b extends com.tencent.gamecenter.wadl.biz.db.a {

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f412623d = {"appid", "status", "packageName", "savePath", WadlProxyConsts.FLAGS};

    public b() {
        super(MobileQQ.sMobileQQ, "TASKS_1");
    }

    private f b(String str, String[] strArr) {
        f fVar;
        SQLiteDatabase readableDatabase = getReadableDatabase();
        Cursor cursor = null;
        r9 = null;
        f fVar2 = null;
        if (readableDatabase == null) {
            return null;
        }
        try {
            Cursor query = readableDatabase.query(this.tableName, f412623d, str, strArr, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToNext()) {
                        int columnIndex = query.getColumnIndex("appId");
                        int columnIndex2 = query.getColumnIndex("status");
                        int columnIndex3 = query.getColumnIndex("packageName");
                        int columnIndex4 = query.getColumnIndex("savePath");
                        int columnIndex5 = query.getColumnIndex(WadlProxyConsts.FLAGS);
                        if (columnIndex >= 0 && columnIndex2 >= 0 && columnIndex3 >= 0 && columnIndex4 >= 0 && columnIndex5 >= 0) {
                            fVar = new f();
                            try {
                                fVar.appId = query.getString(columnIndex);
                                fVar.taskStatus = query.getInt(columnIndex2);
                                fVar.pkgName = query.getString(columnIndex3);
                                fVar.downloadFilePath = query.getString(columnIndex4);
                                fVar.flags = query.getInt(columnIndex5);
                                fVar2 = fVar;
                            } catch (Throwable th5) {
                                th = th5;
                                cursor = query;
                                try {
                                    QLog.e("Wadl_QQGameTaskSimpleDBHelper", 1, "findTask " + this.tableName + " whereValue=" + Arrays.toString(strArr) + "\uff0cexception:" + th.getMessage());
                                    GameCenterUtil.closeIO(cursor);
                                    GameCenterUtil.closeIO(readableDatabase);
                                    return fVar;
                                } catch (Throwable th6) {
                                    GameCenterUtil.closeIO(cursor);
                                    GameCenterUtil.closeIO(readableDatabase);
                                    throw th6;
                                }
                            }
                        }
                        GameCenterUtil.closeIO(query);
                        GameCenterUtil.closeIO(readableDatabase);
                        return null;
                    }
                } catch (Throwable th7) {
                    th = th7;
                    fVar = null;
                }
            }
            GameCenterUtil.closeIO(query);
            GameCenterUtil.closeIO(readableDatabase);
            return fVar2;
        } catch (Throwable th8) {
            th = th8;
            fVar = null;
        }
    }

    public boolean a(String str) {
        return exists("packageName=?", new String[]{str}, "packageName");
    }

    public f c(String str) {
        return b("packageName=? and via!=?", new String[]{str, WadlProxyConsts.VIA_MINI_APP});
    }

    public f d(String str) {
        return b("appId=?", new String[]{str});
    }

    @Override // com.tencent.gamecenter.wadl.biz.db.a
    public String getCreateTableFields() {
        return WadlProxyConsts.GAMECENTER_TABLE_FIELDS;
    }

    @Override // com.tencent.gamecenter.wadl.biz.db.a
    public String getTableKey() {
        return "appId";
    }

    @Override // com.tencent.gamecenter.wadl.biz.db.a, android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        super.onUpgrade(sQLiteDatabase, i3, i16);
        QLog.i("Wadl_QQGameTaskSimpleDBHelper", 1, "onUpgrade oldVersion=" + i3 + ",newVersion=" + i16);
        try {
            sQLiteDatabase.beginTransaction();
            if (i3 < 36) {
                sQLiteDatabase.execSQL("ALTER TABLE " + this.tableName + " ADD downloadType INTEGER");
            }
            if (i3 < 35) {
                sQLiteDatabase.execSQL("ALTER TABLE " + this.tableName + " ADD mieActId LONG");
            }
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }
}
