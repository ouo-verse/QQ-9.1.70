package com.tencent.mobileqq.app.parser;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class bz extends av {
    static IPatchRedirector $redirector_;

    public bz() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void b(@NonNull com.tencent.mobileqq.utils.ax axVar, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        for (String str2 : str.split(ContainerUtils.FIELD_DELIMITER)) {
            int indexOf = str2.indexOf(ContainerUtils.KEY_VALUE_DELIMITER);
            if (indexOf >= 0) {
                String substring = str2.substring(0, indexOf);
                String decode = Uri.decode(str2.substring(indexOf + 1));
                if (!TextUtils.isEmpty(substring) && !TextUtils.isEmpty(decode)) {
                    axVar.r(substring.toLowerCase(), decode);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.app.parser.av
    public com.tencent.mobileqq.utils.ax a(BaseQQAppInterface baseQQAppInterface, Context context, String str, JumpParserResult jumpParserResult) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.utils.ax) iPatchRedirector.redirect((short) 2, this, baseQQAppInterface, context, str, jumpParserResult);
        }
        bx bxVar = new bx((QQAppInterface) baseQQAppInterface, context);
        String[] split = str.split("\\?");
        if (split.length < 1) {
            return bxVar;
        }
        String[] split2 = split[0].substring(9).split("/");
        if (split2.length != 2) {
            return bxVar;
        }
        bxVar.f307438c = str;
        bxVar.f307439d = split2[0];
        bxVar.f307440e = split2[1];
        bxVar.r("key_scheme", str);
        if (split.length < 2) {
            return bxVar;
        }
        b(bxVar, split[1]);
        String[] split3 = str.split("url=");
        if (split3.length > 1) {
            bxVar.r("url", split3[1]);
        }
        return bxVar;
    }
}
