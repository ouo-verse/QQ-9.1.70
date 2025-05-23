package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class bb extends av {
    static IPatchRedirector $redirector_;

    public bb() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.parser.av
    public com.tencent.mobileqq.utils.ax a(BaseQQAppInterface baseQQAppInterface, Context context, String str, JumpParserResult jumpParserResult) {
        String[] split;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.utils.ax) iPatchRedirector.redirect((short) 2, this, baseQQAppInterface, context, str, jumpParserResult);
        }
        ba baVar = new ba((QQAppInterface) baseQQAppInterface, context);
        baVar.f307438c = str;
        baVar.f307439d = "map";
        baVar.f307440e = "openmap";
        String str2 = str.split("\\?", 2)[1];
        if (str2 != null && (split = str2.split(ContainerUtils.KEY_VALUE_DELIMITER, 2)) != null && split.length == 2) {
            baVar.r(split[0], split[1]);
        }
        return baVar;
    }
}
