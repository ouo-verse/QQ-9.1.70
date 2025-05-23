package com.tencent.ams.dsdk.download;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.ams.dsdk.utils.DBHelper;
import com.tencent.ams.dsdk.utils.DLog;
import com.tencent.ams.dsdk.utils.DynamicUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DownloadItem {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "DownloadItem";
    public String fileName;
    public String folder;

    /* renamed from: id, reason: collision with root package name */
    public String f70115id;
    public long lastModified;
    public String md5;
    public long progress;
    public long total;
    public String url;

    DownloadItem() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public void delete() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        DLog.d(TAG, "delete, item: " + this);
        if (TextUtils.isEmpty(this.f70115id)) {
            DLog.w(TAG, "");
            return;
        }
        try {
            DBHelper.getInstance().delete("_id = ?", new String[]{this.f70115id});
        } catch (Throwable th5) {
            DLog.e(TAG, "delete error. item: " + this, th5);
        }
    }

    public void insert() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        try {
            this.lastModified = System.currentTimeMillis();
            ContentValues contentValues = new ContentValues();
            contentValues.put("url", this.url);
            contentValues.put("md5", this.md5);
            contentValues.put(DBHelper.COL_FOLDER, this.folder);
            contentValues.put("file_name", this.fileName);
            contentValues.put("total", Long.valueOf(this.total));
            contentValues.put("progress", Long.valueOf(this.progress));
            contentValues.put(DBHelper.COL_MODIFY_DATE, Long.valueOf(this.lastModified));
            long insert = DBHelper.getInstance().insert(contentValues);
            if (insert != -1) {
                this.f70115id = String.valueOf(insert);
            } else {
                DLog.w(TAG, "insert fail.");
            }
        } catch (Throwable th5) {
            DLog.e(TAG, "insert error. item: " + this, th5);
        }
    }

    public void insertOrUpdate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else if (TextUtils.isEmpty(this.f70115id)) {
            insert();
        } else {
            update();
        }
    }

    public boolean isFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        long j3 = this.total;
        if (j3 != 0 && j3 == this.progress) {
            return true;
        }
        return false;
    }

    public DownloadItem query() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) ? query(this) : (DownloadItem) iPatchRedirector.redirect((short) 11, (Object) this);
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "DownloadItem{id='" + this.f70115id + "', url='" + this.url + "', md5='" + this.md5 + "', total=" + this.total + ", progress=" + this.progress + ", folder='" + this.folder + "', fileName='" + this.fileName + "', lastModified=" + this.lastModified + '}';
    }

    public void update() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        try {
            this.lastModified = System.currentTimeMillis();
            ContentValues contentValues = new ContentValues();
            contentValues.put("url", this.url);
            contentValues.put("md5", this.md5);
            contentValues.put(DBHelper.COL_FOLDER, this.folder);
            contentValues.put("file_name", this.fileName);
            contentValues.put("total", Long.valueOf(this.total));
            contentValues.put("progress", Long.valueOf(this.progress));
            contentValues.put(DBHelper.COL_MODIFY_DATE, Long.valueOf(this.lastModified));
            DBHelper.getInstance().update(contentValues, "_id = ?", new String[]{this.f70115id});
        } catch (Throwable th5) {
            DLog.e(TAG, "update error. item: " + this, th5);
        }
    }

    public void updateProgress(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, j3);
            return;
        }
        this.progress = j3;
        if (TextUtils.isEmpty(this.f70115id)) {
            insert();
            return;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("progress", Long.valueOf(j3));
            DBHelper.getInstance().update(contentValues, "_id = ?", new String[]{this.f70115id});
        } catch (Throwable th5) {
            DLog.e(TAG, "updateProgress error. item: " + this, th5);
        }
    }

    public void updateTotalAndProgress(long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        this.progress = j16;
        this.total = j3;
        if (TextUtils.isEmpty(this.f70115id)) {
            insert();
            return;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("progress", Long.valueOf(j16));
            contentValues.put("total", Long.valueOf(j3));
            DBHelper.getInstance().update(contentValues, "_id = ?", new String[]{this.f70115id});
        } catch (Throwable th5) {
            DLog.e(TAG, "updateProgress error. item: " + this, th5);
        }
    }

    public DownloadItem(String str, String str2, long j3, long j16, String str3, String str4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, str2, Long.valueOf(j3), Long.valueOf(j16), str3, str4);
            return;
        }
        this.url = str;
        this.md5 = str2;
        this.total = j3;
        this.progress = j16;
        this.folder = str3;
        this.fileName = str4;
    }

    public static DownloadItem query(DownloadItem downloadItem) {
        String[] strArr;
        DownloadItem downloadItem2;
        Cursor query;
        Cursor cursor = null;
        DownloadItem downloadItem3 = null;
        if (downloadItem == null) {
            return null;
        }
        String[] strArr2 = {"_id", "url", "md5", "total", "progress", DBHelper.COL_FOLDER, "file_name", DBHelper.COL_MODIFY_DATE};
        String str = "url = ? AND folder = ? AND file_name = ?";
        if (TextUtils.isEmpty(downloadItem.md5)) {
            strArr = new String[]{downloadItem.url, downloadItem.folder, downloadItem.fileName};
        } else {
            str = "url = ? AND folder = ? AND file_name = ? AND md5 = ?";
            strArr = new String[]{downloadItem.url, downloadItem.folder, downloadItem.fileName, downloadItem.md5};
        }
        try {
            query = DBHelper.getInstance().query(strArr2, str, strArr, null, null, null);
        } catch (Throwable th5) {
            th = th5;
            downloadItem2 = null;
        }
        if (query == null) {
            DynamicUtils.safeClose(query);
            return null;
        }
        try {
            if (query.moveToFirst()) {
                downloadItem2 = new DownloadItem();
                try {
                    downloadItem2.f70115id = String.valueOf(query.getLong(0));
                    downloadItem2.url = query.getString(1);
                    downloadItem2.md5 = query.getString(2);
                    downloadItem2.total = query.getLong(3);
                    downloadItem2.progress = query.getLong(4);
                    downloadItem2.folder = query.getString(5);
                    downloadItem2.fileName = query.getString(6);
                    downloadItem2.lastModified = query.getLong(7);
                    downloadItem3 = downloadItem2;
                } catch (Throwable th6) {
                    th = th6;
                    cursor = query;
                    try {
                        DLog.e(TAG, "download item query error. colums: " + strArr2 + ", selections: " + str + ", args: " + strArr, th);
                        DynamicUtils.safeClose(cursor);
                        downloadItem3 = downloadItem2;
                        DLog.d(TAG, "query, result: " + downloadItem3);
                        return downloadItem3;
                    } catch (Throwable th7) {
                        DynamicUtils.safeClose(cursor);
                        throw th7;
                    }
                }
            }
            DynamicUtils.safeClose(query);
        } catch (Throwable th8) {
            th = th8;
            downloadItem2 = null;
        }
        DLog.d(TAG, "query, result: " + downloadItem3);
        return downloadItem3;
    }
}
