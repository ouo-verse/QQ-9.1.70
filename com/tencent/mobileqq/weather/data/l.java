package com.tencent.mobileqq.weather.data;

import com.tencent.jungle.weather.proto.DayCard$DailyCard;
import com.tencent.jungle.weather.proto.weather$GetConcernWeatherReply;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.weather.util.WeatherMainConstant$MainScene;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u0016J\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rR&\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/weather/data/l;", "Lcom/tencent/mobileqq/weather/data/k;", "Lcom/tencent/jungle/weather/proto/weather$GetConcernWeatherReply;", "reply", "", "f", "Lcom/tencent/mobileqq/weather/util/WeatherMainConstant$MainScene;", "c", "bean", "", "d", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/weather/data/m;", "Lkotlin/collections/ArrayList;", "e", "Ljava/util/ArrayList;", "weatherQuoteData", "", "pagePos", "<init>", "(Lcom/tencent/jungle/weather/proto/weather$GetConcernWeatherReply;I)V", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class l extends k {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<m> weatherQuoteData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(@NotNull weather$GetConcernWeatherReply reply, int i3) {
        super(reply, i3);
        ArrayList<m> arrayListOf;
        Intrinsics.checkNotNullParameter(reply, "reply");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new m(0L, "", "", "", 190L, false, ""));
            this.weatherQuoteData = arrayListOf;
            f(reply);
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) reply, i3);
    }

    private final void f(weather$GetConcernWeatherReply reply) {
        this.weatherQuoteData.clear();
        for (DayCard$DailyCard dayCard$DailyCard : reply.dailyCards.content.get()) {
            ArrayList<m> arrayList = this.weatherQuoteData;
            long j3 = dayCard$DailyCard.f116935id.get();
            String str = dayCard$DailyCard.tag.get();
            Intrinsics.checkNotNullExpressionValue(str, "item.tag.get()");
            String str2 = dayCard$DailyCard.content.get();
            Intrinsics.checkNotNullExpressionValue(str2, "item.content.get()");
            String str3 = dayCard$DailyCard.reference.get();
            Intrinsics.checkNotNullExpressionValue(str3, "item.reference.get()");
            long j16 = dayCard$DailyCard.likeNum.get();
            boolean z16 = dayCard$DailyCard.hasLike.get();
            String str4 = dayCard$DailyCard.jumpSchema.get();
            Intrinsics.checkNotNullExpressionValue(str4, "item.jumpSchema.get()");
            arrayList.add(new m(j3, str, str2, str3, j16, z16, str4));
        }
    }

    @Override // com.tencent.mobileqq.weather.data.k
    @NotNull
    public WeatherMainConstant$MainScene c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (WeatherMainConstant$MainScene) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return WeatherMainConstant$MainScene.QUOTE;
    }

    @Override // com.tencent.mobileqq.weather.data.k
    public boolean d(@Nullable k bean) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) bean)).booleanValue();
        }
        if (!(bean instanceof l)) {
            return false;
        }
        return Intrinsics.areEqual(((l) bean).e(), this.weatherQuoteData);
    }

    @NotNull
    public final ArrayList<m> e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.weatherQuoteData;
    }
}
