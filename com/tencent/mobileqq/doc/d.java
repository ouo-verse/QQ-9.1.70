package com.tencent.mobileqq.doc;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.doc.b;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static b.a f203568a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71501);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f203568a = null;
        }
    }

    public static void a(QQAppInterface qQAppInterface, String str, String str2, int i3, long j3, long j16, long j17) {
        boolean z16;
        long j18 = j3 + 1;
        BaseApplication app = qQAppInterface.getApp();
        String account = qQAppInterface.getAccount();
        f203568a = b.b(qQAppInterface);
        int g16 = c.g(app, account);
        long f16 = c.f(app, account);
        if (QLog.isColorLevel()) {
            QLog.d("TencentDocGrayTipsUtils", 2, "addGrayTipMsg friendUin = " + str + ", senderUin = " + str2 + ", uinType = " + i3 + ", selfUin = " + account + ", time = " + j18 + ", msgseq = " + j16 + ", msgUid = " + j17 + ", times = " + g16 + ", lastShowTime = " + f16);
        }
        if (QQAudioHelper.c(10) == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QQAudioHelper.w(HardCodeUtil.qqStr(R.string.f172768u22) + f203568a.f203564b);
            z16 = TextUtils.isEmpty(f203568a.f203564b) ^ true;
        }
        b.a aVar = f203568a;
        if ((aVar.f203563a && g16 < aVar.f203566d && j18 - f16 > 30 && !str2.equals(account)) || z16) {
            String str3 = f203568a.f203564b;
            String str4 = str3 + f203568a.f203565c;
            com.tencent.mobileqq.graytip.g gVar = new com.tencent.mobileqq.graytip.g(str, str2, str4, i3, MessageRecord.MSG_TYPE_UNITE_GRAY_NORMAL, 3276801, j18);
            gVar.f213693p = String.valueOf(j16) + "_" + String.valueOf(j18);
            if (QLog.isColorLevel()) {
                QLog.d("TencentDocGrayTipsUtils", 2, "addGrayTipMsg grayTipParam.grayTipKey = " + gVar.f213693p);
            }
            Bundle bundle = new Bundle();
            bundle.putInt("key_action", 1);
            bundle.putString("key_action_DATA", f203568a.f203567e);
            gVar.b(str3.length(), str4.length(), bundle);
            MessageForUniteGrayTip messageForUniteGrayTip = new MessageForUniteGrayTip();
            messageForUniteGrayTip.initGrayTipMsg(qQAppInterface, gVar);
            if (com.tencent.mobileqq.graytip.f.a(qQAppInterface, messageForUniteGrayTip)) {
                c.i(app, account, g16 + 1);
                c.h(app, account, j18);
                h.a("0X80094AA");
            }
        }
    }
}
