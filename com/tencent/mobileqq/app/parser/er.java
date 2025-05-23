package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportKey;

/* compiled from: P */
/* loaded from: classes11.dex */
public class er extends av {
    static IPatchRedirector $redirector_;

    public er() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.parser.av
    public com.tencent.mobileqq.utils.ax a(BaseQQAppInterface baseQQAppInterface, Context context, String str, JumpParserResult jumpParserResult) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.utils.ax) iPatchRedirector.redirect((short) 2, this, baseQQAppInterface, context, str, jumpParserResult);
        }
        if (str.startsWith("mqqapi://gamecenter/install")) {
            eq eqVar = new eq((QQAppInterface) baseQQAppInterface, context);
            eqVar.f307438c = str;
            eqVar.f307439d = "gamecenter";
            eqVar.f307440e = VRReportDefine$ReportKey.INSTALL;
            return eqVar;
        }
        return null;
    }
}
