package com.tencent.mobileqq.startup.task;

import android.content.Context;
import com.tencent.gdtad.splash.IGdtSplashAPI;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.guild.api.IGuildDiscoverRecommendApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.startup.task.NtTask;
import com.tencent.qqperf.crashdefend.CrashDefendManager;
import com.tencent.qqperf.crashdefend.test.StartUpCrashDefendDebugHelper;
import com.tencent.qqperf.monitor.crash.safemode.SafeModeHelper;
import com.tencent.qqperf.safemode.SafeModeClearHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \n2\u00020\u0001:\u0003\u000b\f\rB\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/startup/task/bv;", "Lcom/tencent/qqnt/startup/task/NtTask;", "Landroid/content/Context;", "context", "", TencentLocation.RUN_MODE, "", "blockUntilFinish", "<init>", "()V", "d", "a", "b", "c", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class bv extends NtTask {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static AtomicBoolean f289822e;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0007R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/startup/task/bv$a;", "", "", "a", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasInitRunner", "Ljava/util/concurrent/atomic/AtomicBoolean;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.startup.task.bv$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
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

        @JvmStatic
        public final void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else if (bv.f289822e.compareAndSet(false, true)) {
                SafeModeHelper.e(new c());
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/startup/task/bv$b;", "Lcom/tencent/qqperf/monitor/crash/safemode/a;", "Landroid/content/Context;", "context", "", "a", "", "b", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b implements com.tencent.qqperf.monitor.crash.safemode.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/startup/task/bv$b$a;", "", "", "KEY", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.startup.task.bv$b$a, reason: from kotlin metadata */
        /* loaded from: classes18.dex */
        public static final class Companion {
            static IPatchRedirector $redirector_;

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    return;
                }
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
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
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61613);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 4)) {
                redirector.redirect((short) 4);
            } else {
                INSTANCE = new Companion(null);
            }
        }

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qqperf.monitor.crash.safemode.a
        public void a(@Nullable Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
                return;
            }
            QLog.e("SafeModeTask", 1, "doOnSafeModeStartUp run! isLastStartFailed is " + SafeModeHelper.f(context));
        }

        @Override // com.tencent.qqperf.monitor.crash.safemode.a
        @NotNull
        public String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return "SafeModeLogRunner";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0014\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/startup/task/bv$c;", "Lcom/tencent/qqperf/monitor/crash/safemode/SafeModeHelper$a;", "Landroid/content/Context;", "context", "", "Lcom/tencent/qqperf/monitor/crash/safemode/a;", "b", "", "", "", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class c implements SafeModeHelper.a {
        static IPatchRedirector $redirector_;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qqperf.monitor.crash.safemode.SafeModeHelper.a
        @NotNull
        public Map<String, Integer> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Map) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            HashMap hashMap = new HashMap();
            hashMap.put("SafeModeLogRunner", 1);
            try {
                hashMap.put("CommonClearRunner", 3);
                hashMap.put(((IGdtSplashAPI) QRoute.api(IGdtSplashAPI.class)).getSafeModeRunnerKey(), 1);
                hashMap.put(((IGuildDiscoverRecommendApi) QRoute.api(IGuildDiscoverRecommendApi.class)).getDiscoverSafeModeStartUpRunner().b(), 3);
                hashMap.put(com.tencent.mobileqq.perf.thread.handlerthread.b.a().b(), 3);
            } catch (Throwable th5) {
                QLog.e("SafeModeTask", 1, "[buildSafeModeRunnerList]", th5);
            }
            return hashMap;
        }

        @Override // com.tencent.qqperf.monitor.crash.safemode.SafeModeHelper.a
        @NotNull
        public List<com.tencent.qqperf.monitor.crash.safemode.a> b(@Nullable Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(new b());
            try {
                arrayList.add(new xy3.a());
            } catch (Throwable th5) {
                QLog.e("SafeModeTask", 1, "[CommonClearSafeModeStartUpRunner build Failed]", th5);
            }
            try {
                arrayList.add(((IGdtSplashAPI) QRoute.api(IGdtSplashAPI.class)).buildSafeModeStartUpRunner());
            } catch (Throwable th6) {
                QLog.e("SafeModeTask", 1, "[IGdtSplashAPI build Failed]", th6);
            }
            try {
                arrayList.add(((IGuildDiscoverRecommendApi) QRoute.api(IGuildDiscoverRecommendApi.class)).getDiscoverSafeModeStartUpRunner());
            } catch (Throwable th7) {
                QLog.e("SafeModeTask", 1, "[IGuildDiscoverRecommendApi build Failed]", th7);
            }
            try {
                arrayList.add(com.tencent.mobileqq.perf.thread.handlerthread.b.a());
            } catch (Throwable th8) {
                QLog.e("SafeModeTask", 1, "[LightMessageQueueHelper build Failed]", th8);
            }
            return arrayList;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61626);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
            f289822e = new AtomicBoolean(false);
        }
    }

    public bv() {
        super(null, 1, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final void b() {
        INSTANCE.a();
    }

    @Override // com.tencent.qqnt.startup.task.NtTask
    public boolean blockUntilFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.qqnt.startup.task.c
    public void run(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        if (MobileQQ.sProcessId == 1) {
            INSTANCE.a();
            if (!CrashDefendManager.i().c()) {
                SafeModeHelper.g(context);
            }
            com.tencent.mobileqq.upgrade.shiply.a aVar = new com.tencent.mobileqq.upgrade.shiply.a();
            aVar.d();
            com.tencent.mobileqq.upgrade.e.e().p(aVar);
            com.tencent.qqperf.monitor.crash.tools.g.i(context);
            com.tencent.mobileqq.diagnosis.a.a(context);
        }
        if (MobileQQ.sProcessId == 1) {
            StartUpCrashDefendDebugHelper.b(BaseApplication.getContext(), "testFirstCrashTest");
            SafeModeClearHelper.n(context);
        }
    }
}
