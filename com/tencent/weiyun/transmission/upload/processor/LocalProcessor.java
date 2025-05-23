package com.tencent.weiyun.transmission.upload.processor;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.media.ExifInterface;
import android.media.MediaMetadataRetriever;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.weiyun.transmission.db.JobDbManager;
import com.tencent.weiyun.transmission.upload.UploadFile;
import com.tencent.weiyun.transmission.upload.UploadHelper;
import com.tencent.weiyun.transmission.upload.UploadJobContext;
import com.tencent.weiyun.transmission.utils.TsLog;
import com.tencent.weiyun.transmission.utils.handler.ReleaseLooperHandler;
import com.tencent.weiyun.utils.IOUtils;
import java.io.File;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/* loaded from: classes27.dex */
public class LocalProcessor implements Handler.Callback {
    static IPatchRedirector $redirector_ = null;
    private static final int MSG_PROCESS = 11;
    private static final String TAG = "UploadLocalProcessor";
    private static final long TAKEN_TIME_DIFF_60S = 60000;
    private static SimpleDateFormat sFormatter;
    private final LocalProcessorCallback mCallback;
    private final Context mContext;
    private final ReleaseLooperHandler mHandler;

    /* loaded from: classes27.dex */
    public interface LocalProcessorCallback {
        void onLocalResult(long j3, boolean z16, boolean z17);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13096);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            sFormatter = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        }
    }

    public LocalProcessor(Context context, LocalProcessorCallback localProcessorCallback, ReleaseLooperHandler releaseLooperHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, localProcessorCallback, releaseLooperHandler);
            return;
        }
        this.mContext = context;
        this.mCallback = localProcessorCallback;
        this.mHandler = releaseLooperHandler;
        releaseLooperHandler.addCallback(this);
    }

    private double convert2Degree(String str) {
        String[] split = str.split(",", 3);
        String[] split2 = split[0].split("/", 2);
        String[] split3 = split[1].split("/", 2);
        String[] split4 = split[2].split("/", 2);
        return (parseDoubleSafely(split2[0]) / parseDoubleSafely(split2[1])) + ((parseDoubleSafely(split3[0]) / parseDoubleSafely(split3[1])) / 60.0d) + ((parseDoubleSafely(split4[0]) / parseDoubleSafely(split4[1])) / 3600.0d);
    }

    private double parseDoubleSafely(String str) {
        try {
            return Double.parseDouble(str);
        } catch (Throwable unused) {
            return 0.0d;
        }
    }

    private String[] parseExif(String str) {
        String str2;
        String str3;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            ExifInterface exifInterface = new ExifInterface(str);
            String attribute = exifInterface.getAttribute("GPSLongitude");
            String attribute2 = exifInterface.getAttribute("GPSLatitude");
            String attribute3 = exifInterface.getAttribute("GPSLongitudeRef");
            String attribute4 = exifInterface.getAttribute("GPSLatitudeRef");
            if (!TextUtils.isEmpty(attribute)) {
                double convert2Degree = convert2Degree(attribute);
                if (!TextUtils.equals(attribute3, "E")) {
                    convert2Degree = 0.0d - convert2Degree;
                }
                str2 = Double.toString(convert2Degree);
            } else {
                str2 = null;
            }
            if (!TextUtils.isEmpty(attribute2)) {
                double convert2Degree2 = convert2Degree(attribute2);
                if (!TextUtils.equals(attribute4, "N")) {
                    convert2Degree2 = 0.0d - convert2Degree2;
                }
                str3 = Double.toString(convert2Degree2);
            } else {
                str3 = null;
            }
            String[] strArr = {str2, str3, exifInterface.getAttribute("DateTime"), exifInterface.getAttribute("ImageWidth"), exifInterface.getAttribute("ImageLength")};
            TsLog.d(TAG, str + " parseExif success:" + Arrays.toString(strArr));
            return strArr;
        } catch (Throwable th5) {
            TsLog.e(TAG, str + " parseExif failed.", th5);
            return null;
        }
    }

    private int parseIntSafely(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Throwable unused) {
            return 0;
        }
    }

    private long parseLongSafely(String str) {
        try {
            return Long.parseLong(str);
        } catch (Throwable unused) {
            return 0L;
        }
    }

    @TargetApi(14)
    private int[] parseVideoSizes(String str) {
        int parseIntSafely;
        int parseIntSafely2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(str);
            String extractMetadata = mediaMetadataRetriever.extractMetadata(18);
            String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
            if (TextUtils.isEmpty(extractMetadata)) {
                parseIntSafely = 0;
            } else {
                parseIntSafely = parseIntSafely(extractMetadata);
            }
            if (TextUtils.isEmpty(extractMetadata2)) {
                parseIntSafely2 = 0;
            } else {
                parseIntSafely2 = parseIntSafely(extractMetadata2);
            }
            return new int[]{parseIntSafely, parseIntSafely2};
        } catch (Throwable th5) {
            try {
                TsLog.e(TAG, "parseVideoSizes failed.", th5);
                return null;
            } finally {
                mediaMetadataRetriever.release();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:136:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x03d2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x03d3  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d5 A[Catch: all -> 0x00df, TRY_LEAVE, TryCatch #2 {all -> 0x00df, blocks: (B:202:0x00a7, B:69:0x00d5, B:62:0x00b0, B:64:0x00cb), top: B:201:0x00a7 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0176  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void processLocalEnsure(UploadJobContext uploadJobContext) {
        boolean z16;
        Cursor cursor;
        String str;
        String lowerCase;
        String[] queryAudioInfo;
        int[] parseVideoSizes;
        int i3;
        boolean z17;
        long j3;
        int i16;
        String[] parseExif;
        Date parse;
        boolean z18;
        String[] strArr;
        String str2;
        if (uploadJobContext == null || uploadJobContext.isCanceled()) {
            return;
        }
        File file = new File(uploadJobContext.file().localPath);
        boolean exists = file.exists();
        boolean z19 = !file.isDirectory();
        if (exists && z19) {
            UploadFile file2 = uploadJobContext.file();
            String str3 = null;
            if (!TextUtils.isEmpty(file2.compressedPath)) {
                File file3 = new File(file2.compressedPath);
                z16 = file3.exists();
                if (!z16) {
                    file2.compressedPath = null;
                    file2.compressedSha = null;
                    file2.compressedSliceSha = null;
                    file2.compressedSize = 0L;
                } else {
                    file2.compressedSize = file3.length();
                }
            } else {
                z16 = false;
            }
            long lastModified = file.lastModified();
            long length = file.length();
            if (file2.lastModified == lastModified && file2.fileSize == length && file2.sha != null) {
                z17 = false;
            } else {
                file2.lastModified = file.lastModified();
                file2.fileName = file.getName();
                ContentResolver contentResolver = this.mContext.getContentResolver();
                String[] strArr2 = {JobDbManager.COL_UP_MIME_TYPE};
                String[] strArr3 = {file2.localPath};
                try {
                    cursor = ContactsMonitor.query(contentResolver, MediaStore.Files.getContentUri("external"), strArr2, "_data=? ", strArr3, null);
                } catch (Throwable th5) {
                    th = th5;
                    cursor = null;
                }
                if (cursor != null) {
                    try {
                        if (!cursor.moveToNext()) {
                        }
                        z18 = true;
                        if (z18) {
                            str = cursor.getString(0);
                        } else {
                            str = null;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        try {
                            TsLog.e(TAG, th);
                            IOUtils.closeSilently(cursor);
                            str = null;
                            if (str != null) {
                            }
                            file2.mimeType = lowerCase;
                            if (!lowerCase.startsWith("image")) {
                            }
                            z17 = true;
                            if (z16) {
                            }
                            if (!z17) {
                            }
                            uploadJobContext.statisticsTimes().onCalShaStart();
                            String[] calSliceSha1 = UploadHelper.calSliceSha1(file.getAbsolutePath(), uploadJobContext.getCanceledFlag());
                            uploadJobContext.statisticsTimes().onCalShaEnd();
                            if (!uploadJobContext.isCanceled()) {
                            }
                        } finally {
                            IOUtils.closeSilently(cursor);
                        }
                    }
                    if (str != null) {
                        lowerCase = "";
                    } else {
                        lowerCase = str.toLowerCase();
                    }
                    file2.mimeType = lowerCase;
                    if (!lowerCase.startsWith("image")) {
                        String[] queryImageInfo = queryImageInfo(contentResolver, file2.localPath);
                        if (queryImageInfo != null) {
                            if (!TextUtils.isEmpty(queryImageInfo[0])) {
                                file2.longitude = parseDoubleSafely(queryImageInfo[0]);
                            }
                            if (!TextUtils.isEmpty(queryImageInfo[1])) {
                                file2.latitude = parseDoubleSafely(queryImageInfo[1]);
                            }
                            if (!TextUtils.isEmpty(queryImageInfo[2])) {
                                if (TextUtils.isDigitsOnly(queryImageInfo[2])) {
                                    j3 = parseLongSafely(queryImageInfo[2]);
                                } else {
                                    Date parse2 = sFormatter.parse(queryImageInfo[2], new ParsePosition(0));
                                    if (parse2 != null) {
                                        j3 = parse2.getTime();
                                    }
                                }
                                if (!TextUtils.isEmpty(queryImageInfo[4])) {
                                    file2.width = parseIntSafely(queryImageInfo[4]);
                                }
                                if (!TextUtils.isEmpty(queryImageInfo[5])) {
                                    file2.height = parseIntSafely(queryImageInfo[5]);
                                }
                            }
                            j3 = 0;
                            if (!TextUtils.isEmpty(queryImageInfo[4])) {
                            }
                            if (!TextUtils.isEmpty(queryImageInfo[5])) {
                            }
                        } else {
                            j3 = 0;
                        }
                        if (lowerCase.endsWith(MimeHelper.IMAGE_SUBTYPE_JPEG) && (parseExif = parseExif(file2.localPath)) != null) {
                            if (!TextUtils.isEmpty(parseExif[0])) {
                                file2.longitude = parseDoubleSafely(parseExif[0]);
                            }
                            if (!TextUtils.isEmpty(parseExif[1])) {
                                file2.latitude = parseDoubleSafely(parseExif[1]);
                            }
                            if (!TextUtils.isEmpty(parseExif[2]) && (parse = sFormatter.parse(parseExif[2], new ParsePosition(0))) != null) {
                                long time = parse.getTime();
                                if (Math.abs(time - j3) > 60000) {
                                    j3 = time;
                                }
                            }
                            if (!TextUtils.isEmpty(parseExif[3])) {
                                file2.width = parseIntSafely(parseExif[3]);
                            }
                            if (!TextUtils.isEmpty(parseExif[4])) {
                                file2.height = parseIntSafely(parseExif[4]);
                            }
                        }
                        if (j3 <= 0 && queryImageInfo != null && !TextUtils.isEmpty(queryImageInfo[3])) {
                            String trim = queryImageInfo[3].trim();
                            long parseLongSafely = parseLongSafely(trim);
                            if (trim.length() > 8 && trim.length() <= 10) {
                                i16 = 1000;
                            } else {
                                i16 = 1;
                            }
                            j3 = i16 * parseLongSafely;
                        }
                        file2.takenTime = j3;
                    } else if (lowerCase.startsWith("video")) {
                        String[] queryVideoInfo = queryVideoInfo(contentResolver, file2.localPath);
                        if (queryVideoInfo != null) {
                            if (!TextUtils.isEmpty(queryVideoInfo[0])) {
                                file2.longitude = parseDoubleSafely(queryVideoInfo[0]);
                            }
                            if (!TextUtils.isEmpty(queryVideoInfo[1])) {
                                file2.latitude = parseDoubleSafely(queryVideoInfo[1]);
                            }
                            if (!TextUtils.isEmpty(queryVideoInfo[2])) {
                                if (TextUtils.isDigitsOnly(queryVideoInfo[2])) {
                                    file2.takenTime = parseLongSafely(queryVideoInfo[2]);
                                } else {
                                    Date parse3 = sFormatter.parse(queryVideoInfo[2], new ParsePosition(0));
                                    if (parse3 != null) {
                                        file2.takenTime = parse3.getTime();
                                    }
                                }
                            } else if (!TextUtils.isEmpty(queryVideoInfo[3])) {
                                String trim2 = queryVideoInfo[3].trim();
                                long parseLongSafely2 = parseLongSafely(trim2);
                                if (trim2.length() > 8 && trim2.length() <= 10) {
                                    i3 = 1000;
                                } else {
                                    i3 = 1;
                                }
                                file2.takenTime = parseLongSafely2 * i3;
                            }
                            if (!TextUtils.isEmpty(queryVideoInfo[4])) {
                                file2.width = parseIntSafely(queryVideoInfo[4]);
                            }
                            if (!TextUtils.isEmpty(queryVideoInfo[5])) {
                                file2.height = parseIntSafely(queryVideoInfo[5]);
                            }
                            if (!TextUtils.isEmpty(queryVideoInfo[6])) {
                                file2.duration = parseLongSafely(queryVideoInfo[6]);
                            }
                        }
                        if (file2.width == 0 && file2.height == 0 && (parseVideoSizes = parseVideoSizes(file2.localPath)) != null) {
                            file2.width = parseVideoSizes[0];
                            file2.height = parseVideoSizes[1];
                        }
                    } else if (lowerCase.startsWith("audio") && (queryAudioInfo = queryAudioInfo(contentResolver, file2.localPath)) != null) {
                        if (!TextUtils.isEmpty(queryAudioInfo[0])) {
                            file2.album = queryAudioInfo[0];
                        }
                        if (!TextUtils.isEmpty(queryAudioInfo[1])) {
                            file2.artist = queryAudioInfo[1];
                        }
                    }
                    z17 = true;
                }
                IOUtils.closeSilently(cursor);
                cursor = ContactsMonitor.query(contentResolver, MediaStore.Files.getContentUri("internal"), strArr2, "_data=? ", strArr3, null);
                if (cursor != null && cursor.moveToNext()) {
                    z18 = true;
                    if (z18) {
                    }
                    if (str != null) {
                    }
                    file2.mimeType = lowerCase;
                    if (!lowerCase.startsWith("image")) {
                    }
                    z17 = true;
                } else {
                    z18 = false;
                    if (z18) {
                    }
                    if (str != null) {
                    }
                    file2.mimeType = lowerCase;
                    if (!lowerCase.startsWith("image")) {
                    }
                    z17 = true;
                }
            }
            if (z16) {
                if (z17) {
                    if (!TextUtils.isEmpty(file2.compressedPath)) {
                        IOUtils.deleteFile(new File(file2.compressedPath), false);
                    }
                    file2.compressedPath = null;
                    file2.compressedSha = null;
                    file2.compressedSliceSha = null;
                    file2.compressedSize = 0L;
                } else {
                    uploadJobContext.statisticsTimes().onCalShaStart();
                    String[] calSliceSha12 = UploadHelper.calSliceSha1(file2.compressedPath, uploadJobContext.getCanceledFlag());
                    uploadJobContext.statisticsTimes().onCalShaEnd();
                    if (uploadJobContext.isCanceled()) {
                        return;
                    }
                    UploadFile file4 = uploadJobContext.file();
                    if (calSliceSha12 != null && calSliceSha12.length > 0) {
                        str2 = calSliceSha12[calSliceSha12.length - 1];
                    } else {
                        str2 = null;
                    }
                    file4.compressedSha = str2;
                    uploadJobContext.file().compressedSliceSha = calSliceSha12;
                    if (uploadJobContext.file().compressedSha == null) {
                        uploadJobContext.statisticsTimes().onCalShaStart();
                        uploadJobContext.file().compressedSha = IOUtils.getFileSha1(file2.compressedPath);
                        uploadJobContext.statisticsTimes().onCalShaEnd();
                    }
                }
            }
            if (!z17 || (((strArr = file2.sliceSha) == null || strArr.length <= 0) && !z16)) {
                uploadJobContext.statisticsTimes().onCalShaStart();
                String[] calSliceSha13 = UploadHelper.calSliceSha1(file.getAbsolutePath(), uploadJobContext.getCanceledFlag());
                uploadJobContext.statisticsTimes().onCalShaEnd();
                if (!uploadJobContext.isCanceled()) {
                    return;
                }
                if (calSliceSha13 != null && calSliceSha13.length > 0) {
                    str3 = calSliceSha13[calSliceSha13.length - 1];
                }
                file2.sha = str3;
                file2.sliceSha = calSliceSha13;
                if (str3 == null) {
                    uploadJobContext.statisticsTimes().onCalShaStart();
                    file2.sha = IOUtils.getFileSha1(file.getAbsolutePath());
                    uploadJobContext.statisticsTimes().onCalShaEnd();
                }
            }
            file2.fileSize = file.length();
        }
        if (uploadJobContext.isCanceled()) {
            return;
        }
        this.mCallback.onLocalResult(uploadJobContext.dbId(), exists, z19);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004f A[Catch: all -> 0x0082, TRY_LEAVE, TryCatch #0 {all -> 0x0082, blocks: (B:32:0x002d, B:16:0x004f, B:9:0x0036, B:11:0x0045), top: B:31:0x002d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String[] queryAudioInfo(ContentResolver contentResolver, String str) {
        Cursor cursor;
        boolean z16;
        if (contentResolver == null || TextUtils.isEmpty(str)) {
            return null;
        }
        String[] strArr = {"album", JobDbManager.COL_UP_ARTIST};
        String[] strArr2 = {str};
        try {
            cursor = ContactsMonitor.query(contentResolver, MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, strArr, "_data=? ", strArr2, null);
        } catch (Throwable th5) {
            th = th5;
            cursor = null;
        }
        if (cursor != null) {
            try {
                if (!cursor.moveToNext()) {
                }
                z16 = true;
                if (z16) {
                    String[] strArr3 = {cursor.getString(0), cursor.getString(1)};
                    TsLog.d(TAG, str + " queryAudioInfo success." + Arrays.toString(strArr3));
                    return strArr3;
                }
            } catch (Throwable th6) {
                th = th6;
                try {
                    TsLog.e(TAG, str + " queryAudioInfo failed.", th);
                    return null;
                } finally {
                    IOUtils.closeSilently(cursor);
                }
            }
            return null;
        }
        cursor = ContactsMonitor.query(contentResolver, MediaStore.Audio.Media.INTERNAL_CONTENT_URI, strArr, "_data=? ", strArr2, null);
        if (cursor != null && cursor.moveToNext()) {
            z16 = true;
            if (z16) {
            }
            return null;
        }
        z16 = false;
        if (z16) {
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x005d A[Catch: all -> 0x00ac, TRY_LEAVE, TryCatch #1 {all -> 0x00ac, blocks: (B:32:0x003b, B:16:0x005d, B:9:0x0044, B:11:0x0053), top: B:31:0x003b }] */
    @TargetApi(16)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String[] queryImageInfo(ContentResolver contentResolver, String str) {
        Cursor cursor;
        boolean z16;
        if (contentResolver == null || TextUtils.isEmpty(str)) {
            return null;
        }
        String[] strArr = {"longitude", "latitude", "datetaken", "date_added", "width", "height"};
        String[] strArr2 = {str};
        try {
            cursor = ContactsMonitor.query(contentResolver, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, strArr, "_data=? ", strArr2, null);
        } catch (Throwable th5) {
            th = th5;
            cursor = null;
        }
        if (cursor != null) {
            try {
                if (!cursor.moveToNext()) {
                }
                z16 = true;
                if (z16) {
                    String[] strArr3 = {cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5)};
                    TsLog.d(TAG, str + " queryImageInfo success." + Arrays.toString(strArr3));
                    return strArr3;
                }
            } catch (Throwable th6) {
                th = th6;
                try {
                    TsLog.e(TAG, str + " queryImageInfo failed.", th);
                    return null;
                } finally {
                    IOUtils.closeSilently(cursor);
                }
            }
            return null;
        }
        cursor = ContactsMonitor.query(contentResolver, MediaStore.Images.Media.INTERNAL_CONTENT_URI, strArr, "_data=? ", strArr2, null);
        if (cursor != null && cursor.moveToNext()) {
            z16 = true;
            if (z16) {
            }
            return null;
        }
        z16 = false;
        if (z16) {
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0060 A[Catch: all -> 0x00b6, TRY_LEAVE, TryCatch #1 {all -> 0x00b6, blocks: (B:32:0x003e, B:16:0x0060, B:9:0x0047, B:11:0x0056), top: B:31:0x003e }] */
    @TargetApi(16)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String[] queryVideoInfo(ContentResolver contentResolver, String str) {
        Cursor cursor;
        boolean z16;
        if (contentResolver == null || TextUtils.isEmpty(str)) {
            return null;
        }
        String[] strArr = {"longitude", "latitude", "datetaken", "date_added", "width", "height", "duration"};
        String[] strArr2 = {str};
        try {
            cursor = ContactsMonitor.query(contentResolver, MediaStore.Video.Media.EXTERNAL_CONTENT_URI, strArr, "_data=? ", strArr2, null);
        } catch (Throwable th5) {
            th = th5;
            cursor = null;
        }
        if (cursor != null) {
            try {
                if (!cursor.moveToNext()) {
                }
                z16 = true;
                if (z16) {
                    String[] strArr3 = {cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6)};
                    TsLog.d(TAG, str + " queryVideoInfo success." + Arrays.toString(strArr3));
                    return strArr3;
                }
            } catch (Throwable th6) {
                th = th6;
                try {
                    TsLog.e(TAG, str + " queryVideoInfo failed.", th);
                    return null;
                } finally {
                    IOUtils.closeSilently(cursor);
                }
            }
            return null;
        }
        cursor = ContactsMonitor.query(contentResolver, MediaStore.Video.Media.INTERNAL_CONTENT_URI, strArr, "_data=? ", strArr2, null);
        if (cursor != null && cursor.moveToNext()) {
            z16 = true;
            if (z16) {
            }
            return null;
        }
        z16 = false;
        if (z16) {
        }
        return null;
    }

    public void cancelAll() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.mHandler.removeMessages(11);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) message)).booleanValue();
        }
        if (message.what == 11) {
            processLocalEnsure((UploadJobContext) message.obj);
            return true;
        }
        return false;
    }

    public void processor(UploadJobContext uploadJobContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) uploadJobContext);
        } else {
            if (uploadJobContext == null) {
                return;
            }
            this.mHandler.sendMessage(Message.obtain(null, 11, uploadJobContext));
        }
    }

    public void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.mHandler.release();
        }
    }
}
