package com.tencent.hippykotlin.demo.pages.goods_center;

import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterEvent;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterPendantAttr;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterPendantView;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterEvent;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterPendantViewModel;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes31.dex */
public final class GoodsCenterPage$bodyWithPendantView$1 extends Lambda implements Function1<ViewContainer<?, ?>, Unit> {
    public final /* synthetic */ GoodsCenterPage $ctx;
    public final /* synthetic */ IGoodsCenterPendantViewModel $viewModel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoodsCenterPage$bodyWithPendantView$1(IGoodsCenterPendantViewModel iGoodsCenterPendantViewModel, GoodsCenterPage goodsCenterPage) {
        super(1);
        this.$viewModel = iGoodsCenterPendantViewModel;
        this.$ctx = goodsCenterPage;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(ViewContainer<?, ?> viewContainer) {
        ViewContainer<?, ?> viewContainer2 = viewContainer;
        GoodsCenterPendantView pendantView = this.$viewModel.getPendantView();
        GoodsCenterPage goodsCenterPage = this.$ctx;
        IGoodsCenterPendantViewModel iGoodsCenterPendantViewModel = this.$viewModel;
        IGoodsCenterEvent iGoodsCenterEvent = iGoodsCenterPendantViewModel instanceof IGoodsCenterEvent ? (IGoodsCenterEvent) iGoodsCenterPendantViewModel : null;
        goodsCenterPage.getClass();
        if (iGoodsCenterEvent != null) {
            goodsCenterPage.eventViewModel.add(iGoodsCenterEvent);
        }
        final GoodsCenterPage goodsCenterPage2 = this.$ctx;
        final IGoodsCenterPendantViewModel iGoodsCenterPendantViewModel2 = this.$viewModel;
        viewContainer2.addChild(pendantView, new Function1<GoodsCenterPendantView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.GoodsCenterPage$bodyWithPendantView$1.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(GoodsCenterPendantView goodsCenterPendantView) {
                GoodsCenterPendantView goodsCenterPendantView2 = goodsCenterPendantView;
                final GoodsCenterPage goodsCenterPage3 = GoodsCenterPage.this;
                goodsCenterPendantView2.ref(goodsCenterPendantView2, new Function1<aa<GoodsCenterPendantView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.GoodsCenterPage.bodyWithPendantView.1.1.1
                    {
                        super(1);
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:4:0x000f, code lost:
                    
                        if (r0.mainViewScrollEnable() == true) goto L8;
                     */
                    @Override // kotlin.jvm.functions.Function1
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Unit invoke(aa<GoodsCenterPendantView> aaVar) {
                        aa<GoodsCenterPendantView> aaVar2 = aaVar;
                        GoodsCenterPendantView b16 = aaVar2.b();
                        boolean z16 = b16 != null;
                        if (z16) {
                            GoodsCenterPage.this.scrollEnableView.add(aaVar2);
                        }
                        return Unit.INSTANCE;
                    }
                });
                final IGoodsCenterPendantViewModel iGoodsCenterPendantViewModel3 = iGoodsCenterPendantViewModel2;
                goodsCenterPendantView2.attr(new Function1<GoodsCenterPendantAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.GoodsCenterPage.bodyWithPendantView.1.1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(GoodsCenterPendantAttr goodsCenterPendantAttr) {
                        goodsCenterPendantAttr.viewModel = IGoodsCenterPendantViewModel.this;
                        return Unit.INSTANCE;
                    }
                });
                final GoodsCenterPage goodsCenterPage4 = GoodsCenterPage.this;
                goodsCenterPendantView2.event(new Function1<GoodsCenterEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.GoodsCenterPage.bodyWithPendantView.1.1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(GoodsCenterEvent goodsCenterEvent) {
                        final GoodsCenterPage goodsCenterPage5 = GoodsCenterPage.this;
                        goodsCenterEvent.goodsCenterEvent(new Function2<String, Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.GoodsCenterPage.bodyWithPendantView.1.1.3.1
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Unit invoke(String str, Object obj) {
                                String str2 = str;
                                Iterator<IGoodsCenterEvent> it = GoodsCenterPage.this.eventViewModel.iterator();
                                while (it.hasNext()) {
                                    IGoodsCenterEvent next = it.next();
                                    if (next.canHandleEventName().contains(str2)) {
                                        next.onEvent(str2, obj);
                                    }
                                }
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
}
