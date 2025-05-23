package com.tencent.mobileqq.springhb.api;

import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0014\u0010\u0007\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t\u0018\u00010\bH&J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0003H&J\u0018\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/springhb/api/ISpringHbUtilApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getConfContentMd5", "", "configId", "", "getConfTaskId", "getReportDebugFragment", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "saveConfContentMd5", "", "md5", "saveConfTaskId", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "springhb-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface ISpringHbUtilApi extends QRouteApi {
    @Nullable
    String getConfContentMd5(int configId);

    int getConfTaskId(int configId);

    @Nullable
    Class<? extends QPublicBaseFragment> getReportDebugFragment();

    void saveConfContentMd5(int configId, @Nullable String md5);

    void saveConfTaskId(int configId, int taskId);
}
