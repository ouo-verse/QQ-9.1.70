package com.tencent.hippykotlin.demo.pages.base;

import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
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
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECEmptyViewView extends ComposeView<ECEmptyViewAttr, l> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ ECEmptyViewAttr access$getAttr(ECEmptyViewView eCEmptyViewView) {
        return (ECEmptyViewAttr) eCEmptyViewView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final ECEmptyViewAttr eCEmptyViewAttr = (ECEmptyViewAttr) getAttr();
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECEmptyViewView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final ECEmptyViewAttr eCEmptyViewAttr2 = ECEmptyViewAttr.this;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECEmptyViewView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        float navigationBarHeight;
                        m mVar2 = mVar;
                        Float f16 = ECEmptyViewAttr.this.positionTop;
                        if (f16 != null) {
                            navigationBarHeight = f16.floatValue();
                        } else {
                            navigationBarHeight = mVar2.getPager().getPageData().getNavigationBarHeight();
                        }
                        mVar2.absolutePosition(navigationBarHeight, 0.0f, 0.0f, 0.0f);
                        h hVar = ECEmptyViewAttr.this.backgroundColor;
                        if (hVar == null) {
                            hVar = SkinColor.INSTANCE.fgColor(mVar2.getPagerId());
                        }
                        mVar2.mo113backgroundColor(hVar);
                        mVar2.allCenter();
                        return Unit.INSTANCE;
                    }
                });
                final ECEmptyViewAttr eCEmptyViewAttr3 = ECEmptyViewAttr.this;
                ah.a(viewContainer2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECEmptyViewView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ImageView imageView) {
                        final ECEmptyViewAttr eCEmptyViewAttr4 = ECEmptyViewAttr.this;
                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECEmptyViewView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(af afVar) {
                                af afVar2 = afVar;
                                afVar2.size(256.0f, 192.0f);
                                b.a.b(afVar2, ECEmptyViewAttr.this.emptyImgToken, false, 2, null);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final ECEmptyViewAttr eCEmptyViewAttr4 = ECEmptyViewAttr.this;
                final ECEmptyViewView eCEmptyViewView = this;
                cg.a(viewContainer2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECEmptyViewView$body$1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        final ECEmptyViewAttr eCEmptyViewAttr5 = ECEmptyViewAttr.this;
                        final ECEmptyViewView eCEmptyViewView2 = eCEmptyViewView;
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECEmptyViewView.body.1.3.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                ce ceVar2 = ceVar;
                                ceVar2.marginTop(16.0f);
                                h hVar = ECEmptyViewAttr.this.textColor;
                                if (hVar == null) {
                                    hVar = SkinColor.INSTANCE.blackTextColor(ceVar2.getPagerId());
                                }
                                ceVar2.color(hVar);
                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                ECEmptyViewAttr access$getAttr = ECEmptyViewView.access$getAttr(eCEmptyViewView2);
                                ceVar2.text((String) access$getAttr.emptyText$delegate.getValue(access$getAttr, ECEmptyViewAttr.$$delegatedProperties[0]));
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECEmptyViewView$body$1.4
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECEmptyViewView.body.1.4.1
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
        return new ECEmptyViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}
