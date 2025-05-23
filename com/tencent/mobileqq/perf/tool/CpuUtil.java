package com.tencent.mobileqq.perf.tool;

import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.RuntimeMonitor;
import com.tencent.qphone.base.util.QLog;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b3\u00104J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\f\u001a\u00020\nH\u0002J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0012\u001a\u00020\u0002R\u0016\u0010\u0015\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0014R\u001b\u0010\u001a\u001a\u00020\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001cR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u001eR\u0018\u0010 \u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001eR\u0016\u0010\"\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010!R\u0016\u0010$\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010!R\u0016\u0010%\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010!R \u0010)\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010'\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010(R\u001c\u0010-\u001a\n +*\u0004\u0018\u00010*0*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010,R\u0016\u00100\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00102\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010!\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/perf/tool/CpuUtil;", "", "", "pid", "", "c", "e", "d", "Ljava/io/Reader;", "reader", "", "f", "j", "b", "Ljava/io/RandomAccessFile;", "input", "k", "g", "a", "", "Z", "useFallback", "", "Lkotlin/Lazy;", "i", "()J", "jiffyHz", "", "[B", "buffer", "Ljava/io/RandomAccessFile;", "procStatFile", "appStatFile", "J", "lastCpuTime", tl.h.F, "lastAppCpuTime", "lastUptimeMillis", "", "Ljava/io/File;", "[Ljava/io/File;", "cpuFreqFile", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "Ljava/util/regex/Pattern;", "spacePattern", "l", UserInfo.SEX_FEMALE, "lastCpuUsage", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "lastGetTime", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class CpuUtil {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final CpuUtil f258160a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean useFallback;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy jiffyHz;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final byte[] buffer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static RandomAccessFile procStatFile;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static RandomAccessFile appStatFile;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static long lastCpuTime;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static long lastAppCpuTime;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static long lastUptimeMillis;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static File[] cpuFreqFile;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private static final Pattern spacePattern;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private static float lastCpuUsage;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private static long lastGetTime;

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44980);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        f258160a = new CpuUtil();
        lazy = LazyKt__LazyJVMKt.lazy(CpuUtil$jiffyHz$2.INSTANCE);
        jiffyHz = lazy;
        buffer = new byte[512];
        spacePattern = Pattern.compile("\\s+");
        lastCpuUsage = -1.0f;
    }

    CpuUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String b(int pid) throws IOException {
        RandomAccessFile randomAccessFile = appStatFile;
        if (randomAccessFile == null) {
            randomAccessFile = new RandomAccessFile("/proc/" + pid + "/stat", "r");
            appStatFile = randomAccessFile;
        } else {
            randomAccessFile.seek(0L);
        }
        return k(randomAccessFile);
    }

    private final float c(int pid) {
        List split$default;
        List split$default2;
        try {
            String j3 = j();
            Pattern spacePattern2 = spacePattern;
            Intrinsics.checkNotNullExpressionValue(spacePattern2, "spacePattern");
            split$default = StringsKt__StringsJVMKt.split$default(j3, spacePattern2, 0, 2, null);
            Object[] array = split$default.toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            String[] strArr = (String[]) array;
            if (strArr.length < 8) {
                QLog.e("CpuUtil", 1, "procStatString is not excepted -> " + j3);
                return -1.0f;
            }
            long parseLong = Long.parseLong(strArr[1]) + Long.parseLong(strArr[2]) + Long.parseLong(strArr[3]) + Long.parseLong(strArr[4]) + Long.parseLong(strArr[5]) + Long.parseLong(strArr[6]) + Long.parseLong(strArr[7]);
            String b16 = b(pid);
            Intrinsics.checkNotNullExpressionValue(spacePattern2, "spacePattern");
            split$default2 = StringsKt__StringsJVMKt.split$default(b16, spacePattern2, 0, 2, null);
            Object[] array2 = split$default2.toArray(new String[0]);
            Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            String[] strArr2 = (String[]) array2;
            if (strArr2.length < 15) {
                QLog.e("CpuUtil", 1, "appStatString is not excepted -> " + b16);
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
        } catch (IOException e16) {
            QLog.e("CpuUtil", 1, "get cpu data error", e16);
            return -1.0f;
        } catch (ArrayIndexOutOfBoundsException e17) {
            QLog.e("CpuUtil", 1, "get cpu data error", e17);
            return -1.0f;
        } catch (NumberFormatException e18) {
            QLog.e("CpuUtil", 1, "get cpu data error", e18);
            return -1.0f;
        } catch (OutOfMemoryError e19) {
            QLog.e("CpuUtil", 1, "get cpu data error", e19);
            return -1.0f;
        }
    }

    private final float d(int pid) {
        Process process = null;
        try {
            process = RuntimeMonitor.exec(Runtime.getRuntime(), "top -n 1 -p " + pid + " -o %CPU -b");
            float parseFloat = (Float.parseFloat(f(new InputStreamReader(process.getInputStream()))) / 100.0f) / Runtime.getRuntime().availableProcessors();
            process.destroy();
            return parseFloat;
        } catch (Throwable th5) {
            try {
                QLog.e("CpuUtil", 1, "get cpu data error", th5);
                useFallback = true;
                return e(pid);
            } finally {
                if (process != null) {
                    process.destroy();
                }
            }
        }
    }

    private final float e(int pid) {
        List split$default;
        try {
            String b16 = b(pid);
            Pattern spacePattern2 = spacePattern;
            Intrinsics.checkNotNullExpressionValue(spacePattern2, "spacePattern");
            split$default = StringsKt__StringsJVMKt.split$default(b16, spacePattern2, 0, 2, null);
            Object[] array = split$default.toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            String[] strArr = (String[]) array;
            if (strArr.length < 15) {
                QLog.e("CpuUtil", 1, "appStatString is not excepted -> " + b16);
                return -1.0f;
            }
            long parseLong = Long.parseLong(strArr[13]) + Long.parseLong(strArr[14]);
            long uptimeMillis = SystemClock.uptimeMillis();
            long j3 = lastUptimeMillis;
            if (j3 != 0 && j3 != uptimeMillis) {
                float a16 = ((((float) (uptimeMillis - j3)) * a()) * ((float) i())) / 1000;
                if (a16 < 1.0f) {
                    return -1.0f;
                }
                float f16 = ((float) (parseLong - lastAppCpuTime)) / a16;
                lastUptimeMillis = uptimeMillis;
                lastAppCpuTime = parseLong;
                return f16;
            }
            lastUptimeMillis = uptimeMillis;
            lastAppCpuTime = parseLong;
            return 0.0f;
        } catch (IOException e16) {
            QLog.e("CpuUtil", 1, "get cpu data error", e16);
            return 0.0f;
        } catch (ArrayIndexOutOfBoundsException e17) {
            QLog.e("CpuUtil", 1, "get cpu data error", e17);
            return 0.0f;
        } catch (NumberFormatException e18) {
            QLog.e("CpuUtil", 1, "get cpu data error", e18);
            return 0.0f;
        }
    }

    private final String f(Reader reader) throws IOException {
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

    public static /* synthetic */ float h(CpuUtil cpuUtil, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = Process.myPid();
        }
        return cpuUtil.g(i3);
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
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
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

    public final int a() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        if (cpuFreqFile == null) {
            File[] fileArr = new File[Runtime.getRuntime().availableProcessors()];
            cpuFreqFile = fileArr;
            Intrinsics.checkNotNull(fileArr);
            int length = fileArr.length;
            for (int i16 = 0; i16 < length; i16++) {
                File[] fileArr2 = cpuFreqFile;
                Intrinsics.checkNotNull(fileArr2);
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("/sys/devices/system/cpu/cpu%d/cpufreq/scaling_cur_freq", Arrays.copyOf(new Object[]{Integer.valueOf(i16)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
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

    public final float g(int pid) {
        float c16;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Float) iPatchRedirector.redirect((short) 2, (Object) this, pid)).floatValue();
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = lastGetTime;
        if (j3 == 0) {
            lastGetTime = currentTimeMillis;
        } else if (currentTimeMillis - j3 < 10) {
            return lastCpuUsage;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            if (useFallback) {
                c16 = e(pid);
            } else {
                c16 = d(pid);
            }
        } else {
            c16 = c(pid);
        }
        lastCpuUsage = c16;
        if (c16 == -1.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.e("CpuUtil", 1, "get cpuUsage error.");
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("CpuUtil", 2, "now cpuUsage is " + c16);
        }
        return c16;
    }
}
