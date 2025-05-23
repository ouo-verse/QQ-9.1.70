package com.tencent.mobileqq.msf.core.startup;

import android.util.Log;
import com.tencent.mobileqq.msf.core.startup.task.AccountCenterInitTask;
import com.tencent.mobileqq.msf.core.startup.task.AppProcessManagerTask;
import com.tencent.mobileqq.msf.core.startup.task.BaseEventManagerInitTask;
import com.tencent.mobileqq.msf.core.startup.task.CheckAppVersionTask;
import com.tencent.mobileqq.msf.core.startup.task.DeviceInfoInitTask;
import com.tencent.mobileqq.msf.core.startup.task.LoadMSFBusinessModuleTask;
import com.tencent.mobileqq.msf.core.startup.task.MSFConfigInitTask;
import com.tencent.mobileqq.msf.core.startup.task.MSFNetServiceInitTask;
import com.tencent.mobileqq.msf.core.startup.task.MSFServiceRespHandlerInitTask;
import com.tencent.mobileqq.msf.core.startup.task.MSFStateReporterInitTask;
import com.tencent.mobileqq.msf.core.startup.task.MSFStoreInitTask;
import com.tencent.mobileqq.msf.core.startup.task.NetConnInfoCenterInitTask;
import com.tencent.mobileqq.msf.core.startup.task.NtWtloginInitTask;
import com.tencent.mobileqq.msf.core.startup.task.PushManagerInitTask;
import com.tencent.mobileqq.msf.core.startup.task.TestEnvManagerInitTask;
import com.tencent.mobileqq.msf.core.startup.task.WtloginInitTask;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R>\u0010\u0005\u001a2\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\b0\u00070\u0006j\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\b0\u0007`\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/msf/core/startup/MSFStartupTaskFactory;", "", "()V", "TAG", "", "sTaskClassMap", "Ljava/util/HashMap;", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/msf/core/startup/MSFTask;", "Lkotlin/collections/HashMap;", "createTask", "taskName", "MSFSDK_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public final class MSFStartupTaskFactory {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    public static final MSFStartupTaskFactory INSTANCE;

    @NotNull
    private static final String TAG = "MSFStartupTaskFactory";

    @NotNull
    private static final HashMap<String, Class<? extends MSFTask>> sTaskClassMap;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19657);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        INSTANCE = new MSFStartupTaskFactory();
        HashMap<String, Class<? extends MSFTask>> hashMap = new HashMap<>();
        sTaskClassMap = hashMap;
        hashMap.put("DeviceInfoInitTask", DeviceInfoInitTask.class);
        hashMap.put("MSFStoreInitTask", MSFStoreInitTask.class);
        hashMap.put(AccountCenterInitTask.TAG, AccountCenterInitTask.class);
        hashMap.put(WtloginInitTask.TAG, WtloginInitTask.class);
        hashMap.put(NtWtloginInitTask.TAG, NtWtloginInitTask.class);
        hashMap.put(MSFConfigInitTask.TAG, MSFConfigInitTask.class);
        hashMap.put(NetConnInfoCenterInitTask.TAG, NetConnInfoCenterInitTask.class);
        hashMap.put(TestEnvManagerInitTask.TAG, TestEnvManagerInitTask.class);
        hashMap.put(MSFNetServiceInitTask.TAG, MSFNetServiceInitTask.class);
        hashMap.put(PushManagerInitTask.TAG, PushManagerInitTask.class);
        hashMap.put(AppProcessManagerTask.TAG, AppProcessManagerTask.class);
        hashMap.put(MSFServiceRespHandlerInitTask.TAG, MSFServiceRespHandlerInitTask.class);
        hashMap.put(LoadMSFBusinessModuleTask.TAG, LoadMSFBusinessModuleTask.class);
        hashMap.put(MSFStateReporterInitTask.TAG, MSFStateReporterInitTask.class);
        hashMap.put(CheckAppVersionTask.TAG, CheckAppVersionTask.class);
        hashMap.put(BaseEventManagerInitTask.TAG, BaseEventManagerInitTask.class);
    }

    MSFStartupTaskFactory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    public final MSFTask createTask(@NotNull String taskName) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (MSFTask) iPatchRedirector.redirect((short) 3, (Object) this, (Object) taskName);
        }
        Intrinsics.checkNotNullParameter(taskName, "taskName");
        HashMap<String, Class<? extends MSFTask>> hashMap = sTaskClassMap;
        Class<? extends MSFTask> cls = hashMap.get(taskName);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("map size:");
        sb5.append(hashMap.size());
        sb5.append(", taskName:");
        sb5.append(taskName);
        sb5.append(", contain:");
        if (cls != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        Log.d("MSFStartup", sb5.toString());
        if (cls != null) {
            try {
                return cls.newInstance();
            } catch (Exception e16) {
                if (BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion()) {
                    BaseApplication.getContext().getMSFInterfaceAdapter().handleCatchException(Thread.currentThread(), e16, "MSFTaskCreateException", null);
                }
                QLog.e(TAG, 1, e16, new Object[0]);
                return null;
            }
        }
        throw new RuntimeException("Not support task:" + taskName);
    }
}
