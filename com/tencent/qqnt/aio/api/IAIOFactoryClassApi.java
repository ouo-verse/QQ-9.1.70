package com.tencent.qqnt.aio.api;

import android.content.Context;
import com.tencent.aio.data.AIOParam;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H&J\b\u0010\n\u001a\u00020\tH&J\b\u0010\u000b\u001a\u00020\tH&J\b\u0010\f\u001a\u00020\tH&J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH&\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/aio/api/IAIOFactoryClassApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/content/Context;", "context", "", "isScaleAIO", "isMiniAIO", "", "getMsgHeadPadding", "", "getFirstScreenHelperName", "getC2CAIOFactory", "getGroupAIOFactory", "Lcom/tencent/aio/data/AIOParam;", "aioParam", "Lts/b;", "createAIOAssistanceService", "aio_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IAIOFactoryClassApi extends QRouteApi {
    @NotNull
    ts.b createAIOAssistanceService(@NotNull Context context, @NotNull AIOParam aioParam);

    @NotNull
    String getC2CAIOFactory();

    @NotNull
    String getFirstScreenHelperName();

    @NotNull
    String getGroupAIOFactory();

    int getMsgHeadPadding(@NotNull Context context, boolean isScaleAIO, boolean isMiniAIO);
}
