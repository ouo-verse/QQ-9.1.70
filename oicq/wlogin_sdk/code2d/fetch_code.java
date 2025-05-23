package oicq.wlogin_sdk.code2d;

import java.util.ArrayList;
import oicq.wlogin_sdk.request.u;
import oicq.wlogin_sdk.tlv_type.tlv_t;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class fetch_code extends c {

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class QRCodeCustom {
        public int Micro = 0;
        public int Version = 0;
        public int Size = 3;
        public int Margin = 4;
        public int Dpi = 72;
        public int EcLevel = 2;
        public int Hint = 2;
    }

    public fetch_code() {
        this._cmd = 49;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x01ea  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] get_request(long j3, long j16, long j17, byte[] bArr, QRCodeCustom qRCodeCustom, long j18, long j19, byte[] bArr2) {
        tlv_t tlv_tVar;
        int[] iArr;
        ArrayList arrayList;
        int i3;
        int length;
        byte[] bArr3;
        ArrayList arrayList2;
        int i16 = 17;
        int length2 = bArr.length + 17 + 2;
        int[] iArr2 = {17, 22, 27, 29, 31, 51, 53};
        ArrayList arrayList3 = new ArrayList();
        int i17 = 0;
        for (int i18 = 7; i17 < i18; i18 = 7) {
            tlv_t tlv_tVar2 = new tlv_t();
            tlv_tVar2.fill_head(iArr2[i17]);
            int i19 = iArr2[i17];
            if (i19 != i16) {
                if (i19 != 22) {
                    iArr = iArr2;
                    if (i19 != 27) {
                        if (i19 != 29) {
                            if (i19 != 31) {
                                if (i19 != 51) {
                                    if (i19 != 53) {
                                        tlv_tVar = tlv_tVar2;
                                        arrayList = arrayList3;
                                        i3 = i17;
                                        bArr3 = null;
                                        length = 0;
                                    } else {
                                        bArr3 = new byte[4];
                                        util.int32_to_buf(bArr3, 0, u.f422942s0);
                                        tlv_tVar = tlv_tVar2;
                                        length = 4;
                                    }
                                } else {
                                    bArr3 = (byte[]) u.D.clone();
                                    length = bArr3.length;
                                    tlv_tVar = tlv_tVar2;
                                }
                                arrayList = arrayList3;
                                i3 = i17;
                            } else {
                                int length3 = u.H.length + u.L.length + 3 + 2 + u.K.length + 2 + 2 + oicq.wlogin_sdk.utils.b.d(u.f422949w).length + 2 + 0 + 2;
                                bArr3 = new byte[length3];
                                util.LOGI("os " + new String(u.L) + " sim info " + new String(oicq.wlogin_sdk.utils.b.d(u.f422949w)) + " apn " + new String(u.H), "");
                                util.int8_to_buf(bArr3, 0, u.Y);
                                int fill_staff = fill_staff(bArr3, u.K, fill_staff(bArr3, u.L, 1));
                                util.int16_to_buf(bArr3, fill_staff, u.F);
                                fill_staff(bArr3, u.H, fill_staff(bArr3, new byte[0], fill_staff(bArr3, oicq.wlogin_sdk.utils.b.d(u.f422949w), fill_staff + 2)));
                                tlv_tVar = tlv_tVar2;
                                arrayList = arrayList3;
                                i3 = i17;
                                length = length3;
                            }
                        } else {
                            bArr3 = new byte[14];
                            util.int8_to_buf(bArr3, 0, 1);
                            arrayList = arrayList3;
                            util.int64_to_buf32(bArr3, 1, j18);
                            tlv_tVar = tlv_tVar2;
                            util.int64_to_buf32(bArr3, 5, j19);
                            util.int8_to_buf(bArr3, 9, 0);
                            i3 = i17;
                            util.int64_to_buf32(bArr3, 10, 0L);
                            length = 14;
                        }
                    } else {
                        tlv_tVar = tlv_tVar2;
                        arrayList = arrayList3;
                        i3 = i17;
                        byte[] bArr4 = new byte[30];
                        util.int32_to_buf(bArr4, 0, qRCodeCustom.Micro);
                        util.int32_to_buf(bArr4, 4, qRCodeCustom.Version);
                        util.int32_to_buf(bArr4, 8, qRCodeCustom.Size);
                        util.int32_to_buf(bArr4, 12, qRCodeCustom.Margin);
                        util.int32_to_buf(bArr4, 16, qRCodeCustom.Dpi);
                        util.int32_to_buf(bArr4, 20, qRCodeCustom.EcLevel);
                        util.int32_to_buf(bArr4, 24, qRCodeCustom.Hint);
                        util.int16_to_buf(bArr4, 28, 0);
                        bArr3 = bArr4;
                        length = 30;
                    }
                } else {
                    tlv_tVar = tlv_tVar2;
                    iArr = iArr2;
                    arrayList = arrayList3;
                    i3 = i17;
                    bArr3 = getAppInfo(j16, j17);
                    length = bArr3.length;
                }
                if (bArr3 != null) {
                    tlv_t tlv_tVar3 = tlv_tVar;
                    tlv_tVar3.fill_body(bArr3, length);
                    tlv_tVar3.set_length();
                    byte[] bArr5 = tlv_tVar3.get_buf();
                    length2 += bArr5.length;
                    arrayList2 = arrayList;
                    arrayList2.add(bArr5);
                } else {
                    arrayList2 = arrayList;
                }
                i17 = i3 + 1;
                arrayList3 = arrayList2;
                iArr2 = iArr;
                i16 = 17;
            } else {
                tlv_tVar = tlv_tVar2;
                iArr = iArr2;
                arrayList = arrayList3;
                i3 = i17;
                if (bArr2 != null && bArr2.length > 0) {
                    length = bArr2.length;
                    util.LOGI("qrpushsig of " + j16, j3 + "");
                    bArr3 = bArr2;
                    if (bArr3 != null) {
                    }
                    i17 = i3 + 1;
                    arrayList3 = arrayList2;
                    iArr2 = iArr;
                    i16 = 17;
                }
                bArr3 = null;
                length = 0;
                if (bArr3 != null) {
                }
                i17 = i3 + 1;
                arrayList3 = arrayList2;
                iArr2 = iArr;
                i16 = 17;
            }
        }
        ArrayList arrayList4 = arrayList3;
        byte[] bArr6 = new byte[length2];
        util.int64_to_buf32(bArr6, 2, j16);
        util.int64_to_buf(bArr6, 6, j3);
        util.int8_to_buf(bArr6, 14, 8);
        int fill_staff2 = fill_staff(bArr6, bArr, 15);
        int size = arrayList4.size();
        util.int16_to_buf(bArr6, fill_staff2, size);
        int i26 = fill_staff2 + 2;
        for (int i27 = 0; i27 < size; i27++) {
            byte[] bArr7 = (byte[]) arrayList4.get(i27);
            System.arraycopy(bArr7, 0, bArr6, i26, bArr7.length);
            i26 += bArr7.length;
        }
        return get_request(j3, true, bArr6);
    }

    public int get_response(byte[] bArr) {
        byte[] bArr2 = get_response(bArr, 0);
        if (bArr2 != null && bArr2.length >= 11) {
            d dVar = c._status;
            util.buf_to_int32(bArr2, 2);
            dVar.getClass();
            c._status.f422750b = util.buf_to_int8(bArr2, 6);
            if (c._status.f422750b != 0) {
                int buf_to_int16 = util.buf_to_int16(bArr2, 7);
                byte[] bArr3 = new byte[buf_to_int16];
                c._status.f422754f = bArr3;
                System.arraycopy(bArr2, 9, bArr3, 0, buf_to_int16);
            } else {
                int buf_to_int162 = util.buf_to_int16(bArr2, 7);
                byte[] bArr4 = new byte[buf_to_int162];
                d.f422744k = bArr4;
                System.arraycopy(bArr2, 9, bArr4, 0, buf_to_int162);
                int i3 = buf_to_int162 + 9;
                int buf_to_int163 = util.buf_to_int16(bArr2, i3);
                int i16 = i3 + 2;
                for (int i17 = 0; i17 < buf_to_int163; i17++) {
                    int buf_to_int164 = util.buf_to_int16(bArr2, i16);
                    int i18 = i16 + 2;
                    int buf_to_int165 = util.buf_to_int16(bArr2, i18);
                    i16 = i18 + 2;
                    if (buf_to_int164 != 23) {
                        if (buf_to_int164 == 28) {
                            c._status.f422757i = util.buf_to_int32(bArr2, i16);
                            int i19 = i16 + 4;
                            c._status.f422758j = util.buf_to_int16(bArr2, i19);
                            i16 = i19 + 2;
                        }
                    } else {
                        byte[] bArr5 = new byte[buf_to_int165];
                        c._status.f422756h = bArr5;
                        System.arraycopy(bArr2, i16, bArr5, 0, buf_to_int165);
                        i16 += buf_to_int165;
                    }
                }
            }
            return c._status.f422750b;
        }
        return -1009;
    }
}
