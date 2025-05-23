package com.tencent.open.agent.report;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class d extends SQLiteOpenHelper {

    /* renamed from: d, reason: collision with root package name */
    protected static final String[] f340534d = {"key"};

    /* renamed from: e, reason: collision with root package name */
    protected static d f340535e;

    public d(Context context) {
        super(context, "agent_report.db", (SQLiteDatabase.CursorFactory) null, 2);
    }

    public static synchronized d e() {
        d dVar;
        synchronized (d.class) {
            if (f340535e == null) {
                f340535e = new d(com.tencent.open.adapter.a.f().e());
            }
            dVar = f340535e;
        }
        return dVar;
    }

    public synchronized void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        SQLiteDatabase writableDatabase = getWritableDatabase();
        if (writableDatabase == null) {
            return;
        }
        writableDatabase.delete("via_cgi_report", "type = ?", new String[]{str});
        writableDatabase.close();
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x001c, code lost:
    
        if (r3.moveToFirst() != false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x001e, code lost:
    
        r4 = r3.getColumnIndex("type");
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0025, code lost:
    
        if (r4 < 0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x002b, code lost:
    
        r0.add(java.lang.Integer.valueOf(java.lang.Integer.valueOf(r3.getString(r4)).intValue()));
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0049 A[Catch: all -> 0x0063, TRY_LEAVE, TryCatch #1 {, blocks: (B:3:0x0001, B:12:0x0044, B:14:0x0049, B:34:0x004f, B:36:0x0054, B:37:0x0057, B:39:0x0059, B:41:0x005e), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized List<Integer> d() {
        ArrayList arrayList;
        SQLiteDatabase writableDatabase;
        Cursor cursor;
        arrayList = new ArrayList();
        writableDatabase = getWritableDatabase();
        if (writableDatabase == null) {
            return arrayList;
        }
        Cursor cursor2 = null;
        try {
            cursor = writableDatabase.rawQuery("select distinct type from via_cgi_report", null);
            if (cursor != null) {
                try {
                    try {
                    } catch (Exception unused) {
                        writableDatabase.close();
                        if (cursor != null) {
                            cursor.close();
                        }
                        return null;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    cursor2 = cursor;
                    writableDatabase.close();
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            }
            writableDatabase.close();
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (Exception unused2) {
            cursor = null;
        } catch (Throwable th6) {
            th = th6;
        }
        if (!cursor.moveToNext()) {
            writableDatabase.close();
            if (cursor != null) {
            }
            return arrayList;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0074 A[Catch: all -> 0x007e, TRY_ENTER, TryCatch #12 {all -> 0x007e, blocks: (B:22:0x002e, B:24:0x0034, B:25:0x0037, B:27:0x0040, B:33:0x0054, B:36:0x0057, B:40:0x0074, B:65:0x0061, B:58:0x0064, B:59:0x0067, B:51:0x006b, B:46:0x006e, B:71:0x0077), top: B:21:0x002e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized List<Serializable> f(String str) {
        ObjectInputStream objectInputStream;
        Serializable serializable;
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        SQLiteDatabase readableDatabase = getReadableDatabase();
        if (readableDatabase == null) {
            return arrayList;
        }
        Cursor cursor = null;
        ObjectInputStream objectInputStream2 = null;
        try {
            Cursor query = readableDatabase.query("via_cgi_report", null, "type = ?", new String[]{str}, null, null, null);
            if (query != null) {
                try {
                    if (query.getCount() > 0) {
                        query.moveToFirst();
                        do {
                            int columnIndex = query.getColumnIndex("blob");
                            if (columnIndex >= 0) {
                                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(query.getBlob(columnIndex));
                                try {
                                    objectInputStream = new ObjectInputStream(byteArrayInputStream);
                                } catch (Exception unused) {
                                    objectInputStream = null;
                                } catch (Throwable th5) {
                                    th = th5;
                                }
                                try {
                                    serializable = (Serializable) objectInputStream.readObject();
                                    try {
                                        objectInputStream.close();
                                    } catch (IOException unused2) {
                                    }
                                } catch (Exception unused3) {
                                    if (objectInputStream != null) {
                                        try {
                                            objectInputStream.close();
                                        } catch (IOException unused4) {
                                        }
                                    }
                                    try {
                                        byteArrayInputStream.close();
                                    } catch (IOException unused5) {
                                    }
                                    serializable = null;
                                    if (serializable != null) {
                                    }
                                } catch (Throwable th6) {
                                    th = th6;
                                    objectInputStream2 = objectInputStream;
                                    if (objectInputStream2 != null) {
                                        try {
                                            objectInputStream2.close();
                                        } catch (IOException unused6) {
                                        }
                                    }
                                    try {
                                        byteArrayInputStream.close();
                                        throw th;
                                    } catch (IOException unused7) {
                                        throw th;
                                    }
                                }
                                try {
                                    byteArrayInputStream.close();
                                } catch (IOException unused8) {
                                    if (serializable != null) {
                                        arrayList.add(serializable);
                                    }
                                }
                            }
                        } while (query.moveToNext());
                    }
                } catch (Throwable th7) {
                    th = th7;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    readableDatabase.close();
                    throw th;
                }
            }
            if (query != null) {
                query.close();
            }
            readableDatabase.close();
            return arrayList;
        } catch (Throwable th8) {
            th = th8;
        }
    }

    public synchronized int g(String str) {
        int i3 = 0;
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        SQLiteDatabase readableDatabase = getReadableDatabase();
        if (readableDatabase == null) {
            return 0;
        }
        Cursor cursor = null;
        try {
            cursor = readableDatabase.query("via_cgi_report", f340534d, "type = ?", new String[]{str}, null, null, null);
            if (cursor != null) {
                i3 = cursor.getCount();
            }
            return i3;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            readableDatabase.close();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public SQLiteDatabase getReadableDatabase() {
        try {
            return super.getReadableDatabase();
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public SQLiteDatabase getWritableDatabase() {
        try {
            return super.getWritableDatabase();
        } catch (Exception unused) {
            return null;
        }
    }

    public synchronized void h(String str, List<Serializable> list) {
        ObjectOutputStream objectOutputStream;
        int size = list.size();
        if (!TextUtils.isEmpty(str) && size != 0) {
            if (size > 20) {
                size = 20;
            }
            a(str);
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null) {
                return;
            }
            writableDatabase.beginTransaction();
            try {
                ContentValues contentValues = new ContentValues();
                for (int i3 = 0; i3 < size; i3++) {
                    Serializable serializable = list.get(i3);
                    if (serializable != null) {
                        contentValues.put("type", str);
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
                        ObjectOutputStream objectOutputStream2 = null;
                        try {
                            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                        } catch (IOException unused) {
                            objectOutputStream = null;
                        } catch (Throwable th5) {
                            th = th5;
                        }
                        try {
                            objectOutputStream.writeObject(serializable);
                            try {
                                objectOutputStream.close();
                            } catch (IOException unused2) {
                            }
                        } catch (IOException unused3) {
                            if (objectOutputStream != null) {
                                objectOutputStream.close();
                            }
                            byteArrayOutputStream.close();
                        } catch (Throwable th6) {
                            th = th6;
                            objectOutputStream2 = objectOutputStream;
                            if (objectOutputStream2 != null) {
                                try {
                                    objectOutputStream2.close();
                                } catch (IOException unused4) {
                                }
                            }
                            try {
                                byteArrayOutputStream.close();
                                throw th;
                            } catch (IOException unused5) {
                                throw th;
                            }
                        }
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException unused6) {
                            contentValues.put("blob", byteArrayOutputStream.toByteArray());
                            writableDatabase.insert("via_cgi_report", null, contentValues);
                        }
                    }
                    contentValues.clear();
                }
                writableDatabase.setTransactionSuccessful();
            } finally {
                writableDatabase.endTransaction();
                writableDatabase.close();
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS via_cgi_report( _id INTEGER PRIMARY KEY,key TEXT,type TEXT,blob BLOB);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS via_cgi_report");
        onCreate(sQLiteDatabase);
    }
}
