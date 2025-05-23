package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ab extends av {
    static IPatchRedirector $redirector_;

    public ab() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private com.tencent.mobileqq.utils.ax b(BaseQQAppInterface baseQQAppInterface, Context context, JumpParserResult jumpParserResult) {
        aa aaVar = new aa((QQAppInterface) baseQQAppInterface, context);
        aaVar.f307439d = "gamecenter";
        aaVar.f307440e = "kuikly_float";
        aaVar.f307438c = jumpParserResult.getUrl();
        aaVar.s(jumpParserResult.getParamMap());
        return aaVar;
    }

    private com.tencent.mobileqq.utils.ax c(BaseQQAppInterface baseQQAppInterface, Context context, JumpParserResult jumpParserResult) {
        aa aaVar = new aa((QQAppInterface) baseQQAppInterface, context);
        aaVar.f307439d = "gamecenter";
        aaVar.f307440e = "searchgame";
        aaVar.s(jumpParserResult.getParamMap());
        return aaVar;
    }

    @Override // com.tencent.mobileqq.app.parser.av
    public com.tencent.mobileqq.utils.ax a(BaseQQAppInterface baseQQAppInterface, Context context, String str, JumpParserResult jumpParserResult) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.utils.ax) iPatchRedirector.redirect((short) 2, this, baseQQAppInterface, context, str, jumpParserResult);
        }
        if (str.startsWith("mqqapi://gamecenter/searchgame")) {
            return c(baseQQAppInterface, context, jumpParserResult);
        }
        if (str.startsWith("mqqapi://gamecenter/kuikly_float")) {
            return b(baseQQAppInterface, context, jumpParserResult);
        }
        return null;
    }
}
