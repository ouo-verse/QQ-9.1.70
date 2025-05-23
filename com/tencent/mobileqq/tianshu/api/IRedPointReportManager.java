package com.tencent.mobileqq.tianshu.api;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u001c\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u001c\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u001c\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\u0016\u0010\u000e\u001a\u00020\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010H&\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/tianshu/api/IRedPointReportManager;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "reportClick", "", "info", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;", WadlProxyConsts.EXTRA_DATA, "", "path", "reportExposuresDeduplicate", "reportLevelZeroClick", "appSet", "", "reportLevelZeroExposure", "resetExposuresDeduplicate", "pathList", "", "tianshu-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface IRedPointReportManager extends QRouteApi {
    void reportClick(@NotNull BusinessInfoCheckUpdate.AppInfo info, @Nullable String extraData);

    void reportClick(@NotNull String path, @Nullable String extraData);

    void reportExposuresDeduplicate(@NotNull BusinessInfoCheckUpdate.AppInfo info, @Nullable String extraData);

    void reportExposuresDeduplicate(@NotNull String path, @Nullable String extraData);

    void reportLevelZeroClick(int appSet);

    void reportLevelZeroExposure(int appSet);

    void resetExposuresDeduplicate(@NotNull List<String> pathList);
}
