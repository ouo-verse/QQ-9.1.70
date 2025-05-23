package com.tencent.state.square.util;

import android.app.ActivityManager;
import android.app.Application;
import android.os.Build;
import android.os.Debug;
import android.os.Process;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\u0006\u0010\f\u001a\u00020\u0004J\b\u0010\r\u001a\u00020\u000eH\u0002J\u0012\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0002J\u0012\u0010\u0012\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007J\u0012\u0010\u0013\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0002J\u0006\u0010\u0014\u001a\u00020\u0004R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/state/square/util/MemoryUtil;", "", "()V", "MIN_INTERVAL_FOR_GET_MEM_INFO", "", "TAG", "", "lastGetPssTimeStamp", "lastMemInfo", "Landroid/os/Debug$MemoryInfo;", "sTotalMemory", "getDebugMemoryInfo", "getFreeMem", "getMemInfo", "", "getPssMemoryInfo", "pid", "", "getRoughPssMemoryInfoInner", "getThrottledMemoryInfo", "getTotalMem", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public final class MemoryUtil {

    @NotNull
    public static final MemoryUtil INSTANCE = new MemoryUtil();

    @JvmField
    public static long MIN_INTERVAL_FOR_GET_MEM_INFO = 10000;
    private static final String TAG = "MemoryUtil";
    private static long lastGetPssTimeStamp;
    private static Debug.MemoryInfo lastMemInfo;
    private static long sTotalMemory;

    MemoryUtil() {
    }

    private final Debug.MemoryInfo getDebugMemoryInfo() {
        Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
        Debug.getMemoryInfo(memoryInfo);
        return memoryInfo;
    }

    private final long[] getMemInfo() {
        long[] jArr = new long[4];
        try {
            Class<?> cls = Class.forName("android.os.Process");
            Intrinsics.checkNotNullExpressionValue(cls, "Class.forName(\"android.os.Process\")");
            Method method = cls.getMethod("readProcLines", (Class[]) Arrays.copyOf(new Class[]{String.class, String[].class, long[].class}, 3));
            Intrinsics.checkNotNullExpressionValue(method, "procClazz.getMethod(\n   \u2026*paramTypes\n            )");
            long[] jArr2 = {0, 0, 0, 0};
            Object[] objArr = {"/proc/meminfo", new String[]{"MemTotal:", "MemFree:", "Buffers:", "Cached:"}, jArr2};
            if (method != null) {
                method.invoke(null, Arrays.copyOf(objArr, 3));
                for (int i3 = 0; i3 < 4; i3++) {
                    jArr[i3] = jArr2[i3] / 1024;
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return jArr;
    }

    private final Debug.MemoryInfo getPssMemoryInfo(int pid) {
        Debug.MemoryInfo throttledMemoryInfo;
        if (Build.VERSION.SDK_INT > 28 && pid == Process.myPid()) {
            throttledMemoryInfo = getDebugMemoryInfo();
        } else {
            throttledMemoryInfo = getThrottledMemoryInfo(pid);
        }
        SquareBaseKt.getSquareLog().d(TAG, "process:" + pid + " pss is " + throttledMemoryInfo.getTotalPss() + ", nativePss is " + throttledMemoryInfo.nativePss);
        return throttledMemoryInfo;
    }

    static /* synthetic */ Debug.MemoryInfo getPssMemoryInfo$default(MemoryUtil memoryUtil, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = Process.myPid();
        }
        return memoryUtil.getPssMemoryInfo(i3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0016, code lost:
    
        if ((r0 - r2) <= com.tencent.state.square.util.MemoryUtil.MIN_INTERVAL_FOR_GET_MEM_INFO) goto L9;
     */
    @JvmStatic
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Debug.MemoryInfo getRoughPssMemoryInfoInner(int pid) {
        long currentTimeMillis = System.currentTimeMillis();
        if (lastMemInfo != null) {
            long j3 = lastGetPssTimeStamp;
            if (j3 != 0) {
            }
        }
        lastMemInfo = INSTANCE.getPssMemoryInfo(pid);
        lastGetPssTimeStamp = currentTimeMillis;
        Debug.MemoryInfo memoryInfo = lastMemInfo;
        if (memoryInfo == null) {
            return new Debug.MemoryInfo();
        }
        return memoryInfo;
    }

    public static /* synthetic */ Debug.MemoryInfo getRoughPssMemoryInfoInner$default(int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = Process.myPid();
        }
        return getRoughPssMemoryInfoInner(i3);
    }

    private final Debug.MemoryInfo getThrottledMemoryInfo(int pid) {
        Object obj;
        Application app = SquareBase.INSTANCE.getApp();
        Debug.MemoryInfo[] memoryInfoArr = null;
        if (app != null) {
            obj = app.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        } else {
            obj = null;
        }
        if (!(obj instanceof ActivityManager)) {
            obj = null;
        }
        ActivityManager activityManager = (ActivityManager) obj;
        boolean z16 = true;
        if (activityManager != null) {
            try {
                memoryInfoArr = SystemMethodProxy.getProcessMemoryInfo(activityManager, new int[]{pid});
            } catch (Exception e16) {
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "error " + e16, null, 4, null);
            }
        }
        if (memoryInfoArr != null) {
            if (memoryInfoArr.length != 0) {
                z16 = false;
            }
            if (!z16) {
                return memoryInfoArr[0];
            }
        }
        SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "getThrottledMemoryInfo get memInfo failed.", null, 4, null);
        return new Debug.MemoryInfo();
    }

    static /* synthetic */ Debug.MemoryInfo getThrottledMemoryInfo$default(MemoryUtil memoryUtil, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = Process.myPid();
        }
        return memoryUtil.getThrottledMemoryInfo(i3);
    }

    public final long getFreeMem() {
        long[] memInfo = getMemInfo();
        return memInfo[1] + memInfo[2] + memInfo[3];
    }

    public final long getTotalMem() {
        if (sTotalMemory == 0) {
            sTotalMemory = getMemInfo()[0];
        }
        return sTotalMemory;
    }
}
