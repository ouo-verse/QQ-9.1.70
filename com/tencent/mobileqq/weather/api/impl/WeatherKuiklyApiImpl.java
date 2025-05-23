package com.tencent.mobileqq.weather.api.impl;

import com.tencent.kuikly.core.render.android.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.weather.api.IWeatherKuiklyApi;
import com.tencent.mobileqq.weather.hippy.QQWeatherModule;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/weather/api/impl/WeatherKuiklyApiImpl;", "Lcom/tencent/mobileqq/weather/api/IWeatherKuiklyApi;", "Lcom/tencent/kuikly/core/render/android/b;", "renderExport", "", "registerExternalRenderView", "registerExternalModule", "<init>", "()V", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class WeatherKuiklyApiImpl implements IWeatherKuiklyApi {
    static IPatchRedirector $redirector_;

    public WeatherKuiklyApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.weather.api.IWeatherKuiklyApi
    public void registerExternalModule(@NotNull b renderExport) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) renderExport);
        } else {
            Intrinsics.checkNotNullParameter(renderExport, "renderExport");
            renderExport.a(QQWeatherModule.NAME, WeatherKuiklyApiImpl$registerExternalModule$1$1.INSTANCE);
        }
    }

    @Override // com.tencent.mobileqq.weather.api.IWeatherKuiklyApi
    public void registerExternalRenderView(@NotNull b renderExport) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) renderExport);
            return;
        }
        Intrinsics.checkNotNullParameter(renderExport, "renderExport");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }
}
