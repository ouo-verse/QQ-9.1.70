package com.tencent.hippykotlin.demo.pages.qq_intimate_space.share;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSBottomDynamicGuideEvent;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QRCodeViewKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.view.adelie.QQAvatarViewKt;
import com.tencent.hippykotlin.demo.pages.foundation.lib.UriKt;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveSproutCardViewKt;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallFlowerGeneralCardConfig;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallFlowerGeneralCardKt;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.LoveWallHomepageViewModel;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.utils.IntimateSpaceReportUtilKt;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.coroutines.BuildersKt;
import com.tencent.kuikly.core.coroutines.e;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.views.LoadSuccessParams;
import com.tencent.kuikly.core.views.v;
import com.tencent.mobileqq.msf.core.auth.m;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.RichTextKt;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.ntcompose.material.n;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.text.StringsKt__StringsJVMKt;

/* loaded from: classes37.dex */
public final class LoveWallTreeCardSharePageViewKt {
    public static final void LoveWallTreeCardSharePageView(final LoveWallTreeCardShareViewModel loveWallTreeCardShareViewModel, final LoveWallHomepageViewModel loveWallHomepageViewModel, final Function0<Unit> function0, Composer composer, final int i3, final int i16) {
        Composer startRestartGroup = composer.startRestartGroup(-1100302315);
        if ((i16 & 4) != 0) {
            function0 = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1100302315, i3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.LoveWallTreeCardSharePageView (LoveWallTreeCardSharePageView.kt:69)");
        }
        BoxKt.a(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1886223665, true, new Function3<b, Composer, Integer, Unit>(function0, i3, loveWallTreeCardShareViewModel) { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.LoveWallTreeCardSharePageViewKt$LoveWallTreeCardSharePageView$1
            public static final /* synthetic */ int $r8$clinit = 0;
            public final /* synthetic */ Function0<Unit> $onDismiss;
            public final /* synthetic */ LoveWallTreeCardShareViewModel $viewModel;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
                this.$viewModel = loveWallTreeCardShareViewModel;
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(b bVar, Composer composer2, Integer num) {
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1886223665, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.LoveWallTreeCardSharePageView.<anonymous> (LoveWallTreeCardSharePageView.kt:74)");
                    }
                    composer3.startReplaceableGroup(-492369756);
                    Object rememberedValue = composer3.rememberedValue();
                    Composer.Companion companion = Composer.INSTANCE;
                    if (rememberedValue == companion.getEmpty()) {
                        rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
                        composer3.updateRememberedValue(rememberedValue);
                    }
                    composer3.endReplaceableGroup();
                    final MutableState mutableState = (MutableState) rememberedValue;
                    composer3.startReplaceableGroup(-492369756);
                    Object rememberedValue2 = composer3.rememberedValue();
                    if (rememberedValue2 == companion.getEmpty()) {
                        rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new ImageSharePanelViewModel(null, null, 3, null), null, 2, null);
                        composer3.updateRememberedValue(rememberedValue2);
                    }
                    composer3.endReplaceableGroup();
                    final MutableState mutableState2 = (MutableState) rememberedValue2;
                    composer3.startReplaceableGroup(-492369756);
                    Object rememberedValue3 = composer3.rememberedValue();
                    if (rememberedValue3 == companion.getEmpty()) {
                        rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composer3.updateRememberedValue(rememberedValue3);
                    }
                    composer3.endReplaceableGroup();
                    final MutableState mutableState3 = (MutableState) rememberedValue3;
                    ImageSharePanelViewModel imageSharePanelViewModel = (ImageSharePanelViewModel) mutableState2.getValue();
                    PanelConfig panelConfig = new PanelConfig();
                    ShareElementVR shareElementVR = new ShareElementVR("pg_qz_love_tree_home", LoveWallHomepageViewModel.this.getPageReportParams());
                    ShareElementVR shareElementVR2 = new ShareElementVR("em_qz_sharing_panel", IntimateSpaceReportUtilKt.getIntimateDTReportBaseParams());
                    composer3.startReplaceableGroup(1157296644);
                    boolean changed = composer3.changed(mutableState);
                    Object rememberedValue4 = composer3.rememberedValue();
                    if (changed || rememberedValue4 == companion.getEmpty()) {
                        rememberedValue4 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.LoveWallTreeCardSharePageViewKt$LoveWallTreeCardSharePageView$1$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                mutableState.setValue(Boolean.TRUE);
                                return Unit.INSTANCE;
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue4);
                    }
                    composer3.endReplaceableGroup();
                    Function0 function02 = (Function0) rememberedValue4;
                    composer3.startReplaceableGroup(1157296644);
                    boolean changed2 = composer3.changed(mutableState);
                    Object rememberedValue5 = composer3.rememberedValue();
                    if (changed2 || rememberedValue5 == companion.getEmpty()) {
                        rememberedValue5 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.LoveWallTreeCardSharePageViewKt$LoveWallTreeCardSharePageView$1$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                mutableState.setValue(Boolean.FALSE);
                                return Unit.INSTANCE;
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue5);
                    }
                    composer3.endReplaceableGroup();
                    Function0 function03 = (Function0) rememberedValue5;
                    final Function0<Unit> function04 = this.$onDismiss;
                    composer3.startReplaceableGroup(1157296644);
                    boolean changed3 = composer3.changed(function04);
                    Object rememberedValue6 = composer3.rememberedValue();
                    if (changed3 || rememberedValue6 == companion.getEmpty()) {
                        rememberedValue6 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.LoveWallTreeCardSharePageViewKt$LoveWallTreeCardSharePageView$1$3$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                Function0<Unit> function05 = function04;
                                if (function05 != null) {
                                    function05.invoke();
                                }
                                return Unit.INSTANCE;
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue6);
                    }
                    composer3.endReplaceableGroup();
                    final LoveWallTreeCardShareViewModel loveWallTreeCardShareViewModel2 = this.$viewModel;
                    Function1<ShareItem, Unit> function1 = new Function1<ShareItem, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.LoveWallTreeCardSharePageViewKt$LoveWallTreeCardSharePageView$1.4

                        @DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.LoveWallTreeCardSharePageViewKt$LoveWallTreeCardSharePageView$1$4$1", f = "LoveWallTreeCardSharePageView.kt", i = {}, l = {101}, m = "invokeSuspend", n = {}, s = {})
                        /* renamed from: com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.LoveWallTreeCardSharePageViewKt$LoveWallTreeCardSharePageView$1$4$1, reason: invalid class name */
                        /* loaded from: classes37.dex */
                        public final class AnonymousClass1 extends SuspendLambda implements Function2<com.tencent.kuikly.core.coroutines.b, Continuation<? super Unit>, Object> {
                            public final /* synthetic */ ShareItem $item;
                            public final /* synthetic */ MutableState<aa<v>> $screenShotRef$delegate;
                            public final /* synthetic */ MutableState<ImageSharePanelViewModel> $sharePanelViewModel;
                            public final /* synthetic */ LoveWallTreeCardShareViewModel $viewModel;
                            public int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            public AnonymousClass1(LoveWallTreeCardShareViewModel loveWallTreeCardShareViewModel, MutableState<ImageSharePanelViewModel> mutableState, ShareItem shareItem, MutableState<aa<v>> mutableState2, Continuation<? super AnonymousClass1> continuation) {
                                super(2, continuation);
                                this.$viewModel = loveWallTreeCardShareViewModel;
                                this.$sharePanelViewModel = mutableState;
                                this.$item = shareItem;
                                this.$screenShotRef$delegate = mutableState2;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                return new AnonymousClass1(this.$viewModel, this.$sharePanelViewModel, this.$item, this.$screenShotRef$delegate, continuation);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(com.tencent.kuikly.core.coroutines.b bVar, Continuation<? super Unit> continuation) {
                                return ((AnonymousClass1) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                Object coroutine_suspended;
                                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                int i3 = this.label;
                                if (i3 == 0) {
                                    ResultKt.throwOnFailure(obj);
                                    LoveWallTreeCardShareViewModel loveWallTreeCardShareViewModel = this.$viewModel;
                                    aa<v> value = this.$screenShotRef$delegate.getValue();
                                    int nativeRef = value != null ? value.getNativeRef() : 0;
                                    ImageSharePanelViewModel value2 = this.$sharePanelViewModel.getValue();
                                    ShareItem shareItem = this.$item;
                                    this.label = 1;
                                    if (loveWallTreeCardShareViewModel.share(nativeRef, value2, shareItem, this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                } else if (i3 == 1) {
                                    ResultKt.throwOnFailure(obj);
                                } else {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                return Unit.INSTANCE;
                            }
                        }

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ShareItem shareItem) {
                            BuildersKt.e(e.f117232d, null, null, new AnonymousClass1(LoveWallTreeCardShareViewModel.this, mutableState2, shareItem, mutableState3, null), 3, null);
                            return Unit.INSTANCE;
                        }
                    };
                    final LoveWallTreeCardShareViewModel loveWallTreeCardShareViewModel3 = this.$viewModel;
                    ImageSharePanelViewKt.ImageSharePanelView(imageSharePanelViewModel, panelConfig, shareElementVR, shareElementVR2, function02, function03, (Function0) rememberedValue6, function1, ComposableLambdaKt.composableLambda(composer3, -2017123235, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.LoveWallTreeCardSharePageViewKt$LoveWallTreeCardSharePageView$1.5
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Unit invoke(Composer composer4, Integer num2) {
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 11) == 2 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-2017123235, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.LoveWallTreeCardSharePageView.<anonymous>.<anonymous> (LoveWallTreeCardSharePageView.kt:107)");
                                }
                                float f16 = (com.tencent.ntcompose.activity.b.a().getPageData().getIsIphoneX() ? 34.0f : 0.0f) + 266.0f;
                                if (mutableState.getValue().booleanValue()) {
                                    final float l3 = (com.tencent.ntcompose.activity.b.a().getPageData().l() - f16) - com.tencent.ntcompose.activity.b.a().getPageData().getStatusBarHeight();
                                    i k3 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), l3);
                                    final MutableState<aa<v>> mutableState4 = mutableState3;
                                    final LoveWallTreeCardShareViewModel loveWallTreeCardShareViewModel4 = loveWallTreeCardShareViewModel3;
                                    BoxKt.a(k3, null, null, ComposableLambdaKt.composableLambda(composer5, 471813566, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.LoveWallTreeCardSharePageViewKt.LoveWallTreeCardSharePageView.1.5.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public final Unit invoke(b bVar2, Composer composer6, Integer num3) {
                                            int i17;
                                            b bVar3 = bVar2;
                                            Composer composer7 = composer6;
                                            int intValue3 = num3.intValue();
                                            if ((intValue3 & 14) == 0) {
                                                i17 = (composer7.changed(bVar3) ? 4 : 2) | intValue3;
                                            } else {
                                                i17 = intValue3;
                                            }
                                            if ((i17 & 91) == 18 && composer7.getSkipping()) {
                                                composer7.skipToGroupEnd();
                                            } else {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(471813566, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.LoveWallTreeCardSharePageView.<anonymous>.<anonymous>.<anonymous> (LoveWallTreeCardSharePageView.kt:112)");
                                                }
                                                i r16 = ModifiersKt.r(bVar3.a(ModifiersKt.J(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(ModifiersKt.d(i.INSTANCE, h.INSTANCE.a(0.0f)), 240.0f), 480.0f), (l3 - 56.0f) / 480.0f, null, 2, null), Alignment.Center), true);
                                                final MutableState<aa<v>> mutableState5 = mutableState4;
                                                composer7.startReplaceableGroup(1157296644);
                                                boolean changed4 = composer7.changed(mutableState5);
                                                Object rememberedValue7 = composer7.rememberedValue();
                                                if (changed4 || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                                                    rememberedValue7 = new Function2<v, aa<v>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.LoveWallTreeCardSharePageViewKt$LoveWallTreeCardSharePageView$1$5$1$1$1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(2);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function2
                                                        public final Unit invoke(v vVar, aa<v> aaVar) {
                                                            mutableState5.setValue(aaVar);
                                                            return Unit.INSTANCE;
                                                        }
                                                    };
                                                    composer7.updateRememberedValue(rememberedValue7);
                                                }
                                                composer7.endReplaceableGroup();
                                                LoveWallTreeCardSharePageViewKt.TreeCardShareContentView(r16, (Function2) rememberedValue7, 380.0f, loveWallTreeCardShareViewModel4, composer7, 4488, 0);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer5, 3080, 6);
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 100667976, 0);
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
        final Function0<Unit> function02 = function0;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.LoveWallTreeCardSharePageViewKt$LoveWallTreeCardSharePageView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                LoveWallTreeCardSharePageViewKt.LoveWallTreeCardSharePageView(LoveWallTreeCardShareViewModel.this, loveWallHomepageViewModel, function02, composer2, i3 | 1, i16);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void TreeCardShareContentView(final i iVar, Function2<? super v, ? super aa<v>, Unit> function2, final float f16, final LoveWallTreeCardShareViewModel loveWallTreeCardShareViewModel, Composer composer, final int i3, final int i16) {
        Composer startRestartGroup = composer.startRestartGroup(-1492538472);
        if ((i16 & 2) != 0) {
            function2 = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1492538472, i3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.TreeCardShareContentView (LoveWallTreeCardSharePageView.kt:135)");
        }
        BoxKt.a(iVar, null, function2, ComposableLambdaKt.composableLambda(startRestartGroup, 830614098, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.LoveWallTreeCardSharePageViewKt$TreeCardShareContentView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(b bVar, Composer composer2, Integer num) {
                int i17;
                b bVar2 = bVar;
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 14) == 0) {
                    i17 = (composer3.changed(bVar2) ? 4 : 2) | intValue;
                } else {
                    i17 = intValue;
                }
                if ((i17 & 91) == 18 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(830614098, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.TreeCardShareContentView.<anonymous> (LoveWallTreeCardSharePageView.kt:144)");
                    }
                    composer3.startReplaceableGroup(-492369756);
                    Object rememberedValue = composer3.rememberedValue();
                    Composer.Companion companion = Composer.INSTANCE;
                    if (rememberedValue == companion.getEmpty()) {
                        rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                        composer3.updateRememberedValue(rememberedValue);
                    }
                    composer3.endReplaceableGroup();
                    final MutableState mutableState = (MutableState) rememberedValue;
                    i.Companion companion2 = i.INSTANCE;
                    i h16 = ComposeLayoutPropUpdaterKt.h(companion2, 0.0f, 1, null);
                    composer3.startReplaceableGroup(1157296644);
                    boolean changed = composer3.changed(mutableState);
                    Object rememberedValue2 = composer3.rememberedValue();
                    if (changed || rememberedValue2 == companion.getEmpty()) {
                        rememberedValue2 = new Function1<LoadSuccessParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.LoveWallTreeCardSharePageViewKt$TreeCardShareContentView$1$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(LoadSuccessParams loadSuccessParams) {
                                mutableState.setValue(Boolean.TRUE);
                                return Unit.INSTANCE;
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue2);
                    }
                    composer3.endReplaceableGroup();
                    ImageKt.a(null, null, null, null, null, h16, null, 0, null, null, "https://image.superqqshow.qq.com/wuji/qq_zplan_config_test/couple_space_pic_resouce/4221bcd7_N8aSQUQJRTl.png", null, null, null, null, null, (Function1) rememberedValue2, null, null, null, null, composer3, 262144, 6, 0, 2030559);
                    if (!((Boolean) mutableState.getValue()).booleanValue()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    } else {
                        i h17 = ComposeLayoutPropUpdaterKt.h(companion2, 0.0f, 1, null);
                        Alignment.Companion companion3 = Alignment.INSTANCE;
                        Alignment.Horizontal b16 = companion3.b();
                        final LoveWallTreeCardShareViewModel loveWallTreeCardShareViewModel2 = LoveWallTreeCardShareViewModel.this;
                        ColumnKt.a(h17, null, b16, null, ComposableLambdaKt.composableLambda(composer3, 1948508219, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.LoveWallTreeCardSharePageViewKt$TreeCardShareContentView$1.2
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(d dVar, Composer composer4, Integer num2) {
                                Composer composer5 = composer4;
                                int intValue2 = num2.intValue();
                                if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                    composer5.skipToGroupEnd();
                                } else {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1948508219, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.TreeCardShareContentView.<anonymous>.<anonymous> (LoveWallTreeCardSharePageView.kt:160)");
                                    }
                                    i.Companion companion4 = i.INSTANCE;
                                    SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion4, 12), composer5, 8, 0);
                                    i v3 = ComposeLayoutPropUpdaterKt.v(companion4, 63.58f, 36.0f);
                                    final LoveWallTreeCardShareViewModel loveWallTreeCardShareViewModel3 = LoveWallTreeCardShareViewModel.this;
                                    BoxKt.a(v3, null, null, ComposableLambdaKt.composableLambda(composer5, -1688641419, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.LoveWallTreeCardSharePageViewKt.TreeCardShareContentView.1.2.1
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public final Unit invoke(b bVar3, Composer composer6, Integer num3) {
                                            Composer composer7 = composer6;
                                            int intValue3 = num3.intValue();
                                            if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                                composer7.skipToGroupEnd();
                                            } else {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1688641419, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.TreeCardShareContentView.<anonymous>.<anonymous>.<anonymous> (LoveWallTreeCardSharePageView.kt:163)");
                                                }
                                                i.Companion companion5 = i.INSTANCE;
                                                float f17 = 36;
                                                float f18 = 18;
                                                i j3 = ModifiersKt.j(ComposeLayoutPropUpdaterKt.u(companion5, f17), f18);
                                                BorderStyle borderStyle = BorderStyle.SOLID;
                                                h.Companion companion6 = h.INSTANCE;
                                                QQAvatarViewKt.QQAvatarView(ModifiersKt.g(j3, new com.tencent.kuikly.core.base.e(1.64f, borderStyle, companion6.m())), null, c.f117352a.g().getPageData().n().q("uin", ""), composer7, 8, 2);
                                                QQAvatarViewKt.QQAvatarView(ModifiersKt.g(ModifiersKt.j(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(companion5, f17), 27.58f, 0.0f, 0.0f, 0.0f, 14, null), f18), new com.tencent.kuikly.core.base.e(1.64f, borderStyle, companion6.m())), null, LoveWallTreeCardShareViewModel.this.pageData.peerUin, composer7, 8, 2);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer5, 3080, 6);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer3, 24584, 10);
                        i h18 = ComposeLayoutPropUpdaterKt.h(companion2, 0.0f, 1, null);
                        Alignment.Horizontal b17 = companion3.b();
                        final float f17 = f16;
                        final LoveWallTreeCardShareViewModel loveWallTreeCardShareViewModel3 = LoveWallTreeCardShareViewModel.this;
                        ColumnKt.a(h18, null, b17, null, ComposableLambdaKt.composableLambda(composer3, 541599716, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.LoveWallTreeCardSharePageViewKt$TreeCardShareContentView$1.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(d dVar, Composer composer4, Integer num2) {
                                Composer composer5 = composer4;
                                int intValue2 = num2.intValue();
                                if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                    composer5.skipToGroupEnd();
                                } else {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(541599716, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.TreeCardShareContentView.<anonymous>.<anonymous> (LoveWallTreeCardSharePageView.kt:182)");
                                    }
                                    i.Companion companion4 = i.INSTANCE;
                                    SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion4, 30), composer5, 8, 0);
                                    i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion4, 0.0f, 1, null), f17), 16.28f, 0.0f, 10, 0.0f, 10, null);
                                    final LoveWallTreeCardShareViewModel loveWallTreeCardShareViewModel4 = loveWallTreeCardShareViewModel3;
                                    LoveWallFlowerGeneralCardConfig loveWallFlowerGeneralCardConfig = new LoveWallFlowerGeneralCardConfig(loveWallTreeCardShareViewModel4.config.title, 23.0f, false);
                                    final float f18 = f17;
                                    LoveWallFlowerGeneralCardKt.LoveWallFlowerGeneralCard(n3, loveWallFlowerGeneralCardConfig, ComposableLambdaKt.composableLambda(composer5, -799448560, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.LoveWallTreeCardSharePageViewKt.TreeCardShareContentView.1.3.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public final Unit invoke(Composer composer6, Integer num3) {
                                            String replace$default;
                                            String replace$default2;
                                            String replace$default3;
                                            List listOf;
                                            Composer composer7 = composer6;
                                            int intValue3 = num3.intValue();
                                            if ((intValue3 & 11) == 2 && composer7.getSkipping()) {
                                                composer7.skipToGroupEnd();
                                            } else {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-799448560, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.TreeCardShareContentView.<anonymous>.<anonymous>.<anonymous> (LoveWallTreeCardSharePageView.kt:195)");
                                                }
                                                i.Companion companion5 = i.INSTANCE;
                                                float f19 = 12;
                                                i j3 = ModifiersKt.j(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion5, 0.0f, 1, null), f18 - 170), f19, 5, f19, 0.0f, 8, null), 11.0f);
                                                final LoveWallTreeCardShareViewModel loveWallTreeCardShareViewModel5 = loveWallTreeCardShareViewModel4;
                                                BoxKt.a(j3, null, null, ComposableLambdaKt.composableLambda(composer7, -214356970, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.LoveWallTreeCardSharePageViewKt.TreeCardShareContentView.1.3.1.1
                                                    {
                                                        super(3);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function3
                                                    public final Unit invoke(b bVar3, Composer composer8, Integer num4) {
                                                        Composer composer9 = composer8;
                                                        int intValue4 = num4.intValue();
                                                        if ((intValue4 & 81) == 16 && composer9.getSkipping()) {
                                                            composer9.skipToGroupEnd();
                                                        } else {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-214356970, intValue4, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.TreeCardShareContentView.<anonymous>.<anonymous>.<anonymous>.<anonymous> (LoveWallTreeCardSharePageView.kt:201)");
                                                            }
                                                            i.Companion companion6 = i.INSTANCE;
                                                            BoxKt.a(ModifiersKt.e(ComposeLayoutPropUpdaterKt.h(companion6, 0.0f, 1, null), Direction.TO_BOTTOM, new j(new h(4283030271L), 0.0f), new j(new h(4294967295L), 1.0f)), null, null, null, composer9, 8, 14);
                                                            if (LoveWallTreeCardShareViewModel.this.hasTreeImage.getValue().booleanValue()) {
                                                                ImageKt.a(null, LoveWallTreeCardShareViewModel.this.treeImageRawData, null, null, null, ComposeLayoutPropUpdaterKt.h(companion6, 0.0f, 1, null), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer9, m.f247499e, 0, 0, 2097117);
                                                            }
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                }), composer7, 3080, 6);
                                                i n16 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.h(companion5, 0.0f, 1, null), f19, 2, 0, 0.0f, 8, null);
                                                LoveWallTreeCardShareViewModel loveWallTreeCardShareViewModel6 = loveWallTreeCardShareViewModel4;
                                                replace$default = StringsKt__StringsJVMKt.replace$default("\u6211\u4eec\u7cbe\u5fc3\u57f9\u80b2\u4e86{days}\u5929\n\u85e4\u8513\u9ad8{height}\n\u7ed3\u51fa{flower_count}\u4e2a\u5c5e\u4e8e\u6211\u4eec\u7684\u7231\u60c5\u679c\u5b9e", "{days}", String.valueOf(loveWallTreeCardShareViewModel6.achieveDays), false, 4, (Object) null);
                                                StringBuilder sb5 = new StringBuilder();
                                                sb5.append(loveWallTreeCardShareViewModel6.treeHeight);
                                                sb5.append('m');
                                                replace$default2 = StringsKt__StringsJVMKt.replace$default(replace$default, "{height}", sb5.toString(), false, 4, (Object) null);
                                                replace$default3 = StringsKt__StringsJVMKt.replace$default(replace$default2, "{flower_count}", String.valueOf(loveWallTreeCardShareViewModel6.config.flowersCount), false, 4, (Object) null);
                                                bp3.j jVar = new bp3.j(h.INSTANCE.b(), Float.valueOf(10.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, 32764, null);
                                                StringBuilder sb6 = new StringBuilder();
                                                sb6.append(loveWallTreeCardShareViewModel4.treeHeight);
                                                sb6.append('m');
                                                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{String.valueOf(loveWallTreeCardShareViewModel4.achieveDays), sb6.toString(), String.valueOf(loveWallTreeCardShareViewModel4.config.flowersCount)});
                                                RichTextKt.b(LoveSproutCardViewKt.highlightedText(replace$default3, jVar, listOf, new bp3.j(new h(255, 128, 0, 1.0f), Float.valueOf(15.0f), bp3.c.INSTANCE.h(), null, new n("DINPro-Bold"), null, null, null, null, null, null, Float.valueOf(0.0f), null, null, null, 30696, null)), n16, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, composer7, 64, 0, 0, 268435452);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer5, QFSBottomDynamicGuideEvent.DYNAMIC_GUIDE_BUTTON_TYPE, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer3, 24584, 10);
                        float f18 = 12;
                        i a16 = bVar2.a(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion2, 0.0f, 1, null), 40), f18, 0.0f, f18, f18, 2, null), Alignment.BottomStart);
                        Alignment.Vertical c16 = companion3.c();
                        a.e e16 = a.f339245a.e();
                        final LoveWallTreeCardShareViewModel loveWallTreeCardShareViewModel4 = LoveWallTreeCardShareViewModel.this;
                        RowKt.a(a16, e16, c16, null, null, ComposableLambdaKt.composableLambda(composer3, 693017072, true, new Function3<com.tencent.ntcompose.foundation.layout.n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.LoveWallTreeCardSharePageViewKt$TreeCardShareContentView$1.4
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(com.tencent.ntcompose.foundation.layout.n nVar, Composer composer4, Integer num2) {
                                Composer composer5 = composer4;
                                int intValue2 = num2.intValue();
                                if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                    composer5.skipToGroupEnd();
                                } else {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(693017072, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.TreeCardShareContentView.<anonymous>.<anonymous> (LoveWallTreeCardSharePageView.kt:248)");
                                    }
                                    i.Companion companion4 = i.INSTANCE;
                                    float f19 = 40;
                                    ColumnKt.a(ComposeLayoutPropUpdaterKt.v(companion4, 125, f19), null, null, null, ComposableSingletons$LoveWallTreeCardSharePageViewKt.f114lambda1, composer5, 24584, 14);
                                    i D = ModifiersKt.D(ComposeLayoutPropUpdaterKt.u(companion4, f19), 0.5f);
                                    LoveWallTreeCardShareViewModel loveWallTreeCardShareViewModel5 = LoveWallTreeCardShareViewModel.this;
                                    loveWallTreeCardShareViewModel5.getClass();
                                    StringBuilder sb5 = new StringBuilder();
                                    sb5.append("mqzone://arouse/intimate/lovetree?uin=");
                                    sb5.append(c.f117352a.g().getPageData().n().q("uin", ""));
                                    sb5.append("&peer_uin=");
                                    String m3 = OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0.m(sb5, loveWallTreeCardShareViewModel5.pageData.peerUin, "&enter_page=0&from=4");
                                    StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("https://ti.qq.com/open_qq/index.html?url=");
                                    m16.append(UriKt.encodeURIComponent(m3));
                                    String sb6 = m16.toString();
                                    DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0.m("qrCodeUrl: ", sb6, KLog.INSTANCE, "LoveWallTreeCardShareViewModel");
                                    QRCodeViewKt.QRCodeView(D, null, sb6, 40.0f, null, null, composer5, 3080, 50);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer3, 196680, 24);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, ((i3 << 3) & 896) | 3080, 2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Function2<? super v, ? super aa<v>, Unit> function22 = function2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.LoveWallTreeCardSharePageViewKt$TreeCardShareContentView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                LoveWallTreeCardSharePageViewKt.TreeCardShareContentView(i.this, function22, f16, loveWallTreeCardShareViewModel, composer2, i3 | 1, i16);
                return Unit.INSTANCE;
            }
        });
    }
}
