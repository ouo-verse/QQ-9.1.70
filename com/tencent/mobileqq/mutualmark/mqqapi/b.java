package com.tencent.mobileqq.mutualmark.mqqapi;

import android.content.Context;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.parser.JumpParserResult;
import com.tencent.mobileqq.app.parser.av;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ax;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b extends av {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.parser.av
    public ax a(BaseQQAppInterface baseQQAppInterface, Context context, String str, JumpParserResult jumpParserResult) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ax) iPatchRedirector.redirect((short) 2, this, baseQQAppInterface, context, str, jumpParserResult);
        }
        if (QLog.isColorLevel()) {
            QLog.d("MutualMarkOpenPageParser", 2, "parse\uff1a" + str);
        }
        a aVar = new a((QQAppInterface) baseQQAppInterface, context);
        aVar.f307438c = str;
        aVar.f307439d = "mutualmark";
        aVar.f307440e = "";
        if (str.contains("unwear")) {
            aVar.f307440e = "unwear";
        } else if (str.contains("wear")) {
            aVar.f307440e = "wear";
        } else if (str.contains("poke")) {
            aVar.f307440e = "poke";
        }
        String[] split = str.split("\\?");
        if (split.length != 2) {
            return aVar;
        }
        for (String str2 : split[1].split(ContainerUtils.FIELD_DELIMITER)) {
            String[] split2 = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
            if (split2.length == 2) {
                aVar.r(split2[0], split2[1]);
            }
        }
        return aVar;
    }
}
