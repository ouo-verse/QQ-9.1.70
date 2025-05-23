package com.tencent.hippykotlin.demo.pages.nearby.public_account.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.c;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.compose_base.view.QQStrangerImageKt;
import com.tencent.hippykotlin.demo.pages.nearby.public_account.vm.QQStrangerPAFeedCardVM;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.an;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.ntcompose.material.h;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import p35.n;
import yo3.Size;

/* loaded from: classes31.dex */
public final class QQStrangerPAFeedCardViewKt {
    public static final void QQStrangerPAFeedCardView(final QQStrangerPAFeedCardVM qQStrangerPAFeedCardVM, i iVar, final Size size, final Object obj, final String str, final String str2, final String str3, final Function0<Boolean> function0, final Function0<String> function02, final Function0<Unit> function03, final Function0<Unit> function04, final Function0<Unit> function05, Composer composer, final int i3, final int i16, final int i17) {
        final String str4;
        Composer startRestartGroup = composer.startRestartGroup(-620204662);
        i iVar2 = (i17 & 2) != 0 ? i.INSTANCE : iVar;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-620204662, i3, i16, "com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPAFeedCardView (QQStrangerPAFeedCardView.kt:45)");
        }
        n nVar = qQStrangerPAFeedCardVM.feedCard;
        if (nVar == null || (str4 = nVar.f425193d) == null) {
            str4 = "";
        }
        i iVar3 = i.INSTANCE;
        i c16 = ModifiersKt.c(ModifiersKt.j(ComposeLayoutPropUpdaterKt.z(ComposeLayoutPropUpdaterKt.w(iVar3, size.getWidth())), 4.0f), QUIToken.color$default("fill_light_primary"));
        startRestartGroup.startReplaceableGroup(-321088327);
        if (!qQStrangerPAFeedCardVM.isFromCache) {
            startRestartGroup.startReplaceableGroup(511388516);
            boolean changed = startRestartGroup.changed(str4) | startRestartGroup.changed(qQStrangerPAFeedCardVM);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPAFeedCardViewKt$QQStrangerPAFeedCardView$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object obj2) {
                        QQStrangerPAFeedCardViewKt.doReportFeedCard(str4, qQStrangerPAFeedCardVM, true);
                        return Unit.INSTANCE;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            iVar3 = ViewEventPropUpdaterKt.r(iVar3, (Function1) rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        i b16 = c16.b(iVar3);
        startRestartGroup.startReplaceableGroup(1618982084);
        boolean changed2 = startRestartGroup.changed(function03) | startRestartGroup.changed(str4) | startRestartGroup.changed(qQStrangerPAFeedCardVM);
        Object rememberedValue2 = startRestartGroup.rememberedValue();
        if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            rememberedValue2 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPAFeedCardViewKt$QQStrangerPAFeedCardView$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(ClickParams clickParams) {
                    function03.invoke();
                    QQStrangerPAFeedCardViewKt.doReportFeedCard(str4, qQStrangerPAFeedCardVM, false);
                    return Unit.INSTANCE;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue2);
        }
        startRestartGroup.endReplaceableGroup();
        ColumnKt.a(ViewEventPropUpdaterKt.d(b16, false, null, (Function1) rememberedValue2, 3, null), null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1097738867, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPAFeedCardViewKt$QQStrangerPAFeedCardView$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            /* JADX WARN: Removed duplicated region for block: B:21:0x01bc  */
            @Override // kotlin.jvm.functions.Function3
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Unit invoke(d dVar, Composer composer2, Integer num) {
                Composer composer3;
                Composer composer4 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer4.getSkipping()) {
                    composer4.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1097738867, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPAFeedCardView.<anonymous> (QQStrangerPAFeedCardView.kt:73)");
                    }
                    Object obj2 = obj;
                    if (obj2 instanceof String) {
                        if (((CharSequence) obj2).length() == 0) {
                            composer4.startReplaceableGroup(-1288054365);
                            Alignment alignment = Alignment.Center;
                            i k3 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, size.getWidth()), size.getWidth());
                            final Size size2 = size;
                            final String str5 = str;
                            final int i18 = i3;
                            BoxKt.a(k3, alignment, null, ComposableLambdaKt.composableLambda(composer4, -707084302, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPAFeedCardViewKt$QQStrangerPAFeedCardView$3.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public final Unit invoke(b bVar, Composer composer5, Integer num2) {
                                    Composer composer6 = composer5;
                                    int intValue2 = num2.intValue();
                                    if ((intValue2 & 81) == 16 && composer6.getSkipping()) {
                                        composer6.skipToGroupEnd();
                                    } else {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-707084302, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPAFeedCardView.<anonymous>.<anonymous> (QQStrangerPAFeedCardView.kt:80)");
                                        }
                                        int a16 = h.INSTANCE.a();
                                        i.Companion companion = i.INSTANCE;
                                        ImageKt.a("https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_yL65F5v2jIT.png", null, null, null, null, ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion, Size.this.getWidth()), Size.this.getWidth()), null, a16, null, null, null, null, null, null, null, null, null, null, null, null, null, composer6, 12845062, 0, 0, 2096990);
                                        com.tencent.kuikly.core.base.h hVar = new com.tencent.kuikly.core.base.h(7504300L, 1.0f);
                                        c e16 = c.INSTANCE.e();
                                        int b17 = an.INSTANCE.b();
                                        TextKt.a(str5, ComposeLayoutPropUpdaterKt.j(ComposeLayoutPropUpdaterKt.n(companion, 16.0f, 0.0f, 16.0f, 0.0f, 10, null), 0.0f, 1, null), null, hVar, Float.valueOf(16.0f), null, e16, null, null, null, null, null, null, null, null, null, an.d(b17), null, 5, null, null, null, "emoji", null, null, null, false, composer6, ((i18 >> 12) & 14) | 1601600, 102236160, MsgConstant.KRMFILETHUMBSIZE384, 129695652);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                    return Unit.INSTANCE;
                                }
                            }), composer4, 3128, 4);
                            composer4.endReplaceableGroup();
                            composer3 = composer4;
                            Alignment.Vertical c17 = Alignment.INSTANCE.c();
                            i.Companion companion = i.INSTANCE;
                            Composer composer5 = composer3;
                            RowKt.a(ComposeLayoutPropUpdaterKt.z(ComposeLayoutPropUpdaterKt.j(ComposeLayoutPropUpdaterKt.n(companion, 10.0f, 7.0f, 10.0f, 0.0f, 8, null), 0.0f, 1, null)), null, c17, null, null, ComposableLambdaKt.composableLambda(composer5, -1268045551, true, new Function3<com.tencent.ntcompose.foundation.layout.n, Composer, Integer, Unit>(str2, function03, i3, str3, function05, i16, function0, function02) { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPAFeedCardViewKt$QQStrangerPAFeedCardView$3.3
                                public final /* synthetic */ int $$dirty;
                                public final /* synthetic */ Function0<Boolean> $isLikeProvider;
                                public final /* synthetic */ Function0<String> $likeCountProvider;
                                public final /* synthetic */ String $nickName;
                                public final /* synthetic */ String $nickUrl;
                                public final /* synthetic */ Function0<Unit> $onFeedCardClick;
                                public final /* synthetic */ Function0<Unit> $onLikeIconClick;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                    this.$isLikeProvider = r7;
                                    this.$likeCountProvider = r8;
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public final Unit invoke(com.tencent.ntcompose.foundation.layout.n nVar2, Composer composer6, Integer num2) {
                                    int i19;
                                    com.tencent.ntcompose.foundation.layout.n nVar3 = nVar2;
                                    Composer composer7 = composer6;
                                    int intValue2 = num2.intValue();
                                    if ((intValue2 & 14) == 0) {
                                        i19 = (composer7.changed(nVar3) ? 4 : 2) | intValue2;
                                    } else {
                                        i19 = intValue2;
                                    }
                                    if ((i19 & 91) == 18 && composer7.getSkipping()) {
                                        composer7.skipToGroupEnd();
                                    } else {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1268045551, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPAFeedCardView.<anonymous>.<anonymous> (QQStrangerPAFeedCardView.kt:129)");
                                        }
                                        String str6 = this.$nickUrl;
                                        i.Companion companion2 = i.INSTANCE;
                                        i j3 = ModifiersKt.j(ComposeLayoutPropUpdaterKt.u(companion2, 17.0f), 8.5f);
                                        final Function0<Unit> function06 = this.$onFeedCardClick;
                                        composer7.startReplaceableGroup(1157296644);
                                        boolean changed3 = composer7.changed(function06);
                                        Object rememberedValue3 = composer7.rememberedValue();
                                        if (changed3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue3 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPAFeedCardViewKt$QQStrangerPAFeedCardView$3$3$1$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ClickParams clickParams) {
                                                    function06.invoke();
                                                    return Unit.INSTANCE;
                                                }
                                            };
                                            composer7.updateRememberedValue(rememberedValue3);
                                        }
                                        composer7.endReplaceableGroup();
                                        ImageKt.a(str6, null, null, null, null, ViewEventPropUpdaterKt.d(j3, false, null, (Function1) rememberedValue3, 3, null), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer7, ((this.$$dirty >> 15) & 14) | 262144, 0, 0, 2097118);
                                        c e16 = c.INSTANCE.e();
                                        float f16 = 16;
                                        com.tencent.kuikly.core.base.h color$default = QUIToken.color$default("text_secondary");
                                        int b17 = an.INSTANCE.b();
                                        i n3 = ComposeLayoutPropUpdaterKt.n(nVar3.a(companion2, 1.0f), 4.0f, 2.0f, 4.0f, 0.0f, 8, null);
                                        final Function0<Unit> function07 = this.$onFeedCardClick;
                                        composer7.startReplaceableGroup(1157296644);
                                        boolean changed4 = composer7.changed(function07);
                                        Object rememberedValue4 = composer7.rememberedValue();
                                        if (changed4 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue4 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPAFeedCardViewKt$QQStrangerPAFeedCardView$3$3$2$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ClickParams clickParams) {
                                                    function07.invoke();
                                                    return Unit.INSTANCE;
                                                }
                                            };
                                            composer7.updateRememberedValue(rememberedValue4);
                                        }
                                        composer7.endReplaceableGroup();
                                        TextKt.a(this.$nickName, ViewEventPropUpdaterKt.d(n3, false, null, (Function1) rememberedValue4, 3, null), null, color$default, Float.valueOf(12.0f), null, e16, null, null, null, null, Float.valueOf(f16), null, null, null, null, an.d(b17), null, 1, null, null, null, null, null, null, null, false, composer7, ((this.$$dirty >> 18) & 14) | 1601600, 102236208, 0, 133887908);
                                        Alignment.Vertical c18 = Alignment.INSTANCE.c();
                                        i A = ComposeLayoutPropUpdaterKt.A(companion2);
                                        final Function0<Unit> function08 = this.$onLikeIconClick;
                                        composer7.startReplaceableGroup(1157296644);
                                        boolean changed5 = composer7.changed(function08);
                                        Object rememberedValue5 = composer7.rememberedValue();
                                        if (changed5 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue5 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPAFeedCardViewKt$QQStrangerPAFeedCardView$3$3$3$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ClickParams clickParams) {
                                                    function08.invoke();
                                                    return Unit.INSTANCE;
                                                }
                                            };
                                            composer7.updateRememberedValue(rememberedValue5);
                                        }
                                        composer7.endReplaceableGroup();
                                        i d16 = ViewEventPropUpdaterKt.d(A, false, null, (Function1) rememberedValue5, 3, null);
                                        final Function0<Boolean> function09 = this.$isLikeProvider;
                                        final Function0<String> function010 = this.$likeCountProvider;
                                        RowKt.a(d16, null, c18, null, null, ComposableLambdaKt.composableLambda(composer7, 29311791, true, new Function3<com.tencent.ntcompose.foundation.layout.n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPAFeedCardViewKt.QQStrangerPAFeedCardView.3.3.4
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public final Unit invoke(com.tencent.ntcompose.foundation.layout.n nVar4, Composer composer8, Integer num3) {
                                                String str7;
                                                com.tencent.kuikly.core.base.h color$default2;
                                                Composer composer9 = composer8;
                                                int intValue3 = num3.intValue();
                                                if ((intValue3 & 81) == 16 && composer9.getSkipping()) {
                                                    composer9.skipToGroupEnd();
                                                } else {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(29311791, intValue3, -1, "com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPAFeedCardView.<anonymous>.<anonymous>.<anonymous> (QQStrangerPAFeedCardView.kt:164)");
                                                    }
                                                    boolean booleanValue = function09.invoke().booleanValue();
                                                    QUIToken qUIToken = QUIToken.INSTANCE;
                                                    if (booleanValue) {
                                                        str7 = "heart_filled";
                                                    } else {
                                                        str7 = "heart";
                                                    }
                                                    if (booleanValue) {
                                                        color$default2 = QUIToken.color$default("feedback_error");
                                                    } else {
                                                        color$default2 = QUIToken.color$default("icon_secondary");
                                                    }
                                                    String image = qUIToken.image(str7, color$default2);
                                                    i.Companion companion3 = i.INSTANCE;
                                                    ImageKt.a(image, null, null, null, null, ComposeLayoutPropUpdaterKt.u(companion3, 13.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer9, 262144, 0, 0, 2097118);
                                                    String invoke = function010.invoke();
                                                    if (invoke.length() > 0) {
                                                        TextKt.a(invoke, ComposeLayoutPropUpdaterKt.n(companion3, 4.0f, 0.0f, 0.0f, 0.0f, 14, null), null, QUIToken.color$default("text_secondary"), Float.valueOf(13.0f), null, c.INSTANCE.e(), null, null, null, null, Float.valueOf(16), null, null, null, null, null, null, null, null, null, null, "emoji", null, null, null, false, composer9, 1601600, 48, MsgConstant.KRMFILETHUMBSIZE384, 130021284);
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        }), composer7, 196616, 26);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                    return Unit.INSTANCE;
                                }
                            }), composer5, 196616, 26);
                            SpacerKt.a(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null), 7.0f), composer5, 8, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }
                    composer4.startReplaceableGroup(-1288053352);
                    final Object obj3 = obj;
                    Function0<Object> function06 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPAFeedCardViewKt$QQStrangerPAFeedCardView$3.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return obj3;
                        }
                    };
                    int a16 = h.INSTANCE.a();
                    i.Companion companion2 = i.INSTANCE;
                    QQStrangerImageKt.m114QQStrangerImageCvonfEE(function06, a16, ModifiersKt.c(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion2, size.getWidth()), size.getHeight()), QUIToken.color$default("fill_standard_primary")), composer4, PlayerResources.ViewId.GET_MORE_TOGGLE_AREA, 0);
                    if (str.length() > 0) {
                        composer3 = composer4;
                        TextKt.a(str, ComposeLayoutPropUpdaterKt.n(companion2, 10.0f, 9.0f, 10.0f, 0.0f, 8, null), null, QUIToken.color$default("text_primary"), Float.valueOf(14.0f), null, c.INSTANCE.f(), null, null, null, null, Float.valueOf(21.0f), null, null, null, null, an.d(an.INSTANCE.b()), null, 2, null, null, null, "emoji", null, null, null, false, composer3, ((i3 >> 12) & 14) | 1601600, 102236208, MsgConstant.KRMFILETHUMBSIZE384, 129693604);
                    } else {
                        composer3 = composer4;
                    }
                    composer3.endReplaceableGroup();
                    Alignment.Vertical c172 = Alignment.INSTANCE.c();
                    i.Companion companion3 = i.INSTANCE;
                    Composer composer52 = composer3;
                    RowKt.a(ComposeLayoutPropUpdaterKt.z(ComposeLayoutPropUpdaterKt.j(ComposeLayoutPropUpdaterKt.n(companion3, 10.0f, 7.0f, 10.0f, 0.0f, 8, null), 0.0f, 1, null)), null, c172, null, null, ComposableLambdaKt.composableLambda(composer52, -1268045551, true, new Function3<com.tencent.ntcompose.foundation.layout.n, Composer, Integer, Unit>(str2, function03, i3, str3, function05, i16, function0, function02) { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPAFeedCardViewKt$QQStrangerPAFeedCardView$3.3
                        public final /* synthetic */ int $$dirty;
                        public final /* synthetic */ Function0<Boolean> $isLikeProvider;
                        public final /* synthetic */ Function0<String> $likeCountProvider;
                        public final /* synthetic */ String $nickName;
                        public final /* synthetic */ String $nickUrl;
                        public final /* synthetic */ Function0<Unit> $onFeedCardClick;
                        public final /* synthetic */ Function0<Unit> $onLikeIconClick;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                            this.$isLikeProvider = r7;
                            this.$likeCountProvider = r8;
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(com.tencent.ntcompose.foundation.layout.n nVar2, Composer composer6, Integer num2) {
                            int i19;
                            com.tencent.ntcompose.foundation.layout.n nVar3 = nVar2;
                            Composer composer7 = composer6;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 14) == 0) {
                                i19 = (composer7.changed(nVar3) ? 4 : 2) | intValue2;
                            } else {
                                i19 = intValue2;
                            }
                            if ((i19 & 91) == 18 && composer7.getSkipping()) {
                                composer7.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1268045551, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPAFeedCardView.<anonymous>.<anonymous> (QQStrangerPAFeedCardView.kt:129)");
                                }
                                String str6 = this.$nickUrl;
                                i.Companion companion22 = i.INSTANCE;
                                i j3 = ModifiersKt.j(ComposeLayoutPropUpdaterKt.u(companion22, 17.0f), 8.5f);
                                final Function0<Unit> function062 = this.$onFeedCardClick;
                                composer7.startReplaceableGroup(1157296644);
                                boolean changed3 = composer7.changed(function062);
                                Object rememberedValue3 = composer7.rememberedValue();
                                if (changed3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue3 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPAFeedCardViewKt$QQStrangerPAFeedCardView$3$3$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ClickParams clickParams) {
                                            function062.invoke();
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    composer7.updateRememberedValue(rememberedValue3);
                                }
                                composer7.endReplaceableGroup();
                                ImageKt.a(str6, null, null, null, null, ViewEventPropUpdaterKt.d(j3, false, null, (Function1) rememberedValue3, 3, null), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer7, ((this.$$dirty >> 15) & 14) | 262144, 0, 0, 2097118);
                                c e16 = c.INSTANCE.e();
                                float f16 = 16;
                                com.tencent.kuikly.core.base.h color$default = QUIToken.color$default("text_secondary");
                                int b17 = an.INSTANCE.b();
                                i n3 = ComposeLayoutPropUpdaterKt.n(nVar3.a(companion22, 1.0f), 4.0f, 2.0f, 4.0f, 0.0f, 8, null);
                                final Function0<Unit> function07 = this.$onFeedCardClick;
                                composer7.startReplaceableGroup(1157296644);
                                boolean changed4 = composer7.changed(function07);
                                Object rememberedValue4 = composer7.rememberedValue();
                                if (changed4 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue4 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPAFeedCardViewKt$QQStrangerPAFeedCardView$3$3$2$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ClickParams clickParams) {
                                            function07.invoke();
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    composer7.updateRememberedValue(rememberedValue4);
                                }
                                composer7.endReplaceableGroup();
                                TextKt.a(this.$nickName, ViewEventPropUpdaterKt.d(n3, false, null, (Function1) rememberedValue4, 3, null), null, color$default, Float.valueOf(12.0f), null, e16, null, null, null, null, Float.valueOf(f16), null, null, null, null, an.d(b17), null, 1, null, null, null, null, null, null, null, false, composer7, ((this.$$dirty >> 18) & 14) | 1601600, 102236208, 0, 133887908);
                                Alignment.Vertical c18 = Alignment.INSTANCE.c();
                                i A = ComposeLayoutPropUpdaterKt.A(companion22);
                                final Function0<Unit> function08 = this.$onLikeIconClick;
                                composer7.startReplaceableGroup(1157296644);
                                boolean changed5 = composer7.changed(function08);
                                Object rememberedValue5 = composer7.rememberedValue();
                                if (changed5 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue5 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPAFeedCardViewKt$QQStrangerPAFeedCardView$3$3$3$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ClickParams clickParams) {
                                            function08.invoke();
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    composer7.updateRememberedValue(rememberedValue5);
                                }
                                composer7.endReplaceableGroup();
                                i d16 = ViewEventPropUpdaterKt.d(A, false, null, (Function1) rememberedValue5, 3, null);
                                final Function0<Boolean> function09 = this.$isLikeProvider;
                                final Function0<String> function010 = this.$likeCountProvider;
                                RowKt.a(d16, null, c18, null, null, ComposableLambdaKt.composableLambda(composer7, 29311791, true, new Function3<com.tencent.ntcompose.foundation.layout.n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPAFeedCardViewKt.QQStrangerPAFeedCardView.3.3.4
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(com.tencent.ntcompose.foundation.layout.n nVar4, Composer composer8, Integer num3) {
                                        String str7;
                                        com.tencent.kuikly.core.base.h color$default2;
                                        Composer composer9 = composer8;
                                        int intValue3 = num3.intValue();
                                        if ((intValue3 & 81) == 16 && composer9.getSkipping()) {
                                            composer9.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(29311791, intValue3, -1, "com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPAFeedCardView.<anonymous>.<anonymous>.<anonymous> (QQStrangerPAFeedCardView.kt:164)");
                                            }
                                            boolean booleanValue = function09.invoke().booleanValue();
                                            QUIToken qUIToken = QUIToken.INSTANCE;
                                            if (booleanValue) {
                                                str7 = "heart_filled";
                                            } else {
                                                str7 = "heart";
                                            }
                                            if (booleanValue) {
                                                color$default2 = QUIToken.color$default("feedback_error");
                                            } else {
                                                color$default2 = QUIToken.color$default("icon_secondary");
                                            }
                                            String image = qUIToken.image(str7, color$default2);
                                            i.Companion companion32 = i.INSTANCE;
                                            ImageKt.a(image, null, null, null, null, ComposeLayoutPropUpdaterKt.u(companion32, 13.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer9, 262144, 0, 0, 2097118);
                                            String invoke = function010.invoke();
                                            if (invoke.length() > 0) {
                                                TextKt.a(invoke, ComposeLayoutPropUpdaterKt.n(companion32, 4.0f, 0.0f, 0.0f, 0.0f, 14, null), null, QUIToken.color$default("text_secondary"), Float.valueOf(13.0f), null, c.INSTANCE.e(), null, null, null, null, Float.valueOf(16), null, null, null, null, null, null, null, null, null, null, "emoji", null, null, null, false, composer9, 1601600, 48, MsgConstant.KRMFILETHUMBSIZE384, 130021284);
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer7, 196616, 26);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer52, 196616, 26);
                    SpacerKt.a(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion3, 0.0f, 1, null), 7.0f), composer52, 8, 0);
                    if (ComposerKt.isTraceInProgress()) {
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
        final i iVar4 = iVar2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPAFeedCardViewKt$QQStrangerPAFeedCardView$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQStrangerPAFeedCardViewKt.QQStrangerPAFeedCardView(QQStrangerPAFeedCardVM.this, iVar4, size, obj, str, str2, str3, function0, function02, function03, function04, function05, composer2, i3 | 1, i16, i17);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void doReportFeedCard(String str, QQStrangerPAFeedCardVM qQStrangerPAFeedCardVM, boolean z16) {
        String str2;
        if (z16) {
            str2 = "dt_imp";
        } else {
            str2 = "dt_clck";
        }
        e dtReportBaseParams = qQStrangerPAFeedCardVM.mainVM.getDtReportBaseParams();
        dtReportBaseParams.v("dt_eid", "em_nearby_kl_feed_card");
        dtReportBaseParams.v("nearby_kl_feed_id", str);
        dtReportBaseParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent(str2, dtReportBaseParams);
    }
}
