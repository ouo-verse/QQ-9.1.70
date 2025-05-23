package com.tencent.richframework.preload.activity;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import androidx.annotation.UiThread;
import androidx.collection.LruCache;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 &2\u00020\u0001:\u0003&'(B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0005H\u0017J\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0005H\u0017J\u0010\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0005H\u0016J \u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\tH\u0016R\u001a\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\t8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u000b\u00a8\u0006)"}, d2 = {"Lcom/tencent/richframework/preload/activity/BaseActivityPreloadTask;", "", "()V", "activityClass", "Ljava/lang/Class;", "Landroid/app/Activity;", "getActivityClass", "()Ljava/lang/Class;", "activityKey", "", "getActivityKey", "()Ljava/lang/String;", "executeMode", "Lcom/tencent/richframework/preload/activity/BaseActivityPreloadTask$ExecuteMode;", "getExecuteMode", "()Lcom/tencent/richframework/preload/activity/BaseActivityPreloadTask$ExecuteMode;", "isReady", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "preloadMode", "Lcom/tencent/richframework/preload/activity/BaseActivityPreloadTask$PreloadMode;", "getPreloadMode", "()Lcom/tencent/richframework/preload/activity/BaseActivityPreloadTask$PreloadMode;", "taskKey", "getTaskKey", QCircleLpReportDc05507.KEY_CLEAR, "", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "doAfterActivityCreate", "doBeforeActivityBeUse", "isTarget", "", "classLoader", "Ljava/lang/ClassLoader;", "activityClassName", "intent", "Landroid/content/Intent;", "toString", "Companion", "ExecuteMode", "PreloadMode", "preload-activity_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public abstract class BaseActivityPreloadTask {
    private static int appThemeId;

    @NotNull
    private final AtomicBoolean isReady = new AtomicBoolean(false);

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final LruCache<Class<?>, Integer> themeIds = new LruCache<>(100);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J\u0012\u0010\f\u001a\u00020\u00042\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0012\u0004\u0012\u00020\u00040\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/richframework/preload/activity/BaseActivityPreloadTask$Companion;", "", "()V", "FAILED_THEME_ID", "", "UNDEFINED_THEME_ID", "appThemeId", "themeIds", "Landroidx/collection/LruCache;", "Ljava/lang/Class;", "getFinalThemeId", "activityTheme", "getThemeId", "targetActivityClass", "preload-activity_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes25.dex */
    public static final class Companion {
        Companion() {
        }

        private final int getFinalThemeId(int activityTheme) {
            int i3;
            if (activityTheme != 0) {
                return activityTheme;
            }
            if (BaseActivityPreloadTask.appThemeId == 0) {
                try {
                    Application application = RFWApplication.getApplication();
                    Intrinsics.checkNotNullExpressionValue(application, "RFWApplication.getApplication()");
                    PackageManager packageManager = application.getPackageManager();
                    Application application2 = RFWApplication.getApplication();
                    Intrinsics.checkNotNullExpressionValue(application2, "RFWApplication.getApplication()");
                    i3 = packageManager.getApplicationInfo(application2.getPackageName(), 0).theme;
                } catch (Exception unused) {
                    i3 = Integer.MIN_VALUE;
                }
                BaseActivityPreloadTask.appThemeId = i3;
            }
            return BaseActivityPreloadTask.appThemeId;
        }

        public final int getThemeId(@NotNull Class<?> targetActivityClass) {
            Intrinsics.checkNotNullParameter(targetActivityClass, "targetActivityClass");
            try {
                Integer num = (Integer) BaseActivityPreloadTask.themeIds.get(targetActivityClass);
                if (num == null) {
                    ComponentName componentName = new ComponentName(RFWApplication.getApplication(), targetActivityClass);
                    Application application = RFWApplication.getApplication();
                    Intrinsics.checkNotNullExpressionValue(application, "RFWApplication.getApplication()");
                    ActivityInfo activityInfo = application.getPackageManager().getActivityInfo(componentName, 0);
                    Intrinsics.checkNotNullExpressionValue(activityInfo, "RFWApplication.getApplic\u2026ityInfo(componentName, 0)");
                    int i3 = activityInfo.theme;
                    RFWLog.i("ActivityPreloadManager", RFWLog.USR, "themeId" + i3);
                    BaseActivityPreloadTask.themeIds.put(targetActivityClass, Integer.valueOf(i3));
                    return getFinalThemeId(i3);
                }
                return getFinalThemeId(num.intValue());
            } catch (Exception unused) {
                BaseActivityPreloadTask.themeIds.put(targetActivityClass, Integer.MIN_VALUE);
                return Integer.MIN_VALUE;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/richframework/preload/activity/BaseActivityPreloadTask$ExecuteMode;", "", "(Ljava/lang/String;I)V", "AT_ONCE", "IDLE", "preload-activity_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes25.dex */
    public enum ExecuteMode {
        AT_ONCE,
        IDLE
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/richframework/preload/activity/BaseActivityPreloadTask$PreloadMode;", "", "(Ljava/lang/String;I)V", "ONCE", "RECYCLE", "preload-activity_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes25.dex */
    public enum PreloadMode {
        ONCE,
        RECYCLE
    }

    @UiThread
    public void clear(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @UiThread
    public void doAfterActivityCreate(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public void doBeforeActivityBeUse(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @NotNull
    public abstract Class<? extends Activity> getActivityClass();

    @NotNull
    public final String getActivityKey() {
        String name = getActivityClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "activityClass.name");
        return name;
    }

    @NotNull
    public ExecuteMode getExecuteMode() {
        return ExecuteMode.AT_ONCE;
    }

    @NotNull
    public PreloadMode getPreloadMode() {
        return PreloadMode.ONCE;
    }

    @NotNull
    public String getTaskKey() {
        String name = getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "javaClass.name");
        return name;
    }

    @NotNull
    /* renamed from: isReady, reason: from getter */
    public final AtomicBoolean getIsReady() {
        return this.isReady;
    }

    public boolean isTarget(@NotNull ClassLoader classLoader, @NotNull String activityClassName, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(classLoader, "classLoader");
        Intrinsics.checkNotNullParameter(activityClassName, "activityClassName");
        Intrinsics.checkNotNullParameter(intent, "intent");
        return Intrinsics.areEqual(getActivityClass().getName(), activityClassName);
    }

    @NotNull
    public String toString() {
        return "BaseActivityPreloadTask{ PreloadMode = " + getPreloadMode() + " ExecuteMode = " + getExecuteMode() + " IsReady = " + this.isReady + '}';
    }
}
