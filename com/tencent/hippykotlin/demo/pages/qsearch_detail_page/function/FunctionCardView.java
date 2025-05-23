package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.function;

import com.tencent.hippykotlin.demo.pages.base.QUISkinColor;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.module.QQSearchModule;
import com.tencent.hippykotlin.demo.pages.foundation.extension.FontModuleExtKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseSingleItemView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.HighlightAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.HighlightTextView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.HighlightTextViewKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
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
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class FunctionCardView extends QSearchBaseSingleItemView<QSearchFunctionItemAttr, QSearchFunctionItemEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QSearchFunctionItemAttr access$getAttr(FunctionCardView functionCardView) {
        return (QSearchFunctionItemAttr) functionCardView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.function.FunctionCardView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final FunctionCardView functionCardView = FunctionCardView.this;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.function.FunctionCardView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.function.FunctionCardView.body.1.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                tVar.padding(8.0f, 8.0f, 0.0f, 8.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        final FunctionCardView functionCardView2 = FunctionCardView.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.function.FunctionCardView.body.1.1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.function.FunctionCardView.body.1.1.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.paddingLeft(16.0f);
                                        tVar2.paddingRight(16.0f);
                                        tVar2.mo113backgroundColor(QUISkinColor.INSTANCE.wrapColor("fill_light_secondary"));
                                        tVar2.borderRadius(8.0f, 8.0f, 8.0f, 8.0f);
                                        tVar2.flexDirectionColumn();
                                        return Unit.INSTANCE;
                                    }
                                });
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.function.FunctionCardView.body.1.1.2.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        v vVar6 = vVar5;
                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.function.FunctionCardView.body.1.1.2.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.mo141height(FontModuleExtKt.qqFontScaleAddSize(17.0f) + 49.0f);
                                                tVar2.flexDirectionRow();
                                                tVar2.alignItemsCenter();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.function.FunctionCardView.body.1.1.2.2.2
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.function.FunctionCardView.body.1.1.2.2.2.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        ce ceVar2 = ceVar;
                                                        ceVar2.m144maxWidth(150.0f);
                                                        ceVar2.lines(1);
                                                        ceVar2.text("\u6700\u8fd1\u4f7f\u7528\u8fc7");
                                                        ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                                        ceVar2.fontWeight400();
                                                        ceVar2.color(QUISkinColor.INSTANCE.wrapColor("text_primary"));
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.function.FunctionCardView.body.1.1.2.3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        vVar5.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.function.FunctionCardView.body.1.1.2.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.size(tVar2.getPagerData().m() - 28.0f, 0.5f);
                                                tVar2.mo113backgroundColor(QUISkinColor.INSTANCE.wrapColor("border_standard"));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final FunctionCardView functionCardView3 = FunctionCardView.this;
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.function.FunctionCardView.body.1.1.2.4
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        v vVar6 = vVar5;
                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.function.FunctionCardView.body.1.1.2.4.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.marginTop(6.0f);
                                                tVar2.paddingBottom(13.0f);
                                                tVar2.flexDirectionRow();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final FunctionCardView functionCardView4 = FunctionCardView.this;
                                        ah.a(vVar6, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.function.FunctionCardView.body.1.1.2.4.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ImageView imageView) {
                                                final FunctionCardView functionCardView5 = FunctionCardView.this;
                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.function.FunctionCardView.body.1.1.2.4.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(af afVar) {
                                                        af afVar2 = afVar;
                                                        afVar2.marginTop(10.0f);
                                                        afVar2.size(52.0f, 52.0f);
                                                        QSearchFunctionItemAttr access$getAttr = FunctionCardView.access$getAttr(FunctionCardView.this);
                                                        b.a.b(afVar2, (String) access$getAttr.imageUrl$delegate.getValue(access$getAttr, QSearchFunctionItemAttr.$$delegatedProperties[1]), false, 2, null);
                                                        afVar2.borderRadius(26.0f);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final FunctionCardView functionCardView5 = FunctionCardView.this;
                                        w.a(vVar6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.function.FunctionCardView.body.1.1.2.4.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar7) {
                                                v vVar8 = vVar7;
                                                vVar8.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.function.FunctionCardView.body.1.1.2.4.3.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.m140flex(1.0f);
                                                        tVar2.marginLeft(12.0f);
                                                        tVar2.alignSelfCenter();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final FunctionCardView functionCardView6 = FunctionCardView.this;
                                                HighlightTextViewKt.HighlightText(vVar8, new Function1<HighlightTextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.function.FunctionCardView.body.1.1.2.4.3.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(HighlightTextView highlightTextView) {
                                                        final FunctionCardView functionCardView7 = FunctionCardView.this;
                                                        highlightTextView.attr(new Function1<HighlightAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.function.FunctionCardView.body.1.1.2.4.3.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(HighlightAttr highlightAttr) {
                                                                HighlightAttr highlightAttr2 = highlightAttr;
                                                                highlightAttr2.mo141height(FontModuleExtKt.qqFontScaleAddSize(17.0f) + 52.0f);
                                                                highlightAttr2.marginTop(10.0f);
                                                                highlightAttr2.justifyContentCenter();
                                                                QSearchFunctionItemAttr access$getAttr = FunctionCardView.access$getAttr(FunctionCardView.this);
                                                                ReadWriteProperty readWriteProperty = access$getAttr.text$delegate;
                                                                KProperty<?>[] kPropertyArr = QSearchFunctionItemAttr.$$delegatedProperties;
                                                                highlightAttr2.text = (String) readWriteProperty.getValue(access$getAttr, kPropertyArr[0]);
                                                                QSearchFunctionItemAttr access$getAttr2 = FunctionCardView.access$getAttr(FunctionCardView.this);
                                                                highlightAttr2.highlightText = (String) access$getAttr2.text$delegate.getValue(access$getAttr2, kPropertyArr[0]);
                                                                highlightAttr2.fontSize = 17.0f;
                                                                highlightAttr2.isIgnoreCase = true;
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
                                return Unit.INSTANCE;
                            }
                        });
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.function.FunctionCardView.body.1.1.3
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.function.FunctionCardView.body.1.1.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        QQSearchModule qqSearchModule = Utils.INSTANCE.qqSearchModule();
                                        String p16 = c.f117352a.g().getPageData().n().p("func_payload");
                                        qqSearchModule.getClass();
                                        e eVar = new e();
                                        eVar.v("funcPayload", p16);
                                        qqSearchModule.callNativeMethod("openLastFunction", eVar, null);
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
        return new QSearchFunctionItemAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new QSearchFunctionItemEvent();
    }
}
