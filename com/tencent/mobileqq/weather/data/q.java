package com.tencent.mobileqq.weather.data;

import com.tencent.jungle.weather.proto.WeatherInfo$LifeIndex;
import com.tencent.jungle.weather.proto.WeatherInfo$NightCare;
import com.tencent.jungle.weather.proto.weather$GetConcernWeatherReply;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.weather.util.WeatherMainConstant$MainScene;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \n2\u00020\u0001:\u0001\u0013B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u0016J\u0006\u0010\f\u001a\u00020\u000bR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\r\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/weather/data/q;", "Lcom/tencent/mobileqq/weather/data/k;", "Lcom/tencent/jungle/weather/proto/weather$GetConcernWeatherReply;", "reply", "", "f", "Lcom/tencent/mobileqq/weather/util/WeatherMainConstant$MainScene;", "c", "bean", "", "d", "Lcom/tencent/mobileqq/weather/data/r;", "e", "Lcom/tencent/mobileqq/weather/data/r;", "mData", "", "pagePos", "<init>", "(Lcom/tencent/jungle/weather/proto/weather$GetConcernWeatherReply;I)V", "a", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class q extends k {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private r mData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/weather/data/q$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.weather.data.q$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(IjkMediaPlayer.FFP_PROP_INT64_ASYNC_STATISTIC_BUF_CAPACITY);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(@NotNull weather$GetConcernWeatherReply reply, int i3) {
        super(reply, i3);
        Intrinsics.checkNotNullParameter(reply, "reply");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) reply, i3);
        } else {
            this.mData = new r(null, null, null, null, 15, null);
            f(reply);
        }
    }

    private final void f(weather$GetConcernWeatherReply reply) {
        if (a() != 0) {
            return;
        }
        WeatherInfo$NightCare weatherInfo$NightCare = reply.weather.night_care.get();
        r rVar = this.mData;
        String str = weatherInfo$NightCare.background.get();
        Intrinsics.checkNotNullExpressionValue(str, "tomorrowCare.background.get()");
        rVar.e(str);
        r rVar2 = this.mData;
        String str2 = weatherInfo$NightCare.prompt.get();
        Intrinsics.checkNotNullExpressionValue(str2, "tomorrowCare.prompt.get()");
        rVar2.g(str2);
        this.mData.f(com.tencent.mobileqq.weather.util.g.f313646a.x());
        List<WeatherInfo$LifeIndex> list = weatherInfo$NightCare.tomorrowLifeIndexs.get();
        this.mData.c().clear();
        for (WeatherInfo$LifeIndex weatherInfo$LifeIndex : list) {
            ArrayList<s> c16 = this.mData.c();
            String str3 = weatherInfo$LifeIndex.icon.get();
            Intrinsics.checkNotNullExpressionValue(str3, "item.icon.get()");
            String str4 = weatherInfo$LifeIndex.content.get();
            Intrinsics.checkNotNullExpressionValue(str4, "item.content.get()");
            String str5 = weatherInfo$LifeIndex.name.get();
            Intrinsics.checkNotNullExpressionValue(str5, "item.name.get()");
            c16.add(new s(str3, str4, str5));
        }
    }

    @Override // com.tencent.mobileqq.weather.data.k
    @NotNull
    public WeatherMainConstant$MainScene c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (WeatherMainConstant$MainScene) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return WeatherMainConstant$MainScene.NIGHT_CARE;
    }

    @Override // com.tencent.mobileqq.weather.data.k
    public boolean d(@Nullable k bean) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) bean)).booleanValue();
        }
        if (!(bean instanceof q) || this.mData != ((q) bean).mData) {
            return false;
        }
        return true;
    }

    @NotNull
    public final r e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (r) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mData;
    }
}
