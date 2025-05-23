package com.tencent.mobileqq.shortvideo.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.dpc.IDPCApiConstant;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.videocodec.ffmpeg.FFmpegFileUtils;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmedia.videocompress.VideoConverter;
import com.tencent.richmedia.videocompress.VideoConverterConfig;
import com.tencent.video.decode.ShortVideoSoLoad;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ShortVideoTrimmer {
    public static final long CODE_RATE = 1688;
    public static final int CONFIG_LONG_EDGE_DEFAULT = 640;
    public static final int ORIENTATION_DOWN = 2;
    public static final int ORIENTATION_LEFT = 1;
    public static final int ORIENTATION_RIGHT = 3;
    public static final int ORIENTATION_UP = 0;
    public static final String TAG = "ShortVideoTrimmer";
    public static final String VIDEO_COMPRESS_BIN_NAME = "QQVideoTrimProcess";
    public static final String VIDEO_TRIM_PIC = "trim_process_pic";
    public static final String VIDEO_TRIM_PIE = "trim_process_pie";
    public static int sCpuCores;

    private static void PrintLog(String str) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, str);
        }
    }

    public static int compressVideo(Context context, final String str, final String str2, final VideoConverterConfig videoConverterConfig) {
        VideoConverter videoConverter = new VideoConverter(new h());
        setSoftwareCompressMode(context, videoConverter);
        return videoConverter.startCompress(context, str, new ProcessCallBack() { // from class: com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer.1
            @Override // com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer.ProcessCallBack, com.tencent.richmedia.videocompress.VideoConverter.Processor
            public VideoConverterConfig getEncodeConfig(int i3, int i16) {
                VideoConverterConfig videoConverterConfig2 = VideoConverterConfig.this;
                if (videoConverterConfig2 == null) {
                    videoConverterConfig2 = ShortVideoTrimmer.getCompressConfig(str);
                }
                videoConverterConfig2.output = str2;
                return videoConverterConfig2;
            }
        }, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0104  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static VideoConverterConfig getCompressConfig(String str) {
        int i3;
        VideoConverterConfig videoConverterConfig;
        File file;
        int[] videoProperty;
        String[] split;
        String featureValue = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.lvcc.name(), IDPCApiConstant.LONG_VIDEO_COMPRESS_CONFIG_DEFAULT);
        if (featureValue != null && featureValue.length() > 0 && (split = featureValue.split("\\|")) != null && split.length > 1) {
            try {
                i3 = Integer.valueOf(split[1]).intValue();
            } catch (NumberFormatException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "getCompressConfig, get DpcConfig Error", e16);
                }
            }
            if (i3 <= 0) {
                i3 = 640;
            }
            int i16 = i3 + 60;
            videoConverterConfig = new VideoConverterConfig();
            file = new File(str);
            if (!file.exists()) {
                videoConverterConfig.isNeedCompress = false;
                PrintLog("getCompressConfig, file not exists");
            }
            videoProperty = getVideoProperty(str);
            if (videoProperty == null && videoProperty.length == 5 && videoProperty[0] == 0) {
                videoConverterConfig.rotate = getVideoRotate(videoProperty[3]);
                videoConverterConfig.srcWidth = videoProperty[1];
                videoConverterConfig.srcHeight = videoProperty[2];
                if (((int) ((videoProperty[4] / 1000.0d) + 0.5d)) == 0) {
                    videoConverterConfig.isNeedCompress = false;
                    PrintLog("getCompressConfig, [sec == 0 OR video duration < 0.5 sec]");
                } else {
                    videoConverterConfig.srcBitrate = file.length() / (r7 * 128);
                    int max = Math.max(videoProperty[1], videoProperty[2]);
                    if (max <= i16) {
                        if (videoConverterConfig.srcBitrate > CODE_RATE) {
                            videoConverterConfig.isNeedCompress = true;
                            videoConverterConfig.destQmax = 25;
                            videoConverterConfig.destWidth = videoProperty[1];
                            videoConverterConfig.destHeight = videoProperty[2];
                        } else {
                            videoConverterConfig.isNeedCompress = false;
                            PrintLog("getCompressConfig, [kbps > CODE_RATE] judge Failure...");
                        }
                    } else {
                        videoConverterConfig.isNeedCompress = true;
                        float f16 = i3 / max;
                        videoConverterConfig.destWidth = (int) (videoProperty[1] * f16);
                        videoConverterConfig.destHeight = (int) (videoProperty[2] * f16);
                        videoConverterConfig.destQmax = 25;
                    }
                }
            } else {
                videoConverterConfig.isNeedCompress = false;
                PrintLog("getCompressConfig, values=" + videoProperty);
                if (videoProperty != null) {
                    PrintLog("getCompressConfig, values.length=" + videoProperty.length + " err=" + videoProperty[0]);
                }
            }
            return videoConverterConfig;
        }
        i3 = 0;
        if (i3 <= 0) {
        }
        int i162 = i3 + 60;
        videoConverterConfig = new VideoConverterConfig();
        file = new File(str);
        if (!file.exists()) {
        }
        videoProperty = getVideoProperty(str);
        if (videoProperty == null) {
        }
        videoConverterConfig.isNeedCompress = false;
        PrintLog("getCompressConfig, values=" + videoProperty);
        if (videoProperty != null) {
        }
        return videoConverterConfig;
    }

    public static int getCpuCores() {
        if (sCpuCores == 0) {
            try {
                File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new FileFilter() { // from class: com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer.1CpuFilter
                    @Override // java.io.FileFilter
                    public boolean accept(File file) {
                        if (Pattern.matches("cpu[0-9]", file.getName())) {
                            return true;
                        }
                        return false;
                    }
                });
                if (listFiles == null) {
                    return 1;
                }
                sCpuCores = listFiles.length;
            } catch (Exception unused) {
                sCpuCores = 1;
            }
        }
        return sCpuCores;
    }

    public static native String getRealProperties(String str);

    @TargetApi(17)
    public static int[] getVideoProperty(String str) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        int[] iArr = null;
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                iArr = new int[]{0, Integer.parseInt(mediaMetadataRetriever.extractMetadata(18)), Integer.parseInt(mediaMetadataRetriever.extractMetadata(19)), Integer.parseInt(mediaMetadataRetriever.extractMetadata(24)), Integer.parseInt(mediaMetadataRetriever.extractMetadata(9))};
            } catch (Exception e16) {
                QLog.e(TAG, 1, "getVideoProperty:", e16);
            }
            return iArr;
        } finally {
            mediaMetadataRetriever.release();
        }
    }

    public static String getVideoRotate(int i3) {
        if (i3 == 0) {
            return "0";
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return "0";
                }
                return "270";
            }
            return "180";
        }
        return "90";
    }

    private static boolean initTrimProcessFile(Context context) {
        String shortVideoSoPath = ShortVideoSoLoad.getShortVideoSoPath(context);
        File file = new File(shortVideoSoPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = shortVideoSoPath + "trim_process_pie";
        String str2 = shortVideoSoPath + VIDEO_COMPRESS_BIN_NAME;
        if (new File(str2).exists() && trimBinMd5Judge(str, str2)) {
            return true;
        }
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(str);
                try {
                    PrintLog("initTrimProcessFile [FileInputStream]");
                    boolean readInputStreamToFile = readInputStreamToFile(fileInputStream2, new byte[8192], str2);
                    PrintLog("initTrimProcessFile writeOK=" + readInputStreamToFile);
                    if (readInputStreamToFile) {
                        readInputStreamToFile = new File(str2).setExecutable(true, true);
                        PrintLog("initTrimProcessFile [setExecutable] writeOK=" + readInputStreamToFile);
                    }
                    try {
                        fileInputStream2.close();
                    } catch (IOException e16) {
                        e16.printStackTrace();
                    }
                    return readInputStreamToFile;
                } catch (Exception e17) {
                    e = e17;
                    fileInputStream = fileInputStream2;
                    e.printStackTrace();
                    PrintLog("initTrimProcessFile, exp=" + e.toString());
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                            return false;
                        } catch (IOException e18) {
                            e18.printStackTrace();
                            return false;
                        }
                    }
                    return false;
                } catch (Throwable th5) {
                    th = th5;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e19) {
                            e19.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e26) {
                e = e26;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static boolean initVideoTrim(Context context) {
        boolean initTrimProcessFile = initTrimProcessFile(context);
        if (initTrimProcessFile && VideoEnvironment.loadAVCodecSo() != 0) {
            return false;
        }
        return initTrimProcessFile;
    }

    private static boolean readInputStreamToFile(InputStream inputStream, byte[] bArr, String str) {
        int i3;
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(str);
                loop0: while (true) {
                    i3 = 0;
                    do {
                        try {
                            int read = inputStream.read(bArr, i3, bArr.length - i3);
                            if (read == -1) {
                                break loop0;
                            }
                            i3 += read;
                        } catch (IOException e16) {
                            e = e16;
                            fileOutputStream = fileOutputStream2;
                            e.printStackTrace();
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException unused) {
                                }
                            }
                            return false;
                        } catch (Throwable th5) {
                            th = th5;
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException unused2) {
                                }
                            }
                            throw th;
                        }
                    } while (i3 != bArr.length);
                    fileOutputStream2.write(bArr, 0, i3);
                }
                if (i3 != 0) {
                    fileOutputStream2.write(bArr, 0, i3);
                }
                try {
                    fileOutputStream2.close();
                    return true;
                } catch (IOException unused3) {
                    return true;
                }
            } catch (IOException e17) {
                e = e17;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static void setSoftwareCompressMode(Context context, VideoConverter videoConverter) {
        String shortVideoSoPath = ShortVideoSoLoad.getShortVideoSoPath(context);
        String shortVideoSoLibName = VideoEnvironment.getShortVideoSoLibName();
        videoConverter.setFFmpegBinAndSoPath(FFmpegFileUtils.getFFmpeg(context), shortVideoSoPath + shortVideoSoLibName, false);
        videoConverter.setCompressMode(2);
    }

    private static boolean trimBinMd5Judge(String str, String str2) {
        if (!new File(str).exists()) {
            return true;
        }
        byte[] fileMd5 = MD5.getFileMd5(str);
        byte[] fileMd52 = MD5.getFileMd5(str2);
        String bytes2HexStr = HexUtil.bytes2HexStr(fileMd5);
        String bytes2HexStr2 = HexUtil.bytes2HexStr(fileMd52);
        PrintLog("trimBinMd5Judge, pieMd5=" + bytes2HexStr + "  outMd5=" + bytes2HexStr2);
        if (!TextUtils.isEmpty(bytes2HexStr) && !TextUtils.isEmpty(bytes2HexStr2) && bytes2HexStr.equals(bytes2HexStr2)) {
            return true;
        }
        return false;
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class ProcessCallBack implements VideoConverter.Processor {
        @Override // com.tencent.richmedia.videocompress.VideoConverter.Processor
        public VideoConverterConfig getEncodeConfig(int i3, int i16) {
            return null;
        }

        @Override // com.tencent.richmedia.videocompress.VideoConverter.Processor
        public void onCancel() {
        }

        @Override // com.tencent.richmedia.videocompress.VideoConverter.Processor
        public void onSuccess() {
        }

        @Override // com.tencent.richmedia.videocompress.VideoConverter.Processor
        public void onFail(Throwable th5) {
        }

        @Override // com.tencent.richmedia.videocompress.VideoConverter.Processor
        public void onProgress(int i3) {
        }
    }
}
