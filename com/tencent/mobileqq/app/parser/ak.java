package com.tencent.mobileqq.app.parser;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ak extends av {
    static IPatchRedirector $redirector_;

    public ak() {
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
        aj ajVar = new aj((QQAppInterface) baseQQAppInterface, context);
        ajVar.f307438c = str;
        ajVar.f307439d = "microapp";
        ajVar.f307440e = "open";
        if (QLog.isColorLevel()) {
            QLog.d("HttpOpenMicroAppParser", 2, "[miniapp-scheme], open microapp scheme=" + str);
        }
        String[] split = str.split("\\?");
        if (split.length >= 2 && split[0].length() != 0) {
            String[] split2 = str.substring(split[0].length() + 1).split(ContainerUtils.FIELD_DELIMITER);
            if (split2 != null) {
                for (String str2 : split2) {
                    String[] split3 = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                    if (split3 != null && split3.length == 2) {
                        ajVar.r(split3[0], split3[1]);
                        if (QLog.isColorLevel()) {
                            QLog.d("HttpOpenMicroAppParser", 2, "[miniapp-scheme], open microapp key=" + split3[0] + ", value=" + split3[1]);
                        }
                    }
                }
            }
            String f16 = ajVar.f("fakeUrl");
            if (TextUtils.isEmpty(ajVar.f("scene")) && !TextUtils.isEmpty(f16)) {
                ajVar.r("scene", String.valueOf(2003));
            }
        }
        return ajVar;
    }
}
