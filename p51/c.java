package p51;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.tencent.minibox.common.log.LogUtils;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.api.ProcessConstant;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\f\u001a\u00020\u0004R\u0016\u0010\u000e\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\rR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lp51/c;", "", "Landroid/content/Context;", "context", "", "e", "", "f", "d", "", "a", "c", "b", "Ljava/lang/String;", "mCurProcessName", "Ljava/lang/Boolean;", "mIsArm64", "<init>", "()V", "MiniBoxLoader_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes9.dex */
public final class c {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static Boolean mIsArm64;

    /* renamed from: c, reason: collision with root package name */
    public static final c f425348c = new c();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static String mCurProcessName = "";

    c() {
    }

    @JvmStatic
    public static final boolean d(@NotNull Context context) {
        boolean startsWith$default;
        boolean endsWith$default;
        Intrinsics.checkParameterIsNotNull(context, "context");
        Object systemService = context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        if (systemService != null) {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) systemService);
            if (runningAppProcesses != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    String str = runningAppProcessInfo.processName;
                    Intrinsics.checkExpressionValueIsNotNull(str, "it.processName");
                    String packageName = context.getPackageName();
                    Intrinsics.checkExpressionValueIsNotNull(packageName, "context.packageName");
                    startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, packageName, false, 2, null);
                    if (startsWith$default) {
                        String str2 = runningAppProcessInfo.processName;
                        Intrinsics.checkExpressionValueIsNotNull(str2, "it.processName");
                        endsWith$default = StringsKt__StringsJVMKt.endsWith$default(str2, "miniboxapp", false, 2, null);
                        if (endsWith$default) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.ActivityManager");
    }

    @JvmStatic
    public static final boolean e(@NotNull Context context) {
        boolean startsWith$default;
        boolean endsWith$default;
        boolean endsWith$default2;
        Intrinsics.checkParameterIsNotNull(context, "context");
        Object systemService = context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        if (systemService != null) {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) systemService);
            if (runningAppProcesses != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    String str = runningAppProcessInfo.processName;
                    Intrinsics.checkExpressionValueIsNotNull(str, "it.processName");
                    String packageName = context.getPackageName();
                    Intrinsics.checkExpressionValueIsNotNull(packageName, "context.packageName");
                    startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, packageName, false, 2, null);
                    if (startsWith$default) {
                        String str2 = runningAppProcessInfo.processName;
                        Intrinsics.checkExpressionValueIsNotNull(str2, "it.processName");
                        endsWith$default = StringsKt__StringsJVMKt.endsWith$default(str2, ProcessConstant.MINI_BOX_CORE, false, 2, null);
                        if (!endsWith$default) {
                            String str3 = runningAppProcessInfo.processName;
                            Intrinsics.checkExpressionValueIsNotNull(str3, "it.processName");
                            endsWith$default2 = StringsKt__StringsJVMKt.endsWith$default(str3, "miniboxapp", false, 2, null);
                            if (endsWith$default2) {
                                return true;
                            }
                        } else {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.ActivityManager");
    }

    @JvmStatic
    public static final void f(@NotNull Context context) {
        boolean startsWith$default;
        boolean endsWith$default;
        boolean endsWith$default2;
        Intrinsics.checkParameterIsNotNull(context, "context");
        Object systemService = context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        if (systemService != null) {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) systemService);
            if (runningAppProcesses != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    String str = runningAppProcessInfo.processName;
                    Intrinsics.checkExpressionValueIsNotNull(str, "it.processName");
                    String packageName = context.getPackageName();
                    Intrinsics.checkExpressionValueIsNotNull(packageName, "context.packageName");
                    startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, packageName, false, 2, null);
                    if (startsWith$default) {
                        String str2 = runningAppProcessInfo.processName;
                        Intrinsics.checkExpressionValueIsNotNull(str2, "it.processName");
                        endsWith$default = StringsKt__StringsJVMKt.endsWith$default(str2, ProcessConstant.MINI_BOX_CORE, false, 2, null);
                        if (!endsWith$default) {
                            String str3 = runningAppProcessInfo.processName;
                            Intrinsics.checkExpressionValueIsNotNull(str3, "it.processName");
                            endsWith$default2 = StringsKt__StringsJVMKt.endsWith$default(str3, "miniboxapp", false, 2, null);
                            if (endsWith$default2) {
                            }
                        }
                        SystemMethodProxy.killProcess(runningAppProcessInfo.pid);
                    }
                }
                return;
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.ActivityManager");
    }

    @NotNull
    public final String a(@NotNull Context context) {
        boolean z16;
        Intrinsics.checkParameterIsNotNull(context, "context");
        if (mCurProcessName.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return mCurProcessName;
        }
        int myPid = Process.myPid();
        Object systemService = context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        if (systemService != null) {
            String str = "";
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : SystemMethodProxy.getRunningAppProcesses((ActivityManager) systemService)) {
                if (runningAppProcessInfo.pid == myPid) {
                    str = runningAppProcessInfo.processName;
                    Intrinsics.checkExpressionValueIsNotNull(str, "process.processName");
                }
            }
            mCurProcessName = str;
            return str;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.ActivityManager");
    }

    public final boolean b() {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 26) {
            LogUtils.e("ProcessUtil", "isArm64Runtime: do not support.version=" + i3);
            return false;
        }
        Boolean bool = mIsArm64;
        if (bool != null) {
            if (bool == null) {
                Intrinsics.throwNpe();
            }
            return bool.booleanValue();
        }
        Boolean valueOf = Boolean.valueOf(Process.is64Bit());
        mIsArm64 = valueOf;
        if (valueOf == null) {
            Intrinsics.throwNpe();
        }
        return valueOf.booleanValue();
    }

    public final boolean c(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        return Intrinsics.areEqual(a(context), context.getPackageName());
    }
}
