package com.tencent.mobileqq.app.automator.step;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AppSetting;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import mqq.util.MqqConfigUtil;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0000\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0014\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/app/automator/step/MqqConfigLoadStep;", "Lcom/tencent/mobileqq/app/automator/AsyncStep;", "Lcom/tencent/mobileqq/app/automator/Automator;", "", "g", tl.h.F, "", "switchIndex", WadlProxyConsts.PARAM_FILENAME, "b", "", "doStep", "<init>", "()V", "d", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class MqqConfigLoadStep extends AsyncStep<Automator> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/app/automator/step/MqqConfigLoadStep$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.app.automator.step.MqqConfigLoadStep$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53999);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public MqqConfigLoadStep() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void b(String switchIndex, String fileName) {
        boolean z16;
        if (AppSetting.isPublicVersion()) {
            z16 = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(switchIndex, false);
        } else {
            z16 = true;
        }
        File configFile = MqqConfigUtil.INSTANCE.getConfigFile(fileName);
        File parentFile = configFile.getParentFile();
        if (parentFile == null) {
            QLog.e("MqqConfigLoadStep", 1, "handleConfig get parentDir fail");
            return;
        }
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        if (z16) {
            if (!configFile.exists()) {
                configFile.createNewFile();
            }
        } else if (configFile.exists()) {
            configFile.delete();
        }
        QLog.d("MqqConfigLoadStep", 1, "init handleConfig switchIndex: " + switchIndex + ", fileName: " + fileName + ", configValue: " + z16);
    }

    private final void g() {
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("use_merge_account_change", false);
        File file = new File(BaseApplication.getContext().getFilesDir(), "use_merge_account_change");
        if (isSwitchOn) {
            file.createNewFile();
        } else if (file.exists()) {
            file.delete();
        }
        QLog.d("MqqConfigLoadStep", 1, "init handleMergeAccountConfig useMergeAccChange: " + isSwitchOn);
    }

    private final void h() {
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("use_notify_aggregate", true);
        File file = new File(BaseApplication.getContext().getFilesDir(), "use_notify_aggregate");
        if (isSwitchOn) {
            file.createNewFile();
        } else if (file.exists()) {
            file.delete();
        }
        QLog.d("MqqConfigLoadStep", 1, "init handleNotifyAggregateConfig useNotifyAggregate: " + isSwitchOn);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.automator.AsyncStep
    public int doStep() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        g();
        h();
        b("105994", "use_notify_single_thread");
        b("106131", "runtime_use_string_key");
        b("106179", "runtime_register_msf_service");
        b("106208", "main_service_popup_window");
        return 7;
    }
}
