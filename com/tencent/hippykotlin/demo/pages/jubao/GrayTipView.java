package com.tencent.hippykotlin.demo.pages.jubao;

import com.tencent.hippykotlin.demo.pages.base.EcommerceExtKt;
import com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.k;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.f;
import com.tencent.kuikly.core.views.h;
import com.tencent.kuikly.core.views.i;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GrayTipView extends ComposeView<k, l> {
    public Function1<? super Integer, Unit> onReportClickCallback;
    public final PageModel pageModel;

    public GrayTipView(PageModel pageModel) {
        this.pageModel = pageModel;
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.GrayTipView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final GrayTipView grayTipView = GrayTipView.this;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.GrayTipView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.flexDirectionColumn();
                        mVar2.alignItemsCenter();
                        e jubaoDTBaseParams = ConstantsKt.getJubaoDTBaseParams();
                        GrayTipView grayTipView2 = GrayTipView.this;
                        jubaoDTBaseParams.t("gray_tip_version", 1);
                        jubaoDTBaseParams.v("come_from", grayTipView2.pageModel.getPostData().src);
                        jubaoDTBaseParams.v("strategyid", grayTipView2.pageModel.getPostData().grayId);
                        Unit unit = Unit.INSTANCE;
                        EcommerceExtKt.elementVR(mVar2, "em_safe_quick_report", jubaoDTBaseParams);
                        return Unit.INSTANCE;
                    }
                });
                final GrayTipView grayTipView2 = GrayTipView.this;
                ConditionViewKt.c(viewContainer2, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.GrayTipView$body$1.2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(GrayTipView.this.pageModel.getGrayTipData() == null);
                    }
                }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.GrayTipView$body$1.3
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.GrayTipView.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.GrayTipView.body.1.3.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.mo141height(310.0f);
                                        tVar2.allCenter();
                                        return Unit.INSTANCE;
                                    }
                                });
                                i.a(vVar2, new Function1<h, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.GrayTipView.body.1.3.1.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(h hVar) {
                                        hVar.attr(new Function1<f, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.GrayTipView.body.1.3.1.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(f fVar) {
                                                f fVar2 = fVar;
                                                fVar2.h(true);
                                                fVar2.mo141height(20.0f);
                                                fVar2.mo153width(20.0f);
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
                final GrayTipView grayTipView3 = GrayTipView.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.GrayTipView$body$1.4
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(GrayTipView.this.pageModel.getGrayTipData() != null);
                    }
                };
                final GrayTipView grayTipView4 = GrayTipView.this;
                ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.GrayTipView$body$1.5
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        ConditionView conditionView2 = conditionView;
                        w.a(conditionView2, JubaoUtil$O3BgView$1.INSTANCE);
                        final float m3 = GrayTipView.this.getPagerData().m() - 40.0f;
                        if (m3 > 335.0f) {
                            m3 = 335.0f;
                        }
                        final GrayTipView grayTipView5 = GrayTipView.this;
                        w.a(conditionView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.GrayTipView.body.1.5.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.GrayTipView.body.1.5.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.absolutePosition(34.0f, 0.0f, 0.0f, 0.0f);
                                        tVar2.flexDirectionColumn();
                                        tVar2.alignItemsCenter();
                                        return Unit.INSTANCE;
                                    }
                                });
                                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.GrayTipView.body.1.5.1.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.GrayTipView.body.1.5.1.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ceVar2.text("\u98ce\u9669\u5f02\u5e38\u63d0\u9192");
                                                ce.fontSize$default(ceVar2, 18.0f, null, 2, null);
                                                ceVar2.color(JubaoThemeData.INSTANCE.getNavTitleTextColor());
                                                ceVar2.fontWeight500();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final float f16 = m3;
                                final GrayTipView grayTipView6 = grayTipView5;
                                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.GrayTipView.body.1.5.1.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        v vVar4 = vVar3;
                                        final float f17 = f16;
                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.GrayTipView.body.1.5.1.3.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.flexDirectionRow();
                                                tVar2.marginTop(20.0f);
                                                tVar2.mo153width(f17);
                                                tVar2.justifyContentCenter();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.GrayTipView.body.1.5.1.3.2
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ImageView imageView) {
                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.GrayTipView.body.1.5.1.3.2.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(af afVar) {
                                                        af afVar2 = afVar;
                                                        afVar2.mo153width(20.0f);
                                                        afVar2.mo141height(20.0f);
                                                        b.a.b(afVar2, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFAAAABQCAYAAACOEfKtAAAACXBIWXMAABYlAAAWJQFJUiTwAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAATvSURBVHgB7ZxfcuJGEMa/ESTY8Yv3BCEnyPgEZl9jkyUnMD6BnROsfYK1T2BygsW13n01voFusNwgPGSBTYEm3UKkXLvWaIRGQkjzq6KgSgKkT93zp6d7AIfD4XA4HNtBoESonjycA4dYoO0JHAZL+sx4GPNbI8Dkx0++jxKxVQFnp7KjBKSncKwUJF1N2+R7dNG+Aib08Yleo/0Hf4QtUbiALBr96xkJ0BMqsrCM0EOY0I0MPeC+9cEfokAKETB0zQUu6EYvbYkWi8CY/uNGNXG/P/THyJlcBSxUuG8hIaEwQBN/5SlkbgLOf5cXgcJV4cJ9iwg7oOv9D/4AOWBdwFlPtqkXvaOPHZSLEVnjuW1rtCpg1Ku+37rVxUHWSB3NnzY7Gg+W+Hoq39LbY2nFYxTa1Ky8n62u1QpWLHDele9oHHeJ3eKKxo/XyEhmAWcn8o5+pY9dRGBAncs5MpDJhUO33VXxGIX+lLwHGdhYQBYvIDfAjkNt9mWWNnEjF/7alT1ujFEtXm8yp04tYDjOW+KRezRUCBJiQtO/o7TjxPQuzIPkionHqFUY7S7l19IJOOvKPso3w7BJZ3oiUw3HjF24QNd9QkBBgJfwcIacHyC7cquJX8TQn5ic34Qh3gJn1Ou2kTMUif7c+vTyxJ88oMO+lifsytNFOCm4MjnfyIXZ+oJdHu+lpAEKwVEozuRcIwHFEr0qdhxxPLPCRIwEpB+8QM1oGN5zooBfaNBcJ+tbw1YYrt8k4Bmc8AY1hTq0s8Rzkk7g1TPUFArRJd67VkA24VIHSHPGxI2TLLCDmhMu+GtIEvAYjo7uoFZAgfq67xrh4Vfdca2A1AZozbcW0BBONyuJFfDfnnTiRcw1nhgr4HLh3Pd/FvETCWvrwlWGAinpLZBicm04QrxNXNhhRqyAQQNGEdlaoFYpxi8RK6CnnIAmxLtwM171usHJ7XHHYgWcw1ngGl1lgHZVbnYiP5tmzlcVmo35Pz34R3HH9XNhD6WqydgGIsETtQIGqzqMuqPVQG+BylkgOLdaQ2JmwrQr/65rVJrdd+/Bf6U7JzEzgX7knt4SF1dsQQs5g1ZM1uisKwfUqhd2LUIgMRk9eSqnYvJUasBiZTxaEgXkpEOuRUPdEBgfGJRDmKV2KNyiZqjA7J6NBJw3cVMrK+SCxR+S2z/GSMBXQ39SJysMlHmBonF+IFtha4mLvIc0dPHt2W9hJuz3KPyMvOFysIZ5x5kqyXzelZe00JyprqL0CJynqexMn6V/Kh9R3YwF3j7gdZovpA/pN3FeyQ6F64rp3pCS1AJy40rt4B+oGFwGu0kt8UaLSlFFT+ZKx7JAUafrTWuIM1VrTk/ljdjx9F8W7+DBv8KGZC53/XIiByaZnGWEx3sHH/0+MpB5XTi6gJ1zZwrV32YVj7GysL6/coGdEZHdltY5rFTYW910gjP66Ym8K2tWf7jDEY0gbG4VZTW1Iwz/NMAD0RHKx0g0cGR7n63cNt6JKjvfbtsaw0F/QC770b9BDuS69VO0CU+fNxsrWsjIXW/3KAhiWnm5CbkKuIaFVEv0wjFjzkIWJdyaQgR8Tlg6hlDMN7a3vwPH8QreS7BwAZ8TFbHw65grAoyT2hXGapU18cRr17XagDGJf3pSNtb52VGWLOcqhul2TYz3aK22CNd0OBwOh8NRdv4DQwSn4gKzBMoAAAAASUVORK5CYII=", false, 2, null);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final float f18 = f16;
                                        final GrayTipView grayTipView7 = grayTipView6;
                                        cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.GrayTipView.body.1.5.1.3.3
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                final float f19 = f18;
                                                final GrayTipView grayTipView8 = grayTipView7;
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.GrayTipView.body.1.5.1.3.3.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        com.tencent.kuikly.core.base.h hVar;
                                                        String str;
                                                        ce ceVar2 = ceVar;
                                                        ceVar2.m144maxWidth(f19 - 28);
                                                        ceVar2.marginLeft(8.0f);
                                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                        ceVar2.fontWeight400();
                                                        JubaoThemeData jubaoThemeData = JubaoThemeData.INSTANCE;
                                                        if (!VasUIToken.INSTANCE.isDarkMode()) {
                                                            hVar = new com.tencent.kuikly.core.base.h(4294396976L);
                                                        } else {
                                                            hVar = new com.tencent.kuikly.core.base.h(4294396976L);
                                                        }
                                                        ceVar2.color(hVar);
                                                        GrayTipData grayTipData = grayTipView8.pageModel.getGrayTipData();
                                                        if (grayTipData == null || (str = grayTipData.text) == null) {
                                                            str = "";
                                                        }
                                                        ceVar2.text(str);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.GrayTipView.body.1.5.1.4
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.GrayTipView.body.1.5.1.4.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.mo141height(1.0f);
                                                tVar2.mo153width(tVar2.getPagerData().m());
                                                tVar2.mo113backgroundColor(JubaoThemeData.INSTANCE.getPartingLineColor());
                                                tVar2.marginTop(20.0f);
                                                tVar2.marginBottom(20.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final float f17 = m3;
                                final GrayTipView grayTipView7 = grayTipView5;
                                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.GrayTipView.body.1.5.1.5
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        v vVar4 = vVar3;
                                        final float f18 = f17;
                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.GrayTipView.body.1.5.1.5.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.flexDirectionRow();
                                                tVar2.mo153width(f18);
                                                tVar2.alignItemsCenter();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final float f19 = f17;
                                        cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.GrayTipView.body.1.5.1.5.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                final float f26 = f19;
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.GrayTipView.body.1.5.1.5.2.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        ce ceVar2 = ceVar;
                                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                        ceVar2.fontWeight400();
                                                        ceVar2.color(JubaoThemeData.INSTANCE.getContentTextColor());
                                                        ceVar2.text("\u54a8\u8be2\u5b98\u65b9\u5b89\u5168\u52a9\u624b\uff0c\u4e86\u89e3\u5e76\u786e\u8ba4\u98ce\u9669\uff0c\u4fdd\u62a4\u4f60\u7684\u8d44\u91d1\u5b89\u5168");
                                                        ceVar2.mo153width((f26 - 91) - 18.5f);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final GrayTipView grayTipView8 = grayTipView7;
                                        w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.GrayTipView.body.1.5.1.5.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar5) {
                                                v vVar6 = vVar5;
                                                vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.GrayTipView.body.1.5.1.5.3.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.mo141height(36.0f);
                                                        tVar2.mo153width(91.0f);
                                                        tVar2.borderRadius(4.0f);
                                                        tVar2.m136border(new com.tencent.kuikly.core.base.e(1.0f, BorderStyle.SOLID, JubaoThemeData.INSTANCE.getConfirmBtnBgColor()));
                                                        tVar2.allCenter();
                                                        tVar2.marginLeft(18.5f);
                                                        e jubaoDTBaseParams = ConstantsKt.getJubaoDTBaseParams();
                                                        jubaoDTBaseParams.t("gray_tip_version", 1);
                                                        Unit unit = Unit.INSTANCE;
                                                        EcommerceExtKt.elementVR(tVar2, "em_safe_see_more_cases", jubaoDTBaseParams);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.GrayTipView.body.1.5.1.5.3.2
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.GrayTipView.body.1.5.1.5.3.2.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                ce ceVar2 = ceVar;
                                                                ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                                                ceVar2.fontWeight500();
                                                                ceVar2.color(JubaoThemeData.INSTANCE.getConfirmBtnBgColor());
                                                                ceVar2.text("\u4e86\u89e3\u98ce\u9669");
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final GrayTipView grayTipView9 = GrayTipView.this;
                                                vVar6.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.GrayTipView.body.1.5.1.5.3.3
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(u uVar) {
                                                        final GrayTipView grayTipView10 = GrayTipView.this;
                                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.GrayTipView.body.1.5.1.5.3.3.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                Function1<? super Integer, Unit> function1 = GrayTipView.this.onReportClickCallback;
                                                                if (function1 != null) {
                                                                    function1.invoke(0);
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
                                });
                                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.GrayTipView.body.1.5.1.6
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.GrayTipView.body.1.5.1.6.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.mo141height(1.0f);
                                                tVar2.mo153width(tVar2.getPagerData().m());
                                                tVar2.mo113backgroundColor(JubaoThemeData.INSTANCE.getPartingLineColor());
                                                tVar2.marginTop(20.0f);
                                                tVar2.marginBottom(20.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final float f18 = m3;
                                final GrayTipView grayTipView8 = grayTipView5;
                                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.GrayTipView.body.1.5.1.7
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        v vVar4 = vVar3;
                                        final float f19 = f18;
                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.GrayTipView.body.1.5.1.7.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.flexDirectionRow();
                                                tVar2.mo153width(f19);
                                                tVar2.alignItemsCenter();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final float f26 = f18;
                                        cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.GrayTipView.body.1.5.1.7.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                final float f27 = f26;
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.GrayTipView.body.1.5.1.7.2.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        ce ceVar2 = ceVar;
                                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                        ceVar2.fontWeight400();
                                                        ceVar2.color(JubaoThemeData.INSTANCE.getContentTextColor());
                                                        ceVar2.text("\u82e5\u5df2\u786e\u8ba4\u5bf9\u65b9\u5b58\u5728\u6b3a\u8bc8\u884c\u4e3a\uff0c\u53ef\u4e3e\u62a5\u5bf9\u65b9");
                                                        ceVar2.mo153width((f27 - 91) - 18.5f);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final GrayTipView grayTipView9 = grayTipView8;
                                        w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.GrayTipView.body.1.5.1.7.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar5) {
                                                v vVar6 = vVar5;
                                                vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.GrayTipView.body.1.5.1.7.3.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.mo141height(36.0f);
                                                        tVar2.mo153width(91.0f);
                                                        tVar2.mo113backgroundColor(JubaoThemeData.INSTANCE.getConfirmBtnBgColor());
                                                        tVar2.allCenter();
                                                        tVar2.borderRadius(4.0f);
                                                        tVar2.marginLeft(18.5f);
                                                        e jubaoDTBaseParams = ConstantsKt.getJubaoDTBaseParams();
                                                        jubaoDTBaseParams.t("gray_tip_version", 1);
                                                        Unit unit = Unit.INSTANCE;
                                                        EcommerceExtKt.elementVR(tVar2, "em_safe_report_immediately", jubaoDTBaseParams);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.GrayTipView.body.1.5.1.7.3.2
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.GrayTipView.body.1.5.1.7.3.2.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                ce ceVar2 = ceVar;
                                                                ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                                                ceVar2.fontWeight500();
                                                                ceVar2.color(JubaoThemeData.INSTANCE.getConfirmBtnTextColor());
                                                                ceVar2.text("\u7acb\u5373\u4e3e\u62a5");
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final GrayTipView grayTipView10 = GrayTipView.this;
                                                vVar6.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.GrayTipView.body.1.5.1.7.3.3
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(u uVar) {
                                                        final GrayTipView grayTipView11 = GrayTipView.this;
                                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.GrayTipView.body.1.5.1.7.3.3.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                Function1<? super Integer, Unit> function1 = GrayTipView.this.onReportClickCallback;
                                                                if (function1 != null) {
                                                                    function1.invoke(1);
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
        return new k();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}
