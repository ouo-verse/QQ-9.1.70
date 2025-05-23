package com.tencent.hippykotlin.demo.pages.base;

import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.compose.ButtonView;
import com.tencent.kuikly.core.views.compose.a;
import com.tencent.kuikly.core.views.compose.c;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECErrorView extends ComposeView<ErrorViewAttr, ErrorViewEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ ErrorViewAttr access$getAttr(ECErrorView eCErrorView) {
        return (ErrorViewAttr) eCErrorView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final ErrorViewAttr errorViewAttr = (ErrorViewAttr) getAttr();
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECErrorView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final ErrorViewAttr errorViewAttr2 = ErrorViewAttr.this;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECErrorView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        float navigationBarHeight;
                        m mVar2 = mVar;
                        Float f16 = ErrorViewAttr.this.positionTop;
                        if (f16 != null) {
                            navigationBarHeight = f16.floatValue();
                        } else {
                            navigationBarHeight = mVar2.getPager().getPageData().getNavigationBarHeight();
                        }
                        mVar2.absolutePosition(navigationBarHeight, 0.0f, 0.0f, 0.0f);
                        h hVar = ErrorViewAttr.this.backgroundColor;
                        if (hVar == null) {
                            hVar = SkinColor.INSTANCE.fgColor(mVar2.getPagerId());
                        }
                        mVar2.mo113backgroundColor(hVar);
                        mVar2.allCenter();
                        return Unit.INSTANCE;
                    }
                });
                final ErrorViewAttr errorViewAttr3 = ErrorViewAttr.this;
                ah.a(viewContainer2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECErrorView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ImageView imageView) {
                        final ErrorViewAttr errorViewAttr4 = ErrorViewAttr.this;
                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECErrorView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(af afVar) {
                                af afVar2 = afVar;
                                afVar2.size(256.0f, 192.0f);
                                b.a.b(afVar2, ErrorViewAttr.this.errorImgToken, false, 2, null);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final ErrorViewAttr errorViewAttr4 = ErrorViewAttr.this;
                cg.a(viewContainer2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECErrorView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        final ErrorViewAttr errorViewAttr5 = ErrorViewAttr.this;
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECErrorView.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                ce ceVar2 = ceVar;
                                ceVar2.marginTop(16.0f);
                                h hVar = ErrorViewAttr.this.textColor;
                                if (hVar == null) {
                                    hVar = SkinColor.INSTANCE.blackTextColor(ceVar2.getPagerId());
                                }
                                ceVar2.color(hVar);
                                ceVar2.text(ErrorViewAttr.this.errorMsgLine1);
                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final ErrorViewAttr errorViewAttr5 = ErrorViewAttr.this;
                cg.a(viewContainer2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECErrorView$body$1.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        final ErrorViewAttr errorViewAttr6 = ErrorViewAttr.this;
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECErrorView.body.1.4.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                ce ceVar2 = ceVar;
                                h hVar = ErrorViewAttr.this.textColor;
                                if (hVar == null) {
                                    hVar = SkinColor.INSTANCE.blackTextColor(ceVar2.getPagerId());
                                }
                                ceVar2.color(hVar);
                                ceVar2.text(ErrorViewAttr.this.errorMsgLine2);
                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final ECErrorView eCErrorView = this;
                final ECErrorView eCErrorView2 = this;
                c.a(viewContainer2, new Function1<ButtonView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECErrorView$body$1.5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ButtonView buttonView) {
                        ButtonView buttonView2 = buttonView;
                        buttonView2.attr(new Function1<a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECErrorView.body.1.5.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(a aVar) {
                                aVar.q(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECErrorView.body.1.5.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ceVar2.text("\u91cd\u65b0\u52a0\u8f7d");
                                        ceVar2.fontWeightMedium();
                                        ceVar2.color(SkinColor.whiteTextColor);
                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final ECErrorView eCErrorView3 = ECErrorView.this;
                        buttonView2.attr(new Function1<a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECErrorView.body.1.5.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(a aVar) {
                                a aVar2 = aVar;
                                aVar2.size(92.0f, 32.0f);
                                aVar2.marginTop(20.0f);
                                aVar2.borderRadius(4.0f);
                                h hVar = ECErrorView.access$getAttr(ECErrorView.this).buttonBgColor;
                                if (hVar != null) {
                                    aVar2.mo113backgroundColor(hVar);
                                } else {
                                    aVar2.mo135backgroundLinearGradient(Direction.TO_RIGHT, new j(new h("qecommerce_color_btn_gradient01_normal"), 0.0f), new j(new h("qecommerce_color_btn_gradient02_normal"), 1.0f));
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        final ECErrorView eCErrorView4 = eCErrorView2;
                        buttonView2.event(new Function1<com.tencent.kuikly.core.views.compose.b, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECErrorView.body.1.5.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(com.tencent.kuikly.core.views.compose.b bVar) {
                                final ECErrorView eCErrorView5 = ECErrorView.this;
                                bVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECErrorView.body.1.5.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        ECErrorView.this.emit("clickRetryButton", null);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECErrorView$body$1.6
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECErrorView.body.1.6.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                tVar.mo141height(100.0f);
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
        return new ErrorViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new ErrorViewEvent();
    }
}
