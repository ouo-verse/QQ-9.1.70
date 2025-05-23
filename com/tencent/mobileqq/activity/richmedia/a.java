package com.tencent.mobileqq.activity.richmedia;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.videocodec.ffmpeg.Argument;
import com.tencent.qqmini.miniapp.util.logmonitor.LogCmdOptions;
import com.tencent.qzonehub.api.utils.IQzoneVideoHelper;
import com.tencent.xweb.FileReaderHelper;
import cooperation.qzone.util.QZLog;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f185821a = EditLocalVideoActivity.J1 + File.separator + "silent.m4a";

    public static String a(long j3, long j16, String str) {
        if (!TextUtils.isEmpty(str) && new File(str).exists()) {
            String str2 = EditLocalVideoActivity.J1 + File.separator + "clipped." + i(str, FileReaderHelper.M4A_EXT);
            int trimByFFmpeg = ((IQzoneVideoHelper) QRoute.api(IQzoneVideoHelper.class)).trimByFFmpeg(new String[]{"-y", Argument.FILE_INPUT, str, Argument.START_TIME, j(j3), Argument.DURATION, j(j16), LogCmdOptions.CLEAR, "copy", str2});
            if (trimByFFmpeg != 0) {
                QZLog.e("EditLocalVideoMusicMixH", 2, "ffmpegClipAudio: FFmpeg run failed with " + trimByFFmpeg);
                return null;
            }
            return str2;
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x012e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0133 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(List<String> list) {
        BufferedWriter bufferedWriter;
        int trimByFFmpeg;
        BufferedWriter bufferedWriter2 = null;
        if (list == null) {
            return null;
        }
        if (list.size() == 1) {
            return list.get(0);
        }
        String str = EditLocalVideoActivity.J1 + File.separator + "config.txt";
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(str)));
        } catch (Exception e16) {
            e = e16;
            bufferedWriter = null;
        } catch (Throwable th5) {
            th = th5;
            if (bufferedWriter2 != null) {
            }
            throw th;
        }
        try {
            try {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    bufferedWriter.write("file '" + new File(it.next()).getAbsolutePath() + "'");
                    bufferedWriter.newLine();
                }
                bufferedWriter.flush();
                try {
                    bufferedWriter.close();
                } catch (IOException e17) {
                    QZLog.e("EditLocalVideoMusicMixH", 2, e17, new Object[0]);
                }
            } catch (Throwable th6) {
                th = th6;
                bufferedWriter2 = bufferedWriter;
                if (bufferedWriter2 != null) {
                    try {
                        bufferedWriter2.close();
                    } catch (IOException e18) {
                        QZLog.e("EditLocalVideoMusicMixH", 2, e18, new Object[0]);
                    }
                }
                throw th;
            }
        } catch (Exception e19) {
            e = e19;
            QZLog.e("EditLocalVideoMusicMixH", 2, e, new Object[0]);
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e26) {
                    QZLog.e("EditLocalVideoMusicMixH", 2, e26, new Object[0]);
                }
            }
            String str2 = EditLocalVideoActivity.J1 + File.separator + UUID.randomUUID() + ".m4a";
            trimByFFmpeg = ((IQzoneVideoHelper) QRoute.api(IQzoneVideoHelper.class)).trimByFFmpeg(new String[]{"-y", "-f", Argument.CONCAT, "-safe", "0", Argument.FILE_INPUT, str, LogCmdOptions.CLEAR, "copy", str2});
            if (new File(str).delete()) {
            }
            if (trimByFFmpeg == 0) {
            }
        }
        String str22 = EditLocalVideoActivity.J1 + File.separator + UUID.randomUUID() + ".m4a";
        trimByFFmpeg = ((IQzoneVideoHelper) QRoute.api(IQzoneVideoHelper.class)).trimByFFmpeg(new String[]{"-y", "-f", Argument.CONCAT, "-safe", "0", Argument.FILE_INPUT, str, LogCmdOptions.CLEAR, "copy", str22});
        if (new File(str).delete()) {
            Log.d("EditLocalVideoMusicMixH", "ffmpegConcatAudio: delete config file");
        }
        if (trimByFFmpeg == 0) {
            QZLog.e("EditLocalVideoMusicMixH", 2, "ffmpegConcatAudio: FFmpeg run failed with " + trimByFFmpeg);
            return null;
        }
        return str22;
    }

    public static String c(String str) {
        if (str == null || !new File(str).exists()) {
            return null;
        }
        if (str.endsWith(FileReaderHelper.M4A_EXT)) {
            return str;
        }
        String str2 = EditLocalVideoActivity.J1 + File.separator + "converted.m4a";
        int trimByFFmpeg = ((IQzoneVideoHelper) QRoute.api(IQzoneVideoHelper.class)).trimByFFmpeg(new String[]{"-y", Argument.FILE_INPUT, str, "-c:a", FileReaderHelper.AAC_EXT, str2});
        if (trimByFFmpeg != 0) {
            QZLog.e("EditLocalVideoMusicMixH", 2, "ffmpegConvert2AAC: FFmpeg run failed with " + trimByFFmpeg);
            return null;
        }
        return str2;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x011a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x011f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String d(long j3, String str, long j16) {
        BufferedWriter bufferedWriter;
        int trimByFFmpeg;
        String str2 = EditLocalVideoActivity.J1 + File.separator + "garbage_concat_config.txt";
        int i3 = (int) ((j3 / j16) + 1);
        BufferedWriter bufferedWriter2 = null;
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(str2)));
            for (int i16 = 0; i16 < i3; i16++) {
                try {
                    try {
                        bufferedWriter.write("file '" + new File(str).getAbsolutePath() + "'");
                        bufferedWriter.newLine();
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedWriter2 = bufferedWriter;
                        if (bufferedWriter2 != null) {
                            try {
                                bufferedWriter2.close();
                            } catch (IOException e16) {
                                QZLog.e("EditLocalVideoMusicMixH", 2, e16, new Object[0]);
                            }
                        }
                        throw th;
                    }
                } catch (Exception e17) {
                    e = e17;
                    QZLog.e("EditLocalVideoMusicMixH", 2, e, new Object[0]);
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.close();
                        } catch (IOException e18) {
                            QZLog.e("EditLocalVideoMusicMixH", 2, e18, new Object[0]);
                        }
                    }
                    IQzoneVideoHelper iQzoneVideoHelper = (IQzoneVideoHelper) QRoute.api(IQzoneVideoHelper.class);
                    String str3 = f185821a;
                    trimByFFmpeg = iQzoneVideoHelper.trimByFFmpeg(new String[]{"-y", "-f", Argument.CONCAT, "-safe", "0", Argument.FILE_INPUT, str2, Argument.DURATION, j(j3), LogCmdOptions.CLEAR, "copy", str3});
                    if (new File(str2).delete()) {
                    }
                    if (trimByFFmpeg == 0) {
                    }
                }
            }
            bufferedWriter.flush();
            try {
                bufferedWriter.close();
            } catch (IOException e19) {
                QZLog.e("EditLocalVideoMusicMixH", 2, e19, new Object[0]);
            }
        } catch (Exception e26) {
            e = e26;
            bufferedWriter = null;
        } catch (Throwable th6) {
            th = th6;
            if (bufferedWriter2 != null) {
            }
            throw th;
        }
        IQzoneVideoHelper iQzoneVideoHelper2 = (IQzoneVideoHelper) QRoute.api(IQzoneVideoHelper.class);
        String str32 = f185821a;
        trimByFFmpeg = iQzoneVideoHelper2.trimByFFmpeg(new String[]{"-y", "-f", Argument.CONCAT, "-safe", "0", Argument.FILE_INPUT, str2, Argument.DURATION, j(j3), LogCmdOptions.CLEAR, "copy", str32});
        if (new File(str2).delete()) {
            QZLog.d("EditLocalVideoMusicMixH", 2, "ffmpegCreateGarbageSound() delete file " + str2);
        }
        if (trimByFFmpeg == 0) {
            QZLog.e("EditLocalVideoMusicMixH", 2, "ffmpegCreateGarbageSound: FFmpeg run failed with " + trimByFFmpeg);
            return null;
        }
        return str32;
    }

    public static String e(String str, String str2, long j3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String str3 = EditLocalVideoActivity.J1 + File.separator + "merged_" + UUID.randomUUID().toString() + ".mp4";
            String[] strArr = {"-y", Argument.FILE_INPUT, str, Argument.FILE_INPUT, str2, Argument.DURATION, j(j3), "-codec", "copy", "-map", "0:v:0", "-map", "1:a", str3};
            QZLog.d("EditLocalVideoMusicMixH", 2, "ffmpegMergeVideoAndAudio: " + Arrays.toString(strArr));
            int trimByFFmpeg = ((IQzoneVideoHelper) QRoute.api(IQzoneVideoHelper.class)).trimByFFmpeg(strArr);
            if (trimByFFmpeg != 0) {
                QZLog.e("EditLocalVideoMusicMixH", 2, "ffmpegMergeVideoAndAudio: FFmpeg run failed with code " + trimByFFmpeg);
                return null;
            }
            return str3;
        }
        QZLog.e("EditLocalVideoMusicMixH", 2, "ffmpegMergeVideoAndAudio: input video/audio is empty " + str + " " + str2);
        return null;
    }

    public static String f(String str) {
        if (!TextUtils.isEmpty(str) && new File(str).exists()) {
            String str2 = EditLocalVideoActivity.J1 + File.separator + UUID.randomUUID().toString() + "_an." + i(str, "mp4");
            int trimByFFmpeg = ((IQzoneVideoHelper) QRoute.api(IQzoneVideoHelper.class)).trimByFFmpeg(new String[]{"-y", Argument.FILE_INPUT, str, "-an", LogCmdOptions.CLEAR, "copy", str2});
            if (trimByFFmpeg != 0) {
                QZLog.e("EditLocalVideoMusicMixH", 2, "ffmpegRemoveAudioTrack: FFmpeg run failed with code " + trimByFFmpeg);
                return str;
            }
            return str2;
        }
        return str;
    }

    public static String g(String str) {
        if (str != null && new File(str).exists()) {
            String str2 = EditLocalVideoActivity.J1 + File.separator + "converted_no_video." + i(str, FileReaderHelper.M4A_EXT);
            int trimByFFmpeg = ((IQzoneVideoHelper) QRoute.api(IQzoneVideoHelper.class)).trimByFFmpeg(new String[]{"-y", Argument.FILE_INPUT, str, "-vn", LogCmdOptions.CLEAR, "copy", "-map", "0:a:0", str2});
            if (trimByFFmpeg != 0) {
                QZLog.e("EditLocalVideoMusicMixH", 2, "ffmpegRemoveVideoTrack: FFmpeg run failed with " + trimByFFmpeg);
                return null;
            }
            return str2;
        }
        return str;
    }

    public static String h(String str, int i3) {
        if (i3 >= 2) {
            ArrayList arrayList = new ArrayList();
            for (int i16 = 0; i16 < i3; i16++) {
                arrayList.add(str);
            }
            return b(arrayList);
        }
        return str;
    }

    @NonNull
    private static String i(String str, String str2) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf > 0) {
            return str.substring(lastIndexOf + 1);
        }
        return str2;
    }

    private static String j(long j3) {
        return String.format(Locale.getDefault(), "%.3f", Float.valueOf(((float) j3) / 1000.0f));
    }
}
