package com.tencent.mobileqq.winkpublish.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.api.constant.QCirclePublishQualityDataBuilder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.winkpublish.model.ShuoshuoVideoInfo;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import common.config.service.QzoneConfig;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

/* loaded from: classes21.dex */
public class PublishVideoUtils {
    private static final String TAG = "[upload2]PublishVideoUtils";
    private static final String THUMB_BASE_PATH = com.tencent.mobileqq.qcircle.api.constant.a.f261587l;
    private static final String VIDEO_COVER_TMP_CACHE_DIR = VFSAssistantUtils.getSDKPrivatePath("qcircle") + File.separator + "cover";
    private static int MAX_EDGE = 480;

    /* loaded from: classes21.dex */
    public static class ThumbnailInfo {
        public String mCoverUrl;
        public int mThumbnailHeight;
        public int mThumbnailWidth;
    }

    private static int[] calculateScaledThumbWH(Bitmap bitmap) {
        if (bitmap == null) {
            QLog.w(TAG, 1, "calculateThumbWH, bitmap == null \uff01");
            return null;
        }
        if (bitmap.isRecycled()) {
            QLog.w(TAG, 1, "calculateThumbWH, bitmap isRecycled !");
            return null;
        }
        return calculateScaledThumbWH(new int[]{bitmap.getWidth(), bitmap.getHeight()});
    }

