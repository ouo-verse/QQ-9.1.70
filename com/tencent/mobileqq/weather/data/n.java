package com.tencent.mobileqq.weather.data;

import com.tencent.jungle.weather.proto.weather$GetConcernWeatherReply;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.weather.util.WeatherMainConstant$MainScene;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0016J\u0014\u0010\u000b\u001a\u00020\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007R(\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/weather/data/n;", "Lcom/tencent/mobileqq/weather/data/k;", "Lcom/tencent/mobileqq/weather/util/WeatherMainConstant$MainScene;", "c", "bean", "", "d", "", "Lcom/tencent/mobileqq/weather/data/o;", "recommendBannerDataList", "", "f", "Ljava/util/List;", "e", "()Ljava/util/List;", "setRecommendBannerDataList", "(Ljava/util/List;)V", "Lcom/tencent/jungle/weather/proto/weather$GetConcernWeatherReply;", "reply", "", "pagePos", "<init>", "(Lcom/tencent/jungle/weather/proto/weather$GetConcernWeatherReply;I)V", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class n extends k {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<o> recommendBannerDataList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(@NotNull weather$GetConcernWeatherReply reply, int i3) {
        super(reply, i3);
        Intrinsics.checkNotNullParameter(reply, "reply");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) reply, i3);
        } else {
            this.recommendBannerDataList = new ArrayList();
        }
    }

    @Override // com.tencent.mobileqq.weather.data.k
    @NotNull
    public WeatherMainConstant$MainScene c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (WeatherMainConstant$MainScene) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return WeatherMainConstant$MainScene.RECOMMEND_BANNER;
    }

    @Override // com.tencent.mobileqq.weather.data.k
    public boolean d(@Nullable k bean) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) bean)).booleanValue();
        }
        if (!(bean instanceof n)) {
            return false;
        }
        return Intrinsics.areEqual(((n) bean).recommendBannerDataList, this.recommendBannerDataList);
    }

    @NotNull
    public final List<o> e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.recommendBannerDataList;
    }

    public final void f(@NotNull List<o> recommendBannerDataList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) recommendBannerDataList);
        } else {
            Intrinsics.checkNotNullParameter(recommendBannerDataList, "recommendBannerDataList");
            this.recommendBannerDataList = recommendBannerDataList;
        }
    }
}
