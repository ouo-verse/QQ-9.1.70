package com.tencent.mobileqq.weather.data;

import android.text.TextUtils;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.avbiz.Constants;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.jungle.weather.proto.MedicalArticle$MedicalArticleDate;
import com.tencent.jungle.weather.proto.WeatherReportStore$LifeIndexItem;
import com.tencent.jungle.weather.proto.WeatherReportStore$LifeIndexList;
import com.tencent.jungle.weather.proto.weather$GetConcernWeatherReply;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.weather.util.WeatherMainConstant$MainScene;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0014\u0018\u0000 $2\u00020\u0001:\u0001*B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010'\u001a\u00020\b\u00a2\u0006\u0004\b(\u0010)J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\fH\u0016J\u0012\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0016J\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u0013R&\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0015R\"\u0010\u001d\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010 \u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0018\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\"\u0010#\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u0018\u001a\u0004\b!\u0010\u001a\"\u0004\b\"\u0010\u001cR\"\u0010&\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0018\u001a\u0004\b$\u0010\u001a\"\u0004\b%\u0010\u001c\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/weather/data/b;", "Lcom/tencent/mobileqq/weather/data/k;", "Lcom/tencent/jungle/weather/proto/weather$GetConcernWeatherReply;", "reply", "", "j", "Lcom/tencent/jungle/weather/proto/WeatherReportStore$LifeIndexItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "adapterPos", "dataPos", "k", "Lcom/tencent/mobileqq/weather/util/WeatherMainConstant$MainScene;", "c", "bean", "", "d", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/weather/data/c;", "Lkotlin/collections/ArrayList;", "e", "Ljava/util/ArrayList;", "mData", "", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "setMDateTitle", "(Ljava/lang/String;)V", "mDateTitle", "f", "setMDateDes", "mDateDes", "i", "setMPosDes", "mPosDes", tl.h.F, "setMNegDes", "mNegDes", "pagePos", "<init>", "(Lcom/tencent/jungle/weather/proto/weather$GetConcernWeatherReply;I)V", "a", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class b extends k {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<c> mData;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mDateTitle;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mDateDes;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mPosDes;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mNegDes;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0004\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/weather/data/b$a;", "", "", "ALMANAC_DATE_KEY", "Ljava/lang/String;", "ALMANAC_DAY_SUB", "ALMANAC_ITEM_NAME_SUB", "ALMANAC_ITEM_UV_NAME", "ALMANAC_LUNAR_DAY_KEY", "ALMANAC_LUNAR_MONTH_KEY", "ALMANAC_MONTH_SUB", "ALMANAC_NEG_KEY", "ALMANAC_POS_KEY", "ALMANAC_YEAR_SUB", "TAG", "<init>", "()V", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.weather.data.b$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19955);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull weather$GetConcernWeatherReply reply, int i3) {
        super(reply, i3);
        ArrayList arrayListOf;
        ArrayList arrayListOf2;
        ArrayList arrayListOf3;
        ArrayList arrayListOf4;
        ArrayList arrayListOf5;
        ArrayList<c> arrayListOf6;
        Intrinsics.checkNotNullParameter(reply, "reply");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new d(i3, R.drawable.nij, "\u7a7f\u8863", "", "", false, ""));
            arrayListOf2 = CollectionsKt__CollectionsKt.arrayListOf(new d(i3, R.drawable.nij, "\u7a7f\u8863", "", "", false, ""), new d(i3, R.drawable.nit, "\u7d2b\u5916\u7ebf", "", "", false, ""));
            arrayListOf3 = CollectionsKt__CollectionsKt.arrayListOf(new d(i3, R.drawable.nik, "\u611f\u5192", "", "", false, ""), new d(i3, R.drawable.nih, "\u8fc7\u654f", "", "", false, ""));
            arrayListOf4 = CollectionsKt__CollectionsKt.arrayListOf(new d(i3, R.drawable.nil, "\u5316\u5986", "", "", false, ""), new d(i3, R.drawable.nis, "\u667e\u6652", "", "", false, ""));
            arrayListOf5 = CollectionsKt__CollectionsKt.arrayListOf(new d(i3, R.drawable.nir, Constants.Business.QQ_HEALTH, "", "", false, ""), new d(i3, R.drawable.nio, "\u6668\u7ec3", "", "", false, ""));
            arrayListOf6 = CollectionsKt__CollectionsKt.arrayListOf(new c(0, arrayListOf), new c(1, arrayListOf2), new c(1, arrayListOf3), new c(1, arrayListOf4), new c(1, arrayListOf5));
            this.mData = arrayListOf6;
            this.mDateTitle = "";
            this.mDateDes = "";
            this.mPosDes = "";
            this.mNegDes = "";
            j(reply);
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) reply, i3);
    }

    private final void j(weather$GetConcernWeatherReply reply) {
        String replace$default;
        String replace$default2;
        if (TextUtils.isEmpty(reply.almanac.get())) {
            QLog.e("WeatherConstellationBean", 1, "initData almanacReply is null");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(reply.almanac.get());
            this.mDateTitle = jSONObject.optString("lunarMonthName") + jSONObject.getString("lunarDayName");
            String date = jSONObject.optString("days");
            if (date.length() > 7) {
                Intrinsics.checkNotNullExpressionValue(date, "date");
                String substring = date.substring(0, 4);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                String substring2 = date.substring(4, 6);
                Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                String substring3 = date.substring(6);
                Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String).substring(startIndex)");
                this.mDateDes = substring + "\u5e74" + substring2 + "\u6708" + substring3 + "\u65e5";
            }
            String optString = jSONObject.optString(WidgetCacheLunarData.YI);
            Intrinsics.checkNotNullExpressionValue(optString, "almanacJson.optString(ALMANAC_POS_KEY)");
            replace$default = StringsKt__StringsJVMKt.replace$default(optString, ".", " ", false, 4, (Object) null);
            this.mPosDes = replace$default;
            String optString2 = jSONObject.optString(WidgetCacheLunarData.JI);
            Intrinsics.checkNotNullExpressionValue(optString2, "almanacJson.optString(ALMANAC_NEG_KEY)");
            replace$default2 = StringsKt__StringsJVMKt.replace$default(optString2, ".", " ", false, 4, (Object) null);
            this.mNegDes = replace$default2;
            d dVar = this.mData.get(0).a().get(0);
            Intrinsics.checkNotNullExpressionValue(dVar, "mData[0].data[0]");
            d dVar2 = dVar;
            MedicalArticle$MedicalArticleDate medicalArticle$MedicalArticleDate = reply.medicalArticle.get();
            String str = medicalArticle$MedicalArticleDate.title.get();
            Intrinsics.checkNotNullExpressionValue(str, "medicalArticle.title.get()");
            dVar2.k(str);
            dVar2.h(medicalArticle$MedicalArticleDate.author.get() + " " + medicalArticle$MedicalArticleDate.author_title.get());
            String str2 = medicalArticle$MedicalArticleDate.link.get();
            Intrinsics.checkNotNullExpressionValue(str2, "medicalArticle.link.get()");
            dVar2.l(str2);
            this.mData.get(0).a().set(0, dVar2);
            WeatherReportStore$LifeIndexList weatherReportStore$LifeIndexList = reply.weather.lifeindex_list.get();
            WeatherReportStore$LifeIndexItem weatherReportStore$LifeIndexItem = weatherReportStore$LifeIndexList.clothing.get();
            Intrinsics.checkNotNullExpressionValue(weatherReportStore$LifeIndexItem, "lifeIndexList.clothing.get()");
            k(weatherReportStore$LifeIndexItem, 1, 0);
            WeatherReportStore$LifeIndexItem weatherReportStore$LifeIndexItem2 = weatherReportStore$LifeIndexList.common_cold.get();
            Intrinsics.checkNotNullExpressionValue(weatherReportStore$LifeIndexItem2, "lifeIndexList.common_cold.get()");
            k(weatherReportStore$LifeIndexItem2, 2, 0);
            WeatherReportStore$LifeIndexItem weatherReportStore$LifeIndexItem3 = weatherReportStore$LifeIndexList.makeup.get();
            Intrinsics.checkNotNullExpressionValue(weatherReportStore$LifeIndexItem3, "lifeIndexList.makeup.get()");
            k(weatherReportStore$LifeIndexItem3, 3, 0);
            WeatherReportStore$LifeIndexItem weatherReportStore$LifeIndexItem4 = weatherReportStore$LifeIndexList.sport.get();
            Intrinsics.checkNotNullExpressionValue(weatherReportStore$LifeIndexItem4, "lifeIndexList.sport.get()");
            k(weatherReportStore$LifeIndexItem4, 4, 0);
            WeatherReportStore$LifeIndexItem weatherReportStore$LifeIndexItem5 = weatherReportStore$LifeIndexList.uv_light.get();
            Intrinsics.checkNotNullExpressionValue(weatherReportStore$LifeIndexItem5, "lifeIndexList.uv_light.get()");
            k(weatherReportStore$LifeIndexItem5, 1, 1);
            WeatherReportStore$LifeIndexItem weatherReportStore$LifeIndexItem6 = weatherReportStore$LifeIndexList.allergy.get();
            Intrinsics.checkNotNullExpressionValue(weatherReportStore$LifeIndexItem6, "lifeIndexList.allergy.get()");
            k(weatherReportStore$LifeIndexItem6, 2, 1);
            WeatherReportStore$LifeIndexItem weatherReportStore$LifeIndexItem7 = weatherReportStore$LifeIndexList.sundry_cloth.get();
            Intrinsics.checkNotNullExpressionValue(weatherReportStore$LifeIndexItem7, "lifeIndexList.sundry_cloth.get()");
            k(weatherReportStore$LifeIndexItem7, 3, 1);
            WeatherReportStore$LifeIndexItem weatherReportStore$LifeIndexItem8 = weatherReportStore$LifeIndexList.morning_workout.get();
            Intrinsics.checkNotNullExpressionValue(weatherReportStore$LifeIndexItem8, "lifeIndexList.morning_workout.get()");
            k(weatherReportStore$LifeIndexItem8, 4, 1);
        } catch (Exception e16) {
            QLog.e("WeatherConstellationBean", 1, "initData almanacJson error:", e16);
        }
    }

    private final void k(WeatherReportStore$LifeIndexItem item, int adapterPos, int dataPos) {
        String replace$default;
        d dVar = this.mData.get(adapterPos).a().get(dataPos);
        Intrinsics.checkNotNullExpressionValue(dVar, "mData[adapterPos].data[dataPos]");
        d dVar2 = dVar;
        boolean z16 = true;
        if (adapterPos == 1 && dataPos == 1) {
            dVar2.j("\u7d2b\u5916\u7ebf");
        } else {
            String str = item.name.get();
            Intrinsics.checkNotNullExpressionValue(str, "item.name.get()");
            replace$default = StringsKt__StringsJVMKt.replace$default(str, "\u6307\u6570", "", false, 4, (Object) null);
            dVar2.j(replace$default);
        }
        String str2 = item.tips.get();
        Intrinsics.checkNotNullExpressionValue(str2, "item.tips.get()");
        dVar2.h(str2);
        String str3 = item.summary.get();
        Intrinsics.checkNotNullExpressionValue(str3, "item.summary.get()");
        dVar2.k(str3);
        if (item.highlight.get() != 1) {
            z16 = false;
        }
        dVar2.i(z16);
        String str4 = item.link.get();
        Intrinsics.checkNotNullExpressionValue(str4, "item.link.get()");
        dVar2.l(str4);
        this.mData.get(adapterPos).a().set(dataPos, dVar2);
    }

    @Override // com.tencent.mobileqq.weather.data.k
    @NotNull
    public WeatherMainConstant$MainScene c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (WeatherMainConstant$MainScene) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return WeatherMainConstant$MainScene.ALMANAC;
    }

    @Override // com.tencent.mobileqq.weather.data.k
    public boolean d(@Nullable k bean) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) bean)).booleanValue();
        }
        if (!(bean instanceof b)) {
            return false;
        }
        return Intrinsics.areEqual(((b) bean).mData, this.mData);
    }

    @NotNull
    public final ArrayList<c> e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (ArrayList) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.mData;
    }

    @NotNull
    public final String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mDateDes;
    }

    @NotNull
    public final String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mDateTitle;
    }

    @NotNull
    public final String h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.mNegDes;
    }

    @NotNull
    public final String i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mPosDes;
    }
}
