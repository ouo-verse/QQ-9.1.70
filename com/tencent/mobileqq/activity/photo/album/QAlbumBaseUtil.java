package com.tencent.mobileqq.activity.photo.album;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.core.internal.view.SupportMenu;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.activity.photo.MediaScannerInfo;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.r;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.weiyun.transmission.db.JobDbManager;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes10.dex */
public class QAlbumBaseUtil {
    static IPatchRedirector $redirector_ = null;
    public static int CONFIG_LIMIT_MAX_IMAGE_FILE_SIZE = 0;
    protected static final String IMAGE_ORDER_BY = "date_modified DESC, date_added DESC";
    private static final int MAX_PHOTO_HEIGHT_OF_CACHE = 65535;
    private static final int MAX_PHOTO_WIDTH_OF_CACHE = 65535;
    protected static final String TAG = "QQAlbum";
    public static final int TYPE_SLIDESHOW = 1;
    private static String[] VIDEO_COLUMNS;
    protected static String[] columns;
    private static final Map<String, Integer> pathWHMap;
    public static boolean sAlbumQueryFailReport;
    private static long sLastModify;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13182);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        sAlbumQueryFailReport = false;
        CONFIG_LIMIT_MAX_IMAGE_FILE_SIZE = 10485760;
        pathWHMap = new ConcurrentHashMap();
        VIDEO_COLUMNS = new String[]{"_id", "_data", "duration", "date_added", "date_modified", JobDbManager.COL_UP_MIME_TYPE, "_size", "width", "height"};
        columns = new String[]{"_id", "_data", JobDbManager.COL_UP_MIME_TYPE, "date_added", "date_modified", "orientation", "latitude", "longitude", "_size", "width", "height"};
    }

    public QAlbumBaseUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static int addPhotoInfo(Cursor cursor, List<LocalMediaInfo> list, int i3, boolean z16, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29, int i36, BitmapFactory.Options options, int[] iArr, int i37, String str, String str2) {
        long j3 = cursor.getLong(i18);
        long j16 = cursor.getLong(i19);
        if (sLastModify < j16) {
            sLastModify = j16;
        }
        boolean z17 = cursor.getInt(i29) == 0;
        long j17 = cursor.getLong(i16);
        if (i3 > 0 && z17) {
            getWHByPath(str, options, iArr);
            if (iArr[0] < i3 && iArr[1] < i3) {
                return i37;
            }
            LocalMediaInfo localMediaInfo = new LocalMediaInfo();
            localMediaInfo._id = j17;
            localMediaInfo.path = str;
            localMediaInfo.addedDate = j3;
            localMediaInfo.modifiedDate = j16;
            localMediaInfo.orientation = cursor.getInt(i17);
            localMediaInfo.mMimeType = str2;
            localMediaInfo.fileSize = cursor.getLong(i26);
            localMediaInfo.mediaWidth = iArr[0];
            localMediaInfo.mediaHeight = iArr[1];
            localMediaInfo.latitude = (int) (cursor.getDouble(i27) * 1000000.0d);
            localMediaInfo.longitude = (int) (cursor.getDouble(i28) * 1000000.0d);
            checkWidthAndHeight(str, localMediaInfo);
            list.add(localMediaInfo);
        } else {
            LocalMediaInfo localMediaInfo2 = new LocalMediaInfo();
            localMediaInfo2._id = j17;
            localMediaInfo2.path = str;
            localMediaInfo2.addedDate = cursor.getLong(i18);
            localMediaInfo2.modifiedDate = cursor.getLong(i19);
            localMediaInfo2.orientation = cursor.getInt(i17);
            localMediaInfo2.mMimeType = str2;
            localMediaInfo2.fileSize = cursor.getLong(i26);
            localMediaInfo2.latitude = (int) (cursor.getDouble(i27) * 1000000.0d);
            localMediaInfo2.longitude = (int) (cursor.getDouble(i28) * 1000000.0d);
            localMediaInfo2.mediaWidth = cursor.getInt(i29);
            int i38 = cursor.getInt(i36);
            localMediaInfo2.mediaHeight = i38;
            if (localMediaInfo2.mediaWidth <= 0 || i38 <= 0) {
                getWHByPath(str, options, iArr);
                localMediaInfo2.mediaWidth = iArr[0];
                localMediaInfo2.mediaHeight = iArr[1];
            }
            checkWidthAndHeight(str, localMediaInfo2);
            list.add(localMediaInfo2);
        }
        return i37 + 1;
    }

    private static void addVideoToMediaList(int i3, List<LocalMediaInfo> list, List<LocalMediaInfo> list2) {
        int size = list.size();
        int i16 = 0;
        int i17 = 0;
        while (i16 < list2.size()) {
            LocalMediaInfo localMediaInfo = list2.get(i16);
            if (localMediaInfo.modifiedDate <= list.get(size - 1).modifiedDate) {
                if (i3 == -1) {
                    while (i16 < list2.size()) {
                        list.add(list2.get(i16));
                        i16++;
                    }
                    return;
                } else {
                    int min = Math.min(list2.size() - i16, i3 - size);
                    for (int i18 = 0; i18 < min; i18++) {
                        list.add(list2.get(i18 + i16));
                    }
                    return;
                }
            }
            int i19 = i17;
            while (true) {
                if (i19 < size) {
                    if (localMediaInfo.modifiedDate <= list.get(i19).modifiedDate) {
                        i19++;
                    } else {
                        list.add(i19, localMediaInfo);
                        if (i3 != -1 && list.size() > i3) {
                            list.remove(size);
                        }
                        int size2 = list.size();
                        if (size != size2) {
                            size = size2;
                        }
                        i17 = i19 + 1;
                    }
                }
            }
            i16++;
        }
    }

    private static void checkWidthAndHeight(String str, LocalMediaInfo localMediaInfo) {
        if ((localMediaInfo.mediaWidth <= 0 || localMediaInfo.mediaHeight <= 0) && QLog.isColorLevel()) {
            QLog.i("QQAlbum", 2, "no size " + str);
        }
    }

    public static boolean fileExistsAndNotEmpty(String str) {
        if (str == null) {
            return false;
        }
        File file = new File(str);
        if (!file.exists() || file.length() <= 0) {
            return false;
        }
        return true;
    }

    public static String fixMimeType(String str, String str2) {
        if (str.indexOf(".jpg") == -1 && str.indexOf(".jpeg") == -1) {
            if (str.indexOf(QzoneEmotionUtils.SIGN_ICON_URL_END) != -1) {
                return "image/gif";
            }
            if (str.indexOf(".bmp") != -1) {
                return MimeHelper.IMAGE_BMP;
            }
            if (str.indexOf(".png") != -1) {
                return "image/png";
            }
            if (QLog.isColorLevel()) {
                QLog.i("QQAlbum", 2, "Filter mime type:" + str2 + ", path is " + str);
                return null;
            }
            return null;
        }
        return "image/jpeg";
    }

    public static List<LocalMediaInfo> getAlbumMedias(Context context, String str, String str2, int i3, MediaFileFilter mediaFileFilter, long j3) {
        return getAlbumMedias(context, str, str2, i3, mediaFileFilter, 0, -1, false, null, false, j3);
    }

    public static List<LocalMediaInfo> getAlbumPhotos(Context context, String str, String str2, int i3, MediaFileFilter mediaFileFilter, int i16, int i17, boolean z16, ArrayList<String> arrayList, boolean z17) {
        if (QLog.isColorLevel()) {
            QLog.d("QQAlbum", 2, "getAlbumPhotos");
        }
        if (str2 != null && !QAlbumCustomAlbumConstants.RECENT_ALBUM_ID.equals(str)) {
            List<LocalMediaInfo> queryImages = queryImages(context, "bucket_id='" + str + "'", i3, mediaFileFilter);
            if (queryImages != null && QLog.isColorLevel()) {
                QLog.d("QQAlbum", 2, "photo list size is:" + queryImages.size());
            }
            return queryImages;
        }
        return queryRecentImages(context, i17, i3, mediaFileFilter, z16, i16, arrayList, z17);
    }

    public static List<LocalMediaInfo> getAlbumVideos(Context context, String str, String str2, int i3, MediaFileFilter mediaFileFilter, long j3) {
        if (str2 != null && !QAlbumCustomAlbumConstants.RECENT_ALBUM_ID.equals(str)) {
            ArrayList arrayList = new ArrayList();
            Cursor cursor = null;
            try {
                try {
                    cursor = ContactsMonitor.query(context.getContentResolver(), MediaStore.Video.Media.EXTERNAL_CONTENT_URI, VIDEO_COLUMNS, "bucket_id='" + str + "'", null, "date_modified DESC, date_added DESC");
                    getVideoList(cursor, arrayList, i3, mediaFileFilter, true, j3);
                    if (cursor == null) {
                        return arrayList;
                    }
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("QQAlbum", 2, "query error", e16);
                    }
                    if (cursor == null) {
                        return arrayList;
                    }
                }
                cursor.close();
                return arrayList;
            } catch (Throwable th5) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th5;
            }
        }
        return queryRecentVideos(context, 210, i3, mediaFileFilter, j3);
    }

    private static void getImageList(Cursor cursor, List<LocalMediaInfo> list, int i3, int i16, boolean z16, MediaFileFilter mediaFileFilter) {
        getImageList(cursor, list, i3, i16, z16, mediaFileFilter, null, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x011a, code lost:
    
        if (r12 != null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0135, code lost:
    
        return r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0132, code lost:
    
        r12.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0130, code lost:
    
        if (r12 != null) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<LocalMediaInfo> getSlideShowAlbumPhotos(Context context, String str, String str2, int i3, MediaFileFilter mediaFileFilter, int i16, int i17, boolean z16, ArrayList<String> arrayList, boolean z17) {
        boolean z18;
        ArrayList arrayList2 = new ArrayList();
        StringBuilder sb5 = new StringBuilder();
        if (str2 != null && !QAlbumCustomAlbumConstants.RECENT_ALBUM_ID.equals(str)) {
            z18 = false;
        } else {
            z18 = true;
        }
        if (z18) {
            if (i3 <= 0) {
                throw new IllegalArgumentException("maxCount must be great than 0");
            }
        } else {
            sb5.append("bucket_id='" + str + "'");
            sb5.append(" and ");
        }
        Cursor cursor = null;
        try {
            try {
                if (z16) {
                    sb5.append("_size>?  and ( _size < " + CONFIG_LIMIT_MAX_IMAGE_FILE_SIZE + " )  and (width>=? or width IS NULL)  and (height>=? or height IS NULL )  and (height * 1.0 / width>= 0.45 ) and (height * 1.0 / width<= 2.2 )");
                } else {
                    sb5.append("_size>?  and ( _size < " + CONFIG_LIMIT_MAX_IMAGE_FILE_SIZE + " )  and (width>=? or width IS NULL or height>=? or height IS NULL ) ");
                }
                cursor = queryImages(context, sb5.toString(), new String[]{String.valueOf(i16), String.valueOf(i17), String.valueOf(i17)}, i3);
                getImageList(cursor, arrayList2, i17, i3, true, mediaFileFilter, arrayList, z17);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQAlbum", 2, e16.getMessage(), e16);
                }
            }
        } catch (Throwable th5) {
            if (cursor != null) {
                cursor.close();
            }
            throw th5;
        }
    }

    private static ArrayList<LocalMediaInfo> getSystemAndAppVideoList(Context context, Cursor cursor, List<LocalMediaInfo> list, int i3, MediaFileFilter mediaFileFilter, boolean z16, long j3) {
        ArrayList<MediaScannerInfo> mediaScannerInfos;
        ArrayList<LocalMediaInfo> arrayList = new ArrayList<>();
        ArrayList arrayList2 = (ArrayList) getVideoList(cursor, list, i3, mediaFileFilter, z16, j3);
        if (arrayList2 != null) {
            arrayList.addAll(arrayList2);
        }
        if (QLog.isColorLevel()) {
            QLog.e("QQAlbum", 2, "getSystemAndAppVideoList listsize=" + arrayList.size());
        }
        MediaScanner mediaScanner = MediaScanner.getInstance(BaseApplication.getContext());
        if (mediaScanner != null && (mediaScannerInfos = mediaScanner.getMediaScannerInfos(false, -1)) != null) {
            Iterator<MediaScannerInfo> it = mediaScannerInfos.iterator();
            while (it.hasNext()) {
                MediaScannerInfo next = it.next();
                LocalMediaInfo localMediaInfo = new LocalMediaInfo();
                localMediaInfo._id = next.f183982id;
                localMediaInfo.mDuration = next.duration;
                localMediaInfo.fileSize = next.fileSize;
                localMediaInfo.path = next.path;
                localMediaInfo.modifiedDate = next.modifiedDate;
                localMediaInfo.mMimeType = next.mimeType;
                localMediaInfo.isSystemMeidaStore = false;
                arrayList.add(localMediaInfo);
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    @TargetApi(10)
    private static List<LocalMediaInfo> getVideoList(Cursor cursor, List<LocalMediaInfo> list, int i3, MediaFileFilter mediaFileFilter, boolean z16, long j3) {
        List<LocalMediaInfo> list2;
        int i16;
        int i17;
        int count = cursor.getCount();
        if (QLog.isColorLevel()) {
            QLog.i("QQAlbum", 2, "getVideoList videoCursor count:" + count);
        }
        if (count <= 0) {
            return null;
        }
        if (list == null) {
            list2 = new ArrayList();
        } else {
            list2 = list;
        }
        int columnIndexOrThrow = cursor.getColumnIndexOrThrow("_id");
        int columnIndexOrThrow2 = cursor.getColumnIndexOrThrow("_data");
        int columnIndexOrThrow3 = cursor.getColumnIndexOrThrow("date_added");
        int columnIndexOrThrow4 = cursor.getColumnIndexOrThrow("date_modified");
        int columnIndexOrThrow5 = cursor.getColumnIndexOrThrow("duration");
        int columnIndexOrThrow6 = cursor.getColumnIndexOrThrow(JobDbManager.COL_UP_MIME_TYPE);
        int columnIndexOrThrow7 = cursor.getColumnIndexOrThrow("_size");
        if (z16) {
            i16 = cursor.getColumnIndexOrThrow("width");
            i17 = cursor.getColumnIndexOrThrow("height");
        } else {
            i16 = 0;
            i17 = 0;
        }
        qureyVideoList(cursor, list2, i3, mediaFileFilter, z16, j3, columnIndexOrThrow, columnIndexOrThrow2, columnIndexOrThrow3, columnIndexOrThrow4, columnIndexOrThrow5, columnIndexOrThrow6, columnIndexOrThrow7, i16, i17);
        return list2;
    }

    public static void getWHByPath(String str, BitmapFactory.Options options, int[] iArr) {
        int i3;
        int i16;
        if (TextUtils.isEmpty(str)) {
            QLog.i("QQAlbum", 1, "imagePath is empty, return");
            return;
        }
        Map<String, Integer> map = pathWHMap;
        Integer num = map.get(str);
        if (num == null) {
            try {
                SafeBitmapFactory.decodeFile(str, options);
                i16 = options.outWidth;
                try {
                    i3 = options.outHeight;
                    if (i16 <= 65535 && i3 <= 65535) {
                        try {
                            map.put(str, Integer.valueOf((65535 & i3) | ((i16 << 16) & SupportMenu.CATEGORY_MASK)));
                        } catch (OutOfMemoryError e16) {
                            e = e16;
                            QLog.e("QQAlbum", 1, "getWHByPath error. ", e);
                            iArr[0] = i16;
                            iArr[1] = i3;
                        }
                    }
                } catch (OutOfMemoryError e17) {
                    e = e17;
                    i3 = 0;
                }
            } catch (OutOfMemoryError e18) {
                e = e18;
                i3 = 0;
                i16 = 0;
            }
        } else {
            int intValue = (num.intValue() >> 16) & 65535;
            i3 = num.intValue() & 65535;
            i16 = intValue;
        }
        iArr[0] = i16;
        iArr[1] = i3;
    }

    private static boolean ignorePath(ArrayList<String> arrayList, String str) {
        boolean z16;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<String> it = arrayList.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (str.contains(it.next())) {
                        z16 = true;
                        break;
                    }
                } else {
                    z16 = false;
                    break;
                }
            }
            if (z16) {
                return true;
            }
        }
        return false;
    }

    private static List<LocalMediaInfo> limitPhotosAndVideos(int i3, List<LocalMediaInfo> list, List<LocalMediaInfo> list2) {
        Object obj;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("getAlbumMedias,mediaList size:");
            Object obj2 = "null";
            if (list == null) {
                obj = "null";
            } else {
                obj = Integer.valueOf(list.size());
            }
            sb5.append(obj);
            sb5.append(" videoList size:");
            if (list2 != null) {
                obj2 = Integer.valueOf(list2.size());
            }
            sb5.append(obj2);
            QLog.d("QQAlbum", 2, sb5.toString());
        }
        if (list2 != null && !list2.isEmpty()) {
            if (list != null && !list.isEmpty()) {
                addVideoToMediaList(i3, list, list2);
                return list;
            }
            return list2;
        }
        return list;
    }

    private static void queryImageList(Cursor cursor, List<LocalMediaInfo> list, int i3, int i16, boolean z16, MediaFileFilter mediaFileFilter, ArrayList<String> arrayList, int i17, int i18, int i19, int i26, int i27, int i28, int i29, int i36, int i37, int i38, int i39, BitmapFactory.Options options, int[] iArr, int i46) {
        Cursor cursor2 = cursor;
        MediaFileFilter mediaFileFilter2 = mediaFileFilter;
        int i47 = i46;
        int i48 = 0;
        int i49 = 0;
        while (true) {
            if (!cursor.moveToNext()) {
                break;
            }
            String string = cursor2.getString(i18);
            if (!fileExistsAndNotEmpty(string)) {
                if (string == null) {
                    i48++;
                } else {
                    i49++;
                }
                if (QLog.isColorLevel()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("getImageList file not exists:");
                    if (string == null) {
                        string = "null";
                    }
                    sb5.append(string);
                    QLog.i("QQAlbum", 2, sb5.toString());
                }
            } else if (!ignorePath(arrayList, string)) {
                String string2 = cursor2.getString(i28);
                if (mediaFileFilter2 != null && mediaFileFilter2.filter(string2)) {
                    if (!"*/*".equals(string2) && !"image/*".equals(string2)) {
                        if (QLog.isColorLevel()) {
                            QLog.i("QQAlbum", 2, "Filter unknown " + string2 + ", path is " + string);
                        }
                    } else {
                        string2 = fixMimeType(string, string2);
                        if (string2 == null) {
                            continue;
                        }
                    }
                }
                int i56 = i48;
                int i57 = i49;
                int addPhotoInfo = addPhotoInfo(cursor, list, i3, z16, i17, i19, i26, i27, i29, i36, i37, i38, i39, options, iArr, i47, string, string2);
                if (i16 > 0 && addPhotoInfo >= i16) {
                    i48 = i56;
                    i49 = i57;
                    break;
                } else {
                    cursor2 = cursor;
                    mediaFileFilter2 = mediaFileFilter;
                    i47 = addPhotoInfo;
                    i48 = i56;
                    i49 = i57;
                }
            }
        }
        reportFail(i48, i49);
    }

    private static Cursor queryImages(Context context, String str, String[] strArr, int i3) {
        Uri uri;
        if (i3 > 0) {
            Uri.Builder buildUpon = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.buildUpon();
            buildUpon.appendQueryParameter("limit", String.valueOf(i3));
            uri = buildUpon.build();
        } else {
            uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        }
        return ContactsMonitor.query(context.getContentResolver(), uri, columns, str, strArr, "date_modified DESC, date_added DESC");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void queryOnHighVer(Cursor cursor, int i3, int i16, String str, LocalMediaInfo localMediaInfo) {
        MediaMetadataRetriever mediaMetadataRetriever;
        Throwable th5;
        Exception e16;
        localMediaInfo.mediaWidth = cursor.getInt(i3);
        localMediaInfo.mediaHeight = cursor.getInt(i16);
        if (localMediaInfo.mDuration == 0) {
            try {
                mediaMetadataRetriever = new MediaMetadataRetriever();
            } catch (Exception e17) {
                mediaMetadataRetriever = null;
                e16 = e17;
            } catch (Throwable th6) {
                mediaMetadataRetriever = null;
                th5 = th6;
                if (mediaMetadataRetriever != null) {
                }
                throw th5;
            }
            try {
                try {
                    mediaMetadataRetriever.setDataSource(str);
                    localMediaInfo.mDuration = Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
                } catch (Throwable th7) {
                    th5 = th7;
                    if (mediaMetadataRetriever != null) {
                        mediaMetadataRetriever.release();
                    }
                    throw th5;
                }
            } catch (Exception e18) {
                e16 = e18;
                e16.printStackTrace();
                if (QLog.isColorLevel()) {
                    QLog.i("QQAlbum", 2, "get timeString failed");
                }
                if (mediaMetadataRetriever == null) {
                    return;
                }
                mediaMetadataRetriever.release();
            }
            mediaMetadataRetriever.release();
        }
    }

    private static void queryOnLowVer(String str, LocalMediaInfo localMediaInfo) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(str);
        String extractMetadata = mediaMetadataRetriever.extractMetadata(18);
        String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
        mediaMetadataRetriever.release();
        try {
            localMediaInfo.mediaWidth = Integer.parseInt(extractMetadata);
            localMediaInfo.mediaHeight = Integer.parseInt(extractMetadata2);
        } catch (NumberFormatException unused) {
            localMediaInfo.mediaWidth = 0;
            localMediaInfo.mediaHeight = 0;
            if (QLog.isColorLevel()) {
                QLog.i("QQAlbum", 2, "Video size is not number format...");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<LocalMediaInfo> queryRecentImages(Context context, int i3, int i16, MediaFileFilter mediaFileFilter, boolean z16, int i17, ArrayList<String> arrayList, boolean z17) {
        String str;
        long uptimeMillis = SystemClock.uptimeMillis();
        if (QLog.isColorLevel()) {
            QLog.d("QQAlbum", 2, "queryRecentImages startTime=" + uptimeMillis);
        }
        ArrayList arrayList2 = new ArrayList();
        Cursor cursor = null;
        if (z16) {
            str = "_size>? and (width>=? or width IS NULL) and (height>=? or height IS NULL )) GROUP BY (_data";
        } else {
            str = "_size>? and (width>=? or width IS NULL or height>=? or height IS NULL )) GROUP BY (_data";
        }
        try {
            try {
                Cursor queryImages = queryImages(context, str, new String[]{String.valueOf(i17), String.valueOf(i3), String.valueOf(i3)}, i16);
                try {
                    getImageList(queryImages, arrayList2, i3, i16, true, mediaFileFilter, arrayList, z17);
                    if (queryImages != null) {
                        queryImages.close();
                    }
                } catch (Exception e16) {
                    e = e16;
                    cursor = queryImages;
                    if (QLog.isColorLevel()) {
                        QLog.d("QQAlbum", 2, e.getMessage(), e);
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (QLog.isColorLevel()) {
                    }
                    return arrayList2;
                } catch (Throwable th5) {
                    th = th5;
                    cursor = queryImages;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception e17) {
            e = e17;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQAlbum", 2, "queryRecentImages cost: " + (SystemClock.uptimeMillis() - uptimeMillis) + "  imageList size:" + Integer.valueOf(arrayList2.size()));
        }
        return arrayList2;
    }

    public static List<LocalMediaInfo> queryRecentVideos(Context context, int i3, int i16, MediaFileFilter mediaFileFilter, long j3) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (QLog.isColorLevel()) {
            QLog.d("QQAlbum", 2, "queryRecentVideos startTime=" + uptimeMillis);
        }
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                Uri.Builder buildUpon = MediaStore.Video.Media.EXTERNAL_CONTENT_URI.buildUpon();
                if (i16 > 0) {
                    buildUpon.appendQueryParameter("limit", String.valueOf(i16 * 6));
                }
                Cursor query = ContactsMonitor.query(context.getContentResolver(), buildUpon.build(), VIDEO_COLUMNS, "_size>10000 ) GROUP BY (_data", null, "date_modified DESC, date_added DESC");
                try {
                    getVideoList(query, arrayList, i16, mediaFileFilter, true, j3);
                    if (query != null) {
                        query.close();
                    }
                } catch (Exception e16) {
                    e = e16;
                    cursor = query;
                    if (QLog.isColorLevel()) {
                        QLog.d("QQAlbum", 2, e.getMessage(), e);
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    queryThirdPartyVideo(mediaFileFilter, arrayList);
                    return sortAndLimitVideoList(i16, uptimeMillis, arrayList);
                } catch (Throwable th5) {
                    th = th5;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception e17) {
            e = e17;
        }
        queryThirdPartyVideo(mediaFileFilter, arrayList);
        return sortAndLimitVideoList(i16, uptimeMillis, arrayList);
    }

    private static void queryThirdPartyVideo(MediaFileFilter mediaFileFilter, List<LocalMediaInfo> list) {
        ArrayList<MediaScannerInfo> mediaScannerInfos;
        MediaScanner mediaScanner = MediaScanner.getInstance(BaseApplication.getContext());
        if (mediaScanner != null && (mediaScannerInfos = mediaScanner.getMediaScannerInfos(true, 100)) != null) {
            Iterator<MediaScannerInfo> it = mediaScannerInfos.iterator();
            while (it.hasNext()) {
                MediaScannerInfo next = it.next();
                LocalMediaInfo localMediaInfo = new LocalMediaInfo();
                localMediaInfo._id = next.f183982id;
                localMediaInfo.mDuration = next.duration;
                localMediaInfo.fileSize = next.fileSize;
                localMediaInfo.path = next.path;
                localMediaInfo.modifiedDate = next.modifiedDate;
                String str = next.mimeType;
                localMediaInfo.mMimeType = str;
                localMediaInfo.isSystemMeidaStore = false;
                if (mediaFileFilter == null || !mediaFileFilter.filter(str)) {
                    list.add(localMediaInfo);
                }
            }
        }
    }

    private static void qureyVideoList(Cursor cursor, List<LocalMediaInfo> list, int i3, MediaFileFilter mediaFileFilter, boolean z16, long j3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29, int i36) {
        String str;
        MediaFileFilter mediaFileFilter2 = mediaFileFilter;
        int i37 = 0;
        StringBuilder sb5 = null;
        while (true) {
            str = "QQAlbum";
            if (!cursor.moveToNext()) {
                break;
            }
            String string = cursor.getString(i17);
            if (!TextUtils.isEmpty(string) && new File(string).exists()) {
                String string2 = cursor.getString(i27);
                if (mediaFileFilter2 != null && mediaFileFilter2.filter(string2)) {
                    if (QLog.isColorLevel()) {
                        if (sb5 == null) {
                            sb5 = new StringBuilder();
                        }
                        sb5.append("Filter mime type:");
                        sb5.append(string2);
                        sb5.append(", path is ");
                        sb5.append(string);
                        sb5.append("\n");
                    }
                } else {
                    long j16 = cursor.getLong(i18);
                    long j17 = cursor.getLong(i19);
                    LocalMediaInfo localMediaInfo = new LocalMediaInfo();
                    localMediaInfo._id = cursor.getLong(i16);
                    localMediaInfo.path = string;
                    localMediaInfo.mMimeType = string2;
                    localMediaInfo.addedDate = j16;
                    localMediaInfo.modifiedDate = j17;
                    localMediaInfo.mDuration = cursor.getLong(i26);
                    localMediaInfo.fileSize = cursor.getLong(i28);
                    queryOnHighVer(cursor, i29, i36, string, localMediaInfo);
                    if (j3 <= 0 || localMediaInfo.mDuration <= j3) {
                        list.add(localMediaInfo);
                        i37++;
                        if (sLastModify < j17) {
                            sLastModify = j17;
                        }
                        if (i3 > 0 && i37 >= i3) {
                            str = "QQAlbum";
                            break;
                        }
                    }
                }
            } else if (QLog.isColorLevel()) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append("getVideoList file not exists:");
                if (string == null) {
                    string = "null";
                }
                sb6.append(string);
                QLog.i("QQAlbum", 2, sb6.toString());
            }
            mediaFileFilter2 = mediaFileFilter;
        }
        if (sb5 == null || !QLog.isColorLevel()) {
            return;
        }
        QLog.d(str, 2, sb5.toString());
    }

    private static void reportFail(int i3, int i16) {
        if (!sAlbumQueryFailReport) {
            if (i3 > 0 || i16 > 0) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("imagePathNullCount:");
                stringBuffer.append(i3);
                stringBuffer.append(" imagePathFileNotExistCount:");
                stringBuffer.append(i16);
                String stringBuffer2 = stringBuffer.toString();
                if (i3 > 0) {
                    r.a("Album_Query_File_Path_Null", stringBuffer2);
                }
                if (i16 > 0) {
                    r.a("Album_Query_File_Not_Exist", stringBuffer2);
                }
            }
            sAlbumQueryFailReport = true;
        }
    }

    private static List<LocalMediaInfo> sortAndLimitVideoList(int i3, long j3, List<LocalMediaInfo> list) {
        int size;
        Collections.sort(list);
        ArrayList arrayList = new ArrayList();
        if (i3 > 0) {
            size = Math.min(i3, list.size());
        } else {
            size = list.size();
        }
        for (int i16 = 0; i16 < size; i16++) {
            arrayList.add(list.get(i16));
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQAlbum", 2, "queryRecentVideos cost: " + (SystemClock.uptimeMillis() - j3) + " resultVideoList size:" + Integer.valueOf(arrayList.size()));
        }
        return arrayList;
    }

    private static void sortMedias(String str, List<LocalMediaInfo> list, List<LocalMediaInfo> list2) {
        if (QAlbumCustomAlbumConstants.RECENT_ALBUM_ID.equals(str)) {
            long uptimeMillis = SystemClock.uptimeMillis();
            if (list != null) {
                Collections.sort(list);
            }
            if (list2 != null) {
                Collections.sort(list2);
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQAlbum", 2, "getAlbumMedias-sort recent cost: " + (SystemClock.uptimeMillis() - uptimeMillis));
            }
        }
    }

    public static List<LocalMediaInfo> getAlbumMedias(Context context, String str, String str2, int i3, MediaFileFilter mediaFileFilter, int i16, int i17, boolean z16, ArrayList<String> arrayList, boolean z17, long j3) {
        return getAlbumMedias(context, str, str2, i3, mediaFileFilter, i16, i17, z16, arrayList, z17, j3, -1);
    }

    protected static void getImageList(Cursor cursor, List<LocalMediaInfo> list, int i3, int i16, boolean z16, MediaFileFilter mediaFileFilter, ArrayList<String> arrayList, boolean z17) {
        int i17;
        int i18;
        if (cursor.getCount() > 0) {
            List<LocalMediaInfo> arrayList2 = list == null ? new ArrayList<>() : list;
            int columnIndexOrThrow = cursor.getColumnIndexOrThrow("_id");
            int columnIndexOrThrow2 = cursor.getColumnIndexOrThrow("_data");
            int columnIndexOrThrow3 = cursor.getColumnIndexOrThrow("orientation");
            int columnIndexOrThrow4 = cursor.getColumnIndexOrThrow("date_added");
            int columnIndexOrThrow5 = cursor.getColumnIndexOrThrow("date_modified");
            int columnIndexOrThrow6 = cursor.getColumnIndexOrThrow(JobDbManager.COL_UP_MIME_TYPE);
            int columnIndexOrThrow7 = cursor.getColumnIndexOrThrow("_size");
            int columnIndexOrThrow8 = cursor.getColumnIndexOrThrow("latitude");
            int columnIndexOrThrow9 = cursor.getColumnIndexOrThrow("longitude");
            if (z16) {
                i17 = cursor.getColumnIndexOrThrow("width");
                i18 = cursor.getColumnIndexOrThrow("height");
            } else {
                i17 = 0;
                i18 = 0;
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            int[] iArr = new int[2];
            if (QLog.isColorLevel()) {
                QLog.i("QQAlbum", 2, "getImageList imageCursor count:" + cursor.getCount());
            }
            queryImageList(cursor, arrayList2, i3, i16, z16, mediaFileFilter, arrayList, columnIndexOrThrow, columnIndexOrThrow2, columnIndexOrThrow3, columnIndexOrThrow4, columnIndexOrThrow5, columnIndexOrThrow6, columnIndexOrThrow7, columnIndexOrThrow8, columnIndexOrThrow9, i17, i18, options, iArr, 0);
        }
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x005b: MOVE (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:45:0x005b */
    public static List<LocalMediaInfo> getAlbumMedias(Context context, String str, String str2, int i3, MediaFileFilter mediaFileFilter, int i16, int i17, boolean z16, ArrayList<String> arrayList, boolean z17, long j3, int i18) {
        Cursor cursor;
        Cursor cursor2;
        List<LocalMediaInfo> list;
        if (QLog.isColorLevel()) {
            QLog.d("QQAlbum", 2, "getAlbumMedias");
        }
        Cursor cursor3 = null;
        r3 = null;
        List<LocalMediaInfo> list2 = null;
        try {
            if (QAlbumCustomAlbumConstants.VIDEO_ALBUM_ID.equals(str)) {
                try {
                    cursor2 = ContactsMonitor.query(context.getContentResolver(), MediaStore.Video.Media.EXTERNAL_CONTENT_URI, VIDEO_COLUMNS, null, null, "date_modified DESC, date_added DESC");
                } catch (Exception e16) {
                    e = e16;
                    cursor2 = null;
                } catch (Throwable th5) {
                    th = th5;
                    if (cursor3 != null) {
                        cursor3.close();
                    }
                    throw th;
                }
                try {
                    ArrayList<LocalMediaInfo> systemAndAppVideoList = getSystemAndAppVideoList(context, cursor2, null, i3, mediaFileFilter, true, j3);
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    return systemAndAppVideoList;
                } catch (Exception e17) {
                    e = e17;
                    if (QLog.isColorLevel()) {
                        QLog.e("QQAlbum", 2, "query error", e);
                    }
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    if (mediaFileFilter != null) {
                    }
                    list = null;
                    if (mediaFileFilter != null) {
                        list2 = getAlbumVideos(context, str, str2, i3, mediaFileFilter, j3);
                    }
                    sortMedias(str, list, list2);
                    return limitPhotosAndVideos(i3, list, list2);
                }
            }
            if (mediaFileFilter != null || !mediaFileFilter.showImage()) {
                list = null;
            } else if (i18 == 1) {
                list = getSlideShowAlbumPhotos(context, str, str2, i3, mediaFileFilter, i16, i17, z16, arrayList, z17);
            } else {
                list = getAlbumPhotos(context, str, str2, i3, mediaFileFilter, i16, i17, z16, arrayList, z17);
            }
            if (mediaFileFilter != null && mediaFileFilter.showVideo()) {
                list2 = getAlbumVideos(context, str, str2, i3, mediaFileFilter, j3);
            }
            sortMedias(str, list, list2);
            return limitPhotosAndVideos(i3, list, list2);
        } catch (Throwable th6) {
            th = th6;
            cursor3 = cursor;
        }
    }

    private static List<LocalMediaInfo> queryImages(Context context, String str, int i3, MediaFileFilter mediaFileFilter) {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                Cursor queryImages = queryImages(context, str, (String[]) null, i3);
                try {
                    getImageList(queryImages, arrayList, -1, i3, true, mediaFileFilter);
                    if (queryImages != null) {
                        queryImages.close();
                    }
                } catch (Exception e16) {
                    e = e16;
                    cursor = queryImages;
                    if (QLog.isColorLevel()) {
                        QLog.d("QQAlbum", 2, e.getMessage(), e);
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    return arrayList;
                } catch (Throwable th5) {
                    th = th5;
                    cursor = queryImages;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception e17) {
            e = e17;
        }
        return arrayList;
    }
}
