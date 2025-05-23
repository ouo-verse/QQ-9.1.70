package com.tencent.mobileqq.notification.modularize;

import android.app.ActivityManager;
import android.os.Looper;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.cl;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u001a\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u001a\u0014\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u001a\u0014\u0010\r\u001a\u00020\u00002\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00000\u000b\u001a\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\" \u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0014"}, d2 = {"", "c", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "", "d", "", "Landroid/app/ActivityManager$RunningAppProcessInfo;", "processes", "", "e", "Lkotlin/Function0;", TencentLocation.RUN_MODE, "g", "f", "Ljava/util/concurrent/ConcurrentHashMap;", "", "a", "Ljava/util/concurrent/ConcurrentHashMap;", "cachedNotifyIdMap", "AQQLiteModule_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a */
    @NotNull
    private static final ConcurrentHashMap<Integer, Integer> f254285a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59236);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f254285a = new ConcurrentHashMap<>();
        }
    }

    public static final void c() {
        Set<Integer> keySet = f254285a.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "cachedNotifyIdMap.keys");
        for (Integer it : keySet) {
            QQNotificationManager qQNotificationManager = QQNotificationManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            qQNotificationManager.cancel("OnlineModulePushReceiver", it.intValue());
        }
        f254285a.clear();
    }

    public static final boolean d(@NotNull QQAppInterface app) {
        Intrinsics.checkNotNullParameter(app, "app");
        BaseApplication baseApplication = BaseApplication.context;
        Object systemService = baseApplication.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) systemService);
        if (runningAppProcesses != null && !runningAppProcesses.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : runningAppProcesses) {
                if (cl.b(baseApplication, ((ActivityManager.RunningAppProcessInfo) obj).processName)) {
                    arrayList.add(obj);
                }
            }
            QLog.d("OnlineModulePushReceiver", 1, "isAppBackground: called. ", "foreProcesses: " + e(arrayList));
            return arrayList.isEmpty();
        }
        QLog.d("OnlineModulePushReceiver", 1, "isAppBackground: called. procList=", runningAppProcesses);
        return true;
    }

    @NotNull
    public static final String e(@NotNull List<? extends ActivityManager.RunningAppProcessInfo> processes) {
        int collectionSizeOrDefault;
        String joinToString$default;
        Intrinsics.checkNotNullParameter(processes, "processes");
        List<? extends ActivityManager.RunningAppProcessInfo> list = processes;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : list) {
            arrayList.add("name: " + runningAppProcessInfo.processName + " imp: " + runningAppProcessInfo.importance + " pid: " + runningAppProcessInfo.pid);
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, null, null, null, 0, null, null, 63, null);
        return joinToString$default;
    }

    public static final boolean f(@NotNull QQAppInterface app) {
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(app, "app");
        boolean c16 = FriendsStatusUtil.c(app.getApp());
        IRuntimeService runtimeService = app.getRuntimeService(IOnlineStatusService.class);
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IO\u2026tatusService::class.java)");
        if (((IOnlineStatusService) runtimeService).getOnlineStatus() == AppRuntime.Status.dnd) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.tencent.mobileqq.app.msgnotify.a aVar = com.tencent.mobileqq.app.msgnotify.a.f196345a;
        if ((aVar.l() && aVar.m()) || !((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("tianshu_push_msg_notify_open", true)) {
            z17 = true;
        } else {
            z17 = false;
        }
        QLog.d("OnlineModulePushReceiver", 1, "needShieldPush: called. ", "canNotDisturb: " + c16 + "  dndStatus: " + z16, "  msgOpen:" + z17);
        if (!c16 && !z16 && z17) {
            return false;
        }
        return true;
    }

    public static final void g(@NotNull final Function0<Unit> run) {
        Intrinsics.checkNotNullParameter(run, "run");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.notification.modularize.d
                @Override // java.lang.Runnable
                public final void run() {
                    e.h(Function0.this);
                }
            });
        } else {
            run.invoke();
        }
    }

    public static final void h(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }
}
