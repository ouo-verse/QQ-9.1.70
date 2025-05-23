package com.tencent.state.square.util;

import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.system.Os;
import android.system.OsConstants;
import com.tencent.qmethod.pandoraex.monitor.RuntimeMonitor;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\"\u001a\u00020#H\u0002J\u0010\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020#H\u0002J\u0010\u0010&\u001a\u00020\u00042\u0006\u0010%\u001a\u00020#H\u0002J\u0010\u0010'\u001a\u00020\u00042\u0006\u0010%\u001a\u00020#H\u0002J\u0010\u0010(\u001a\u00020\u00042\u0006\u0010%\u001a\u00020#H\u0002J\u0012\u0010)\u001a\u00020\u00062\b\u0010*\u001a\u0004\u0018\u00010+H\u0002J\u0010\u0010,\u001a\u00020\u00042\b\b\u0002\u0010%\u001a\u00020#J\b\u0010-\u001a\u00020\u0006H\u0002J\u0010\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0011R\u001b\u0010\u0012\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0017\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001d\u001a\n \u001f*\u0004\u0018\u00010\u001e0\u001eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00060"}, d2 = {"Lcom/tencent/state/square/util/CpuUtil;", "", "()V", "INVALID_CPU_VALUE", "", "LINUX_CPU_FREQUENCY_PATH", "", "MIN_GET_INTERVAL_MS", "", "TAG", "appStatFile", "Ljava/io/RandomAccessFile;", "buffer", "", "cpuFreqFile", "", "Ljava/io/File;", "[Ljava/io/File;", "jiffyHz", "getJiffyHz", "()J", "jiffyHz$delegate", "Lkotlin/Lazy;", "lastAppCpuTime", "lastCpuTime", "lastCpuUsage", "lastGetTime", "lastUptimeMillis", "procStatFile", "spacePattern", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "useFallback", "", "countCpuCore", "", "getAppStatString", "pid", "getCPUDataUnderO", "getCpuDataForOWhenDebug", "getCpuDataForOWhenRelease", "getCpuLineString", "reader", "Ljava/io/Reader;", "getCpuUsage", "getProcStatString", "readLineBuffered", "input", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public final class CpuUtil {

    @NotNull
    public static final CpuUtil INSTANCE = new CpuUtil();
    public static final float INVALID_CPU_VALUE = -1.0f;
    private static final String LINUX_CPU_FREQUENCY_PATH = "/sys/devices/system/cpu/cpu%d/cpufreq/scaling_cur_freq";
    private static final long MIN_GET_INTERVAL_MS = 10;
    private static final String TAG = "CpuUtil";
    private static RandomAccessFile appStatFile;
    private static final byte[] buffer;
    private static File[] cpuFreqFile;

    /* renamed from: jiffyHz$delegate, reason: from kotlin metadata */
    private static final Lazy jiffyHz;
    private static long lastAppCpuTime;
    private static long lastCpuTime;
    private static float lastCpuUsage;
    private static long lastGetTime;
    private static long lastUptimeMillis;
    private static RandomAccessFile procStatFile;
    private static final Pattern spacePattern;
    private static boolean useFallback;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Long>() { // from class: com.tencent.state.square.util.CpuUtil$jiffyHz$2
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
        lastCpuUsage = -1.0f;
    }

    CpuUtil() {
    }

    private final int countCpuCore() {
        int i3;
        if (cpuFreqFile == null) {
            File[] fileArr = new File[Runtime.getRuntime().availableProcessors()];
            cpuFreqFile = fileArr;
            Intrinsics.checkNotNull(fileArr);
            int length = fileArr.length;
            for (int i16 = 0; i16 < length; i16++) {
                File[] fileArr2 = cpuFreqFile;
                Intrinsics.checkNotNull(fileArr2);
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format(LINUX_CPU_FREQUENCY_PATH, Arrays.copyOf(new Object[]{Integer.valueOf(i16)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
                fileArr2[i16] = new File(format);
            }
        }
        File[] fileArr3 = cpuFreqFile;
        Intrinsics.checkNotNull(fileArr3);
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

    private final String getAppStatString(int pid) throws IOException {
        RandomAccessFile randomAccessFile = appStatFile;
        if (randomAccessFile == null) {
            randomAccessFile = new RandomAccessFile("/proc/" + pid + "/stat", "r");
            appStatFile = randomAccessFile;
        } else {
            randomAccessFile.seek(0L);
        }
        return readLineBuffered(randomAccessFile);
    }

    private final float getCPUDataUnderO(int pid) {
        List split$default;
        List split$default2;
        try {
            String procStatString = getProcStatString();
            Pattern spacePattern2 = spacePattern;
            Intrinsics.checkNotNullExpressionValue(spacePattern2, "spacePattern");
            split$default = StringsKt__StringsJVMKt.split$default(procStatString, spacePattern2, 0, 2, null);
            Object[] array = split$default.toArray(new String[0]);
            if (array != null) {
                String[] strArr = (String[]) array;
                if (strArr.length < 8) {
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "procStatString is not excepted -> " + procStatString, null, 4, null);
                    return -1.0f;
                }
                long parseLong = Long.parseLong(strArr[1]) + Long.parseLong(strArr[2]) + Long.parseLong(strArr[3]) + Long.parseLong(strArr[4]) + Long.parseLong(strArr[5]) + Long.parseLong(strArr[6]) + Long.parseLong(strArr[7]);
                String appStatString = getAppStatString(pid);
                Intrinsics.checkNotNullExpressionValue(spacePattern2, "spacePattern");
                split$default2 = StringsKt__StringsJVMKt.split$default(appStatString, spacePattern2, 0, 2, null);
                Object[] array2 = split$default2.toArray(new String[0]);
                if (array2 != null) {
                    String[] strArr2 = (String[]) array2;
                    if (strArr2.length < 15) {
                        SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "appStatString is not excepted -> " + appStatString, null, 4, null);
                        return -1.0f;
                    }
                    long parseLong2 = Long.parseLong(strArr2[13]) + Long.parseLong(strArr2[14]);
                    long j3 = lastCpuTime;
                    if (j3 != 0 && j3 != parseLong) {
                        float f16 = ((float) (parseLong2 - lastAppCpuTime)) / ((float) (parseLong - j3));
                        lastCpuTime = parseLong;
                        lastAppCpuTime = parseLong2;
                        return f16;
                    }
                    lastCpuTime = parseLong;
                    lastAppCpuTime = parseLong2;
                    return -1.0f;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        } catch (IOException e16) {
            SquareBaseKt.getSquareLog().e(TAG, "get cpu data error", e16);
            return -1.0f;
        } catch (ArrayIndexOutOfBoundsException e17) {
            SquareBaseKt.getSquareLog().e(TAG, "get cpu data error", e17);
            return -1.0f;
        } catch (NumberFormatException e18) {
            SquareBaseKt.getSquareLog().e(TAG, "get cpu data error", e18);
            return -1.0f;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0067, code lost:
    
        if (r2 == null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x006a, code lost:
    
        com.tencent.state.square.util.CpuUtil.useFallback = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0071, code lost:
    
        return getCpuDataForOWhenRelease(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005b, code lost:
    
        r2.destroy();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0059, code lost:
    
        if (r2 == null) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final float getCpuDataForOWhenDebug(int pid) {
        Process process = null;
        try {
            try {
                process = RuntimeMonitor.exec(Runtime.getRuntime(), "top -n 1 -p " + pid + " -o %CPU -b");
                Intrinsics.checkNotNullExpressionValue(process, "process");
                float parseFloat = (Float.parseFloat(getCpuLineString(new InputStreamReader(process.getInputStream()))) / 100.0f) / Runtime.getRuntime().availableProcessors();
                process.destroy();
                return parseFloat;
            } catch (IOException e16) {
                SquareBaseKt.getSquareLog().e(TAG, "get cpu data error", e16);
            } catch (NumberFormatException e17) {
                SquareBaseKt.getSquareLog().e(TAG, "get cpu data error", e17);
            }
        } catch (Throwable th5) {
            if (process != null) {
                process.destroy();
            }
            throw th5;
        }
    }

    private final float getCpuDataForOWhenRelease(int pid) {
        List split$default;
        try {
            String appStatString = getAppStatString(pid);
            Pattern spacePattern2 = spacePattern;
            Intrinsics.checkNotNullExpressionValue(spacePattern2, "spacePattern");
            split$default = StringsKt__StringsJVMKt.split$default(appStatString, spacePattern2, 0, 2, null);
            Object[] array = split$default.toArray(new String[0]);
            if (array != null) {
                String[] strArr = (String[]) array;
                if (strArr.length < 15) {
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "appStatString is not excepted -> " + appStatString, null, 4, null);
                    return -1.0f;
                }
                long parseLong = Long.parseLong(strArr[13]) + Long.parseLong(strArr[14]);
                long uptimeMillis = SystemClock.uptimeMillis();
                long j3 = lastUptimeMillis;
                if (j3 != 0 && j3 != uptimeMillis) {
                    float countCpuCore = ((((float) (uptimeMillis - j3)) * countCpuCore()) * ((float) getJiffyHz())) / 1000;
                    if (countCpuCore < 1) {
                        return -1.0f;
                    }
                    float f16 = ((float) (parseLong - lastAppCpuTime)) / countCpuCore;
                    lastUptimeMillis = uptimeMillis;
                    lastAppCpuTime = parseLong;
                    return f16;
                }
                lastUptimeMillis = uptimeMillis;
                lastAppCpuTime = parseLong;
                return 0.0f;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        } catch (IOException | ArrayIndexOutOfBoundsException | NumberFormatException unused) {
            return 0.0f;
        }
    }

    private final String getCpuLineString(Reader reader) throws IOException {
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
                if (Intrinsics.compare((int) str.charAt(i16), 32) <= 0) {
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
                        if (Intrinsics.compare((int) readLine2.charAt(i3), 32) <= 0) {
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

    public static /* synthetic */ float getCpuUsage$default(CpuUtil cpuUtil, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = Process.myPid();
        }
        return cpuUtil.getCpuUsage(i3);
    }

    private final long getJiffyHz() {
        return ((Number) jiffyHz.getValue()).longValue();
    }

    private final String getProcStatString() throws IOException {
        RandomAccessFile randomAccessFile = procStatFile;
        if (randomAccessFile == null) {
            randomAccessFile = new RandomAccessFile("/proc/stat", "r");
            procStatFile = randomAccessFile;
        } else {
            randomAccessFile.seek(0L);
        }
        return readLineBuffered(randomAccessFile);
    }

    private final String readLineBuffered(RandomAccessFile input) throws IOException {
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
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                sb5.append(substring);
                break;
            }
            sb5.append(str);
            read = input.read(bArr);
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "sb.toString()");
        return sb6;
    }

    public final float getCpuUsage(int pid) {
        float cPUDataUnderO;
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = lastGetTime;
        if (j3 == 0) {
            lastGetTime = currentTimeMillis;
        } else if (currentTimeMillis - j3 < 10) {
            return lastCpuUsage;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            if (useFallback) {
                cPUDataUnderO = getCpuDataForOWhenRelease(pid);
            } else {
                cPUDataUnderO = getCpuDataForOWhenDebug(pid);
            }
        } else {
            cPUDataUnderO = getCPUDataUnderO(pid);
        }
        lastCpuUsage = cPUDataUnderO;
        if (cPUDataUnderO == -1.0f) {
            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "get cpuUsage error.", null, 4, null);
        }
        return cPUDataUnderO;
    }
}
