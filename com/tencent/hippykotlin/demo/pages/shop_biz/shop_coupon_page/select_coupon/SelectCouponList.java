package com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon;

import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.BotListCellKt$BotListCell$3$1$2$2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.extension.AttrExtKt;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.CommonCouponItemModel;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.SCPUtilsKt;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponViewModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.views.RichTextView;
import com.tencent.kuikly.core.views.RichTextViewKt;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ao;
import com.tencent.kuikly.core.views.aq;
import com.tencent.kuikly.core.views.ar;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cf;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class SelectCouponList extends ComposeView<SelectCouponAttr, SelectCouponEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final SelectCouponViewModel.PageState pageState = ((SelectCouponAttr) getAttr()).listState;
        if (pageState == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listState");
            pageState = null;
        }
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponList$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final SelectCouponViewModel.PageState pageState2 = SelectCouponViewModel.PageState.this;
                final SelectCouponList selectCouponList = this;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponList$body$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponList.body.1.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.padding(4.0f, 16.0f, 4.0f, 16.0f);
                                tVar2.m140flex(1.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        if (SelectCouponViewModel.PageState.this instanceof SelectCouponViewModel.PageState.InitLoading) {
                            w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponList.body.1.1.2
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(v vVar3) {
                                    vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponList.body.1.1.2.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(t tVar) {
                                            t tVar2 = tVar;
                                            tVar2.marginBottom(16.0f);
                                            tVar2.marginTop(16.0f);
                                            tVar2.size(250.0f, 20.0f);
                                            AttrExtKt.backgroundColorToken(tVar2, "qecommerce_skin_color_bg_backplate");
                                            tVar2.borderRadius(4.0f);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                        }
                        final SelectCouponViewModel.PageState pageState3 = SelectCouponViewModel.PageState.this;
                        if (pageState3.showTitle) {
                            final SelectCouponList selectCouponList2 = selectCouponList;
                            w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponList.body.1.1.3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                /* JADX WARN: Code restructure failed: missing block: B:4:0x001c, code lost:
                                
                                    if (r0.isBestDiscount == true) goto L8;
                                 */
                                @Override // kotlin.jvm.functions.Function1
                                /*
                                    Code decompiled incorrectly, please refer to instructions dump.
                                */
                                public final Unit invoke(v vVar3) {
                                    v vVar4 = vVar3;
                                    vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponList.body.1.1.3.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(t tVar) {
                                            t tVar2 = tVar;
                                            tVar2.marginBottom(14.0f);
                                            tVar2.mo141height(28.0f);
                                            tVar2.flexDirectionRow();
                                            tVar2.alignItemsCenter();
                                            tVar2.justifyContentSpaceBetween();
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final SelectCouponViewModel.PageState pageState4 = SelectCouponViewModel.PageState.this;
                                    RichTextViewKt.b(vVar4, new Function1<RichTextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponList.body.1.1.3.2
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(RichTextView richTextView) {
                                            final RichTextView richTextView2 = richTextView;
                                            final SelectCouponViewModel.PageState pageState5 = SelectCouponViewModel.PageState.this;
                                            RichTextViewKt.c(richTextView2, new Function1<cf, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponList.body.1.1.3.2.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(cf cfVar) {
                                                    String str;
                                                    cf cfVar2 = cfVar;
                                                    SelectCouponViewModel.PageData optPageData = SelectCouponViewModelKt.optPageData(SelectCouponViewModel.PageState.this);
                                                    boolean z16 = false;
                                                    if (optPageData != null && optPageData.isBestDiscount) {
                                                        str = "\u5df2\u9009\u62e9\u6700\u4f73\u4f18\u60e0,\u5f53\u524d\u62b5\u6263";
                                                    } else {
                                                        SelectCouponViewModel.PageData optPageData2 = SelectCouponViewModelKt.optPageData(SelectCouponViewModel.PageState.this);
                                                        if (optPageData2 != null && optPageData2.discountPrice == 0) {
                                                            z16 = true;
                                                        }
                                                        if (z16) {
                                                            str = "\u8bf7\u9009\u62e9\u4f18\u60e0,\u5f53\u524d\u62b5\u6263";
                                                        } else {
                                                            str = "\u5df2\u9009\u62e9\u4f18\u60e0,\u5f53\u524d\u62b5\u6263";
                                                        }
                                                    }
                                                    cfVar2.text(str);
                                                    ce.fontSize$default(cfVar2, 13.0f, null, 2, null);
                                                    cfVar2.color(IPagerIdKtxKt.getSkinColor(richTextView2).getPrimaryTextColor());
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final SelectCouponViewModel.PageState pageState6 = SelectCouponViewModel.PageState.this;
                                            RichTextViewKt.c(richTextView2, new Function1<cf, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponList.body.1.1.3.2.2
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(cf cfVar) {
                                                    cf cfVar2 = cfVar;
                                                    StringBuilder m3 = BotListCellKt$BotListCell$3$1$2$2$$ExternalSyntheticOutline0.m('\u00a5');
                                                    SelectCouponViewModel.PageData optPageData = SelectCouponViewModelKt.optPageData(SelectCouponViewModel.PageState.this);
                                                    m3.append(optPageData != null ? SCPUtilsKt.priceToStr(optPageData.discountPrice, true) : null);
                                                    cfVar2.text(m3.toString());
                                                    ce.fontSize$default(cfVar2, 13.0f, null, 2, null);
                                                    cfVar2.color(IPagerIdKtxKt.getSkinColor(richTextView2).getRedTextColor());
                                                    cfVar2.fontWeightBold();
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    SelectCouponViewModel.PageData optPageData = SelectCouponViewModelKt.optPageData(SelectCouponViewModel.PageState.this);
                                    boolean z16 = optPageData != null;
                                    if (!z16) {
                                        final SelectCouponList selectCouponList3 = selectCouponList2;
                                        w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponList.body.1.1.3.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar5) {
                                                v vVar6 = vVar5;
                                                vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponList.body.1.1.3.3.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        h hVar;
                                                        t tVar2 = tVar;
                                                        hVar = IPagerIdKtxKt.getSkinColor(tVar2).tokenColor("qecommerce_skin_color_btn_secondary_red_normal", false);
                                                        tVar2.mo113backgroundColor(hVar);
                                                        tVar2.borderRadius(4.0f);
                                                        tVar2.padding(5.0f, 10.0f, 5.0f, 10.0f);
                                                        tVar2.allCenter();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final SelectCouponList selectCouponList4 = SelectCouponList.this;
                                                vVar6.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponList.body.1.1.3.3.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(u uVar) {
                                                        final SelectCouponList selectCouponList5 = SelectCouponList.this;
                                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponList.body.1.1.3.3.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                SelectCouponList.this.emit("clickBestSelection", null);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponList.body.1.1.3.3.3
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponList.body.1.1.3.3.3.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                ce ceVar2 = ceVar;
                                                                ceVar2.text("\u4f7f\u7528\u6700\u4f73\u4f18\u60e0");
                                                                ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                                ceVar2.color(IPagerIdKtxKt.getSkinColor(ceVar2).getPrimaryTextColor());
                                                                ceVar2.fontWeightBold();
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
                        }
                        final SelectCouponViewModel.PageState pageState4 = SelectCouponViewModel.PageState.this;
                        final SelectCouponList selectCouponList3 = selectCouponList;
                        ar.a(vVar2, new Function1<aq<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponList.body.1.1.4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(aq<?, ?> aqVar) {
                                List<SelectCouponItemModel> list;
                                aq<?, ?> aqVar2 = aqVar;
                                aqVar2.attr(new Function1<ao, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponList.body.1.1.4.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ao aoVar) {
                                        ao aoVar2 = aoVar;
                                        aoVar2.showScrollerIndicator(false);
                                        aoVar2.m140flex(1.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                SelectCouponViewModel.PageData optPageData = SelectCouponViewModelKt.optPageData(SelectCouponViewModel.PageState.this);
                                if (optPageData != null && (list = optPageData.list) != null) {
                                    final SelectCouponList selectCouponList4 = selectCouponList3;
                                    for (final SelectCouponItemModel selectCouponItemModel : list) {
                                        if (selectCouponItemModel instanceof CouponItem) {
                                            aqVar2.addChild(new SelectCouponItemView(), new Function1<SelectCouponItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponList$body$1$1$4$2$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(SelectCouponItemView selectCouponItemView) {
                                                    SelectCouponItemView selectCouponItemView2 = selectCouponItemView;
                                                    final SelectCouponItemModel selectCouponItemModel2 = SelectCouponItemModel.this;
                                                    selectCouponItemView2.attr(new Function1<SelectCouponItemAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponList$body$1$1$4$2$1.1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(SelectCouponItemAttr selectCouponItemAttr) {
                                                            selectCouponItemAttr.couponItem = (CouponItem) SelectCouponItemModel.this;
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final SelectCouponItemModel selectCouponItemModel3 = SelectCouponItemModel.this;
                                                    final SelectCouponList selectCouponList5 = selectCouponList4;
                                                    selectCouponItemView2.event(new Function1<l, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponList$body$1$1$4$2$1.2
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(l lVar) {
                                                            final SelectCouponItemModel selectCouponItemModel4 = SelectCouponItemModel.this;
                                                            final SelectCouponList selectCouponList6 = selectCouponList5;
                                                            lVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponList.body.1.1.4.2.1.2.1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ClickParams clickParams) {
                                                                    CommonCouponItemModel commonCouponItemModel = ((CouponItem) SelectCouponItemModel.this).commonCouponItem;
                                                                    if (commonCouponItemModel.isEnabled) {
                                                                        selectCouponList6.emit("selectCoupon", commonCouponItemModel.f114301id);
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
                                        } else if (selectCouponItemModel instanceof TitleItem) {
                                            w.a(aqVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponList$body$1$1$4$2$2
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(v vVar3) {
                                                    v vVar4 = vVar3;
                                                    vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponList$body$1$1$4$2$2.1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(t tVar) {
                                                            t tVar2 = tVar;
                                                            tVar2.marginTop(17.0f);
                                                            tVar2.marginBottom(21.0f);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final SelectCouponItemModel selectCouponItemModel2 = SelectCouponItemModel.this;
                                                    cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponList$body$1$1$4$2$2.2
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(TextView textView) {
                                                            final SelectCouponItemModel selectCouponItemModel3 = SelectCouponItemModel.this;
                                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponList.body.1.1.4.2.2.2.1
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ce ceVar) {
                                                                    ce ceVar2 = ceVar;
                                                                    ceVar2.text(((TitleItem) SelectCouponItemModel.this).title);
                                                                    ce.fontSize$default(ceVar2, 13.0f, null, 2, null);
                                                                    ceVar2.color(IPagerIdKtxKt.getSkinColor(ceVar2).getPrimaryTextColor());
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
                                    }
                                }
                                if (SelectCouponViewModel.PageState.this instanceof SelectCouponViewModel.PageState.InitLoading) {
                                    SelectCouponItemSkeletonViewKt.SelectCouponItemSkeleton(aqVar2);
                                    SelectCouponItemSkeletonViewKt.SelectCouponItemSkeleton(aqVar2);
                                    SelectCouponItemSkeletonViewKt.SelectCouponItemSkeleton(aqVar2);
                                }
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
        return new SelectCouponAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new SelectCouponEvent();
    }
}
