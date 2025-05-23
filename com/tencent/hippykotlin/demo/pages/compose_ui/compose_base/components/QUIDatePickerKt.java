package com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.component.media.image.ProgressTracer;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.GuideBannerCardAnimationViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.base.t;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.ICalendar;
import com.tencent.kuikly.core.module.b;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.foundation.lazy.d;
import com.tencent.ntcompose.material.AlertCustomDialogKt;
import com.tencent.ntcompose.material.AlertDialogTransitionType;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.ai;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* loaded from: classes31.dex */
public final class QUIDatePickerKt {
    /* JADX WARN: Removed duplicated region for block: B:106:0x03da  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x03fc  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x041a  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0421  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0428  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x046a  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x04e5  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0561  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x04a2  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x03fe  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0581  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0363  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0391 A[LOOP:0: B:89:0x038f->B:90:0x0391, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x03b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void QUIDatePicker(i iVar, DatePickerType datePickerType, long j3, int i3, final boolean z16, String str, h hVar, h hVar2, h hVar3, h hVar4, final Function1<? super Boolean, Unit> function1, Function0<Unit> function0, Function2<? super Long, ? super DatePickerState, Unit> function2, Function2<? super Long, ? super DatePickerState, Unit> function22, Composer composer, final int i16, final int i17, final int i18) {
        int i19;
        int i26;
        int i27;
        int i28;
        int i29;
        int i36;
        int i37;
        int i38;
        int i39;
        int i46;
        int i47;
        Function2<? super Long, ? super DatePickerState, Unit> function23;
        h hVar5;
        h hVar6;
        h hVar7;
        h hVar8;
        Function2<? super Long, ? super DatePickerState, Unit> function24;
        h hVar9;
        i iVar2;
        DatePickerType datePickerType2;
        h hVar10;
        Function2<? super Long, ? super DatePickerState, Unit> function25;
        h hVar11;
        String str2;
        h hVar12;
        long j16;
        Function0<Unit> function02;
        int i48;
        Object rememberedValue;
        Composer.Companion companion;
        int i49;
        SnapshotMutationPolicy snapshotMutationPolicy;
        Object rememberedValue2;
        Object rememberedValue3;
        int i56;
        int i57;
        int i58;
        int i59;
        int indexOf;
        int indexOf2;
        int indexOf3;
        Object rememberedValue4;
        Composer.Companion companion2;
        b bVar;
        ArrayList arrayList;
        int i65;
        long j17;
        boolean changed;
        Object rememberedValue5;
        Composer composer2;
        final i iVar3;
        final Function0<Unit> function03;
        final int i66;
        final long j18;
        final DatePickerType datePickerType3;
        final String str3;
        final h hVar13;
        final h hVar14;
        final h hVar15;
        final h hVar16;
        final Function2<? super Long, ? super DatePickerState, Unit> function26;
        String valueOf;
        String valueOf2;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-627971269);
        int i67 = i18 & 1;
        int i68 = i67 != 0 ? i16 | 2 : i16;
        int i69 = i18 & 2;
        if (i69 != 0) {
            i68 |= 48;
        } else if ((i16 & 112) == 0) {
            i68 |= startRestartGroup.changed(datePickerType) ? 32 : 16;
            i19 = i18 & 4;
            if (i19 == 0) {
                i68 |= MsgConstant.KRMFILETHUMBSIZE384;
            } else if ((i16 & 896) == 0) {
                i68 |= startRestartGroup.changed(j3) ? 256 : 128;
            }
            i26 = i18 & 8;
            if (i26 == 0) {
                i68 |= 3072;
            } else if ((i16 & 7168) == 0) {
                i68 |= startRestartGroup.changed(i3) ? 2048 : 1024;
                if ((i18 & 16) != 0) {
                    i68 |= 24576;
                } else if ((i16 & 57344) == 0) {
                    i68 |= startRestartGroup.changed(z16) ? 16384 : 8192;
                }
                i27 = i18 & 32;
                if (i27 != 0) {
                    i68 |= 196608;
                } else if ((i16 & 458752) == 0) {
                    i68 |= startRestartGroup.changed(str) ? 131072 : 65536;
                }
                i28 = i18 & 64;
                if (i28 != 0) {
                    i68 |= 524288;
                }
                i29 = i18 & 128;
                if (i29 != 0) {
                    i68 |= 4194304;
                }
                i36 = i18 & 256;
                if (i36 != 0) {
                    i68 |= 33554432;
                }
                i37 = i18 & 512;
                if (i37 != 0) {
                    i68 |= 268435456;
                }
                if ((i18 & 1024) != 0) {
                    i38 = i17 | 6;
                } else if ((i17 & 14) == 0) {
                    i38 = (startRestartGroup.changed(function1) ? 4 : 2) | i17;
                } else {
                    i38 = i17;
                }
                i39 = i18 & 2048;
                if (i39 != 0) {
                    i38 |= 48;
                } else if ((i17 & 112) == 0) {
                    i38 |= startRestartGroup.changed(function0) ? 32 : 16;
                }
                i46 = i18 & 4096;
                if (i46 != 0) {
                    i38 |= MsgConstant.KRMFILETHUMBSIZE384;
                } else if ((i17 & 896) == 0) {
                    i38 |= startRestartGroup.changed(function2) ? 256 : 128;
                    i47 = i18 & 8192;
                    if (i47 == 0) {
                        i38 |= 3072;
                    } else if ((i17 & 7168) == 0) {
                        function23 = function22;
                        i38 |= startRestartGroup.changed(function23) ? 2048 : 1024;
                        if ((i18 & 961) != 961 && (1533916891 & i68) == 306783378 && (i38 & 5851) == 1170 && startRestartGroup.getSkipping()) {
                            startRestartGroup.skipToGroupEnd();
                            iVar3 = iVar;
                            datePickerType3 = datePickerType;
                            j18 = j3;
                            i66 = i3;
                            str3 = str;
                            hVar13 = hVar;
                            hVar14 = hVar2;
                            hVar16 = hVar4;
                            function03 = function0;
                            composer2 = startRestartGroup;
                            function24 = function23;
                            hVar15 = hVar3;
                            function26 = function2;
                        } else {
                            startRestartGroup.startDefaults();
                            if ((i16 & 1) == 0 && !startRestartGroup.getDefaultsInvalid()) {
                                startRestartGroup.skipToGroupEnd();
                                if (i28 != 0) {
                                    i68 &= -3670017;
                                }
                                if (i29 != 0) {
                                    i68 &= -29360129;
                                }
                                if (i36 != 0) {
                                    i68 &= -234881025;
                                }
                                if (i37 != 0) {
                                    iVar2 = iVar;
                                    datePickerType2 = datePickerType;
                                    i48 = i3;
                                    str2 = str;
                                    hVar12 = hVar;
                                    hVar11 = hVar2;
                                    hVar9 = hVar3;
                                    hVar10 = hVar4;
                                    function02 = function0;
                                    function25 = function2;
                                    i68 = (-1879048193) & i68;
                                } else {
                                    iVar2 = iVar;
                                    datePickerType2 = datePickerType;
                                    i48 = i3;
                                    str2 = str;
                                    hVar12 = hVar;
                                    hVar11 = hVar2;
                                    hVar9 = hVar3;
                                    hVar10 = hVar4;
                                    function02 = function0;
                                    function25 = function2;
                                }
                                function24 = function23;
                                j16 = j3;
                            } else {
                                i iVar4 = i67 != 0 ? i.INSTANCE : iVar;
                                DatePickerType datePickerType4 = i69 != 0 ? DatePickerType.QZone : datePickerType;
                                long j19 = i19 != 0 ? 0L : j3;
                                int i75 = i26 != 0 ? 20 : i3;
                                String str4 = i27 != 0 ? "" : str;
                                if (i28 != 0) {
                                    hVar5 = QUIToken.color$default("text_primary");
                                    i68 &= -3670017;
                                } else {
                                    hVar5 = hVar;
                                }
                                if (i29 != 0) {
                                    hVar6 = QUIToken.color$default("bg_middle_light");
                                    i68 &= -29360129;
                                } else {
                                    hVar6 = hVar2;
                                }
                                if (i36 != 0) {
                                    hVar7 = new h(16777215L);
                                    i68 &= -234881025;
                                } else {
                                    hVar7 = hVar3;
                                }
                                if (i37 != 0) {
                                    hVar8 = QUIToken.color$default("border_standard");
                                    i68 &= -1879048193;
                                } else {
                                    hVar8 = hVar4;
                                }
                                Function0<Unit> function04 = i39 != 0 ? null : function0;
                                Function2<? super Long, ? super DatePickerState, Unit> function27 = i46 != 0 ? null : function2;
                                if (i47 != 0) {
                                    hVar9 = hVar7;
                                    iVar2 = iVar4;
                                    datePickerType2 = datePickerType4;
                                    hVar10 = hVar8;
                                    function25 = function27;
                                    hVar11 = hVar6;
                                    str2 = str4;
                                    hVar12 = hVar5;
                                    j16 = j19;
                                    function24 = null;
                                } else {
                                    function24 = function22;
                                    hVar9 = hVar7;
                                    iVar2 = iVar4;
                                    datePickerType2 = datePickerType4;
                                    hVar10 = hVar8;
                                    function25 = function27;
                                    hVar11 = hVar6;
                                    str2 = str4;
                                    hVar12 = hVar5;
                                    j16 = j19;
                                }
                                function02 = function04;
                                i48 = i75;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-627971269, i68, i38, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePicker (QUIDatePicker.kt:78)");
                            }
                            startRestartGroup.startReplaceableGroup(-492369756);
                            rememberedValue = startRestartGroup.rememberedValue();
                            companion = Composer.INSTANCE;
                            if (rememberedValue == companion.getEmpty()) {
                                i49 = 2;
                                snapshotMutationPolicy = null;
                                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            } else {
                                i49 = 2;
                                snapshotMutationPolicy = null;
                            }
                            startRestartGroup.endReplaceableGroup();
                            final MutableState mutableState = (MutableState) rememberedValue;
                            startRestartGroup.startReplaceableGroup(-492369756);
                            rememberedValue2 = startRestartGroup.rememberedValue();
                            if (rememberedValue2 == companion.getEmpty()) {
                                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0L, snapshotMutationPolicy, i49, snapshotMutationPolicy);
                                startRestartGroup.updateRememberedValue(rememberedValue2);
                            }
                            startRestartGroup.endReplaceableGroup();
                            final MutableState mutableState2 = (MutableState) rememberedValue2;
                            b bVar2 = (b) c.f117352a.g().acquireModule("KRCalendarModule");
                            final ICalendar b16 = bVar2.b(j16);
                            int c16 = b16.c(ICalendar.Field.YEAR);
                            int c17 = b16.c(ICalendar.Field.MONTH) + 1;
                            ICalendar.Field field = ICalendar.Field.DAY_OF_MONTH;
                            int c18 = b16.c(field);
                            final int i76 = i38;
                            int c19 = b16.c(ICalendar.Field.HOUR_OF_DAY);
                            final i iVar5 = iVar2;
                            int c26 = b16.c(ICalendar.Field.MINUS);
                            final Function0<Unit> function05 = function02;
                            int c27 = b16.c(ICalendar.Field.SECOND);
                            final int i77 = i68;
                            KLog.INSTANCE.i("QUIDatePicker", "current year = " + c16 + ", month = " + c17 + ", day = " + c18 + ", hour = " + c19 + ", minute = " + c26 + ", second = " + c27);
                            startRestartGroup.startReplaceableGroup(-492369756);
                            rememberedValue3 = startRestartGroup.rememberedValue();
                            if (rememberedValue3 == companion.getEmpty()) {
                                rememberedValue3 = SnapshotStateKt.mutableStateListOf();
                                startRestartGroup.updateRememberedValue(rememberedValue3);
                            }
                            startRestartGroup.endReplaceableGroup();
                            final ArrayList arrayList2 = new ArrayList();
                            ICalendar b17 = bVar2.b(j16);
                            arrayList2.add(bVar2.a(b17.d(field, -i48).a(), "MM\u6708dd\u65e5"));
                            i56 = i48 * 2;
                            for (i57 = 0; i57 < i56; i57++) {
                                arrayList2.add(bVar2.a(b17.d(ICalendar.Field.DAY_OF_MONTH, 1).a(), "MM\u6708dd\u65e5"));
                            }
                            final ArrayList arrayList3 = new ArrayList();
                            for (i58 = 0; i58 < 24; i58++) {
                                if (i58 < 10) {
                                    StringBuilder sb5 = new StringBuilder();
                                    sb5.append('0');
                                    sb5.append(i58);
                                    valueOf2 = sb5.toString();
                                } else {
                                    valueOf2 = String.valueOf(i58);
                                }
                                arrayList3.add(valueOf2);
                            }
                            ArrayList arrayList4 = new ArrayList();
                            for (i59 = 0; i59 < 60; i59++) {
                                if (i59 < 10) {
                                    StringBuilder sb6 = new StringBuilder();
                                    sb6.append('0');
                                    sb6.append(i59);
                                    valueOf = sb6.toString();
                                } else {
                                    valueOf = String.valueOf(i59);
                                }
                                arrayList4.add(valueOf);
                            }
                            long a16 = j16 != 0 ? j16 : b16.a();
                            String a17 = bVar2.a(a16, "MM\u6708dd\u65e5");
                            String a18 = bVar2.a(a16, "HH");
                            String a19 = bVar2.a(a16, "mm");
                            indexOf = arrayList2.indexOf(a17);
                            if (indexOf < 0) {
                                indexOf = 0;
                            }
                            indexOf2 = arrayList3.indexOf(a18);
                            if (indexOf2 < 0) {
                                indexOf2 = 0;
                            }
                            indexOf3 = arrayList4.indexOf(a19);
                            if (indexOf3 < 0) {
                                indexOf3 = 0;
                            }
                            Triple triple = new Triple(Integer.valueOf(indexOf), Integer.valueOf(indexOf2), Integer.valueOf(indexOf3));
                            final int intValue = ((Number) triple.component1()).intValue();
                            final int intValue2 = ((Number) triple.component2()).intValue();
                            final int intValue3 = ((Number) triple.component3()).intValue();
                            startRestartGroup.startReplaceableGroup(-492369756);
                            rememberedValue4 = startRestartGroup.rememberedValue();
                            companion2 = Composer.INSTANCE;
                            if (rememberedValue4 == companion2.getEmpty()) {
                                i65 = i48;
                                bVar = bVar2;
                                j17 = j16;
                                arrayList = arrayList4;
                                rememberedValue4 = new DatePickerState(new ScrollPickerState("", new d(0, 0.0f, 2, null), 8), new ScrollPickerState("", new d(0, 0.0f, 2, null), 8), new ScrollPickerState("", new d(0, 0.0f, 2, null), 8));
                                startRestartGroup.updateRememberedValue(rememberedValue4);
                            } else {
                                bVar = bVar2;
                                arrayList = arrayList4;
                                i65 = i48;
                                j17 = j16;
                            }
                            startRestartGroup.endReplaceableGroup();
                            final DatePickerState datePickerState = (DatePickerState) rememberedValue4;
                            AlertDialogTransitionType alertDialogTransitionType = AlertDialogTransitionType.DIRECTION_FROM_BOTTOM;
                            h a26 = h.INSTANCE.a(0.5f);
                            Alignment alignment = Alignment.BottomCenter;
                            Boolean valueOf3 = Boolean.valueOf(z16);
                            int i78 = (i77 >> 12) & 14;
                            startRestartGroup.startReplaceableGroup(1618982084);
                            changed = startRestartGroup.changed(valueOf3) | startRestartGroup.changed(function1) | startRestartGroup.changed(function05);
                            rememberedValue5 = startRestartGroup.rememberedValue();
                            if (!changed || rememberedValue5 == companion2.getEmpty()) {
                                rememberedValue5 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePickerKt$QUIDatePicker$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Unit invoke() {
                                        if (z16) {
                                            function1.invoke(Boolean.TRUE);
                                        }
                                        Function0<Unit> function06 = function05;
                                        if (function06 != null) {
                                            function06.invoke();
                                        }
                                        return Unit.INSTANCE;
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue5);
                            }
                            startRestartGroup.endReplaceableGroup();
                            final DatePickerType datePickerType5 = datePickerType2;
                            final h hVar17 = hVar12;
                            final h hVar18 = hVar11;
                            final h hVar19 = hVar9;
                            final h hVar20 = hVar10;
                            final ArrayList arrayList5 = arrayList;
                            final String str5 = str2;
                            final long j26 = j17;
                            final Function2<? super Long, ? super DatePickerState, Unit> function28 = function24;
                            final b bVar3 = bVar;
                            final Function2<? super Long, ? super DatePickerState, Unit> function29 = function25;
                            composer2 = startRestartGroup;
                            int i79 = i65;
                            long j27 = j17;
                            AlertCustomDialogKt.a(z16, false, a26, null, alertDialogTransitionType, (Function0) rememberedValue5, null, alignment, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1500388696, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePickerKt$QUIDatePicker$2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final Unit invoke(Composer composer3, Integer num) {
                                    Composer composer4 = composer3;
                                    int intValue4 = num.intValue();
                                    if ((intValue4 & 11) == 2 && composer4.getSkipping()) {
                                        composer4.skipToGroupEnd();
                                    } else {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1500388696, intValue4, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePicker.<anonymous> (QUIDatePicker.kt:198)");
                                        }
                                        i d16 = ViewEventPropUpdaterKt.d(ModifiersKt.k(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(ModifiersKt.c(i.INSTANCE, QUIToken.color$default("bg_middle_standard")), 0.0f, 1, null), 292.0f), 8.0f, 8.0f, 0.0f, 0.0f), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePickerKt$QUIDatePicker$2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                                                return Unit.INSTANCE;
                                            }
                                        }, 3, null);
                                        final DatePickerType datePickerType6 = DatePickerType.this;
                                        final i iVar6 = iVar5;
                                        final DatePickerState datePickerState2 = datePickerState;
                                        final h hVar21 = hVar17;
                                        final h hVar22 = hVar18;
                                        final h hVar23 = hVar19;
                                        final h hVar24 = hVar20;
                                        final List<String> list = arrayList2;
                                        final int i85 = intValue;
                                        final List<String> list2 = arrayList3;
                                        final int i86 = intValue2;
                                        final List<String> list3 = arrayList5;
                                        final int i87 = intValue3;
                                        final Function1<Boolean, Unit> function12 = function1;
                                        final int i88 = i76;
                                        final String str6 = str5;
                                        final int i89 = i77;
                                        final MutableState<Long> mutableState3 = mutableState2;
                                        final long j28 = j26;
                                        final ICalendar iCalendar = b16;
                                        final Function2<Long, DatePickerState, Unit> function210 = function28;
                                        final b bVar4 = bVar3;
                                        final Function2<Long, DatePickerState, Unit> function211 = function29;
                                        final MutableState<String> mutableState4 = mutableState;
                                        ColumnKt.a(d16, null, null, null, ComposableLambdaKt.composableLambda(composer4, -1062491951, true, new Function3<com.tencent.ntcompose.foundation.layout.d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePickerKt$QUIDatePicker$2.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public final Unit invoke(com.tencent.ntcompose.foundation.layout.d dVar, Composer composer5, Integer num2) {
                                                Composer composer6 = composer5;
                                                int intValue5 = num2.intValue();
                                                if ((intValue5 & 81) == 16 && composer6.getSkipping()) {
                                                    composer6.skipToGroupEnd();
                                                } else {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-1062491951, intValue5, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePicker.<anonymous>.<anonymous> (QUIDatePicker.kt:205)");
                                                    }
                                                    RowKt.a(ModifiersKt.c(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 56.0f), 16.0f, 0.0f, 16.0f, 0.0f, 10, null), QUIToken.color$default("bg_middle_light")), a.f339245a.e(), Alignment.INSTANCE.c(), null, null, ComposableLambdaKt.composableLambda(composer6, 445825263, true, new Function3<n, Composer, Integer, Unit>(function12, i88, str6, i89, mutableState3, j28, iCalendar, function210, datePickerState2) { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePickerKt.QUIDatePicker.2.2.1
                                                        public final /* synthetic */ int $$dirty;
                                                        public final /* synthetic */ ICalendar $calendarInstance;
                                                        public final /* synthetic */ Function1<Boolean, Unit> $cancelButtonClick;
                                                        public final /* synthetic */ MutableState<Long> $curTimestamp;
                                                        public final /* synthetic */ DatePickerState $datePickerState;
                                                        public final /* synthetic */ Function2<Long, DatePickerState, Unit> $onSelected;
                                                        public final /* synthetic */ long $targetTimeMillis;
                                                        public final /* synthetic */ String $titleText;

                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        /* JADX WARN: Multi-variable type inference failed */
                                                        {
                                                            super(3);
                                                            this.$titleText = r3;
                                                            this.$$dirty = r4;
                                                            this.$curTimestamp = r5;
                                                            this.$targetTimeMillis = r6;
                                                            this.$calendarInstance = r8;
                                                            this.$onSelected = r9;
                                                            this.$datePickerState = r10;
                                                        }

