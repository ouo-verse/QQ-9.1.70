package com.tencent.mobileqq.weiyun.sdk.download;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.weiyun.transmission.ErrorCode;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal;
import com.tencent.weiyun.transmission.utils.ErrorCodeUtil;
import com.tencent.weiyun.utils.NetworkUtils;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class a {
    static IPatchRedirector $redirector_;

    public static String a(int i3, String str) {
        if (i3 != 0 && TextUtils.isEmpty(str)) {
            String errorMsg = ErrorCodeUtil.getErrorMsg(i3);
            if (TextUtils.isEmpty(errorMsg)) {
                if (ErrorCodeUtil.isHttpError(i3)) {
                    errorMsg = ErrorCodeUtil.getErrorMsg(ErrorCode.CMD_SERVER_ERROR);
                } else {
                    errorMsg = ErrorCodeUtil.getErrorMsg(ErrorCode.TRAN_UNKNOWN_EXCEPTION);
                }
            }
            if (1810008 == i3) {
                errorMsg = errorMsg + "\n\u8bf7\u5c1d\u8bd5\u4e0b\u8f7d\u5230\u5176\u4ed6\u8def\u5f84";
            }
            return "(" + i3 + ")" + errorMsg;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(int i3) {
        if (-29150 != i3 && -29151 != i3 && -29152 != i3) {
            return false;
        }
        return true;
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb5 = new StringBuilder(str);
        int networkType = NetworkUtils.getNetworkType(WeiyunTransmissionGlobal.getInstance().getContext());
        sb5.append("&nettype=");
        sb5.append(networkType);
        return sb5.toString();
    }
}
