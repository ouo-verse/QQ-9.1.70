package com.tencent.mobileqq.activity.photo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MediaDatabaseHelper extends SQLiteOpenHelper {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "QQAlbum";
    private static MediaDatabaseHelper sInstance;
    private SQLiteDatabase mDatabase;
    private AtomicInteger mOpenCounter;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12901);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 23)) {
            redirector.redirect((short) 23);
        } else {
            sInstance = null;
        }
    }

    MediaDatabaseHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i3) {
        super(context, str, cursorFactory, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, str, cursorFactory, Integer.valueOf(i3));
        } else {
            this.mOpenCounter = new AtomicInteger(0);
        }
    }

    private void createDatabase(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS content_table (id            integer PRIMARY KEY autoincrement,name         varchar (128),path           varchar (512),filesize       integer,modifieddate   integer,folderpath           varchar (512),md5           varchar(128),duration      integer,mimetype  varchar (50));");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS folder_table (id            integer PRIMARY KEY autoincrement,folderpath         varchar (512),modifieddate   integer);");
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("QQAlbum", 2, "createDatabase error=" + e16.getMessage());
            }
        }
    }

    public static synchronized MediaDatabaseHelper getInstance(Context context) {
        MediaDatabaseHelper mediaDatabaseHelper;
        synchronized (MediaDatabaseHelper.class) {
            if (sInstance == null) {
                sInstance = new MediaDatabaseHelper(context, MediaDBValues.DB_NAME, null, 2);
            }
            mediaDatabaseHelper = sInstance;
        }
        return mediaDatabaseHelper;
    }

    public synchronized void closeDatabase() {
        SQLiteDatabase sQLiteDatabase;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (this.mOpenCounter.decrementAndGet() == 0 && (sQLiteDatabase = this.mDatabase) != null) {
            sQLiteDatabase.close();
        }
    }

    public void deleteMediaScannerInfoByFolderPathSet(HashSet<String> hashSet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) hashSet);
            return;
        }
        if (hashSet == null) {
            return;
        }
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            readableDatabase.beginTransaction();
            Iterator<String> it = hashSet.iterator();
            while (it.hasNext()) {
                String[] strArr = {it.next()};
                readableDatabase.delete(MediaDBValues.CONTENT_TABLE_NAME, "folderpath=?", strArr);
                readableDatabase.delete(MediaDBValues.FOLDER_TABLE_NAME, "folderpath=?", strArr);
            }
            try {
                try {
                    readableDatabase.setTransactionSuccessful();
                    readableDatabase.endTransaction();
                } catch (Throwable th5) {
                    readableDatabase.endTransaction();
                    closeDatabase();
                    throw th5;
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQAlbum", 2, "deleteMediaScannerInfoByFolderPathSet() ERROR Exception:" + e16.getMessage());
                }
                readableDatabase.endTransaction();
            }
            closeDatabase();
        } catch (Exception e17) {
            if (QLog.isColorLevel()) {
                QLog.d("QQAlbum", 2, "getReadableDatabase ERROR Exception:" + e17.getMessage());
            }
        }
    }

    public void deleteMediaScannerInfoByList(ArrayList<MediaScannerInfo> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) arrayList);
            return;
        }
        if (arrayList == null) {
            return;
        }
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            readableDatabase.beginTransaction();
            try {
                try {
                    Iterator<MediaScannerInfo> it = arrayList.iterator();
                    while (it.hasNext()) {
                        readableDatabase.delete(MediaDBValues.CONTENT_TABLE_NAME, "id=?", new String[]{String.valueOf(it.next().f183982id)});
                    }
                    readableDatabase.setTransactionSuccessful();
                    readableDatabase.endTransaction();
                } catch (Throwable th5) {
                    readableDatabase.endTransaction();
                    closeDatabase();
                    throw th5;
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQAlbum", 2, "deleteMediaScannerInfoByList() ERROR Exception:" + e16.getMessage());
                }
                readableDatabase.endTransaction();
            }
            closeDatabase();
        } catch (Exception e17) {
            if (QLog.isColorLevel()) {
                QLog.d("QQAlbum", 2, "getReadableDatabase ERROR Exception:" + e17.getMessage());
            }
        }
    }

    public void deleteMediaScannerInfoByPathSet(HashSet<String> hashSet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) hashSet);
            return;
        }
        if (hashSet == null) {
            return;
        }
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            readableDatabase.beginTransaction();
            try {
                try {
                    Iterator<String> it = hashSet.iterator();
                    while (it.hasNext()) {
                        readableDatabase.delete(MediaDBValues.CONTENT_TABLE_NAME, "path=?", new String[]{it.next()});
                    }
                    readableDatabase.setTransactionSuccessful();
                    readableDatabase.endTransaction();
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("QQAlbum", 2, "insertMediaScannerInfoByList() ERROR Exception:" + e16.getMessage());
                    }
                    readableDatabase.endTransaction();
                }
                closeDatabase();
            } catch (Throwable th5) {
                readableDatabase.endTransaction();
                closeDatabase();
                throw th5;
            }
        } catch (Exception e17) {
            if (QLog.isColorLevel()) {
                QLog.d("QQAlbum", 2, "getReadableDatabase ERROR Exception:" + e17.getMessage());
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public synchronized SQLiteDatabase getReadableDatabase() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SQLiteDatabase) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (this.mOpenCounter.incrementAndGet() == 1 || this.mDatabase == null) {
            this.mDatabase = super.getReadableDatabase();
        }
        return this.mDatabase;
    }

    public void insertMediaScannerInfo(MediaScannerInfo mediaScannerInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) mediaScannerInfo);
            return;
        }
        try {
            if (mediaScannerInfo == null) {
                return;
            }
            try {
                SQLiteDatabase readableDatabase = getReadableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put("name", mediaScannerInfo.name);
                contentValues.put("path", mediaScannerInfo.path);
                contentValues.put(MediaDBValues.FILESIZE, Long.valueOf(mediaScannerInfo.fileSize));
                contentValues.put(MediaDBValues.MODIFIEDDATE, Long.valueOf(mediaScannerInfo.modifiedDate));
                contentValues.put("duration", Long.valueOf(mediaScannerInfo.duration));
                contentValues.put("mimetype", mediaScannerInfo.mimeType);
                contentValues.put(MediaDBValues.FOLDERPATH, mediaScannerInfo.folderPath);
                contentValues.put("md5", mediaScannerInfo.md5);
                readableDatabase.insert(MediaDBValues.CONTENT_TABLE_NAME, null, contentValues);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQAlbum", 2, "insertMediaScannerInfoByList() ERROR Exception:" + e16.getMessage());
                }
            }
        } finally {
            closeDatabase();
        }
    }

    public void insertMediaScannerInfoByList(ArrayList<MediaScannerInfo> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) arrayList);
            return;
        }
        if (arrayList == null) {
            return;
        }
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            readableDatabase.beginTransaction();
            try {
                try {
                    Iterator<MediaScannerInfo> it = arrayList.iterator();
                    while (it.hasNext()) {
                        MediaScannerInfo next = it.next();
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("name", next.name);
                        contentValues.put("path", next.path);
                        contentValues.put(MediaDBValues.FILESIZE, Long.valueOf(next.fileSize));
                        contentValues.put(MediaDBValues.MODIFIEDDATE, Long.valueOf(next.modifiedDate));
                        contentValues.put("duration", Long.valueOf(next.duration));
                        contentValues.put("mimetype", next.mimeType);
                        contentValues.put(MediaDBValues.FOLDERPATH, next.folderPath);
                        contentValues.put("md5", next.md5);
                        readableDatabase.insert(MediaDBValues.CONTENT_TABLE_NAME, null, contentValues);
                    }
                    readableDatabase.setTransactionSuccessful();
                    readableDatabase.endTransaction();
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("QQAlbum", 2, "insertMediaScannerInfoByList() ERROR Exception:" + e16.getMessage());
                    }
                    readableDatabase.endTransaction();
                }
                closeDatabase();
            } catch (Throwable th5) {
                readableDatabase.endTransaction();
                closeDatabase();
                throw th5;
            }
        } catch (Exception e17) {
            if (QLog.isColorLevel()) {
                QLog.d("QQAlbum", 2, "getReadableDatabase ERROR Exception:" + e17.getMessage());
            }
        }
    }

    public void insertMediaScnnerFolderInfo(MediaScannerFolderInfo mediaScannerFolderInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) mediaScannerFolderInfo);
            return;
        }
        if (mediaScannerFolderInfo == null) {
            return;
        }
        try {
            try {
                SQLiteDatabase readableDatabase = getReadableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put(MediaDBValues.FOLDERPATH, mediaScannerFolderInfo.folderpath);
                contentValues.put(MediaDBValues.MODIFIEDDATE, Long.valueOf(mediaScannerFolderInfo.modifiedDate));
                readableDatabase.insert(MediaDBValues.FOLDER_TABLE_NAME, null, contentValues);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQAlbum", 2, "insertMediaScnnerFolderInfo() ERROR Exception:" + e16.getMessage());
                }
            }
        } finally {
            closeDatabase();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) sQLiteDatabase);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQAlbum", 2, "onCreate");
        }
        createDatabase(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, sQLiteDatabase, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQAlbum", 2, "onDowngrade oldVersion=" + i3 + ", newVersion=" + i16);
        }
        if (i3 == i16) {
            return;
        }
        try {
            sQLiteDatabase.execSQL("drop table if exists folder_table");
            sQLiteDatabase.execSQL("drop table if exists content_table");
            createDatabase(sQLiteDatabase);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("QQAlbum", 2, "onDowngrade error=" + e16.getMessage());
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, sQLiteDatabase, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQAlbum", 2, "onUpgrade oldVersion=" + i3 + ", newVersion=" + i16);
        }
        if (i3 == i16) {
            return;
        }
        try {
            sQLiteDatabase.execSQL("drop table if exists folder_table");
            sQLiteDatabase.execSQL("drop table if exists content_table");
            createDatabase(sQLiteDatabase);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("QQAlbum", 2, "onUpgrade error=" + e16.getMessage());
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x00e1, code lost:
    
        if (r1 != null) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArrayList<MediaScannerInfo> queryAllLongVideoMediaScannerInfo(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (ArrayList) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
        }
        ArrayList<MediaScannerInfo> arrayList = new ArrayList<>();
        Cursor cursor = null;
        try {
            try {
                cursor = getReadableDatabase().query(MediaDBValues.CONTENT_TABLE_NAME, MediaDBValues.CONTENT_TABLE_COLUMNS, "filesize>?", new String[]{"819200"}, null, null, "modifieddate DESC", str);
                while (cursor.moveToNext()) {
                    MediaScannerInfo mediaScannerInfo = new MediaScannerInfo();
                    mediaScannerInfo.f183982id = cursor.getInt(cursor.getColumnIndex("id"));
                    mediaScannerInfo.name = cursor.getString(cursor.getColumnIndex("name"));
                    mediaScannerInfo.path = cursor.getString(cursor.getColumnIndex("path"));
                    mediaScannerInfo.fileSize = cursor.getLong(cursor.getColumnIndex(MediaDBValues.FILESIZE));
                    mediaScannerInfo.modifiedDate = cursor.getLong(cursor.getColumnIndex(MediaDBValues.MODIFIEDDATE));
                    mediaScannerInfo.duration = cursor.getLong(cursor.getColumnIndex("duration"));
                    mediaScannerInfo.mimeType = cursor.getString(cursor.getColumnIndex("mimetype"));
                    mediaScannerInfo.folderPath = cursor.getString(cursor.getColumnIndex(MediaDBValues.FOLDERPATH));
                    mediaScannerInfo.md5 = cursor.getString(cursor.getColumnIndex("md5"));
                    arrayList.add(mediaScannerInfo);
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQAlbum", 2, "queryAllLongVideoMediaScannerInfo() error=" + e16.getMessage());
                }
            }
            cursor.close();
            closeDatabase();
            return arrayList;
        } catch (Throwable th5) {
            if (cursor != null) {
                cursor.close();
            }
            closeDatabase();
            throw th5;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0068, code lost:
    
        if (r10 != null) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public HashSet<String> queryAllMediaScannerFolderPathSet() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (HashSet) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        HashSet<String> hashSet = new HashSet<>();
        Cursor cursor = null;
        try {
            try {
                cursor = getReadableDatabase().query(MediaDBValues.FOLDER_TABLE_NAME, new String[]{MediaDBValues.FOLDERPATH}, null, null, null, null, null);
                while (cursor.moveToNext()) {
                    hashSet.add(cursor.getString(cursor.getColumnIndex(MediaDBValues.FOLDERPATH)));
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQAlbum", 2, "queryAllMediaScannerInfoMd5Set() error=" + e16.getMessage());
                }
            }
            cursor.close();
            closeDatabase();
            return hashSet;
        } catch (Throwable th5) {
            if (cursor != null) {
                cursor.close();
            }
            closeDatabase();
            throw th5;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x00d9, code lost:
    
        if (r1 != null) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArrayList<MediaScannerInfo> queryAllMediaScannerInfo(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (ArrayList) iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
        }
        ArrayList<MediaScannerInfo> arrayList = new ArrayList<>();
        Cursor cursor = null;
        try {
            try {
                cursor = getReadableDatabase().query(MediaDBValues.CONTENT_TABLE_NAME, MediaDBValues.CONTENT_TABLE_COLUMNS, null, null, null, null, "modifieddate DESC", str);
                while (cursor.moveToNext()) {
                    MediaScannerInfo mediaScannerInfo = new MediaScannerInfo();
                    mediaScannerInfo.f183982id = cursor.getInt(cursor.getColumnIndex("id"));
                    mediaScannerInfo.name = cursor.getString(cursor.getColumnIndex("name"));
                    mediaScannerInfo.path = cursor.getString(cursor.getColumnIndex("path"));
                    mediaScannerInfo.fileSize = cursor.getLong(cursor.getColumnIndex(MediaDBValues.FILESIZE));
                    mediaScannerInfo.modifiedDate = cursor.getLong(cursor.getColumnIndex(MediaDBValues.MODIFIEDDATE));
                    mediaScannerInfo.duration = cursor.getLong(cursor.getColumnIndex("duration"));
                    mediaScannerInfo.mimeType = cursor.getString(cursor.getColumnIndex("mimetype"));
                    mediaScannerInfo.folderPath = cursor.getString(cursor.getColumnIndex(MediaDBValues.FOLDERPATH));
                    mediaScannerInfo.md5 = cursor.getString(cursor.getColumnIndex("md5"));
                    arrayList.add(mediaScannerInfo);
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQAlbum", 2, "queryAllMediaScannerInfo() error=" + e16.getMessage());
                }
            }
            cursor.close();
            closeDatabase();
            return arrayList;
        } catch (Throwable th5) {
            if (cursor != null) {
                cursor.close();
            }
            closeDatabase();
            throw th5;
        }
    }

    public int queryAllMediaScannerInfoCnt() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        Cursor cursor = null;
        try {
            try {
                cursor = getReadableDatabase().query(MediaDBValues.CONTENT_TABLE_NAME, new String[]{"id"}, null, null, null, null, null);
                int count = cursor.getCount();
                cursor.close();
                closeDatabase();
                return count;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQAlbum", 2, "queryAllMediaScannerInfoCnt() error=" + e16.getMessage());
                }
                if (cursor != null) {
                    cursor.close();
                }
                closeDatabase();
                return 0;
            }
        } catch (Throwable th5) {
            if (cursor != null) {
                cursor.close();
            }
            closeDatabase();
            throw th5;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0068, code lost:
    
        if (r10 != null) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public HashSet<String> queryAllMediaScannerInfoMd5Set() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (HashSet) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        HashSet<String> hashSet = new HashSet<>();
        Cursor cursor = null;
        try {
            try {
                cursor = getReadableDatabase().query(MediaDBValues.CONTENT_TABLE_NAME, new String[]{"md5"}, null, null, null, null, null);
                while (cursor.moveToNext()) {
                    hashSet.add(cursor.getString(cursor.getColumnIndex("md5")));
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQAlbum", 2, "queryAllMediaScannerInfoMd5Set() error=" + e16.getMessage());
                }
            }
            cursor.close();
            closeDatabase();
            return hashSet;
        } catch (Throwable th5) {
            if (cursor != null) {
                cursor.close();
            }
            closeDatabase();
            throw th5;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0068, code lost:
    
        if (r10 != null) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public HashSet<String> queryAllMediaScannerInfoPathSet() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (HashSet) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        HashSet<String> hashSet = new HashSet<>();
        Cursor cursor = null;
        try {
            try {
                cursor = getReadableDatabase().query(MediaDBValues.CONTENT_TABLE_NAME, new String[]{"path"}, null, null, null, null, null);
                while (cursor.moveToNext()) {
                    hashSet.add(cursor.getString(cursor.getColumnIndex("path")));
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQAlbum", 2, "queryAllMediaScannerInfoPathSet() error=" + e16.getMessage());
                }
            }
            cursor.close();
            closeDatabase();
            return hashSet;
        } catch (Throwable th5) {
            if (cursor != null) {
                cursor.close();
            }
            closeDatabase();
            throw th5;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x006e, code lost:
    
        if (r11 != null) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public HashSet<String> queryAllMediaScannerInfoPathSetByFolder(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (HashSet) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        }
        HashSet<String> hashSet = new HashSet<>();
        String[] strArr = {str};
        Cursor cursor = null;
        try {
            try {
                cursor = getReadableDatabase().query(MediaDBValues.CONTENT_TABLE_NAME, new String[]{"path"}, "folderpath=?", strArr, null, null, null);
                while (cursor.moveToNext()) {
                    hashSet.add(cursor.getString(cursor.getColumnIndex("path")));
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQAlbum", 2, "queryAllMediaScannerInfoPathSetByFolder() error=" + e16.getMessage());
                }
            }
            cursor.close();
            closeDatabase();
            return hashSet;
        } catch (Throwable th5) {
            if (cursor != null) {
                cursor.close();
            }
            closeDatabase();
            throw th5;
        }
    }

    public MediaScannerFolderInfo queryMediaScannerFolderInfoByFolderpath(String str) {
        Throwable th5;
        Cursor cursor;
        MediaScannerFolderInfo mediaScannerFolderInfo;
        Exception e16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (MediaScannerFolderInfo) iPatchRedirector.redirect((short) 18, (Object) this, (Object) str);
        }
        MediaScannerFolderInfo mediaScannerFolderInfo2 = null;
        try {
            cursor = getReadableDatabase().query(MediaDBValues.FOLDER_TABLE_NAME, MediaDBValues.FOLDER_TABLE_COLUMNS, "folderpath=?", new String[]{str}, null, null, null);
            try {
                try {
                    if (cursor.getCount() > 0) {
                        cursor.moveToNext();
                        mediaScannerFolderInfo = new MediaScannerFolderInfo();
                        try {
                            mediaScannerFolderInfo.f183981id = cursor.getInt(cursor.getColumnIndex("id"));
                            mediaScannerFolderInfo.folderpath = cursor.getString(cursor.getColumnIndex(MediaDBValues.FOLDERPATH));
                            mediaScannerFolderInfo.modifiedDate = cursor.getLong(cursor.getColumnIndex(MediaDBValues.MODIFIEDDATE));
                            mediaScannerFolderInfo2 = mediaScannerFolderInfo;
                        } catch (Exception e17) {
                            e16 = e17;
                            if (QLog.isColorLevel()) {
                                QLog.d("QQAlbum", 2, "queryMediaScannerFolderInfoByFolderpath() ERROR Exception:" + e16.getMessage());
                            }
                            if (cursor != null) {
                                cursor.close();
                            }
                            closeDatabase();
                            return mediaScannerFolderInfo;
                        }
                    }
                    cursor.close();
                    closeDatabase();
                    return mediaScannerFolderInfo2;
                } catch (Throwable th6) {
                    th5 = th6;
                    if (cursor != null) {
                        cursor.close();
                    }
                    closeDatabase();
                    throw th5;
                }
            } catch (Exception e18) {
                mediaScannerFolderInfo = null;
                e16 = e18;
            }
        } catch (Exception e19) {
            mediaScannerFolderInfo = null;
            e16 = e19;
            cursor = null;
        } catch (Throwable th7) {
            th5 = th7;
            cursor = null;
        }
    }

    public void updateMediaScnnerFolderInfo(MediaScannerFolderInfo mediaScannerFolderInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) mediaScannerFolderInfo);
            return;
        }
        if (mediaScannerFolderInfo == null) {
            return;
        }
        try {
            try {
                SQLiteDatabase readableDatabase = getReadableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put(MediaDBValues.MODIFIEDDATE, Long.valueOf(mediaScannerFolderInfo.modifiedDate));
                readableDatabase.update(MediaDBValues.FOLDER_TABLE_NAME, contentValues, "folderpath=?", new String[]{mediaScannerFolderInfo.folderpath});
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQAlbum", 2, "updateMediaScnnerFolderInfo() ERROR Exception:" + e16.getMessage());
                }
            }
        } finally {
            closeDatabase();
        }
    }

    public void updateMediaScnnerInfoDuration(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, str, Long.valueOf(j3));
            return;
        }
        try {
            try {
                SQLiteDatabase readableDatabase = getReadableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put("duration", Long.valueOf(j3));
                readableDatabase.update(MediaDBValues.CONTENT_TABLE_NAME, contentValues, "path=?", new String[]{str});
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQAlbum", 2, "updateMediaScnnerFolderInfo() ERROR Exception:" + e16.getMessage());
                }
            }
        } finally {
            closeDatabase();
        }
    }
}
