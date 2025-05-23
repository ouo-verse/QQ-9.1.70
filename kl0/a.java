package kl0;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a extends com.tencent.gamecenter.wadl.biz.db.a {

    /* renamed from: d, reason: collision with root package name */
    private static String[] f412622d = {"appId", "resName", "status", WadlProxyConsts.RES_MD5, "totalSize", "downloadSize"};

    public a() {
        super(MobileQQ.sMobileQQ, "TASKS_2");
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00e6, code lost:
    
        return r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00e3, code lost:
    
        if (r11 == null) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArrayList<com.tencent.gamecenter.wadl.biz.entity.c> a(String str, int i3) {
        SQLiteDatabase readableDatabase = getReadableDatabase();
        Cursor cursor = null;
        if (readableDatabase == null) {
            return null;
        }
        QLog.i("Wadl_QQGameResDBHelper", 1, "execQueryByType pkgName=" + str + ",resType=" + i3);
        ArrayList<com.tencent.gamecenter.wadl.biz.entity.c> arrayList = new ArrayList<>();
        try {
            cursor = readableDatabase.query(this.tableName, f412622d, "packageName=? and resType=?", new String[]{str, String.valueOf(i3)}, null, null, null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    int columnIndex = cursor.getColumnIndex("appId");
                    int columnIndex2 = cursor.getColumnIndex("resName");
                    int columnIndex3 = cursor.getColumnIndex("status");
                    int columnIndex4 = cursor.getColumnIndex(WadlProxyConsts.RES_MD5);
                    int columnIndex5 = cursor.getColumnIndex("totalSize");
                    int columnIndex6 = cursor.getColumnIndex("downloadSize");
                    if (columnIndex >= 0 && columnIndex2 >= 0 && columnIndex3 >= 0 && columnIndex4 >= 0 && columnIndex5 >= 0 && columnIndex6 >= 0) {
                        arrayList.add(new com.tencent.gamecenter.wadl.biz.entity.c(cursor.getString(columnIndex), cursor.getString(columnIndex2), cursor.getInt(columnIndex3), cursor.getString(columnIndex4), cursor.getLong(columnIndex5), cursor.getLong(columnIndex6)));
                    }
                }
            }
        } catch (Throwable th5) {
            try {
                QLog.e("Wadl_QQGameResDBHelper", 1, "execQueryByType " + this.tableName + " resType=" + i3 + " exception:" + th5.getMessage());
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
    }

    @Override // com.tencent.gamecenter.wadl.biz.db.a
    public String getCreateTableFields() {
        return WadlProxyConsts.RES_TABLE_FIELDS;
    }

    @Override // com.tencent.gamecenter.wadl.biz.db.a
    public String getTableKey() {
        return "resId";
    }
}
