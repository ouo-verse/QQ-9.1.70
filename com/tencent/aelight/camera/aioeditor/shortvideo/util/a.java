package com.tencent.aelight.camera.aioeditor.shortvideo.util;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.videocodec.ffmpeg.FFmpegFileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.video.decode.ShortVideoSoLoad;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static String f67606a;

    public static String a(Context context) {
        return ShortVideoSoLoad.getShortVideoSoPath(context) + VideoEnvironment.getShortVideoSoLibName();
    }

    public static String b(Context context) {
        int i3;
        if (TextUtils.isEmpty(f67606a)) {
            File file = new File(context.getApplicationInfo().nativeLibraryDir, "/libtrim_process_pie.so");
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
                file = new File(new File(context.getPackageCodePath()).getParentFile(), "/lib/arm64/libtrim_process_pie.so");
            }
            if (!file.exists() || th5 != null) {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("scene", "FileFFmpegUtils");
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
            f67606a = file.getAbsolutePath();
        }
        return f67606a;
    }
}
