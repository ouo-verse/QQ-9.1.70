package com.tencent.util;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.commonsdk.util.notification.NotificationUtil;
import com.tencent.luggage.wxa.gf.j0;
import com.tencent.luggage.wxa.yf.x;
import com.tencent.mobileqq.activity.SubAccountBindActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.reminder.util.QQConstants;
import com.tencent.mobileqq.startup.step.InitSkin;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.vas.qid.QidPagView;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.dex.sdkupdate.TVKUpdateInfo;
import com.tencent.thumbplayer.core.codec.decoder.ITPMediaCodecDecoder;
import cooperation.qzone.report.lp.LpReportInfoConfig;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TelephonyUtils {
    static IPatchRedirector $redirector_;
    static final String[] sCommonPrefix;
    static final int[] sCountryCodes;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42420);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            sCountryCodes = new int[]{86, 852, 853, BusinessInfoCheckUpdateItem.UIAPPID_LEBA_NEARBY_TROOPS, 1, 7, 20, 27, 30, 32, 33, 34, 36, 39, 40, 41, 43, 44, 45, 46, 47, 48, 49, 51, 52, 53, 54, 55, 56, 57, 58, 60, 61, 62, 63, 65, 66, 81, 82, 84, 90, 91, 92, 93, 94, 95, 98, 213, 216, 218, 220, 221, 223, 224, 225, 226, 227, 228, 229, 230, 231, 232, 233, 234, 235, 236, 237, 239, 241, 242, 243, 244, 247, 248, 249, 251, 252, 253, 254, 255, 256, 257, 258, 260, 261, 262, 263, 265, 266, 267, 268, 297, ITPMediaCodecDecoder.BYTES_SET_MEDIA_DRM_SESSION_ID, 351, com.tencent.luggage.wxa.rf.g.CTRL_INDEX, com.tencent.luggage.wxa.rf.h.CTRL_INDEX, com.tencent.luggage.wxa.rf.f.CTRL_INDEX, 356, 357, com.tencent.luggage.wxa.rf.d.CTRL_INDEX, 359, 370, 371, com.tencent.luggage.wxa.se.b.CTRL_INDEX, com.tencent.luggage.wxa.se.c.CTRL_INDEX, 374, QidPagView.DESIGN_PAG_WIDTH, 376, NotificationUtil.Constants.NOTIFY_ID_UNIFORM_DOWNLOAD_END, NotificationUtil.Constants.NOTIFY_ID_APPCENTER_BEGIN, LpReportInfoConfig.ACTION_HOMEPAGE_NOT_RIGHT, 386, 420, 421, 423, 501, 502, 503, 504, 506, 507, 509, 591, com.tencent.luggage.wxa.v6.d.CTRL_INDEX, LpReportInfoConfig.ACTION_TYPE_COMMON_SETTING, 594, 596, 597, 598, 673, 674, 675, 676, 677, 679, 682, 685, 689, 855, 856, x.CTRL_INDEX, 960, 961, 962, 963, 964, 965, 966, 967, 971, 972, 973, QQConstants.REMINDER_POS_ID, 975, 992, j0.CTRL_INDEX, 994, 995, 996, 998, SubAccountBindActivity.ERROR_ACCOUNT_LOCK, 1246, InitSkin.COLOR_COUNT, 1268, 1345, 1441, 1473, 1671, 1684, 1758, 1784, 1787, 1868, 1876, 1890};
            sCommonPrefix = new String[]{TVKUpdateInfo.APP_ID, "00", "+00", Marker.ANY_NON_NULL_MARKER};
        }
    }

    public TelephonyUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String formatPhoneNumber(String str) {
        if (str != null && str.length() != 0) {
            StringBuffer stringBuffer = new StringBuffer(str.length());
            for (int i3 = 0; i3 < str.length(); i3++) {
                char charAt = str.charAt(i3);
                if (charAt != ' ' && charAt != '-' && charAt != ')' && charAt != '(' && charAt != '_') {
                    stringBuffer.append(charAt);
                }
            }
            return stringBuffer.toString();
        }
        return str;
    }

    public static String[] getCodeNumber(Context context) {
        String str;
        try {
            str = DeviceInfoMonitor.getLine1Number((TelephonyManager) context.getSystemService("phone"));
        } catch (Exception e16) {
            e16.printStackTrace();
            str = "";
        }
        if (QLog.isColorLevel()) {
            QLog.d("PhoneCodeUtil", 2, "line1Number=" + str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (String str2 : sCommonPrefix) {
            for (int i3 : sCountryCodes) {
                if (str.startsWith(str2 + i3)) {
                    return new String[]{"" + i3, str.replace(str2 + i3, "")};
                }
            }
        }
        return null;
    }
}
