package com.tencent.hippykotlin.demo.pages.nearby.follower_page.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.avcore.jni.audiodevice.TraeAudioManager;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_component.ActionButtonParams;
import com.tencent.hippykotlin.demo.pages.foundation.qui_component.QActionSheetAttr;
import com.tencent.hippykotlin.demo.pages.foundation.qui_component.QActionSheetEvent;
import com.tencent.hippykotlin.demo.pages.foundation.qui_component.QActionSheetKt;
import com.tencent.hippykotlin.demo.pages.foundation.qui_component.QActionSheetView;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.follower_page.view_model.NBPFollowerViewModel;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.foundation.lazy.layout.LazyDslKt;
import com.tencent.ntcompose.lifecycle.viewmodel.b;
import com.tencent.ntcompose.lifecycle.viewmodel.compose.a;
import com.tencent.ntcompose.lifecycle.viewmodel.e;
import com.tencent.ntcompose.lifecycle.viewmodel.g;
import com.tencent.ntcompose.lifecycle.viewmodel.i;
import com.tencent.ntcompose.lifecycle.viewmodel.k;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.KuiklyKt;
import com.tencent.ntcompose.material.PagerListKt;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.TabRowKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.ntcompose.ui.platform.CompositionLocalsKt;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
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
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.CoroutineScope;
import org.aspectj.lang.JoinPoint;

