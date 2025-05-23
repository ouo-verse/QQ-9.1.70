package com.tencent.richmedia.videocompress.converter;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.videocodec.ffmpeg.Argument;
import com.tencent.qqmini.miniapp.util.logmonitor.LogCmdOptions;
import com.tencent.richmedia.videocompress.VideoConverterConfig;
import com.tencent.richmedia.videocompress.utils.ConvertLog;
import com.tencent.richmedia.videocompress.utils.a;
import com.tencent.xweb.FileReaderHelper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes25.dex */
public class SoftwareConverter {
    public static final String TAG = "SoftwareConverter";
    private static String ffmpegBinFullPath;
    private static String ffmpegSoFullPath;
    private static int sCpuCores;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface ProcessCallBack {
        VideoConverterConfig getEncodeConfig();

        void onDestroy();

        void onStart(Process process);

        void onStop();
    }

    public static int compressVideo(String str, ProcessCallBack processCallBack) {
        VideoConverterConfig encodeConfig = processCallBack.getEncodeConfig();
        if (!encodeConfig.isNeedCompress) {
            if (ConvertLog.isColorLevel()) {
                ConvertLog.d(TAG, 2, "compressVideo error, isNeedCompress is false");
                return -1;
            }
            return -1;
        }
        File file = new File(encodeConfig.output);
        if (file.exists()) {
            ConvertLog.i(TAG, 1, "compressVideo, output path exists, delete it, path is " + file.getAbsolutePath() + ", delete=" + file.delete());
        }
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            ConvertLog.i(TAG, 1, "compressVideo, output directory doesn't exist, path is " + file.getAbsolutePath() + ", mkdir=" + parentFile.mkdirs());
        }
        int executeFFmpegCmd = executeFFmpegCmd(generateCommand(str, encodeConfig.output, encodeConfig), processCallBack);
        if (executeFFmpegCmd != 0) {
            try {
                File file2 = new File(encodeConfig.output);
                if (file2.exists()) {
                    file2.delete();
                    if (ConvertLog.isColorLevel()) {
                        ConvertLog.d(TAG, 2, "compressVideo, delete video, ret=", Integer.valueOf(executeFFmpegCmd));
                    }
                }
            } catch (Exception e16) {
                ConvertLog.e(TAG, 1, "compressVideo, delete video exception", e16);
            }
        }
        return executeFFmpegCmd;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x018d A[Catch: IOException -> 0x0183, TRY_LEAVE, TryCatch #5 {IOException -> 0x0183, blocks: (B:107:0x017f, B:98:0x0188, B:100:0x018d), top: B:106:0x017f }] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x017f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x015d A[Catch: IOException -> 0x0157, TryCatch #13 {IOException -> 0x0157, blocks: (B:128:0x0153, B:121:0x015d, B:123:0x0162), top: B:127:0x0153 }] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0162 A[Catch: IOException -> 0x0157, TRY_LEAVE, TryCatch #13 {IOException -> 0x0157, blocks: (B:128:0x0153, B:121:0x015d, B:123:0x0162), top: B:127:0x0153 }] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0153 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0216 A[Catch: IOException -> 0x0211, TryCatch #17 {IOException -> 0x0211, blocks: (B:62:0x020d, B:51:0x0216, B:53:0x021b), top: B:61:0x020d }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x021b A[Catch: IOException -> 0x0211, TRY_LEAVE, TryCatch #17 {IOException -> 0x0211, blocks: (B:62:0x020d, B:51:0x0216, B:53:0x021b), top: B:61:0x020d }] */
    /* JADX WARN: Removed duplicated region for block: B:60:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x020d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01bf A[Catch: IOException -> 0x01ba, TryCatch #0 {IOException -> 0x01ba, blocks: (B:87:0x01b6, B:76:0x01bf, B:78:0x01c4), top: B:86:0x01b6 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01c4 A[Catch: IOException -> 0x01ba, TRY_LEAVE, TryCatch #0 {IOException -> 0x01ba, blocks: (B:87:0x01b6, B:76:0x01bf, B:78:0x01c4), top: B:86:0x01b6 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01b6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0188 A[Catch: IOException -> 0x0183, TryCatch #5 {IOException -> 0x0183, blocks: (B:107:0x017f, B:98:0x0188, B:100:0x018d), top: B:106:0x017f }] */
    /* JADX WARN: Type inference failed for: r12v10, types: [java.lang.Process] */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v13, types: [java.lang.Process] */
    /* JADX WARN: Type inference failed for: r12v32 */
    /* JADX WARN: Type inference failed for: r12v34 */
    /* JADX WARN: Type inference failed for: r12v40, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v45 */
    /* JADX WARN: Type inference failed for: r12v46 */
    /* JADX WARN: Type inference failed for: r12v49 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v50 */
    /* JADX WARN: Type inference failed for: r5v14, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v19, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r5v38 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v40 */
    /* JADX WARN: Type inference failed for: r5v49, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r5v50 */
    /* JADX WARN: Type inference failed for: r5v51 */
    /* JADX WARN: Type inference failed for: r5v56 */
    /* JADX WARN: Type inference failed for: r5v57 */
    /* JADX WARN: Type inference failed for: r5v60 */
    /* JADX WARN: Type inference failed for: r5v61 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int executeFFmpegCmd(List<String> list, ProcessCallBack processCallBack) {
        Throwable th5;
        InputStreamReader inputStreamReader;
        int i3;
        Process process;
        boolean z16;
        Process process2;
        InputStreamReader inputStreamReader2;
        Process process3;
        boolean z17;
        Process process4;
        ?? r122;
        BufferedReader bufferedReader;
        InputStream inputStream;
        int i16;
        Process process5;
        InputStreamReader inputStreamReader3;
        int i17;
        Process process6;
        InputStreamReader inputStreamReader4;
        Process start;
        Process process7;
        InputStreamReader inputStreamReader5;
        Process process8;
        InputStreamReader inputStreamReader6;
        Process process9;
        InputStreamReader inputStreamReader7;
        Process process10;
        InputStreamReader inputStreamReader8;
        InputStreamReader inputStreamReader9;
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        arrayList.add(ffmpegBinFullPath);
        arrayList.addAll(list);
        arrayList.add(ffmpegSoFullPath);
        boolean isColorLevel = ConvertLog.isColorLevel();
        int i18 = 3;
        int i19 = 1;
        ?? r56 = isColorLevel;
        if (isColorLevel) {
            r122 = ffmpegSoFullPath;
            ?? r57 = {"compressVideo, bin Path:", ffmpegBinFullPath, " so path:", r122};
            ConvertLog.d(TAG, 2, r57);
            r56 = r57;
        }
        try {
            try {
                start = new ProcessBuilder(arrayList).redirectErrorStream(true).start();
                if (processCallBack != null) {
                    try {
                        processCallBack.onStart(start);
                    } catch (IOException e16) {
                        e = e16;
                        process4 = start;
                        z17 = false;
                        bufferedReader = null;
                        inputStream = null;
                        r56 = z17;
                        r122 = process4;
                        i18 = -1001;
                        ConvertLog.e(TAG, 1, "compressVideo IOException, ", e);
                        if (processCallBack != null) {
                        }
                        if (r122 != 0) {
                        }
                        if (inputStream != null) {
                        }
                        if (r56 != 0) {
                        }
                        if (bufferedReader != null) {
                        }
                        i17 = i18;
                        ConvertLog.d(TAG, 2, "Convert video completed, cost ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), "ms, ret=", Integer.valueOf(i17), " compressMode:soft");
                        return i17;
                    } catch (InterruptedException e17) {
                        e = e17;
                        process3 = start;
                        inputStreamReader2 = null;
                        bufferedReader = null;
                        inputStream = null;
                        inputStreamReader3 = inputStreamReader2;
                        process5 = process3;
                        try {
                            ConvertLog.e(TAG, 1, "compressVideo InterruptedException, ", e);
                            if (processCallBack != null) {
                            }
                            if (process5 != null) {
                            }
                            if (inputStream != null) {
                            }
                            if (inputStreamReader3 != null) {
                            }
                            if (bufferedReader != null) {
                            }
                            i17 = -1002;
                            ConvertLog.d(TAG, 2, "Convert video completed, cost ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), "ms, ret=", Integer.valueOf(i17), " compressMode:soft");
                            return i17;
                        } catch (Throwable th6) {
                            th5 = th6;
                            i3 = -1002;
                            inputStreamReader4 = inputStreamReader3;
                            process6 = process5;
                            if (processCallBack != null) {
                            }
                            if (process6 != null) {
                            }
                            if (inputStream != null) {
                            }
                            if (inputStreamReader4 != null) {
                            }
                            if (bufferedReader == null) {
                            }
                        }
                    } catch (Exception e18) {
                        e = e18;
                        process2 = start;
                        z16 = false;
                        bufferedReader = null;
                        inputStream = null;
                        r56 = z16;
                        r122 = process2;
                        i18 = -1003;
                        ConvertLog.e(TAG, 1, "compressVideo exception, ", e);
                        if (processCallBack != null) {
                        }
                        if (r122 != 0) {
                        }
                        if (inputStream != null) {
                        }
                        if (r56 != 0) {
                        }
                        if (bufferedReader != null) {
                        }
                        i17 = i18;
                        ConvertLog.d(TAG, 2, "Convert video completed, cost ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), "ms, ret=", Integer.valueOf(i17), " compressMode:soft");
                        return i17;
                    } catch (Throwable th7) {
                        th5 = th7;
                        process = start;
                        inputStreamReader = null;
                        i3 = -9999;
                        bufferedReader = null;
                        inputStream = null;
                        inputStreamReader4 = inputStreamReader;
                        process6 = process;
                        if (processCallBack != null) {
                        }
                        if (process6 != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (inputStreamReader4 != null) {
                        }
                        if (bufferedReader == null) {
                        }
                    }
                }
                inputStream = start.getInputStream();
                try {
                    inputStreamReader9 = new InputStreamReader(inputStream);
                } catch (IOException e19) {
                    e = e19;
                    process10 = start;
                    inputStreamReader8 = null;
                } catch (InterruptedException e26) {
                    e = e26;
                    process9 = start;
                    inputStreamReader7 = null;
                } catch (Exception e27) {
                    e = e27;
                    process8 = start;
                    inputStreamReader6 = null;
                } catch (Throwable th8) {
                    th5 = th8;
                    process7 = start;
                    inputStreamReader5 = null;
                }
            } catch (IOException e28) {
                e = e28;
                z17 = false;
                process4 = null;
            } catch (InterruptedException e29) {
                e = e29;
                inputStreamReader2 = null;
                process3 = null;
            } catch (Exception e36) {
                e = e36;
                z16 = false;
                process2 = null;
            } catch (Throwable th9) {
                th5 = th9;
                inputStreamReader = null;
                i3 = -9999;
                process = null;
            }
            try {
                bufferedReader = new BufferedReader(inputStreamReader9);
                try {
                    try {
                        start.waitFor();
                        i3 = start.exitValue();
                    } catch (IOException e37) {
                        e = e37;
                        r56 = inputStreamReader9;
                        r122 = start;
                        i18 = -1001;
                        ConvertLog.e(TAG, 1, "compressVideo IOException, ", e);
                        if (processCallBack != null) {
                            processCallBack.onDestroy();
                        }
                        if (r122 != 0) {
                            r122.destroy();
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e38) {
                                e = e38;
                                i16 = 1;
                                ConvertLog.e(TAG, i16, "compressVideo close streams, ", e);
                                i17 = i18;
                                ConvertLog.d(TAG, 2, "Convert video completed, cost ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), "ms, ret=", Integer.valueOf(i17), " compressMode:soft");
                                return i17;
                            }
                        }
                        if (r56 != 0) {
                            r56.close();
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        i17 = i18;
                        ConvertLog.d(TAG, 2, "Convert video completed, cost ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), "ms, ret=", Integer.valueOf(i17), " compressMode:soft");
                        return i17;
                    } catch (InterruptedException e39) {
                        e = e39;
                        inputStreamReader3 = inputStreamReader9;
                        process5 = start;
                        ConvertLog.e(TAG, 1, "compressVideo InterruptedException, ", e);
                        if (processCallBack != null) {
                            processCallBack.onStop();
                        }
                        if (process5 != null) {
                            process5.destroy();
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e46) {
                                ConvertLog.e(TAG, 1, "compressVideo close streams, ", e46);
                                i17 = -1002;
                                ConvertLog.d(TAG, 2, "Convert video completed, cost ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), "ms, ret=", Integer.valueOf(i17), " compressMode:soft");
                                return i17;
                            }
                        }
                        if (inputStreamReader3 != null) {
                            inputStreamReader3.close();
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        i17 = -1002;
                        ConvertLog.d(TAG, 2, "Convert video completed, cost ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), "ms, ret=", Integer.valueOf(i17), " compressMode:soft");
                        return i17;
                    } catch (Exception e47) {
                        e = e47;
                        r56 = inputStreamReader9;
                        r122 = start;
                        i18 = -1003;
                        ConvertLog.e(TAG, 1, "compressVideo exception, ", e);
                        if (processCallBack != null) {
                            processCallBack.onDestroy();
                        }
                        if (r122 != 0) {
                            r122.destroy();
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e48) {
                                e = e48;
                                i16 = 1;
                                ConvertLog.e(TAG, i16, "compressVideo close streams, ", e);
                                i17 = i18;
                                ConvertLog.d(TAG, 2, "Convert video completed, cost ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), "ms, ret=", Integer.valueOf(i17), " compressMode:soft");
                                return i17;
                            }
                        }
                        if (r56 != 0) {
                            r56.close();
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        i17 = i18;
                        ConvertLog.d(TAG, 2, "Convert video completed, cost ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), "ms, ret=", Integer.valueOf(i17), " compressMode:soft");
                        return i17;
                    }
                } catch (Throwable th10) {
                    th5 = th10;
                    inputStreamReader4 = inputStreamReader9;
                    process6 = start;
                    i3 = -9999;
                }
            } catch (IOException e49) {
                e = e49;
                inputStreamReader8 = inputStreamReader9;
                process10 = start;
                bufferedReader = null;
                r56 = inputStreamReader8;
                r122 = process10;
                i18 = -1001;
                ConvertLog.e(TAG, 1, "compressVideo IOException, ", e);
                if (processCallBack != null) {
                }
                if (r122 != 0) {
                }
                if (inputStream != null) {
                }
                if (r56 != 0) {
                }
                if (bufferedReader != null) {
                }
                i17 = i18;
                ConvertLog.d(TAG, 2, "Convert video completed, cost ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), "ms, ret=", Integer.valueOf(i17), " compressMode:soft");
                return i17;
            } catch (InterruptedException e56) {
                e = e56;
                inputStreamReader7 = inputStreamReader9;
                process9 = start;
                bufferedReader = null;
                inputStreamReader3 = inputStreamReader7;
                process5 = process9;
                ConvertLog.e(TAG, 1, "compressVideo InterruptedException, ", e);
                if (processCallBack != null) {
                }
                if (process5 != null) {
                }
                if (inputStream != null) {
                }
                if (inputStreamReader3 != null) {
                }
                if (bufferedReader != null) {
                }
                i17 = -1002;
                ConvertLog.d(TAG, 2, "Convert video completed, cost ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), "ms, ret=", Integer.valueOf(i17), " compressMode:soft");
                return i17;
            } catch (Exception e57) {
                e = e57;
                inputStreamReader6 = inputStreamReader9;
                process8 = start;
                bufferedReader = null;
                r56 = inputStreamReader6;
                r122 = process8;
                i18 = -1003;
                ConvertLog.e(TAG, 1, "compressVideo exception, ", e);
                if (processCallBack != null) {
                }
                if (r122 != 0) {
                }
                if (inputStream != null) {
                }
                if (r56 != 0) {
                }
                if (bufferedReader != null) {
                }
                i17 = i18;
                ConvertLog.d(TAG, 2, "Convert video completed, cost ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), "ms, ret=", Integer.valueOf(i17), " compressMode:soft");
                return i17;
            } catch (Throwable th11) {
                th5 = th11;
                inputStreamReader5 = inputStreamReader9;
                process7 = start;
                i3 = -9999;
                bufferedReader = null;
                inputStreamReader4 = inputStreamReader5;
                process6 = process7;
                if (processCallBack != null) {
                }
                if (process6 != null) {
                }
                if (inputStream != null) {
                }
                if (inputStreamReader4 != null) {
                }
                if (bufferedReader == null) {
                }
            }
            try {
                ConvertLog.d(TAG, 2, "compressVideo :ret=" + i3);
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    Object[] objArr = new Object[i19];
                    objArr[0] = "compressVideo log:" + readLine;
                    ConvertLog.d(TAG, 2, objArr);
                    i19 = 1;
                }
                int i26 = i19;
                Object[] objArr2 = new Object[i26];
                objArr2[0] = "compressVideo destroy OK.";
                ConvertLog.d(TAG, i26, objArr2);
                if (processCallBack != null) {
                    if (i3 == -1002) {
                        processCallBack.onStop();
                    } else {
                        processCallBack.onDestroy();
                    }
                }
                start.destroy();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e58) {
                        ConvertLog.e(TAG, 1, "compressVideo close streams, ", e58);
                    }
                }
                inputStreamReader9.close();
                bufferedReader.close();
                i17 = i3;
                ConvertLog.d(TAG, 2, "Convert video completed, cost ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), "ms, ret=", Integer.valueOf(i17), " compressMode:soft");
                return i17;
            } catch (Throwable th12) {
                th5 = th12;
                inputStreamReader4 = inputStreamReader9;
                process6 = start;
                if (processCallBack != null) {
                    if (i3 == -1002) {
                        processCallBack.onStop();
                    } else {
                        processCallBack.onDestroy();
                    }
                }
                if (process6 != null) {
                    process6.destroy();
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e59) {
                        ConvertLog.e(TAG, 1, "compressVideo close streams, ", e59);
                        throw th5;
                    }
                }
                if (inputStreamReader4 != null) {
                    inputStreamReader4.close();
                }
                if (bufferedReader == null) {
                    bufferedReader.close();
                    throw th5;
                }
                throw th5;
            }
        } catch (Throwable th13) {
            th5 = th13;
            i3 = i18;
            inputStreamReader4 = r56;
            process6 = r122;
        }
    }

    private static List<String> generateCommand(String str, String str2, VideoConverterConfig videoConverterConfig) {
        int threadNum = getThreadNum();
        String resolution = getResolution(videoConverterConfig);
        if (ConvertLog.isColorLevel()) {
            ConvertLog.d(TAG, 2, "generateCommand threads=" + threadNum + "  resolution=" + resolution);
        }
        a aVar = new a();
        aVar.a(LogCmdOptions.DUMP);
        aVar.a("-y");
        aVar.b("-threads", threadNum);
        aVar.a("-copyts");
        aVar.d("-copytb", "0");
        aVar.d(Argument.FILE_INPUT, str);
        if (videoConverterConfig.isMute) {
            aVar.a("-an");
        } else {
            aVar.d(Argument.AUDIO_CODEC, FileReaderHelper.AAC_EXT);
        }
        aVar.d(Argument.VIDEO_CODEC, "libo264rt");
        aVar.d("-bufsize", "2000K");
        int i3 = videoConverterConfig.videoFrameRate;
        if (i3 > 0) {
            aVar.b("-r", i3);
        }
        VideoConverterConfig.SoftwareConfig softwareConfig = videoConverterConfig.softwareConfig;
        if (softwareConfig == null) {
            softwareConfig = VideoConverterConfig.SoftwareConfig.H264_DEFAULT;
        }
        if (softwareConfig.getMinRateKbps() > 0) {
            aVar.d("-minrate", softwareConfig.getMinRateKbps() + "k");
        }
        if (softwareConfig.getMaxRateKbps() > 0) {
            aVar.d("-maxrate", softwareConfig.getMaxRateKbps() + "k");
        }
        if (videoConverterConfig.softwareConfig != null) {
            aVar.c("-crf", softwareConfig.getCrf(), 25);
        } else if (videoConverterConfig.videoBitRate > 0) {
            aVar.d("-b", videoConverterConfig.videoBitRate + "k");
        } else if (videoConverterConfig.destQmax > 0) {
            aVar.d("-maxrate", "600k");
        } else {
            aVar.b("-crf", 25);
        }
        aVar.d("-s", resolution);
        aVar.d("-movflags", "faststart");
        aVar.a(str2);
        ConvertLog.i(TAG, 1, "compress command:" + aVar.e());
        return aVar.e();
    }

    public static int getCpuCores() {
        if (sCpuCores == 0) {
            try {
                File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new FileFilter() { // from class: com.tencent.richmedia.videocompress.converter.SoftwareConverter.1CpuFilter
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

    @NonNull
    private static String getResolution(VideoConverterConfig videoConverterConfig) {
        String str = videoConverterConfig.destWidth + HippyTKDListViewAdapter.X + videoConverterConfig.destHeight;
        try {
            int parseInt = Integer.parseInt(videoConverterConfig.rotate) % 180;
            if (parseInt == 90 || parseInt == -90) {
                return videoConverterConfig.destHeight + HippyTKDListViewAdapter.X + videoConverterConfig.destWidth;
            }
            return str;
        } catch (NumberFormatException unused) {
            ConvertLog.w(TAG, 1, "getResolution, invalid rotation, " + videoConverterConfig.rotate);
            return str;
        }
    }

    private static int getThreadNum() {
        if (getCpuCores() >= 8) {
            return 4;
        }
        if (getCpuCores() >= 2) {
            return 2;
        }
        return 1;
    }

    public static void setFFmpegBinAndSoPath(String str, String str2) {
        ffmpegBinFullPath = str;
        ffmpegSoFullPath = str2;
    }

    public static boolean supportCodec() {
        boolean z16;
        boolean z17;
        if (!TextUtils.isEmpty(ffmpegBinFullPath) && new File(ffmpegBinFullPath).exists()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!TextUtils.isEmpty(ffmpegSoFullPath) && new File(ffmpegSoFullPath).exists()) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 && z17) {
            return true;
        }
        return false;
    }
}
