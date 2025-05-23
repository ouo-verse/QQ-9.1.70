package com.tencent.bugly.common.utils;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.bugly.common.utils.AndroidVersion;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.rmonitor.common.logger.Logger;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/bugly/common/utils/ProcessUtil;", "", "()V", "Companion", "bugly-common_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes5.dex */
public final class ProcessUtil {

    @NotNull
    public static final String TAG = "Bugly_ProcessUtil";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static String currProcessName = "";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\n\u001a\u00020\u0004H\u0003J\b\u0010\u000b\u001a\u00020\u0004H\u0003J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0012\u0010\u0012\u001a\u00020\u00112\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/bugly/common/utils/ProcessUtil$Companion;", "", "()V", "TAG", "", "currProcessName", "getCurrentProcessName", "context", "Landroid/content/Context;", "getCurrentProcessNameByActivityManager", "getCurrentProcessNameByActivityThread", "getCurrentProcessNameByApplication", "getProcessNameByCmdLine", "pid", "", "getProcessNameByCmdLineInner", "is64BitProcess", "", "isMainProcess", "bugly-common_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes5.dex */
    public static final class Companion {
        Companion() {
        }

        private final String getCurrentProcessNameByActivityManager(Context context) {
            Object obj;
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
            try {
                int myPid = Process.myPid();
                Object obj2 = null;
                if (context != null) {
                    obj = context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
                } else {
                    obj = null;
                }
                if (obj instanceof ActivityManager) {
                    obj2 = obj;
                }
                ActivityManager activityManager = (ActivityManager) obj2;
                if (activityManager == null || (runningAppProcesses = SystemMethodProxy.getRunningAppProcesses(activityManager)) == null) {
                    return "";
                }
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo != null && runningAppProcessInfo.pid == myPid) {
                        String str = runningAppProcessInfo.processName;
                        Intrinsics.checkExpressionValueIsNotNull(str, "appProcess.processName");
                        return str;
                    }
                }
                return "";
            } catch (Exception e16) {
                Logger.f365497g.e(ProcessUtil.TAG, "getCurrentProcessNameByActivityManager " + e16);
                return "";
            }
        }

        @SuppressLint({"DiscouragedPrivateApi", "PrivateApi"})
        private final String getCurrentProcessNameByActivityThread() {
            try {
                Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
                Intrinsics.checkExpressionValueIsNotNull(declaredMethod, "declaredMethod");
                declaredMethod.setAccessible(true);
                Object obj = null;
                Object invoke = declaredMethod.invoke(null, new Object[0]);
                if (invoke instanceof String) {
                    obj = invoke;
                }
                String str = (String) obj;
                if (str == null) {
                    return "";
                }
                return str;
            } catch (Throwable th5) {
                Logger.f365497g.e(ProcessUtil.TAG, "getCurrentProcessNameByActivityThread " + th5);
                return "";
            }
        }

        @SuppressLint({"NewApi"})
        private final String getCurrentProcessNameByApplication() {
            String processName;
            if (AndroidVersion.INSTANCE.isOverP()) {
                processName = Application.getProcessName();
                Intrinsics.checkExpressionValueIsNotNull(processName, "Application.getProcessName()");
                return processName;
            }
            return "";
        }

        @JvmStatic
        @NotNull
        public final String getCurrentProcessName(@Nullable Context context) {
            if (!TextUtils.isEmpty(ProcessUtil.currProcessName)) {
                return ProcessUtil.currProcessName;
            }
            ProcessUtil.currProcessName = getCurrentProcessNameByApplication();
            if (TextUtils.isEmpty(ProcessUtil.currProcessName)) {
                ProcessUtil.currProcessName = getCurrentProcessNameByActivityThread();
                if (TextUtils.isEmpty(ProcessUtil.currProcessName)) {
                    ProcessUtil.currProcessName = getCurrentProcessNameByActivityManager(context);
                    if (TextUtils.isEmpty(ProcessUtil.currProcessName)) {
                        ProcessUtil.currProcessName = getProcessNameByCmdLine(Process.myPid());
                        if (TextUtils.isEmpty(ProcessUtil.currProcessName)) {
                            ProcessUtil.currProcessName = String.valueOf(Process.myPid());
                            Logger.f365497g.i(ProcessUtil.TAG, "getProcessNameByPid, " + ProcessUtil.currProcessName);
                            return ProcessUtil.currProcessName;
                        }
                        Logger.f365497g.i(ProcessUtil.TAG, "getProcessNameByCmdLine, " + ProcessUtil.currProcessName);
                        return ProcessUtil.currProcessName;
                    }
                    Logger.f365497g.i(ProcessUtil.TAG, "getCurrentProcessNameByActivityManager, " + ProcessUtil.currProcessName);
                    return ProcessUtil.currProcessName;
                }
                Logger.f365497g.i(ProcessUtil.TAG, "getCurrentProcessNameByActivityThread, " + ProcessUtil.currProcessName);
                return ProcessUtil.currProcessName;
            }
            Logger.f365497g.i(ProcessUtil.TAG, "getCurrentProcessNameByApplication, " + ProcessUtil.currProcessName);
            return ProcessUtil.currProcessName;
        }

        @JvmStatic
        @NotNull
        public final String getProcessNameByCmdLine(int pid) {
            boolean z16;
            String processNameByCmdLineInner = getProcessNameByCmdLineInner(pid);
            if (processNameByCmdLineInner != null) {
                if (processNameByCmdLineInner.length() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    return processNameByCmdLineInner;
                }
            }
            return String.valueOf(pid);
        }

        @JvmStatic
        @Nullable
        public final String getProcessNameByCmdLineInner(int pid) {
            FileReader fileReader;
            try {
                fileReader = new FileReader("/proc/" + pid + "/cmdline");
                try {
                    char[] cArr = new char[512];
                    int read = fileReader.read(cArr);
                    Logger.f365497g.d(ProcessUtil.TAG, "getProcessNameByCmdLineInner, ret: " + read);
                    int i3 = 0;
                    while (i3 < 512 && cArr[i3] != ((char) 0)) {
                        i3++;
                    }
                    String substring = new String(cArr).substring(0, i3);
                    Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                    try {
                        fileReader.close();
                    } catch (Throwable unused) {
                    }
                    return substring;
                } catch (Throwable unused2) {
                    if (fileReader == null) {
                        return null;
                    }
                    try {
                        fileReader.close();
                        return null;
                    } catch (Throwable unused3) {
                        return null;
                    }
                }
            } catch (Throwable unused4) {
                fileReader = null;
            }
        }

        @JvmStatic
        public final boolean is64BitProcess(@NotNull Context context) {
            boolean contains$default;
            Intrinsics.checkParameterIsNotNull(context, "context");
            AndroidVersion.Companion companion = AndroidVersion.INSTANCE;
            if (companion.isOverM()) {
                return Process.is64Bit();
            }
            if (companion.isOverIceScreamSandwich()) {
                try {
                    ClassLoader classLoader = context.getClassLoader();
                    Object invoke = classLoader.getClass().getMethod("findLibrary", String.class).invoke(classLoader, "skia");
                    if (invoke != null) {
                        contains$default = StringsKt__StringsKt.contains$default((CharSequence) invoke, (CharSequence) "lib64", false, 2, (Object) null);
                        return contains$default;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
                } catch (Throwable th5) {
                    Logger.f365497g.c(ProcessUtil.TAG, th5);
                }
            }
            return false;
        }

        @JvmStatic
        public final boolean isMainProcess(@Nullable Context context) {
            if (context != null && Intrinsics.areEqual(context.getPackageName(), getCurrentProcessName(context))) {
                return true;
            }
            return false;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @JvmStatic
    @NotNull
    public static final String getCurrentProcessName(@Nullable Context context) {
        return INSTANCE.getCurrentProcessName(context);
    }

    @JvmStatic
    @NotNull
    public static final String getProcessNameByCmdLine(int i3) {
        return INSTANCE.getProcessNameByCmdLine(i3);
    }

    @JvmStatic
    @Nullable
    public static final String getProcessNameByCmdLineInner(int i3) {
        return INSTANCE.getProcessNameByCmdLineInner(i3);
    }

    @JvmStatic
    public static final boolean is64BitProcess(@NotNull Context context) {
        return INSTANCE.is64BitProcess(context);
    }

    @JvmStatic
    public static final boolean isMainProcess(@Nullable Context context) {
        return INSTANCE.isMainProcess(context);
    }
}
