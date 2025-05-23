package com.tencent.ark;

import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes3.dex */
public class SQLiteHandler {
    protected static final ArkEnvironmentManager ENV = ArkEnvironmentManager.getInstance();
    private static final String TAG = "ArkApp.SQLiteHandler";

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class DBInstanse {

        /* renamed from: db, reason: collision with root package name */
        SQLiteDatabase f72566db;
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class DBStatement {
        protected Cursor cursor;

        /* renamed from: db, reason: collision with root package name */
        SQLiteDatabase f72567db;
        protected ArrayList<String> queryParams;
        protected String querySql;
        protected SQLiteStatement stmt;
        protected boolean isQuery = false;
        protected boolean queryHasRow = false;
        protected int index = 1;
    }

    public static boolean closeDB(DBInstanse dBInstanse) {
        SQLiteDatabase sQLiteDatabase;
        if (dBInstanse != null && (sQLiteDatabase = dBInstanse.f72566db) != null) {
            try {
                sQLiteDatabase.close();
                return true;
            } catch (Exception e16) {
                Logger.logE(TAG, String.format("Failed to find closeDB %s", e16.toString()));
            }
        }
        return false;
    }

    public static boolean closeStatement(DBStatement dBStatement) {
        if (dBStatement != null) {
            try {
                Cursor cursor = dBStatement.cursor;
                if (cursor != null) {
                    cursor.close();
                    dBStatement.cursor = null;
                }
                SQLiteStatement sQLiteStatement = dBStatement.stmt;
                if (sQLiteStatement != null) {
                    sQLiteStatement.close();
                    dBStatement.stmt = null;
                }
                dBStatement.isQuery = false;
                dBStatement.queryParams = null;
                dBStatement.querySql = null;
                return true;
            } catch (Exception e16) {
                Logger.logE(TAG, String.format("Failed to find closeStatement %s", e16.toString()));
            }
        }
        return false;
    }

    public static DBInstanse createDB(String str) {
        try {
            SQLiteDatabase openOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(str, (SQLiteDatabase.CursorFactory) null);
            if (openOrCreateDatabase != null && openOrCreateDatabase.isOpen()) {
                DBInstanse dBInstanse = new DBInstanse();
                dBInstanse.f72566db = openOrCreateDatabase;
                return dBInstanse;
            }
        } catch (Exception e16) {
            Logger.logE(TAG, String.format("Failed to find createDB %s", e16.toString()));
        }
        return null;
    }

    public static DBStatement createStatement(DBInstanse dBInstanse, String str, boolean z16) {
        if (dBInstanse != null) {
            try {
                DBStatement dBStatement = new DBStatement();
                SQLiteDatabase sQLiteDatabase = dBInstanse.f72566db;
                dBStatement.f72567db = sQLiteDatabase;
                dBStatement.isQuery = z16;
                if (z16) {
                    dBStatement.querySql = str;
                    dBStatement.queryParams = new ArrayList<>();
                } else {
                    dBStatement.stmt = sQLiteDatabase.compileStatement(str);
                }
                return dBStatement;
            } catch (Exception e16) {
                Logger.logE(TAG, String.format("Failed to find createStatement %s", e16.toString()));
                return null;
            }
        }
        return null;
    }

    public static boolean execSQL(DBInstanse dBInstanse, String str) {
        if (dBInstanse != null) {
            try {
                Logger.logD(TAG, String.format("execSQL  %s", str));
                dBInstanse.f72566db.execSQL(str);
                return true;
            } catch (Exception e16) {
                Logger.logE(TAG, String.format("Failed to find execSQL %s", e16.toString()));
            }
        }
        return false;
    }

    public static boolean moveToNext(DBStatement dBStatement) {
        return dBStatement.cursor.moveToNext();
    }

    public static byte[] queryGetBlobField(DBStatement dBStatement, int i3, byte[] bArr) {
        if (dBStatement != null && dBStatement.isQuery && dBStatement.queryHasRow) {
            try {
                return dBStatement.cursor.getBlob(i3);
            } catch (Exception e16) {
                Logger.logE(TAG, String.format("Failed to find queryGetBlobField %s", e16.toString()));
            }
        }
        return bArr;
    }

    public static double queryGetDoubleField(DBStatement dBStatement, int i3, double d16) {
        if (dBStatement != null && dBStatement.isQuery && dBStatement.queryHasRow) {
            try {
                return dBStatement.cursor.getDouble(i3);
            } catch (Exception e16) {
                Logger.logE(TAG, String.format("Failed to find queryGetDoubleField %s", e16.toString()));
            }
        }
        return d16;
    }

    public static long queryGetLongField(DBStatement dBStatement, int i3, long j3) {
        if (dBStatement != null && dBStatement.isQuery && dBStatement.queryHasRow) {
            try {
                return dBStatement.cursor.getLong(i3);
            } catch (Exception e16) {
                Logger.logE(TAG, String.format("Failed to find queryGetLongField %s", e16.toString()));
            }
        }
        return j3;
    }

    public static String queryGetStrField(DBStatement dBStatement, int i3, String str) {
        if (dBStatement != null && dBStatement.isQuery && dBStatement.queryHasRow) {
            try {
                return dBStatement.cursor.getString(i3);
            } catch (Exception e16) {
                Logger.logE(TAG, String.format("Failed to find queryGetStrField %s", e16.toString()));
            }
        }
        return str;
    }

    public static boolean statementBindBlob(DBStatement dBStatement, byte[] bArr) {
        if (dBStatement != null) {
            try {
                if (dBStatement.isQuery) {
                    return false;
                }
                SQLiteStatement sQLiteStatement = dBStatement.stmt;
                int i3 = dBStatement.index;
                dBStatement.index = i3 + 1;
                sQLiteStatement.bindBlob(i3, bArr);
                return true;
            } catch (Exception e16) {
                Logger.logE(TAG, String.format("Failed to find statementBindBlob %s", e16.toString()));
            }
        }
        return false;
    }

    public static boolean statementBindDouble(DBStatement dBStatement, double d16) {
        if (dBStatement != null) {
            try {
                if (dBStatement.isQuery) {
                    dBStatement.queryParams.add(String.valueOf(d16));
                } else {
                    SQLiteStatement sQLiteStatement = dBStatement.stmt;
                    int i3 = dBStatement.index;
                    dBStatement.index = i3 + 1;
                    sQLiteStatement.bindDouble(i3, d16);
                }
                return true;
            } catch (Exception e16) {
                Logger.logE(TAG, String.format("Failed to find statementBindDouble %s", e16.toString()));
            }
        }
        return false;
    }

    public static boolean statementBindLong(DBStatement dBStatement, long j3) {
        if (dBStatement != null) {
            try {
                if (dBStatement.isQuery) {
                    dBStatement.queryParams.add(String.valueOf(j3));
                } else {
                    SQLiteStatement sQLiteStatement = dBStatement.stmt;
                    int i3 = dBStatement.index;
                    dBStatement.index = i3 + 1;
                    sQLiteStatement.bindLong(i3, j3);
                }
                return true;
            } catch (Exception e16) {
                Logger.logE(TAG, String.format("Failed to find statementBindLong %s", e16.toString()));
            }
        }
        return false;
    }

    public static boolean statementBindStr(DBStatement dBStatement, String str) {
        try {
            if (dBStatement.isQuery) {
                dBStatement.queryParams.add(str);
            } else {
                SQLiteStatement sQLiteStatement = dBStatement.stmt;
                int i3 = dBStatement.index;
                dBStatement.index = i3 + 1;
                sQLiteStatement.bindString(i3, str);
            }
            return true;
        } catch (Exception e16) {
            Logger.logE(TAG, String.format("Failed to find statementBindStr %s", e16.toString()));
            return false;
        }
    }

    public static boolean statementExec(DBStatement dBStatement) {
        String format;
        if (dBStatement != null) {
            try {
                try {
                    if (dBStatement.isQuery) {
                        if (ENV.mIsDebug) {
                            Logger.logD(TAG, String.format("statementExec is query %s", dBStatement.querySql));
                        }
                        Cursor rawQuery = dBStatement.f72567db.rawQuery(dBStatement.querySql, (String[]) dBStatement.queryParams.toArray(new String[dBStatement.queryParams.size()]));
                        dBStatement.cursor = rawQuery;
                        boolean moveToFirst = rawQuery.moveToFirst();
                        dBStatement.queryHasRow = moveToFirst;
                        if (!dBStatement.isQuery) {
                            try {
                                dBStatement.f72567db.endTransaction();
                            } catch (Exception e16) {
                                Logger.logE(TAG, String.format("ark.SQLiteHandler.statementExec.finally %s", e16.toString()));
                            }
                        }
                        return moveToFirst;
                    }
                    dBStatement.f72567db.beginTransaction();
                    dBStatement.stmt.execute();
                    dBStatement.f72567db.setTransactionSuccessful();
                    if (!dBStatement.isQuery) {
                        try {
                            dBStatement.f72567db.endTransaction();
                        } catch (Exception e17) {
                            Logger.logE(TAG, String.format("ark.SQLiteHandler.statementExec.finally %s", e17.toString()));
                        }
                    }
                    return true;
                } catch (SQLiteConstraintException unused) {
                    if (!dBStatement.isQuery) {
                        try {
                            dBStatement.f72567db.endTransaction();
                        } catch (Exception e18) {
                            format = String.format("ark.SQLiteHandler.statementExec.finally %s", e18.toString());
                            Logger.logE(TAG, format);
                            return false;
                        }
                    }
                } catch (Exception e19) {
                    Logger.logE(TAG, String.format("ark.SQLiteHandler.statementExec %s", e19.toString()));
                    if (!dBStatement.isQuery) {
                        try {
                            dBStatement.f72567db.endTransaction();
                        } catch (Exception e26) {
                            format = String.format("ark.SQLiteHandler.statementExec.finally %s", e26.toString());
                            Logger.logE(TAG, format);
                            return false;
                        }
                    }
                }
            } catch (Throwable th5) {
                if (!dBStatement.isQuery) {
                    try {
                        dBStatement.f72567db.endTransaction();
                    } catch (Exception e27) {
                        Logger.logE(TAG, String.format("ark.SQLiteHandler.statementExec.finally %s", e27.toString()));
                    }
                }
                throw th5;
            }
        }
        return false;
    }

    public static boolean statementReset(DBStatement dBStatement) {
        if (dBStatement == null) {
            return false;
        }
        try {
            dBStatement.index = 1;
            return true;
        } catch (Exception e16) {
            Logger.logE(TAG, String.format("ark.SQLiteHandler.statementReset %s", e16.toString()));
            return false;
        }
    }
}
