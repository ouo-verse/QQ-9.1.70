package com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import ap3.a;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSBottomDynamicGuideEvent;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.GuideBannerCardAnimationViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.foundation.lib.vas_report_utils.VasBusinessReportData$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyFormatUtils;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyProUtilsKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.StrangerUtilsKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.ClickLocation;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPLikeData;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPLikeNumAttr;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPLikeNumberView;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPLikeNumberViewKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.TextViewExtKt;
import com.tencent.hippykotlin.demo.pages.nearby.compose_base.view.QQStrangerImageKt;
import com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyContentFeedAvatarViewKt;
import com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPContentFeedAvatarView;
import com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPContentFeedAvatarViewAttr;
import com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPContentFeedAvatarViewEvent;
import com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPAvatarViewKt;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.e;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.FrameEventKt;
import com.tencent.kuikly.core.base.event.LongPressParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.base.t;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.av;
import com.tencent.kuikly.core.views.aw;
import com.tencent.kuikly.core.views.ax;
import com.tencent.kuikly.core.views.ay;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.MotionEvent;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.ButtonKt;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.KuiklyKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.an;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.ntcompose.ui.platform.CompositionLocalsKt;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.random.Random;
import kotlin.text.StringsKt__StringsJVMKt;
import n35.z;
import o25.f;
import p35.ag;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class NearbyFeedItemViewKt {
    public static final void NearbyFeedItemView(final NearbyFeedItemViewModel nearbyFeedItemViewModel, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-1619743800);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1619743800, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemView (NearbyFeedItemView.kt:77)");
        }
        ColumnKt.a(ViewEventPropUpdaterKt.l(ComposeLayoutPropUpdaterKt.z(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null)), new Function1<a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt$NearbyFeedItemView$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(a aVar) {
                NearbyFeedItemViewModel.this.offsetY = aVar.getY();
                return Unit.INSTANCE;
            }
        }), null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 475529663, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt$NearbyFeedItemView$2
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(d dVar, Composer composer2, Integer num) {
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(475529663, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemView.<anonymous> (NearbyFeedItemView.kt:82)");
                    }
                    i.Companion companion = i.INSTANCE;
                    final NearbyFeedItemViewModel nearbyFeedItemViewModel2 = NearbyFeedItemViewModel.this;
                    NearbyFeedItemViewKt.access$HeaderView(ViewEventPropUpdaterKt.g(companion, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt$NearbyFeedItemView$2.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(Object obj) {
                            NearbyFeedItemViewModel nearbyFeedItemViewModel3 = NearbyFeedItemViewModel.this;
                            nearbyFeedItemViewModel3.onReportExpose.invoke(nearbyFeedItemViewModel3.feed, Float.valueOf(nearbyFeedItemViewModel3.offsetY));
                            return Unit.INSTANCE;
                        }
                    }), NearbyFeedItemViewModel.this, composer3, 72);
                    final NearbyFeedItemViewModel nearbyFeedItemViewModel3 = NearbyFeedItemViewModel.this;
                    Function1<LongPressParams, Unit> function1 = new Function1<LongPressParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt$NearbyFeedItemView$2$contentModifier$1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(LongPressParams longPressParams) {
                            NearbyFeedItemViewModel.this.onLongPressContent();
                            return Unit.INSTANCE;
                        }
                    };
                    final NearbyFeedItemViewModel nearbyFeedItemViewModel4 = NearbyFeedItemViewModel.this;
                    Function1<ClickParams, Unit> function12 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt$NearbyFeedItemView$2$contentModifier$2
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ClickParams clickParams) {
                            ClickParams clickParams2 = clickParams;
                            NearbyFeedItemViewModel nearbyFeedItemViewModel5 = NearbyFeedItemViewModel.this;
                            float x16 = clickParams2.getX();
                            float y16 = clickParams2.getY();
                            nearbyFeedItemViewModel5.getClass();
                            AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onDoubleClickContent "), nearbyFeedItemViewModel5.feed.f425193d, KLog.INSTANCE, "NearbyFeedItemViewModel");
                            NBPLikeData nBPLikeData = nearbyFeedItemViewModel5.likeData;
                            nBPLikeData.doubleClickLocation = new ClickLocation(x16, y16);
                            nBPLikeData.setDoubleClickAnimation(true);
                            if (!nearbyFeedItemViewModel5.meLiked) {
                                nearbyFeedItemViewModel5.onClickLike();
                            }
                            return Unit.INSTANCE;
                        }
                    };
                    final NearbyFeedItemViewModel nearbyFeedItemViewModel5 = NearbyFeedItemViewModel.this;
                    i f16 = ViewEventPropUpdaterKt.f(companion, false, null, null, function1, function12, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt$NearbyFeedItemView$2$contentModifier$3
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ClickParams clickParams) {
                            NearbyFeedItemViewModel.this.onClickContent();
                            return Unit.INSTANCE;
                        }
                    }, 7, null);
                    if (NearbyFeedItemViewModel.this.isOnlyText) {
                        composer3.startReplaceableGroup(-1152400280);
                        NearbyFeedItemViewKt.access$TextContentView(f16, NearbyFeedItemViewModel.this, composer3, 72);
                        composer3.endReplaceableGroup();
                    } else {
                        composer3.startReplaceableGroup(-1152400214);
                        NearbyFeedItemViewKt.access$ImageContentView(f16, NearbyFeedItemViewModel.this, composer3, 72);
                        composer3.endReplaceableGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 24584, 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt$NearbyFeedItemView$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                NearbyFeedItemViewKt.NearbyFeedItemView(NearbyFeedItemViewModel.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void access$DoubleClickLikeAnimation(final NearbyFeedItemViewModel nearbyFeedItemViewModel, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(585078631);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(585078631, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.DoubleClickLikeAnimation (NearbyFeedItemView.kt:517)");
        }
        KuiklyKt.a(null, ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt$DoubleClickLikeAnimation$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final NearbyFeedItemViewModel nearbyFeedItemViewModel2 = NearbyFeedItemViewModel.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt$DoubleClickLikeAnimation$1.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(NearbyFeedItemViewModel.this.likeData.getDoubleClickAnimation());
                    }
                };
                final NearbyFeedItemViewModel nearbyFeedItemViewModel3 = NearbyFeedItemViewModel.this;
                ConditionViewKt.c(viewContainer, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt$DoubleClickLikeAnimation$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final NearbyFeedItemViewModel nearbyFeedItemViewModel4 = NearbyFeedItemViewModel.this;
                        ay.a(conditionView, new Function1<ax, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt.DoubleClickLikeAnimation.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ax axVar) {
                                ax axVar2 = axVar;
                                final NearbyFeedItemViewModel nearbyFeedItemViewModel5 = NearbyFeedItemViewModel.this;
                                axVar2.attr(new Function1<av, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt.DoubleClickLikeAnimation.1.2.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(av avVar) {
                                        av avVar2 = avVar;
                                        avVar2.positionAbsolute();
                                        ClickLocation clickLocation = NearbyFeedItemViewModel.this.likeData.doubleClickLocation;
                                        avVar2.m142left(clickLocation.f114210x - 53.5f);
                                        avVar2.m150top(clickLocation.f114211y - 67.5f);
                                        avVar2.src("https://image.superqqshow.qq.com/files/3c6784d9_ZBp37qLwtTO.json");
                                        avVar2.size(107.0f, 135.0f);
                                        avVar2.m154zIndex(1);
                                        avVar2.transform(new t(Random.INSTANCE.nextInt(-10, 11), 0.0f, 0.0f, 6, null));
                                        avVar2.h(false);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NearbyFeedItemViewModel nearbyFeedItemViewModel6 = NearbyFeedItemViewModel.this;
                                axVar2.event(new Function1<aw, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt.DoubleClickLikeAnimation.1.2.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(aw awVar) {
                                        aw awVar2 = awVar;
                                        final NearbyFeedItemViewModel nearbyFeedItemViewModel7 = NearbyFeedItemViewModel.this;
                                        FrameEventKt.g(awVar2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt.DoubleClickLikeAnimation.1.2.1.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(Object obj) {
                                                NearbyFeedItemViewModel.this.likeData.setDoubleClickAnimation(false);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NearbyFeedItemViewModel nearbyFeedItemViewModel8 = NearbyFeedItemViewModel.this;
                                        awVar2.h(new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt.DoubleClickLikeAnimation.1.2.1.2.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(Object obj) {
                                                NearbyFeedItemViewModel.this.likeData.setDoubleClickAnimation(false);
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
        }, startRestartGroup, 64, 1);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt$DoubleClickLikeAnimation$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                NearbyFeedItemViewKt.access$DoubleClickLikeAnimation(NearbyFeedItemViewModel.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void access$FeedActions(final i iVar, final NearbyFeedItemViewModel nearbyFeedItemViewModel, Composer composer, final int i3) {
        final h m3;
        Composer startRestartGroup = composer.startRestartGroup(1785067745);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1785067745, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.FeedActions (NearbyFeedItemView.kt:394)");
        }
        final boolean z16 = nearbyFeedItemViewModel.isOnlyText;
        if (z16) {
            m3 = h.INSTANCE.b();
        } else {
            m3 = h.INSTANCE.m();
        }
        RowKt.a(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(iVar, 0.0f, 1, null), 48.0f), 12.0f, 0.0f, 12.0f, 0.0f, 10, null), com.tencent.ntcompose.foundation.layout.base.a.f339245a.e(), Alignment.INSTANCE.c(), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 719147779, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt$FeedActions$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(n nVar, Composer composer2, Integer num) {
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(719147779, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.FeedActions.<anonymous> (NearbyFeedItemView.kt:402)");
                    }
                    i.Companion companion = i.INSTANCE;
                    i w3 = ComposeLayoutPropUpdaterKt.w(companion, 72.0f);
                    final NearbyFeedItemViewModel nearbyFeedItemViewModel2 = NearbyFeedItemViewModel.this;
                    i d16 = ViewEventPropUpdaterKt.d(w3, false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt$FeedActions$1.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ClickParams clickParams) {
                            NearbyFeedItemViewModel.this.onClickLike();
                            return Unit.INSTANCE;
                        }
                    }, 3, null);
                    Alignment.Companion companion2 = Alignment.INSTANCE;
                    Alignment.Vertical c16 = companion2.c();
                    final NearbyFeedItemViewModel nearbyFeedItemViewModel3 = NearbyFeedItemViewModel.this;
                    final boolean z17 = z16;
                    final h hVar = m3;
                    RowKt.a(d16, null, c16, null, null, ComposableLambdaKt.composableLambda(composer3, 1052787109, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt$FeedActions$1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(n nVar2, Composer composer4, Integer num2) {
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1052787109, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.FeedActions.<anonymous>.<anonymous> (NearbyFeedItemView.kt:408)");
                                }
                                final NearbyFeedItemViewModel nearbyFeedItemViewModel4 = NearbyFeedItemViewModel.this;
                                final boolean z18 = z17;
                                KuiklyKt.a(null, null, new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt.FeedActions.1.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                                        final NearbyFeedItemViewModel nearbyFeedItemViewModel5 = NearbyFeedItemViewModel.this;
                                        final boolean z19 = z18;
                                        w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt.FeedActions.1.2.1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar) {
                                                v vVar2 = vVar;
                                                vVar2.attr(new Function1<com.tencent.kuikly.core.views.t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt.FeedActions.1.2.1.1.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(com.tencent.kuikly.core.views.t tVar) {
                                                        com.tencent.kuikly.core.views.t tVar2 = tVar;
                                                        tVar2.margin(4.0f);
                                                        tVar2.size(24.0f, 24.0f);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NearbyFeedItemViewModel nearbyFeedItemViewModel6 = NearbyFeedItemViewModel.this;
                                                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt.FeedActions.1.2.1.1.2
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Object invoke() {
                                                        return Boolean.valueOf(NearbyFeedItemViewModel.this.likeData.getIcon().iconAnimation);
                                                    }
                                                };
                                                final NearbyFeedItemViewModel nearbyFeedItemViewModel7 = NearbyFeedItemViewModel.this;
                                                final boolean z26 = z19;
                                                ConditionViewKt.c(vVar2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt.FeedActions.1.2.1.1.3
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ConditionView conditionView) {
                                                        final NearbyFeedItemViewModel nearbyFeedItemViewModel8 = NearbyFeedItemViewModel.this;
                                                        final boolean z27 = z26;
                                                        ay.a(conditionView, new Function1<ax, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt.FeedActions.1.2.1.1.3.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ax axVar) {
                                                                ax axVar2 = axVar;
                                                                final NearbyFeedItemViewModel nearbyFeedItemViewModel9 = NearbyFeedItemViewModel.this;
                                                                final boolean z28 = z27;
                                                                axVar2.attr(new Function1<av, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt.FeedActions.1.2.1.1.3.1.1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(av avVar) {
                                                                        String str;
                                                                        String str2;
                                                                        av avVar2 = avVar;
                                                                        avVar2.positionAbsolute();
                                                                        avVar2.m142left(-8.0f);
                                                                        avVar2.m150top(-8.0f);
                                                                        avVar2.h(false);
                                                                        avVar2.size(40.0f, 40.0f);
                                                                        if (NearbyFeedItemViewModel.this.likeData.getIcon().isLiked) {
                                                                            if (z28) {
                                                                                str2 = "https://image.superqqshow.qq.com/files/3c6784d9_55FdJSnLGKG.json";
                                                                            } else {
                                                                                str2 = "https://image.superqqshow.qq.com/files/3c6784d9_7tYJi6oYD-1.json";
                                                                            }
                                                                            avVar2.src(str2);
                                                                        } else {
                                                                            if (z28) {
                                                                                str = "https://image.superqqshow.qq.com/files/3c6784d9_c983EAY1cWP.json";
                                                                            } else {
                                                                                str = "https://image.superqqshow.qq.com/files/3c6784d9_KCsvbm0RM64.json";
                                                                            }
                                                                            avVar2.src(str);
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final NearbyFeedItemViewModel nearbyFeedItemViewModel10 = NearbyFeedItemViewModel.this;
                                                                axVar2.event(new Function1<aw, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt.FeedActions.1.2.1.1.3.1.2
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(aw awVar) {
                                                                        aw awVar2 = awVar;
                                                                        final NearbyFeedItemViewModel nearbyFeedItemViewModel11 = NearbyFeedItemViewModel.this;
                                                                        FrameEventKt.g(awVar2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt.FeedActions.1.2.1.1.3.1.2.1
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(Object obj) {
                                                                                NearbyFeedItemViewModel.this.likeData.resetIconAnimation();
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        final NearbyFeedItemViewModel nearbyFeedItemViewModel12 = NearbyFeedItemViewModel.this;
                                                                        awVar2.i(new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt.FeedActions.1.2.1.1.3.1.2.2
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(Object obj) {
                                                                                NearbyFeedItemViewModel.this.likeData.startIconAnimation();
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        final NearbyFeedItemViewModel nearbyFeedItemViewModel13 = NearbyFeedItemViewModel.this;
                                                                        awVar2.h(new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt.FeedActions.1.2.1.1.3.1.2.3
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(Object obj) {
                                                                                NearbyFeedItemViewModel.this.likeData.resetIconAnimation();
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
                                                final NearbyFeedItemViewModel nearbyFeedItemViewModel8 = NearbyFeedItemViewModel.this;
                                                final boolean z27 = z19;
                                                ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt.FeedActions.1.2.1.1.4
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ImageView imageView) {
                                                        final NearbyFeedItemViewModel nearbyFeedItemViewModel9 = NearbyFeedItemViewModel.this;
                                                        final boolean z28 = z27;
                                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt.FeedActions.1.2.1.1.4.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(af afVar) {
                                                                String str;
                                                                af afVar2 = afVar;
                                                                afVar2.m142left(-8.0f);
                                                                afVar2.m150top(-8.0f);
                                                                afVar2.size(40.0f, 40.0f);
                                                                if (NearbyFeedItemViewModel.this.likeData.staticLiked()) {
                                                                    b.a.b(afVar2, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAHgAAAB4CAMAAAAOusbgAAAAn1BMVEUAAADlJVLkKVj3U1ziI1n5V1vnLVrhIVreGVrlKlr6VFrfGlr7WFriHFvxQ1r7WFv5U1r4VFr2TVj1UFzwQlr4VVr0SlvaFFnsOlr6WVruPVrrN1nbE1ntPVnpM1ruO1r6V1vwQFruPFr0SVrsOFr3UFryRFr2TFrnLFrrNFrlJ1r5U1roMFrhIFrjJFr6V1rqMlrgG1rdGFrzRlrcFFo3ph39AAAAIXRSTlMAECAgz+/f38+gX++fL7+8f29DMO/fn1/fz891v6+QX4++ml+yAAACL0lEQVRo3u2SfXOiMBCHgx7tlXoqWFtbr+0JBd9AsPb7f7bbJTCL9mUwG/lrn5BfNlmHZ8ioBEEQBEEQBEEQBEEQfsDxB49unrujgdc/6XhlJ38c+dCxTDDKGwwagsnAzYmRZ1XbJ+2J2vl32pla/GrPzbcABGaORT6dlJ873eotJKB7Y1ve8fZL4FID98vO2KY33saxDki9+AHWGmziUjbtmL3YAJ/v7U9NxG6fLb6Pl0hchh66ijHrpj7EqI6GXO9kaUjA/WB4RxRFSwACoD1W1YMHdRXpZH5yPzLGYYk9c7HPu+kIOESHAyaEnlSUEzOhX+ECxT1LPEzO40DlE0t8lxhzxxIvgCTBgFEtelsV2K5WPXXgwha3B6UE76oXxvCuemYu5v25nsMwXIRNWh0gzyzxPDTmlSWemIt7isXwrTXh0W6oeMzfDHlVTGb0rjU+R6xh0AYnBlYzxSVYG9FTbF7gNQVMSD2LegsLFXWt93PFx3kqzuZF2cC5Sos0hQl5QlEtVR+izBtlh95Vehbk5ZtXKQwNlVTUD4Jem+bWgLdbM3ltmzc4mqxWzY0+AK9186YFv5R9eteb3e6zanfkdRRg3wyaHyGvbTPLyzdnOLJsB4GlPruMl8zZtzC8HDN6L8qfW4aXad7v9xlMnRW/L+klM8HwMs3vXXjJ/H5ER140M7w8Hj5A+AF05iVzTUdeMt9q719HdUzv5hq0D0oQBEEQBEEQBEEQBKE9/wFFiEq+642ELgAAAABJRU5ErkJggg==", false, 2, null);
                                                                } else {
                                                                    if (z28) {
                                                                        str = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAHgAAAB4CAMAAAAOusbgAAAAM1BMVEUAAAAKCw4ICAsLDA4LCw0QEBALDA4KDA4LDA0KCw0KCwsJCw4KDA0KDAwMDA4LDA4LDA4GWpimAAAAEHRSTlMA3yDvXhDPf7+gMHCvQJCPzyHOpQAAAcFJREFUaN7t2NlugzAQhWG8ADZLMu//tC2E9KQ0oOJx5ur8V1Wt6IsXFqVhjDHGGGOMMcYYO6kdcxdEQsrR70biOiLdNPrq7JzkpfwCDDkISrEq68Hu6Pa+H3EVZx23ObmUp/T8e1in62QtpJxTt9F9Lbd/SM8NHPqHFr83IKxqv434mCBXckP89a+wysODbRsUXTU5rmem3W26W82fJUftbRkZVSSI/Pfi6nCU3qxQ0J+wvFygDYIMd9e0LJHWHQ4vkNadjchcYcLxaBOOLtmon7JfJnw4eLiRyza0uiNddkJHfEyx0kPZQmUVnERCU1DApVBWKDwlHb5wWSIylW6RCi7dqwmw7VIn7VI7XMa2h2squxP43dkouxPEsvtOVD8jUtEOifLBmAoeNHhIKNc6lUxY/Zrrrr9C3fFIUzTL1a/fC3ZY0+2i3Nd4zcTLVbzk3rQoXqFkvuBmPYo33DBYu5CtXcjWLmRrF7KxC9mfungIV5edP3fb6ixkaxeytQvZzoUc3soj3E81QEbx4y5kaxeytQvZ2oVs7UI2dzfOeWMX8pRMXchi7+KX5ATXKJ/d+ns8Y4wxxhhjjDHG2P/7AkJjInCMtIwFAAAAAElFTkSuQmCC";
                                                                    } else {
                                                                        str = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAHgAAAB4CAMAAAAOusbgAAAAOVBMVEUAAAD///////////////////////////////////////////////////////////////////////8KOjVvAAAAEnRSTlMA3yDvEM9/v18woGCfr0JwkG+63umMAAABw0lEQVRo3u3Y23KCMBSFYZMACUd1v//DtkSdZakwJTvdV+u/6pRpP8kBMl4YY4wxxhhjjDHGDmruUxtEQpyS31wZ8xVp57uvzi5R3pregH4IgmKqynqwG7q5ySZX8a5TeP7POM3x9XOfb9fJ2joBU2yfdFfL7R7SawL77qGl7wkIWe2eV/wYIVdyQ/rxq5Dl/sE2FzS6avKY10yzmXSXzeeQv8KkX1UkiOH35mqxlD6MUNCvsGHdoBcEGe6meR0irdvvbpDGHV2RpcINp71J2Nuyi/6W/XrDuxd3J3Kdhka3pMtW6BV/phjpvmygJhUcRcKloICtUFYoXCUtPnBZIjKXTpEKLp2rGbDtUEftUDtsY9vFNZc9CfxmbZQ9Ccay505SvyNi0QyJ8sUYS140Iz6uaqxjyQ2rj7nu/BHqhleaokXOfvxOMMOabiflrsYxE4erdMq9aVEcoWQ54Q56FCfc0Fu7kK1dyNYuZGsXsrEL2R+6eAlXl50/dpvqLGRrF7K1C9nOhRw+ygnuf9VDtnQhW7uQrV3I1i5kaxeymYtGybKxC3mOpi5kMXQhB8lFuEb5weXv4xljjDHGGGOMMcb+3hc8HyZzil1rvAAAAABJRU5ErkJggg==";
                                                                    }
                                                                    b.a.b(afVar2, str, false, 2, null);
                                                                }
                                                                afVar2.m152visibility(NearbyFeedItemViewModel.this.likeData.showStatic());
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
                                }, composer5, 0, 3);
                                final h hVar2 = hVar;
                                final NearbyFeedItemViewModel nearbyFeedItemViewModel5 = NearbyFeedItemViewModel.this;
                                KuiklyKt.a(null, null, new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt.FeedActions.1.2.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                                        final h hVar3 = h.this;
                                        final NearbyFeedItemViewModel nearbyFeedItemViewModel6 = nearbyFeedItemViewModel5;
                                        NBPLikeNumberViewKt.NBPLikeNumber(viewContainer, new Function1<NBPLikeNumberView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt.FeedActions.1.2.2.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(NBPLikeNumberView nBPLikeNumberView) {
                                                final h hVar4 = h.this;
                                                final NearbyFeedItemViewModel nearbyFeedItemViewModel7 = nearbyFeedItemViewModel6;
                                                nBPLikeNumberView.attr(new Function1<NBPLikeNumAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt.FeedActions.1.2.2.1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(NBPLikeNumAttr nBPLikeNumAttr) {
                                                        NBPLikeNumAttr nBPLikeNumAttr2 = nBPLikeNumAttr;
                                                        nBPLikeNumAttr2.mo141height(18.0f);
                                                        nBPLikeNumAttr2.overflow(true);
                                                        nBPLikeNumAttr2.fontSize = 16.0f;
                                                        nBPLikeNumAttr2.innerHeight = 18.0f;
                                                        nBPLikeNumAttr2.fontWeight = 400;
                                                        nBPLikeNumAttr2.color = h.this;
                                                        nBPLikeNumAttr2.setData(nearbyFeedItemViewModel7.likeData);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                }, composer5, 0, 3);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 196616, 26);
                    i w16 = ComposeLayoutPropUpdaterKt.w(companion, 72.0f);
                    final NearbyFeedItemViewModel nearbyFeedItemViewModel4 = NearbyFeedItemViewModel.this;
                    i d17 = ViewEventPropUpdaterKt.d(w16, false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt$FeedActions$1.3
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ClickParams clickParams) {
                            String str;
                            NearbyFeedItemViewModel nearbyFeedItemViewModel5 = NearbyFeedItemViewModel.this;
                            if (!nearbyFeedItemViewModel5.fastClickUtils.isFastDoubleClick()) {
                                nearbyFeedItemViewModel5.reportClick(2);
                                s35.af afVar = nearbyFeedItemViewModel5.feed.f425194e;
                                if (afVar == null || (str = StrangerUtilsKt.getUserId(afVar, 2)) == null) {
                                    str = "0";
                                }
                                String str2 = str;
                                UserDataManager userDataManager = UserDataManager.INSTANCE;
                                String valueOf = String.valueOf(userDataManager.getUserSelfInfo().tid);
                                String str3 = userDataManager.getUserSelfInfo().nickName;
                                String str4 = userDataManager.getUserSelfInfo().avatarUrl;
                                AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(VasBusinessReportData$$ExternalSyntheticOutline0.m(VasBusinessReportData$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("open comment view: "), nearbyFeedItemViewModel5.feed.f425193d, ", ", str2, ", "), valueOf, ", ", str3, ", "), str4, KLog.INSTANCE, "NearbyFeedItemViewModel");
                                QQNearbyModule.Companion.getInstance().openFeedCommentPage(2, 2, valueOf, str3, str4, str2, nearbyFeedItemViewModel5.feed.f425193d);
                            }
                            return Unit.INSTANCE;
                        }
                    }, 3, null);
                    Alignment.Vertical c17 = companion2.c();
                    final h hVar2 = m3;
                    final NearbyFeedItemViewModel nearbyFeedItemViewModel5 = NearbyFeedItemViewModel.this;
                    RowKt.a(d17, null, c17, null, null, ComposableLambdaKt.composableLambda(composer3, 389719324, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt$FeedActions$1.4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(n nVar2, Composer composer4, Integer num2) {
                            String valueOf;
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(389719324, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.FeedActions.<anonymous>.<anonymous> (NearbyFeedItemView.kt:480)");
                                }
                                ImageKt.a("https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_hsSty9_X1fp.png", null, null, null, null, ComposeLayoutPropUpdaterKt.l(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 24.0f), 4.0f), null, com.tencent.ntcompose.material.h.INSTANCE.c(), null, null, null, null, null, null, null, null, null, null, null, h.this, null, composer5, 12845062, 1073741824, 0, 1572702);
                                if (((Number) nearbyFeedItemViewModel5.commentCount$delegate.getValue()).intValue() == 0) {
                                    valueOf = "\u8bc4\u8bba";
                                } else {
                                    valueOf = String.valueOf(((Number) nearbyFeedItemViewModel5.commentCount$delegate.getValue()).intValue());
                                }
                                TextKt.a(TextViewExtKt.fixLineHeightForView(valueOf), null, null, h.this, Float.valueOf(16.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer5, 28672, 0, 0, 134217702);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 196616, 26);
                    i w17 = ComposeLayoutPropUpdaterKt.w(companion, 72.0f);
                    final NearbyFeedItemViewModel nearbyFeedItemViewModel6 = NearbyFeedItemViewModel.this;
                    i d18 = ViewEventPropUpdaterKt.d(w17, false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt$FeedActions$1.5
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ClickParams clickParams) {
                            NearbyFeedItemViewModel nearbyFeedItemViewModel7 = NearbyFeedItemViewModel.this;
                            if (!nearbyFeedItemViewModel7.fastClickUtils.isFastDoubleClick()) {
                                nearbyFeedItemViewModel7.reportClick(3);
                                if (NearbyProUtilsKt.isCityWalk(nearbyFeedItemViewModel7.feed)) {
                                    KLog.INSTANCE.i("NearbyFeedItemViewModel", "onShareClick is citywalk");
                                    ((BridgeModule) c.f117352a.g().acquireModule("HRBridgeModule")).qToast("\u6b64\u7c7b\u578b\u52a8\u6001\u4e0d\u652f\u6301\u5206\u4eab", QToastMode.Info);
                                } else {
                                    AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onShareClick: "), nearbyFeedItemViewModel7.feed.f425193d, KLog.INSTANCE, "NearbyFeedItemViewModel");
                                    QQNearbyModule.openFeedShare$default(QQNearbyModule.Companion.getInstance(), 2, 2, null, nearbyFeedItemViewModel7.feed, false, null, 52);
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }, 3, null);
                    Alignment.Vertical c18 = companion2.c();
                    final h hVar3 = m3;
                    RowKt.a(d18, null, c18, null, null, ComposableLambdaKt.composableLambda(composer3, 1674781853, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt$FeedActions$1.6
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(n nVar2, Composer composer4, Integer num2) {
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1674781853, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.FeedActions.<anonymous>.<anonymous> (NearbyFeedItemView.kt:500)");
                                }
                                ImageKt.a("https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_Ig7vZhM2U_j.png", null, null, null, null, ComposeLayoutPropUpdaterKt.l(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 24.0f), 4.0f), null, com.tencent.ntcompose.material.h.INSTANCE.c(), null, null, null, null, null, null, null, null, null, null, null, h.this, null, composer5, 12845062, 1073741824, 0, 1572702);
                                TextKt.a(TextViewExtKt.fixLineHeightForView("\u5206\u4eab"), null, null, h.this, Float.valueOf(16.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer5, 28672, 0, 0, 134217702);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 196616, 26);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 196680, 24);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt$FeedActions$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                NearbyFeedItemViewKt.access$FeedActions(i.this, nearbyFeedItemViewModel, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void access$FeedTags(final i iVar, final NearbyFeedItemViewModel nearbyFeedItemViewModel, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(1326672725);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1326672725, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.FeedTags (NearbyFeedItemView.kt:312)");
        }
        final boolean z16 = nearbyFeedItemViewModel.isOnlyText;
        RowKt.a(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(iVar, 0.0f, 1, null), 22.0f), 12.0f, 0.0f, 12.0f, 0.0f, 10, null), null, null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1524438131, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt$FeedTags$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(n nVar, Composer composer2, Integer num) {
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1524438131, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.FeedTags.<anonymous> (NearbyFeedItemView.kt:315)");
                    }
                    composer3.startReplaceableGroup(1789618617);
                    Iterator<String> it = NearbyFeedItemViewModel.this.feed.I.iterator();
                    while (it.hasNext()) {
                        f mapThemeFromCache = NearbyProUtilsKt.getMapThemeFromCache(it.next());
                        composer3.startReplaceableGroup(1789618701);
                        if (mapThemeFromCache != null) {
                            NearbyFeedItemViewKt.access$FeedTag(ComposeLayoutPropUpdaterKt.n(i.INSTANCE, 0.0f, 0.0f, 8.0f, 0.0f, 11, null), mapThemeFromCache.C, mapThemeFromCache.f421850e, z16, composer3, 8);
                            Unit unit = Unit.INSTANCE;
                        }
                        composer3.endReplaceableGroup();
                    }
                    composer3.endReplaceableGroup();
                    p35.ah ahVar = NearbyFeedItemViewModel.this.feed.C;
                    if (ahVar != null) {
                        NearbyFeedItemViewKt.access$FeedTag(i.INSTANCE, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_Wy8Y0lyQyV0.png", ahVar.Q, z16, composer3, 56);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 196616, 30);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt$FeedTags$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                NearbyFeedItemViewKt.access$FeedTags(i.this, nearbyFeedItemViewModel, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void access$HeaderView(final i iVar, final NearbyFeedItemViewModel nearbyFeedItemViewModel, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-1509969008);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1509969008, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.HeaderView (NearbyFeedItemView.kt:106)");
        }
        final float e16 = ((com.tencent.ntcompose.ui.platform.a) startRestartGroup.consume(CompositionLocalsKt.d())).e();
        RowKt.a(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(iVar, 0.0f, 1, null), 36.0f), 0.0f, 0.0f, 0.0f, 12.0f, 7, null), com.tencent.ntcompose.foundation.layout.base.a.f339245a.e(), Alignment.Vertical.CenterVertically, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -435974866, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt$HeaderView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(n nVar, Composer composer2, Integer num) {
                h j3;
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-435974866, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.HeaderView.<anonymous> (NearbyFeedItemView.kt:113)");
                    }
                    final NearbyFeedItemViewModel nearbyFeedItemViewModel2 = NearbyFeedItemViewModel.this;
                    final p35.n nVar2 = nearbyFeedItemViewModel2.feed;
                    final s35.af afVar = nVar2.f425194e;
                    Alignment.Vertical vertical = Alignment.Vertical.CenterVertically;
                    final float f16 = e16;
                    RowKt.a(null, null, vertical, null, null, ComposableLambdaKt.composableLambda(composer3, -1533590964, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt$HeaderView$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(n nVar3, Composer composer4, Integer num2) {
                            String str;
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1533590964, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.HeaderView.<anonymous>.<anonymous> (NearbyFeedItemView.kt:119)");
                                }
                                i n3 = ComposeLayoutPropUpdaterKt.n(i.INSTANCE, 0.0f, 0.0f, 8.0f, 0.0f, 11, null);
                                final NearbyFeedItemViewModel nearbyFeedItemViewModel3 = nearbyFeedItemViewModel2;
                                i d16 = ViewEventPropUpdaterKt.d(n3, false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt.HeaderView.1.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        NearbyFeedItemViewModel.this.onClickUser();
                                        return Unit.INSTANCE;
                                    }
                                }, 3, null);
                                s35.af afVar2 = s35.af.this;
                                if (afVar2 == null || (str = afVar2.E) == null) {
                                    str = "";
                                }
                                NBPAvatarViewKt.NBPAvatarView(d16, str, 32.0f, afVar2 != null ? StrangerUtilsKt.getAvatarDressFrameUrl(afVar2) : null, composer5, QFSBottomDynamicGuideEvent.DYNAMIC_GUIDE_BUTTON_TYPE, 0);
                                final s35.af afVar3 = s35.af.this;
                                final float f17 = f16;
                                final p35.n nVar4 = nVar2;
                                final NearbyFeedItemViewModel nearbyFeedItemViewModel4 = nearbyFeedItemViewModel2;
                                ColumnKt.a(null, null, null, null, ComposableLambdaKt.composableLambda(composer5, -1305879627, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt.HeaderView.1.1.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(d dVar, Composer composer6, Integer num3) {
                                        String str2;
                                        Composer composer7 = composer6;
                                        int intValue3 = num3.intValue();
                                        if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                            composer7.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1305879627, intValue3, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.HeaderView.<anonymous>.<anonymous>.<anonymous> (NearbyFeedItemView.kt:126)");
                                            }
                                            s35.af afVar4 = s35.af.this;
                                            if (afVar4 == null || (str2 = afVar4.f433209f) == null) {
                                                str2 = "\u9644\u8fd1\u7528\u6237";
                                            }
                                            String fixLineHeightForView = TextViewExtKt.fixLineHeightForView(str2);
                                            h color$default = QUIToken.color$default("text_primary");
                                            bp3.c f18 = bp3.c.INSTANCE.f();
                                            i.Companion companion = i.INSTANCE;
                                            i n16 = ComposeLayoutPropUpdaterKt.n(com.tencent.ntcompose.foundation.layout.h.b(companion, f17 / 2.0f), 0.0f, 0.0f, 0.0f, 2.0f, 7, null);
                                            final NearbyFeedItemViewModel nearbyFeedItemViewModel5 = nearbyFeedItemViewModel4;
                                            TextKt.a(fixLineHeightForView, ViewEventPropUpdaterKt.d(n16, false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt.HeaderView.1.1.2.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ClickParams clickParams) {
                                                    NearbyFeedItemViewModel.this.onClickUser();
                                                    return Unit.INSTANCE;
                                                }
                                            }, 3, null), null, color$default, Float.valueOf(14.0f), null, f18, null, null, null, null, Float.valueOf(20.0f), null, null, null, null, null, null, 1, null, null, null, "emoji", null, null, null, false, composer7, 1601600, 100663344, MsgConstant.KRMFILETHUMBSIZE384, 129759140);
                                            TextKt.a(TextViewExtKt.fixLineHeightForView(NearbyFormatUtils.INSTANCE.formatFeedTime(nVar4.D * 1000)), com.tencent.ntcompose.foundation.layout.h.b(companion, f17 / 2.0f), null, QUIToken.color$default("text_secondary"), Float.valueOf(12.0f), null, null, null, null, null, null, Float.valueOf(14.0f), null, null, null, null, null, null, 1, null, null, null, null, null, null, null, false, composer7, 28736, 100663344, 0, 133953508);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer5, 24576, 15);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 196992, 27);
                    UserDataManager userDataManager = UserDataManager.INSTANCE;
                    s35.af afVar2 = nVar2.f425194e;
                    if (!userDataManager.isHostTid(afVar2 != null ? Long.valueOf(afVar2.f433207e) : null)) {
                        composer3.startReplaceableGroup(-492369756);
                        Object rememberedValue = composer3.rememberedValue();
                        Composer.Companion companion = Composer.INSTANCE;
                        if (rememberedValue == companion.getEmpty()) {
                            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                            composer3.updateRememberedValue(rememberedValue);
                        }
                        composer3.endReplaceableGroup();
                        final MutableState mutableState = (MutableState) rememberedValue;
                        i v3 = ComposeLayoutPropUpdaterKt.v(i.INSTANCE, 82.0f, 32.0f);
                        if (((Boolean) mutableState.getValue()).booleanValue()) {
                            j3 = h.INSTANCE.a(0.1f);
                        } else {
                            j3 = h.INSTANCE.j();
                        }
                        i g16 = ModifiersKt.g(ModifiersKt.j(ModifiersKt.c(v3, j3), 4.0f), new e(1.0f, BorderStyle.SOLID, QUIToken.color$default("border_standard")));
                        composer3.startReplaceableGroup(1157296644);
                        boolean changed = composer3.changed(mutableState);
                        Object rememberedValue2 = composer3.rememberedValue();
                        if (changed || rememberedValue2 == companion.getEmpty()) {
                            rememberedValue2 = new Function1<MotionEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt$HeaderView$1$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(MotionEvent motionEvent) {
                                    int action = motionEvent.getAction();
                                    if (action == 0) {
                                        mutableState.setValue(Boolean.TRUE);
                                    } else if (action == 2 || action == 3) {
                                        mutableState.setValue(Boolean.FALSE);
                                    }
                                    return Unit.INSTANCE;
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue2);
                        }
                        composer3.endReplaceableGroup();
                        i p16 = ViewEventPropUpdaterKt.p(g16, (Function1) rememberedValue2);
                        final NearbyFeedItemViewModel nearbyFeedItemViewModel3 = NearbyFeedItemViewModel.this;
                        ButtonKt.a(null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt$HeaderView$1.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ClickParams clickParams) {
                                String str;
                                String str2;
                                String l3;
                                NearbyFeedItemViewModel nearbyFeedItemViewModel4 = NearbyFeedItemViewModel.this;
                                if (!nearbyFeedItemViewModel4.fastClickUtils.isFastDoubleClick()) {
                                    nearbyFeedItemViewModel4.reportClick(0);
                                    s35.af afVar3 = nearbyFeedItemViewModel4.feed.f425194e;
                                    String str3 = (afVar3 == null || (l3 = Long.valueOf(afVar3.f433207e).toString()) == null) ? "" : l3;
                                    s35.af afVar4 = nearbyFeedItemViewModel4.feed.f425194e;
                                    String str4 = (afVar4 == null || (str2 = afVar4.f433209f) == null) ? "" : str2;
                                    String str5 = (afVar4 == null || (str = afVar4.E) == null) ? "" : str;
                                    KLog kLog = KLog.INSTANCE;
                                    StringBuilder m3 = VasBusinessReportData$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onMessageBtnClick: "), nearbyFeedItemViewModel4.feed.f425193d, ", ", str3, ", ");
                                    m3.append(str4);
                                    m3.append(", ");
                                    m3.append(str5);
                                    kLog.i("NearbyFeedItemViewModel", m3.toString());
                                    QQNearbyModule.Companion.getInstance().openGreetingPage(str3, str4, str5, 25, 0);
                                }
                                return Unit.INSTANCE;
                            }
                        }, p16, null, ComposableSingletons$NearbyFeedItemViewKt.f62lambda1, composer3, 25088, 9);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 197064, 24);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt$HeaderView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                NearbyFeedItemViewKt.access$HeaderView(i.this, nearbyFeedItemViewModel, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$ImageContentView(final i iVar, final NearbyFeedItemViewModel nearbyFeedItemViewModel, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(740842465);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(740842465, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.ImageContentView (NearbyFeedItemView.kt:179)");
        }
        final p35.n nVar = nearbyFeedItemViewModel.feed;
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue = startRestartGroup.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = GuideBannerCardAnimationViewKt$$ExternalSyntheticOutline0.m(0.0f, null, 2, null, startRestartGroup);
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState mutableState = (MutableState) rememberedValue;
        i j3 = ComposeLayoutPropUpdaterKt.j(ModifiersKt.j(iVar, 12.0f), 0.0f, 1, null);
        startRestartGroup.startReplaceableGroup(1157296644);
        boolean changed = startRestartGroup.changed(mutableState);
        Object rememberedValue2 = startRestartGroup.rememberedValue();
        if (changed || rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = new Function1<a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt$ImageContentView$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(a aVar) {
                    mutableState.setValue(Float.valueOf(aVar.getWidth()));
                    return Unit.INSTANCE;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue2);
        }
        startRestartGroup.endReplaceableGroup();
        BoxKt.a(ModifiersKt.D(ViewEventPropUpdaterKt.l(j3, (Function1) rememberedValue2), ((Number) mutableState.getValue()).floatValue() > 0.0f ? 1.0f : 0.0f), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1209970587, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt$ImageContentView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer2, Integer num) {
                int i16;
                float floatValue;
                float floatValue2;
                float floatValue3;
                com.tencent.ntcompose.foundation.layout.b bVar2 = bVar;
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 14) == 0) {
                    i16 = (composer3.changed(bVar2) ? 4 : 2) | intValue;
                } else {
                    i16 = intValue;
                }
                if ((i16 & 91) == 18 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1209970587, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.ImageContentView.<anonymous> (NearbyFeedItemView.kt:187)");
                    }
                    final p35.n nVar2 = nVar;
                    Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt$ImageContentView$2.1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Object firstOrNull;
                            n35.w wVar;
                            List<z> list;
                            Object firstOrNull2;
                            n35.v vVar;
                            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) p35.n.this.f425198m);
                            ag agVar = (ag) firstOrNull;
                            if (agVar != null && (wVar = agVar.f425139d) != null && (list = wVar.f418273d) != null) {
                                firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
                                z zVar = (z) firstOrNull2;
                                if (zVar != null && (vVar = zVar.f418280d) != null) {
                                    return vVar;
                                }
                            }
                            return "";
                        }
                    };
                    int a16 = com.tencent.ntcompose.material.h.INSTANCE.a();
                    i.Companion companion2 = i.INSTANCE;
                    floatValue = ((Number) mutableState.getValue()).floatValue();
                    floatValue2 = ((Number) mutableState.getValue()).floatValue();
                    QQStrangerImageKt.m114QQStrangerImageCvonfEE(function0, a16, ComposeLayoutPropUpdaterKt.v(companion2, floatValue, (floatValue2 * 4) / 3), composer3, PlayerResources.ViewId.GET_MORE_TOGGLE_AREA, 0);
                    floatValue3 = ((Number) mutableState.getValue()).floatValue();
                    i e16 = ModifiersKt.e(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion2, floatValue3), 153.0f), Direction.TO_BOTTOM, new j(new h(0L, 0.0f), 0.0f), new j(new h(0L, 0.6f), 1.0f));
                    Alignment alignment = Alignment.BottomCenter;
                    BoxKt.a(bVar2.a(e16, alignment), null, null, ComposableSingletons$NearbyFeedItemViewKt.f63lambda2, composer3, 3080, 6);
                    i a17 = bVar2.a(ComposeLayoutPropUpdaterKt.z(ComposeLayoutPropUpdaterKt.j(companion2, 0.0f, 1, null)), alignment);
                    final p35.n nVar3 = nVar;
                    final NearbyFeedItemViewModel nearbyFeedItemViewModel2 = NearbyFeedItemViewModel.this;
                    ColumnKt.a(a17, null, null, null, ComposableLambdaKt.composableLambda(composer3, -458381820, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt$ImageContentView$2.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(d dVar, Composer composer4, Integer num2) {
                            String decodeToString;
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-458381820, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.ImageContentView.<anonymous>.<anonymous> (NearbyFeedItemView.kt:207)");
                                }
                                decodeToString = StringsKt__StringsJVMKt.decodeToString(p35.n.this.f425197i.f30291a);
                                i.Companion companion3 = i.INSTANCE;
                                NearbyFeedItemViewKt.access$FeedText(ComposeLayoutPropUpdaterKt.s(companion3, 12.0f, 0.0f, 12.0f, 0.0f, 10, null), decodeToString, false, composer5, QFSBottomDynamicGuideEvent.DYNAMIC_GUIDE_BUTTON_TYPE);
                                NearbyFeedItemViewKt.access$FeedTags(ComposeLayoutPropUpdaterKt.n(companion3, 0.0f, 8.0f, 0.0f, 0.0f, 13, null), nearbyFeedItemViewModel2, composer5, 72);
                                NearbyFeedItemViewKt.access$FeedActions(ComposeLayoutPropUpdaterKt.n(companion3, 0.0f, 17.0f, 0.0f, 0.0f, 13, null), nearbyFeedItemViewModel2, composer5, 72);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 24584, 14);
                    NearbyFeedItemViewKt.access$UserMotionAvatar(ComposeLayoutPropUpdaterKt.p(bVar2.a(companion2, Alignment.BottomEnd), 0.0f, -64.0f, 1, null), NearbyFeedItemViewModel.this, composer3, 72);
                    NearbyFeedItemViewKt.access$DoubleClickLikeAnimation(NearbyFeedItemViewModel.this, composer3, 8);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 3080, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt$ImageContentView$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                NearbyFeedItemViewKt.access$ImageContentView(i.this, nearbyFeedItemViewModel, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void access$TextContentView(final i iVar, final NearbyFeedItemViewModel nearbyFeedItemViewModel, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-1508106189);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1508106189, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.TextContentView (NearbyFeedItemView.kt:242)");
        }
        final p35.n nVar = nearbyFeedItemViewModel.feed;
        BoxKt.a(ComposeLayoutPropUpdaterKt.j(ModifiersKt.j(ModifiersKt.c(iVar, new h(4293915903L)), 12.0f), 0.0f, 1, null), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -661689031, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt$TextContentView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer2, Integer num) {
                int i16;
                com.tencent.ntcompose.foundation.layout.b bVar2 = bVar;
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 14) == 0) {
                    i16 = (composer3.changed(bVar2) ? 4 : 2) | intValue;
                } else {
                    i16 = intValue;
                }
                if ((i16 & 91) == 18 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-661689031, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.TextContentView.<anonymous> (NearbyFeedItemView.kt:247)");
                    }
                    i.Companion companion = i.INSTANCE;
                    ImageKt.a("https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_eBOVl8UjRq6.png", null, null, null, null, ComposeLayoutPropUpdaterKt.a(ComposeLayoutPropUpdaterKt.v(companion, 48.0f, 44.0f), 16.0f, 24.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer3, 262150, 0, 0, 2097118);
                    i j3 = ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null);
                    final p35.n nVar2 = nVar;
                    final NearbyFeedItemViewModel nearbyFeedItemViewModel2 = NearbyFeedItemViewModel.this;
                    ColumnKt.a(j3, null, null, null, ComposableLambdaKt.composableLambda(composer3, 2055439792, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt$TextContentView$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(d dVar, Composer composer4, Integer num2) {
                            String decodeToString;
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(2055439792, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.TextContentView.<anonymous>.<anonymous> (NearbyFeedItemView.kt:257)");
                                }
                                decodeToString = StringsKt__StringsJVMKt.decodeToString(p35.n.this.f425197i.f30291a);
                                i.Companion companion2 = i.INSTANCE;
                                NearbyFeedItemViewKt.access$FeedText(ComposeLayoutPropUpdaterKt.m(companion2, 12.0f, 48.0f, 12.0f, 24.0f), decodeToString, true, composer5, QFSBottomDynamicGuideEvent.DYNAMIC_GUIDE_BUTTON_TYPE);
                                NearbyFeedItemViewKt.access$FeedTags(ComposeLayoutPropUpdaterKt.n(companion2, 0.0f, 26.0f, 0.0f, 0.0f, 13, null), nearbyFeedItemViewModel2, composer5, 72);
                                NearbyFeedItemViewKt.access$FeedActions(ComposeLayoutPropUpdaterKt.n(companion2, 0.0f, 17.0f, 0.0f, 0.0f, 13, null), nearbyFeedItemViewModel2, composer5, 72);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 24584, 14);
                    NearbyFeedItemViewKt.access$UserMotionAvatar(ComposeLayoutPropUpdaterKt.p(bVar2.a(companion, Alignment.BottomEnd), 0.0f, -64.0f, 1, null), NearbyFeedItemViewModel.this, composer3, 72);
                    NearbyFeedItemViewKt.access$DoubleClickLikeAnimation(NearbyFeedItemViewModel.this, composer3, 8);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 3080, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt$TextContentView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                NearbyFeedItemViewKt.access$TextContentView(i.this, nearbyFeedItemViewModel, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void access$UserMotionAvatar(final i iVar, final NearbyFeedItemViewModel nearbyFeedItemViewModel, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(1260229720);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1260229720, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.UserMotionAvatar (NearbyFeedItemView.kt:332)");
        }
        KuiklyKt.a(null, ViewEventPropUpdaterKt.h(ViewEventPropUpdaterKt.g(ComposeLayoutPropUpdaterKt.u(iVar, 80.0f), new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt$UserMotionAvatar$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                NearbyFeedItemViewModel nearbyFeedItemViewModel2 = NearbyFeedItemViewModel.this;
                nearbyFeedItemViewModel2.showAvatar$delegate.setValue(nearbyFeedItemViewModel2, NearbyFeedItemViewModel.$$delegatedProperties[0], Boolean.TRUE);
                return Unit.INSTANCE;
            }
        }), new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt$UserMotionAvatar$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                NearbyFeedItemViewModel nearbyFeedItemViewModel2 = NearbyFeedItemViewModel.this;
                nearbyFeedItemViewModel2.showAvatar$delegate.setValue(nearbyFeedItemViewModel2, NearbyFeedItemViewModel.$$delegatedProperties[0], Boolean.FALSE);
                return Unit.INSTANCE;
            }
        }), new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt$UserMotionAvatar$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final NearbyFeedItemViewModel nearbyFeedItemViewModel2 = NearbyFeedItemViewModel.this;
                NearbyContentFeedAvatarViewKt.NearbyContentFeedAvatar(viewContainer, new Function1<NearbyFDPContentFeedAvatarView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt$UserMotionAvatar$3.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(NearbyFDPContentFeedAvatarView nearbyFDPContentFeedAvatarView) {
                        NearbyFDPContentFeedAvatarView nearbyFDPContentFeedAvatarView2 = nearbyFDPContentFeedAvatarView;
                        final NearbyFeedItemViewModel nearbyFeedItemViewModel3 = NearbyFeedItemViewModel.this;
                        nearbyFDPContentFeedAvatarView2.ref(nearbyFDPContentFeedAvatarView2, new Function1<aa<NearbyFDPContentFeedAvatarView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt.UserMotionAvatar.3.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(aa<NearbyFDPContentFeedAvatarView> aaVar) {
                                NearbyFeedItemViewModel.this.getClass();
                                return Unit.INSTANCE;
                            }
                        });
                        final NearbyFeedItemViewModel nearbyFeedItemViewModel4 = NearbyFeedItemViewModel.this;
                        nearbyFDPContentFeedAvatarView2.attr(new Function1<NearbyFDPContentFeedAvatarViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt.UserMotionAvatar.3.1.2
                            {
                                super(1);
                            }

                            /* JADX WARN: Code restructure failed: missing block: B:4:0x0017, code lost:
                            
                                if (r0.f433218m == 1) goto L8;
                             */
                            @Override // kotlin.jvm.functions.Function1
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                            */
                            public final Unit invoke(NearbyFDPContentFeedAvatarViewAttr nearbyFDPContentFeedAvatarViewAttr) {
                                boolean z16;
                                NearbyFDPContentFeedAvatarViewAttr nearbyFDPContentFeedAvatarViewAttr2 = nearbyFDPContentFeedAvatarViewAttr;
                                nearbyFDPContentFeedAvatarViewAttr2.setFilamentResource(NearbyFeedItemViewModel.this.feed.f425196h);
                                s35.af afVar = NearbyFeedItemViewModel.this.feed.f425194e;
                                if (afVar != null) {
                                    z16 = true;
                                }
                                z16 = false;
                                nearbyFDPContentFeedAvatarViewAttr2.setMale(z16);
                                s35.af afVar2 = NearbyFeedItemViewModel.this.feed.f425194e;
                                nearbyFDPContentFeedAvatarViewAttr2.setTinyId(afVar2 != null ? afVar2.f433207e : 0L);
                                nearbyFDPContentFeedAvatarViewAttr2.size(100.0f, 100.0f);
                                nearbyFDPContentFeedAvatarViewAttr2.marginTop(-10.0f);
                                nearbyFDPContentFeedAvatarViewAttr2.marginLeft(-10.0f);
                                NearbyFeedItemViewModel nearbyFeedItemViewModel5 = NearbyFeedItemViewModel.this;
                                nearbyFDPContentFeedAvatarViewAttr2.setLoadAvatarView(((Boolean) nearbyFeedItemViewModel5.showAvatar$delegate.getValue(nearbyFeedItemViewModel5, NearbyFeedItemViewModel.$$delegatedProperties[0])).booleanValue());
                                return Unit.INSTANCE;
                            }
                        });
                        final NearbyFeedItemViewModel nearbyFeedItemViewModel5 = NearbyFeedItemViewModel.this;
                        nearbyFDPContentFeedAvatarView2.event(new Function1<NearbyFDPContentFeedAvatarViewEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt.UserMotionAvatar.3.1.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NearbyFDPContentFeedAvatarViewEvent nearbyFDPContentFeedAvatarViewEvent) {
                                NearbyFDPContentFeedAvatarViewEvent nearbyFDPContentFeedAvatarViewEvent2 = nearbyFDPContentFeedAvatarViewEvent;
                                final NearbyFeedItemViewModel nearbyFeedItemViewModel6 = NearbyFeedItemViewModel.this;
                                nearbyFDPContentFeedAvatarViewEvent2.clickHandler = new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt.UserMotionAvatar.3.1.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Object obj) {
                                        NearbyFeedItemViewModel.this.onClickContent();
                                        return Unit.INSTANCE;
                                    }
                                };
                                final NearbyFeedItemViewModel nearbyFeedItemViewModel7 = NearbyFeedItemViewModel.this;
                                nearbyFDPContentFeedAvatarViewEvent2.longClickHandler = new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt.UserMotionAvatar.3.1.3.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Object obj) {
                                        NearbyFeedItemViewModel.this.onLongPressContent();
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
        }, startRestartGroup, 64, 1);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt$UserMotionAvatar$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                NearbyFeedItemViewKt.access$UserMotionAvatar(i.this, nearbyFeedItemViewModel, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void access$FeedTag(final i iVar, final String str, final String str2, final boolean z16, Composer composer, final int i3) {
        h hVar;
        Composer startRestartGroup = composer.startRestartGroup(227512938);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(227512938, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.FeedTag (NearbyFeedItemView.kt:367)");
        }
        Alignment.Vertical c16 = Alignment.INSTANCE.c();
        i j3 = ModifiersKt.j(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.k(iVar, 22.0f), 6.0f, 0.0f, 6.0f, 0.0f, 10, null), 8.0f);
        if (z16) {
            hVar = new h(0L, 0.1f);
        } else {
            hVar = new h(16777215L, 0.1f);
        }
        RowKt.a(ModifiersKt.j(ModifiersKt.c(j3, hVar), 20.0f), null, c16, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -392843764, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt$FeedTag$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(n nVar, Composer composer2, Integer num) {
                h m3;
                h m16;
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-392843764, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.FeedTag.<anonymous> (NearbyFeedItemView.kt:373)");
                    }
                    String str3 = str;
                    i.Companion companion = i.INSTANCE;
                    i u16 = ComposeLayoutPropUpdaterKt.u(companion, 14.0f);
                    int c17 = com.tencent.ntcompose.material.h.INSTANCE.c();
                    if (z16) {
                        m3 = h.INSTANCE.b();
                    } else {
                        m3 = h.INSTANCE.m();
                    }
                    ImageKt.a(str3, null, null, null, null, u16, null, c17, null, null, null, null, null, null, null, null, null, null, null, m3, null, composer3, ((i3 >> 3) & 14) | 12845056, 1073741824, 0, 1572702);
                    String fixLineHeightForView = TextViewExtKt.fixLineHeightForView(str2);
                    if (z16) {
                        m16 = h.INSTANCE.b();
                    } else {
                        m16 = h.INSTANCE.m();
                    }
                    h hVar2 = m16;
                    TextKt.a(fixLineHeightForView, ComposeLayoutPropUpdaterKt.x(ComposeLayoutPropUpdaterKt.s(companion, 4.0f, 0.0f, 0.0f, 0.0f, 14, null), 0.0f, 200.0f), null, hVar2, Float.valueOf(12.0f), null, bp3.c.INSTANCE.f(), null, null, null, null, null, null, null, null, null, an.d(an.INSTANCE.b()), null, 1, null, null, null, null, null, null, null, false, composer3, 1601600, 102236160, 0, 133889956);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 196616, 26);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt$FeedTag$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                NearbyFeedItemViewKt.access$FeedTag(i.this, str, str2, z16, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void access$FeedText(final i iVar, final String str, final boolean z16, Composer composer, final int i3) {
        h m3;
        Composer startRestartGroup = composer.startRestartGroup(-799355388);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-799355388, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.FeedText (NearbyFeedItemView.kt:291)");
        }
        if (z16) {
            m3 = h.INSTANCE.b();
        } else {
            m3 = h.INSTANCE.m();
        }
        String fixLineHeightForView = TextViewExtKt.fixLineHeightForView(str);
        TextKt.a(fixLineHeightForView, iVar, null, m3, Float.valueOf(18.0f), null, bp3.c.INSTANCE.f(), null, null, null, null, Float.valueOf(24.0f), null, null, null, null, null, null, 3, null, null, null, "emoji", null, null, null, false, startRestartGroup, 1601600, 100663344, MsgConstant.KRMFILETHUMBSIZE384, 129759140);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds.NearbyFeedItemViewKt$FeedText$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                NearbyFeedItemViewKt.access$FeedText(i.this, str, z16, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
