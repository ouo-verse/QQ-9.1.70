package com.tencent.mobileqq.aio.notification;

import com.tencent.aio.main.businesshelper.h;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H&\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000b0\tH&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/aio/notification/IAIONotificationApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "isNotificationEnable", "Lcom/tencent/aio/main/businesshelper/h;", "createAIONotificationHelper", "", "getAIONotificationHelperArray", "()[Lcom/tencent/aio/main/businesshelper/h;", "", "", "Lkotlin/Function0;", "getAIONotificationHelperMap", "aio_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes11.dex */
public interface IAIONotificationApi extends QRouteApi {
    @NotNull
    h createAIONotificationHelper();

    @NotNull
    h[] getAIONotificationHelperArray();

    @NotNull
    Map<String, Function0<h>> getAIONotificationHelperMap();

    boolean isNotificationEnable();
}
