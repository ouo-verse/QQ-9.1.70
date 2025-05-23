package com.tencent.mobileqq.login.verify;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.msf.sdk.VerifyCodeInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import oicq.wlogin_sdk.devicelock.DevlockInfo;

/* compiled from: P */
/* loaded from: classes15.dex */
public class j {
    static IPatchRedirector $redirector_;

    public static VerifyCodeInfo a(PuzzleVerifyInfo puzzleVerifyInfo) {
        if (puzzleVerifyInfo == null) {
            return null;
        }
        VerifyCodeInfo verifyCodeInfo = new VerifyCodeInfo();
        verifyCodeInfo.verifyimage = puzzleVerifyInfo.f242682d;
        verifyCodeInfo.verifyNote = puzzleVerifyInfo.f242683e;
        verifyCodeInfo.ssoSeq = puzzleVerifyInfo.f242684f;
        verifyCodeInfo.wupSeq = puzzleVerifyInfo.f242685h;
        verifyCodeInfo.svrSeqNo = puzzleVerifyInfo.f242686i;
        verifyCodeInfo.vpicSid = puzzleVerifyInfo.f242687m;
        verifyCodeInfo.uin = puzzleVerifyInfo.C;
        verifyCodeInfo.verifyurl = puzzleVerifyInfo.D;
        verifyCodeInfo.appSeq = puzzleVerifyInfo.E;
        return verifyCodeInfo;
    }

    public static DevlockInfo b(FromServiceMsg fromServiceMsg) {
        if (fromServiceMsg != null) {
            Object attribute = fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_RESP_DEVLOCKINFO);
            if (attribute instanceof DevlockInfo) {
                return (DevlockInfo) attribute;
            }
            return null;
        }
        return null;
    }

    public static String c(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        String str;
        String str2 = null;
        if (fromServiceMsg != null) {
            str = fromServiceMsg.getUin();
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str) || "0".equals(str)) {
            if (toServiceMsg != null) {
                str2 = toServiceMsg.getUin();
            }
            return str2;
        }
        return str;
    }

    public static Bundle d(ToServiceMsg toServiceMsg) {
        Bundle bundle = new Bundle();
        if (toServiceMsg != null) {
            Object attribute = toServiceMsg.getAttribute("from_where");
            Object attribute2 = toServiceMsg.getAttribute("mainaccount");
            if (attribute != null) {
                bundle.putString("from_where", (String) attribute);
                bundle.putString("mainaccount", (String) attribute2);
            }
            Object attribute3 = toServiceMsg.getAttribute(AppConstants.Key.KEY_CONNECT_DATA);
            if (attribute3 != null) {
                bundle.putByteArray(AppConstants.Key.KEY_CONNECT_DATA, (byte[]) attribute3);
            }
        }
        return bundle;
    }

    public static PuzzleVerifyInfo e(FromServiceMsg fromServiceMsg) {
        VerifyCodeInfo verifyCodeInfo;
        if (fromServiceMsg != null) {
            verifyCodeInfo = VerifyCodeInfo.getVerifyCodeInfo(fromServiceMsg);
        } else {
            verifyCodeInfo = null;
        }
        if (verifyCodeInfo == null) {
            return null;
        }
        PuzzleVerifyInfo puzzleVerifyInfo = new PuzzleVerifyInfo();
        puzzleVerifyInfo.f242682d = verifyCodeInfo.verifyimage;
        puzzleVerifyInfo.f242683e = verifyCodeInfo.verifyNote;
        puzzleVerifyInfo.f242684f = verifyCodeInfo.ssoSeq;
        puzzleVerifyInfo.f242685h = verifyCodeInfo.wupSeq;
        puzzleVerifyInfo.f242686i = verifyCodeInfo.svrSeqNo;
        puzzleVerifyInfo.f242687m = verifyCodeInfo.vpicSid;
        Object attribute = fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_RESP_VERIFUIN);
        if (attribute instanceof String) {
            puzzleVerifyInfo.C = (String) attribute;
        } else {
            puzzleVerifyInfo.C = "0";
        }
        puzzleVerifyInfo.D = verifyCodeInfo.verifyurl;
        puzzleVerifyInfo.E = verifyCodeInfo.appSeq;
        return puzzleVerifyInfo;
    }

    public static Bundle f(ToServiceMsg toServiceMsg) {
        Bundle bundle = new Bundle();
        if (toServiceMsg != null) {
            Object attribute = toServiceMsg.getAttribute("from_where");
            Object attribute2 = toServiceMsg.getAttribute("mainaccount");
            if (attribute != null) {
                bundle.putString("from_where", (String) attribute);
                bundle.putString("mainaccount", (String) attribute2);
            }
            Object attribute3 = toServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_LOGIN_UIN_ENCRYPT);
            Object attribute4 = toServiceMsg.getAttribute(AppConstants.Key.KEY_CONNECT_DATA);
            if (attribute3 != null) {
                bundle.putByteArray(MsfConstants.ATTRIBUTE_WTLOGIN_542, (byte[]) attribute3);
            } else if (attribute4 != null) {
                bundle.putByteArray(MsfConstants.ATTRIBUTE_WTLOGIN_542, (byte[]) attribute4);
            }
            if (attribute4 != null) {
                bundle.putByteArray(AppConstants.Key.KEY_CONNECT_DATA, (byte[]) attribute4);
            }
        }
        return bundle;
    }
}
