package com.tencent.mobileqq.app.parser;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class dx extends av {
    static IPatchRedirector $redirector_;

    public dx() {
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
        dw dwVar = new dw((QQAppInterface) baseQQAppInterface, context);
        String[] split = str.split("\\?");
        if (split.length < 1) {
            return dwVar;
        }
        String[] split2 = split[0].substring(9).split("/");
        if (split2.length != 2) {
            return dwVar;
        }
        dwVar.f307438c = str;
        dwVar.f307439d = split2[0];
        dwVar.f307440e = split2[1];
        Uri parse = Uri.parse(str);
        for (String str2 : parse.getQueryParameterNames()) {
            if (!TextUtils.isEmpty(str2)) {
                String queryParameter = parse.getQueryParameter(str2);
                if (!TextUtils.isEmpty(queryParameter)) {
                    dwVar.r(str2.toLowerCase(), queryParameter);
                }
            }
        }
        return dwVar;
    }
}
