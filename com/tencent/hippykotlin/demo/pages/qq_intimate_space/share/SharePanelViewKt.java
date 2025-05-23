package com.tencent.hippykotlin.demo.pages.qq_intimate_space.share;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.modifer_ext.ModifierExtKt;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.f;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.ntcompose.animation.b;
import com.tencent.ntcompose.animation.m;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.AlertCustomDialogKt;
import com.tencent.ntcompose.material.AlertDialogTransitionType;
import com.tencent.ntcompose.material.ButtonKt;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.LazyRowKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* loaded from: classes37.dex */
public final class SharePanelViewKt {
    public static final ShareItem ShareItemSendToQQ = new ShareItem("QQ\u597d\u53cb", "https://vfiles.gtimg.cn/wupload/xy/componenthub/iyuLkiV8.png", 2, (h) null, 24);
    public static final ShareItem ShareItemSendToQZone = new ShareItem("QQ\u7a7a\u95f4", "https://vfiles.gtimg.cn/wupload/xy/componenthub/3b7ZXUs1.png", 3, (h) null, 24);
    public static final ShareItem ShareItemSendToWechatFriend = new ShareItem("\u5fae\u4fe1\u597d\u53cb", "https://vfiles.gtimg.cn/wupload/xy/componenthub/hAlD2UWM.png", 9, (h) null, 24);
    public static final ShareItem ShareItemSendToWechatCircle = new ShareItem("\u670b\u53cb\u5708", "https://vfiles.gtimg.cn/wupload/xy/componenthub/uakjv48U.png", 10, (h) null, 24);
    public static final ShareItem ShareItemSendToXHS = new ShareItem("\u5c0f\u7ea2\u4e66", "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_zTYJbp54MY4.png", 218, (h) null, 24);
    public static final ShareItem ShareItemSaveToMobile = new ShareItem("\u4fdd\u5b58\u5230\u624b\u673a", "https://vfiles.gtimg.cn/wupload/xy/componenthub/cybPQdIY.png", 39, QUIToken.color$default("icon_primary"), 16);

