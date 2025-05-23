package cooperation.qwallet.plugin.impl;

import android.app.ActivityManager;
import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.component.media.image.ProgressTracer;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.statistics.o;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import cooperation.qwallet.plugin.IQWalletHelper;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QWalletHelperDelegate {
    private static final String TAG = "QWalletHelperDelegate";
    public static boolean graphbSpeedEnable = false;
    public static boolean mIsEnterPayBridge = false;
    public static int sEnterQWalletPluginCount;
    public static int sFullWindowActivitySource;
    public static int sFullWndCurID;
    public static int sFullWndCurType;
    public static long sReporteSeq;

    public static String desDecrypt(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && 16 == str2.length() && 16 == str3.length()) {
            try {
                byte[] decode = Base64.decode(str, 2);
                IvParameterSpec ivParameterSpec = new IvParameterSpec(str3.getBytes());
                SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), KeyPropertiesCompact.KEY_ALGORITHM_AES);
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                cipher.init(2, secretKeySpec, ivParameterSpec);
                return new String(cipher.doFinal(decode));
            } catch (Exception e16) {
                QLog.e(TAG, 1, "error msg in qqpay-api module: ", e16);
                return "";
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(IQWalletHelper.TAG_WALLET_REDPACK, 2, "AES decrypt key error = " + str2 + ProgressTracer.SEPARATOR + str3);
            return null;
        }
        return null;
    }

    public static String desEncrypt(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && 16 == str2.length() && 16 == str3.length()) {
            try {
                IvParameterSpec ivParameterSpec = new IvParameterSpec(str3.getBytes());
                SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), KeyPropertiesCompact.KEY_ALGORITHM_AES);
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                cipher.init(1, secretKeySpec, ivParameterSpec);
                return Base64.encodeToString(cipher.doFinal(str.getBytes()), 2);
            } catch (Exception e16) {
                QLog.e(TAG, 1, "error msg in qqpay-api module: ", e16);
                return "";
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(IQWalletHelper.TAG_WALLET_REDPACK, 2, "AES encrypt key error = " + str2 + ProgressTracer.SEPARATOR + str3);
            return null;
        }
        return null;
    }

    public static String getQWDevId() {
        return o.c();
    }

    public static String hexdigest(String str) {
        if (str == null) {
            return "";
        }
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET, 'B', 'C', 'D', 'E', 'F'};
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            char[] cArr2 = new char[32];
            int i3 = 0;
            for (int i16 = 0; i16 < 16; i16++) {
                byte b16 = digest[i16];
                int i17 = i3 + 1;
                cArr2[i3] = cArr[(b16 >>> 4) & 15];
                i3 = i17 + 1;
                cArr2[i17] = cArr[b16 & RegisterType.DOUBLE_HI];
            }
            return new String(cArr2);
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean isQWalletProcessExist(Context context) {
        ActivityManager activityManager;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        try {
            activityManager = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        } catch (Throwable th5) {
            if (QLog.isDevelopLevel()) {
                QLog.e(TAG, 1, "error msg in qqpay-api module: ", th5);
            }
        }
        if (activityManager == null || (runningAppProcesses = SystemMethodProxy.getRunningAppProcesses(activityManager)) == null) {
            return false;
        }
        Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
        while (it.hasNext()) {
            if ("com.tencent.mobileqq:tool".compareTo(it.next().processName) == 0) {
                return true;
            }
        }
        return false;
    }
}
