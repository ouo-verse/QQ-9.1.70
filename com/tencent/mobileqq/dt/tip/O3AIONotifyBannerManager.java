package com.tencent.mobileqq.dt.tip;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.msg.api.IMsgService;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\b\u001a\u00020\u0006J\u0010\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\"\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\nJ\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u000f\u001a\u00020\u0006R \u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R,\u0010\u0014\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\n0\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/dt/tip/O3AIONotifyBannerManager;", "", "", "destUin", "Lcom/tencent/mobileqq/dt/tip/b;", "msg", "", "f", "g", "e", "Lkotlin/Function1;", "listener", "c", "j", "i", "d", "", "b", "Ljava/util/Map;", "bannerModelMap", "listeners", "", "Z", "isRegister", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/Job;", "job", "<init>", "()V", "qq-devicetoken-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class O3AIONotifyBannerManager {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final O3AIONotifyBannerManager f203873a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, b> bannerModelMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, Function1<b, Unit>> listeners;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static boolean isRegister;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Job job;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25066);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
            return;
        }
        f203873a = new O3AIONotifyBannerManager();
        bannerModelMap = new LinkedHashMap();
        listeners = new LinkedHashMap();
    }

    O3AIONotifyBannerManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(String destUin, b msg2) {
        bannerModelMap.put(destUin, msg2);
        Function1<b, Unit> function1 = listeners.get(destUin);
        if (function1 != null) {
            function1.invoke(msg2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(int i3, String errMsg) {
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        QLog.i("O3AIONotifyBannerManager", 1, "register result = " + i3 + ", errMsg = " + errMsg);
    }

    public final void c(@NotNull String destUin, @NotNull Function1<? super b, Unit> listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) destUin, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(destUin, "destUin");
        Intrinsics.checkNotNullParameter(listener, "listener");
        listeners.put(destUin, listener);
    }

    public final void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        QLog.i("O3AIONotifyBannerManager", 1, QCircleLpReportDc05507.KEY_CLEAR);
        bannerModelMap.clear();
        listeners.clear();
        isRegister = false;
        Job job2 = job;
        if (job2 != null) {
            Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
        job = null;
    }

    @Nullable
    public final b e(@NotNull String destUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (b) iPatchRedirector.redirect((short) 3, (Object) this, (Object) destUin);
        }
        Intrinsics.checkNotNullParameter(destUin, "destUin");
        return bannerModelMap.get(destUin);
    }

    public final void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        QLog.i("O3AIONotifyBannerManager", 1, "registerSysMsgNotification " + isRegister);
        if (isRegister || MobileQQ.sProcessId != 1) {
            return;
        }
        if (MobileQQ.sMobileQQ.peekAppRuntime() == null) {
            QLog.e("O3AIONotifyBannerManager", 1, "observe push failed: runtime is null");
            return;
        }
        isRegister = true;
        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(377L);
        ((IMsgService) QRoute.api(IMsgService.class)).registerSysMsgNotification(0, 528L, arrayList, new IOperateCallback() { // from class: com.tencent.mobileqq.dt.tip.c
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                O3AIONotifyBannerManager.h(i3, str);
            }
        });
        job = FlowKt.launchIn(FlowKt.onEach(((IMsgService) QRoute.api(IMsgService.class)).receiveSysMsgNotificationFlow(), new O3AIONotifyBannerManager$registerSysMsgNotification$2(null)), GlobalScope.INSTANCE);
    }

    public final void i(@NotNull String destUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) destUin);
        } else {
            Intrinsics.checkNotNullParameter(destUin, "destUin");
            bannerModelMap.remove(destUin);
        }
    }

    public final void j(@NotNull String destUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) destUin);
        } else {
            Intrinsics.checkNotNullParameter(destUin, "destUin");
            listeners.remove(destUin);
        }
    }
}
