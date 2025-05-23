package com.tencent.mobileqq.zootopia.ipc;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.mobileqq.z1.download.ZPlanResDownloadUrlRsp;
import com.tencent.mobileqq.zplan.ipc.annotation.RemoteCallBack;
import kotlin.Metadata;
import nx4.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@RemoteCallBack
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH&J\u001a\u0010\u000e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0004H&J\u001a\u0010\u000f\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0004H&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/zootopia/ipc/e;", "", "", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "", "filePath", "Lnx4/a$b;", "result", "Lcom/tencent/mobileqq/z1/download/ZPlanResDownloadUrlRsp;", "urlRspInfo", "", "b", "errorCode", "errorMessage", "onDownloadFailed", "a", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public interface e {
    void a(int errorCode, @Nullable String errorMessage);

    void b(int statusCode, @Nullable String filePath, @Nullable a.b result, @NotNull ZPlanResDownloadUrlRsp urlRspInfo);

    void onDownloadFailed(int errorCode, @Nullable String errorMessage);
}
