package com.tencent.hippykotlin.demo.pages.nearby.public_account.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.c;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.hippykotlin.demo.pages.base.QUISkinImage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QQAnimatedImageKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.modifer_ext.ModifierExtKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView$body$1$1$3$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.public_account.vm.QQStrangerPAMoodCardVM;
import com.tencent.hippykotlin.demo.pages.nearby.public_account.vm.QQStrangerPublicAccountViewModel;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import o35.h;

/* loaded from: classes31.dex */
public final class QQStrangerPAMoodCardViewKt {
    public static final void QQStrangerPAMoodCardView(final QQStrangerPAMoodCardVM qQStrangerPAMoodCardVM, final i iVar, final h hVar, final QQStrangerPublicAccountViewModel qQStrangerPublicAccountViewModel, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-1379652076);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1379652076, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPAMoodCardView (QQStrangerPAMoodCardView.kt:35)");
        }
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(hVar != null ? hVar.D : false), null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState mutableState = (MutableState) rememberedValue;
        BoxKt.a(ViewEventPropUpdaterKt.d(ModifiersKt.j(ModifiersKt.c(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(iVar, GoodsCenterProductView$body$1$1$3$$ExternalSyntheticOutline0.m(c.f117352a) - (2 * 6.0f)), 104.0f), QUIToken.color$default("fill_standard_primary")), 8.0f), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPAMoodCardViewKt$QQStrangerPAMoodCardView$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ClickParams clickParams) {
                String str;
                List split$default;
                List<String> split$default2;
                int collectionSizeOrDefault;
                String joinToString$default;
                String str2;
                boolean startsWith$default;
                h hVar2 = h.this;
                if (hVar2 != null && (str = hVar2.f421915m) != null) {
                    split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER}, false, 0, 6, (Object) null);
                    if (split$default.size() != 2) {
                        str2 = str;
                    } else {
                        String str3 = (String) split$default.get(0);
                        split$default2 = StringsKt__StringsKt.split$default((CharSequence) split$default.get(1), new String[]{ContainerUtils.FIELD_DELIMITER}, false, 0, 6, (Object) null);
                        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(split$default2, 10);
                        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                        for (String str4 : split$default2) {
                            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str4, "auto_jump=", false, 2, null);
                            if (startsWith$default) {
                                str4 = "auto_jump=0";
                            }
                            arrayList.add(str4);
                        }
                        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ContainerUtils.FIELD_DELIMITER, null, null, 0, null, null, 62, null);
                        str2 = str3 + '?' + joinToString$default;
                    }
                    KLog.INSTANCE.i("QQStrangerPAMoodCard", QUISkinImage$$ExternalSyntheticOutline0.m(" original url: ", str, ", modifiedUrl: ", str2));
                    QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                    QQKuiklyPlatformApi.Companion.openPage$default(str2, false, 6);
                }
                return Unit.INSTANCE;
            }
        }, 3, null), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 2129393870, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPAMoodCardViewKt$QQStrangerPAMoodCardView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(b bVar, Composer composer2, Integer num) {
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2129393870, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPAMoodCardView.<anonymous> (QQStrangerPAMoodCardView.kt:56)");
                    }
                    i.Companion companion = i.INSTANCE;
                    i D = ModifiersKt.D(ComposeLayoutPropUpdaterKt.h(companion, 0.0f, 1, null), c.f117352a.g().isNightMode() ? 0.3f : 1.0f);
                    h hVar2 = h.this;
                    ImageKt.a(hVar2 != null ? hVar2.f421914i : null, null, null, null, null, D, null, com.tencent.ntcompose.material.h.INSTANCE.b(), null, null, null, null, null, null, null, null, null, null, null, null, null, composer3, 12845056, 0, 0, 2096990);
                    i s16 = ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.h(companion, 0.0f, 1, null), 13.0f, 0.0f, 0.0f, 0.0f, 14, null);
                    Alignment.Vertical c16 = Alignment.INSTANCE.c();
                    final h hVar3 = h.this;
                    final MutableState<Boolean> mutableState2 = mutableState;
                    final QQStrangerPAMoodCardVM qQStrangerPAMoodCardVM2 = qQStrangerPAMoodCardVM;
                    final QQStrangerPublicAccountViewModel qQStrangerPublicAccountViewModel2 = qQStrangerPublicAccountViewModel;
                    RowKt.a(s16, null, c16, null, null, ComposableLambdaKt.composableLambda(composer3, -825136020, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPAMoodCardViewKt$QQStrangerPAMoodCardView$2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(n nVar, Composer composer4, Integer num2) {
                            int i16;
                            String str;
                            com.tencent.kuikly.core.base.h color$default;
                            n nVar2 = nVar;
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 14) == 0) {
                                i16 = (composer5.changed(nVar2) ? 4 : 2) | intValue2;
                            } else {
                                i16 = intValue2;
                            }
                            if ((i16 & 91) == 18 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-825136020, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPAMoodCardView.<anonymous>.<anonymous> (QQStrangerPAMoodCardView.kt:68)");
                                }
                                h hVar4 = h.this;
                                if (hVar4 == null || (str = hVar4.C) == null) {
                                    str = "";
                                }
                                i iVar2 = i.INSTANCE;
                                QQAnimatedImageKt.QQAnimatedImage(str, ComposeLayoutPropUpdaterKt.v(iVar2, 100.0f, 100.0f), false, null, composer5, 64, 12);
                                i s17 = ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.A(iVar2), 4.0f, 0.0f, 0.0f, 0.0f, 14, null);
                                final h hVar5 = h.this;
                                ColumnKt.a(s17, null, null, null, ComposableLambdaKt.composableLambda(composer5, -472661867, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPAMoodCardViewKt.QQStrangerPAMoodCardView.2.1.1
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(d dVar, Composer composer6, Integer num3) {
                                        Composer composer7 = composer6;
                                        int intValue3 = num3.intValue();
                                        if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                            composer7.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-472661867, intValue3, -1, "com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPAMoodCardView.<anonymous>.<anonymous>.<anonymous> (QQStrangerPAMoodCardView.kt:75)");
                                            }
                                            i.Companion companion2 = i.INSTANCE;
                                            i A = ComposeLayoutPropUpdaterKt.A(companion2);
                                            c.Companion companion3 = bp3.c.INSTANCE;
                                            bp3.c f16 = companion3.f();
                                            com.tencent.kuikly.core.base.h color$default2 = QUIToken.color$default("text_primary");
                                            h hVar6 = h.this;
                                            TextKt.a(hVar6 != null ? hVar6.f421912f : null, A, null, color$default2, Float.valueOf(16.0f), null, f16, null, null, null, null, Float.valueOf(22.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer7, 1601600, 48, 0, 134215588);
                                            i s18 = ComposeLayoutPropUpdaterKt.s(companion2, 0.0f, 2.0f, 0.0f, 0.0f, 13, null);
                                            bp3.c e16 = companion3.e();
                                            com.tencent.kuikly.core.base.h color$default3 = QUIToken.color$default("text_secondary");
                                            h hVar7 = h.this;
                                            TextKt.a(hVar7 != null ? hVar7.f421913h : null, s18, null, color$default3, Float.valueOf(12.0f), null, e16, null, null, null, null, Float.valueOf(20.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer7, 1601600, 48, 0, 134215588);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer5, 24584, 14);
                                ColumnKt.a(nVar2.a(ComposeLayoutPropUpdaterKt.z(iVar2), 1.0f), null, null, null, ComposableSingletons$QQStrangerPAMoodCardViewKt.f90lambda1, composer5, 24584, 14);
                                i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.v(iVar2, 74.0f, 29.0f), 0.0f, 0.0f, 16.0f, 0.0f, 11, null);
                                if (mutableState2.getValue().booleanValue()) {
                                    color$default = new com.tencent.kuikly.core.base.h(4291611852L);
                                } else {
                                    color$default = QUIToken.color$default("button_bg_primary_default");
                                }
                                i j3 = ModifiersKt.j(ModifiersKt.d(n3, color$default), 4.0f);
                                if (!qQStrangerPAMoodCardVM2.isFromCache) {
                                    iVar2 = ModifierExtKt.elementVR(iVar2, "em_nearby_kl_join_pray_btn", qQStrangerPublicAccountViewModel2.getDtReportBaseParams());
                                }
                                i b16 = j3.b(iVar2);
                                final QQStrangerPublicAccountViewModel qQStrangerPublicAccountViewModel3 = qQStrangerPublicAccountViewModel2;
                                final MutableState<Boolean> mutableState3 = mutableState2;
                                final h hVar6 = h.this;
                                i d16 = ViewEventPropUpdaterKt.d(b16, false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPAMoodCardViewKt.QQStrangerPAMoodCardView.2.1.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        String str2;
                                        if (!QQStrangerPublicAccountViewModel.this.visitor) {
                                            mutableState3.setValue(Boolean.TRUE);
                                        }
                                        h hVar7 = hVar6;
                                        if (hVar7 != null && (str2 = hVar7.f421915m) != null) {
                                            QQKuiklyPlatformApi.Companion companion2 = QQKuiklyPlatformApi.Companion;
                                            QQKuiklyPlatformApi.Companion.openPage$default(str2, false, 6);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }, 3, null);
                                Alignment alignment = Alignment.Center;
                                final h hVar7 = h.this;
                                final MutableState<Boolean> mutableState4 = mutableState2;
                                BoxKt.a(d16, alignment, null, ComposableLambdaKt.composableLambda(composer5, 1291283494, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPAMoodCardViewKt.QQStrangerPAMoodCardView.2.1.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(b bVar2, Composer composer6, Integer num3) {
                                        String str2;
                                        boolean startsWith$default;
                                        String removePrefix;
                                        Composer composer7 = composer6;
                                        int intValue3 = num3.intValue();
                                        if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                            composer7.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1291283494, intValue3, -1, "com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPAMoodCardView.<anonymous>.<anonymous>.<anonymous> (QQStrangerPAMoodCardView.kt:112)");
                                            }
                                            h hVar8 = h.this;
                                            if (hVar8 == null || (str2 = hVar8.f421911e) == null) {
                                                str2 = "";
                                            }
                                            if (mutableState4.getValue().booleanValue()) {
                                                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str2, "\u52a0\u5165", false, 2, null);
                                                if (startsWith$default) {
                                                    StringBuilder sb5 = new StringBuilder();
                                                    removePrefix = StringsKt__StringsKt.removePrefix(str2, (CharSequence) "\u52a0\u5165");
                                                    sb5.append(removePrefix);
                                                    sb5.append('\u4e2d');
                                                    str2 = sb5.toString();
                                                }
                                            }
                                            TextKt.a(str2, null, null, QUIToken.color$default("button_text_primary_default"), Float.valueOf(14.0f), null, bp3.c.INSTANCE.e(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer7, 1601536, 0, 0, 134217638);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer5, 3128, 4);
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
        }), startRestartGroup, 3080, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPAMoodCardViewKt$QQStrangerPAMoodCardView$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQStrangerPAMoodCardViewKt.QQStrangerPAMoodCardView(QQStrangerPAMoodCardVM.this, iVar, hVar, qQStrangerPublicAccountViewModel, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
