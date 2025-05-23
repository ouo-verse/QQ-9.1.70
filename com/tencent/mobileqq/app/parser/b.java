package com.tencent.mobileqq.app.parser;

import android.app.Activity;
import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.api.ProcessConstant;

/* compiled from: P */
/* loaded from: classes11.dex */
public class b extends av {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.parser.av
    public com.tencent.mobileqq.utils.ax a(BaseQQAppInterface baseQQAppInterface, Context context, String str, JumpParserResult jumpParserResult) {
        a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.utils.ax) iPatchRedirector.redirect((short) 2, this, baseQQAppInterface, context, str, jumpParserResult);
        }
        if (context instanceof Activity) {
            aVar = new a(baseQQAppInterface, (Activity) context);
        } else {
            aVar = new a(baseQQAppInterface, context);
        }
        return com.tencent.avgame.util.b.a(aVar, str, ProcessConstant.AVGAME, "create_room");
    }
}
