package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.b;
import com.tencent.kuikly.core.base.event.AnimationCompletionParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.FrameEventKt;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.base.y;
import com.tencent.kuikly.core.layout.d;
import com.tencent.kuikly.core.timer.TimerKt;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class GuildMarqueeAnimationView extends ComposeView<GuildMarqueeAnimationAttr, GuildMarqueeAnimationEvent> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GuildMarqueeAnimationView.class, QZoneJsConstants.ACTION_START_ANIMATION, "getStartAnimation()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GuildMarqueeAnimationView.class, "animationDuration", "getAnimationDuration()F", 0)};
    public final ReadWriteProperty startAnimation$delegate = c.a(Boolean.FALSE);
    public final ReadWriteProperty animationDuration$delegate = c.a(Float.valueOf(0.3f));

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ GuildMarqueeAnimationAttr access$getAttr(GuildMarqueeAnimationView guildMarqueeAnimationView) {
        return (GuildMarqueeAnimationAttr) guildMarqueeAnimationView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ GuildMarqueeAnimationEvent access$getEvent(GuildMarqueeAnimationView guildMarqueeAnimationView) {
        return (GuildMarqueeAnimationEvent) guildMarqueeAnimationView.getEvent();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildMarqueeAnimationView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final GuildMarqueeAnimationView guildMarqueeAnimationView = GuildMarqueeAnimationView.this;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildMarqueeAnimationView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.flexDirectionRow();
                        if (GuildMarqueeAnimationView.this.getStartAnimation()) {
                            if (GuildMarqueeAnimationView.access$getAttr(GuildMarqueeAnimationView.this).marqueeDirection == 2) {
                                mVar2.transform(new y(0.0f, 0.0f, 0.0f, 0.0f, 12, null));
                            } else {
                                mVar2.transform(new y(-1.0f, 0.0f, 0.0f, 0.0f, 12, null));
                            }
                        } else if (GuildMarqueeAnimationView.access$getAttr(GuildMarqueeAnimationView.this).marqueeDirection == 2) {
                            mVar2.transform(new y(-1.0f, 0.0f, 0.0f, 0.0f, 12, null));
                        } else {
                            mVar2.transform(new y(0.0f, 0.0f, 0.0f, 0.0f, 12, null));
                        }
                        b.Companion companion = b.INSTANCE;
                        GuildMarqueeAnimationView guildMarqueeAnimationView2 = GuildMarqueeAnimationView.this;
                        mVar2.m134animation(b.Companion.l(companion, ((Number) guildMarqueeAnimationView2.animationDuration$delegate.getValue(guildMarqueeAnimationView2, GuildMarqueeAnimationView.$$delegatedProperties[1])).floatValue(), null, 2, null), (Object) Boolean.valueOf(GuildMarqueeAnimationView.this.getStartAnimation()));
                        return Unit.INSTANCE;
                    }
                });
                final GuildMarqueeAnimationView guildMarqueeAnimationView2 = GuildMarqueeAnimationView.this;
                viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildMarqueeAnimationView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Event event) {
                        final Event event2 = event;
                        final GuildMarqueeAnimationView guildMarqueeAnimationView3 = GuildMarqueeAnimationView.this;
                        FrameEventKt.d(event2, new Function1<d, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildMarqueeAnimationView.body.1.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(d dVar) {
                                d dVar2 = dVar;
                                Function1<? super d, Unit> function1 = GuildMarqueeAnimationView.access$getEvent(GuildMarqueeAnimationView.this).marqueeLayoutFrameChanged;
                                if (function1 != null) {
                                    function1.invoke(dVar2);
                                }
                                if (!GuildMarqueeAnimationView.this.getStartAnimation() && dVar2.getWidth() > GuildMarqueeAnimationView.access$getAttr(GuildMarqueeAnimationView.this).marqueeViewWidth) {
                                    GuildMarqueeAnimationView guildMarqueeAnimationView4 = GuildMarqueeAnimationView.this;
                                    float width = dVar2.getWidth() / GuildMarqueeAnimationView.access$getAttr(GuildMarqueeAnimationView.this).marqueePerSecondTranslation;
                                    ReadWriteProperty readWriteProperty = guildMarqueeAnimationView4.animationDuration$delegate;
                                    KProperty<?>[] kPropertyArr = GuildMarqueeAnimationView.$$delegatedProperties;
                                    readWriteProperty.setValue(guildMarqueeAnimationView4, kPropertyArr[1], Float.valueOf(width));
                                    GuildMarqueeAnimationView guildMarqueeAnimationView5 = GuildMarqueeAnimationView.this;
                                    guildMarqueeAnimationView5.startAnimation$delegate.setValue(guildMarqueeAnimationView5, kPropertyArr[0], Boolean.TRUE);
                                    float width2 = (dVar2.getWidth() - GuildMarqueeAnimationView.access$getAttr(GuildMarqueeAnimationView.this).marqueeViewWidth) / GuildMarqueeAnimationView.access$getAttr(GuildMarqueeAnimationView.this).marqueePerSecondTranslation;
                                    Event event3 = event2;
                                    final GuildMarqueeAnimationView guildMarqueeAnimationView6 = GuildMarqueeAnimationView.this;
                                    Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildMarqueeAnimationView.body.1.2.1.1
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public final Unit invoke() {
                                            Function1<Object, Unit> function12 = GuildMarqueeAnimationView.access$getEvent(GuildMarqueeAnimationView.this).animationWillEnd;
                                            if (function12 != null) {
                                                function12.invoke(null);
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    KProperty<Object>[] kPropertyArr2 = IPagerIdKtxKt.$$delegatedProperties;
                                    TimerKt.e(event3.getPagerId(), (int) ((width2 * 1000) - 30), function0);
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        final GuildMarqueeAnimationView guildMarqueeAnimationView4 = GuildMarqueeAnimationView.this;
                        event2.animationCompletion(new Function1<AnimationCompletionParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildMarqueeAnimationView.body.1.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(AnimationCompletionParams animationCompletionParams) {
                                Function1<Object, Unit> function1 = GuildMarqueeAnimationView.access$getEvent(GuildMarqueeAnimationView.this).animationDidEnd;
                                if (function1 != null) {
                                    function1.invoke(null);
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                Function1<? super ViewContainer<?, ?>, Unit> function1 = GuildMarqueeAnimationView.access$getAttr(GuildMarqueeAnimationView.this).viewCreator;
                if (function1 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewCreator");
                    function1 = null;
                }
                function1.invoke(viewContainer2);
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new GuildMarqueeAnimationAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new GuildMarqueeAnimationEvent();
    }

    public final boolean getStartAnimation() {
        return ((Boolean) this.startAnimation$delegate.getValue(this, $$delegatedProperties[0])).booleanValue();
    }
}
