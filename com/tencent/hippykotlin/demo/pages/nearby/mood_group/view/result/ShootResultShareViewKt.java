package com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.c;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieAgreementConsentPage$onCreate$1$1$3$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AgreementConsentViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.RoleCardKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPLatLng;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPUserSelfInfo;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.NBPPublishConfig;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.NBPPublishService;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporterKt;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.NBPMoodGroupReportViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.result.NBPShootResultPageState;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.result.NBPShootResultViewModel;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.LoadSuccessParams;
import com.tencent.kuikly.core.views.v;
import com.tencent.ntcompose.animation.AnimateAsStateKt;
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
import com.tencent.ntcompose.material.ButtonKt;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.ai;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.ntcompose.material.h;
import com.tencent.ntcompose.ui.platform.CompositionLocalsKt;
import com.tencent.ntcompose.ui.platform.a;
import com.tencent.thumbplayer.core.codec.decoder.ITPMediaCodecDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import n25.k;
import s25.f;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ShootResultShareViewKt {
    public static final void access$DateView(final String str, Composer composer, final int i3) {
        int i16;
        final h b16;
        Composer startRestartGroup = composer.startRestartGroup(-706923106);
        if ((i3 & 14) == 0) {
            i16 = (startRestartGroup.changed(str) ? 4 : 2) | i3;
        } else {
            i16 = i3;
        }
        if ((i16 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-706923106, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.DateView (ShootResultShareView.kt:366)");
            }
            c cVar = c.f117352a;
            final String a16 = ((b) cVar.g().acquireModule("KRCalendarModule")).a(APICallTechReporterKt.NBPCurrentTime(), "dd");
            final String a17 = ((b) cVar.g().acquireModule("KRCalendarModule")).a(APICallTechReporterKt.NBPCurrentTime(), "M");
            if (Intrinsics.areEqual(str, "rose")) {
                b16 = h.INSTANCE.m();
            } else {
                b16 = h.INSTANCE.b();
            }
            RowKt.a(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.A(i.INSTANCE), 19.0f, 0.0f, 0.0f, 0.0f, 14, null), null, Alignment.INSTANCE.a(), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 502716604, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultShareViewKt$DateView$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
                /* JADX WARN: Failed to find 'out' block for switch in B:13:0x0094. Please report as an issue. */
                /* JADX WARN: Failed to find 'out' block for switch in B:14:0x0097. Please report as an issue. */
                /* JADX WARN: Removed duplicated region for block: B:20:0x017c  */
                @Override // kotlin.jvm.functions.Function3
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Unit invoke(n nVar, Composer composer2, Integer num) {
                    String str2;
                    Composer composer3 = composer2;
                    int intValue = num.intValue();
                    if ((intValue & 81) == 16 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                    } else {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(502716604, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.DateView.<anonymous> (ShootResultShareView.kt:373)");
                        }
                        c.Companion companion = bp3.c.INSTANCE;
                        TextKt.a(a16, null, null, b16, Float.valueOf(48.0f), null, companion.d(), null, null, null, null, Float.valueOf(80.8f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, 1601536, 48, 0, 134215590);
                        i n3 = ComposeLayoutPropUpdaterKt.n(i.INSTANCE, 0.0f, 0.0f, 0.0f, 17.0f, 7, null);
                        String str3 = a17;
                        int hashCode = str3.hashCode();
                        switch (hashCode) {
                            case 49:
                                if (str3.equals("1")) {
                                    str2 = "JAN";
                                    TextKt.a(str2, n3, null, b16, Float.valueOf(18.0f), null, companion.d(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, 1601600, 0, 0, 134217636);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        break;
                                    }
                                }
                                throw new IllegalArgumentException(AgreementConsentViewKt$$ExternalSyntheticOutline0.m("Invalid month number: ", str3));
                            case 50:
                                if (str3.equals("2")) {
                                    str2 = "FEB";
                                    TextKt.a(str2, n3, null, b16, Float.valueOf(18.0f), null, companion.d(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, 1601600, 0, 0, 134217636);
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                }
                                throw new IllegalArgumentException(AgreementConsentViewKt$$ExternalSyntheticOutline0.m("Invalid month number: ", str3));
                            case 51:
                                if (str3.equals("3")) {
                                    str2 = "MAR";
                                    TextKt.a(str2, n3, null, b16, Float.valueOf(18.0f), null, companion.d(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, 1601600, 0, 0, 134217636);
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                }
                                throw new IllegalArgumentException(AgreementConsentViewKt$$ExternalSyntheticOutline0.m("Invalid month number: ", str3));
                            case 52:
                                if (str3.equals("4")) {
                                    str2 = "APR";
                                    TextKt.a(str2, n3, null, b16, Float.valueOf(18.0f), null, companion.d(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, 1601600, 0, 0, 134217636);
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                }
                                throw new IllegalArgumentException(AgreementConsentViewKt$$ExternalSyntheticOutline0.m("Invalid month number: ", str3));
                            case 53:
                                if (str3.equals("5")) {
                                    str2 = "MAY";
                                    TextKt.a(str2, n3, null, b16, Float.valueOf(18.0f), null, companion.d(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, 1601600, 0, 0, 134217636);
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                }
                                throw new IllegalArgumentException(AgreementConsentViewKt$$ExternalSyntheticOutline0.m("Invalid month number: ", str3));
                            case 54:
                                if (str3.equals("6")) {
                                    str2 = "JUN";
                                    TextKt.a(str2, n3, null, b16, Float.valueOf(18.0f), null, companion.d(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, 1601600, 0, 0, 134217636);
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                }
                                throw new IllegalArgumentException(AgreementConsentViewKt$$ExternalSyntheticOutline0.m("Invalid month number: ", str3));
                            case 55:
                                if (str3.equals("7")) {
                                    str2 = "JUL";
                                    TextKt.a(str2, n3, null, b16, Float.valueOf(18.0f), null, companion.d(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, 1601600, 0, 0, 134217636);
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                }
                                throw new IllegalArgumentException(AgreementConsentViewKt$$ExternalSyntheticOutline0.m("Invalid month number: ", str3));
                            case 56:
                                if (str3.equals("8")) {
                                    str2 = "AUG";
                                    TextKt.a(str2, n3, null, b16, Float.valueOf(18.0f), null, companion.d(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, 1601600, 0, 0, 134217636);
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                }
                                throw new IllegalArgumentException(AgreementConsentViewKt$$ExternalSyntheticOutline0.m("Invalid month number: ", str3));
                            case 57:
                                if (str3.equals("9")) {
                                    str2 = "SEPT";
                                    TextKt.a(str2, n3, null, b16, Float.valueOf(18.0f), null, companion.d(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, 1601600, 0, 0, 134217636);
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                }
                                throw new IllegalArgumentException(AgreementConsentViewKt$$ExternalSyntheticOutline0.m("Invalid month number: ", str3));
                            default:
                                switch (hashCode) {
                                    case 1567:
                                        if (str3.equals("10")) {
                                            str2 = "OCT";
                                            TextKt.a(str2, n3, null, b16, Float.valueOf(18.0f), null, companion.d(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, 1601600, 0, 0, 134217636);
                                            if (ComposerKt.isTraceInProgress()) {
                                            }
                                        }
                                        throw new IllegalArgumentException(AgreementConsentViewKt$$ExternalSyntheticOutline0.m("Invalid month number: ", str3));
                                    case 1568:
                                        if (str3.equals("11")) {
                                            str2 = "NOV";
                                            TextKt.a(str2, n3, null, b16, Float.valueOf(18.0f), null, companion.d(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, 1601600, 0, 0, 134217636);
                                            if (ComposerKt.isTraceInProgress()) {
                                            }
                                        }
                                        throw new IllegalArgumentException(AgreementConsentViewKt$$ExternalSyntheticOutline0.m("Invalid month number: ", str3));
                                    case 1569:
                                        if (str3.equals("12")) {
                                            str2 = "DEC";
                                            TextKt.a(str2, n3, null, b16, Float.valueOf(18.0f), null, companion.d(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, 1601600, 0, 0, 134217636);
                                            if (ComposerKt.isTraceInProgress()) {
                                            }
                                        }
                                        throw new IllegalArgumentException(AgreementConsentViewKt$$ExternalSyntheticOutline0.m("Invalid month number: ", str3));
                                    default:
                                        throw new IllegalArgumentException(AgreementConsentViewKt$$ExternalSyntheticOutline0.m("Invalid month number: ", str3));
                                }
                        }
                    }
                    return Unit.INSTANCE;
                }
            }), startRestartGroup, 196616, 26);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultShareViewKt$DateView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                ShootResultShareViewKt.access$DateView(str, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void access$LuckView(final NBPShootResultViewModel nBPShootResultViewModel, Composer composer, final int i3) {
        final h b16;
        List split$default;
        int collectionSizeOrDefault;
        String replace$default;
        Composer startRestartGroup = composer.startRestartGroup(-767137482);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-767137482, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.LuckView (ShootResultShareView.kt:441)");
        }
        if (Intrinsics.areEqual(nBPShootResultViewModel.cardData.f444481i, "rose")) {
            b16 = h.INSTANCE.m();
        } else {
            b16 = h.INSTANCE.b();
        }
        split$default = StringsKt__StringsKt.split$default((CharSequence) nBPShootResultViewModel.cardData.f444479f, new String[]{" "}, false, 0, 6, (Object) null);
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(split$default, 10);
        final ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator it = split$default.iterator();
        while (it.hasNext()) {
            replace$default = StringsKt__StringsJVMKt.replace$default((String) it.next(), ":", "  ", false, 4, (Object) null);
            arrayList.add(replace$default);
        }
        ColumnKt.a(ComposeLayoutPropUpdaterKt.n(i.INSTANCE, 0.0f, 20.0f, 20.0f, 0.0f, 9, null), null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1893816787, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultShareViewKt$LuckView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        ComposerKt.traceEventStart(-1893816787, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.LuckView.<anonymous> (ShootResultShareView.kt:449)");
                    }
                    List<String> list = arrayList;
                    h hVar = b16;
                    for (String str : list) {
                        TextKt.a((char) 0 + str, ComposeLayoutPropUpdaterKt.B(i.INSTANCE), null, hVar, Float.valueOf(18.0f), null, bp3.c.INSTANCE.d(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, 1601600, 0, 0, 134217636);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultShareViewKt$LuckView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                ShootResultShareViewKt.access$LuckView(NBPShootResultViewModel.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void ShootResultShareView(final NBPShootResultViewModel nBPShootResultViewModel, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(170238084);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(170238084, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultShareView (ShootResultShareView.kt:63)");
        }
        i.Companion companion = i.INSTANCE;
        BoxKt.a(ViewEventPropUpdaterKt.g(ModifiersKt.T(ComposeLayoutPropUpdaterKt.f(ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null), 0.0f, 1, null), 5), new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultShareViewKt$ShootResultShareView$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                NBPShootResultViewModel.this.fadeOutAnimation.setValue(Boolean.TRUE);
                NBPMoodGroupReportViewModel nBPMoodGroupReportViewModel = NBPShootResultViewModel.this.reportVM;
                e m3 = RoleCardKt$$ExternalSyntheticOutline0.m("nearby_click_area", 0);
                Unit unit = Unit.INSTANCE;
                nBPMoodGroupReportViewModel.dtReportElementImp("em_nearby_clock_share_pop", m3);
                return Unit.INSTANCE;
            }
        }), Alignment.TopCenter, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1259047158, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultShareViewKt$ShootResultShareView$2
            {
                super(3);
            }

            public static final float invoke$lambda$0(State<Float> state) {
                return state.getValue().floatValue();
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer2, Integer num) {
                int i16;
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
                        ComposerKt.traceEventStart(-1259047158, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultShareView.<anonymous> (ShootResultShareView.kt:76)");
                    }
                    final State<Float> c16 = AnimateAsStateKt.c(!NBPShootResultViewModel.this.fadeOutAnimation.getValue().booleanValue() ? 0.0f : 1.0f, com.tencent.ntcompose.animation.b.d(150, 0, com.tencent.ntcompose.animation.i.d(), null, 10, null), null, composer3, 0, 4);
                    State<Float> c17 = AnimateAsStateKt.c(NBPShootResultViewModel.this.collectCardAnimation.getValue().booleanValue() ? -0.28f : 0.0f, com.tencent.ntcompose.animation.b.d(500, 0, com.tencent.ntcompose.animation.i.d(), null, 10, null), null, composer3, 0, 4);
                    State<Float> c18 = AnimateAsStateKt.c(NBPShootResultViewModel.this.collectCardAnimation.getValue().booleanValue() ? 0.5f : 0.0f, com.tencent.ntcompose.animation.b.d(500, 0, com.tencent.ntcompose.animation.i.d(), null, 10, null), null, composer3, 0, 4);
                    State<Float> c19 = AnimateAsStateKt.c(NBPShootResultViewModel.this.collectCardAnimation.getValue().booleanValue() ? 0.0f : 1.0f, com.tencent.ntcompose.animation.b.d(500, 0, com.tencent.ntcompose.animation.i.d(), null, 10, null), null, composer3, 0, 4);
                    i.Companion companion2 = i.INSTANCE;
                    BoxKt.a(ModifiersKt.d(ComposeLayoutPropUpdaterKt.f(ComposeLayoutPropUpdaterKt.j(companion2, 0.0f, 1, null), 0.0f, 1, null), new h(0L, invoke$lambda$0(c16) / 2)), null, null, null, composer3, 8, 14);
                    i J = ModifiersKt.J(ComposeLayoutPropUpdaterKt.o(bVar2.a(ModifiersKt.b(ModifiersKt.j(ModifiersKt.d(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion2, 296.0f), 392.0f), 0.0f, 200.0f - NBPShootResultViewModel.this.smallScreenOffsetY.getValue().floatValue(), 0.0f, 0.0f, 13, null), h.INSTANCE.m()), 8.0f), c16.getValue().floatValue()), Alignment.TopCenter), ((a) composer3.consume(CompositionLocalsKt.d())).h() * c17.getValue().floatValue(), ((a) composer3.consume(CompositionLocalsKt.d())).g() * c18.getValue().floatValue()), c19.getValue().floatValue(), null, 2, null);
                    Alignment.Horizontal b16 = Alignment.INSTANCE.b();
                    a.k h16 = com.tencent.ntcompose.foundation.layout.base.a.f339245a.h();
                    final NBPShootResultViewModel nBPShootResultViewModel2 = NBPShootResultViewModel.this;
                    ColumnKt.a(J, h16, b16, null, ComposableLambdaKt.composableLambda(composer3, -281919167, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultShareViewKt$ShootResultShareView$2.1
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
                                    ComposerKt.traceEventStart(-281919167, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultShareView.<anonymous>.<anonymous> (ShootResultShareView.kt:118)");
                                }
                                i.Companion companion3 = i.INSTANCE;
                                i k3 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion3, 296.0f), 288.0f);
                                final NBPShootResultViewModel nBPShootResultViewModel3 = NBPShootResultViewModel.this;
                                BoxKt.a(k3, null, null, ComposableLambdaKt.composableLambda(composer5, -1231763897, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultShareViewKt.ShootResultShareView.2.1.1
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar3, Composer composer6, Integer num3) {
                                        String str;
                                        Composer composer7 = composer6;
                                        int intValue3 = num3.intValue();
                                        if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                            composer7.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1231763897, intValue3, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultShareView.<anonymous>.<anonymous>.<anonymous> (ShootResultShareView.kt:122)");
                                            }
                                            i.Companion companion4 = i.INSTANCE;
                                            i h17 = ComposeLayoutPropUpdaterKt.h(companion4, 0.0f, 1, null);
                                            String str2 = NBPShootResultViewModel.this.cardData.f444477d;
                                            h.Companion companion5 = com.tencent.ntcompose.material.h.INSTANCE;
                                            int a16 = companion5.a();
                                            final NBPShootResultViewModel nBPShootResultViewModel4 = NBPShootResultViewModel.this;
                                            ImageKt.a(str2, null, null, null, null, h17, null, a16, null, null, null, null, null, null, null, null, new Function1<LoadSuccessParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultShareViewKt.ShootResultShareView.2.1.1.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(LoadSuccessParams loadSuccessParams) {
                                                    KLog.INSTANCE.i("NBPShootResultPage", "share view background image loaded successfully");
                                                    NBPShootResultViewModel.this.shareImageLoadedCheck = true;
                                                    return Unit.INSTANCE;
                                                }
                                            }, null, null, null, null, composer7, 12845056, 0, 0, 2031454);
                                            i k16 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion4, 0.0f, 1, null), 100.0f);
                                            if (Intrinsics.areEqual(NBPShootResultViewModel.this.cardData.f444481i, "rose")) {
                                                str = "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_-mBNPi_rnFw.png";
                                            } else {
                                                str = "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_9_L_0__W5VI.png";
                                            }
                                            ImageKt.a(str, null, null, null, null, k16, null, companion5.c(), null, null, null, null, null, null, null, null, null, null, null, null, null, composer7, 12845056, 0, 0, 2096990);
                                            i k17 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion4, 0.0f, 1, null), 50.0f);
                                            final NBPShootResultViewModel nBPShootResultViewModel5 = NBPShootResultViewModel.this;
                                            RowKt.a(k17, null, null, null, null, ComposableLambdaKt.composableLambda(composer7, -892437527, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultShareViewKt.ShootResultShareView.2.1.1.2
                                                {
                                                    super(3);
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public final Unit invoke(n nVar, Composer composer8, Integer num4) {
                                                    int i17;
                                                    n nVar2 = nVar;
                                                    Composer composer9 = composer8;
                                                    int intValue4 = num4.intValue();
                                                    if ((intValue4 & 14) == 0) {
                                                        i17 = (composer9.changed(nVar2) ? 4 : 2) | intValue4;
                                                    } else {
                                                        i17 = intValue4;
                                                    }
                                                    if ((i17 & 91) == 18 && composer9.getSkipping()) {
                                                        composer9.skipToGroupEnd();
                                                    } else {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-892437527, intValue4, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultShareView.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ShootResultShareView.kt:146)");
                                                        }
                                                        ShootResultShareViewKt.access$DateView(NBPShootResultViewModel.this.cardData.f444481i, composer9, 0);
                                                        SpacerKt.a(nVar2.a(ComposeLayoutPropUpdaterKt.B(i.INSTANCE), 1.0f), composer9, 8, 0);
                                                        ShootResultShareViewKt.access$LuckView(NBPShootResultViewModel.this, composer9, 8);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }), composer7, 196616, 30);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer5, 3080, 6);
                                i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion3, 0.0f, 1, null), 104.0f), 20.0f, 0.0f, 20.0f, 9.0f, 2, null);
                                Alignment.Horizontal b17 = Alignment.INSTANCE.b();
                                final NBPShootResultViewModel nBPShootResultViewModel4 = NBPShootResultViewModel.this;
                                final State<Float> state = c16;
                                ColumnKt.a(n3, null, b17, null, ComposableLambdaKt.composableLambda(composer5, 479931896, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultShareViewKt.ShootResultShareView.2.1.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(d dVar2, Composer composer6, Integer num3) {
                                        int i17;
                                        d dVar3 = dVar2;
                                        Composer composer7 = composer6;
                                        int intValue3 = num3.intValue();
                                        if ((intValue3 & 14) == 0) {
                                            i17 = (composer7.changed(dVar3) ? 4 : 2) | intValue3;
                                        } else {
                                            i17 = intValue3;
                                        }
                                        if ((i17 & 91) == 18 && composer7.getSkipping()) {
                                            composer7.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(479931896, intValue3, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultShareView.<anonymous>.<anonymous>.<anonymous> (ShootResultShareView.kt:162)");
                                            }
                                            i.Companion companion4 = i.INSTANCE;
                                            i a16 = dVar3.a(ComposeLayoutPropUpdaterKt.z(ComposeLayoutPropUpdaterKt.j(companion4, 0.0f, 1, null)), 1.0f);
                                            Alignment alignment = Alignment.CenterStart;
                                            final NBPShootResultViewModel nBPShootResultViewModel5 = NBPShootResultViewModel.this;
                                            BoxKt.a(a16, alignment, null, ComposableLambdaKt.composableLambda(composer7, 613768190, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultShareViewKt.ShootResultShareView.2.1.2.1
                                                {
                                                    super(3);
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar3, Composer composer8, Integer num4) {
                                                    Composer composer9 = composer8;
                                                    int intValue4 = num4.intValue();
                                                    if ((intValue4 & 81) == 16 && composer9.getSkipping()) {
                                                        composer9.skipToGroupEnd();
                                                    } else {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(613768190, intValue4, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultShareView.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ShootResultShareView.kt:166)");
                                                        }
                                                        TextKt.a(NBPShootResultViewModel.this.cardData.f444478e, null, null, com.tencent.kuikly.core.base.h.INSTANCE.b(), Float.valueOf(14.0f), null, bp3.c.INSTANCE.e(), null, null, null, ai.f(ai.INSTANCE.e()), null, null, null, null, null, null, null, 2, null, null, null, null, null, null, null, false, composer9, 1601536, 100663296, 0, 133954470);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }), composer7, 3128, 4);
                                            i n16 = ComposeLayoutPropUpdaterKt.n(ModifiersKt.b(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion4, 280.0f), 45.0f), state.getValue().floatValue()), 0.0f, 0.0f, 0.0f, 9.0f, 7, null);
                                            Alignment alignment2 = Alignment.Center;
                                            final NBPShootResultViewModel nBPShootResultViewModel6 = NBPShootResultViewModel.this;
                                            BoxKt.a(n16, alignment2, null, ComposableLambdaKt.composableLambda(composer7, -805938763, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultShareViewKt.ShootResultShareView.2.1.2.2
                                                {
                                                    super(3);
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar3, Composer composer8, Integer num4) {
                                                    Composer composer9 = composer8;
                                                    int intValue4 = num4.intValue();
                                                    if ((intValue4 & 81) == 16 && composer9.getSkipping()) {
                                                        composer9.skipToGroupEnd();
                                                    } else {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-805938763, intValue4, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultShareView.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ShootResultShareView.kt:182)");
                                                        }
                                                        final NBPShootResultViewModel nBPShootResultViewModel7 = NBPShootResultViewModel.this;
                                                        ButtonKt.a(null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultShareViewKt.ShootResultShareView.2.1.2.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            /* JADX WARN: Multi-variable type inference failed */
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                final NBPShootResultViewModel nBPShootResultViewModel8 = NBPShootResultViewModel.this;
                                                                if (!nBPShootResultViewModel8.shareImageLoadedCheck) {
                                                                    KLog.INSTANCE.i("NBPShootResultPage", "Image not fully loaded, publishing not allowed.");
                                                                    Utils.INSTANCE.currentBridgeModule().qToast("\u4eca\u65e5\u8fd0\u52bf\u6b63\u5728\u8ba1\u7b97\u4e2d\uff0c\u8bf7\u7a0d\u7b49", QToastMode.Info);
                                                                } else if (((Boolean) nBPShootResultViewModel8.isPublishing$delegate.getValue()).booleanValue()) {
                                                                    KLog.INSTANCE.e("NBPShootResultPage", "isPublishing, return this time");
                                                                } else {
                                                                    nBPShootResultViewModel8.isPublishing$delegate.setValue(Boolean.TRUE);
                                                                    QQNearbyModule.Companion.getInstance().viewToImage(nBPShootResultViewModel8.shareView, "resultPageShareCard", false, new Function1<String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.result.NBPShootResultViewModel$publish$1
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(String str) {
                                                                            List listOf;
                                                                            String str2 = str;
                                                                            if (!(str2 == null || str2.length() == 0)) {
                                                                                listOf = CollectionsKt__CollectionsJVMKt.listOf(NBPShootResultViewModel.this.themeId);
                                                                                NBPUserSelfInfo userSelfInfo = UserDataManager.INSTANCE.getUserSelfInfo();
                                                                                NBPShootResultViewModel nBPShootResultViewModel9 = NBPShootResultViewModel.this;
                                                                                NBPLatLng nBPLatLng = userSelfInfo.latLng;
                                                                                double d16 = 1000000;
                                                                                NBPPublishConfig nBPPublishConfig = new NBPPublishConfig("6", str2, null, null, new k((String) null, NBPShootResultViewModel.access$safeStringForRequest(nBPShootResultViewModel9, userSelfInfo.locationName, userSelfInfo.locationCity), 0, (String) null, userSelfInfo.locationAddress, 0, new n25.i((long) (nBPLatLng.latitude * d16), (long) (nBPLatLng.longitude * d16), 12), 0, 0, (String) null, NBPShootResultViewModel.access$safeStringForRequest(nBPShootResultViewModel9, userSelfInfo.locationCountry, "\u6d77\u5916"), NBPShootResultViewModel.access$safeStringForRequest(nBPShootResultViewModel9, userSelfInfo.locationProvince, userSelfInfo.locationCountry), NBPShootResultViewModel.access$safeStringForRequest(nBPShootResultViewModel9, userSelfInfo.locationCity, userSelfInfo.locationProvince), 0, 0, (String) null, userSelfInfo.locationDistrict, (String) null, (String) null, NBPShootResultViewModel.access$safeStringForRequest(nBPShootResultViewModel9, userSelfInfo.locationName, userSelfInfo.locationCity), 1500077), null, listOf, 4, 172);
                                                                                NBPPublishService nBPPublishService = NBPPublishService.INSTANCE;
                                                                                final NBPShootResultViewModel nBPShootResultViewModel10 = NBPShootResultViewModel.this;
                                                                                nBPPublishService.publish(nBPPublishConfig, new Function3<Boolean, f, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.result.NBPShootResultViewModel$publish$1.1
                                                                                    {
                                                                                        super(3);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function3
                                                                                    public final Unit invoke(Boolean bool, f fVar, String str3) {
                                                                                        if (bool.booleanValue()) {
                                                                                            Utils.INSTANCE.currentBridgeModule().qToast("\u5df2\u53d1\u5e03\u5230\u9644\u8fd1\u52a8\u6001", QToastMode.Success);
                                                                                            NBPShootResultViewModel.this.collectCardAnimation.setValue(Boolean.TRUE);
                                                                                            final NBPShootResultViewModel nBPShootResultViewModel11 = NBPShootResultViewModel.this;
                                                                                            TimerKt.d(ITPMediaCodecDecoder.BYTES_SET_MEDIA_DRM_SESSION_ID, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.result.NBPShootResultViewModel.publish.1.1.1
                                                                                                {
                                                                                                    super(0);
                                                                                                }

                                                                                                @Override // kotlin.jvm.functions.Function0
                                                                                                public final Unit invoke() {
                                                                                                    NBPShootResultViewModel.this.fadeOutAnimation.setValue(Boolean.FALSE);
                                                                                                    return Unit.INSTANCE;
                                                                                                }
                                                                                            });
                                                                                            final NBPShootResultViewModel nBPShootResultViewModel12 = NBPShootResultViewModel.this;
                                                                                            TimerKt.d(600, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.result.NBPShootResultViewModel.publish.1.1.2
                                                                                                {
                                                                                                    super(0);
                                                                                                }

                                                                                                @Override // kotlin.jvm.functions.Function0
                                                                                                public final Unit invoke() {
                                                                                                    NBPShootResultViewModel.this.resultViewState.setValue(NBPShootResultPageState.NULL);
                                                                                                    NBPShootResultViewModel.this.collectCardAnimation.setValue(Boolean.FALSE);
                                                                                                    AdelieAgreementConsentPage$onCreate$1$1$3$$ExternalSyntheticOutline0.m((com.tencent.kuikly.core.module.k) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("KRNotifyModule"), "NEARBY_RECEIVE_PRAY_CARD", false, 4, null);
                                                                                                    return Unit.INSTANCE;
                                                                                                }
                                                                                            });
                                                                                        } else {
                                                                                            Utils.INSTANCE.currentBridgeModule().qToast("\u5206\u4eab\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", QToastMode.Warning);
                                                                                        }
                                                                                        NBPShootResultViewModel.this.setNeedToBlur(false);
                                                                                        NBPShootResultViewModel.this.isPublishing$delegate.setValue(Boolean.FALSE);
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                });
                                                                            } else {
                                                                                KLog.INSTANCE.e("NBPShootResultPage", "\u5206\u4eab\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5");
                                                                                Utils.INSTANCE.currentBridgeModule().qToast("\u5206\u4eab\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", QToastMode.Warning);
                                                                            }
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        }, ModifiersKt.j(ModifiersKt.c(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 256.0f), 45.0f), QUIToken.color$default("brand_standard")), 4.0f), null, ComposableSingletons$ShootResultShareViewKt.f75lambda1, composer9, 25088, 9);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }), composer7, 3128, 4);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer5, 24584, 10);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 24648, 8);
                    i R = ModifiersKt.R(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion2, 100.0f), 60.0f), 0.0f, 620.0f - NBPShootResultViewModel.this.smallScreenOffsetY.getValue().floatValue(), 0.0f, 0.0f, 13, null), !NBPShootResultViewModel.this.collectCardAnimation.getValue().booleanValue());
                    final NBPShootResultViewModel nBPShootResultViewModel3 = NBPShootResultViewModel.this;
                    i d16 = ViewEventPropUpdaterKt.d(R, false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultShareViewKt$ShootResultShareView$2.2
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ClickParams clickParams) {
                            NBPShootResultViewModel.this.setNeedToBlur(false);
                            NBPShootResultViewModel.this.collectCardAnimation.setValue(Boolean.TRUE);
                            final NBPShootResultViewModel nBPShootResultViewModel4 = NBPShootResultViewModel.this;
                            TimerKt.d(ITPMediaCodecDecoder.BYTES_SET_MEDIA_DRM_SESSION_ID, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultShareViewKt.ShootResultShareView.2.2.1
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final Unit invoke() {
                                    NBPShootResultViewModel.this.fadeOutAnimation.setValue(Boolean.FALSE);
                                    return Unit.INSTANCE;
                                }
                            });
                            final NBPShootResultViewModel nBPShootResultViewModel5 = NBPShootResultViewModel.this;
                            TimerKt.d(600, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultShareViewKt.ShootResultShareView.2.2.2
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final Unit invoke() {
                                    NBPShootResultViewModel.this.resultViewState.setValue(NBPShootResultPageState.NULL);
                                    NBPShootResultViewModel.this.collectCardAnimation.setValue(Boolean.FALSE);
                                    AdelieAgreementConsentPage$onCreate$1$1$3$$ExternalSyntheticOutline0.m((com.tencent.kuikly.core.module.k) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("KRNotifyModule"), "NEARBY_RECEIVE_PRAY_CARD", false, 4, null);
                                    return Unit.INSTANCE;
                                }
                            });
                            return Unit.INSTANCE;
                        }
                    }, 3, null);
                    Alignment alignment = Alignment.Center;
                    BoxKt.a(d16, alignment, null, ComposableSingletons$ShootResultShareViewKt.f76lambda2, composer3, 3128, 4);
                    if (((Boolean) NBPShootResultViewModel.this.isPublishing$delegate.getValue()).booleanValue()) {
                        BoxKt.a(ViewEventPropUpdaterKt.d(ComposeLayoutPropUpdaterKt.h(companion2, 0.0f, 1, null), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultShareViewKt$ShootResultShareView$2.3
                            @Override // kotlin.jvm.functions.Function1
                            public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                                return Unit.INSTANCE;
                            }
                        }, 3, null), alignment, null, ComposableSingletons$ShootResultShareViewKt.f78lambda4, composer3, 3128, 4);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 3128, 4);
        ColumnKt.a(ComposeLayoutPropUpdaterKt.b(ModifiersKt.d(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion, 296.0f), 392.0f), 0.0f, 200.0f - nBPShootResultViewModel.smallScreenOffsetY.getValue().floatValue(), 0.0f, 0.0f, 13, null), com.tencent.kuikly.core.base.h.INSTANCE.m()), ((com.tencent.ntcompose.ui.platform.a) startRestartGroup.consume(CompositionLocalsKt.d())).e() + 300.0f, 0.0f, 2, null), com.tencent.ntcompose.foundation.layout.base.a.f339245a.h(), Alignment.INSTANCE.b(), new Function2<v, aa<v>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultShareViewKt$ShootResultShareView$3
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(v vVar, aa<v> aaVar) {
                NBPShootResultViewModel.this.shareView = aaVar.getNativeRef();
                return Unit.INSTANCE;
            }
        }, ComposableLambdaKt.composableLambda(startRestartGroup, 418325243, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultShareViewKt$ShootResultShareView$4
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
                        ComposerKt.traceEventStart(418325243, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultShareView.<anonymous> (ShootResultShareView.kt:269)");
                    }
                    i.Companion companion2 = i.INSTANCE;
                    i k3 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion2, 296.0f), 288.0f);
                    final NBPShootResultViewModel nBPShootResultViewModel2 = NBPShootResultViewModel.this;
                    BoxKt.a(k3, null, null, ComposableLambdaKt.composableLambda(composer3, -1781013887, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultShareViewKt$ShootResultShareView$4.1
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer4, Integer num2) {
                            String str;
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1781013887, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultShareView.<anonymous>.<anonymous> (ShootResultShareView.kt:273)");
                                }
                                i.Companion companion3 = i.INSTANCE;
                                i h16 = ComposeLayoutPropUpdaterKt.h(companion3, 0.0f, 1, null);
                                String str2 = NBPShootResultViewModel.this.cardData.f444477d;
                                h.Companion companion4 = com.tencent.ntcompose.material.h.INSTANCE;
                                ImageKt.a(str2, null, null, null, null, h16, null, companion4.a(), null, null, null, null, null, null, null, null, null, null, null, null, null, composer5, 12845056, 0, 0, 2096990);
                                i k16 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion3, 0.0f, 1, null), 100.0f);
                                if (Intrinsics.areEqual(NBPShootResultViewModel.this.cardData.f444481i, "rose")) {
                                    str = "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_-mBNPi_rnFw.png";
                                } else {
                                    str = "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_9_L_0__W5VI.png";
                                }
                                ImageKt.a(str, null, null, null, null, k16, null, companion4.c(), null, null, null, null, null, null, null, null, null, null, null, null, null, composer5, 12845056, 0, 0, 2096990);
                                i k17 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion3, 0.0f, 1, null), 50.0f);
                                final NBPShootResultViewModel nBPShootResultViewModel3 = NBPShootResultViewModel.this;
                                RowKt.a(k17, null, null, null, null, ComposableLambdaKt.composableLambda(composer5, 987382691, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultShareViewKt.ShootResultShareView.4.1.1
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(n nVar, Composer composer6, Integer num3) {
                                        int i16;
                                        n nVar2 = nVar;
                                        Composer composer7 = composer6;
                                        int intValue3 = num3.intValue();
                                        if ((intValue3 & 14) == 0) {
                                            i16 = (composer7.changed(nVar2) ? 4 : 2) | intValue3;
                                        } else {
                                            i16 = intValue3;
                                        }
                                        if ((i16 & 91) == 18 && composer7.getSkipping()) {
                                            composer7.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(987382691, intValue3, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultShareView.<anonymous>.<anonymous>.<anonymous> (ShootResultShareView.kt:293)");
                                            }
                                            ShootResultShareViewKt.access$DateView(NBPShootResultViewModel.this.cardData.f444481i, composer7, 0);
                                            SpacerKt.a(nVar2.a(ComposeLayoutPropUpdaterKt.B(i.INSTANCE), 1.0f), composer7, 8, 0);
                                            ShootResultShareViewKt.access$LuckView(NBPShootResultViewModel.this, composer7, 8);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer5, 196616, 30);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 3080, 6);
                    i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion2, 0.0f, 1, null), 104.0f), 20.0f, 0.0f, 20.0f, 9.0f, 2, null);
                    Alignment.Horizontal b16 = Alignment.INSTANCE.b();
                    final NBPShootResultViewModel nBPShootResultViewModel3 = NBPShootResultViewModel.this;
                    ColumnKt.a(n3, null, b16, null, ComposableLambdaKt.composableLambda(composer3, -106682382, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultShareViewKt$ShootResultShareView$4.2
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(d dVar2, Composer composer4, Integer num2) {
                            int i16;
                            d dVar3 = dVar2;
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 14) == 0) {
                                i16 = (composer5.changed(dVar3) ? 4 : 2) | intValue2;
                            } else {
                                i16 = intValue2;
                            }
                            if ((i16 & 91) == 18 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-106682382, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultShareView.<anonymous>.<anonymous> (ShootResultShareView.kt:309)");
                                }
                                i.Companion companion3 = i.INSTANCE;
                                i a16 = dVar3.a(ComposeLayoutPropUpdaterKt.z(ComposeLayoutPropUpdaterKt.j(companion3, 0.0f, 1, null)), 1.0f);
                                Alignment alignment = Alignment.CenterStart;
                                final NBPShootResultViewModel nBPShootResultViewModel4 = NBPShootResultViewModel.this;
                                BoxKt.a(a16, alignment, null, ComposableLambdaKt.composableLambda(composer5, 162812024, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultShareViewKt.ShootResultShareView.4.2.1
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer6, Integer num3) {
                                        Composer composer7 = composer6;
                                        int intValue3 = num3.intValue();
                                        if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                            composer7.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(162812024, intValue3, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultShareView.<anonymous>.<anonymous>.<anonymous> (ShootResultShareView.kt:313)");
                                            }
                                            TextKt.a(NBPShootResultViewModel.this.cardData.f444478e, null, null, com.tencent.kuikly.core.base.h.INSTANCE.b(), Float.valueOf(14.0f), null, bp3.c.INSTANCE.e(), null, null, null, ai.f(ai.INSTANCE.e()), null, null, null, null, null, null, null, 2, null, null, null, null, null, null, null, false, composer7, 1601536, 100663296, 0, 133954470);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer5, 3128, 4);
                                RowKt.a(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion3, 0.0f, 1, null), 45.0f), 0.0f, 0.0f, 0.0f, 9.0f, 7, null), null, Alignment.INSTANCE.a(), null, null, ComposableSingletons$ShootResultShareViewKt.f79lambda5, composer5, 196616, 26);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 24584, 10);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 24648, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultShareViewKt$ShootResultShareView$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                ShootResultShareViewKt.ShootResultShareView(NBPShootResultViewModel.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
