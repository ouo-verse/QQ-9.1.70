package com.tencent.mobileqq.zootopia.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@QRouteFactory(singleton = true)
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\b\u001a\u00020\u0007H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/zootopia/api/IZootopiaEnterUEModApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/mobileqq/zootopia/api/a;", "processor", "", "registerEnterMapProcessor", "unRegisterEnterMapProcessor", "", "getCurrMapName", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"zplan"})
/* loaded from: classes21.dex */
public interface IZootopiaEnterUEModApi extends QRouteApi {
    @NotNull
    String getCurrMapName();

    void registerEnterMapProcessor(@Nullable a processor);

    void unRegisterEnterMapProcessor(@Nullable a processor);
}
