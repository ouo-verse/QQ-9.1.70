package com.tencent.replacemonitor.replace.d;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.replacemonitor.MonitorStep;
import com.tencent.replacemonitor.MonitorTask;
import com.tencent.tmassistant.common.a.c;
import com.tencent.tmassistantbase.util.r;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes25.dex */
public class b implements com.tencent.tmassistant.common.a.b {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private MonitorTask c(Cursor cursor) {
        MonitorTask monitorTask = new MonitorTask();
        monitorTask.f364885id = cursor.getLong(cursor.getColumnIndex("_id"));
        monitorTask.packageName = cursor.getString(cursor.getColumnIndex("pkg_name"));
        monitorTask.versionCode = cursor.getInt(cursor.getColumnIndex("version_code"));
        monitorTask.appName = cursor.getString(cursor.getColumnIndex("app_name"));
        monitorTask.fileSize = cursor.getLong(cursor.getColumnIndex("file_size"));
        monitorTask.fileMd5 = cursor.getString(cursor.getColumnIndex("file_md5"));
        monitorTask.cpChannelId = cursor.getString(cursor.getColumnIndex("channel_id"));
        monitorTask.filePath = cursor.getString(cursor.getColumnIndex("file_path"));
        monitorTask.downloadUrl = cursor.getString(cursor.getColumnIndex("download_url"));
        monitorTask.yybAppId = cursor.getLong(cursor.getColumnIndex("yyb_app_id"));
        monitorTask.yybApkId = cursor.getLong(cursor.getColumnIndex("yyb_apk_id"));
        monitorTask.installDir = cursor.getString(cursor.getColumnIndex("install_dir"));
        monitorTask.lastModifedTime = cursor.getLong(cursor.getColumnIndex("last_modify_time"));
        monitorTask.additionalId = cursor.getString(cursor.getColumnIndex("task_id"));
        monitorTask.traceId = cursor.getString(cursor.getColumnIndex("trace_id"));
        monitorTask.appType = cursor.getInt(cursor.getColumnIndex("app_type"));
        int i3 = cursor.getInt(cursor.getColumnIndex("last_step"));
        if (MonitorStep.values().length > i3 && i3 >= 0) {
            monitorTask.lastStep = MonitorStep.values()[i3];
        } else {
            monitorTask.lastStep = MonitorStep.DOWNLOADING;
            r.a("MonitorTaskTable", "Bad MonitorStep index:" + i3);
        }
        boolean z16 = true;
        if (cursor.getInt(cursor.getColumnIndex("is_tdownload")) != 1) {
            z16 = false;
        }
        monitorTask.isTencentDownload = z16;
        monitorTask.externalParams = com.tencent.tmassistantbase.util.b.a(cursor.getString(cursor.getColumnIndex("external_param")), ContainerUtils.FIELD_DELIMITER);
        return monitorTask;
    }

