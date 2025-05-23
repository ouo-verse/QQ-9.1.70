package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.filemanager.api.IExcitingTransferAdapter;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.util.cu;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.UnsupportedEncodingException;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ExcitingTransferNativeCallMe {
    public static boolean getConfigFromServer() {
        return ((IExcitingTransferAdapter) ah.W().getRuntimeService(IExcitingTransferAdapter.class, "")).getConfigFromServer();
    }

    public static long getFreeSpaceForFile(String str) {
        long c16;
        if (cu.e()) {
            c16 = cu.b();
        } else {
            c16 = cu.c();
        }
        return c16 * 1024;
    }

    public static long getLastModifyTime(String str) {
        return new File(str).lastModified();
    }

    public static short getProxyType() {
        return (short) 0;
    }

    public static long getPubNo() {
        return AppSetting.f();
    }

    public static long getRegulatedMilliTime() {
        return NetConnInfoCenter.getServerTimeMillis();
    }

    public static long getSelfUin() {
        return ((IExcitingTransferAdapter) ah.W().getRuntimeService(IExcitingTransferAdapter.class, "")).getSelfUin();
    }

    public static String getVersion() {
        return AppSetting.l();
    }

    public static void onLog(int i3, byte[] bArr, byte[] bArr2) {
        try {
            String str = new String(bArr, "UTF-8");
            String str2 = new String(bArr2, "UTF-8");
            if (TextUtils.isEmpty(str)) {
                str = "unTag";
            }
            if (i3 != 0 && i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (QLog.isColorLevel()) {
                                QLog.d(str, 2, str2);
                                return;
                            }
                            return;
                        } else {
                            if (QLog.isColorLevel()) {
                                QLog.d(str, 2, str2);
                                return;
                            }
                            return;
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i(str, 2, str2);
                        return;
                    }
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.w(str, 2, str2);
                    return;
                }
                return;
            }
            QLog.i(str, 1, str2);
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
            if (QLog.isDevelopLevel()) {
                QLog.e("ExcitingT.", 4, "native log encoding utf8 failed");
            }
        }
    }
}
