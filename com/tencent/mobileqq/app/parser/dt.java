package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class dt extends av {
    static IPatchRedirector $redirector_;

    public dt() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private com.tencent.mobileqq.utils.ax b(com.tencent.mobileqq.utils.ax axVar, String str) {
        axVar.f307438c = str;
        axVar.f307439d = "avsharescreen";
        axVar.f307440e = Const.BUNDLE_KEY_REQUEST;
        String[] split = str.split("\\?");
        if (split.length != 2) {
            return axVar;
        }
        for (String str2 : split[1].split(ContainerUtils.FIELD_DELIMITER)) {
            if (str2.split(ContainerUtils.KEY_VALUE_DELIMITER).length == 2) {
                int indexOf = str2.indexOf(ContainerUtils.KEY_VALUE_DELIMITER);
                axVar.r(str2.substring(0, indexOf), str2.substring(indexOf + 1));
            }
        }
        return axVar;
    }

    @Override // com.tencent.mobileqq.app.parser.av
    public com.tencent.mobileqq.utils.ax a(BaseQQAppInterface baseQQAppInterface, Context context, String str, JumpParserResult jumpParserResult) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.utils.ax) iPatchRedirector.redirect((short) 2, this, baseQQAppInterface, context, str, jumpParserResult);
        }
        return b(new ScreenShareAskAction((QQAppInterface) baseQQAppInterface, context), str);
    }
}
