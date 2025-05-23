package com.tencent.mobileqq.weather.data;

import android.annotation.SuppressLint;
import com.tencent.jungle.weather.proto.Festival$FestivalDate;
import com.tencent.jungle.weather.proto.WeatherReportStore$WeatherForecast;
import com.tencent.jungle.weather.proto.WeatherReportStore$WeatherForecastList;
import com.tencent.jungle.weather.proto.weather$GetConcernWeatherReply;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.weather.util.WeatherMainConstant$MainScene;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 \u000f2\u00020\u0001:\u0001&B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010#\u001a\u00020\u0006\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0003J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0012\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0016J\u0016\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0017`\u0018J\u0006\u0010\u001a\u001a\u00020\nJ\u0006\u0010\u001b\u001a\u00020\nR\u0016\u0010\u001d\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u001cR&\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0017`\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u001eR\u0016\u0010!\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010 R\u0016\u0010\"\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010 \u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/weather/data/g;", "Lcom/tencent/mobileqq/weather/data/k;", "Lcom/tencent/jungle/weather/proto/weather$GetConcernWeatherReply;", "reply", "", "l", "", "day", "", "time", "", "e", "f", "Ljava/util/Date;", "date", "g", "i", "Lcom/tencent/mobileqq/weather/util/WeatherMainConstant$MainScene;", "c", "bean", "", "d", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/weather/data/h;", "Lkotlin/collections/ArrayList;", tl.h.F, "j", "k", "J", "mCurrentTimeMs", "Ljava/util/ArrayList;", "mData", "Ljava/lang/String;", "mTitle", "mTitleDes", "pagePos", "<init>", "(Lcom/tencent/jungle/weather/proto/weather$GetConcernWeatherReply;I)V", "a", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class g extends k {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long mCurrentTimeMs;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<h> mData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mTitle;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mTitleDes;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/weather/data/g$a;", "", "", "DEGREE", "Ljava/lang/String;", "DES_NORMAL_TEXT", "DES_WEBPAGE_TEXT", "TAG", "<init>", "()V", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.weather.data.g$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20069);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(@NotNull weather$GetConcernWeatherReply reply, int i3) {
        super(reply, i3);
        Intrinsics.checkNotNullParameter(reply, "reply");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) reply, i3);
            return;
        }
        this.mData = new ArrayList<>();
        this.mTitle = "7\u5929\u9884\u62a5";
        this.mTitleDes = "\u66f4\u591a";
        l(reply);
    }

    private final String e(int day, long time) {
        if (day != 0) {
            if (day != 1) {
                return g(new Date(time));
            }
            return "\u4eca\u5929";
        }
        return "\u6628\u5929";
    }

    @SuppressLint({"SimpleDateFormat"})
    private final String f(long time) {
        String format = new SimpleDateFormat("MM/dd").format(new Date(time));
        Intrinsics.checkNotNullExpressionValue(format, "formatter.format(Date(time))");
        return format;
    }

    private final String g(Date date) {
        Calendar.getInstance().setTime(date);
        return new String[]{"\u5468\u65e5", "\u5468\u4e00", "\u5468\u4e8c", "\u5468\u4e09", "\u5468\u56db", "\u5468\u4e94", "\u5468\u516d"}[r0.get(7) - 1];
    }

    private final long i(int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(this.mCurrentTimeMs);
        calendar.set(5, (calendar.get(5) + day) - 1);
        return calendar.getTimeInMillis();
    }

    private final void l(weather$GetConcernWeatherReply reply) {
        boolean z16;
        String str;
        this.mCurrentTimeMs = System.currentTimeMillis();
        WeatherReportStore$WeatherForecastList weatherReportStore$WeatherForecastList = reply.weather.forecast_list.get();
        Intrinsics.checkNotNullExpressionValue(weatherReportStore$WeatherForecastList, "reply.weather.forecast_list.get()");
        WeatherReportStore$WeatherForecastList weatherReportStore$WeatherForecastList2 = weatherReportStore$WeatherForecastList;
        String dayForecastTitle = weatherReportStore$WeatherForecastList2.weeklyPrompt.get();
        Intrinsics.checkNotNullExpressionValue(dayForecastTitle, "dayForecastTitle");
        if (dayForecastTitle.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.mTitle = dayForecastTitle;
        }
        if (reply.config.jumpWeatherWebStyle.get() == 2) {
            str = "\u53bb\u5929\u6c14\u7f51";
        } else {
            str = "\u66f4\u591a";
        }
        this.mTitleDes = str;
        ArrayList<h> arrayList = new ArrayList<>();
        List<WeatherReportStore$WeatherForecast> forecastDataList = weatherReportStore$WeatherForecastList2.weatherForecast.get();
        HashMap hashMap = new HashMap();
        List<Festival$FestivalDate> list = reply.festivals.get();
        if (list != null) {
            Intrinsics.checkNotNullExpressionValue(list, "get()");
            for (Festival$FestivalDate festival$FestivalDate : list) {
                hashMap.put(f(festival$FestivalDate.date.get() * 1000), festival$FestivalDate.icon.get());
            }
        }
        Intrinsics.checkNotNullExpressionValue(forecastDataList, "forecastDataList");
        for (WeatherReportStore$WeatherForecast weatherReportStore$WeatherForecast : forecastDataList) {
            long i3 = i(weatherReportStore$WeatherForecast.day.get());
            String f16 = f(i3);
            String e16 = e(weatherReportStore$WeatherForecast.day.get(), i3);
            String p16 = com.tencent.mobileqq.weather.util.g.f313646a.p(weatherReportStore$WeatherForecast.day_type_id_new.get());
            String str2 = (String) hashMap.get(f16);
            if (str2 == null) {
                str2 = "";
            }
            String str3 = str2;
            Intrinsics.checkNotNullExpressionValue(str3, "dateFestivalMap[date] ?: \"\"");
            String str4 = weatherReportStore$WeatherForecast.day_weather.get();
            Intrinsics.checkNotNullExpressionValue(str4, "forecast.day_weather.get()");
            arrayList.add(new h(e16, f16, p16, str3, str4, weatherReportStore$WeatherForecast.day_temper.get() + "\u00b0", weatherReportStore$WeatherForecast.night_temper.get() + "\u00b0"));
        }
        this.mData = arrayList;
    }

    @Override // com.tencent.mobileqq.weather.data.k
    @NotNull
    public WeatherMainConstant$MainScene c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (WeatherMainConstant$MainScene) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return WeatherMainConstant$MainScene.DAY;
    }

    @Override // com.tencent.mobileqq.weather.data.k
    public boolean d(@Nullable k bean) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) bean)).booleanValue();
        }
        if (!(bean instanceof g) || this.mData != ((g) bean).mData) {
            return false;
        }
        return true;
    }

    @NotNull
    public final ArrayList<h> h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mData;
    }

    @NotNull
    public final String j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mTitle;
    }

    @NotNull
    public final String k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mTitleDes;
    }
}
