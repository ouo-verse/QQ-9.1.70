package com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.channel;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import ap3.a;
import bp3.c;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.GuideBannerCardAnimationViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.TextViewExtKt;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import l25.d;
import l25.e;
import l25.f;
import l25.g;
import l25.h;
import l25.i;
import l25.j;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ChannelFeedItemViewKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ChannelFeedItemView(final ChannelFeedItemViewModel channelFeedItemViewModel, Composer composer, final int i3) {
        Object firstOrNull;
        final f fVar;
        String str;
        j jVar;
        ScopeUpdateScope endRestartGroup;
        d dVar;
        String str2;
        List<h> list;
        Object firstOrNull2;
        i iVar;
        String str3;
        List<f> list2;
        Object firstOrNull3;
        Composer startRestartGroup = composer.startRestartGroup(-76922780);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-76922780, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.channel.ChannelFeedItemView (ChannelFeedItemView.kt:38)");
        }
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = GuideBannerCardAnimationViewKt$$ExternalSyntheticOutline0.m(0.0f, null, 2, null, startRestartGroup);
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState mutableState = (MutableState) rememberedValue;
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) channelFeedItemViewModel.feed.f413748i);
        e eVar = (e) firstOrNull;
        if (eVar == null || (list2 = eVar.f413754h) == null) {
            fVar = null;
        } else {
            firstOrNull3 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list2);
            fVar = (f) firstOrNull3;
        }
        g gVar = channelFeedItemViewModel.feed.f413745e;
        final String str4 = "";
        if (gVar != null && (list = gVar.f413762d) != null) {
            firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
            h hVar = (h) firstOrNull2;
            if (hVar != null && (iVar = hVar.f413766f) != null && (str3 = iVar.f413767d) != null) {
                str = str3;
                jVar = channelFeedItemViewModel.feed.f413747h;
                if (jVar != null && (dVar = jVar.f413770f) != null && (str2 = dVar.f413750d) != null) {
                    str4 = str2;
                }
                if (jVar != null || (r0 = jVar.f413769e) == null) {
                    String str5 = "\u9891\u9053\u7528\u6237";
                }
                final String str6 = str5;
                final String str7 = str;
                ColumnKt.a(ViewEventPropUpdaterKt.d(ModifiersKt.D(ViewEventPropUpdaterKt.l(ModifiersKt.p(ModifiersKt.j(ComposeLayoutPropUpdaterKt.z(ComposeLayoutPropUpdaterKt.j(ModifiersKt.c(com.tencent.ntcompose.core.i.INSTANCE, QUIToken.color$default("fill_light_secondary")), 0.0f, 1, null)), 4.0f), new com.tencent.kuikly.core.base.g(0.0f, 3.0f, 15.0f, com.tencent.kuikly.core.base.h.INSTANCE.a(0.08f))), new Function1<a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.channel.ChannelFeedItemViewKt$ChannelFeedItemView$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(a aVar) {
                        a aVar2 = aVar;
                        mutableState.setValue(Float.valueOf(aVar2.getWidth()));
                        ChannelFeedItemViewModel.this.offsetY = aVar2.getY();
                        return Unit.INSTANCE;
                    }
                }), ((Number) mutableState.getValue()).floatValue() > 0.0f ? 1.0f : 0.0f), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.channel.ChannelFeedItemViewKt$ChannelFeedItemView$2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ClickParams clickParams) {
                        ChannelFeedItemViewModel channelFeedItemViewModel2 = ChannelFeedItemViewModel.this;
                        channelFeedItemViewModel2.onClick.invoke(channelFeedItemViewModel2.feed);
                        return Unit.INSTANCE;
                    }
                }, 3, null), null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -976155443, true, new Function3<com.tencent.ntcompose.foundation.layout.d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.channel.ChannelFeedItemViewKt$ChannelFeedItemView$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public final Unit invoke(com.tencent.ntcompose.foundation.layout.d dVar2, Composer composer2, Integer num) {
                        float floatValue;
                        float floatValue2;
                        Composer composer3 = composer2;
                        int intValue = num.intValue();
                        if ((intValue & 81) == 16 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                        } else {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-976155443, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.channel.ChannelFeedItemView.<anonymous> (ChannelFeedItemView.kt:56)");
                            }
                            floatValue = ((Number) mutableState.getValue()).floatValue();
                            if (floatValue <= 0.0f) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            } else {
                                i.Companion companion = com.tencent.ntcompose.core.i.INSTANCE;
                                final ChannelFeedItemViewModel channelFeedItemViewModel2 = channelFeedItemViewModel;
                                BoxKt.a(ViewEventPropUpdaterKt.g(companion, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.channel.ChannelFeedItemViewKt$ChannelFeedItemView$3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Object obj) {
                                        ChannelFeedItemViewModel channelFeedItemViewModel3 = ChannelFeedItemViewModel.this;
                                        channelFeedItemViewModel3.onExpose.invoke(channelFeedItemViewModel3.feed, Float.valueOf(channelFeedItemViewModel3.offsetY));
                                        return Unit.INSTANCE;
                                    }
                                }), null, null, ComposableSingletons$ChannelFeedItemViewKt.f61lambda1, composer3, 3080, 6);
                                final f fVar2 = f.this;
                                composer3.startReplaceableGroup(-2138631502);
                                if (fVar2 != null) {
                                    MutableState<Float> mutableState2 = mutableState;
                                    floatValue2 = ((Number) mutableState2.getValue()).floatValue();
                                    BoxKt.a(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion, mutableState2.getValue().floatValue()), Math.min((floatValue2 / fVar2.f413759f) * fVar2.f413760h, mutableState2.getValue().floatValue() * 1.4f)), null, null, ComposableLambdaKt.composableLambda(composer3, 1539309961, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.channel.ChannelFeedItemViewKt$ChannelFeedItemView$3$2$1
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
                                                    ComposerKt.traceEventStart(1539309961, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.channel.ChannelFeedItemView.<anonymous>.<anonymous>.<anonymous> (ChannelFeedItemView.kt:70)");
                                                }
                                                ImageKt.a(f.this.f413758e, null, null, null, null, ComposeLayoutPropUpdaterKt.h(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, 1, null), null, com.tencent.ntcompose.material.h.INSTANCE.a(), null, null, null, null, null, null, null, null, null, null, null, null, null, composer5, 12845056, 0, 0, 2096990);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer3, 3080, 6);
                                    Unit unit = Unit.INSTANCE;
                                }
                                composer3.endReplaceableGroup();
                                TextKt.a(TextViewExtKt.fixLineHeightForView(str7), ComposeLayoutPropUpdaterKt.m(companion, 10.0f, 9.0f, 10.0f, 10.0f), null, QUIToken.color$default("text_primary"), Float.valueOf(14.0f), null, c.INSTANCE.f(), null, null, null, null, Float.valueOf(21.0f), null, null, null, null, null, null, 2, null, null, null, "emoji", null, null, null, false, composer3, 1601600, 100663344, MsgConstant.KRMFILETHUMBSIZE384, 129759140);
                                com.tencent.ntcompose.core.i m3 = ComposeLayoutPropUpdaterKt.m(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null), 16.0f), 10.0f, 0.0f, 10.0f, 10.0f);
                                Alignment.Vertical c16 = Alignment.INSTANCE.c();
                                final String str8 = str4;
                                final String str9 = str6;
                                RowKt.a(m3, null, c16, null, null, ComposableLambdaKt.composableLambda(composer3, -841780117, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.channel.ChannelFeedItemViewKt$ChannelFeedItemView$3.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                                ComposerKt.traceEventStart(-841780117, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.channel.ChannelFeedItemView.<anonymous>.<anonymous> (ChannelFeedItemView.kt:97)");
                                            }
                                            ImageKt.a(str8, null, null, null, null, ComposeLayoutPropUpdaterKt.n(ModifiersKt.j(ComposeLayoutPropUpdaterKt.u(com.tencent.ntcompose.core.i.INSTANCE, 16.0f), 3.0f), 0.0f, 0.0f, 3.0f, 0.0f, 11, null), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer5, 262144, 0, 0, 2097118);
                                            TextKt.a(TextViewExtKt.fixLineHeightForView(str9), null, null, QUIToken.color$default("text_secondary"), Float.valueOf(12.0f), null, c.INSTANCE.e(), null, null, null, null, Float.valueOf(12.0f), null, null, null, null, null, null, 1, null, null, null, "emoji", null, null, null, false, composer5, 1601536, 100663344, MsgConstant.KRMFILETHUMBSIZE384, 129759142);
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
                        }
                        return Unit.INSTANCE;
                    }
                }), startRestartGroup, 24584, 14);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    return;
                }
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.channel.ChannelFeedItemViewKt$ChannelFeedItemView$4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Unit invoke(Composer composer2, Integer num) {
                        num.intValue();
                        ChannelFeedItemViewKt.ChannelFeedItemView(ChannelFeedItemViewModel.this, composer2, i3 | 1);
                        return Unit.INSTANCE;
                    }
                });
                return;
            }
        }
        str = "";
        jVar = channelFeedItemViewModel.feed.f413747h;
        if (jVar != null) {
            str4 = str2;
        }
        if (jVar != null) {
        }
        String str52 = "\u9891\u9053\u7528\u6237";
        final String str62 = str52;
        final String str72 = str;
        ColumnKt.a(ViewEventPropUpdaterKt.d(ModifiersKt.D(ViewEventPropUpdaterKt.l(ModifiersKt.p(ModifiersKt.j(ComposeLayoutPropUpdaterKt.z(ComposeLayoutPropUpdaterKt.j(ModifiersKt.c(com.tencent.ntcompose.core.i.INSTANCE, QUIToken.color$default("fill_light_secondary")), 0.0f, 1, null)), 4.0f), new com.tencent.kuikly.core.base.g(0.0f, 3.0f, 15.0f, com.tencent.kuikly.core.base.h.INSTANCE.a(0.08f))), new Function1<a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.channel.ChannelFeedItemViewKt$ChannelFeedItemView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(a aVar) {
                a aVar2 = aVar;
                mutableState.setValue(Float.valueOf(aVar2.getWidth()));
                ChannelFeedItemViewModel.this.offsetY = aVar2.getY();
                return Unit.INSTANCE;
            }
        }), ((Number) mutableState.getValue()).floatValue() > 0.0f ? 1.0f : 0.0f), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.channel.ChannelFeedItemViewKt$ChannelFeedItemView$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ClickParams clickParams) {
                ChannelFeedItemViewModel channelFeedItemViewModel2 = ChannelFeedItemViewModel.this;
                channelFeedItemViewModel2.onClick.invoke(channelFeedItemViewModel2.feed);
                return Unit.INSTANCE;
            }
        }, 3, null), null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -976155443, true, new Function3<com.tencent.ntcompose.foundation.layout.d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.channel.ChannelFeedItemViewKt$ChannelFeedItemView$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(com.tencent.ntcompose.foundation.layout.d dVar2, Composer composer2, Integer num) {
                float floatValue;
                float floatValue2;
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-976155443, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.channel.ChannelFeedItemView.<anonymous> (ChannelFeedItemView.kt:56)");
                    }
                    floatValue = ((Number) mutableState.getValue()).floatValue();
                    if (floatValue <= 0.0f) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    } else {
                        i.Companion companion = com.tencent.ntcompose.core.i.INSTANCE;
                        final ChannelFeedItemViewModel channelFeedItemViewModel2 = channelFeedItemViewModel;
                        BoxKt.a(ViewEventPropUpdaterKt.g(companion, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.channel.ChannelFeedItemViewKt$ChannelFeedItemView$3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(Object obj) {
                                ChannelFeedItemViewModel channelFeedItemViewModel3 = ChannelFeedItemViewModel.this;
                                channelFeedItemViewModel3.onExpose.invoke(channelFeedItemViewModel3.feed, Float.valueOf(channelFeedItemViewModel3.offsetY));
                                return Unit.INSTANCE;
                            }
                        }), null, null, ComposableSingletons$ChannelFeedItemViewKt.f61lambda1, composer3, 3080, 6);
                        final f fVar2 = f.this;
                        composer3.startReplaceableGroup(-2138631502);
                        if (fVar2 != null) {
                            MutableState<Float> mutableState2 = mutableState;
                            floatValue2 = ((Number) mutableState2.getValue()).floatValue();
                            BoxKt.a(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion, mutableState2.getValue().floatValue()), Math.min((floatValue2 / fVar2.f413759f) * fVar2.f413760h, mutableState2.getValue().floatValue() * 1.4f)), null, null, ComposableLambdaKt.composableLambda(composer3, 1539309961, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.channel.ChannelFeedItemViewKt$ChannelFeedItemView$3$2$1
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
                                            ComposerKt.traceEventStart(1539309961, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.channel.ChannelFeedItemView.<anonymous>.<anonymous>.<anonymous> (ChannelFeedItemView.kt:70)");
                                        }
                                        ImageKt.a(f.this.f413758e, null, null, null, null, ComposeLayoutPropUpdaterKt.h(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, 1, null), null, com.tencent.ntcompose.material.h.INSTANCE.a(), null, null, null, null, null, null, null, null, null, null, null, null, null, composer5, 12845056, 0, 0, 2096990);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                    return Unit.INSTANCE;
                                }
                            }), composer3, 3080, 6);
                            Unit unit = Unit.INSTANCE;
                        }
                        composer3.endReplaceableGroup();
                        TextKt.a(TextViewExtKt.fixLineHeightForView(str72), ComposeLayoutPropUpdaterKt.m(companion, 10.0f, 9.0f, 10.0f, 10.0f), null, QUIToken.color$default("text_primary"), Float.valueOf(14.0f), null, c.INSTANCE.f(), null, null, null, null, Float.valueOf(21.0f), null, null, null, null, null, null, 2, null, null, null, "emoji", null, null, null, false, composer3, 1601600, 100663344, MsgConstant.KRMFILETHUMBSIZE384, 129759140);
                        com.tencent.ntcompose.core.i m3 = ComposeLayoutPropUpdaterKt.m(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null), 16.0f), 10.0f, 0.0f, 10.0f, 10.0f);
                        Alignment.Vertical c16 = Alignment.INSTANCE.c();
                        final String str8 = str4;
                        final String str9 = str62;
                        RowKt.a(m3, null, c16, null, null, ComposableLambdaKt.composableLambda(composer3, -841780117, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.channel.ChannelFeedItemViewKt$ChannelFeedItemView$3.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                        ComposerKt.traceEventStart(-841780117, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.channel.ChannelFeedItemView.<anonymous>.<anonymous> (ChannelFeedItemView.kt:97)");
                                    }
                                    ImageKt.a(str8, null, null, null, null, ComposeLayoutPropUpdaterKt.n(ModifiersKt.j(ComposeLayoutPropUpdaterKt.u(com.tencent.ntcompose.core.i.INSTANCE, 16.0f), 3.0f), 0.0f, 0.0f, 3.0f, 0.0f, 11, null), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer5, 262144, 0, 0, 2097118);
                                    TextKt.a(TextViewExtKt.fixLineHeightForView(str9), null, null, QUIToken.color$default("text_secondary"), Float.valueOf(12.0f), null, c.INSTANCE.e(), null, null, null, null, Float.valueOf(12.0f), null, null, null, null, null, null, 1, null, null, null, "emoji", null, null, null, false, composer5, 1601536, 100663344, MsgConstant.KRMFILETHUMBSIZE384, 129759142);
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
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 24584, 14);
        if (ComposerKt.isTraceInProgress()) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}
