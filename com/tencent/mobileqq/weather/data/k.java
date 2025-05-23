package com.tencent.mobileqq.weather.data;

import com.tencent.jungle.weather.proto.weather$GetConcernWeatherReply;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.weather.util.WeatherMainConstant$MainScene;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\r\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0000H&R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000e\u001a\u0004\b\b\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/weather/data/k;", "", "Lcom/tencent/mobileqq/weather/util/WeatherMainConstant$MainScene;", "c", "bean", "", "d", "Lcom/tencent/jungle/weather/proto/weather$GetConcernWeatherReply;", "a", "Lcom/tencent/jungle/weather/proto/weather$GetConcernWeatherReply;", "b", "()Lcom/tencent/jungle/weather/proto/weather$GetConcernWeatherReply;", "reply", "", "I", "()I", "pagePos", "<init>", "(Lcom/tencent/jungle/weather/proto/weather$GetConcernWeatherReply;I)V", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public abstract class k {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final weather$GetConcernWeatherReply reply;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int pagePos;

    public k(@NotNull weather$GetConcernWeatherReply reply, int i3) {
        Intrinsics.checkNotNullParameter(reply, "reply");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) reply, i3);
        } else {
            this.reply = reply;
            this.pagePos = i3;
        }
    }

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.pagePos;
    }

    @NotNull
    public final weather$GetConcernWeatherReply b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (weather$GetConcernWeatherReply) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.reply;
    }

    @NotNull
    public abstract WeatherMainConstant$MainScene c();

    public abstract boolean d(@Nullable k bean);
}