    public static long getDuration(String str) {
        long j3 = -1;
        if (!new File(str).exists()) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 1, "Path:" + str + str + ", not exits!");
            }
            return -1L;
        }
        ReportMediaPlayer reportMediaPlayer = new ReportMediaPlayer();
        try {
            try {
                reportMediaPlayer.setDataSource(str);
                reportMediaPlayer.prepare();
                j3 = reportMediaPlayer.getDuration();
            } catch (Exception e16) {
                e16.printStackTrace();
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "getDuration", e16);
                }
            }
            return j3;
        } finally {
            reportMediaPlayer.release();
        }
    }

    @TargetApi(10)
    private static Bitmap getFirstFrame(String str) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                try {
                    try {
                        mediaMetadataRetriever.setDataSource(str);
                        mediaMetadataRetriever.extractMetadata(9);
                        Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(500L, 2);
                        if (frameAtTime == null) {
                            QLog.d(TAG, 1, "getFirstFrame... bitmap == null option:0");
                            frameAtTime = mediaMetadataRetriever.getFrameAtTime(500L, 0);
                        }
                        if (frameAtTime == null) {
                            QLog.d(TAG, 1, "getFirstFrame... bitmap == null option:3");
                            frameAtTime = mediaMetadataRetriever.getFrameAtTime(500L, 3);
                        }
                        try {
                            mediaMetadataRetriever.release();
                        } catch (RuntimeException e16) {
                            QLog.e(TAG, 1, "retriever.release error", e16);
                        }
                        return frameAtTime;
                    } catch (Throwable th5) {
                        try {
                            mediaMetadataRetriever.release();
                        } catch (RuntimeException e17) {
                            QLog.e(TAG, 1, "retriever.release error", e17);
                        }
                        throw th5;
                    }
                } catch (RuntimeException e18) {
                    QLog.e(TAG, 1, "RuntimeException", e18);
                    mediaMetadataRetriever.release();
                    return null;
                }
            } catch (IllegalArgumentException e19) {
                QLog.e(TAG, 1, "IllegalArgumentException", e19);
                mediaMetadataRetriever.release();
                return null;
            }
        } catch (RuntimeException e26) {
            QLog.e(TAG, 1, "retriever.release error", e26);
            return null;
        }
    }

    public static String getThumbNail(String str) {
        ThumbnailInfo processThumb = processThumb(str);
        if (processThumb == null) {
            return null;
        }
        return processThumb.mCoverUrl;
    }

    public static int getTrimMinAvailRam(String str, boolean z16) {
        if (!z16) {
            return uq3.c.X0(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_TRIM_MIN_AVAIL_RAM, Integer.valueOf(QzoneConfig.DefaultValue.DEFAUL_VIDEO_TRIM_MIN_AVAIL_RAM)).intValue();
        }
        if ("ultrafast".equalsIgnoreCase(str)) {
            return uq3.c.X0(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_TRIM_ULTRAFAST_AVAIL_RAM, Integer.valueOf(QzoneConfig.DefaultValue.DEFAUL_VIDEO_TRIM_ULTRAFAST_AVAIL_RAM)).intValue();
        }
        if ("superfast".equalsIgnoreCase(str)) {
            return uq3.c.X0(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_TRIM_SUPERFAST_AVAIL_RAM, Integer.valueOf(QzoneConfig.DefaultValue.DEFAUL_VIDEO_TRIM_SUPERFAST_AVAIL_RAM)).intValue();
        }
        if (!"medium".equalsIgnoreCase(str)) {
            return QzoneConfig.DefaultValue.DEFAUL_VIDEO_TRIM_MIN_AVAIL_RAM;
        }
        return uq3.c.X0(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_TRIM_MEDIUM_AVAIL_RAM, Integer.valueOf(QzoneConfig.DefaultValue.DEFAUL_VIDEO_TRIM_MEDIUM_AVAIL_RAM)).intValue();
    }

    @Nullable
    public static String getVideoCover(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 1, "videoPath == null");
            return null;
        }
        if (!new File(str).exists()) {
            QLog.e(TAG, 1, "!videoFile.exists()");
            return null;
        }
        return saveBitmapToLocal(getFirstFrame(str));
    }

    public static String getVideoDurationString(long j3) {
        String str;
        String str2;
        if (j3 < 0) {
            QLog.e(TAG, 1, "Illegal video duration:" + j3);
            return "";
        }
        int i3 = (int) (j3 / 1000);
        int i16 = i3 % 60;
        int i17 = i3 / 60;
        if (i16 > 9) {
            str = String.valueOf(i16);
        } else {
            str = "0" + String.valueOf(i16);
        }
        if (i17 > 9) {
            str2 = String.valueOf(i17);
        } else {
            str2 = "0" + String.valueOf(i17);
        }
        return str2 + ":" + str;
    }

    public static double getVideoEstimateSize(String str, long j3, long j16, boolean z16, boolean z17) {
        if (!TextUtils.isEmpty(str) && j16 != 0) {
            if (j3 == 0 || j3 < j16) {
                j3 = j16;
            }
            long length = new File(str).length();
            if (!z17) {
                return length;
            }
            if (z16) {
                double d16 = ((length * 1.0d) / j3) * j16;
                QLog.d(TAG, 1, "getVideoEstimateSize, estimateSize=" + d16);
                return d16;
            }
            double min = Math.min((((j16 * 1.0d) / 1000.0d) * uq3.c.X0(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_MAX_BITRATE, Integer.valueOf(QzoneConfig.DefaultValue.DEFAULT_WEISHI_VIDEO_MAX_BITRATE)).intValue()) / 8.0d, length);
            QLog.d(TAG, 1, "getVideoEstimateSize, totalDuration=" + j3 + ", duration=" + j16 + ", estimateSize=" + min);
            return min;
        }
        return 0.0d;
    }

    private static Bitmap getVideoThumbnail(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        Bitmap createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(str, 1);
        long currentTimeMillis2 = System.currentTimeMillis();
        if (createVideoThumbnail != null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getVideoThumbnail => success, width=" + createVideoThumbnail.getWidth() + ", height=" + createVideoThumbnail.getHeight() + ", videoPath=" + str + ", cost:" + (currentTimeMillis2 - currentTimeMillis) + "ms");
            }
        } else {
            QLog.e(TAG, 1, "getVideoThumbnail => fail,  videoPath=" + str);
        }
        return createVideoThumbnail;
    }

    private static String getVideoThumbnailPath(String str) {
        return THUMB_BASE_PATH + str + ".jpg";
    }

    public static ShuoshuoVideoInfo prepareVideoInfos(int i3, String str, Context context, long j3, String str2, long j16, int i16, String str3, int i17, int i18, long j17, long j18, long j19, boolean z16, Bundle bundle) {
        ShuoshuoVideoInfo shuoshuoVideoInfo;
        String str4;
        int i19;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("videoId:" + j3 + " videoPath:" + str2 + " size:" + j16 + " videoType:" + i16 + " thumbnailPath:" + str3 + " thumbnailHeight:" + i17 + " thumbnailWidth:" + i18 + " startTime:" + j17 + " duration:" + j18 + " totalDuration:" + j19 + " needProcess:" + z16);
        QLog.d(TAG, 1, sb5.toString());
        if (!new File(str2).exists()) {
            QLog.e(TAG, 1, "Path:" + str2 + ", not exits!");
            ((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).uploadQualityReport(new QCirclePublishQualityDataBuilder().setKeyEventId(((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).tVideoInfo()).setTraceId(str).setExt1(String.valueOf(i3)).setDesc(sb5.toString()).setKeyRetCode("-80000004"));
            return null;
        }
        ShuoshuoVideoInfo shuoshuoVideoInfo2 = new ShuoshuoVideoInfo();
        shuoshuoVideoInfo2.mVideoPath = str2;
        shuoshuoVideoInfo2.mSize = j16;
        shuoshuoVideoInfo2.mVideoType = i16;
        if (i16 == 0) {
            shuoshuoVideoInfo2.mIsNew = 1;
            shuoshuoVideoInfo2.mEstimateSize = (500 * j19) / 8;
        } else if (i16 == 1) {
            shuoshuoVideoInfo2.mIsNew = 102;
            shuoshuoVideoInfo = shuoshuoVideoInfo2;
            str4 = TAG;
            i19 = 1;
            shuoshuoVideoInfo.mEstimateSize = getVideoEstimateSize(str2, j19, j18, false, z16);
            sb5.append(" coverUrl:" + shuoshuoVideoInfo.mCoverUrl);
            Object[] objArr = new Object[2];
            objArr[0] = "prepareVideoInfos... video coverUrl:";
            objArr[i19] = shuoshuoVideoInfo.mCoverUrl;
            QLog.d(str4, i19, objArr);
            processVideoCover(i3, str, context, j3, str2, str3, i17, i18, shuoshuoVideoInfo, sb5);
            shuoshuoVideoInfo.mStartTime = j17;
            shuoshuoVideoInfo.mEndTime = j17 + j18;
            ShuoshuoVideoInfo shuoshuoVideoInfo3 = shuoshuoVideoInfo;
            shuoshuoVideoInfo3.mNeedProcess = z16;
            shuoshuoVideoInfo3.mDuration = j18;
            shuoshuoVideoInfo3.mTotalDuration = j19;
            shuoshuoVideoInfo3.mExtras = bundle;
            QLog.d(str4, 2, "prepareVideoInfos mCoverUrl: " + shuoshuoVideoInfo3.mCoverUrl);
            return shuoshuoVideoInfo3;
        }
        shuoshuoVideoInfo = shuoshuoVideoInfo2;
        str4 = TAG;
        i19 = 1;
        sb5.append(" coverUrl:" + shuoshuoVideoInfo.mCoverUrl);
        Object[] objArr2 = new Object[2];
        objArr2[0] = "prepareVideoInfos... video coverUrl:";
        objArr2[i19] = shuoshuoVideoInfo.mCoverUrl;
        QLog.d(str4, i19, objArr2);
        processVideoCover(i3, str, context, j3, str2, str3, i17, i18, shuoshuoVideoInfo, sb5);
        shuoshuoVideoInfo.mStartTime = j17;
        shuoshuoVideoInfo.mEndTime = j17 + j18;
        ShuoshuoVideoInfo shuoshuoVideoInfo32 = shuoshuoVideoInfo;
        shuoshuoVideoInfo32.mNeedProcess = z16;
        shuoshuoVideoInfo32.mDuration = j18;
        shuoshuoVideoInfo32.mTotalDuration = j19;
        shuoshuoVideoInfo32.mExtras = bundle;
        QLog.d(str4, 2, "prepareVideoInfos mCoverUrl: " + shuoshuoVideoInfo32.mCoverUrl);
        return shuoshuoVideoInfo32;
    }

    /* JADX WARN: Not initialized variable reg: 6, insn: 0x00e0: MOVE (r3 I:??[OBJECT, ARRAY]) = (r6 I:??[OBJECT, ARRAY]) (LINE:225), block:B:54:0x00e0 */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00e3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ThumbnailInfo processThumb(String str) {
        BufferedOutputStream bufferedOutputStream;
        OutputStream outputStream;
        ThumbnailInfo thumbnailInfo = new ThumbnailInfo();
        OutputStream outputStream2 = null;
        try {
            try {
                Bitmap videoThumbnail = getVideoThumbnail(str);
                if (videoThumbnail == null) {
                    QLog.e(TAG, 1, "processThumb: create thumbnail fail");
                    return null;
                }
                Bitmap resizeThumb = resizeThumb(videoThumbnail);
                if (resizeThumb == null) {
                    QLog.e(TAG, 1, "processThumb: resize thumbnail fail");
                    return null;
                }
                thumbnailInfo.mThumbnailWidth = resizeThumb.getWidth();
                thumbnailInfo.mThumbnailHeight = resizeThumb.getHeight();
                String videoThumbnailPath = getVideoThumbnailPath(new File(str).getName());
                if (TextUtils.isEmpty(videoThumbnailPath)) {
                    return null;
                }
                WinkHostFileUtils.createFileIfNotExits(THUMB_BASE_PATH + ".nomedia");
                File file = new File(videoThumbnailPath);
                File file2 = new File(file.getParent());
                if (!file2.exists() || !file2.isDirectory()) {
                    file2.mkdirs();
                }
                if (!file.exists() || !file.isFile()) {
                    file.createNewFile();
                }
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                try {
                    resizeThumb.compress(Bitmap.CompressFormat.JPEG, 50, bufferedOutputStream);
                    bufferedOutputStream.flush();
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "video thumbnail saved, path=" + videoThumbnailPath);
                    }
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException unused) {
                    }
                    thumbnailInfo.mCoverUrl = videoThumbnailPath;
                    return thumbnailInfo;
                } catch (Exception e16) {
                    e = e16;
                    QLog.e(TAG, 1, "processThumb failure", e);
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    return null;
                } catch (OutOfMemoryError e17) {
                    e = e17;
                    QLog.e(TAG, 1, "processThumb OutOfMemoryError", e);
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    return null;
                }
            } catch (Exception e18) {
                e = e18;
                bufferedOutputStream = null;
            } catch (OutOfMemoryError e19) {
                e = e19;
                bufferedOutputStream = null;
            } catch (Throwable th5) {
                th = th5;
                if (outputStream2 != null) {
                }
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            outputStream2 = outputStream;
            if (outputStream2 != null) {
                try {
                    outputStream2.close();
                } catch (IOException unused4) {
                }
            }
            throw th;
        }
    }

    public static void processVideoCover(int i3, String str, Context context, long j3, String str2, String str3, int i16, int i17, ShuoshuoVideoInfo shuoshuoVideoInfo, StringBuilder sb5) {
        int i18;
        int i19 = 2;
        if (!TextUtils.isEmpty(str3) && WinkHostFileUtils.fileExists(str3)) {
            shuoshuoVideoInfo.mCoverUrl = str3;
            shuoshuoVideoInfo.mVideoHeight = i16;
            shuoshuoVideoInfo.mVideoWidth = i17;
            QLog.d(TAG, 1, "prepareVideoInfos... use exist mCoverUrl:", str3);
            i18 = 0;
        } else {
            i18 = -1;
        }
        if (TextUtils.isEmpty(shuoshuoVideoInfo.mCoverUrl)) {
            String videoCover = getVideoCover(str2);
            if (!TextUtils.isEmpty(videoCover)) {
                shuoshuoVideoInfo.mCoverUrl = videoCover;
                shuoshuoVideoInfo.mVideoHeight = i16;
                shuoshuoVideoInfo.mVideoWidth = i17;
                i19 = 1;
            } else if (j3 != -1 && context != null && TextUtils.isEmpty(shuoshuoVideoInfo.mCoverUrl)) {
                ThumbnailInfo queryVideoThumbs = queryVideoThumbs(context, j3);
                String str4 = queryVideoThumbs.mCoverUrl;
                shuoshuoVideoInfo.mCoverUrl = str4;
                int i26 = queryVideoThumbs.mThumbnailHeight;
                if (i26 == 0) {
                    i26 = i16;
                }
                shuoshuoVideoInfo.mVideoHeight = i26;
                int i27 = queryVideoThumbs.mThumbnailWidth;
                if (i27 == 0) {
                    i27 = i17;
                }
                shuoshuoVideoInfo.mVideoWidth = i27;
                QLog.d(TAG, 1, "prepareVideoInfos... queryVideoThumbs... mCoverUrl:", str4, " mVideoHeight:", Integer.valueOf(i26), " mVideoWidth:", Integer.valueOf(shuoshuoVideoInfo.mVideoWidth));
            }
            ((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).uploadQualityReport(new QCirclePublishQualityDataBuilder().setKeyEventId(((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).tVideoInfo()).setTraceId(str).setExt1(String.valueOf(i3)).setExt2(String.valueOf(i19)).setExt3(String.valueOf(shuoshuoVideoInfo.mVideoWidth)).setExt4(String.valueOf(shuoshuoVideoInfo.mVideoHeight)).setDesc(sb5.toString()).setKeyRetCode("0"));
        }
        i19 = i18;
        ((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).uploadQualityReport(new QCirclePublishQualityDataBuilder().setKeyEventId(((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).tVideoInfo()).setTraceId(str).setExt1(String.valueOf(i3)).setExt2(String.valueOf(i19)).setExt3(String.valueOf(shuoshuoVideoInfo.mVideoWidth)).setExt4(String.valueOf(shuoshuoVideoInfo.mVideoHeight)).setDesc(sb5.toString()).setKeyRetCode("0"));
    }

    public static ThumbnailInfo queryVideoThumbs(Context context, long j3) {
        Cursor cursor;
        String[] strArr = {"_data", "video_id", "height", "width"};
        try {
            cursor = ContactsMonitor.query(context.getContentResolver(), MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, strArr, "video_id=" + j3, null, null);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "query error:" + e16.toString());
            cursor = null;
        }
        ThumbnailInfo thumbnailInfo = new ThumbnailInfo();
        if (cursor != null && cursor.moveToFirst()) {
            int columnIndex = cursor.getColumnIndex("_data");
            if (columnIndex != -1) {
                thumbnailInfo.mCoverUrl = cursor.getString(columnIndex);
            }
            int columnIndex2 = cursor.getColumnIndex("height");
            if (columnIndex2 != -1) {
                thumbnailInfo.mThumbnailHeight = cursor.getInt(columnIndex2);
            }
            int columnIndex3 = cursor.getColumnIndex("width");
            if (columnIndex3 != -1) {
                thumbnailInfo.mThumbnailWidth = cursor.getInt(columnIndex3);
            }
        }
        if (cursor != null) {
            cursor.close();
        }
        return thumbnailInfo;
    }

    public static Bitmap resizeThumb(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int[] calculateScaledThumbWH = calculateScaledThumbWH(bitmap);
            if (calculateScaledThumbWH == null) {
                return null;
            }
            int i3 = calculateScaledThumbWH[0];
            int i16 = calculateScaledThumbWH[1];
            if (width == i3 && height == i16) {
                return bitmap;
            }
            float f16 = i3;
            float f17 = i16;
            Matrix matrix = new Matrix();
            matrix.postScale(f16 / width, f17 / height);
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            Canvas canvas = new Canvas(createBitmap);
            RectF rectF = new RectF(0.0f, 0.0f, f16, f17);
            Paint paint = new Paint(1);
            paint.setColor(-16777216);
            paint.setAntiAlias(true);
            canvas.drawBitmap(bitmap, (Rect) null, rectF, paint);
            if (!bitmap.isRecycled()) {
                bitmap.recycle();
            }
            return createBitmap;
        } catch (OutOfMemoryError e16) {
            QLog.e(TAG, 1, "resizeThumb, OutOfMemoryError ", e16);
            return bitmap;
        }
    }

    private static boolean saveBitmapToJPG(Bitmap bitmap, String str) {
        File file = new File(str);
        if (file.exists() || bitmap == null) {
            return false;
        }
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                if (file.getParentFile() != null && !file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                file.createNewFile();
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
                try {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bufferedOutputStream2);
                    try {
                        bufferedOutputStream2.close();
                    } catch (IOException unused) {
                    }
                    return true;
                } catch (Exception e16) {
                    e = e16;
                    bufferedOutputStream = bufferedOutputStream2;
                    QLog.e(TAG, 1, "saveBitmapToJPG...", e);
                    if (bufferedOutputStream == null) {
                        return false;
                    }
                    try {
                        bufferedOutputStream.close();
                        return false;
                    } catch (IOException unused2) {
                        return false;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    bufferedOutputStream = bufferedOutputStream2;
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

    public static String saveBitmapToLocal(Bitmap bitmap) {
        return saveBitmapToLocal(bitmap, VIDEO_COVER_TMP_CACHE_DIR + File.separator + UUID.randomUUID().toString() + ".jpg");
    }

    public static ShuoshuoVideoInfo simplePrepareVideoInfos(Context context, long j3, String str, long j16, int i3, String str2, int i16, int i17, long j17, long j18, long j19, boolean z16, Bundle bundle, boolean z17) {
        if (!new File(str).exists() && z17) {
            QLog.e(TAG, 1, "Path:" + str + ", not exits!");
            return null;
        }
        ShuoshuoVideoInfo shuoshuoVideoInfo = new ShuoshuoVideoInfo();
        shuoshuoVideoInfo.mVideoPath = str;
        shuoshuoVideoInfo.mSize = j16;
        shuoshuoVideoInfo.mVideoType = i3;
        if (i3 == 0) {
            shuoshuoVideoInfo.mIsNew = 1;
            shuoshuoVideoInfo.mEstimateSize = (500 * j19) / 8;
        } else if (i3 == 1) {
            shuoshuoVideoInfo.mIsNew = 102;
            shuoshuoVideoInfo.mEstimateSize = getVideoEstimateSize(str, j19, j18, false, z16);
        }
        shuoshuoVideoInfo.mCoverUrl = str2;
        shuoshuoVideoInfo.mVideoHeight = i16;
        shuoshuoVideoInfo.mVideoWidth = i17;
        shuoshuoVideoInfo.mStartTime = j17;
        shuoshuoVideoInfo.mEndTime = j17 + j18;
        shuoshuoVideoInfo.mNeedProcess = z16;
        shuoshuoVideoInfo.mDuration = j18;
        shuoshuoVideoInfo.mTotalDuration = j19;
        shuoshuoVideoInfo.mExtras = bundle;
        QLog.d(TAG, 2, "prepareVideoInfos mCoverUrl: " + shuoshuoVideoInfo.mCoverUrl);
        return shuoshuoVideoInfo;
    }

    public static void updataVideoEstimateSize(ShuoshuoVideoInfo shuoshuoVideoInfo, boolean z16) {
        if (shuoshuoVideoInfo == null) {
            return;
        }
        shuoshuoVideoInfo.mEstimateSize = getVideoEstimateSize(shuoshuoVideoInfo.mVideoPath, shuoshuoVideoInfo.mTotalDuration, shuoshuoVideoInfo.mDuration, z16, shuoshuoVideoInfo.mNeedProcess);
    }

    public static String saveBitmapToLocal(Bitmap bitmap, String str) {
        if (bitmap != null && !TextUtils.isEmpty(str)) {
            if (saveBitmapToJPG(bitmap, str)) {
                QLog.d(TAG, 1, "saveBitmapToLocal... path:", str);
                return str;
            }
            QLog.e(TAG, 1, "saveBitmapToJPG error, path:" + str);
            return null;
        }
        QLog.e(TAG, 1, "bmp == null");
        return null;
    }

    private static int[] calculateScaledThumbWH(int[] iArr) {
        int i3;
        int i16;
        if (iArr == null) {
            return null;
        }
        int i17 = iArr[0];
        int i18 = iArr[1];
        if (i17 != 0 && i18 != 0) {
            if (i17 > i18) {
                i16 = MAX_EDGE;
                i3 = (int) (i18 / ((i17 * 1.0d) / i16));
            } else {
                int i19 = MAX_EDGE;
                i3 = i19;
                i16 = (int) (i17 / ((i18 * 1.0d) / i19));
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "calculateThumbWH, w = " + i17 + ", h = " + i18 + ",  dstW = " + i16 + ", dstH = " + i3);
            }
            return new int[]{i16, i3};
        }
        QLog.e(TAG, 1, "calculateThumbWH, w or h == 0 !");
        return null;
    }

    public static ShuoshuoVideoInfo simplePrepareVideoInfos(Context context, long j3, String str, long j16, int i3, String str2, int i16, int i17, long j17, long j18, long j19, boolean z16, Bundle bundle) {
        return simplePrepareVideoInfos(context, j3, str, j16, i3, str2, i16, i17, j17, j18, j19, z16, bundle, true);
    }
}
