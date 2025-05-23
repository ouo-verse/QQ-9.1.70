package com.tencent.mobileqq.mutualmark;

import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void a(QQAppInterface qQAppInterface, MessageForUniteGrayTip messageForUniteGrayTip, int i3) {
        if (messageForUniteGrayTip != null) {
            String extInfoFromExtStr = messageForUniteGrayTip.getExtInfoFromExtStr("mutualmark_id");
            String extInfoFromExtStr2 = messageForUniteGrayTip.getExtInfoFromExtStr("sub_level");
            String extInfoFromExtStr3 = messageForUniteGrayTip.getExtInfoFromExtStr("mutualmark_WillDowngradeSoon");
            String str = messageForUniteGrayTip.frienduin;
            if (!TextUtils.isEmpty(extInfoFromExtStr)) {
                long i16 = g.i(extInfoFromExtStr);
                long g16 = g.g(extInfoFromExtStr);
                if (g.n(i16) && g16 >= 0) {
                    String d16 = g.d(i16, g16);
                    int i17 = (int) ((i16 * 10) + g16);
                    if (TextUtils.isEmpty(extInfoFromExtStr2)) {
                        extInfoFromExtStr2 = "0";
                    }
                    ReportController.o(qQAppInterface, "dc00898", "", str, "0X800A7E4", d16, i17, 0, extInfoFromExtStr2, "", "", "");
                }
            }
            if (QLog.isColorLevel()) {
                QLog.i("MutualMarkBusinessLogicHelper", 2, "reportMutualMarkGrayTipExposure id:" + extInfoFromExtStr + " willDowngradeSoon:" + extInfoFromExtStr3 + " grayID:" + i3);
            }
        }
    }

    public static void b(QQAppInterface qQAppInterface, MessageForUniteGrayTip messageForUniteGrayTip, int i3) {
        if (messageForUniteGrayTip != null) {
            String extInfoFromExtStr = messageForUniteGrayTip.getExtInfoFromExtStr("mutualmark_id");
            String str = messageForUniteGrayTip.frienduin;
            BaseActivity baseActivity = BaseActivity.sTopActivity;
            if (!TextUtils.isEmpty(extInfoFromExtStr) && baseActivity != null) {
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("interact_tag_id", extInfoFromExtStr);
                hashMap.put("to_uin", str);
                ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).reportItemEvent("dt_imp", "pg_aio", "em_aio_interact_graytext", null, hashMap);
                if (QLog.isColorLevel()) {
                    QLog.i("MutualMarkBusinessLogicHelper", 2, "reportMutualMarkGrayTipExposure id:" + extInfoFromExtStr);
                }
            }
        }
    }
}
