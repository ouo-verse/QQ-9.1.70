package com.qq.e.comm.plugin.stat.a;

import android.content.Context;
import android.content.ContextWrapper;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import com.qq.e.comm.util.GDTLogger;
import java.io.File;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a extends ContextWrapper {

    /* renamed from: a, reason: collision with root package name */
    private String f39702a;

    public a(Context context, String str) {
        super(context);
        this.f39702a = str;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDatabasePath(String str) {
        File filesDir = getFilesDir();
        String str2 = null;
        if (filesDir != null) {
            if (this.f39702a != null) {
                File file = new File(filesDir, this.f39702a);
                if (file.exists() || file.mkdir()) {
                    filesDir = file;
                }
            }
            File file2 = new File(filesDir, str);
            if (!file2.exists()) {
                GDTLogger.d("create database file");
                try {
                    if (!file2.createNewFile()) {
                        file2 = super.getDatabasePath(str);
                    }
                } catch (IOException e16) {
                    e16.printStackTrace();
                    file2 = super.getDatabasePath(str);
                }
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("getDatabasePath(");
            sb5.append(str);
            sb5.append(") = ");
            if (file2 != null) {
                str2 = file2.getPath();
            }
            sb5.append(str2);
            sb5.append(", this:");
            sb5.append(this);
            GDTLogger.d(sb5.toString());
            return file2;
        }
        File databasePath = super.getDatabasePath(str);
        StringBuilder sb6 = new StringBuilder();
        sb6.append("getDatabasePath(");
        sb6.append(str);
        sb6.append(") = ");
        if (databasePath != null) {
            str2 = databasePath.getPath();
        }
        sb6.append(str2);
        GDTLogger.d(sb6.toString());
        return databasePath;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i3, SQLiteDatabase.CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        int i16 = (i3 & 8) != 0 ? 805306368 : 268435456;
        try {
            File databasePath = getDatabasePath(str);
            SQLiteDatabase openDatabase = databasePath != null ? SQLiteDatabase.openDatabase(databasePath.getPath(), cursorFactory, i16, databaseErrorHandler) : 0;
            try {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("openOrCreateDatabase(");
                sb5.append(str);
                sb5.append(",,) = ");
                sb5.append(openDatabase != 0 ? openDatabase.getPath() : null);
                GDTLogger.d(sb5.toString());
                return openDatabase;
            } catch (Throwable th5) {
                th = th5;
                r0 = openDatabase;
                GDTLogger.d("openDatabase error: " + th.getMessage());
                return r0;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i3, SQLiteDatabase.CursorFactory cursorFactory) {
        return openOrCreateDatabase(str, i3, cursorFactory, null);
    }
}
