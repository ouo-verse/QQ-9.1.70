package com.tencent.mobileqq.wink.newalbum.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ads.data.AdParam;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.mobileqq.wink.newalbum.collector.WinkNewMemoryAlbumResult;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.Iterator;
import java.util.List;
import s83.WinkNewAlbumConfigInfo;

/* compiled from: P */
/* loaded from: classes21.dex */
public class b extends SQLiteOpenHelper {

    /* renamed from: e, reason: collision with root package name */
    private static volatile b f324155e;

    /* renamed from: d, reason: collision with root package name */
    private List<WinkNewAlbumConfigInfo> f324156d;

    public b() {
        super(BaseApplication.getContext(), "memory_album.db", (SQLiteDatabase.CursorFactory) null, 6);
    }

    private void c(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        try {
            try {
                cursor = sQLiteDatabase.rawQuery("SELECT name FROM sqlite_master WHERE type='table' AND name LIKE ?", new String[]{"t_clip_%"});
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        String string = cursor.getString(0);
                        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + string);
                        QLog.i("WinkNewAlbumDatabaseHelper", 1, "drop table:" + string);
                    }
                }
                if (cursor == null) {
                    return;
                }
            } catch (Exception e16) {
                QLog.e("WinkNewAlbumDatabaseHelper", 1, e16, new Object[0]);
                if (cursor == null) {
                    return;
                }
            }
            cursor.close();
        } catch (Throwable th5) {
            if (cursor != null) {
                cursor.close();
            }
            throw th5;
        }
    }

    public static synchronized b j() {
        b bVar;
        synchronized (b.class) {
            if (f324155e == null) {
                synchronized (b.class) {
                    if (f324155e == null) {
                        f324155e = new b();
                    }
                }
            }
            bVar = f324155e;
        }
        return bVar;
    }

    public static String l() {
        return "t_clip_memory_photo";
    }

    public boolean a(List<WinkNewAlbumConfigInfo> list) {
        boolean z16 = false;
        if (list == null || list.size() == 0) {
            return false;
        }
        this.f324156d = list;
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabase = getWritableDatabase();
                sQLiteDatabase.beginTransaction();
                Iterator<WinkNewAlbumConfigInfo> it = this.f324156d.iterator();
                while (it.hasNext()) {
                    sQLiteDatabase.execSQL(i(it.next().getStoryID()));
                }
                try {
                    sQLiteDatabase.setTransactionSuccessful();
                    return true;
                } catch (Exception e16) {
                    e = e16;
                    z16 = true;
                    QLog.d("WinkNewAlbumDatabaseHelper", 1, "create Album Fail! " + e);
                    r(sQLiteDatabase);
                    return z16;
                }
            } finally {
                r(sQLiteDatabase);
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

    public void b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS t_clip_cache_album(albumid TEXT PRIMARY KEY, storyid TEXT, coverid TEXT, albumName TEXT, firstTime LONG, lastTime LONG, photoIds TEXT, exposureTimes INTEGER)");
    }

    public ContentValues d(WinkNewMemoryAlbumResult winkNewMemoryAlbumResult) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("albumid", winkNewMemoryAlbumResult.getAlbumID());
        contentValues.put("storyid", winkNewMemoryAlbumResult.getStoryID());
        contentValues.put(AdParam.COVERID, winkNewMemoryAlbumResult.getAlbumCoverPhotoId());
        contentValues.put(AEEditorConstants.ALBUMNAME, winkNewMemoryAlbumResult.getCom.tencent.aelight.camera.constants.AEEditorConstants.ALBUMNAME java.lang.String());
        contentValues.put("firstTime", Long.valueOf(winkNewMemoryAlbumResult.p()));
        contentValues.put("lastTime", Long.valueOf(winkNewMemoryAlbumResult.l()));
        contentValues.put("exposureTimes", Integer.valueOf(winkNewMemoryAlbumResult.getExposeTimes()));
        contentValues.put("photoIds", winkNewMemoryAlbumResult.n());
        return contentValues;
    }

    public List<WinkNewAlbumConfigInfo> e() {
        return this.f324156d;
    }

    public ContentValues f(a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", aVar.getPhotoID());
        contentValues.put("similarity", Float.valueOf(aVar.getSimilarity()));
        contentValues.put("hasexposure", Integer.valueOf(aVar.getHasExposure()));
        contentValues.put("aestheticscore", Float.valueOf(aVar.getAestheticScore()));
        return contentValues;
    }

    public String g(String str) {
        return "t_clip_" + str;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public String getDatabaseName() {
        return "memory_album.db";
    }

    public String i(String str) {
        return "CREATE TABLE IF NOT EXISTS t_clip_" + str + "(id TEXT PRIMARY KEY, similarity FLOAT, hasexposure INTEGER, aestheticscore FLOAT)";
    }

    public String k() {
        return "t_clip_cache_album";
    }

    public ContentValues m(z83.a aVar) {
        String str;
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", aVar.getId());
        contentValues.put("mediatype", Integer.valueOf(aVar.getMediaType()));
        contentValues.put("submediatype", Integer.valueOf(aVar.getSubMediaType()));
        contentValues.put("cameratype", Integer.valueOf(aVar.getCom.tencent.mobileqq.shortvideo.ShortVideoConstants.PARAM_KEY_CAMERA_TYPE java.lang.String()));
        contentValues.put("cameraswitch", Integer.valueOf(aVar.getCameraSwitch()));
        contentValues.put("hasface", Integer.valueOf(aVar.getHasFace()));
        contentValues.put("videoduration", Integer.valueOf(aVar.getVideoDuration()));
        contentValues.put("width", Integer.valueOf(aVar.getWidth()));
        contentValues.put("height", Integer.valueOf(aVar.getHeight()));
        contentValues.put("hasexposure", Integer.valueOf(aVar.getHasExposure()));
        contentValues.put("path", aVar.getPath());
        contentValues.put("timestamp", Long.valueOf(aVar.getTimestamp()));
        contentValues.put("year", Integer.valueOf(aVar.getYear()));
        contentValues.put("month", Integer.valueOf(aVar.getMonth()));
        contentValues.put("dayofmonth", Integer.valueOf(aVar.getDayOfMonth()));
        contentValues.put("dayofweek", Integer.valueOf(aVar.getDayOfWeek()));
        contentValues.put(WidgetCacheLunarData.WEEK, Integer.valueOf(aVar.getCom.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData.WEEK java.lang.String()));
        contentValues.put("localmediainfo", aVar.getOriginPhoto().toJsonString());
        contentValues.put("chinese_month", Integer.valueOf(aVar.getLunarMonth()));
        contentValues.put("aestheticscore", Float.valueOf(aVar.getAestheticScore()));
        if (aVar.getCity() != null) {
            str = aVar.getCity();
        } else {
            str = "";
        }
        contentValues.put("city", str);
        contentValues.put("longitude", Float.valueOf(aVar.getLongitude()));
        contentValues.put("latitude", Float.valueOf(aVar.getLatitude()));
        return contentValues;
    }

    public String n(List<String> list) {
        StringBuilder sb5 = new StringBuilder("id IN (");
        String[] strArr = new String[list.size()];
        for (int i3 = 0; i3 < list.size(); i3++) {
            strArr[i3] = list.get(i3);
            if (i3 > 0) {
                sb5.append(", ");
            }
            sb5.append(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
        }
        sb5.append(")");
        return sb5.toString();
    }

    public String o(String str) {
        return "SELECT COUNT(*) FROM " + g(str) + " WHERE hasexposure = 0";
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS t_clip_memory_photo(id TEXT PRIMARY KEY, mediatype INTEGER, submediatype INTEGER, cameratype INTEGER, cameraswitch INTEGER, hasface INTEGER, videoduration FLOAT, width INTEGER, height INTEGER, aestheticscore FLOAT, curationscore FLOAT, facecount INTEGER, hasexposure INTEGER, path TEXT, timestamp LONG, year INTEGER, month INTEGER, dayofmonth INTEGER, dayofweek INTEGER, week INTEGER, localmediainfo TEXT, chinese_month INTEGER, chinese_day_of_month INTEGER, province TEXT, city TEXT, longitude FLOAT, latitude FLOAT )");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS t_clip_cache_album(albumid TEXT PRIMARY KEY, storyid TEXT, coverid TEXT, albumName TEXT, firstTime LONG, lastTime LONG, photoIds TEXT, exposureTimes INTEGER)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        QLog.i("WinkNewAlbumDatabaseHelper", 1, "onUpgrade oldVersion:" + i3 + " newVersion:" + i16);
        if (i3 < 5 && i16 == 5) {
            try {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS t_clip_memory_photo");
                c(sQLiteDatabase);
                onCreate(sQLiteDatabase);
                QLog.i("WinkNewAlbumDatabaseHelper", 1, "onUpgrade success");
                return;
            } catch (Exception e16) {
                QLog.e("WinkNewAlbumDatabaseHelper", 1, e16, new Object[0]);
                return;
            }
        }
        if (i3 < 5 && i16 == 6) {
            try {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS t_clip_memory_photo");
                c(sQLiteDatabase);
                onCreate(sQLiteDatabase);
                QLog.i("WinkNewAlbumDatabaseHelper", 1, "onUpgrade success");
                return;
            } catch (Exception e17) {
                QLog.e("WinkNewAlbumDatabaseHelper", 1, e17, new Object[0]);
                return;
            }
        }
        if (i3 == 5 && i16 == 6) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE t_clip_memory_photo ADD COLUMN chinese_month INTEGER");
                sQLiteDatabase.execSQL("ALTER TABLE t_clip_memory_photo ADD COLUMN chinese_day_of_month INTEGER");
                sQLiteDatabase.execSQL("ALTER TABLE t_clip_memory_photo ADD COLUMN province TEXT");
                sQLiteDatabase.execSQL("ALTER TABLE t_clip_memory_photo ADD COLUMN city TEXT");
                sQLiteDatabase.execSQL("ALTER TABLE t_clip_memory_photo ADD COLUMN longitude FLOAT");
                sQLiteDatabase.execSQL("ALTER TABLE t_clip_memory_photo ADD COLUMN latitude FLOAT");
                QLog.i("WinkNewAlbumDatabaseHelper", 1, "Database Upgrade successfully");
            } catch (Exception e18) {
                QLog.e("WinkNewAlbumDatabaseHelper", 1, "Error upgrading database to version 9125", e18);
            }
        }
    }

    public String p(String str) {
        String g16 = g(str);
        return "SELECT " + g16 + ".id, t_clip_memory_photo.mediatype FROM " + g16 + " INNER JOIN t_clip_memory_photo ON " + g16 + ".id = t_clip_memory_photo.id WHERE " + g16 + ".hasexposure = 0";
    }

    public String q(String str) {
        return "id='" + str + "'";
    }

    public void r(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            try {
                if (sQLiteDatabase.isOpen() && sQLiteDatabase.inTransaction()) {
                    sQLiteDatabase.endTransaction();
                    QLog.d("WinkNewAlbumDatabaseHelper", 4, "safeEndTransaction success");
                    return;
                }
            } catch (Exception e16) {
                QLog.e("WinkNewAlbumDatabaseHelper", 1, "safeEndTransaction error", e16);
                return;
            }
        }
        if (sQLiteDatabase == null) {
            throw new RuntimeException("safeEndTransaction error database == null");
        }
        QLog.e("WinkNewAlbumDatabaseHelper", 1, "safeEndTransaction error\uff0cdatabase.isOpen():" + sQLiteDatabase.isOpen() + " database.inTransaction():" + sQLiteDatabase.inTransaction());
        throw new RuntimeException("safeEndTransaction error");
    }
}
