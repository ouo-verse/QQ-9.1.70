package com.tencent.mobileqq.qwallet.transaction.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteClosable;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class a extends SQLiteOpenHelper {
    public a(Context context) {
        super(context, "QWalletNotifyMsg.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(" CREATE TABLE IF NOT EXISTS " + QQPermissionConstants.Permission.AUIDO_GROUP + " (no INTEGER PRIMARY KEY AUTOINCREMENT, uin INTEGER(64) DEFAULT 0, btype INTEGER(16) DEFAULT 0, bid VARCHAR(64) , " + AlbumCacheData.CREATE_TIME + " INTEGER(64) DEFAULT 0, ext VARCHAR(128) )");
    }

    public void a(long j3, int[] iArr) {
        SQLiteDatabase writableDatabase;
        if (j3 <= 0) {
            return;
        }
        long serverTime = NetConnInfoCenter.getServerTime();
        SQLiteClosable sQLiteClosable = null;
        try {
            try {
                try {
                    writableDatabase = getWritableDatabase();
                    if (iArr != null && iArr.length > 0) {
                        StringBuilder sb5 = new StringBuilder();
                        int i3 = 0;
                        while (i3 < iArr.length) {
                            sb5.append(iArr[i3]);
                            i3++;
                            if (i3 < iArr.length) {
                                sb5.append(',');
                            }
                        }
                        writableDatabase.delete(QQPermissionConstants.Permission.AUIDO_GROUP, " btype in (" + sb5.toString() + ") AND" + AlbumCacheData.CREATE_TIME + "< ? ", new String[]{String.valueOf(serverTime - j3)});
                    } else {
                        writableDatabase.delete(QQPermissionConstants.Permission.AUIDO_GROUP, " create_time< ? ", new String[]{String.valueOf(serverTime - j3)});
                    }
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.i("NotifyMsgDBHelper", 2, "clearOverTimeRecords err:" + e16.getMessage());
                    }
                    if (0 != 0) {
                        sQLiteClosable.close();
                    } else {
                        return;
                    }
                }
                if (writableDatabase != null) {
                    writableDatabase.close();
                }
            } catch (Throwable th5) {
                if (0 != 0) {
                    try {
                        sQLiteClosable.close();
                    } catch (Exception e17) {
                        QLog.e("NotifyMsgDBHelper", 1, "error msg in qqpay-impl module: ", e17);
                    }
                }
                throw th5;
            }
        } catch (Exception e18) {
            QLog.e("NotifyMsgDBHelper", 1, "error msg in qqpay-impl module: ", e18);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x0101 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(String str, List<b> list) {
        SQLiteDatabase sQLiteDatabase;
        Throwable th5;
        Exception e16;
        if (str != null && list != null && list.size() > 0) {
            try {
                try {
                    sQLiteDatabase = getWritableDatabase();
                } catch (Exception e17) {
                    sQLiteDatabase = null;
                    e16 = e17;
                } catch (Throwable th6) {
                    sQLiteDatabase = null;
                    th5 = th6;
                    if (sQLiteDatabase != null) {
                    }
                    throw th5;
                }
                try {
                    try {
                        for (b bVar : list) {
                            if (bVar != null) {
                                ContentValues contentValues = new ContentValues();
                                contentValues.put("uin", Long.valueOf(bVar.f279236b));
                                contentValues.put("btype", Integer.valueOf(bVar.f279237c));
                                String str2 = bVar.f279238d;
                                String str3 = "";
                                if (str2 == null) {
                                    str2 = "";
                                }
                                contentValues.put("bid", str2);
                                contentValues.put(AlbumCacheData.CREATE_TIME, Long.valueOf(NetConnInfoCenter.getServerTime()));
                                JSONObject jSONObject = bVar.f279240f;
                                if (jSONObject != null) {
                                    str3 = jSONObject.toString();
                                }
                                contentValues.put("ext", str3);
                                try {
                                    sQLiteDatabase.insertOrThrow(QQPermissionConstants.Permission.AUIDO_GROUP, null, contentValues);
                                    if (QLog.isColorLevel()) {
                                        QLog.i("NotifyMsgDBHelper", 2, "insert bId:" + bVar.f279238d);
                                    }
                                } catch (Exception e18) {
                                    if (QLog.isColorLevel()) {
                                        QLog.i("NotifyMsgDBHelper", 2, "insert err bId:" + bVar.f279238d + " " + e18.getMessage());
                                    }
                                }
                            }
                        }
                    } catch (Throwable th7) {
                        th5 = th7;
                        if (sQLiteDatabase != null) {
                            try {
                                sQLiteDatabase.close();
                            } catch (Exception e19) {
                                QLog.e("NotifyMsgDBHelper", 1, "error msg in qqpay-impl module: ", e19);
                            }
                        }
                        throw th5;
                    }
                } catch (Exception e26) {
                    e16 = e26;
                    if (QLog.isColorLevel()) {
                        QLog.i("NotifyMsgDBHelper", 2, "insert err:" + e16.getMessage());
                    }
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    return;
                }
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
            } catch (Exception e27) {
                QLog.e("NotifyMsgDBHelper", 1, "error msg in qqpay-impl module: ", e27);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x00c2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00b2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(String str, List<b> list) {
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor;
        if (str != null && list != null) {
            list.clear();
            Cursor cursor2 = null;
            cursor2 = null;
            cursor2 = null;
            cursor2 = null;
            SQLiteDatabase sQLiteDatabase2 = null;
            try {
                try {
                    sQLiteDatabase = getReadableDatabase();
                    if (sQLiteDatabase != null) {
                        try {
                            cursor2 = sQLiteDatabase.rawQuery("SELECT * FROM record where uin=" + str, null);
                            if (cursor2 != null && cursor2.getCount() > 0) {
                                cursor2.moveToFirst();
                                while (!cursor2.isAfterLast()) {
                                    b a16 = b.a(cursor2);
                                    if (a16 != null) {
                                        list.add(a16);
                                    }
                                    cursor2.moveToNext();
                                }
                            }
                            if (cursor2 != null) {
                                cursor2.close();
                            }
                        } catch (Exception e16) {
                            e = e16;
                            cursor = cursor2;
                            sQLiteDatabase2 = sQLiteDatabase;
                            try {
                                if (QLog.isColorLevel()) {
                                    QLog.i("NotifyMsgDBHelper", 2, "queryAll err:" + e.getMessage());
                                }
                                if (cursor != null) {
                                    try {
                                        if (!cursor.isClosed()) {
                                            cursor.close();
                                        }
                                    } catch (Exception e17) {
                                        QLog.e("NotifyMsgDBHelper", 1, "error msg in qqpay-impl module: ", e17);
                                    }
                                }
                                if (sQLiteDatabase2 != null) {
                                    sQLiteDatabase2.close();
                                }
                                return;
                            } catch (Throwable th5) {
                                th = th5;
                                sQLiteDatabase = sQLiteDatabase2;
                                cursor2 = cursor;
                                if (cursor2 != null) {
                                    try {
                                        if (!cursor2.isClosed()) {
                                            cursor2.close();
                                        }
                                    } catch (Exception e18) {
                                        QLog.e("NotifyMsgDBHelper", 1, "error msg in qqpay-impl module: ", e18);
                                    }
                                }
                                if (sQLiteDatabase == null) {
                                    try {
                                        sQLiteDatabase.close();
                                        throw th;
                                    } catch (Exception e19) {
                                        QLog.e("NotifyMsgDBHelper", 1, "error msg in qqpay-impl module: ", e19);
                                        throw th;
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            if (cursor2 != null) {
                            }
                            if (sQLiteDatabase == null) {
                            }
                        }
                    }
                    if (cursor2 != null) {
                        try {
                            if (!cursor2.isClosed()) {
                                cursor2.close();
                            }
                        } catch (Exception e26) {
                            QLog.e("NotifyMsgDBHelper", 1, "error msg in qqpay-impl module: ", e26);
                        }
                    }
                } catch (Exception e27) {
                    e = e27;
                    cursor = null;
                } catch (Throwable th7) {
                    th = th7;
                    sQLiteDatabase = null;
                }
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
            } catch (Exception e28) {
                QLog.e("NotifyMsgDBHelper", 1, "error msg in qqpay-impl module: ", e28);
            }
        }
    }

    public void e(String str, List<b> list) {
        if (str != null && list != null && list.size() > 0) {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                try {
                    try {
                        sQLiteDatabase = getWritableDatabase();
                        for (b bVar : list) {
                            if (bVar != null) {
                                ContentValues contentValues = new ContentValues();
                                contentValues.put("uin", Long.valueOf(bVar.f279236b));
                                contentValues.put("btype", Integer.valueOf(bVar.f279237c));
                                String str2 = bVar.f279238d;
                                String str3 = "";
                                if (str2 == null) {
                                    str2 = "";
                                }
                                contentValues.put("bid", str2);
                                JSONObject jSONObject = bVar.f279240f;
                                if (jSONObject != null) {
                                    str3 = jSONObject.toString();
                                }
                                contentValues.put("ext", str3);
                                try {
                                    sQLiteDatabase.update(QQPermissionConstants.Permission.AUIDO_GROUP, contentValues, " uin= ?  AND btype= ?  AND bid= ? ", new String[]{str, String.valueOf(bVar.f279237c), bVar.f279238d});
                                    if (QLog.isColorLevel()) {
                                        QLog.i("NotifyMsgDBHelper", 2, "update bId:" + bVar.f279238d);
                                    }
                                } catch (Exception e16) {
                                    if (QLog.isColorLevel()) {
                                        QLog.i("NotifyMsgDBHelper", 2, "update err bId:" + bVar.f279238d + " " + e16.getMessage());
                                    }
                                }
                            }
                        }
                    } catch (Exception e17) {
                        if (QLog.isColorLevel()) {
                            QLog.i("NotifyMsgDBHelper", 2, "update err:" + e17.getMessage());
                        }
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.close();
                        } else {
                            return;
                        }
                    }
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                } catch (Throwable th5) {
                    if (sQLiteDatabase != null) {
                        try {
                            sQLiteDatabase.close();
                        } catch (Exception e18) {
                            QLog.e("NotifyMsgDBHelper", 1, "error msg in qqpay-impl module: ", e18);
                        }
                    }
                    throw th5;
                }
            } catch (Exception e19) {
                QLog.e("NotifyMsgDBHelper", 1, "error msg in qqpay-impl module: ", e19);
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        b(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
    }
}