    private ContentValues h(MonitorTask monitorTask) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("pkg_name", monitorTask.packageName);
        contentValues.put("version_code", Integer.valueOf(monitorTask.versionCode));
        contentValues.put("app_name", monitorTask.appName);
        contentValues.put("file_size", Long.valueOf(monitorTask.fileSize));
        contentValues.put("channel_id", monitorTask.cpChannelId);
        contentValues.put("file_path", monitorTask.filePath);
        contentValues.put("download_url", monitorTask.downloadUrl);
        contentValues.put("file_md5", monitorTask.fileMd5);
        contentValues.put("install_dir", monitorTask.installDir);
        contentValues.put("last_modify_time", Long.valueOf(monitorTask.lastModifedTime));
        contentValues.put("yyb_app_id", Long.valueOf(monitorTask.yybAppId));
        contentValues.put("yyb_apk_id", Long.valueOf(monitorTask.yybApkId));
        contentValues.put("trace_id", monitorTask.traceId);
        contentValues.put("task_id", monitorTask.additionalId);
        contentValues.put("app_type", Integer.valueOf(monitorTask.appType));
        MonitorStep monitorStep = monitorTask.lastStep;
        if (monitorStep != null) {
            contentValues.put("last_step", Integer.valueOf(monitorStep.ordinal()));
        }
        contentValues.put("is_tdownload", Integer.valueOf(monitorTask.isTencentDownload ? 1 : 0));
        Map<String, String> map = monitorTask.externalParams;
        if (map != null) {
            contentValues.put("external_param", com.tencent.tmassistantbase.util.b.a(map, ContainerUtils.FIELD_DELIMITER));
        }
        return contentValues;
    }

    public int a(MonitorTask monitorTask) {
        SQLiteDatabase writableDatabase;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, (Object) monitorTask)).intValue();
        }
        if (monitorTask == null || (writableDatabase = g().getWritableDatabase()) == null) {
            return -1;
        }
        try {
            return writableDatabase.delete("monitor_task_table", "_id =?", new String[]{String.valueOf(monitorTask.f364885id)});
        } catch (Exception e16) {
            r.a("MonitorTaskTable", ">delete error:" + e16.getMessage() + "|" + e16.getCause() + "|" + monitorTask);
            return -1;
        }
    }

    public MonitorTask b(long j3) {
        SQLiteDatabase readableDatabase;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (MonitorTask) iPatchRedirector.redirect((short) 4, (Object) this, j3);
        }
        MonitorTask monitorTask = null;
        if (j3 <= 0 || (readableDatabase = g().getReadableDatabase()) == null) {
            return null;
        }
        Cursor query = readableDatabase.query("monitor_task_table", null, "_id =?", new String[]{String.valueOf(j3)}, null, null, null);
        if (query != null && query.moveToFirst()) {
            monitorTask = c(query);
        }
        if (query != null) {
            query.close();
        }
        return monitorTask;
    }

    @Override // com.tencent.tmassistant.common.a.b
    public String createTableSQL() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return "CREATE TABLE if not exists monitor_task_table(_id INTEGER PRIMARY KEY AUTOINCREMENT,pkg_name TEXT,version_code INTEGER,app_name TEXT,file_size INTEGER,channel_id TEXT,file_path TEXT,download_url TEXT,file_md5 TEXT,install_dir TEXT,last_modify_time INTEGER,yyb_apk_id INTEGER,yyb_app_id INTEGER,trace_id TEXT,task_id TEXT,app_type INTEGER,last_step INTEGER,is_tdownload INTEGER,external_param TEXT);";
    }

    public MonitorTask d(String str) {
        SQLiteDatabase readableDatabase;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (MonitorTask) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        MonitorTask monitorTask = null;
        if (TextUtils.isEmpty(str) || (readableDatabase = g().getReadableDatabase()) == null) {
            return null;
        }
        Cursor query = readableDatabase.query("monitor_task_table", null, "task_id =?", new String[]{str}, null, null, null);
        if (query != null && query.moveToFirst()) {
            monitorTask = c(query);
        }
        if (query != null) {
            query.close();
        }
        return monitorTask;
    }

    public ArrayList<MonitorTask> e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ArrayList) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        SQLiteDatabase readableDatabase = g().getReadableDatabase();
        ArrayList<MonitorTask> arrayList = null;
        if (readableDatabase == null) {
            return null;
        }
        Cursor query = readableDatabase.query("monitor_task_table", null, null, null, null, null, null);
        if (query != null && query.moveToFirst()) {
            ArrayList<MonitorTask> arrayList2 = new ArrayList<>();
            do {
                arrayList2.add(c(query));
            } while (query.moveToNext());
            arrayList = arrayList2;
        }
        if (query != null) {
            query.close();
        }
        return arrayList;
    }

    public long f(MonitorTask monitorTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this, (Object) monitorTask)).longValue();
        }
        if (monitorTask == null) {
            return -1L;
        }
        ContentValues h16 = h(monitorTask);
        SQLiteDatabase writableDatabase = g().getWritableDatabase();
        if (writableDatabase == null) {
            return -1L;
        }
        return writableDatabase.insert("monitor_task_table", null, h16);
    }

    public c g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (c) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return com.tencent.tmdownloader.f.b.d.a.c();
    }

    @Override // com.tencent.tmassistant.common.a.b
    public String[] getAlterSQL(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String[]) iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        r.b("MonitorTaskTable", ">getAlterSQL " + i3 + "|" + i16);
        if (i3 == 7 && i16 == 8) {
            return new String[]{"alter table monitor_task_table add column is_tdownload INTEGER;", "alter table monitor_task_table add column external_param TEXT;"};
        }
        return null;
    }

    public boolean i(MonitorTask monitorTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) monitorTask)).booleanValue();
        }
        System.out.print(Thread.currentThread().getName() + " update task.id = " + monitorTask.f364885id);
        ContentValues h16 = h(monitorTask);
        SQLiteDatabase writableDatabase = g().getWritableDatabase();
        if (writableDatabase != null) {
            try {
                long j3 = monitorTask.f364885id;
                if (j3 > 0) {
                    if (writableDatabase.update("monitor_task_table", h16, "_id =?", new String[]{String.valueOf(j3)}) <= 0) {
                        return false;
                    }
                    return true;
                }
                if (TextUtils.isEmpty(monitorTask.additionalId) || writableDatabase.update("monitor_task_table", h16, "task_id =?", new String[]{monitorTask.additionalId}) <= 0) {
                    return false;
                }
                return true;
            } catch (Throwable th5) {
                r.a("MonitorTaskTable", ">update error:" + th5.getMessage() + "|" + th5.getCause());
            }
        }
        return false;
    }

    @Override // com.tencent.tmassistant.common.a.b
    public String tableName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return "monitor_task_table";
    }
}
