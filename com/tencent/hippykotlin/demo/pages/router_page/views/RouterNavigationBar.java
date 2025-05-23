package com.tencent.hippykotlin.demo.pages.router_page.views;

import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.views.ImageEvent;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class RouterNavigationBar extends ComposeView<RouterNavigationBarAttr, l> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ RouterNavigationBarAttr access$getAttr(RouterNavigationBar routerNavigationBar) {
        return (RouterNavigationBarAttr) routerNavigationBar.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.views.RouterNavigationBar$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final RouterNavigationBar routerNavigationBar = RouterNavigationBar.this;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.views.RouterNavigationBar$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final RouterNavigationBar routerNavigationBar2 = RouterNavigationBar.this;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.views.RouterNavigationBar.body.1.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.paddingTop(RouterNavigationBar.this.getPagerData().getStatusBarHeight());
                                tVar2.mo113backgroundColor(h.INSTANCE.m());
                                return Unit.INSTANCE;
                            }
                        });
                        final RouterNavigationBar routerNavigationBar3 = RouterNavigationBar.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.views.RouterNavigationBar.body.1.1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.views.RouterNavigationBar.body.1.1.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.mo141height(44.0f);
                                        tVar2.allCenter();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final RouterNavigationBar routerNavigationBar4 = RouterNavigationBar.this;
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.views.RouterNavigationBar.body.1.1.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final RouterNavigationBar routerNavigationBar5 = RouterNavigationBar.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.views.RouterNavigationBar.body.1.1.2.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                RouterNavigationBarAttr access$getAttr = RouterNavigationBar.access$getAttr(RouterNavigationBar.this);
                                                ceVar2.text((String) access$getAttr.title$delegate.getValue(access$getAttr, RouterNavigationBarAttr.$$delegatedProperties[0]));
                                                ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                                ceVar2.fontWeightSemisolid();
                                                ceVar2.mo135backgroundLinearGradient(Direction.TO_BOTTOM, new j(new h(4283533037L), 0.0f), new j(new h(4283533037L), 1.0f));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final RouterNavigationBar routerNavigationBar4 = RouterNavigationBar.this;
                        ConditionViewKt.c(vVar2, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.views.RouterNavigationBar.body.1.1.3
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Boolean.valueOf(!RouterNavigationBar.access$getAttr(RouterNavigationBar.this).backDisable);
                            }
                        }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.views.RouterNavigationBar.body.1.1.4
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                ah.a(conditionView, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.views.RouterNavigationBar.body.1.1.4.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        ImageView imageView2 = imageView;
                                        imageView2.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.views.RouterNavigationBar.body.1.1.4.1.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                afVar2.absolutePosition(afVar2.getPager().getPageData().getStatusBarHeight() + 12.0f, 12.0f, 12.0f, 12.0f);
                                                afVar2.size(10.0f, 17.0f);
                                                b.a.b(afVar2, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAsAAAASBAMAAAB/WzlGAAAAElBMVEUAAAAAAAAAAAAAAAAAAAAAAADgKxmiAAAABXRSTlMAIN/PELVZAGcAAAAkSURBVAjXYwABQTDJqCQAooSCHUAcVROCHBiFECTMhVoEtRYA6UMHzQlOjQIAAAAASUVORK5CYII=", false, 2, null);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        imageView2.event(new Function1<ImageEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.views.RouterNavigationBar.body.1.1.4.1.2
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ImageEvent imageEvent) {
                                                final ImageEvent imageEvent2 = imageEvent;
                                                imageEvent2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.views.RouterNavigationBar.body.1.1.4.1.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        BridgeModule.closePage$default(Utils.INSTANCE.bridgeModule(ImageEvent.this.getPagerId()), null, null, 3);
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
        return new RouterNavigationBarAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}