                                                        @Override // kotlin.jvm.functions.Function3
                                                        public final Unit invoke(n nVar, Composer composer7, Integer num3) {
                                                            int i95;
                                                            n nVar2 = nVar;
                                                            Composer composer8 = composer7;
                                                            int intValue6 = num3.intValue();
                                                            if ((intValue6 & 14) == 0) {
                                                                i95 = (composer8.changed(nVar2) ? 4 : 2) | intValue6;
                                                            } else {
                                                                i95 = intValue6;
                                                            }
                                                            if ((i95 & 91) == 18 && composer8.getSkipping()) {
                                                                composer8.skipToGroupEnd();
                                                            } else {
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(445825263, intValue6, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePicker.<anonymous>.<anonymous>.<anonymous> (QUIDatePicker.kt:212)");
                                                                }
                                                                i.Companion companion3 = i.INSTANCE;
                                                                i a27 = ModifiersKt.a(ComposeLayoutPropUpdaterKt.v(companion3, 65.0f, 45.0f), "\u53d6\u6d88");
                                                                final Function1<Boolean, Unit> function13 = this.$cancelButtonClick;
                                                                composer8.startReplaceableGroup(1157296644);
                                                                boolean changed2 = composer8.changed(function13);
                                                                Object rememberedValue6 = composer8.rememberedValue();
                                                                if (changed2 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                                                    rememberedValue6 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePickerKt$QUIDatePicker$2$2$1$1$1
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        /* JADX WARN: Multi-variable type inference failed */
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(ClickParams clickParams) {
                                                                            function13.invoke(Boolean.FALSE);
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    };
                                                                    composer8.updateRememberedValue(rememberedValue6);
                                                                }
                                                                composer8.endReplaceableGroup();
                                                                i d17 = ViewEventPropUpdaterKt.d(a27, false, null, (Function1) rememberedValue6, 3, null);
                                                                Alignment alignment2 = Alignment.Center;
                                                                BoxKt.a(d17, alignment2, null, ComposableSingletons$QUIDatePickerKt.f29lambda1, composer8, 3128, 4);
                                                                TextKt.a(this.$titleText, nVar2.a(companion3, 1.0f), null, QUIToken.color$default("text_primary"), Float.valueOf(17.0f), null, bp3.c.INSTANCE.f(), null, null, null, ai.f(ai.INSTANCE.a()), Float.valueOf(24.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer8, ((this.$$dirty >> 15) & 14) | 1601600, 48, 0, 134214564);
                                                                i a28 = ModifiersKt.a(ComposeLayoutPropUpdaterKt.v(companion3, 65.0f, 45.0f), "\u786e\u8ba4");
                                                                final MutableState<Long> mutableState5 = this.$curTimestamp;
                                                                final long j29 = this.$targetTimeMillis;
                                                                final ICalendar iCalendar2 = this.$calendarInstance;
                                                                final Function2<Long, DatePickerState, Unit> function212 = this.$onSelected;
                                                                final DatePickerState datePickerState3 = this.$datePickerState;
                                                                BoxKt.a(ViewEventPropUpdaterKt.d(a28, false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePickerKt.QUIDatePicker.2.2.1.2
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    /* JADX WARN: Multi-variable type inference failed */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ClickParams clickParams) {
                                                                        long longValue;
                                                                        if (mutableState5.getValue().longValue() == 0) {
                                                                            longValue = j29;
                                                                            if (longValue == 0) {
                                                                                longValue = iCalendar2.a();
                                                                            }
                                                                        } else {
                                                                            longValue = mutableState5.getValue().longValue();
                                                                        }
                                                                        Function2<Long, DatePickerState, Unit> function213 = function212;
                                                                        if (function213 != null) {
                                                                            function213.invoke(Long.valueOf(longValue), datePickerState3);
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                }, 3, null), alignment2, null, ComposableSingletons$QUIDatePickerKt.f30lambda2, composer8, 3128, 4);
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                }
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    }), composer6, 196680, 24);
                                                    DatePickerType datePickerType7 = DatePickerType.this;
                                                    if (datePickerType7 != DatePickerType.Normal && datePickerType7 == DatePickerType.QZone) {
                                                        i iVar7 = iVar6;
                                                        final DatePickerState datePickerState3 = datePickerState2;
                                                        h hVar25 = hVar21;
                                                        h hVar26 = hVar22;
                                                        h hVar27 = hVar23;
                                                        h hVar28 = hVar24;
                                                        List<String> list4 = list;
                                                        final int i95 = i85;
                                                        List<String> list5 = list2;
                                                        final int i96 = i86;
                                                        List<String> list6 = list3;
                                                        final int i97 = i87;
                                                        final MutableState<Long> mutableState5 = mutableState3;
                                                        final long j29 = j28;
                                                        final b bVar5 = bVar4;
                                                        final ICalendar iCalendar2 = iCalendar;
                                                        final Function2<Long, DatePickerState, Unit> function212 = function211;
                                                        final MutableState<String> mutableState6 = mutableState4;
                                                        QUIDatePickerKt.access$QUIDatePickerImpl(iVar7, datePickerState3, hVar25, hVar26, hVar27, hVar28, list4, i95, list5, i96, list6, i97, 3, 0, 50.0f, new Function1<DatePickerState, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePickerKt.QUIDatePicker.2.2.2
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            /* JADX WARN: Multi-variable type inference failed */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(DatePickerState datePickerState4) {
                                                                long longValue;
                                                                DatePickerState datePickerState5 = DatePickerState.this;
                                                                if (!datePickerState5.scrollPickerState1.isScrolling && !datePickerState5.scrollPickerState2.isScrolling && !datePickerState5.scrollPickerState3.isScrolling) {
                                                                    MutableState<Long> mutableState7 = mutableState5;
                                                                    int i98 = i95;
                                                                    int i99 = i96;
                                                                    int i100 = i97;
                                                                    ICalendar b18 = bVar5.b(j29);
                                                                    b18.d(ICalendar.Field.DAY_OF_MONTH, datePickerState5.scrollPickerState1.centerItemIndex - i98);
                                                                    b18.d(ICalendar.Field.HOUR_OF_DAY, datePickerState5.scrollPickerState2.centerItemIndex - i99);
                                                                    b18.d(ICalendar.Field.MINUS, datePickerState5.scrollPickerState3.centerItemIndex - i100);
                                                                    mutableState7.setValue(Long.valueOf(b18.a()));
                                                                    if (mutableState5.getValue().longValue() == 0) {
                                                                        longValue = j29;
                                                                        if (longValue == 0) {
                                                                            longValue = iCalendar2.a();
                                                                        }
                                                                    } else {
                                                                        longValue = mutableState5.getValue().longValue();
                                                                    }
                                                                    Function2<Long, DatePickerState, Unit> function213 = function212;
                                                                    if (function213 != null) {
                                                                        function213.invoke(Long.valueOf(longValue), DatePickerState.this);
                                                                    }
                                                                    MutableState<String> mutableState8 = mutableState6;
                                                                    DatePickerState datePickerState6 = DatePickerState.this;
                                                                    mutableState8.setValue(datePickerState6.scrollPickerState1.centerValue + datePickerState6.scrollPickerState2.centerValue + ProgressTracer.SEPARATOR + datePickerState6.scrollPickerState3.centerValue);
                                                                } else {
                                                                    KLog.INSTANCE.i("QUIDatePicker", "At least one list is scrolling, so won't call back the current onScrollEnd event.");
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        }, composer6, 136614472, 24968, 8192);
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        }), composer4, 24584, 14);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                    return Unit.INSTANCE;
                                }
                            }), composer2, i78 | 12608000, 6, com.tencent.luggage.wxa.uf.h.CTRL_INDEX);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            iVar3 = iVar5;
                            function03 = function05;
                            i66 = i79;
                            j18 = j27;
                            datePickerType3 = datePickerType2;
                            str3 = str2;
                            hVar13 = hVar12;
                            hVar14 = hVar11;
                            hVar15 = hVar9;
                            hVar16 = hVar10;
                            function26 = function25;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                            return;
                        }
                        final Function2<? super Long, ? super DatePickerState, Unit> function210 = function24;
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePickerKt$QUIDatePicker$3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Unit invoke(Composer composer3, Integer num) {
                                num.intValue();
                                QUIDatePickerKt.QUIDatePicker(i.this, datePickerType3, j18, i66, z16, str3, hVar13, hVar14, hVar15, hVar16, function1, function03, function26, function210, composer3, i16 | 1, i17, i18);
                                return Unit.INSTANCE;
                            }
                        });
                        return;
                    }
                    function23 = function22;
                    if ((i18 & 961) != 961) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i16 & 1) == 0) {
                    }
                    if (i67 != 0) {
                    }
                    if (i69 != 0) {
                    }
                    if (i19 != 0) {
                    }
                    if (i26 != 0) {
                    }
                    if (i27 != 0) {
                    }
                    if (i28 != 0) {
                    }
                    if (i29 != 0) {
                    }
                    if (i36 != 0) {
                    }
                    if (i37 != 0) {
                    }
                    if (i39 != 0) {
                    }
                    if (i46 != 0) {
                    }
                    if (i47 != 0) {
                    }
                    function02 = function04;
                    i48 = i75;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup.startReplaceableGroup(-492369756);
                    rememberedValue = startRestartGroup.rememberedValue();
                    companion = Composer.INSTANCE;
                    if (rememberedValue == companion.getEmpty()) {
                    }
                    startRestartGroup.endReplaceableGroup();
                    final MutableState<String> mutableState3 = (MutableState) rememberedValue;
                    startRestartGroup.startReplaceableGroup(-492369756);
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (rememberedValue2 == companion.getEmpty()) {
                    }
                    startRestartGroup.endReplaceableGroup();
                    final MutableState<Long> mutableState22 = (MutableState) rememberedValue2;
                    b bVar22 = (b) c.f117352a.g().acquireModule("KRCalendarModule");
                    final ICalendar b162 = bVar22.b(j16);
                    int c162 = b162.c(ICalendar.Field.YEAR);
                    int c172 = b162.c(ICalendar.Field.MONTH) + 1;
                    ICalendar.Field field2 = ICalendar.Field.DAY_OF_MONTH;
                    int c182 = b162.c(field2);
                    final int i762 = i38;
                    int c192 = b162.c(ICalendar.Field.HOUR_OF_DAY);
                    final i iVar52 = iVar2;
                    int c262 = b162.c(ICalendar.Field.MINUS);
                    final Function0<Unit> function052 = function02;
                    int c272 = b162.c(ICalendar.Field.SECOND);
                    final int i772 = i68;
                    KLog.INSTANCE.i("QUIDatePicker", "current year = " + c162 + ", month = " + c172 + ", day = " + c182 + ", hour = " + c192 + ", minute = " + c262 + ", second = " + c272);
                    startRestartGroup.startReplaceableGroup(-492369756);
                    rememberedValue3 = startRestartGroup.rememberedValue();
                    if (rememberedValue3 == companion.getEmpty()) {
                    }
                    startRestartGroup.endReplaceableGroup();
                    final List<String> arrayList22 = new ArrayList();
                    ICalendar b172 = bVar22.b(j16);
                    arrayList22.add(bVar22.a(b172.d(field2, -i48).a(), "MM\u6708dd\u65e5"));
                    i56 = i48 * 2;
                    while (i57 < i56) {
                    }
                    final List<String> arrayList32 = new ArrayList();
                    while (i58 < 24) {
                    }
                    ArrayList arrayList42 = new ArrayList();
                    while (i59 < 60) {
                    }
                    if (j16 != 0) {
                    }
                    String a172 = bVar22.a(a16, "MM\u6708dd\u65e5");
                    String a182 = bVar22.a(a16, "HH");
                    String a192 = bVar22.a(a16, "mm");
                    indexOf = arrayList22.indexOf(a172);
                    if (indexOf < 0) {
                    }
                    indexOf2 = arrayList32.indexOf(a182);
                    if (indexOf2 < 0) {
                    }
                    indexOf3 = arrayList42.indexOf(a192);
                    if (indexOf3 < 0) {
                    }
                    Triple triple2 = new Triple(Integer.valueOf(indexOf), Integer.valueOf(indexOf2), Integer.valueOf(indexOf3));
                    final int intValue4 = ((Number) triple2.component1()).intValue();
                    final int intValue22 = ((Number) triple2.component2()).intValue();
                    final int intValue32 = ((Number) triple2.component3()).intValue();
                    startRestartGroup.startReplaceableGroup(-492369756);
                    rememberedValue4 = startRestartGroup.rememberedValue();
                    companion2 = Composer.INSTANCE;
                    if (rememberedValue4 == companion2.getEmpty()) {
                    }
                    startRestartGroup.endReplaceableGroup();
                    final DatePickerState datePickerState2 = (DatePickerState) rememberedValue4;
                    AlertDialogTransitionType alertDialogTransitionType2 = AlertDialogTransitionType.DIRECTION_FROM_BOTTOM;
                    h a262 = h.INSTANCE.a(0.5f);
                    Alignment alignment2 = Alignment.BottomCenter;
                    Boolean valueOf32 = Boolean.valueOf(z16);
                    int i782 = (i772 >> 12) & 14;
                    startRestartGroup.startReplaceableGroup(1618982084);
                    changed = startRestartGroup.changed(valueOf32) | startRestartGroup.changed(function1) | startRestartGroup.changed(function052);
                    rememberedValue5 = startRestartGroup.rememberedValue();
                    if (!changed) {
                    }
                    rememberedValue5 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePickerKt$QUIDatePicker$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Unit invoke() {
                            if (z16) {
                                function1.invoke(Boolean.TRUE);
                            }
                            Function0<Unit> function06 = function052;
                            if (function06 != null) {
                                function06.invoke();
                            }
                            return Unit.INSTANCE;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue5);
                    startRestartGroup.endReplaceableGroup();
                    final DatePickerType datePickerType52 = datePickerType2;
                    final h hVar172 = hVar12;
                    final h hVar182 = hVar11;
                    final h hVar192 = hVar9;
                    final h hVar202 = hVar10;
                    final List<String> arrayList52 = arrayList;
                    final String str52 = str2;
                    final long j262 = j17;
                    final Function2<? super Long, ? super DatePickerState, Unit> function282 = function24;
                    final b bVar32 = bVar;
                    final Function2<? super Long, ? super DatePickerState, Unit> function292 = function25;
                    composer2 = startRestartGroup;
                    int i792 = i65;
                    long j272 = j17;
                    AlertCustomDialogKt.a(z16, false, a262, null, alertDialogTransitionType2, (Function0) rememberedValue5, null, alignment2, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1500388696, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePickerKt$QUIDatePicker$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Unit invoke(Composer composer3, Integer num) {
                            Composer composer4 = composer3;
                            int intValue42 = num.intValue();
                            if ((intValue42 & 11) == 2 && composer4.getSkipping()) {
                                composer4.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1500388696, intValue42, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePicker.<anonymous> (QUIDatePicker.kt:198)");
                                }
                                i d16 = ViewEventPropUpdaterKt.d(ModifiersKt.k(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(ModifiersKt.c(i.INSTANCE, QUIToken.color$default("bg_middle_standard")), 0.0f, 1, null), 292.0f), 8.0f, 8.0f, 0.0f, 0.0f), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePickerKt$QUIDatePicker$2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                                        return Unit.INSTANCE;
                                    }
                                }, 3, null);
                                final DatePickerType datePickerType6 = DatePickerType.this;
                                final i iVar6 = iVar52;
                                final DatePickerState datePickerState22 = datePickerState2;
                                final h hVar21 = hVar172;
                                final h hVar22 = hVar182;
                                final h hVar23 = hVar192;
                                final h hVar24 = hVar202;
                                final List<String> list = arrayList22;
                                final int i85 = intValue4;
                                final List<String> list2 = arrayList32;
                                final int i86 = intValue22;
                                final List<String> list3 = arrayList52;
                                final int i87 = intValue32;
                                final Function1<? super Boolean, Unit> function12 = function1;
                                final int i88 = i762;
                                final String str6 = str52;
                                final int i89 = i772;
                                final MutableState<Long> mutableState32 = mutableState22;
                                final long j28 = j262;
                                final ICalendar iCalendar = b162;
                                final Function2<? super Long, ? super DatePickerState, Unit> function2102 = function282;
                                final b bVar4 = bVar32;
                                final Function2<? super Long, ? super DatePickerState, Unit> function211 = function292;
                                final MutableState<String> mutableState4 = mutableState3;
                                ColumnKt.a(d16, null, null, null, ComposableLambdaKt.composableLambda(composer4, -1062491951, true, new Function3<com.tencent.ntcompose.foundation.layout.d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePickerKt$QUIDatePicker$2.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(com.tencent.ntcompose.foundation.layout.d dVar, Composer composer5, Integer num2) {
                                        Composer composer6 = composer5;
                                        int intValue5 = num2.intValue();
                                        if ((intValue5 & 81) == 16 && composer6.getSkipping()) {
                                            composer6.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1062491951, intValue5, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePicker.<anonymous>.<anonymous> (QUIDatePicker.kt:205)");
                                            }
                                            RowKt.a(ModifiersKt.c(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 56.0f), 16.0f, 0.0f, 16.0f, 0.0f, 10, null), QUIToken.color$default("bg_middle_light")), a.f339245a.e(), Alignment.INSTANCE.c(), null, null, ComposableLambdaKt.composableLambda(composer6, 445825263, true, new Function3<n, Composer, Integer, Unit>(function12, i88, str6, i89, mutableState32, j28, iCalendar, function2102, datePickerState22) { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePickerKt.QUIDatePicker.2.2.1
                                                public final /* synthetic */ int $$dirty;
                                                public final /* synthetic */ ICalendar $calendarInstance;
                                                public final /* synthetic */ Function1<Boolean, Unit> $cancelButtonClick;
                                                public final /* synthetic */ MutableState<Long> $curTimestamp;
                                                public final /* synthetic */ DatePickerState $datePickerState;
                                                public final /* synthetic */ Function2<Long, DatePickerState, Unit> $onSelected;
                                                public final /* synthetic */ long $targetTimeMillis;
                                                public final /* synthetic */ String $titleText;

                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(3);
                                                    this.$titleText = r3;
                                                    this.$$dirty = r4;
                                                    this.$curTimestamp = r5;
                                                    this.$targetTimeMillis = r6;
                                                    this.$calendarInstance = r8;
                                                    this.$onSelected = r9;
                                                    this.$datePickerState = r10;
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public final Unit invoke(n nVar, Composer composer7, Integer num3) {
                                                    int i95;
                                                    n nVar2 = nVar;
                                                    Composer composer8 = composer7;
                                                    int intValue6 = num3.intValue();
                                                    if ((intValue6 & 14) == 0) {
                                                        i95 = (composer8.changed(nVar2) ? 4 : 2) | intValue6;
                                                    } else {
                                                        i95 = intValue6;
                                                    }
                                                    if ((i95 & 91) == 18 && composer8.getSkipping()) {
                                                        composer8.skipToGroupEnd();
                                                    } else {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(445825263, intValue6, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePicker.<anonymous>.<anonymous>.<anonymous> (QUIDatePicker.kt:212)");
                                                        }
                                                        i.Companion companion3 = i.INSTANCE;
                                                        i a27 = ModifiersKt.a(ComposeLayoutPropUpdaterKt.v(companion3, 65.0f, 45.0f), "\u53d6\u6d88");
                                                        final Function1<? super Boolean, Unit> function13 = this.$cancelButtonClick;
                                                        composer8.startReplaceableGroup(1157296644);
                                                        boolean changed2 = composer8.changed(function13);
                                                        Object rememberedValue6 = composer8.rememberedValue();
                                                        if (changed2 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                                            rememberedValue6 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePickerKt$QUIDatePicker$2$2$1$1$1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                /* JADX WARN: Multi-variable type inference failed */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ClickParams clickParams) {
                                                                    function13.invoke(Boolean.FALSE);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            };
                                                            composer8.updateRememberedValue(rememberedValue6);
                                                        }
                                                        composer8.endReplaceableGroup();
                                                        i d17 = ViewEventPropUpdaterKt.d(a27, false, null, (Function1) rememberedValue6, 3, null);
                                                        Alignment alignment22 = Alignment.Center;
                                                        BoxKt.a(d17, alignment22, null, ComposableSingletons$QUIDatePickerKt.f29lambda1, composer8, 3128, 4);
                                                        TextKt.a(this.$titleText, nVar2.a(companion3, 1.0f), null, QUIToken.color$default("text_primary"), Float.valueOf(17.0f), null, bp3.c.INSTANCE.f(), null, null, null, ai.f(ai.INSTANCE.a()), Float.valueOf(24.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer8, ((this.$$dirty >> 15) & 14) | 1601600, 48, 0, 134214564);
                                                        i a28 = ModifiersKt.a(ComposeLayoutPropUpdaterKt.v(companion3, 65.0f, 45.0f), "\u786e\u8ba4");
                                                        final MutableState<Long> mutableState5 = this.$curTimestamp;
                                                        final long j29 = this.$targetTimeMillis;
                                                        final ICalendar iCalendar2 = this.$calendarInstance;
                                                        final Function2<? super Long, ? super DatePickerState, Unit> function212 = this.$onSelected;
                                                        final DatePickerState datePickerState3 = this.$datePickerState;
                                                        BoxKt.a(ViewEventPropUpdaterKt.d(a28, false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePickerKt.QUIDatePicker.2.2.1.2
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            /* JADX WARN: Multi-variable type inference failed */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                long longValue;
                                                                if (mutableState5.getValue().longValue() == 0) {
                                                                    longValue = j29;
                                                                    if (longValue == 0) {
                                                                        longValue = iCalendar2.a();
                                                                    }
                                                                } else {
                                                                    longValue = mutableState5.getValue().longValue();
                                                                }
                                                                Function2<Long, DatePickerState, Unit> function213 = function212;
                                                                if (function213 != null) {
                                                                    function213.invoke(Long.valueOf(longValue), datePickerState3);
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        }, 3, null), alignment22, null, ComposableSingletons$QUIDatePickerKt.f30lambda2, composer8, 3128, 4);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }), composer6, 196680, 24);
                                            DatePickerType datePickerType7 = DatePickerType.this;
                                            if (datePickerType7 != DatePickerType.Normal && datePickerType7 == DatePickerType.QZone) {
                                                i iVar7 = iVar6;
                                                final DatePickerState datePickerState3 = datePickerState22;
                                                h hVar25 = hVar21;
                                                h hVar26 = hVar22;
                                                h hVar27 = hVar23;
                                                h hVar28 = hVar24;
                                                List<String> list4 = list;
                                                final int i95 = i85;
                                                List<String> list5 = list2;
                                                final int i96 = i86;
                                                List<String> list6 = list3;
                                                final int i97 = i87;
                                                final MutableState<Long> mutableState5 = mutableState32;
                                                final long j29 = j28;
                                                final b bVar5 = bVar4;
                                                final ICalendar iCalendar2 = iCalendar;
                                                final Function2<? super Long, ? super DatePickerState, Unit> function212 = function211;
                                                final MutableState<String> mutableState6 = mutableState4;
                                                QUIDatePickerKt.access$QUIDatePickerImpl(iVar7, datePickerState3, hVar25, hVar26, hVar27, hVar28, list4, i95, list5, i96, list6, i97, 3, 0, 50.0f, new Function1<DatePickerState, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePickerKt.QUIDatePicker.2.2.2
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(DatePickerState datePickerState4) {
                                                        long longValue;
                                                        DatePickerState datePickerState5 = DatePickerState.this;
                                                        if (!datePickerState5.scrollPickerState1.isScrolling && !datePickerState5.scrollPickerState2.isScrolling && !datePickerState5.scrollPickerState3.isScrolling) {
                                                            MutableState<Long> mutableState7 = mutableState5;
                                                            int i98 = i95;
                                                            int i99 = i96;
                                                            int i100 = i97;
                                                            ICalendar b18 = bVar5.b(j29);
                                                            b18.d(ICalendar.Field.DAY_OF_MONTH, datePickerState5.scrollPickerState1.centerItemIndex - i98);
                                                            b18.d(ICalendar.Field.HOUR_OF_DAY, datePickerState5.scrollPickerState2.centerItemIndex - i99);
                                                            b18.d(ICalendar.Field.MINUS, datePickerState5.scrollPickerState3.centerItemIndex - i100);
                                                            mutableState7.setValue(Long.valueOf(b18.a()));
                                                            if (mutableState5.getValue().longValue() == 0) {
                                                                longValue = j29;
                                                                if (longValue == 0) {
                                                                    longValue = iCalendar2.a();
                                                                }
                                                            } else {
                                                                longValue = mutableState5.getValue().longValue();
                                                            }
                                                            Function2<Long, DatePickerState, Unit> function213 = function212;
                                                            if (function213 != null) {
                                                                function213.invoke(Long.valueOf(longValue), DatePickerState.this);
                                                            }
                                                            MutableState<String> mutableState8 = mutableState6;
                                                            DatePickerState datePickerState6 = DatePickerState.this;
                                                            mutableState8.setValue(datePickerState6.scrollPickerState1.centerValue + datePickerState6.scrollPickerState2.centerValue + ProgressTracer.SEPARATOR + datePickerState6.scrollPickerState3.centerValue);
                                                        } else {
                                                            KLog.INSTANCE.i("QUIDatePicker", "At least one list is scrolling, so won't call back the current onScrollEnd event.");
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                }, composer6, 136614472, 24968, 8192);
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer4, 24584, 14);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer2, i782 | 12608000, 6, com.tencent.luggage.wxa.uf.h.CTRL_INDEX);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    iVar3 = iVar52;
                    function03 = function052;
                    i66 = i792;
                    j18 = j272;
                    datePickerType3 = datePickerType2;
                    str3 = str2;
                    hVar13 = hVar12;
                    hVar14 = hVar11;
                    hVar15 = hVar9;
                    hVar16 = hVar10;
                    function26 = function25;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                i47 = i18 & 8192;
                if (i47 == 0) {
                }
                function23 = function22;
                if ((i18 & 961) != 961) {
                }
                startRestartGroup.startDefaults();
                if ((i16 & 1) == 0) {
                }
                if (i67 != 0) {
                }
                if (i69 != 0) {
                }
                if (i19 != 0) {
                }
                if (i26 != 0) {
                }
                if (i27 != 0) {
                }
                if (i28 != 0) {
                }
                if (i29 != 0) {
                }
                if (i36 != 0) {
                }
                if (i37 != 0) {
                }
                if (i39 != 0) {
                }
                if (i46 != 0) {
                }
                if (i47 != 0) {
                }
                function02 = function04;
                i48 = i75;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                startRestartGroup.startReplaceableGroup(-492369756);
                rememberedValue = startRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (rememberedValue == companion.getEmpty()) {
                }
                startRestartGroup.endReplaceableGroup();
                final MutableState<String> mutableState32 = (MutableState) rememberedValue;
                startRestartGroup.startReplaceableGroup(-492369756);
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == companion.getEmpty()) {
                }
                startRestartGroup.endReplaceableGroup();
                final MutableState<Long> mutableState222 = (MutableState) rememberedValue2;
                b bVar222 = (b) c.f117352a.g().acquireModule("KRCalendarModule");
                final ICalendar b1622 = bVar222.b(j16);
                int c1622 = b1622.c(ICalendar.Field.YEAR);
                int c1722 = b1622.c(ICalendar.Field.MONTH) + 1;
                ICalendar.Field field22 = ICalendar.Field.DAY_OF_MONTH;
                int c1822 = b1622.c(field22);
                final int i7622 = i38;
                int c1922 = b1622.c(ICalendar.Field.HOUR_OF_DAY);
                final i iVar522 = iVar2;
                int c2622 = b1622.c(ICalendar.Field.MINUS);
                final Function0<Unit> function0522 = function02;
                int c2722 = b1622.c(ICalendar.Field.SECOND);
                final int i7722 = i68;
                KLog.INSTANCE.i("QUIDatePicker", "current year = " + c1622 + ", month = " + c1722 + ", day = " + c1822 + ", hour = " + c1922 + ", minute = " + c2622 + ", second = " + c2722);
                startRestartGroup.startReplaceableGroup(-492369756);
                rememberedValue3 = startRestartGroup.rememberedValue();
                if (rememberedValue3 == companion.getEmpty()) {
                }
                startRestartGroup.endReplaceableGroup();
                final List<String> arrayList222 = new ArrayList();
                ICalendar b1722 = bVar222.b(j16);
                arrayList222.add(bVar222.a(b1722.d(field22, -i48).a(), "MM\u6708dd\u65e5"));
                i56 = i48 * 2;
                while (i57 < i56) {
                }
                final List<String> arrayList322 = new ArrayList();
                while (i58 < 24) {
                }
                ArrayList arrayList422 = new ArrayList();
                while (i59 < 60) {
                }
                if (j16 != 0) {
                }
                String a1722 = bVar222.a(a16, "MM\u6708dd\u65e5");
                String a1822 = bVar222.a(a16, "HH");
                String a1922 = bVar222.a(a16, "mm");
                indexOf = arrayList222.indexOf(a1722);
                if (indexOf < 0) {
                }
                indexOf2 = arrayList322.indexOf(a1822);
                if (indexOf2 < 0) {
                }
                indexOf3 = arrayList422.indexOf(a1922);
                if (indexOf3 < 0) {
                }
                Triple triple22 = new Triple(Integer.valueOf(indexOf), Integer.valueOf(indexOf2), Integer.valueOf(indexOf3));
                final int intValue42 = ((Number) triple22.component1()).intValue();
                final int intValue222 = ((Number) triple22.component2()).intValue();
                final int intValue322 = ((Number) triple22.component3()).intValue();
                startRestartGroup.startReplaceableGroup(-492369756);
                rememberedValue4 = startRestartGroup.rememberedValue();
                companion2 = Composer.INSTANCE;
                if (rememberedValue4 == companion2.getEmpty()) {
                }
                startRestartGroup.endReplaceableGroup();
                final DatePickerState datePickerState22 = (DatePickerState) rememberedValue4;
                AlertDialogTransitionType alertDialogTransitionType22 = AlertDialogTransitionType.DIRECTION_FROM_BOTTOM;
                h a2622 = h.INSTANCE.a(0.5f);
                Alignment alignment22 = Alignment.BottomCenter;
                Boolean valueOf322 = Boolean.valueOf(z16);
                int i7822 = (i7722 >> 12) & 14;
                startRestartGroup.startReplaceableGroup(1618982084);
                changed = startRestartGroup.changed(valueOf322) | startRestartGroup.changed(function1) | startRestartGroup.changed(function0522);
                rememberedValue5 = startRestartGroup.rememberedValue();
                if (!changed) {
                }
                rememberedValue5 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePickerKt$QUIDatePicker$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        if (z16) {
                            function1.invoke(Boolean.TRUE);
                        }
                        Function0<Unit> function06 = function0522;
                        if (function06 != null) {
                            function06.invoke();
                        }
                        return Unit.INSTANCE;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue5);
                startRestartGroup.endReplaceableGroup();
                final DatePickerType datePickerType522 = datePickerType2;
                final h hVar1722 = hVar12;
                final h hVar1822 = hVar11;
                final h hVar1922 = hVar9;
                final h hVar2022 = hVar10;
                final List<String> arrayList522 = arrayList;
                final String str522 = str2;
                final long j2622 = j17;
                final Function2<? super Long, ? super DatePickerState, Unit> function2822 = function24;
                final b bVar322 = bVar;
                final Function2<? super Long, ? super DatePickerState, Unit> function2922 = function25;
                composer2 = startRestartGroup;
                int i7922 = i65;
                long j2722 = j17;
                AlertCustomDialogKt.a(z16, false, a2622, null, alertDialogTransitionType22, (Function0) rememberedValue5, null, alignment22, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1500388696, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePickerKt$QUIDatePicker$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Unit invoke(Composer composer3, Integer num) {
                        Composer composer4 = composer3;
                        int intValue422 = num.intValue();
                        if ((intValue422 & 11) == 2 && composer4.getSkipping()) {
                            composer4.skipToGroupEnd();
                        } else {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1500388696, intValue422, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePicker.<anonymous> (QUIDatePicker.kt:198)");
                            }
                            i d16 = ViewEventPropUpdaterKt.d(ModifiersKt.k(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(ModifiersKt.c(i.INSTANCE, QUIToken.color$default("bg_middle_standard")), 0.0f, 1, null), 292.0f), 8.0f, 8.0f, 0.0f, 0.0f), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePickerKt$QUIDatePicker$2.1
                                @Override // kotlin.jvm.functions.Function1
                                public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                                    return Unit.INSTANCE;
                                }
                            }, 3, null);
                            final DatePickerType datePickerType6 = DatePickerType.this;
                            final i iVar6 = iVar522;
                            final DatePickerState datePickerState222 = datePickerState22;
                            final h hVar21 = hVar1722;
                            final h hVar22 = hVar1822;
                            final h hVar23 = hVar1922;
                            final h hVar24 = hVar2022;
                            final List<String> list = arrayList222;
                            final int i85 = intValue42;
                            final List<String> list2 = arrayList322;
                            final int i86 = intValue222;
                            final List<String> list3 = arrayList522;
                            final int i87 = intValue322;
                            final Function1<? super Boolean, Unit> function12 = function1;
                            final int i88 = i7622;
                            final String str6 = str522;
                            final int i89 = i7722;
                            final MutableState<Long> mutableState322 = mutableState222;
                            final long j28 = j2622;
                            final ICalendar iCalendar = b1622;
                            final Function2<? super Long, ? super DatePickerState, Unit> function2102 = function2822;
                            final b bVar4 = bVar322;
                            final Function2<? super Long, ? super DatePickerState, Unit> function211 = function2922;
                            final MutableState<String> mutableState4 = mutableState32;
                            ColumnKt.a(d16, null, null, null, ComposableLambdaKt.composableLambda(composer4, -1062491951, true, new Function3<com.tencent.ntcompose.foundation.layout.d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePickerKt$QUIDatePicker$2.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public final Unit invoke(com.tencent.ntcompose.foundation.layout.d dVar, Composer composer5, Integer num2) {
                                    Composer composer6 = composer5;
                                    int intValue5 = num2.intValue();
                                    if ((intValue5 & 81) == 16 && composer6.getSkipping()) {
                                        composer6.skipToGroupEnd();
                                    } else {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1062491951, intValue5, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePicker.<anonymous>.<anonymous> (QUIDatePicker.kt:205)");
                                        }
                                        RowKt.a(ModifiersKt.c(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 56.0f), 16.0f, 0.0f, 16.0f, 0.0f, 10, null), QUIToken.color$default("bg_middle_light")), a.f339245a.e(), Alignment.INSTANCE.c(), null, null, ComposableLambdaKt.composableLambda(composer6, 445825263, true, new Function3<n, Composer, Integer, Unit>(function12, i88, str6, i89, mutableState322, j28, iCalendar, function2102, datePickerState222) { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePickerKt.QUIDatePicker.2.2.1
                                            public final /* synthetic */ int $$dirty;
                                            public final /* synthetic */ ICalendar $calendarInstance;
                                            public final /* synthetic */ Function1<Boolean, Unit> $cancelButtonClick;
                                            public final /* synthetic */ MutableState<Long> $curTimestamp;
                                            public final /* synthetic */ DatePickerState $datePickerState;
                                            public final /* synthetic */ Function2<Long, DatePickerState, Unit> $onSelected;
                                            public final /* synthetic */ long $targetTimeMillis;
                                            public final /* synthetic */ String $titleText;

                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(3);
                                                this.$titleText = r3;
                                                this.$$dirty = r4;
                                                this.$curTimestamp = r5;
                                                this.$targetTimeMillis = r6;
                                                this.$calendarInstance = r8;
                                                this.$onSelected = r9;
                                                this.$datePickerState = r10;
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public final Unit invoke(n nVar, Composer composer7, Integer num3) {
                                                int i95;
                                                n nVar2 = nVar;
                                                Composer composer8 = composer7;
                                                int intValue6 = num3.intValue();
                                                if ((intValue6 & 14) == 0) {
                                                    i95 = (composer8.changed(nVar2) ? 4 : 2) | intValue6;
                                                } else {
                                                    i95 = intValue6;
                                                }
                                                if ((i95 & 91) == 18 && composer8.getSkipping()) {
                                                    composer8.skipToGroupEnd();
                                                } else {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(445825263, intValue6, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePicker.<anonymous>.<anonymous>.<anonymous> (QUIDatePicker.kt:212)");
                                                    }
                                                    i.Companion companion3 = i.INSTANCE;
                                                    i a27 = ModifiersKt.a(ComposeLayoutPropUpdaterKt.v(companion3, 65.0f, 45.0f), "\u53d6\u6d88");
                                                    final Function1<? super Boolean, Unit> function13 = this.$cancelButtonClick;
                                                    composer8.startReplaceableGroup(1157296644);
                                                    boolean changed2 = composer8.changed(function13);
                                                    Object rememberedValue6 = composer8.rememberedValue();
                                                    if (changed2 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                                        rememberedValue6 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePickerKt$QUIDatePicker$2$2$1$1$1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            /* JADX WARN: Multi-variable type inference failed */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                function13.invoke(Boolean.FALSE);
                                                                return Unit.INSTANCE;
                                                            }
                                                        };
                                                        composer8.updateRememberedValue(rememberedValue6);
                                                    }
                                                    composer8.endReplaceableGroup();
                                                    i d17 = ViewEventPropUpdaterKt.d(a27, false, null, (Function1) rememberedValue6, 3, null);
                                                    Alignment alignment222 = Alignment.Center;
                                                    BoxKt.a(d17, alignment222, null, ComposableSingletons$QUIDatePickerKt.f29lambda1, composer8, 3128, 4);
                                                    TextKt.a(this.$titleText, nVar2.a(companion3, 1.0f), null, QUIToken.color$default("text_primary"), Float.valueOf(17.0f), null, bp3.c.INSTANCE.f(), null, null, null, ai.f(ai.INSTANCE.a()), Float.valueOf(24.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer8, ((this.$$dirty >> 15) & 14) | 1601600, 48, 0, 134214564);
                                                    i a28 = ModifiersKt.a(ComposeLayoutPropUpdaterKt.v(companion3, 65.0f, 45.0f), "\u786e\u8ba4");
                                                    final MutableState<Long> mutableState5 = this.$curTimestamp;
                                                    final long j29 = this.$targetTimeMillis;
                                                    final ICalendar iCalendar2 = this.$calendarInstance;
                                                    final Function2<? super Long, ? super DatePickerState, Unit> function212 = this.$onSelected;
                                                    final DatePickerState datePickerState3 = this.$datePickerState;
                                                    BoxKt.a(ViewEventPropUpdaterKt.d(a28, false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePickerKt.QUIDatePicker.2.2.1.2
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        /* JADX WARN: Multi-variable type inference failed */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ClickParams clickParams) {
                                                            long longValue;
                                                            if (mutableState5.getValue().longValue() == 0) {
                                                                longValue = j29;
                                                                if (longValue == 0) {
                                                                    longValue = iCalendar2.a();
                                                                }
                                                            } else {
                                                                longValue = mutableState5.getValue().longValue();
                                                            }
                                                            Function2<Long, DatePickerState, Unit> function213 = function212;
                                                            if (function213 != null) {
                                                                function213.invoke(Long.valueOf(longValue), datePickerState3);
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    }, 3, null), alignment222, null, ComposableSingletons$QUIDatePickerKt.f30lambda2, composer8, 3128, 4);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        }), composer6, 196680, 24);
                                        DatePickerType datePickerType7 = DatePickerType.this;
                                        if (datePickerType7 != DatePickerType.Normal && datePickerType7 == DatePickerType.QZone) {
                                            i iVar7 = iVar6;
                                            final DatePickerState datePickerState3 = datePickerState222;
                                            h hVar25 = hVar21;
                                            h hVar26 = hVar22;
                                            h hVar27 = hVar23;
                                            h hVar28 = hVar24;
                                            List<String> list4 = list;
                                            final int i95 = i85;
                                            List<String> list5 = list2;
                                            final int i96 = i86;
                                            List<String> list6 = list3;
                                            final int i97 = i87;
                                            final MutableState<Long> mutableState5 = mutableState322;
                                            final long j29 = j28;
                                            final b bVar5 = bVar4;
                                            final ICalendar iCalendar2 = iCalendar;
                                            final Function2<? super Long, ? super DatePickerState, Unit> function212 = function211;
                                            final MutableState<String> mutableState6 = mutableState4;
                                            QUIDatePickerKt.access$QUIDatePickerImpl(iVar7, datePickerState3, hVar25, hVar26, hVar27, hVar28, list4, i95, list5, i96, list6, i97, 3, 0, 50.0f, new Function1<DatePickerState, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePickerKt.QUIDatePicker.2.2.2
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(DatePickerState datePickerState4) {
                                                    long longValue;
                                                    DatePickerState datePickerState5 = DatePickerState.this;
                                                    if (!datePickerState5.scrollPickerState1.isScrolling && !datePickerState5.scrollPickerState2.isScrolling && !datePickerState5.scrollPickerState3.isScrolling) {
                                                        MutableState<Long> mutableState7 = mutableState5;
                                                        int i98 = i95;
                                                        int i99 = i96;
                                                        int i100 = i97;
                                                        ICalendar b18 = bVar5.b(j29);
                                                        b18.d(ICalendar.Field.DAY_OF_MONTH, datePickerState5.scrollPickerState1.centerItemIndex - i98);
                                                        b18.d(ICalendar.Field.HOUR_OF_DAY, datePickerState5.scrollPickerState2.centerItemIndex - i99);
                                                        b18.d(ICalendar.Field.MINUS, datePickerState5.scrollPickerState3.centerItemIndex - i100);
                                                        mutableState7.setValue(Long.valueOf(b18.a()));
                                                        if (mutableState5.getValue().longValue() == 0) {
                                                            longValue = j29;
                                                            if (longValue == 0) {
                                                                longValue = iCalendar2.a();
                                                            }
                                                        } else {
                                                            longValue = mutableState5.getValue().longValue();
                                                        }
                                                        Function2<Long, DatePickerState, Unit> function213 = function212;
                                                        if (function213 != null) {
                                                            function213.invoke(Long.valueOf(longValue), DatePickerState.this);
                                                        }
                                                        MutableState<String> mutableState8 = mutableState6;
                                                        DatePickerState datePickerState6 = DatePickerState.this;
                                                        mutableState8.setValue(datePickerState6.scrollPickerState1.centerValue + datePickerState6.scrollPickerState2.centerValue + ProgressTracer.SEPARATOR + datePickerState6.scrollPickerState3.centerValue);
                                                    } else {
                                                        KLog.INSTANCE.i("QUIDatePicker", "At least one list is scrolling, so won't call back the current onScrollEnd event.");
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }, composer6, 136614472, 24968, 8192);
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                    return Unit.INSTANCE;
                                }
                            }), composer4, 24584, 14);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }), composer2, i7822 | 12608000, 6, com.tencent.luggage.wxa.uf.h.CTRL_INDEX);
                if (ComposerKt.isTraceInProgress()) {
                }
                iVar3 = iVar522;
                function03 = function0522;
                i66 = i7922;
                j18 = j2722;
                datePickerType3 = datePickerType2;
                str3 = str2;
                hVar13 = hVar12;
                hVar14 = hVar11;
                hVar15 = hVar9;
                hVar16 = hVar10;
                function26 = function25;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            if ((i18 & 16) != 0) {
            }
            i27 = i18 & 32;
            if (i27 != 0) {
            }
            i28 = i18 & 64;
            if (i28 != 0) {
            }
            i29 = i18 & 128;
            if (i29 != 0) {
            }
            i36 = i18 & 256;
            if (i36 != 0) {
            }
            i37 = i18 & 512;
            if (i37 != 0) {
            }
            if ((i18 & 1024) != 0) {
            }
            i39 = i18 & 2048;
            if (i39 != 0) {
            }
            i46 = i18 & 4096;
            if (i46 != 0) {
            }
            i47 = i18 & 8192;
            if (i47 == 0) {
            }
            function23 = function22;
            if ((i18 & 961) != 961) {
            }
            startRestartGroup.startDefaults();
            if ((i16 & 1) == 0) {
            }
            if (i67 != 0) {
            }
            if (i69 != 0) {
            }
            if (i19 != 0) {
            }
            if (i26 != 0) {
            }
            if (i27 != 0) {
            }
            if (i28 != 0) {
            }
            if (i29 != 0) {
            }
            if (i36 != 0) {
            }
            if (i37 != 0) {
            }
            if (i39 != 0) {
            }
            if (i46 != 0) {
            }
            if (i47 != 0) {
            }
            function02 = function04;
            i48 = i75;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.startReplaceableGroup(-492369756);
            rememberedValue = startRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
            }
            startRestartGroup.endReplaceableGroup();
            final MutableState<String> mutableState322 = (MutableState) rememberedValue;
            startRestartGroup.startReplaceableGroup(-492369756);
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
            }
            startRestartGroup.endReplaceableGroup();
            final MutableState<Long> mutableState2222 = (MutableState) rememberedValue2;
            b bVar2222 = (b) c.f117352a.g().acquireModule("KRCalendarModule");
            final ICalendar b16222 = bVar2222.b(j16);
            int c16222 = b16222.c(ICalendar.Field.YEAR);
            int c17222 = b16222.c(ICalendar.Field.MONTH) + 1;
            ICalendar.Field field222 = ICalendar.Field.DAY_OF_MONTH;
            int c18222 = b16222.c(field222);
            final int i76222 = i38;
            int c19222 = b16222.c(ICalendar.Field.HOUR_OF_DAY);
            final i iVar5222 = iVar2;
            int c26222 = b16222.c(ICalendar.Field.MINUS);
            final Function0<Unit> function05222 = function02;
            int c27222 = b16222.c(ICalendar.Field.SECOND);
            final int i77222 = i68;
            KLog.INSTANCE.i("QUIDatePicker", "current year = " + c16222 + ", month = " + c17222 + ", day = " + c18222 + ", hour = " + c19222 + ", minute = " + c26222 + ", second = " + c27222);
            startRestartGroup.startReplaceableGroup(-492369756);
            rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == companion.getEmpty()) {
            }
            startRestartGroup.endReplaceableGroup();
            final List<String> arrayList2222 = new ArrayList();
            ICalendar b17222 = bVar2222.b(j16);
            arrayList2222.add(bVar2222.a(b17222.d(field222, -i48).a(), "MM\u6708dd\u65e5"));
            i56 = i48 * 2;
            while (i57 < i56) {
            }
            final List<String> arrayList3222 = new ArrayList();
            while (i58 < 24) {
            }
            ArrayList arrayList4222 = new ArrayList();
            while (i59 < 60) {
            }
            if (j16 != 0) {
            }
            String a17222 = bVar2222.a(a16, "MM\u6708dd\u65e5");
            String a18222 = bVar2222.a(a16, "HH");
            String a19222 = bVar2222.a(a16, "mm");
            indexOf = arrayList2222.indexOf(a17222);
            if (indexOf < 0) {
            }
            indexOf2 = arrayList3222.indexOf(a18222);
            if (indexOf2 < 0) {
            }
            indexOf3 = arrayList4222.indexOf(a19222);
            if (indexOf3 < 0) {
            }
            Triple triple222 = new Triple(Integer.valueOf(indexOf), Integer.valueOf(indexOf2), Integer.valueOf(indexOf3));
            final int intValue422 = ((Number) triple222.component1()).intValue();
            final int intValue2222 = ((Number) triple222.component2()).intValue();
            final int intValue3222 = ((Number) triple222.component3()).intValue();
            startRestartGroup.startReplaceableGroup(-492369756);
            rememberedValue4 = startRestartGroup.rememberedValue();
            companion2 = Composer.INSTANCE;
            if (rememberedValue4 == companion2.getEmpty()) {
            }
            startRestartGroup.endReplaceableGroup();
            final DatePickerState datePickerState222 = (DatePickerState) rememberedValue4;
            AlertDialogTransitionType alertDialogTransitionType222 = AlertDialogTransitionType.DIRECTION_FROM_BOTTOM;
            h a26222 = h.INSTANCE.a(0.5f);
            Alignment alignment222 = Alignment.BottomCenter;
            Boolean valueOf3222 = Boolean.valueOf(z16);
            int i78222 = (i77222 >> 12) & 14;
            startRestartGroup.startReplaceableGroup(1618982084);
            changed = startRestartGroup.changed(valueOf3222) | startRestartGroup.changed(function1) | startRestartGroup.changed(function05222);
            rememberedValue5 = startRestartGroup.rememberedValue();
            if (!changed) {
            }
            rememberedValue5 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePickerKt$QUIDatePicker$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    if (z16) {
                        function1.invoke(Boolean.TRUE);
                    }
                    Function0<Unit> function06 = function05222;
                    if (function06 != null) {
                        function06.invoke();
                    }
                    return Unit.INSTANCE;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue5);
            startRestartGroup.endReplaceableGroup();
            final DatePickerType datePickerType5222 = datePickerType2;
            final h hVar17222 = hVar12;
            final h hVar18222 = hVar11;
            final h hVar19222 = hVar9;
            final h hVar20222 = hVar10;
            final List<String> arrayList5222 = arrayList;
            final String str5222 = str2;
            final long j26222 = j17;
            final Function2<? super Long, ? super DatePickerState, Unit> function28222 = function24;
            final b bVar3222 = bVar;
            final Function2<? super Long, ? super DatePickerState, Unit> function29222 = function25;
            composer2 = startRestartGroup;
            int i79222 = i65;
            long j27222 = j17;
            AlertCustomDialogKt.a(z16, false, a26222, null, alertDialogTransitionType222, (Function0) rememberedValue5, null, alignment222, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1500388696, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePickerKt$QUIDatePicker$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer3, Integer num) {
                    Composer composer4 = composer3;
                    int intValue4222 = num.intValue();
                    if ((intValue4222 & 11) == 2 && composer4.getSkipping()) {
                        composer4.skipToGroupEnd();
                    } else {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1500388696, intValue4222, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePicker.<anonymous> (QUIDatePicker.kt:198)");
                        }
                        i d16 = ViewEventPropUpdaterKt.d(ModifiersKt.k(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(ModifiersKt.c(i.INSTANCE, QUIToken.color$default("bg_middle_standard")), 0.0f, 1, null), 292.0f), 8.0f, 8.0f, 0.0f, 0.0f), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePickerKt$QUIDatePicker$2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                                return Unit.INSTANCE;
                            }
                        }, 3, null);
                        final DatePickerType datePickerType6 = DatePickerType.this;
                        final i iVar6 = iVar5222;
                        final DatePickerState datePickerState2222 = datePickerState222;
                        final h hVar21 = hVar17222;
                        final h hVar22 = hVar18222;
                        final h hVar23 = hVar19222;
                        final h hVar24 = hVar20222;
                        final List<String> list = arrayList2222;
                        final int i85 = intValue422;
                        final List<String> list2 = arrayList3222;
                        final int i86 = intValue2222;
                        final List<String> list3 = arrayList5222;
                        final int i87 = intValue3222;
                        final Function1<? super Boolean, Unit> function12 = function1;
                        final int i88 = i76222;
                        final String str6 = str5222;
                        final int i89 = i77222;
                        final MutableState<Long> mutableState3222 = mutableState2222;
                        final long j28 = j26222;
                        final ICalendar iCalendar = b16222;
                        final Function2<? super Long, ? super DatePickerState, Unit> function2102 = function28222;
                        final b bVar4 = bVar3222;
                        final Function2<? super Long, ? super DatePickerState, Unit> function211 = function29222;
                        final MutableState<String> mutableState4 = mutableState322;
                        ColumnKt.a(d16, null, null, null, ComposableLambdaKt.composableLambda(composer4, -1062491951, true, new Function3<com.tencent.ntcompose.foundation.layout.d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePickerKt$QUIDatePicker$2.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(com.tencent.ntcompose.foundation.layout.d dVar, Composer composer5, Integer num2) {
                                Composer composer6 = composer5;
                                int intValue5 = num2.intValue();
                                if ((intValue5 & 81) == 16 && composer6.getSkipping()) {
                                    composer6.skipToGroupEnd();
                                } else {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1062491951, intValue5, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePicker.<anonymous>.<anonymous> (QUIDatePicker.kt:205)");
                                    }
                                    RowKt.a(ModifiersKt.c(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 56.0f), 16.0f, 0.0f, 16.0f, 0.0f, 10, null), QUIToken.color$default("bg_middle_light")), a.f339245a.e(), Alignment.INSTANCE.c(), null, null, ComposableLambdaKt.composableLambda(composer6, 445825263, true, new Function3<n, Composer, Integer, Unit>(function12, i88, str6, i89, mutableState3222, j28, iCalendar, function2102, datePickerState2222) { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePickerKt.QUIDatePicker.2.2.1
                                        public final /* synthetic */ int $$dirty;
                                        public final /* synthetic */ ICalendar $calendarInstance;
                                        public final /* synthetic */ Function1<Boolean, Unit> $cancelButtonClick;
                                        public final /* synthetic */ MutableState<Long> $curTimestamp;
                                        public final /* synthetic */ DatePickerState $datePickerState;
                                        public final /* synthetic */ Function2<Long, DatePickerState, Unit> $onSelected;
                                        public final /* synthetic */ long $targetTimeMillis;
                                        public final /* synthetic */ String $titleText;

                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(3);
                                            this.$titleText = r3;
                                            this.$$dirty = r4;
                                            this.$curTimestamp = r5;
                                            this.$targetTimeMillis = r6;
                                            this.$calendarInstance = r8;
                                            this.$onSelected = r9;
                                            this.$datePickerState = r10;
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public final Unit invoke(n nVar, Composer composer7, Integer num3) {
                                            int i95;
                                            n nVar2 = nVar;
                                            Composer composer8 = composer7;
                                            int intValue6 = num3.intValue();
                                            if ((intValue6 & 14) == 0) {
                                                i95 = (composer8.changed(nVar2) ? 4 : 2) | intValue6;
                                            } else {
                                                i95 = intValue6;
                                            }
                                            if ((i95 & 91) == 18 && composer8.getSkipping()) {
                                                composer8.skipToGroupEnd();
                                            } else {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(445825263, intValue6, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePicker.<anonymous>.<anonymous>.<anonymous> (QUIDatePicker.kt:212)");
                                                }
                                                i.Companion companion3 = i.INSTANCE;
                                                i a27 = ModifiersKt.a(ComposeLayoutPropUpdaterKt.v(companion3, 65.0f, 45.0f), "\u53d6\u6d88");
                                                final Function1<? super Boolean, Unit> function13 = this.$cancelButtonClick;
                                                composer8.startReplaceableGroup(1157296644);
                                                boolean changed2 = composer8.changed(function13);
                                                Object rememberedValue6 = composer8.rememberedValue();
                                                if (changed2 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                                    rememberedValue6 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePickerKt$QUIDatePicker$2$2$1$1$1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        /* JADX WARN: Multi-variable type inference failed */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ClickParams clickParams) {
                                                            function13.invoke(Boolean.FALSE);
                                                            return Unit.INSTANCE;
                                                        }
                                                    };
                                                    composer8.updateRememberedValue(rememberedValue6);
                                                }
                                                composer8.endReplaceableGroup();
                                                i d17 = ViewEventPropUpdaterKt.d(a27, false, null, (Function1) rememberedValue6, 3, null);
                                                Alignment alignment2222 = Alignment.Center;
                                                BoxKt.a(d17, alignment2222, null, ComposableSingletons$QUIDatePickerKt.f29lambda1, composer8, 3128, 4);
                                                TextKt.a(this.$titleText, nVar2.a(companion3, 1.0f), null, QUIToken.color$default("text_primary"), Float.valueOf(17.0f), null, bp3.c.INSTANCE.f(), null, null, null, ai.f(ai.INSTANCE.a()), Float.valueOf(24.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer8, ((this.$$dirty >> 15) & 14) | 1601600, 48, 0, 134214564);
                                                i a28 = ModifiersKt.a(ComposeLayoutPropUpdaterKt.v(companion3, 65.0f, 45.0f), "\u786e\u8ba4");
                                                final MutableState<Long> mutableState5 = this.$curTimestamp;
                                                final long j29 = this.$targetTimeMillis;
                                                final ICalendar iCalendar2 = this.$calendarInstance;
                                                final Function2<? super Long, ? super DatePickerState, Unit> function212 = this.$onSelected;
                                                final DatePickerState datePickerState3 = this.$datePickerState;
                                                BoxKt.a(ViewEventPropUpdaterKt.d(a28, false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePickerKt.QUIDatePicker.2.2.1.2
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        long longValue;
                                                        if (mutableState5.getValue().longValue() == 0) {
                                                            longValue = j29;
                                                            if (longValue == 0) {
                                                                longValue = iCalendar2.a();
                                                            }
                                                        } else {
                                                            longValue = mutableState5.getValue().longValue();
                                                        }
                                                        Function2<Long, DatePickerState, Unit> function213 = function212;
                                                        if (function213 != null) {
                                                            function213.invoke(Long.valueOf(longValue), datePickerState3);
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                }, 3, null), alignment2222, null, ComposableSingletons$QUIDatePickerKt.f30lambda2, composer8, 3128, 4);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer6, 196680, 24);
                                    DatePickerType datePickerType7 = DatePickerType.this;
                                    if (datePickerType7 != DatePickerType.Normal && datePickerType7 == DatePickerType.QZone) {
                                        i iVar7 = iVar6;
                                        final DatePickerState datePickerState3 = datePickerState2222;
                                        h hVar25 = hVar21;
                                        h hVar26 = hVar22;
                                        h hVar27 = hVar23;
                                        h hVar28 = hVar24;
                                        List<String> list4 = list;
                                        final int i95 = i85;
                                        List<String> list5 = list2;
                                        final int i96 = i86;
                                        List<String> list6 = list3;
                                        final int i97 = i87;
                                        final MutableState<Long> mutableState5 = mutableState3222;
                                        final long j29 = j28;
                                        final b bVar5 = bVar4;
                                        final ICalendar iCalendar2 = iCalendar;
                                        final Function2<? super Long, ? super DatePickerState, Unit> function212 = function211;
                                        final MutableState<String> mutableState6 = mutableState4;
                                        QUIDatePickerKt.access$QUIDatePickerImpl(iVar7, datePickerState3, hVar25, hVar26, hVar27, hVar28, list4, i95, list5, i96, list6, i97, 3, 0, 50.0f, new Function1<DatePickerState, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePickerKt.QUIDatePicker.2.2.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(DatePickerState datePickerState4) {
                                                long longValue;
                                                DatePickerState datePickerState5 = DatePickerState.this;
                                                if (!datePickerState5.scrollPickerState1.isScrolling && !datePickerState5.scrollPickerState2.isScrolling && !datePickerState5.scrollPickerState3.isScrolling) {
                                                    MutableState<Long> mutableState7 = mutableState5;
                                                    int i98 = i95;
                                                    int i99 = i96;
                                                    int i100 = i97;
                                                    ICalendar b18 = bVar5.b(j29);
                                                    b18.d(ICalendar.Field.DAY_OF_MONTH, datePickerState5.scrollPickerState1.centerItemIndex - i98);
                                                    b18.d(ICalendar.Field.HOUR_OF_DAY, datePickerState5.scrollPickerState2.centerItemIndex - i99);
                                                    b18.d(ICalendar.Field.MINUS, datePickerState5.scrollPickerState3.centerItemIndex - i100);
                                                    mutableState7.setValue(Long.valueOf(b18.a()));
                                                    if (mutableState5.getValue().longValue() == 0) {
                                                        longValue = j29;
                                                        if (longValue == 0) {
                                                            longValue = iCalendar2.a();
                                                        }
                                                    } else {
                                                        longValue = mutableState5.getValue().longValue();
                                                    }
                                                    Function2<Long, DatePickerState, Unit> function213 = function212;
                                                    if (function213 != null) {
                                                        function213.invoke(Long.valueOf(longValue), DatePickerState.this);
                                                    }
                                                    MutableState<String> mutableState8 = mutableState6;
                                                    DatePickerState datePickerState6 = DatePickerState.this;
                                                    mutableState8.setValue(datePickerState6.scrollPickerState1.centerValue + datePickerState6.scrollPickerState2.centerValue + ProgressTracer.SEPARATOR + datePickerState6.scrollPickerState3.centerValue);
                                                } else {
                                                    KLog.INSTANCE.i("QUIDatePicker", "At least one list is scrolling, so won't call back the current onScrollEnd event.");
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        }, composer6, 136614472, 24968, 8192);
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer4, 24584, 14);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    return Unit.INSTANCE;
                }
            }), composer2, i78222 | 12608000, 6, com.tencent.luggage.wxa.uf.h.CTRL_INDEX);
            if (ComposerKt.isTraceInProgress()) {
            }
            iVar3 = iVar5222;
            function03 = function05222;
            i66 = i79222;
            j18 = j27222;
            datePickerType3 = datePickerType2;
            str3 = str2;
            hVar13 = hVar12;
            hVar14 = hVar11;
            hVar15 = hVar9;
            hVar16 = hVar10;
            function26 = function25;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        i19 = i18 & 4;
        if (i19 == 0) {
        }
        i26 = i18 & 8;
        if (i26 == 0) {
        }
        if ((i18 & 16) != 0) {
        }
        i27 = i18 & 32;
        if (i27 != 0) {
        }
        i28 = i18 & 64;
        if (i28 != 0) {
        }
        i29 = i18 & 128;
        if (i29 != 0) {
        }
        i36 = i18 & 256;
        if (i36 != 0) {
        }
        i37 = i18 & 512;
        if (i37 != 0) {
        }
        if ((i18 & 1024) != 0) {
        }
        i39 = i18 & 2048;
        if (i39 != 0) {
        }
        i46 = i18 & 4096;
        if (i46 != 0) {
        }
        i47 = i18 & 8192;
        if (i47 == 0) {
        }
        function23 = function22;
        if ((i18 & 961) != 961) {
        }
        startRestartGroup.startDefaults();
        if ((i16 & 1) == 0) {
        }
        if (i67 != 0) {
        }
        if (i69 != 0) {
        }
        if (i19 != 0) {
        }
        if (i26 != 0) {
        }
        if (i27 != 0) {
        }
        if (i28 != 0) {
        }
        if (i29 != 0) {
        }
        if (i36 != 0) {
        }
        if (i37 != 0) {
        }
        if (i39 != 0) {
        }
        if (i46 != 0) {
        }
        if (i47 != 0) {
        }
        function02 = function04;
        i48 = i75;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceableGroup(-492369756);
        rememberedValue = startRestartGroup.rememberedValue();
        companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState<String> mutableState3222 = (MutableState) rememberedValue;
        startRestartGroup.startReplaceableGroup(-492369756);
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == companion.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState<Long> mutableState22222 = (MutableState) rememberedValue2;
        b bVar22222 = (b) c.f117352a.g().acquireModule("KRCalendarModule");
        final ICalendar b162222 = bVar22222.b(j16);
        int c162222 = b162222.c(ICalendar.Field.YEAR);
        int c172222 = b162222.c(ICalendar.Field.MONTH) + 1;
        ICalendar.Field field2222 = ICalendar.Field.DAY_OF_MONTH;
        int c182222 = b162222.c(field2222);
        final int i762222 = i38;
        int c192222 = b162222.c(ICalendar.Field.HOUR_OF_DAY);
        final i iVar52222 = iVar2;
        int c262222 = b162222.c(ICalendar.Field.MINUS);
        final Function0<Unit> function052222 = function02;
        int c272222 = b162222.c(ICalendar.Field.SECOND);
        final int i772222 = i68;
        KLog.INSTANCE.i("QUIDatePicker", "current year = " + c162222 + ", month = " + c172222 + ", day = " + c182222 + ", hour = " + c192222 + ", minute = " + c262222 + ", second = " + c272222);
        startRestartGroup.startReplaceableGroup(-492369756);
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (rememberedValue3 == companion.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        final List<String> arrayList22222 = new ArrayList();
        ICalendar b172222 = bVar22222.b(j16);
        arrayList22222.add(bVar22222.a(b172222.d(field2222, -i48).a(), "MM\u6708dd\u65e5"));
        i56 = i48 * 2;
        while (i57 < i56) {
        }
        final List<String> arrayList32222 = new ArrayList();
        while (i58 < 24) {
        }
        ArrayList arrayList42222 = new ArrayList();
        while (i59 < 60) {
        }
        if (j16 != 0) {
        }
        String a172222 = bVar22222.a(a16, "MM\u6708dd\u65e5");
        String a182222 = bVar22222.a(a16, "HH");
        String a192222 = bVar22222.a(a16, "mm");
        indexOf = arrayList22222.indexOf(a172222);
        if (indexOf < 0) {
        }
        indexOf2 = arrayList32222.indexOf(a182222);
        if (indexOf2 < 0) {
        }
        indexOf3 = arrayList42222.indexOf(a192222);
        if (indexOf3 < 0) {
        }
        Triple triple2222 = new Triple(Integer.valueOf(indexOf), Integer.valueOf(indexOf2), Integer.valueOf(indexOf3));
        final int intValue4222 = ((Number) triple2222.component1()).intValue();
        final int intValue22222 = ((Number) triple2222.component2()).intValue();
        final int intValue32222 = ((Number) triple2222.component3()).intValue();
        startRestartGroup.startReplaceableGroup(-492369756);
        rememberedValue4 = startRestartGroup.rememberedValue();
        companion2 = Composer.INSTANCE;
        if (rememberedValue4 == companion2.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        final DatePickerState datePickerState2222 = (DatePickerState) rememberedValue4;
        AlertDialogTransitionType alertDialogTransitionType2222 = AlertDialogTransitionType.DIRECTION_FROM_BOTTOM;
        h a262222 = h.INSTANCE.a(0.5f);
        Alignment alignment2222 = Alignment.BottomCenter;
        Boolean valueOf32222 = Boolean.valueOf(z16);
        int i782222 = (i772222 >> 12) & 14;
        startRestartGroup.startReplaceableGroup(1618982084);
        changed = startRestartGroup.changed(valueOf32222) | startRestartGroup.changed(function1) | startRestartGroup.changed(function052222);
        rememberedValue5 = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        rememberedValue5 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePickerKt$QUIDatePicker$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                if (z16) {
                    function1.invoke(Boolean.TRUE);
                }
                Function0<Unit> function06 = function052222;
                if (function06 != null) {
                    function06.invoke();
                }
                return Unit.INSTANCE;
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue5);
        startRestartGroup.endReplaceableGroup();
        final DatePickerType datePickerType52222 = datePickerType2;
        final h hVar172222 = hVar12;
        final h hVar182222 = hVar11;
        final h hVar192222 = hVar9;
        final h hVar202222 = hVar10;
        final List<String> arrayList52222 = arrayList;
        final String str52222 = str2;
        final long j262222 = j17;
        final Function2<? super Long, ? super DatePickerState, Unit> function282222 = function24;
        final b bVar32222 = bVar;
        final Function2<? super Long, ? super DatePickerState, Unit> function292222 = function25;
        composer2 = startRestartGroup;
        int i792222 = i65;
        long j272222 = j17;
        AlertCustomDialogKt.a(z16, false, a262222, null, alertDialogTransitionType2222, (Function0) rememberedValue5, null, alignment2222, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1500388696, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePickerKt$QUIDatePicker$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer3, Integer num) {
                Composer composer4 = composer3;
                int intValue42222 = num.intValue();
                if ((intValue42222 & 11) == 2 && composer4.getSkipping()) {
                    composer4.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1500388696, intValue42222, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePicker.<anonymous> (QUIDatePicker.kt:198)");
                    }
                    i d16 = ViewEventPropUpdaterKt.d(ModifiersKt.k(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(ModifiersKt.c(i.INSTANCE, QUIToken.color$default("bg_middle_standard")), 0.0f, 1, null), 292.0f), 8.0f, 8.0f, 0.0f, 0.0f), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePickerKt$QUIDatePicker$2.1
                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                            return Unit.INSTANCE;
                        }
                    }, 3, null);
                    final DatePickerType datePickerType6 = DatePickerType.this;
                    final i iVar6 = iVar52222;
                    final DatePickerState datePickerState22222 = datePickerState2222;
                    final h hVar21 = hVar172222;
                    final h hVar22 = hVar182222;
                    final h hVar23 = hVar192222;
                    final h hVar24 = hVar202222;
                    final List<String> list = arrayList22222;
                    final int i85 = intValue4222;
                    final List<String> list2 = arrayList32222;
                    final int i86 = intValue22222;
                    final List<String> list3 = arrayList52222;
                    final int i87 = intValue32222;
                    final Function1<? super Boolean, Unit> function12 = function1;
                    final int i88 = i762222;
                    final String str6 = str52222;
                    final int i89 = i772222;
                    final MutableState<Long> mutableState32222 = mutableState22222;
                    final long j28 = j262222;
                    final ICalendar iCalendar = b162222;
                    final Function2<? super Long, ? super DatePickerState, Unit> function2102 = function282222;
                    final b bVar4 = bVar32222;
                    final Function2<? super Long, ? super DatePickerState, Unit> function211 = function292222;
                    final MutableState<String> mutableState4 = mutableState3222;
                    ColumnKt.a(d16, null, null, null, ComposableLambdaKt.composableLambda(composer4, -1062491951, true, new Function3<com.tencent.ntcompose.foundation.layout.d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePickerKt$QUIDatePicker$2.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(com.tencent.ntcompose.foundation.layout.d dVar, Composer composer5, Integer num2) {
                            Composer composer6 = composer5;
                            int intValue5 = num2.intValue();
                            if ((intValue5 & 81) == 16 && composer6.getSkipping()) {
                                composer6.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1062491951, intValue5, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePicker.<anonymous>.<anonymous> (QUIDatePicker.kt:205)");
                                }
                                RowKt.a(ModifiersKt.c(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 56.0f), 16.0f, 0.0f, 16.0f, 0.0f, 10, null), QUIToken.color$default("bg_middle_light")), a.f339245a.e(), Alignment.INSTANCE.c(), null, null, ComposableLambdaKt.composableLambda(composer6, 445825263, true, new Function3<n, Composer, Integer, Unit>(function12, i88, str6, i89, mutableState32222, j28, iCalendar, function2102, datePickerState22222) { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePickerKt.QUIDatePicker.2.2.1
                                    public final /* synthetic */ int $$dirty;
                                    public final /* synthetic */ ICalendar $calendarInstance;
                                    public final /* synthetic */ Function1<Boolean, Unit> $cancelButtonClick;
                                    public final /* synthetic */ MutableState<Long> $curTimestamp;
                                    public final /* synthetic */ DatePickerState $datePickerState;
                                    public final /* synthetic */ Function2<Long, DatePickerState, Unit> $onSelected;
                                    public final /* synthetic */ long $targetTimeMillis;
                                    public final /* synthetic */ String $titleText;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(3);
                                        this.$titleText = r3;
                                        this.$$dirty = r4;
                                        this.$curTimestamp = r5;
                                        this.$targetTimeMillis = r6;
                                        this.$calendarInstance = r8;
                                        this.$onSelected = r9;
                                        this.$datePickerState = r10;
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(n nVar, Composer composer7, Integer num3) {
                                        int i95;
                                        n nVar2 = nVar;
                                        Composer composer8 = composer7;
                                        int intValue6 = num3.intValue();
                                        if ((intValue6 & 14) == 0) {
                                            i95 = (composer8.changed(nVar2) ? 4 : 2) | intValue6;
                                        } else {
                                            i95 = intValue6;
                                        }
                                        if ((i95 & 91) == 18 && composer8.getSkipping()) {
                                            composer8.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(445825263, intValue6, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePicker.<anonymous>.<anonymous>.<anonymous> (QUIDatePicker.kt:212)");
                                            }
                                            i.Companion companion3 = i.INSTANCE;
                                            i a27 = ModifiersKt.a(ComposeLayoutPropUpdaterKt.v(companion3, 65.0f, 45.0f), "\u53d6\u6d88");
                                            final Function1<? super Boolean, Unit> function13 = this.$cancelButtonClick;
                                            composer8.startReplaceableGroup(1157296644);
                                            boolean changed2 = composer8.changed(function13);
                                            Object rememberedValue6 = composer8.rememberedValue();
                                            if (changed2 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                                rememberedValue6 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePickerKt$QUIDatePicker$2$2$1$1$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        function13.invoke(Boolean.FALSE);
                                                        return Unit.INSTANCE;
                                                    }
                                                };
                                                composer8.updateRememberedValue(rememberedValue6);
                                            }
                                            composer8.endReplaceableGroup();
                                            i d17 = ViewEventPropUpdaterKt.d(a27, false, null, (Function1) rememberedValue6, 3, null);
                                            Alignment alignment22222 = Alignment.Center;
                                            BoxKt.a(d17, alignment22222, null, ComposableSingletons$QUIDatePickerKt.f29lambda1, composer8, 3128, 4);
                                            TextKt.a(this.$titleText, nVar2.a(companion3, 1.0f), null, QUIToken.color$default("text_primary"), Float.valueOf(17.0f), null, bp3.c.INSTANCE.f(), null, null, null, ai.f(ai.INSTANCE.a()), Float.valueOf(24.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer8, ((this.$$dirty >> 15) & 14) | 1601600, 48, 0, 134214564);
                                            i a28 = ModifiersKt.a(ComposeLayoutPropUpdaterKt.v(companion3, 65.0f, 45.0f), "\u786e\u8ba4");
                                            final MutableState<Long> mutableState5 = this.$curTimestamp;
                                            final long j29 = this.$targetTimeMillis;
                                            final ICalendar iCalendar2 = this.$calendarInstance;
                                            final Function2<? super Long, ? super DatePickerState, Unit> function212 = this.$onSelected;
                                            final DatePickerState datePickerState3 = this.$datePickerState;
                                            BoxKt.a(ViewEventPropUpdaterKt.d(a28, false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePickerKt.QUIDatePicker.2.2.1.2
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ClickParams clickParams) {
                                                    long longValue;
                                                    if (mutableState5.getValue().longValue() == 0) {
                                                        longValue = j29;
                                                        if (longValue == 0) {
                                                            longValue = iCalendar2.a();
                                                        }
                                                    } else {
                                                        longValue = mutableState5.getValue().longValue();
                                                    }
                                                    Function2<Long, DatePickerState, Unit> function213 = function212;
                                                    if (function213 != null) {
                                                        function213.invoke(Long.valueOf(longValue), datePickerState3);
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }, 3, null), alignment22222, null, ComposableSingletons$QUIDatePickerKt.f30lambda2, composer8, 3128, 4);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer6, 196680, 24);
                                DatePickerType datePickerType7 = DatePickerType.this;
                                if (datePickerType7 != DatePickerType.Normal && datePickerType7 == DatePickerType.QZone) {
                                    i iVar7 = iVar6;
                                    final DatePickerState datePickerState3 = datePickerState22222;
                                    h hVar25 = hVar21;
                                    h hVar26 = hVar22;
                                    h hVar27 = hVar23;
                                    h hVar28 = hVar24;
                                    List<String> list4 = list;
                                    final int i95 = i85;
                                    List<String> list5 = list2;
                                    final int i96 = i86;
                                    List<String> list6 = list3;
                                    final int i97 = i87;
                                    final MutableState<Long> mutableState5 = mutableState32222;
                                    final long j29 = j28;
                                    final b bVar5 = bVar4;
                                    final ICalendar iCalendar2 = iCalendar;
                                    final Function2<? super Long, ? super DatePickerState, Unit> function212 = function211;
                                    final MutableState<String> mutableState6 = mutableState4;
                                    QUIDatePickerKt.access$QUIDatePickerImpl(iVar7, datePickerState3, hVar25, hVar26, hVar27, hVar28, list4, i95, list5, i96, list6, i97, 3, 0, 50.0f, new Function1<DatePickerState, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePickerKt.QUIDatePicker.2.2.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(DatePickerState datePickerState4) {
                                            long longValue;
                                            DatePickerState datePickerState5 = DatePickerState.this;
                                            if (!datePickerState5.scrollPickerState1.isScrolling && !datePickerState5.scrollPickerState2.isScrolling && !datePickerState5.scrollPickerState3.isScrolling) {
                                                MutableState<Long> mutableState7 = mutableState5;
                                                int i98 = i95;
                                                int i99 = i96;
                                                int i100 = i97;
                                                ICalendar b18 = bVar5.b(j29);
                                                b18.d(ICalendar.Field.DAY_OF_MONTH, datePickerState5.scrollPickerState1.centerItemIndex - i98);
                                                b18.d(ICalendar.Field.HOUR_OF_DAY, datePickerState5.scrollPickerState2.centerItemIndex - i99);
                                                b18.d(ICalendar.Field.MINUS, datePickerState5.scrollPickerState3.centerItemIndex - i100);
                                                mutableState7.setValue(Long.valueOf(b18.a()));
                                                if (mutableState5.getValue().longValue() == 0) {
                                                    longValue = j29;
                                                    if (longValue == 0) {
                                                        longValue = iCalendar2.a();
                                                    }
                                                } else {
                                                    longValue = mutableState5.getValue().longValue();
                                                }
                                                Function2<Long, DatePickerState, Unit> function213 = function212;
                                                if (function213 != null) {
                                                    function213.invoke(Long.valueOf(longValue), DatePickerState.this);
                                                }
                                                MutableState<String> mutableState8 = mutableState6;
                                                DatePickerState datePickerState6 = DatePickerState.this;
                                                mutableState8.setValue(datePickerState6.scrollPickerState1.centerValue + datePickerState6.scrollPickerState2.centerValue + ProgressTracer.SEPARATOR + datePickerState6.scrollPickerState3.centerValue);
                                            } else {
                                                KLog.INSTANCE.i("QUIDatePicker", "At least one list is scrolling, so won't call back the current onScrollEnd event.");
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }, composer6, 136614472, 24968, 8192);
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer4, 24584, 14);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), composer2, i782222 | 12608000, 6, com.tencent.luggage.wxa.uf.h.CTRL_INDEX);
        if (ComposerKt.isTraceInProgress()) {
        }
        iVar3 = iVar52222;
        function03 = function052222;
        i66 = i792222;
        j18 = j272222;
        datePickerType3 = datePickerType2;
        str3 = str2;
        hVar13 = hVar12;
        hVar14 = hVar11;
        hVar15 = hVar9;
        hVar16 = hVar10;
        function26 = function25;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    public static final void access$QUIDatePickerImpl(i iVar, final DatePickerState datePickerState, h hVar, h hVar2, h hVar3, h hVar4, final List list, int i3, final List list2, int i16, final List list3, int i17, int i18, int i19, float f16, final Function1 function1, Composer composer, final int i26, final int i27, final int i28) {
        h hVar5;
        int i29;
        h hVar6;
        h hVar7;
        h hVar8;
        Composer startRestartGroup = composer.startRestartGroup(197676345);
        i iVar2 = (i28 & 1) != 0 ? i.INSTANCE : iVar;
        if ((i28 & 4) != 0) {
            i29 = i26 & (-897);
            hVar5 = h.INSTANCE.b();
        } else {
            hVar5 = hVar;
            i29 = i26;
        }
        if ((i28 & 8) != 0) {
            i29 &= -7169;
            hVar6 = h.INSTANCE.m();
        } else {
            hVar6 = hVar2;
        }
        if ((i28 & 16) != 0) {
            i29 &= -57345;
            hVar7 = new h(16777215L);
        } else {
            hVar7 = hVar3;
        }
        if ((i28 & 32) != 0) {
            i29 &= -458753;
            hVar8 = QUIToken.color$default("border_standard");
        } else {
            hVar8 = hVar4;
        }
        int i36 = (i28 & 128) != 0 ? 0 : i3;
        int i37 = (i28 & 512) != 0 ? 0 : i16;
        int i38 = (i28 & 2048) != 0 ? 0 : i17;
        int i39 = (i28 & 4096) != 0 ? 1 : i18;
        int i46 = (i28 & 8192) != 0 ? 5 : i19;
        float f17 = (i28 & 16384) != 0 ? 50.0f : f16;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(197676345, i29, i27, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePickerImpl (QUIDatePicker.kt:312)");
        }
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = GuideBannerCardAnimationViewKt$$ExternalSyntheticOutline0.m(0.0f, null, 2, null, startRestartGroup);
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState mutableState = (MutableState) rememberedValue;
        final h hVar9 = hVar6;
        final int i47 = i46;
        final float f18 = f17;
        final h hVar10 = hVar7;
        final h hVar11 = hVar8;
        final int i48 = i39;
        final int i49 = i36;
        final h hVar12 = hVar5;
        final int i56 = i29;
        final int i57 = i37;
        final int i58 = i38;
        BoxKt.a(iVar2, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1401381875, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePickerKt$QUIDatePickerImpl$1
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
                        ComposerKt.traceEventStart(1401381875, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePickerImpl.<anonymous> (QUIDatePicker.kt:334)");
                    }
                    i j3 = ComposeLayoutPropUpdaterKt.j(ModifiersKt.d(i.INSTANCE, h.this), 0.0f, 1, null);
                    final MutableState<Float> mutableState2 = mutableState;
                    composer3.startReplaceableGroup(1157296644);
                    boolean changed = composer3.changed(mutableState2);
                    Object rememberedValue2 = composer3.rememberedValue();
                    if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue2 = new Function1<ap3.a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePickerKt$QUIDatePickerImpl$1$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ap3.a aVar) {
                                mutableState2.setValue(Float.valueOf(aVar.getWidth()));
                                return Unit.INSTANCE;
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue2);
                    }
                    composer3.endReplaceableGroup();
                    i k3 = ViewEventPropUpdaterKt.k(j3, (Function1) rememberedValue2);
                    final DatePickerState datePickerState2 = datePickerState;
                    final int i59 = i48;
                    final int i65 = i49;
                    final List<String> list4 = list;
                    final int i66 = i47;
                    final float f19 = f18;
                    final h hVar13 = hVar12;
                    final int i67 = i56;
                    final int i68 = i27;
                    final int i69 = i57;
                    final List<String> list5 = list2;
                    final int i75 = i58;
                    final List<String> list6 = list3;
                    final MutableState<Float> mutableState3 = mutableState;
                    final Function1<DatePickerState, Unit> function12 = function1;
                    RowKt.a(k3, null, null, null, null, ComposableLambdaKt.composableLambda(composer3, 1358814097, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePickerKt$QUIDatePickerImpl$1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(n nVar, Composer composer4, Integer num2) {
                            float floatValue;
                            float floatValue2;
                            float floatValue3;
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1358814097, intValue2, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePickerImpl.<anonymous>.<anonymous> (QUIDatePicker.kt:342)");
                                }
                                ScrollPickerState scrollPickerState = DatePickerState.this.scrollPickerState1;
                                floatValue = ((Number) mutableState3.getValue()).floatValue();
                                float f26 = floatValue / i59;
                                int i76 = i65;
                                List<String> list7 = list4;
                                int i77 = i66;
                                float f27 = f19;
                                h hVar14 = hVar13;
                                final DatePickerState datePickerState3 = DatePickerState.this;
                                Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePickerKt.QUIDatePickerImpl.1.2.1
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Unit invoke() {
                                        DatePickerState.this.scrollPickerState1.isScrolling = true;
                                        return Unit.INSTANCE;
                                    }
                                };
                                final DatePickerState datePickerState4 = DatePickerState.this;
                                final Function1<DatePickerState, Unit> function13 = function12;
                                Function1<ScrollPickerState, Unit> function14 = new Function1<ScrollPickerState, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePickerKt.QUIDatePickerImpl.1.2.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ScrollPickerState scrollPickerState2) {
                                        DatePickerState datePickerState5 = DatePickerState.this;
                                        datePickerState5.scrollPickerState1.isScrolling = false;
                                        datePickerState5.scrollPickerState1 = scrollPickerState2;
                                        Function1<DatePickerState, Unit> function15 = function13;
                                        if (function15 != null) {
                                            function15.invoke(datePickerState5);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                };
                                int i78 = ((i67 >> 15) & 896) | 134221888;
                                int i79 = i68 << 3;
                                QUIPickerKt.ScrollPicker(null, scrollPickerState, i76, list7, i77, f27, f26, null, hVar14, function0, function14, composer5, i78 | (i79 & 57344) | (i79 & 458752), 0, 129);
                                ScrollPickerState scrollPickerState2 = DatePickerState.this.scrollPickerState2;
                                floatValue2 = ((Number) mutableState3.getValue()).floatValue();
                                float f28 = floatValue2 / i59;
                                int i85 = i69;
                                List<String> list8 = list5;
                                int i86 = i66;
                                float f29 = f19;
                                h hVar15 = hVar13;
                                final DatePickerState datePickerState5 = DatePickerState.this;
                                Function0<Unit> function02 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePickerKt.QUIDatePickerImpl.1.2.3
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Unit invoke() {
                                        DatePickerState.this.scrollPickerState2.isScrolling = true;
                                        return Unit.INSTANCE;
                                    }
                                };
                                final DatePickerState datePickerState6 = DatePickerState.this;
                                final Function1<DatePickerState, Unit> function15 = function12;
                                Function1<ScrollPickerState, Unit> function16 = new Function1<ScrollPickerState, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePickerKt.QUIDatePickerImpl.1.2.4
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ScrollPickerState scrollPickerState3) {
                                        DatePickerState datePickerState7 = DatePickerState.this;
                                        datePickerState7.scrollPickerState2.isScrolling = false;
                                        datePickerState7.scrollPickerState2 = scrollPickerState3;
                                        Function1<DatePickerState, Unit> function17 = function15;
                                        if (function17 != null) {
                                            function17.invoke(datePickerState7);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                };
                                int i87 = ((i67 >> 21) & 896) | 134221888;
                                int i88 = i68 << 3;
                                QUIPickerKt.ScrollPicker(null, scrollPickerState2, i85, list8, i86, f29, f28, null, hVar15, function02, function16, composer5, i87 | (i88 & 57344) | (i88 & 458752), 0, 129);
                                ScrollPickerState scrollPickerState3 = DatePickerState.this.scrollPickerState3;
                                floatValue3 = ((Number) mutableState3.getValue()).floatValue();
                                float f36 = floatValue3 / i59;
                                int i89 = i75;
                                List<String> list9 = list6;
                                int i95 = i66;
                                float f37 = f19;
                                h hVar16 = hVar13;
                                final DatePickerState datePickerState7 = DatePickerState.this;
                                Function0<Unit> function03 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePickerKt.QUIDatePickerImpl.1.2.5
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Unit invoke() {
                                        DatePickerState.this.scrollPickerState3.isScrolling = true;
                                        return Unit.INSTANCE;
                                    }
                                };
                                final DatePickerState datePickerState8 = DatePickerState.this;
                                final Function1<DatePickerState, Unit> function17 = function12;
                                Function1<ScrollPickerState, Unit> function18 = new Function1<ScrollPickerState, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePickerKt.QUIDatePickerImpl.1.2.6
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ScrollPickerState scrollPickerState4) {
                                        DatePickerState datePickerState9 = DatePickerState.this;
                                        datePickerState9.scrollPickerState3.isScrolling = false;
                                        datePickerState9.scrollPickerState3 = scrollPickerState4;
                                        Function1<DatePickerState, Unit> function19 = function17;
                                        if (function19 != null) {
                                            function19.invoke(datePickerState9);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                };
                                int i96 = i68 << 3;
                                QUIPickerKt.ScrollPicker(null, scrollPickerState3, i89, list9, i95, f37, f36, null, hVar16, function03, function18, composer5, (i96 & 896) | 134221888 | (i96 & 57344) | (i96 & 458752), 0, 129);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 196616, 30);
                    float f26 = i47 / 2;
                    float f27 = f18;
                    QUIDatePickerKt.gradientMaskView(f26 * f27, f27, h.this, hVar10, hVar11, composer3, 37376 | ((i27 >> 9) & 112));
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
        final i iVar3 = iVar2;
        final h hVar13 = hVar5;
        final h hVar14 = hVar6;
        final h hVar15 = hVar7;
        final h hVar16 = hVar8;
        final int i59 = i36;
        final int i65 = i37;
        final int i66 = i38;
        final int i67 = i39;
        final int i68 = i46;
        final float f19 = f17;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePickerKt$QUIDatePickerImpl$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QUIDatePickerKt.access$QUIDatePickerImpl(i.this, datePickerState, hVar13, hVar14, hVar15, hVar16, list, i59, list2, i65, list3, i66, i67, i68, f19, function1, composer2, i26 | 1, i27, i28);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void gradientMaskView(final float f16, final float f17, final h hVar, final h hVar2, final h hVar3, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(1148002624);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1148002624, i3, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.gradientMaskView (QUIDatePicker.kt:413)");
        }
        ColumnKt.a(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), a.f339245a.h(), Alignment.Horizontal.CenterHorizontally, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1396089783, true, new Function3<com.tencent.ntcompose.foundation.layout.d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePickerKt$gradientMaskView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(com.tencent.ntcompose.foundation.layout.d dVar, Composer composer2, Integer num) {
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1396089783, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.gradientMaskView.<anonymous> (QUIDatePicker.kt:424)");
                    }
                    i.Companion companion = i.INSTANCE;
                    i k3 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null), f16);
                    Direction direction = Direction.TO_BOTTOM;
                    i e16 = ModifiersKt.e(k3, direction, new j(hVar, 0.0f), new j(hVar2, 1.0f));
                    Alignment alignment = Alignment.BottomCenter;
                    final h hVar4 = hVar3;
                    BoxKt.a(e16, alignment, null, ComposableLambdaKt.composableLambda(composer3, -803249347, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePickerKt$gradientMaskView$1.1
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer4, Integer num2) {
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-803249347, intValue2, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.gradientMaskView.<anonymous>.<anonymous> (QUIDatePicker.kt:433)");
                                }
                                SpacerKt.a(ComposeLayoutPropUpdaterKt.n(ModifiersKt.d(ComposeLayoutPropUpdaterKt.k(i.INSTANCE, 0.5f), h.this), 16.0f, 0.0f, 16.0f, 0.0f, 10, null), composer5, 8, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 3128, 4);
                    SpacerKt.a(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null), f17), composer3, 8, 0);
                    i O = ModifiersKt.O(ModifiersKt.e(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null), f16), direction, new j(hVar, 0.0f), new j(hVar2, 1.0f)), new t(180.0f, 0.0f, 0.0f, 6, null), null, null, null, null, 30, null);
                    final h hVar5 = hVar3;
                    BoxKt.a(O, alignment, null, ComposableLambdaKt.composableLambda(composer3, -432195916, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePickerKt$gradientMaskView$1.2
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer4, Integer num2) {
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-432195916, intValue2, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.gradientMaskView.<anonymous>.<anonymous> (QUIDatePicker.kt:448)");
                                }
                                SpacerKt.a(ComposeLayoutPropUpdaterKt.n(ModifiersKt.d(ComposeLayoutPropUpdaterKt.k(i.INSTANCE, 0.5f), h.this), 16.0f, 0.0f, 16.0f, 0.0f, 10, null), composer5, 8, 0);
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
        }), startRestartGroup, 25032, 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDatePickerKt$gradientMaskView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QUIDatePickerKt.gradientMaskView(f16, f17, hVar, hVar2, hVar3, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
