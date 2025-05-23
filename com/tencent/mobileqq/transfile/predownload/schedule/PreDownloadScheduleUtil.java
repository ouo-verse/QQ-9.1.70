package com.tencent.mobileqq.transfile.predownload.schedule;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.utils.NetworkUtil;
import java.io.File;
import mqq.app.MobileQQ;

/* loaded from: classes19.dex */
public class PreDownloadScheduleUtil {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "PreDownloadScheduleUtil";

    PreDownloadScheduleUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static String getNetworkName(BaseQQAppInterface baseQQAppInterface) {
        return getNetworkName(baseQQAppInterface.getApp());
    }

    public static int getNetworkType(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                    int type = NetworkMonitor.getType(activeNetworkInfo);
                    if (QLog.isColorLevel()) {
                        QLog.d(NetworkUtil.TAG, 2, "getNetworkType type = ", Integer.valueOf(type));
                    }
                    return getNetworkTypeInner(activeNetworkInfo, type);
                }
                if (activeNetworkInfo == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d(NetworkUtil.TAG, 2, "getNetworkType networkInfo = null");
                    }
                } else if (QLog.isColorLevel()) {
                    QLog.d(NetworkUtil.TAG, 2, "getNetworkType networkInfo isConnected =", Boolean.valueOf(activeNetworkInfo.isConnected()));
                }
            } else if (QLog.isColorLevel()) {
                QLog.d(NetworkUtil.TAG, 2, "getNetworkType could not get ConnectivityManager");
            }
        } catch (IllegalStateException e16) {
            if (QLog.isColorLevel()) {
                QLog.d(NetworkUtil.TAG, 2, "getNetworkType IllegalStateException", e16);
            }
        } catch (Exception e17) {
            if (QLog.isColorLevel()) {
                QLog.d(NetworkUtil.TAG, 2, "getNetworkType exception", e17);
            }
        }
        return 0;
    }

    private static int getNetworkTypeInner(NetworkInfo networkInfo, int i3) {
        if (i3 != 0) {
            if (i3 == 1) {
                return 1;
            }
            return -1;
        }
        return getSubType(NetworkMonitor.getSubtype(networkInfo));
    }

    public static String getPreDownloadPathStatic(@NonNull String str, String str2, boolean z16) {
        String sDKPrivatePath;
        if (TextUtils.isEmpty(str2)) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 1, "department should not be empty");
                return null;
            }
            return null;
        }
        if (z16) {
            try {
                sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(Environment.getExternalStorageDirectory().getAbsolutePath() + PreDownloadConstants.SDCRAD_DIR);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 1, "Exception:", e16);
                }
                sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath("/sdcard/tencent/MobileQQ/pddata/");
            }
        } else {
            sDKPrivatePath = MobileQQ.sMobileQQ.getFilesDir() + PreDownloadConstants.INNER_DIR;
        }
        File file = new File(sDKPrivatePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str3 = sDKPrivatePath + str2 + "/" + str;
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 1, "[getPreDownloadPath] path = " + str3);
        }
        return str3;
    }

    private static int getSubType(int i3) {
        switch (i3) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return 2;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return 3;
            case 13:
            case 18:
            case 19:
                return 4;
            default:
                if (QLog.isColorLevel()) {
                    QLog.d(NetworkUtil.TAG, 2, "getNetworkType subType = ", Integer.valueOf(i3));
                    return -1;
                }
                return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getNetworkName(Context context) {
        int networkType = getNetworkType(context);
        return networkType != 0 ? networkType != 1 ? networkType != 2 ? networkType != 3 ? networkType != 4 ? networkType != 5 ? "unknown" : "5G" : "4G" : "3G" : "2G" : "Wi-Fi" : "none";
    }
}
