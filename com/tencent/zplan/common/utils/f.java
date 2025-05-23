package com.tencent.zplan.common.utils;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.lang.reflect.Method;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0003J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0016\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0002J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/zplan/common/utils/f;", "", "", "d", "c", "Landroid/content/Context;", "context", "b", "target", "", "e", "a", "<init>", "()V", "common_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f385292a = new f();

    f() {
    }

    private final String b(Context context) {
        int myPid = Process.myPid();
        Object systemService = context.getApplicationContext().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        if (systemService != null) {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) systemService);
            if (runningAppProcesses != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.pid == myPid) {
                        return runningAppProcessInfo.processName;
                    }
                }
                return null;
            }
            return null;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
    }

    @SuppressLint({"PrivateApi", "DiscouragedPrivateApi"})
    private final String c() {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            Intrinsics.checkNotNullExpressionValue(declaredMethod, "Class.forName(\n         \u2026rayOfNulls<Class<*>?>(0))");
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            Intrinsics.checkNotNullExpressionValue(invoke, "declaredMethod.invoke(null, arrayOfNulls<Any>(0))");
            if (invoke instanceof String) {
                return (String) invoke;
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        return null;
    }

    private final String d() {
        String processName;
        if (Build.VERSION.SDK_INT >= 28) {
            processName = Application.getProcessName();
            return processName;
        }
        return null;
    }

    @Nullable
    public final String a(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String d16 = d();
        if (!TextUtils.isEmpty(d16)) {
            return d16;
        }
        String c16 = c();
        if (!TextUtils.isEmpty(c16)) {
            return c16;
        }
        return b(context);
    }

    public final boolean e(@NotNull Context context, @NotNull String target) {
        boolean endsWith$default;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(target, "target");
        String a16 = a(context);
        if (a16 != null) {
            endsWith$default = StringsKt__StringsJVMKt.endsWith$default(a16, target, false, 2, null);
            return endsWith$default;
        }
        return false;
    }
}
