package com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.channel;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model.ComposeFeedListViewModel;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.FeedsEmptyViewKt;
import com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.FeedsFooterRefreshViewKt;
import com.tencent.hippykotlin.demo.pages.nearby.middle_page.view_model.FeedListViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.middle_page.view_model.NBPMiddlePageViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.middle_page.view_model.TabViewModel;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.views.FooterRefreshState;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.k;
import com.tencent.ntcompose.foundation.layout.l;
import com.tencent.ntcompose.lifecycle.common.Lifecycle;
import com.tencent.ntcompose.lifecycle.common.c;
import com.tencent.ntcompose.lifecycle.viewmodel.compose.a;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.ntcompose.material.base.d;
import com.tencent.ntcompose.material.r;
import com.tencent.ntcompose.ui.platform.CompositionLocalsKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ChannelFeedListViewKt {
    public static final void ChannelFeedListView(final TabViewModel<? extends FeedListViewModel> tabViewModel, final NBPMiddlePageViewModel nBPMiddlePageViewModel, Composer composer, final int i3) {
        boolean z16;
        i e16;
        Composer startRestartGroup = composer.startRestartGroup(-197127557);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-197127557, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.channel.ChannelFeedListView (ChannelFeedListView.kt:28)");
        }
        a.b(nBPMiddlePageViewModel.getChannelFeedsVm(), ((c) startRestartGroup.consume(CompositionLocalsKt.e())).getLifecycle(), startRestartGroup, (Lifecycle.f339325a << 3) | 8);
        final float a16 = ((com.tencent.ntcompose.ui.platform.a) startRestartGroup.consume(CompositionLocalsKt.d())).a();
        boolean z17 = nBPMiddlePageViewModel.getChannelFeedsVm().listVm.feedCardViewModelList.size() == 0;
        final boolean z18 = nBPMiddlePageViewModel.getChannelFeedsVm().isEnd() && z17;
        i.Companion companion = i.INSTANCE;
        i k3 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null), nBPMiddlePageViewModel.getPageListHeight());
        if (z17) {
            Direction direction = Direction.TO_BOTTOM;
            h.Companion companion2 = h.INSTANCE;
            e16 = ModifiersKt.e(companion, direction, new j(companion2.a(0.0f), 0.0f), new j(companion2.a(0.0f), 1.0f));
            z16 = true;
        } else {
            Direction direction2 = Direction.TO_BOTTOM;
            h.Companion companion3 = h.INSTANCE;
            z16 = true;
            e16 = ModifiersKt.e(companion, direction2, new j(companion3.a(0.0f), 0.0f), new j(companion3.a(0.03f), 0.3f), new j(companion3.a(0.03f), 1.0f));
        }
        BoxKt.a(k3.b(e16), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 974344193, z16, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.channel.ChannelFeedListViewKt$ChannelFeedListView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(b bVar, Composer composer2, Integer num) {
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(974344193, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.channel.ChannelFeedListView.<anonymous> (ChannelFeedListView.kt:56)");
                    }
                    com.tencent.ntcompose.ui.platform.a aVar = (com.tencent.ntcompose.ui.platform.a) composer3.consume(CompositionLocalsKt.d());
                    if (!((Boolean) NBPMiddlePageViewModel.this.getChannelFeedsVm().tabOpened$delegate.getValue()).booleanValue()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    } else {
                        composer3.startReplaceableGroup(1370244294);
                        if (z18) {
                            FeedsEmptyViewKt.FeedsEmptyView(composer3, 0);
                        }
                        composer3.endReplaceableGroup();
                        ComposeFeedListViewModel composeFeedListViewModel = NBPMiddlePageViewModel.this.getChannelFeedsVm().listVm;
                        i k16 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), NBPMiddlePageViewModel.this.getPageListHeight());
                        final NBPMiddlePageViewModel nBPMiddlePageViewModel2 = NBPMiddlePageViewModel.this;
                        final TabViewModel<? extends FeedListViewModel> tabViewModel2 = tabViewModel;
                        i a17 = d.a(k16, ComposableLambdaKt.composableLambda(composer3, -612802503, true, new Function3<com.tencent.ntcompose.material.base.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.channel.ChannelFeedListViewKt$ChannelFeedListView$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(com.tencent.ntcompose.material.base.b bVar2, Composer composer4, Integer num2) {
                                com.tencent.ntcompose.material.base.b bVar3 = bVar2;
                                Composer composer5 = composer4;
                                int intValue2 = num2.intValue();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-612802503, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.channel.ChannelFeedListView.<anonymous>.<anonymous> (ChannelFeedListView.kt:69)");
                                }
                                NBPMiddlePageViewModel.this.bindTabListOffset(tabViewModel2, bVar3, composer5, 584);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer3, 56);
                        r.a aVar2 = new r.a(2);
                        float e17 = aVar.e();
                        float d16 = aVar.d();
                        l c16 = k.c(6.0f, 10.0f, 6.0f, 0.0f, 8, null);
                        Boolean bool = Boolean.FALSE;
                        Float valueOf = Float.valueOf(d16);
                        final NBPMiddlePageViewModel nBPMiddlePageViewModel3 = NBPMiddlePageViewModel.this;
                        final float f16 = a16;
                        Function2<Float, Float, Unit> function2 = new Function2<Float, Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.channel.ChannelFeedListViewKt$ChannelFeedListView$1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Unit invoke(Float f17, Float f18) {
                                f17.floatValue();
                                NBPMiddlePageViewModel.this.tabList.get(1).listContentHeight.setValue(Float.valueOf(Math.max(f18.floatValue(), f16)));
                                return Unit.INSTANCE;
                            }
                        };
                        final NBPMiddlePageViewModel nBPMiddlePageViewModel4 = NBPMiddlePageViewModel.this;
                        composeFeedListViewModel.buildLazyVerticalGrid(aVar2, a17, e17, null, c16, 6.0f, 6.0f, bool, null, null, null, null, null, 6, valueOf, null, null, null, null, function2, ComposableLambdaKt.composableLambda(composer3, 1269884045, true, new Function3<FooterRefreshState, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.channel.ChannelFeedListViewKt$ChannelFeedListView$1.3

                            /* compiled from: P */
                            /* renamed from: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.channel.ChannelFeedListViewKt$ChannelFeedListView$1$3$1, reason: invalid class name */
                            /* loaded from: classes31.dex */
                            public final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Unit> {
                                @Override // kotlin.jvm.functions.Function0
                                public final Unit invoke() {
                                    ((ChannelFeedListViewModel) this.receiver).getClass();
                                    DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0.m("open scheme: ", "mqqapi://guild/main", KLog.INSTANCE, "ChannelFeedListViewModel");
                                    QQKuiklyPlatformApi.openPage$default((QQKuiklyPlatformApi) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("QQKuiklyPlatformApi"), "mqqapi://guild/main", false, 6);
                                    return Unit.INSTANCE;
                                }

                                public AnonymousClass1(Object obj) {
                                    super(0, obj, ChannelFeedListViewModel.class, "gotoChannelPage", "gotoChannelPage()V", 0);
                                }
                            }

                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(FooterRefreshState footerRefreshState, Composer composer4, Integer num2) {
                                FooterRefreshState footerRefreshState2 = footerRefreshState;
                                Composer composer5 = composer4;
                                int intValue2 = num2.intValue();
                                if ((intValue2 & 14) == 0) {
                                    intValue2 |= composer5.changed(footerRefreshState2) ? 4 : 2;
                                }
                                if ((intValue2 & 91) == 18 && composer5.getSkipping()) {
                                    composer5.skipToGroupEnd();
                                } else {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1269884045, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.channel.ChannelFeedListView.<anonymous>.<anonymous> (ChannelFeedListView.kt:80)");
                                    }
                                    FeedsFooterRefreshViewKt.FeedsFooterRefreshView(footerRefreshState2, "\u53bb\u9891\u9053\u770b\u66f4\u591a\u5e16\u5b50", new AnonymousClass1(NBPMiddlePageViewModel.this.getChannelFeedsVm()), composer5, (intValue2 & 14) | 48);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer3, 14352448, 3072, 70, 499464);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.channel.ChannelFeedListViewKt$ChannelFeedListView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                ChannelFeedListViewKt.ChannelFeedListView(tabViewModel, nBPMiddlePageViewModel, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
