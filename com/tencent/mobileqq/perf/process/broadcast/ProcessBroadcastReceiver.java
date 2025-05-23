package com.tencent.mobileqq.perf.process.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.process.foregroud.ProcessExitManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppProcHelper;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 \t2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0006\u0010\u0003\u001a\u00020\u0002J\u001c\u0010\b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006R\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/perf/process/broadcast/ProcessBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "", "d", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "onReceive", "b", "", "a", "Z", "getRegistered", "()Z", "setRegistered", "(Z)V", "registered", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class ProcessBroadcastReceiver extends BroadcastReceiver {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private volatile boolean registered;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J(\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\nR\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\nR\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\nR\u0014\u0010\u0010\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\nR\u0014\u0010\u0011\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\n\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/perf/process/broadcast/ProcessBroadcastReceiver$a;", "", "", "verifyValue", "Ljava/util/ArrayList;", "nameList", "", "needCheckForeground", "a", "ACTION_PROCESS_AUDIO_STAT", "Ljava/lang/String;", "ACTION_PROCESS_IS_IDLE", "ACTION_PROCESS_MEMORY_COUNT", "ACTION_PROCESS_MEMORY_EXIT", "ACTION_PROCESS_TRIGGER_EXIT", "KEY_BROADCAST_PROCESS_NAMELIST", "KEY_BROADCAST_PROCESS_VERIFY", "TAG", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.perf.process.broadcast.ProcessBroadcastReceiver$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
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

        public final boolean a(@Nullable String verifyValue, @Nullable ArrayList<String> nameList, boolean needCheckForeground) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, this, verifyValue, nameList, Boolean.valueOf(needCheckForeground))).booleanValue();
            }
            if (needCheckForeground && Foreground.getActivityCount() > 0) {
                return false;
            }
            if (verifyValue != null && verifyValue.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                QLog.d("ProcessGuard", 1, "broadcast check fail, verifyValue is " + verifyValue);
                return false;
            }
            if (Intrinsics.areEqual(verifyValue, AppProcHelper.getLocalVerify(nameList, false)) || Intrinsics.areEqual(verifyValue, AppProcHelper.getLocalVerify(nameList, true))) {
                return true;
            }
            QLog.d("ProcessGuard", 1, "broadcast check fail, over one minute");
            return false;
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31860);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ProcessBroadcastReceiver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(Intent intent, ProcessBroadcastReceiver this$0) {
        ArrayList<String> arrayList;
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            Bundle extras = intent.getExtras();
            String str = null;
            if (extras != null) {
                arrayList = extras.getStringArrayList("proc_nameList");
            } else {
                arrayList = null;
            }
            Bundle extras2 = intent.getExtras();
            if (extras2 != null) {
                str = extras2.getString("process_verify");
            }
            if (!Intrinsics.areEqual(intent.getAction(), "com.tencent.process.is.idle")) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!INSTANCE.a(str, arrayList, z16)) {
                QLog.d("ProcessGuard", 1, "ignore received broadcast, action:" + intent.getAction());
                return;
            }
            String action = intent.getAction();
            if (action != null) {
                switch (action.hashCode()) {
                    case -1909280937:
                        if (action.equals("com.tencent.process.memory.count")) {
                            com.tencent.mobileqq.perf.process.backgroud.counter.a.f257838a.b();
                            return;
                        }
                        return;
                    case -1438274527:
                        if (action.equals("com.tencent.process.audio.stat")) {
                            com.tencent.mobileqq.perf.process.backgroud.audio.a.f257816a.a(intent);
                            return;
                        }
                        return;
                    case 354120150:
                        if (action.equals("com.tencent.process.memory.exit")) {
                            this$0.b(intent);
                            return;
                        }
                        return;
                    case 1780811651:
                        if (action.equals("com.tencent.process.is.idle")) {
                            ProcessExitManager.f257912d.c();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        } catch (NullPointerException e16) {
            QLog.e("ProcessGuard", 1, "received broadcast error, ", e16);
        }
    }

    public final void b(@NotNull Intent intent) {
        ArrayList<String> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        Bundle extras = intent.getExtras();
        if (extras != null) {
            arrayList = extras.getStringArrayList("proc_nameList");
        } else {
            arrayList = null;
        }
        if (arrayList != null) {
            for (String it : arrayList) {
                com.tencent.mobileqq.perf.process.foregroud.b bVar = com.tencent.mobileqq.perf.process.foregroud.b.f257916a;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                bVar.h(it);
            }
        }
        if (AppProcHelper.isContainsProc(BaseApplication.context, arrayList)) {
            QLog.d("ProcessGuard", 1, "exitProcess, current:" + MobileQQ.processName + ", killList:" + arrayList);
            com.tencent.mobileqq.perf.process.util.b.f257946a.e();
        }
    }

    public final void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (this.registered) {
            return;
        }
        this.registered = true;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.process.memory.exit");
        intentFilter.addAction("com.tencent.process.memory.count");
        intentFilter.addAction("com.tencent.process.is.idle");
        intentFilter.addAction("com.tencent.process.audio.stat");
        BaseApplication.getContext().registerReceiver(this, intentFilter);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@Nullable Context context, @Nullable final Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) context, (Object) intent);
            return;
        }
        if (intent == null) {
            return;
        }
        QLog.d("ProcessGuard", 1, "onReceive, action:" + intent.getAction());
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.perf.process.broadcast.b
            @Override // java.lang.Runnable
            public final void run() {
                ProcessBroadcastReceiver.c(intent, this);
            }
        }, 64, null, true);
    }
}
