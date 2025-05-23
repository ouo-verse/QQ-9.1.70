package com.tencent.mobileqq.weather.data;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheWeatherData;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\"\b\u0086\b\u0018\u00002\u00020\u0001Bo\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u0002\u0012\u0006\u0010 \u001a\u00020\u0002\u0012\u0006\u0010\"\u001a\u00020\u0002\u0012\u0006\u0010#\u001a\u00020\u0002\u0012\u0006\u0010$\u001a\u00020\u0002\u0012\u0006\u0010%\u001a\u00020\u0002\u0012\u0006\u0010&\u001a\u00020\u0002\u00a2\u0006\u0004\b'\u0010(J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011R\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u0017\u0010\u0019\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0018\u0010\u0011R\u0017\u0010\u001c\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u000f\u001a\u0004\b\u001b\u0010\u0011R\u0017\u0010\u001e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u000f\u001a\u0004\b\u0016\u0010\u0011R\u0017\u0010 \u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u000f\u001a\u0004\b\t\u0010\u0011R\u0017\u0010\"\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b!\u0010\u0011R\u0017\u0010#\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b!\u0010\u000f\u001a\u0004\b\u001f\u0010\u0011R\u0017\u0010$\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000f\u001a\u0004\b\u001d\u0010\u0011R\u0017\u0010%\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\u001a\u0010\u0011R\u0017\u0010&\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u000f\u001a\u0004\b\u000e\u0010\u0011\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/weather/data/u;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "l", "()I", "weatherType", "b", "Ljava/lang/String;", "k", "()Ljava/lang/String;", "weatherName", "c", "i", "template", "d", "highTemplate", "e", "lowTemplate", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, WidgetCacheWeatherData.WIND, "g", WidgetCacheWeatherData.HUMIDITY, tl.h.F, "airQuality", "j", "updateTime", "sunSetTime", "sunRiseTime", "moonUrl", "headBackgroundPicUrl", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final /* data */ class u {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int weatherType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String weatherName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String template;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String highTemplate;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String lowTemplate;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String wind;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String humidity;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String airQuality;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String updateTime;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String sunSetTime;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String sunRiseTime;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String moonUrl;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String headBackgroundPicUrl;

    public u(int i3, @NotNull String weatherName, @NotNull String template, @NotNull String highTemplate, @NotNull String lowTemplate, @NotNull String wind, @NotNull String humidity, @NotNull String airQuality, @NotNull String updateTime, @NotNull String sunSetTime, @NotNull String sunRiseTime, @NotNull String moonUrl, @NotNull String headBackgroundPicUrl) {
        Intrinsics.checkNotNullParameter(weatherName, "weatherName");
        Intrinsics.checkNotNullParameter(template, "template");
        Intrinsics.checkNotNullParameter(highTemplate, "highTemplate");
        Intrinsics.checkNotNullParameter(lowTemplate, "lowTemplate");
        Intrinsics.checkNotNullParameter(wind, "wind");
        Intrinsics.checkNotNullParameter(humidity, "humidity");
        Intrinsics.checkNotNullParameter(airQuality, "airQuality");
        Intrinsics.checkNotNullParameter(updateTime, "updateTime");
        Intrinsics.checkNotNullParameter(sunSetTime, "sunSetTime");
        Intrinsics.checkNotNullParameter(sunRiseTime, "sunRiseTime");
        Intrinsics.checkNotNullParameter(moonUrl, "moonUrl");
        Intrinsics.checkNotNullParameter(headBackgroundPicUrl, "headBackgroundPicUrl");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), weatherName, template, highTemplate, lowTemplate, wind, humidity, airQuality, updateTime, sunSetTime, sunRiseTime, moonUrl, headBackgroundPicUrl);
            return;
        }
        this.weatherType = i3;
        this.weatherName = weatherName;
        this.template = template;
        this.highTemplate = highTemplate;
        this.lowTemplate = lowTemplate;
        this.wind = wind;
        this.humidity = humidity;
        this.airQuality = airQuality;
        this.updateTime = updateTime;
        this.sunSetTime = sunSetTime;
        this.sunRiseTime = sunRiseTime;
        this.moonUrl = moonUrl;
        this.headBackgroundPicUrl = headBackgroundPicUrl;
    }

    @NotNull
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.airQuality;
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.headBackgroundPicUrl;
    }

    @NotNull
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.highTemplate;
    }

    @NotNull
    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.humidity;
    }

    @NotNull
    public final String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.lowTemplate;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Boolean) iPatchRedirector.redirect((short) 31, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof u)) {
            return false;
        }
        u uVar = (u) other;
        if (this.weatherType == uVar.weatherType && Intrinsics.areEqual(this.weatherName, uVar.weatherName) && Intrinsics.areEqual(this.template, uVar.template) && Intrinsics.areEqual(this.highTemplate, uVar.highTemplate) && Intrinsics.areEqual(this.lowTemplate, uVar.lowTemplate) && Intrinsics.areEqual(this.wind, uVar.wind) && Intrinsics.areEqual(this.humidity, uVar.humidity) && Intrinsics.areEqual(this.airQuality, uVar.airQuality) && Intrinsics.areEqual(this.updateTime, uVar.updateTime) && Intrinsics.areEqual(this.sunSetTime, uVar.sunSetTime) && Intrinsics.areEqual(this.sunRiseTime, uVar.sunRiseTime) && Intrinsics.areEqual(this.moonUrl, uVar.moonUrl) && Intrinsics.areEqual(this.headBackgroundPicUrl, uVar.headBackgroundPicUrl)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.moonUrl;
    }

    @NotNull
    public final String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.sunRiseTime;
    }

    @NotNull
    public final String h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.sunSetTime;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Integer) iPatchRedirector.redirect((short) 30, (Object) this)).intValue();
        }
        return (((((((((((((((((((((((this.weatherType * 31) + this.weatherName.hashCode()) * 31) + this.template.hashCode()) * 31) + this.highTemplate.hashCode()) * 31) + this.lowTemplate.hashCode()) * 31) + this.wind.hashCode()) * 31) + this.humidity.hashCode()) * 31) + this.airQuality.hashCode()) * 31) + this.updateTime.hashCode()) * 31) + this.sunSetTime.hashCode()) * 31) + this.sunRiseTime.hashCode()) * 31) + this.moonUrl.hashCode()) * 31) + this.headBackgroundPicUrl.hashCode();
    }

    @NotNull
    public final String i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.template;
    }

    @NotNull
    public final String j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.updateTime;
    }

    @NotNull
    public final String k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.weatherName;
    }

    public final int l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.weatherType;
    }

    @NotNull
    public final String m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.wind;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (String) iPatchRedirector.redirect((short) 29, (Object) this);
        }
        return "WeatherTopData(weatherType=" + this.weatherType + ", weatherName=" + this.weatherName + ", template=" + this.template + ", highTemplate=" + this.highTemplate + ", lowTemplate=" + this.lowTemplate + ", wind=" + this.wind + ", humidity=" + this.humidity + ", airQuality=" + this.airQuality + ", updateTime=" + this.updateTime + ", sunSetTime=" + this.sunSetTime + ", sunRiseTime=" + this.sunRiseTime + ", moonUrl=" + this.moonUrl + ", headBackgroundPicUrl=" + this.headBackgroundPicUrl + ")";
    }
}
