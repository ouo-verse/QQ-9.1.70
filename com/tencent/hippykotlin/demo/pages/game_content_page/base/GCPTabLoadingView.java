package com.tencent.hippykotlin.demo.pages.game_content_page.base;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.b;
import com.tencent.kuikly.core.base.event.AnimationCompletionParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class GCPTabLoadingView extends ComposeView<GCPTabLoadingAttr, GCPTabLoadingEvent> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GCPTabLoadingView.class, "animationState", "getAnimationState()I", 0)};
    public final ReadWriteProperty animationState$delegate = c.a(0);

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.base.GCPTabLoadingView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.base.GCPTabLoadingView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        mVar.mo113backgroundColor(new h("qecommerce_skin_color_bg_default"));
                        return Unit.INSTANCE;
                    }
                });
                final GCPTabLoadingView gCPTabLoadingView = GCPTabLoadingView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.base.GCPTabLoadingView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final GCPTabLoadingView gCPTabLoadingView2 = GCPTabLoadingView.this;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.base.GCPTabLoadingView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                int intValue;
                                int intValue2;
                                t tVar2 = tVar;
                                tVar2.marginLeft(16.0f).marginRight(16.0f);
                                tVar2.mo141height(88.0f).borderRadius(4.0f);
                                tVar2.mo113backgroundColor(IPagerIdKtxKt.getSkinColor(tVar2).getSkeletonColor());
                                intValue = ((Number) r0.animationState$delegate.getValue(GCPTabLoadingView.this, GCPTabLoadingView.$$delegatedProperties[0])).intValue();
                                tVar2.m147opacity(intValue == 0 ? 1.0f : 0.3f);
                                b l3 = b.Companion.l(b.INSTANCE, 0.75f, null, 2, null);
                                intValue2 = ((Number) r1.animationState$delegate.getValue(GCPTabLoadingView.this, GCPTabLoadingView.$$delegatedProperties[0])).intValue();
                                tVar2.m134animation(l3, (Object) Integer.valueOf(intValue2));
                                return Unit.INSTANCE;
                            }
                        });
                        final GCPTabLoadingView gCPTabLoadingView3 = GCPTabLoadingView.this;
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.base.GCPTabLoadingView.body.1.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                final GCPTabLoadingView gCPTabLoadingView4 = GCPTabLoadingView.this;
                                uVar.animationCompletion(new Function1<AnimationCompletionParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.base.GCPTabLoadingView.body.1.2.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(AnimationCompletionParams animationCompletionParams) {
                                        int intValue;
                                        intValue = ((Number) r5.animationState$delegate.getValue(GCPTabLoadingView.this, GCPTabLoadingView.$$delegatedProperties[0])).intValue();
                                        if (intValue == 0) {
                                            GCPTabLoadingView gCPTabLoadingView5 = GCPTabLoadingView.this;
                                            gCPTabLoadingView5.animationState$delegate.setValue(gCPTabLoadingView5, GCPTabLoadingView.$$delegatedProperties[0], 1);
                                        } else if (intValue == 1) {
                                            GCPTabLoadingView gCPTabLoadingView6 = GCPTabLoadingView.this;
                                            gCPTabLoadingView6.animationState$delegate.setValue(gCPTabLoadingView6, GCPTabLoadingView.$$delegatedProperties[0], 0);
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
                final GCPTabLoadingView gCPTabLoadingView2 = GCPTabLoadingView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.base.GCPTabLoadingView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        final GCPTabLoadingView gCPTabLoadingView3 = GCPTabLoadingView.this;
                        vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.base.GCPTabLoadingView.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                int intValue;
                                int intValue2;
                                t tVar2 = tVar;
                                tVar2.marginLeft(16.0f).marginRight(16.0f);
                                tVar2.mo141height(43.0f).marginTop(8.0f).borderRadius(4.0f);
                                tVar2.mo113backgroundColor(IPagerIdKtxKt.getSkinColor(tVar2).getSkeletonColor());
                                intValue = ((Number) r0.animationState$delegate.getValue(GCPTabLoadingView.this, GCPTabLoadingView.$$delegatedProperties[0])).intValue();
                                tVar2.m147opacity(intValue == 0 ? 1.0f : 0.3f);
                                b l3 = b.Companion.l(b.INSTANCE, 0.75f, null, 2, null);
                                intValue2 = ((Number) r1.animationState$delegate.getValue(GCPTabLoadingView.this, GCPTabLoadingView.$$delegatedProperties[0])).intValue();
                                tVar2.m134animation(l3, (Object) Integer.valueOf(intValue2));
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final GCPTabLoadingView gCPTabLoadingView3 = GCPTabLoadingView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.base.GCPTabLoadingView$body$1.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.base.GCPTabLoadingView.body.1.4.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.marginTop(24.0f);
                                tVar2.marginLeft(16.0f).marginRight(16.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        final GCPTabLoadingView gCPTabLoadingView4 = GCPTabLoadingView.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.base.GCPTabLoadingView.body.1.4.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.base.GCPTabLoadingView.body.1.4.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        tVar.flexDirectionRow();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final GCPTabLoadingView gCPTabLoadingView5 = GCPTabLoadingView.this;
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.base.GCPTabLoadingView.body.1.4.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        final GCPTabLoadingView gCPTabLoadingView6 = GCPTabLoadingView.this;
                                        vVar5.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.base.GCPTabLoadingView.body.1.4.2.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                int intValue;
                                                int intValue2;
                                                t tVar2 = tVar;
                                                tVar2.size(34.0f, 34.0f).borderRadius(17.0f);
                                                tVar2.mo113backgroundColor(IPagerIdKtxKt.getSkinColor(tVar2).getSkeletonColor());
                                                intValue = ((Number) r0.animationState$delegate.getValue(GCPTabLoadingView.this, GCPTabLoadingView.$$delegatedProperties[0])).intValue();
                                                tVar2.m147opacity(intValue == 0 ? 1.0f : 0.3f);
                                                b l3 = b.Companion.l(b.INSTANCE, 0.75f, null, 2, null);
                                                intValue2 = ((Number) r1.animationState$delegate.getValue(GCPTabLoadingView.this, GCPTabLoadingView.$$delegatedProperties[0])).intValue();
                                                tVar2.m134animation(l3, (Object) Integer.valueOf(intValue2));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final GCPTabLoadingView gCPTabLoadingView6 = GCPTabLoadingView.this;
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.base.GCPTabLoadingView.body.1.4.2.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        final GCPTabLoadingView gCPTabLoadingView7 = GCPTabLoadingView.this;
                                        vVar5.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.base.GCPTabLoadingView.body.1.4.2.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                int intValue;
                                                int intValue2;
                                                t tVar2 = tVar;
                                                tVar2.size(87.0f, 34.0f).borderRadius(4.0f);
                                                tVar2.marginLeft(8.0f);
                                                tVar2.mo113backgroundColor(IPagerIdKtxKt.getSkinColor(tVar2).getSkeletonColor());
                                                intValue = ((Number) r0.animationState$delegate.getValue(GCPTabLoadingView.this, GCPTabLoadingView.$$delegatedProperties[0])).intValue();
                                                tVar2.m147opacity(intValue == 0 ? 1.0f : 0.3f);
                                                b l3 = b.Companion.l(b.INSTANCE, 0.75f, null, 2, null);
                                                intValue2 = ((Number) r1.animationState$delegate.getValue(GCPTabLoadingView.this, GCPTabLoadingView.$$delegatedProperties[0])).intValue();
                                                tVar2.m134animation(l3, (Object) Integer.valueOf(intValue2));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final GCPTabLoadingView gCPTabLoadingView5 = GCPTabLoadingView.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.base.GCPTabLoadingView.body.1.4.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                final GCPTabLoadingView gCPTabLoadingView6 = GCPTabLoadingView.this;
                                vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.base.GCPTabLoadingView.body.1.4.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        int intValue;
                                        int intValue2;
                                        t tVar2 = tVar;
                                        tVar2.mo141height(45.0f).marginTop(8.0f).borderRadius(4.0f);
                                        tVar2.mo113backgroundColor(IPagerIdKtxKt.getSkinColor(tVar2).getSkeletonColor());
                                        intValue = ((Number) r0.animationState$delegate.getValue(GCPTabLoadingView.this, GCPTabLoadingView.$$delegatedProperties[0])).intValue();
                                        tVar2.m147opacity(intValue == 0 ? 1.0f : 0.3f);
                                        b l3 = b.Companion.l(b.INSTANCE, 0.75f, null, 2, null);
                                        intValue2 = ((Number) r1.animationState$delegate.getValue(GCPTabLoadingView.this, GCPTabLoadingView.$$delegatedProperties[0])).intValue();
                                        tVar2.m134animation(l3, (Object) Integer.valueOf(intValue2));
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final GCPTabLoadingView gCPTabLoadingView6 = GCPTabLoadingView.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.base.GCPTabLoadingView.body.1.4.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                final GCPTabLoadingView gCPTabLoadingView7 = GCPTabLoadingView.this;
                                vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.base.GCPTabLoadingView.body.1.4.4.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        int intValue;
                                        int intValue2;
                                        t tVar2 = tVar;
                                        tVar2.mo141height(184.0f).marginTop(8.0f).borderRadius(4.0f);
                                        tVar2.mo113backgroundColor(IPagerIdKtxKt.getSkinColor(tVar2).getSkeletonColor());
                                        intValue = ((Number) r0.animationState$delegate.getValue(GCPTabLoadingView.this, GCPTabLoadingView.$$delegatedProperties[0])).intValue();
                                        tVar2.m147opacity(intValue == 0 ? 1.0f : 0.3f);
                                        b l3 = b.Companion.l(b.INSTANCE, 0.75f, null, 2, null);
                                        intValue2 = ((Number) r1.animationState$delegate.getValue(GCPTabLoadingView.this, GCPTabLoadingView.$$delegatedProperties[0])).intValue();
                                        tVar2.m134animation(l3, (Object) Integer.valueOf(intValue2));
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
        return new GCPTabLoadingAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new GCPTabLoadingEvent();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewDidLayout() {
        super.viewDidLayout();
        this.animationState$delegate.setValue(this, $$delegatedProperties[0], 1);
    }
}
