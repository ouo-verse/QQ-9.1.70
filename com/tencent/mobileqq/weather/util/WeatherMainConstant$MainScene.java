package com.tencent.mobileqq.weather.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/weather/util/WeatherMainConstant$MainScene", "", "Lcom/tencent/mobileqq/weather/util/WeatherMainConstant$MainScene;", "<init>", "(Ljava/lang/String;I)V", "TOP_VIDEO", "HOUR", "AD", "DAY", "QUOTE", "ALMANAC", b8.a.CONSTELLATION, "NEWS", "TEXT", "RECOMMEND_BANNER", "NIGHT_CARE", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class WeatherMainConstant$MainScene {
    private static final /* synthetic */ WeatherMainConstant$MainScene[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final WeatherMainConstant$MainScene AD;
    public static final WeatherMainConstant$MainScene ALMANAC;
    public static final WeatherMainConstant$MainScene CONSTELLATION;
    public static final WeatherMainConstant$MainScene DAY;
    public static final WeatherMainConstant$MainScene HOUR;
    public static final WeatherMainConstant$MainScene NEWS;
    public static final WeatherMainConstant$MainScene NIGHT_CARE;
    public static final WeatherMainConstant$MainScene QUOTE;
    public static final WeatherMainConstant$MainScene RECOMMEND_BANNER;
    public static final WeatherMainConstant$MainScene TEXT;
    public static final WeatherMainConstant$MainScene TOP_VIDEO;

    private static final /* synthetic */ WeatherMainConstant$MainScene[] $values() {
        return new WeatherMainConstant$MainScene[]{TOP_VIDEO, HOUR, AD, DAY, QUOTE, ALMANAC, CONSTELLATION, NEWS, TEXT, RECOMMEND_BANNER, NIGHT_CARE};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43845);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        TOP_VIDEO = new WeatherMainConstant$MainScene("TOP_VIDEO", 0);
        HOUR = new WeatherMainConstant$MainScene("HOUR", 1);
        AD = new WeatherMainConstant$MainScene("AD", 2);
        DAY = new WeatherMainConstant$MainScene("DAY", 3);
        QUOTE = new WeatherMainConstant$MainScene("QUOTE", 4);
        ALMANAC = new WeatherMainConstant$MainScene("ALMANAC", 5);
        CONSTELLATION = new WeatherMainConstant$MainScene(b8.a.CONSTELLATION, 6);
        NEWS = new WeatherMainConstant$MainScene("NEWS", 7);
        TEXT = new WeatherMainConstant$MainScene("TEXT", 8);
        RECOMMEND_BANNER = new WeatherMainConstant$MainScene("RECOMMEND_BANNER", 9);
        NIGHT_CARE = new WeatherMainConstant$MainScene("NIGHT_CARE", 10);
        $VALUES = $values();
    }

    WeatherMainConstant$MainScene(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static WeatherMainConstant$MainScene valueOf(String str) {
        return (WeatherMainConstant$MainScene) Enum.valueOf(WeatherMainConstant$MainScene.class, str);
    }

    public static WeatherMainConstant$MainScene[] values() {
        return (WeatherMainConstant$MainScene[]) $VALUES.clone();
    }
}
