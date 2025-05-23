package com.tencent.mobileqq.msf.core.z;

import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    private static final String f250465a = "JCPTZXEZ";

    /* renamed from: b, reason: collision with root package name */
    private static final HashSet<String> f250466b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18199);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        HashSet<String> hashSet = new HashSet<>();
        f250466b = hashSet;
        hashSet.add(BaseConstants.CMD_REPORTRDM);
        hashSet.add("socketnetflow");
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String a(String str) {
        return TextUtils.isEmpty(str) ? str : Base64.encodeToString(a(str.getBytes(), f250465a), 3);
    }

    public static String b(ToServiceMsg toServiceMsg) {
        try {
            StringBuilder sb5 = new StringBuilder("ToServiceMsg");
            sb5.append(" msName:");
            sb5.append(toServiceMsg.getMsfCommand());
            sb5.append(" ssoSeq:");
            sb5.append(toServiceMsg.getRequestSsoSeq());
            sb5.append(" appId:");
            sb5.append(toServiceMsg.getAppId());
            sb5.append(" appSeq:");
            sb5.append(toServiceMsg.getAppSeq());
            sb5.append(" uin:");
            sb5.append(MsfSdkUtils.getShortUin(toServiceMsg.getUin()));
            String serviceCmd = toServiceMsg.getServiceCmd();
            if (QLog.isColorLevel()) {
                sb5.append(" cmd:");
                sb5.append(serviceCmd);
            } else {
                sb5.append(" cmd=");
                sb5.append(a(serviceCmd));
            }
            sb5.append(" t:");
            sb5.append(toServiceMsg.getTimeout());
            sb5.append(" needResp:");
            sb5.append(toServiceMsg.isNeedCallback());
            sb5.append(" needQuickSend:");
            sb5.append(toServiceMsg.isQuickSendEnable());
            sb5.append(" strategy:");
            sb5.append(toServiceMsg.getQuickSendStrategy());
            sb5.append("IsSupportRetry");
            sb5.append(toServiceMsg.isSupportRetry());
            return sb5.toString();
        } catch (Throwable unused) {
            return "TSM toString error";
        }
    }

    public static byte[] a(byte[] bArr, String str) {
        if (bArr != null) {
            try {
                char[] charArray = str.toCharArray();
                int length = bArr.length;
                byte[] bArr2 = new byte[length];
                for (int i3 = 0; i3 < length; i3++) {
                    bArr2[i3] = (byte) (bArr[i3] ^ charArray[i3 % charArray.length]);
                }
                return bArr2;
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.e("LogUtils", 2, "xor Exception! ", th5);
                }
            }
        }
        return bArr;
    }

    public static String a(FromServiceMsg fromServiceMsg) {
        try {
            StringBuilder sb5 = new StringBuilder("FromServiceMsg");
            sb5.append(" msName:");
            sb5.append(fromServiceMsg.getMsfCommand());
            sb5.append(" ssoSeq:");
            sb5.append(fromServiceMsg.getRequestSsoSeq());
            sb5.append(" failCode:");
            sb5.append(fromServiceMsg.getResultCode());
            sb5.append(" errorMsg:");
            sb5.append(fromServiceMsg.getBusinessFailMsg());
            sb5.append(" uin:");
            sb5.append(MsfSdkUtils.getShortUin(fromServiceMsg.getUin()));
            sb5.append(" serviceCmd:");
            String serviceCmd = fromServiceMsg.getServiceCmd();
            if (QLog.isColorLevel()) {
                sb5.append(" cmd:");
                sb5.append(serviceCmd);
            } else {
                sb5.append(" cmd=");
                sb5.append(a(serviceCmd));
            }
            sb5.append(" appId:");
            sb5.append(fromServiceMsg.getAppId());
            sb5.append(" appSeq:");
            sb5.append(fromServiceMsg.getAppSeq());
            return sb5.toString();
        } catch (Exception unused) {
            return "FSM toString error";
        }
    }

    public static boolean a(ToServiceMsg toServiceMsg) {
        return toServiceMsg.getServiceCmd() == null || !f250466b.contains(toServiceMsg.getServiceCmd());
    }
}
