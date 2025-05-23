package com.tencent.qqmini.minigame.utils;

import android.os.Build;
import android.os.SystemClock;
import android.system.Os;
import android.system.OsConstants;
import com.tencent.qmethod.pandoraex.monitor.RuntimeMonitor;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b0\u00101J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\f\u001a\u00020\nH\u0002J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0015\u001a\u00020\u0012R\u0016\u0010\u0018\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0017R\u001b\u0010\u001d\u001a\u00020\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010 \u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u001fR\u0018\u0010\"\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010!R\u0018\u0010#\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010!R\u0016\u0010%\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010$R\u0016\u0010&\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010$R\u0016\u0010'\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010$R \u0010+\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010)\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010*R\u001c\u0010/\u001a\n -*\u0004\u0018\u00010,0,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010.\u00a8\u00062"}, d2 = {"Lcom/tencent/qqmini/minigame/utils/CpuUtil;", "", "", "pid", "", "d", "f", "e", "Ljava/io/Reader;", "reader", "", "g", "j", "c", "b", "Ljava/io/RandomAccessFile;", "input", "k", "", "a", h.F, "l", "", "Z", "useFallback", "", "Lkotlin/Lazy;", "i", "()J", "jiffyHz", "", "[B", "buffer", "Ljava/io/RandomAccessFile;", "procStatFile", "appStatFile", "J", "lastCpuTime", "lastAppCpuTime", "lastUptimeMillis", "", "Ljava/io/File;", "[Ljava/io/File;", "cpuFreqFile", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "Ljava/util/regex/Pattern;", "spacePattern", "<init>", "()V", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public final class CpuUtil {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static boolean useFallback;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Lazy jiffyHz;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final byte[] buffer;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static RandomAccessFile procStatFile;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static RandomAccessFile appStatFile;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static long lastCpuTime;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static long lastAppCpuTime;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static long lastUptimeMillis;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static File[] cpuFreqFile;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private static final Pattern spacePattern;

    /* renamed from: k, reason: collision with root package name */
    public static final CpuUtil f346831k = new CpuUtil();

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Long>() { // from class: com.tencent.qqmini.minigame.utils.CpuUtil$jiffyHz$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Long invoke() {
                return Long.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final long invoke2() {
                return Os.sysconf(OsConstants._SC_CLK_TCK);
            }
        });
        jiffyHz = lazy;
        buffer = new byte[512];
        spacePattern = Pattern.compile("\\s+");
    }

    CpuUtil() {
    }

    private final void a() {
        try {
            RandomAccessFile randomAccessFile = procStatFile;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
        } catch (IOException unused) {
        }
        try {
            RandomAccessFile randomAccessFile2 = appStatFile;
            if (randomAccessFile2 != null) {
                randomAccessFile2.close();
            }
        } catch (IOException unused2) {
        }
        procStatFile = null;
        appStatFile = null;
    }

    private final int b() {
        int i3;
        if (cpuFreqFile == null) {
            File[] fileArr = new File[Runtime.getRuntime().availableProcessors()];
            cpuFreqFile = fileArr;
            int length = fileArr.length;
            for (int i16 = 0; i16 < length; i16++) {
                File[] fileArr2 = cpuFreqFile;
                if (fileArr2 == null) {
                    Intrinsics.throwNpe();
                }
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("/sys/devices/system/cpu/cpu%d/cpufreq/scaling_cur_freq", Arrays.copyOf(new Object[]{Integer.valueOf(i16)}, 1));
                Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
                fileArr2[i16] = new File(format);
            }
        }
        File[] fileArr3 = cpuFreqFile;
        if (fileArr3 == null) {
            Intrinsics.throwNpe();
        }
        int i17 = 0;
        for (File file : fileArr3) {
            if (file != null && file.exists()) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            i17 += i3;
        }
        return i17;
    }

    private final String c(int pid) throws IOException {
        RandomAccessFile randomAccessFile = appStatFile;
        if (randomAccessFile == null) {
            randomAccessFile = new RandomAccessFile("/proc/" + pid + "/stat", "r");
            appStatFile = randomAccessFile;
        } else {
            randomAccessFile.seek(0L);
        }
        return k(randomAccessFile);
    }

    private final float d(int pid) {
        List split$default;
        List split$default2;
        try {
            String j3 = j();
            Pattern spacePattern2 = spacePattern;
            Intrinsics.checkExpressionValueIsNotNull(spacePattern2, "spacePattern");
            split$default = StringsKt__StringsJVMKt.split$default(j3, spacePattern2, 0, 2, null);
            Object[] array = split$default.toArray(new String[0]);
            if (array != null) {
                String[] strArr = (String[]) array;
                if (strArr.length < 8) {
                    QMLog.e("CpuUtil", "procStatString is not excepted -> " + j3);
                    return -1.0f;
                }
                long parseLong = Long.parseLong(strArr[1]) + Long.parseLong(strArr[2]) + Long.parseLong(strArr[3]) + Long.parseLong(strArr[4]) + Long.parseLong(strArr[5]) + Long.parseLong(strArr[6]) + Long.parseLong(strArr[7]);
                String c16 = c(pid);
                Intrinsics.checkExpressionValueIsNotNull(spacePattern2, "spacePattern");
                split$default2 = StringsKt__StringsJVMKt.split$default(c16, spacePattern2, 0, 2, null);
                Object[] array2 = split$default2.toArray(new String[0]);
                if (array2 != null) {
                    String[] strArr2 = (String[]) array2;
                    if (strArr2.length < 15) {
                        QMLog.e("CpuUtil", "appStatString is not excepted -> " + c16);
                        return -1.0f;
                    }
                    long parseLong2 = Long.parseLong(strArr2[13]) + Long.parseLong(strArr2[14]);
                    long j16 = lastCpuTime;
                    if (j16 != 0 && j16 != parseLong) {
                        float f16 = ((float) (parseLong2 - lastAppCpuTime)) / ((float) (parseLong - j16));
                        lastCpuTime = parseLong;
                        lastAppCpuTime = parseLong2;
                        return f16;
                    }
                    lastCpuTime = parseLong;
                    lastAppCpuTime = parseLong2;
                    return -1.0f;
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        } catch (IOException e16) {
            QMLog.e("CpuUtil", "get cpu data error", e16);
            return -1.0f;
        } catch (ArrayIndexOutOfBoundsException e17) {
            QMLog.e("CpuUtil", "get cpu data error", e17);
            return -1.0f;
        } catch (NumberFormatException e18) {
            QMLog.e("CpuUtil", "get cpu data error", e18);
            return -1.0f;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x005f, code lost:
    
        if (r2 == null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0062, code lost:
    
        com.tencent.qqmini.minigame.utils.CpuUtil.useFallback = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0069, code lost:
    
        return f(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0057, code lost:
    
        r2.destroy();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0055, code lost:
    
        if (r2 == null) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final float e(int pid) {
        Process process = null;
        try {
            try {
                process = RuntimeMonitor.exec(Runtime.getRuntime(), "top -n 1 -p " + pid + " -o %CPU -b");
                Intrinsics.checkExpressionValueIsNotNull(process, "process");
                float parseFloat = (Float.parseFloat(g(new InputStreamReader(process.getInputStream()))) / 100.0f) / Runtime.getRuntime().availableProcessors();
                process.destroy();
                return parseFloat;
            } catch (IOException e16) {
                QMLog.e("CpuUtil", "get cpu data error", e16);
            } catch (NumberFormatException e17) {
                QMLog.e("CpuUtil", "get cpu data error", e17);
            }
        } catch (Throwable th5) {
            if (process != null) {
                process.destroy();
            }
            throw th5;
        }
    }

    private final float f(int pid) {
        List split$default;
        try {
            String c16 = c(pid);
            Pattern spacePattern2 = spacePattern;
            Intrinsics.checkExpressionValueIsNotNull(spacePattern2, "spacePattern");
            split$default = StringsKt__StringsJVMKt.split$default(c16, spacePattern2, 0, 2, null);
            Object[] array = split$default.toArray(new String[0]);
            if (array != null) {
                String[] strArr = (String[]) array;
                if (strArr.length < 15) {
                    QMLog.e("CpuUtil", "appStatString is not excepted -> " + c16);
                    return -1.0f;
                }
                long parseLong = Long.parseLong(strArr[13]) + Long.parseLong(strArr[14]);
                long uptimeMillis = SystemClock.uptimeMillis();
                long j3 = lastUptimeMillis;
                if (j3 != 0 && j3 != uptimeMillis) {
                    float b16 = ((float) (parseLong - lastAppCpuTime)) / (((((float) (uptimeMillis - j3)) * b()) * ((float) i())) / 1000);
                    lastUptimeMillis = uptimeMillis;
                    lastAppCpuTime = parseLong;
                    return b16;
                }
                lastUptimeMillis = uptimeMillis;
                lastAppCpuTime = parseLong;
                return 0.0f;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        } catch (IOException e16) {
            QMLog.e("CpuUtil", "get cpu data error", e16);
            return 0.0f;
        } catch (ArrayIndexOutOfBoundsException e17) {
            QMLog.e("CpuUtil", "get cpu data error", e17);
            return 0.0f;
        } catch (NumberFormatException e18) {
            QMLog.e("CpuUtil", "get cpu data error", e18);
            return 0.0f;
        }
    }

    private final String g(Reader reader) throws IOException {
        boolean startsWith$default;
        int i3;
        boolean z16;
        int i16;
        boolean z17;
        BufferedReader bufferedReader = new BufferedReader(reader);
        String str = "";
        int i17 = 0;
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                str = readLine;
            } else {
                readLine = null;
            }
            if (readLine == null || i17 >= 100) {
                break;
            }
            int length = str.length() - 1;
            int i18 = 0;
            boolean z18 = false;
            while (i18 <= length) {
                if (!z18) {
                    i16 = i18;
                } else {
                    i16 = length;
                }
                if (str.charAt(i16) <= ' ') {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z18) {
                    if (!z17) {
                        z18 = true;
                    } else {
                        i18++;
                    }
                } else {
                    if (!z17) {
                        break;
                    }
                    length--;
                }
            }
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str.subSequence(i18, length + 1).toString(), "%CPU", false, 2, null);
            if (startsWith$default) {
                String readLine2 = bufferedReader.readLine();
                if (readLine2 != null) {
                    int length2 = readLine2.length() - 1;
                    int i19 = 0;
                    boolean z19 = false;
                    while (i19 <= length2) {
                        if (!z19) {
                            i3 = i19;
                        } else {
                            i3 = length2;
                        }
                        if (readLine2.charAt(i3) <= ' ') {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (!z19) {
                            if (!z16) {
                                z19 = true;
                            } else {
                                i19++;
                            }
                        } else {
                            if (!z16) {
                                break;
                            }
                            length2--;
                        }
                    }
                    return readLine2.subSequence(i19, length2 + 1).toString();
                }
            } else {
                i17++;
            }
        }
        throw new IOException("data not found");
    }

    private final long i() {
        return ((Number) jiffyHz.getValue()).longValue();
    }

    private final String j() throws IOException {
        RandomAccessFile randomAccessFile = procStatFile;
        if (randomAccessFile == null) {
            randomAccessFile = new RandomAccessFile("/proc/stat", "r");
            procStatFile = randomAccessFile;
        } else {
            randomAccessFile.seek(0L);
        }
        return k(randomAccessFile);
    }

    private final String k(RandomAccessFile input) throws IOException {
        int indexOf$default;
        int indexOf$default2;
        StringBuilder sb5 = new StringBuilder();
        int read = input.read(buffer);
        while (true) {
            if (read <= 0) {
                break;
            }
            byte[] bArr = buffer;
            String str = new String(bArr, 0, read, Charsets.UTF_8);
            indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, '\n', 0, false, 6, (Object) null);
            indexOf$default2 = StringsKt__StringsKt.indexOf$default((CharSequence) str, '\r', 0, false, 6, (Object) null);
            if (indexOf$default == -1) {
                indexOf$default = indexOf$default2;
            } else if (indexOf$default2 != -1) {
                indexOf$default = RangesKt___RangesKt.coerceAtMost(indexOf$default, indexOf$default2);
            }
            if (indexOf$default != -1) {
                String substring = str.substring(0, indexOf$default);
                Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                sb5.append(substring);
                break;
            }
            sb5.append(str);
            read = input.read(bArr);
        }
        String sb6 = sb5.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb6, "sb.toString()");
        return sb6;
    }

    public final float h(int pid) {
        float d16;
        if (Build.VERSION.SDK_INT >= 26) {
            if (useFallback) {
                d16 = f(pid);
            } else {
                d16 = e(pid);
            }
        } else {
            d16 = d(pid);
        }
        if (d16 == -1.0f) {
            QMLog.d("CpuUtil", "get cpuUsage error.");
        }
        return d16;
    }

    public final void l() {
        a();
    }
}
