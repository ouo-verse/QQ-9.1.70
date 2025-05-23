package com.tencent.hippykotlin.demo.pages.game_content_page.banner;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.create.AdelieAudioRecordManager$endRecord$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.foundation.view.APNGAttr;
import com.tencent.hippykotlin.demo.pages.foundation.view.APNGVView;
import com.tencent.hippykotlin.demo.pages.foundation.view.APNGViewKt;
import com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPage$body$1$3$1$3$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.TopBannerItem;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.PageListView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.compose.SliderPageAttr;
import com.tencent.kuikly.core.views.compose.SliderPageView;
import com.tencent.kuikly.core.views.compose.d;
import com.tencent.kuikly.core.views.compose.e;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsJVMKt;

/* loaded from: classes31.dex */
public final class GCPSmallBannerView extends ComposeView<GCPSmallBannerAttr, GCPSmallBannerEvent> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GCPSmallBannerView.class, "currentIndex", "getCurrentIndex()I", 0)};
    public aa<SliderPageView> bannerRef;
    public final ReadWriteProperty currentIndex$delegate = c.a(0);

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ GCPSmallBannerAttr access$getAttr(GCPSmallBannerView gCPSmallBannerView) {
        return (GCPSmallBannerAttr) gCPSmallBannerView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.banner.GCPSmallBannerView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.banner.GCPSmallBannerView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(m mVar) {
                        return Unit.INSTANCE;
                    }
                });
                final GCPSmallBannerView gCPSmallBannerView = GCPSmallBannerView.this;
                e.a(viewContainer2, new Function1<SliderPageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.banner.GCPSmallBannerView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(SliderPageView sliderPageView) {
                        SliderPageView sliderPageView2 = sliderPageView;
                        final GCPSmallBannerView gCPSmallBannerView2 = GCPSmallBannerView.this;
                        sliderPageView2.ref(sliderPageView2, new Function1<aa<SliderPageView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.banner.GCPSmallBannerView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(aa<SliderPageView> aaVar) {
                                GCPSmallBannerView.this.bannerRef = aaVar;
                                return Unit.INSTANCE;
                            }
                        });
                        final GCPSmallBannerView gCPSmallBannerView3 = GCPSmallBannerView.this;
                        sliderPageView2.attr(new Function1<SliderPageAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.banner.GCPSmallBannerView.body.1.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(SliderPageAttr sliderPageAttr) {
                                SliderPageAttr sliderPageAttr2 = sliderPageAttr;
                                sliderPageAttr2.q(0);
                                sliderPageAttr2.r(true);
                                sliderPageAttr2.marginLeft(16.0f);
                                sliderPageAttr2.marginRight(16.0f);
                                sliderPageAttr2.borderRadius(8.0f);
                                sliderPageAttr2.u(sliderPageAttr2.getPagerData().m() - 32.0f);
                                sliderPageAttr2.t((sliderPageAttr2.getPagerData().m() - 32.0f) * 0.36151603f);
                                GCPSmallBannerAttr access$getAttr = GCPSmallBannerView.access$getAttr(GCPSmallBannerView.this);
                                sliderPageAttr2.s(((Number) access$getAttr.loopPlayIntervalTimeMs$delegate.getValue(access$getAttr, GCPSmallBannerAttr.$$delegatedProperties[0])).intValue());
                                List<TopBannerItem> list = GCPSmallBannerView.access$getAttr(GCPSmallBannerView.this).bannerData;
                                if (list != null) {
                                    sliderPageAttr2.o(list, new Function2<PageListView<?, ?>, TopBannerItem, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.banner.GCPSmallBannerView$body$1$2$2$1$1
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Unit invoke(PageListView<?, ?> pageListView, TopBannerItem topBannerItem) {
                                            final TopBannerItem topBannerItem2 = topBannerItem;
                                            w.a(pageListView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.banner.GCPSmallBannerView$body$1$2$2$1$1.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(v vVar) {
                                                    boolean endsWith;
                                                    boolean endsWith2;
                                                    v vVar2 = vVar;
                                                    vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.banner.GCPSmallBannerView.body.1.2.2.1.1.1.1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(t tVar) {
                                                            tVar.m140flex(1.0f);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final TopBannerItem topBannerItem3 = TopBannerItem.this;
                                                    vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.banner.GCPSmallBannerView.body.1.2.2.1.1.1.2
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(u uVar) {
                                                            final u uVar2 = uVar;
                                                            final TopBannerItem topBannerItem4 = TopBannerItem.this;
                                                            uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.banner.GCPSmallBannerView.body.1.2.2.1.1.1.2.1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ClickParams clickParams) {
                                                                    BridgeModule bridgeModule = IPagerIdKtxKt.getBridgeModule(u.this);
                                                                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("did click small banner with url:");
                                                                    m3.append(topBannerItem4.jumpUrl);
                                                                    bridgeModule.log(m3.toString());
                                                                    BridgeModule.openPage$default(IPagerIdKtxKt.getBridgeModule(u.this), topBannerItem4.jumpUrl, false, null, null, 30);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    TopBannerItem topBannerItem4 = TopBannerItem.this;
                                                    if (topBannerItem4.isSmallImgDynamic != 0) {
                                                        endsWith = StringsKt__StringsJVMKt.endsWith(topBannerItem4.smallImg, "gif", true);
                                                        if (!endsWith) {
                                                            endsWith2 = StringsKt__StringsJVMKt.endsWith(TopBannerItem.this.smallImg, "png", true);
                                                            if (endsWith2) {
                                                                final TopBannerItem topBannerItem5 = TopBannerItem.this;
                                                                APNGViewKt.APNG(vVar2, new Function1<APNGVView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.banner.GCPSmallBannerView.body.1.2.2.1.1.1.4
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(APNGVView aPNGVView) {
                                                                        final TopBannerItem topBannerItem6 = TopBannerItem.this;
                                                                        aPNGVView.attr(new Function1<APNGAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.banner.GCPSmallBannerView.body.1.2.2.1.1.1.4.1
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(APNGAttr aPNGAttr) {
                                                                                APNGAttr aPNGAttr2 = aPNGAttr;
                                                                                aPNGAttr2.absolutePositionAllZero();
                                                                                aPNGAttr2.with("src", TopBannerItem.this.smallImg);
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    }
                                                    final TopBannerItem topBannerItem6 = TopBannerItem.this;
                                                    ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.banner.GCPSmallBannerView.body.1.2.2.1.1.1.3
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ImageView imageView) {
                                                            final TopBannerItem topBannerItem7 = TopBannerItem.this;
                                                            imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.banner.GCPSmallBannerView.body.1.2.2.1.1.1.3.1
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(af afVar) {
                                                                    af afVar2 = afVar;
                                                                    afVar2.absolutePositionAllZero();
                                                                    b.a.b(afVar2, TopBannerItem.this.smallImg, false, 2, null);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        final GCPSmallBannerView gCPSmallBannerView4 = GCPSmallBannerView.this;
                        sliderPageView2.event(new Function1<d, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.banner.GCPSmallBannerView.body.1.2.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(d dVar) {
                                final GCPSmallBannerView gCPSmallBannerView5 = GCPSmallBannerView.this;
                                dVar.pageIndexDidChanged(new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.banner.GCPSmallBannerView.body.1.2.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Object obj) {
                                        GCPSmallBannerView gCPSmallBannerView6 = GCPSmallBannerView.this;
                                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                                        int j3 = ((com.tencent.kuikly.core.nvi.serialization.json.e) obj).j("index");
                                        ReadWriteProperty readWriteProperty = gCPSmallBannerView6.currentIndex$delegate;
                                        KProperty<?>[] kPropertyArr = GCPSmallBannerView.$$delegatedProperties;
                                        readWriteProperty.setValue(gCPSmallBannerView6, kPropertyArr[0], Integer.valueOf(j3));
                                        GCPSmallBannerView.this.emit("pageIndexChanged", obj);
                                        GCPSmallBannerView gCPSmallBannerView7 = GCPSmallBannerView.this;
                                        gCPSmallBannerView7.reportExp(((Number) gCPSmallBannerView7.currentIndex$delegate.getValue(gCPSmallBannerView7, kPropertyArr[0])).intValue());
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final GCPSmallBannerView gCPSmallBannerView2 = GCPSmallBannerView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.banner.GCPSmallBannerView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final GCPSmallBannerView gCPSmallBannerView3 = GCPSmallBannerView.this;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.banner.GCPSmallBannerView.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                Attr.absolutePosition$default(tVar2, 0.0f, (tVar2.getPagerData().m() / 2) - ((GCPSmallBannerView.access$getAttr(GCPSmallBannerView.this).bannerData != null ? r1.size() : 0) * 3.5f), 8.0f, 0.0f, 9, null);
                                tVar2.size((GCPSmallBannerView.access$getAttr(GCPSmallBannerView.this).bannerData != null ? r0.size() : 0) * 7.0f, 3.0f);
                                tVar2.borderRadius(1.5f);
                                tVar2.mo113backgroundColor(new h(255, 255, 255, 0.4f));
                                return Unit.INSTANCE;
                            }
                        });
                        final GCPSmallBannerView gCPSmallBannerView4 = GCPSmallBannerView.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.banner.GCPSmallBannerView.body.1.3.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                final GCPSmallBannerView gCPSmallBannerView5 = GCPSmallBannerView.this;
                                vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.banner.GCPSmallBannerView.body.1.3.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        GCPSmallBannerView gCPSmallBannerView6 = GCPSmallBannerView.this;
                                        tVar2.marginLeft(((Number) gCPSmallBannerView6.currentIndex$delegate.getValue(gCPSmallBannerView6, GCPSmallBannerView.$$delegatedProperties[0])).intValue() * 7.0f).marginTop(0.0f).marginBottom(0.0f);
                                        tVar2.size(7.0f, 3.0f);
                                        tVar2.borderRadius(1.5f);
                                        tVar2.mo113backgroundColor(new h(255, 255, 255, 1.0f));
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new GCPSmallBannerAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new GCPSmallBannerEvent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void reportExp(int i3) {
        TopBannerItem topBannerItem;
        List<TopBannerItem> list = ((GCPSmallBannerAttr) getAttr()).bannerData;
        if (list == null || (topBannerItem = list.get(i3)) == null) {
            return;
        }
        com.tencent.kuikly.core.nvi.serialization.json.e v3 = new com.tencent.kuikly.core.nvi.serialization.json.e().v("banner_id", topBannerItem.bannerId);
        com.tencent.kuikly.core.nvi.serialization.json.e m3 = AdelieAudioRecordManager$endRecord$1$$ExternalSyntheticOutline0.m("source_from", GameContentPage$body$1$3$1$3$1$$ExternalSyntheticOutline0.m(BridgeManager.f117344a, com.tencent.kuikly.core.manager.c.f117352a, "source_from"), "bus_id", 2);
        if (v3 != null) {
            Iterator<String> c16 = v3.c();
            while (c16.hasNext()) {
                String next = c16.next();
                m3.v(next, v3.p(next));
            }
        }
        Utils.INSTANCE.currentBridgeModule().reportDT("youxi_page_narrow_banner_exp", m3);
    }
}
