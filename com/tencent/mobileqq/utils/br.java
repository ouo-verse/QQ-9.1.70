package com.tencent.mobileqq.utils;

import android.database.Cursor;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.data.MessageRecord;

/* compiled from: P */
/* loaded from: classes20.dex */
public class br {
    public static StringBuilder a(String str, long j3, int i3, long j16, String str2, int i16, SQLiteDatabase sQLiteDatabase) {
        boolean e16 = e(str, sQLiteDatabase);
        if (i3 <= 0) {
            e16 = false;
        }
        if (str2 == null || str2.length() == 0) {
            str2 = "";
        }
        if (e16) {
            StringBuilder sb5 = new StringBuilder("select ");
            sb5.append(MessageRecord.QUERY_NEW_TABLE_FIELDS);
            sb5.append(" , shmsgseq as _index from ");
            sb5.append(str);
            sb5.append(" where shmsgseq>=");
            sb5.append(j16);
            sb5.append(str2);
            sb5.append(" order by shmsgseq asc , _id asc limit ");
            sb5.append(i16);
            return sb5;
        }
        return null;
    }

    public static StringBuilder b(String str, String str2, long j3, int i3, long j16, int i16, SQLiteDatabase sQLiteDatabase, String str3) {
        long j17;
        String str4;
        int count;
        boolean e16 = e(str2, sQLiteDatabase);
        boolean e17 = e(str, sQLiteDatabase);
        if (i3 <= 0) {
            e16 = false;
        }
        if (j16 < 0) {
            j17 = Long.MAX_VALUE;
        } else {
            j17 = j16;
        }
        if (str3 != null && str3.length() != 0) {
            str4 = str3;
        } else {
            str4 = "";
        }
        if (e16 && e17) {
            StringBuilder sb5 = new StringBuilder("select ");
            sb5.append(MessageRecord.QUERY_NEW_TABLE_FIELDS);
            sb5.append(" , time as _index from ( select * from ");
            sb5.append(str2);
            sb5.append(" where time<");
            sb5.append(j17);
            sb5.append(str4);
            sb5.append(") order by time desc, _id desc");
            long j18 = j17;
            Cursor rawQuery = sQLiteDatabase.rawQuery(sb5.toString(), null);
            if (rawQuery == null) {
                count = 0;
            } else {
                count = rawQuery.getCount();
                rawQuery.close();
            }
            if (count >= i16) {
                sb5.append(" limit ");
                sb5.append(i16);
                StringBuilder sb6 = new StringBuilder("select * from ( ");
                sb6.append((CharSequence) sb5);
                sb6.append(") order by time desc, _id desc");
                return sb6;
            }
            StringBuilder sb7 = new StringBuilder("select * from ( ");
            sb7.append("select ");
            sb7.append(MessageRecord.QUERY_OLD_TABLE_FIELDS);
            sb7.append(" , -1 as _index from ( select * from ");
            sb7.append(str);
            sb7.append(" where _id<=( select _id from ");
            sb7.append(str);
            sb7.append(" where time<( select time from ");
            sb7.append(str2);
            sb7.append(" order by time asc limit 1) order by time desc limit 1) ");
            sb7.append(str4);
            sb7.append("order by _id desc limit ");
            sb7.append(i16 - count);
            sb7.append(") ");
            sb7.append("union select ");
            sb7.append(MessageRecord.QUERY_NEW_TABLE_FIELDS);
            sb7.append(" , time as _index from ( select * from ");
            sb7.append(str2);
            sb7.append(" where time<");
            sb7.append(j18);
            sb7.append(str4);
            sb7.append(") order by _index desc, _id desc)");
            return sb7;
        }
        if (e17) {
            StringBuilder sb8 = new StringBuilder("select * from ( select ");
            sb8.append(MessageRecord.QUERY_OLD_TABLE_FIELDS);
            sb8.append(" , -1 as _index from ");
            sb8.append(str);
            sb8.append(" where _id<");
            sb8.append(j3);
            sb8.append(str4);
            sb8.append(" order by _id desc limit ");
            sb8.append(i16);
            sb8.append(") order by _id desc");
            return sb8;
        }
        if (!e16) {
            return null;
        }
        StringBuilder sb9 = new StringBuilder("select * from ( select ");
        sb9.append(MessageRecord.QUERY_NEW_TABLE_FIELDS);
        sb9.append(" , isValid, time as _index from ");
        sb9.append(str2);
        sb9.append(" where time<");
        sb9.append(j17);
        sb9.append(str4);
        sb9.append(") order by time desc, _id desc");
        sb9.append(" limit ");
        sb9.append(i16);
        return sb9;
    }

