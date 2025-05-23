package com.tencent.open.agent.util;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import qqlogin.qrlogin.extinfo.QrLoginExtInfo$ScanExtInfo;

/* compiled from: P */
/* loaded from: classes22.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    private static final short[] f340617a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 63, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0075, code lost:
    
        if (r4 != 3) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] a(byte[] bArr, int i3) {
        int i16;
        byte[] bArr2 = new byte[24];
        int i17 = 0;
        short s16 = 0;
        int i18 = 0;
        int i19 = 0;
        while (true) {
            int i26 = i3 - 1;
            if (i3 <= 0) {
                break;
            }
            int i27 = i17 + 1;
            s16 = bArr[i17];
            if (s16 == 0 || s16 == 95) {
                break;
            }
            if (s16 == 32) {
                s16 = 42;
            }
            s16 = f340617a[s16];
            if (s16 >= 0) {
                int i28 = i18 % 4;
                if (i28 != 0) {
                    if (i28 != 1) {
                        if (i28 != 2) {
                            if (i28 == 3) {
                                i16 = i19 + 1;
                                bArr2[i19] = (byte) (bArr2[i19] | s16);
                            }
                        } else {
                            i16 = i19 + 1;
                            bArr2[i19] = (byte) (bArr2[i19] | (s16 >> 2));
                            bArr2[i16] = (byte) ((s16 & 3) << 6);
                        }
                    } else {
                        i16 = i19 + 1;
                        bArr2[i19] = (byte) (bArr2[i19] | (s16 >> 4));
                        bArr2[i16] = (byte) ((s16 & 15) << 4);
                    }
                    i19 = i16;
                } else {
                    bArr2[i19] = (byte) (s16 << 2);
                }
                i18++;
            }
            i17 = i27;
            i3 = i26;
        }
        if (s16 == 95) {
            int i29 = i18 % 4;
            if (i29 != 0 && i29 != 1) {
                if (i29 == 2) {
                    i19++;
                }
                bArr2[i19] = 0;
            } else {
                return null;
            }
        }
        return bArr2;
    }

    public static QrLoginExtInfo$ScanExtInfo b(AppRuntime appRuntime, int i3, boolean z16) {
        QrLoginExtInfo$ScanExtInfo qrLoginExtInfo$ScanExtInfo = new QrLoginExtInfo$ScanExtInfo();
        byte[] c16 = com.tencent.mobileqq.guid.c.f213821a.c();
        if (c16 != null && c16.length > 0) {
            qrLoginExtInfo$ScanExtInfo.guid.set(ByteStringMicro.copyFrom(c16));
        } else {
            QLog.e("QRLoginAuthUtil", 1, new Exception("buildQrLoginExtInfo but guid is empty."), new Object[0]);
        }
        qrLoginExtInfo$ScanExtInfo.imei.set(ByteStringMicro.copyFromUtf8(com.tencent.mobileqq.statistics.o.c()));
        qrLoginExtInfo$ScanExtInfo.scan_scene.set(i3);
        qrLoginExtInfo$ScanExtInfo.allow_auto_renew_ticket.set(z16);
        qrLoginExtInfo$ScanExtInfo.setHasFlag(true);
        return qrLoginExtInfo$ScanExtInfo;
    }

    public static QrLoginExtInfo$ScanExtInfo c(AppRuntime appRuntime, int i3, boolean z16) {
        QrLoginExtInfo$ScanExtInfo b16 = b(appRuntime, i3, false);
        b16.invalid_gen_ticket.set(z16);
        return b16;
    }

    public static byte[] d(long j3) {
        return new byte[]{(byte) (j3 >>> 56), (byte) (j3 >>> 48), (byte) (j3 >>> 40), (byte) (j3 >>> 32), (byte) (j3 >>> 24), (byte) (j3 >>> 16), (byte) (j3 >>> 8), (byte) j3};
    }
}
