package com.tencent.mobileqq.weather.mvvm;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.adv.preload.api.IVasMaskAdvPreloadApi;
import com.tencent.mobileqq.weather.mvvm.a;
import com.tencent.mobileqq.weather.mvvm.c;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.access;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0016\u0018\u0000 %2\u00020\u0001:\u0001&B\u0007\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J0\u0010\u0011\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0006\u0010\u0012\u001a\u00020\tR.\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R*\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R.\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u0015\u001a\u0004\b \u0010\u0017\"\u0004\b!\u0010\u0019\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/weather/mvvm/c;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "getLogTag", "", "needRequestMask", "isRefresh", "", "pagePos", "", "P1", "", "Lcom/tencent/gdtad/aditem/GdtAd;", "gdtAds", "adPosId", "Ltencent/gdt/access$UserActionReportInfo;", "userActionReportInfo", "O1", QCircleLpReportDc05507.KEY_CLEAR, "Landroidx/lifecycle/MutableLiveData;", "i", "Landroidx/lifecycle/MutableLiveData;", "M1", "()Landroidx/lifecycle/MutableLiveData;", "setMFirstScreenAdData", "(Landroidx/lifecycle/MutableLiveData;)V", "mFirstScreenAdData", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "N1", "setMUserActionReportInfo", "mUserActionReportInfo", BdhLogUtil.LogTag.Tag_Conn, "getMNewsAdData", "setMNewsAdData", "mNewsAdData", "<init>", "()V", "D", "a", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public class c extends BaseViewModel {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<List<GdtAd>> mNewsAdData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MutableLiveData<List<GdtAd>> mFirstScreenAdData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MutableLiveData<access.UserActionReportInfo> mUserActionReportInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/weather/mvvm/c$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.weather.mvvm.c$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/weather/mvvm/c$b", "Lcom/tencent/mobileqq/weather/mvvm/a$a;", "", "Lcom/tencent/gdtad/aditem/GdtAd;", "gdtAds", "Ltencent/gdt/access$UserActionReportInfo;", "userActionReportInfo", "", "a", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b implements a.InterfaceC8965a {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f313408b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f313409c;

        b(String str, int i3) {
            this.f313408b = str;
            this.f313409c = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, c.this, str, Integer.valueOf(i3));
            }
        }

        @Override // com.tencent.mobileqq.weather.mvvm.a.InterfaceC8965a
        public void a(@NotNull List<? extends GdtAd> gdtAds, @Nullable access.UserActionReportInfo userActionReportInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) gdtAds, (Object) userActionReportInfo);
                return;
            }
            Intrinsics.checkNotNullParameter(gdtAds, "gdtAds");
            c.this.O1(gdtAds, this.f313408b, this.f313409c, userActionReportInfo);
            com.tencent.mobileqq.weather.util.h.f313657a.g();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31215);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mFirstScreenAdData = new MutableLiveData<>();
        this.mUserActionReportInfo = new MutableLiveData<>();
        this.mNewsAdData = new MutableLiveData<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q1(b listener, boolean z16, String firstAdPosId, int i3) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        Intrinsics.checkNotNullParameter(firstAdPosId, "$firstAdPosId");
        a.f313393a.h(listener, z16);
        if (z16) {
            ((IVasMaskAdvPreloadApi) QRoute.api(IVasMaskAdvPreloadApi.class)).requestMaskAdAndDownloadFile();
        }
        com.tencent.mobileqq.weather.util.report.b.f313669a.i(firstAdPosId, i3);
    }

    @NotNull
    public final MutableLiveData<List<GdtAd>> M1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mFirstScreenAdData;
    }

    @NotNull
    public final MutableLiveData<access.UserActionReportInfo> N1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mUserActionReportInfo;
    }

    public void O1(@NotNull List<? extends GdtAd> gdtAds, @NotNull String adPosId, int pagePos, @Nullable access.UserActionReportInfo userActionReportInfo) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, gdtAds, adPosId, Integer.valueOf(pagePos), userActionReportInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(gdtAds, "gdtAds");
        Intrinsics.checkNotNullParameter(adPosId, "adPosId");
        this.mFirstScreenAdData.postValue(gdtAds);
        this.mUserActionReportInfo.postValue(userActionReportInfo);
        String weatherSecondPosId = ((IVasMaskAdvPreloadApi) QRoute.api(IVasMaskAdvPreloadApi.class)).getWeatherSecondPosId();
        if (gdtAds.isEmpty()) {
            com.tencent.mobileqq.weather.util.report.b.f313669a.j(adPosId, pagePos);
            return;
        }
        for (GdtAd gdtAd : gdtAds) {
            int i16 = i3 + 1;
            if (i3 == 0) {
                str = adPosId;
            } else {
                str = weatherSecondPosId;
            }
            com.tencent.mobileqq.weather.util.report.b.f313669a.k(str, pagePos, gdtAd);
            i3 = i16;
        }
    }

    public void P1(final boolean needRequestMask, boolean isRefresh, final int pagePos) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Boolean.valueOf(needRequestMask), Boolean.valueOf(isRefresh), Integer.valueOf(pagePos));
            return;
        }
        final String weatherFirstPosId = ((IVasMaskAdvPreloadApi) QRoute.api(IVasMaskAdvPreloadApi.class)).getWeatherFirstPosId();
        final b bVar = new b(weatherFirstPosId, pagePos);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.weather.mvvm.b
            @Override // java.lang.Runnable
            public final void run() {
                c.Q1(c.b.this, needRequestMask, weatherFirstPosId, pagePos);
            }
        }, 128, null, false);
    }

    public final void clear() {
        List<GdtAd> emptyList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        MutableLiveData<List<GdtAd>> mutableLiveData = this.mFirstScreenAdData;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        mutableLiveData.postValue(emptyList);
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return "WeatherMainAdViewModel";
    }
}
