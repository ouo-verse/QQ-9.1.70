package com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page;

import com.tencent.hippykotlin.demo.pages.base.SkinColor;
import com.tencent.hippykotlin.demo.pages.base.SkinColorKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.RichTextAttr;
import com.tencent.kuikly.core.views.RichTextView;
import com.tencent.kuikly.core.views.RichTextViewKt;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cf;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class ASDAmountView extends ComposeView<ASDAmountViewAttr, l> {
    public ASDAmountViewAttr viewAttr = new ASDAmountViewAttr();

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDAmountView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDAmountView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.flexDirectionRow();
                        mVar2.mo141height(16.0f);
                        mVar2.allCenter();
                        return Unit.INSTANCE;
                    }
                });
                ah.a(viewContainer2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDAmountView$body$1.2
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ImageView imageView) {
                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDAmountView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(af afVar) {
                                af afVar2 = afVar;
                                afVar2.marginTop(2.0f);
                                afVar2.size(7.0f, 11.0f);
                                b.a.b(afVar2, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABUAAAAiCAMAAACHtmKxAAAANlBMVEUAAAD/M3D/MnD/NHD/MnD/MnD/MHD/MHD/M3D/M3D/M3D/M3H/MnD/M3D/NHD/MnD/MHD/M3ATxfXOAAAAEXRSTlMAv4BA32AgEO+gr19wUM/PMCmy1cMAAACqSURBVCjPvZBJEsMgDASFWQTETsL/Pxs0BUhJccrBffAyHkML2nN0mBSWgFxr7SAl9ndHvl+zKYf+7gnlx8xQCuPuVlrR0X9AQhUWplzWcpz7I6+9QqJVPpZWmeJ5yr16msisdg6d8iX5xFdUJw5yyZqvSU4V1/JbtMhyyUxzAkUmsVV2wkjxzDiQX9I+hRaQCaoHpOgRgX3K1QkBCv85XFGo4hDBfre70w/wgg/y3jQACwAAAABJRU5ErkJggg==", false, 2, null);
                                afVar2.marginRight(2.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final ASDAmountView aSDAmountView = ASDAmountView.this;
                RichTextViewKt.b(viewContainer2, new Function1<RichTextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDAmountView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(RichTextView richTextView) {
                        RichTextView richTextView2 = richTextView;
                        richTextView2.attr(new Function1<RichTextAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDAmountView.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(RichTextAttr richTextAttr) {
                                h access$toUniqueColor;
                                RichTextAttr richTextAttr2 = richTextAttr;
                                richTextAttr2.fontWeightBold();
                                if (SkinColor.INSTANCE.isNightMode(richTextAttr2.getPagerId())) {
                                    access$toUniqueColor = SkinColorKt.access$toUniqueColor("qecommerce_skin_color_text_red_brand");
                                } else {
                                    access$toUniqueColor = SkinColorKt.access$toUniqueColor("qecommerce_skin_color_text_red_brand");
                                }
                                richTextAttr2.color(access$toUniqueColor);
                                return Unit.INSTANCE;
                            }
                        });
                        final ASDAmountView aSDAmountView2 = ASDAmountView.this;
                        RichTextViewKt.c(richTextView2, new Function1<cf, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDAmountView.body.1.3.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(cf cfVar) {
                                cf cfVar2 = cfVar;
                                ce.fontSize$default(cfVar2, 18.0f, null, 2, null);
                                ASDAmountViewAttr aSDAmountViewAttr = ASDAmountView.this.viewAttr;
                                cfVar2.text((String) aSDAmountViewAttr.integerStr$delegate.getValue(aSDAmountViewAttr, ASDAmountViewAttr.$$delegatedProperties[0]));
                                return Unit.INSTANCE;
                            }
                        });
                        final ASDAmountView aSDAmountView3 = ASDAmountView.this;
                        RichTextViewKt.c(richTextView2, new Function1<cf, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDAmountView.body.1.3.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(cf cfVar) {
                                cf cfVar2 = cfVar;
                                ce.fontSize$default(cfVar2, 15.0f, null, 2, null);
                                ASDAmountViewAttr aSDAmountViewAttr = ASDAmountView.this.viewAttr;
                                cfVar2.text((String) aSDAmountViewAttr.decimalStr$delegate.getValue(aSDAmountViewAttr, ASDAmountViewAttr.$$delegatedProperties[1]));
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
