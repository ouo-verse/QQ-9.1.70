package com.tencent.hippykotlin.demo.pages.goods_center.card.order;

import com.tencent.hippykotlin.demo.pages.base.protoc.Icon;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GoodsCenterOrderNavigationView extends ComposeView<GoodsCenterOrderNavigationAttr, l> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final Function1 access$bodyWithNavItem(GoodsCenterOrderNavigationView goodsCenterOrderNavigationView, Icon icon) {
        GoodsCenterOrderViewModel goodsCenterOrderViewModel = ((GoodsCenterOrderNavigationAttr) goodsCenterOrderNavigationView.getAttr()).viewModel;
        if (goodsCenterOrderViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            goodsCenterOrderViewModel = null;
        }
        Intrinsics.checkNotNull(goodsCenterOrderViewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.goods_center.card.order.GoodsCenterOrderViewModel");
        return new GoodsCenterOrderNavigationView$bodyWithNavItem$1(goodsCenterOrderViewModel, icon);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ GoodsCenterOrderNavigationAttr access$getAttr(GoodsCenterOrderNavigationView goodsCenterOrderNavigationView) {
        return (GoodsCenterOrderNavigationAttr) goodsCenterOrderNavigationView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.order.GoodsCenterOrderNavigationView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final GoodsCenterOrderNavigationView goodsCenterOrderNavigationView = GoodsCenterOrderNavigationView.this;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.order.GoodsCenterOrderNavigationView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.order.GoodsCenterOrderNavigationView.body.1.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.marginLeft(20.0f).marginRight(20.0f);
                                tVar2.flexDirectionRow().justifyContentSpaceAround();
                                return Unit.INSTANCE;
                            }
                        });
                        ArrayList<Icon> arrayList = GoodsCenterOrderNavigationView.access$getAttr(GoodsCenterOrderNavigationView.this).navButtons;
                        if (arrayList == null) {
                            Icon icon = new Icon("\u9009\u54c1\u4e2d\u5fc3", "https://fcccdn.qq.com/infoop/8a2ed5e6ee59b4dc2df088b9d95fc720_1647421201581.png", 10);
                            arrayList = CollectionsKt__CollectionsKt.arrayListOf(icon, icon, icon, icon);
                        }
                        if (arrayList != null) {
                            GoodsCenterOrderNavigationView goodsCenterOrderNavigationView2 = GoodsCenterOrderNavigationView.this;
                            Iterator<T> it = arrayList.iterator();
                            while (it.hasNext()) {
                                ((GoodsCenterOrderNavigationView$bodyWithNavItem$1) GoodsCenterOrderNavigationView.access$bodyWithNavItem(goodsCenterOrderNavigationView2, (Icon) it.next())).invoke(vVar2);
                            }
                        }
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new GoodsCenterOrderNavigationAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}
