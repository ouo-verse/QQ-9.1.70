package com.tencent.hippykotlin.demo.pages.base;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.b;
import com.tencent.kuikly.core.base.event.AnimationCompletionParams;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.f;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.base.y;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.c;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class FloatingPanelView extends ComposeView<FloatingPanelAttr, FloatingPanelEvent> implements c {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(FloatingPanelView.class, "animated", "getAnimated()Z", 0)};
    public final ReadWriteProperty animated$delegate = c01.c.a(Boolean.FALSE);
    public final Function2<ViewContainer<?, ?>, FloatingPanelView, Unit> child;

    /* JADX WARN: Multi-variable type inference failed */
    public FloatingPanelView(Function2<? super ViewContainer<?, ?>, ? super FloatingPanelView, Unit> function2) {
        this.child = function2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ FloatingPanelAttr access$getAttr(FloatingPanelView floatingPanelView) {
        return (FloatingPanelAttr) floatingPanelView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.FloatingPanelView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final FloatingPanelView floatingPanelView = FloatingPanelView.this;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.FloatingPanelView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        boolean booleanValue;
                        boolean booleanValue2;
                        m mVar2 = mVar;
                        mVar2.m140flex(1.0f);
                        mVar2.flexDirectionColumn();
                        mVar2.justifyContentFlexEnd();
                        booleanValue = ((Boolean) r0.animated$delegate.getValue(FloatingPanelView.this, FloatingPanelView.$$delegatedProperties[0])).booleanValue();
                        if (booleanValue) {
                            mVar2.mo113backgroundColor(new h(0, 0, 0, 0.5f));
                        } else {
                            mVar2.mo113backgroundColor(new h(0, 0, 0, 0.0f));
                        }
                        b p16 = b.Companion.p(b.INSTANCE, 0.4f, 0.92f, 1.0f, null, 8, null);
                        booleanValue2 = ((Boolean) r1.animated$delegate.getValue(FloatingPanelView.this, FloatingPanelView.$$delegatedProperties[0])).booleanValue();
                        mVar2.m134animation(p16, (Object) Boolean.valueOf(booleanValue2));
                        return Unit.INSTANCE;
                    }
                });
                final FloatingPanelView floatingPanelView2 = FloatingPanelView.this;
                viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.FloatingPanelView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Event event) {
                        Event event2 = event;
                        final FloatingPanelView floatingPanelView3 = FloatingPanelView.this;
                        event2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.FloatingPanelView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ClickParams clickParams) {
                                FloatingPanelView.this.close();
                                return Unit.INSTANCE;
                            }
                        });
                        final FloatingPanelView floatingPanelView4 = FloatingPanelView.this;
                        event2.animationCompletion(new Function1<AnimationCompletionParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.FloatingPanelView.body.1.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(AnimationCompletionParams animationCompletionParams) {
                                boolean booleanValue;
                                final AnimationCompletionParams animationCompletionParams2 = animationCompletionParams;
                                booleanValue = ((Boolean) r0.animated$delegate.getValue(FloatingPanelView.this, FloatingPanelView.$$delegatedProperties[0])).booleanValue();
                                if (booleanValue) {
                                    FloatingPanelView.this.emit("actionShow", animationCompletionParams2);
                                } else if (FloatingPanelView.this.getPagerData().getIsIOS()) {
                                    BridgeModule bridgeModule = IPagerIdKtxKt.getBridgeModule(FloatingPanelView.this);
                                    final FloatingPanelView floatingPanelView5 = FloatingPanelView.this;
                                    BridgeModule.closePage$default(bridgeModule, null, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.FloatingPanelView.body.1.2.2.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(e eVar) {
                                            FloatingPanelView.this.emit("actionClose", animationCompletionParams2);
                                            return Unit.INSTANCE;
                                        }
                                    }, 1);
                                } else {
                                    BridgeModule.closePage$default(IPagerIdKtxKt.getBridgeModule(FloatingPanelView.this), null, null, 3);
                                    FloatingPanelView.this.emit("actionClose", animationCompletionParams2);
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final FloatingPanelView floatingPanelView3 = FloatingPanelView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.FloatingPanelView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final FloatingPanelView floatingPanelView4 = FloatingPanelView.this;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.FloatingPanelView.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                boolean booleanValue;
                                boolean booleanValue2;
                                t tVar2 = tVar;
                                tVar2.m140flex(1.0f);
                                FloatingPanelView.access$getAttr(FloatingPanelView.this).getClass();
                                tVar2.mo113backgroundColor(IPagerIdKtxKt.getSkinColor(tVar2).getForegroundColor());
                                tVar2.m137borderRadius(new f(8.0f, 8.0f, 0.0f, 0.0f));
                                tVar2.marginTop(FloatingPanelView.access$getAttr(FloatingPanelView.this).marginTop);
                                booleanValue = ((Boolean) r2.animated$delegate.getValue(FloatingPanelView.this, FloatingPanelView.$$delegatedProperties[0])).booleanValue();
                                if (booleanValue) {
                                    tVar2.transform(new y(0.0f, 0.0f, 0.0f, 0.0f, 12, null));
                                } else {
                                    tVar2.transform(new y(0.0f, 1.0f, 0.0f, 0.0f, 12, null));
                                }
                                b n3 = b.Companion.n(b.INSTANCE, 0.4f, 0.92f, 1.0f, null, 8, null);
                                booleanValue2 = ((Boolean) r3.animated$delegate.getValue(FloatingPanelView.this, FloatingPanelView.$$delegatedProperties[0])).booleanValue();
                                tVar2.m134animation(n3, (Object) Boolean.valueOf(booleanValue2));
                                return Unit.INSTANCE;
                            }
                        });
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.FloatingPanelView.body.1.3.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.FloatingPanelView.body.1.3.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final FloatingPanelView floatingPanelView5 = FloatingPanelView.this;
                        final String str = FloatingPanelView.access$getAttr(floatingPanelView5).rightIcon;
                        final String str2 = FloatingPanelView.access$getAttr(FloatingPanelView.this).title;
                        FloatingPanelView.access$getAttr(FloatingPanelView.this).getClass();
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.FloatingPanelViewKt$FloatingPanelNavBar$1
                            public final /* synthetic */ h $titleColor = null;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.FloatingPanelViewKt$FloatingPanelNavBar$1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.mo113backgroundColor(h.INSTANCE.j());
                                        tVar2.flexDirectionColumn();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final String str3 = str2;
                                final h hVar = this.$titleColor;
                                final FloatingPanelView floatingPanelView6 = floatingPanelView5;
                                final String str4 = str;
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.FloatingPanelViewKt$FloatingPanelNavBar$1.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        v vVar6 = vVar5;
                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.FloatingPanelViewKt.FloatingPanelNavBar.1.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.flexDirectionRow();
                                                tVar2.marginTop(12.0f);
                                                tVar2.marginBottom(12.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        w.a(vVar6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.FloatingPanelViewKt.FloatingPanelNavBar.1.2.2
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar7) {
                                                vVar7.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.FloatingPanelViewKt.FloatingPanelNavBar.1.2.2.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.mo153width(55.0f);
                                                        tVar2.allCenter();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final String str5 = str3;
                                        final h hVar2 = hVar;
                                        w.a(vVar6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.FloatingPanelViewKt.FloatingPanelNavBar.1.2.3
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar7) {
                                                v vVar8 = vVar7;
                                                vVar8.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.FloatingPanelViewKt.FloatingPanelNavBar.1.2.3.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.m140flex(1.0f);
                                                        tVar2.allCenter();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final String str6 = str5;
                                                final h hVar3 = hVar2;
                                                cg.a(vVar8, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.FloatingPanelViewKt.FloatingPanelNavBar.1.2.3.2
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        final String str7 = str6;
                                                        final h hVar4 = hVar3;
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.FloatingPanelViewKt.FloatingPanelNavBar.1.2.3.2.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                ce ceVar2 = ceVar;
                                                                ceVar2.text(str7);
                                                                h hVar5 = hVar4;
                                                                if (hVar5 == null) {
                                                                    hVar5 = IPagerIdKtxKt.getSkinColor(ceVar2).getPrimaryTextColor();
                                                                }
                                                                ceVar2.color(hVar5);
                                                                ce.fontSize$default(ceVar2, 18.0f, null, 2, null);
                                                                ceVar2.fontWeight500();
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final FloatingPanelView floatingPanelView7 = floatingPanelView6;
                                        final String str6 = str4;
                                        w.a(vVar6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.FloatingPanelViewKt.FloatingPanelNavBar.1.2.4
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar7) {
                                                v vVar8 = vVar7;
                                                vVar8.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.FloatingPanelViewKt.FloatingPanelNavBar.1.2.4.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.mo153width(55.0f);
                                                        tVar2.allCenter();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final FloatingPanelView floatingPanelView8 = FloatingPanelView.this;
                                                vVar8.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.FloatingPanelViewKt.FloatingPanelNavBar.1.2.4.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(u uVar) {
                                                        final FloatingPanelView floatingPanelView9 = FloatingPanelView.this;
                                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.FloatingPanelViewKt.FloatingPanelNavBar.1.2.4.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                FloatingPanelView.this.close();
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final String str7 = str6;
                                                ah.a(vVar8, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.FloatingPanelViewKt.FloatingPanelNavBar.1.2.4.3
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ImageView imageView) {
                                                        final String str8 = str7;
                                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.FloatingPanelViewKt.FloatingPanelNavBar.1.2.4.3.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(af afVar) {
                                                                af afVar2 = afVar;
                                                                afVar2.size(25.0f, 25.0f);
                                                                b.a.b(afVar2, str8, false, 2, null);
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
                        final FloatingPanelView floatingPanelView6 = FloatingPanelView.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.FloatingPanelView.body.1.3.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.FloatingPanelView.body.1.3.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        tVar.m140flex(1.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                FloatingPanelView floatingPanelView7 = FloatingPanelView.this;
                                floatingPanelView7.child.invoke(vVar4, floatingPanelView7);
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

    public final void close() {
        this.animated$delegate.setValue(this, $$delegatedProperties[0], Boolean.FALSE);
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new FloatingPanelAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new FloatingPanelEvent();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        super.created();
        getPager().addPagerEventObserver(this);
    }

    @Override // com.tencent.kuikly.core.pager.c
    public final void onPagerEvent(String str, e eVar) {
        if (Intrinsics.areEqual(str, "onModalModeBackPressed")) {
            close();
        }
    }

    @Override // com.tencent.kuikly.core.pager.c
    public final void onRootViewSizeChanged(double d16, double d17) {
        c.a.a(this, d16, d17);
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewDidLayout() {
        super.viewDidLayout();
        this.animated$delegate.setValue(this, $$delegatedProperties[0], Boolean.TRUE);
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewDidUnload() {
        super.viewDidUnload();
        getPager().removePagerEventObserver(this);
    }
}
