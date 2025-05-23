package com.tencent.zplan.common.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Debug;
import android.os.Process;
import android.util.Log;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\bR\u0016\u0010\r\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/zplan/common/utils/e;", "", "", "c", "Landroid/content/Context;", "context", "d", "b", "", "pid", "Landroid/os/Debug$MemoryInfo;", "a", "J", "cachedTotalMemory", "<init>", "()V", "common_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static long cachedTotalMemory;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final e f385291b = new e();

    e() {
    }

    @NotNull
    public final Debug.MemoryInfo a(@NotNull Context context, int pid) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        if (systemService != null) {
            ActivityManager activityManager = (ActivityManager) systemService;
            try {
                Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
                if (Build.VERSION.SDK_INT > 28 && pid == Process.myPid()) {
                    Debug.getMemoryInfo(memoryInfo);
                } else {
                    Debug.MemoryInfo[] processMemoryInfo = SystemMethodProxy.getProcessMemoryInfo(activityManager, new int[]{pid});
                    if (processMemoryInfo != null && processMemoryInfo.length > 0) {
                        memoryInfo = processMemoryInfo[0];
                        Intrinsics.checkNotNullExpressionValue(memoryInfo, "memInfos[0]");
                    }
                }
                return memoryInfo;
            } catch (Exception e16) {
                Log.e("MemoryUtil", "getMemoryInfoByPid, ", e16);
                return new Debug.MemoryInfo();
            }
        }
        throw new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
    }

    public final long b(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        if (systemService != null) {
            ActivityManager activityManager = (ActivityManager) systemService;
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            try {
                activityManager.getMemoryInfo(memoryInfo);
                return memoryInfo.availMem / 1024;
            } catch (Exception unused) {
                return -1L;
            }
        }
        throw new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0091 A[Catch: Exception -> 0x008d, TRY_LEAVE, TryCatch #3 {Exception -> 0x008d, blocks: (B:37:0x0089, B:29:0x0091), top: B:36:0x0089 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0089 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long c() {
        FileReader fileReader;
        Throwable th5;
        BufferedReader bufferedReader;
        Exception e16;
        if (cachedTotalMemory == 0) {
            try {
                try {
                    fileReader = new FileReader("/proc/meminfo");
                } catch (Exception e17) {
                    fileReader = null;
                    e16 = e17;
                    bufferedReader = null;
                } catch (Throwable th6) {
                    fileReader = null;
                    th5 = th6;
                    bufferedReader = null;
                }
                try {
                    bufferedReader = new BufferedReader(fileReader, 1024);
                } catch (Exception e18) {
                    e16 = e18;
                    bufferedReader = null;
                } catch (Throwable th7) {
                    th5 = th7;
                    bufferedReader = null;
                    if (bufferedReader != null) {
                    }
                    if (fileReader != null) {
                    }
                    throw th5;
                }
            } catch (Exception e19) {
                Log.e("MemoryUtil", "getSystemTotalMemory finally,", e19);
            }
            try {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        StringBuffer stringBuffer = new StringBuffer();
                        Matcher matcher = Pattern.compile("\\d").matcher(readLine);
                        while (matcher.find()) {
                            stringBuffer.append(matcher.group());
                        }
                        String stringBuffer2 = stringBuffer.toString();
                        Intrinsics.checkNotNullExpressionValue(stringBuffer2, "value.toString()");
                        cachedTotalMemory = Long.parseLong(stringBuffer2);
                    }
                    bufferedReader.close();
                    fileReader.close();
                } catch (Throwable th8) {
                    th5 = th8;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e26) {
                            Log.e("MemoryUtil", "getSystemTotalMemory finally,", e26);
                            throw th5;
                        }
                    }
                    if (fileReader != null) {
                        fileReader.close();
                    }
                    throw th5;
                }
            } catch (Exception e27) {
                e16 = e27;
                cachedTotalMemory = 0L;
                Log.e("MemoryUtil", "getSystemTotalMemory, ", e16);
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (fileReader != null) {
                    fileReader.close();
                }
                return cachedTotalMemory;
            }
        }
        return cachedTotalMemory;
    }

    public final long d(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        if (systemService != null) {
            ActivityManager activityManager = (ActivityManager) systemService;
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            try {
                activityManager.getMemoryInfo(memoryInfo);
                return memoryInfo.totalMem / 1024;
            } catch (Exception unused) {
                return -1L;
            }
        }
        throw new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
    }
}
