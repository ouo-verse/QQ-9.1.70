package oicq.wlogin_sdk.register;

import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public int f422816a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f422817b = 0;

    public static int a(int i3, byte[] bArr, c cVar) {
        int buf_to_int16;
        int buf_to_int162;
        int buf_to_int8;
        int buf_to_int82;
        int buf_to_int163;
        int buf_to_int164;
        int i16;
        int buf_to_int83;
        int buf_to_int84;
        int[] b16 = b(bArr);
        int i17 = b16[0];
        int i18 = b16[1];
        if (i17 == -1009) {
            return i17;
        }
        int i19 = i18 + 2;
        if (i19 > bArr.length) {
            return -1009;
        }
        cVar.f422822b = util.buf_to_int16(bArr, i18) & 65535;
        int i26 = i19 + 2;
        if (i26 > bArr.length || (buf_to_int162 = i26 + (buf_to_int16 = util.buf_to_int16(bArr, i19))) > bArr.length) {
            return -1009;
        }
        byte[] bArr2 = new byte[buf_to_int16];
        System.arraycopy(bArr, i26, bArr2, 0, buf_to_int16);
        int i27 = buf_to_int162 + 1;
        if (i27 > bArr.length || (buf_to_int82 = i27 + (buf_to_int8 = util.buf_to_int8(bArr, buf_to_int162))) > bArr.length) {
            return -1009;
        }
        byte[] bArr3 = new byte[buf_to_int8];
        cVar.f422823c = bArr3;
        System.arraycopy(bArr, i27, bArr3, 0, buf_to_int8);
        int i28 = buf_to_int82 + 2;
        if (i28 > bArr.length || (buf_to_int164 = i28 + (buf_to_int163 = util.buf_to_int16(bArr, buf_to_int82))) > bArr.length) {
            return -1009;
        }
        byte[] bArr4 = new byte[buf_to_int163];
        cVar.f422824d = bArr4;
        System.arraycopy(bArr, i28, bArr4, 0, buf_to_int163);
        if ((i3 == 3 || i3 == 10) && (i16 = buf_to_int164 + 2) <= bArr.length) {
            int buf_to_int165 = util.buf_to_int16(bArr, buf_to_int164);
            util.LOGI("reg cmd 0x3 has " + buf_to_int165 + " tlv");
            i17 = oicq.wlogin_sdk.contextpersist.a.a(buf_to_int165, bArr, i16, bArr.length - i16, cVar.f422840t);
            if (i17 != 0) {
                util.LOGI("parser tlv failed " + i17, "");
                return -1009;
            }
            util.LOGI("reg cmd 0x3 tlv map size " + cVar.f422840t.size());
        }
        if (buf_to_int16 <= 0) {
            return i17;
        }
        int i29 = cVar.f422822b;
        if (i29 != 0) {
            if (i29 != 31) {
                if (i29 != 44 && i29 != 51 && i29 != 58) {
                    if (i29 != 59) {
                        if (i29 != 2) {
                            if (i29 != 3) {
                                if (i29 != 4) {
                                    if (i29 != 5) {
                                        if (i29 != 6) {
                                            util.LOGW("unhandle return code int parse_checkvalid_rsp", "", "");
                                        }
                                    } else {
                                        if (2 > buf_to_int16) {
                                            return -1009;
                                        }
                                        cVar.f422835o = util.buf_to_int16(bArr2, 0);
                                        if (4 > buf_to_int16) {
                                            return -1009;
                                        }
                                    }
                                } else {
                                    if (2 > buf_to_int16) {
                                        return -1009;
                                    }
                                    cVar.f422835o = util.buf_to_int16(bArr2, 0);
                                    if (4 > buf_to_int16) {
                                        return -1009;
                                    }
                                }
                                cVar.f422836p = util.buf_to_int16(bArr2, 2);
                            }
                        } else {
                            if (1 > buf_to_int16 || (buf_to_int84 = (buf_to_int83 = util.buf_to_int8(bArr2, 0)) + 1) > buf_to_int16) {
                                return -1009;
                            }
                            byte[] bArr5 = new byte[buf_to_int83];
                            cVar.f422830j = bArr5;
                            System.arraycopy(bArr2, 1, bArr5, 0, buf_to_int83);
                            int i36 = buf_to_int84 + 1;
                            int buf_to_int85 = util.buf_to_int8(bArr2, buf_to_int84);
                            int i37 = i36 + buf_to_int85;
                            if (i37 > buf_to_int16) {
                                return -1009;
                            }
                            byte[] bArr6 = new byte[buf_to_int85];
                            cVar.f422831k = bArr6;
                            System.arraycopy(bArr2, i36, bArr6, 0, buf_to_int85);
                            int buf_to_int166 = util.buf_to_int16(bArr2, i37);
                            int i38 = i37 + 2;
                            if (i38 + buf_to_int166 > buf_to_int16) {
                                return -1009;
                            }
                            byte[] bArr7 = new byte[buf_to_int166];
                            cVar.f422832l = bArr7;
                            System.arraycopy(bArr2, i38, bArr7, 0, buf_to_int166);
                        }
                    } else {
                        if (2 > buf_to_int16) {
                            return -1009;
                        }
                        int buf_to_int167 = util.buf_to_int16(bArr2, 0);
                        if (buf_to_int167 + 2 > buf_to_int16) {
                            return -1009;
                        }
                        byte[] bArr8 = new byte[buf_to_int167];
                        cVar.f422834n = bArr8;
                        System.arraycopy(bArr2, 2, bArr8, 0, buf_to_int167);
                    }
                }
                if (2 > buf_to_int16) {
                    return -1009;
                }
                int buf_to_int168 = util.buf_to_int16(bArr2, 0);
                if (buf_to_int168 + 2 > buf_to_int16) {
                    return -1009;
                }
                byte[] bArr9 = new byte[buf_to_int168];
                cVar.f422833m = bArr9;
                System.arraycopy(bArr2, 2, bArr9, 0, buf_to_int168);
            } else {
                cVar.f422835o = 0;
                cVar.f422836p = 0;
            }
        } else {
            if (4 > buf_to_int16) {
                return -1009;
            }
            cVar.f422828h = util.buf_to_int32(bArr2, 0);
            if (5 > buf_to_int16) {
                return -1009;
            }
            int buf_to_int86 = util.buf_to_int8(bArr2, 4);
            if (buf_to_int86 + 5 > buf_to_int16) {
                return -1009;
            }
            byte[] bArr10 = new byte[buf_to_int86];
            cVar.f422829i = bArr10;
            System.arraycopy(bArr2, 5, bArr10, 0, buf_to_int86);
        }
        return i17;
    }

    public static int[] b(byte[] bArr) {
        if (1 > bArr.length) {
            return new int[]{-1009, 0};
        }
        if (3 > bArr.length) {
            return new int[]{-1009, 1};
        }
        if (util.buf_to_int16(bArr, 1) != bArr.length) {
            return new int[]{-1009, 3};
        }
        if (7 > bArr.length) {
            return new int[]{-1009, 3};
        }
        if (8 > bArr.length) {
            return new int[]{-1009, 7};
        }
        int buf_to_int8 = util.buf_to_int8(bArr, 7) + 8;
        if (buf_to_int8 > bArr.length) {
            return new int[]{-1009, 8};
        }
        return new int[]{0, buf_to_int8};
    }

    public byte[] a(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length + 13];
        util.int8_to_buf(bArr2, 0, 2);
        util.int16_to_buf(bArr2, 1, bArr.length + 11 + 2);
        util.int16_to_buf(bArr2, 3, 3);
        util.int16_to_buf(bArr2, 5, this.f422816a);
        util.int8_to_buf(bArr2, 7, 4);
        util.int32_to_buf(bArr2, 8, 0);
        System.arraycopy(bArr, 0, bArr2, 12, bArr.length);
        util.int8_to_buf(bArr2, bArr.length + 12, 3);
        return bArr2;
    }
}
