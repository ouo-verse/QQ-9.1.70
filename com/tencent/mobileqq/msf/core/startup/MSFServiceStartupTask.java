package com.tencent.mobileqq.msf.core.startup;

import com.tencent.mobileqq.msf.core.startup.task.AccountCenterInitTask;
import com.tencent.mobileqq.msf.core.startup.task.AppProcessManagerTask;
import com.tencent.mobileqq.msf.core.startup.task.BaseEventManagerInitTask;
import com.tencent.mobileqq.msf.core.startup.task.CheckAppVersionTask;
import com.tencent.mobileqq.msf.core.startup.task.LoadMSFBusinessModuleTask;
import com.tencent.mobileqq.msf.core.startup.task.MSFConfigInitTask;
import com.tencent.mobileqq.msf.core.startup.task.MSFNetServiceInitTask;
import com.tencent.mobileqq.msf.core.startup.task.MSFServiceRespHandlerInitTask;
import com.tencent.mobileqq.msf.core.startup.task.MSFStateReporterInitTask;
import com.tencent.mobileqq.msf.core.startup.task.NetConnInfoCenterInitTask;
import com.tencent.mobileqq.msf.core.startup.task.NtWtloginInitTask;
import com.tencent.mobileqq.msf.core.startup.task.PushManagerInitTask;
import com.tencent.mobileqq.msf.core.startup.task.TestEnvManagerInitTask;
import com.tencent.mobileqq.msf.core.startup.task.WtloginInitTask;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0012\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/msf/core/startup/MSFServiceStartupTask;", "", "(Ljava/lang/String;I)V", "DeviceInfoInitTask", "MSFStoreInitTask", AccountCenterInitTask.TAG, WtloginInitTask.TAG, NtWtloginInitTask.TAG, MSFConfigInitTask.TAG, NetConnInfoCenterInitTask.TAG, TestEnvManagerInitTask.TAG, MSFNetServiceInitTask.TAG, PushManagerInitTask.TAG, AppProcessManagerTask.TAG, MSFServiceRespHandlerInitTask.TAG, LoadMSFBusinessModuleTask.TAG, MSFStateReporterInitTask.TAG, CheckAppVersionTask.TAG, BaseEventManagerInitTask.TAG, "MSFSDK_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public final class MSFServiceStartupTask {
    private static final /* synthetic */ MSFServiceStartupTask[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final MSFServiceStartupTask AccountCenterInitTask;
    public static final MSFServiceStartupTask AppProcessManagerTask;
    public static final MSFServiceStartupTask BaseEventManagerInitTask;
    public static final MSFServiceStartupTask CheckAppVersionTask;
    public static final MSFServiceStartupTask DeviceInfoInitTask;
    public static final MSFServiceStartupTask LoadMSFBusinessModuleTask;
    public static final MSFServiceStartupTask MSFConfigInitTask;
    public static final MSFServiceStartupTask MSFNetServiceInitTask;
    public static final MSFServiceStartupTask MSFServiceRespHandlerInitTask;
    public static final MSFServiceStartupTask MSFStateReporterInitTask;
    public static final MSFServiceStartupTask MSFStoreInitTask;
    public static final MSFServiceStartupTask NetConnInfoCenterInitTask;
    public static final MSFServiceStartupTask NtWtloginInitTask;
    public static final MSFServiceStartupTask PushManagerInitTask;
    public static final MSFServiceStartupTask TestEnvManagerInitTask;
    public static final MSFServiceStartupTask WtloginInitTask;

    private static final /* synthetic */ MSFServiceStartupTask[] $values() {
        return new MSFServiceStartupTask[]{DeviceInfoInitTask, MSFStoreInitTask, AccountCenterInitTask, WtloginInitTask, NtWtloginInitTask, MSFConfigInitTask, NetConnInfoCenterInitTask, TestEnvManagerInitTask, MSFNetServiceInitTask, PushManagerInitTask, AppProcessManagerTask, MSFServiceRespHandlerInitTask, LoadMSFBusinessModuleTask, MSFStateReporterInitTask, CheckAppVersionTask, BaseEventManagerInitTask};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23643);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        DeviceInfoInitTask = new MSFServiceStartupTask("DeviceInfoInitTask", 0);
        MSFStoreInitTask = new MSFServiceStartupTask("MSFStoreInitTask", 1);
        AccountCenterInitTask = new MSFServiceStartupTask(AccountCenterInitTask.TAG, 2);
        WtloginInitTask = new MSFServiceStartupTask(WtloginInitTask.TAG, 3);
        NtWtloginInitTask = new MSFServiceStartupTask(NtWtloginInitTask.TAG, 4);
        MSFConfigInitTask = new MSFServiceStartupTask(MSFConfigInitTask.TAG, 5);
        NetConnInfoCenterInitTask = new MSFServiceStartupTask(NetConnInfoCenterInitTask.TAG, 6);
        TestEnvManagerInitTask = new MSFServiceStartupTask(TestEnvManagerInitTask.TAG, 7);
        MSFNetServiceInitTask = new MSFServiceStartupTask(MSFNetServiceInitTask.TAG, 8);
        PushManagerInitTask = new MSFServiceStartupTask(PushManagerInitTask.TAG, 9);
        AppProcessManagerTask = new MSFServiceStartupTask(AppProcessManagerTask.TAG, 10);
        MSFServiceRespHandlerInitTask = new MSFServiceStartupTask(MSFServiceRespHandlerInitTask.TAG, 11);
        LoadMSFBusinessModuleTask = new MSFServiceStartupTask(LoadMSFBusinessModuleTask.TAG, 12);
        MSFStateReporterInitTask = new MSFServiceStartupTask(MSFStateReporterInitTask.TAG, 13);
        CheckAppVersionTask = new MSFServiceStartupTask(CheckAppVersionTask.TAG, 14);
        BaseEventManagerInitTask = new MSFServiceStartupTask(BaseEventManagerInitTask.TAG, 15);
        $VALUES = $values();
    }

    MSFServiceStartupTask(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static MSFServiceStartupTask valueOf(String str) {
        return (MSFServiceStartupTask) Enum.valueOf(MSFServiceStartupTask.class, str);
    }

    public static MSFServiceStartupTask[] values() {
        return (MSFServiceStartupTask[]) $VALUES.clone();
    }
}
