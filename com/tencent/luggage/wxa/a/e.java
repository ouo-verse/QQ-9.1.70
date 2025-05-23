package com.tencent.luggage.wxa.a;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e {

    /* renamed from: b, reason: collision with root package name */
    public static final float[] f120466b = {1.0f, 10.0f, 100.0f, 1000.0f, 10000.0f, 100000.0f, 1000000.0f, 1.0E7f, 1.0E8f, 1.0E9f, 1.0E10f, 9.9999998E10f, 1.0E12f, 9.9999998E12f, 1.0E14f, 9.9999999E14f, 1.00000003E16f, 9.9999998E16f, 9.9999998E17f, 1.0E19f, 1.0E20f, 1.0E21f, 1.0E22f, 1.0E23f, 1.0E24f, 1.0E25f, 1.0E26f, 1.0E27f, 1.0E28f, 1.0E29f, 1.0E30f, 1.0E31f, 1.0E32f, 1.0E33f, 1.0E34f, 1.0E35f, 1.0E36f, 1.0E37f, 1.0E38f};

    /* renamed from: c, reason: collision with root package name */
    public static final float[] f120467c = {1.0f, 0.1f, 0.01f, 0.001f, 1.0E-4f, 1.0E-5f, 1.0E-6f, 1.0E-7f, 1.0E-8f, 1.0E-9f, 1.0E-10f, 1.0E-11f, 1.0E-12f, 1.0E-13f, 1.0E-14f, 1.0E-15f, 1.0E-16f, 1.0E-17f, 1.0E-18f, 1.0E-19f, 1.0E-20f, 1.0E-21f, 1.0E-22f, 1.0E-23f, 1.0E-24f, 1.0E-25f, 1.0E-26f, 1.0E-27f, 1.0E-28f, 1.0E-29f, 1.0E-30f, 1.0E-31f, 1.0E-32f, 1.0E-33f, 1.0E-34f, 1.0E-35f, 1.0E-36f, 1.0E-37f, 1.0E-38f};

    /* renamed from: a, reason: collision with root package name */
    public int f120468a;

    public int a() {
        return this.f120468a;
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x008a A[EDGE_INSN: B:118:0x008a->B:47:0x008a BREAK  A[LOOP:0: B:10:0x0032->B:17:0x0080], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00dc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public float a(String str, int i3, int i16) {
        boolean z16;
        int i17;
        int i18;
        boolean z17;
        int i19;
        int i26;
        int i27;
        float f16;
        char charAt;
        int i28;
        boolean z18;
        boolean z19;
        char charAt2;
        this.f120468a = i3;
        if (i3 >= i16) {
            return Float.NaN;
        }
        char charAt3 = str.charAt(i3);
        if (charAt3 == '+') {
            z16 = false;
        } else {
            if (charAt3 != '-') {
                z16 = false;
                int i29 = this.f120468a;
                long j3 = 0;
                i17 = 0;
                i18 = 0;
                int i36 = 0;
                z17 = false;
                int i37 = 0;
                while (true) {
                    i19 = this.f120468a;
                    if (i19 >= i16) {
                        break;
                    }
                    char charAt4 = str.charAt(i19);
                    if (charAt4 == '0') {
                        if (i17 == 0) {
                            i36++;
                        } else {
                            i18++;
                        }
                    } else if (charAt4 >= '1' && charAt4 <= '9') {
                        int i38 = i17 + i18;
                        while (i18 > 0) {
                            if (j3 > 922337203685477580L) {
                                return Float.NaN;
                            }
                            j3 *= 10;
                            i18--;
                        }
                        if (j3 > 922337203685477580L) {
                            return Float.NaN;
                        }
                        j3 = (j3 * 10) + (charAt4 - '0');
                        i17 = i38 + 1;
                        if (j3 < 0) {
                            return Float.NaN;
                        }
                    } else {
                        if (charAt4 != '.' || z17) {
                            break;
                        }
                        i37 = this.f120468a - i29;
                        z17 = true;
                    }
                    this.f120468a++;
                }
                if (!z17 && this.f120468a == i37 + 1) {
                    return Float.NaN;
                }
                if (i17 == 0) {
                    if (i36 == 0) {
                        return Float.NaN;
                    }
                    i17 = 1;
                }
                if (z17) {
                    i18 = (i37 - i36) - i17;
                }
                i26 = this.f120468a;
                if (i26 < i16 && ((charAt = str.charAt(i26)) == 'E' || charAt == 'e')) {
                    i28 = this.f120468a + 1;
                    this.f120468a = i28;
                    if (i28 != i16) {
                        return Float.NaN;
                    }
                    char charAt5 = str.charAt(i28);
                    if (charAt5 == '+') {
                        z18 = false;
                    } else if (charAt5 != '-') {
                        switch (charAt5) {
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                z18 = false;
                                z19 = false;
                                break;
                            default:
                                this.f120468a--;
                                z19 = true;
                                z18 = false;
                                break;
                        }
                        if (!z19) {
                            int i39 = this.f120468a;
                            int i46 = 0;
                            while (true) {
                                int i47 = this.f120468a;
                                if (i47 < i16 && (charAt2 = str.charAt(i47)) >= '0' && charAt2 <= '9') {
                                    if (i46 > 922337203685477580L) {
                                        return Float.NaN;
                                    }
                                    i46 = (i46 * 10) + (charAt2 - '0');
                                    this.f120468a++;
                                }
                            }
                            if (this.f120468a == i39) {
                                return Float.NaN;
                            }
                            i18 = z18 ? i18 - i46 : i18 + i46;
                        }
                    } else {
                        z18 = true;
                    }
                    this.f120468a++;
                    z19 = false;
                    if (!z19) {
                    }
                }
                i27 = i17 + i18;
                if (i27 <= 39 || i27 < -44) {
                    return Float.NaN;
                }
                long j16 = j3;
                float f17 = (float) j16;
                if (j16 != 0) {
                    if (i18 > 0) {
                        f16 = f120466b[i18];
                    } else if (i18 < 0) {
                        if (i18 < -38) {
                            f17 = (float) (f17 * 1.0E-20d);
                            i18 += 20;
                        }
                        f16 = f120467c[-i18];
                    }
                    f17 *= f16;
                }
                return z16 ? -f17 : f17;
            }
            z16 = true;
        }
        this.f120468a++;
        int i292 = this.f120468a;
        long j36 = 0;
        i17 = 0;
        i18 = 0;
        int i362 = 0;
        z17 = false;
        int i372 = 0;
        while (true) {
            i19 = this.f120468a;
            if (i19 >= i16) {
            }
            this.f120468a++;
        }
        if (!z17) {
        }
        if (i17 == 0) {
        }
        if (z17) {
        }
        i26 = this.f120468a;
        if (i26 < i16) {
            i28 = this.f120468a + 1;
            this.f120468a = i28;
            if (i28 != i16) {
            }
        }
        i27 = i17 + i18;
        if (i27 <= 39) {
        }
        return Float.NaN;
    }
}
