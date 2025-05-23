package com.tencent.mobileqq.msf.core.startup;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.text.StringsKt__IndentKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/msf/core/startup/MSFServiceStartupConfigReader;", "", "()V", "readConfigFile", "", "MSFSDK_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public final class MSFServiceStartupConfigReader {
    static IPatchRedirector $redirector_;

    @NotNull
    public static final MSFServiceStartupConfigReader INSTANCE;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29143);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            INSTANCE = new MSFServiceStartupConfigReader();
        }
    }

    MSFServiceStartupConfigReader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final String readConfigFile() {
        String trimIndent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("\n            >> ");
        sb5.append(MSFServiceStartupStage.MSFServiceInit);
        sb5.append("\n                ");
        sb5.append(MSFServiceStartupTask.MSFStateReporterInitTask);
        sb5.append("\n                ");
        sb5.append(MSFServiceStartupTask.CheckAppVersionTask);
        sb5.append("\n                ");
        MSFServiceStartupTask mSFServiceStartupTask = MSFServiceStartupTask.DeviceInfoInitTask;
        sb5.append(mSFServiceStartupTask);
        sb5.append("\n                ");
        MSFServiceStartupTask mSFServiceStartupTask2 = MSFServiceStartupTask.BaseEventManagerInitTask;
        sb5.append(mSFServiceStartupTask2);
        sb5.append("\n                ");
        MSFServiceStartupTask mSFServiceStartupTask3 = MSFServiceStartupTask.MSFStoreInitTask;
        sb5.append(mSFServiceStartupTask3);
        sb5.append("\n                ");
        MSFServiceStartupTask mSFServiceStartupTask4 = MSFServiceStartupTask.WtloginInitTask;
        sb5.append(mSFServiceStartupTask4);
        sb5.append("\n                ");
        sb5.append(mSFServiceStartupTask3);
        sb5.append("-->");
        MSFServiceStartupTask mSFServiceStartupTask5 = MSFServiceStartupTask.AccountCenterInitTask;
        sb5.append(mSFServiceStartupTask5);
        sb5.append("\n                ");
        sb5.append(mSFServiceStartupTask4);
        sb5.append("-->");
        sb5.append(mSFServiceStartupTask5);
        sb5.append("\n                ");
        sb5.append(mSFServiceStartupTask5);
        sb5.append("-->");
        sb5.append(MSFServiceStartupTask.NtWtloginInitTask);
        sb5.append("\n                ");
        sb5.append(mSFServiceStartupTask3);
        sb5.append("-->");
        sb5.append(mSFServiceStartupTask5);
        sb5.append("-->");
        MSFServiceStartupTask mSFServiceStartupTask6 = MSFServiceStartupTask.MSFConfigInitTask;
        sb5.append(mSFServiceStartupTask6);
        sb5.append("\n                ");
        MSFServiceStartupTask mSFServiceStartupTask7 = MSFServiceStartupTask.TestEnvManagerInitTask;
        sb5.append(mSFServiceStartupTask7);
        sb5.append("\n                ");
        MSFServiceStartupTask mSFServiceStartupTask8 = MSFServiceStartupTask.NetConnInfoCenterInitTask;
        sb5.append(mSFServiceStartupTask8);
        sb5.append("\n                ");
        sb5.append(mSFServiceStartupTask);
        sb5.append("-->");
        MSFServiceStartupTask mSFServiceStartupTask9 = MSFServiceStartupTask.MSFNetServiceInitTask;
        sb5.append(mSFServiceStartupTask9);
        sb5.append("\n                ");
        sb5.append(mSFServiceStartupTask2);
        sb5.append("-->");
        sb5.append(mSFServiceStartupTask9);
        sb5.append("\n                ");
        sb5.append(mSFServiceStartupTask6);
        sb5.append("-->");
        sb5.append(mSFServiceStartupTask9);
        sb5.append("\n                ");
        sb5.append(mSFServiceStartupTask3);
        sb5.append("-->");
        sb5.append(mSFServiceStartupTask5);
        sb5.append("-->");
        sb5.append(mSFServiceStartupTask9);
        sb5.append("\n                ");
        sb5.append(mSFServiceStartupTask7);
        sb5.append("-->");
        sb5.append(mSFServiceStartupTask9);
        sb5.append("\n                ");
        sb5.append(mSFServiceStartupTask8);
        sb5.append("-->");
        sb5.append(mSFServiceStartupTask9);
        sb5.append("\n                ");
        sb5.append(mSFServiceStartupTask3);
        sb5.append("-->");
        sb5.append(mSFServiceStartupTask9);
        sb5.append("-->");
        sb5.append(MSFServiceStartupTask.PushManagerInitTask);
        sb5.append("\n                ");
        sb5.append(mSFServiceStartupTask3);
        sb5.append("-->");
        sb5.append(mSFServiceStartupTask6);
        sb5.append("-->");
        MSFServiceStartupTask mSFServiceStartupTask10 = MSFServiceStartupTask.AppProcessManagerTask;
        sb5.append(mSFServiceStartupTask10);
        sb5.append("\n                ");
        sb5.append(mSFServiceStartupTask10);
        sb5.append("-->");
        sb5.append(MSFServiceStartupTask.MSFServiceRespHandlerInitTask);
        sb5.append("\n                ");
        sb5.append(mSFServiceStartupTask9);
        sb5.append("-->");
        sb5.append(MSFServiceStartupTask.LoadMSFBusinessModuleTask);
        sb5.append("     \n            <<\n        ");
        trimIndent = StringsKt__IndentKt.trimIndent(sb5.toString());
        return trimIndent;
    }
}
