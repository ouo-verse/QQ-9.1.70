package com.qq.e.tg.splash;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Movie;
import android.graphics.Point;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.qq.e.comm.managers.thread.GdtSDKThreadManager;
import com.qq.e.comm.util.ArrayUtilStub;
import com.qq.e.comm.util.FileUtil;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.JSONUtilStub;
import com.qq.e.comm.util.SharedPreferencedUtil;
import com.qq.e.tg.splash.PreCacheSplashAd;
import com.qq.e.tg.splash.image.ImageLoader;
import com.qq.e.tg.splash.image.ImageLoadingListener;
import com.qq.e.tg.splash.image.ImageTask;
import com.qq.e.tg.splash.image.TGSplashFileUtil;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class TGSplashPreCacheUtil {
    public static final String EMPTY_ORDER_KEY = "Splash_EmptyOrder";
    public static final String PRECACHE_KEY = "Splash_PreCache";
    public static final String SPLASH_RES_STATE = "Splash_ResState";

    /* loaded from: classes3.dex */
    public interface AdImageLoadListener {
        void onLoadFailed(int i3);

        void onLoaded(Bitmap bitmap);
    }

    private static PreCacheSplashAd a(List<Point> list, JSONObject jSONObject, JSONArray jSONArray, String str) {
        int currentTimeInMinute;
        PreCacheSplashAd preCacheSplashAd = null;
        if (list.size() != 0 && JSONUtilStub.notNull(jSONObject) && !JSONUtilStub.isJSONArrayEmpty(jSONArray)) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                if (list.get(i3) != null) {
                    int i16 = list.get(i3).x;
                    int i17 = list.get(i3).y;
                    if (i16 < 0) {
                        i16 = 0;
                    }
                    if (i17 > 1440) {
                        i17 = 1440;
                    }
                    if (i16 < i17 && (currentTimeInMinute = getCurrentTimeInMinute()) <= i17 && currentTimeInMinute >= i16) {
                        JSONArray optJSONArray = JSONUtilStub.optJSONArray(jSONObject, i16 + "-" + i17);
                        for (int i18 = 0; i18 < optJSONArray.length(); i18++) {
                            String optString = JSONUtilStub.optString(optJSONArray, i18);
                            for (int i19 = 0; i19 < jSONArray.length(); i19++) {
                                JSONObject jSONObject2 = JSONUtilStub.getJSONObject(jSONArray, i19);
                                if (JSONUtilStub.notNull(jSONObject2) && jSONObject2.has(optString)) {
                                    preCacheSplashAd = PreCacheSplashAd.fromJSONObject(str, jSONObject2);
                                    if (checkSrc(preCacheSplashAd) == 0) {
                                        GDTLogger.i("TGSplashPreCacheUtil [isInEffectPlayTime] success:" + optString + " start:" + i16 + " end:" + i17);
                                        return preCacheSplashAd;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return preCacheSplashAd;
    }

    public static int checkSrc(PreCacheSplashAd preCacheSplashAd) {
        boolean z16;
        boolean z17;
        String str;
        String str2;
        if (preCacheSplashAd == null) {
            return 17;
        }
        String string = SharedPreferencedUtil.getString(SPLASH_RES_STATE, "");
        GDTLogger.i("[checkSrc] cache = " + string);
        if (a(preCacheSplashAd.getVideo(), string) && a(preCacheSplashAd.getVideoFirstFrameUrl(), string)) {
            str2 = "[checkSrc] video && firstFrame exist!";
        } else if (a(preCacheSplashAd.getImg(), string)) {
            str2 = "[checkSrc] image exist!";
        } else {
            if (TextUtils.isEmpty(string)) {
                z16 = false;
            } else {
                String iconZipUrl = preCacheSplashAd.getIconZipUrl();
                String collisionAnimationUrl = preCacheSplashAd.getCollisionAnimationUrl();
                z16 = true;
                if (TextUtils.isEmpty(iconZipUrl) && TextUtils.isEmpty(collisionAnimationUrl)) {
                    str = "[checkSrc] no iconZipUrl and no collisionAnimationUrl";
                } else {
                    GDTLogger.i("[checkSrc] iconZipUrl:" + iconZipUrl);
                    if (!TextUtils.isEmpty(iconZipUrl) && a(iconZipUrl, string)) {
                        GDTLogger.i("[checkSrc] iconZipUrl exist!");
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    GDTLogger.i("[checkSrc] collisionAnimationUrl:" + collisionAnimationUrl);
                    if (!TextUtils.isEmpty(collisionAnimationUrl) && a(collisionAnimationUrl, string)) {
                        str = "[checkSrc] collisionAnimationUrl exist!";
                    } else {
                        z16 = z17;
                    }
                }
                GDTLogger.i(str);
            }
            if (z16) {
                str2 = "[checkSrc] icon exist!";
            } else {
                return 18;
            }
        }
        GDTLogger.i(str2);
        return 0;
    }

    public static void clearPreCacheData() {
        clearPreCacheData(true);
    }

    public static void clearResStateData() {
        SharedPreferencedUtil.remove(SPLASH_RES_STATE);
    }

    public static void fetchPreloadData(final Context context, final String str, final PreCacheSplashAd preCacheSplashAd, final boolean z16) {
        if (!TextUtils.isEmpty(str) && preCacheSplashAd != null && context != null) {
            GdtSDKThreadManager.getInstance().runOnThread(3, new Runnable() { // from class: com.qq.e.tg.splash.TGSplashPreCacheUtil.1
                @Override // java.lang.Runnable
                public final void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    GDTLogger.i("TGSplashPreCacheUtil [fetchPreloadData] start.");
                    PreCacheSplashAd.this.updatePreloadData(FileUtil.readStringFromFile(TGSplashFileUtil.getPreloadDataFile(context, str, z16)));
                    GDTLogger.i("TGSplashPreCacheUtil [fetchPreloadData] end cost :" + (System.currentTimeMillis() - currentTimeMillis));
                }
            });
        }
    }

    public static int getCurrentTimeInMinute() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        return (calendar.get(11) * 60) + calendar.get(12);
    }

    public static TGSplashPreCacheResult getEmptyOrderApUrlByDate(String str, String str2) {
        Date date;
        Date date2;
        TGSplashPreCacheResult tGSplashPreCacheResult = new TGSplashPreCacheResult();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            GDTLogger.i("TGSplashPreCacheUtil [getEmptyOrderApUrlByDate] posId :" + str + " date :" + str2);
            String string = SharedPreferencedUtil.getString(EMPTY_ORDER_KEY, "");
            if (TextUtils.isEmpty(string)) {
                GDTLogger.e("TGSplashPreCacheUtil [getEmptyOrderApUrlByDate] emptyOrderStr null!");
                tGSplashPreCacheResult.setErrorCode(8);
                return tGSplashPreCacheResult;
            }
            JSONObject newJSONObject = JSONUtilStub.newJSONObject(string);
            if (!JSONUtilStub.notNull(newJSONObject)) {
                GDTLogger.e("TGSplashPreCacheUtil [getEmptyOrderApUrlByDate] emptyOrderStr json null!");
                tGSplashPreCacheResult.setErrorCode(9);
                return tGSplashPreCacheResult;
            }
            JSONObject optJSONObject = JSONUtilStub.optJSONObject(newJSONObject, str);
            if (!JSONUtilStub.notNull(optJSONObject)) {
                GDTLogger.e("TGSplashPreCacheUtil [getEmptyOrderApUrlByDate] emptyOrderStr posJson null!");
                tGSplashPreCacheResult.setErrorCode(10);
                return tGSplashPreCacheResult;
            }
            GDTLogger.i("TGSplashPreCacheUtil [getEmptyOrderApUrlByDate] posJson :" + JSONUtilStub.toString(optJSONObject));
            Iterator keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String str3 = (String) keys.next();
                if (!TextUtils.isEmpty(str3)) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT);
                    Date date3 = null;
                    try {
                        date2 = simpleDateFormat.parse(str3);
                    } catch (Throwable th5) {
                        th = th5;
                        date = null;
                    }
                    try {
                        date3 = simpleDateFormat.parse(str2);
                        GDTLogger.i("TGSplashPreCacheUtil [getEmptyOrderApUrlByDate] dateCache :" + str3);
                    } catch (Throwable th6) {
                        th = th6;
                        date = date3;
                        date3 = date2;
                        GDTLogger.e("getEmptyOrderByDate error:", th);
                        Date date4 = date;
                        date2 = date3;
                        date3 = date4;
                        if (date2 != null) {
                            PreCacheSplashAd.Builder maxExposureDate = new PreCacheSplashAd.Builder().setApUrl(JSONUtilStub.optString(optJSONObject, str3, "")).setPosId(str).setMaxExposureDate(str3);
                            tGSplashPreCacheResult.setErrorCode(0);
                            tGSplashPreCacheResult.setPreCacheSplashAd(maxExposureDate.build());
                            return tGSplashPreCacheResult;
                        }
                        continue;
                    }
                    if (date2 != null && date3 != null && date2.compareTo(date3) >= 0) {
                        PreCacheSplashAd.Builder maxExposureDate2 = new PreCacheSplashAd.Builder().setApUrl(JSONUtilStub.optString(optJSONObject, str3, "")).setPosId(str).setMaxExposureDate(str3);
                        tGSplashPreCacheResult.setErrorCode(0);
                        tGSplashPreCacheResult.setPreCacheSplashAd(maxExposureDate2.build());
                        return tGSplashPreCacheResult;
                    }
                }
            }
            tGSplashPreCacheResult.setErrorCode(11);
            return tGSplashPreCacheResult;
        }
        GDTLogger.e("TGSplashPreCacheUtil [getEmptyOrderApUrlByDate] error!");
        tGSplashPreCacheResult.setErrorCode(7);
        return tGSplashPreCacheResult;
    }

    public static TGSplashPreCacheResult getPreCacheOrderByCurrentTimeMinute(Context context, String str) {
        TGSplashPreCacheResult tGSplashPreCacheResult = new TGSplashPreCacheResult();
        String todayDate = getTodayDate();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(todayDate)) {
            String string = SharedPreferencedUtil.getString(PRECACHE_KEY, "");
            if (TextUtils.isEmpty(string)) {
                GDTLogger.e("TGSplashPreCacheUtil [getPreCacheOrderByCurrentTimeMinute] preCacheStr null!");
                tGSplashPreCacheResult.setErrorCode(2);
                return tGSplashPreCacheResult;
            }
            JSONObject newJSONObject = JSONUtilStub.newJSONObject(string);
            if (!JSONUtilStub.notNull(newJSONObject)) {
                GDTLogger.e("TGSplashPreCacheUtil [getPreCacheOrderByCurrentTimeMinute] preCache json null!");
                tGSplashPreCacheResult.setErrorCode(3);
                return tGSplashPreCacheResult;
            }
            JSONObject optJSONObject = JSONUtilStub.optJSONObject(newJSONObject, str);
            if (!JSONUtilStub.notNull(optJSONObject)) {
                GDTLogger.e("TGSplashPreCacheUtil [getPreCacheOrderByCurrentTimeMinute] posJson null!");
                tGSplashPreCacheResult.setErrorCode(4);
                return tGSplashPreCacheResult;
            }
            GDTLogger.i("TGSplashPreCacheUtil [getPreCacheOrderByCurrentTimeMinute] posJson :" + JSONUtilStub.toString(optJSONObject));
            JSONObject optJSONObject2 = JSONUtilStub.optJSONObject(optJSONObject, todayDate + "-timeRange");
            if (!JSONUtilStub.notNull(optJSONObject2)) {
                GDTLogger.e("TGSplashPreCacheUtil [getPreCacheOrderByCurrentTimeMinute] timeJson null!");
                return getPreCacheOrderByDate(context, str, todayDate);
            }
            JSONArray optJSONArray = JSONUtilStub.optJSONArray(optJSONObject, todayDate);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Iterator keys = optJSONObject2.keys();
            while (true) {
                if (!keys.hasNext()) {
                    break;
                }
                String str2 = (String) keys.next();
                if (!TextUtils.isEmpty(str2) && str2.contains("-")) {
                    try {
                        String[] split = str2.split("-");
                        arrayList.add(new Point(Integer.parseInt(split[0]), Integer.parseInt(split[1])));
                        JSONArray optJSONArray2 = JSONUtilStub.optJSONArray(optJSONObject2, str2);
                        if (!JSONUtilStub.isJSONArrayEmpty(optJSONArray2)) {
                            for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                                if (!arrayList2.contains(JSONUtilStub.optString(optJSONArray2, i3))) {
                                    arrayList2.add(JSONUtilStub.optString(optJSONArray2, i3));
                                }
                            }
                        }
                    } catch (Throwable th5) {
                        GDTLogger.e("cache time range order error:", th5);
                    }
                }
            }
            PreCacheSplashAd a16 = a(arrayList, optJSONObject2, optJSONArray, str);
            if (a16 != null) {
                fetchPreloadData(context, str, a16, false);
                GDTLogger.i("TGSplashPreCacheUtil [getPreCacheOrderByCurrentTimeMinute] result :" + JSONUtilStub.toString(a16.formatOrderInfo()));
                tGSplashPreCacheResult.setErrorCode(0);
                tGSplashPreCacheResult.setPreCacheSplashAd(a16);
                return tGSplashPreCacheResult;
            }
            GDTLogger.e("TGSplashPreCacheUtil [getPreCacheOrderByCurrentTimeMinute] can not match timeRange order.");
            return a(context, str, todayDate, arrayList2);
        }
        GDTLogger.e("TGSplashPreCacheUtil [getPreCacheOrderByCurrentTimeMinute] error!");
        tGSplashPreCacheResult.setErrorCode(1);
        return tGSplashPreCacheResult;
    }

    public static TGSplashPreCacheResult getPreCacheOrderByDate(Context context, String str) {
        return getPreCacheOrderByDate(context, str, getTodayDate());
    }

    public static String getTodayDate() {
        return new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT, Locale.getDefault()).format(new Date());
    }

    public static void preloadAdImages(final Context context, final PreCacheSplashAd preCacheSplashAd, WeakReference<AdImageLoadListener> weakReference) {
        final AdImageLoadListener adImageLoadListener;
        if (preCacheSplashAd != null && preCacheSplashAd.isSrcReady(context)) {
            if (weakReference != null && weakReference.get() != null) {
                adImageLoadListener = weakReference.get();
            } else {
                adImageLoadListener = null;
            }
            if (adImageLoadListener == null) {
                GDTLogger.e("TGSplashPreCacheUtil [preloadImgBitmap] loadListener == null");
                return;
            } else {
                GdtSDKThreadManager.getInstance().runOnThread(3, new Runnable() { // from class: com.qq.e.tg.splash.TGSplashPreCacheUtil.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        File videoFile = TGSplashFileUtil.getVideoFile(context, preCacheSplashAd.getVideo());
                        if (videoFile != null && videoFile.exists()) {
                            String videoFirstFrameUrl = preCacheSplashAd.getVideoFirstFrameUrl();
                            if (TextUtils.isEmpty(videoFirstFrameUrl)) {
                                adImageLoadListener.onLoadFailed(13);
                                return;
                            } else {
                                TGSplashPreCacheUtil.a(TGSplashFileUtil.getImgFile(context, videoFirstFrameUrl), adImageLoadListener);
                                return;
                            }
                        }
                        String img = preCacheSplashAd.getImg();
                        if (TextUtils.isEmpty(img)) {
                            adImageLoadListener.onLoadFailed(14);
                        } else {
                            TGSplashPreCacheUtil.a(TGSplashFileUtil.getImgFile(context, img), adImageLoadListener);
                        }
                    }
                });
                return;
            }
        }
        GDTLogger.e("TGSplashPreCacheUtil [preloadImgBitmap] error");
        if (weakReference != null && weakReference.get() != null) {
            weakReference.get().onLoadFailed(12);
        }
    }

    public static void updatePreCacheInfo(final PreCacheSplashAd preCacheSplashAd, final List<Pair<Integer, Integer>> list) {
        if (preCacheSplashAd == null) {
            return;
        }
        GdtSDKThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.qq.e.tg.splash.TGSplashPreCacheUtil.2
            @Override // java.lang.Runnable
            public final void run() {
                JSONObject formatOrderInfo = PreCacheSplashAd.this.formatOrderInfo();
                if (!JSONUtilStub.notNull(formatOrderInfo)) {
                    GDTLogger.e("TGSplashPreCacheUtil [updatePreCacheInfo] data null");
                    return;
                }
                if (PreCacheSplashAd.this.isEmpty()) {
                    GDTLogger.i("TGSplashPreCacheUtil [updatePreCacheInfo] Empty order:" + JSONUtilStub.toString(formatOrderInfo));
                    SharedPreferencedUtil.putString(TGSplashPreCacheUtil.EMPTY_ORDER_KEY, JSONUtilStub.toString(formatOrderInfo));
                    return;
                }
                GDTLogger.i("TGSplashPreCacheUtil [updatePreCacheInfo] order:" + JSONUtilStub.toString(formatOrderInfo));
                TGSplashPreCacheUtil.a(formatOrderInfo, PreCacheSplashAd.this, list);
            }
        });
    }

    public static void updateResState(String str) {
        JSONArray jSONArray;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String string = SharedPreferencedUtil.getString(SPLASH_RES_STATE, "");
        try {
            if (TextUtils.isEmpty(string)) {
                jSONArray = new JSONArray();
            } else {
                JSONArray jSONArray2 = new JSONArray(string);
                for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                    if (str.equals(jSONArray2.getString(i3))) {
                        GDTLogger.d("TGSplashPreCacheUtil [updateResState] existed !");
                        return;
                    }
                }
                jSONArray = jSONArray2;
            }
            jSONArray.mo162put(str);
            String jSONArray3 = jSONArray.toString();
            GDTLogger.d("TGSplashPreCacheUtil [updateResState] new :" + jSONArray3);
            SharedPreferencedUtil.putString(SPLASH_RES_STATE, jSONArray3);
        } catch (Throwable th5) {
            GDTLogger.e(th5.getMessage());
        }
    }

    private static TGSplashPreCacheResult a(Context context, String str, String str2, List<String> list) {
        int i3;
        TGSplashPreCacheResult tGSplashPreCacheResult = new TGSplashPreCacheResult();
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            GDTLogger.e("TGSplashPreCacheUtil [getPreCacheOrderListByDate] error!");
            i3 = 1;
        } else {
            GDTLogger.i("TGSplashPreCacheUtil [getPreCacheOrderListByDate] posId :" + str + " date :" + str2);
            String string = SharedPreferencedUtil.getString(PRECACHE_KEY, "");
            if (TextUtils.isEmpty(string)) {
                GDTLogger.e("TGSplashPreCacheUtil [getPreCacheOrderListByDate] preCacheStr null!");
                i3 = 2;
            } else {
                JSONObject newJSONObject = JSONUtilStub.newJSONObject(string);
                if (JSONUtilStub.notNull(newJSONObject)) {
                    JSONObject optJSONObject = JSONUtilStub.optJSONObject(newJSONObject, str);
                    if (JSONUtilStub.notNull(optJSONObject)) {
                        GDTLogger.i("TGSplashPreCacheUtil [getPreCacheOrderListByDate] posJson :" + JSONUtilStub.toString(optJSONObject));
                        JSONArray optJSONArray = JSONUtilStub.optJSONArray(optJSONObject, str2);
                        if (!JSONUtilStub.isJSONArrayEmpty(optJSONArray)) {
                            if (ArrayUtilStub.isNullOrEmpty(list)) {
                                PreCacheSplashAd fromJSONObject = PreCacheSplashAd.fromJSONObject(str, JSONUtilStub.getJSONObject(optJSONArray, 0));
                                fetchPreloadData(context, str, fromJSONObject, false);
                                if (fromJSONObject != null) {
                                    GDTLogger.d("TGSplashPreCacheUtil [getPreCacheOrderListByDate] result :" + JSONUtilStub.toString(fromJSONObject.formatOrderInfo()));
                                    tGSplashPreCacheResult.setErrorCode(0);
                                    tGSplashPreCacheResult.setPreCacheSplashAd(fromJSONObject);
                                } else {
                                    tGSplashPreCacheResult.setErrorCode(6);
                                }
                            } else {
                                GDTLogger.i("TGSplashPreCacheUtil [getPreCacheOrderListByDate] got time range order need filter.");
                                int i16 = 0;
                                while (true) {
                                    if (i16 >= optJSONArray.length()) {
                                        break;
                                    }
                                    PreCacheSplashAd fromJSONObject2 = PreCacheSplashAd.fromJSONObject(str, JSONUtilStub.getJSONObject(optJSONArray, i16));
                                    if (fromJSONObject2 != null) {
                                        if (!list.contains(fromJSONObject2.getUoid())) {
                                            GDTLogger.i("TGSplashPreCacheUtil [getPreCacheOrderListByDate] result :" + JSONUtilStub.toString(fromJSONObject2.formatOrderInfo()));
                                            fetchPreloadData(context, str, fromJSONObject2, false);
                                            tGSplashPreCacheResult.setErrorCode(0);
                                            tGSplashPreCacheResult.setPreCacheSplashAd(fromJSONObject2);
                                            break;
                                        }
                                        GDTLogger.i("TGSplashPreCacheUtil [getPreCacheOrderListByDate] result filtered:" + fromJSONObject2.getUoid());
                                        tGSplashPreCacheResult.setErrorCode(7);
                                    } else {
                                        tGSplashPreCacheResult.setErrorCode(6);
                                    }
                                    i16++;
                                }
                            }
                            return tGSplashPreCacheResult;
                        }
                        i3 = 5;
                    } else {
                        GDTLogger.e("TGSplashPreCacheUtil [getPreCacheOrderListByDate] posJson null!");
                        i3 = 4;
                    }
                } else {
                    GDTLogger.e("TGSplashPreCacheUtil [getPreCacheOrderListByDate] preCache json null!");
                    i3 = 3;
                }
            }
        }
        tGSplashPreCacheResult.setErrorCode(i3);
        return tGSplashPreCacheResult;
    }

    public static void clearPreCacheData(boolean z16) {
        SharedPreferencedUtil.remove(PRECACHE_KEY);
        SharedPreferencedUtil.remove(EMPTY_ORDER_KEY);
        if (z16) {
            SharedPreferencedUtil.remove(SPLASH_RES_STATE);
        }
    }

    public static TGSplashPreCacheResult getPreCacheOrderByDate(Context context, String str, String str2) {
        return a(context, str, str2, (List<String>) null);
    }

    private static void a(PreCacheSplashAd preCacheSplashAd, List<Pair<Integer, Integer>> list, JSONObject jSONObject) {
        if (preCacheSplashAd == null || ArrayUtilStub.isNullOrEmpty(list) || !JSONUtilStub.notNull(jSONObject)) {
            return;
        }
        JSONObject optJSONObject = JSONUtilStub.optJSONObject(jSONObject, preCacheSplashAd.getPosId());
        if (JSONUtilStub.notNull(optJSONObject)) {
            JSONObject optJSONObject2 = JSONUtilStub.optJSONObject(optJSONObject, preCacheSplashAd.getDate() + "-timeRange");
            if (!JSONUtilStub.notNull(optJSONObject2)) {
                optJSONObject2 = JSONUtilStub.newJSONObject();
            }
            for (Pair<Integer, Integer> pair : list) {
                if (pair != null) {
                    if (optJSONObject2.has(pair.first + "-" + pair.second)) {
                        JSONArray optJSONArray = JSONUtilStub.optJSONArray(optJSONObject2, pair.first + "-" + pair.second);
                        if (!JSONUtilStub.isJSONArrayEmpty(optJSONArray) && !optJSONArray.toString().contains(preCacheSplashAd.getUoid())) {
                            optJSONArray.mo162put(preCacheSplashAd.getUoid());
                        }
                    } else {
                        JSONArray jSONArray = new JSONArray();
                        jSONArray.mo162put(preCacheSplashAd.getUoid());
                        JSONUtilStub.put(optJSONObject2, pair.first + "-" + pair.second, jSONArray);
                    }
                }
            }
            GDTLogger.i("TGSplashPreCacheUtil [updatePreCacheInfo] write date :" + preCacheSplashAd.getDate());
            GDTLogger.i("TGSplashPreCacheUtil [updatePreCacheInfo] write data timeRangeJson:" + optJSONObject2);
            if (JSONUtilStub.notNull(optJSONObject2)) {
                JSONUtilStub.put(optJSONObject, preCacheSplashAd.getDate() + "-timeRange", optJSONObject2);
                StringBuilder sb5 = new StringBuilder("TGSplashPreCacheUtil [updatePreCacheInfo] write timeRangeJson end :");
                sb5.append(optJSONObject);
                GDTLogger.d(sb5.toString());
            }
        }
    }

    static /* synthetic */ void a(File file, final AdImageLoadListener adImageLoadListener) {
        if (adImageLoadListener == null) {
            GDTLogger.e("TGSplashPreCacheUtil [loadImgInternal] loadListener == null");
            return;
        }
        if (file == null || !file.exists()) {
            GDTLogger.e("TGSplashPreCacheUtil [loadImgInternal] imgFile error");
            adImageLoadListener.onLoadFailed(15);
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        ImageTask.Params params = new ImageTask.Params();
        params.imageFile = file;
        params.imageLoadingListener = new ImageLoadingListener() { // from class: com.qq.e.tg.splash.TGSplashPreCacheUtil.4
            @Override // com.qq.e.tg.splash.image.ImageLoadingListener
            public final void onLoadingComplete(String str, View view, Bitmap bitmap, Movie movie) {
                GDTLogger.e("TGSplashPreCacheUtil [loadImgInternal] onLoaded cost time :" + (System.currentTimeMillis() - currentTimeMillis));
                AdImageLoadListener.this.onLoaded(bitmap);
            }

            @Override // com.qq.e.tg.splash.image.ImageLoadingListener
            public final void onLoadingFailed(String str, View view, int i3) {
                GDTLogger.e("TGSplashPreCacheUtil [loadImgInternal] onLoadFailed :" + i3);
                AdImageLoadListener.this.onLoadFailed(16);
            }

            @Override // com.qq.e.tg.splash.image.ImageLoadingListener
            public final void onLoadingStatus(String str, boolean z16) {
            }
        };
        ImageLoader.getInstance().displayImage(params);
    }

    static /* synthetic */ void a(JSONObject jSONObject, PreCacheSplashAd preCacheSplashAd, List list) {
        if (!JSONUtilStub.notNull(jSONObject) || preCacheSplashAd == null) {
            GDTLogger.e("TGSplashPreCacheUtil [updatePreCache] data null");
            return;
        }
        String string = SharedPreferencedUtil.getString(PRECACHE_KEY, "");
        GDTLogger.i("TGSplashPreCacheUtil [updatePreCacheInfo] all cached orders:" + string);
        if (TextUtils.isEmpty(string)) {
            JSONObject newJSONObject = JSONUtilStub.newJSONObject();
            JSONArray jSONArray = new JSONArray();
            jSONArray.mo162put(jSONObject);
            JSONObject newJSONObject2 = JSONUtilStub.newJSONObject();
            JSONUtilStub.put(newJSONObject2, preCacheSplashAd.getDate(), jSONArray);
            JSONUtilStub.put(newJSONObject, preCacheSplashAd.getPosId(), newJSONObject2);
            a(preCacheSplashAd, (List<Pair<Integer, Integer>>) list, newJSONObject);
            String jSONUtilStub = JSONUtilStub.toString(newJSONObject);
            GDTLogger.i("TGSplashPreCacheUtil [updatePreCacheInfo] first write data :" + jSONUtilStub);
            SharedPreferencedUtil.putString(PRECACHE_KEY, jSONUtilStub);
            return;
        }
        JSONObject newJSONObject3 = JSONUtilStub.newJSONObject(string);
        if (!JSONUtilStub.notNull(newJSONObject3)) {
            GDTLogger.e("TGSplashPreCacheUtil [updatePreCacheInfo] preCache json null!");
            return;
        }
        JSONObject optJSONObject = JSONUtilStub.optJSONObject(newJSONObject3, preCacheSplashAd.getPosId());
        if (!JSONUtilStub.notNull(optJSONObject)) {
            GDTLogger.e("TGSplashPreCacheUtil [updatePreCacheInfo] posJson null!");
            JSONObject newJSONObject4 = JSONUtilStub.newJSONObject();
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.mo162put(jSONObject);
            JSONObject newJSONObject5 = JSONUtilStub.newJSONObject();
            JSONUtilStub.put(newJSONObject5, preCacheSplashAd.getDate(), jSONArray2);
            JSONUtilStub.put(newJSONObject4, preCacheSplashAd.getPosId(), newJSONObject5);
            a(preCacheSplashAd, (List<Pair<Integer, Integer>>) list, newJSONObject3);
            String jSONUtilStub2 = JSONUtilStub.toString(newJSONObject4);
            GDTLogger.i("TGSplashPreCacheUtil [updatePreCacheInfo] write posJson :" + jSONUtilStub2);
            SharedPreferencedUtil.putString(PRECACHE_KEY, jSONUtilStub2);
            return;
        }
        if (optJSONObject.has(preCacheSplashAd.getDate())) {
            GDTLogger.e("TGSplashPreCacheUtil [updatePreCacheInfo] has :" + preCacheSplashAd.getDate());
            JSONUtilStub.optJSONArray(optJSONObject, preCacheSplashAd.getDate()).mo162put(jSONObject);
        } else {
            JSONArray jSONArray3 = new JSONArray();
            jSONArray3.mo162put(jSONObject);
            JSONUtilStub.put(optJSONObject, preCacheSplashAd.getDate(), jSONArray3);
            JSONUtilStub.put(newJSONObject3, preCacheSplashAd.getPosId(), optJSONObject);
        }
        a(preCacheSplashAd, (List<Pair<Integer, Integer>>) list, newJSONObject3);
        String jSONUtilStub3 = JSONUtilStub.toString(newJSONObject3);
        GDTLogger.i("TGSplashPreCacheUtil [updatePreCacheInfo] over write :" + jSONUtilStub3);
        SharedPreferencedUtil.putString(PRECACHE_KEY, jSONUtilStub3);
    }

    private static boolean a(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            try {
                JSONArray jSONArray = new JSONArray(str2);
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    if (str.equals(jSONArray.getString(i3))) {
                        GDTLogger.d("[checkSrc] src ok : url " + str);
                        return true;
                    }
                }
            } catch (Throwable th5) {
                GDTLogger.e(th5.getMessage());
            }
        }
        return false;
    }
}
