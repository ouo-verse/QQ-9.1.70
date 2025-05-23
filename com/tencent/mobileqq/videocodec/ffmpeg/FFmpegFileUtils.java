package com.tencent.mobileqq.videocodec.ffmpeg;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.video.decode.ShortVideoSoLoad;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes20.dex */
public class FFmpegFileUtils {
    static IPatchRedirector $redirector_ = null;
    public static final String FFMPEG_BIN_FILE_NAME_PIC = "trim_process_pic";
    public static final String FFMPEG_BIN_FILE_NAME_PIE = "trim_process_pie";
    private static String s_binFilePath;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43345);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            s_binFilePath = null;
        }
    }

    public FFmpegFileUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String getAVCodecSoFilePath(Context context) {
        return ShortVideoSoLoad.getShortVideoSoPath(context) + VideoEnvironment.getShortVideoSoLibName();
    }

    public static String getFFmpeg(Context context) {
        int i3;
        if (TextUtils.isEmpty(s_binFilePath)) {
            File file = new File(context.getApplicationInfo().nativeLibraryDir, "/libtrim_process_pie.so");
            Throwable th5 = null;
            if (!file.exists()) {
                QLog.d("FFmpegFileUtils", 1, "fix bin file path nativeLibPath notExists: " + file.getAbsolutePath());
                i3 = 2;
                try {
                    file = new File((String) ClassLoader.class.getDeclaredMethod("findLibrary", String.class).invoke(FFmpegFileUtils.class.getClassLoader(), "trim_process_pie"));
                } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e16) {
                    th5 = e16;
                    QLog.e("FFmpegFileUtils", 1, "getFFmpeg exception. ", th5);
                }
            } else {
                i3 = 1;
            }
            if (!file.exists()) {
                i3++;
                QLog.d("FFmpegFileUtils", 1, "fix bin file path classLoaderLibPath notExists: " + file.getAbsolutePath());
                file = new File(new File(context.getPackageCodePath()).getParentFile(), "/lib/arm64/libtrim_process_pie.so");
            }
            if (!file.exists() || th5 != null) {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("scene", "FFmpegFileUtils");
                hashMap.put("step", i3 + "");
                hashMap.put("exists", file.exists() + "");
                if (th5 != null) {
                    hashMap.put("exception", th5.getClass().getSimpleName());
                }
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "ffmpeg_fix_bin_path", true, 0L, 0L, hashMap, null);
            }
            if (!file.exists()) {
                QLog.d("FFmpegFileUtils", 1, "fix bin file path use old path");
                return ShortVideoSoLoad.getShortVideoSoPath(context) + "trim_process_pie";
            }
            s_binFilePath = file.getAbsolutePath();
        }
        return s_binFilePath;
    }
}
