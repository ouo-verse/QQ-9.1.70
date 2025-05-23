package cooperation.qzone.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.media.ExifInterface;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.tencent.image.JpegExifReader;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes28.dex */
public class PhotoUtils {
    private static final int CLOSE = 0;
    private static final String IMAGE_ORDER_BY = "date_modified DESC";
    private static final String KEY_NEW_PHOTO_CHECK_LASTTIME = "LocalRecentPhotoCheckManager.new_photo_check_lasttime";
    public static final int RECENT_IMAGE_MIN_SIZE = 20480;
    private static final int SHOW = 4;
    private static final String TAG = "PhotoUtils";
    private static PhotoUtils mInstance;
    private static long uin;
    static ConcurrentHashMap<Long, Integer> map = new ConcurrentHashMap<>();
    private static final String[] PROJECTION_IMAGE = {"DISTINCT _data"};

    public static void clearNewPicRuleMapCache() {
        ConcurrentHashMap<Long, Integer> concurrentHashMap = map;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
        }
    }

    public static Bitmap decodeBitmapFromFile(String str, Bitmap bitmap) {
        return decodeBitmapFromFile(str, 0, 0, false, bitmap);
    }

    public static PhotoUtils get() {
        if (mInstance == null) {
            synchronized (PhotoUtils.class) {
                if (mInstance == null) {
                    mInstance = new PhotoUtils();
                }
            }
        }
        return mInstance;
    }

    public static ExifInterface getExif(String str) {
        try {
            if (!JpegExifReader.isCrashJpeg(str)) {
                return new ExifInterface(str);
            }
        } catch (IOException unused) {
        }
        return null;
    }

    private long getLastCheckTime() {
        return LocalMultiProcConfig.getLong(KEY_NEW_PHOTO_CHECK_LASTTIME, 0L);
    }

    public static int getPicRotate(String str) {
        int i3;
        try {
            int readOrientation = JpegExifReader.readOrientation(str);
            if (readOrientation != 3) {
                if (readOrientation != 6) {
                    if (readOrientation != 8) {
                        return 0;
                    }
                    i3 = 270;
                } else {
                    i3 = 90;
                }
            } else {
                i3 = 180;
            }
            return i3;
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0;
        }
    }

    public static String gpsInfoConvert(double d16) {
        String str;
        String[] split = Location.convert(Math.abs(d16), 2).split(":");
        String[] split2 = split[2].split("\\.");
        if (split2.length == 0) {
            str = split[2];
        } else {
            str = split2[0];
        }
        return split[0] + "/1," + split[1] + "/1," + str + "/1";
    }

    public static boolean isCurrentDayInQzone() {
        long j3 = LocalMultiProcConfig.getLong(QZoneHelper.QzoneSharePrefrenceConstants.KEY_PHOTO_GUIDE_ENTER_QZONE_DATE, 0L);
        if (j3 <= 0) {
            if (QLog.isDevelopLevel()) {
                QLog.d(TAG, 4, "isCurrentDayInQzone false");
            }
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis() - j3;
        if (currentTimeMillis <= 86400000 && currentTimeMillis > 0) {
            if (QLog.isDevelopLevel()) {
                QLog.d(TAG, 4, "isCurrentDayInQzone");
                return true;
            }
            return true;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "isCurrentDayInQzone false");
        }
        return false;
    }

    private static boolean isExifValuable(ExifInterface exifInterface) {
        if (exifInterface == null) {
            return false;
        }
        String attribute = exifInterface.getAttribute("DateTime");
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "FDateTime:" + attribute);
        }
        if (attribute == null) {
            return false;
        }
        return true;
    }

    public static boolean isInCheckTimeQuantum() {
        int config = QzoneConfig.getInstance().getConfig("PhotoUpload", QzoneConfig.SECONDARY_ALBUM_PHOTO_SHOW_START_HOUR, 19);
        int config2 = QzoneConfig.getInstance().getConfig("PhotoUpload", QzoneConfig.SECONDARY_ALBUM_PHOTO_SHOW_END_HOUR, 22);
        int i3 = Calendar.getInstance().get(11);
        if (i3 >= config && i3 < config2) {
            return true;
        }
        return false;
    }

    public static boolean isNewPicRule() {
        int int4Uin;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return false;
        }
        long longAccountUin = peekAppRuntime.getLongAccountUin();
        uin = longAccountUin;
        if (map.get(Long.valueOf(longAccountUin)) != null) {
            int4Uin = map.get(Long.valueOf(uin)).intValue();
        } else {
            int4Uin = LocalMultiProcConfig.getInt4Uin("qzone_feed_gray_mask", 1, uin);
            map.put(Long.valueOf(uin), Integer.valueOf(int4Uin));
        }
        if ((int4Uin & 2) == 0) {
            return false;
        }
        return true;
    }

    public static boolean isOverLastCheck() {
        long config = QzoneConfig.getInstance().getConfig("PhotoUpload", QzoneConfig.SECONDARY_PHOTOGUIDE_QQ_EXPOSEPHOTOTIMERANGE, 1) * 60 * 60 * 1000;
        long j3 = LocalMultiProcConfig.getLong(QZoneHelper.QzoneSharePrefrenceConstants.KEY_PHOTO_GUIDE_LAST_CHECK, 0L);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "KEY_PHOTO_GUIDE_LAST_CHECK get:" + j3);
        }
        if (j3 <= 0) {
            if (QLog.isDevelopLevel()) {
                QLog.d(TAG, 4, "isOverLastCheck");
            }
            return true;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "isOverLastCheck S-L:" + (System.currentTimeMillis() - j3));
        }
        if (System.currentTimeMillis() - j3 >= config || System.currentTimeMillis() - j3 <= 0) {
            return true;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "isOverLastCheck false");
            return false;
        }
        return false;
    }

    private static Cursor queryLatestImageCursor(Context context, int i3, long j3, long j16) {
        int config = QzoneConfig.getInstance().getConfig("PhotoUpload", QzoneConfig.SECONDARY_PHOTOGUIDE_GUIDE_PHOTO_CHANGE_STRATEGY, 1);
        int config2 = QzoneConfig.getInstance().getConfig("PhotoUpload", QzoneConfig.SECONDARY_PHOTOGUIDE_GUIDE_PHOTO_MIN_SIZE, 300) * 1024;
        long config3 = QzoneConfig.getInstance().getConfig("PhotoUpload", QzoneConfig.SECONDARY_PHOTOGUIDE_GUIDE_PHOTO_MAX_SIZE, 20000) * 1024;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("bucket_display_name");
        sb5.append(" != 'Screenshots' ");
        sb5.append(" and ");
        sb5.append("_size");
        sb5.append(">=");
        sb5.append(config2);
        if (config == 1) {
            sb5.append(" and ");
            sb5.append("_size");
            sb5.append("<=");
            sb5.append(config3);
        }
        sb5.append(" and ");
        sb5.append("date_modified");
        sb5.append(">=");
        sb5.append(j3 / 1000);
        sb5.append(" and ");
        sb5.append("date_modified");
        sb5.append(" <= ");
        sb5.append(j16 / 1000);
        try {
            return ContactsMonitor.query(context.getContentResolver(), MediaStore.Images.Media.EXTERNAL_CONTENT_URI, PROJECTION_IMAGE, sb5.toString(), null, "date_modified DESC LIMIT 0,50");
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0089, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isDevelopLevel() == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x008b, code lost:
    
        com.tencent.qphone.base.util.QLog.d(cooperation.qzone.util.PhotoUtils.TAG, 4, "queryLatestImages break");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ArrayList<String> queryLatestImages(Context context, int i3, long j3, long j16, int i16, int i17) {
        ArrayList<String> arrayList;
        Cursor queryLatestImageCursor;
        Cursor cursor = null;
        ArrayList<String> arrayList2 = null;
        cursor = null;
        try {
            try {
                queryLatestImageCursor = queryLatestImageCursor(context, i3, j3, j16);
            } catch (Throwable th5) {
                th = th5;
            }
            try {
                try {
                    int count = queryLatestImageCursor.getCount();
                    if (count > 0) {
                        arrayList = new ArrayList<>(count);
                        try {
                            int columnIndexOrThrow = queryLatestImageCursor.getColumnIndexOrThrow("_data");
                            List arrayList3 = new ArrayList();
                            if (i17 != 0) {
                                if (i17 != 1) {
                                    if (i17 == 2) {
                                        arrayList3 = RecentPhotoManger.getRecentPhotoBlackListPath(RecentPhotoManger.KEY_SHUOSHUO_RECENT_PHOTO_BLACKLIST);
                                    }
                                } else {
                                    arrayList3 = RecentPhotoManger.getRecentPhotoBlackListPath(RecentPhotoManger.KEY_PERSONAL_ALBUM_RECENT_PHOTO_BLACKLIST);
                                }
                            } else {
                                arrayList3 = RecentPhotoManger.getRecentPhotoBlackListPath(RecentPhotoManger.KEY_BANNER_RECENT_PHOTO_BLACKLIST);
                            }
                            int config = QzoneConfig.getInstance().getConfig("PhotoUpload", QzoneConfig.SECONDARY_PHOTOGUIDE_GUIDE_PHOTO_CHANGE_STRATEGY, 1);
                            while (true) {
                                if (!queryLatestImageCursor.moveToNext()) {
                                    break;
                                }
                                String string = queryLatestImageCursor.getString(columnIndexOrThrow);
                                if (string != null && !arrayList3.contains(string)) {
                                    File file = new File(string);
                                    if (file.exists() && !file.isDirectory() && (config != 0 || isExifValuable(getExif(string)))) {
                                        arrayList.add(string);
                                        if (arrayList.size() >= i16) {
                                            break;
                                        }
                                    }
                                }
                            }
                            arrayList2 = arrayList;
                        } catch (Exception e16) {
                            e = e16;
                            cursor = queryLatestImageCursor;
                            e.printStackTrace();
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Exception e17) {
                                    e17.printStackTrace();
                                }
                            }
                            return arrayList;
                        }
                    }
                    try {
                        queryLatestImageCursor.close();
                        return arrayList2;
                    } catch (Exception e18) {
                        e18.printStackTrace();
                        return arrayList2;
                    }
                } catch (Exception e19) {
                    e = e19;
                    arrayList = null;
                }
            } catch (Throwable th6) {
                th = th6;
                cursor = queryLatestImageCursor;
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception e26) {
                        e26.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e27) {
            e = e27;
            arrayList = null;
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x0037 -> B:14:0x004f). Please report as a decompilation issue!!! */
    public static boolean saveBitmapToFile(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat, int i3, boolean z16) {
        File file = new File(str);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e16) {
                QLog.e(TAG, 1, "create new bitmap file exception ", e16);
            }
        }
        boolean z17 = false;
        BufferedOutputStream bufferedOutputStream = null;
        try {
        } catch (IOException e17) {
            e17.printStackTrace();
        }
        try {
            try {
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
                try {
                    z17 = bitmap.compress(compressFormat, i3, bufferedOutputStream2);
                    bufferedOutputStream2.flush();
                    if (z16) {
                        bitmap.recycle();
                    }
                    bufferedOutputStream2.close();
                } catch (Exception e18) {
                    e = e18;
                    bufferedOutputStream = bufferedOutputStream2;
                    QLog.e(TAG, 1, "saveBitmapToFile exception", e);
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    return z17;
                } catch (Throwable th5) {
                    th = th5;
                    bufferedOutputStream = bufferedOutputStream2;
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e19) {
                            e19.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e26) {
                e = e26;
            }
            return z17;
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public boolean checkNewImages() {
        long max;
        if ((QzoneConfig.getInstance().getConfig("PhotoUpload", QzoneConfig.SECONDARY_PHOTOGUIDE_GUIDESHOWOPEN, 7) & 4) == 0) {
            if (QLog.isDevelopLevel()) {
                QLog.d(TAG, 4, "showGuide == CLOSE");
            }
            return false;
        }
        int config = QzoneConfig.getInstance().getConfig("PhotoUpload", QzoneConfig.SECONDARY_PHOTOGUIDE_EXPOSEPHOTOMINCOUNT, 10);
        long config2 = QzoneConfig.getInstance().getConfig("PhotoUpload", QzoneConfig.SECONDARY_PHOTOGUIDE_EXPOSEPHOTOTIMERANGE, 6) * 60 * 60 * 1000;
        long lastCheckTime = getLastCheckTime();
        long currentTimeMillis = System.currentTimeMillis();
        if (lastCheckTime == 0 || currentTimeMillis < lastCheckTime) {
            lastCheckTime = currentTimeMillis;
        }
        if (lastCheckTime == currentTimeMillis) {
            max = currentTimeMillis - config2;
        } else {
            max = Math.max(lastCheckTime, currentTimeMillis - config2);
        }
        long j3 = max;
        if (j3 != currentTimeMillis - config2) {
            if (QLog.isDevelopLevel()) {
                QLog.d(TAG, 4, config2 + "\u79d2\u4ee5\u5185");
            }
            return false;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "filterTime:" + j3);
            QLog.d(TAG, 4, "nowTime:" + currentTimeMillis);
        }
        ArrayList<String> queryLatestImages = queryLatestImages(BaseApplication.getContext(), 20480, j3, currentTimeMillis, config, 0);
        if (queryLatestImages != null && queryLatestImages.size() >= config) {
            LocalMultiProcConfig.putLong(QZoneHelper.QzoneSharePrefrenceConstants.KEY_PHOTO_GUIDE_FIRST_PHOTO, new File(queryLatestImages.get(queryLatestImages.size() - 1)).lastModified());
            return true;
        }
        if (queryLatestImages == null) {
            if (QLog.isDevelopLevel()) {
                QLog.d(TAG, 4, "no pics");
            }
        } else if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "pics count:" + queryLatestImages.size());
        }
        return false;
    }

    @TargetApi(11)
    public static Bitmap decodeBitmapFromFile(String str, int i3, int i16, boolean z16, Bitmap bitmap) {
        BufferedInputStream bufferedInputStream;
        BitmapFactory.Options options;
        int i17;
        Bitmap bitmap2 = null;
        if (str == null || "".equals(str) || str.length() <= 0 || TextUtils.isEmpty(str) || !new File(str).exists()) {
            return null;
        }
        try {
            options = new BitmapFactory.Options();
            try {
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(str, options);
                options.inJustDecodeBounds = false;
                if (i3 == 0 || i16 == 0) {
                    i17 = 1;
                } else if (z16) {
                    i17 = Math.max(options.outWidth / i3, options.outHeight / i16);
                } else {
                    i17 = Math.min(options.outWidth / i3, options.outHeight / i16);
                }
                options.inSampleSize = i17;
                options.inMutable = true;
                if (bitmap != null) {
                    options.inBitmap = bitmap;
                }
                bufferedInputStream = new BufferedInputStream(new FileInputStream(str), 4096);
                try {
                    Bitmap decodeStream = BitmapFactory.decodeStream(bufferedInputStream, null, options);
                    try {
                        bufferedInputStream.close();
                        return decodeStream;
                    } catch (IOException e16) {
                        e16.printStackTrace();
                        return decodeStream;
                    }
                } catch (Throwable unused) {
                    try {
                        System.gc();
                        try {
                            bitmap2 = BitmapFactory.decodeFile(str, options);
                        } catch (Throwable unused2) {
                            QLog.i(TAG, 1, "decodeBitmapFromFile happen exception");
                            System.gc();
                        }
                        return bitmap2;
                    } finally {
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e17) {
                                e17.printStackTrace();
                            }
                        }
                    }
                }
            } catch (Throwable unused3) {
                bufferedInputStream = null;
            }
        } catch (Throwable unused4) {
            bufferedInputStream = null;
            options = null;
        }
    }
}
