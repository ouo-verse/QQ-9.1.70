package com.tencent.mobileqq.utils;

import android.util.SparseIntArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import tencent.im.cs.ptt_waveform.ptt_waveform$PttWaveform;

/* compiled from: P */
/* loaded from: classes20.dex */
public class cm {

    /* renamed from: a, reason: collision with root package name */
    private static final SparseIntArray f307534a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(8);
        f307534a = sparseIntArray;
        sparseIntArray.put(4, 13);
        sparseIntArray.put(12, 14);
        sparseIntArray.put(20, 16);
        sparseIntArray.put(28, 18);
        sparseIntArray.put(36, 20);
        sparseIntArray.put(44, 21);
        sparseIntArray.put(52, 27);
        sparseIntArray.put(60, 32);
    }

    public static int[] a(ptt_waveform$PttWaveform ptt_waveform_pttwaveform) {
        if (ptt_waveform_pttwaveform == null || !ptt_waveform_pttwaveform.uin32_size.has() || ptt_waveform_pttwaveform.uin32_size.get() <= 0 || !ptt_waveform_pttwaveform.bytes_amplitudes.has()) {
            return null;
        }
        int i3 = ptt_waveform_pttwaveform.uin32_size.get();
        int[] iArr = new int[i3];
        byte[] byteArray = ptt_waveform_pttwaveform.bytes_amplitudes.get().toByteArray();
        if (byteArray.length != i3) {
            QLog.e("PttUtils", 2, "changePtToWaveform, data error");
            return null;
        }
        for (int i16 = 0; i16 < i3; i16++) {
            iArr[i16] = byteArray[i16] & 255;
        }
        return iArr;
    }

    public static void b(QQAppInterface qQAppInterface, int i3) {
        int i16 = 8;
        if (i3 != 8) {
            i16 = 1;
            if (i3 != 1) {
                if (i3 == 2) {
                    i16 = 2;
                } else {
                    i16 = 3;
                }
            }
        }
        ReportController.o(qQAppInterface, "CliOper", "", "", "0X8004603", "0X8004603", 0, 0, i16 + "", "", "", "");
        if (QLog.isColorLevel()) {
            QLog.d("QQRecorder", 2, "report cancle send ptt, cancel source = " + i3);
        }
    }

    public static void c(QQAppInterface qQAppInterface, int i3, int i16, int i17) {
        int i18;
        int i19 = 1;
        if (i3 == 0) {
            i18 = 1;
        } else if (i3 == 3000) {
            i18 = 2;
        } else if (i3 == 1) {
            i18 = 3;
        } else {
            i18 = 4;
        }
        if (i16 == 8) {
            ReportController.o(qQAppInterface, "CliOper", "", "", "0X8006189", "0X8006189", 0, 0, "", i18 + "", i17 + "", "");
        } else if (i16 != 1 && i16 != 2) {
            if (i16 == 4) {
                ReportController.o(qQAppInterface, "CliOper", "", "", "0X8005C1E", "0X8005C1E", 0, 0, "", i18 + "", i17 + "", "");
            } else {
                ReportController.o(qQAppInterface, "CliOper", "", "", "0X8004601", "0X8004601", 0, 0, "", i18 + "", i17 + "", "");
            }
        } else {
            StringBuilder sb5 = new StringBuilder();
            if (i16 != 1) {
                i19 = 2;
            }
            sb5.append(i19);
            sb5.append("");
            ReportController.o(qQAppInterface, "CliOper", "", "", "0X8004600", "0X8004600", 0, 0, sb5.toString(), i18 + "", i17 + "", "");
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQRecorder", 2, "report send ptt, send source = " + i16 + ", sessionType = " + i18 + ", seconds = " + i17);
        }
    }

    private static final boolean d(ByteArrayInputStream byteArrayInputStream, int[] iArr) throws IOException {
        int i3;
        byteArrayInputStream.read("#!AMR\n".getBytes());
        int read = byteArrayInputStream.read();
        int i16 = 0;
        while (i16 < iArr.length && read != iArr[i16]) {
            i16++;
        }
        if (i16 == iArr.length || (i3 = f307534a.get(read, -1)) == -1) {
            return false;
        }
        byte[] bArr = new byte[i3 - 1];
        byteArrayInputStream.read(bArr);
        while (true) {
            int read2 = byteArrayInputStream.read();
            if (read2 == -1) {
                return true;
            }
            if (read2 != read) {
                return false;
            }
            byteArrayInputStream.read(bArr);
        }
    }

    public static final boolean e(String str, int[] iArr) {
        ByteArrayInputStream byteArrayInputStream;
        Throwable th5;
        File file = new File(str);
        if (!file.exists() || file.length() == 0) {
            return false;
        }
        try {
            byteArrayInputStream = new ByteArrayInputStream(FileUtils.fileToBytes(file));
        } catch (Throwable th6) {
            byteArrayInputStream = null;
            th5 = th6;
        }
        try {
            boolean d16 = d(byteArrayInputStream, iArr);
            try {
                byteArrayInputStream.close();
            } catch (Exception unused) {
            }
            return d16;
        } catch (Throwable th7) {
            th5 = th7;
            try {
                if (QLog.isColorLevel()) {
                    QLog.d("PttUtils", 2, "verify amr", th5);
                }
                if (byteArrayInputStream != null) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Exception unused2) {
                    }
                }
                return false;
            } catch (Throwable th8) {
                if (byteArrayInputStream != null) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Exception unused3) {
                    }
                }
                throw th8;
            }
        }
    }
}
