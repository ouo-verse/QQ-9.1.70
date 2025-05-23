package com.tencent.mobileqq.winkpublish.api;

import android.os.Bundle;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkpublish.TaskInfo;
import com.tencent.mobileqq.winkpublish.model.params.WinkPublishParams;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH&J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0004\u001a\u00020\u000fH&J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH&J&\u0010\u0014\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0016H&\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/api/IPublishApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "addExportTask", "", "params", "Landroid/os/Bundle;", "addTask", "addTaskListener", "listener", "Lcom/tencent/mobileqq/winkpublish/api/ITaskListener;", "businessType", "", "addTaskListenerStrong", "addTaskR", "Lcom/tencent/mobileqq/winkpublish/TaskInfo;", "Lcom/tencent/mobileqq/winkpublish/model/params/WinkPublishParams;", "cancelTaskWithId", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "", "removeTaskListener", "resumeTaskWithId", "resumeFailed", "Lkotlin/Function0;", "qq-winkpublish-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IPublishApi extends QRouteApi {
    void addExportTask(@Nullable Bundle params);

    void addTask(@NotNull Bundle params);

    void addTaskListener(@NotNull ITaskListener listener, int businessType);

    void addTaskListenerStrong(int businessType, @NotNull ITaskListener listener);

    @Nullable
    TaskInfo addTaskR(@NotNull WinkPublishParams params);

    void cancelTaskWithId(int businessType, long taskId);

    void removeTaskListener(int businessType, @NotNull ITaskListener listener);

    void resumeTaskWithId(int businessType, long taskId, @NotNull Function0<Unit> resumeFailed);
}
