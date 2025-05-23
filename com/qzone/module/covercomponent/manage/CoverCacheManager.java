package com.qzone.module.covercomponent.manage;

import android.text.TextUtils;
import com.qzone.module.covercomponent.model.CoverDBCacheData;
import com.qzone.module.covercomponent.utils.CoverHelper;
import com.qzone.module.covercomponent.utils.SimpleMemoryCache;
import com.qzone.proxy.covercomponent.QzoneCoverConst;
import com.qzone.proxy.covercomponent.adapter.CoverLog;
import com.qzone.proxy.covercomponent.env.CoverEnv;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheWeatherData;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.music.SongInfo;
import cooperation.qzone.model.CoverCacheData;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import n7.a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CoverCacheManager {

    /* renamed from: f, reason: collision with root package name */
    private static volatile CoverCacheManager f48635f = null;
    public static volatile String gLoginUserCoverUrl = "";

    /* renamed from: a, reason: collision with root package name */
    private long f48636a;

    /* renamed from: b, reason: collision with root package name */
    private long f48637b;

    /* renamed from: c, reason: collision with root package name */
    private ReadWriteLock f48638c = new ReentrantReadWriteLock();

    /* renamed from: d, reason: collision with root package name */
    protected CacheHolder f48639d = new CacheHolder();

    /* renamed from: e, reason: collision with root package name */
    private SimpleMemoryCache f48640e = new SimpleMemoryCache(10);

    protected CoverCacheManager() {
    }

    public static CoverCacheManager getInstance() {
        if (f48635f == null) {
            synchronized (CoverCacheManager.class) {
                if (f48635f == null) {
                    f48635f = new CoverCacheManager();
                }
            }
        }
        return f48635f;
    }

    public static SongInfo getMusicInfo(CoverCacheData coverCacheData) {
        HashMap<String, String> hashMap;
        SongInfo songInfo = new SongInfo();
        if (coverCacheData == null || (hashMap = coverCacheData.mapExtInfo) == null) {
            return null;
        }
        if (hashMap.get("song_id") != null) {
            songInfo.f251867d = Long.parseLong(coverCacheData.mapExtInfo.get("song_id"));
        }
        if (coverCacheData.mapExtInfo.get("song_mid") != null) {
            songInfo.E = coverCacheData.mapExtInfo.get("song_mid");
        }
        if (coverCacheData.mapExtInfo.get("song_name") != null) {
            songInfo.f251871i = coverCacheData.mapExtInfo.get("song_name");
        }
        if (coverCacheData.mapExtInfo.get("song_id") != null) {
            songInfo.F = coverCacheData.mapExtInfo.get("singer_name");
        }
        return songInfo;
    }

    public static int getSuperCoverTrans(long j3) {
        CoverCacheData coverFromCache = getInstance().getCoverFromCache(j3);
        if (coverFromCache == null || !QzoneCoverConst.CoverStringType.COVER_TYPE_FULL_SCREEN.equals(coverFromCache.type) || coverFromCache.mapExtInfo == null || !CoverEnv.isSupportSuperCover()) {
            return 255;
        }
        return transparencyValueRealValue(coverFromCache.mapExtInfo.get(QzoneCoverConst.KEY_TRANSPARENCY));
    }

    public static int getSuperCoverTransFromMemory(long j3) {
        CoverCacheData coverFromMemory = getInstance().getCoverFromMemory(j3);
        RFWLog.d("CoverCacheManager", RFWLog.USR, "getSuperCoverTransFromMemory: , uin: " + j3 + ", cover: " + coverFromMemory);
        if (coverFromMemory == null || !QzoneCoverConst.CoverStringType.COVER_TYPE_FULL_SCREEN.equals(coverFromMemory.type) || coverFromMemory.mapExtInfo == null || !CoverEnv.isSupportSuperCover()) {
            return 255;
        }
        return transparencyValueRealValue(coverFromMemory.mapExtInfo.get(QzoneCoverConst.KEY_TRANSPARENCY));
    }

    public static CoverCacheData parseCoverJceJson(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        JSONArray jSONArray;
        JSONObject jSONObject5;
        CoverCacheData coverCacheData = new CoverCacheData();
        String optString = jSONObject.optString("type");
        coverCacheData.type = optString;
        if (TextUtils.isEmpty(optString)) {
            CoverLog.e("cover", "cover type is empty!!!", null);
            return coverCacheData;
        }
        coverCacheData.coverId = jSONObject.optString("coverId");
        coverCacheData.isJigsawOpen = jSONObject.optInt("photoWallCombinePic");
        if (jSONObject.has("MulRelsotionUrl") && (jSONObject5 = jSONObject.getJSONObject("MulRelsotionUrl")) != null) {
            String optString2 = jSONObject5.optString("HigeResolutionCover");
            if (optString2 != null && optString2.length() > 0) {
                coverCacheData.urls.put("HigeResolutionCover", optString2);
            }
            String optString3 = jSONObject5.optString("LowResolutionCover");
            if (optString3 != null && optString3.length() > 0) {
                coverCacheData.urls.put("LowResolutionCover", optString3);
            }
        }
        if (jSONObject.has("vecUrls") && (jSONArray = jSONObject.getJSONArray("vecUrls")) != null && jSONArray.length() > 0) {
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject6 = jSONArray.getJSONObject(i3);
                if (jSONObject6 != null) {
                    Iterator keys = jSONObject6.keys();
                    HashMap hashMap = new HashMap();
                    while (keys.hasNext()) {
                        String str = (String) keys.next();
                        String optString4 = jSONObject6.optString(str);
                        if (optString4 != null && optString4.length() > 0) {
                            try {
                                hashMap.put(Integer.valueOf(Integer.parseInt(str)), optString4);
                            } catch (Exception e16) {
                                e16.printStackTrace();
                            }
                        }
                    }
                    if (hashMap.size() > 0) {
                        coverCacheData.photoWall.add(hashMap);
                    }
                }
            }
        }
        if (jSONObject.has("mapExtInfo") && (jSONObject4 = jSONObject.getJSONObject("mapExtInfo")) != null) {
            Iterator keys2 = jSONObject4.keys();
            while (keys2.hasNext()) {
                String str2 = (String) keys2.next();
                String optString5 = jSONObject4.optString(str2);
                if (optString5 != null && optString5.length() > 0) {
                    coverCacheData.mapExtInfo.put(str2, optString5);
                }
            }
        }
        if (jSONObject.has("gameCoverInfo") && (jSONObject3 = jSONObject.getJSONObject("gameCoverInfo")) != null) {
            if (coverCacheData.gameCoverInfo == null) {
                coverCacheData.gameCoverInfo = new CoverCacheData.GameCoverInfo();
            }
            coverCacheData.gameCoverInfo.xCoordLU = jSONObject3.optInt("xCoordLU");
            coverCacheData.gameCoverInfo.yCoordLU = jSONObject3.optInt("yCoordLU");
            coverCacheData.gameCoverInfo.xCoordRD = jSONObject3.optInt("xCoordRD");
            coverCacheData.gameCoverInfo.yCoordRD = jSONObject3.optInt("yCoordRD");
            coverCacheData.gameCoverInfo.jmpUrl = jSONObject3.optString("jmpUrl");
            coverCacheData.gameCoverInfo.schema = jSONObject3.optString(QZoneDTLoginReporter.SCHEMA);
            coverCacheData.gameCoverInfo.jmpType = jSONObject3.optInt("jmpType");
        }
        if (jSONObject.has("packageInfo") && (jSONObject2 = jSONObject.getJSONObject("packageInfo")) != null) {
            if (coverCacheData.packageInfo == null) {
                coverCacheData.packageInfo = new CoverCacheData.PackageInfo();
            }
            coverCacheData.packageInfo.prePic = jSONObject2.optString("prePic");
            coverCacheData.packageInfo.PackageUrl = jSONObject2.optString("PackageUrl");
            coverCacheData.packageInfo.md5 = jSONObject2.optString("md5");
            coverCacheData.packageInfo.weather = jSONObject2.optInt("weather");
            coverCacheData.packageInfo.daytime = jSONObject2.optInt(WidgetCacheWeatherData.DAYTIME);
            coverCacheData.packageInfo.coverStyle = jSONObject2.optInt("coverStyle");
            coverCacheData.packageInfo.degrade_pic = jSONObject2.optString("degrade_pic");
        }
        return coverCacheData;
    }

    protected a b() {
        a(this.f48639d);
        return this.f48639d.f48643c;
    }

    public void clearMemoryCache() {
        this.f48640e.clear();
    }

    public void close() {
        clearMemoryCache();
        a b16 = b();
        if (b16 != null) {
            b16.close();
        }
        try {
            this.f48638c.writeLock().lock();
            this.f48636a = 0L;
            this.f48637b = 0L;
            this.f48639d.reset();
        } finally {
            this.f48638c.writeLock().unlock();
        }
    }

    public CoverCacheData getCoverDataFromDB(long j3) {
        CoverDBCacheData coverDBCacheData;
        long currentTimeMillis = System.currentTimeMillis();
        a b16 = b();
        if (b16 == null) {
            CoverLog.w("CoverCost", "IDbManagerWrapper is null", null);
        }
        String[] strArr = {String.valueOf(j3)};
        if (b16 != null) {
            try {
                coverDBCacheData = (CoverDBCacheData) b16.dbQueryFirstData("uin=?", null, strArr);
            } catch (NullPointerException e16) {
                CoverLog.w("CoverCost", "dbQueryFirstData NPE", e16);
                return null;
            }
        } else {
            coverDBCacheData = null;
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        CoverLog.i("CoverCost", CoverLog.CLR, "cover data db query cost : " + currentTimeMillis2 + "ms,uin=" + j3);
        if (coverDBCacheData == null) {
            CoverLog.i("CoverCost", CoverLog.CLR, "cover db data is null");
            return null;
        }
        return coverDBCacheData.getCoverCacheData();
    }

    public CoverCacheData getCoverFromCache(long j3) {
        Object obj = this.f48640e.get(j3);
        if (obj != null) {
            CoverLog.d("CoverCost", CoverLog.DEV, "getCoverFromCache return memory cache cover data.uin=" + j3);
            return (CoverCacheData) obj;
        }
        CoverCacheData coverDataFromDB = getCoverDataFromDB(j3);
        if (coverDataFromDB != null) {
            this.f48640e.add(j3, coverDataFromDB);
            CoverLog.i("CoverCost", CoverLog.CLR, "get cover cache not null");
            return coverDataFromDB;
        }
        this.f48640e.remove(j3);
        CoverLog.i("CoverCost", CoverLog.CLR, "get cover cache null");
        return null;
    }

    public CoverCacheData getCoverFromMemory(long j3) {
        Object obj = this.f48640e.get(j3);
        if (!(obj instanceof CoverCacheData)) {
            return null;
        }
        CoverLog.d("CoverCost", CoverLog.DEV, "getCoverFromCache return memory cache cover data.uin=" + j3);
        return (CoverCacheData) obj;
    }

    public void init(long j3, long j16) {
        this.f48636a = j3;
        this.f48637b = j16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static final class CacheHolder {

        /* renamed from: a, reason: collision with root package name */
        long f48641a;

        /* renamed from: b, reason: collision with root package name */
        long f48642b;

        /* renamed from: c, reason: collision with root package name */
        a f48643c;

        CacheHolder() {
        }

        public void reset() {
            this.f48641a = 0L;
            this.f48642b = 0L;
            this.f48643c = null;
        }
    }

    private void a(CacheHolder cacheHolder) {
        a aVar;
        if (cacheHolder == null) {
            return;
        }
        long j3 = this.f48636a;
        long j16 = this.f48637b;
        if (j3 != cacheHolder.f48641a || j16 != cacheHolder.f48642b || (aVar = cacheHolder.f48643c) == null || aVar.isClosed()) {
            cacheHolder.f48641a = j3;
            cacheHolder.f48642b = j16;
            cacheHolder.f48643c = CoverEnv.obtainDbManager(CoverDBCacheData.class, j3, "table_cover");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int transparencyValueRealValue(String str) {
        float f16;
        if (str != null && str.length() > 0) {
            try {
                f16 = Float.parseFloat(str);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            if (f16 > 100.0f) {
                f16 = 100.0f;
            }
            return 255 - ((int) (((f16 >= 0.0f ? f16 : 0.0f) * 255.0f) / 100.0f));
        }
        f16 = 0.0f;
        if (f16 > 100.0f) {
        }
        return 255 - ((int) (((f16 >= 0.0f ? f16 : 0.0f) * 255.0f) / 100.0f));
    }

    public void saveCoverIntoCache(CoverCacheData coverCacheData) {
        if (coverCacheData == null) {
            return;
        }
        if (!QzoneCoverConst.CoverStringType.COVER_TYPE_VIDEO_COVER.equals(coverCacheData.type) || coverCacheData.mapExtInfo.containsKey(QzoneCoverConst.KEY_VIDEO_COVER_PIC) || coverCacheData.mapExtInfo.containsKey(QzoneCoverConst.KEY_VIDEO_COVER_LOCAL_PIC) || coverCacheData.mapExtInfo.containsKey(QzoneCoverConst.KEY_VIDEO_COVER_PLAY_URL) || coverCacheData.mapExtInfo.containsKey(QzoneCoverConst.KEY_VIDEO_COVER_LOCAL_PATH)) {
            long j3 = coverCacheData.uin;
            gLoginUserCoverUrl = "";
            a b16 = b();
            if (b16 != null) {
                long currentTimeMillis = System.currentTimeMillis();
                boolean a16 = b16.a(new CoverDBCacheData(coverCacheData));
                this.f48640e.add(j3, coverCacheData);
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (CoverLog.isDevelopLevel()) {
                    CoverLog.d("CoverCost", CoverLog.DEV, "cover data db save cost : " + currentTimeMillis2 + "ms,uin=" + j3 + ",cover type=" + coverCacheData.type + ",dbInsertData ret=" + a16);
                }
            }
        }
    }

    public static String[] getMusicCoverUrl(CoverCacheData coverCacheData) {
        HashMap<String, String> hashMap;
        if (coverCacheData == null || (hashMap = coverCacheData.mapExtInfo) == null || hashMap.get("music_cover_urls") == null) {
            return null;
        }
        return coverCacheData.mapExtInfo.get("music_cover_urls").split("\\|");
    }

    public static String getRightCoverUrl(CoverCacheData coverCacheData) {
        if (coverCacheData == null) {
            return null;
        }
        if (!TextUtils.isEmpty(coverCacheData.local_url)) {
            return coverCacheData.local_url;
        }
        if (TextUtils.equals(coverCacheData.coverId, "118859")) {
            String defaultCover = CoverHelper.getDefaultCover();
            RFWLog.d("CoverCacheManager", RFWLog.USR, "use qzone default cover: " + defaultCover);
            return defaultCover;
        }
        if (coverCacheData.urls == null) {
            return null;
        }
        if (QzoneCoverConst.CoverStringType.COVER_TYPE_FULL_SCREEN.equals(coverCacheData.type) && !CoverEnv.isSupportSuperCover()) {
            String str = coverCacheData.urls.get("LowResolutionCover");
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        String str2 = coverCacheData.urls.get("HigeResolutionCover");
        String str3 = coverCacheData.urls.get("LowResolutionCover");
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        return str3;
    }

    public static String getWebviewDefaultUrl(CoverCacheData coverCacheData) {
        HashMap<String, String> hashMap;
        if (coverCacheData == null || (hashMap = coverCacheData.urls) == null) {
            return null;
        }
        String str = hashMap.get("HigeResolutionCover");
        String str2 = coverCacheData.urls.get("LowResolutionCover");
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        return str2;
    }
}
