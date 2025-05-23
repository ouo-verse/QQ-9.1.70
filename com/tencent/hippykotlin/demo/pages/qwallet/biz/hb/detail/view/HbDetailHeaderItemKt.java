package com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.QUISkinImage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.QQComposeViewExtCreator$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.compose_ui.view.adelie.QQAvatarViewKt;
import com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.Mqq;
import com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.MqqUi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.qwallet.base.log.QWLog;
import com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.HbDetailViewModel;
import com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.data.HbDetailRsp;
import com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.data.HbDetailStartupData;
import com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.data.HbReceiver;
import com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.data.HbSender;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.e;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.manager.c;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.ai;
import com.tencent.ntcompose.material.am;
import com.tencent.ntcompose.material.an;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.ntcompose.material.base.b;
import com.tencent.ntcompose.material.n;
import com.tencent.ntcompose.ui.platform.CompositionLocalsKt;
import com.tencent.ntcompose.ui.platform.a;
import defpackage.k;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class HbDetailHeaderItemKt {
    public static final void HbDetailHeaderItem(final HbDetailViewModel hbDetailViewModel, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-702857312);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-702857312, i3, -1, "com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailHeaderItem (HbDetailHeaderItem.kt:45)");
        }
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            if (k.a(c.f117352a)) {
                rememberedValue = new n("DIN-NextLT-Pro-Medium");
            } else {
                rememberedValue = new n("DINNextLTPro-Bold");
            }
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        final n nVar = (n) rememberedValue;
        final float e16 = ((a) startRestartGroup.consume(CompositionLocalsKt.d())).e();
        ColumnKt.a(ComposeLayoutPropUpdaterKt.z(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null)), null, Alignment.INSTANCE.b(), null, ComposableLambdaKt.composableLambda(startRestartGroup, -2124675127, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailHeaderItemKt$HbDetailHeaderItem$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(d dVar, Composer composer2, Integer num) {
                String str;
                String str2;
                HbSender hbSender;
                HbSender hbSender2;
                HbSender hbSender3;
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2124675127, intValue, -1, "com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailHeaderItem.<anonymous> (HbDetailHeaderItem.kt:63)");
                    }
                    i.Companion companion = i.INSTANCE;
                    i d16 = ModifiersKt.d(ModifiersKt.g(ModifiersKt.j(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(companion, 60.0f), 0.0f, 30.0f, 0.0f, 0.0f, 13, null), 30.0f), new e(0.5f, BorderStyle.SOLID, QUIToken.color$default("border_superlight"))), QUIToken.color$default("overlay_standard_primary"));
                    final HbDetailViewModel hbDetailViewModel2 = HbDetailViewModel.this;
                    i d17 = ViewEventPropUpdaterKt.d(d16, false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailHeaderItemKt$HbDetailHeaderItem$1.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ClickParams clickParams) {
                            String m3;
                            HbDetailRsp value = HbDetailViewModel.this.hbDetailRsp.getValue();
                            if (value != null) {
                                HbSender hbSender4 = value.sender;
                                String str3 = hbSender4 != null ? hbSender4.sendUin : null;
                                int i16 = hbSender4 != null ? hbSender4.channel : 0;
                                boolean z16 = i16 == 5 || i16 == 16;
                                HbDetailStartupData value2 = HbDetailViewModel.this.startupData.getValue();
                                String str4 = value2 != null ? value2.groupId : null;
                                if (str3 != null) {
                                    if (z16) {
                                        m3 = QQComposeViewExtCreator$$ExternalSyntheticOutline0.m("mqqapi://nearby_entry/nearby_profile?src_type=web&version=1&from=10003&from_type=0&uin=", str3, "&mode=3");
                                    } else {
                                        if (!(str4 == null || str4.length() == 0)) {
                                            m3 = QUISkinImage$$ExternalSyntheticOutline0.m("mqqapi://card/show_pslcard?src_type=internal&version=1&card_type=troopmemberfromhb&uin=", str3, "&troopuin=", str4);
                                        } else {
                                            m3 = QQComposeViewExtCreator$$ExternalSyntheticOutline0.m("mqqapi://card/show_pslcard?src_type=internal&uin=", str3, "&version=1");
                                        }
                                    }
                                    MqqUi.openUrl$default(Mqq.INSTANCE.getUi(), m3);
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }, 3, null);
                    HbDetailRsp value = HbDetailViewModel.this.hbDetailRsp.getValue();
                    if (value == null || (hbSender3 = value.sender) == null || (str = hbSender3.sendUin) == null) {
                        str = "";
                    }
                    QQAvatarViewKt.QQAvatarView(d17, null, str, composer3, 8, 2);
                    i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.z(ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null)), 0.0f, 15.0f, 0.0f, 0.0f, 13, null);
                    Alignment.Companion companion2 = Alignment.INSTANCE;
                    Alignment.Vertical c16 = companion2.c();
                    com.tencent.ntcompose.foundation.layout.base.a aVar = com.tencent.ntcompose.foundation.layout.base.a.f339245a;
                    a.e b16 = aVar.b();
                    final HbDetailViewModel hbDetailViewModel3 = HbDetailViewModel.this;
                    final float f16 = e16;
                    RowKt.a(n3, b16, c16, null, null, ComposableLambdaKt.composableLambda(composer3, 48430055, true, new Function3<com.tencent.ntcompose.foundation.layout.n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailHeaderItemKt$HbDetailHeaderItem$1.2

                        /* compiled from: P */
                        @DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailHeaderItemKt$HbDetailHeaderItem$1$2$3", f = "HbDetailHeaderItem.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                        /* renamed from: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailHeaderItemKt$HbDetailHeaderItem$1$2$3, reason: invalid class name */
                        /* loaded from: classes33.dex */
                        public final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            public final /* synthetic */ MutableState<String> $contentRef;
                            public final /* synthetic */ MutableState<b> $modifierRef;
                            public final /* synthetic */ com.tencent.ntcompose.foundation.layout.n $this_Row;
                            public final /* synthetic */ HbDetailViewModel $vm;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            public AnonymousClass3(MutableState<String> mutableState, HbDetailViewModel hbDetailViewModel, MutableState<b> mutableState2, com.tencent.ntcompose.foundation.layout.n nVar, Continuation<? super AnonymousClass3> continuation) {
                                super(2, continuation);
                                this.$contentRef = mutableState;
                                this.$vm = hbDetailViewModel;
                                this.$modifierRef = mutableState2;
                                this.$this_Row = nVar;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                return new AnonymousClass3(this.$contentRef, this.$vm, this.$modifierRef, this.$this_Row, continuation);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                b value;
                                HbSender hbSender;
                                MutableState<String> mutableState;
                                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                ResultKt.throwOnFailure(obj);
                                String value2 = this.$contentRef.getValue();
                                HbDetailRsp value3 = this.$vm.hbDetailRsp.getValue();
                                if (!Intrinsics.areEqual(value2, (value3 == null || (hbSender = value3.sender) == null || (mutableState = hbSender.sendName) == null) ? null : mutableState.getValue()) && (value = this.$modifierRef.getValue()) != null) {
                                    value.a(this.$this_Row.a(i.INSTANCE, 0.0f));
                                }
                                return Unit.INSTANCE;
                            }
                        }

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(com.tencent.ntcompose.foundation.layout.n nVar2, Composer composer4, Integer num2) {
                            int i16;
                            HbSender hbSender4;
                            HbSender hbSender5;
                            HbSender hbSender6;
                            MutableState<String> mutableState;
                            HbSender hbSender7;
                            MutableState<String> mutableState2;
                            HbSender hbSender8;
                            MutableState<String> mutableState3;
                            final com.tencent.ntcompose.foundation.layout.n nVar3 = nVar2;
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 14) == 0) {
                                i16 = (composer5.changed(nVar3) ? 4 : 2) | intValue2;
                            } else {
                                i16 = intValue2;
                            }
                            if ((i16 & 91) == 18 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(48430055, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailHeaderItem.<anonymous>.<anonymous> (HbDetailHeaderItem.kt:89)");
                                }
                                composer5.startReplaceableGroup(-492369756);
                                Object rememberedValue2 = composer5.rememberedValue();
                                Composer.Companion companion3 = Composer.INSTANCE;
                                if (rememberedValue2 == companion3.getEmpty()) {
                                    rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                                    composer5.updateRememberedValue(rememberedValue2);
                                }
                                composer5.endReplaceableGroup();
                                final MutableState mutableState4 = (MutableState) rememberedValue2;
                                composer5.startReplaceableGroup(-492369756);
                                Object rememberedValue3 = composer5.rememberedValue();
                                if (rememberedValue3 == companion3.getEmpty()) {
                                    rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                                    composer5.updateRememberedValue(rememberedValue3);
                                }
                                composer5.endReplaceableGroup();
                                final MutableState mutableState5 = (MutableState) rememberedValue3;
                                i.Companion companion4 = i.INSTANCE;
                                i a16 = com.tencent.ntcompose.material.base.d.a(nVar3.a(ComposeLayoutPropUpdaterKt.A(companion4), 0.0f), ComposableLambdaKt.composableLambda(composer5, 1993737009, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailHeaderItemKt.HbDetailHeaderItem.1.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(b bVar, Composer composer6, Integer num3) {
                                        b bVar2 = bVar;
                                        int intValue3 = num3.intValue();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1993737009, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailHeaderItem.<anonymous>.<anonymous>.<anonymous> (HbDetailHeaderItem.kt:94)");
                                        }
                                        mutableState4.setValue(bVar2);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer5, 56);
                                HbDetailRsp value2 = HbDetailViewModel.this.hbDetailRsp.getValue();
                                String value3 = (value2 == null || (hbSender8 = value2.sender) == null || (mutableState3 = hbSender8.sendName) == null) ? null : mutableState3.getValue();
                                h color$default = QUIToken.color$default("text_primary");
                                c.Companion companion5 = bp3.c.INSTANCE;
                                bp3.c a17 = companion5.a();
                                an.Companion companion6 = an.INSTANCE;
                                int b17 = companion6.b();
                                Float valueOf = Float.valueOf(17.0f);
                                an d18 = an.d(b17);
                                final HbDetailViewModel hbDetailViewModel4 = HbDetailViewModel.this;
                                final float f17 = f16;
                                Integer num3 = null;
                                TextKt.a(value3, a16, null, color$default, valueOf, null, a17, null, null, null, null, null, null, null, null, null, d18, null, 1, new Function1<am, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailHeaderItemKt.HbDetailHeaderItem.1.2.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(am amVar) {
                                        HbSender hbSender9;
                                        MutableState<String> mutableState6;
                                        HbSender hbSender10;
                                        MutableState<String> mutableState7;
                                        am amVar2 = amVar;
                                        String value4 = mutableState5.getValue();
                                        HbDetailRsp value5 = hbDetailViewModel4.hbDetailRsp.getValue();
                                        String str3 = null;
                                        if (!Intrinsics.areEqual(value4, (value5 == null || (hbSender10 = value5.sender) == null || (mutableState7 = hbSender10.sendName) == null) ? null : mutableState7.getValue())) {
                                            MutableState<String> mutableState8 = mutableState5;
                                            HbDetailRsp value6 = hbDetailViewModel4.hbDetailRsp.getValue();
                                            if (value6 != null && (hbSender9 = value6.sender) != null && (mutableState6 = hbSender9.sendName) != null) {
                                                str3 = mutableState6.getValue();
                                            }
                                            mutableState8.setValue(str3);
                                            QWLog qWLog = QWLog.INSTANCE;
                                            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onTextLayout: contentRef.value=");
                                            m3.append(mutableState5.getValue());
                                            m3.append(" result.frame.width=");
                                            m3.append(amVar2.getFrame().getWidth());
                                            m3.append(", activityWidth / 2=");
                                            float f18 = 2;
                                            m3.append(f17 / f18);
                                            QWLog.INSTANCE.i("HbDetailHeaderItem", m3.toString(), false);
                                            if (amVar2.getFrame().getWidth() > f17 / f18) {
                                                b value7 = mutableState4.getValue();
                                                if (value7 != null) {
                                                    value7.a(nVar3.a(i.INSTANCE, 1.0f));
                                                }
                                            } else {
                                                b value8 = mutableState4.getValue();
                                                if (value8 != null) {
                                                    value8.a(nVar3.a(i.INSTANCE, 0.0f));
                                                }
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }, null, Float.valueOf(0.0f), null, null, null, null, false, composer5, 1601600, 102236160, 48, 131268516);
                                HbDetailRsp value4 = HbDetailViewModel.this.hbDetailRsp.getValue();
                                EffectsKt.LaunchedEffect((value4 == null || (hbSender7 = value4.sender) == null || (mutableState2 = hbSender7.sendName) == null) ? null : mutableState2.getValue(), new AnonymousClass3(mutableState5, HbDetailViewModel.this, mutableState4, nVar3, null), composer5, 64);
                                HbDetailRsp value5 = HbDetailViewModel.this.hbDetailRsp.getValue();
                                String value6 = (value5 == null || (hbSender6 = value5.sender) == null || (mutableState = hbSender6.sendName) == null) ? null : mutableState.getValue();
                                if (!(value6 == null || value6.length() == 0)) {
                                    i A = ComposeLayoutPropUpdaterKt.A(companion4);
                                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\u53d1\u9001\u7684");
                                    HbDetailRsp value7 = HbDetailViewModel.this.hbDetailRsp.getValue();
                                    Integer valueOf2 = (value7 == null || (hbSender5 = value7.sender) == null) ? null : Integer.valueOf(hbSender5.channel);
                                    HbDetailRsp value8 = HbDetailViewModel.this.hbDetailRsp.getValue();
                                    if (value8 != null && (hbSender4 = value8.sender) != null) {
                                        num3 = Integer.valueOf(hbSender4.busiType);
                                    }
                                    String str3 = "";
                                    if (valueOf2 != null && num3 != null) {
                                        int intValue3 = valueOf2.intValue();
                                        if (intValue3 == 6 || intValue3 == 32 || intValue3 == 65536) {
                                            str3 = valueOf2.intValue() == 65536 ? "\u8bed\u97f3" : "\u53e3\u4ee4";
                                        } else {
                                            if (valueOf2.intValue() == 1024) {
                                                str3 = "\u4e13\u5c5e";
                                            } else if (2 == num3.intValue()) {
                                                str3 = "\u62fc\u624b\u6c14";
                                            } else if (num3.intValue() == 0) {
                                                str3 = "\u666e\u901a";
                                            }
                                        }
                                    }
                                    TextKt.a(OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0.m(m3, str3, "\u7ea2\u5305"), A, null, QUIToken.color$default("text_primary"), Float.valueOf(17.0f), null, companion5.a(), null, null, null, null, null, null, null, null, null, an.d(companion6.b()), null, 1, null, null, null, null, null, null, null, false, composer5, 1601600, 102236160, 0, 133889956);
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 196680, 24);
                    i n16 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.A(companion), 0.0f, 15.0f, 0.0f, 0.0f, 13, null);
                    int a16 = ai.INSTANCE.a();
                    HbDetailRsp value2 = HbDetailViewModel.this.hbDetailRsp.getValue();
                    String str3 = (value2 == null || (hbSender2 = value2.sender) == null) ? null : hbSender2.wishing;
                    if (!(!(str3 == null || str3.length() == 0))) {
                        str3 = null;
                    }
                    if (str3 == null) {
                        str3 = " ";
                    }
                    TextKt.a(str3, n16, null, QUIToken.color$default("text_secondary"), Float.valueOf(17.0f), null, null, null, null, null, ai.f(a16), null, null, null, null, null, an.d(an.INSTANCE.b()), null, 1, null, null, null, null, null, null, null, false, composer3, 28736, 102236160, 0, 133888996);
                    composer3.startReplaceableGroup(229624993);
                    if (HbDetailViewModel.this.hasGrabbed.getValue().booleanValue()) {
                        i n17 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.z(ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null)), 0.0f, 20.0f, 0.0f, 0.0f, 13, null);
                        Alignment.Vertical a17 = companion2.a();
                        a.e b17 = aVar.b();
                        final n nVar2 = nVar;
                        final HbDetailViewModel hbDetailViewModel4 = HbDetailViewModel.this;
                        RowKt.a(n17, b17, a17, null, null, ComposableLambdaKt.composableLambda(composer3, -1561404308, true, new Function3<com.tencent.ntcompose.foundation.layout.n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailHeaderItemKt$HbDetailHeaderItem$1.4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(com.tencent.ntcompose.foundation.layout.n nVar3, Composer composer4, Integer num2) {
                                HbReceiver hbReceiver;
                                Composer composer5 = composer4;
                                int intValue2 = num2.intValue();
                                if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                    composer5.skipToGroupEnd();
                                } else {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1561404308, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailHeaderItem.<anonymous>.<anonymous> (HbDetailHeaderItem.kt:163)");
                                    }
                                    i.Companion companion3 = i.INSTANCE;
                                    i n18 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.A(companion3), 0.0f, 0.0f, 3.0f, 0.0f, 11, null);
                                    ai.Companion companion4 = ai.INSTANCE;
                                    int a18 = companion4.a();
                                    h hVar = new h(4292057401L);
                                    bp3.c a19 = bp3.c.INSTANCE.a();
                                    Float valueOf = Float.valueOf(36.0f);
                                    n nVar4 = n.this;
                                    ai f17 = ai.f(a18);
                                    int i16 = n.f339436b;
                                    TextKt.a("\uffe5", n18, null, hVar, valueOf, null, a19, nVar4, null, null, f17, null, null, null, null, null, null, null, 1, null, null, null, null, null, null, null, false, composer5, (i16 << 21) | 1601606, 100663296, 0, 133954340);
                                    i n19 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.A(companion3), 5.0f, 0.0f, 0.0f, 0.0f, 14, null);
                                    int a26 = companion4.a();
                                    HbDetailRsp value3 = hbDetailViewModel4.hbDetailRsp.getValue();
                                    TextKt.a(String.valueOf(((value3 == null || (hbReceiver = value3.self) == null) ? 0 : hbReceiver.amount) / 100.0f), n19, null, new h(4292057401L), Float.valueOf(70.0f), null, null, n.this, null, null, ai.f(a26), Float.valueOf(55.0f), null, null, null, null, null, null, 1, null, null, null, null, null, null, null, false, composer5, (i16 << 21) | 28736, 100663344, 0, 133952356);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer3, 196680, 24);
                        RowKt.a(ViewEventPropUpdaterKt.d(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.z(ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null)), 0.0f, 15.0f, 0.0f, 0.0f, 13, null), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailHeaderItemKt$HbDetailHeaderItem$1.5
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ClickParams clickParams) {
                                MqqUi.openUrl$default(Mqq.INSTANCE.getUi(), "mqqapi://wallet/open?src_type=web&viewtype=0&version=1&view=0&channel=4");
                                return Unit.INSTANCE;
                            }
                        }, 3, null), aVar.b(), companion2.c(), null, null, ComposableSingletons$HbDetailHeaderItemKt.f159lambda1, composer3, 196680, 24);
                    }
                    composer3.endReplaceableGroup();
                    i n18 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.z(ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null)), 0.0f, 50.0f, 0.0f, 15.0f, 5, null);
                    HbDetailRsp value3 = HbDetailViewModel.this.hbDetailRsp.getValue();
                    if (value3 == null || (hbSender = value3.sender) == null || (str2 = hbSender.hbStatusDesc) == null) {
                        str2 = "";
                    }
                    TextKt.a(str2, n18, null, QUIToken.color$default("text_secondary"), Float.valueOf(14.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, 28736, 0, 0, 134217700);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 24584, 10);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailHeaderItemKt$HbDetailHeaderItem$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                HbDetailHeaderItemKt.HbDetailHeaderItem(HbDetailViewModel.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
