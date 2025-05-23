package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ep extends av {
    static IPatchRedirector $redirector_;

    public ep() {
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
        eo eoVar = new eo((QQAppInterface) baseQQAppInterface, context);
        eoVar.f307438c = str;
        eoVar.f307439d = "vastest";
        if (str.contains("change_theme")) {
            eoVar.f307440e = "change_theme";
        }
        if (str.contains("change_page")) {
            eoVar.f307440e = "change_page";
        }
        String[] split = str.split("\\?");
        if (split.length != 2) {
            return eoVar;
        }
        for (String str2 : split[1].split(",")) {
            String[] split2 = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
            if (split2.length == 2) {
                eoVar.r(split2[0], split2[1]);
            }
        }
        return eoVar;
    }
}
