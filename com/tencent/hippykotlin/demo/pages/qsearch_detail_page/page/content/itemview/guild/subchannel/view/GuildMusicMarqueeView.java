package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.FrameEventKt;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.layout.d;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class GuildMusicMarqueeView extends ComposeView<GuildMusicMarqueeAttr, GuildMusicMarqueeEvent> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GuildMusicMarqueeView.class, "useFirstView", "getUseFirstView()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GuildMusicMarqueeView.class, "useSecondView", "getUseSecondView()Z", 0)};
    public float marqueeWidth;
    public final ReadWriteProperty useFirstView$delegate = c.a(Boolean.TRUE);
    public final ReadWriteProperty useSecondView$delegate = c.a(Boolean.FALSE);
    public int currentIndex = -1;
    public boolean isFirstCreate = true;
    public d marqueeLayoutFrame = d.INSTANCE.a();

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ GuildMusicMarqueeAttr access$getAttr(GuildMusicMarqueeView guildMusicMarqueeView) {
        return (GuildMusicMarqueeAttr) guildMusicMarqueeView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildMusicMarqueeView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildMusicMarqueeView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        mVar.flexDirectionRow();
                        return Unit.INSTANCE;
                    }
                });
                final GuildMusicMarqueeView guildMusicMarqueeView = GuildMusicMarqueeView.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildMusicMarqueeView$body$1.2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        GuildMusicMarqueeView guildMusicMarqueeView2 = GuildMusicMarqueeView.this;
                        return Boolean.valueOf(((Boolean) guildMusicMarqueeView2.useFirstView$delegate.getValue(guildMusicMarqueeView2, GuildMusicMarqueeView.$$delegatedProperties[0])).booleanValue());
                    }
                };
                final GuildMusicMarqueeView guildMusicMarqueeView2 = GuildMusicMarqueeView.this;
                ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildMusicMarqueeView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final GuildMusicMarqueeView guildMusicMarqueeView3 = GuildMusicMarqueeView.this;
                        conditionView.addChild(new GuildMarqueeAnimationView(), new Function1<GuildMarqueeAnimationView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildMusicMarqueeView.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(GuildMarqueeAnimationView guildMarqueeAnimationView) {
                                GuildMarqueeAnimationView guildMarqueeAnimationView2 = guildMarqueeAnimationView;
                                final GuildMusicMarqueeView guildMusicMarqueeView4 = GuildMusicMarqueeView.this;
                                guildMarqueeAnimationView2.attr(new Function1<GuildMarqueeAnimationAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildMusicMarqueeView.body.1.3.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(GuildMarqueeAnimationAttr guildMarqueeAnimationAttr) {
                                        GuildMarqueeAnimationAttr guildMarqueeAnimationAttr2 = guildMarqueeAnimationAttr;
                                        Attr.absolutePosition$default(guildMarqueeAnimationAttr2, 0.0f, 0.0f, 0.0f, 0.0f, 12, null);
                                        guildMarqueeAnimationAttr2.marqueePerSecondTranslation = GuildMusicMarqueeView.access$getAttr(GuildMusicMarqueeView.this).marqueePerSecondTranslation;
                                        GuildMusicMarqueeView guildMusicMarqueeView5 = GuildMusicMarqueeView.this;
                                        guildMarqueeAnimationAttr2.marqueeViewWidth = guildMusicMarqueeView5.marqueeWidth;
                                        guildMarqueeAnimationAttr2.marqueeDirection = GuildMusicMarqueeView.access$getAttr(guildMusicMarqueeView5).marqueeDirection;
                                        final GuildMusicMarqueeView guildMusicMarqueeView6 = GuildMusicMarqueeView.this;
                                        guildMarqueeAnimationAttr2.viewCreator = new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildMusicMarqueeView.body.1.3.1.1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                                GuildMusicMarqueeView guildMusicMarqueeView7 = GuildMusicMarqueeView.this;
                                                KProperty<Object>[] kPropertyArr = GuildMusicMarqueeView.$$delegatedProperties;
                                                guildMusicMarqueeView7.getClass();
                                                new GuildMusicMarqueeView$createNextBatchMarquee$1(guildMusicMarqueeView7).invoke(viewContainer3);
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        int i3 = GuildMusicMarqueeView.access$getAttr(GuildMusicMarqueeView.this).maxMarqueeEachBatch;
                                        GuildMusicMarqueeView guildMusicMarqueeView7 = GuildMusicMarqueeView.this;
                                        if (guildMusicMarqueeView7.isFirstCreate) {
                                            if (guildMusicMarqueeView7.marqueeLayoutFrame.getWidth() > 0.0f) {
                                                GuildMusicMarqueeView guildMusicMarqueeView8 = GuildMusicMarqueeView.this;
                                                if (guildMusicMarqueeView8.marqueeWidth > guildMusicMarqueeView8.marqueeLayoutFrame.getWidth()) {
                                                    GuildMusicMarqueeView guildMusicMarqueeView9 = GuildMusicMarqueeView.this;
                                                    guildMarqueeAnimationAttr2.paddingLeft(guildMusicMarqueeView9.marqueeWidth - guildMusicMarqueeView9.marqueeLayoutFrame.getWidth());
                                                }
                                            }
                                            guildMarqueeAnimationAttr2.paddingLeft(0.0f);
                                        } else {
                                            guildMarqueeAnimationAttr2.paddingLeft(guildMusicMarqueeView7.marqueeWidth + 48.0f);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                final GuildMusicMarqueeView guildMusicMarqueeView5 = GuildMusicMarqueeView.this;
                                guildMarqueeAnimationView2.event(new Function1<GuildMarqueeAnimationEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildMusicMarqueeView.body.1.3.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(GuildMarqueeAnimationEvent guildMarqueeAnimationEvent) {
                                        GuildMarqueeAnimationEvent guildMarqueeAnimationEvent2 = guildMarqueeAnimationEvent;
                                        final GuildMusicMarqueeView guildMusicMarqueeView6 = GuildMusicMarqueeView.this;
                                        guildMarqueeAnimationEvent2.animationWillEnd = new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildMusicMarqueeView.body.1.3.1.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(Object obj) {
                                                GuildMusicMarqueeView.this.setUseSecondView(false);
                                                GuildMusicMarqueeView.this.setUseSecondView(true);
                                                GuildMusicMarqueeView.this.isFirstCreate = false;
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        final GuildMusicMarqueeView guildMusicMarqueeView7 = GuildMusicMarqueeView.this;
                                        guildMarqueeAnimationEvent2.animationDidEnd = new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildMusicMarqueeView.body.1.3.1.2.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(Object obj) {
                                                GuildMusicMarqueeView.this.setUseFirstView(false);
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        final GuildMusicMarqueeView guildMusicMarqueeView8 = GuildMusicMarqueeView.this;
                                        guildMarqueeAnimationEvent2.marqueeLayoutFrameChanged = new Function1<d, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildMusicMarqueeView.body.1.3.1.2.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(d dVar) {
                                                d dVar2 = dVar;
                                                GuildMusicMarqueeView guildMusicMarqueeView9 = GuildMusicMarqueeView.this;
                                                if (guildMusicMarqueeView9.isFirstCreate && dVar2 != null) {
                                                    guildMusicMarqueeView9.marqueeLayoutFrame = dVar2;
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final GuildMusicMarqueeView guildMusicMarqueeView3 = GuildMusicMarqueeView.this;
                Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildMusicMarqueeView$body$1.4
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        GuildMusicMarqueeView guildMusicMarqueeView4 = GuildMusicMarqueeView.this;
                        return Boolean.valueOf(((Boolean) guildMusicMarqueeView4.useSecondView$delegate.getValue(guildMusicMarqueeView4, GuildMusicMarqueeView.$$delegatedProperties[1])).booleanValue());
                    }
                };
                final GuildMusicMarqueeView guildMusicMarqueeView4 = GuildMusicMarqueeView.this;
                ConditionViewKt.c(viewContainer2, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildMusicMarqueeView$body$1.5
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final GuildMusicMarqueeView guildMusicMarqueeView5 = GuildMusicMarqueeView.this;
                        conditionView.addChild(new GuildMarqueeAnimationView(), new Function1<GuildMarqueeAnimationView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildMusicMarqueeView.body.1.5.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(GuildMarqueeAnimationView guildMarqueeAnimationView) {
                                GuildMarqueeAnimationView guildMarqueeAnimationView2 = guildMarqueeAnimationView;
                                final GuildMusicMarqueeView guildMusicMarqueeView6 = GuildMusicMarqueeView.this;
                                guildMarqueeAnimationView2.attr(new Function1<GuildMarqueeAnimationAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildMusicMarqueeView.body.1.5.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(GuildMarqueeAnimationAttr guildMarqueeAnimationAttr) {
                                        GuildMarqueeAnimationAttr guildMarqueeAnimationAttr2 = guildMarqueeAnimationAttr;
                                        Attr.absolutePosition$default(guildMarqueeAnimationAttr2, 0.0f, 0.0f, 0.0f, 0.0f, 12, null);
                                        guildMarqueeAnimationAttr2.marqueePerSecondTranslation = GuildMusicMarqueeView.access$getAttr(GuildMusicMarqueeView.this).marqueePerSecondTranslation;
                                        GuildMusicMarqueeView guildMusicMarqueeView7 = GuildMusicMarqueeView.this;
                                        guildMarqueeAnimationAttr2.marqueeViewWidth = guildMusicMarqueeView7.marqueeWidth;
                                        guildMarqueeAnimationAttr2.marqueeDirection = GuildMusicMarqueeView.access$getAttr(guildMusicMarqueeView7).marqueeDirection;
                                        final GuildMusicMarqueeView guildMusicMarqueeView8 = GuildMusicMarqueeView.this;
                                        guildMarqueeAnimationAttr2.viewCreator = new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildMusicMarqueeView.body.1.5.1.1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                                GuildMusicMarqueeView guildMusicMarqueeView9 = GuildMusicMarqueeView.this;
                                                KProperty<Object>[] kPropertyArr = GuildMusicMarqueeView.$$delegatedProperties;
                                                guildMusicMarqueeView9.getClass();
                                                new GuildMusicMarqueeView$createNextBatchMarquee$1(guildMusicMarqueeView9).invoke(viewContainer3);
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        int i3 = GuildMusicMarqueeView.access$getAttr(GuildMusicMarqueeView.this).maxMarqueeEachBatch;
                                        guildMarqueeAnimationAttr2.paddingLeft(GuildMusicMarqueeView.this.marqueeWidth + 48.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final GuildMusicMarqueeView guildMusicMarqueeView7 = GuildMusicMarqueeView.this;
                                guildMarqueeAnimationView2.event(new Function1<GuildMarqueeAnimationEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildMusicMarqueeView.body.1.5.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(GuildMarqueeAnimationEvent guildMarqueeAnimationEvent) {
                                        GuildMarqueeAnimationEvent guildMarqueeAnimationEvent2 = guildMarqueeAnimationEvent;
                                        final GuildMusicMarqueeView guildMusicMarqueeView8 = GuildMusicMarqueeView.this;
                                        guildMarqueeAnimationEvent2.animationWillEnd = new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildMusicMarqueeView.body.1.5.1.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(Object obj) {
                                                GuildMusicMarqueeView.this.setUseFirstView(false);
                                                GuildMusicMarqueeView.this.setUseFirstView(true);
                                                GuildMusicMarqueeView.this.isFirstCreate = false;
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        final GuildMusicMarqueeView guildMusicMarqueeView9 = GuildMusicMarqueeView.this;
                                        guildMarqueeAnimationEvent2.animationDidEnd = new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildMusicMarqueeView.body.1.5.1.2.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(Object obj) {
                                                GuildMusicMarqueeView.this.setUseSecondView(false);
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final GuildMusicMarqueeView guildMusicMarqueeView5 = GuildMusicMarqueeView.this;
                viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildMusicMarqueeView$body$1.6
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Event event) {
                        final GuildMusicMarqueeView guildMusicMarqueeView6 = GuildMusicMarqueeView.this;
                        FrameEventKt.d(event, new Function1<d, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildMusicMarqueeView.body.1.6.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(d dVar) {
                                d dVar2 = dVar;
                                GuildMusicMarqueeView guildMusicMarqueeView7 = GuildMusicMarqueeView.this;
                                if (guildMusicMarqueeView7.isFirstCreate) {
                                    guildMusicMarqueeView7.marqueeWidth = dVar2.getWidth();
                                    GuildMusicMarqueeView.this.setUseFirstView(false);
                                    GuildMusicMarqueeView.this.setUseFirstView(true);
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
        return new GuildMusicMarqueeAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new GuildMusicMarqueeEvent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView, com.tencent.kuikly.core.base.AbstractBaseView
    public final void didInit() {
        float U = getFlexNode().U();
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        if (Float.isNaN(U) || Float.isNaN(Float.NaN) ? Float.isNaN(U) && Float.isNaN(Float.NaN) : Math.abs(Float.NaN - U) < 1.0E-5f) {
            this.marqueeWidth = getPagerData().m();
        }
        ((GuildMusicMarqueeAttr) getAttr()).overflow(true);
        ((GuildMusicMarqueeAttr) getAttr()).justifyContentFlexEnd();
        super.didInit();
    }

    public final void setUseFirstView(boolean z16) {
        this.useFirstView$delegate.setValue(this, $$delegatedProperties[0], Boolean.valueOf(z16));
    }

    public final void setUseSecondView(boolean z16) {
        this.useSecondView$delegate.setValue(this, $$delegatedProperties[1], Boolean.valueOf(z16));
    }
}
