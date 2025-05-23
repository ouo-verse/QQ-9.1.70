package oicq.wlogin_sdk.register;

import com.tencent.qqlive.tvkplayer.qqliveasset.player.message.TVKQQLiveAssetPlayerMsg;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.Map;
import oicq.wlogin_sdk.request.u;
import oicq.wlogin_sdk.tlv_type.RegTLV;
import oicq.wlogin_sdk.tlv_type.tlv_t544;
import oicq.wlogin_sdk.tools.MD5;
import oicq.wlogin_sdk.tools.cryptor;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class b extends a {
    public b() {
        this.f422816a = 6;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:29:0x0075. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:30:0x0078. Please report as an issue. */
    public byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, int i3, byte[] bArr5, byte[] bArr6, boolean z16, byte[] bArr7, long j3, byte[] bArr8, byte[] bArr9, int i16, byte[] bArr10, Map<Integer, RegTLV> map) {
        byte[] bytes;
        byte[] bArr11;
        byte[] bArr12;
        byte[] bArr13;
        int[] iArr;
        byte[] buf;
        RegTLV regTLV;
        RegTLV regTLV2;
        byte b16;
        byte[] bArr14 = bArr8;
        int i17 = 0;
        byte[] bArr15 = bArr6 == null ? new byte[0] : bArr6;
        byte[] bArr16 = bArr4 == null ? new byte[0] : bArr4;
        byte[] bArr17 = bArr7 == null ? new byte[0] : bArr7;
        byte[] bArr18 = bArr10 == null ? new byte[0] : bArr10;
        StringBuilder sb5 = new StringBuilder("reg_request_get_account");
        int[] iArr2 = z16 ? new int[]{1, 5, 6, 8, 15, 37, 9, 10, 11, 13, 14, 18, 58, TVKQQLiveAssetPlayerMsg.PLAYER_INFO_QUICK_PLAY_WITH_OFFLINE_RESOURCE} : new int[]{1, 5, 6, 8, 15, 37, 10, 13, 14, 18, 58, TVKQQLiveAssetPlayerMsg.PLAYER_INFO_QUICK_PLAY_WITH_OFFLINE_RESOURCE};
        ArrayList arrayList = new ArrayList();
        int length = iArr2.length;
        int i18 = 0;
        while (i17 < length) {
            int i19 = length;
            byte[] bArr19 = new byte[0];
            int i26 = iArr2[i17];
            if (i26 != 1) {
                if (i26 == 18) {
                    bArr11 = bArr15;
                    bArr12 = bArr16;
                    bArr13 = bArr17;
                    iArr = iArr2;
                    regTLV = new RegTLV(18);
                    regTLV.setData(bArr9, bArr9.length);
                } else if (i26 == 37) {
                    bArr11 = bArr15;
                    bArr12 = bArr16;
                    bArr13 = bArr17;
                    iArr = iArr2;
                    regTLV = new RegTLV(37);
                    regTLV.setShort(u.f422942s0);
                } else if (i26 != 58) {
                    iArr = iArr2;
                    if (i26 != 544) {
                        if (i26 != 5) {
                            if (i26 != 6) {
                                switch (i26) {
                                    case 8:
                                        b16 = 1;
                                        regTLV2 = new RegTLV(8);
                                        regTLV2.setByte(b16);
                                        break;
                                    case 9:
                                        regTLV2 = new RegTLV(9);
                                        b16 = 1;
                                        regTLV2.setByte(b16);
                                        break;
                                    case 10:
                                        regTLV2 = new RegTLV(10);
                                        regTLV2.setData(bArr17, bArr17.length);
                                        break;
                                    case 11:
                                        regTLV2 = new RegTLV(11);
                                        regTLV2.setData(bArr3, bArr3.length);
                                        break;
                                    default:
                                        switch (i26) {
                                            case 13:
                                                regTLV2 = new RegTLV(13);
                                                regTLV2.setInt((int) j3);
                                                break;
                                            case 14:
                                                RegTLV regTLV3 = new RegTLV(14);
                                                regTLV3.setData(bArr14, bArr14.length);
                                                buf = regTLV3.getBuf();
                                                bArr11 = bArr15;
                                                bArr12 = bArr16;
                                                bArr13 = bArr17;
                                                break;
                                            case 15:
                                                RegTLV regTLV4 = new RegTLV(15);
                                                regTLV4.setInt(i16);
                                                bArr11 = bArr15;
                                                bArr12 = bArr16;
                                                bArr13 = bArr17;
                                                buf = regTLV4.getBuf();
                                                break;
                                            default:
                                                buf = bArr19;
                                                break;
                                        }
                                }
                            } else {
                                regTLV2 = new RegTLV(6);
                                regTLV2.setData(bArr16, bArr16.length);
                            }
                            buf = regTLV2.getBuf();
                        } else {
                            RegTLV regTLV5 = new RegTLV(5);
                            regTLV5.setData(bArr15, bArr15.length);
                            buf = regTLV5.getBuf();
                        }
                        bArr11 = bArr15;
                        bArr12 = bArr16;
                        bArr13 = bArr17;
                    } else {
                        byte[] mD5Byte = MD5.toMD5Byte(bArr);
                        byte[] mD5Byte2 = MD5.toMD5Byte(bArr3);
                        bArr11 = bArr15;
                        bArr12 = bArr16;
                        byte[] bArr20 = new byte[mD5Byte.length + bArr5.length + mD5Byte2.length + 6];
                        bArr13 = bArr17;
                        util.int16_to_buf(bArr20, 0, mD5Byte.length);
                        System.arraycopy(mD5Byte, 0, bArr20, 0, mD5Byte.length);
                        int length2 = mD5Byte.length + 2;
                        util.int16_to_buf(bArr20, length2, bArr5.length);
                        int i27 = length2 + 2;
                        System.arraycopy(bArr5, 0, bArr20, i27, bArr5.length);
                        int length3 = i27 + bArr5.length;
                        util.int16_to_buf(bArr20, length3, mD5Byte2.length);
                        System.arraycopy(mD5Byte2, 0, bArr20, length3 + 2, mD5Byte2.length);
                        buf = new tlv_t544().get_tlv_544("", "812_6", bArr20);
                    }
                } else {
                    bArr11 = bArr15;
                    bArr12 = bArr16;
                    bArr13 = bArr17;
                    iArr = iArr2;
                    regTLV = new RegTLV(58);
                    regTLV.setData(bArr18, bArr18.length);
                }
                buf = regTLV.getBuf();
            } else {
                bArr11 = bArr15;
                bArr12 = bArr16;
                bArr13 = bArr17;
                iArr = iArr2;
                RegTLV regTLV6 = new RegTLV(1);
                regTLV6.setData(bArr5, bArr5.length);
                buf = regTLV6.getBuf();
            }
            if (buf.length >= 2) {
                i18 += buf.length;
                arrayList.add(buf);
            }
            i17++;
            length = i19;
            bArr14 = bArr8;
            iArr2 = iArr;
            bArr15 = bArr11;
            bArr16 = bArr12;
            bArr17 = bArr13;
        }
        for (Integer num : map.keySet()) {
            byte[] buf2 = map.get(num).getBuf();
            arrayList.add(buf2);
            i18 += buf2.length;
            sb5.append(",key=");
            sb5.append(num);
            sb5.append(",value=");
            sb5.append(buf2.length);
        }
        int size = arrayList.size();
        byte[] bArr21 = new byte[i18 + 2];
        int i28 = 0;
        util.int16_to_buf(bArr21, 0, (byte) size);
        sb5.append(",tlv cnt=");
        sb5.append(size);
        util.LOGI(sb5.toString(), "");
        int i29 = 0;
        int i36 = 2;
        while (i29 < size) {
            byte[] bArr22 = (byte[]) arrayList.get(i29);
            System.arraycopy(bArr22, i28, bArr21, i36, bArr22.length);
            i36 += bArr22.length;
            i29++;
            i28 = 0;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.writeByte(bArr.length);
            dataOutputStream.write(bArr);
            dataOutputStream.writeByte(bArr3.length);
            dataOutputStream.write(bArr3);
            dataOutputStream.writeByte(i3);
            dataOutputStream.write(bArr21);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (bArr2 != null && bArr2.length > 0) {
                util.LOGI("msgchk is " + util.buf_to_string(bArr2, bArr2.length), "");
                bytes = MD5.toMD5Byte(bArr2);
                byte[] encrypt = cryptor.encrypt(byteArray, 0, byteArray.length, bytes);
                int length4 = bArr.length + 1 + 2 + encrypt.length;
                this.f422817b = length4;
                byte[] bArr23 = new byte[length4];
                util.int8_to_buf(bArr23, 0, bArr.length);
                System.arraycopy(bArr, 0, bArr23, 1, bArr.length);
                int length5 = bArr.length + 1;
                util.int16_to_buf(bArr23, length5, encrypt.length);
                System.arraycopy(encrypt, 0, bArr23, length5 + 2, encrypt.length);
                util.LOGI("encryptedContent length " + encrypt.length, "");
                return a(bArr23);
            }
            util.LOGI("msgchk is null or length is 0", "");
            bytes = "e75734d01ad9b57f".getBytes();
            byte[] encrypt2 = cryptor.encrypt(byteArray, 0, byteArray.length, bytes);
            int length42 = bArr.length + 1 + 2 + encrypt2.length;
            this.f422817b = length42;
            byte[] bArr232 = new byte[length42];
            util.int8_to_buf(bArr232, 0, bArr.length);
            System.arraycopy(bArr, 0, bArr232, 1, bArr.length);
            int length52 = bArr.length + 1;
            util.int16_to_buf(bArr232, length52, encrypt2.length);
            System.arraycopy(encrypt2, 0, bArr232, length52 + 2, encrypt2.length);
            util.LOGI("encryptedContent length " + encrypt2.length, "");
            return a(bArr232);
        } catch (Exception e16) {
            util.LOGI("get account failed " + e16.getMessage(), "");
            return null;
        }
    }
}
