package com.tencent.mobileqq.qne.api.impl;

import android.content.Context;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.opr.helper.repair.OldPhotoRepairHelper;
import com.tencent.mobileqq.opr.helper.sr.SuperResolutionHelper;
import com.tencent.mobileqq.opr.model.ModelConfig;
import com.tencent.mobileqq.opr.model.TaskQueueConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qne.api.IQneApi;
import com.tencent.mobileqq.qne.api.SRLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0019\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096\u0001J)\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\bH\u0096\u0001J\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096\u0001J\u001d\u0010\u0011\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0096\u0001\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/qne/api/impl/QneApiImpl;", "Lcom/tencent/mobileqq/qne/api/IQneApi;", "()V", "createOldPhotoRepairHelper", "Lcom/tencent/mobileqq/opr/helper/repair/OldPhotoRepairHelper;", "context", "Landroid/content/Context;", "onlyDownloadOnWifi", "", "createSuperResolutionHelper", "Lcom/tencent/mobileqq/opr/helper/sr/SuperResolutionHelper;", "modelConfig", "Lcom/tencent/mobileqq/opr/model/ModelConfig;", "taskQueueConfig", "Lcom/tencent/mobileqq/opr/model/TaskQueueConfig;", "level", "Lcom/tencent/mobileqq/qne/api/SRLevel;", "isShiplyResourceDownloaded", "resourceId", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "", "qne-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class QneApiImpl implements IQneApi {
    static IPatchRedirector $redirector_;
    private final /* synthetic */ QneApi $$delegate_0;

    public QneApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.$$delegate_0 = QneApi.INSTANCE;
        }
    }

    @Override // com.tencent.mobileqq.qne.api.IQneApi
    @NotNull
    public OldPhotoRepairHelper createOldPhotoRepairHelper(@NotNull Context context, boolean onlyDownloadOnWifi) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (OldPhotoRepairHelper) iPatchRedirector.redirect((short) 2, this, context, Boolean.valueOf(onlyDownloadOnWifi));
        }
        Intrinsics.checkNotNullParameter(context, "context");
        return this.$$delegate_0.createOldPhotoRepairHelper(context, onlyDownloadOnWifi);
    }

    @Override // com.tencent.mobileqq.qne.api.IQneApi
    @NotNull
    public SuperResolutionHelper createSuperResolutionHelper(@NotNull Context context, @NotNull ModelConfig modelConfig, @NotNull TaskQueueConfig taskQueueConfig, boolean onlyDownloadOnWifi) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (SuperResolutionHelper) iPatchRedirector.redirect((short) 3, this, context, modelConfig, taskQueueConfig, Boolean.valueOf(onlyDownloadOnWifi));
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(modelConfig, "modelConfig");
        Intrinsics.checkNotNullParameter(taskQueueConfig, "taskQueueConfig");
        return this.$$delegate_0.createSuperResolutionHelper(context, modelConfig, taskQueueConfig, onlyDownloadOnWifi);
    }

    @Override // com.tencent.mobileqq.qne.api.IQneApi
    public boolean isShiplyResourceDownloaded(@Nullable String resourceId, long taskId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, resourceId, Long.valueOf(taskId))).booleanValue();
        }
        return this.$$delegate_0.isShiplyResourceDownloaded(resourceId, taskId);
    }

    @Override // com.tencent.mobileqq.qne.api.IQneApi
    @NotNull
    public SuperResolutionHelper createSuperResolutionHelper(@NotNull SRLevel level) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (SuperResolutionHelper) iPatchRedirector.redirect((short) 4, (Object) this, (Object) level);
        }
        Intrinsics.checkNotNullParameter(level, "level");
        return this.$$delegate_0.createSuperResolutionHelper(level);
    }
}