    public static final void SharePanelView(final SharePanelViewModel sharePanelViewModel, final PanelConfig panelConfig, ShareElementVR shareElementVR, ShareElementVR shareElementVR2, Function0<Unit> function0, Function0<Unit> function02, Function0<Unit> function03, Function1<? super ShareItem, Unit> function1, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i3, final int i16) {
        Composer startRestartGroup = composer.startRestartGroup(-1878641514);
        ShareElementVR shareElementVR3 = (i16 & 4) != 0 ? null : shareElementVR;
        ShareElementVR shareElementVR4 = (i16 & 8) != 0 ? null : shareElementVR2;
        final Function0<Unit> function04 = (i16 & 16) != 0 ? null : function0;
        Function0<Unit> function05 = (i16 & 32) != 0 ? null : function02;
        final Function0<Unit> function06 = (i16 & 64) != 0 ? null : function03;
        Function1<? super ShareItem, Unit> function12 = (i16 & 128) != 0 ? null : function1;
        Function2<? super Composer, ? super Integer, Unit> function22 = (i16 & 256) != 0 ? null : function2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1878641514, i3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.SharePanelView (SharePanelView.kt:42)");
        }
        boolean booleanValue = sharePanelViewModel.showPanel.getValue().booleanValue();
        AlertDialogTransitionType alertDialogTransitionType = AlertDialogTransitionType.DIRECTION_FROM_BOTTOM;
        h a16 = h.INSTANCE.a(0.5f);
        Alignment alignment = Alignment.BottomCenter;
        m d16 = b.d(300, 0, null, null, 14, null);
        m d17 = b.d(300, 0, null, null, 14, null);
        SharePanelViewKt$SharePanelView$1 sharePanelViewKt$SharePanelView$1 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.SharePanelViewKt$SharePanelView$1
            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                return Unit.INSTANCE;
            }
        };
        startRestartGroup.startReplaceableGroup(1157296644);
        boolean changed = startRestartGroup.changed(function06);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.SharePanelViewKt$SharePanelView$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    Function0<Unit> function07 = function06;
                    if (function07 != null) {
                        function07.invoke();
                    }
                    return Unit.INSTANCE;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        Function0 function07 = (Function0) rememberedValue;
        startRestartGroup.startReplaceableGroup(1157296644);
        boolean changed2 = startRestartGroup.changed(function04);
        Object rememberedValue2 = startRestartGroup.rememberedValue();
        if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            rememberedValue2 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.SharePanelViewKt$SharePanelView$3$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    Function0<Unit> function08 = function04;
                    if (function08 != null) {
                        function08.invoke();
                    }
                    return Unit.INSTANCE;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue2);
        }
        startRestartGroup.endReplaceableGroup();
        Function0 function08 = (Function0) rememberedValue2;
        final Function2<? super Composer, ? super Integer, Unit> function23 = function22;
        final ShareElementVR shareElementVR5 = shareElementVR3;
        final ShareElementVR shareElementVR6 = shareElementVR4;
        final Function1<? super ShareItem, Unit> function13 = function12;
        final Function0<Unit> function09 = function05;
        AlertCustomDialogKt.a(booleanValue, false, a16, sharePanelViewKt$SharePanelView$1, alertDialogTransitionType, function07, function08, alignment, d16, d17, ComposableLambdaKt.composableLambda(startRestartGroup, -1689862519, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.SharePanelViewKt$SharePanelView$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                        ComposerKt.traceEventStart(-1689862519, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.SharePanelView.<anonymous> (SharePanelView.kt:68)");
                    }
                    Function2<Composer, Integer, Unit> function24 = function23;
                    composer3.startReplaceableGroup(383733435);
                    if (function24 != null) {
                        function24.invoke(composer3, Integer.valueOf((i3 >> 24) & 14));
                        Unit unit = Unit.INSTANCE;
                    }
                    composer3.endReplaceableGroup();
                    PanelConfig panelConfig2 = panelConfig;
                    ShareElementVR shareElementVR7 = shareElementVR5;
                    ShareElementVR shareElementVR8 = shareElementVR6;
                    final Function0<Unit> function010 = function09;
                    final SharePanelViewModel sharePanelViewModel2 = sharePanelViewModel;
                    SharePanelViewKt.SharePanelContentView(panelConfig2, shareElementVR7, shareElementVR8, new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.SharePanelViewKt$SharePanelView$4.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(Boolean bool) {
                            Function0<Unit> function011;
                            boolean booleanValue2 = bool.booleanValue();
                            if (booleanValue2 && (function011 = function010) != null) {
                                function011.invoke();
                            }
                            sharePanelViewModel2.showPanel.setValue(Boolean.valueOf(!booleanValue2));
                            return Unit.INSTANCE;
                        }
                    }, function13, composer3, ((i3 >> 9) & 57344) | 584, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 918580736, 6, 2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final ShareElementVR shareElementVR7 = shareElementVR3;
        final ShareElementVR shareElementVR8 = shareElementVR4;
        final Function0<Unit> function010 = function04;
        final Function0<Unit> function011 = function05;
        final Function0<Unit> function012 = function06;
        final Function1<? super ShareItem, Unit> function14 = function12;
        final Function2<? super Composer, ? super Integer, Unit> function24 = function22;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.SharePanelViewKt$SharePanelView$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                SharePanelViewKt.SharePanelView(SharePanelViewModel.this, panelConfig, shareElementVR7, shareElementVR8, function010, function011, function012, function14, function24, composer2, i3 | 1, i16);
                return Unit.INSTANCE;
            }
        });
    }

    public static final ShareItem getShareItemSaveToMobile() {
        return ShareItemSaveToMobile;
    }

    public static final void SharePanelItemView(final i iVar, final ShareItem shareItem, final ShareElementVR shareElementVR, final Function0<Unit> function0, Composer composer, final int i3) {
        String str;
        e eVar;
        e eVar2;
        Composer startRestartGroup = composer.startRestartGroup(-831778331);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-831778331, i3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.SharePanelItemView (SharePanelView.kt:177)");
        }
        if (shareElementVR == null || (str = shareElementVR.elementId) == null) {
            str = "";
        }
        if (shareElementVR == null || (eVar2 = shareElementVR.elementParams) == null) {
            eVar = null;
        } else {
            eVar = new e(eVar2.toString());
            int i16 = shareItem.action;
            int i17 = 2;
            if (i16 != 2) {
                if (i16 == 3) {
                    i17 = 1;
                } else if (i16 != 9) {
                    if (i16 == 10) {
                        i17 = 3;
                    } else if (i16 == 39) {
                        i17 = 5;
                    } else if (i16 == 218) {
                        i17 = 4;
                    }
                }
                eVar.t("share_source", i17);
                Unit unit = Unit.INSTANCE;
            }
            i17 = 0;
            eVar.t("share_source", i17);
            Unit unit2 = Unit.INSTANCE;
        }
        ColumnKt.a(ModifierExtKt.elementVR$default(iVar, str, eVar, String.valueOf(shareItem.hashCode())), null, Alignment.Horizontal.CenterHorizontally, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1670487836, true, new Function3<d, Composer, Integer, Unit>(function0, i3, shareItem) { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.SharePanelViewKt$SharePanelItemView$3
            public final /* synthetic */ Function0<Unit> $onItemClick;
            public final /* synthetic */ ShareItem $shareItem;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
                this.$shareItem = shareItem;
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(d dVar, Composer composer2, Integer num) {
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1670487836, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.SharePanelItemView.<anonymous> (SharePanelView.kt:194)");
                    }
                    i.Companion companion = i.INSTANCE;
                    i c16 = ModifiersKt.c(ModifiersKt.j(ComposeLayoutPropUpdaterKt.v(companion, 52.0f, 52.0f), 26.0f), QUIToken.color$default("fill_standard_primary"));
                    final Function0<Unit> function02 = this.$onItemClick;
                    composer3.startReplaceableGroup(1157296644);
                    boolean changed = composer3.changed(function02);
                    Object rememberedValue = composer3.rememberedValue();
                    if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.SharePanelViewKt$SharePanelItemView$3$1$1
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
                    i d16 = ViewEventPropUpdaterKt.d(c16, false, null, (Function1) rememberedValue, 3, null);
                    final ShareItem shareItem2 = this.$shareItem;
                    BoxKt.a(d16, null, null, ComposableLambdaKt.composableLambda(composer3, 154280482, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.SharePanelViewKt$SharePanelItemView$3.2
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer4, Integer num2) {
                            int i18;
                            com.tencent.ntcompose.foundation.layout.b bVar2 = bVar;
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 14) == 0) {
                                i18 = (composer5.changed(bVar2) ? 4 : 2) | intValue2;
                            } else {
                                i18 = intValue2;
                            }
                            if ((i18 & 91) == 18 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(154280482, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.SharePanelItemView.<anonymous>.<anonymous> (SharePanelView.kt:202)");
                                }
                                i a16 = bVar2.a(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 24.0f), Alignment.Center);
                                ShareItem shareItem3 = ShareItem.this;
                                ImageKt.a(null, null, null, null, null, a16, null, 0, null, null, shareItem3.icon, null, null, null, null, null, null, null, null, shareItem3.imageTintColor, null, composer5, 262144, 1073741824, 0, 1571807);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 3080, 6);
                    i n3 = ComposeLayoutPropUpdaterKt.n(companion, 0.0f, 8.0f, 0.0f, 0.0f, 13, null);
                    final Function0<Unit> function03 = this.$onItemClick;
                    composer3.startReplaceableGroup(1157296644);
                    boolean changed2 = composer3.changed(function03);
                    Object rememberedValue2 = composer3.rememberedValue();
                    if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue2 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.SharePanelViewKt$SharePanelItemView$3$3$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ClickParams clickParams) {
                                function03.invoke();
                                return Unit.INSTANCE;
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue2);
                    }
                    composer3.endReplaceableGroup();
                    i d17 = ViewEventPropUpdaterKt.d(n3, false, null, (Function1) rememberedValue2, 3, null);
                    TextKt.a(this.$shareItem.text, d17, null, QUIToken.color$default("text_primary"), Float.valueOf(10.0f), null, new c(400), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, 28736, 0, 0, 134217636);
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
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.SharePanelViewKt$SharePanelItemView$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                SharePanelViewKt.SharePanelItemView(i.this, shareItem, shareElementVR, function0, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void SharePanelContentView(final PanelConfig panelConfig, ShareElementVR shareElementVR, ShareElementVR shareElementVR2, final Function1<? super Boolean, Unit> function1, Function1<? super ShareItem, Unit> function12, Composer composer, final int i3, final int i16) {
        String str;
        Composer startRestartGroup = composer.startRestartGroup(384269017);
        ShareElementVR shareElementVR3 = (i16 & 2) != 0 ? null : shareElementVR;
        ShareElementVR shareElementVR4 = (i16 & 4) != 0 ? null : shareElementVR2;
        Function1<? super ShareItem, Unit> function13 = (i16 & 16) != 0 ? null : function12;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(384269017, i3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.SharePanelContentView (SharePanelView.kt:86)");
        }
        i c16 = ModifiersKt.c(ModifiersKt.l(ComposeLayoutPropUpdaterKt.k(ModifiersKt.b(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 1.0f), (com.tencent.ntcompose.activity.b.a().getPageData().getIsIphoneX() ? 34.0f : 0.0f) + 266.0f), new f(8.0f, 8.0f, 0.0f, 0.0f)), QUIToken.color$default("bg_middle_light"));
        if (shareElementVR3 == null || (str = shareElementVR3.elementId) == null) {
            str = "";
        }
        final Function1<? super ShareItem, Unit> function14 = function13;
        final ShareElementVR shareElementVR5 = shareElementVR4;
        ColumnKt.a(ModifierExtKt.pageVR(c16, str, shareElementVR3 != null ? shareElementVR3.elementParams : null), null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 694625794, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.SharePanelViewKt$SharePanelContentView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                        ComposerKt.traceEventStart(694625794, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.SharePanelContentView.<anonymous> (SharePanelView.kt:99)");
                    }
                    i.Companion companion = i.INSTANCE;
                    RowKt.a(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null), 36.0f), a.f339245a.e(), Alignment.Vertical.Bottom, null, null, ComposableLambdaKt.composableLambda(composer3, 1353655328, true, new Function3<n, Composer, Integer, Unit>(function1, i3) { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.SharePanelViewKt$SharePanelContentView$1.1
                        public final /* synthetic */ Function1<Boolean, Unit> $setHidden;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(n nVar, Composer composer4, Integer num2) {
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1353655328, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.SharePanelContentView.<anonymous>.<anonymous> (SharePanelView.kt:104)");
                                }
                                i.Companion companion2 = i.INSTANCE;
                                TextKt.a("\u5206\u4eab\u5230", ComposeLayoutPropUpdaterKt.n(companion2, 16.0f, 0.0f, 0.0f, 0.0f, 14, null), null, QUIToken.color$default("text_primary"), Float.valueOf(14.0f), null, new c(500), new com.tencent.ntcompose.material.n("PingFangSC"), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer5, (com.tencent.ntcompose.material.n.f339436b << 21) | 28742, 0, 0, 134217508);
                                i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(companion2, 20.0f), 0.0f, 0.0f, 16.0f, 0.0f, 11, null);
                                final Function1<Boolean, Unit> function15 = this.$setHidden;
                                composer5.startReplaceableGroup(1157296644);
                                boolean changed = composer5.changed(function15);
                                Object rememberedValue = composer5.rememberedValue();
                                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.SharePanelViewKt$SharePanelContentView$1$1$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ClickParams clickParams) {
                                            function15.invoke(Boolean.TRUE);
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    composer5.updateRememberedValue(rememberedValue);
                                }
                                composer5.endReplaceableGroup();
                                ButtonKt.a(null, (Function1) rememberedValue, n3, null, ComposableSingletons$SharePanelViewKt.f115lambda1, composer5, 25088, 9);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 197064, 24);
                    composer3.startReplaceableGroup(1157372668);
                    if (!PanelConfig.this.topItems.isEmpty()) {
                        SharePanelViewKt.SharePanelItemViewRow(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null), 74.0f), 0.0f, 28.0f, 0.0f, 0.0f, 13, null), PanelConfig.this.topItems, function14, shareElementVR5, composer3, ((i3 >> 6) & 896) | 4168, 0);
                    }
                    composer3.endReplaceableGroup();
                    if (!PanelConfig.this.bottomItems.isEmpty()) {
                        SharePanelViewKt.SharePanelItemViewRow(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null), 74.0f), 0.0f, 28.0f, 0.0f, 0.0f, 13, null), PanelConfig.this.bottomItems, function14, shareElementVR5, composer3, ((i3 >> 6) & 896) | 4168, 0);
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
        final ShareElementVR shareElementVR6 = shareElementVR3;
        final ShareElementVR shareElementVR7 = shareElementVR4;
        final Function1<? super ShareItem, Unit> function15 = function13;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.SharePanelViewKt$SharePanelContentView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                SharePanelViewKt.SharePanelContentView(PanelConfig.this, shareElementVR6, shareElementVR7, function1, function15, composer2, i3 | 1, i16);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void SharePanelItemViewRow(final i iVar, final List<ShareItem> list, final Function1<? super ShareItem, Unit> function1, ShareElementVR shareElementVR, Composer composer, final int i3, final int i16) {
        Composer startRestartGroup = composer.startRestartGroup(-2083674868);
        final ShareElementVR shareElementVR2 = (i16 & 8) != 0 ? null : shareElementVR;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2083674868, i3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.SharePanelItemViewRow (SharePanelView.kt:145)");
        }
        final ShareElementVR shareElementVR3 = shareElementVR2;
        LazyRowKt.a(iVar, null, null, null, null, null, null, Boolean.FALSE, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1755219499, true, new Function3<com.tencent.ntcompose.foundation.lazy.layout.a, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.SharePanelViewKt$SharePanelItemViewRow$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(com.tencent.ntcompose.foundation.lazy.layout.a aVar, Composer composer2, Integer num) {
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1755219499, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.SharePanelItemViewRow.<anonymous> (SharePanelView.kt:154)");
                }
                for (final ShareItem shareItem : list) {
                    i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.v(i.INSTANCE, 52.0f, 74.0f), 16.0f, 0.0f, 0.0f, 0.0f, 14, null);
                    ShareElementVR shareElementVR4 = shareElementVR2;
                    final Function1<ShareItem, Unit> function12 = function1;
                    SharePanelViewKt.SharePanelItemView(n3, shareItem, shareElementVR4, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.SharePanelViewKt$SharePanelItemViewRow$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Unit invoke() {
                            ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("click item: "), ShareItem.this.action, KLog.INSTANCE, "SharePanelView");
                            ShareItem shareItem2 = ShareItem.this;
                            Function0<Unit> function0 = shareItem2.onClick;
                            if (function0 != null) {
                                function0.invoke();
                            } else {
                                Function1<ShareItem, Unit> function13 = function12;
                                if (function13 != null) {
                                    function13.invoke(shareItem2);
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }, composer3, 584);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 12582920, 0, MsgConstant.KRMFILETHUMBSIZE384, 4194174);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.SharePanelViewKt$SharePanelItemViewRow$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                SharePanelViewKt.SharePanelItemViewRow(i.this, list, function1, shareElementVR3, composer2, i3 | 1, i16);
                return Unit.INSTANCE;
            }
        });
    }
}
