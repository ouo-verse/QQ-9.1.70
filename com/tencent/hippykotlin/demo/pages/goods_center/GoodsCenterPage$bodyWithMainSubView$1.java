package com.tencent.hippykotlin.demo.pages.goods_center;

import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterCardAttr;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterCardView;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterEvent;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterCardViewModel;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterEvent;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes31.dex */
public final class GoodsCenterPage$bodyWithMainSubView$1 extends Lambda implements Function1<ViewContainer<?, ?>, Unit> {
    public final /* synthetic */ GoodsCenterPage $ctx;
    public final /* synthetic */ IGoodsCenterCardViewModel $viewModel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoodsCenterPage$bodyWithMainSubView$1(GoodsCenterPage goodsCenterPage, IGoodsCenterCardViewModel iGoodsCenterCardViewModel) {
        super(1);
        this.$ctx = goodsCenterPage;
        this.$viewModel = iGoodsCenterCardViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(ViewContainer<?, ?> viewContainer) {
        ViewContainer<?, ?> viewContainer2 = viewContainer;
        GoodsCenterPage goodsCenterPage = this.$ctx;
        IGoodsCenterCardViewModel iGoodsCenterCardViewModel = this.$viewModel;
        IGoodsCenterEvent iGoodsCenterEvent = iGoodsCenterCardViewModel instanceof IGoodsCenterEvent ? (IGoodsCenterEvent) iGoodsCenterCardViewModel : null;
        goodsCenterPage.getClass();
        if (iGoodsCenterEvent != null) {
            goodsCenterPage.eventViewModel.add(iGoodsCenterEvent);
        }
        ComposeView<GoodsCenterCardAttr, GoodsCenterEvent> cardView = this.$viewModel.getCardView();
        final IGoodsCenterCardViewModel iGoodsCenterCardViewModel2 = this.$viewModel;
        final GoodsCenterPage goodsCenterPage2 = this.$ctx;
        viewContainer2.addChild(cardView, new Function1<ComposeView<GoodsCenterCardAttr, GoodsCenterEvent>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.GoodsCenterPage$bodyWithMainSubView$1.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ComposeView<GoodsCenterCardAttr, GoodsCenterEvent> composeView) {
                ComposeView<GoodsCenterCardAttr, GoodsCenterEvent> composeView2 = composeView;
                final IGoodsCenterCardViewModel iGoodsCenterCardViewModel3 = IGoodsCenterCardViewModel.this;
                composeView2.attr(new Function1<GoodsCenterCardAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.GoodsCenterPage.bodyWithMainSubView.1.1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(GoodsCenterCardAttr goodsCenterCardAttr) {
                        goodsCenterCardAttr.viewModel = IGoodsCenterCardViewModel.this;
                        return Unit.INSTANCE;
                    }
                });
                final GoodsCenterPage goodsCenterPage3 = goodsCenterPage2;
                final IGoodsCenterCardViewModel iGoodsCenterCardViewModel4 = IGoodsCenterCardViewModel.this;
                composeView2.ref(composeView2, new Function1<aa<ComposeView<GoodsCenterCardAttr, GoodsCenterEvent>>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.GoodsCenterPage.bodyWithMainSubView.1.1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:6:0x0015, code lost:
                    
                        if (r0.mainViewScrollEnable() == true) goto L11;
                     */
                    @Override // kotlin.jvm.functions.Function1
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Unit invoke(aa<ComposeView<GoodsCenterCardAttr, GoodsCenterEvent>> aaVar) {
                        aa<ComposeView<GoodsCenterCardAttr, GoodsCenterEvent>> aaVar2 = aaVar;
                        ComposeView<GoodsCenterCardAttr, GoodsCenterEvent> b16 = aaVar2.b();
                        GoodsCenterCardView goodsCenterCardView = b16 instanceof GoodsCenterCardView ? (GoodsCenterCardView) b16 : null;
                        boolean z16 = goodsCenterCardView != null;
                        if (z16) {
                            GoodsCenterPage.this.scrollEnableView.add(aaVar2);
                        }
                        if (iGoodsCenterCardViewModel4.isTopOfCard() && goodsCenterCardView != null) {
                            GoodsCenterPage.this.topCardViewRef.add(aaVar2);
                        }
                        return Unit.INSTANCE;
                    }
                });
                final GoodsCenterPage goodsCenterPage4 = goodsCenterPage2;
                composeView2.event(new Function1<GoodsCenterEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.GoodsCenterPage.bodyWithMainSubView.1.1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(GoodsCenterEvent goodsCenterEvent) {
                        final GoodsCenterPage goodsCenterPage5 = GoodsCenterPage.this;
                        goodsCenterEvent.goodsCenterEvent(new Function2<String, Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.GoodsCenterPage.bodyWithMainSubView.1.1.3.1
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
