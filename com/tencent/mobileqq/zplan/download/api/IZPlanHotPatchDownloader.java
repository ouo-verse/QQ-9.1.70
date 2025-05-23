package com.tencent.mobileqq.zplan.download.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@QRouteFactory(singleton = true)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001:\u0001\nJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/zplan/download/api/IZPlanHotPatchDownloader;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/content/Context;", "context", "", "source", "Lcom/tencent/mobileqq/zplan/download/api/IZPlanHotPatchDownloader$a;", "cb", "", "checkHotPatch", "a", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IZPlanHotPatchDownloader extends QRouteApi {

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/zplan/download/api/IZPlanHotPatchDownloader$a;", "", "", "source", "", "result", "", "a", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public interface a {
        void a(int source, boolean result);
    }

    void checkHotPatch(@NotNull Context context, int source, @NotNull a cb5);
}
