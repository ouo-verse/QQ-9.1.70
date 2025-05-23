package com.tencent.mobileqq.popanim.api;

import com.tencent.aio.api.runtime.a;
import com.tencent.mobileqq.popanim.PopOutAnimConfig;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/popanim/api/INTPopOutAnimConfig;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lcom/tencent/mobileqq/popanim/PopOutAnimConfig;", "getNTPopOutAnimConfig", "qqemoticonpanel-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {""})
/* loaded from: classes16.dex */
public interface INTPopOutAnimConfig extends QRouteApi {
    @NotNull
    PopOutAnimConfig getNTPopOutAnimConfig(@NotNull a aioContext);
}
