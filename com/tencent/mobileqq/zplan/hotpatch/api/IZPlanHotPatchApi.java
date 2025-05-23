package com.tencent.mobileqq.zplan.hotpatch.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import ji3.c;
import ji3.d;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import zh3.a;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H&J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H&J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH&J\b\u0010\u000e\u001a\u00020\u0004H&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/zplan/hotpatch/api/IZPlanHotPatchApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lji3/d;", "listener", "", "registerHotPatchStatusListener", "unregisterHotPatchStatusListener", "Lji3/c;", "registerHotPatchProgressListener", "unregisterHotPatchProgressListener", "Landroid/content/Context;", "context", "Lzh3/a;", "createHotPatchProgressView", "interruptHotPatching", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IZPlanHotPatchApi extends QRouteApi {
    @NotNull
    a createHotPatchProgressView(@NotNull Context context);

    void interruptHotPatching();

    void registerHotPatchProgressListener(@NotNull c listener);

    void registerHotPatchStatusListener(@NotNull d listener);

    void unregisterHotPatchProgressListener(@NotNull c listener);

    void unregisterHotPatchStatusListener(@NotNull d listener);
}
