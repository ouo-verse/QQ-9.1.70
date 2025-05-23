package com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar;

import com.tencent.hippykotlin.demo.pages.base.extension.AttrExtKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.layout.FlexJustifyContent;
import com.tencent.kuikly.core.views.ImageEvent;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GoodsCenterSearchBarForAndroid extends ComposeView<SearchBarForAndroidAttr, SearchBarForAndroidEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final SearchBarForAndroidAttr searchBarForAndroidAttr = (SearchBarForAndroidAttr) getAttr();
        final SearchBarForAndroidEvent searchBarForAndroidEvent = (SearchBarForAndroidEvent) getEvent();
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterSearchBarForAndroid$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterSearchBarForAndroid$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.alignItemsCenter();
                        mVar2.flexDirectionRow();
                        mVar2.justifyContentSpaceBetween();
                        return Unit.INSTANCE;
                    }
                });
                final SearchBarForAndroidEvent searchBarForAndroidEvent2 = SearchBarForAndroidEvent.this;
                final SearchBarForAndroidAttr searchBarForAndroidAttr2 = searchBarForAndroidAttr;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterSearchBarForAndroid$body$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterSearchBarForAndroid.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.m140flex(1.0f);
                                tVar2.mo141height(36.0f);
                                tVar2.flexDirectionRow();
                                tVar2.justifyContent(FlexJustifyContent.FLEX_START);
                                tVar2.alignItemsCenter();
                                return Unit.INSTANCE;
                            }
                        });
                        final SearchBarForAndroidEvent searchBarForAndroidEvent3 = SearchBarForAndroidEvent.this;
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterSearchBarForAndroid.body.1.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                final SearchBarForAndroidEvent searchBarForAndroidEvent4 = SearchBarForAndroidEvent.this;
                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterSearchBarForAndroid.body.1.2.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        SearchBarForAndroidEvent.this.tapSearchBarCallback.invoke();
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterSearchBarForAndroid.body.1.2.3
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterSearchBarForAndroid.body.1.2.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        af afVar2 = afVar;
                                        afVar2.marginLeft(10.0f);
                                        b.a.b(afVar2, "qecommerce_skin_icon_general_search_secondary", false, 2, null);
                                        afVar2.size(16.0f, 16.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final SearchBarForAndroidAttr searchBarForAndroidAttr3 = searchBarForAndroidAttr2;
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterSearchBarForAndroid.body.1.2.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final SearchBarForAndroidAttr searchBarForAndroidAttr4 = SearchBarForAndroidAttr.this;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterSearchBarForAndroid.body.1.2.4.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ceVar2.marginLeft(4.0f);
                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                        ceVar2.lineHeight(20.0f);
                                        AttrExtKt.colorToken(ceVar2, "qecommerce_skin_color_text_primary");
                                        SearchBarForAndroidAttr searchBarForAndroidAttr5 = SearchBarForAndroidAttr.this;
                                        ceVar2.text((String) searchBarForAndroidAttr5.searchTxt$delegate.getValue(searchBarForAndroidAttr5, SearchBarForAndroidAttr.$$delegatedProperties[0]));
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final SearchBarForAndroidEvent searchBarForAndroidEvent3 = SearchBarForAndroidEvent.this;
                ah.a(viewContainer2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterSearchBarForAndroid$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ImageView imageView) {
                        ImageView imageView2 = imageView;
                        imageView2.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterSearchBarForAndroid.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(af afVar) {
                                af afVar2 = afVar;
                                b.a.b(afVar2, "qecommerce_skin_icon_general_close_solid_light", false, 2, null);
                                afVar2.size(16.0f, 16.0f);
                                afVar2.marginRight(16.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        final SearchBarForAndroidEvent searchBarForAndroidEvent4 = SearchBarForAndroidEvent.this;
                        imageView2.event(new Function1<ImageEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterSearchBarForAndroid.body.1.3.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageEvent imageEvent) {
                                final SearchBarForAndroidEvent searchBarForAndroidEvent5 = SearchBarForAndroidEvent.this;
                                imageEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterSearchBarForAndroid.body.1.3.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        SearchBarForAndroidEvent.this.tapClearIconCallback.invoke();
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
        return new SearchBarForAndroidAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new SearchBarForAndroidEvent();
    }
}
