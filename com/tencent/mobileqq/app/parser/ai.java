package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ai extends av {
    static IPatchRedirector $redirector_;

    public ai() {
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
        ah ahVar = new ah((QQAppInterface) baseQQAppInterface, context);
        ahVar.f307438c = str;
        ahVar.f307439d = "troop_homework";
        ahVar.f307440e = "publish";
        String[] split = str.split("\\?");
        if (split.length != 2) {
            return ahVar;
        }
        for (String str2 : split[1].split(ContainerUtils.FIELD_DELIMITER)) {
            String[] split2 = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
            if (split2.length == 2) {
                ahVar.r(split2[0], split2[1]);
            }
        }
        return ahVar;
    }
}
