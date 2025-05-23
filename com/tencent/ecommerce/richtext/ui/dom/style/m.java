package com.tencent.ecommerce.richtext.ui.dom.style;

/* compiled from: P */
/* loaded from: classes5.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    private static final int f105407a = FlexDirection.COLUMN.ordinal();

    /* renamed from: b, reason: collision with root package name */
    private static final int f105408b = FlexDirection.COLUMN_REVERSE.ordinal();

    /* renamed from: c, reason: collision with root package name */
    private static final int f105409c = FlexDirection.ROW.ordinal();

    /* renamed from: d, reason: collision with root package name */
    private static final int f105410d = FlexDirection.ROW_REVERSE.ordinal();

    /* renamed from: e, reason: collision with root package name */
    private static final int[] f105411e = {1, 3, 0, 2};

    /* renamed from: f, reason: collision with root package name */
    private static final int[] f105412f = {3, 1, 2, 0};

    /* renamed from: g, reason: collision with root package name */
    private static final int[] f105413g = {1, 3, 0, 2};

    /* renamed from: h, reason: collision with root package name */
    private static final int[] f105414h = {1, 1, 0, 0};

    /* renamed from: i, reason: collision with root package name */
    private static final int[] f105415i = {1, 3, 6, 6};

    /* renamed from: j, reason: collision with root package name */
    private static final int[] f105416j = {3, 1, 7, 7};

    private static float a(FlexNode flexNode, int i3, float f16) {
        float f17;
        float f18;
        if (i3 != f105407a && i3 != f105408b) {
            if (i3 != f105409c && i3 != f105410d) {
                f18 = Float.NaN;
                f17 = Float.NaN;
            } else {
                k kVar = flexNode.f105336e;
                f17 = kVar.f105403p;
                f18 = kVar.f105405r;
            }
        } else {
            k kVar2 = flexNode.f105336e;
            f17 = kVar2.f105404q;
            f18 = kVar2.f105406s;
        }
        if (!Float.isNaN(f18) && f18 >= 0.0d && f16 > f18) {
            f16 = f18;
        }
        if (Float.isNaN(f17) || f17 < 0.0d || f17 <= f16) {
            return f16;
        }
        return f17;
    }

    private static FlexAlign b(FlexNode flexNode, FlexNode flexNode2) {
        FlexAlign flexAlign = flexNode2.f105336e.f105392e;
        if (flexAlign != FlexAlign.AUTO) {
            return flexAlign;
        }
        return flexNode.f105336e.f105393f;
    }

    private static int c(int i3, FlexLayoutDirection flexLayoutDirection) {
        int i16 = f105407a;
        if (i3 != i16 && i3 != f105408b) {
            return i16;
        }
        return k(f105409c, flexLayoutDirection);
    }

    private static int d(FlexNode flexNode) {
        return flexNode.f105336e.f105389b.ordinal();
    }

    private static float e(FlexNode flexNode, int i3) {
        float f16 = flexNode.f105336e.f105400m[f105411e[i3]];
        if (!Float.isNaN(f16)) {
            return f16;
        }
        float f17 = flexNode.f105336e.f105400m[f105412f[i3]];
        if (Float.isNaN(f17)) {
            return 0.0f;
        }
        return -f17;
    }

    private static boolean f(FlexNode flexNode) {
        k kVar = flexNode.f105336e;
        if (kVar.f105394g == FlexPositionType.RELATIVE && kVar.f105396i > 0.0f) {
            return true;
        }
        return false;
    }

    private static boolean g(FlexNode flexNode) {
        return flexNode.q();
    }

    public static void h(j jVar, FlexNode flexNode, float f16, FlexLayoutDirection flexLayoutDirection) {
        if (j(flexNode, f16)) {
            i iVar = flexNode.f105337f;
            float[] fArr = flexNode.f105335d.f105382b;
            iVar.f105384d = fArr[0];
            iVar.f105385e = fArr[1];
            iVar.f105386f = f16;
            i(jVar, flexNode, f16, flexLayoutDirection);
            flexNode.S(flexNode.f105335d);
        } else {
            flexNode.f105335d.a(flexNode.f105337f);
            flexNode.S(flexNode.f105337f);
        }
        flexNode.s();
    }

    /* JADX WARN: Code restructure failed: missing block: B:182:0x095b, code lost:
    
        if (r2 >= 0.0d) goto L227;
     */
    /* JADX WARN: Code restructure failed: missing block: B:297:0x0650, code lost:
    
        if (r5 >= 0.0d) goto L151;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0193, code lost:
    
        if (r1.f105336e.f105401n[r16[r11]] < 0.0d) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:418:0x0f78, code lost:
    
        if (r1.f105336e.f105401n[r6[r3]] < 0.0d) goto L431;
     */
    /* JADX WARN: Removed duplicated region for block: B:110:0x05b6  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x06c4 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x06e4  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x06fb  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0721  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x07bd  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x07af  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0a00  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0b0d  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0b22  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0c8c  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0caf A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:270:0x0b1a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x0633  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x0681  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x068c  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x06bc  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x0679  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x01aa A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:332:0x0d40  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0201 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:398:0x0ebe  */
    /* JADX WARN: Removed duplicated region for block: B:404:0x0edf A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:407:0x0f3c  */
    /* JADX WARN: Removed duplicated region for block: B:454:0x0ee4  */
    /* JADX WARN: Removed duplicated region for block: B:476:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:478:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:479:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:482:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:483:0x0196  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void i(j jVar, FlexNode flexNode, float f16, FlexLayoutDirection flexLayoutDirection) {
        int i3;
        int i16;
        int i17;
        int i18;
        boolean z16;
        boolean z17;
        int i19;
        FlexNode flexNode2;
        float f17;
        float f18;
        int i26;
        int i27;
        float f19;
        int i28;
        j jVar2;
        float f26;
        FlexNode flexNode3;
        int i29;
        boolean z18;
        int i36;
        float f27;
        int i37;
        boolean z19;
        int i38;
        int i39;
        float f28;
        FlexLayoutDirection flexLayoutDirection2;
        boolean z26;
        float max;
        FlexNode flexNode4;
        boolean z27;
        int i46;
        float f29;
        int i47;
        FlexJustifyContent flexJustifyContent;
        float f36;
        float f37;
        int i48;
        float f38;
        int i49;
        int i56;
        float f39;
        FlexLayoutDirection flexLayoutDirection3;
        float f46;
        int i57;
        int i58;
        float f47;
        float f48;
        FlexJustifyContent flexJustifyContent2;
        int i59;
        FlexNode flexNode5;
        boolean z28;
        int i65;
        float f49;
        float f56;
        float f57;
        float b16;
        float f58;
        int i66;
        int i67;
        int i68;
        int i69;
        int i75;
        FlexAlign flexAlign;
        int i76;
        int i77;
        FlexNode flexNode6;
        int i78;
        float f59;
        k kVar;
        FlexNode flexNode7;
        int i79;
        float f65;
        float b17;
        int i85;
        FlexNode flexNode8;
        FlexNode flexNode9;
        int i86;
        FlexAlign flexAlign2;
        k kVar2;
        FlexPositionType flexPositionType;
        FlexPositionType flexPositionType2;
        int i87;
        FlexNode flexNode10;
        int i88;
        int i89;
        int i95;
        float b18;
        boolean z29;
        float[] fArr;
        int i96;
        boolean z36;
        FlexNode flexNode11 = flexNode;
        int h16 = flexNode.h();
        for (int i97 = 0; i97 < h16; i97++) {
            if (flexNode11.f(i97) != null) {
                flexNode11.f(i97).f105335d.b();
            }
        }
        if (flexNode.r()) {
            FlexLayoutDirection l3 = l(flexNode11, flexLayoutDirection);
            int k3 = k(d(flexNode), l3);
            int c16 = c(k3, l3);
            int i98 = f105409c;
            int k16 = k(i98, l3);
            m(flexNode11, k3);
            m(flexNode11, c16);
            h hVar = flexNode11.f105335d;
            hVar.f105383c = l3;
            float[] fArr2 = hVar.f105381a;
            int[] iArr = f105411e;
            int i99 = iArr[k3];
            float f66 = fArr2[i99];
            o oVar = flexNode11.f105336e.f105397j;
            int[] iArr2 = f105415i;
            fArr2[i99] = f66 + oVar.b(iArr2[k3], i99) + e(flexNode11, k3);
            float[] fArr3 = flexNode11.f105335d.f105381a;
            int[] iArr3 = f105412f;
            int i100 = iArr3[k3];
            float f67 = fArr3[i100];
            o oVar2 = flexNode11.f105336e.f105397j;
            int[] iArr4 = f105416j;
            fArr3[i100] = f67 + oVar2.b(iArr4[k3], i100) + e(flexNode11, k3);
            float[] fArr4 = flexNode11.f105335d.f105381a;
            int i101 = iArr[c16];
            fArr4[i101] = fArr4[i101] + flexNode11.f105336e.f105397j.b(iArr2[c16], i101) + e(flexNode11, c16);
            float[] fArr5 = flexNode11.f105335d.f105381a;
            int i102 = iArr3[c16];
            fArr5[i102] = fArr5[i102] + flexNode11.f105336e.f105397j.b(iArr4[c16], i102) + e(flexNode11, c16);
            int h17 = flexNode.h();
            FlexLayoutDirection flexLayoutDirection4 = l3;
            float b19 = flexNode11.f105336e.f105398k.b(iArr2[k16], iArr[k16]) + flexNode11.f105336e.f105399l.b(iArr2[k16], iArr[k16]) + flexNode11.f105336e.f105398k.b(iArr4[k16], iArr3[k16]) + flexNode11.f105336e.f105399l.b(iArr4[k16], iArr3[k16]);
            if (g(flexNode)) {
                float[] fArr6 = flexNode11.f105335d.f105382b;
                int[] iArr5 = f105414h;
                boolean z37 = !Float.isNaN(fArr6[iArr5[k16]]);
                if (Float.isNaN(flexNode11.f105336e.f105401n[iArr5[k16]])) {
                    i16 = c16;
                    i17 = i98;
                } else {
                    float[] fArr7 = flexNode11.f105336e.f105401n;
                    i17 = i98;
                    i16 = c16;
                    if (fArr7[iArr5[k16]] >= 0.0d) {
                        b18 = fArr7[0];
                        float f68 = b18 - b19;
                        z29 = (!Float.isNaN(flexNode11.f105336e.f105401n[iArr5[k16]]) || ((double) flexNode11.f105336e.f105401n[iArr5[k16]]) < 0.0d) && !z37;
                        fArr = flexNode11.f105336e.f105401n;
                        i96 = f105407a;
                        if (Float.isNaN(fArr[iArr5[i96]])) {
                            i3 = k3;
                        } else {
                            i3 = k3;
                        }
                        if (Float.isNaN(flexNode11.f105336e.f105401n[iArr5[i96]])) {
                            z36 = true;
                            if (!z29 || z36) {
                                n u16 = flexNode11.u(jVar.f105387a, f68);
                                if (z29) {
                                    flexNode11.f105335d.f105382b[0] = u16.f105417a + b19;
                                }
                                if (z36) {
                                    flexNode11.f105335d.f105382b[1] = u16.f105418b + flexNode11.f105336e.f105398k.b(iArr2[i96], iArr[i96]) + flexNode11.f105336e.f105399l.b(iArr2[i96], iArr[i96]) + flexNode11.f105336e.f105398k.b(iArr4[i96], iArr3[i96]) + flexNode11.f105336e.f105399l.b(iArr4[i96], iArr3[i96]);
                                }
                            }
                            if (h17 == 0) {
                                return;
                            }
                        }
                        z36 = false;
                        if (!z29) {
                        }
                        n u162 = flexNode11.u(jVar.f105387a, f68);
                        if (z29) {
                        }
                        if (z36) {
                        }
                        if (h17 == 0) {
                        }
                    }
                }
                if (z37) {
                    b18 = flexNode11.f105335d.f105382b[iArr5[k16]];
                } else {
                    b18 = f16 - (flexNode11.f105336e.f105397j.b(iArr2[k16], iArr[k16]) + flexNode11.f105336e.f105397j.b(iArr4[k16], iArr3[k16]));
                }
                float f682 = b18 - b19;
                if (Float.isNaN(flexNode11.f105336e.f105401n[iArr5[k16]])) {
                }
                fArr = flexNode11.f105336e.f105401n;
                i96 = f105407a;
                if (Float.isNaN(fArr[iArr5[i96]])) {
                }
                if (Float.isNaN(flexNode11.f105336e.f105401n[iArr5[i96]])) {
                }
                z36 = false;
                if (!z29) {
                }
                n u1622 = flexNode11.u(jVar.f105387a, f682);
                if (z29) {
                }
                if (z36) {
                }
                if (h17 == 0) {
                }
            } else {
                i3 = k3;
                i16 = c16;
                i17 = i98;
            }
            k kVar3 = flexNode11.f105336e;
            boolean z38 = kVar3.f105395h == FlexWrap.WRAP;
            FlexJustifyContent flexJustifyContent3 = kVar3.f105390c;
            float b26 = kVar3.f105398k.b(iArr2[i3], iArr[i3]) + flexNode11.f105336e.f105399l.b(iArr2[i3], iArr[i3]);
            float b27 = flexNode11.f105336e.f105398k.b(iArr2[i16], iArr[i16]) + flexNode11.f105336e.f105399l.b(iArr2[i16], iArr[i16]);
            float b28 = flexNode11.f105336e.f105398k.b(iArr2[i3], iArr[i3]) + flexNode11.f105336e.f105399l.b(iArr2[i3], iArr[i3]) + flexNode11.f105336e.f105398k.b(iArr4[i3], iArr3[i3]) + flexNode11.f105336e.f105399l.b(iArr4[i3], iArr3[i3]);
            float b29 = flexNode11.f105336e.f105398k.b(iArr2[i16], iArr[i16]) + flexNode11.f105336e.f105399l.b(iArr2[i16], iArr[i16]) + flexNode11.f105336e.f105398k.b(iArr4[i16], iArr3[i16]) + flexNode11.f105336e.f105399l.b(iArr4[i16], iArr3[i16]);
            float[] fArr8 = flexNode11.f105335d.f105382b;
            int[] iArr6 = f105414h;
            boolean z39 = !Float.isNaN(fArr8[iArr6[i3]]);
            boolean z46 = !Float.isNaN(flexNode11.f105335d.f105382b[iArr6[i16]]);
            int i103 = i3;
            boolean z47 = i103 == i17 || i103 == f105410d;
            float f69 = z39 ? flexNode11.f105335d.f105382b[iArr6[i103]] - b28 : Float.NaN;
            int i104 = 0;
            int i105 = 0;
            int i106 = 0;
            boolean z48 = false;
            float f75 = 0.0f;
            FlexNode flexNode12 = null;
            float f76 = 0.0f;
            FlexNode flexNode13 = null;
            FlexNode flexNode14 = null;
            FlexNode flexNode15 = null;
            while (i104 < h17) {
                boolean z49 = (z39 && flexJustifyContent3 == FlexJustifyContent.FLEX_START) || !(z39 || flexJustifyContent3 == FlexJustifyContent.CENTER);
                FlexJustifyContent flexJustifyContent4 = flexJustifyContent3;
                int i107 = h17;
                float f77 = f69;
                int i108 = i104;
                float f78 = b26;
                FlexNode flexNode16 = flexNode12;
                FlexNode flexNode17 = flexNode13;
                int i109 = z49 ? h17 : i106;
                FlexNode flexNode18 = null;
                int i110 = 0;
                boolean z55 = true;
                float f79 = 0.0f;
                FlexNode flexNode19 = null;
                float f85 = 0.0f;
                float f86 = 0.0f;
                float f87 = b28;
                int i111 = i106;
                boolean z56 = z48;
                boolean z57 = z49;
                int i112 = 0;
                while (true) {
                    if (i111 >= h17) {
                        jVar2 = jVar;
                        f26 = b29;
                        flexNode3 = flexNode11;
                        i29 = h17;
                        z18 = z38;
                        i36 = k16;
                        f27 = b19;
                        i37 = i103;
                        z19 = z46;
                        i38 = i105;
                        i39 = i16;
                        f28 = f86;
                        flexLayoutDirection2 = flexLayoutDirection4;
                        z26 = z47;
                        z48 = z56;
                        flexNode12 = flexNode16;
                        break;
                    }
                    i29 = h17;
                    FlexNode f88 = flexNode11.f(i111);
                    if (f88 == null) {
                        f26 = b29;
                        flexNode3 = flexNode11;
                        z18 = z38;
                        i36 = k16;
                        f27 = b19;
                        i37 = i103;
                        z19 = z46;
                        i38 = i105;
                        i67 = i16;
                        i68 = i106;
                        flexLayoutDirection2 = flexLayoutDirection4;
                        i69 = i111;
                        z26 = z47;
                        i108 = i69 + 1;
                        flexNode18 = flexNode18;
                    } else if (f88.r()) {
                        f88.f105338h = i105;
                        i38 = i105;
                        f88.f105339i = null;
                        f88.f105340m = null;
                        FlexAlign b36 = b(flexNode11, f88);
                        int i113 = i111;
                        if (b36 == FlexAlign.STRETCH) {
                            k kVar4 = f88.f105336e;
                            flexAlign = b36;
                            z18 = z38;
                            if (kVar4.f105394g == FlexPositionType.RELATIVE && z46) {
                                float[] fArr9 = kVar4.f105401n;
                                int[] iArr7 = f105414h;
                                if (Float.isNaN(fArr9[iArr7[i16]])) {
                                    i95 = k16;
                                    f27 = b19;
                                } else {
                                    i95 = k16;
                                    f27 = b19;
                                    if (f88.f105336e.f105401n[iArr7[i16]] >= 0.0d) {
                                        f26 = b29;
                                        z19 = z46;
                                        i75 = i110;
                                        i36 = i95;
                                    }
                                }
                                float[] fArr10 = f88.f105335d.f105382b;
                                int i114 = iArr7[i16];
                                float f89 = flexNode11.f105335d.f105382b[i114] - b29;
                                o oVar3 = f88.f105336e.f105397j;
                                int[] iArr8 = f105415i;
                                f26 = b29;
                                int i115 = iArr8[i16];
                                int[] iArr9 = f105411e;
                                z19 = z46;
                                float b37 = oVar3.b(i115, iArr9[i16]);
                                o oVar4 = f88.f105336e.f105397j;
                                int[] iArr10 = f105416j;
                                i75 = i110;
                                int i116 = iArr10[i16];
                                int[] iArr11 = f105412f;
                                i36 = i95;
                                float b38 = f89 - (b37 + oVar4.b(i116, iArr11[i16]));
                                i76 = i16;
                                z26 = z47;
                                fArr10[i114] = Math.max(a(f88, i76, b38), f88.f105336e.f105398k.b(iArr8[i76], iArr9[i76]) + f88.f105336e.f105399l.b(iArr8[i76], iArr9[i76]) + f88.f105336e.f105398k.b(iArr10[i76], iArr11[i76]) + f88.f105336e.f105399l.b(iArr10[i76], iArr11[i76]));
                                i77 = i76;
                                flexNode6 = flexNode18;
                                i37 = i103;
                                i78 = i112;
                                if (!z39 && f(f88)) {
                                    i112 = i78 + 1;
                                    k kVar5 = f88.f105336e;
                                    f79 += kVar5.f105396i;
                                    if (flexNode19 == null) {
                                        flexNode19 = f88;
                                    }
                                    if (flexNode6 != null) {
                                        flexNode6.f105340m = f88;
                                    }
                                    o oVar5 = kVar5.f105398k;
                                    int[] iArr12 = f105415i;
                                    int i117 = iArr12[i37];
                                    int[] iArr13 = f105411e;
                                    float b39 = oVar5.b(i117, iArr13[i37]) + f88.f105336e.f105399l.b(iArr12[i37], iArr13[i37]);
                                    o oVar6 = f88.f105336e.f105398k;
                                    int[] iArr14 = f105416j;
                                    int i118 = iArr14[i37];
                                    int[] iArr15 = f105412f;
                                    float b46 = b39 + oVar6.b(i118, iArr15[i37]) + f88.f105336e.f105399l.b(iArr14[i37], iArr15[i37]) + f88.f105336e.f105397j.b(iArr12[i37], iArr13[i37]) + f88.f105336e.f105397j.b(iArr14[i37], iArr15[i37]);
                                    jVar2 = jVar;
                                    flexLayoutDirection2 = flexLayoutDirection4;
                                    f65 = b46;
                                    flexNode7 = f88;
                                    i79 = i75;
                                    flexNode3 = flexNode;
                                } else {
                                    FlexNode flexNode20 = flexNode6;
                                    flexNode3 = flexNode;
                                    if (z26) {
                                        f59 = Float.NaN;
                                    } else {
                                        float[] fArr11 = flexNode3.f105336e.f105401n;
                                        int[] iArr16 = f105414h;
                                        if (!Float.isNaN(fArr11[iArr16[i36]])) {
                                            b17 = flexNode3.f105336e.f105401n[iArr16[i36]];
                                        }
                                        b17 = f16 - (flexNode3.f105336e.f105397j.b(f105415i[i36], f105411e[i36]) + flexNode3.f105336e.f105397j.b(f105416j[i36], f105412f[i36]));
                                        f59 = b17 - f27;
                                    }
                                    jVar2 = jVar;
                                    flexLayoutDirection2 = flexLayoutDirection4;
                                    if (!z56) {
                                        h(jVar2, f88, f59, flexLayoutDirection2);
                                    }
                                    kVar = f88.f105336e;
                                    if (kVar.f105394g == FlexPositionType.RELATIVE) {
                                        i79 = i75 + 1;
                                        f65 = f88.f105336e.f105397j.b(f105416j[i37], f105412f[i37]) + f88.f105335d.f105382b[f105414h[i37]] + kVar.f105397j.b(f105415i[i37], f105411e[i37]);
                                        flexNode7 = flexNode20;
                                        i112 = i78;
                                    } else {
                                        flexNode7 = flexNode20;
                                        i79 = i75;
                                        i112 = i78;
                                        f65 = 0.0f;
                                    }
                                }
                                if (!z18 && z39 && f85 + f65 > f77) {
                                    i85 = i106;
                                    i69 = i113;
                                    if (i69 != i85) {
                                        i110 = i79 - 1;
                                        flexNode12 = flexNode16;
                                        f28 = f86;
                                        i39 = i77;
                                        z48 = true;
                                        break;
                                    }
                                } else {
                                    i85 = i106;
                                    i69 = i113;
                                }
                                if (z57 && ((flexPositionType = (kVar2 = f88.f105336e).f105394g) != (flexPositionType2 = FlexPositionType.RELATIVE) || (flexPositionType == flexPositionType2 && kVar2.f105396i > 0.0f))) {
                                    i109 = i69;
                                    z57 = false;
                                }
                                if (z55) {
                                    k kVar6 = f88.f105336e;
                                    if (kVar6.f105394g != FlexPositionType.RELATIVE || (((flexAlign2 = flexAlign) != FlexAlign.STRETCH && flexAlign2 != FlexAlign.FLEX_START) || Float.isNaN(kVar6.f105401n[f105414h[i77]]))) {
                                        i107 = i69;
                                        z55 = false;
                                    }
                                }
                                if (z57) {
                                    h hVar2 = f88.f105335d;
                                    float[] fArr12 = hVar2.f105381a;
                                    int i119 = f105413g[i37];
                                    float f95 = fArr12[i119] + f78;
                                    fArr12[i119] = f95;
                                    if (z39) {
                                        int i120 = f105412f[i37];
                                        flexNode8 = flexNode17;
                                        float[] fArr13 = flexNode3.f105335d.f105382b;
                                        int i121 = f105414h[i37];
                                        i68 = i85;
                                        fArr12[i120] = (fArr13[i121] - hVar2.f105382b[i121]) - f95;
                                    } else {
                                        flexNode8 = flexNode17;
                                        i68 = i85;
                                    }
                                    float[] fArr14 = hVar2.f105382b;
                                    int[] iArr17 = f105414h;
                                    float f96 = fArr14[iArr17[i37]];
                                    o oVar7 = f88.f105336e.f105397j;
                                    int[] iArr18 = f105415i;
                                    int i122 = iArr18[i37];
                                    int[] iArr19 = f105411e;
                                    flexNode9 = flexNode7;
                                    float b47 = f96 + oVar7.b(i122, iArr19[i37]);
                                    o oVar8 = f88.f105336e.f105397j;
                                    int[] iArr20 = f105416j;
                                    int i123 = iArr20[i37];
                                    int[] iArr21 = f105412f;
                                    i86 = i79;
                                    f78 += b47 + oVar8.b(i123, iArr21[i37]);
                                    i67 = i77;
                                    f86 = Math.max(f86, a(f88, i67, f88.f105335d.f105382b[iArr17[i77]] + f88.f105336e.f105397j.b(iArr18[i77], iArr19[i77]) + f88.f105336e.f105397j.b(iArr20[i77], iArr21[i77])));
                                } else {
                                    flexNode8 = flexNode17;
                                    i68 = i85;
                                    flexNode9 = flexNode7;
                                    i86 = i79;
                                    i67 = i77;
                                }
                                if (z55) {
                                    h hVar3 = f88.f105335d;
                                    float[] fArr15 = hVar3.f105381a;
                                    int i124 = f105413g[i67];
                                    float f97 = fArr15[i124] + f75 + b27;
                                    fArr15[i124] = f97;
                                    if (z19) {
                                        int i125 = f105412f[i67];
                                        float[] fArr16 = flexNode3.f105335d.f105382b;
                                        int i126 = f105414h[i67];
                                        fArr15[i125] = (fArr16[i126] - hVar3.f105382b[i126]) - f97;
                                    }
                                }
                                f85 += f65;
                                flexNode17 = flexNode8;
                                i108 = i69 + 1;
                                flexNode18 = flexNode9;
                                i110 = i86;
                                z56 = false;
                            } else {
                                f26 = b29;
                                i36 = k16;
                                f27 = b19;
                                z19 = z46;
                                i75 = i110;
                            }
                        } else {
                            f26 = b29;
                            z18 = z38;
                            i36 = k16;
                            f27 = b19;
                            z19 = z46;
                            i75 = i110;
                            flexAlign = b36;
                        }
                        i76 = i16;
                        z26 = z47;
                        if (f88.f105336e.f105394g == FlexPositionType.ABSOLUTE) {
                            if (flexNode16 == null) {
                                flexNode16 = f88;
                            }
                            if (flexNode17 != null) {
                                flexNode17.f105339i = f88;
                            }
                            int i127 = 0;
                            for (int i128 = 2; i127 < i128; i128 = 2) {
                                int i129 = i127 != 0 ? f105409c : f105407a;
                                float[] fArr17 = flexNode11.f105335d.f105382b;
                                int[] iArr22 = f105414h;
                                if (!Float.isNaN(fArr17[iArr22[i129]]) && (Float.isNaN(f88.f105336e.f105401n[iArr22[i129]]) || f88.f105336e.f105401n[iArr22[i129]] < 0.0d)) {
                                    float[] fArr18 = f88.f105336e.f105400m;
                                    int[] iArr23 = f105411e;
                                    if (!Float.isNaN(fArr18[iArr23[i129]])) {
                                        float[] fArr19 = f88.f105336e.f105400m;
                                        int[] iArr24 = f105412f;
                                        if (!Float.isNaN(fArr19[iArr24[i129]])) {
                                            float[] fArr20 = f88.f105335d.f105382b;
                                            int i130 = iArr22[i129];
                                            float f98 = flexNode11.f105335d.f105382b[i130];
                                            o oVar9 = flexNode11.f105336e.f105398k;
                                            int[] iArr25 = f105415i;
                                            i87 = i76;
                                            i88 = i103;
                                            flexNode10 = flexNode18;
                                            float b48 = oVar9.b(iArr25[i129], iArr23[i129]) + flexNode11.f105336e.f105399l.b(iArr25[i129], iArr23[i129]);
                                            o oVar10 = flexNode11.f105336e.f105398k;
                                            int[] iArr26 = f105416j;
                                            i89 = i112;
                                            fArr20[i130] = Math.max(a(f88, i129, (((f98 - (b48 + (oVar10.b(iArr26[i129], iArr24[i129]) + flexNode11.f105336e.f105399l.b(iArr26[i129], iArr24[i129])))) - (f88.f105336e.f105397j.b(iArr25[i129], iArr23[i129]) + f88.f105336e.f105397j.b(iArr26[i129], iArr24[i129]))) - (Float.isNaN(f88.f105336e.f105400m[iArr23[i129]]) ? 0.0f : f88.f105336e.f105400m[iArr23[i129]])) - (Float.isNaN(f88.f105336e.f105400m[iArr24[i129]]) ? 0.0f : f88.f105336e.f105400m[iArr24[i129]])), f88.f105336e.f105398k.b(iArr25[i129], iArr23[i129]) + f88.f105336e.f105399l.b(iArr25[i129], iArr23[i129]) + f88.f105336e.f105398k.b(iArr26[i129], iArr24[i129]) + f88.f105336e.f105399l.b(iArr26[i129], iArr24[i129]));
                                            i127++;
                                            flexNode11 = flexNode;
                                            i76 = i87;
                                            i103 = i88;
                                            flexNode18 = flexNode10;
                                            i112 = i89;
                                        }
                                    }
                                }
                                i87 = i76;
                                flexNode10 = flexNode18;
                                i88 = i103;
                                i89 = i112;
                                i127++;
                                flexNode11 = flexNode;
                                i76 = i87;
                                i103 = i88;
                                flexNode18 = flexNode10;
                                i112 = i89;
                            }
                            i77 = i76;
                            flexNode6 = flexNode18;
                            i37 = i103;
                            i78 = i112;
                            flexNode17 = f88;
                            if (!z39) {
                            }
                            FlexNode flexNode202 = flexNode6;
                            flexNode3 = flexNode;
                            if (z26) {
                            }
                            jVar2 = jVar;
                            flexLayoutDirection2 = flexLayoutDirection4;
                            if (!z56) {
                            }
                            kVar = f88.f105336e;
                            if (kVar.f105394g == FlexPositionType.RELATIVE) {
                            }
                            if (!z18) {
                            }
                            i85 = i106;
                            i69 = i113;
                            if (z57) {
                                i109 = i69;
                                z57 = false;
                            }
                            if (z55) {
                            }
                            if (z57) {
                            }
                            if (z55) {
                            }
                            f85 += f65;
                            flexNode17 = flexNode8;
                            i108 = i69 + 1;
                            flexNode18 = flexNode9;
                            i110 = i86;
                            z56 = false;
                        }
                        i77 = i76;
                        flexNode6 = flexNode18;
                        i37 = i103;
                        i78 = i112;
                        if (!z39) {
                        }
                        FlexNode flexNode2022 = flexNode6;
                        flexNode3 = flexNode;
                        if (z26) {
                        }
                        jVar2 = jVar;
                        flexLayoutDirection2 = flexLayoutDirection4;
                        if (!z56) {
                        }
                        kVar = f88.f105336e;
                        if (kVar.f105394g == FlexPositionType.RELATIVE) {
                        }
                        if (!z18) {
                        }
                        i85 = i106;
                        i69 = i113;
                        if (z57) {
                        }
                        if (z55) {
                        }
                        if (z57) {
                        }
                        if (z55) {
                        }
                        f85 += f65;
                        flexNode17 = flexNode8;
                        i108 = i69 + 1;
                        flexNode18 = flexNode9;
                        i110 = i86;
                        z56 = false;
                    } else {
                        f26 = b29;
                        flexNode3 = flexNode11;
                        i108 = i111 + 1;
                        z18 = z38;
                        i36 = k16;
                        f27 = b19;
                        i37 = i103;
                        z19 = z46;
                        i38 = i105;
                        i67 = i16;
                        i68 = i106;
                        flexLayoutDirection2 = flexLayoutDirection4;
                        i69 = i111;
                        z26 = z47;
                    }
                    i111 = i69 + 1;
                    flexLayoutDirection4 = flexLayoutDirection2;
                    z47 = z26;
                    h17 = i29;
                    i105 = i38;
                    i106 = i68;
                    z38 = z18;
                    i103 = i37;
                    z46 = z19;
                    k16 = i36;
                    flexNode11 = flexNode3;
                    i16 = i67;
                    b19 = f27;
                    b29 = f26;
                }
                if (z39) {
                    max = f77 - f85;
                } else {
                    float f99 = f85;
                    max = Math.max(f99, 0.0f) - f99;
                }
                if (i112 != 0) {
                    float f100 = max / f79;
                    FlexNode flexNode21 = flexNode19;
                    while (flexNode21 != null) {
                        if (flexNode21.r()) {
                            k kVar7 = flexNode21.f105336e;
                            float f101 = kVar7.f105396i * f100;
                            o oVar11 = kVar7.f105398k;
                            int[] iArr27 = f105415i;
                            int i131 = iArr27[i37];
                            int[] iArr28 = f105411e;
                            float b49 = oVar11.b(i131, iArr28[i37]) + flexNode21.f105336e.f105399l.b(iArr27[i37], iArr28[i37]);
                            o oVar12 = flexNode21.f105336e.f105398k;
                            int[] iArr29 = f105416j;
                            int i132 = iArr29[i37];
                            int[] iArr30 = f105412f;
                            f58 = f100;
                            float b56 = f101 + b49 + oVar12.b(i132, iArr30[i37]) + flexNode21.f105336e.f105399l.b(iArr29[i37], iArr30[i37]);
                            i66 = i37;
                            float a16 = a(flexNode21, i66, b56);
                            if (b56 != a16) {
                                max -= a16;
                                f79 -= flexNode21.f105336e.f105396i;
                            }
                        } else {
                            f58 = f100;
                            i66 = i37;
                        }
                        flexNode21 = flexNode21.f105340m;
                        i37 = i66;
                        f100 = f58;
                    }
                    i47 = i37;
                    float f102 = max / f79;
                    if (f102 < 0.0f) {
                        f102 = 0.0f;
                    }
                    FlexNode flexNode22 = flexNode19;
                    while (flexNode22 != null) {
                        if (flexNode22.r()) {
                            float[] fArr21 = flexNode22.f105335d.f105382b;
                            int[] iArr31 = f105414h;
                            int i133 = iArr31[i47];
                            k kVar8 = flexNode22.f105336e;
                            float f103 = kVar8.f105396i * f102;
                            o oVar13 = kVar8.f105398k;
                            int[] iArr32 = f105415i;
                            flexNode5 = flexNode17;
                            int i134 = iArr32[i47];
                            int[] iArr33 = f105411e;
                            f49 = f28;
                            f56 = f102;
                            float b57 = oVar13.b(i134, iArr33[i47]) + flexNode22.f105336e.f105399l.b(iArr32[i47], iArr33[i47]);
                            o oVar14 = flexNode22.f105336e.f105398k;
                            int[] iArr34 = f105416j;
                            int i135 = iArr34[i47];
                            int[] iArr35 = f105412f;
                            i65 = i39;
                            z28 = z39;
                            fArr21[i133] = a(flexNode22, i47, f103 + b57 + oVar14.b(i135, iArr35[i47]) + flexNode22.f105336e.f105399l.b(iArr34[i47], iArr35[i47]));
                            if (!Float.isNaN(flexNode3.f105336e.f105401n[iArr31[i36]])) {
                                b16 = flexNode3.f105336e.f105401n[iArr31[i36]];
                            }
                            if (!z26) {
                                b16 = f16 - (flexNode3.f105336e.f105397j.b(iArr32[i36], iArr33[i36]) + flexNode3.f105336e.f105397j.b(iArr34[i36], iArr35[i36]));
                                f57 = b16 - f27;
                                h(jVar2, flexNode22, f57, flexLayoutDirection2);
                            } else {
                                f57 = Float.NaN;
                                h(jVar2, flexNode22, f57, flexLayoutDirection2);
                            }
                        } else {
                            flexNode5 = flexNode17;
                            z28 = z39;
                            i65 = i39;
                            f49 = f28;
                            f56 = f102;
                        }
                        FlexNode flexNode23 = flexNode22.f105340m;
                        flexNode22.f105340m = null;
                        flexNode22 = flexNode23;
                        f102 = f56;
                        f28 = f49;
                        z39 = z28;
                        i39 = i65;
                        flexNode17 = flexNode5;
                    }
                    flexNode4 = flexNode17;
                    z27 = z39;
                    i46 = i39;
                    f29 = f28;
                    flexJustifyContent = flexJustifyContent4;
                } else {
                    flexNode4 = flexNode17;
                    z27 = z39;
                    i46 = i39;
                    f29 = f28;
                    i47 = i37;
                    flexJustifyContent = flexJustifyContent4;
                    if (flexJustifyContent != FlexJustifyContent.FLEX_START) {
                        if (flexJustifyContent == FlexJustifyContent.CENTER) {
                            max /= 2.0f;
                        } else if (flexJustifyContent != FlexJustifyContent.FLEX_END) {
                            if (flexJustifyContent == FlexJustifyContent.SPACE_BETWEEN) {
                                f36 = 0.0f;
                                float max2 = Math.max(max, 0.0f);
                                int i136 = (i112 + i110) - 1;
                                if (i136 != 0) {
                                    f37 = max2 / i136;
                                    max = 0.0f;
                                    float f104 = f29;
                                    i104 = i108;
                                    i48 = i109;
                                    float f105 = f78 + max;
                                    while (i48 < i104) {
                                        FlexNode f106 = flexNode3.f(i48);
                                        if (f106 == null || !f106.r()) {
                                            flexJustifyContent2 = flexJustifyContent;
                                        } else {
                                            k kVar9 = f106.f105336e;
                                            if (kVar9.f105394g == FlexPositionType.ABSOLUTE) {
                                                float[] fArr22 = kVar9.f105400m;
                                                int[] iArr36 = f105411e;
                                                if (!Float.isNaN(fArr22[iArr36[i47]])) {
                                                    float[] fArr23 = f106.f105335d.f105381a;
                                                    int i137 = f105413g[i47];
                                                    float f107 = Float.isNaN(f106.f105336e.f105400m[iArr36[i47]]) ? f36 : f106.f105336e.f105400m[iArr36[i47]];
                                                    o oVar15 = flexNode3.f105336e.f105399l;
                                                    int[] iArr37 = f105415i;
                                                    flexJustifyContent2 = flexJustifyContent;
                                                    fArr23[i137] = f107 + oVar15.b(iArr37[i47], iArr36[i47]) + f106.f105336e.f105397j.b(iArr37[i47], iArr36[i47]);
                                                }
                                            }
                                            flexJustifyContent2 = flexJustifyContent;
                                            h hVar4 = f106.f105335d;
                                            float[] fArr24 = hVar4.f105381a;
                                            int i138 = f105413g[i47];
                                            float f108 = fArr24[i138] + f105;
                                            fArr24[i138] = f108;
                                            if (z27) {
                                                int i139 = f105412f[i47];
                                                float[] fArr25 = flexNode3.f105335d.f105382b;
                                                int i140 = f105414h[i47];
                                                fArr24[i139] = (fArr25[i140] - hVar4.f105382b[i140]) - f108;
                                            }
                                            k kVar10 = f106.f105336e;
                                            if (kVar10.f105394g == FlexPositionType.RELATIVE) {
                                                float[] fArr26 = hVar4.f105382b;
                                                int[] iArr38 = f105414h;
                                                float f109 = fArr26[iArr38[i47]];
                                                o oVar16 = kVar10.f105397j;
                                                int[] iArr39 = f105415i;
                                                int i141 = iArr39[i47];
                                                int[] iArr40 = f105411e;
                                                float b58 = f109 + oVar16.b(i141, iArr40[i47]);
                                                o oVar17 = f106.f105336e.f105397j;
                                                int[] iArr41 = f105416j;
                                                int i142 = iArr41[i47];
                                                int[] iArr42 = f105412f;
                                                f105 += f37 + b58 + oVar17.b(i142, iArr42[i47]);
                                                i59 = i46;
                                                f104 = Math.max(f104, a(f106, i59, f106.f105335d.f105382b[iArr38[i46]] + f106.f105336e.f105397j.b(iArr39[i46], iArr40[i46]) + f106.f105336e.f105397j.b(iArr41[i46], iArr42[i46])));
                                                i48++;
                                                i46 = i59;
                                                flexJustifyContent = flexJustifyContent2;
                                                f36 = 0.0f;
                                            }
                                        }
                                        i59 = i46;
                                        i48++;
                                        i46 = i59;
                                        flexJustifyContent = flexJustifyContent2;
                                        f36 = 0.0f;
                                    }
                                    FlexJustifyContent flexJustifyContent5 = flexJustifyContent;
                                    int i143 = i46;
                                    float f110 = flexNode3.f105335d.f105382b[f105414h[i143]];
                                    if (z19) {
                                        f38 = f26;
                                        f110 = Math.max(a(flexNode3, i143, f104 + f26), f38);
                                    } else {
                                        f38 = f26;
                                    }
                                    FlexNode flexNode24 = flexNode15;
                                    i49 = i107;
                                    while (i49 < i104) {
                                        FlexNode f111 = flexNode3.f(i49);
                                        if (f111 == null || !f111.r()) {
                                            i56 = i47;
                                            f39 = f105;
                                            flexLayoutDirection3 = flexLayoutDirection2;
                                            f46 = f104;
                                            i57 = i49;
                                            i58 = i104;
                                        } else {
                                            k kVar11 = f111.f105336e;
                                            if (kVar11.f105394g == FlexPositionType.ABSOLUTE) {
                                                float[] fArr27 = kVar11.f105400m;
                                                int[] iArr43 = f105411e;
                                                if (!Float.isNaN(fArr27[iArr43[i143]])) {
                                                    float[] fArr28 = f111.f105335d.f105381a;
                                                    int i144 = f105413g[i143];
                                                    if (Float.isNaN(f111.f105336e.f105400m[iArr43[i143]])) {
                                                        flexLayoutDirection3 = flexLayoutDirection2;
                                                        f48 = 0.0f;
                                                    } else {
                                                        f48 = f111.f105336e.f105400m[iArr43[i143]];
                                                        flexLayoutDirection3 = flexLayoutDirection2;
                                                    }
                                                    o oVar18 = flexNode3.f105336e.f105399l;
                                                    int[] iArr44 = f105415i;
                                                    i58 = i104;
                                                    i56 = i47;
                                                    fArr28[i144] = f48 + oVar18.b(iArr44[i143], iArr43[i143]) + f111.f105336e.f105397j.b(iArr44[i143], iArr43[i143]);
                                                    f39 = f105;
                                                    f46 = f104;
                                                    i57 = i49;
                                                }
                                            }
                                            i56 = i47;
                                            flexLayoutDirection3 = flexLayoutDirection2;
                                            i58 = i104;
                                            if (f111.f105336e.f105394g == FlexPositionType.RELATIVE) {
                                                FlexAlign b59 = b(flexNode3, f111);
                                                if (b59 == FlexAlign.STRETCH) {
                                                    float[] fArr29 = f111.f105335d.f105382b;
                                                    int[] iArr45 = f105414h;
                                                    if (Float.isNaN(fArr29[iArr45[i143]])) {
                                                        float[] fArr30 = f111.f105335d.f105382b;
                                                        int i145 = iArr45[i143];
                                                        o oVar19 = f111.f105336e.f105397j;
                                                        int[] iArr46 = f105415i;
                                                        int i146 = iArr46[i143];
                                                        int[] iArr47 = f105411e;
                                                        f39 = f105;
                                                        float b65 = oVar19.b(i146, iArr47[i143]);
                                                        o oVar20 = f111.f105336e.f105397j;
                                                        int[] iArr48 = f105416j;
                                                        f46 = f104;
                                                        int i147 = iArr48[i143];
                                                        int[] iArr49 = f105412f;
                                                        i57 = i49;
                                                        fArr30[i145] = Math.max(a(f111, i143, (f110 - f38) - (b65 + oVar20.b(i147, iArr49[i143]))), f111.f105336e.f105398k.b(iArr46[i143], iArr47[i143]) + f111.f105336e.f105399l.b(iArr46[i143], iArr47[i143]) + f111.f105336e.f105398k.b(iArr48[i143], iArr49[i143]) + f111.f105336e.f105399l.b(iArr48[i143], iArr49[i143]));
                                                        if (flexNode14 == null) {
                                                            flexNode24 = f111;
                                                            flexNode14 = flexNode24;
                                                        } else {
                                                            flexNode24.C = f111;
                                                            flexNode24 = f111;
                                                        }
                                                    }
                                                } else {
                                                    f39 = f105;
                                                    f46 = f104;
                                                    i57 = i49;
                                                    if (b59 != FlexAlign.FLEX_START) {
                                                        float b66 = (f110 - f38) - ((f111.f105335d.f105382b[f105414h[i143]] + f111.f105336e.f105397j.b(f105415i[i143], f105411e[i143])) + f111.f105336e.f105397j.b(f105416j[i143], f105412f[i143]));
                                                        if (b59 == FlexAlign.CENTER) {
                                                            b66 /= 2.0f;
                                                        }
                                                        f47 = b27 + b66;
                                                        h hVar5 = f111.f105335d;
                                                        float[] fArr31 = hVar5.f105381a;
                                                        int i148 = f105413g[i143];
                                                        float f112 = fArr31[i148] + f75 + f47;
                                                        fArr31[i148] = f112;
                                                        if (z19) {
                                                            int i149 = f105412f[i143];
                                                            float[] fArr32 = flexNode3.f105335d.f105382b;
                                                            int i150 = f105414h[i143];
                                                            fArr31[i149] = (fArr32[i150] - hVar5.f105382b[i150]) - f112;
                                                        }
                                                    }
                                                }
                                                f47 = b27;
                                                h hVar52 = f111.f105335d;
                                                float[] fArr312 = hVar52.f105381a;
                                                int i1482 = f105413g[i143];
                                                float f1122 = fArr312[i1482] + f75 + f47;
                                                fArr312[i1482] = f1122;
                                                if (z19) {
                                                }
                                            }
                                            f39 = f105;
                                            f46 = f104;
                                            i57 = i49;
                                            f47 = b27;
                                            h hVar522 = f111.f105335d;
                                            float[] fArr3122 = hVar522.f105381a;
                                            int i14822 = f105413g[i143];
                                            float f11222 = fArr3122[i14822] + f75 + f47;
                                            fArr3122[i14822] = f11222;
                                            if (z19) {
                                            }
                                        }
                                        i49 = i57 + 1;
                                        flexLayoutDirection2 = flexLayoutDirection3;
                                        f105 = f39;
                                        i104 = i58;
                                        f104 = f46;
                                        i47 = i56;
                                    }
                                    int i151 = i47;
                                    FlexLayoutDirection flexLayoutDirection5 = flexLayoutDirection2;
                                    f75 += f104;
                                    f76 = Math.max(f76, f105);
                                    i105 = i38 + 1;
                                    flexNode11 = flexNode3;
                                    b29 = f38;
                                    z47 = z26;
                                    i106 = i104;
                                    z39 = z27;
                                    flexJustifyContent3 = flexJustifyContent5;
                                    f69 = f77;
                                    z38 = z18;
                                    b19 = f27;
                                    i103 = i151;
                                    z46 = z19;
                                    k16 = i36;
                                    i16 = i143;
                                    flexNode15 = flexNode24;
                                    b28 = f87;
                                    h17 = i29;
                                    flexNode13 = flexNode4;
                                    flexLayoutDirection4 = flexLayoutDirection5;
                                }
                                max = f36;
                                f37 = max;
                                float f1042 = f29;
                                i104 = i108;
                                i48 = i109;
                                float f1052 = f78 + max;
                                while (i48 < i104) {
                                }
                                FlexJustifyContent flexJustifyContent52 = flexJustifyContent;
                                int i1432 = i46;
                                float f1102 = flexNode3.f105335d.f105382b[f105414h[i1432]];
                                if (z19) {
                                }
                                FlexNode flexNode242 = flexNode15;
                                i49 = i107;
                                while (i49 < i104) {
                                }
                                int i1512 = i47;
                                FlexLayoutDirection flexLayoutDirection52 = flexLayoutDirection2;
                                f75 += f1042;
                                f76 = Math.max(f76, f1052);
                                i105 = i38 + 1;
                                flexNode11 = flexNode3;
                                b29 = f38;
                                z47 = z26;
                                i106 = i104;
                                z39 = z27;
                                flexJustifyContent3 = flexJustifyContent52;
                                f69 = f77;
                                z38 = z18;
                                b19 = f27;
                                i103 = i1512;
                                z46 = z19;
                                k16 = i36;
                                i16 = i1432;
                                flexNode15 = flexNode242;
                                b28 = f87;
                                h17 = i29;
                                flexNode13 = flexNode4;
                                flexLayoutDirection4 = flexLayoutDirection52;
                            } else {
                                f36 = 0.0f;
                                if (flexJustifyContent == FlexJustifyContent.SPACE_AROUND) {
                                    int i152 = i112 + i110;
                                    if (i152 != 0) {
                                        max /= i152;
                                    }
                                    f37 = max;
                                    max /= 2.0f;
                                    float f10422 = f29;
                                    i104 = i108;
                                    i48 = i109;
                                    float f10522 = f78 + max;
                                    while (i48 < i104) {
                                    }
                                    FlexJustifyContent flexJustifyContent522 = flexJustifyContent;
                                    int i14322 = i46;
                                    float f11022 = flexNode3.f105335d.f105382b[f105414h[i14322]];
                                    if (z19) {
                                    }
                                    FlexNode flexNode2422 = flexNode15;
                                    i49 = i107;
                                    while (i49 < i104) {
                                    }
                                    int i15122 = i47;
                                    FlexLayoutDirection flexLayoutDirection522 = flexLayoutDirection2;
                                    f75 += f10422;
                                    f76 = Math.max(f76, f10522);
                                    i105 = i38 + 1;
                                    flexNode11 = flexNode3;
                                    b29 = f38;
                                    z47 = z26;
                                    i106 = i104;
                                    z39 = z27;
                                    flexJustifyContent3 = flexJustifyContent522;
                                    f69 = f77;
                                    z38 = z18;
                                    b19 = f27;
                                    i103 = i15122;
                                    z46 = z19;
                                    k16 = i36;
                                    i16 = i14322;
                                    flexNode15 = flexNode2422;
                                    b28 = f87;
                                    h17 = i29;
                                    flexNode13 = flexNode4;
                                    flexLayoutDirection4 = flexLayoutDirection522;
                                }
                                max = f36;
                                f37 = max;
                                float f104222 = f29;
                                i104 = i108;
                                i48 = i109;
                                float f105222 = f78 + max;
                                while (i48 < i104) {
                                }
                                FlexJustifyContent flexJustifyContent5222 = flexJustifyContent;
                                int i143222 = i46;
                                float f110222 = flexNode3.f105335d.f105382b[f105414h[i143222]];
                                if (z19) {
                                }
                                FlexNode flexNode24222 = flexNode15;
                                i49 = i107;
                                while (i49 < i104) {
                                }
                                int i151222 = i47;
                                FlexLayoutDirection flexLayoutDirection5222 = flexLayoutDirection2;
                                f75 += f104222;
                                f76 = Math.max(f76, f105222);
                                i105 = i38 + 1;
                                flexNode11 = flexNode3;
                                b29 = f38;
                                z47 = z26;
                                i106 = i104;
                                z39 = z27;
                                flexJustifyContent3 = flexJustifyContent5222;
                                f69 = f77;
                                z38 = z18;
                                b19 = f27;
                                i103 = i151222;
                                z46 = z19;
                                k16 = i36;
                                i16 = i143222;
                                flexNode15 = flexNode24222;
                                b28 = f87;
                                h17 = i29;
                                flexNode13 = flexNode4;
                                flexLayoutDirection4 = flexLayoutDirection5222;
                            }
                        }
                        f36 = 0.0f;
                        f37 = 0.0f;
                        float f1042222 = f29;
                        i104 = i108;
                        i48 = i109;
                        float f1052222 = f78 + max;
                        while (i48 < i104) {
                        }
                        FlexJustifyContent flexJustifyContent52222 = flexJustifyContent;
                        int i1432222 = i46;
                        float f1102222 = flexNode3.f105335d.f105382b[f105414h[i1432222]];
                        if (z19) {
                        }
                        FlexNode flexNode242222 = flexNode15;
                        i49 = i107;
                        while (i49 < i104) {
                        }
                        int i1512222 = i47;
                        FlexLayoutDirection flexLayoutDirection52222 = flexLayoutDirection2;
                        f75 += f1042222;
                        f76 = Math.max(f76, f1052222);
                        i105 = i38 + 1;
                        flexNode11 = flexNode3;
                        b29 = f38;
                        z47 = z26;
                        i106 = i104;
                        z39 = z27;
                        flexJustifyContent3 = flexJustifyContent52222;
                        f69 = f77;
                        z38 = z18;
                        b19 = f27;
                        i103 = i1512222;
                        z46 = z19;
                        k16 = i36;
                        i16 = i1432222;
                        flexNode15 = flexNode242222;
                        b28 = f87;
                        h17 = i29;
                        flexNode13 = flexNode4;
                        flexLayoutDirection4 = flexLayoutDirection52222;
                    }
                }
                f36 = 0.0f;
                max = f36;
                f37 = max;
                float f10422222 = f29;
                i104 = i108;
                i48 = i109;
                float f10522222 = f78 + max;
                while (i48 < i104) {
                }
                FlexJustifyContent flexJustifyContent522222 = flexJustifyContent;
                int i14322222 = i46;
                float f11022222 = flexNode3.f105335d.f105382b[f105414h[i14322222]];
                if (z19) {
                }
                FlexNode flexNode2422222 = flexNode15;
                i49 = i107;
                while (i49 < i104) {
                }
                int i15122222 = i47;
                FlexLayoutDirection flexLayoutDirection522222 = flexLayoutDirection2;
                f75 += f10422222;
                f76 = Math.max(f76, f10522222);
                i105 = i38 + 1;
                flexNode11 = flexNode3;
                b29 = f38;
                z47 = z26;
                i106 = i104;
                z39 = z27;
                flexJustifyContent3 = flexJustifyContent522222;
                f69 = f77;
                z38 = z18;
                b19 = f27;
                i103 = i15122222;
                z46 = z19;
                k16 = i36;
                i16 = i14322222;
                flexNode15 = flexNode2422222;
                b28 = f87;
                h17 = i29;
                flexNode13 = flexNode4;
                flexLayoutDirection4 = flexLayoutDirection522222;
            }
            int i153 = h17;
            boolean z58 = z39;
            float f113 = b28;
            int i154 = i103;
            boolean z59 = z46;
            int i155 = i16;
            float f114 = b29;
            FlexNode flexNode25 = flexNode11;
            int i156 = i105;
            float f115 = f76;
            if (i156 > 1 && z59) {
                float f116 = flexNode25.f105335d.f105382b[f105414h[i155]] - f114;
                float f117 = f116 - f75;
                FlexAlign flexAlign3 = flexNode25.f105336e.f105391d;
                if (flexAlign3 != FlexAlign.FLEX_END) {
                    if (flexAlign3 == FlexAlign.CENTER) {
                        f117 /= 2.0f;
                    } else if (flexAlign3 != FlexAlign.STRETCH || f116 <= f75) {
                        f17 = b27;
                        f18 = 0.0f;
                        i26 = 0;
                        int i157 = 0;
                        while (i26 < i156) {
                            int i158 = i157;
                            int i159 = i153;
                            float f118 = 0.0f;
                            while (i158 < i159) {
                                FlexNode f119 = flexNode25.f(i158);
                                if (f119 != null && f119.r() && f119.f105336e.f105394g == FlexPositionType.RELATIVE) {
                                    if (f119.f105338h != i26) {
                                        break;
                                    }
                                    float[] fArr33 = f119.f105335d.f105382b;
                                    int[] iArr50 = f105414h;
                                    if (!Float.isNaN(fArr33[iArr50[i155]])) {
                                        i28 = i156;
                                        f118 = Math.max(f118, f119.f105335d.f105382b[iArr50[i155]] + f119.f105336e.f105397j.b(f105415i[i155], f105411e[i155]) + f119.f105336e.f105397j.b(f105416j[i155], f105412f[i155]));
                                        i158++;
                                        i156 = i28;
                                    }
                                }
                                i28 = i156;
                                i158++;
                                i156 = i28;
                            }
                            int i160 = i156;
                            float f120 = f118 + f18;
                            while (i157 < i158) {
                                FlexNode f121 = flexNode25.f(i157);
                                if (f121 != null && f121.r() && f121.f105336e.f105394g == FlexPositionType.RELATIVE) {
                                    FlexAlign b67 = b(flexNode25, f121);
                                    if (b67 == FlexAlign.FLEX_START) {
                                        f121.f105335d.f105381a[f105413g[i155]] = f121.f105336e.f105397j.b(f105415i[i155], f105411e[i155]) + f17;
                                    } else {
                                        if (b67 == FlexAlign.FLEX_END) {
                                            i27 = i158;
                                            f19 = f18;
                                            f121.f105335d.f105381a[f105413g[i155]] = ((f17 + f120) - f121.f105336e.f105397j.b(f105416j[i155], f105412f[i155])) - f121.f105336e.f105401n[f105414h[i155]];
                                        } else {
                                            i27 = i158;
                                            f19 = f18;
                                            if (b67 == FlexAlign.CENTER) {
                                                h hVar6 = f121.f105335d;
                                                hVar6.f105381a[f105413g[i155]] = ((f120 - hVar6.f105382b[f105414h[i155]]) / 2.0f) + f17;
                                            } else if (b67 == FlexAlign.STRETCH) {
                                                f121.f105335d.f105381a[f105413g[i155]] = f121.f105336e.f105397j.b(f105415i[i155], f105411e[i155]) + f17;
                                            }
                                        }
                                        i157++;
                                        f18 = f19;
                                        i158 = i27;
                                    }
                                }
                                i27 = i158;
                                f19 = f18;
                                i157++;
                                f18 = f19;
                                i158 = i27;
                            }
                            f17 += f120;
                            i26++;
                            i153 = i159;
                            i157 = i158;
                            i156 = i160;
                        }
                    } else {
                        f18 = f117 / i156;
                        f17 = b27;
                        i26 = 0;
                        int i1572 = 0;
                        while (i26 < i156) {
                        }
                    }
                }
                f17 = b27 + f117;
                f18 = 0.0f;
                i26 = 0;
                int i15722 = 0;
                while (i26 < i156) {
                }
            }
            int i161 = i153;
            if (z58) {
                i18 = i154;
            } else {
                float[] fArr34 = flexNode25.f105335d.f105382b;
                int i162 = f105414h[i154];
                o oVar21 = flexNode25.f105336e.f105398k;
                int[] iArr51 = f105416j;
                int i163 = iArr51[i154];
                int[] iArr52 = f105412f;
                float b68 = oVar21.b(i163, iArr52[i154]) + flexNode25.f105336e.f105399l.b(iArr51[i154], iArr52[i154]) + f115;
                i18 = i154;
                fArr34[i162] = Math.max(a(flexNode25, i18, b68), f113);
                if (i18 == f105410d || i18 == f105408b) {
                    z16 = true;
                    if (!z59) {
                        flexNode25.f105335d.f105382b[f105414h[i155]] = Math.max(a(flexNode25, i155, f75 + f114), f114);
                        if (i155 == f105410d || i155 == f105408b) {
                            z17 = true;
                            if (!z16 || z17) {
                                for (i19 = 0; i19 < i161; i19++) {
                                    FlexNode f122 = flexNode25.f(i19);
                                    if (f122 != null && f122.r()) {
                                        if (z16) {
                                            h hVar7 = f122.f105335d;
                                            float[] fArr35 = hVar7.f105381a;
                                            int i164 = f105412f[i18];
                                            float[] fArr36 = flexNode25.f105335d.f105382b;
                                            int i165 = f105414h[i18];
                                            fArr35[i164] = (fArr36[i165] - hVar7.f105382b[i165]) - fArr35[f105413g[i18]];
                                        }
                                        if (z17) {
                                            h hVar8 = f122.f105335d;
                                            float[] fArr37 = hVar8.f105381a;
                                            int i166 = f105412f[i155];
                                            float[] fArr38 = flexNode25.f105335d.f105382b;
                                            int i167 = f105414h[i155];
                                            fArr37[i166] = (fArr38[i167] - hVar8.f105382b[i167]) - fArr37[f105413g[i155]];
                                        }
                                    }
                                }
                            }
                            flexNode2 = flexNode12;
                            while (flexNode2 != null) {
                                if (flexNode2.r()) {
                                    int i168 = 0;
                                    for (int i169 = 2; i168 < i169; i169 = 2) {
                                        int i170 = i168 != 0 ? f105409c : f105407a;
                                        float[] fArr39 = flexNode25.f105335d.f105382b;
                                        int[] iArr53 = f105414h;
                                        if (!Float.isNaN(fArr39[iArr53[i170]])) {
                                            if (!Float.isNaN(flexNode2.f105336e.f105401n[iArr53[i170]])) {
                                            }
                                            float[] fArr40 = flexNode2.f105336e.f105400m;
                                            int[] iArr54 = f105411e;
                                            if (!Float.isNaN(fArr40[iArr54[i170]])) {
                                                float[] fArr41 = flexNode2.f105336e.f105400m;
                                                int[] iArr55 = f105412f;
                                                if (!Float.isNaN(fArr41[iArr55[i170]])) {
                                                    float[] fArr42 = flexNode2.f105335d.f105382b;
                                                    int i171 = iArr53[i170];
                                                    float f123 = flexNode25.f105335d.f105382b[i171];
                                                    o oVar22 = flexNode25.f105336e.f105399l;
                                                    int[] iArr56 = f105415i;
                                                    float b69 = oVar22.b(iArr56[i170], iArr54[i170]);
                                                    o oVar23 = flexNode25.f105336e.f105399l;
                                                    int[] iArr57 = f105416j;
                                                    fArr42[i171] = Math.max(a(flexNode2, i170, (((f123 - (b69 + oVar23.b(iArr57[i170], iArr55[i170]))) - (flexNode2.f105336e.f105397j.b(iArr56[i170], iArr54[i170]) + flexNode2.f105336e.f105397j.b(iArr57[i170], iArr55[i170]))) - (Float.isNaN(flexNode2.f105336e.f105400m[iArr54[i170]]) ? 0.0f : flexNode2.f105336e.f105400m[iArr54[i170]])) - (Float.isNaN(flexNode2.f105336e.f105400m[iArr55[i170]]) ? 0.0f : flexNode2.f105336e.f105400m[iArr55[i170]])), flexNode2.f105336e.f105398k.b(iArr56[i170], iArr54[i170]) + flexNode2.f105336e.f105399l.b(iArr56[i170], iArr54[i170]) + flexNode2.f105336e.f105398k.b(iArr57[i170], iArr55[i170]) + flexNode2.f105336e.f105399l.b(iArr57[i170], iArr55[i170]));
                                                }
                                            }
                                        }
                                        float[] fArr43 = flexNode2.f105336e.f105400m;
                                        int[] iArr58 = f105412f;
                                        if (!Float.isNaN(fArr43[iArr58[i170]])) {
                                            float[] fArr44 = flexNode2.f105336e.f105400m;
                                            int[] iArr59 = f105411e;
                                            if (Float.isNaN(fArr44[iArr59[i170]])) {
                                                h hVar9 = flexNode2.f105335d;
                                                float[] fArr45 = hVar9.f105381a;
                                                int i172 = iArr59[i170];
                                                float[] fArr46 = flexNode25.f105335d.f105382b;
                                                int i173 = iArr53[i170];
                                                fArr45[i172] = (fArr46[i173] - hVar9.f105382b[i173]) - (Float.isNaN(flexNode2.f105336e.f105400m[iArr58[i170]]) ? 0.0f : flexNode2.f105336e.f105400m[iArr58[i170]]);
                                            }
                                        }
                                        i168++;
                                    }
                                }
                                FlexNode flexNode26 = flexNode2.f105339i;
                                flexNode2.f105339i = null;
                                flexNode2 = flexNode26;
                            }
                        }
                    }
                    z17 = false;
                    if (!z16) {
                    }
                    while (i19 < i161) {
                    }
                    flexNode2 = flexNode12;
                    while (flexNode2 != null) {
                    }
                }
            }
            z16 = false;
            if (!z59) {
            }
            z17 = false;
            if (!z16) {
            }
            while (i19 < i161) {
            }
            flexNode2 = flexNode12;
            while (flexNode2 != null) {
            }
        }
    }

    static boolean j(FlexNode flexNode, float f16) {
        if (flexNode.p() || !l.a(flexNode.f105337f.f105385e, flexNode.f105335d.f105382b[1]) || !l.a(flexNode.f105337f.f105384d, flexNode.f105335d.f105382b[0]) || !l.a(flexNode.f105337f.f105386f, f16)) {
            return true;
        }
        return false;
    }

    private static int k(int i3, FlexLayoutDirection flexLayoutDirection) {
        if (flexLayoutDirection == FlexLayoutDirection.RTL) {
            int i16 = f105409c;
            if (i3 == i16) {
                return f105410d;
            }
            if (i3 == f105410d) {
                return i16;
            }
        }
        return i3;
    }

    private static FlexLayoutDirection l(FlexNode flexNode, FlexLayoutDirection flexLayoutDirection) {
        FlexLayoutDirection flexLayoutDirection2 = flexNode.f105336e.f105388a;
        if (flexLayoutDirection2 == FlexLayoutDirection.INHERIT) {
            if (flexLayoutDirection == null) {
                flexLayoutDirection = FlexLayoutDirection.LTR;
            }
            return flexLayoutDirection;
        }
        return flexLayoutDirection2;
    }

    private static void m(FlexNode flexNode, int i3) {
        float[] fArr = flexNode.f105335d.f105382b;
        int[] iArr = f105414h;
        if (!Float.isNaN(fArr[iArr[i3]])) {
            return;
        }
        if (i3 != 0 && i3 != 1) {
            if ((Float.isNaN(flexNode.f105336e.f105401n[iArr[i3]]) && Float.isNaN(flexNode.f105336e.f105403p) && Float.isNaN(flexNode.f105336e.f105405r)) || flexNode.f105336e.f105401n[iArr[i3]] <= 0.0d) {
                return;
            }
        } else if ((Float.isNaN(flexNode.f105336e.f105401n[iArr[i3]]) && Float.isNaN(flexNode.f105336e.f105404q) && Float.isNaN(flexNode.f105336e.f105406s)) || flexNode.f105336e.f105401n[iArr[i3]] <= 0.0d) {
            return;
        }
        float a16 = a(flexNode, i3, flexNode.f105336e.f105401n[iArr[i3]]);
        o oVar = flexNode.f105336e.f105398k;
        int[] iArr2 = f105415i;
        int i16 = iArr2[i3];
        int[] iArr3 = f105411e;
        float b16 = oVar.b(i16, iArr3[i3]);
        o oVar2 = flexNode.f105336e.f105398k;
        int[] iArr4 = f105416j;
        int i17 = iArr4[i3];
        int[] iArr5 = f105412f;
        flexNode.f105335d.f105382b[iArr[i3]] = Math.max(a16, b16 + oVar2.b(i17, iArr5[i3]) + flexNode.f105336e.f105399l.b(iArr2[i3], iArr3[i3]) + flexNode.f105336e.f105399l.b(iArr4[i3], iArr5[i3]));
    }
}
