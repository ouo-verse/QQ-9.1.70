package cooperation.qzone;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqsharpP.a;
import common.config.service.QzoneConfig;

/* loaded from: classes38.dex */
public class SharpPDec {
    private static String LIB_NAME = "TcHevcDec";
    private static final int NOT_INIT = -1;
    private static final int REQUIRED_VERSION = 12;
    private static final String TAG = "SharpPDec";
    private static long sLastLoadTime = 0;
    private static int sRetryWaitTime = -1;
    private static int sVersion = -1;

    static {
        try {
            SoLoadUtilNew.loadSoByName(BaseApplicationImpl.getApplication(), "c++_shared");
        } catch (Throwable th5) {
            QLog.w(TAG, 1, "loadSoByName, load libc++_shared.so failed:", th5);
        }
    }

    SharpPDec() {
    }

    private native int GetVersion();

    public static synchronized int getVersion() {
        boolean loadLibrary;
        synchronized (SharpPDec.class) {
            if (sVersion < 12 && System.currentTimeMillis() - sLastLoadTime >= sRetryWaitTime) {
                try {
                    sVersion = 0;
                    loadLibrary = loadLibrary();
                    LocalMultiProcConfig.putBool(LocalMultiProcConfig.QZONE_SUPPORT_SHARPP, loadLibrary);
                } catch (UnsatisfiedLinkError e16) {
                    QLog.e(TAG, 1, e16, new Object[0]);
                }
                if (!loadLibrary) {
                    sLastLoadTime = System.currentTimeMillis();
                    if (sRetryWaitTime == -1) {
                        sRetryWaitTime = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_SHARPP_LOAD_SO_RETRY_WAIT_TIME, 3000);
                        QLog.i(TAG, 1, "sRetryWaitTime(ms):" + sRetryWaitTime);
                    }
                    return sVersion;
                }
                sVersion = new SharpPDec().GetVersion();
                QLog.i(TAG, 1, "cooperation.SharpPDec------version:" + sVersion);
                return sVersion;
            }
            return sVersion;
        }
    }

    public static synchronized int isSupportSharpP(Context context) {
        int i3;
        synchronized (SharpPDec.class) {
            i3 = getVersion() >= 12 ? 1 : 0;
        }
        return i3;
    }

    public static boolean loadLibrary() {
        boolean z16;
        try {
            z16 = a.e();
            try {
                QLog.i(TAG, 4, "cooperation.SharpPDec--load from qq original: load success ? " + z16);
            } catch (UnsatisfiedLinkError e16) {
                e = e16;
                QLog.e(TAG, 2, "load library exception:", e);
                return z16;
            }
        } catch (UnsatisfiedLinkError e17) {
            e = e17;
            z16 = false;
        }
        return z16;
    }
}
