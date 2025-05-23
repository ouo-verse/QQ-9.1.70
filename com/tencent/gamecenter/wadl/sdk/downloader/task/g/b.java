package com.tencent.gamecenter.wadl.sdk.downloader.task.g;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTask;
import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTaskCategory;
import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTaskPriority;
import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTaskStatus;
import com.tencent.gamecenter.wadl.sdk.downloader.HistoryTask;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public class b extends a {
    public b(Context context) {
        super(context, "wadl_history_task_table", null, 1);
    }

    private int a(DownloaderTaskStatus downloaderTaskStatus) {
        return downloaderTaskStatus.ordinal() <= DownloaderTaskStatus.DOWNLOADING.ordinal() ? DownloaderTaskStatus.PAUSED.ordinal() : downloaderTaskStatus.ordinal();
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.task.g.a
    protected int b() {
        return 1;
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.task.g.a
    protected String c() {
        return "wadl_history_task_table";
    }

    public List<HistoryTask> d() {
        Cursor cursor;
        ArrayList arrayList = new ArrayList();
        try {
            cursor = null;
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        try {
            cursor = getReadableDatabase().rawQuery("SELECT * FROM wadl_history_task_table", null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    try {
                        String string = cursor.getString(cursor.getColumnIndex("taskid"));
                        int i3 = cursor.getInt(cursor.getColumnIndex("type"));
                        long j3 = cursor.getLong(cursor.getColumnIndex("knownsize"));
                        int i16 = cursor.getInt(cursor.getColumnIndex("category"));
                        int i17 = cursor.getInt(cursor.getColumnIndex("priority"));
                        String string2 = cursor.getString(cursor.getColumnIndex("url"));
                        String string3 = cursor.getString(cursor.getColumnIndex("saveDir"));
                        String string4 = cursor.getString(cursor.getColumnIndex("saveName"));
                        int i18 = cursor.getInt(cursor.getColumnIndex("status"));
                        int i19 = cursor.getInt(cursor.getColumnIndex("totalLen"));
                        int i26 = cursor.getInt(cursor.getColumnIndex("rcvLen"));
                        int i27 = cursor.getInt(cursor.getColumnIndex("pencent"));
                        Cursor cursor2 = cursor;
                        try {
                            arrayList = arrayList;
                        } catch (Throwable th6) {
                            th = th6;
                        }
                        try {
                            arrayList.add(new HistoryTask(string, i3, j3, DownloaderTaskCategory.values()[i16], DownloaderTaskPriority.values()[i17], string2, string3, string4, DownloaderTaskStatus.values()[i18], i19, i26, i27));
                            cursor = cursor2;
                        } catch (Throwable th7) {
                            th = th7;
                            cursor = cursor2;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th8) {
                        th = th8;
                    }
                }
            }
            Cursor cursor3 = cursor;
            if (cursor3 != null) {
                cursor3.close();
            }
            return arrayList;
        } catch (Throwable th9) {
            th = th9;
        }
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.task.g.a
    protected String a() {
        return "CREATE TABLE IF NOT EXISTS wadl_history_task_table (id INTEGER PRIMARY KEY AUTOINCREMENT,taskid TEXT,type INTEGER,knownsize TEXT,category TEXT,priority TEXT,url TEXT,saveDir TEXT,saveName TEXT,status INTEGER,totalLen INTEGER,rcvLen INTEGER,pencent INTEGER);";
    }

    public void b(DownloaderTask downloaderTask) {
        try {
            getWritableDatabase().delete("wadl_history_task_table", "saveDir=? and saveName=?", new String[]{downloaderTask.getSaveDir(), downloaderTask.getInitSaveName()});
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public void a(DownloaderTask downloaderTask) {
        if (downloaderTask.isDeleted()) {
            return;
        }
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("taskid", downloaderTask.getId());
            contentValues.put("type", (Integer) 0);
            contentValues.put("knownsize", Long.valueOf(downloaderTask.getKnownSize()));
            contentValues.put("priority", Integer.valueOf(downloaderTask.getPriority().ordinal()));
            contentValues.put("category", Integer.valueOf(downloaderTask.getCategory().ordinal()));
            contentValues.put("url", downloaderTask.getUrl());
            contentValues.put("saveDir", downloaderTask.getSaveDir());
            contentValues.put("saveName", downloaderTask.getInitSaveName());
            contentValues.put("status", Integer.valueOf(a(downloaderTask.getStatus())));
            contentValues.put("totalLen", Long.valueOf(downloaderTask.getTotalLength()));
            contentValues.put("rcvLen", Long.valueOf(downloaderTask.getReceivedLength()));
            contentValues.put("pencent", Integer.valueOf(downloaderTask.getPercentage()));
            int update = writableDatabase.update("wadl_history_task_table", contentValues, "saveDir=? and saveName=?", new String[]{downloaderTask.getSaveDir(), downloaderTask.getInitSaveName()});
            com.tencent.gamecenter.wadl.sdk.common.e.b.a("HistoryTaskDb", "updateRet:" + update);
            if (update <= 0) {
                com.tencent.gamecenter.wadl.sdk.common.e.b.a("HistoryTaskDb", "insertRet:" + writableDatabase.insert("wadl_history_task_table", null, contentValues));
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public void a(String str, String str2) {
        try {
            getWritableDatabase().delete("wadl_history_task_table", "saveDir=? and saveName=?", new String[]{str, str2});
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }
}
