package com.tencent.aelight.camera.aioeditor.shortvideo.util;

import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.media.MediaMuxer;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.videocodec.ffmpeg.Argument;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.miniapp.util.logmonitor.LogCmdOptions;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private String f67607a;

    /* renamed from: b, reason: collision with root package name */
    private String f67608b;

    /* renamed from: c, reason: collision with root package name */
    private MediaExtractor f67609c;

    /* renamed from: d, reason: collision with root package name */
    private MediaExtractor f67610d;

    /* renamed from: e, reason: collision with root package name */
    private int f67611e;

    /* renamed from: f, reason: collision with root package name */
    private int f67612f;

    /* renamed from: g, reason: collision with root package name */
    private MediaMuxer f67613g;

    /* renamed from: h, reason: collision with root package name */
    private C0586b f67614h = new C0586b();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private InputStream f67615a = null;

        /* renamed from: b, reason: collision with root package name */
        private InputStreamReader f67616b = null;

        /* renamed from: c, reason: collision with root package name */
        private BufferedReader f67617c = null;

        /* renamed from: d, reason: collision with root package name */
        public Process f67618d = null;

        a() {
        }

        public void a() {
            Process process = this.f67618d;
            if (process != null) {
                this.f67615a = process.getInputStream();
                this.f67616b = new InputStreamReader(this.f67615a);
                this.f67617c = new BufferedReader(this.f67616b);
            }
        }

        public void b() {
            BufferedReader bufferedReader;
            if (this.f67618d != null) {
                while (true) {
                    try {
                        try {
                            String readLine = this.f67617c.readLine();
                            if (readLine == null) {
                                break;
                            }
                            b.b("[@] compressVideo log:" + readLine, null);
                        } catch (IOException unused) {
                            InputStream inputStream = this.f67615a;
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            InputStreamReader inputStreamReader = this.f67616b;
                            if (inputStreamReader != null) {
                                inputStreamReader.close();
                            }
                            bufferedReader = this.f67617c;
                            if (bufferedReader == null) {
                                return;
                            }
                        } catch (Throwable th5) {
                            try {
                                InputStream inputStream2 = this.f67615a;
                                if (inputStream2 != null) {
                                    inputStream2.close();
                                }
                                InputStreamReader inputStreamReader2 = this.f67616b;
                                if (inputStreamReader2 != null) {
                                    inputStreamReader2.close();
                                }
                                BufferedReader bufferedReader2 = this.f67617c;
                                if (bufferedReader2 != null) {
                                    bufferedReader2.close();
                                }
                            } catch (IOException unused2) {
                            }
                            throw th5;
                        }
                    } catch (IOException unused3) {
                        return;
                    }
                }
                InputStream inputStream3 = this.f67615a;
                if (inputStream3 != null) {
                    inputStream3.close();
                }
                InputStreamReader inputStreamReader3 = this.f67616b;
                if (inputStreamReader3 != null) {
                    inputStreamReader3.close();
                }
                bufferedReader = this.f67617c;
                if (bufferedReader == null) {
                    return;
                }
                bufferedReader.close();
            }
        }
    }

    public b(String str, String str2) {
        this.f67607a = str;
        this.f67608b = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str, Throwable th5) {
        if (QLog.isColorLevel()) {
            if (th5 != null) {
                QLog.d("HwVideoMerge", 2, str, th5);
            } else {
                QLog.d("HwVideoMerge", 2, str);
            }
        }
    }

    private int c() {
        this.f67614h.f67619a.position(0);
        if (this.f67609c.readSampleData(this.f67614h.f67619a, 0) <= 0) {
            o();
            return -5;
        }
        this.f67614h.f67619a.position(0);
        if (this.f67610d.readSampleData(this.f67614h.f67619a, 0) > 0) {
            return 0;
        }
        o();
        return -6;
    }

    private final MediaExtractor e(String str) {
        MediaExtractor mediaExtractor;
        IOException e16;
        if (!d(str)) {
            return null;
        }
        MediaExtractor mediaExtractor2 = new MediaExtractor();
        try {
            mediaExtractor2.setDataSource(str);
            int trackCount = mediaExtractor2.getTrackCount();
            if (trackCount == 1) {
                return mediaExtractor2;
            }
            mediaExtractor2.release();
            try {
                b("createExtractor:invalid media file:numTracks=" + trackCount + " path=" + str, null);
                return null;
            } catch (IOException e17) {
                e16 = e17;
                mediaExtractor = null;
                b("createExtractor path:" + str, e16);
                mediaExtractor.release();
                return null;
            }
        } catch (IOException e18) {
            mediaExtractor = mediaExtractor2;
            e16 = e18;
        }
    }

    private static int f(List<String> list) {
        if (list == null || list.size() == 0) {
            return -9;
        }
        String b16 = com.tencent.aelight.camera.aioeditor.shortvideo.util.a.b(VideoEnvironment.getContext());
        File file = new File(b16);
        if (!file.exists()) {
            return -12;
        }
        b("[@] ffmpegProcess [setExecutable] code=" + file.setExecutable(true, true), null);
        list.add(0, b16);
        list.add(1, LogCmdOptions.DUMP);
        list.add(2, "-y");
        list.add(3, "-loglevel");
        list.add(4, "quiet");
        list.add(com.tencent.aelight.camera.aioeditor.shortvideo.util.a.a(VideoEnvironment.getContext()));
        a aVar = new a();
        ProcessBuilder processBuilder = new ProcessBuilder(new String[0]);
        processBuilder.redirectErrorStream(true);
        processBuilder.command(list);
        try {
            Process start = processBuilder.start();
            aVar.f67618d = start;
            aVar.a();
            try {
                start.waitFor();
            } catch (InterruptedException e16) {
                b("[@] IOException log:", e16);
            }
            int exitValue = start.exitValue();
            if (exitValue != 0) {
                b("[@] process.exitValue:errcode=" + exitValue, null);
            }
            aVar.b();
            try {
                start.destroy();
            } catch (Throwable th5) {
                b("[@] Throwable log:", th5);
            }
            return exitValue;
        } catch (IOException e17) {
            b("[@] IOException log:", e17);
            return -11;
        }
    }

    public static boolean g(List<String> list, String str, int i3) {
        String str2 = "concat:";
        for (int i16 = 0; i16 < list.size(); i16++) {
            String str3 = list.get(i16);
            if (i16 > 0) {
                str2 = str2 + "|";
            }
            String replace = str3.replace(".mp4", ".ts");
            int i17 = i(str3, replace);
            if (i17 != 0) {
                if (QLog.isColorLevel()) {
                    QLog.e("HwVideoMerge", 2, "ffmpegMp4toTs fail, err: " + i17);
                }
                return false;
            }
            str2 = str2 + replace;
        }
        String replace2 = str.replace(".mp4", ".ts");
        int h16 = h(str2, replace2);
        if (h16 != 0) {
            if (QLog.isColorLevel()) {
                QLog.e("HwVideoMerge", 2, "ffmpegMergeTs fail, err: " + h16);
            }
            return false;
        }
        if (i3 == 90) {
            i3 = 270;
        } else if (i3 == 270) {
            i3 = 90;
        }
        int f16 = f(new ArrayList(Arrays.asList(Argument.FILE_INPUT, replace2, "-metadata:s", "rotate=" + i3, Argument.VIDEO_CODEC, "copy", Argument.AUDIO_CODEC, "copy", "-absf", "aac_adtstoasc", str)));
        if (f16 == 0) {
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.e("HwVideoMerge", 2, "ffmpegTstoMp4 fail, err: " + f16);
        }
        return false;
    }

    private static int j(String str, String str2, String str3, int i3) {
        String b16 = com.tencent.aelight.camera.aioeditor.shortvideo.util.a.b(VideoEnvironment.getContext());
        File file = new File(b16);
        if (!file.exists()) {
            return -12;
        }
        b("[@] ffmpegProcess [setExecutable] code=" + file.setExecutable(true, true), null);
        k(str, i3);
        ArrayList arrayList = new ArrayList();
        arrayList.add(b16);
        arrayList.add(LogCmdOptions.DUMP);
        arrayList.add("-y");
        arrayList.add("-loglevel");
        arrayList.add("quiet");
        arrayList.add(Argument.FILE_INPUT);
        arrayList.add(str);
        arrayList.add(Argument.FILE_INPUT);
        arrayList.add(str2);
        arrayList.add(Argument.VIDEO_CODEC);
        arrayList.add("copy");
        arrayList.add(Argument.AUDIO_CODEC);
        arrayList.add("copy");
        arrayList.add(str3);
        arrayList.add(com.tencent.aelight.camera.aioeditor.shortvideo.util.a.a(VideoEnvironment.getContext()));
        a aVar = new a();
        ProcessBuilder processBuilder = new ProcessBuilder(new String[0]);
        processBuilder.redirectErrorStream(true);
        processBuilder.command(arrayList);
        try {
            Process start = processBuilder.start();
            aVar.f67618d = start;
            aVar.a();
            try {
                start.waitFor();
            } catch (InterruptedException e16) {
                b("[@] IOException log:", e16);
            }
            int exitValue = start.exitValue();
            if (exitValue != 0) {
                File file2 = new File(str3);
                if (file2.exists()) {
                    file2.delete();
                }
                b("[@] process.exitValue:errcode=" + exitValue, null);
            }
            aVar.b();
            try {
                start.destroy();
            } catch (Throwable th5) {
                b("[@] Throwable log:", th5);
            }
            return exitValue;
        } catch (IOException e17) {
            b("[@] IOException log:", e17);
            return -11;
        }
    }

    private static int k(String str, int i3) {
        String str2;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(str);
            try {
                str2 = mediaMetadataRetriever.extractMetadata(24);
            } catch (Exception e16) {
                QLog.e("HwVideoMerge", 2, e16, new Object[0]);
                str2 = null;
            }
            mediaMetadataRetriever.release();
            return str2 == null ? i3 : Integer.parseInt(str2);
        } catch (NumberFormatException | IllegalArgumentException unused) {
            return i3;
        }
    }

    public static final int m(String str, String str2, String str3, int i3) {
        return n(str, str2, str3, i3);
    }

    public static final int n(String str, String str2, String str3, int i3) {
        int l3 = new b(str, str2).l(null, i3);
        if (l3 == -2 || l3 == -4 || l3 == -6) {
            return new File(str).renameTo(new File(str3)) ? 0 : -10;
        }
        return l3 == -9 ? j(str, str2, str3, i3) : l3;
    }

    private void o() {
        MediaExtractor mediaExtractor = this.f67609c;
        if (mediaExtractor != null) {
            mediaExtractor.release();
            this.f67609c = null;
        }
        MediaExtractor mediaExtractor2 = this.f67610d;
        if (mediaExtractor2 != null) {
            mediaExtractor2.release();
            this.f67610d = null;
        }
    }

    public int l(String str, int i3) {
        MediaExtractor e16 = e(this.f67607a);
        this.f67609c = e16;
        if (e16 == null) {
            return -1;
        }
        MediaExtractor e17 = e(this.f67608b);
        this.f67610d = e17;
        if (e17 == null) {
            o();
            return -2;
        }
        MediaFormat trackFormat = this.f67609c.getTrackFormat(0);
        String string = trackFormat.getString("mime");
        this.f67611e = trackFormat.getInteger("width");
        this.f67612f = trackFormat.getInteger("height");
        if (string.startsWith("video/")) {
            this.f67609c.selectTrack(0);
            MediaFormat trackFormat2 = this.f67610d.getTrackFormat(0);
            if (trackFormat2.getString("mime").startsWith("audio/")) {
                this.f67610d.selectTrack(0);
                this.f67614h.a(this.f67611e, this.f67612f);
                int c16 = c();
                if (c16 != 0) {
                    return c16;
                }
                if (!d(str)) {
                    o();
                    return -9;
                }
                try {
                    if (new File(str).exists()) {
                        o();
                        return -8;
                    }
                    this.f67613g = new MediaMuxer(str, 0);
                    this.f67613g.setOrientationHint(k(this.f67607a, i3));
                    this.f67614h.f67621c = this.f67613g.addTrack(trackFormat);
                    this.f67614h.f67622d = this.f67613g.addTrack(trackFormat2);
                    return c16;
                } catch (IOException unused) {
                    this.f67613g = null;
                    o();
                    return -7;
                }
            }
            o();
            return -4;
        }
        o();
        return -3;
    }

    private static int h(String str, String str2) {
        return f(new ArrayList(Arrays.asList(Argument.FILE_INPUT, str, LogCmdOptions.CLEAR, "copy", str2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: com.tencent.aelight.camera.aioeditor.shortvideo.util.b$b, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    public static class C0586b {

        /* renamed from: a, reason: collision with root package name */
        public ByteBuffer f67619a;

        /* renamed from: b, reason: collision with root package name */
        public MediaCodec.BufferInfo f67620b = new MediaCodec.BufferInfo();

        /* renamed from: c, reason: collision with root package name */
        public int f67621c;

        /* renamed from: d, reason: collision with root package name */
        public int f67622d;

        C0586b() {
        }

        public void a(int i3, int i16) {
            this.f67619a = ByteBuffer.allocate(((i3 * i16) * 3) / 2);
        }
    }

    private boolean d(String str) {
        return (str == null || "".equals(str)) ? false : true;
    }

    private static int i(String str, String str2) {
        return f(new ArrayList(Arrays.asList(Argument.FILE_INPUT, str, LogCmdOptions.CLEAR, "copy", "-bsf:v", "h264_mp4toannexb", "-f", "mpegts", str2)));
    }
}
