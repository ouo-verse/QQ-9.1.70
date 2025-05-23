package com.tencent.hippykotlin.demo.pages.base;

import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.reactive.ReactiveObserver;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECCategoryView extends ComposeView<ECCategoryAttr, ECCategoryEvent> {
    public List<CategoryItemConfig> categoryItemConfigs;

    public ECCategoryView() {
        List<CategoryItemConfig> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.categoryItemConfigs = emptyList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ ECCategoryAttr access$getAttr(ECCategoryView eCCategoryView) {
        return (ECCategoryAttr) eCCategoryView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final ECCategoryAttr eCCategoryAttr = (ECCategoryAttr) getAttr();
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECCategoryView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECCategoryView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        mVar.flexDirectionRow().alignSelfStretch();
                        return Unit.INSTANCE;
                    }
                });
                final ECCategoryView eCCategoryView = ECCategoryView.this;
                final int i3 = 0;
                for (Object obj : eCCategoryView.categoryItemConfigs) {
                    int i16 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    final CategoryItemConfig categoryItemConfig = (CategoryItemConfig) obj;
                    new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECCategoryView$categoryItem$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                            final ECCategoryView eCCategoryView2 = ECCategoryView.this;
                            final CategoryItemConfig categoryItemConfig2 = categoryItemConfig;
                            final int i17 = i3;
                            w.a(viewContainer3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECCategoryView$categoryItem$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(v vVar) {
                                    v vVar2 = vVar;
                                    final ECCategoryView eCCategoryView3 = ECCategoryView.this;
                                    vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECCategoryView.categoryItem.1.1.1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(t tVar) {
                                            t tVar2 = tVar;
                                            tVar2.mo153width(ECCategoryView.access$getAttr(ECCategoryView.this).itemWidth());
                                            tVar2.flexDirectionColumn().alignItemsCenter().justifyContentCenter();
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final CategoryItemConfig categoryItemConfig3 = categoryItemConfig2;
                                    cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECCategoryView.categoryItem.1.1.2
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(TextView textView) {
                                            final CategoryItemConfig categoryItemConfig4 = CategoryItemConfig.this;
                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECCategoryView.categoryItem.1.1.2.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ce ceVar) {
                                                    ce ceVar2 = ceVar;
                                                    ce.fontSize$default(ceVar2.text(CategoryItemConfig.this.title).textAlignCenter(), CategoryItemConfig.this.itemStyle.fontSize, null, 2, null);
                                                    CategoryItemConfig categoryItemConfig5 = CategoryItemConfig.this;
                                                    if (((Boolean) categoryItemConfig5.isSelected$delegate.getValue(categoryItemConfig5, CategoryItemConfig.$$delegatedProperties[0])).booleanValue()) {
                                                        ItemStyle itemStyle = CategoryItemConfig.this.itemStyle;
                                                        h hVar = (h) itemStyle.selectedColor$delegate.getValue(itemStyle, ItemStyle.$$delegatedProperties[1]);
                                                        if (hVar == null) {
                                                            hVar = IPagerIdKtxKt.getSkinColor(ceVar2).getPrimaryTextColor();
                                                        }
                                                        ceVar2.color(hVar);
                                                        ceVar2.fontWeightBold();
                                                    } else {
                                                        ItemStyle itemStyle2 = CategoryItemConfig.this.itemStyle;
                                                        h hVar2 = (h) itemStyle2.color$delegate.getValue(itemStyle2, ItemStyle.$$delegatedProperties[0]);
                                                        if (hVar2 == null) {
                                                            hVar2 = IPagerIdKtxKt.getSkinColor(ceVar2).getPrimaryTextColor();
                                                        }
                                                        ceVar2.color(hVar2);
                                                        ceVar2.fontWeightNormal();
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final ECCategoryView eCCategoryView4 = ECCategoryView.this;
                                    final int i18 = i17;
                                    vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECCategoryView.categoryItem.1.1.3
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(u uVar) {
                                            final ECCategoryView eCCategoryView5 = ECCategoryView.this;
                                            final int i19 = i18;
                                            uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECCategoryView.categoryItem.1.1.3.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ClickParams clickParams) {
                                                    ECCategoryAttr access$getAttr = ECCategoryView.access$getAttr(ECCategoryView.this);
                                                    access$getAttr.currentIndex$delegate.setValue(access$getAttr, ECCategoryAttr.$$delegatedProperties[1], Integer.valueOf(i19));
                                                    ECCategoryAttr access$getAttr2 = ECCategoryView.access$getAttr(ECCategoryView.this);
                                                    int i26 = i19;
                                                    if (access$getAttr2.switchAutoMoveIndicator) {
                                                        access$getAttr2.indicatorPosition(access$getAttr2.itemWidth() * i26);
                                                    }
                                                    ECCategoryView.this.emit("clickCategorySwitch", Integer.valueOf(i19));
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
                    }.invoke(viewContainer2);
                    i3 = i16;
                }
                final ECCategoryAttr eCCategoryAttr2 = eCCategoryAttr;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECCategoryView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        final ECCategoryAttr eCCategoryAttr3 = ECCategoryAttr.this;
                        vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECCategoryView.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                h hVar = ECCategoryAttr.this.indicatorStyle.color;
                                if (hVar == null) {
                                    hVar = IPagerIdKtxKt.getSkinColor(tVar2).getPrimaryTextColor();
                                }
                                tVar2.mo113backgroundColor(hVar);
                                ECCategoryAttr.this.indicatorStyle.getClass();
                                Attr.absolutePosition$default(tVar2, 0.0f, 0.0f, 0.0f, 0.0f, 11, null);
                                ECCategoryAttr.this.indicatorStyle.getClass();
                                Attr mo153width = tVar2.mo153width(20.0f);
                                ECCategoryAttr.this.indicatorStyle.getClass();
                                mo153width.mo141height(3.0f);
                                tVar2.m142left(ECCategoryAttr.this.getIndicatorPosition());
                                if (ECCategoryAttr.this.indicatorAnimation) {
                                    tVar2.m134animation(b.Companion.l(b.INSTANCE, 0.2f, null, 2, null), (Object) Float.valueOf(ECCategoryAttr.this.getIndicatorPosition()));
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
        return new ECCategoryAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new ECCategoryEvent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        int collectionSizeOrDefault;
        super.created();
        List<String> list = ((ECCategoryAttr) getAttr()).itemTitles;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        int i3 = 0;
        for (Object obj : list) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            arrayList.add(new CategoryItemConfig((String) obj, ((ECCategoryAttr) getAttr()).itemStyle));
            i3 = i16;
        }
        this.categoryItemConfigs = arrayList;
        ReactiveObserver.Companion companion = ReactiveObserver.INSTANCE;
        ECCategoryAttr eCCategoryAttr = (ECCategoryAttr) getAttr();
        companion.b(Integer.valueOf(((Number) eCCategoryAttr.currentIndex$delegate.getValue(eCCategoryAttr, ECCategoryAttr.$$delegatedProperties[1])).intValue()), new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECCategoryView$created$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Boolean bool) {
                bool.booleanValue();
                ECCategoryView eCCategoryView = ECCategoryView.this;
                int i17 = 0;
                for (Object obj2 : eCCategoryView.categoryItemConfigs) {
                    int i18 = i17 + 1;
                    if (i17 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    CategoryItemConfig categoryItemConfig = (CategoryItemConfig) obj2;
                    ECCategoryAttr access$getAttr = ECCategoryView.access$getAttr(eCCategoryView);
                    boolean z16 = true;
                    if (i17 != ((Number) access$getAttr.currentIndex$delegate.getValue(access$getAttr, ECCategoryAttr.$$delegatedProperties[1])).intValue()) {
                        z16 = false;
                    }
                    categoryItemConfig.isSelected$delegate.setValue(categoryItemConfig, CategoryItemConfig.$$delegatedProperties[0], Boolean.valueOf(z16));
                    i17 = i18;
                }
                return Unit.INSTANCE;
            }
        });
    }
}
