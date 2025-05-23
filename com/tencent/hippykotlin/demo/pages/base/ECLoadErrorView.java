package com.tencent.hippykotlin.demo.pages.base;

import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECLoadErrorView extends ComposeView<ECLoadErrorViewAttr, ECLoadErrorViewEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ ECLoadErrorViewAttr access$getAttr(ECLoadErrorView eCLoadErrorView) {
        return (ECLoadErrorViewAttr) eCLoadErrorView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECLoadErrorView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECLoadErrorView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.absolutePosition(0.0f, 0.0f, 0.0f, 0.0f);
                        mVar2.allCenter();
                        return Unit.INSTANCE;
                    }
                });
                ah.a(viewContainer2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECLoadErrorView$body$1.2
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ImageView imageView) {
                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECLoadErrorView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(af afVar) {
                                af afVar2 = afVar;
                                afVar2.size(176.0f, 132.0f);
                                b.a.b(afVar2, "qecommerce_skin_emptystate_img_wuwangluo", false, 2, null);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final ECLoadErrorView eCLoadErrorView = ECLoadErrorView.this;
                cg.a(viewContainer2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECLoadErrorView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        final ECLoadErrorView eCLoadErrorView2 = ECLoadErrorView.this;
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECLoadErrorView.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                ce ceVar2 = ceVar;
                                ceVar2.marginTop(8.0f);
                                ce.fontSize$default(ceVar2, 17.0f, null, 2, null).color(new h("qecommerce_skin_color_text_primary"));
                                ECLoadErrorViewAttr access$getAttr = ECLoadErrorView.access$getAttr(ECLoadErrorView.this);
                                ceVar2.value((String) access$getAttr.tipsText$delegate.getValue(access$getAttr, ECLoadErrorViewAttr.$$delegatedProperties[0]));
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final ECLoadErrorView eCLoadErrorView2 = ECLoadErrorView.this;
                ECButtonKt.ECButton(viewContainer2, new Function1<ECButton, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECLoadErrorView$body$1.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ECButton eCButton) {
                        ECButton eCButton2 = eCButton;
                        final ECLoadErrorView eCLoadErrorView3 = ECLoadErrorView.this;
                        eCButton2.attr(new Function1<ECButtonAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECLoadErrorView.body.1.4.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ECButtonAttr eCButtonAttr) {
                                ECButtonAttr eCButtonAttr2 = eCButtonAttr;
                                eCButtonAttr2.size(88.0f, 29.0f);
                                eCButtonAttr2.marginTop(23.5f);
                                eCButtonAttr2.titleAttrInit = new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECLoadErrorView.body.1.4.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ceVar2.text("\u91cd\u65b0\u52a0\u8f7d");
                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                        return Unit.INSTANCE;
                                    }
                                };
                                eCButtonAttr2.isCirStyle = ECLoadErrorView.access$getAttr(ECLoadErrorView.this).isCirStyle;
                                return Unit.INSTANCE;
                            }
                        });
                        final ECLoadErrorView eCLoadErrorView4 = ECLoadErrorView.this;
                        eCButton2.event(new Function1<l, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECLoadErrorView.body.1.4.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(l lVar) {
                                final ECLoadErrorView eCLoadErrorView5 = ECLoadErrorView.this;
                                lVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECLoadErrorView.body.1.4.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        ECLoadErrorView.this.emit("onClickRetryBtn", null);
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
        return new ECLoadErrorViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new ECLoadErrorViewEvent();
    }
}
