package com.tencent.mobileqq.weather.api;

import com.tencent.kuikly.core.render.android.b;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/weather/api/IWeatherKuiklyApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/kuikly/core/render/android/b;", "renderExport", "", "registerExternalRenderView", "registerExternalModule", "qq-weather-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IWeatherKuiklyApi extends QRouteApi {
    void registerExternalModule(@NotNull b renderExport);

    void registerExternalRenderView(@NotNull b renderExport);
}
