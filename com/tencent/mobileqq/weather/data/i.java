package com.tencent.mobileqq.weather.data;

import com.tencent.jungle.weather.proto.WeatherReportStore$WeatherForecast;
import com.tencent.jungle.weather.proto.WeatherReportStore$WeatherForecastList;
import com.tencent.jungle.weather.proto.WeatherReportStore$WeatherHourInfo;
import com.tencent.jungle.weather.proto.weather$GetConcernWeatherReply;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.weather.util.WeatherMainConstant$MainScene;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 \n2\u00020\u0001:\u0001/B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010,\u001a\u00020\u0011\u00a2\u0006\u0004\b-\u0010.J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0002J0\u0010\u0014\u001a\u00020\u00042\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000eH\u0002J \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u000eH\u0002J(\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u0015H\u0002J\b\u0010!\u001a\u00020 H\u0016J\u0012\u0010#\u001a\u00020\u00192\b\u0010\"\u001a\u0004\u0018\u00010\u0001H\u0016J\u0016\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fJ\u0006\u0010%\u001a\u00020\bJ\u0006\u0010&\u001a\u00020\bR&\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010'R\u0016\u0010*\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010)R\u0016\u0010+\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010)\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/weather/data/i;", "Lcom/tencent/mobileqq/weather/data/k;", "Lcom/tencent/jungle/weather/proto/weather$GetConcernWeatherReply;", "reply", "", "k", "Lcom/tencent/jungle/weather/proto/WeatherReportStore$WeatherForecast;", "weatherForecast", "", "j", "f", "hourString", "g", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/weather/data/j;", "Lkotlin/collections/ArrayList;", "list", "", com.tencent.luggage.wxa.c8.c.G, "data", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "time", "bfItem", "afItem", "", "l", "todaySunRiseTimeStamp", "todaySunsetTimeStamp", "tomorrowSunRiseTimeStamp", "tomorrowSunsetTimeStamp", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/weather/util/WeatherMainConstant$MainScene;", "c", "bean", "d", "e", tl.h.F, "i", "Ljava/util/ArrayList;", "mData", "Ljava/lang/String;", "mTitle", "mTitleDes", "pagePos", "<init>", "(Lcom/tencent/jungle/weather/proto/weather$GetConcernWeatherReply;I)V", "a", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class i extends k {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<j> mData;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mTitle;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mTitleDes;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0007R\u0014\u0010\f\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0007R\u0014\u0010\r\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0007R\u0014\u0010\u000e\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0007R\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0014\u0010\u0010\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0007R\u0014\u0010\u0011\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0007R\u0014\u0010\u0012\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0007R\u0014\u0010\u0013\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0007R\u0014\u0010\u0014\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0007R\u0014\u0010\u0015\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0007\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/weather/data/i$a;", "", "", "CLOUD_TYPE", "I", "", "DAY_TEXT", "Ljava/lang/String;", "DES_NORMAL_TEXT", "DES_WEBPAGE_TEXT", "FORECAST_SIZE", "MARK_1", "MARK_2", "MARK_4", "MIDDLE_TEXT", "SUNNY_TYPE", "SUNRISE_IMG", "SUNRISE_TEXT", "SUNSET_IMG", "SUNSET_TEXT", "TAG", "TEMPERATURE_TEXT", "<init>", "()V", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.weather.data.i$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20085);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(@NotNull weather$GetConcernWeatherReply reply, int i3) {
        super(reply, i3);
        Intrinsics.checkNotNullParameter(reply, "reply");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) reply, i3);
            return;
        }
        this.mData = new ArrayList<>();
        this.mTitle = "\u52a0\u8f7d\u4e2d";
        this.mTitleDes = "\u66f4\u591a";
        k(reply);
    }

    private final String f(WeatherReportStore$WeatherForecast weatherForecast) {
        String str = weatherForecast.day_temper.get();
        String str2 = weatherForecast.night_temper.get();
        if (str.equals(str2)) {
            return "\u6c14\u6e29" + str + "\u00b0";
        }
        return "\u6c14\u6e29" + str + "\u00b0/" + str2 + "\u00b0";
    }

    private final String g(String hourString) {
        String substring = hourString.substring(8, 10);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        String substring2 = hourString.substring(10, 12);
        Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        String str = substring + ":" + substring2;
        if (Intrinsics.areEqual(str, QzoneConfig.ALBUM_RECOM_EVENT_ALGO_USER_SAMPLE_DEFAULT)) {
            String substring3 = hourString.substring(6, 8);
            Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            return substring3 + "\u65e50\u65f6";
        }
        return str;
    }

    private final String j(WeatherReportStore$WeatherForecast weatherForecast) {
        String str = weatherForecast.day_weather.get();
        String str2 = weatherForecast.night_weather.get();
        if (str.equals(str2)) {
            return "\u4eca\u65e5" + str + "\uff0c";
        }
        return "\u4eca\u65e5" + str + "\u8f6c" + str2 + "\uff0c";
    }

    private final void k(weather$GetConcernWeatherReply reply) {
        boolean z16;
        boolean z17;
        String str;
        boolean z18;
        String str2;
        String str3;
        long j3;
        long j16;
        String str4;
        String str5;
        String str6;
        String str7;
        int i3;
        long j17;
        long j18;
        long j19;
        WeatherReportStore$WeatherForecastList weatherReportStore$WeatherForecastList = reply.weather.forecast_list.get();
        Intrinsics.checkNotNullExpressionValue(weatherReportStore$WeatherForecastList, "reply.weather.forecast_list.get()");
        WeatherReportStore$WeatherForecastList weatherReportStore$WeatherForecastList2 = weatherReportStore$WeatherForecastList;
        String hourForecastTitle = weatherReportStore$WeatherForecastList2.tomorrowPrompt.get();
        List<WeatherReportStore$WeatherForecast> list = weatherReportStore$WeatherForecastList2.weatherForecast.get();
        if (hourForecastTitle != null && hourForecastTitle.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16 && list.size() > 1) {
            WeatherReportStore$WeatherForecast weatherForecast = list.get(1);
            Intrinsics.checkNotNullExpressionValue(weatherForecast, "weatherForecast");
            hourForecastTitle = j(weatherForecast) + f(weatherForecast);
        }
        Intrinsics.checkNotNullExpressionValue(hourForecastTitle, "hourForecastTitle");
        if (hourForecastTitle.length() > 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            Intrinsics.checkNotNullExpressionValue(hourForecastTitle, "hourForecastTitle");
            this.mTitle = hourForecastTitle;
        }
        if (reply.config.jumpWeatherWebStyle.get() == 2) {
            str = "\u53bb\u5929\u6c14\u7f51";
        } else {
            str = "\u66f4\u591a";
        }
        this.mTitleDes = str;
        ArrayList<j> arrayList = new ArrayList<>();
        String n3 = com.tencent.mobileqq.weather.util.g.f313646a.n();
        List<WeatherReportStore$WeatherHourInfo> list2 = reply.weather.hourinfo_list.weatherHourInfo.get();
        Iterator<WeatherReportStore$WeatherHourInfo> it = list2.iterator();
        List<WeatherReportStore$WeatherHourInfo> list3 = null;
        int i16 = 0;
        while (it.hasNext()) {
            int i17 = i16 + 1;
            if (Intrinsics.areEqual(it.next().d_hour.get(), n3)) {
                List<WeatherReportStore$WeatherHourInfo> list4 = reply.weather.hourinfo_list.weatherHourInfo.get();
                int i18 = i16 + 27;
                if (list2.size() <= i18) {
                    i18 = list2.size() - 1;
                }
                list3 = list4.subList(i16, i18);
            }
            i16 = i17;
        }
        if (list3 != null) {
            for (WeatherReportStore$WeatherHourInfo weatherReportStore$WeatherHourInfo : list3) {
                int i19 = weatherReportStore$WeatherHourInfo.concrete_type.get();
                String str8 = weatherReportStore$WeatherHourInfo.temper.get() + "\u00b0";
                com.tencent.mobileqq.weather.util.g gVar = com.tencent.mobileqq.weather.util.g.f313646a;
                String p16 = gVar.p(i19);
                String str9 = weatherReportStore$WeatherHourInfo.d_hour.get();
                Intrinsics.checkNotNullExpressionValue(str9, "item.d_hour.get()");
                String g16 = g(str9);
                String str10 = weatherReportStore$WeatherHourInfo.d_hour.get();
                Intrinsics.checkNotNullExpressionValue(str10, "item.d_hour.get()");
                long u16 = gVar.u(str10);
                String str11 = weatherReportStore$WeatherHourInfo.weather.get();
                Intrinsics.checkNotNullExpressionValue(str11, "item.weather.get()");
                arrayList.add(new j(str8, p16, g16, u16, i19, str11));
            }
        }
        String todaySunRiseTime = reply.weather.weather_info.sunrise.get();
        com.tencent.mobileqq.weather.util.g gVar2 = com.tencent.mobileqq.weather.util.g.f313646a;
        Intrinsics.checkNotNullExpressionValue(todaySunRiseTime, "todaySunRiseTime");
        long r16 = gVar2.r(todaySunRiseTime, 0);
        String todaySunSetTime = reply.weather.weather_info.sunset.get();
        Intrinsics.checkNotNullExpressionValue(todaySunSetTime, "todaySunSetTime");
        long s16 = gVar2.s(todaySunSetTime, 0);
        if (weatherReportStore$WeatherForecastList2.weatherForecast.size() > 3) {
            WeatherReportStore$WeatherForecast weatherReportStore$WeatherForecast = weatherReportStore$WeatherForecastList2.weatherForecast.get(2);
            str2 = weatherReportStore$WeatherForecast.sunrise_time.get();
            Intrinsics.checkNotNullExpressionValue(str2, "nextDayForecast.sunrise_time.get()");
            z18 = true;
            long r17 = gVar2.r(str2, 1);
            str3 = weatherReportStore$WeatherForecast.sunset_time.get();
            Intrinsics.checkNotNullExpressionValue(str3, "nextDayForecast.sunset_time.get()");
            j16 = r17;
            j3 = gVar2.s(str3, 1);
        } else {
            z18 = true;
            str2 = "";
            str3 = "";
            j3 = 0;
            j16 = 0;
        }
        if (arrayList.isEmpty() ^ z18) {
            this.mData = arrayList;
            Iterator<j> it5 = arrayList.iterator();
            int i26 = 0;
            while (it5.hasNext()) {
                int i27 = i26 + 1;
                j next = it5.next();
                Iterator<j> it6 = it5;
                if (i26 == arrayList.size() - 1) {
                    break;
                }
                j jVar = arrayList.get(i27);
                Intrinsics.checkNotNullExpressionValue(jVar, "list[count + 1]");
                if (l(r16, next, jVar)) {
                    str5 = str3;
                    str6 = str2;
                    str7 = "list[count + 1]";
                    str4 = todaySunSetTime;
                    i3 = i27;
                    j17 = j16;
                    j18 = s16;
                    m(this.mData, i3, new j("\u65e5\u51fa", "https://qq-weather.cdn-go.cn/hippy-weather/latest/sunrise.png", todaySunRiseTime, r16, -1, ""));
                } else {
                    str4 = todaySunSetTime;
                    str5 = str3;
                    str6 = str2;
                    str7 = "list[count + 1]";
                    i3 = i27;
                    j17 = j16;
                    j18 = s16;
                }
                j jVar2 = arrayList.get(i3);
                Intrinsics.checkNotNullExpressionValue(jVar2, str7);
                long j26 = j18;
                if (l(j26, next, jVar2)) {
                    j19 = j26;
                    m(this.mData, i3, new j("\u65e5\u843d", "https://qq-weather.cdn-go.cn/hippy-weather/latest/sunset.png", str4, j26, -1, ""));
                } else {
                    j19 = j26;
                }
                j jVar3 = arrayList.get(i3);
                Intrinsics.checkNotNullExpressionValue(jVar3, str7);
                long j27 = j17;
                if (l(j27, next, jVar3)) {
                    m(this.mData, i3, new j("\u65e5\u51fa", "https://qq-weather.cdn-go.cn/hippy-weather/latest/sunrise.png", str6, j27, -1, ""));
                }
                j jVar4 = arrayList.get(i3);
                Intrinsics.checkNotNullExpressionValue(jVar4, str7);
                long j28 = j3;
                if (l(j28, next, jVar4)) {
                    m(this.mData, i3, new j("\u65e5\u843d", "https://qq-weather.cdn-go.cn/hippy-weather/latest/sunset.png", str5, j28, -1, ""));
                }
                it5 = it6;
                i26 = i3;
                j3 = j28;
                str3 = str5;
                str2 = str6;
                todaySunSetTime = str4;
                s16 = j19;
                j16 = j27;
            }
            this.mData.remove(0);
            n(r16, s16, j16, j3);
        }
    }

    private final boolean l(long time, j bfItem, j afItem) {
        if (time > bfItem.a() && time < afItem.a()) {
            return true;
        }
        return false;
    }

    private final void m(ArrayList<j> list, int pos, j data) {
        if (!list.isEmpty() && pos <= list.size()) {
            int size = list.size() - 1;
            int i3 = pos + 1;
            if (i3 <= size) {
                while (true) {
                    list.set(size, list.get(size - 1));
                    if (size == i3) {
                        break;
                    } else {
                        size--;
                    }
                }
            }
            list.set(pos, data);
        }
    }

    private final void n(long todaySunRiseTimeStamp, long todaySunsetTimeStamp, long tomorrowSunRiseTimeStamp, long tomorrowSunsetTimeStamp) {
        boolean z16;
        String replace$default;
        Iterator<j> it = this.mData.iterator();
        while (it.hasNext()) {
            j next = it.next();
            if (!Intrinsics.areEqual(next.c(), "\u65e5\u51fa") && !Intrinsics.areEqual(next.c(), "\u65e5\u843d")) {
                boolean z17 = true;
                if (next.f() == 1 || next.f() == 2) {
                    long a16 = next.a();
                    if (todaySunRiseTimeStamp <= a16 && a16 < todaySunsetTimeStamp) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16) {
                        long a17 = next.a();
                        if (tomorrowSunRiseTimeStamp > a17 || a17 >= tomorrowSunsetTimeStamp) {
                            z17 = false;
                        }
                        if (!z17) {
                            replace$default = StringsKt__StringsJVMKt.replace$default(next.b(), ".png", "-night.png", false, 4, (Object) null);
                            next.g(replace$default);
                        }
                    }
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.weather.data.k
    @NotNull
    public WeatherMainConstant$MainScene c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (WeatherMainConstant$MainScene) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return WeatherMainConstant$MainScene.HOUR;
    }

    @Override // com.tencent.mobileqq.weather.data.k
    public boolean d(@Nullable k bean) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) bean)).booleanValue();
        }
        if (!(bean instanceof i) || this.mData != ((i) bean).mData) {
            return false;
        }
        return true;
    }

    @NotNull
    public final ArrayList<j> e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mData;
    }

    @NotNull
    public final String h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mTitle;
    }

    @NotNull
    public final String i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mTitleDes;
    }
}
