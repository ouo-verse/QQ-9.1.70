package com.tencent.luggage.wxa.y8;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.wink.storage.kv.MaskType;
import cooperation.qzone.QZoneHelper;
import org.apache.commons.fileupload.MultipartStream;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class f {
    public static void a(e eVar, e eVar2, e eVar3, e eVar4, e eVar5, e eVar6) {
        eVar3.f145481b = 0;
        eVar3.f145480a = eVar2.f145480a;
        eVar4.f145481b = 28;
        eVar4.f145480a = eVar2.f145480a;
        eVar5.f145481b = 0;
        eVar5.f145480a = eVar.f145480a;
        eVar6.f145481b = 32;
        eVar6.f145480a = eVar.f145480a;
    }

    public static void b(e eVar, e eVar2, int i3) {
        for (int i16 = 0; i16 < i3; i16++) {
            eVar.f145480a[eVar.f145481b + i16] = (byte) ((eVar2.f145480a[(i16 >> 3) + eVar2.f145481b] >> (i16 & 7)) & 1);
        }
    }

    public static void c(e eVar, e eVar2, int i3) {
        for (int i16 = 0; i16 < i3; i16++) {
            byte[] bArr = eVar.f145480a;
            int i17 = eVar.f145481b + i16;
            bArr[i17] = (byte) (bArr[i17] ^ eVar2.f145480a[eVar2.f145481b + i16]);
        }
    }

    public static void d(e eVar, e eVar2, int i3) {
        for (int i16 = 0; i16 < i3; i16++) {
            eVar.f145480a[eVar.f145481b + i16] = eVar2.f145480a[eVar2.f145481b + i16];
        }
    }

    public static void a(e eVar, e eVar2, e eVar3) {
        for (int i3 = 0; i3 < 8; i3++) {
            eVar.f145480a[eVar.f145481b + i3] = (byte) (eVar2.f145480a[eVar2.f145481b + i3] ^ eVar3.f145480a[eVar3.f145481b + i3]);
        }
    }

    public static void a(e eVar, e eVar2, int i3) {
        a(eVar, 0, i3 >> 3);
        for (int i16 = 0; i16 < i3; i16++) {
            byte[] bArr = eVar.f145480a;
            int i17 = eVar.f145481b + (i16 >> 3);
            bArr[i17] = (byte) (bArr[i17] | (eVar2.f145480a[eVar2.f145481b + i16] << (i16 & 7)));
        }
    }

    public static void a(e eVar, e eVar2, int i3, int i16) {
        d(eVar2, eVar, i16);
        for (int i17 = 0; i17 < i3 - i16; i17++) {
            byte[] bArr = eVar.f145480a;
            int i18 = eVar.f145481b + i17;
            bArr[i18] = bArr[i18 + i16];
        }
        for (int i19 = 0; i19 < i16; i19++) {
            eVar.f145480a[((eVar.f145481b + i19) + i3) - i16] = eVar2.f145480a[eVar2.f145481b + i19];
        }
    }

    public static void a(e eVar, e eVar2, byte[] bArr, int i3, e eVar3) {
        for (int i16 = 0; i16 < i3; i16++) {
            eVar3.f145480a[eVar3.f145481b + i16] = eVar2.f145480a[(eVar2.f145481b + bArr[i16]) - 1];
        }
        d(eVar, eVar3, i3);
    }

    public static void a(e[] eVarArr, e eVar, e eVar2, e eVar3, e eVar4, e eVar5) {
        byte[] bArr = {57, 49, 41, 33, 25, 17, 9, 1, 58, 50, 42, WadlProxyConsts.REQUEST_CODE_INSTALL_PERMISSION, 26, RegisterType.REFERENCE, 10, 2, 59, 51, 43, 35, 27, RegisterType.CONFLICTED, 11, 3, 60, 52, 44, 36, 63, 55, 47, 39, 31, 23, RegisterType.DOUBLE_HI, 7, 62, 54, 46, 38, 30, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, RegisterType.DOUBLE_LO, 6, 61, 53, MultipartStream.DASH, 37, 29, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, 13, 5, 28, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, 12, 4};
        byte[] bArr2 = {RegisterType.DOUBLE_LO, 17, 11, 24, 1, 5, 3, 28, RegisterType.DOUBLE_HI, 6, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, 10, 23, RegisterType.CONFLICTED, 12, 4, 26, 8, RegisterType.UNINIT_REF, 7, 27, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, 13, 2, 41, 52, 31, 37, 47, 55, 30, 40, 51, MultipartStream.DASH, 33, 48, 44, 49, 39, 56, WadlProxyConsts.REQUEST_CODE_INSTALL_PERMISSION, 53, 46, 42, 50, 36, 29, 32};
        byte[] bArr3 = {1, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1};
        b(eVar2, eVar, 64);
        a(eVar2, eVar2, bArr, 56, eVar5);
        for (int i3 = 0; i3 < 16; i3++) {
            a(eVar3, eVar5, 28, bArr3[i3]);
            a(eVar4, eVar5, 28, bArr3[i3]);
            a(eVarArr[i3], eVar2, bArr2, 48, eVar5);
        }
    }

    public static void a(e[] eVarArr, e eVar, byte[] bArr, int i3, e eVar2, e eVar3, e eVar4, e eVar5) {
        a(eVar, 0, 24);
        e eVar6 = new e(bArr);
        if (i3 > 24) {
            i3 = 24;
        }
        d(eVar, eVar6, i3);
        a(eVarArr, eVar, eVar2, eVar3, eVar4, eVar5);
    }

    public static void a(e eVar, e eVar2) {
        byte b16 = 0;
        byte[][][] bArr = {new byte[][]{new byte[]{RegisterType.DOUBLE_LO, 4, 13, 1, 2, RegisterType.DOUBLE_HI, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7}, new byte[]{0, RegisterType.DOUBLE_HI, 7, 4, RegisterType.DOUBLE_LO, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8}, new byte[]{4, 1, RegisterType.DOUBLE_LO, 8, 13, 6, 2, 11, RegisterType.DOUBLE_HI, 12, 9, 7, 3, 10, 5, 0}, new byte[]{RegisterType.DOUBLE_HI, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, RegisterType.DOUBLE_LO, 10, 0, 6, 13}}, new byte[][]{new byte[]{RegisterType.DOUBLE_HI, 1, 8, RegisterType.DOUBLE_LO, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 10}, new byte[]{3, 13, 4, 7, RegisterType.DOUBLE_HI, 2, 8, RegisterType.DOUBLE_LO, 12, 0, 1, 10, 6, 9, 11, 5}, new byte[]{0, RegisterType.DOUBLE_LO, 7, 11, 10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, RegisterType.DOUBLE_HI}, new byte[]{13, 8, 10, 1, 3, RegisterType.DOUBLE_HI, 4, 2, 11, 6, 7, 12, 0, 5, RegisterType.DOUBLE_LO, 9}}, new byte[][]{new byte[]{10, 0, 9, RegisterType.DOUBLE_LO, 6, 3, RegisterType.DOUBLE_HI, 5, 1, 13, 12, 7, 11, 4, 2, 8}, new byte[]{13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, RegisterType.DOUBLE_LO, 12, 11, RegisterType.DOUBLE_HI, 1}, new byte[]{13, 6, 4, 9, 8, RegisterType.DOUBLE_HI, 3, 0, 11, 1, 2, 12, 5, 10, RegisterType.DOUBLE_LO, 7}, new byte[]{1, 10, 13, 0, 6, 9, 8, 7, 4, RegisterType.DOUBLE_HI, RegisterType.DOUBLE_LO, 3, 11, 5, 2, 12}}, new byte[][]{new byte[]{7, 13, RegisterType.DOUBLE_LO, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, RegisterType.DOUBLE_HI}, new byte[]{13, 8, 11, 5, 6, RegisterType.DOUBLE_HI, 0, 3, 4, 7, 2, 12, 1, 10, RegisterType.DOUBLE_LO, 9}, new byte[]{10, 6, 9, 0, 12, 11, 7, 13, RegisterType.DOUBLE_HI, 1, 3, RegisterType.DOUBLE_LO, 5, 2, 8, 4}, new byte[]{3, RegisterType.DOUBLE_HI, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, RegisterType.DOUBLE_LO}}, new byte[][]{new byte[]{2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, RegisterType.DOUBLE_HI, 13, 0, RegisterType.DOUBLE_LO, 9}, new byte[]{RegisterType.DOUBLE_LO, 11, 2, 12, 4, 7, 13, 1, 5, 0, RegisterType.DOUBLE_HI, 10, 3, 9, 8, 6}, new byte[]{4, 2, 1, 11, 10, 13, 7, 8, RegisterType.DOUBLE_HI, 9, 12, 5, 6, 3, 0, RegisterType.DOUBLE_LO}, new byte[]{11, 8, 12, 7, 1, RegisterType.DOUBLE_LO, 2, 13, 6, RegisterType.DOUBLE_HI, 0, 9, 10, 4, 5, 3}}, new byte[][]{new byte[]{12, 1, 10, RegisterType.DOUBLE_HI, 9, 2, 6, 8, 0, 13, 3, 4, RegisterType.DOUBLE_LO, 7, 5, 11}, new byte[]{10, RegisterType.DOUBLE_HI, 4, 2, 7, 12, 9, 5, 6, 1, 13, RegisterType.DOUBLE_LO, 0, 11, 3, 8}, new byte[]{9, RegisterType.DOUBLE_LO, RegisterType.DOUBLE_HI, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6}, new byte[]{4, 3, 2, 12, 9, 5, RegisterType.DOUBLE_HI, 10, 11, RegisterType.DOUBLE_LO, 1, 7, 6, 0, 8, 13}}, new byte[][]{new byte[]{4, 11, 2, RegisterType.DOUBLE_LO, RegisterType.DOUBLE_HI, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1}, new byte[]{13, 0, 11, 7, 4, 9, 1, 10, RegisterType.DOUBLE_LO, 3, 5, 12, 2, RegisterType.DOUBLE_HI, 8, 6}, new byte[]{1, 4, 11, 13, 12, 3, 7, RegisterType.DOUBLE_LO, 10, RegisterType.DOUBLE_HI, 6, 8, 0, 5, 9, 2}, new byte[]{6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, RegisterType.DOUBLE_HI, RegisterType.DOUBLE_LO, 2, 3, 12}}, new byte[][]{new byte[]{13, 2, 8, 4, 6, RegisterType.DOUBLE_HI, 11, 1, 10, 9, 3, RegisterType.DOUBLE_LO, 5, 0, 12, 7}, new byte[]{1, RegisterType.DOUBLE_HI, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11, 0, RegisterType.DOUBLE_LO, 9, 2}, new byte[]{7, 11, 4, 1, 9, 12, RegisterType.DOUBLE_LO, 2, 0, 6, 10, 13, RegisterType.DOUBLE_HI, 3, 5, 8}, new byte[]{2, 1, RegisterType.DOUBLE_LO, 7, 4, 10, 8, 13, RegisterType.DOUBLE_HI, 12, 9, 0, 3, 5, 6, 11}}};
        int i3 = eVar2.f145481b;
        int i16 = eVar.f145481b;
        while (b16 < 8) {
            byte[] bArr2 = eVar2.f145480a;
            int i17 = eVar2.f145481b;
            b(eVar, new e(bArr[b16][(byte) ((bArr2[i17 + 0] << 1) + bArr2[i17 + 5])][(byte) ((bArr2[i17 + 1] << 3) + (bArr2[i17 + 2] << 2) + (bArr2[i17 + 3] << 1) + bArr2[i17 + 4])]), 4);
            b16 = (byte) (b16 + 1);
            eVar2.f145481b += 6;
            eVar.f145481b += 4;
        }
        eVar2.f145481b = i3;
        eVar.f145481b = i16;
    }

    public static void a(e eVar, e eVar2, e eVar3, e eVar4) {
        byte[] bArr = {32, 1, 2, 3, 4, 5, 4, 5, 6, 7, 8, 9, 8, 9, 10, 11, 12, 13, 12, 13, RegisterType.DOUBLE_LO, RegisterType.DOUBLE_HI, RegisterType.UNINIT_REF, 17, RegisterType.UNINIT_REF, 17, RegisterType.REFERENCE, RegisterType.CONFLICTED, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, 23, 24, 25, 24, 25, 26, 27, 28, 29, 28, 29, 30, 31, 32, 1};
        byte[] bArr2 = {RegisterType.UNINIT_REF, 7, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, 29, 12, 28, 17, 1, RegisterType.DOUBLE_HI, 23, 26, 5, RegisterType.REFERENCE, 31, 10, 2, 8, 24, RegisterType.DOUBLE_LO, 32, 27, 3, 9, RegisterType.CONFLICTED, 13, 30, 6, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, 11, 4, 25};
        a(eVar3, eVar, bArr, 48, eVar4);
        c(eVar3, eVar2, 48);
        a(eVar, eVar3);
        a(eVar, eVar, bArr2, 32, eVar4);
    }

    public static void a(e eVar, e eVar2, e[] eVarArr, int i3, e eVar3, e eVar4, e eVar5, e eVar6, e eVar7, e eVar8) {
        byte[] bArr = {58, 50, 42, WadlProxyConsts.REQUEST_CODE_INSTALL_PERMISSION, 26, RegisterType.REFERENCE, 10, 2, 60, 52, 44, 36, 28, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, 12, 4, 62, 54, 46, 38, 30, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, RegisterType.DOUBLE_LO, 6, MaskType.MASK_TYPE_EXTERNAL, 56, 48, 40, 32, 24, RegisterType.UNINIT_REF, 8, 57, 49, 41, 33, 25, 17, 9, 1, 59, 51, 43, 35, 27, RegisterType.CONFLICTED, 11, 3, 61, 53, MultipartStream.DASH, 37, 29, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, 13, 5, 63, 55, 47, 39, 31, 23, RegisterType.DOUBLE_HI, 7};
        byte[] bArr2 = {40, 8, 48, RegisterType.UNINIT_REF, 56, 24, MaskType.MASK_TYPE_EXTERNAL, 32, 39, 7, 47, RegisterType.DOUBLE_HI, 55, 23, 63, 31, 38, 6, 46, RegisterType.DOUBLE_LO, 54, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, 62, 30, 37, 5, MultipartStream.DASH, 13, 53, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, 61, 29, 36, 4, 44, 12, 52, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, 60, 28, 35, 3, 43, 11, 51, RegisterType.CONFLICTED, 59, 27, WadlProxyConsts.REQUEST_CODE_INSTALL_PERMISSION, 2, 42, 10, 50, RegisterType.REFERENCE, 58, 26, 33, 1, 41, 9, 49, 17, 57, 25};
        b(eVar3, eVar2, 64);
        a(eVar3, eVar3, bArr, 64, eVar8);
        if (i3 == 0) {
            for (int i16 = 0; i16 < 16; i16++) {
                d(eVar5, eVar7, 32);
                a(eVar7, eVarArr[i16], eVar4, eVar8);
                c(eVar7, eVar6, 32);
                d(eVar6, eVar5, 32);
            }
        } else {
            for (int i17 = 15; i17 >= 0; i17--) {
                d(eVar5, eVar6, 32);
                a(eVar6, eVarArr[i17], eVar4, eVar8);
                c(eVar6, eVar7, 32);
                d(eVar7, eVar5, 32);
            }
        }
        a(eVar3, eVar3, bArr2, 64, eVar8);
        a(eVar, eVar3, 64);
    }

    public static char a(byte[] bArr, byte[] bArr2, long j3, int i3, byte[] bArr3, int i16) {
        int i17;
        int i18;
        e eVar = new e(bArr);
        e eVar2 = new e(bArr2);
        e[] eVarArr = new e[16];
        for (int i19 = 0; i19 < 16; i19++) {
            eVarArr[i19] = new e(new byte[48]);
        }
        e eVar3 = new e(new byte[256]);
        e eVar4 = new e(new byte[24]);
        e eVar5 = new e(new byte[64]);
        e eVar6 = new e();
        e eVar7 = new e();
        e eVar8 = new e();
        e eVar9 = new e();
        e eVar10 = new e(new byte[64]);
        e eVar11 = new e(new byte[48]);
        e eVar12 = new e(new byte[32]);
        e eVar13 = new e(new byte[9]);
        e eVar14 = new e(new byte[8]);
        if (bArr3 == null || bArr3.length <= 0) {
            return (char) 0;
        }
        long j16 = (j3 + 7) & (-8);
        long j17 = 0;
        if (j16 == 0) {
            return (char) 0;
        }
        a(eVar10, eVar5, eVar6, eVar7, eVar8, eVar9);
        a(eVarArr, eVar4, bArr3, i3, eVar5, eVar6, eVar7, eVar3);
        int i26 = eVar2.f145481b;
        int i27 = eVar.f145481b;
        if (i16 == 0) {
            i17 = i26;
            a(eVar, eVar13, eVarArr, i16, eVar10, eVar11, eVar12, eVar8, eVar9, eVar3);
            e eVar15 = eVar14;
            d(eVar15, eVar, 8);
            eVar.f145481b += 8;
            long j18 = j16 >> 3;
            while (j17 < j18) {
                a(eVar15, eVar15, eVar2);
                e[] eVarArr2 = eVarArr;
                e[] eVarArr3 = eVarArr;
                e eVar16 = eVar15;
                a(eVar, eVar15, eVarArr2, i16, eVar10, eVar11, eVar12, eVar8, eVar9, eVar3);
                d(eVar16, eVar, 8);
                j17++;
                eVar.f145481b += 8;
                eVar2.f145481b += 8;
                eVar15 = eVar16;
                eVarArr = eVarArr3;
            }
            i18 = i27;
        } else {
            i17 = i26;
            int i28 = i27;
            d(eVar13, eVar2, 8);
            eVar2.f145481b += 8;
            long j19 = j16 >> 3;
            long j26 = 1;
            while (j26 < j19) {
                a(eVar14, eVar2, eVarArr, i16, eVar10, eVar11, eVar12, eVar8, eVar9, eVar3);
                a(eVar, eVar14, eVar13);
                d(eVar13, eVar2, 8);
                j26++;
                eVar.f145481b += 8;
                eVar2.f145481b += 8;
                i28 = i28;
            }
            i18 = i28;
        }
        eVar2.f145481b = i17;
        eVar.f145481b = i18;
        return (char) 1;
    }

    public static void a(e eVar, int i3, int i16) {
        for (int i17 = 0; i17 < i16; i17++) {
            eVar.f145480a[eVar.f145481b + i17] = (byte) i3;
        }
    }
}
