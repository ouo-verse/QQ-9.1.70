package com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view;

import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.directives.BindDirectivesView;
import com.tencent.kuikly.core.directives.BindDirectivesViewKt;
import com.tencent.kuikly.core.layout.FlexNode;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MyCouponCategoryView extends ComposeView<CategoryAttr, CategoryEvent> {
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponCategoryView$body$1
            {
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final MyCouponCategoryView myCouponCategoryView = MyCouponCategoryView.this;
                final CategoryAttr categoryAttr = (CategoryAttr) myCouponCategoryView.getViewAttr();
                FlexNode flexNode = categoryAttr.getFlexNode();
                final float K = flexNode != null ? flexNode.K() : 0.0f;
                w.a(myCouponCategoryView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponCategoryView$bodyWithCategories$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final CategoryAttr categoryAttr2 = categoryAttr;
                        final float f16 = K;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponCategoryView$bodyWithCategories$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                FlexNode flexNode2 = CategoryAttr.this.getFlexNode();
                                tVar2.mo153width(flexNode2 != null ? flexNode2.U() : 0.0f);
                                tVar2.mo141height(f16);
                                tVar2.flexDirectionRow();
                                return Unit.INSTANCE;
                            }
                        });
                        List<? extends CategoryItemConfig> list = ((CategoryAttr) MyCouponCategoryView.this.getViewAttr()).items;
                        final CategoryAttr categoryAttr3 = categoryAttr;
                        final float f17 = K;
                        final MyCouponCategoryView myCouponCategoryView2 = MyCouponCategoryView.this;
                        final int i3 = 0;
                        for (Object obj : list) {
                            int i16 = i3 + 1;
                            if (i3 < 0) {
                                CollectionsKt__CollectionsKt.throwIndexOverflow();
                            }
                            final CategoryItemConfig categoryItemConfig = (CategoryItemConfig) obj;
                            w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponCategoryView$bodyWithCategories$1$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(v vVar3) {
                                    v vVar4 = vVar3;
                                    final CategoryAttr categoryAttr4 = CategoryAttr.this;
                                    final float f18 = f17;
                                    vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponCategoryView$bodyWithCategories$1$2$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(t tVar) {
                                            tVar.mo153width(CategoryAttr.this.itemWidth()).mo141height(f18);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final CategoryItemConfig categoryItemConfig2 = categoryItemConfig;
                                    Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponCategoryView$bodyWithCategories$1$2$1.2
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            CategoryItemConfig categoryItemConfig3 = CategoryItemConfig.this;
                                            return Boolean.valueOf(((Boolean) categoryItemConfig3.isChoose$delegate.getValue(categoryItemConfig3, CategoryItemConfig.$$delegatedProperties[1])).booleanValue());
                                        }
                                    };
                                    final CategoryItemConfig categoryItemConfig3 = categoryItemConfig;
                                    final CategoryAttr categoryAttr5 = CategoryAttr.this;
                                    BindDirectivesViewKt.a(vVar4, function0, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponCategoryView$bodyWithCategories$1$2$1.3
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(BindDirectivesView bindDirectivesView) {
                                            final CategoryItemConfig categoryItemConfig4 = CategoryItemConfig.this;
                                            final CategoryAttr categoryAttr6 = categoryAttr5;
                                            cg.a(bindDirectivesView, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponCategoryView.bodyWithCategories.1.2.1.3.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(TextView textView) {
                                                    final CategoryItemConfig categoryItemConfig5 = CategoryItemConfig.this;
                                                    final CategoryAttr categoryAttr7 = categoryAttr6;
                                                    textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponCategoryView.bodyWithCategories.1.2.1.3.1.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ce ceVar) {
                                                            ce ceVar2 = ceVar;
                                                            Attr.absolutePosition$default(ceVar2, 11.0f, 0.0f, 0.0f, 0.0f, 4, null);
                                                            ceVar2.color(CategoryItemConfig.this.itemTextColor);
                                                            CategoryItemConfig categoryItemConfig6 = CategoryItemConfig.this;
                                                            ReadWriteProperty readWriteProperty = categoryItemConfig6.itemText$delegate;
                                                            KProperty<?>[] kPropertyArr = CategoryItemConfig.$$delegatedProperties;
                                                            ce.fontSize$default(ceVar2.value((String) readWriteProperty.getValue(categoryItemConfig6, kPropertyArr[0])).textAlignCenter(), 16.0f, null, 2, null);
                                                            CategoryItemConfig categoryItemConfig7 = CategoryItemConfig.this;
                                                            if (((Boolean) categoryItemConfig7.isChoose$delegate.getValue(categoryItemConfig7, kPropertyArr[1])).booleanValue()) {
                                                                CategoryAttr categoryAttr8 = categoryAttr7;
                                                                if (((Boolean) categoryAttr8.fontChangeEnable$delegate.getValue(categoryAttr8, CategoryAttr.$$delegatedProperties[1])).booleanValue()) {
                                                                    ceVar2.fontWeightBold();
                                                                    return Unit.INSTANCE;
                                                                }
                                                            }
                                                            ceVar2.fontWeightNormal();
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final CategoryAttr categoryAttr6 = CategoryAttr.this;
                                    final int i17 = i3;
                                    final MyCouponCategoryView myCouponCategoryView3 = myCouponCategoryView2;
                                    vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponCategoryView$bodyWithCategories$1$2$1.4
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(u uVar) {
                                            final CategoryAttr categoryAttr7 = CategoryAttr.this;
                                            final int i18 = i17;
                                            final MyCouponCategoryView myCouponCategoryView4 = myCouponCategoryView3;
                                            uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponCategoryView.bodyWithCategories.1.2.1.4.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ClickParams clickParams) {
                                                    CategoryAttr.this.index(i18);
                                                    myCouponCategoryView4.emit("clickTabSwitch", Integer.valueOf(i18));
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                            i3 = i16;
                        }
                        return Unit.INSTANCE;
                    }
                });
                MyCouponCategoryView myCouponCategoryView2 = MyCouponCategoryView.this;
                final CategoryAttr categoryAttr2 = (CategoryAttr) myCouponCategoryView2.getViewAttr();
                w.a(myCouponCategoryView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponCategoryView$bodyWithIndicator$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        final CategoryAttr categoryAttr3 = CategoryAttr.this;
                        vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponCategoryView$bodyWithIndicator$1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.mo113backgroundColor(CategoryAttr.this.indicatorColor);
                                Attr.absolutePosition$default(tVar2, 0.0f, 0.0f, 2.0f, 0.0f, 11, null);
                                tVar2.mo153width(CategoryAttr.this.indicatorWidth).mo141height(CategoryAttr.this.indicatorHeight);
                                CategoryAttr categoryAttr4 = CategoryAttr.this;
                                tVar2.m142left(((Number) categoryAttr4.indicatorPositio$delegate.getValue(categoryAttr4, CategoryAttr.$$delegatedProperties[0])).floatValue());
                                tVar2.m134animation(b.Companion.l(b.INSTANCE, 0.1f, null, 2, null), (Object) Boolean.TRUE);
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
        return new CategoryAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new CategoryEvent();
    }
}
