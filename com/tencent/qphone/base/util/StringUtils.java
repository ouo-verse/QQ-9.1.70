package com.tencent.qphone.base.util;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.commonsdk.soload.SoLoadCore;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import com.tencent.rfix.loader.utils.RFixConstants;
import java.io.File;

/* compiled from: P */
/* loaded from: classes22.dex */
public class StringUtils {
    public static final String MSF_LIB_BOOTV2 = "msfbootV2";
    public static final String MSF_LIB_CODEC_V2 = "codecwrapperV2";
    public static final String MSF_LIB_QUIC = "quic";
    private static final String TAG_LOAD_MSF = "LoadMSFSo";

    public static String getIpAddrFromInt(int i3) {
        StringBuffer stringBuffer = new StringBuffer("");
        stringBuffer.append(String.valueOf(i3 >>> 24));
        stringBuffer.append(".");
        stringBuffer.append(String.valueOf((16777215 & i3) >>> 16));
        stringBuffer.append(".");
        stringBuffer.append(String.valueOf((65535 & i3) >>> 8));
        stringBuffer.append(".");
        stringBuffer.append(String.valueOf(i3 & 255));
        return stringBuffer.toString();
    }

    public static boolean getLoadResult(int i3) {
        if ((i3 & 2) == 2 || (i3 & 262144) == 262144) {
            return true;
        }
        return false;
    }

    public static String getPlatformString() {
        String str = Build.CPU_ABI;
        if (str != null && str.contains(ResourceAttributes.HostArchValues.X86)) {
            return ResourceAttributes.HostArchValues.X86;
        }
        if (str != null && str.contains("mip")) {
            return "mips";
        }
        return "armeabi";
    }

    public static String getTxLib(Context context) {
        return context.getFilesDir().getParent() + SoLoadCore.PATH_TX_LIB;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0086 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean loadLibrary(String str, String str2, Context context) {
        boolean z16;
        if (context == null) {
            return false;
        }
        File file = new File(getTxLib(context) + RFixConstants.SO_PATH + str2 + ".so");
        if (!file.exists()) {
            file = new File(context.getFilesDir().getParent() + "/lib/lib" + str2 + ".so");
        }
        if (file.exists()) {
            try {
                System.load(file.getAbsolutePath());
                z16 = true;
            } catch (UnsatisfiedLinkError unused) {
                if (QLog.isColorLevel()) {
                    QLog.d(str, 2, "cannot load library " + file.getAbsolutePath());
                }
            }
            if (!z16) {
                return z16;
            }
            try {
                System.loadLibrary(str2);
                return true;
            } catch (UnsatisfiedLinkError unused2) {
                if (QLog.isColorLevel()) {
                    QLog.d(str, 2, "cannot load library " + str2);
                }
                return false;
            }
        }
        z16 = false;
        if (!z16) {
        }
    }

    public static synchronized int msfLoadSo(String str, String str2) {
        boolean z16;
        synchronized (StringUtils.class) {
            try {
                System.loadLibrary(str2);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG_LOAD_MSF, 2, "System.loadLibrary, libname = " + str2 + " suc");
                }
            } catch (Throwable th5) {
                QLog.e(TAG_LOAD_MSF, 1, th5, new Object[0]);
                if ("armeabi".equalsIgnoreCase(getPlatformString())) {
                    String str3 = BaseApplication.processName;
                    if (str3 == null || str3.endsWith(":MSF")) {
                        SoLoadUtilNew.setReport(null);
                    }
                    int loadSo = SoLoadCore.loadSo(BaseApplication.getContext(), str2);
                    QLog.e(str, 1, "loadso arm " + str2 + " resultCode=" + loadSo);
                    return loadSo;
                }
                try {
                    z16 = loadLibrary(str, str2, BaseApplication.getContext());
                } catch (Throwable th6) {
                    th6.printStackTrace();
                    z16 = false;
                }
                QLog.d(str, 1, "loadso x86 " + str2 + " " + z16);
                return 0;
            }
        }
        return 262144;
    }

    public static boolean loadLibrary(String str, Context context, String str2, String str3) {
        boolean z16;
        if (context == null) {
            return false;
        }
        File file = new File(str2);
        if (file.exists()) {
            try {
                System.load(file.getAbsolutePath());
                z16 = true;
            } catch (Throwable th5) {
                QLog.e(str, 1, "cannot load library " + file.getAbsolutePath(), th5);
            }
            if (!z16 || TextUtils.isEmpty(str3)) {
                return z16;
            }
            try {
                System.loadLibrary(str3);
                return true;
            } catch (Throwable th6) {
                QLog.e(str, 1, "cannot load system library " + str3, th6);
                return false;
            }
        }
        z16 = false;
        if (z16) {
        }
        return z16;
    }
}
