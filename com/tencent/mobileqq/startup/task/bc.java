package com.tencent.mobileqq.startup.task;

import android.content.Context;
import com.tencent.common.config.AppSetting;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.app.PrivacyPolicyHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.unitedconfig_android.api.impl.UnitedConfigManagerImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.startup.task.NtTask;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import mqq.app.lifecycle.UECActivityLifeCycle;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/startup/task/bc;", "Lcom/tencent/qqnt/startup/task/NtTask;", "Landroid/content/Context;", "context", "", TencentLocation.RUN_MODE, "<init>", "()V", "d", "a", "startup_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class bc extends NtTask {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/startup/task/bc$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "startup_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.startup.task.bc$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42717);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public bc() {
        super(null, 1, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.startup.task.c
    public void run(@NotNull Context context) {
        boolean z16;
        boolean z17;
        AppRuntime peekAppRuntime;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        if (MobileQQ.sProcessId == 1) {
            try {
                if (!new File(BaseApplication.getContext().getFilesDir(), "disableSmallLock").exists()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                AppSetting.f99556p = z16;
            } catch (Exception unused) {
                AppSetting.f99556p = false;
            }
            QLog.i("NewRuntimeTask", 1, "enableManagerSmallLock " + AppSetting.f99556p);
            try {
                File file = new File(BaseApplication.getContext().getFilesDir(), "use_merge_account_change");
                MobileQQ.sMobileQQ.setUseMergeAccountChange(file.exists());
                QLog.i("NewRuntimeTask", 1, "setUseMergeAccountChange " + file.exists());
            } catch (Exception unused2) {
                MobileQQ.sMobileQQ.setUseMergeAccountChange(false);
            }
        }
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (MobileQQ.sProcessId == 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        mobileQQ.doInit(z17);
        QLog.d("NewRuntimeTask", 1, "After doInit and waitAppRuntime:" + MobileQQ.sMobileQQ.waitAppRuntime());
        if (Intrinsics.areEqual(MobileQQ.PACKAGE_NAME, MobileQQ.processName)) {
            Foreground.init(MobileQQ.sMobileQQ, ThreadManagerV2.getSubThreadLooper(), MobileQQ.processName);
            if (Intrinsics.areEqual("Success", MobileQQ.sInjectResult) && PrivacyPolicyHelper.isUserAllow()) {
                Foreground.addActivityLifeCallback(new UECActivityLifeCycle(MobileQQ.sMobileQQ, ThreadManagerV2.getSubThreadLooper(), MobileQQ.processName));
            }
            if (GuardManager.sInstance == null && Intrinsics.areEqual(MobileQQ.PACKAGE_NAME, MobileQQ.processName)) {
                GuardManager.sInstance = new GuardManager(MobileQQ.sMobileQQ, 0);
            }
            QLog.d("NewRuntimeTask", 1, "After doInit and finish init GuardManager");
        }
        if (MobileQQ.sProcessId == 1 && (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) != null && !peekAppRuntime.isLogin()) {
            QRouteApi api = QRoute.api(IUnitedConfigManager.class);
            Intrinsics.checkNotNull(api, "null cannot be cast to non-null type com.tencent.mobileqq.unitedconfig_android.api.impl.UnitedConfigManagerImpl");
            ((UnitedConfigManagerImpl) api).fetchNoLogin();
        }
    }
}
