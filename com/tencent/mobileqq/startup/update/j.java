package com.tencent.mobileqq.startup.update;

import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.qqnt.startup.task.NtTask;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016RB\u0010\r\u001a*\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00070\u0006j\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0007`\b8\u0002X\u0083\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u0012\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/startup/update/j;", "Lcom/tencent/qqnt/startup/task/d;", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "Lcom/tencent/qqnt/startup/task/NtTask;", "createTask", "Ljava/util/HashMap;", "Ljava/lang/Class;", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "getSTaskClassMap$annotations", "()V", "sTaskClassMap", "<init>", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class j implements com.tencent.qqnt.startup.task.d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final j f289878a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Startup/Inject_UpdateTaskFactory.yml", version = 1)
    @NotNull
    private static final HashMap<String, Class<NtTask>> sTaskClassMap;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61762);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f289878a = new j();
        HashMap<String, Class<NtTask>> hashMap = new HashMap<>();
        sTaskClassMap = hashMap;
        hashMap.put("UpdateFreesiaTask", d.class);
        hashMap.put("UpdateSharppSoTask", i.class);
        hashMap.put("UpdateSecureFileTask", h.class);
        hashMap.put("UpdatePluginVersionTask", f.class);
        hashMap.put("UpdatePatchConfigTask", e.class);
        hashMap.put("UpdateBubbleZipTask", b.class);
        hashMap.put("UpdateArkSoTask", a.class);
    }

    j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.startup.task.d
    @NotNull
    public NtTask createTask(@NotNull String taskId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (NtTask) iPatchRedirector.redirect((short) 2, (Object) this, (Object) taskId);
        }
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Class<NtTask> cls = sTaskClassMap.get(taskId);
        if (cls != null) {
            NtTask newInstance = cls.newInstance();
            NtTask ntTask = newInstance;
            ntTask.setTaskId(taskId);
            Intrinsics.checkNotNullExpressionValue(newInstance, "clazz.newInstance().appl\u2026Id = taskId\n            }");
            return ntTask;
        }
        throw new RuntimeException("Not support task:" + taskId);
    }
}
