package o63;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.videocodec.ffmpeg.Argument;
import com.tencent.mobileqq.wink.editor.export.compress.base.c;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.richmedia.videocompress.converter.SoftwareConverter;
import com.tencent.tav.core.ExportConfig;
import com.tencent.xweb.FileReaderHelper;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\b\u0018\u0000 .2\u00020\u0001:\u0001/B\u0007\u00a2\u0006\u0004\b,\u0010-J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0019\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0010\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0010\u0010\u000fJ!\u0010\u0013\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0016\u001a\u00020\u00152\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J&\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001b\u001a\u00020\u0007H\u0002J\b\u0010\u001c\u001a\u00020\u0002H\u0016J \u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J\b\u0010 \u001a\u00020\u0007H\u0016R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010%\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010'\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010$R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u00060"}, d2 = {"Lo63/b;", "Lcom/tencent/mobileqq/wink/editor/export/compress/base/c;", "", "input", "Lcom/tencent/tav/core/ExportConfig;", "exportConfig", "output", "", "p", "Ljava/lang/Process;", "process", DomainData.DOMAIN_NAME, "message", "", "r", "(Ljava/lang/String;)Ljava/lang/Long;", "t", "Ljava/util/regex/Pattern;", "pattern", "w", "(Ljava/lang/String;Ljava/util/regex/Pattern;)Ljava/lang/Long;", "", "u", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", ReportConstant.COSTREPORT_PREFIX, "o", "b", "inputPath", "outputPath", "l", "cancel", "d", "Ljava/lang/Process;", "e", "Ljava/lang/Long;", "durationInMillis", "f", "timeInMillis", "", "g", UserInfo.SEX_FEMALE, "currentPercent", "<init>", "()V", h.F, "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class b extends c {

    /* renamed from: i, reason: collision with root package name */
    private static final Pattern f422163i = Pattern.compile("Duration: ([\\d:]{8}[.]\\d+)");

    /* renamed from: j, reason: collision with root package name */
    private static final Pattern f422164j = Pattern.compile("time=([\\d:]{8}[.]\\d+)");

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private volatile Process process;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private volatile Long durationInMillis;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private volatile Long timeInMillis;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private volatile float currentPercent;

    /* JADX WARN: Removed duplicated region for block: B:17:0x004b A[Catch: Exception -> 0x00d4, TryCatch #0 {Exception -> 0x00d4, blocks: (B:7:0x000b, B:8:0x0019, B:10:0x0023, B:12:0x003e, B:17:0x004b, B:19:0x004f, B:20:0x0053, B:22:0x005b, B:23:0x005d, B:25:0x0067, B:28:0x0073, B:29:0x008d, B:31:0x0093, B:32:0x00be, B:34:0x00ce), top: B:6:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void n(Process process) {
        BufferedReader bufferedReader;
        boolean z16;
        float coerceAtLeast;
        while (!u(process) && !this.isCancelled) {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            } catch (Exception e16) {
                QLog.e(b(), 1, "checkAndUpdateProgress, error ", e16);
            }
            do {
                String readLine = bufferedReader.readLine();
                if (QLog.isColorLevel()) {
                    QLog.d(b(), 1, "checkAndUpdateProgress, line:" + readLine);
                }
                if (readLine != null && readLine.length() != 0) {
                    z16 = false;
                    if (!z16) {
                        Long l3 = this.durationInMillis;
                        if (l3 == null) {
                            l3 = r(readLine);
                        }
                        this.durationInMillis = l3;
                        Long t16 = t(readLine);
                        if (t16 == null) {
                            t16 = this.timeInMillis;
                        }
                        this.timeInMillis = t16;
                        Long l16 = this.durationInMillis;
                        Long l17 = this.timeInMillis;
                        float f16 = this.currentPercent;
                        if (l16 != null && l16.longValue() != 0 && l17 != null) {
                            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast((((float) l17.longValue()) * 1.0f) / ((float) l16.longValue()), this.currentPercent);
                            f16 = RangesKt___RangesKt.coerceAtMost(coerceAtLeast, 1.0f);
                            this.currentPercent = f16;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d(b(), 1, "checkAndUpdateProgress, duration:" + l16 + ", time:" + l17 + ", percent:" + f16);
                        }
                        j(f16, 0L, 0L, 0L);
                        if (readLine != null) {
                        }
                    }
                }
                z16 = true;
                if (!z16) {
                }
            } while (!this.isCancelled);
        }
    }

    private final void o() {
        try {
            if (this.process != null) {
                Process process = this.process;
                if (process != null) {
                    process.destroy();
                }
                this.process = null;
            }
        } catch (Exception e16) {
            QLog.e(b(), 1, "destroyProcess, error ", e16);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00aa A[Catch: all -> 0x00fd, Exception -> 0x00ff, InterruptedException -> 0x0125, IOException -> 0x013c, TryCatch #3 {IOException -> 0x013c, blocks: (B:3:0x0001, B:5:0x000a, B:10:0x0016, B:13:0x0023, B:15:0x0031, B:18:0x003a, B:21:0x0047, B:23:0x00aa, B:27:0x00af, B:28:0x00cb, B:32:0x00e4), top: B:2:0x0001, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00af A[Catch: all -> 0x00fd, Exception -> 0x00ff, InterruptedException -> 0x0125, IOException -> 0x013c, TryCatch #3 {IOException -> 0x013c, blocks: (B:3:0x0001, B:5:0x000a, B:10:0x0016, B:13:0x0023, B:15:0x0031, B:18:0x003a, B:21:0x0047, B:23:0x00aa, B:27:0x00af, B:28:0x00cb, B:32:0x00e4), top: B:2:0x0001, outer: #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void p(String input, ExportConfig exportConfig, String output) {
        y73.a aVar;
        String a16;
        boolean z16;
        boolean z17;
        String b16;
        int waitFor;
        try {
            try {
                try {
                    aVar = y73.a.f449547a;
                    a16 = aVar.a();
                    z16 = false;
                } catch (InterruptedException e16) {
                    QLog.e(b(), 1, "doCompress, InterruptedException ", e16);
                    c.f(this, 0L, "InterruptedException ", 1, null);
                } catch (Exception e17) {
                    QLog.e(b(), 1, "doCompress, Exception ", e17);
                    c.f(this, 0L, "Exception:" + e17, 1, null);
                }
            } catch (IOException e18) {
                QLog.e(b(), 1, "doCompress, IOException ", e18);
                c.f(this, 0L, "IOException ", 1, null);
            }
            if (a16 != null && a16.length() != 0) {
                z17 = false;
                if (!z17 && new File(a16).exists()) {
                    new File(a16).setExecutable(true, true);
                    b16 = aVar.b();
                    if (b16 != null || b16.length() == 0) {
                        z16 = true;
                    }
                    if (!z16 && new File(b16).exists()) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(a16);
                        arrayList.addAll(q(input, exportConfig, output));
                        arrayList.add(b16);
                        QLog.d(b(), 1, "doCompress, cmdList:" + arrayList);
                        Process process = new ProcessBuilder(arrayList).start();
                        this.process = process;
                        i();
                        Intrinsics.checkNotNullExpressionValue(process, "process");
                        n(process);
                        waitFor = process.waitFor();
                        QLog.d(b(), 1, "doCompress, exitValue:" + waitFor);
                        if (waitFor != 0) {
                            g(output);
                        } else {
                            c.f(this, 0L, "exitValue:" + waitFor, 1, null);
                        }
                        return;
                    }
                    QLog.e(b(), 1, "doCompress, soFile not exists ");
                    c.f(this, 0L, "soFile not exists ", 1, null);
                    return;
                }
                QLog.e(b(), 1, "doCompress, binFile not exists ");
                c.f(this, 0L, "binFile not exists ", 1, null);
            }
            z17 = true;
            if (!z17) {
                new File(a16).setExecutable(true, true);
                b16 = aVar.b();
                if (b16 != null) {
                }
                z16 = true;
                if (!z16) {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(a16);
                    arrayList2.addAll(q(input, exportConfig, output));
                    arrayList2.add(b16);
                    QLog.d(b(), 1, "doCompress, cmdList:" + arrayList2);
                    Process process2 = new ProcessBuilder(arrayList2).start();
                    this.process = process2;
                    i();
                    Intrinsics.checkNotNullExpressionValue(process2, "process");
                    n(process2);
                    waitFor = process2.waitFor();
                    QLog.d(b(), 1, "doCompress, exitValue:" + waitFor);
                    if (waitFor != 0) {
                    }
                    return;
                }
                QLog.e(b(), 1, "doCompress, soFile not exists ");
                c.f(this, 0L, "soFile not exists ", 1, null);
                return;
            }
            QLog.e(b(), 1, "doCompress, binFile not exists ");
            c.f(this, 0L, "binFile not exists ", 1, null);
        } finally {
            o();
        }
    }

    private final List<String> q(String input, ExportConfig exportConfig, String output) {
        com.tencent.richmedia.videocompress.utils.a aVar = new com.tencent.richmedia.videocompress.utils.a();
        aVar.a("-y");
        aVar.b("-threads", s());
        aVar.a("-copyts");
        aVar.d("-copytb", "0");
        aVar.d(Argument.FILE_INPUT, input);
        aVar.d(Argument.AUDIO_CODEC, FileReaderHelper.AAC_EXT);
        aVar.d(Argument.VIDEO_CODEC, "libo264rt");
        aVar.d("-bufsize", "2000K");
        aVar.b("-r", exportConfig.getVideoFrameRate());
        aVar.d("-b", (exportConfig.getVideoBitRate() / 1024) + "k");
        aVar.d("-s", exportConfig.getOutputWidth() + HippyTKDListViewAdapter.X + exportConfig.getOutputHeight());
        aVar.d("-movflags", "faststart");
        aVar.a(output);
        ArrayList<String> e16 = aVar.e();
        Intrinsics.checkNotNullExpressionValue(e16, "CommandBuilder().apply {\u2026output)\n        }.cmdList");
        return e16;
    }

    private final Long r(String message) {
        boolean contains$default;
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) message, (CharSequence) "Duration", false, 2, (Object) null);
        if (!contains$default) {
            return null;
        }
        Pattern durationPattern = f422163i;
        Intrinsics.checkNotNullExpressionValue(durationPattern, "durationPattern");
        return w(message, durationPattern);
    }

    private final int s() {
        if (SoftwareConverter.getCpuCores() >= 8) {
            return 4;
        }
        if (SoftwareConverter.getCpuCores() >= 2) {
            return 2;
        }
        return 1;
    }

    private final Long t(String message) {
        boolean contains$default;
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) message, (CharSequence) "speed", false, 2, (Object) null);
        if (!contains$default) {
            return null;
        }
        Pattern timePattern = f422164j;
        Intrinsics.checkNotNullExpressionValue(timePattern, "timePattern");
        return w(message, timePattern);
    }

    private final boolean u(Process process) {
        if (process == null) {
            if (QLog.isColorLevel()) {
                QLog.d(b(), 1, "isProcessCompleted, process is null ");
            }
            return true;
        }
        try {
            int exitValue = process.exitValue();
            if (!QLog.isColorLevel()) {
                return true;
            }
            QLog.d(b(), 1, "isProcessCompleted, exitValue:" + exitValue);
            return true;
        } catch (IllegalThreadStateException unused) {
            if (QLog.isColorLevel()) {
                QLog.d(b(), 1, "isProcessCompleted, IllegalThreadStateException ");
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(b this$0, String inputPath, ExportConfig exportConfig, String outputPath) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(inputPath, "$inputPath");
        Intrinsics.checkNotNullParameter(exportConfig, "$exportConfig");
        Intrinsics.checkNotNullParameter(outputPath, "$outputPath");
        QLog.d(this$0.b(), 1, "onRealStartCompress, start ");
        this$0.p(inputPath, exportConfig, outputPath);
        QLog.d(this$0.b(), 1, "onRealStartCompress, end ");
    }

    private final Long w(String message, Pattern pattern) {
        try {
            Matcher matcher = pattern.matcher(message);
            Intrinsics.checkNotNullExpressionValue(matcher, "pattern.matcher(message)");
            matcher.find();
            String group = matcher.group(1);
            if (QLog.isColorLevel()) {
                QLog.d(b(), 1, "parseMillis, time:" + group);
            }
            if (group == null) {
                return null;
            }
            List<String> split = new Regex("[:.]").split(group, 0);
            long millis = TimeUnit.HOURS.toMillis(Long.parseLong(split.get(0))) + TimeUnit.MINUTES.toMillis(Long.parseLong(split.get(1))) + TimeUnit.SECONDS.toMillis(Long.parseLong(split.get(2))) + Long.parseLong(split.get(3));
            if (QLog.isColorLevel()) {
                QLog.d(b(), 1, "parseMillis, milliSeconds:" + millis);
            }
            return Long.valueOf(millis);
        } catch (Exception e16) {
            QLog.e(b(), 1, "parseMillis, error ", e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.export.compress.base.c, com.tencent.mobileqq.wink.editor.export.compress.base.a
    @NotNull
    public String b() {
        return super.b() + "_WinkVideoSoftCompressProcessor";
    }

    @Override // com.tencent.mobileqq.wink.editor.export.compress.base.c, com.tencent.mobileqq.wink.editor.export.compress.base.a
    public void cancel() {
        super.cancel();
        o();
    }

    @Override // com.tencent.mobileqq.wink.editor.export.compress.base.c
    protected void l(@NotNull final String inputPath, @NotNull final String outputPath, @NotNull final ExportConfig exportConfig) {
        Intrinsics.checkNotNullParameter(inputPath, "inputPath");
        Intrinsics.checkNotNullParameter(outputPath, "outputPath");
        Intrinsics.checkNotNullParameter(exportConfig, "exportConfig");
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: o63.a
            @Override // java.lang.Runnable
            public final void run() {
                b.v(b.this, inputPath, exportConfig, outputPath);
            }
        });
    }
}
