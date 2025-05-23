package com.tencent.mobileqq.msf;

import android.util.Log;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.msf.adapter.AccountCenterInitTaskAdapter;
import com.tencent.mobileqq.msf.adapter.AppProcessManagerTaskAdapter;
import com.tencent.mobileqq.msf.adapter.BaseEventManagerInitTaskAdapter;
import com.tencent.mobileqq.msf.adapter.CheckAppVersionTaskAdapter;
import com.tencent.mobileqq.msf.adapter.LoadMSFBusinessModuleTaskAdapter;
import com.tencent.mobileqq.msf.adapter.MSFConfigInitTaskAdapter;
import com.tencent.mobileqq.msf.adapter.MSFDeviceInfoInitTaskAdapter;
import com.tencent.mobileqq.msf.adapter.MSFNetServiceInitTaskAdapter;
import com.tencent.mobileqq.msf.adapter.MSFNtWtloginInitTaskAdapter;
import com.tencent.mobileqq.msf.adapter.MSFServiceRespHandlerInitTaskAdapter;
import com.tencent.mobileqq.msf.adapter.MSFStateReporterInitTaskAdapter;
import com.tencent.mobileqq.msf.adapter.MSFStoreInitTaskAdapter;
import com.tencent.mobileqq.msf.adapter.NetConnInfoCenterInitTaskAdapter;
import com.tencent.mobileqq.msf.adapter.PushManagerInitTaskAdapter;
import com.tencent.mobileqq.msf.adapter.TestEnvManagerInitTaskAdapter;
import com.tencent.mobileqq.msf.adapter.WtloginInitTaskAdapter;
import com.tencent.mobileqq.msf.core.startup.MSFStartupTaskFactory;
import com.tencent.mobileqq.msf.core.startup.MSFTask;
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
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.qqnt.startup.task.NtTask;
import com.tencent.qqnt.startup.task.d;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016RB\u0010\t\u001a*\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00070\u0006j\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0007`\b8\u0002X\u0083\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u0012\u0004\b\u000b\u0010\f\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/msf/MSFStartupTaskAdapterFactory;", "Lcom/tencent/qqnt/startup/task/d;", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "Lcom/tencent/qqnt/startup/task/NtTask;", "createTask", "Ljava/util/HashMap;", "Ljava/lang/Class;", "Lkotlin/collections/HashMap;", "sTaskClassMap", "Ljava/util/HashMap;", "getSTaskClassMap$annotations", "()V", "<init>", "startup_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class MSFStartupTaskAdapterFactory implements d {
    static IPatchRedirector $redirector_;

    @NotNull
    public static final MSFStartupTaskAdapterFactory INSTANCE;

    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Startup/Inject_MSFStartupTaskFactory.yml", version = 1)
    @NotNull
    private static final HashMap<String, Class<NtTask>> sTaskClassMap;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23678);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        INSTANCE = new MSFStartupTaskAdapterFactory();
        HashMap<String, Class<NtTask>> hashMap = new HashMap<>();
        sTaskClassMap = hashMap;
        hashMap.put(BaseEventManagerInitTask.TAG, BaseEventManagerInitTaskAdapter.class);
        hashMap.put(NtWtloginInitTask.TAG, MSFNtWtloginInitTaskAdapter.class);
        hashMap.put(CheckAppVersionTask.TAG, CheckAppVersionTaskAdapter.class);
        hashMap.put(MSFStateReporterInitTask.TAG, MSFStateReporterInitTaskAdapter.class);
        hashMap.put(LoadMSFBusinessModuleTask.TAG, LoadMSFBusinessModuleTaskAdapter.class);
        hashMap.put(MSFServiceRespHandlerInitTask.TAG, MSFServiceRespHandlerInitTaskAdapter.class);
        hashMap.put(AppProcessManagerTask.TAG, AppProcessManagerTaskAdapter.class);
        hashMap.put(PushManagerInitTask.TAG, PushManagerInitTaskAdapter.class);
        hashMap.put(MSFNetServiceInitTask.TAG, MSFNetServiceInitTaskAdapter.class);
        hashMap.put(TestEnvManagerInitTask.TAG, TestEnvManagerInitTaskAdapter.class);
        hashMap.put(NetConnInfoCenterInitTask.TAG, NetConnInfoCenterInitTaskAdapter.class);
        hashMap.put(MSFConfigInitTask.TAG, MSFConfigInitTaskAdapter.class);
        hashMap.put(WtloginInitTask.TAG, WtloginInitTaskAdapter.class);
        hashMap.put(AccountCenterInitTask.TAG, AccountCenterInitTaskAdapter.class);
        hashMap.put("MSFStoreInitTask", MSFStoreInitTaskAdapter.class);
        hashMap.put("DeviceInfoInitTask", MSFDeviceInfoInitTaskAdapter.class);
    }

    MSFStartupTaskAdapterFactory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.startup.task.d
    @NotNull
    public NtTask createTask(@NotNull String taskId) {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (NtTask) iPatchRedirector.redirect((short) 2, (Object) this, (Object) taskId);
        }
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        HashMap<String, Class<NtTask>> hashMap = sTaskClassMap;
        Class<NtTask> cls = hashMap.get(taskId);
        MSFTask createTask = MSFStartupTaskFactory.INSTANCE.createTask(taskId);
        int size = hashMap.size();
        if (cls != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (createTask != null) {
            z17 = true;
        } else {
            z17 = false;
        }
        Log.d("MSFStartup", "map size:" + size + ", taskId:" + taskId + ", contain NTTask:" + z16 + ", MSFTask:" + z17);
        if (createTask != null && cls != null) {
            NtTask newInstance = cls.getConstructor(MSFTask.class).newInstance(createTask);
            NtTask ntTask = newInstance;
            ntTask.setTaskId(taskId);
            Intrinsics.checkNotNullExpressionValue(newInstance, "constructor.newInstance(\u2026Id = taskId\n            }");
            return ntTask;
        }
        throw new RuntimeException("Not support task:" + taskId);
    }

    @JvmStatic
    private static /* synthetic */ void getSTaskClassMap$annotations() {
    }
}
