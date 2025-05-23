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
public class ev extends av {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private Object f196481a;

    public ev() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    @Override // com.tencent.mobileqq.app.parser.av
    public com.tencent.mobileqq.utils.ax a(BaseQQAppInterface baseQQAppInterface, Context context, String str, JumpParserResult jumpParserResult) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.mobileqq.utils.ax) iPatchRedirector.redirect((short) 3, this, baseQQAppInterface, context, str, jumpParserResult);
        }
        eu euVar = new eu((QQAppInterface) baseQQAppInterface, context, this.f196481a);
        euVar.f307438c = str;
        euVar.f307439d = "wsgzh";
        euVar.f307440e = "wesee";
        String[] split = str.split("\\?");
        if (split.length != 2) {
            return euVar;
        }
        for (String str2 : split[1].split(ContainerUtils.FIELD_DELIMITER)) {
            String[] split2 = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
            if (split2.length == 2) {
                try {
                    String decode = URLDecoder.decode(split2[1], "UTF-8");
                    split2[1] = decode;
                    euVar.r(split2[0], decode);
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("WeishiPublicAccountUniversalParser", 2, "failed to decode param value,tmps[1] is:" + split2[0] + ",tmps[1] is:" + split2[1], e16);
                    }
                }
            }
        }
        return euVar;
    }

    public ev(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.f196481a = obj;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }
    }
}
