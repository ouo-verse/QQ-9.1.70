package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view;

import com.tencent.hippykotlin.demo.pages.foundation.extension.FontModuleExtKt;
import com.tencent.hippykotlin.demo.pages.foundation.view.PAGAttr;
import com.tencent.hippykotlin.demo.pages.foundation.view.PAGView;
import com.tencent.hippykotlin.demo.pages.foundation.view.PAGViewKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseAnimControlItemView;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.RenderView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.e;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class GuildTypeIconView extends QSearchBaseAnimControlItemView<GuildTypeIconViewAttr, GuildTypeIconViewEvent> {
    public aa<PAGView> pagRef;

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ GuildTypeIconViewAttr access$getAttr(GuildTypeIconView guildTypeIconView) {
        return (GuildTypeIconViewAttr) guildTypeIconView.getAttr();
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseAnimControlItemView
    public final Function1<ViewContainer<?, ?>, Unit> configView() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildTypeIconView$configView$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final GuildTypeIconView guildTypeIconView = GuildTypeIconView.this;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildTypeIconView$configView$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.mo141height(GuildTypeIconView.access$getAttr(GuildTypeIconView.this).size.getHeight() + FontModuleExtKt.qqFontScaleAddSize(GuildTypeIconView.access$getAttr(GuildTypeIconView.this).iconSize.getHeight()));
                        mVar2.borderRadius(GuildTypeIconView.access$getAttr(GuildTypeIconView.this).borderRadius);
                        mVar2.paddingLeft(6.0f).paddingRight(6.0f);
                        mVar2.m136border(new e(1.0f, BorderStyle.SOLID, GuildTypeIconView.access$getAttr(GuildTypeIconView.this).iconColor));
                        mVar2.flexDirectionRow();
                        mVar2.alignItemsCenter();
                        return Unit.INSTANCE;
                    }
                });
                final GuildTypeIconView guildTypeIconView2 = GuildTypeIconView.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildTypeIconView$configView$1.2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        GuildTypeIconViewAttr access$getAttr = GuildTypeIconView.access$getAttr(GuildTypeIconView.this);
                        return Boolean.valueOf(((String) access$getAttr.iconSrcImg$delegate.getValue(access$getAttr, GuildTypeIconViewAttr.$$delegatedProperties[3])).length() > 0);
                    }
                };
                final GuildTypeIconView guildTypeIconView3 = GuildTypeIconView.this;
                ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildTypeIconView$configView$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final GuildTypeIconView guildTypeIconView4 = GuildTypeIconView.this;
                        ah.a(conditionView, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildTypeIconView.configView.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                final GuildTypeIconView guildTypeIconView5 = GuildTypeIconView.this;
                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildTypeIconView.configView.1.3.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        af afVar2 = afVar;
                                        afVar2.size(GuildTypeIconView.access$getAttr(GuildTypeIconView.this).iconSize.getWidth(), GuildTypeIconView.access$getAttr(GuildTypeIconView.this).iconSize.getHeight());
                                        GuildTypeIconViewAttr access$getAttr = GuildTypeIconView.access$getAttr(GuildTypeIconView.this);
                                        b.a.b(afVar2, (String) access$getAttr.iconSrcImg$delegate.getValue(access$getAttr, GuildTypeIconViewAttr.$$delegatedProperties[3]), false, 2, null);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final GuildTypeIconView guildTypeIconView4 = GuildTypeIconView.this;
                ConditionViewKt.a(viewContainer2, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildTypeIconView$configView$1.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final GuildTypeIconView guildTypeIconView5 = GuildTypeIconView.this;
                        PAGViewKt.PAG(conditionView, new Function1<PAGView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildTypeIconView.configView.1.4.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(PAGView pAGView) {
                                PAGView pAGView2 = pAGView;
                                final GuildTypeIconView guildTypeIconView6 = GuildTypeIconView.this;
                                pAGView2.ref(pAGView2, new Function1<aa<PAGView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildTypeIconView.configView.1.4.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(aa<PAGView> aaVar) {
                                        GuildTypeIconView.this.pagRef = aaVar;
                                        return Unit.INSTANCE;
                                    }
                                });
                                final GuildTypeIconView guildTypeIconView7 = GuildTypeIconView.this;
                                pAGView2.attr(new Function1<PAGAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildTypeIconView.configView.1.4.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(PAGAttr pAGAttr) {
                                        PAGAttr pAGAttr2 = pAGAttr;
                                        pAGAttr2.autoPlay(true);
                                        pAGAttr2.repeatCount(0);
                                        pAGAttr2.size(GuildTypeIconView.access$getAttr(GuildTypeIconView.this).iconSize.getWidth(), GuildTypeIconView.access$getAttr(GuildTypeIconView.this).iconSize.getHeight());
                                        if (pAGAttr2.getPagerData().getIsIOS()) {
                                            GuildTypeIconViewAttr access$getAttr = GuildTypeIconView.access$getAttr(GuildTypeIconView.this);
                                            pAGAttr2.src((String) access$getAttr.iconSrcIOS$delegate.getValue(access$getAttr, GuildTypeIconViewAttr.$$delegatedProperties[2]));
                                        } else {
                                            GuildTypeIconViewAttr access$getAttr2 = GuildTypeIconView.access$getAttr(GuildTypeIconView.this);
                                            pAGAttr2.src((String) access$getAttr2.iconSrcAnd$delegate.getValue(access$getAttr2, GuildTypeIconViewAttr.$$delegatedProperties[1]));
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
                final GuildTypeIconView guildTypeIconView5 = GuildTypeIconView.this;
                cg.a(viewContainer2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildTypeIconView$configView$1.5
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        final GuildTypeIconView guildTypeIconView6 = GuildTypeIconView.this;
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildTypeIconView.configView.1.5.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                ce ceVar2 = ceVar;
                                ceVar2.mo141height(GuildTypeIconView.access$getAttr(GuildTypeIconView.this).size.getHeight() + FontModuleExtKt.qqFontScaleAddSize(GuildTypeIconView.access$getAttr(GuildTypeIconView.this).iconSize.getHeight()));
                                ceVar2.lineHeight(GuildTypeIconView.access$getAttr(GuildTypeIconView.this).size.getHeight());
                                GuildTypeIconViewAttr access$getAttr = GuildTypeIconView.access$getAttr(GuildTypeIconView.this);
                                ceVar2.text((String) access$getAttr.iconText$delegate.getValue(access$getAttr, GuildTypeIconViewAttr.$$delegatedProperties[0]));
                                ce.fontSize$default(ceVar2, GuildTypeIconView.access$getAttr(GuildTypeIconView.this).iconSize.getHeight(), null, 2, null);
                                ceVar2.fontWeight500();
                                ceVar2.color(GuildTypeIconView.access$getAttr(GuildTypeIconView.this).iconColor);
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
        return new GuildTypeIconViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new GuildTypeIconViewEvent();
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseAnimControlItemView, com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        super.created();
        bindValueChange(new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildTypeIconView$created$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(GuildTypeIconView.this.getCanPlayAnim());
            }
        }, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildTypeIconView$created$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                final PAGView b16;
                aa<PAGView> aaVar = GuildTypeIconView.this.pagRef;
                if (aaVar != null && (b16 = aaVar.b()) != null) {
                    if (GuildTypeIconView.this.getCanPlayAnim()) {
                        b16.performTaskWhenRenderViewDidLoad(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.view.PAGView$play$1
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                RenderView renderView = PAGView.this.getRenderView();
                                if (renderView != null) {
                                    RenderView.b(renderView, "play", "", null, 4, null);
                                }
                                return Unit.INSTANCE;
                            }
                        });
                    } else {
                        b16.performTaskWhenRenderViewDidLoad(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.view.PAGView$stop$1
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                RenderView renderView = PAGView.this.getRenderView();
                                if (renderView != null) {
                                    RenderView.b(renderView, "stop", "", null, 4, null);
                                }
                                return Unit.INSTANCE;
                            }
                        });
                    }
                }
                return Unit.INSTANCE;
            }
        });
    }
}
