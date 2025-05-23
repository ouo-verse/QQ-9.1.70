package com.tencent.mobileqq.shortvideo.mediadevice;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.maxvideo.common.GlobalInit;
import com.tencent.maxvideo.trim.TrimNative;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.cover.RecordThumbnailUtils;
import com.tencent.mobileqq.shortvideo.hwcodec.VideoSourceHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.videocodec.ffmpeg.Argument;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.utils.IQzoneVideoHelper;
import com.tencent.video.decode.ShortVideoSoLoad;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.GifCoder;
import java.io.File;
import java.util.ArrayList;

/* loaded from: classes18.dex */
public class GifProcessor {
    public static final int ERROR_CODE_FORMAT_NOT_SUPPORT = -111;
    public static final int ERROR_CODE_GET_FRAME_INIT_FAILED = -112;
    public static final int ERROR_CODE_SO_NOT_LOADED = -110;
    private static final String TAG = "GifProcessor";
    private static int gifFirstNSecond;
    private static int gifFps;
    private static int gifMaxFrame;
    private static int gifSize;
    private static int gifSizeForLongEdge;
    private static int gifTimePerFrame;
    private static boolean sIsSoLoaded;

    private static int convertByFFmpeg(String str, String str2) {
        String str3;
        boolean z16;
        if (!loadSo()) {
            return -110;
        }
        loadConfig();
        String format = String.format("fps=%d", Integer.valueOf(gifFps));
        try {
            str3 = TrimNative.getRealProperties(str, gifSize, gifSizeForLongEdge);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "getRealProperties error:", th5);
            str3 = null;
        }
        if (TextUtils.isEmpty(str3)) {
            return -11;
        }
        String[] split = str3.split(",");
        if (split.length >= 4 && split[0].equals("0")) {
            int intValue = Integer.valueOf(split[3]).intValue();
            if (intValue != 1) {
                if (intValue != 2) {
                    if (intValue == 3) {
                        format = format + ",transpose=2";
                    }
                } else {
                    format = format + ",vflip,hflip";
                }
            } else {
                format = format + ",transpose=1";
            }
            String parent = new File(str2).getParent();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(parent);
            String str4 = File.separator;
            sb5.append(str4);
            sb5.append("tempPics");
            String sb6 = sb5.toString();
            File file = new File(sb6);
            if (file.exists()) {
                if (file.isDirectory()) {
                    FileUtils.deleteDirectory(sb6);
                } else {
                    file.delete();
                }
            }
            file.mkdir();
            String[] strArr = {Argument.FILE_INPUT, str, "-vf", format, "-y", sb6 + str4 + "%03d.jpg"};
            long currentTimeMillis = System.currentTimeMillis();
            int trimByFFmpeg = ((IQzoneVideoHelper) QRoute.api(IQzoneVideoHelper.class)).trimByFFmpeg(strArr);
            long currentTimeMillis2 = System.currentTimeMillis();
            QLog.i(TAG, 1, "convertVideoToGifForRecord generate temp pics input=" + str + " output=" + str2 + " cost=" + (currentTimeMillis2 - currentTimeMillis) + " ret=" + trimByFFmpeg);
            if (trimByFFmpeg == 0) {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    for (File file2 : listFiles) {
                        arrayList.add(file2.getAbsolutePath());
                    }
                    GifCoder gifCoder = new GifCoder();
                    gifCoder.setEncoderDither(true);
                    gifCoder.setEncoderGifSize(gifSize);
                    if (gifSizeForLongEdge == 1) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    gifCoder.setEncoderGifPicSizeForLongEdge(z16);
                    if (!gifCoder.encodeGif(str2, arrayList, gifTimePerFrame, true)) {
                        trimByFFmpeg = -234;
                    }
                    gifCoder.closeEncoder();
                    QLog.i(TAG, 1, "convertVideoToGifForRecord generate gif input=" + str + " output=" + str2 + " cost=" + (System.currentTimeMillis() - currentTimeMillis2) + " ret=" + trimByFFmpeg);
                } else {
                    trimByFFmpeg = -233;
                }
            }
            FileUtils.deleteDirectory(sb6);
            return trimByFFmpeg;
        }
        return -12;
    }

    public static int convertVideoToGifForRecord(String str, String str2) {
        return convertByFFmpeg(str, str2);
    }

    public static int generateGifFromVFile(String str, String str2, int i3, String str3) {
        boolean z16;
        QLog.i(TAG, 1, "generateGifFromVFile vfPath=" + str + " output=" + str3);
        loadConfig();
        GifCoder gifCoder = new GifCoder();
        gifCoder.setEncoderDither(true);
        gifCoder.setEncoderGifSize(gifSize);
        int i16 = 0;
        if (gifSizeForLongEdge == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        gifCoder.setEncoderGifPicSizeForLongEdge(z16);
        int i17 = ((CodecParam.mRecordFrames * 1000) / CodecParam.mRecordTime) / gifFps;
        if (i17 <= 0) {
            i17 = 1;
        }
        VideoSourceHelper videoSourceHelper = new VideoSourceHelper(str, str2);
        videoSourceHelper.initHelperParam();
        int[] sourceVideoParam = videoSourceHelper.getSourceVideoParam();
        Bitmap createBitmap = Bitmap.createBitmap(sourceVideoParam[0], sourceVideoParam[1], Bitmap.Config.RGB_565);
        int i18 = 0;
        while (true) {
            if (i16 >= CodecParam.mRecordFrames) {
                break;
            }
            i18 = videoSourceHelper.getVideoFrameByIndex(createBitmap, i16);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getVideoFrameByIndex from vffile. index=" + i16 + " ret=" + i18);
            }
            if (i18 != 0) {
                break;
            }
            Bitmap copy = createBitmap.copy(Bitmap.Config.ARGB_8888, true);
            if (i3 != 0 && !RecordThumbnailUtils.c(i3)) {
                copy = RecordThumbnailUtils.d(copy, i3);
            }
            if (!gifCoder.encodeGif(copy, str3, gifTimePerFrame, true)) {
                i18 = -1;
                break;
            }
            i16 += i17;
        }
        gifCoder.closeEncoder();
        return i18;
    }

    private static void loadConfig() {
        gifSize = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_TO_GIF_SIZE, 720);
        gifSizeForLongEdge = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_TO_GIF_SIZE_FOR_LONG_EDGE, 0);
        gifFps = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_TO_GIF_FPS, 5);
        gifTimePerFrame = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_TO_GIF_TIME_PER_FRAME, 200);
        gifMaxFrame = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_TO_GIF_MAX_FRAME, 10);
        gifFirstNSecond = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_TO_GIF_FIRST_N_SECOND, 10);
    }

    private static boolean loadSo() {
        if (sIsSoLoaded) {
            return true;
        }
        try {
            String shortVideoSoPath = ShortVideoSoLoad.getShortVideoSoPath(BaseApplication.getContext());
            String shortVideoSoLibName = VideoEnvironment.getShortVideoSoLibName();
            String str = shortVideoSoPath + shortVideoSoLibName;
            File file = new File(str);
            if (shortVideoSoLibName != null && file.exists()) {
                GlobalInit.loadLibraryWithFullPath(str);
                sIsSoLoaded = true;
                return true;
            }
            return false;
        } catch (Throwable th5) {
            QLog.w(TAG, 1, "loadLibrary error", th5);
            return false;
        }
    }
}
