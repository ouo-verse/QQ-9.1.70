package com.tencent.mobileqq.transfile.chatpic;

import android.content.SharedPreferences;
import com.tencent.mobileqq.haoliyou.orion.ZhuoXusManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes19.dex */
public class PicUploadExifInfoSwitch {
    static IPatchRedirector $redirector_ = null;
    public static int EXIF_Info_Switch = 0;
    public static final String SP_KEY_EXIF_INFO_SWITCH = "SP_KEY_EXIF_Info_Switch";
    public static final String SP_KEY_EXIF_INFO_SWITCH_VALUE = "SP_KEY_EXIF_Info_Switch_VALUE";
    public static final String TAG = "PicUploadExifInfoSwitch";

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42660);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            EXIF_Info_Switch = -1;
        }
    }

    public PicUploadExifInfoSwitch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean getSwitch() {
        if (ZhuoXusManager.instance().isSendPicExifOpen()) {
            return true;
        }
        if (EXIF_Info_Switch < 0) {
            EXIF_Info_Switch = BaseApplication.getContext().getSharedPreferences(SP_KEY_EXIF_INFO_SWITCH, 4).getInt(SP_KEY_EXIF_INFO_SWITCH_VALUE, 0);
        }
        if (EXIF_Info_Switch == 1) {
            return true;
        }
        return false;
    }

    public static void setSwitch(int i3) {
        SharedPreferences.Editor edit = BaseApplication.getContext().getSharedPreferences(SP_KEY_EXIF_INFO_SWITCH, 4).edit();
        edit.putInt(SP_KEY_EXIF_INFO_SWITCH_VALUE, i3);
        edit.commit();
        EXIF_Info_Switch = i3;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "setSwitch:" + i3);
        }
    }
}
