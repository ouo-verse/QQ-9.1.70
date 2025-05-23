package com.tencent.mobileqq.unusedcodecheck.api.impl;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import com.tencent.common.config.AppSetting;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.tool.CpuUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.unusedcodecheck.InitClassInfo;
import com.tencent.mobileqq.unusedcodecheck.api.IUnusedCodeCheck;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPCResult;
import eipc.EIPCServer;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J \u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nH\u0016J\u0018\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0018\u001a\u00020\nH\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0002J$\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u001aH\u0002J\b\u0010%\u001a\u00020\u001aH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\n8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/unusedcodecheck/api/impl/UnusedCodeCheckImpl;", "Lcom/tencent/mobileqq/unusedcodecheck/api/IUnusedCodeCheck;", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "()V", "checkTimeInterval", "", "cpuUsageLimit", "", "delayTime", "isInvalidModel", "", com.tencent.mobileqq.msf.core.f0.c.e.h.f248218g, "()Z", "isOpen$delegate", "Lkotlin/Lazy;", "needReport", "analysis", "context", "Landroid/content/Context;", "destFile", "Ljava/io/File;", "isCheckInitInfo", "analysisAndExport", "isCheckInitStatus", "canCheck", "clearCheckInfo", "", "initIPC", "onCall", "Leipc/EIPCResult;", "action", "", "params", "Landroid/os/Bundle;", "callbackId", "", TencentLocation.RUN_MODE, "trigger", "unusedcode_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public final class UnusedCodeCheckImpl extends QIPCModule implements IUnusedCodeCheck {
    static IPatchRedirector $redirector_;
    private long checkTimeInterval;
    private double cpuUsageLimit;
    private long delayTime;
    private boolean isInvalidModel;

    /* renamed from: isOpen$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy isOpen;
    private boolean needReport;

    public UnusedCodeCheckImpl() {
        super("UnusedCodeCheck");
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.unusedcodecheck.api.impl.UnusedCodeCheckImpl$isOpen$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) UnusedCodeCheckImpl.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final Boolean invoke() {
                    long b16;
                    long f16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Boolean) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    com.tencent.mobileqq.unusedcodecheck.b bVar = com.tencent.mobileqq.unusedcodecheck.b.f306127n;
                    a aVar = new a();
                    UnusedCodeCheckImpl.this.needReport = aVar.j();
                    bVar.y(aVar);
                    String j3 = AppSetting.j(bVar.n().getContext());
                    Intrinsics.checkNotNullExpressionValue(j3, "getPublishVersionString(\u2026Facade.tool.getContext())");
                    bVar.s(j3);
                    String revision = AppSetting.f99543c;
                    Intrinsics.checkNotNullExpressionValue(revision, "revision");
                    bVar.r(revision);
                    bVar.x("com.tencent.mobileqq");
                    b bVar2 = (b) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100061");
                    if (bVar2 == null) {
                        bVar2 = new b();
                    }
                    QLog.d("UnusedCodeCheck", 1, "read config:" + bVar2);
                    bVar.t(bVar2.i());
                    bVar.u(bVar2.l());
                    bVar.v(bVar2.m());
                    bVar.p(bVar2.a());
                    bVar.q(65000);
                    bVar.w(bVar2.n());
                    UnusedCodeCheckImpl.this.isInvalidModel = bVar2.o();
                    UnusedCodeCheckImpl unusedCodeCheckImpl = UnusedCodeCheckImpl.this;
                    int i3 = MobileQQ.sProcessId;
                    if (i3 == 1) {
                        b16 = bVar2.b();
                    } else if (i3 != 4) {
                        b16 = bVar2.d();
                    } else {
                        b16 = bVar2.c();
                    }
                    unusedCodeCheckImpl.checkTimeInterval = b16;
                    UnusedCodeCheckImpl unusedCodeCheckImpl2 = UnusedCodeCheckImpl.this;
                    int i16 = MobileQQ.sProcessId;
                    if (i16 == 1) {
                        f16 = bVar2.f();
                    } else if (i16 != 4) {
                        f16 = bVar2.h();
                    } else {
                        f16 = bVar2.g();
                    }
                    unusedCodeCheckImpl2.delayTime = f16;
                    UnusedCodeCheckImpl.this.cpuUsageLimit = bVar2.e();
                    UnusedCodeCheckImpl.this.initIPC();
                    return Boolean.valueOf(bVar2.p());
                }
            });
            this.isOpen = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean analysisAndExport(final boolean isCheckInitStatus, File destFile) {
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        final EIPCServer server = QIPCServerHelper.getInstance().getServer();
        ArrayList<EIPCConnection> clientConnectionList = server.getClientConnectionList();
        Intrinsics.checkNotNullExpressionValue(clientConnectionList, "ipcServer.clientConnectionList");
        ArrayList arrayList = new ArrayList();
        for (Object obj : clientConnectionList) {
            if (((EIPCConnection) obj).isAvailable()) {
                arrayList.add(obj);
            }
        }
        ArrayList<EIPCConnection> arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (true ^ Intrinsics.areEqual(((EIPCConnection) obj2).procName, com.tencent.mobileqq.unusedcodecheck.b.f306127n.l())) {
                arrayList2.add(obj2);
            }
        }
        final CountDownLatch countDownLatch = new CountDownLatch(arrayList2.size() + 1);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.unusedcodecheck.api.impl.d
            @Override // java.lang.Runnable
            public final void run() {
                UnusedCodeCheckImpl.analysisAndExport$lambda$8(Ref.BooleanRef.this, isCheckInitStatus, countDownLatch);
            }
        }, 64, null, true);
        for (final EIPCConnection eIPCConnection : arrayList2) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.unusedcodecheck.api.impl.e
                @Override // java.lang.Runnable
                public final void run() {
                    UnusedCodeCheckImpl.analysisAndExport$lambda$11$lambda$10(EIPCServer.this, eIPCConnection, countDownLatch, isCheckInitStatus);
                }
            }, 64, null, true);
        }
        countDownLatch.await();
        if (booleanRef.element) {
            destFile.delete();
            destFile.getParentFile().mkdirs();
            booleanRef.element = new com.tencent.mobileqq.unusedcodecheck.e().b(destFile);
        }
        return booleanRef.element;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void analysisAndExport$lambda$11$lambda$10(EIPCServer eIPCServer, EIPCConnection eIPCConnection, CountDownLatch latch, boolean z16) {
        Intrinsics.checkNotNullParameter(latch, "$latch");
        Bundle bundle = new Bundle();
        bundle.putBoolean("checkInit", z16);
        eIPCServer.callClient(eIPCConnection.procName, 1, "UnusedCodeCheck", "analysis", bundle);
        latch.countDown();
        QLog.d("UnusedCodeCheck", 1, "notify subProcess:" + eIPCConnection.procName + " check");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void analysisAndExport$lambda$8(Ref.BooleanRef result, boolean z16, CountDownLatch latch) {
        Intrinsics.checkNotNullParameter(result, "$result");
        Intrinsics.checkNotNullParameter(latch, "$latch");
        com.tencent.mobileqq.unusedcodecheck.b bVar = com.tencent.mobileqq.unusedcodecheck.b.f306127n;
        result.element = bVar.a(bVar.n().getContext(), z16).b();
        latch.countDown();
    }

    private final boolean canCheck() {
        if (!isOpen() || Build.VERSION.SDK_INT < 29 || this.isInvalidModel || AppSetting.r() || AppSetting.q()) {
            return false;
        }
        return true;
    }

    private final void run() {
        float h16 = CpuUtil.h(CpuUtil.f258160a, 0, 1, null) * 100;
        if (h16 > this.cpuUsageLimit) {
            QLog.d("UnusedCodeCheck", 2, "cpuUsage is:" + h16 + ", jump check");
            ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.unusedcodecheck.api.impl.g
                @Override // java.lang.Runnable
                public final void run() {
                    UnusedCodeCheckImpl.run$lambda$3$lambda$2(UnusedCodeCheckImpl.this);
                }
            }, 64, null, true, this.checkTimeInterval);
            return;
        }
        com.tencent.mobileqq.unusedcodecheck.b bVar = com.tencent.mobileqq.unusedcodecheck.b.f306127n;
        if (!com.tencent.mobileqq.unusedcodecheck.b.b(bVar, bVar.n().getContext(), false, 2, null).a()) {
            return;
        }
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.unusedcodecheck.api.impl.h
            @Override // java.lang.Runnable
            public final void run() {
                UnusedCodeCheckImpl.run$lambda$4(UnusedCodeCheckImpl.this);
            }
        }, 64, null, true, this.checkTimeInterval);
        if (this.needReport) {
            bVar.o();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void run$lambda$3$lambda$2(UnusedCodeCheckImpl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void run$lambda$4(UnusedCodeCheckImpl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void trigger$lambda$1(final UnusedCodeCheckImpl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean canCheck = this$0.canCheck();
        if (QLog.isColorLevel()) {
            QLog.d("UnusedCodeCheck", 2, "run isOpen:" + this$0.isOpen() + " canCheck:" + canCheck + " isInvalidAndroidVersion:" + this$0.isInvalidModel);
        }
        if (canCheck) {
            ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.unusedcodecheck.api.impl.c
                @Override // java.lang.Runnable
                public final void run() {
                    UnusedCodeCheckImpl.trigger$lambda$1$lambda$0(UnusedCodeCheckImpl.this);
                }
            }, 64, null, true, this$0.delayTime);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void trigger$lambda$1$lambda$0(UnusedCodeCheckImpl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.run();
    }

    @Override // com.tencent.mobileqq.unusedcodecheck.api.IUnusedCodeCheck
    public boolean analysis(@NotNull Context context, @NotNull File destFile, boolean isCheckInitInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, context, destFile, Boolean.valueOf(isCheckInitInfo))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(destFile, "destFile");
        if (MobileQQ.sProcessId != 1) {
            return false;
        }
        if (isOpen() && QLog.isColorLevel()) {
            QLog.d("UnusedCodeCheck", 2, "run isOpen:" + isOpen() + " isInvalidAndroidVersion:" + this.isInvalidModel);
        }
        InitClassInfo initClassInfo = new InitClassInfo();
        initClassInfo.k(context);
        QLog.d("UnusedCodeCheck", 1, "init end result:" + initClassInfo.j());
        if (initClassInfo.j() != 0) {
            return false;
        }
        return analysisAndExport(isCheckInitInfo, destFile);
    }

    @Override // com.tencent.mobileqq.unusedcodecheck.api.IUnusedCodeCheck
    public void clearCheckInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            com.tencent.mobileqq.unusedcodecheck.b.f306127n.c(false);
        }
    }

    public final boolean isOpen() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return ((Boolean) this.isOpen.getValue()).booleanValue();
    }

    @Override // eipc.EIPCModule
    @NotNull
    public EIPCResult onCall(@Nullable String action, @Nullable Bundle params, int callbackId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 6, this, action, params, Integer.valueOf(callbackId));
        }
        if (Intrinsics.areEqual(action, "analysis") && params != null) {
            boolean z16 = params.getBoolean("checkInit");
            com.tencent.mobileqq.unusedcodecheck.b bVar = com.tencent.mobileqq.unusedcodecheck.b.f306127n;
            bVar.a(bVar.n().getContext(), z16);
            EIPCResult createSuccessResult = EIPCResult.createSuccessResult(null);
            Intrinsics.checkNotNullExpressionValue(createSuccessResult, "createSuccessResult(null)");
            return createSuccessResult;
        }
        return new EIPCResult();
    }

    @Override // com.tencent.mobileqq.unusedcodecheck.api.IUnusedCodeCheck
    public void trigger() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.unusedcodecheck.api.impl.f
                @Override // java.lang.Runnable
                public final void run() {
                    UnusedCodeCheckImpl.trigger$lambda$1(UnusedCodeCheckImpl.this);
                }
            }, 64, null, true, 30000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initIPC() {
    }
}
