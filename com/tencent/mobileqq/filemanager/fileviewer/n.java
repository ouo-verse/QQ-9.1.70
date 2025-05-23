package com.tencent.mobileqq.filemanager.fileviewer;

import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class n {
    /* JADX WARN: Removed duplicated region for block: B:13:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a(int i3) {
        int i16;
        if (i3 != 2) {
            i16 = 4;
            if (i3 != 4) {
                if (i3 != 13) {
                    switch (i3) {
                        case 6:
                            break;
                        case 7:
                        case 8:
                        case 9:
                            i16 = 6;
                            break;
                        case 10:
                            i16 = 5;
                            break;
                        case 11:
                            break;
                        default:
                            i16 = 9;
                            break;
                    }
                }
            } else {
                i16 = 8;
            }
            if (QLog.isColorLevel()) {
                QLog.i("QFileBrowserUtils", 1, "getVideoQRReportFromType: reportFromType[" + i16 + "]");
            }
            return i16;
        }
        i16 = 7;
        if (QLog.isColorLevel()) {
        }
        return i16;
    }

    public static void b(long j3) {
        int i3;
        if (j3 < 51200) {
            i3 = 1;
        } else if (j3 < FaceConstant.HeadDownload.QQHEAD_SYSTEM_MIN_STORAGE_SIZE) {
            i3 = 2;
        } else if (j3 < 512000) {
            i3 = 3;
        } else if (j3 < 1024000) {
            i3 = 4;
        } else if (j3 < 3072000) {
            i3 = 5;
        } else if (j3 < 10240000) {
            i3 = 6;
        } else {
            i3 = 7;
        }
        ReportController.o(null, "dc00898", "", "", "0X800ADC0", "0X800ADC0", i3, 0, "", "", "", "");
    }
}
