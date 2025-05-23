package com.tencent.mobileqq.transfile.chatpic;

import android.content.SharedPreferences;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* loaded from: classes19.dex */
public class PicUploadFileSizeLimit {
    static IPatchRedirector $redirector_ = null;
    public static long C2C_FileSize_Limit = 0;
    public static long GROUP_FileSize_Limit = 0;
    public static final String SP_KEY_C2C_PIC_SIZE_LIMIT = "SP_KEY_C2C_PIC_SIZE_LIMIT";
    public static final String SP_KEY_GROUP_PIC_SIZE_LIMIT = "SP_KEY_GROUP_PIC_SIZE_LIMIT";
    public static final String SP_KEY_PIC_SIZE_LIMIT = "SP_KEY_PIC_SIZE_LIMIT";
    public static final String TAG = "PicUploadFileSizeLimit";

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56561);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            C2C_FileSize_Limit = -1L;
            GROUP_FileSize_Limit = -1L;
        }
    }

    public PicUploadFileSizeLimit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static long getLimit(String str, long j3) {
        SharedPreferences sharedPreferences = MobileQQ.sMobileQQ.getSharedPreferences(SP_KEY_PIC_SIZE_LIMIT, 4);
        long j16 = -1;
        if (sharedPreferences != null) {
            j16 = sharedPreferences.getLong(str, -1L);
        }
        if (j16 >= 0) {
            return j16;
        }
        return j3;
    }

    public static long getLimitC2C() {
        if (C2C_FileSize_Limit < 0) {
            C2C_FileSize_Limit = getLimit(SP_KEY_C2C_PIC_SIZE_LIMIT, 16777216L);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getLimitC2C:" + C2C_FileSize_Limit);
            }
        }
        return C2C_FileSize_Limit;
    }

    public static long getLimitGroup() {
        if (GROUP_FileSize_Limit < 0) {
            GROUP_FileSize_Limit = getLimit(SP_KEY_GROUP_PIC_SIZE_LIMIT, 16777216L);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getLimitGroup:" + GROUP_FileSize_Limit);
            }
        }
        return GROUP_FileSize_Limit;
    }

    private static void setLimit(String str, long j3) {
        SharedPreferences.Editor edit = MobileQQ.sMobileQQ.getSharedPreferences(SP_KEY_PIC_SIZE_LIMIT, 4).edit();
        edit.putLong(str, j3);
        edit.commit();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "setLimit:" + str + " size:" + j3);
        }
    }

    public static void setLimitC2C(long j3) {
        setLimit(SP_KEY_C2C_PIC_SIZE_LIMIT, j3);
        if (j3 > 0) {
            C2C_FileSize_Limit = j3;
        }
    }

    public static void setLimitGroup(long j3) {
        setLimit(SP_KEY_GROUP_PIC_SIZE_LIMIT, j3);
        if (j3 > 0) {
            GROUP_FileSize_Limit = j3;
        }
    }
}
