package com.tencent.mobileqq.perf.process.broadcast;

import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import com.tencent.cache.core.manager.api.c;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.guard.GuardState;
import com.tencent.mobileqq.perf.memory.FaultMonitor;
import com.tencent.mobileqq.perf.memory.e;
import com.tencent.mobileqq.perf.process.foregroud.ProcessExitManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.NewIntent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0006\u0010\t\u001a\u00020\u0006J\u001c\u0010\u000e\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016R\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/perf/process/broadcast/MainProcessBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "", "isTrim", "", "level", "", "f", "c", "e", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "onReceive", "b", "Z", "d", "()Z", "setRegistered", "(Z)V", "registered", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class MainProcessBroadcastReceiver extends BroadcastReceiver {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final MainProcessBroadcastReceiver f257874a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean registered;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/perf/process/broadcast/MainProcessBroadcastReceiver$a", "Landroid/content/ComponentCallbacks2;", "", "level", "", "onTrimMemory", "onLowMemory", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class a implements ComponentCallbacks2 {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(@NotNull Configuration newConfig) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) newConfig);
            } else {
                Intrinsics.checkNotNullParameter(newConfig, "newConfig");
            }
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                MainProcessBroadcastReceiver.f257874a.f(false, 0);
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        @Override // android.content.ComponentCallbacks2
        public void onTrimMemory(int level) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                MainProcessBroadcastReceiver.f257874a.f(true, level);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, level);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31845);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f257874a = new MainProcessBroadcastReceiver();
        }
    }

    MainProcessBroadcastReceiver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void c() {
        com.tencent.mobileqq.perf.memory.collect.a e16 = e.e(e.f257732a, null, 1, null);
        com.tencent.mobileqq.perf.memory.largeobject.b.INSTANCE.c(e16);
        FaultMonitor.f257645a.b(e16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(final boolean isTrim, final int level) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.perf.process.broadcast.a
            @Override // java.lang.Runnable
            public final void run() {
                MainProcessBroadcastReceiver.g(isTrim, level);
            }
        }, 64, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(boolean z16, int i3) {
        ProcessExitManager.f257912d.b(ProcessExitManager.FromTag.LowMemory);
        if (z16) {
            c.f98725d.a().onTrimMemory(i3);
        } else {
            c.f98725d.a().onLowMemory();
        }
        f257874a.c();
    }

    public final boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return registered;
    }

    public final void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (registered) {
            return;
        }
        registered = true;
        QLog.d("ProcessPreloadManager_MainProcessBroadcast", 1, "register");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.process.exit");
        intentFilter.addAction("com.tencent.process.trigger.exit");
        for (String str : com.tencent.mobileqq.perf.process.config.e.INSTANCE.b().j()) {
            intentFilter.addAction("mqq.intent.action.LAUNCH_" + str);
            if (Intrinsics.areEqual(str, GuardState.PROCESS_NAME_MINIAPP)) {
                for (int i3 = 1; i3 < 8; i3++) {
                    intentFilter.addAction("mqq.intent.action.LAUNCH_" + str + i3);
                }
            }
        }
        BaseApplication.getContext().registerReceiver(this, intentFilter);
        ProcessExitManager.f257912d.b(ProcessExitManager.FromTag.RegularCheck);
        BaseApplication.getContext().getApplicationContext().registerComponentCallbacks(new a());
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008a  */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onReceive(@Nullable Context context, @Nullable Intent intent) {
        boolean z16;
        String str;
        boolean z17;
        boolean startsWith$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) context, (Object) intent);
            return;
        }
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        boolean z18 = true;
        if (action != null) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(action, NewIntent.ACTION_LAUNCH, false, 2, null);
            if (startsWith$default) {
                z16 = true;
                if (!z16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ProcessPreloadManager_MainProcessBroadcast", 2, "receive broadcast in main process, " + intent.getAction());
                    }
                    String action2 = intent.getAction();
                    Intrinsics.checkNotNull(action2);
                    String substring = action2.substring(25);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                    GuardManager guardManager = GuardManager.sInstance;
                    if (guardManager != null && guardManager.isApplicationForeground()) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        GuardManager guardManager2 = GuardManager.sInstance;
                        if (guardManager2 == null || guardManager2.isProcessForeground(substring)) {
                            z18 = false;
                        }
                        if (z18 && !com.tencent.mobileqq.perf.process.foregroud.b.f257916a.d(substring)) {
                            com.tencent.mobileqq.perf.process.foregroud.report.a.f257918a.b(substring);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (Intrinsics.areEqual(intent.getAction(), "com.tencent.process.exit")) {
                    Bundle extras = intent.getExtras();
                    Intrinsics.checkNotNull(extras);
                    ArrayList<String> stringArrayList = extras.getStringArrayList("procNameList");
                    if (stringArrayList != null) {
                        for (String it : stringArrayList) {
                            com.tencent.mobileqq.perf.process.foregroud.b bVar = com.tencent.mobileqq.perf.process.foregroud.b.f257916a;
                            Intrinsics.checkNotNullExpressionValue(it, "it");
                            bVar.h(it);
                        }
                        return;
                    }
                    return;
                }
                if (Intrinsics.areEqual(intent.getAction(), "com.tencent.process.trigger.exit")) {
                    Bundle extras2 = intent.getExtras();
                    if (extras2 != null) {
                        str = extras2.getString("process_verify");
                    } else {
                        str = null;
                    }
                    if (ProcessBroadcastReceiver.INSTANCE.a(str, null, false)) {
                        ProcessExitManager.f257912d.d(ProcessExitManager.FromTag.PreloadCheck);
                        return;
                    }
                    return;
                }
                return;
            }
        }
        z16 = false;
        if (!z16) {
        }
    }
}
