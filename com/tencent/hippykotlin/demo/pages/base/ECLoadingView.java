package com.tencent.hippykotlin.demo.pages.base;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.view.PAGAttr;
import com.tencent.hippykotlin.demo.pages.foundation.view.PAGView;
import com.tencent.hippykotlin.demo.pages.foundation.view.PAGViewKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECLoadingView extends ComposeView<ECLoadingAttr, l> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(ECLoadingView.class, UIJsPlugin.EVENT_SHOW_LOADING, "getShowLoading()Z", 0)};
    public final Lazy loadingPAGToken$delegate;
    public final ReadWriteProperty showLoading$delegate = c.a(Boolean.FALSE);

    public ECLoadingView() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECLoadingView$loadingPAGToken$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                if (ECLoadingView.this.getPagerData().getIsIOS()) {
                    return "qecommerce_skin_loading_img_sangedian";
                }
                return "ecommerce_skin_loading_img_sangedian";
            }
        });
        this.loadingPAGToken$delegate = lazy;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ ECLoadingAttr access$getAttr(ECLoadingView eCLoadingView) {
        return (ECLoadingAttr) eCLoadingView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECLoadingView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECLoadingView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.absolutePosition(0.0f, 0.0f, 0.0f, 0.0f);
                        mVar2.allCenter();
                        return Unit.INSTANCE;
                    }
                });
                final ECLoadingView eCLoadingView = ECLoadingView.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECLoadingView$body$1.2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        ECLoadingView eCLoadingView2 = ECLoadingView.this;
                        return Boolean.valueOf(((Boolean) eCLoadingView2.showLoading$delegate.getValue(eCLoadingView2, ECLoadingView.$$delegatedProperties[0])).booleanValue());
                    }
                };
                final ECLoadingView eCLoadingView2 = ECLoadingView.this;
                ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECLoadingView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final ECLoadingView eCLoadingView3 = ECLoadingView.this;
                        w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECLoadingView.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECLoadingView.body.1.3.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        h hVar;
                                        t tVar2 = tVar;
                                        tVar2.borderRadius(6.0f);
                                        tVar2.size(100.0f, 100.0f);
                                        if (Intrinsics.areEqual(tVar2.getPager().getPageName(), "qsearch_detail")) {
                                            hVar = new h(3425644335L);
                                        } else {
                                            hVar = new h(3425644335L);
                                        }
                                        tVar2.mo113backgroundColor(hVar);
                                        tVar2.allCenter();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final ECLoadingView eCLoadingView4 = ECLoadingView.this;
                                PAGViewKt.PAG(vVar2, new Function1<PAGView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECLoadingView.body.1.3.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(PAGView pAGView) {
                                        final ECLoadingView eCLoadingView5 = ECLoadingView.this;
                                        pAGView.attr(new Function1<PAGAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECLoadingView.body.1.3.1.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(PAGAttr pAGAttr) {
                                                PAGAttr pAGAttr2 = pAGAttr;
                                                pAGAttr2.size(30.0f, 30.0f);
                                                pAGAttr2.repeatCount(Integer.MAX_VALUE);
                                                pAGAttr2.autoPlay(true);
                                                pAGAttr2.src((String) ECLoadingView.this.loadingPAGToken$delegate.getValue());
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final ECLoadingView eCLoadingView5 = ECLoadingView.this;
                                Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECLoadingView.body.1.3.1.3
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        ECLoadingAttr access$getAttr = ECLoadingView.access$getAttr(ECLoadingView.this);
                                        return Boolean.valueOf(((String) access$getAttr.loadingText$delegate.getValue(access$getAttr, ECLoadingAttr.$$delegatedProperties[0])).length() > 0);
                                    }
                                };
                                final ECLoadingView eCLoadingView6 = ECLoadingView.this;
                                ConditionViewKt.c(vVar2, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECLoadingView.body.1.3.1.4
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ConditionView conditionView2) {
                                        final ECLoadingView eCLoadingView7 = ECLoadingView.this;
                                        cg.a(conditionView2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECLoadingView.body.1.3.1.4.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                final ECLoadingView eCLoadingView8 = ECLoadingView.this;
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECLoadingView.body.1.3.1.4.1.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        ce ceVar2 = ceVar;
                                                        ceVar2.marginTop(13.0f);
                                                        ceVar2.color(h.INSTANCE.m());
                                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                        ECLoadingAttr access$getAttr = ECLoadingView.access$getAttr(ECLoadingView.this);
                                                        ceVar2.text((String) access$getAttr.loadingText$delegate.getValue(access$getAttr, ECLoadingAttr.$$delegatedProperties[0]));
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
        return new ECLoadingAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        super.created();
        if (((ECLoadingAttr) getAttr()).delayShow) {
            TimerKt.e(getPagerId(), ((ECLoadingAttr) getAttr()).delayTime, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECLoadingView$created$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    ECLoadingView eCLoadingView = ECLoadingView.this;
                    eCLoadingView.showLoading$delegate.setValue(eCLoadingView, ECLoadingView.$$delegatedProperties[0], Boolean.TRUE);
                    return Unit.INSTANCE;
                }
            });
        } else {
            this.showLoading$delegate.setValue(this, $$delegatedProperties[0], Boolean.TRUE);
        }
    }
}
