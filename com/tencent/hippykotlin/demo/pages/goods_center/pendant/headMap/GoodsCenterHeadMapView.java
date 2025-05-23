package com.tencent.hippykotlin.demo.pages.goods_center.pendant.headMap;

import com.tencent.hippykotlin.demo.pages.base.extension.ImageAttrExtKt;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterEvent;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterPendantAttr;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterPendantView;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterPendantViewModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GoodsCenterHeadMapView extends GoodsCenterPendantView {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterPendantView, com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        IGoodsCenterPendantViewModel viewModel = ((GoodsCenterPendantAttr) getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.goods_center.pendant.headMap.GoodsCenterHeadMapViewModel");
        final GoodsCenterHeadMapViewModel goodsCenterHeadMapViewModel = (GoodsCenterHeadMapViewModel) viewModel;
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.headMap.GoodsCenterHeadMapView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final GoodsCenterHeadMapViewModel goodsCenterHeadMapViewModel2 = GoodsCenterHeadMapViewModel.this;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.headMap.GoodsCenterHeadMapView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        GoodsCenterHeadMapViewModel goodsCenterHeadMapViewModel3 = GoodsCenterHeadMapViewModel.this;
                        ReadWriteProperty readWriteProperty = goodsCenterHeadMapViewModel3.keepViewInNavBar$delegate;
                        KProperty<?>[] kPropertyArr = GoodsCenterHeadMapViewModel.$$delegatedProperties;
                        mVar2.mo141height(((Boolean) readWriteProperty.getValue(goodsCenterHeadMapViewModel3, kPropertyArr[1])).booleanValue() ? mVar2.getPagerData().getNavigationBarHeight() : 600.0f);
                        Attr.absolutePosition$default(mVar2, 0.0f, 0.0f, 0.0f, 0.0f, 4, null);
                        GoodsCenterHeadMapViewModel goodsCenterHeadMapViewModel4 = GoodsCenterHeadMapViewModel.this;
                        mVar2.m152visibility(((Boolean) goodsCenterHeadMapViewModel4.showBackground$delegate.getValue(goodsCenterHeadMapViewModel4, kPropertyArr[0])).booleanValue());
                        mVar2.overflow(true);
                        return Unit.INSTANCE;
                    }
                });
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.headMap.GoodsCenterHeadMapView$body$1.2
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.headMap.GoodsCenterHeadMapView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                h hVar;
                                t tVar2 = tVar;
                                Attr.absolutePosition$default(tVar2, 0.0f, 0.0f, 0.0f, 0.0f, 12, null);
                                tVar2.size(tVar2.getPagerData().m(), 600.0f);
                                Direction direction = Direction.TO_BOTTOM;
                                hVar = IPagerIdKtxKt.getSkinColor(tVar2).tokenColor("qecommerce_white_color_bg_skeleton", false);
                                tVar2.mo135backgroundLinearGradient(direction, new j(hVar, 0.6f), new j(new h(4294309365L), 0.8f));
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                ah.a(viewContainer2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.headMap.GoodsCenterHeadMapView$body$1.3
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ImageView imageView) {
                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.headMap.GoodsCenterHeadMapView.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(af afVar) {
                                af afVar2 = afVar;
                                afVar2.mo141height(600.0f);
                                afVar2.absolutePosition(0.0f, 0.0f, 0.0f, 0.0f);
                                ImageAttrExtKt.urlToken$default(afVar2, "qecommerce_skin_img_general_daihuozhongxin_background");
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

    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterPendantView, com.tencent.kuikly.core.base.AbstractBaseView
    public final GoodsCenterPendantAttr createAttr() {
        return new GoodsCenterPendantAttr();
    }

    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterPendantView, com.tencent.kuikly.core.base.AbstractBaseView
    public final GoodsCenterEvent createEvent() {
        return new GoodsCenterEvent();
    }

    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterPendantView, com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new GoodsCenterPendantAttr();
    }

    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterPendantView, com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new GoodsCenterEvent();
    }
}