    public static StringBuilder c(String str, String str2, SQLiteDatabase sQLiteDatabase, String str3) {
        boolean e16 = e(str2, sQLiteDatabase);
        boolean e17 = e(str, sQLiteDatabase);
        if (e16 && e17) {
            StringBuilder sb5 = new StringBuilder("select * from ( select ");
            sb5.append(MessageRecord.QUERY_OLD_TABLE_FIELDS);
            sb5.append(" , -1 as _index from ( select * from ");
            sb5.append(str);
            sb5.append(" where _id<=( select _id from ");
            sb5.append(str);
            sb5.append(" where shmsgseq<( select shmsgseq from ");
            sb5.append(str2);
            sb5.append(" order by shmsgseq asc limit 1)  and shmsgseq>0 order by shmsgseq desc , _id desc limit 1)) union select ");
            sb5.append(MessageRecord.QUERY_NEW_TABLE_FIELDS);
            sb5.append(" , shmsgseq as _index from ");
            sb5.append(str2);
            sb5.append(" order by _index asc, _id asc)");
            sb5.append(str3);
            return sb5;
        }
        if (e17) {
            StringBuilder sb6 = new StringBuilder("select ");
            sb6.append(MessageRecord.QUERY_OLD_TABLE_FIELDS);
            sb6.append(" , -1 as _index from ");
            sb6.append(str);
            sb6.append(str3);
            sb6.append(" order by _id asc");
            return sb6;
        }
        if (e16) {
            StringBuilder sb7 = new StringBuilder("select ");
            sb7.append(MessageRecord.QUERY_NEW_TABLE_FIELDS);
            sb7.append(" , shmsgseq as _index from ");
            sb7.append(str2);
            sb7.append(str3);
            sb7.append(" order by shmsgseq asc");
            return sb7;
        }
        return null;
    }

    public static StringBuilder d(String str, String str2, long j3, int i3, long j16, String str3, int i16, SQLiteDatabase sQLiteDatabase) {
        String str4;
        int count;
        boolean e16 = e(str2, sQLiteDatabase);
        boolean e17 = e(str, sQLiteDatabase);
        if (i3 <= 0) {
            e16 = false;
        }
        if (str3 != null && str3.length() != 0) {
            str4 = str3;
        } else {
            str4 = "";
        }
        if (e16 && e17) {
            StringBuilder sb5 = new StringBuilder("select ");
            sb5.append(MessageRecord.QUERY_NEW_TABLE_FIELDS);
            sb5.append(" , shmsgseq as _index from ( select * from ");
            sb5.append(str2);
            sb5.append(" where shmsgseq<=");
            sb5.append(j16);
            sb5.append(str4);
            sb5.append(") order by shmsgseq desc , _id desc");
            Cursor rawQuery = sQLiteDatabase.rawQuery(sb5.toString(), null);
            if (rawQuery == null) {
                count = 0;
            } else {
                count = rawQuery.getCount();
                rawQuery.close();
            }
            if (count >= i16) {
                sb5.append(" limit ");
                sb5.append(i16);
                StringBuilder sb6 = new StringBuilder("select * from ( ");
                sb6.append((CharSequence) sb5);
                sb6.append(") ");
                sb6.append(" order by shmsgseq desc , _id desc");
                return sb6;
            }
            StringBuilder sb7 = new StringBuilder("select * from ( select ");
            sb7.append(MessageRecord.QUERY_OLD_TABLE_FIELDS);
            sb7.append(" , -1 as _index from ( select * from ");
            sb7.append(str);
            sb7.append(" where _id<=( select _id from ");
            sb7.append(str);
            sb7.append(" where shmsgseq<( select shmsgseq from ");
            sb7.append(str2);
            sb7.append(" order by shmsgseq asc limit 1) and shmsgseq>0 order by shmsgseq desc , _id desc limit 1) ");
            sb7.append(str4);
            sb7.append(" order by _id desc limit ");
            sb7.append(i16 - count);
            sb7.append(") union select ");
            sb7.append(MessageRecord.QUERY_NEW_TABLE_FIELDS);
            sb7.append(" , shmsgseq as _index from ( select * from ");
            sb7.append(str2);
            sb7.append(" where shmsgseq<=");
            sb7.append(j16);
            sb7.append(str4);
            sb7.append(") order by _index asc, _id asc)");
            return sb7;
        }
        if (e17) {
            StringBuilder sb8 = new StringBuilder("select * from ( select ");
            sb8.append(MessageRecord.QUERY_OLD_TABLE_FIELDS);
            sb8.append(" , -1 as _index from ");
            sb8.append(str);
            sb8.append(" where _id<");
            sb8.append(j3);
            sb8.append(str4);
            sb8.append(" order by _id desc limit ");
            sb8.append(i16);
            sb8.append(") ");
            sb8.append(" order by _id asc");
            return sb8;
        }
        if (e16) {
            StringBuilder sb9 = new StringBuilder("select * from ( select ");
            sb9.append(MessageRecord.QUERY_NEW_TABLE_FIELDS);
            sb9.append(" , shmsgseq as _index from ");
            sb9.append(str2);
            sb9.append(" where shmsgseq<=");
            sb9.append(j16);
            sb9.append(str4);
            sb9.append(" order by shmsgseq desc , _id desc limit ");
            sb9.append(i16);
            sb9.append(") ");
            sb9.append(" order by shmsgseq asc , _id asc");
            return sb9;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0037, code lost:
    
        if (r1 != null) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean e(String str, SQLiteDatabase sQLiteDatabase) {
        boolean z16 = false;
        if (str == null) {
            return false;
        }
        if ("Sqlite_master".equalsIgnoreCase(str)) {
            return true;
        }
        Cursor cursor = null;
        try {
            cursor = sQLiteDatabase.rawQuery("select count(*) as c from Sqlite_master  where type ='table' and name =? ", new String[]{str.trim()});
            if (cursor.moveToNext()) {
                if (cursor.getInt(0) > 0) {
                    z16 = true;
                }
            }
        } catch (Exception unused) {
        } catch (Throwable th5) {
            if (cursor != null) {
                cursor.close();
            }
            throw th5;
        }
        cursor.close();
        return z16;
    }
}
