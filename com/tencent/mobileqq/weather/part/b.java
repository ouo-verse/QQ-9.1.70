package com.tencent.mobileqq.weather.part;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.gdtad.IGdtActivityHandler;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.ad.cardad.views.CardAdView;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.adv.maskad.MaskAdClickHelper;
import com.tencent.mobileqq.weather.event.WeatherMainPageActivityResultEvent;
import com.tencent.mobileqq.weather.event.WeatherMainPageLifeCircleEvent;
import com.tencent.mobileqq.weather.event.WeatherScrollStateChanged;
import com.tencent.mobileqq.weather.event.WeatherViewPageSelectChangeEvent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u0003B\u0007\u00a2\u0006\u0004\b6\u00107J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\tH\u0014J\u0012\u0010\r\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014J*\u0010\u0014\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0014J\b\u0010\u0015\u001a\u00020\u0007H\u0016J\u0012\u0010\u0017\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004H\u0016J\u0014\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00190\u0018H\u0016R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010(R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00105\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u0010(\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/weather/part/b;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "Lcom/tencent/mobileqq/weather/data/k;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "v", "", "u", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "data", "", "position", "", "", "payload", "w", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "", "d", "Ljava/lang/String;", "TAG", "Landroid/view/ViewGroup;", "e", "Landroid/view/ViewGroup;", "mContainerView", "Lcom/tencent/mobileqq/ad/cardad/views/CardAdView;", "f", "Lcom/tencent/mobileqq/ad/cardad/views/CardAdView;", "mCardAdView", tl.h.F, "I", "mPagePosition", "i", "mPos", "Lcom/tencent/gdtad/aditem/GdtAd;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/gdtad/aditem/GdtAd;", "mGdtAd", "Lcom/tencent/mobileqq/weather/data/a;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/weather/data/a;", "mCurrentData", "D", "mCarouselTimes", "<init>", "()V", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class b extends Section<com.tencent.mobileqq.weather.data.k> implements SimpleEventReceiver<SimpleBaseEvent> {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.weather.data.a mCurrentData;

    /* renamed from: D, reason: from kotlin metadata */
    private int mCarouselTimes;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup mContainerView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CardAdView mCardAdView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mPagePosition;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mPos;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GdtAd mGdtAd;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/weather/part/b$a", "Lcom/tencent/mobileqq/ad/cardad/data/aa;", "Lcom/tencent/gdtad/aditem/GdtAd;", "gdtAd", "", "e", "a", "b", "f", "g", "c", "d", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class a implements com.tencent.mobileqq.ad.cardad.data.aa {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.weather.data.k f313514b;

        a(com.tencent.mobileqq.weather.data.k kVar) {
            this.f313514b = kVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this, (Object) kVar);
            }
        }

        @Override // com.tencent.mobileqq.ad.cardad.data.aa
        public void a(@NotNull GdtAd gdtAd) {
            String e16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) gdtAd);
                return;
            }
            Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
            com.tencent.mobileqq.weather.data.a aVar = b.this.mCurrentData;
            if (aVar != null && (e16 = aVar.e()) != null) {
                com.tencent.mobileqq.weather.util.report.b.f313669a.f(e16, b.this.mPagePosition, gdtAd);
            }
        }

        @Override // com.tencent.mobileqq.ad.cardad.data.aa
        public void b(@NotNull GdtAd gdtAd) {
            String e16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) gdtAd);
                return;
            }
            Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
            com.tencent.mobileqq.weather.data.a aVar = b.this.mCurrentData;
            if (aVar != null && (e16 = aVar.e()) != null) {
                com.tencent.mobileqq.weather.util.report.b.f313669a.g(e16, b.this.mPagePosition, gdtAd);
            }
        }

        @Override // com.tencent.mobileqq.ad.cardad.data.aa
        public void c(@NotNull GdtAd gdtAd) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) gdtAd);
            } else {
                Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
            }
        }

        @Override // com.tencent.mobileqq.ad.cardad.data.aa
        public void d(@NotNull GdtAd gdtAd) {
            String e16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) gdtAd);
                return;
            }
            Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
            com.tencent.mobileqq.weather.data.a aVar = b.this.mCurrentData;
            if (aVar != null && (e16 = aVar.e()) != null) {
                b bVar = b.this;
                com.tencent.mobileqq.weather.util.report.b bVar2 = com.tencent.mobileqq.weather.util.report.b.f313669a;
                int i3 = bVar.mPagePosition;
                bVar.mCarouselTimes++;
                bVar2.d(e16, i3, gdtAd, bVar.mCarouselTimes);
            }
        }

        @Override // com.tencent.mobileqq.ad.cardad.data.aa
        public void e(@NotNull GdtAd gdtAd) {
            String e16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) gdtAd);
                return;
            }
            Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
            com.tencent.mobileqq.weather.data.a aVar = b.this.mCurrentData;
            if (aVar != null && (e16 = aVar.e()) != null) {
                com.tencent.mobileqq.weather.util.report.b.f313669a.h(e16, b.this.mPagePosition, gdtAd);
            }
        }

        @Override // com.tencent.mobileqq.ad.cardad.data.aa
        public void f(@NotNull GdtAd gdtAd) {
            String e16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) gdtAd);
                return;
            }
            Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
            com.tencent.mobileqq.weather.data.a aVar = b.this.mCurrentData;
            if (aVar != null && (e16 = aVar.e()) != null) {
                com.tencent.mobileqq.weather.util.report.b.f313669a.e(e16, b.this.mPagePosition, gdtAd);
            }
        }

        @Override // com.tencent.mobileqq.ad.cardad.data.aa
        public void g(@NotNull GdtAd gdtAd) {
            String e16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) gdtAd);
                return;
            }
            Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
            com.tencent.mobileqq.weather.data.a aVar = (com.tencent.mobileqq.weather.data.a) this.f313514b;
            if (aVar != null) {
                aVar.h(true);
            }
            com.tencent.mobileqq.weather.data.a aVar2 = b.this.mCurrentData;
            if (aVar2 != null && (e16 = aVar2.e()) != null) {
                com.tencent.mobileqq.weather.util.report.b.f313669a.l(e16, b.this.mPagePosition, gdtAd);
            }
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.TAG = "WeatherAdSection";
        }
    }

    private final void u() {
        GdtAd gdtAd = this.mGdtAd;
        boolean z16 = false;
        if (gdtAd != null) {
            if (true == MaskAdClickHelper.INSTANCE.isMaskAd(gdtAd.getInnerShowType())) {
                z16 = true;
            }
        }
        if (z16) {
            QLog.d(this.TAG, 1, "is mask ad, cancel expose");
            return;
        }
        CardAdView cardAdView = this.mCardAdView;
        if (cardAdView != null) {
            cardAdView.c0();
        }
    }

    private final boolean v() {
        com.tencent.mobileqq.ad.cardad.utils.d dVar = com.tencent.mobileqq.ad.cardad.utils.d.f186735a;
        if (com.tencent.mobileqq.ad.cardad.utils.d.d(dVar, this.mContainerView, false, 2, null) > 0.5d) {
            CardAdView cardAdView = this.mCardAdView;
            if (cardAdView != null) {
                cardAdView.r0();
            }
            CardAdView cardAdView2 = this.mCardAdView;
            if (cardAdView2 != null) {
                cardAdView2.q0();
            }
        }
        if (com.tencent.mobileqq.ad.cardad.utils.d.d(dVar, this.mContainerView, false, 2, null) <= 0.0d) {
            return false;
        }
        QLog.d(this.TAG, 2, "bindData: getPercentageOfGlobalVisibleRect > 0");
        u();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(b this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.v();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(WeatherScrollStateChanged.class, WeatherViewPageSelectChangeEvent.class, WeatherMainPageLifeCircleEvent.class, WeatherMainPageActivityResultEvent.class);
            return arrayListOf;
        }
        return (ArrayList) iPatchRedirector.redirect((short) 7, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (int[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new int[]{R.id.f1190375r};
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        CardAdView cardAdView = this.mCardAdView;
        if (cardAdView != null) {
            cardAdView.onDestroy();
        }
        com.tencent.mobileqq.weather.mvvm.d.E.R1();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View containerView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) containerView);
            return;
        }
        if (containerView != null) {
            this.mContainerView = (ViewGroup) containerView.findViewById(R.id.f120897_s);
        }
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        CardAdView cardAdView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) event);
            return;
        }
        if (event instanceof WeatherScrollStateChanged) {
            if (((WeatherScrollStateChanged) event).getPagePosition() != this.mPagePosition) {
                return;
            }
            double d16 = com.tencent.mobileqq.ad.cardad.utils.d.d(com.tencent.mobileqq.ad.cardad.utils.d.f186735a, this.mContainerView, false, 2, null);
            QLog.d(this.TAG, 1, "WeatherScrollStateChanged:", Double.valueOf(d16));
            if (d16 > 0.5d) {
                u();
                CardAdView cardAdView2 = this.mCardAdView;
                if (cardAdView2 != null) {
                    cardAdView2.w0();
                }
            } else {
                CardAdView cardAdView3 = this.mCardAdView;
                if (cardAdView3 != null) {
                    CardAdView.u0(cardAdView3, false, 1, null);
                }
                CardAdView cardAdView4 = this.mCardAdView;
                if (cardAdView4 != null) {
                    cardAdView4.s0();
                }
            }
            CardAdView cardAdView5 = this.mCardAdView;
            if (cardAdView5 != null) {
                cardAdView5.f0();
                return;
            }
            return;
        }
        if (event instanceof WeatherViewPageSelectChangeEvent) {
            WeatherViewPageSelectChangeEvent weatherViewPageSelectChangeEvent = (WeatherViewPageSelectChangeEvent) event;
            QLog.d(this.TAG, 1, "WeatherViewPageSelectChangeEvent pos:", Integer.valueOf(weatherViewPageSelectChangeEvent.getPagePosition()), ",mPos:", Integer.valueOf(this.mPagePosition), ",lastRequestAdPage:", Integer.valueOf(weatherViewPageSelectChangeEvent.getLastPagePosition()));
            if (this.mPagePosition == weatherViewPageSelectChangeEvent.getPagePosition() && this.mPagePosition != weatherViewPageSelectChangeEvent.getLastPagePosition()) {
                u();
                if (com.tencent.mobileqq.ad.cardad.utils.d.f186735a.c(this.mContainerView, true) >= 0.5d) {
                    CardAdView cardAdView6 = this.mCardAdView;
                    if (cardAdView6 != null) {
                        cardAdView6.r0();
                    }
                    CardAdView cardAdView7 = this.mCardAdView;
                    if (cardAdView7 != null) {
                        cardAdView7.q0();
                        return;
                    }
                    return;
                }
                return;
            }
            CardAdView cardAdView8 = this.mCardAdView;
            if (cardAdView8 != null) {
                CardAdView.u0(cardAdView8, false, 1, null);
                return;
            }
            return;
        }
        if (event instanceof WeatherMainPageLifeCircleEvent) {
            WeatherMainPageLifeCircleEvent weatherMainPageLifeCircleEvent = (WeatherMainPageLifeCircleEvent) event;
            QLog.d(this.TAG, 1, "WeatherMainPageLifeCircleEvent:", Integer.valueOf(weatherMainPageLifeCircleEvent.getLifeCircle()));
            if (weatherMainPageLifeCircleEvent.getLifeCircle() == 2) {
                CardAdView cardAdView9 = this.mCardAdView;
                if (cardAdView9 != null) {
                    cardAdView9.f0();
                    return;
                }
                return;
            }
            if (weatherMainPageLifeCircleEvent.getLifeCircle() == 3) {
                CardAdView cardAdView10 = this.mCardAdView;
                if (cardAdView10 != null) {
                    cardAdView10.e0();
                    return;
                }
                return;
            }
            if (weatherMainPageLifeCircleEvent.getLifeCircle() == 5 && (cardAdView = this.mCardAdView) != null) {
                cardAdView.onDestroy();
                return;
            }
            return;
        }
        if (event instanceof WeatherMainPageActivityResultEvent) {
            WeatherMainPageActivityResultEvent weatherMainPageActivityResultEvent = (WeatherMainPageActivityResultEvent) event;
            ((IGdtActivityHandler) QRoute.api(IGdtActivityHandler.class)).onActivityResult(weatherMainPageActivityResultEvent.getWeakActivity(), weatherMainPageActivityResultEvent.getRequestCode(), weatherMainPageActivityResultEvent.getResultCode(), weatherMainPageActivityResultEvent.getData());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable com.tencent.mobileqq.weather.data.k data, int position, @Nullable List<Object> payload) {
        byte b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, data, Integer.valueOf(position), payload);
            return;
        }
        if (!(data instanceof com.tencent.mobileqq.weather.data.a)) {
            return;
        }
        com.tencent.mobileqq.weather.data.a aVar = this.mCurrentData;
        if (aVar != null && aVar.d(data)) {
            b16 = true;
        } else {
            b16 = false;
        }
        if (b16 != false) {
            return;
        }
        com.tencent.mobileqq.weather.data.a aVar2 = (com.tencent.mobileqq.weather.data.a) data;
        this.mCurrentData = aVar2;
        this.mPagePosition = aVar2.a();
        this.mPos = position;
        a aVar3 = new a(data);
        CardAdView cardAdView = this.mCardAdView;
        if (cardAdView != null) {
            cardAdView.onDestroy();
        }
        GdtAd f16 = aVar2.f();
        CardAdView cardAdView2 = null;
        Context context = null;
        if (f16 != null) {
            com.tencent.mobileqq.ad.cardad.manager.a aVar4 = com.tencent.mobileqq.ad.cardad.manager.a.f186722a;
            ViewGroup viewGroup = this.mContainerView;
            if (viewGroup != null) {
                context = viewGroup.getContext();
            }
            cardAdView2 = aVar4.b(context, this.mContainerView, f16, aVar3);
        }
        this.mCardAdView = cardAdView2;
        if (aVar2.g()) {
            CardAdView cardAdView3 = this.mCardAdView;
            if (cardAdView3 != null) {
                cardAdView3.S();
                return;
            }
            return;
        }
        QLog.d(this.TAG, 2, "bindData:", Integer.valueOf(this.mPos), ", ", Integer.valueOf(this.mPagePosition));
        if (!v()) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.weather.part.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.x(b.this);
                }
            }, 300L);
        }
    }
}
