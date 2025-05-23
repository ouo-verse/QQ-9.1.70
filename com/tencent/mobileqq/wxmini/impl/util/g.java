package com.tencent.mobileqq.wxmini.impl.util;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0006\u0010\n\u001a\u00020\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/wxmini/impl/util/g;", "", "Landroid/app/ActivityManager$RecentTaskInfo;", "", "a", "Landroid/app/ActivityManager$AppTask;", "appTask", "", "c", "", "b", "<init>", "()V", "wxmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f327781a = new g();

    g() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v6 */
    private final String a(ActivityManager.RecentTaskInfo recentTaskInfo) {
        Intent intent;
        ComponentName componentName;
        ComponentName componentName2;
        ComponentName componentName3;
        int i3;
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("RecentTaskInfo{id=");
                sb5.append(recentTaskInfo.id);
                sb5.append(" persistentId=");
                sb5.append(recentTaskInfo.persistentId);
                sb5.append(" baseIntent=");
                intent = recentTaskInfo.baseIntent;
                sb5.append(intent);
                sb5.append(" baseActivity=");
                componentName = recentTaskInfo.baseActivity;
                sb5.append(componentName);
                sb5.append(" topActivity=");
                componentName2 = recentTaskInfo.topActivity;
                sb5.append(componentName2);
                sb5.append(" origActivity=");
                componentName3 = recentTaskInfo.origActivity;
                sb5.append(componentName3);
                sb5.append(" numActivities=");
                i3 = recentTaskInfo.numActivities;
                sb5.append(i3);
                sb5.append('}');
                recentTaskInfo = sb5.toString();
            } else {
                String obj = recentTaskInfo.toString();
                Intrinsics.checkNotNullExpressionValue(obj, "{\n                this.toString()\n            }");
                recentTaskInfo = obj;
            }
            return recentTaskInfo;
        } catch (Throwable unused) {
            String obj2 = recentTaskInfo.toString();
            Intrinsics.checkNotNullExpressionValue(obj2, "{\n            this.toString()\n        }");
            return obj2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0007, code lost:
    
        r6 = r6.baseIntent;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean c(ActivityManager.AppTask appTask) {
        Intent intent;
        ComponentName component;
        boolean startsWith$default;
        ActivityManager.RecentTaskInfo taskInfo = appTask.getTaskInfo();
        if (taskInfo != null && intent != null && !Intrinsics.areEqual(intent.getAction(), "android.intent.action.MAIN")) {
            Set<String> categories = intent.getCategories();
            if ((categories != null && categories.contains("android.intent.category.LAUNCHER")) || (component = intent.getComponent()) == null) {
                return false;
            }
            String className = component.getClassName();
            Intrinsics.checkNotNullExpressionValue(className, "cmp.className");
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(className, "com.tencent.luggage.wxa.standalone_open_runtime.container.WxaContainerMultiTaskActivity", false, 2, null);
            if (startsWith$default) {
                return true;
            }
        }
        return false;
    }

    public final void b() {
        List<ActivityManager.AppTask> appTasks;
        String str;
        Object m476constructorimpl;
        ActivityManager activityManager = (ActivityManager) ContextCompat.getSystemService(MobileQQ.sMobileQQ, ActivityManager.class);
        if (activityManager == null || (appTasks = activityManager.getAppTasks()) == null) {
            return;
        }
        for (ActivityManager.AppTask appTask : appTasks) {
            try {
                ActivityManager.RecentTaskInfo taskInfo = appTask.getTaskInfo();
                if (taskInfo != null) {
                    g gVar = f327781a;
                    Intrinsics.checkNotNullExpressionValue(taskInfo, "taskInfo");
                    str = gVar.a(taskInfo);
                } else {
                    str = null;
                }
                g gVar2 = f327781a;
                Intrinsics.checkNotNullExpressionValue(appTask, "appTask");
                if (gVar2.c(appTask)) {
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        appTask.finishAndRemoveTask();
                        m476constructorimpl = Result.m476constructorimpl(Boolean.TRUE);
                    } catch (Throwable th5) {
                        Result.Companion companion2 = Result.INSTANCE;
                        m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
                    }
                    QLog.i("WxProcessKiller", 1, "kill AppBrand task:" + str + ", result:" + ((Object) Result.m484toStringimpl(m476constructorimpl)));
                }
            } catch (RuntimeException e16) {
                QLog.e("WxProcessKiller", 1, "forceKillAllAppBrandTasks dump task failed " + e16);
            }
        }
    }
}
