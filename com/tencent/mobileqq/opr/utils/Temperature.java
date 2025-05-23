package com.tencent.mobileqq.opr.utils;

import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.opr.utils.Temperature;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt__FileReadWriteKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u0003B\u0007\u00a2\u0006\u0004\b\f\u0010\rR\u001d\u0010\u0007\u001a\u0004\u0018\u00010\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\b8F\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/opr/utils/Temperature;", "", "", "a", "Lkotlin/Lazy;", "c", "()Ljava/lang/String;", "path", "", "d", "()Ljava/lang/Integer;", "value", "<init>", "()V", "b", "opr_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public final class Temperature {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final a f257067b;

    /* renamed from: c, reason: collision with root package name */
    @Deprecated
    @NotNull
    private static final List<String> f257068c;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy path;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\t\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0002J\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005*\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\b\u001a\u0004\u0018\u00010\u0005*\u00020\u0005H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u000b\u001a\u0004\u0018\u00010\u0002*\u00020\nH\u0002J\b\u0010\f\u001a\u0004\u0018\u00010\u0002R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/opr/utils/Temperature$a;", "", "", "targetType", "c", "", "i", "(Ljava/lang/String;)Ljava/lang/Integer;", h.F, "(I)Ljava/lang/Integer;", "Ljava/io/File;", "j", "f", "", "CPU_TEMPERATURE_FILE", "Ljava/util/List;", "g", "()Ljava/util/List;", "TAG", "Ljava/lang/String;", "<init>", "()V", "opr_debug"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes16.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        private final String c(String targetType) {
            File[] listFiles = new File("/sys/class/thermal").listFiles(new FileFilter() { // from class: com.tencent.mobileqq.opr.utils.c
                @Override // java.io.FileFilter
                public final boolean accept(File file) {
                    boolean e16;
                    e16 = Temperature.a.e(file);
                    return e16;
                }
            });
            if (listFiles == null) {
                return null;
            }
            int length = listFiles.length;
            int i3 = 0;
            while (i3 < length) {
                File file = listFiles[i3];
                i3++;
                if (Intrinsics.areEqual(j(new File(file, "type")), targetType)) {
                    String tempPath = new File(file, FaceUtil.IMG_TEMP).getAbsolutePath();
                    Intrinsics.checkNotNullExpressionValue(tempPath, "tempPath");
                    if (i(tempPath) != null) {
                        return tempPath;
                    }
                }
            }
            return null;
        }

        static /* synthetic */ String d(a aVar, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = "shell_front";
            }
            return aVar.c(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean e(File file) {
            boolean startsWith$default;
            if (!file.isDirectory()) {
                return false;
            }
            String name = file.getName();
            Intrinsics.checkNotNullExpressionValue(name, "file.name");
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(name, "thermal_zone", false, 2, null);
            if (!startsWith$default) {
                return false;
            }
            return true;
        }

        private final Integer h(int i3) {
            boolean z16;
            IntRange intRange = new IntRange(-30, 250);
            int first = intRange.getFirst();
            boolean z17 = true;
            if (i3 <= intRange.getLast() && first <= i3) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return Integer.valueOf(i3);
            }
            int first2 = intRange.getFirst();
            int last = intRange.getLast();
            int i16 = i3 / 1000;
            if (first2 > i16 || i16 > last) {
                z17 = false;
            }
            if (z17) {
                return Integer.valueOf(i16);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Integer i(String str) {
            BufferedReader bufferedReader;
            Integer intOrNull;
            Integer h16;
            if (!com.tencent.qne.util.a.c(str)) {
                return null;
            }
            try {
                Reader inputStreamReader = new InputStreamReader(new FileInputStream(new File(str)), Charsets.UTF_8);
                if (inputStreamReader instanceof BufferedReader) {
                    bufferedReader = (BufferedReader) inputStreamReader;
                } else {
                    bufferedReader = new BufferedReader(inputStreamReader, 8192);
                }
                try {
                    String readLine = bufferedReader.readLine();
                    Intrinsics.checkNotNullExpressionValue(readLine, "it.readLine()");
                    intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(readLine);
                    if (intOrNull == null) {
                        h16 = null;
                    } else {
                        h16 = Temperature.f257067b.h(intOrNull.intValue());
                    }
                    CloseableKt.closeFinally(bufferedReader, null);
                    return h16;
                } finally {
                }
            } catch (Throwable unused) {
                return null;
            }
        }

        private final String j(File file) {
            String readText$default;
            CharSequence trim;
            if (file.exists()) {
                try {
                    readText$default = FilesKt__FileReadWriteKt.readText$default(file, null, 1, null);
                    if (readText$default != null) {
                        trim = StringsKt__StringsKt.trim((CharSequence) readText$default);
                        return trim.toString();
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                } catch (Throwable unused) {
                    return null;
                }
            }
            return null;
        }

        @Nullable
        public final String f() {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            Object obj = null;
            String d16 = d(this, null, 1, null);
            if (d16 == null) {
                Iterator<T> it = g().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (Temperature.f257067b.i((String) next) != null) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        obj = next;
                        break;
                    }
                }
                return (String) obj;
            }
            return d16;
        }

        @NotNull
        public final List<String> g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return Temperature.f257068c;
            }
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        List<String> listOf;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10957);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f257067b = new a(null);
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"/sys/devices/system/cpu/cpu0/cpufreq/cpu_temp", "/sys/devices/system/cpu/cpu0/cpufreq/FakeShmoo_cpu_temp", "/sys/class/thermal/thermal_zone0/temp", "/sys/class/i2c-adapter/i2c-4/4-004c/temperature", "/sys/devices/platform/tegra-i2c.3/i2c-4/4-004c/temperature", "/sys/devices/platform/omap/omap_temp_sensor.0/temperature", "/sys/devices/platform/tegra_tmon/temp1_input", "/sys/kernel/debug/tegra_thermal/temp_tj", "/sys/devices/platform/s5p-tmu/temperature", "/sys/class/thermal/thermal_zone1/temp", "/sys/class/hwmon/hwmon0/device/temp1_input", "/sys/devices/virtual/thermal/thermal_zone1/temp", "/sys/devices/virtual/thermal/thermal_zone0/temp", "/sys/class/thermal/thermal_zone3/temp", "/sys/class/thermal/thermal_zone4/temp", "/sys/class/hwmon/hwmonX/temp1_input", "/sys/devices/platform/s5p-tmu/curr_temp"});
        f257068c = listOf;
    }

    public Temperature() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(Temperature$path$2.INSTANCE);
            this.path = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String c() {
        return (String) this.path.getValue();
    }

    @Nullable
    public final Integer d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Integer) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        String c16 = c();
        if (c16 != null) {
            return f257067b.i(c16);
        }
        return null;
    }
}
