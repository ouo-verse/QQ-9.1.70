package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ex extends av {
    static IPatchRedirector $redirector_;

    public ex() {
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
        ew ewVar = new ew((QQAppInterface) baseQQAppInterface, context);
        ewVar.f307438c = str;
        ewVar.f307439d = "wsgzh";
        ewVar.f307440e = "miniapp_player";
        String[] split = str.split("\\?");
        if (split.length != 2) {
            return ewVar;
        }
        for (String str2 : split[1].split(ContainerUtils.FIELD_DELIMITER)) {
            String[] split2 = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
            if (split2.length == 2) {
                try {
                    String decode = URLDecoder.decode(split2[1], "UTF-8");
                    split2[1] = decode;
                    ewVar.r(split2[0], decode);
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("WeishiPublicAccountVideoParser", 2, "failed to decode param value,tmps[1] is:" + split2[0] + ",tmps[1] is:" + split2[1], e16);
                    }
                }
            }
        }
        return ewVar;
    }
}
