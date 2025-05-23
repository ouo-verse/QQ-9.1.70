package com.tenpay.sdk.util;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.QwLog;
import com.tenpay.proxy.DataProxy;
import com.tenpay.sdk.Cgi;
import com.tenpay.util.MD5;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TenpayUtil {
    public static final String BU_KEY = "Tenpay_mqq";
    public static final String FOLDER_COMMOM = "/common/";
    public static final String FOLDER_PRELOAD = "/preload/";
    public static final String FOLDER_PRIDATA = "/pridata/";
    public static final int OPER_TYPE_CLOSE_FINGER_PAY = 136;
    public static final int OPER_TYPE_CTPAY_ERRGUIDE_OPEN = 401;
    public static final int OPER_TYPE_CTPAY_NORNAL_OPEN = 400;
    public static final int OPER_TYPE_CTPAY_PAY = 403;
    public static final int OPER_TYPE_DEDUCTION = 170;
    public static final int OPER_TYPE_DEPOSIT_CHANGE_PHONE = 17;
    public static final int OPER_TYPE_DRAW_HB = 501;
    public static final int OPER_TYPE_FINDPASS_BY_IDVERIFY = 158;
    public static final int OPER_TYPE_FINDPASS_BY_IDVERIFY_FORGETPASS = 159;
    public static final int OPER_TYPE_FINGER_DEPOSIT = 139;
    public static final int OPER_TYPE_FINGER_DEPOSIT_NO_BANK = 140;
    public static final int OPER_TYPE_FINGER_PAY_WITHOUT_PAY_METHOD = 138;
    public static final int OPER_TYPE_FINGER_PAY_WITH_PAY_METHOD = 137;
    public static final int OPER_TYPE_FORGET_BIND_PAY = 8;
    public static final int OPER_TYPE_FORGET_BIND_PAY_RESET = 7;
    public static final int OPER_TYPE_FORGET_BIND_RESET_PAY = 13;
    public static final int OPER_TYPE_FORGET_BIND_RESET_WITHDRAW = 125;
    public static final int OPER_TYPE_FORGET_FAST_PAY = 10;
    public static final int OPER_TYPE_FORGET_NOBIND_PAY = 9;
    public static final int OPER_TYPE_FORGET_UNBIND_RESET_PAY = 14;
    public static final int OPER_TYPE_FORGET_UNBIND_RESET_WITHDRAW = 126;
    public static final int OPER_TYPE_GRAB_VOICE_HB = 162;
    public static final int OPER_TYPE_GRAB_WORD_HB = 152;
    public static final int OPER_TYPE_HB = 129;
    public static final int OPER_TYPE_HB_HOTCHAT = 147;
    public static final int OPER_TYPE_HB_NEARBY = 148;
    public static final int OPER_TYPE_HB_NEWUSER = 130;
    public static final int OPER_TYPE_IDIOM_HB = 500;
    public static final int OPER_TYPE_ID_THEME_FEEDBACK = 157;
    public static final int OPER_TYPE_ID_VERIFY = 154;
    public static final int OPER_TYPE_ID_WISH_ASSISTANT = 156;
    public static final int OPER_TYPE_OPEN_FINGER_PAY = 135;
    public static final int OPER_TYPE_OPEN_FINGER_PAY_NEED_BIND_BANK = 133;
    public static final int OPER_TYPE_OPEN_FINGER_PAY_NEED_REGISTER = 134;
    public static final int OPER_TYPE_PAY_BALANCE_CERT = 0;
    public static final int OPER_TYPE_PAY_BALANCE_NOT_CERT = 1;
    public static final int OPER_TYPE_PAY_CHANGE_DATE = 15;
    public static final int OPER_TYPE_PAY_CHANGE_PHONE = 16;
    public static final int OPER_TYPE_PAY_FAST_BINDED_HAS_VERIFY = 3;
    public static final int OPER_TYPE_PAY_FAST_BINDED_NO_VERIFY = 2;
    public static final int OPER_TYPE_PAY_FAST_UNBINDED_HAS_VERIFY = 6;
    public static final int OPER_TYPE_PAY_FAST_UNBINDED_NO_VERIFY = 5;
    public static final int OPER_TYPE_PAY_FAST_UNBINDED_REGISTER = 4;
    public static final int OPER_TYPE_PAY_THIRD_APP = 11;
    public static final int OPER_TYPE_REWARD_TRANSFER = 180;
    public static final int OPER_TYPE_SPECIFY_HB = 212;
    public static final int OPER_TYPE_SWIPE_HB = 151;
    public static final int OPER_TYPE_THEME_HB = 149;
    public static final int OPER_TYPE_WALLET_BALANCE = 108;
    public static final int OPER_TYPE_WALLET_BANKCARD = 109;
    public static final int OPER_TYPE_WALLET_BANKCARD_ACTIONSHEET = 110;
    public static final int OPER_TYPE_WALLET_DELETE_FAST = 103;
    public static final int OPER_TYPE_WALLET_DELETE_YDT = 104;
    public static final int OPER_TYPE_WALLET_DEPOSIT_BIND_HAS_VERIFY = 122;
    public static final int OPER_TYPE_WALLET_DEPOSIT_BIND_NO_VERIFY = 121;
    public static final int OPER_TYPE_WALLET_DEPOSIT_BIND_REGISTER = 120;
    public static final int OPER_TYPE_WALLET_DEPOSIT_FORGET_BIND = 123;
    public static final int OPER_TYPE_WALLET_DEPOSIT_FORGET_UNBIND = 124;
    public static final int OPER_TYPE_WALLET_DEPOSIT_HAS_BANK_HAS_VERIFY = 119;
    public static final int OPER_TYPE_WALLET_DEPOSIT_HAS_BANK_NO_VERIFY = 118;
    public static final int OPER_TYPE_WALLET_MODIFY_PASSWD = 105;
    public static final int OPER_TYPE_WALLET_MODIFY_PASSWD_BIND_PHONE = 106;
    public static final int OPER_TYPE_WALLET_ONLY_BIND_HAS_PASSWD = 101;
    public static final int OPER_TYPE_WALLET_ONLY_BIND_NO_PASSWD = 100;
    public static final int OPER_TYPE_WALLET_PASSWD_MANAGER = 111;
    public static final int OPER_TYPE_WALLET_PASS_VERIFY = 115;
    public static final int OPER_TYPE_WALLET_REGISTER_ONLY_BIND = 102;
    public static final int OPER_TYPE_WALLET_RESET_PASSWD = 107;
    public static final int OPER_TYPE_WALLET_WITHDRAW_HAS_BANK = 112;
    public static final int OPER_TYPE_WALLET_WITHDRAW_NO_BANK = 113;
    private static final String TAG = "TenpayUtil";
    public static final String TAIL = "|0|1|0|android||||";
    public static List<String> mUploadData = new ArrayList();
    private static long mBeginTime = -1;

    public static void addMidasUploadData(int i3, String str) {
        mUploadData.add(str + "-" + i3);
    }

    public static String genCodeUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            int indexOf = Cgi.QRCODE_HB_HOST.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
            String str2 = Cgi.QRCODE_HB_HOST;
            if (indexOf != -1) {
                str2 = str2.substring(0, indexOf);
            }
            StringBuffer stringBuffer = new StringBuffer(str2);
            stringBuffer.append("#");
            stringBuffer.append(str);
            String substring = MD5.hexdigest(stringBuffer.toString() + "akT!Y#9W").substring(0, 4);
            stringBuffer.setLength(0);
            StringBuffer stringBuffer2 = new StringBuffer(Cgi.QRCODE_HB_HOST);
            stringBuffer2.append("c=");
            stringBuffer2.append(substring);
            stringBuffer2.append("#");
            stringBuffer2.append(str);
            return stringBuffer2.toString();
        } catch (Exception e16) {
            QLog.e(TAG, 1, "", e16);
            return "";
        }
    }

    public static boolean getShareBoolean(Context context, String str, String str2) {
        return context.getSharedPreferences(str, 0).getBoolean(str2, false);
    }

    public static String getUinPath(Context context, String str, String str2, boolean z16) {
        String str3;
        if (!z16) {
            str3 = DataProxy.getTenpayExternalPath();
        } else {
            str3 = context.getFilesDir().getPath() + "tencent/QWallet/";
        }
        return String.format("%s%s%s", str3, str, str2);
    }

    public static void markBeginTime() {
        mBeginTime = System.currentTimeMillis();
        QwLog.i("TenpayUtil markBeginTime : " + mBeginTime);
    }
}
