package com.tencent.mobileqq.startup.task;

import android.content.Context;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.hardcoder.HardCoderManager;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.contacts.alphabet.AlphabetFriendFragment;
import com.tencent.mobileqq.activity.contacts.friend.FriendFragment;
import com.tencent.mobileqq.activity.contacts.publicaccount.PublicAccountFragment;
import com.tencent.mobileqq.activity.contacts.troop.TroopFragment;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.friend.alphabet.api.INTFriendApi;
import com.tencent.mobileqq.haoliyou.IATHandler;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.mvvm.LifeCycleFragment;
import com.tencent.mobileqq.mvvm.QLifeCycleFragment;
import com.tencent.mobileqq.perf.block.IdleHandlerMonitor;
import com.tencent.mobileqq.perf.tool.StrictModeUtil;
import com.tencent.mobileqq.perf.tracker.SceneTracker;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqperf.api.IPerfApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.startup.step.InitQQRMonitorSDK;
import com.tencent.mobileqq.startup.step.OpenThreadCreateHook;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.startup.task.NtTask;
import com.tencent.tmdownloader.notify.DownloadTaskNotifier;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00042\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/startup/task/bb;", "Lcom/tencent/qqnt/startup/task/NtTask;", "", "f", "d", "e", "g", "Landroid/content/Context;", "context", TencentLocation.RUN_MODE, "<init>", "()V", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class bb extends NtTask {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/startup/task/bb$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.startup.task.bb$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61476);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public bb() {
        super(null, 1, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void d() {
        long currentTimeMillis = System.currentTimeMillis();
        qy3.a.g().k();
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (QLog.isColorLevel()) {
            QLog.i("FileDescriptorMonitor", 2, "initFDMonitor cost = " + currentTimeMillis2);
        }
    }

    private final void e() {
        if (MobileQQ.sProcessId != 1) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z16 = !com.tencent.mobileqq.startup.monitor.d.f289708a.e();
        if (z16) {
            try {
                HardCoderManager.getInstance().tryInit();
            } catch (Exception e16) {
                QLog.e("MonitorInitTask", 1, "initHardcoder error.", e16.toString());
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("MonitorInitTask", 2, "initHardcoder startupSupport:" + z16 + " cost:" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    private final void g() {
        try {
            if (MobileQQ.sProcessId == 1) {
                MsfServiceSdk.get().getMSFMsgPushHandlerUtil().registerMsgPushMonitorHandler(com.tencent.qqnt.trace.h.INSTANCE.a());
                QLog.d("MonitorInitTask", 1, "registerMsgPushMonitorHandler");
            }
            if (MobileQQ.sProcessId == 4) {
                com.tencent.qqnt.trace.h.INSTANCE.b(com.tencent.mobileqq.startup.a.f289661b);
            }
        } catch (Exception e16) {
            QLog.d("MonitorInitTask", 1, "initMSFPushMonitor error.", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h() {
        ey3.a.f().k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i() {
        QLog.d("[TM]", 1, "init ThreadMonitorManager onLoadDex, processId = " + MobileQQ.sProcessId);
        com.tencent.mobileqq.perf.thread.a.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j() {
        ty3.a.f();
    }

    @Override // com.tencent.qqnt.startup.task.c
    public void run(@NotNull Context context) {
        boolean endsWith$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        if (QLog.isColorLevel()) {
            QLog.d("MonitorInitTask", 2, "AppSetting.isPublicVersion = true");
        }
        if (MobileQQ.sProcessId == 1) {
            f();
        }
        com.tencent.mobileqq.qmethodmonitor.monitor.a.g();
        com.tencent.mobileqq.perf.thread.proxy.c.f258155a.e();
        if (MobileQQ.sProcessId == 4) {
            ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.startup.task.ay
                @Override // java.lang.Runnable
                public final void run() {
                    bb.h();
                }
            }, 3000L);
        }
        if (MobileQQ.sProcessId != 1) {
            ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.startup.task.az
                @Override // java.lang.Runnable
                public final void run() {
                    bb.i();
                }
            }, 16, null, true, 4000L);
            InitQQRMonitorSDK.init();
        }
        ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.startup.task.ba
            @Override // java.lang.Runnable
            public final void run() {
                bb.j();
            }
        }, 3000L);
        String processName = MobileQQ.processName;
        if (processName != null) {
            Intrinsics.checkNotNullExpressionValue(processName, "processName");
            endsWith$default = StringsKt__StringsJVMKt.endsWith$default(processName, "TMAssistantDownloadSDKService", false, 2, null);
            if (endsWith$default) {
                DownloadTaskNotifier.get().addListener(com.tencent.open.appstore.dl.a.b());
            }
        }
        new OpenThreadCreateHook().a();
        SceneTracker.f258213d.g();
        String deviceFragmentName = ((INTFriendApi) QRoute.api(INTFriendApi.class)).getDeviceFragment().getClass().getName();
        String phoneContactFragmentName = ((INTFriendApi) QRoute.api(INTFriendApi.class)).getPhoneContactFragment().getClass().getName();
        String name = LifeCycleFragment.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "LifeCycleFragment::class.java.name");
        String name2 = MainFragment.class.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "MainFragment::class.java.name");
        String name3 = ChatFragment.class.getName();
        Intrinsics.checkNotNullExpressionValue(name3, "ChatFragment::class.java.name");
        String name4 = FriendFragment.class.getName();
        Intrinsics.checkNotNullExpressionValue(name4, "FriendFragment::class.java.name");
        Intrinsics.checkNotNullExpressionValue(deviceFragmentName, "deviceFragmentName");
        Intrinsics.checkNotNullExpressionValue(phoneContactFragmentName, "phoneContactFragmentName");
        String name5 = PublicAccountFragment.class.getName();
        Intrinsics.checkNotNullExpressionValue(name5, "PublicAccountFragment::class.java.name");
        String name6 = TroopFragment.class.getName();
        Intrinsics.checkNotNullExpressionValue(name6, "TroopFragment::class.java.name");
        String name7 = AlphabetFriendFragment.class.getName();
        Intrinsics.checkNotNullExpressionValue(name7, "AlphabetFriendFragment::class.java.name");
        String name8 = QLifeCycleFragment.class.getName();
        Intrinsics.checkNotNullExpressionValue(name8, "QLifeCycleFragment::class.java.name");
        SceneTracker.b(name, name2, name3, name4, deviceFragmentName, phoneContactFragmentName, name5, name6, name7, name8);
        com.tencent.mobileqq.perf.process.backgroud.d.f257845d.r();
        ((IPerfApi) QRoute.api(IPerfApi.class)).init();
        StrictModeUtil.f258190a.d();
        IATHandler.initHandler();
        d();
        e();
        IdleHandlerMonitor.start();
        g();
    }

    private final void f() {
    }
}
