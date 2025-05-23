package com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util.ReportKt;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieKuiklyBaseModule;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.util.AdelieCategoryAIOJumpUtil;
import com.tencent.hippykotlin.demo.pages.base.extension.PageDataExtKt;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.coroutines.BuildersKt;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.mobileqq.emoticonview.report.EmotionDaTongReportUtil;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.material.SurfaceKt;
import g25.g;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GuideBannerCardKt {
    public static final void access$report(String str, e eVar, g gVar) {
        e eVar2 = new e();
        eVar2.v("banner_name", gVar.f401160h);
        eVar2.v("pic_url", gVar.f401159f);
        eVar2.v("jump_address", gVar.f401161i);
        eVar2.v("banner_id", "");
        Unit unit = Unit.INSTANCE;
        e eVar3 = new e(eVar.toString());
        eVar3.v("dt_eid", EmotionDaTongReportUtil.EM_BAS_BANNER);
        eVar3.v("cur_pg", eVar);
        Iterator<String> c16 = eVar2.c();
        if (c16 != null) {
            while (c16.hasNext()) {
                String next = c16.next();
                eVar3.v(next, eVar2.e(next));
            }
        }
        eVar3.v(MiniAppDesktopDtReportHelper.DT_MINI_PARENT_EID, null);
        ReportKt.reportCustomDTEvent(str, eVar3);
    }

    public static final void GuideBannerCard(final g gVar, final float f16, final float f17, final Function0<Unit> function0, final e eVar, Composer composer, final int i3) {
        final Lazy lazy;
        final Lazy lazy2;
        Composer startRestartGroup = composer.startRestartGroup(683183059);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(683183059, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.GuideBannerCard (GuideBannerCard.kt:37)");
        }
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ADELIE_GUIDE_HAS_SHOWN_ANIMATION_");
        c cVar = c.f117352a;
        m3.append(PageDataExtKt.getUin(cVar.g().getPageData()));
        final String sb5 = m3.toString();
        StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ADELIE_GUIDE_HAS_SHOWN_VIDEO_");
        m16.append(PageDataExtKt.getUin(cVar.g().getPageData()));
        final String sb6 = m16.toString();
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState mutableState = (MutableState) rememberedValue;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<AdelieKuiklyBaseModule>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.GuideBannerCardKt$GuideBannerCard$adelieKuiklyModule$2
            @Override // kotlin.jvm.functions.Function0
            public final AdelieKuiklyBaseModule invoke() {
                return (AdelieKuiklyBaseModule) c.f117352a.g().acquireModule("AdelieKuiklyBaseModule");
            }
        });
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<AdelieKuiklyHomePageModule>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.GuideBannerCardKt$GuideBannerCard$adelieKuiklyHomePageModule$2
            @Override // kotlin.jvm.functions.Function0
            public final AdelieKuiklyHomePageModule invoke() {
                return (AdelieKuiklyHomePageModule) c.f117352a.g().acquireModule("AdelieKuiklyHomePageModule");
            }
        });
        final boolean booleanFromCache = ((AdelieKuiklyBaseModule) lazy.getValue()).getBooleanFromCache(sb6);
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        final String b16 = k.b((k) cVar.g().acquireModule("KRNotifyModule"), "adelie_interrupt_guide_animation", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.GuideBannerCardKt$GuideBannerCard$interruptCallback$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar2) {
                e eVar3 = eVar2;
                Ref.BooleanRef.this.element = true;
                Boolean valueOf = eVar3 != null ? Boolean.valueOf(eVar3.f("show_next_time")) : null;
                if (Intrinsics.areEqual(valueOf, Boolean.FALSE)) {
                    AdelieKuiklyBaseModule value = lazy.getValue();
                    String str = sb5;
                    value.getClass();
                    value.setStringToCache$enumunboxing$(str, String.valueOf(true), 1, 2);
                }
                KLog kLog = KLog.INSTANCE;
                StringBuilder sb7 = new StringBuilder();
                sb7.append("interruptCallback showNextTime ");
                sb7.append(valueOf);
                sb7.append(", interruptAnimation: ");
                AdelieCategoryHomePage$$ExternalSyntheticOutline2.m(sb7, Ref.BooleanRef.this.element, kLog, "");
                return Unit.INSTANCE;
            }
        }, 2, null);
        SurfaceKt.a(ViewEventPropUpdaterKt.d(i.INSTANCE, false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.GuideBannerCardKt$GuideBannerCard$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ClickParams clickParams) {
                g gVar2 = g.this;
                g25.k kVar = gVar2.f401162m;
                if (kVar != null) {
                    boolean z16 = booleanFromCache;
                    String str = sb6;
                    e eVar2 = eVar;
                    Lazy<AdelieKuiklyBaseModule> lazy3 = lazy;
                    if (z16) {
                        AdelieCategoryAIOJumpUtil.INSTANCE.jumpToAIO$qecommerce_biz_release(kVar, null, null, false);
                    } else {
                        AdelieCategoryAIOJumpUtil.INSTANCE.jumpToAIO$qecommerce_biz_release(kVar, gVar2.f401161i, gVar2.f401158e, false);
                        AdelieKuiklyBaseModule value = lazy3.getValue();
                        value.getClass();
                        value.setStringToCache$enumunboxing$(str, String.valueOf(true), 1, 2);
                    }
                    GuideBannerCardKt.access$report("dt_clck", eVar2, gVar2);
                }
                return Unit.INSTANCE;
            }
        }, 3, null), null, h.INSTANCE.j(), null, ComposableLambdaKt.composableLambda(startRestartGroup, 115752529, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.GuideBannerCardKt$GuideBannerCard$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 11) == 2 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(115752529, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.GuideBannerCard.<anonymous> (GuideBannerCard.kt:79)");
                    }
                    i k3 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, f16), f17);
                    final g gVar2 = gVar;
                    final float f18 = f16;
                    final float f19 = f17;
                    final int i16 = i3;
                    final MutableState<Boolean> mutableState2 = mutableState;
                    final Lazy<AdelieKuiklyHomePageModule> lazy3 = lazy2;
                    final Function0<Unit> function02 = function0;
                    final String str = sb5;
                    final String str2 = sb6;
                    final Lazy<AdelieKuiklyBaseModule> lazy4 = lazy;
                    final e eVar2 = eVar;
                    final Ref.BooleanRef booleanRef2 = booleanRef;
                    final String str3 = b16;
                    BoxKt.a(k3, null, null, ComposableLambdaKt.composableLambda(composer3, 357964811, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.GuideBannerCardKt$GuideBannerCard$2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(b bVar, Composer composer4, Integer num2) {
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(357964811, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.GuideBannerCard.<anonymous>.<anonymous> (GuideBannerCard.kt:80)");
                                }
                                if (mutableState2.getValue().booleanValue()) {
                                    composer5.startReplaceableGroup(877716484);
                                    g gVar3 = g.this;
                                    float f26 = f18;
                                    float f27 = f19;
                                    final Lazy<AdelieKuiklyHomePageModule> lazy5 = lazy3;
                                    Function0<Unit> function03 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.GuideBannerCardKt.GuideBannerCard.2.1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public final Unit invoke() {
                                            lazy5.getValue().toNative(false, "startPlayAIOGuideAnimation", null, null, false);
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    final g gVar4 = g.this;
                                    final Function0<Unit> function04 = function02;
                                    final String str4 = str;
                                    final String str5 = str2;
                                    final Lazy<AdelieKuiklyHomePageModule> lazy6 = lazy3;
                                    final Lazy<AdelieKuiklyBaseModule> lazy7 = lazy4;
                                    final MutableState<Boolean> mutableState3 = mutableState2;
                                    Function0<Unit> function05 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.GuideBannerCardKt.GuideBannerCard.2.1.2

                                        /* compiled from: P */
                                        @DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.GuideBannerCardKt$GuideBannerCard$2$1$2$2", f = "GuideBannerCard.kt", i = {}, l = {101}, m = "invokeSuspend", n = {}, s = {})
                                        /* renamed from: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.GuideBannerCardKt$GuideBannerCard$2$1$2$2, reason: invalid class name and collision with other inner class name */
                                        /* loaded from: classes31.dex */
                                        public final class C13612 extends SuspendLambda implements Function2<com.tencent.kuikly.core.coroutines.b, Continuation<? super Unit>, Object> {
                                            public final /* synthetic */ MutableState<Boolean> $showModal$delegate;
                                            public /* synthetic */ Object L$0;
                                            public int label;

                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            public C13612(MutableState<Boolean> mutableState, Continuation<? super C13612> continuation) {
                                                super(2, continuation);
                                                this.$showModal$delegate = mutableState;
                                            }

                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                C13612 c13612 = new C13612(this.$showModal$delegate, continuation);
                                                c13612.L$0 = obj;
                                                return c13612;
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public final Object invoke(com.tencent.kuikly.core.coroutines.b bVar, Continuation<? super Unit> continuation) {
                                                return ((C13612) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
                                            }

                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                            public final Object invokeSuspend(Object obj) {
                                                Object coroutine_suspended;
                                                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                int i3 = this.label;
                                                if (i3 == 0) {
                                                    ResultKt.throwOnFailure(obj);
                                                    com.tencent.kuikly.core.coroutines.b bVar = (com.tencent.kuikly.core.coroutines.b) this.L$0;
                                                    this.label = 1;
                                                    if (BuildersKt.c(bVar, 300, this) == coroutine_suspended) {
                                                        return coroutine_suspended;
                                                    }
                                                } else if (i3 == 1) {
                                                    ResultKt.throwOnFailure(obj);
                                                } else {
                                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                }
                                                this.$showModal$delegate.setValue(Boolean.FALSE);
                                                return Unit.INSTANCE;
                                            }
                                        }

                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public final Unit invoke() {
                                            c cVar2 = c.f117352a;
                                            if (defpackage.k.a(cVar2)) {
                                                g gVar5 = g.this;
                                                g25.k kVar = gVar5.f401162m;
                                                if (kVar != null) {
                                                    AdelieCategoryAIOJumpUtil.INSTANCE.jumpToAIO$qecommerce_biz_release(kVar, gVar5.f401161i, gVar5.f401158e, false);
                                                }
                                            } else if (AdelieKuiklyHomePageModule$$ExternalSyntheticOutline1.m(cVar2)) {
                                                lazy6.getValue().toNative(false, "finishPlayAIOGuideAnimation", null, null, false);
                                            }
                                            function04.invoke();
                                            ReportKt.reportCustomDTEvent("ev_bas_agent_novice_boot", new e());
                                            AdelieKuiklyBaseModule value = lazy7.getValue();
                                            String str6 = str4;
                                            value.getClass();
                                            value.setStringToCache$enumunboxing$(str6, String.valueOf(true), 1, 2);
                                            AdelieKuiklyBaseModule value2 = lazy7.getValue();
                                            String str7 = str5;
                                            value2.getClass();
                                            value2.setStringToCache$enumunboxing$(str7, String.valueOf(true), 1, 2);
                                            BuildersKt.e(com.tencent.kuikly.core.coroutines.e.f117232d, null, null, new C13612(mutableState3, null), 3, null);
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    int i17 = i16;
                                    GuideBannerCardAnimationViewKt.GuideBannerCardAnimationView(gVar3, f26, f27, function03, function05, composer5, (i17 & 112) | 8 | (i17 & 896));
                                    composer5.endReplaceableGroup();
                                } else {
                                    composer5.startReplaceableGroup(877717827);
                                    final g gVar5 = g.this;
                                    float f28 = f18;
                                    float f29 = f19;
                                    final String str6 = str;
                                    final String str7 = str2;
                                    final e eVar3 = eVar2;
                                    final Lazy<AdelieKuiklyBaseModule> lazy8 = lazy4;
                                    Function0<Unit> function06 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.GuideBannerCardKt.GuideBannerCard.2.1.3
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public final Unit invoke() {
                                            AdelieKuiklyBaseModule value = lazy8.getValue();
                                            String str8 = str6;
                                            value.getClass();
                                            value.setStringToCache$enumunboxing$(str8, String.valueOf(true), 1, 2);
                                            AdelieKuiklyBaseModule value2 = lazy8.getValue();
                                            String str9 = str7;
                                            value2.getClass();
                                            value2.setStringToCache$enumunboxing$(str9, String.valueOf(true), 1, 2);
                                            GuideBannerCardKt.access$report("dt_imp", eVar3, gVar5);
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    final g gVar6 = g.this;
                                    final MutableState<Boolean> mutableState4 = mutableState2;
                                    final String str8 = str;
                                    final Ref.BooleanRef booleanRef3 = booleanRef2;
                                    final String str9 = str3;
                                    final Lazy<AdelieKuiklyBaseModule> lazy9 = lazy4;
                                    Function0<Unit> function07 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.GuideBannerCardKt.GuideBannerCard.2.1.4
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public final Unit invoke() {
                                            AdelieKuiklyHomePageModule adelieKuiklyHomePageModule = (AdelieKuiklyHomePageModule) c.f117352a.g().acquireModule("AdelieKuiklyHomePageModule");
                                            g gVar7 = g.this;
                                            final MutableState<Boolean> mutableState5 = mutableState4;
                                            final String str10 = str8;
                                            final Ref.BooleanRef booleanRef4 = booleanRef3;
                                            final String str11 = str9;
                                            final Lazy<AdelieKuiklyBaseModule> lazy10 = lazy9;
                                            adelieKuiklyHomePageModule.preloadAIOGuideInfo$qecommerce_biz_release(gVar7, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.GuideBannerCardKt.GuideBannerCard.2.1.4.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(e eVar4) {
                                                    e eVar5 = eVar4;
                                                    if (eVar5 != null) {
                                                        try {
                                                            boolean g16 = eVar5.g("success", false);
                                                            KLog.INSTANCE.i("", "preloadAIOGuideInfo success: " + g16);
                                                            if (g16 && !mutableState5.getValue().booleanValue()) {
                                                                final String str12 = str10;
                                                                final Ref.BooleanRef booleanRef5 = booleanRef4;
                                                                final String str13 = str11;
                                                                final Lazy<AdelieKuiklyBaseModule> lazy11 = lazy10;
                                                                final MutableState<Boolean> mutableState6 = mutableState5;
                                                                TimerKt.c(1000, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.GuideBannerCardKt.GuideBannerCard.2.1.4.1.1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(0);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function0
                                                                    public final Unit invoke() {
                                                                        boolean booleanFromCache2 = lazy11.getValue().getBooleanFromCache(str12);
                                                                        KLog kLog = KLog.INSTANCE;
                                                                        StringBuilder sb7 = new StringBuilder();
                                                                        sb7.append("hasShownAnimation ");
                                                                        sb7.append(booleanFromCache2);
                                                                        sb7.append(", interruptAnimation: ");
                                                                        AdelieCategoryHomePage$$ExternalSyntheticOutline2.m(sb7, booleanRef5.element, kLog, "");
                                                                        if (!booleanFromCache2 && !booleanRef5.element) {
                                                                            mutableState6.setValue(Boolean.TRUE);
                                                                        }
                                                                        ((k) c.f117352a.g().acquireModule("KRNotifyModule")).e("adelie_interrupt_guide_animation", str13);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                            }
                                                        } catch (Throwable unused) {
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    int i18 = i16;
                                    GuideCardKt.GuideCard(gVar5, f28, f29, function06, function07, composer5, (i18 & 112) | 8 | (i18 & 896));
                                    composer5.endReplaceableGroup();
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 3080, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 25096, 10);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.GuideBannerCardKt$GuideBannerCard$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                GuideBannerCardKt.GuideBannerCard(g.this, f16, f17, function0, eVar, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
