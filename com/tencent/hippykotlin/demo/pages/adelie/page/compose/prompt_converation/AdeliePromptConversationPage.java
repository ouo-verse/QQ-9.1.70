package com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import bp3.c;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSBottomDynamicGuideEvent;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.compose.page.BaseComposePager;
import com.tencent.hippykotlin.demo.pages.adelie.common.compose.util.ListStateHolder;
import com.tencent.hippykotlin.demo.pages.adelie.common.compose.util.StateHolder;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util.ReportKt;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationItemData;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationListKt;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationParam;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIPolarLightKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.CenterContentConfig;
import com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.LeftContentConfig;
import com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.SecNavBarKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQUIModule;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUITokenThemeMode;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.ntcompose.activity.a;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.foundation.lazy.d;
import com.tencent.ntcompose.material.ButtonKt;
import com.tencent.ntcompose.material.LazyColumnKt;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import defpackage.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class AdeliePromptConversationPage extends BaseComposePager {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final Lazy viewModel$delegate;

    public AdeliePromptConversationPage() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<AdeliePromptConversationViewModel>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.AdeliePromptConversationPage$viewModel$2
            @Override // kotlin.jvm.functions.Function0
            public final AdeliePromptConversationViewModel invoke() {
                return new AdeliePromptConversationViewModel();
            }
        });
        this.viewModel$delegate = lazy;
    }

    public static final int access$getTotalWordCount(AdeliePromptConversationPage adeliePromptConversationPage) {
        Iterator<ConversationItemData> it = adeliePromptConversationPage.getViewModel().conversationList._stateList.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            ConversationItemData next = it.next();
            String value = next.question._state.getValue();
            int length = i3 + (value != null ? value.length() : 0);
            String value2 = next.answer._state.getValue();
            i3 = length + (value2 != null ? value2.length() : 0);
        }
        return i3;
    }

    public final e getDTPageParam() {
        return AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_bas_dialog_style");
    }

    public final AdeliePromptConversationViewModel getViewModel() {
        return (AdeliePromptConversationViewModel) this.viewModel$delegate.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0095  */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.util.List, java.util.List<com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationItemData>, java.util.ArrayList] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onBack() {
        boolean z16;
        Object orNull;
        SnapshotStateList<ConversationItemData> snapshotStateList = getViewModel().conversationList._stateList;
        ArrayList arrayList = new ArrayList();
        Iterator<ConversationItemData> it = snapshotStateList.iterator();
        while (true) {
            z16 = true;
            if (!it.hasNext()) {
                break;
            }
            ConversationItemData next = it.next();
            if (true ^ next.isEmpty.getValue().booleanValue()) {
                arrayList.add(next);
            }
        }
        ?? r06 = getViewModel().conversationParam.conversationList;
        if (r06 != 0 && arrayList.size() == r06.size()) {
            Iterator it5 = arrayList.iterator();
            int i3 = 0;
            while (it5.hasNext()) {
                Object next2 = it5.next();
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                orNull = CollectionsKt___CollectionsKt.getOrNull(r06, i3);
                if (Intrinsics.areEqual((ConversationItemData) next2, (ConversationItemData) orNull)) {
                    i3 = i16;
                }
            }
            if (z16) {
                ((QQUIModule) c.f117352a.g().acquireModule("QQUIModule")).openAlertDialog("", "\u662f\u5426\u653e\u5f03\u6b64\u6b21\u7f16\u8f91", "\u7559\u5728\u672c\u9875", "\u653e\u5f03\u7f16\u8f91", "", false, new Function2<Boolean, Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.AdeliePromptConversationPage$onBack$1
                    @Override // kotlin.jvm.functions.Function2
                    public final Unit invoke(Boolean bool, Boolean bool2) {
                        boolean booleanValue = bool.booleanValue();
                        bool2.booleanValue();
                        if (booleanValue) {
                            QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                            QQKuiklyPlatformApi.Companion.closePage$default();
                        }
                        return Unit.INSTANCE;
                    }
                });
                return;
            } else {
                QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                QQKuiklyPlatformApi.Companion.closePage$default();
                return;
            }
        }
        z16 = false;
        if (z16) {
        }
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [java.util.List<com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationItemData>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r10v5, types: [java.util.List<com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationItemData>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.util.List<com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationItemData>, java.util.ArrayList] */
    @Override // com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.BaseComponentActivity, com.tencent.ntcompose.activity.ComponentActivity
    public final void onCreate(a aVar) {
        List listOf;
        final h hVar;
        super.onCreate(aVar);
        String q16 = getPageData().n().q("conversation", "{}");
        ConversationParam conversationParam = new ConversationParam();
        if (!(q16.length() == 0)) {
            e eVar = new e(q16);
            conversationParam.maxRound = eVar.k("maxRound", 10);
            int k3 = eVar.k("maxWord", 100);
            conversationParam.maxWord = k3;
            int i3 = conversationParam.maxRound;
            conversationParam.maxRound = i3 > 0 ? i3 : 10;
            conversationParam.maxWord = k3 > 0 ? k3 : 100;
            conversationParam.pageUuid = eVar.q("pageUuid", "");
            b l3 = eVar.l("contentList");
            if (l3 != null) {
                int c16 = l3.c();
                for (int i16 = 0; i16 < c16; i16++) {
                    e l16 = l3.l(i16);
                    if (l16 != null) {
                        conversationParam.conversationList.add(new ConversationItemData(l16.q("question", ""), l16.q("answer", "")));
                    }
                }
            }
        }
        getViewModel().conversationParam = conversationParam;
        if (!conversationParam.conversationList.isEmpty()) {
            ListStateHolder<ConversationItemData> listStateHolder = getViewModel().conversationList;
            ?? r06 = conversationParam.conversationList;
            ArrayList arrayList = new ArrayList();
            Iterator it = r06.iterator();
            while (it.hasNext()) {
                ConversationItemData conversationItemData = (ConversationItemData) it.next();
                String value = conversationItemData.question._state.getValue();
                if (value == null) {
                    value = "";
                }
                String value2 = conversationItemData.answer._state.getValue();
                if (value2 == null) {
                    value2 = "";
                }
                arrayList.add(new ConversationItemData(value, value2));
            }
            listStateHolder._stateList.addAll(arrayList);
        } else {
            ListStateHolder<ConversationItemData> listStateHolder2 = getViewModel().conversationList;
            listOf = CollectionsKt__CollectionsJVMKt.listOf(new ConversationItemData("", ""));
            listStateHolder2._stateList.addAll(listOf);
        }
        if (c.f117352a.g().isNightMode()) {
            hVar = new h(4279506975L);
        } else {
            hVar = new h(4291816191L);
        }
        com.tencent.ntcompose.activity.b.c(this, null, ComposableLambdaKt.composableLambdaInstance(821230938, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.AdeliePromptConversationPage$onCreate$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer, Integer num) {
                Composer composer2 = composer;
                int intValue = num.intValue();
                if ((intValue & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(821230938, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.AdeliePromptConversationPage.onCreate.<anonymous> (AdeliePromptConversationPage.kt:88)");
                    }
                    i c17 = ModifiersKt.c(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), h.this);
                    final AdeliePromptConversationPage adeliePromptConversationPage = this;
                    BoxKt.a(c17, null, null, ComposableLambdaKt.composableLambda(composer2, 770605332, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.AdeliePromptConversationPage$onCreate$1.1
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer3, Integer num2) {
                            Composer composer4 = composer3;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer4.getSkipping()) {
                                composer4.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(770605332, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.AdeliePromptConversationPage.onCreate.<anonymous>.<anonymous> (AdeliePromptConversationPage.kt:89)");
                                }
                                AdeliePromptConversationPage.this.PolarView$qecommerce_biz_release(composer4, 8);
                                AdeliePromptConversationPage.this.NavBar$qecommerce_biz_release(composer4, 8);
                                AdeliePromptConversationPage.this.MiddleContent$qecommerce_biz_release(composer4, 8);
                                AdeliePromptConversationPage.this.ConfirmButton$qecommerce_biz_release(composer4, 8);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer2, 3080, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), 1, null);
    }

    @Override // com.tencent.ntcompose.activity.ComponentActivity
    public final void onDestroy() {
        super.onDestroy();
    }

    @Override // com.tencent.ntcompose.activity.ComponentActivity, com.tencent.kuikly.core.pager.b
    public final void onReceivePagerEvent(String str, e eVar) {
        super.onReceivePagerEvent(str, eVar);
        if (Intrinsics.areEqual(str, "onModalModeBackPressed")) {
            onBack();
        }
    }

    @Override // com.tencent.ntcompose.activity.ComponentActivity
    public final void pageDidAppear() {
        super.pageDidAppear();
        ReportKt.reportCustomDTEvent("dt_pgin", getDTPageParam());
    }

    @Override // com.tencent.ntcompose.activity.ComponentActivity
    public final void pageDidDisappear() {
        super.pageDidDisappear();
        ReportKt.reportCustomDTEvent("dt_pgout", getDTPageParam());
    }

    @Override // com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.BaseComponentActivity
    public final QUITokenThemeMode quiTokenThemeMode() {
        return QUITokenThemeMode.ONLY_DAY_AND_NIGHT;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00a3, code lost:
    
        if ((r3 == null || r3.length() == 0) == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00b1, code lost:
    
        if (r1.isComplete.getValue().booleanValue() != false) goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void ConfirmButton$qecommerce_biz_release(Composer composer, final int i3) {
        boolean z16;
        ScopeUpdateScope endRestartGroup;
        Object first;
        Composer startRestartGroup = composer.startRestartGroup(383354396);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(383354396, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.AdeliePromptConversationPage.ConfirmButton (AdeliePromptConversationPage.kt:211)");
        }
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState mutableState = (MutableState) rememberedValue;
        SnapshotStateList<ConversationItemData> snapshotStateList = getViewModel().conversationList._stateList;
        int size = snapshotStateList.size();
        if (size != 0) {
            z16 = false;
            if (size == 1) {
                first = CollectionsKt___CollectionsKt.first((List<? extends Object>) snapshotStateList);
                ConversationItemData conversationItemData = (ConversationItemData) first;
                String value = conversationItemData.question._state.getValue();
                if (value == null || value.length() == 0) {
                    String value2 = conversationItemData.answer._state.getValue();
                }
            } else {
                Iterator<ConversationItemData> it = getViewModel().conversationList._stateList.iterator();
                while (it.hasNext()) {
                    if (it.next().isComplete.getValue().booleanValue()) {
                    }
                }
            }
            mutableState.setValue(Boolean.valueOf(z16));
            BoxKt.a(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -549841886, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.AdeliePromptConversationPage$ConfirmButton$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer2, Integer num) {
                    int i16;
                    boolean booleanValue;
                    h color$default;
                    boolean booleanValue2;
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
                            ComposerKt.traceEventStart(-549841886, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.AdeliePromptConversationPage.ConfirmButton.<anonymous> (AdeliePromptConversationPage.kt:215)");
                        }
                        i j3 = ModifiersKt.j(ComposeLayoutPropUpdaterKt.n(bVar2.a(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 45.0f), Alignment.BottomCenter), 16.0f, 0.0f, 16.0f, 58.0f, 2, null), 4.0f);
                        booleanValue = ((Boolean) mutableState.getValue()).booleanValue();
                        if (booleanValue) {
                            color$default = QUIToken.color$default("button_bg_primary_default");
                        } else {
                            color$default = QUIToken.color$default("button_bg_primary_disable");
                        }
                        i c16 = ModifiersKt.c(j3, color$default);
                        booleanValue2 = ((Boolean) mutableState.getValue()).booleanValue();
                        i M = ModifiersKt.M(c16, booleanValue2);
                        final AdeliePromptConversationPage adeliePromptConversationPage = this;
                        i g16 = ViewEventPropUpdaterKt.g(M, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.AdeliePromptConversationPage$ConfirmButton$1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(Object obj) {
                                e eVar = new e();
                                AdeliePromptConversationPage adeliePromptConversationPage2 = AdeliePromptConversationPage.this;
                                eVar.v("dt_pgid", "pg_bas_dialog_style");
                                eVar.v("dt_eid", "em_bas_finish");
                                int i17 = AdeliePromptConversationPage.$r8$clinit;
                                eVar.t("session_rounds", adeliePromptConversationPage2.getViewModel().conversationList._stateList.size());
                                eVar.t("total_word_count", AdeliePromptConversationPage.access$getTotalWordCount(adeliePromptConversationPage2));
                                eVar.v("cur_pg", adeliePromptConversationPage2.getDTPageParam());
                                ReportKt.reportCustomDTEvent("dt_imp", eVar);
                                return Unit.INSTANCE;
                            }
                        });
                        final AdeliePromptConversationPage adeliePromptConversationPage2 = this;
                        Function1<ClickParams, Unit> function1 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.AdeliePromptConversationPage$ConfirmButton$1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ClickParams clickParams) {
                                k kVar = (k) c.f117352a.g().acquireModule("KRNotifyModule");
                                e eVar = new e();
                                AdeliePromptConversationPage adeliePromptConversationPage3 = AdeliePromptConversationPage.this;
                                int i17 = AdeliePromptConversationPage.$r8$clinit;
                                ConversationParam conversationParam = adeliePromptConversationPage3.getViewModel().conversationParam;
                                b a16 = o.a(eVar, "pageUuid", conversationParam != null ? conversationParam.pageUuid : null);
                                SnapshotStateList<ConversationItemData> snapshotStateList2 = adeliePromptConversationPage3.getViewModel().conversationList._stateList;
                                ArrayList arrayList = new ArrayList();
                                Iterator<ConversationItemData> it5 = snapshotStateList2.iterator();
                                while (it5.hasNext()) {
                                    ConversationItemData next = it5.next();
                                    if (!next.isEmpty.getValue().booleanValue()) {
                                        arrayList.add(next);
                                    }
                                }
                                Iterator it6 = arrayList.iterator();
                                while (it6.hasNext()) {
                                    final ConversationItemData conversationItemData2 = (ConversationItemData) it6.next();
                                    a16.v(new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.AdeliePromptConversationPage$ConfirmButton$1$2$1$1$2$1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(e eVar2) {
                                            e eVar3 = eVar2;
                                            eVar3.v("question", ConversationItemData.this.question._state.getValue());
                                            eVar3.v("answer", ConversationItemData.this.answer._state.getValue());
                                            return Unit.INSTANCE;
                                        }
                                    });
                                }
                                Unit unit = Unit.INSTANCE;
                                eVar.v("contentList", a16);
                                k.d(kVar, "adelie_prompt_conversation_edit", eVar, false, 4, null);
                                e eVar2 = new e();
                                AdeliePromptConversationPage adeliePromptConversationPage4 = AdeliePromptConversationPage.this;
                                eVar2.v("dt_eid", "em_bas_finish");
                                eVar2.t("session_rounds", adeliePromptConversationPage4.getViewModel().conversationList._stateList.size());
                                eVar2.t("total_word_count", AdeliePromptConversationPage.access$getTotalWordCount(adeliePromptConversationPage4));
                                eVar2.v("cur_pg", adeliePromptConversationPage4.getDTPageParam());
                                ReportKt.reportCustomDTEvent("dt_clck", eVar2);
                                QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                QQKuiklyPlatformApi.Companion.closePage$default();
                                return Unit.INSTANCE;
                            }
                        };
                        final MutableState<Boolean> mutableState2 = mutableState;
                        ButtonKt.a(null, function1, g16, null, ComposableLambdaKt.composableLambda(composer3, 1885634829, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.AdeliePromptConversationPage$ConfirmButton$1.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(n nVar, Composer composer4, Integer num2) {
                                boolean booleanValue3;
                                h color$default2;
                                Composer composer5 = composer4;
                                int intValue2 = num2.intValue();
                                if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                    composer5.skipToGroupEnd();
                                } else {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1885634829, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.AdeliePromptConversationPage.ConfirmButton.<anonymous>.<anonymous> (AdeliePromptConversationPage.kt:248)");
                                    }
                                    booleanValue3 = ((Boolean) mutableState2.getValue()).booleanValue();
                                    if (booleanValue3) {
                                        color$default2 = QUIToken.color$default("button_text_primary_default");
                                    } else {
                                        color$default2 = QUIToken.color$default("button_text_primary_disable");
                                    }
                                    TextKt.a("\u5b8c\u6210", null, null, color$default2, Float.valueOf(17.0f), null, bp3.c.INSTANCE.f(), null, null, null, null, Float.valueOf(24.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer5, 1601542, 48, 0, 134215590);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer3, 25088, 9);
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
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
                return;
            }
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.AdeliePromptConversationPage$ConfirmButton$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    AdeliePromptConversationPage.this.ConfirmButton$qecommerce_biz_release(composer2, i3 | 1);
                    return Unit.INSTANCE;
                }
            });
            return;
        }
        z16 = true;
        mutableState.setValue(Boolean.valueOf(z16));
        BoxKt.a(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -549841886, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.AdeliePromptConversationPage$ConfirmButton$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer2, Integer num) {
                int i16;
                boolean booleanValue;
                h color$default;
                boolean booleanValue2;
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
                        ComposerKt.traceEventStart(-549841886, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.AdeliePromptConversationPage.ConfirmButton.<anonymous> (AdeliePromptConversationPage.kt:215)");
                    }
                    i j3 = ModifiersKt.j(ComposeLayoutPropUpdaterKt.n(bVar2.a(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 45.0f), Alignment.BottomCenter), 16.0f, 0.0f, 16.0f, 58.0f, 2, null), 4.0f);
                    booleanValue = ((Boolean) mutableState.getValue()).booleanValue();
                    if (booleanValue) {
                        color$default = QUIToken.color$default("button_bg_primary_default");
                    } else {
                        color$default = QUIToken.color$default("button_bg_primary_disable");
                    }
                    i c16 = ModifiersKt.c(j3, color$default);
                    booleanValue2 = ((Boolean) mutableState.getValue()).booleanValue();
                    i M = ModifiersKt.M(c16, booleanValue2);
                    final AdeliePromptConversationPage adeliePromptConversationPage = this;
                    i g16 = ViewEventPropUpdaterKt.g(M, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.AdeliePromptConversationPage$ConfirmButton$1.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(Object obj) {
                            e eVar = new e();
                            AdeliePromptConversationPage adeliePromptConversationPage2 = AdeliePromptConversationPage.this;
                            eVar.v("dt_pgid", "pg_bas_dialog_style");
                            eVar.v("dt_eid", "em_bas_finish");
                            int i17 = AdeliePromptConversationPage.$r8$clinit;
                            eVar.t("session_rounds", adeliePromptConversationPage2.getViewModel().conversationList._stateList.size());
                            eVar.t("total_word_count", AdeliePromptConversationPage.access$getTotalWordCount(adeliePromptConversationPage2));
                            eVar.v("cur_pg", adeliePromptConversationPage2.getDTPageParam());
                            ReportKt.reportCustomDTEvent("dt_imp", eVar);
                            return Unit.INSTANCE;
                        }
                    });
                    final AdeliePromptConversationPage adeliePromptConversationPage2 = this;
                    Function1<ClickParams, Unit> function1 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.AdeliePromptConversationPage$ConfirmButton$1.2
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ClickParams clickParams) {
                            k kVar = (k) c.f117352a.g().acquireModule("KRNotifyModule");
                            e eVar = new e();
                            AdeliePromptConversationPage adeliePromptConversationPage3 = AdeliePromptConversationPage.this;
                            int i17 = AdeliePromptConversationPage.$r8$clinit;
                            ConversationParam conversationParam = adeliePromptConversationPage3.getViewModel().conversationParam;
                            b a16 = o.a(eVar, "pageUuid", conversationParam != null ? conversationParam.pageUuid : null);
                            SnapshotStateList<ConversationItemData> snapshotStateList2 = adeliePromptConversationPage3.getViewModel().conversationList._stateList;
                            ArrayList arrayList = new ArrayList();
                            Iterator<ConversationItemData> it5 = snapshotStateList2.iterator();
                            while (it5.hasNext()) {
                                ConversationItemData next = it5.next();
                                if (!next.isEmpty.getValue().booleanValue()) {
                                    arrayList.add(next);
                                }
                            }
                            Iterator it6 = arrayList.iterator();
                            while (it6.hasNext()) {
                                final ConversationItemData conversationItemData2 = (ConversationItemData) it6.next();
                                a16.v(new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.AdeliePromptConversationPage$ConfirmButton$1$2$1$1$2$1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(e eVar2) {
                                        e eVar3 = eVar2;
                                        eVar3.v("question", ConversationItemData.this.question._state.getValue());
                                        eVar3.v("answer", ConversationItemData.this.answer._state.getValue());
                                        return Unit.INSTANCE;
                                    }
                                });
                            }
                            Unit unit = Unit.INSTANCE;
                            eVar.v("contentList", a16);
                            k.d(kVar, "adelie_prompt_conversation_edit", eVar, false, 4, null);
                            e eVar2 = new e();
                            AdeliePromptConversationPage adeliePromptConversationPage4 = AdeliePromptConversationPage.this;
                            eVar2.v("dt_eid", "em_bas_finish");
                            eVar2.t("session_rounds", adeliePromptConversationPage4.getViewModel().conversationList._stateList.size());
                            eVar2.t("total_word_count", AdeliePromptConversationPage.access$getTotalWordCount(adeliePromptConversationPage4));
                            eVar2.v("cur_pg", adeliePromptConversationPage4.getDTPageParam());
                            ReportKt.reportCustomDTEvent("dt_clck", eVar2);
                            QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                            QQKuiklyPlatformApi.Companion.closePage$default();
                            return Unit.INSTANCE;
                        }
                    };
                    final MutableState<Boolean> mutableState2 = mutableState;
                    ButtonKt.a(null, function1, g16, null, ComposableLambdaKt.composableLambda(composer3, 1885634829, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.AdeliePromptConversationPage$ConfirmButton$1.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(n nVar, Composer composer4, Integer num2) {
                            boolean booleanValue3;
                            h color$default2;
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1885634829, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.AdeliePromptConversationPage.ConfirmButton.<anonymous>.<anonymous> (AdeliePromptConversationPage.kt:248)");
                                }
                                booleanValue3 = ((Boolean) mutableState2.getValue()).booleanValue();
                                if (booleanValue3) {
                                    color$default2 = QUIToken.color$default("button_text_primary_default");
                                } else {
                                    color$default2 = QUIToken.color$default("button_text_primary_disable");
                                }
                                TextKt.a("\u5b8c\u6210", null, null, color$default2, Float.valueOf(17.0f), null, bp3.c.INSTANCE.f(), null, null, null, null, Float.valueOf(24.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer5, 1601542, 48, 0, 134215590);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 25088, 9);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 3080, 6);
        if (ComposerKt.isTraceInProgress()) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    public final void NavBar$qecommerce_biz_release(Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(1604881686);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1604881686, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.AdeliePromptConversationPage.NavBar (AdeliePromptConversationPage.kt:119)");
        }
        BoxKt.a(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 0.0f, getPageData().getStatusBarHeight(), 0.0f, 0.0f, 13, null), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 15538640, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.AdeliePromptConversationPage$NavBar$1
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
                        ComposerKt.traceEventStart(15538640, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.AdeliePromptConversationPage.NavBar.<anonymous> (AdeliePromptConversationPage.kt:120)");
                    }
                    h j3 = h.INSTANCE.j();
                    final AdeliePromptConversationPage adeliePromptConversationPage = AdeliePromptConversationPage.this;
                    SecNavBarKt.SecNavBar(j3, new LeftContentConfig(null, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.AdeliePromptConversationPage$NavBar$1.1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Unit invoke() {
                            AdeliePromptConversationPage adeliePromptConversationPage2 = AdeliePromptConversationPage.this;
                            int i16 = AdeliePromptConversationPage.$r8$clinit;
                            adeliePromptConversationPage2.onBack();
                            return Unit.INSTANCE;
                        }
                    }, 190), new CenterContentConfig("\u521b\u5efa\u5bf9\u8bdd\u98ce\u683c"), null, composer3, 8, 8);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.AdeliePromptConversationPage$NavBar$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                AdeliePromptConversationPage.this.NavBar$qecommerce_biz_release(composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public final void PolarView$qecommerce_biz_release(Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(259276941);
        if ((i3 & 1) == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(259276941, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.AdeliePromptConversationPage.PolarView (AdeliePromptConversationPage.kt:114)");
            }
            QUIPolarLightKt.QUIPolarLight(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 190.0f), null, "conversation", startRestartGroup, QFSBottomDynamicGuideEvent.DYNAMIC_GUIDE_BUTTON_TYPE, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.AdeliePromptConversationPage$PolarView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                AdeliePromptConversationPage.this.PolarView$qecommerce_biz_release(composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public final void MiddleContent$qecommerce_biz_release(Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-552206802);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-552206802, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.AdeliePromptConversationPage.MiddleContent (AdeliePromptConversationPage.kt:152)");
        }
        final d a16 = com.tencent.ntcompose.foundation.lazy.e.a(0, 0.0f, startRestartGroup, 0, 3);
        LazyColumnKt.a(ViewEventPropUpdaterKt.d(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), 0.0f, getPageData().getStatusBarHeight() + (defpackage.k.a(c.f117352a) ? 50.0f : 44.0f), 0.0f, 119.0f, 5, null), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.AdeliePromptConversationPage$MiddleContent$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ClickParams clickParams) {
                StateHolder<Boolean> stateHolder = AdeliePromptConversationPage.this.getViewModel().hideKeyboard;
                stateHolder._state.setValue(Boolean.TRUE);
                return Unit.INSTANCE;
            }
        }, 3, null), null, a16, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 343894185, true, new Function3<com.tencent.ntcompose.foundation.lazy.layout.a, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.AdeliePromptConversationPage$MiddleContent$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(com.tencent.ntcompose.foundation.lazy.layout.a aVar, Composer composer2, Integer num) {
                final com.tencent.ntcompose.foundation.lazy.layout.a aVar2 = aVar;
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(343894185, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.AdeliePromptConversationPage.MiddleContent.<anonymous> (AdeliePromptConversationPage.kt:160)");
                }
                i.Companion companion = i.INSTANCE;
                SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion, 16.0f), composer3, 8, 0);
                i n3 = ComposeLayoutPropUpdaterKt.n(ModifiersKt.j(ModifiersKt.c(ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null), QUIToken.color$default("fill_allwhite_medium")), 8.0f), 16.0f, 0.0f, 16.0f, 0.0f, 10, null);
                final AdeliePromptConversationPage adeliePromptConversationPage = AdeliePromptConversationPage.this;
                final d dVar = a16;
                ColumnKt.a(n3, null, null, null, ComposableLambdaKt.composableLambda(composer3, -449676526, true, new Function3<com.tencent.ntcompose.foundation.layout.d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.AdeliePromptConversationPage$MiddleContent$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public final Unit invoke(com.tencent.ntcompose.foundation.layout.d dVar2, Composer composer4, Integer num2) {
                        Composer composer5 = composer4;
                        int intValue2 = num2.intValue();
                        if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                            composer5.skipToGroupEnd();
                        } else {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-449676526, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.AdeliePromptConversationPage.MiddleContent.<anonymous>.<anonymous> (AdeliePromptConversationPage.kt:162)");
                            }
                            i.Companion companion2 = i.INSTANCE;
                            SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion2, 16.0f), composer5, 8, 0);
                            h color$default = QUIToken.color$default("text_primary");
                            c.Companion companion3 = bp3.c.INSTANCE;
                            TextKt.a("\u793a\u4f8b\u5bf9\u8bdd", ComposeLayoutPropUpdaterKt.n(companion2, 16.0f, 0.0f, 16.0f, 0.0f, 10, null), null, color$default, Float.valueOf(16.0f), null, companion3.f(), null, null, null, null, Float.valueOf(22.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer5, 1601606, 48, 0, 134215588);
                            SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion2, 6.0f), composer5, 8, 0);
                            TextKt.a("\u667a\u80fd\u4f53\u5c06\u4f1a\u5b66\u4e60\u4f60\u521b\u5efa\u7684\u793a\u4f8b\u5bf9\u8bdd\uff0c\u5c3d\u53ef\u80fd\u6a21\u4eff\u5176\u8bed\u6c14\u3001\u8bed\u8a00\u4e60\u60ef\u8fdb\u884c\u4ea4\u6d41\u3002", ComposeLayoutPropUpdaterKt.n(companion2, 16.0f, 0.0f, 16.0f, 0.0f, 10, null), null, QUIToken.color$default("text_secondary"), Float.valueOf(14.0f), null, companion3.e(), null, null, null, null, Float.valueOf(20.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer5, 1601606, 48, 0, 134215588);
                            SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion2, 6.0f), composer5, 8, 0);
                            com.tencent.ntcompose.foundation.lazy.layout.a aVar3 = com.tencent.ntcompose.foundation.lazy.layout.a.this;
                            AdeliePromptConversationPage adeliePromptConversationPage2 = adeliePromptConversationPage;
                            int i16 = AdeliePromptConversationPage.$r8$clinit;
                            ConversationListKt.ConversationList(aVar3, adeliePromptConversationPage2.getViewModel(), dVar, composer5, 72, 0);
                            SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion2, 6.0f), composer5, 8, 0);
                            TextKt.a("\u6700\u591a\u53ef\u8bbe\u6dfb\u52a0" + adeliePromptConversationPage.getViewModel().conversationParam.maxRound + "\u8f6e\u5bf9\u8bdd\uff0c\u6bcf\u4e2a\u5bf9\u8bdd\u6846\u5b57\u6570\u5728" + adeliePromptConversationPage.getViewModel().conversationParam.maxWord + "\u5b57\u4ee5\u5185\u3002", ComposeLayoutPropUpdaterKt.n(companion2, 16.0f, 0.0f, 16.0f, 0.0f, 10, null), null, QUIToken.color$default("text_secondary"), Float.valueOf(14.0f), null, companion3.e(), null, null, null, null, Float.valueOf(20.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer5, 1601600, 48, 0, 134215588);
                            SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion2, 16.0f), composer5, 8, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }), composer3, 24584, 14);
                Float value = AdeliePromptConversationPage.this.getViewModel().spaceHolderHeight._state.getValue();
                SpacerKt.a(ViewEventPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.k(companion, value != null ? value.floatValue() : 0.0f), new Function1<ap3.a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.AdeliePromptConversationPage$MiddleContent$2.2
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ap3.a aVar3) {
                        KLog kLog = KLog.INSTANCE;
                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("Spacer onGloballyPositioned = ");
                        m3.append(aVar3.getSize());
                        kLog.i("ConversationList", m3.toString());
                        return Unit.INSTANCE;
                    }
                }), composer3, 8, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 8, 0, MsgConstant.KRMFILETHUMBSIZE384, 4194298);
        EffectsKt.LaunchedEffect(Float.valueOf(a16.d()), new AdeliePromptConversationPage$MiddleContent$3(this, a16, null), startRestartGroup, 64);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.AdeliePromptConversationPage$MiddleContent$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                AdeliePromptConversationPage.this.MiddleContent$qecommerce_biz_release(composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
