package com.tencent.mobileqq.zplan.meme.animation2D;

import android.graphics.Bitmap;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.videocodec.ffmpeg.Argument;
import com.tencent.mobileqq.videocodec.ffmpeg.FFmpegFileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.miniapp.util.logmonitor.LogCmdOptions;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.zplan.meme.action.ERROR_ENCODE_NO_FRAME;
import com.tencent.zplan.meme.action.ERROR_GIF_ENCODE_FAIL;
import com.tencent.zplan.meme.action.RECORD_COMPLETE;
import com.tencent.zplan.meme.f;
import com.tencent.zplan.meme.model.BusinessConfig;
import cooperation.qzone.util.GifCoder;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 02\u00020\u0001:\u0002\u000e\u0013B+\u0012\u0006\u0010\u0019\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0007\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010!\u001a\u00020\u0002\u00a2\u0006\u0004\b.\u0010/J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0002J$\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00070\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\u001c\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00070\f2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\u0007H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016R\u0017\u0010\u0019\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010!\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u001c\u001a\u0004\b \u0010\u001eR\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\"R\u001b\u0010(\u001a\u00020$8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0004\u0010%\u001a\u0004\b&\u0010'R\u0018\u0010*\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010\u001cR\u001d\u0010-\u001a\u0004\u0018\u00010+8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b&\u0010%\u001a\u0004\b)\u0010,\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/zplan/meme/animation2D/Anim2DGifEncoder;", "Lcom/tencent/mobileqq/zplan/meme/animation2D/e;", "", "firstFrame", "f", "", "cmds", "", "e", "Landroid/graphics/Bitmap;", "frameBitmap", "frameIndex", "Lkotlin/Pair;", "", "a", "pngPath", "encode", "c", "", "b", "", "d", "I", "getAllFrameCount", "()I", "allFrameCount", "getFrameRate", "frameRate", "Ljava/lang/String;", "getFrameCacheDir", "()Ljava/lang/String;", "frameCacheDir", "getGifPath", "gifPath", "Ljava/util/List;", "picList", "Lcooperation/qzone/util/GifCoder;", "Lkotlin/Lazy;", h.F, "()Lcooperation/qzone/util/GifCoder;", "gifEncoder", "g", "frameFilePath", "Lzx4/d;", "()Lzx4/d;", "configProxy", "<init>", "(IILjava/lang/String;Ljava/lang/String;)V", "i", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class Anim2DGifEncoder implements e {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int allFrameCount;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int frameRate;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final String frameCacheDir;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String gifPath;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final List<String> picList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy gifEncoder;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private String frameFilePath;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Lazy configProxy;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/zplan/meme/animation2D/Anim2DGifEncoder$a;", "", "", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.meme.animation2D.Anim2DGifEncoder$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return GifCoder.tryToLoadGifLib();
        }

        Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0003B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0006R\u0018\u0010\n\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\tR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR$\u0010\u0015\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\f\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/zplan/meme/animation2D/Anim2DGifEncoder$b;", "", "", "a", "b", "Ljava/io/InputStream;", "Ljava/io/InputStream;", "inputStm", "Ljava/io/InputStreamReader;", "Ljava/io/InputStreamReader;", "isr", "Ljava/io/BufferedReader;", "c", "Ljava/io/BufferedReader;", TtmlNode.TAG_BR, "Ljava/lang/Process;", "d", "Ljava/lang/Process;", "getMProcess", "()Ljava/lang/Process;", "(Ljava/lang/Process;)V", "mProcess", "<init>", "()V", "e", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private InputStream inputStm;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private InputStreamReader isr;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private BufferedReader br;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private Process mProcess;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/zplan/meme/animation2D/Anim2DGifEncoder$b$a;", "", "", "msg", "", "thr", "", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.zplan.meme.animation2D.Anim2DGifEncoder$b$a, reason: from kotlin metadata */
        /* loaded from: classes34.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final void a(String msg2, Throwable thr) {
                Intrinsics.checkNotNullParameter(msg2, "msg");
                if (QLog.isColorLevel()) {
                    if (thr != null) {
                        QLog.d("HwVideoMerge", 2, msg2, thr);
                    } else {
                        QLog.d("HwVideoMerge", 2, msg2);
                    }
                }
            }

            Companion() {
            }
        }

        public final void a() {
            Process process = this.mProcess;
            if (process != null) {
                this.inputStm = process.getInputStream();
                this.isr = new InputStreamReader(this.inputStm);
                this.br = new BufferedReader(this.isr);
            }
        }

        public final void b() {
            BufferedReader bufferedReader;
            if (this.mProcess != null) {
                try {
                    try {
                        try {
                            BufferedReader bufferedReader2 = this.br;
                            if (bufferedReader2 != null) {
                                while (true) {
                                    String readLine = bufferedReader2.readLine();
                                    if (readLine == null) {
                                        break;
                                    }
                                    INSTANCE.a("[@] compressVideo log:" + ((Object) readLine), null);
                                }
                                Unit unit = Unit.INSTANCE;
                            }
                            InputStream inputStream = this.inputStm;
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            InputStreamReader inputStreamReader = this.isr;
                            if (inputStreamReader != null) {
                                inputStreamReader.close();
                            }
                            bufferedReader = this.br;
                            if (bufferedReader == null) {
                                return;
                            }
                        } catch (Throwable th5) {
                            try {
                                InputStream inputStream2 = this.inputStm;
                                if (inputStream2 != null) {
                                    inputStream2.close();
                                }
                                InputStreamReader inputStreamReader2 = this.isr;
                                if (inputStreamReader2 != null) {
                                    inputStreamReader2.close();
                                }
                                BufferedReader bufferedReader3 = this.br;
                                if (bufferedReader3 != null) {
                                    bufferedReader3.close();
                                }
                            } catch (IOException unused) {
                            }
                            throw th5;
                        }
                    } catch (IOException unused2) {
                        return;
                    }
                } catch (IOException unused3) {
                    Unit unit2 = Unit.INSTANCE;
                    InputStream inputStream3 = this.inputStm;
                    if (inputStream3 != null) {
                        inputStream3.close();
                    }
                    InputStreamReader inputStreamReader3 = this.isr;
                    if (inputStreamReader3 != null) {
                        inputStreamReader3.close();
                    }
                    bufferedReader = this.br;
                    if (bufferedReader == null) {
                        return;
                    }
                }
                bufferedReader.close();
            }
        }

        public final void c(Process process) {
            this.mProcess = process;
        }
    }

    public Anim2DGifEncoder(int i3, int i16, String str, String gifPath) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(gifPath, "gifPath");
        this.allFrameCount = i3;
        this.frameRate = i16;
        this.frameCacheDir = str;
        this.gifPath = gifPath;
        this.picList = new ArrayList();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GifCoder>() { // from class: com.tencent.mobileqq.zplan.meme.animation2D.Anim2DGifEncoder$gifEncoder$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final GifCoder invoke() {
                return new GifCoder();
            }
        });
        this.gifEncoder = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<zx4.d>() { // from class: com.tencent.mobileqq.zplan.meme.animation2D.Anim2DGifEncoder$configProxy$2
            @Override // kotlin.jvm.functions.Function0
            public final zx4.d invoke() {
                return (zx4.d) mx4.a.f417748a.a(zx4.d.class);
            }
        });
        this.configProxy = lazy2;
        INSTANCE.a();
        if (ZPlanQQMC.INSTANCE.enableGifEncodeWithMediaCut()) {
            h().setEncodingType(GifCoder.EncodingType.ENCODING_TYPE_FAST_WITH_HIGH_MEMORY);
            h().setEncoderDither(false);
        }
        zx4.d g16 = g();
        if (!(g16 != null && g16.f())) {
            h().setEncoderDispose(3);
            h().setNeedRemoveSamePixels(false);
            GifCoder h16 = h();
            zx4.d g17 = g();
            h16.setTransparentThreshold(g17 != null ? g17.d() : 0);
        }
        h().setUseOrignalBitmap(true);
    }

    private final String f(String firstFrame) {
        List<String> mutableListOf;
        if (firstFrame.length() == 0) {
            return null;
        }
        File file = new File(firstFrame);
        if (!file.exists()) {
            return null;
        }
        String str = file.getParent() + File.separator + "palette.png";
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(Argument.FILE_INPUT, firstFrame, "-vf", "palettegen", str);
        if (e(mutableListOf) != 0) {
            return null;
        }
        return str;
    }

    private final zx4.d g() {
        return (zx4.d) this.configProxy.getValue();
    }

    private final GifCoder h() {
        return (GifCoder) this.gifEncoder.getValue();
    }

    @Override // com.tencent.mobileqq.zplan.meme.animation2D.e
    public Pair<Long, Integer> a(Bitmap frameBitmap, int frameIndex) {
        Intrinsics.checkNotNullParameter(frameBitmap, "frameBitmap");
        long currentTimeMillis = System.currentTimeMillis();
        String str = this.frameCacheDir + File.separator + currentTimeMillis + BusinessConfig.FrameType.PNG.suffix();
        this.frameFilePath = str;
        if (!f.e(frameBitmap, 100, str)) {
            return new Pair<>(0L, -18012);
        }
        String str2 = this.frameFilePath;
        if (str2 != null) {
            this.picList.add(str2);
        }
        return new Pair<>(Long.valueOf(frameBitmap.getByteCount()), 0);
    }

    @Override // com.tencent.mobileqq.zplan.meme.animation2D.e
    public void b() {
        this.picList.clear();
        String str = this.frameCacheDir;
        if (str != null) {
            com.tencent.zplan.common.utils.c.f385288a.f(new File(str));
        }
    }

    @Override // com.tencent.mobileqq.zplan.meme.animation2D.e
    public int c() {
        int reportErrorCode;
        if (this.picList.isEmpty()) {
            return ERROR_ENCODE_NO_FRAME.INSTANCE.toReportErrorCode();
        }
        if (this.picList.size() != this.allFrameCount) {
            return -18013;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.addAll(this.picList);
        if (ZPlanQQMC.INSTANCE.enableGifFFMpegPalette()) {
            try {
                String str = arrayList.get(0);
                Intrinsics.checkNotNullExpressionValue(str, "picListTmp[0]");
                String f16 = f(str);
                if (f16 != null) {
                    h().setPaletteData(f16);
                }
            } catch (Exception e16) {
                QLog.i("Anim2DGifEncoder", 1, "generatePalette IOException log::" + e16);
            }
        }
        if (h().encodeGif(this.gifPath, arrayList, this.frameRate) && com.tencent.zplan.common.utils.c.f385288a.h(this.gifPath)) {
            reportErrorCode = RECORD_COMPLETE.INSTANCE.toReportErrorCode();
        } else {
            reportErrorCode = ERROR_GIF_ENCODE_FAIL.INSTANCE.toReportErrorCode();
        }
        int size = this.picList.size();
        String str2 = this.gifPath;
        QLog.i("Anim2DGifEncoder", 1, "encode " + size + " frames to " + str2 + ", file exists:" + com.tencent.zplan.common.utils.c.f385288a.h(str2) + ", result:" + reportErrorCode);
        h().closeEncoder();
        return reportErrorCode;
    }

    @Override // com.tencent.mobileqq.zplan.meme.animation2D.e
    public byte[] d() {
        return null;
    }

    @Override // com.tencent.mobileqq.zplan.meme.animation2D.e
    public Pair<Long, Integer> encode(String pngPath) {
        Intrinsics.checkNotNullParameter(pngPath, "pngPath");
        this.picList.add(pngPath);
        return new Pair<>(Long.valueOf(pngPath.length()), 0);
    }

    private final int e(List<String> cmds) {
        if (cmds != null && !cmds.isEmpty()) {
            String fFmpeg = FFmpegFileUtils.getFFmpeg(VideoEnvironment.getContext());
            Intrinsics.checkNotNullExpressionValue(fFmpeg, "getFFmpeg(VideoEnvironment.getContext())");
            File file = new File(fFmpeg);
            if (file.exists()) {
                QLog.i("Anim2DGifEncoder", 1, "load sharpP so, success:" + file.setExecutable(true, true));
                cmds.add(0, fFmpeg);
                cmds.add(1, LogCmdOptions.DUMP);
                cmds.add(2, "-y");
                cmds.add(3, "-loglevel");
                cmds.add(4, "quiet");
                String aVCodecSoFilePath = FFmpegFileUtils.getAVCodecSoFilePath(VideoEnvironment.getContext());
                Intrinsics.checkNotNullExpressionValue(aVCodecSoFilePath, "getAVCodecSoFilePath(Vid\u2026Environment.getContext())");
                cmds.add(aVCodecSoFilePath);
                b bVar = new b();
                ProcessBuilder processBuilder = new ProcessBuilder(new String[0]);
                processBuilder.redirectErrorStream(true);
                processBuilder.command(cmds);
                try {
                    Process start = processBuilder.start();
                    bVar.c(start);
                    bVar.a();
                    if (start != null) {
                        try {
                            start.waitFor();
                        } catch (InterruptedException e16) {
                            QLog.i("Anim2DGifEncoder", 1, "[@] InterruptedException log::" + e16);
                        }
                    }
                    Integer valueOf = start != null ? Integer.valueOf(start.exitValue()) : null;
                    int intValue = valueOf != null ? valueOf.intValue() : 0;
                    if (intValue != 0) {
                        b.INSTANCE.a("[@] process.exitValue:errcode=" + intValue, null);
                    }
                    bVar.b();
                    if (start != null) {
                        start.destroy();
                    }
                    return intValue;
                } catch (IOException e17) {
                    QLog.i("Anim2DGifEncoder", 1, "[@] IOException log::" + e17);
                }
            }
        }
        return -1;
    }
}
