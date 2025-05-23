package com.tencent.mobileqq.guild.window;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindow;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.vivo.push.PushClientConstants;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;
import mqq.app.QActivityLifecycleCallbacks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002\u00a2\u0006\u0004\bE\u0010FJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u0005H\u0002J\b\u0010\u000f\u001a\u00020\u0005H\u0002JV\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00122\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u00182\u0014\b\u0002\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00050\u001aJ\u000e\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010 \u001a\u00020\u000bJ\u0006\u0010!\u001a\u00020\u000bJ\u0010\u0010\"\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010#\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0003J\b\u0010$\u001a\u00020\u0005H\u0016J\u0010\u0010'\u001a\u00020\u00052\u0006\u0010&\u001a\u00020%H\u0016J\u0010\u0010)\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u000bH\u0016J\u0010\u0010*\u001a\u00020\u00052\u0006\u0010&\u001a\u00020%H\u0016J\u0010\u0010+\u001a\u00020\u00052\u0006\u0010&\u001a\u00020%H\u0016J\b\u0010,\u001a\u00020\u0005H\u0016J\u0010\u0010/\u001a\u00020\u00052\u0006\u0010.\u001a\u00020-H\u0016J\u0010\u00100\u001a\u00020\u00052\u0006\u0010.\u001a\u00020-H\u0016J\b\u00101\u001a\u00020\u0005H\u0016J\u0010\u00102\u001a\u00020\u00052\u0006\u0010.\u001a\u00020-H\u0016J\u0010\u00103\u001a\u00020\u00052\u0006\u0010.\u001a\u00020-H\u0016J\u0018\u00105\u001a\u00020\u00052\u0006\u0010.\u001a\u00020-2\u0006\u00104\u001a\u00020\u0018H\u0016J\u0010\u00106\u001a\u00020\u00052\u0006\u0010.\u001a\u00020-H\u0016J\b\u00107\u001a\u00020\u0005H\u0016J\u001a\u00108\u001a\u00020\u00052\u0006\u0010.\u001a\u00020-2\b\u00104\u001a\u0004\u0018\u00010\u0018H\u0016R \u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010:R\"\u0010?\u001a\u0010\u0012\f\u0012\n =*\u0004\u0018\u00010\u00030\u00030<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010>R\u0016\u0010A\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010@R\u0016\u0010B\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010@R\u0016\u0010D\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010@\u00a8\u0006G"}, d2 = {"Lcom/tencent/mobileqq/guild/window/GuildFloatWindowManager;", "Lcom/tencent/mobileqq/app/guard/guardinterface/IGuardInterface;", "Lmqq/app/QActivityLifecycleCallbacks;", "", PushClientConstants.TAG_CLASS_NAME, "", "d", "e", "Landroid/content/Context;", "context", "a", "", "display", "o", "k", DomainData.DOMAIN_NAME, "Landroid/view/View;", "customView", "Lcom/tencent/mobileqq/qqfloatingwindow/FloatingScreenParams;", "params", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "channelInfo", "Landroid/os/Bundle;", "extra", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/qqfloatingwindow/a;", "onWrapperCreated", "l", "g", "b", tl.h.F, "i", "f", "j", "onApplicationForeground", "", "tick", "onBackgroundTimeTick", "isEnabled", "onScreensStateChanged", "onLiteTimeTick", "onBackgroundUnguardTimeTick", "onApplicationBackground", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onActivityPaused", "onActivityResumed", "onProcessForeground", "onActivityStarted", "onActivityDestroyed", "p1", "onActivitySaveInstanceState", "onActivityStopped", "onProcessBackground", "onActivityCreated", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "floatWindowStatusMap", "", "kotlin.jvm.PlatformType", "Ljava/util/List;", "audioFloatWindowNames", "Z", "isInitCallbacks", "isApplicationForeground", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "isAppInAssistantMode", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class GuildFloatWindowManager implements IGuardInterface, QActivityLifecycleCallbacks {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final GuildFloatWindowManager f236656d = new GuildFloatWindowManager();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, Boolean> floatWindowStatusMap = new ConcurrentHashMap<>();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<String> audioFloatWindowNames;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static boolean isInitCallbacks;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static boolean isApplicationForeground;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private static boolean isAppInAssistantMode;

    static {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{GuildAudioChannelFloatWrapper.class.getName(), GuildGameFloatWrapper.class.getName(), GuildPlayTogetherFloatWrapper.class.getName()});
        audioFloatWindowNames = listOf;
        isApplicationForeground = true;
    }

    GuildFloatWindowManager() {
    }

    private final void a(Context context) {
        Object obj;
        WindowManager windowManager = null;
        if (context != null) {
            obj = context.getSystemService("window");
        } else {
            obj = null;
        }
        if (obj instanceof WindowManager) {
            windowManager = (WindowManager) obj;
        }
        boolean z16 = false;
        if (windowManager != null) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            Point point = new Point();
            Point point2 = new Point();
            Point point3 = new Point();
            defaultDisplay.getSize(point3);
            defaultDisplay.getCurrentSizeRange(point, point2);
            QLog.d("GuildFloatWindowManager", 1, "checkAppInAssistantMode: szActual=" + point3 + ", szMax=" + point2 + ", szMin=" + point);
            float max = ((float) Math.max(point2.x, point2.y)) * 0.9f;
            if (max > point3.x && max > point3.y) {
                z16 = true;
            }
            isAppInAssistantMode = z16;
        } else {
            QLog.d("GuildFloatWindowManager", 1, "checkAppInAssistantMode: WindowManager is null");
            isAppInAssistantMode = false;
        }
        QLog.d("GuildFloatWindowManager", 1, "checkAppInAssistantMode: " + isAppInAssistantMode);
    }

    private final void d(String className) {
        for (String it : audioFloatWindowNames) {
            if (Intrinsics.areEqual(className, it)) {
                ConcurrentHashMap<String, Boolean> concurrentHashMap = floatWindowStatusMap;
                if (concurrentHashMap.containsKey(it) && Intrinsics.areEqual(concurrentHashMap.get(it), Boolean.TRUE)) {
                    GuildFloatWindowManager guildFloatWindowManager = f236656d;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    guildFloatWindowManager.g(it);
                }
            }
        }
    }

    private final void e() {
        ConcurrentHashMap<String, Boolean> concurrentHashMap = floatWindowStatusMap;
        if (concurrentHashMap.size() > 0) {
            for (Map.Entry<String, Boolean> entry : concurrentHashMap.entrySet()) {
                QLog.i("GuildFloatWindowManager", 1, "forceCloseAllGuildFloatWindow: [" + ((Object) entry.getKey()) + "]");
                View.OnClickListener f16 = f236656d.f(entry.getKey());
                if (!(f16 instanceof p) || !((p) f16).b()) {
                    ((IQQFloatingWindow) QRoute.api(IQQFloatingWindow.class)).quitFloatingScreen(entry.getKey());
                }
            }
            floatWindowStatusMap.clear();
        }
        n();
    }

    private final void k() {
        if (isInitCallbacks) {
            return;
        }
        QLog.i("GuildFloatWindowManager", 1, "registerCallback:");
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager != null) {
            guardManager.registerCallBack(this);
        }
        Foreground.addActivityLifeCallback(this);
        isInitCallbacks = true;
    }

    public static /* synthetic */ boolean m(GuildFloatWindowManager guildFloatWindowManager, View view, String str, FloatingScreenParams floatingScreenParams, IGProGuildInfo iGProGuildInfo, IGProChannelInfo iGProChannelInfo, Bundle bundle, Function1 function1, int i3, Object obj) {
        IGProGuildInfo iGProGuildInfo2;
        IGProChannelInfo iGProChannelInfo2;
        Bundle bundle2;
        Function1 function12;
        if ((i3 & 8) != 0) {
            iGProGuildInfo2 = null;
        } else {
            iGProGuildInfo2 = iGProGuildInfo;
        }
        if ((i3 & 16) != 0) {
            iGProChannelInfo2 = null;
        } else {
            iGProChannelInfo2 = iGProChannelInfo;
        }
        if ((i3 & 32) != 0) {
            bundle2 = new Bundle();
        } else {
            bundle2 = bundle;
        }
        if ((i3 & 64) != 0) {
            function12 = new Function1<com.tencent.mobileqq.qqfloatingwindow.a, Unit>() { // from class: com.tencent.mobileqq.guild.window.GuildFloatWindowManager$showGuildFloatWindow$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull com.tencent.mobileqq.qqfloatingwindow.a it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.qqfloatingwindow.a aVar) {
                    invoke2(aVar);
                    return Unit.INSTANCE;
                }
            };
        } else {
            function12 = function1;
        }
        return guildFloatWindowManager.l(view, str, floatingScreenParams, iGProGuildInfo2, iGProChannelInfo2, bundle2, function12);
    }

    private final void n() {
        if (!isInitCallbacks) {
            return;
        }
        QLog.i("GuildFloatWindowManager", 1, "unregisterCallback:");
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager != null) {
            guardManager.unregisterCallback(this);
        }
        Foreground.removeActivityLifeCallback(this);
        isInitCallbacks = false;
    }

    private final void o(String className, boolean display) {
        floatWindowStatusMap.put(className, Boolean.valueOf(display));
    }

    public final boolean b(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return ((IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class)).checkPermission(context);
    }

    @Nullable
    public final com.tencent.mobileqq.qqfloatingwindow.a f(@NotNull String className) {
        Intrinsics.checkNotNullParameter(className, "className");
        return ((IQQFloatingWindow) QRoute.api(IQQFloatingWindow.class)).getFloatingProxyWrapper(BaseApplication.getContext(), className);
    }

    public final void g(@NotNull String className) {
        String stackTraceToString;
        Intrinsics.checkNotNullParameter(className, "className");
        QLog.i("GuildFloatWindowManager", 1, "hideGuildFloatWindow: className[" + className + "]");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            Logger.a d16 = logger.d();
            stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(new Exception());
            d16.d("GuildFloatWindowManager", 2, "hideGuildFloatWindow: stack " + stackTraceToString);
        }
        ((IQQFloatingWindow) QRoute.api(IQQFloatingWindow.class)).quitFloatingScreen(className);
        o(className, false);
        n();
    }

    public final boolean h() {
        return isAppInAssistantMode;
    }

    public final boolean i() {
        return isApplicationForeground;
    }

    public final boolean j(@NotNull String className) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(className, "className");
        ConcurrentHashMap<String, Boolean> concurrentHashMap = floatWindowStatusMap;
        if (!concurrentHashMap.containsKey(className) || (bool = concurrentHashMap.get(className)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final boolean l(@NotNull View customView, @NotNull String className, @NotNull FloatingScreenParams params, @Nullable IGProGuildInfo guildInfo, @Nullable IGProChannelInfo channelInfo, @NotNull Bundle extra, @NotNull Function1<? super com.tencent.mobileqq.qqfloatingwindow.a, Unit> onWrapperCreated) {
        Intrinsics.checkNotNullParameter(customView, "customView");
        Intrinsics.checkNotNullParameter(className, "className");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(extra, "extra");
        Intrinsics.checkNotNullParameter(onWrapperCreated, "onWrapperCreated");
        d(className);
        if (Intrinsics.areEqual(className, GuildAudioChannelFloatWrapper.class.getName()) && Intrinsics.areEqual(floatWindowStatusMap.get(GuildScreenShareFloatWrapper.class.getName()), Boolean.TRUE)) {
            return false;
        }
        BaseApplication floatContext = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(floatContext, "floatContext");
        if (!b(floatContext)) {
            QLog.i("GuildFloatWindowManager", 1, "showGuildFloatWindow: not had window permission.");
            return false;
        }
        View.OnClickListener f16 = f(className);
        if (f16 != null) {
            p pVar = (p) f16;
            if (guildInfo != null && channelInfo != null) {
                pVar.a(guildInfo, channelInfo);
            }
            pVar.c(extra);
            onWrapperCreated.invoke(f16);
        }
        int enterCustomFloatingScreen = ((IQQFloatingWindow) QRoute.api(IQQFloatingWindow.class)).enterCustomFloatingScreen(floatContext, customView, params, className, 0);
        QLog.i("GuildFloatWindowManager", 1, "showGuildFloatWindow: showResult[" + enterCustomFloatingScreen + "]");
        if (enterCustomFloatingScreen != 0) {
            return false;
        }
        o(className, true);
        k();
        return true;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle p16) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        String simpleName = activity.getClass().getSimpleName();
        QLog.i("GuildFloatWindowManager", 1, "onActivityCreated: activity name [" + simpleName + "]");
        if (TextUtils.equals(simpleName, "SplashActivity")) {
            f236656d.a(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        String simpleName = activity.getClass().getSimpleName();
        QLog.i("GuildFloatWindowManager", 1, "onActivityDestroyed: activity name [" + simpleName + "]");
        if (TextUtils.equals(simpleName, "SplashActivity")) {
            f236656d.e();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@NotNull Activity activity, @NotNull Bundle p16) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(p16, "p1");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onApplicationBackground() {
        QLog.i("GuildFloatWindowManager", 1, "onApplicationBackground:");
        isApplicationForeground = false;
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onApplicationForeground() {
        QLog.i("GuildFloatWindowManager", 1, "onApplicationForeground:");
        isApplicationForeground = true;
    }

    @Override // mqq.app.QActivityLifecycleCallbacks
    public void onProcessBackground() {
        QLog.i("GuildFloatWindowManager", 1, "onProcessBackground:");
        isApplicationForeground = false;
        a(Foreground.getTopActivity());
    }

    @Override // mqq.app.QActivityLifecycleCallbacks
    public void onProcessForeground() {
        QLog.i("GuildFloatWindowManager", 1, "onProcessForeground:");
        isApplicationForeground = true;
        a(Foreground.getTopActivity());
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onBackgroundTimeTick(long tick) {
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onBackgroundUnguardTimeTick(long tick) {
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onLiteTimeTick(long tick) {
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onScreensStateChanged(boolean isEnabled) {
    }
}
