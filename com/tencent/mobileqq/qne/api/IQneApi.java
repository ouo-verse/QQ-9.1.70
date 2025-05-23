package com.tencent.mobileqq.qne.api;

import android.content.Context;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.opr.helper.repair.OldPhotoRepairHelper;
import com.tencent.mobileqq.opr.helper.sr.SuperResolutionHelper;
import com.tencent.mobileqq.opr.model.ModelConfig;
import com.tencent.mobileqq.opr.model.TaskQueueConfig;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@QRouteFactory(singleton = true)
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J(\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u001c\u0010\u0010\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0014H&\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/qne/api/IQneApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "createOldPhotoRepairHelper", "Lcom/tencent/mobileqq/opr/helper/repair/OldPhotoRepairHelper;", "context", "Landroid/content/Context;", "onlyDownloadOnWifi", "", "createSuperResolutionHelper", "Lcom/tencent/mobileqq/opr/helper/sr/SuperResolutionHelper;", "modelConfig", "Lcom/tencent/mobileqq/opr/model/ModelConfig;", "taskQueueConfig", "Lcom/tencent/mobileqq/opr/model/TaskQueueConfig;", "level", "Lcom/tencent/mobileqq/qne/api/SRLevel;", "isShiplyResourceDownloaded", "resourceId", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "", "qne-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {""})
/* loaded from: classes16.dex */
public interface IQneApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public static final class a {
        public static /* synthetic */ boolean a(IQneApi iQneApi, String str, long j3, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    j3 = 0;
                }
                return iQneApi.isShiplyResourceDownloaded(str, j3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: isShiplyResourceDownloaded");
        }
    }

    @NotNull
    OldPhotoRepairHelper createOldPhotoRepairHelper(@NotNull Context context, boolean onlyDownloadOnWifi);

    @NotNull
    SuperResolutionHelper createSuperResolutionHelper(@NotNull Context context, @NotNull ModelConfig modelConfig, @NotNull TaskQueueConfig taskQueueConfig, boolean onlyDownloadOnWifi);

    @NotNull
    SuperResolutionHelper createSuperResolutionHelper(@NotNull SRLevel level);

    boolean isShiplyResourceDownloaded(@Nullable String resourceId, long taskId);
}
