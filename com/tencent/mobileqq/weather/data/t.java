package com.tencent.mobileqq.weather.data;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.jungle.weather.proto.WeatherInfo$Weather;
import com.tencent.jungle.weather.proto.WeatherReportStore$WeatherForecast;
import com.tencent.jungle.weather.proto.WeatherReportStore$WeatherInfo;
import com.tencent.jungle.weather.proto.weather$GetConcernWeatherReply;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.weather.util.WeatherMainConstant$MainScene;

/* compiled from: P */
/* loaded from: classes20.dex */
public class t extends k {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    private final u f313364c;

    public t(@NonNull weather$GetConcernWeatherReply weather_getconcernweatherreply, int i3) {
        super(weather_getconcernweatherreply, i3);
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) weather_getconcernweatherreply, i3);
            return;
        }
        WeatherInfo$Weather weatherInfo$Weather = weather_getconcernweatherreply.weather;
        WeatherReportStore$WeatherInfo weatherReportStore$WeatherInfo = weatherInfo$Weather.weather_info;
        WeatherReportStore$WeatherForecast weatherReportStore$WeatherForecast = weatherInfo$Weather.forecast;
        if (!TextUtils.isEmpty(weatherInfo$Weather.air_info.air_quality.get())) {
            str = weather_getconcernweatherreply.weather.air_info.air_quality.get();
        } else {
            str = "1";
        }
        this.f313364c = new u(weatherReportStore$WeatherInfo.concrete_type.get(), weatherReportStore$WeatherInfo.weather.get(), weatherReportStore$WeatherInfo.temper.get() + "\u00b0", weatherReportStore$WeatherForecast.day_temper.get() + "\u00b0", weatherReportStore$WeatherForecast.night_temper.get() + "\u00b0", weatherReportStore$WeatherInfo.wind_direct.get() + weatherReportStore$WeatherInfo.wind_power.get(), "\u6e7f\u5ea6" + weatherReportStore$WeatherInfo.air_humidity.get() + "%", com.tencent.mobileqq.weather.util.g.f313646a.c(Integer.valueOf(str).intValue()), "\u4e2d\u56fd\u5929\u6c14\u7f51 " + weatherReportStore$WeatherInfo.pubtime.get() + " \u66f4\u65b0", weatherReportStore$WeatherInfo.sunset.get(), weatherReportStore$WeatherInfo.sunrise.get(), weather_getconcernweatherreply.weather.moon.get(), weather_getconcernweatherreply.config.headBackgroundPicPath.get());
    }

    @Override // com.tencent.mobileqq.weather.data.k
    @NonNull
    public WeatherMainConstant$MainScene c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (WeatherMainConstant$MainScene) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return WeatherMainConstant$MainScene.TOP_VIDEO;
    }

    @Override // com.tencent.mobileqq.weather.data.k
    public boolean d(k kVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) kVar)).booleanValue();
        }
        if (!(kVar instanceof t) || ((t) kVar).f313364c != this.f313364c) {
            return false;
        }
        return true;
    }

    public u e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (u) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f313364c;
    }
}
