package cooperation.qzone.video;

import android.text.TextUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.videocodec.ffmpeg.FFmpegFileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.video.decode.ShortVideoSoLoad;
import cooperation.qzone.util.QZLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes38.dex */
public class QZoneVideoCompressor {
    private static final String FFMPEG_BIN_FILE_NAME_PIC = "trim_process_pic";
    private static final String FFMPEG_BIN_FILE_NAME_PIE = "trim_process_pie";
    private static final String LOGTAG = "QZoneVideoCompressor";
    private static ConcurrentHashMap<String, Process> processMap = new ConcurrentHashMap<>(8, 0.75f, 2);
    private static String s_binFilePath = null;

    public static void cancel(String str) {
        if (TextUtils.isEmpty(str)) {
            QZLog.w(LOGTAG, "cancel: key is empty!");
            return;
        }
        if (!processMap.containsKey(str)) {
            QZLog.w(LOGTAG, "cancel: process not exists or finished. key=" + str);
            return;
        }
        Process remove = processMap.remove(str);
        if (remove == null) {
            QZLog.w(LOGTAG, "cancel: process == null. key=" + str);
            return;
        }
        QZLog.i(LOGTAG, "cancel: killProcess. key=" + str);
        remove.destroy();
    }

    private static String getFFmpegPath() {
        int i3;
        if (TextUtils.isEmpty(s_binFilePath)) {
            File file = new File(BaseApplication.getContext().getApplicationInfo().nativeLibraryDir, "/libtrim_process_pie.so");
            Throwable th5 = null;
            if (file.exists()) {
                i3 = 1;
            } else {
                QLog.d("FFmpegFileUtils", 1, "fix bin file path nativeLibPath notExists: " + file.getAbsolutePath());
                i3 = 2;
                try {
                    file = new File((String) ClassLoader.class.getDeclaredMethod("findLibrary", String.class).invoke(FFmpegFileUtils.class.getClassLoader(), "trim_process_pie"));
                } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e16) {
                    th5 = e16;
                    QLog.e("FFmpegFileUtils", 1, "getFFmpeg exception. ", th5);
                }
            }
            if (!file.exists()) {
                i3++;
                QLog.d("FFmpegFileUtils", 1, "fix bin file path classLoaderLibPath notExists: " + file.getAbsolutePath());
                file = new File(new File(BaseApplication.getContext().getPackageCodePath()).getParentFile(), "/lib/arm64/libtrim_process_pie.so");
            }
            if (!file.exists() || th5 != null) {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("scene", LOGTAG);
                hashMap.put("step", i3 + "");
                hashMap.put("exists", file.exists() + "");
                if (th5 != null) {
                    hashMap.put("exception", th5.getClass().getSimpleName());
                }
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "ffmpeg_fix_bin_path", true, 0L, 0L, hashMap, null);
            }
            if (!file.exists()) {
                QLog.d("FFmpegFileUtils", 1, "fix bin file path use old path");
                return ShortVideoSoLoad.getShortVideoSoPath(BaseApplication.getContext()) + "trim_process_pie";
            }
            s_binFilePath = file.getAbsolutePath();
        }
        return s_binFilePath;
    }

    private static String getShortVideoSoFullPath() {
        return ShortVideoSoLoad.getShortVideoSoPath(BaseApplication.getContext()) + VideoEnvironment.getShortVideoSoLibName();
    }

    public static int trimByFFmpeg(String[] strArr) {
        return trimByFFmpeg(null, strArr);
    }

    public static int trimByFFmpeg(String str, String[] strArr) {
        int i3;
        try {
            try {
                setFileExecutable(new File(getFFmpegPath()));
                ArrayList arrayList = new ArrayList();
                arrayList.add(getFFmpegPath());
                arrayList.addAll(Arrays.asList(strArr));
                arrayList.add(getShortVideoSoFullPath());
                Process start = new ProcessBuilder(arrayList).redirectErrorStream(true).start();
                if (!TextUtils.isEmpty(str)) {
                    processMap.put(str, start);
                }
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(start.getInputStream()));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    if (QZLog.isDevelopLevel()) {
                        QZLog.i(LOGTAG, 4, readLine);
                    }
                }
                i3 = start.waitFor();
            } catch (InterruptedIOException unused) {
                QZLog.i(LOGTAG, "process is terminated. key=" + str);
                if (!TextUtils.isEmpty(str)) {
                    processMap.remove(str);
                }
                i3 = 0;
                QZLog.i(LOGTAG, 1, "trimByFFmpeg ret=" + i3);
                return i3;
            } catch (Throwable th5) {
                QZLog.e(LOGTAG, "trimByFFmpeg", th5);
                if (!TextUtils.isEmpty(str)) {
                    processMap.remove(str);
                }
                i3 = -1111;
                QZLog.i(LOGTAG, 1, "trimByFFmpeg ret=" + i3);
                return i3;
            }
            QZLog.i(LOGTAG, 1, "trimByFFmpeg ret=" + i3);
            return i3;
        } finally {
            if (!TextUtils.isEmpty(str)) {
                processMap.remove(str);
            }
        }
    }

    private static boolean setFileExecutable(File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        return file.canExecute() || file.setExecutable(true);
    }
}
