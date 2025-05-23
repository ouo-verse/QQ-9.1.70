package com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page;

import com.tencent.hippykotlin.demo.pages.base.BasePager;
import com.tencent.hippykotlin.demo.pages.base.SkinColor;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.attr.c;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.base.k;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class ASDLoading extends ComposeView<k, l> {
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDLoading$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final ASDLoading aSDLoading = ASDLoading.this;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDLoading$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.absolutePosition(ASDLoading.this.getPagerData().getNavigationBarHeight(), 0.0f, 0.0f, 0.0f);
                        mVar2.mo113backgroundColor(SkinColor.INSTANCE.fgColor(mVar2.getPagerId()));
                        return Unit.INSTANCE;
                    }
                });
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDLoading$body$1.2
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDLoading.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.mo141height(94.0f);
                                if (SkinColor.INSTANCE.isNightMode(tVar2.getPagerId())) {
                                    Direction direction = Direction.TO_RIGHT;
                                    h.Companion companion = h.INSTANCE;
                                    tVar2.mo135backgroundLinearGradient(direction, new j(companion.b(), 0.0f), new j(companion.b(), 1.0f));
                                } else {
                                    tVar2.mo135backgroundLinearGradient(Direction.TO_RIGHT, new j(new h("qecommerce_color_btn_gradient01_normal"), 0.0f), new j(new h("qecommerce_color_btn_gradient02_normal"), 1.0f));
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDLoading.body.1.2.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDLoading.body.1.2.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        af afVar2 = afVar;
                                        afVar2.absolutePosition(0.0f, 0.0f, 0.0f, 0.0f);
                                        b.a.b(afVar2, "qecommerce_skin_order_bg", false, 2, null);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final ASDLoading aSDLoading2 = ASDLoading.this;
                ah.a(viewContainer2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDLoading$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ImageView imageView) {
                        final ASDLoading aSDLoading3 = ASDLoading.this;
                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDLoading.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(af afVar) {
                                af afVar2 = afVar;
                                afVar2.size(ASDLoading.this.getPagerData().m() - 50.0f, ASDLoading.this.getPagerData().m() - 50.0f);
                                c.a.a(afVar2, 30.0f, 25.0f, 25.0f, 0.0f, 8, null);
                                b.a.b(afVar2, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAArIAAAK2AQMAAACIJu3VAAAABlBMVEUAAADz8/MJwGWeAAAAAXRSTlMAQObYZgAAAPRJREFUeNrs27EJwDAMRcHsP1Umi2PsDQIBf+le4+5ag5Cu8Us3l8vlcrlcLpd7pCtJUsXGLuY/Xg+Xy+VyuVwul2u+I0nS1/nOw+VyuVwul8vlJruSJEmSJEmyD87lcrlcLpfL7etKklSxsYv5j9fD5XK5XC6Xy+Wa70iSFHufxeVyuVwul8vluveXJEmSJEmyD86dcblcLpfL5XLtg0uSZL7D5XK5XC6Xy23mSpJUsbT7LC6Xy+VyuVwu172/JEmSJEmSfXDujMvlcrlcLpdrH1ySJPMdLpfL5XK5XG4zV5KkiqXdZ3G5XC6Xy+Vyue8oMBcA9xlX84EO5qQAAAAASUVORK5CYII=", false, 2, null);
                                com.tencent.kuikly.core.pager.b pager = afVar2.getPager();
                                Intrinsics.checkNotNull(pager, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.base.BasePager");
                                if (((BasePager) pager).isNightMode()) {
                                    afVar2.m147opacity(0.5f);
                                } else {
                                    afVar2.m147opacity(1.0f);
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
        return new k();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}
