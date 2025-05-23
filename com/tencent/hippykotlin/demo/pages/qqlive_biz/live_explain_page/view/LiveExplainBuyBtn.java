package com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view;

import com.tencent.hippykotlin.demo.pages.foundation.view.APNGAttr;
import com.tencent.hippykotlin.demo.pages.foundation.view.APNGVView;
import com.tencent.hippykotlin.demo.pages.foundation.view.APNGViewKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.b;
import com.tencent.kuikly.core.base.event.AnimationCompletionParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.base.u;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.RichTextAttr;
import com.tencent.kuikly.core.views.RichTextView;
import com.tencent.kuikly.core.views.RichTextViewKt;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cf;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class LiveExplainBuyBtn extends ComposeView<LiveExplainBuyBtnAttr, l> {
    public final LiveExplainBuyBtnAttr viewAttr = new LiveExplainBuyBtnAttr();

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ LiveExplainBuyBtnAttr access$getAttr(LiveExplainBuyBtn liveExplainBuyBtn) {
        return (LiveExplainBuyBtnAttr) liveExplainBuyBtn.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBuyBtn$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final LiveExplainBuyBtn liveExplainBuyBtn = LiveExplainBuyBtn.this;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBuyBtn$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.marginLeft(4.0f).marginRight(4.0f).marginTop(6.0f);
                        LiveExplainBuyBtnAttr liveExplainBuyBtnAttr = LiveExplainBuyBtn.this.viewAttr;
                        ReadWriteProperty readWriteProperty = liveExplainBuyBtnAttr.explainState$delegate;
                        KProperty<?>[] kPropertyArr = LiveExplainBuyBtnAttr.$$delegatedProperties;
                        if (((ExplainState) readWriteProperty.getValue(liveExplainBuyBtnAttr, kPropertyArr[0])) == ExplainState.EXPLAINING) {
                            mVar2.mo135backgroundLinearGradient(Direction.TO_RIGHT, new j(new h(4294919840L), 0.0f), new j(new h(4294914901L), 1.0f));
                        } else {
                            mVar2.mo135backgroundLinearGradient(Direction.TO_RIGHT, new j(new h(4294947544L), 0.0f), new j(new h(4294941098L), 1.0f));
                        }
                        mVar2.borderRadius(2.0f);
                        mVar2.flexDirectionRow().alignItemsCenter();
                        LiveExplainBuyBtnAttr liveExplainBuyBtnAttr2 = LiveExplainBuyBtn.this.viewAttr;
                        if (((Boolean) liveExplainBuyBtnAttr2.appearAnimated$delegate.getValue(liveExplainBuyBtnAttr2, kPropertyArr[4])).booleanValue()) {
                            mVar2.transform(new u(1.03f, 1.03f));
                        } else {
                            mVar2.transform(new u(1.0f, 1.0f));
                        }
                        b n3 = b.Companion.n(b.INSTANCE, 0.3f, 0.8f, 0.7f, null, 8, null);
                        LiveExplainBuyBtnAttr liveExplainBuyBtnAttr3 = LiveExplainBuyBtn.this.viewAttr;
                        mVar2.m134animation(n3, (Object) Boolean.valueOf(((Boolean) liveExplainBuyBtnAttr3.appearAnimated$delegate.getValue(liveExplainBuyBtnAttr3, kPropertyArr[4])).booleanValue()));
                        return Unit.INSTANCE;
                    }
                });
                final LiveExplainBuyBtn liveExplainBuyBtn2 = LiveExplainBuyBtn.this;
                viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBuyBtn$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Event event) {
                        final LiveExplainBuyBtn liveExplainBuyBtn3 = LiveExplainBuyBtn.this;
                        event.animationCompletion(new Function1<AnimationCompletionParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBuyBtn.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(AnimationCompletionParams animationCompletionParams) {
                                LiveExplainBuyBtnAttr liveExplainBuyBtnAttr = LiveExplainBuyBtn.this.viewAttr;
                                liveExplainBuyBtnAttr.appearAnimated$delegate.setValue(liveExplainBuyBtnAttr, LiveExplainBuyBtnAttr.$$delegatedProperties[4], Boolean.FALSE);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final LiveExplainBuyBtn liveExplainBuyBtn3 = LiveExplainBuyBtn.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBuyBtn$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBuyBtn.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                tVar.marginLeft(6.0f).mo153width(68.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        final LiveExplainBuyBtn liveExplainBuyBtn4 = LiveExplainBuyBtn.this;
                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBuyBtn.body.1.3.2
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                LiveExplainBuyBtnAttr access$getAttr = LiveExplainBuyBtn.access$getAttr(LiveExplainBuyBtn.this);
                                return Boolean.valueOf(((String) access$getAttr.buyBtnActivityTxt$delegate.getValue(access$getAttr, LiveExplainBuyBtnAttr.$$delegatedProperties[3])).length() > 0);
                            }
                        };
                        final LiveExplainBuyBtn liveExplainBuyBtn5 = LiveExplainBuyBtn.this;
                        ConditionViewKt.c(vVar2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBuyBtn.body.1.3.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                final LiveExplainBuyBtn liveExplainBuyBtn6 = LiveExplainBuyBtn.this;
                                cg.a(conditionView, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBuyBtn.body.1.3.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final LiveExplainBuyBtn liveExplainBuyBtn7 = LiveExplainBuyBtn.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBuyBtn.body.1.3.3.1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ce.fontSize$default(ceVar2, 8.0f, null, 2, null).color(h.INSTANCE.m()).lines(1).textOverFlowTail().mo141height(8.0f);
                                                LiveExplainBuyBtnAttr access$getAttr = LiveExplainBuyBtn.access$getAttr(LiveExplainBuyBtn.this);
                                                ceVar2.value((String) access$getAttr.buyBtnActivityTxt$delegate.getValue(access$getAttr, LiveExplainBuyBtnAttr.$$delegatedProperties[3]));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final LiveExplainBuyBtn liveExplainBuyBtn6 = LiveExplainBuyBtn.this;
                        RichTextViewKt.b(vVar2, new Function1<RichTextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBuyBtn.body.1.3.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(RichTextView richTextView) {
                                RichTextView richTextView2 = richTextView;
                                richTextView2.attr(new Function1<RichTextAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBuyBtn.body.1.3.4.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(RichTextAttr richTextAttr) {
                                        RichTextAttr richTextAttr2 = richTextAttr;
                                        richTextAttr2.mo153width(68.0f).marginTop(1.0f);
                                        richTextAttr2.lines(1);
                                        return Unit.INSTANCE;
                                    }
                                });
                                RichTextViewKt.c(richTextView2, new Function1<cf, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBuyBtn.body.1.3.4.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(cf cfVar) {
                                        cf cfVar2 = cfVar;
                                        ce.fontSize$default(cfVar2, 10.0f, null, 2, null).fontFamily("Qvideo Digit").color(h.INSTANCE.m()).fontWeightBold();
                                        cfVar2.text("\u00a5");
                                        return Unit.INSTANCE;
                                    }
                                });
                                final LiveExplainBuyBtn liveExplainBuyBtn7 = LiveExplainBuyBtn.this;
                                RichTextViewKt.c(richTextView2, new Function1<cf, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBuyBtn.body.1.3.4.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(cf cfVar) {
                                        cf cfVar2 = cfVar;
                                        ce.fontSize$default(cfVar2, 14.0f, null, 2, null).fontFamily("Qvideo Digit").color(h.INSTANCE.m()).fontWeightBold().marginTop(2.0f);
                                        LiveExplainBuyBtnAttr access$getAttr = LiveExplainBuyBtn.access$getAttr(LiveExplainBuyBtn.this);
                                        cfVar2.value((String) access$getAttr.goodsPriceStr$delegate.getValue(access$getAttr, LiveExplainBuyBtnAttr.$$delegatedProperties[1]));
                                        return Unit.INSTANCE;
                                    }
                                });
                                final LiveExplainBuyBtn liveExplainBuyBtn8 = LiveExplainBuyBtn.this;
                                RichTextViewKt.c(richTextView2, new Function1<cf, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBuyBtn.body.1.3.4.4
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(cf cfVar) {
                                        cf cfVar2 = cfVar;
                                        ce.fontSize$default(cfVar2, 8.0f, null, 2, null).color(h.INSTANCE.m()).fontWeightMedium();
                                        LiveExplainBuyBtnAttr access$getAttr = LiveExplainBuyBtn.access$getAttr(LiveExplainBuyBtn.this);
                                        cfVar2.value((String) access$getAttr.pricesSuffix$delegate.getValue(access$getAttr, LiveExplainBuyBtnAttr.$$delegatedProperties[2]));
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBuyBtn$body$1.4
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBuyBtn.body.1.4.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.positionAbsolute().m149right(0.0f).m150top(0.0f).m138bottom(0.0f).mo153width(39.0f);
                                tVar2.justifyContentCenter().alignItemsFlexEnd();
                                return Unit.INSTANCE;
                            }
                        });
                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBuyBtn.body.1.4.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBuyBtn.body.1.4.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        af afVar2 = afVar;
                                        afVar2.absolutePosition(0.0f, 0.0f, 0.0f, 0.0f);
                                        b.a.b(afVar2, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFAAAABECAMAAAAhiEISAAAA/1BMVEUAAAD/ipn/V2z/fI3/m6f/RFv/b4H/Z3n/SF//UGX/a33/TWL/j5z/oaz/ucH/x87/OFD/XXD/YHP/PFT/P1f/c4T/gZD/eIn/YnX/lqL/kqD/rLb/VGj/pbD/dof/K0T/qbP/MUr/sLr/g5L/hpX/NEz/hZT/s73/vsb/w8v/VGj/Wm7/xs//YHP/ZXf/5uj/0Nb/anz/iJb/zNT/mKT/gI//0tn/kJ3/n6r/prD/rbf/usP/xcv/zNL/09f/c4P/eYn/s73/zNL/y8v/t8D/1Nn/wcj/v8f/u8P/xsz/nKn/3OH/xs3/XXL/qrX/qrX/1tz/Umf/V2v/boD/O1Pws1ZOAAAAVHRSTlMAgcGSatujrtXLqc96Y0Uz6ru35eCejJezcXVUxl6b+1nzT4mG74dLPTj++RHy7F0658Yntc9Cva2lno2DeVPd1pdmCH9wcGJYHYZnUB6McUnu3tKCSDjMAAADyElEQVRYw63Yi1raQBAFYC4K3gBFFLmpKLdooNi0UFCpAgJSvPf9n6WThfVIJtmNfp0H+L/Z2bMTNKCo+2632+l0flH9sKvdbn+36yfVzc3Nb6oLqkajXq+fU52dJR8CqipMK6f7++FwOn24F4lENjai0YOD5M5OKBTKr69vbq6tra6mUru729vb5WLxiOrvi0o0b0slAYYJ3PMAVwEKMaQAjcdgqbIMkphMCtAW12SLAI9eFOBwChBnJpDEvOPMZSmeeXvWbTAYpCGGMUTVmfXgZEpgiUCq/wGal+Qtzpz+MEQJ5gEuhlhUg/HHLQGeLoYIUIjsVso6cLj1EUwLELeCM/sFE49ZAkmU0dYlUQeOp1nRIot2lIMpBYgryQBEEhFtAbIheoOTIYFSBIgzI9r+wGEmk5Ut+oy2EkwAZAvHdYi7GnD0tEIiguNzPxS9QPNqRYCyRQxRGW1vcPbEQR5tPkSAvEESs/LM+iWbUoOJkRJEEh1nBsiuJAYQz3lPDlGVxHMX7/46RiCG6PtL5QXOxgIULQbdlizOjCEqQJManIMZth+8QCTRBWyOCgR6DhHBIZAN0Q3sFwiMoUP+nBFtP6A1OiZRgPw56/cDB3tjAaqj7TlEDpp3xwCxH5TRBljmYKufEyCJiufMz+wJ9ie5YzZE318qDlr9HMAv7IeyE+xNbJAFx+eS5aDZP8mR6AHyT19IBzYnJyd2iwCF6P9HmATRIEDsBxmctGcS8Zupvnwl4yqBbIh+lywHe7NqdXmIWT5EIeJWVKA5jlfRIrsVth/QIoa4BDZn8TgDnTsxonrOy+CgF1+AOR5t/XPmoCVADNFzP+DMaNENfCZPDrGA4GyRCJANEWd2gvfUoBBdh1jh+0EHNlu1dzCn2Q/ePzwBDp5rBOJWeLSVSeSg9WxIkD3noH6IEmxgVTepQ7twK19YsgDNllGTZ0aH7Mxp3RDfQaOZINFxzTG/0ebgoJUAiFtxGWJaNUSAVnMO2iSBLIm+/xxoyAYNAg3cCsAVgD4+9xI0qUHRIgcz+iWbl7cC0DAEaLjeCoHKJObRogTNlu3hVlyjrU8iQLoSUTUj7pLEz0Q7JcDBwjPYEB2/ZE8BRjySeCEW1xxkSURwXKKN/UCiAzTIki3yIQLkSeRL9kJmhp+Z30pFmUSAFjpkz1m/ZDk4EB6GqPv08b8jkUQCcSUASfTY2vPgHCqeM4HgXM782Wi/RgImTowW/e6HqACRxNe3h4DV6n37WH+o7qiu7bqy69KuW6ouVYdq8S/UNvsX6lvkIfAPYsJOxCVuYBsAAAAASUVORK5CYII=", false, 2, null);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBuyBtn.body.1.4.3
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBuyBtn.body.1.4.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        af afVar2 = afVar;
                                        afVar2.marginRight(4.0f).size(24.0f, 24.0f);
                                        b.a.b(afVar2, "https://vfiles.gtimg.cn/wuji_dashboard/xy/componenthub/TLlTCxa7.png", false, 2, null);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final LiveExplainBuyBtn liveExplainBuyBtn4 = LiveExplainBuyBtn.this;
                ConditionViewKt.c(viewContainer2, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBuyBtn$body$1.5
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        LiveExplainBuyBtnAttr liveExplainBuyBtnAttr = LiveExplainBuyBtn.this.viewAttr;
                        return Boolean.valueOf(((Boolean) liveExplainBuyBtnAttr.lightSweep$delegate.getValue(liveExplainBuyBtnAttr, LiveExplainBuyBtnAttr.$$delegatedProperties[5])).booleanValue());
                    }
                }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBuyBtn$body$1.6
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        APNGViewKt.APNG(conditionView, new Function1<APNGVView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBuyBtn.body.1.6.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(APNGVView aPNGVView) {
                                aPNGVView.attr(new Function1<APNGAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBuyBtn.body.1.6.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(APNGAttr aPNGAttr) {
                                        APNGAttr aPNGAttr2 = aPNGAttr;
                                        aPNGAttr2.absolutePosition(0.0f, 0.0f, 0.0f, 0.0f);
                                        aPNGAttr2.repeatCount(1);
                                        aPNGAttr2.with("src", "https://vfiles.gtimg.cn/wuji_dashboard/xy/componenthub/qSyGIPOl.png");
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
        return this.viewAttr;
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}
