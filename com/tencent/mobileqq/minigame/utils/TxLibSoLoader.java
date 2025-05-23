package com.tencent.mobileqq.minigame.utils;

import android.text.TextUtils;
import com.tencent.avcore.data.AVCoreSystemInfo;
import com.tencent.mobileqq.mini.utils.DebugUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class TxLibSoLoader {
    public static final String LOG_TAG = "TxLibSoLoader";

    public static boolean loadSo(String str) {
        String str2;
        try {
            if (AVCoreSystemInfo.getCpuArchitecture() > 2) {
                str2 = "/txlib/lib" + str + "-v7a.so";
            } else {
                str2 = "/txlib/lib" + str + "-armeabi.so";
            }
            String str3 = BaseApplication.getContext().getFilesDir().getParent() + str2;
            if (TextUtils.isEmpty(str3)) {
                QLog.i(LOG_TAG, 1, "[MiniEng]loadLibrary " + str3 + " failed, file not exists!");
                return false;
            }
            try {
                System.load(str3);
                QLog.i(LOG_TAG, 1, "[MiniEng]loadLibrary " + str3 + " success ");
                return true;
            } catch (Throwable th5) {
                QLog.w(LOG_TAG, 1, "[MiniEng]loadTxLibSo error " + str3 + DebugUtil.getPrintableStackTrace(th5));
                return false;
            }
        } catch (Exception e16) {
            QLog.w(LOG_TAG, 1, "[MiniEng]loadTxLibSo exception " + DebugUtil.getPrintableStackTrace(e16));
            return false;
        }
    }
}
