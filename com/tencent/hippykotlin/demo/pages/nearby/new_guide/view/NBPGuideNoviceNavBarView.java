package com.tencent.hippykotlin.demo.pages.nearby.new_guide.view;

import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.m;
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

/* loaded from: classes31.dex */
public final class NBPGuideNoviceNavBarView extends ComposeView<NBPGuideNoviceNavBarAttr, NBPGuideNoviceNavBarEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NBPGuideNoviceNavBarAttr access$getAttr(NBPGuideNoviceNavBarView nBPGuideNoviceNavBarView) {
        return (NBPGuideNoviceNavBarAttr) nBPGuideNoviceNavBarView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NBPGuideNoviceNavBarEvent access$getEvent(NBPGuideNoviceNavBarView nBPGuideNoviceNavBarView) {
        return (NBPGuideNoviceNavBarEvent) nBPGuideNoviceNavBarView.getEvent();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceNavBarView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceNavBarView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.paddingTop(mVar2.getPagerData().getStatusBarHeight());
                        mVar2.alignItemsStretch();
                        return Unit.INSTANCE;
                    }
                });
                final NBPGuideNoviceNavBarView nBPGuideNoviceNavBarView = NBPGuideNoviceNavBarView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceNavBarView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceNavBarView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.mo141height(44.0f);
                                tVar2.flexDirectionRow();
                                tVar2.alignItemsStretch();
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPGuideNoviceNavBarView nBPGuideNoviceNavBarView2 = NBPGuideNoviceNavBarView.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceNavBarView.body.1.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                final float f16 = 50.0f;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceNavBarView.body.1.2.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.flexDirectionRow();
                                        tVar2.alignItemsCenter();
                                        tVar2.mo153width(f16);
                                        return Unit.INSTANCE;
                                    }
                                });
                                ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceNavBarView.body.1.2.2.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceNavBarView.body.1.2.2.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_gprg2tiIEyx.png", false, 2, null);
                                                afVar2.size(24.0f, 24.0f);
                                                afVar2.marginLeft(10.0f);
                                                afVar2.marginRight(10.0f);
                                                afVar2.t(QUIToken.color$default("text_nav_secondary"));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPGuideNoviceNavBarView nBPGuideNoviceNavBarView3 = NBPGuideNoviceNavBarView.this;
                                vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceNavBarView.body.1.2.2.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(u uVar) {
                                        final NBPGuideNoviceNavBarView nBPGuideNoviceNavBarView4 = NBPGuideNoviceNavBarView.this;
                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceNavBarView.body.1.2.2.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                Function1<Object, Unit> function1 = NBPGuideNoviceNavBarView.access$getEvent(NBPGuideNoviceNavBarView.this).clickBackBtnHandlerFn;
                                                if (function1 != null) {
                                                    function1.invoke(null);
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
                        final NBPGuideNoviceNavBarView nBPGuideNoviceNavBarView3 = NBPGuideNoviceNavBarView.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceNavBarView.body.1.2.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceNavBarView.body.1.2.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.allCenter();
                                        tVar2.absolutePositionAllZero();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPGuideNoviceNavBarView nBPGuideNoviceNavBarView4 = NBPGuideNoviceNavBarView.this;
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceNavBarView.body.1.2.3.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final NBPGuideNoviceNavBarView nBPGuideNoviceNavBarView5 = NBPGuideNoviceNavBarView.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceNavBarView.body.1.2.3.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ceVar2.text(NBPGuideNoviceNavBarView.access$getAttr(NBPGuideNoviceNavBarView.this).title);
                                                ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                                ceVar2.color(QUIToken.color$default("text_nav_secondary"));
                                                ceVar2.fontWeightMedium();
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
        return new NBPGuideNoviceNavBarAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NBPGuideNoviceNavBarEvent();
    }
}
