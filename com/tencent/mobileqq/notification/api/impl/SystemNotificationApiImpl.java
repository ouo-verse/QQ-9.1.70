package com.tencent.mobileqq.notification.api.impl;

import android.app.Activity;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Bundle;
import androidx.core.app.NotificationManagerCompat;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.notification.api.ISystemNotificationApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.plugins.AudioRecorderJsPlugin;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.app.Foreground;
import mqq.app.QActivityLifecycleCallbacks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0001\u001eB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u001a\u0010\u000f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0015\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\rH\u0016J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u0017\u001a\u00020\u0005H\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/notification/api/impl/SystemNotificationApiImpl;", "Lcom/tencent/mobileqq/notification/api/ISystemNotificationApi;", "Lmqq/app/QActivityLifecycleCallbacks;", "", "scene", "", "updateNotificationEnabled", "Landroid/content/Context;", "context", "", "getCachedNotificationSwitch", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onActivityCreated", "onActivityStarted", "onActivityResumed", "onActivityPaused", "onActivityStopped", "outState", "onActivitySaveInstanceState", "onActivityDestroyed", "onProcessForeground", "onProcessBackground", "cachedNotificationEnabled", "Ljava/lang/Boolean;", "<init>", "()V", "Companion", "a", "qq_notification_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final class SystemNotificationApiImpl implements ISystemNotificationApi, QActivityLifecycleCallbacks {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "SystemNotification";

    @Nullable
    private volatile Boolean cachedNotificationEnabled;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/notification/api/impl/SystemNotificationApiImpl$a;", "", "Landroid/content/Context;", "context", "", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq_notification_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.notification.api.impl.SystemNotificationApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes8.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        public final boolean a(@NotNull Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(context, "context");
            if (Build.VERSION.SDK_INT >= 24) {
                return NotificationManagerCompat.from(context).areNotificationsEnabled();
            }
            Object systemService = context.getSystemService("appops");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.AppOpsManager");
            AppOpsManager appOpsManager = (AppOpsManager) systemService;
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            String packageName = context.getApplicationContext().getPackageName();
            int i3 = applicationInfo.uid;
            try {
                Class<?> cls = Class.forName(AppOpsManager.class.getName());
                Class<?> cls2 = Integer.TYPE;
                Method method = cls.getMethod(AudioRecorderJsPlugin.AudioManager.FUNCTION_NAME_CHECK_OP_NOT_THROW, cls2, cls2, String.class);
                Object obj = cls.getDeclaredField("OP_POST_NOTIFICATION").get(cls2);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                Object invoke = method.invoke(appOpsManager, Integer.valueOf(((Integer) obj).intValue()), Integer.valueOf(i3), packageName);
                Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.Int");
                if (((Integer) invoke).intValue() == 0) {
                    return true;
                }
                return false;
            } catch (Throwable th5) {
                QLog.w(SystemNotificationApiImpl.TAG, 1, "areNotificationsEnabledInternal exception: " + th5);
                return true;
            }
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24290);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public SystemNotificationApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            Foreground.addActivityLifeCallback(this);
            updateNotificationEnabled("init");
        }
    }

    private final void updateNotificationEnabled(final String scene) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.notification.api.impl.a
            @Override // java.lang.Runnable
            public final void run() {
                SystemNotificationApiImpl.updateNotificationEnabled$lambda$2(SystemNotificationApiImpl.this, scene);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateNotificationEnabled$lambda$2(SystemNotificationApiImpl this$0, String scene) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(scene, "$scene");
        Companion companion = INSTANCE;
        BaseApplication context = BaseApplication.context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this$0.cachedNotificationEnabled = Boolean.valueOf(companion.a(context));
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "[updateNotificationEnabled] scene=" + scene + " enabled=" + this$0.cachedNotificationEnabled);
        }
    }

    @Override // com.tencent.mobileqq.notification.api.ISystemNotificationApi
    public boolean getCachedNotificationSwitch(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Boolean bool = this.cachedNotificationEnabled;
        if (bool != null) {
            boolean booleanValue = bool.booleanValue();
            updateNotificationEnabled("getCachedNotificationSwitch");
            return booleanValue;
        }
        boolean a16 = INSTANCE.a(context);
        this.cachedNotificationEnabled = Boolean.valueOf(a16);
        return a16;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity, (Object) savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NotNull Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) activity);
        } else {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@NotNull Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
        } else {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@NotNull Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
        } else {
            Intrinsics.checkNotNullParameter(activity, "activity");
            updateNotificationEnabled("onActivityResumed");
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@NotNull Activity activity, @NotNull Bundle outState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) activity, (Object) outState);
        } else {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(outState, "outState");
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@NotNull Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
        } else {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@NotNull Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) activity);
        } else {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }
    }

    @Override // mqq.app.QActivityLifecycleCallbacks
    public void onProcessBackground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        }
    }

    @Override // mqq.app.QActivityLifecycleCallbacks
    public void onProcessForeground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        }
    }
}
