package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqmini.sdk.plugins.QQFriendJsPlugin;

/* compiled from: P */
/* loaded from: classes11.dex */
public class bk extends av {
    static IPatchRedirector $redirector_;

    public bk() {
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
        bj bjVar = new bj((QQAppInterface) baseQQAppInterface, context);
        bjVar.f307438c = str;
        bjVar.f307439d = "odAddFriend";
        bjVar.f307440e = QQFriendJsPlugin.API_ADD_FRIEND;
        String[] split = str.split("\\?");
        if (split.length != 2) {
            return bjVar;
        }
        String[] split2 = split[1].split(ContainerUtils.FIELD_DELIMITER);
        if (split2 != null) {
            for (String str2 : split2) {
                String[] split3 = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                if (split3 != null && split3.length == 2) {
                    bjVar.r(split3[0], split3[1]);
                }
            }
        }
        return bjVar;
    }
}
