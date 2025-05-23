package com.tencent.qqnt.shortvideo.compress;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.shortvideo.VideoEnvironment;
import com.tencent.richmedia.videocompress.VideoConverter;
import com.tencent.richmedia.videocompress.VideoConverterConfig;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0006H\u0002J\u000e\u0010\u0012\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fJ(\u0010\u0018\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015J\u0018\u0010\u001b\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001a\u001a\u00020\u0019J\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u0006H\u0086 \u00a8\u0006 "}, d2 = {"Lcom/tencent/qqnt/shortvideo/compress/ShortVideoTrimmer;", "", "Ljava/io/InputStream;", "is", "", "buffer", "", "outPath", "", "e", "piePic", "g", "Landroid/content/Context;", "context", "c", "msg", "", "a", "d", "inputVideo", "outputVideo", "Lcom/tencent/richmedia/videocompress/VideoConverterConfig;", DownloadInfo.spKey_Config, "", "b", "Lcom/tencent/richmedia/videocompress/VideoConverter;", "converter", "f", "videoFile", "getRealProperties", "<init>", "()V", "shortvideo_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class ShortVideoTrimmer {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ShortVideoTrimmer f362237a = new ShortVideoTrimmer();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/qqnt/shortvideo/compress/ShortVideoTrimmer$b", "Lcom/tencent/qqnt/shortvideo/compress/ShortVideoTrimmer$a;", "", "w", h.F, "Lcom/tencent/richmedia/videocompress/VideoConverterConfig;", "getEncodeConfig", "shortvideo_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b extends a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ VideoConverterConfig f362238a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f362239b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f362240c;

        b(VideoConverterConfig videoConverterConfig, String str, String str2) {
            this.f362238a = videoConverterConfig;
            this.f362239b = str;
            this.f362240c = str2;
        }

        @Override // com.tencent.richmedia.videocompress.VideoConverter.Processor
        @NotNull
        public VideoConverterConfig getEncodeConfig(int w3, int h16) {
            VideoConverterConfig videoConverterConfig = this.f362238a;
            if (videoConverterConfig == null) {
                videoConverterConfig = com.tencent.qqnt.compress.video.config.a.f355762a.a(this.f362239b).getFirst();
            }
            videoConverterConfig.output = this.f362240c;
            return videoConverterConfig;
        }
    }

    ShortVideoTrimmer() {
    }

    private final void a(String msg2) {
        if (QLog.isColorLevel()) {
            QLog.d(com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer.TAG, 2, msg2);
        }
    }

    private final boolean c(Context context) {
        String b16 = c.b(context);
        File file = new File(b16);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = b16 + "trim_process_pie";
        String str2 = b16 + com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer.VIDEO_COMPRESS_BIN_NAME;
        if (new File(str2).exists() && g(str, str2)) {
            return true;
        }
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(str);
                try {
                    a("initTrimProcessFile [FileInputStream]");
                    boolean e16 = e(fileInputStream2, new byte[8192], str2);
                    a("initTrimProcessFile writeOK=" + e16);
                    if (e16) {
                        e16 = new File(str2).setExecutable(true, true);
                        a("initTrimProcessFile [setExecutable] writeOK=" + e16);
                    }
                    try {
                        fileInputStream2.close();
                    } catch (IOException e17) {
                        e17.printStackTrace();
                    }
                    return e16;
                } catch (Exception e18) {
                    e = e18;
                    fileInputStream = fileInputStream2;
                    e.printStackTrace();
                    a("initTrimProcessFile, exp=" + e);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                            return false;
                        } catch (IOException e19) {
                            e19.printStackTrace();
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
                        } catch (IOException e26) {
                            e26.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e27) {
                e = e27;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    private final boolean e(InputStream is5, byte[] buffer, String outPath) {
        int i3;
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(outPath);
                loop0: while (true) {
                    i3 = 0;
                    do {
                        try {
                            int read = is5.read(buffer, i3, buffer.length - i3);
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
                    } while (i3 != buffer.length);
                    fileOutputStream2.write(buffer, 0, i3);
                }
                if (i3 != 0) {
                    fileOutputStream2.write(buffer, 0, i3);
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

    private final boolean g(String piePic, String outPath) {
        if (!new File(piePic).exists()) {
            return true;
        }
        byte[] fileMd5 = MD5.getFileMd5(piePic);
        byte[] fileMd52 = MD5.getFileMd5(outPath);
        String a16 = com.tencent.qqnt.shortvideo.a.a(fileMd5);
        Intrinsics.checkNotNullExpressionValue(a16, "bytes2HexStr(pieMd5Byte)");
        String a17 = com.tencent.qqnt.shortvideo.a.a(fileMd52);
        Intrinsics.checkNotNullExpressionValue(a17, "bytes2HexStr(outMd5Byte)");
        a("trimBinMd5Judge, pieMd5=" + a16 + "  outMd5=" + a17);
        if (!TextUtils.isEmpty(a16) && !TextUtils.isEmpty(a17) && Intrinsics.areEqual(a16, a17)) {
            return true;
        }
        return false;
    }

    public final int b(@NotNull Context context, @NotNull String inputVideo, @NotNull String outputVideo, @Nullable VideoConverterConfig config) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(inputVideo, "inputVideo");
        Intrinsics.checkNotNullParameter(outputVideo, "outputVideo");
        VideoConverter videoConverter = new VideoConverter(new d());
        f(context, videoConverter);
        return videoConverter.startCompress(context, inputVideo, new b(config, inputVideo, outputVideo), true);
    }

    public final boolean d(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        boolean c16 = c(context);
        if (c16 && VideoEnvironment.e() != 0) {
            return false;
        }
        return c16;
    }

    public final void f(@Nullable Context context, @NotNull VideoConverter converter) {
        Intrinsics.checkNotNullParameter(converter, "converter");
        String b16 = c.b(context);
        String d16 = VideoEnvironment.d();
        Intrinsics.checkNotNullExpressionValue(d16, "getShortVideoSoLibName()");
        converter.setFFmpegBinAndSoPath(b16 + com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer.VIDEO_COMPRESS_BIN_NAME, b16 + d16, false);
        converter.setCompressMode(2);
    }

    @Nullable
    public final native String getRealProperties(@Nullable String videoFile);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/shortvideo/compress/ShortVideoTrimmer$a;", "Lcom/tencent/richmedia/videocompress/VideoConverter$Processor;", "", "i", "", "onProgress", "onSuccess", "", "throwable", "onFail", "onCancel", "<init>", "()V", "shortvideo_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static class a implements VideoConverter.Processor {
        @Override // com.tencent.richmedia.videocompress.VideoConverter.Processor
        public void onFail(@NotNull Throwable throwable) {
            Intrinsics.checkNotNullParameter(throwable, "throwable");
        }

        @Override // com.tencent.richmedia.videocompress.VideoConverter.Processor
        public void onCancel() {
        }

        @Override // com.tencent.richmedia.videocompress.VideoConverter.Processor
        public void onSuccess() {
        }

        @Override // com.tencent.richmedia.videocompress.VideoConverter.Processor
        public void onProgress(int i3) {
        }
    }
}
