package o01;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f421676a = new f();

    public static void a(int i3, int i16, boolean z16, g[][] gVarArr) {
        g[] gVarArr2 = gVarArr[i3];
        g gVar = gVarArr2[i16];
        if (gVar != null) {
            gVar.f421677a = z16;
        } else {
            gVarArr2[i16] = new g(z16, i3, i16, gVarArr.length, null, 0, 0, null, 112);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00de A[LOOP:1: B:6:0x0027->B:20:0x00de, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00e6 A[EDGE_INSN: B:21:0x00e6->B:22:0x00e6 BREAK  A[LOOP:1: B:6:0x0027->B:20:0x00de], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b(int i3, int i16, g[][] gVarArr, int i17) {
        int i18;
        int i19;
        boolean z16;
        int i26;
        int length = gVarArr.length;
        int i27 = 1;
        g gVar = new g(false, i3, i16, length, new h(1, 11), i17, i17, null, 128);
        int i28 = -1;
        if (-1 > i17) {
            return;
        }
        int i29 = -1;
        while (true) {
            if (i28 <= i17) {
                int i36 = i28;
                while (true) {
                    int i37 = i29 + i3;
                    if (((i37 < 0 || i37 >= length) ? 0 : i27) != 0) {
                        int i38 = i36 + i16;
                        if (((i38 < 0 || i38 >= length) ? 0 : i27) != 0) {
                            i19 = i27;
                            if (i19 != 0) {
                                i26 = i36;
                                i18 = i29;
                            } else {
                                int i39 = 2;
                                if (((((i36 < 0 || i36 >= i17) ? 0 : i27) == 0 || !(i29 == 0 || i29 == i17 + (-1))) ? 0 : i27) == 0) {
                                    if (((((i29 < 0 || i29 >= i17) ? 0 : i27) == 0 || !(i36 == 0 || i36 == i17 + (-1))) ? 0 : i27) == 0) {
                                        if (((((2 > i29 || i29 >= i17 + (-2)) ? 0 : i27) == 0 || 2 > i36 || i36 > i17 + (-3)) ? 0 : i27) == 0) {
                                            z16 = 0;
                                            if (i29 != 0) {
                                                if (i36 == 0) {
                                                    i39 = i27;
                                                } else if (i36 != i17 - 1) {
                                                    if (i36 != i17) {
                                                        i39 = 3;
                                                    }
                                                    i39 = 10;
                                                }
                                                g[] gVarArr2 = gVarArr[i37];
                                                int i46 = i36 + i16;
                                                h hVar = new h(i27, i39);
                                                i26 = i36;
                                                i18 = i29;
                                                gVarArr2[i46] = new g(z16, i37, i46, length, hVar, 0, 0, gVar, 96);
                                            } else {
                                                int i47 = i17 - 1;
                                                if (i29 == i47) {
                                                    if (i36 == 0) {
                                                        i39 = 7;
                                                    } else if (i36 == i47) {
                                                        i39 = 8;
                                                    } else {
                                                        if (i36 != i17) {
                                                            i39 = 9;
                                                        }
                                                        i39 = 10;
                                                    }
                                                    g[] gVarArr22 = gVarArr[i37];
                                                    int i462 = i36 + i16;
                                                    h hVar2 = new h(i27, i39);
                                                    i26 = i36;
                                                    i18 = i29;
                                                    gVarArr22[i462] = new g(z16, i37, i462, length, hVar2, 0, 0, gVar, 96);
                                                } else {
                                                    if (i29 != i17) {
                                                        if (i36 == 0) {
                                                            i39 = 4;
                                                        } else if (i36 == i47) {
                                                            i39 = 5;
                                                        } else if (i36 != i17) {
                                                            i39 = 6;
                                                        }
                                                        g[] gVarArr222 = gVarArr[i37];
                                                        int i4622 = i36 + i16;
                                                        h hVar22 = new h(i27, i39);
                                                        i26 = i36;
                                                        i18 = i29;
                                                        gVarArr222[i4622] = new g(z16, i37, i4622, length, hVar22, 0, 0, gVar, 96);
                                                    }
                                                    i39 = 10;
                                                    g[] gVarArr2222 = gVarArr[i37];
                                                    int i46222 = i36 + i16;
                                                    h hVar222 = new h(i27, i39);
                                                    i26 = i36;
                                                    i18 = i29;
                                                    gVarArr2222[i46222] = new g(z16, i37, i46222, length, hVar222, 0, 0, gVar, 96);
                                                }
                                            }
                                        }
                                    }
                                }
                                z16 = i27;
                                if (i29 != 0) {
                                }
                            }
                            if (i26 != i17) {
                                break;
                            }
                            i36 = i26 + 1;
                            i29 = i18;
                            i27 = 1;
                        }
                    }
                    i19 = 0;
                    if (i19 != 0) {
                    }
                    if (i26 != i17) {
                    }
                }
            } else {
                i18 = i29;
            }
            if (i18 == i17) {
                return;
            }
            i29 = i18 + 1;
            i27 = 1;
            i28 = -1;
        }
    }
}