/* loaded from: classes31.dex */
public final class NBPFollowerPageKt {
    public static final void NBPFollowerPage(final NBPFollowerViewModel nBPFollowerViewModel, Composer composer, final int i3, final int i16) {
        b bVar;
        Composer startRestartGroup = composer.startRestartGroup(1736779698);
        int i17 = i16 & 1;
        int i18 = i17 != 0 ? i3 | 2 : i3;
        if (i17 == 1 && (i18 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            startRestartGroup.startDefaults();
            if ((i3 & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                startRestartGroup.skipToGroupEnd();
            } else if (i17 != 0) {
                NBPFollowerPageKt$NBPFollowerPage$1 nBPFollowerPageKt$NBPFollowerPage$1 = new Function1<b, NBPFollowerViewModel>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerPageKt$NBPFollowerPage$1
                    @Override // kotlin.jvm.functions.Function1
                    public final NBPFollowerViewModel invoke(b bVar2) {
                        return new NBPFollowerViewModel(c.f117352a.g().getPageData());
                    }
                };
                startRestartGroup.startReplaceableGroup(1485077867);
                Object consume = startRestartGroup.consume(CompositionLocalsKt.f());
                if (consume != null) {
                    k kVar = (k) consume;
                    KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(NBPFollowerViewModel.class);
                    e eVar = new e();
                    eVar.a(Reflection.getOrCreateKotlinClass(NBPFollowerViewModel.class), nBPFollowerPageKt$NBPFollowerPage$1);
                    i.b b16 = eVar.b();
                    if (kVar instanceof com.tencent.ntcompose.lifecycle.viewmodel.c) {
                        bVar = ((com.tencent.ntcompose.lifecycle.viewmodel.c) kVar).a();
                    } else {
                        bVar = b.a.f339329b;
                    }
                    g c16 = a.c(orCreateKotlinClass, kVar, null, b16, bVar, startRestartGroup, TraeAudioManager.CustomHandler.MSG_VOICE_CALL_PRE_PROCESS, 0);
                    startRestartGroup.endReplaceableGroup();
                    nBPFollowerViewModel = (NBPFollowerViewModel) c16;
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
                }
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1736779698, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerPage (NBPFollowerPage.kt:49)");
            }
            ColumnKt.a(ComposeLayoutPropUpdaterKt.h(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, 1, null), null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1840933979, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerPageKt$NBPFollowerPage$2

                @DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerPageKt$NBPFollowerPage$2$1", f = "NBPFollowerPage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerPageKt$NBPFollowerPage$2$1, reason: invalid class name */
                /* loaded from: classes31.dex */
                public final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    public final /* synthetic */ NBPFollowerViewModel $followerVM;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public AnonymousClass1(NBPFollowerViewModel nBPFollowerViewModel, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.$followerVM = nBPFollowerViewModel;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(this.$followerVM, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        ResultKt.throwOnFailure(obj);
                        this.$followerVM.postNotify();
                        return Unit.INSTANCE;
                    }
                }

                @DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerPageKt$NBPFollowerPage$2$2", f = "NBPFollowerPage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerPageKt$NBPFollowerPage$2$2, reason: invalid class name */
                /* loaded from: classes31.dex */
                public final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    public final /* synthetic */ NBPFollowerViewModel $followerVM;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public AnonymousClass2(NBPFollowerViewModel nBPFollowerViewModel, Continuation<? super AnonymousClass2> continuation) {
                        super(2, continuation);
                        this.$followerVM = nBPFollowerViewModel;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass2(this.$followerVM, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        ResultKt.throwOnFailure(obj);
                        this.$followerVM.postNotify();
                        return Unit.INSTANCE;
                    }
                }

                {
                    super(3);
                }

                public static final int invoke$lambda$1(MutableState<Integer> mutableState) {
                    return mutableState.getValue().intValue();
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function3
                public final Unit invoke(d dVar, Composer composer2, Integer num) {
                    final List mutableListOf;
                    Composer composer3 = composer2;
                    int intValue = num.intValue();
                    if ((intValue & 81) == 16 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                    } else {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1840933979, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerPage.<anonymous> (NBPFollowerPage.kt:54)");
                        }
                        KLog.INSTANCE.i("isFansArea", String.valueOf(NBPFollowerViewModel.this.clickAreaInt));
                        NBPFollowerViewModel nBPFollowerViewModel2 = NBPFollowerViewModel.this;
                        composer3.startReplaceableGroup(-492369756);
                        Object rememberedValue = composer3.rememberedValue();
                        Composer.Companion companion = Composer.INSTANCE;
                        if (rememberedValue == companion.getEmpty()) {
                            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Integer.valueOf(nBPFollowerViewModel2.clickAreaInt == 2 ? 0 : 1), null, 2, null);
                            composer3.updateRememberedValue(rememberedValue);
                        }
                        composer3.endReplaceableGroup();
                        final MutableState mutableState = (MutableState) rememberedValue;
                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\u7c89\u4e1d ");
                        m3.append(NBPFollowerViewModel.this.getTotalFansCount());
                        StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\u5173\u6ce8 ");
                        m16.append(NBPFollowerViewModel.this.getTotalFollowingCount());
                        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(m3.toString(), m16.toString());
                        final com.tencent.ntcompose.foundation.lazy.d a16 = com.tencent.ntcompose.foundation.lazy.e.a(0, 0.0f, composer3, 0, 3);
                        EffectsKt.LaunchedEffect(Integer.valueOf(NBPFollowerViewModel.this.getTotalFansCount()), new AnonymousClass1(NBPFollowerViewModel.this, null), composer3, 64);
                        EffectsKt.LaunchedEffect(Integer.valueOf(NBPFollowerViewModel.this.getTotalFollowingCount()), new AnonymousClass2(NBPFollowerViewModel.this, null), composer3, 64);
                        int invoke$lambda$1 = invoke$lambda$1(mutableState);
                        final NBPFollowerViewModel nBPFollowerViewModel3 = NBPFollowerViewModel.this;
                        NBPFollowerPageKt.NBPFollowerNavBar(invoke$lambda$1, mutableListOf, new Function1<Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerPageKt$NBPFollowerPage$2.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(Integer num2) {
                                String str;
                                int intValue2 = num2.intValue();
                                mutableState.setValue(Integer.valueOf(intValue2));
                                com.tencent.ntcompose.foundation.lazy.d.x(com.tencent.ntcompose.foundation.lazy.d.this, intValue2, 0.0f, true, null, 10, null);
                                if (mutableState.getValue().intValue() == 0) {
                                    str = "em_nearby_tab_fans";
                                } else {
                                    str = "em_nearby_tab_focus";
                                }
                                nBPFollowerViewModel3.dtReportElementClick(str, mutableState.getValue().intValue() == 0);
                                return Unit.INSTANCE;
                            }
                        }, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerPageKt$NBPFollowerPage$2.4
                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                QQKuiklyPlatformApi.Companion companion2 = QQKuiklyPlatformApi.Companion;
                                QQKuiklyPlatformApi.Companion.closePage$default();
                                return Unit.INSTANCE;
                            }
                        }, composer3, 3136);
                        com.tencent.ntcompose.core.i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.h(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, 1, null), 0.0f, 0.0f, 0.0f, NBPFollowerViewModel.this.marginBottom.getValue().floatValue(), 7, null);
                        int intValue2 = ((Number) mutableState.getValue()).intValue();
                        Float valueOf = Float.valueOf(((com.tencent.ntcompose.ui.platform.a) composer3.consume(CompositionLocalsKt.d())).e());
                        composer3.startReplaceableGroup(1157296644);
                        boolean changed = composer3.changed(mutableState);
                        Object rememberedValue2 = composer3.rememberedValue();
                        if (changed || rememberedValue2 == companion.getEmpty()) {
                            rememberedValue2 = new Function1<Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerPageKt$NBPFollowerPage$2$5$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(Integer num2) {
                                    mutableState.setValue(Integer.valueOf(num2.intValue()));
                                    return Unit.INSTANCE;
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue2);
                        }
                        composer3.endReplaceableGroup();
                        PagerListKt.a(n3, null, a16, valueOf, intValue2, null, null, null, null, null, null, 0, null, null, null, 0.0f, (Function1) rememberedValue2, null, null, null, null, null, null, ComposableLambdaKt.composableLambda(composer3, 1755393998, true, new Function3<com.tencent.ntcompose.foundation.lazy.layout.a, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerPageKt$NBPFollowerPage$2.6
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(com.tencent.ntcompose.foundation.lazy.layout.a aVar, Composer composer4, Integer num2) {
                                com.tencent.ntcompose.foundation.lazy.layout.a aVar2 = aVar;
                                Composer composer5 = composer4;
                                int intValue3 = num2.intValue();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1755393998, intValue3, -1, "com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerPage.<anonymous>.<anonymous> (NBPFollowerPage.kt:92)");
                                }
                                LazyDslKt.c(aVar2, mutableListOf, null, ComposableSingletons$NBPFollowerPageKt.f44lambda1, composer5, 3144, 2);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer3, 8, 0, 3072, 8323042);
                        if (NBPFollowerViewModel.this.isSelf.getValue().booleanValue()) {
                            NBPFollowerPageKt.NBPFollowerFootBar(null, composer3, 0, 1);
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
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerPageKt$NBPFollowerPage$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                NBPFollowerPageKt.NBPFollowerPage(NBPFollowerViewModel.this, composer2, i3 | 1, i16);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void NBPFollowerNavBar(final int i3, final List<String> list, final Function1<? super Integer, Unit> function1, final Function0<Unit> function0, Composer composer, final int i16) {
        Composer startRestartGroup = composer.startRestartGroup(572600079);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(572600079, i16, -1, "com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerNavBar (NBPFollowerPage.kt:114)");
        }
        BoxKt.a(ModifiersKt.d(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.j(ComposeLayoutPropUpdaterKt.k(com.tencent.ntcompose.core.i.INSTANCE, ((com.tencent.ntcompose.ui.platform.a) startRestartGroup.consume(CompositionLocalsKt.d())).i() + 44), 0.0f, 1, null), 0.0f, ((com.tencent.ntcompose.ui.platform.a) startRestartGroup.consume(CompositionLocalsKt.d())).i(), 0.0f, 0.0f, 13, null), QUIToken.color$default("bg_middle_light")), Alignment.Center, null, ComposableLambdaKt.composableLambda(startRestartGroup, -856685163, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerPageKt$NBPFollowerNavBar$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer2, Integer num) {
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-856685163, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerNavBar.<anonymous> (NBPFollowerPage.kt:125)");
                    }
                    i.Companion companion = com.tencent.ntcompose.core.i.INSTANCE;
                    float f16 = 20;
                    com.tencent.ntcompose.core.i p16 = ComposeLayoutPropUpdaterKt.p(ComposeLayoutPropUpdaterKt.u(companion, 36.0f), ((-((com.tencent.ntcompose.ui.platform.a) composer3.consume(CompositionLocalsKt.d())).e()) / 2) + f16, 0.0f, 2, null);
                    final Function0<Unit> function02 = function0;
                    composer3.startReplaceableGroup(1157296644);
                    boolean changed = composer3.changed(function02);
                    Object rememberedValue = composer3.rememberedValue();
                    if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerPageKt$NBPFollowerNavBar$1$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ClickParams clickParams) {
                                function02.invoke();
                                return Unit.INSTANCE;
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue);
                    }
                    composer3.endReplaceableGroup();
                    BoxKt.a(ViewEventPropUpdaterKt.d(p16, false, null, (Function1) rememberedValue, 3, null), Alignment.Center, null, ComposableSingletons$NBPFollowerPageKt.f45lambda2, composer3, 3128, 4);
                    TabRowKt.c(i3, ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(companion, 44), 0.0f, f16, 0.0f, 0.0f, 13, null), ComposableSingletons$NBPFollowerPageKt.f46lambda3, ComposableLambdaKt.composableLambda(composer3, -51573270, true, new Function2<Composer, Integer, Unit>(list, function1, i16, i3) { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerPageKt$NBPFollowerNavBar$1.2
                        public final /* synthetic */ Function1<Integer, Unit> $clickTabHandlerFn;
                        public final /* synthetic */ int $selectedIndex;
                        public final /* synthetic */ List<String> $titles;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                            this.$selectedIndex = r4;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Unit invoke(Composer composer4, Integer num2) {
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 11) == 2 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-51573270, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerNavBar.<anonymous>.<anonymous> (NBPFollowerPage.kt:155)");
                                }
                                List<String> list2 = this.$titles;
                                final Function1<Integer, Unit> function12 = this.$clickTabHandlerFn;
                                final int i17 = this.$selectedIndex;
                                final int i18 = 0;
                                for (Object obj : list2) {
                                    int i19 = i18 + 1;
                                    if (i18 < 0) {
                                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                                    }
                                    final String str = (String) obj;
                                    com.tencent.ntcompose.core.i w3 = ComposeLayoutPropUpdaterKt.w(com.tencent.ntcompose.core.i.INSTANCE, (((com.tencent.ntcompose.ui.platform.a) composer5.consume(CompositionLocalsKt.d())).e() / 2) - 70);
                                    Object valueOf = Integer.valueOf(i18);
                                    composer5.startReplaceableGroup(511388516);
                                    boolean changed2 = composer5.changed(valueOf) | composer5.changed(function12);
                                    Object rememberedValue2 = composer5.rememberedValue();
                                    if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue2 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerPageKt$NBPFollowerNavBar$1$2$1$1$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                function12.invoke(Integer.valueOf(i18));
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        composer5.updateRememberedValue(rememberedValue2);
                                    }
                                    composer5.endReplaceableGroup();
                                    TabRowKt.b(w3, (Function1) rememberedValue2, null, Alignment.Horizontal.CenterHorizontally, ComposableLambdaKt.composableLambda(composer5, -78925914, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerPageKt$NBPFollowerNavBar$1$2$1$2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public final Unit invoke(d dVar, Composer composer6, Integer num3) {
                                            h color$default;
                                            Composer composer7 = composer6;
                                            int intValue3 = num3.intValue();
                                            if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                                composer7.skipToGroupEnd();
                                            } else {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-78925914, intValue3, -1, "com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerNavBar.<anonymous>.<anonymous>.<anonymous>.<anonymous> (NBPFollowerPage.kt:164)");
                                                }
                                                bp3.c f17 = bp3.c.INSTANCE.f();
                                                if (i17 == i18) {
                                                    color$default = QUIToken.color$default("brand_standard");
                                                } else {
                                                    color$default = QUIToken.color$default("text_primary");
                                                }
                                                TextKt.a(str, null, null, color$default, Float.valueOf(16.0f), null, f17, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer7, 1601536, 0, 0, 134217638);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer5, 27656, 4);
                                    i18 = i19;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, (i16 & 14) | 3520, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 3128, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerPageKt$NBPFollowerNavBar$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                NBPFollowerPageKt.NBPFollowerNavBar(i3, list, function1, function0, composer2, i16 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void NBPFollowerFootBar(NBPFollowerViewModel nBPFollowerViewModel, Composer composer, final int i3, final int i16) {
        b bVar;
        final NBPFollowerViewModel nBPFollowerViewModel2;
        Composer startRestartGroup = composer.startRestartGroup(-1963530092);
        int i17 = i16 & 1;
        int i18 = i17 != 0 ? i3 | 2 : i3;
        if (i17 == 1 && (i18 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            nBPFollowerViewModel2 = nBPFollowerViewModel;
        } else {
            startRestartGroup.startDefaults();
            if ((i3 & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                startRestartGroup.skipToGroupEnd();
            } else if (i17 != 0) {
                NBPFollowerPageKt$NBPFollowerFootBar$1 nBPFollowerPageKt$NBPFollowerFootBar$1 = new Function1<b, NBPFollowerViewModel>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerPageKt$NBPFollowerFootBar$1
                    @Override // kotlin.jvm.functions.Function1
                    public final NBPFollowerViewModel invoke(b bVar2) {
                        return new NBPFollowerViewModel(c.f117352a.g().getPageData());
                    }
                };
                startRestartGroup.startReplaceableGroup(1485077867);
                Object consume = startRestartGroup.consume(CompositionLocalsKt.f());
                if (consume != null) {
                    k kVar = (k) consume;
                    KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(NBPFollowerViewModel.class);
                    e eVar = new e();
                    eVar.a(Reflection.getOrCreateKotlinClass(NBPFollowerViewModel.class), nBPFollowerPageKt$NBPFollowerFootBar$1);
                    i.b b16 = eVar.b();
                    if (kVar instanceof com.tencent.ntcompose.lifecycle.viewmodel.c) {
                        bVar = ((com.tencent.ntcompose.lifecycle.viewmodel.c) kVar).a();
                    } else {
                        bVar = b.a.f339329b;
                    }
                    g c16 = a.c(orCreateKotlinClass, kVar, null, b16, bVar, startRestartGroup, TraeAudioManager.CustomHandler.MSG_VOICE_CALL_PRE_PROCESS, 0);
                    startRestartGroup.endReplaceableGroup();
                    nBPFollowerViewModel2 = (NBPFollowerViewModel) c16;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1963530092, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerFootBar (NBPFollowerPage.kt:178)");
                    }
                    float f16 = !((com.tencent.ntcompose.ui.platform.a) startRestartGroup.consume(CompositionLocalsKt.d())).j() ? 66 : 86;
                    ColumnKt.a(ModifiersKt.d(ComposeLayoutPropUpdaterKt.j(ViewEventPropUpdaterKt.d(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.p(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, -f16, 1, null), f16), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerPageKt$NBPFollowerFootBar$2
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ClickParams clickParams) {
                            NBPFollowerViewModel.this.setShowActionSheet(true);
                            return Unit.INSTANCE;
                        }
                    }, 3, null), 0.0f, 1, null), QUIToken.color$default("fill_standard_primary")), null, Alignment.Horizontal.CenterHorizontally, null, ComposableLambdaKt.composableLambda(startRestartGroup, -69732533, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerPageKt$NBPFollowerFootBar$3
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
                                    ComposerKt.traceEventStart(-69732533, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerFootBar.<anonymous> (NBPFollowerPage.kt:192)");
                                }
                                com.tencent.ntcompose.core.i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(com.tencent.ntcompose.core.i.INSTANCE, 52), 0.0f, 10, 0.0f, 0.0f, 13, null);
                                Alignment alignment = Alignment.Center;
                                final NBPFollowerViewModel nBPFollowerViewModel3 = NBPFollowerViewModel.this;
                                BoxKt.a(n3, alignment, null, ComposableLambdaKt.composableLambda(composer3, 559397201, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerPageKt$NBPFollowerFootBar$3.1
                                    {
                                        super(3);
                                    }

                                    /* JADX WARN: Multi-variable type inference failed */
                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar2, Composer composer4, Integer num2) {
                                        Composer composer5 = composer4;
                                        int intValue2 = num2.intValue();
                                        if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                            composer5.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(559397201, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerFootBar.<anonymous>.<anonymous> (NBPFollowerPage.kt:196)");
                                            }
                                            final NBPFollowerViewModel nBPFollowerViewModel4 = NBPFollowerViewModel.this;
                                            RowKt.a(null, null, null, null, null, ComposableLambdaKt.composableLambda(composer5, 277863923, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerPageKt.NBPFollowerFootBar.3.1.1
                                                {
                                                    super(3);
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public final Unit invoke(n nVar, Composer composer6, Integer num3) {
                                                    Composer composer7 = composer6;
                                                    int intValue3 = num3.intValue();
                                                    if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                                        composer7.skipToGroupEnd();
                                                    } else {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(277863923, intValue3, -1, "com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerFootBar.<anonymous>.<anonymous>.<anonymous> (NBPFollowerPage.kt:197)");
                                                        }
                                                        final NBPFollowerViewModel nBPFollowerViewModel5 = NBPFollowerViewModel.this;
                                                        RowKt.a(null, null, null, null, null, ComposableLambdaKt.composableLambda(composer7, -1569376491, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerPageKt.NBPFollowerFootBar.3.1.1.1
                                                            {
                                                                super(3);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function3
                                                            public final Unit invoke(n nVar2, Composer composer8, Integer num4) {
                                                                String str;
                                                                Composer composer9 = composer8;
                                                                int intValue4 = num4.intValue();
                                                                if ((intValue4 & 81) == 16 && composer9.getSkipping()) {
                                                                    composer9.skipToGroupEnd();
                                                                } else {
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventStart(-1569376491, intValue4, -1, "com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerFootBar.<anonymous>.<anonymous>.<anonymous>.<anonymous> (NBPFollowerPage.kt:198)");
                                                                    }
                                                                    if (NBPFollowerViewModel.this.getFollowInfoOnlySelf()) {
                                                                        str = JoinPoint.SYNCHRONIZATION_LOCK;
                                                                    } else {
                                                                        str = "lock_off";
                                                                    }
                                                                    i.Companion companion = com.tencent.ntcompose.core.i.INSTANCE;
                                                                    ImageKt.a(QUIToken.INSTANCE.image(str, QUIToken.color$default("icon_primary")), null, null, null, null, ComposeLayoutPropUpdaterKt.u(companion, 16), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer9, 262144, 0, 0, 2097118);
                                                                    SpacerKt.a(ComposeLayoutPropUpdaterKt.w(companion, 5), composer9, 8, 0);
                                                                    TextKt.a("\u8c01\u53ef\u4ee5\u770b\u5230\u6211\u7684\u7c89\u4e1d\u548c\u5173\u6ce8", null, null, QUIToken.color$default("text_primary"), Float.valueOf(14.0f), null, bp3.c.INSTANCE.e(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer9, 1601542, 0, 0, 134217638);
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventEnd();
                                                                    }
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        }), composer7, 196608, 31);
                                                        SpacerKt.a(ComposeLayoutPropUpdaterKt.w(com.tencent.ntcompose.core.i.INSTANCE, 100), composer7, 8, 0);
                                                        final NBPFollowerViewModel nBPFollowerViewModel6 = NBPFollowerViewModel.this;
                                                        RowKt.a(null, null, null, null, null, ComposableLambdaKt.composableLambda(composer7, 1340366668, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerPageKt.NBPFollowerFootBar.3.1.1.2
                                                            {
                                                                super(3);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function3
                                                            public final Unit invoke(n nVar2, Composer composer8, Integer num4) {
                                                                String str;
                                                                Composer composer9 = composer8;
                                                                int intValue4 = num4.intValue();
                                                                if ((intValue4 & 81) == 16 && composer9.getSkipping()) {
                                                                    composer9.skipToGroupEnd();
                                                                } else {
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventStart(1340366668, intValue4, -1, "com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerFootBar.<anonymous>.<anonymous>.<anonymous>.<anonymous> (NBPFollowerPage.kt:213)");
                                                                    }
                                                                    if (NBPFollowerViewModel.this.getFollowInfoOnlySelf()) {
                                                                        str = "\u4ec5\u81ea\u5df1";
                                                                    } else {
                                                                        str = "\u6240\u6709\u4eba";
                                                                    }
                                                                    bp3.c e16 = bp3.c.INSTANCE.e();
                                                                    QUIToken qUIToken = QUIToken.INSTANCE;
                                                                    TextKt.a(str, null, null, QUIToken.color$default("text_secondary"), Float.valueOf(14.0f), null, e16, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer9, 1601536, 0, 0, 134217638);
                                                                    ImageKt.a(qUIToken.image("chevron_right", QUIToken.color$default("icon_secondary")), null, null, null, null, ComposeLayoutPropUpdaterKt.u(com.tencent.ntcompose.core.i.INSTANCE, 16), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer9, 262144, 0, 0, 2097118);
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventEnd();
                                                                    }
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        }), composer7, 196608, 31);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }), composer5, 196608, 31);
                                            if (((Boolean) NBPFollowerViewModel.this.isShowActionSheet$delegate.getValue()).booleanValue()) {
                                                final NBPFollowerViewModel nBPFollowerViewModel5 = NBPFollowerViewModel.this;
                                                KuiklyKt.a(null, null, new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerPageKt.NBPFollowerFootBar.3.1.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                                                        final NBPFollowerViewModel nBPFollowerViewModel6 = NBPFollowerViewModel.this;
                                                        QActionSheetKt.QActionSheet(viewContainer, new Function1<QActionSheetView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerPageKt.NBPFollowerFootBar.3.1.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(QActionSheetView qActionSheetView) {
                                                                final QActionSheetView qActionSheetView2 = qActionSheetView;
                                                                qActionSheetView2.attr(new Function1<QActionSheetAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerPageKt.NBPFollowerFootBar.3.1.2.1.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(QActionSheetAttr qActionSheetAttr) {
                                                                        qActionSheetAttr.with("title", "\u8bbe\u7f6e\u7c89\u4e1d\u548c\u5173\u6ce8\u5217\u8868\u7684\u6743\u9650");
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final NBPFollowerViewModel nBPFollowerViewModel7 = NBPFollowerViewModel.this;
                                                                qActionSheetView2.event(new Function1<QActionSheetEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerPageKt.NBPFollowerFootBar.3.1.2.1.2
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(QActionSheetEvent qActionSheetEvent) {
                                                                        QActionSheetEvent qActionSheetEvent2 = qActionSheetEvent;
                                                                        final NBPFollowerViewModel nBPFollowerViewModel8 = NBPFollowerViewModel.this;
                                                                        final QActionSheetView qActionSheetView3 = qActionSheetView2;
                                                                        qActionSheetEvent2.onClickWithText(new Function1<ActionButtonParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerPageKt.NBPFollowerFootBar.3.1.2.1.2.1
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ActionButtonParams actionButtonParams) {
                                                                                int i19 = actionButtonParams.index;
                                                                                if (i19 == 0) {
                                                                                    NBPFollowerViewModel.this.setFollowOnlySelf(false);
                                                                                    qActionSheetView3.dismiss();
                                                                                    NBPFollowerViewModel.this.setShowActionSheet(false);
                                                                                    NBPFollowerViewModel.this.setFollowInfoOnlySelf(false);
                                                                                    NBPFollowerViewModel.this.dtReportPrivateElementClick(1);
                                                                                } else if (i19 == 1) {
                                                                                    NBPFollowerViewModel.this.setFollowOnlySelf(true);
                                                                                    qActionSheetView3.dismiss();
                                                                                    NBPFollowerViewModel.this.setShowActionSheet(false);
                                                                                    NBPFollowerViewModel.this.setFollowInfoOnlySelf(true);
                                                                                    NBPFollowerViewModel.this.dtReportPrivateElementClick(2);
                                                                                }
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        final NBPFollowerViewModel nBPFollowerViewModel9 = NBPFollowerViewModel.this;
                                                                        qActionSheetEvent2.register("onBottomCancelClick", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerPageKt.NBPFollowerFootBar.3.1.2.1.2.2
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(Object obj) {
                                                                                NBPFollowerViewModel.this.setShowActionSheet(false);
                                                                                NBPFollowerViewModel.this.dtReportPrivateElementClick(0);
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        final NBPFollowerViewModel nBPFollowerViewModel10 = NBPFollowerViewModel.this;
                                                                        qActionSheetEvent2.register("onDismiss", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerPageKt.NBPFollowerFootBar.3.1.2.1.2.3
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(Object obj) {
                                                                                NBPFollowerViewModel.this.setShowActionSheet(false);
                                                                                NBPFollowerViewModel.this.dtReportPrivateElementClick(0);
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                qActionSheetView2.addRadioButton("\u516c\u5f00", !NBPFollowerViewModel.this.getFollowInfoOnlySelf());
                                                                qActionSheetView2.addRadioButton("\u4ec5\u81ea\u5df1\u53ef\u89c1", NBPFollowerViewModel.this.getFollowInfoOnlySelf());
                                                                qActionSheetView2.addCancelButton();
                                                                qActionSheetView2.show();
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                }, composer5, 0, 3);
                                                int i19 = NBPFollowerViewModel.this.getFollowInfoOnlySelf() ? 2 : 1;
                                                com.tencent.kuikly.core.nvi.serialization.json.e dTPageParam = NBPFollowerViewModel.this.getDTPageParam(false);
                                                NBPFollowerViewModel nBPFollowerViewModel6 = NBPFollowerViewModel.this;
                                                dTPageParam.v("dt_eid", "em_nearby_privilege_set_float");
                                                dTPageParam.t("nearby_btn_type", i19);
                                                dTPageParam.v("cur_pg", nBPFollowerViewModel6.getDTPageParam(true));
                                                dTPageParam.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                                Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_imp", dTPageParam);
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer3, 3128, 4);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), startRestartGroup, 24968, 10);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
                }
            }
            nBPFollowerViewModel2 = nBPFollowerViewModel;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            float f162 = !((com.tencent.ntcompose.ui.platform.a) startRestartGroup.consume(CompositionLocalsKt.d())).j() ? 66 : 86;
            ColumnKt.a(ModifiersKt.d(ComposeLayoutPropUpdaterKt.j(ViewEventPropUpdaterKt.d(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.p(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, -f162, 1, null), f162), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerPageKt$NBPFollowerFootBar$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(ClickParams clickParams) {
                    NBPFollowerViewModel.this.setShowActionSheet(true);
                    return Unit.INSTANCE;
                }
            }, 3, null), 0.0f, 1, null), QUIToken.color$default("fill_standard_primary")), null, Alignment.Horizontal.CenterHorizontally, null, ComposableLambdaKt.composableLambda(startRestartGroup, -69732533, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerPageKt$NBPFollowerFootBar$3
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
                            ComposerKt.traceEventStart(-69732533, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerFootBar.<anonymous> (NBPFollowerPage.kt:192)");
                        }
                        com.tencent.ntcompose.core.i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(com.tencent.ntcompose.core.i.INSTANCE, 52), 0.0f, 10, 0.0f, 0.0f, 13, null);
                        Alignment alignment = Alignment.Center;
                        final NBPFollowerViewModel nBPFollowerViewModel3 = NBPFollowerViewModel.this;
                        BoxKt.a(n3, alignment, null, ComposableLambdaKt.composableLambda(composer3, 559397201, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerPageKt$NBPFollowerFootBar$3.1
                            {
                                super(3);
                            }

                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar2, Composer composer4, Integer num2) {
                                Composer composer5 = composer4;
                                int intValue2 = num2.intValue();
                                if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                    composer5.skipToGroupEnd();
                                } else {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(559397201, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerFootBar.<anonymous>.<anonymous> (NBPFollowerPage.kt:196)");
                                    }
                                    final NBPFollowerViewModel nBPFollowerViewModel4 = NBPFollowerViewModel.this;
                                    RowKt.a(null, null, null, null, null, ComposableLambdaKt.composableLambda(composer5, 277863923, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerPageKt.NBPFollowerFootBar.3.1.1
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public final Unit invoke(n nVar, Composer composer6, Integer num3) {
                                            Composer composer7 = composer6;
                                            int intValue3 = num3.intValue();
                                            if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                                composer7.skipToGroupEnd();
                                            } else {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(277863923, intValue3, -1, "com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerFootBar.<anonymous>.<anonymous>.<anonymous> (NBPFollowerPage.kt:197)");
                                                }
                                                final NBPFollowerViewModel nBPFollowerViewModel5 = NBPFollowerViewModel.this;
                                                RowKt.a(null, null, null, null, null, ComposableLambdaKt.composableLambda(composer7, -1569376491, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerPageKt.NBPFollowerFootBar.3.1.1.1
                                                    {
                                                        super(3);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function3
                                                    public final Unit invoke(n nVar2, Composer composer8, Integer num4) {
                                                        String str;
                                                        Composer composer9 = composer8;
                                                        int intValue4 = num4.intValue();
                                                        if ((intValue4 & 81) == 16 && composer9.getSkipping()) {
                                                            composer9.skipToGroupEnd();
                                                        } else {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-1569376491, intValue4, -1, "com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerFootBar.<anonymous>.<anonymous>.<anonymous>.<anonymous> (NBPFollowerPage.kt:198)");
                                                            }
                                                            if (NBPFollowerViewModel.this.getFollowInfoOnlySelf()) {
                                                                str = JoinPoint.SYNCHRONIZATION_LOCK;
                                                            } else {
                                                                str = "lock_off";
                                                            }
                                                            i.Companion companion = com.tencent.ntcompose.core.i.INSTANCE;
                                                            ImageKt.a(QUIToken.INSTANCE.image(str, QUIToken.color$default("icon_primary")), null, null, null, null, ComposeLayoutPropUpdaterKt.u(companion, 16), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer9, 262144, 0, 0, 2097118);
                                                            SpacerKt.a(ComposeLayoutPropUpdaterKt.w(companion, 5), composer9, 8, 0);
                                                            TextKt.a("\u8c01\u53ef\u4ee5\u770b\u5230\u6211\u7684\u7c89\u4e1d\u548c\u5173\u6ce8", null, null, QUIToken.color$default("text_primary"), Float.valueOf(14.0f), null, bp3.c.INSTANCE.e(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer9, 1601542, 0, 0, 134217638);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                }), composer7, 196608, 31);
                                                SpacerKt.a(ComposeLayoutPropUpdaterKt.w(com.tencent.ntcompose.core.i.INSTANCE, 100), composer7, 8, 0);
                                                final NBPFollowerViewModel nBPFollowerViewModel6 = NBPFollowerViewModel.this;
                                                RowKt.a(null, null, null, null, null, ComposableLambdaKt.composableLambda(composer7, 1340366668, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerPageKt.NBPFollowerFootBar.3.1.1.2
                                                    {
                                                        super(3);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function3
                                                    public final Unit invoke(n nVar2, Composer composer8, Integer num4) {
                                                        String str;
                                                        Composer composer9 = composer8;
                                                        int intValue4 = num4.intValue();
                                                        if ((intValue4 & 81) == 16 && composer9.getSkipping()) {
                                                            composer9.skipToGroupEnd();
                                                        } else {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(1340366668, intValue4, -1, "com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerFootBar.<anonymous>.<anonymous>.<anonymous>.<anonymous> (NBPFollowerPage.kt:213)");
                                                            }
                                                            if (NBPFollowerViewModel.this.getFollowInfoOnlySelf()) {
                                                                str = "\u4ec5\u81ea\u5df1";
                                                            } else {
                                                                str = "\u6240\u6709\u4eba";
                                                            }
                                                            bp3.c e16 = bp3.c.INSTANCE.e();
                                                            QUIToken qUIToken = QUIToken.INSTANCE;
                                                            TextKt.a(str, null, null, QUIToken.color$default("text_secondary"), Float.valueOf(14.0f), null, e16, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer9, 1601536, 0, 0, 134217638);
                                                            ImageKt.a(qUIToken.image("chevron_right", QUIToken.color$default("icon_secondary")), null, null, null, null, ComposeLayoutPropUpdaterKt.u(com.tencent.ntcompose.core.i.INSTANCE, 16), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer9, 262144, 0, 0, 2097118);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                }), composer7, 196608, 31);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer5, 196608, 31);
                                    if (((Boolean) NBPFollowerViewModel.this.isShowActionSheet$delegate.getValue()).booleanValue()) {
                                        final NBPFollowerViewModel nBPFollowerViewModel5 = NBPFollowerViewModel.this;
                                        KuiklyKt.a(null, null, new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerPageKt.NBPFollowerFootBar.3.1.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                                                final NBPFollowerViewModel nBPFollowerViewModel6 = NBPFollowerViewModel.this;
                                                QActionSheetKt.QActionSheet(viewContainer, new Function1<QActionSheetView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerPageKt.NBPFollowerFootBar.3.1.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(QActionSheetView qActionSheetView) {
                                                        final QActionSheetView qActionSheetView2 = qActionSheetView;
                                                        qActionSheetView2.attr(new Function1<QActionSheetAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerPageKt.NBPFollowerFootBar.3.1.2.1.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(QActionSheetAttr qActionSheetAttr) {
                                                                qActionSheetAttr.with("title", "\u8bbe\u7f6e\u7c89\u4e1d\u548c\u5173\u6ce8\u5217\u8868\u7684\u6743\u9650");
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final NBPFollowerViewModel nBPFollowerViewModel7 = NBPFollowerViewModel.this;
                                                        qActionSheetView2.event(new Function1<QActionSheetEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerPageKt.NBPFollowerFootBar.3.1.2.1.2
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(QActionSheetEvent qActionSheetEvent) {
                                                                QActionSheetEvent qActionSheetEvent2 = qActionSheetEvent;
                                                                final NBPFollowerViewModel nBPFollowerViewModel8 = NBPFollowerViewModel.this;
                                                                final QActionSheetView qActionSheetView3 = qActionSheetView2;
                                                                qActionSheetEvent2.onClickWithText(new Function1<ActionButtonParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerPageKt.NBPFollowerFootBar.3.1.2.1.2.1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ActionButtonParams actionButtonParams) {
                                                                        int i19 = actionButtonParams.index;
                                                                        if (i19 == 0) {
                                                                            NBPFollowerViewModel.this.setFollowOnlySelf(false);
                                                                            qActionSheetView3.dismiss();
                                                                            NBPFollowerViewModel.this.setShowActionSheet(false);
                                                                            NBPFollowerViewModel.this.setFollowInfoOnlySelf(false);
                                                                            NBPFollowerViewModel.this.dtReportPrivateElementClick(1);
                                                                        } else if (i19 == 1) {
                                                                            NBPFollowerViewModel.this.setFollowOnlySelf(true);
                                                                            qActionSheetView3.dismiss();
                                                                            NBPFollowerViewModel.this.setShowActionSheet(false);
                                                                            NBPFollowerViewModel.this.setFollowInfoOnlySelf(true);
                                                                            NBPFollowerViewModel.this.dtReportPrivateElementClick(2);
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final NBPFollowerViewModel nBPFollowerViewModel9 = NBPFollowerViewModel.this;
                                                                qActionSheetEvent2.register("onBottomCancelClick", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerPageKt.NBPFollowerFootBar.3.1.2.1.2.2
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(Object obj) {
                                                                        NBPFollowerViewModel.this.setShowActionSheet(false);
                                                                        NBPFollowerViewModel.this.dtReportPrivateElementClick(0);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final NBPFollowerViewModel nBPFollowerViewModel10 = NBPFollowerViewModel.this;
                                                                qActionSheetEvent2.register("onDismiss", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerPageKt.NBPFollowerFootBar.3.1.2.1.2.3
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(Object obj) {
                                                                        NBPFollowerViewModel.this.setShowActionSheet(false);
                                                                        NBPFollowerViewModel.this.dtReportPrivateElementClick(0);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        qActionSheetView2.addRadioButton("\u516c\u5f00", !NBPFollowerViewModel.this.getFollowInfoOnlySelf());
                                                        qActionSheetView2.addRadioButton("\u4ec5\u81ea\u5df1\u53ef\u89c1", NBPFollowerViewModel.this.getFollowInfoOnlySelf());
                                                        qActionSheetView2.addCancelButton();
                                                        qActionSheetView2.show();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        }, composer5, 0, 3);
                                        int i19 = NBPFollowerViewModel.this.getFollowInfoOnlySelf() ? 2 : 1;
                                        com.tencent.kuikly.core.nvi.serialization.json.e dTPageParam = NBPFollowerViewModel.this.getDTPageParam(false);
                                        NBPFollowerViewModel nBPFollowerViewModel6 = NBPFollowerViewModel.this;
                                        dTPageParam.v("dt_eid", "em_nearby_privilege_set_float");
                                        dTPageParam.t("nearby_btn_type", i19);
                                        dTPageParam.v("cur_pg", nBPFollowerViewModel6.getDTPageParam(true));
                                        dTPageParam.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_imp", dTPageParam);
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer3, 3128, 4);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    return Unit.INSTANCE;
                }
            }), startRestartGroup, 24968, 10);
            if (ComposerKt.isTraceInProgress()) {
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerPageKt$NBPFollowerFootBar$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                NBPFollowerPageKt.NBPFollowerFootBar(NBPFollowerViewModel.this, composer2, i3 | 1, i16);
                return Unit.INSTANCE;
            }
        });
    }
}
