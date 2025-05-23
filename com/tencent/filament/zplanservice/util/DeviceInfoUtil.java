package com.tencent.filament.zplanservice.util;

import android.os.SystemProperties;
import androidx.annotation.Keep;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.RuntimeMonitor;
import io.github.landerlyoung.jenny.NativeProxy;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@NativeProxy(allFields = true, allMethods = true)
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0002J\u0006\u0010\b\u001a\u00020\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/filament/zplanservice/util/DeviceInfoUtil;", "", "()V", "getDeviceModel", "", "getGPUInfo", "getGPUInfoFromSysfs", "getGPUInfoViaReflection", "getGpuName", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class DeviceInfoUtil {

    @NotNull
    public static final DeviceInfoUtil INSTANCE = new DeviceInfoUtil();

    DeviceInfoUtil() {
    }

    private final String getGPUInfo() {
        BufferedReader bufferedReader;
        try {
            Process process = RuntimeMonitor.exec(Runtime.getRuntime(), "getprop ro.hardware.egl");
            Intrinsics.checkNotNullExpressionValue(process, "process");
            InputStream inputStream = process.getInputStream();
            Intrinsics.checkNotNullExpressionValue(inputStream, "process.inputStream");
            Reader inputStreamReader = new InputStreamReader(inputStream, Charsets.UTF_8);
            if (inputStreamReader instanceof BufferedReader) {
                bufferedReader = (BufferedReader) inputStreamReader;
            } else {
                bufferedReader = new BufferedReader(inputStreamReader, 8192);
            }
            try {
                String readLine = bufferedReader.readLine();
                CloseableKt.closeFinally(bufferedReader, null);
                return readLine;
            } finally {
            }
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0013, code lost:
    
        r1 = kotlin.io.FilesKt__FileReadWriteKt.readText$default(r1, null, 1, null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String getGPUInfoFromSysfs() {
        String readText$default;
        CharSequence trim;
        try {
            File file = new File("/sys/class/kgsl/kgsl-3d0/gpu_model");
            if (!file.exists()) {
                file = null;
            }
            if (file == null || readText$default == null) {
                return null;
            }
            trim = StringsKt__StringsKt.trim((CharSequence) readText$default);
            return trim.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    private final String getGPUInfoViaReflection() {
        try {
            Object invoke = SystemProperties.class.getMethod("get", String.class).invoke(null, "ro.hardware.egl");
            if (!(invoke instanceof String)) {
                invoke = null;
            }
            return (String) invoke;
        } catch (Exception unused) {
            return null;
        }
    }

    @NotNull
    public final String getDeviceModel() {
        String model = DeviceInfoMonitor.getModel();
        Intrinsics.checkNotNullExpressionValue(model, "Build.MODEL");
        return model;
    }

    @NotNull
    public final String getGpuName() {
        String gPUInfoFromSysfs = getGPUInfoFromSysfs();
        if (gPUInfoFromSysfs == null) {
            gPUInfoFromSysfs = getGPUInfo();
        }
        if (gPUInfoFromSysfs == null) {
            gPUInfoFromSysfs = getGPUInfoViaReflection();
        }
        if (gPUInfoFromSysfs == null) {
            return "Unknown";
        }
        return gPUInfoFromSysfs;
    }
}
