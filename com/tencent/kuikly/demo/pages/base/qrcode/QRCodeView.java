package com.tencent.kuikly.demo.pages.base.qrcode;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.detail.model.BoxType$EnumUnboxingSharedUtility;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.directives.BindDirectivesView;
import com.tencent.kuikly.core.directives.BindDirectivesViewKt;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.CanvasView;
import com.tencent.kuikly.core.views.CanvasViewKt;
import com.tencent.kuikly.core.views.p;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.reflect.KProperty;
import kotlin.text.Regex;
import n01.a;
import n01.b;
import n01.c;
import o01.d;
import o01.f;
import o01.g;
import o01.j;
import o01.k;
import o01.l;
import o01.m;
import o01.n;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class QRCodeView extends ComposeView<b, c> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ b h(QRCodeView qRCodeView) {
        return (b) qRCodeView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ c i(QRCodeView qRCodeView) {
        return (c) qRCodeView.getEvent();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.kuikly.demo.pages.base.qrcode.QRCodeView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final QRCodeView qRCodeView = QRCodeView.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.kuikly.demo.pages.base.qrcode.QRCodeView$body$1.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        b h16 = QRCodeView.h(QRCodeView.this);
                        return (String) h16.f417917a.getValue(h16, b.f417916e[0]);
                    }
                };
                final QRCodeView qRCodeView2 = QRCodeView.this;
                BindDirectivesViewKt.a(viewContainer, function0, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.kuikly.demo.pages.base.qrcode.QRCodeView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(BindDirectivesView bindDirectivesView) {
                        final BindDirectivesView bindDirectivesView2 = bindDirectivesView;
                        b h16 = QRCodeView.h(QRCodeView.this);
                        final String str = (String) h16.f417917a.getValue(h16, b.f417916e[0]);
                        if (str == null) {
                            str = "";
                        }
                        final QRCodeView qRCodeView3 = QRCodeView.this;
                        Function1<CanvasView, Unit> function1 = new Function1<CanvasView, Unit>() { // from class: com.tencent.kuikly.demo.pages.base.qrcode.QRCodeView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(CanvasView canvasView) {
                                final QRCodeView qRCodeView4 = QRCodeView.this;
                                canvasView.attr(new Function1<Attr, Unit>() { // from class: com.tencent.kuikly.demo.pages.base.qrcode.QRCodeView.body.1.2.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Attr attr) {
                                        attr.size(QRCodeView.h(QRCodeView.this).h(), QRCodeView.h(QRCodeView.this).h());
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        };
                        final QRCodeView qRCodeView4 = QRCodeView.this;
                        CanvasViewKt.a(bindDirectivesView2, function1, new Function3<p, Float, Float, Unit>() { // from class: com.tencent.kuikly.demo.pages.base.qrcode.QRCodeView.body.1.2.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(p pVar, Float f16, Float f17) {
                                int i3;
                                j lVar;
                                int i16;
                                n[] nVarArr;
                                int i17;
                                boolean z16;
                                a aVar;
                                int i18;
                                int i19;
                                int coerceAtLeast;
                                int coerceAtLeast2;
                                int i26;
                                int i27;
                                int i28;
                                int i29;
                                int i36;
                                int[] iArr;
                                int i37;
                                C59402 c59402 = this;
                                final p pVar2 = pVar;
                                f16.floatValue();
                                f17.floatValue();
                                a aVar2 = new a(str);
                                final QRCodeView qRCodeView5 = qRCodeView4;
                                aVar2.f417915b = new Function5<Integer, Integer, Integer, Boolean, e, Unit>() { // from class: com.tencent.kuikly.demo.pages.base.qrcode.QRCodeView.body.1.2.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(5);
                                    }

                                    @Override // kotlin.jvm.functions.Function5
                                    public final Unit invoke(Integer num, Integer num2, Integer num3, Boolean bool, e eVar) {
                                        h hVar;
                                        int intValue = num.intValue();
                                        int intValue2 = num2.intValue();
                                        int intValue3 = num3.intValue();
                                        boolean booleanValue = bool.booleanValue();
                                        p.this.b();
                                        float h17 = QRCodeView.h(qRCodeView5).h() / Math.max(intValue3, 1.0f);
                                        float f18 = intValue * h17;
                                        float f19 = intValue2 * h17;
                                        p.this.k(f18, f19);
                                        float f26 = f18 + h17;
                                        p.this.i(f26, f19);
                                        float f27 = h17 + f19;
                                        p.this.i(f26, f27);
                                        p.this.i(f18, f27);
                                        p.this.i(f18, f19);
                                        p pVar3 = p.this;
                                        if (booleanValue) {
                                            b h18 = QRCodeView.h(qRCodeView5);
                                            hVar = (h) h18.f417919c.getValue(h18, b.f417916e[2]);
                                        } else {
                                            b h19 = QRCodeView.h(qRCodeView5);
                                            hVar = (h) h19.f417920d.getValue(h19, b.f417916e[3]);
                                        }
                                        pVar3.f(hVar);
                                        p.this.e();
                                        p.this.c();
                                        return Unit.INSTANCE;
                                    }
                                };
                                p01.c cVar = aVar2.f417914a;
                                String str2 = cVar.f424864a;
                                int i38 = cVar.f424865b;
                                if (new Regex("^[0-9A-Z $%*+\\-./:]+$").matches(str2)) {
                                    i3 = new Regex("^\\d+$").matches(str2) ? 1 : 2;
                                } else {
                                    i3 = 3;
                                }
                                int ordinal = BoxType$EnumUnboxingSharedUtility.ordinal(i3);
                                if (ordinal == 0) {
                                    lVar = new l(str2);
                                } else if (ordinal != 1) {
                                    if (ordinal != 2) {
                                        throw new NoWhenBranchMatchedException();
                                    }
                                    lVar = new o01.c(str2);
                                } else {
                                    lVar = new d(str2);
                                }
                                int a16 = lVar.a();
                                int a17 = p01.a.a(i38);
                                int i39 = 1;
                                while (true) {
                                    if (i39 >= a17) {
                                        i39 = 40;
                                        break;
                                    }
                                    if (a16 <= m.f421695c[i39 - 1][BoxType$EnumUnboxingSharedUtility.ordinal(i38)][BoxType$EnumUnboxingSharedUtility.ordinal(i3)]) {
                                        break;
                                    }
                                    i39++;
                                }
                                int i46 = (i39 * 4) + 17;
                                g[][] gVarArr = new g[i46];
                                int i47 = 0;
                                for (int i48 = 0; i48 < i46; i48++) {
                                    g[] gVarArr2 = new g[i46];
                                    for (int i49 = 0; i49 < i46; i49++) {
                                        gVarArr2[i49] = null;
                                    }
                                    gVarArr[i48] = gVarArr2;
                                }
                                f fVar = f.f421676a;
                                fVar.b(0, 0, gVarArr, 7);
                                int i56 = i46 - 7;
                                fVar.b(i56, 0, gVarArr, 7);
                                fVar.b(0, i56, gVarArr, 7);
                                int i57 = i39 - 1;
                                int[] iArr2 = m.f421694b[i57];
                                int length = iArr2.length;
                                int i58 = 0;
                                while (true) {
                                    int i59 = 11;
                                    if (i58 >= length) {
                                        break;
                                    }
                                    int length2 = iArr2.length;
                                    int i65 = i47;
                                    while (i65 < length2) {
                                        int i66 = iArr2[i58];
                                        int i67 = iArr2[i65];
                                        if (gVarArr[i66][i67] != null) {
                                            i37 = i59;
                                            i29 = i58;
                                            i36 = length;
                                            iArr = iArr2;
                                        } else {
                                            i29 = i58;
                                            i36 = length;
                                            iArr = iArr2;
                                            g gVar = new g(false, i66 - 1, i67 - 1, i46, new o01.h(2, i59), 5, 5, null, 128);
                                            int i68 = -2;
                                            int i69 = -2;
                                            while (i69 < 3) {
                                                int i75 = i68;
                                                while (i75 < 3) {
                                                    int i76 = i66 + i69;
                                                    int i77 = i67 + i75;
                                                    gVarArr[i76][i77] = new g(i69 == i68 || i69 == 2 || i75 == i68 || i75 == 2 || (i69 == 0 && i75 == 0), i76, i77, i46, new o01.h(2, 11), 0, 0, gVar, 96);
                                                    i75++;
                                                    i69 = i69;
                                                    i68 = -2;
                                                }
                                                i69++;
                                                i68 = -2;
                                            }
                                            i37 = 11;
                                        }
                                        i65++;
                                        i59 = i37;
                                        i58 = i29;
                                        length = i36;
                                        iArr2 = iArr;
                                    }
                                    i58++;
                                    i47 = 0;
                                }
                                int i78 = i46 - 8;
                                g gVar2 = new g(false, 8, 6, i46, new o01.h(3, 11), i78, i78, null, 128);
                                int i79 = 8;
                                while (i79 < i78) {
                                    g[] gVarArr3 = gVarArr[i79];
                                    if (gVarArr3[6] != null) {
                                        i28 = i79;
                                    } else {
                                        i28 = i79;
                                        gVarArr3[6] = new g(i79 % 2 == 0, i79, 6, i46, new o01.h(3, 11), 0, 0, gVar2, 96);
                                    }
                                    i79 = i28 + 1;
                                }
                                int i85 = 8;
                                while (i85 < i78) {
                                    g[] gVarArr4 = gVarArr[6];
                                    if (gVarArr4[i85] != null) {
                                        i27 = i85;
                                    } else {
                                        i27 = i85;
                                        gVarArr4[i27] = new g(i85 % 2 == 0, 6, i85, i46, new o01.h(3, 11), 0, 0, gVar2, 96);
                                    }
                                    i85 = i27 + 1;
                                }
                                int b16 = ((p01.a.b(cVar.f424865b) << 3) | 0) << 10;
                                int i86 = b16;
                                while (true) {
                                    int i87 = 0;
                                    for (int i88 = i86; i88 != 0; i88 >>>= 1) {
                                        i87++;
                                    }
                                    int i89 = 0;
                                    for (int i95 = 1335; i95 != 0; i95 >>>= 1) {
                                        i89++;
                                    }
                                    if (i87 - i89 < 0) {
                                        break;
                                    }
                                    int i96 = 0;
                                    for (int i97 = i86; i97 != 0; i97 >>>= 1) {
                                        i96++;
                                    }
                                    int i98 = 0;
                                    for (int i99 = 1335; i99 != 0; i99 >>>= 1) {
                                        i98++;
                                    }
                                    i86 ^= 1335 << (i96 - i98);
                                }
                                int i100 = (b16 | i86) ^ 21522;
                                int i101 = 0;
                                while (true) {
                                    if (i101 >= 15) {
                                        break;
                                    }
                                    boolean z17 = ((i100 >> i101) & 1) == 1;
                                    if (i101 < 6) {
                                        f.a(i101, 8, z17, gVarArr);
                                    } else if (i101 < 8) {
                                        f.a(i101 + 1, 8, z17, gVarArr);
                                    } else {
                                        f.a((i46 - 15) + i101, 8, z17, gVarArr);
                                    }
                                    i101++;
                                }
                                int i102 = 0;
                                for (i16 = 15; i102 < i16; i16 = 15) {
                                    boolean z18 = ((i100 >> i102) & 1) == 1;
                                    if (i102 < 8) {
                                        f.a(8, (i46 - i102) - 1, z18, gVarArr);
                                    } else if (i102 < 9) {
                                        f.a(8, 15 - i102, z18, gVarArr);
                                    } else {
                                        f.a(8, (15 - i102) - 1, z18, gVarArr);
                                    }
                                    i102++;
                                }
                                f.a(i78, 8, true, gVarArr);
                                if (i39 >= 7) {
                                    int i103 = i39 << 12;
                                    int i104 = i103;
                                    while (true) {
                                        int i105 = 0;
                                        for (int i106 = i104; i106 != 0; i106 >>>= 1) {
                                            i105++;
                                        }
                                        int i107 = 0;
                                        for (int i108 = 7973; i108 != 0; i108 >>>= 1) {
                                            i107++;
                                        }
                                        if (i105 - i107 < 0) {
                                            break;
                                        }
                                        int i109 = 0;
                                        for (int i110 = i104; i110 != 0; i110 >>>= 1) {
                                            i109++;
                                        }
                                        int i111 = 0;
                                        for (int i112 = 7973; i112 != 0; i112 >>>= 1) {
                                            i111++;
                                        }
                                        i104 ^= 7973 << (i109 - i111);
                                    }
                                    int i113 = i103 | i104;
                                    int i114 = 0;
                                    while (true) {
                                        if (i114 >= 18) {
                                            break;
                                        }
                                        f.a(i114 / 3, (((i114 % 3) + i46) - 8) - 3, ((i113 >> i114) & 1) == 1, gVarArr);
                                        i114++;
                                    }
                                    int i115 = 0;
                                    for (i26 = 18; i115 < i26; i26 = 18) {
                                        f.a((((i115 % 3) + i46) - 8) - 3, i115 / 3, ((i113 >> i115) & 1) == 1, gVarArr);
                                        i115++;
                                    }
                                }
                                int[] iArr3 = n.f421696c[BoxType$EnumUnboxingSharedUtility.ordinal(cVar.f424865b) + (i57 * 4)];
                                if (iArr3.length == 3) {
                                    n nVar = new n(iArr3[1], iArr3[2]);
                                    int i116 = iArr3[0];
                                    nVarArr = new n[i116];
                                    for (int i117 = 0; i117 < i116; i117++) {
                                        nVarArr[i117] = nVar;
                                    }
                                } else {
                                    int i118 = iArr3[0] + iArr3[3];
                                    n nVar2 = new n(iArr3[1], iArr3[2]);
                                    n nVar3 = new n(iArr3[4], iArr3[5]);
                                    n[] nVarArr2 = new n[i118];
                                    int i119 = 0;
                                    while (i119 < i118) {
                                        nVarArr2[i119] = i119 < iArr3[0] ? nVar2 : nVar3;
                                        i119++;
                                    }
                                    nVarArr = nVarArr2;
                                }
                                o01.a aVar3 = new o01.a();
                                aVar3.a(p01.b.a(cVar.f424867d.f421688a), 4);
                                int a18 = cVar.f424867d.a();
                                j jVar = cVar.f424867d;
                                jVar.getClass();
                                if (1 <= i39 && i39 < 10) {
                                    int ordinal2 = BoxType$EnumUnboxingSharedUtility.ordinal(jVar.f421688a);
                                    if (ordinal2 == 0) {
                                        i17 = 10;
                                    } else if (ordinal2 == 1) {
                                        i17 = 9;
                                    } else {
                                        if (ordinal2 != 2) {
                                            throw new NoWhenBranchMatchedException();
                                        }
                                        i17 = 8;
                                    }
                                } else if (1 <= i39 && i39 < 27) {
                                    int ordinal3 = BoxType$EnumUnboxingSharedUtility.ordinal(jVar.f421688a);
                                    if (ordinal3 == 0) {
                                        i17 = 12;
                                    } else if (ordinal3 != 1) {
                                        if (ordinal3 != 2) {
                                            throw new NoWhenBranchMatchedException();
                                        }
                                        i17 = 16;
                                    } else {
                                        i17 = 11;
                                    }
                                } else if (1 <= i39 && i39 < 41) {
                                    int ordinal4 = BoxType$EnumUnboxingSharedUtility.ordinal(jVar.f421688a);
                                    if (ordinal4 == 0) {
                                        i17 = 14;
                                    } else if (ordinal4 != 1) {
                                        if (ordinal4 != 2) {
                                            throw new NoWhenBranchMatchedException();
                                        }
                                        i17 = 16;
                                    } else {
                                        i17 = 13;
                                    }
                                } else {
                                    throw new IllegalArgumentException("'type' must be greater than 0 and cannot be greater than 40: " + i39);
                                }
                                aVar3.a(a18, i17);
                                cVar.f424867d.b(aVar3);
                                int i120 = 0;
                                for (n nVar4 : nVarArr) {
                                    i120 += nVar4.f421698b;
                                }
                                int i121 = i120 * 8;
                                int i122 = aVar3.f421673b;
                                if (i122 <= i121) {
                                    if (i122 + 4 <= i121) {
                                        z16 = false;
                                        aVar3.a(0, 4);
                                    } else {
                                        z16 = false;
                                    }
                                    while (aVar3.f421673b % 8 != 0) {
                                        aVar3.b(z16);
                                    }
                                    while (aVar3.f421673b < i121) {
                                        aVar3.a(236, 8);
                                        if (aVar3.f421673b >= i121) {
                                            break;
                                        }
                                        a aVar4 = aVar2;
                                        C59402 c594022 = c59402;
                                        o01.a aVar5 = aVar3;
                                        aVar5.a(17, 8);
                                        aVar3 = aVar5;
                                        c59402 = c594022;
                                        aVar2 = aVar4;
                                    }
                                    int length3 = nVarArr.length;
                                    int[][] iArr4 = new int[length3];
                                    for (int i123 = 0; i123 < length3; i123++) {
                                        iArr4[i123] = new int[0];
                                    }
                                    int i124 = 0;
                                    int length4 = nVarArr.length;
                                    int[][] iArr5 = new int[length4];
                                    int i125 = 0;
                                    while (i125 < length4) {
                                        iArr5[i125] = new int[i124];
                                        i125++;
                                        i124 = 0;
                                    }
                                    int length5 = nVarArr.length;
                                    int i126 = 0;
                                    int i127 = 0;
                                    int i128 = 0;
                                    int i129 = 0;
                                    int i130 = 0;
                                    int i131 = 0;
                                    while (i130 < length5) {
                                        n nVar5 = nVarArr[i130];
                                        int i132 = i128 + 1;
                                        int i133 = length5;
                                        int i134 = nVar5.f421698b;
                                        int i135 = nVar5.f421697a;
                                        int i136 = i135 - i134;
                                        int i137 = i127 + i135;
                                        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i131, i134);
                                        coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(i129, i136);
                                        int[] iArr6 = new int[i134];
                                        int i138 = 0;
                                        while (i138 < i134) {
                                            iArr6[i138] = aVar3.f421672a[i138 + i126] & 255;
                                            i138++;
                                            coerceAtLeast2 = coerceAtLeast2;
                                        }
                                        int i139 = coerceAtLeast2;
                                        iArr4[i128] = iArr6;
                                        int i140 = i126 + i134;
                                        int i141 = 1;
                                        int i142 = 0;
                                        o01.b bVar = new o01.b(new int[]{1}, 0);
                                        int i143 = 0;
                                        while (i143 < i136) {
                                            int i144 = i136;
                                            int i145 = i140;
                                            int i146 = coerceAtLeast;
                                            int[] iArr7 = new int[2];
                                            iArr7[i142] = i141;
                                            iArr7[i141] = k.f421690a.a(i143);
                                            o01.b bVar2 = new o01.b(iArr7, i142);
                                            int length6 = (bVar.f421674a.length + bVar2.f421674a.length) - i141;
                                            int[] iArr8 = new int[length6];
                                            int i147 = i142;
                                            while (i147 < length6) {
                                                iArr8[i147] = i142;
                                                i147++;
                                                i142 = 0;
                                            }
                                            int length7 = bVar.f421674a.length;
                                            int i148 = 0;
                                            while (i148 < length7) {
                                                int length8 = bVar2.f421674a.length;
                                                int i149 = length7;
                                                int i150 = 0;
                                                while (i150 < length8) {
                                                    int i151 = i148 + i150;
                                                    int i152 = iArr8[i151];
                                                    int i153 = length8;
                                                    k kVar = k.f421690a;
                                                    o01.a aVar6 = aVar3;
                                                    int i154 = bVar.f421674a[i148];
                                                    int[] iArr9 = k.f421692c;
                                                    iArr8[i151] = i152 ^ kVar.a(iArr9[i154] + iArr9[bVar2.f421674a[i150]]);
                                                    i150++;
                                                    length8 = i153;
                                                    aVar3 = aVar6;
                                                    aVar2 = aVar2;
                                                }
                                                i148++;
                                                length7 = i149;
                                            }
                                            bVar = new o01.b(iArr8, 0);
                                            i143++;
                                            i136 = i144;
                                            i140 = i145;
                                            coerceAtLeast = i146;
                                            i141 = 1;
                                            i142 = 0;
                                        }
                                        a aVar7 = aVar2;
                                        o01.a aVar8 = aVar3;
                                        int i155 = i140;
                                        int i156 = coerceAtLeast;
                                        o01.b b17 = new o01.b(iArr4[i128], bVar.f421674a.length - 1).b(bVar);
                                        int length9 = bVar.f421674a.length - 1;
                                        int[] iArr10 = new int[length9];
                                        for (int i157 = 0; i157 < length9; i157++) {
                                            int[] iArr11 = b17.f421674a;
                                            int length10 = (iArr11.length + i157) - length9;
                                            iArr10[i157] = length10 >= 0 ? iArr11[length10] : 0;
                                        }
                                        iArr5[i128] = iArr10;
                                        i130++;
                                        i127 = i137;
                                        i128 = i132;
                                        length5 = i133;
                                        i129 = i139;
                                        i126 = i155;
                                        i131 = i156;
                                        aVar3 = aVar8;
                                        aVar2 = aVar7;
                                    }
                                    a aVar9 = aVar2;
                                    int[] iArr12 = new int[i127];
                                    int i158 = 0;
                                    for (int i159 = 0; i159 < i131; i159++) {
                                        int length11 = nVarArr.length;
                                        for (int i160 = 0; i160 < length11; i160++) {
                                            int[] iArr13 = iArr4[i160];
                                            if (i159 < iArr13.length) {
                                                iArr12[i158] = iArr13[i159];
                                                i158++;
                                            }
                                        }
                                    }
                                    for (int i161 = 0; i161 < i129; i161++) {
                                        int length12 = nVarArr.length;
                                        for (int i162 = 0; i162 < length12; i162++) {
                                            int[] iArr14 = iArr5[i162];
                                            if (i161 < iArr14.length) {
                                                iArr12[i158] = iArr14[i161];
                                                i158++;
                                            }
                                        }
                                    }
                                    int i163 = i46 - 1;
                                    int i164 = i163;
                                    int i165 = -1;
                                    int i166 = 0;
                                    int i167 = 7;
                                    while (i163 > 0) {
                                        if (i163 == 6) {
                                            i163--;
                                        }
                                        while (true) {
                                            i18 = i166;
                                            int i168 = 2;
                                            int i169 = 0;
                                            while (i169 < i168) {
                                                int i170 = i163 - i169;
                                                if (gVarArr[i164][i170] == null) {
                                                    boolean z19 = i18 < i127 && ((iArr12[i18] >>> i167) & 1) == 1;
                                                    i19 = 2;
                                                    if ((i164 + i170) % 2 == 0) {
                                                        z19 = !z19;
                                                    }
                                                    f.a(i164, i170, z19, gVarArr);
                                                    i167--;
                                                    if (i167 == -1) {
                                                        i18++;
                                                        i167 = 7;
                                                    }
                                                } else {
                                                    i19 = 2;
                                                }
                                                i169++;
                                                i168 = i19;
                                            }
                                            i164 += i165;
                                            if (i164 >= 0 && i46 > i164) {
                                                i166 = i18;
                                            }
                                        }
                                        i164 -= i165;
                                        i165 = -i165;
                                        i163 -= 2;
                                        i166 = i18;
                                    }
                                    final g[][] gVarArr5 = new g[i46];
                                    for (int i171 = 0; i171 < i46; i171++) {
                                        g[] gVarArr6 = new g[i46];
                                        for (int i172 = 0; i172 < i46; i172++) {
                                            g gVar3 = gVarArr[i171][i172];
                                            if (gVar3 == null) {
                                                gVar3 = new g(false, i171, i172, i46, null, 0, 0, null, 240);
                                            }
                                            gVarArr6[i172] = gVar3;
                                        }
                                        gVarArr5[i171] = gVarArr6;
                                    }
                                    Function4<Integer, Integer, g, q01.a, Unit> function4 = new Function4<Integer, Integer, g, q01.a, Unit>() { // from class: com.tencent.kuikly.demo.pages.base.qrcode.raw.QRCodeProcessor$render$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(4);
                                        }

                                        @Override // kotlin.jvm.functions.Function4
                                        public final Unit invoke(Integer num, Integer num2, g gVar4, q01.a aVar10) {
                                            int intValue = num.intValue();
                                            int intValue2 = num2.intValue();
                                            q01.a aVar11 = aVar10;
                                            if (gVar4.f421677a) {
                                                aVar11.a(intValue, intValue2, gVarArr5.length, true, null);
                                            } else {
                                                aVar11.a(intValue, intValue2, gVarArr5.length, false, null);
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    for (int i173 = 0; i173 < i46; i173++) {
                                        g[] gVarArr7 = gVarArr5[i173];
                                        int length13 = gVarArr7.length;
                                        int i174 = 0;
                                        while (i174 < length13) {
                                            g gVar4 = gVarArr7[i174];
                                            if (gVar4.f421685i) {
                                                aVar = aVar9;
                                            } else {
                                                aVar = aVar9;
                                                function4.invoke(Integer.valueOf(gVar4.f421679c * 1), Integer.valueOf(gVar4.f421678b * 1), gVar4, aVar);
                                                gVar4.f421685i = true;
                                            }
                                            i174++;
                                            aVar9 = aVar;
                                        }
                                    }
                                    BindDirectivesView bindDirectivesView3 = bindDirectivesView2;
                                    final QRCodeView qRCodeView6 = qRCodeView4;
                                    Function0<Unit> function02 = new Function0<Unit>() { // from class: com.tencent.kuikly.demo.pages.base.qrcode.QRCodeView.body.1.2.2.2
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public final Unit invoke() {
                                            Function1<Object, Unit> function12 = QRCodeView.i(QRCodeView.this).f417921a;
                                            if (function12 != null) {
                                                function12.invoke(null);
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    KProperty<Object>[] kPropertyArr = IPagerIdKtxKt.$$delegatedProperties;
                                    TimerKt.e(bindDirectivesView3.getPagerId(), 0, function02);
                                    return Unit.INSTANCE;
                                }
                                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("Code length overflow (");
                                m3.append(aVar3.f421673b);
                                m3.append(" > ");
                                m3.append(i121);
                                m3.append(')');
                                throw new IllegalArgumentException(m3.toString());
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new b();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new c();
    }
}
