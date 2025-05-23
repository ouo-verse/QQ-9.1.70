package com.tencent.mobileqq.app.parser;

import android.content.Context;
import androidx.annotation.Nullable;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vaswebviewplugin.QQIliveJsPlugin;
import com.tencent.timi.game.jump.api.IQQLiveJumpParserApi;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes11.dex */
public class at extends av {
    static IPatchRedirector $redirector_;

    public at() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    private com.tencent.mobileqq.utils.ax b(BaseQQAppInterface baseQQAppInterface, Context context, String str, JumpParserResult jumpParserResult) {
        av jumpParser = ((IQQLiveJumpParserApi) QRoute.api(IQQLiveJumpParserApi.class)).getJumpParser(str);
        if (jumpParser == null) {
            return null;
        }
        return jumpParser.a(baseQQAppInterface, context, str, jumpParserResult);
    }

    @NotNull
    private IliveJumpAction c(QQAppInterface qQAppInterface, Context context, String str) {
        IliveJumpAction iliveJumpAction = new IliveJumpAction(qQAppInterface, context);
        iliveJumpAction.f307438c = str;
        iliveJumpAction.f307439d = QQIliveJsPlugin.BUSINESS_NAME;
        iliveJumpAction.c0();
        String[] split = str.split("\\?");
        if (split.length != 2) {
            return iliveJumpAction;
        }
        String[] split2 = split[1].split(ContainerUtils.FIELD_DELIMITER);
        if (split2 != null) {
            for (String str2 : split2) {
                String[] split3 = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                if (split3 != null && split3.length == 2) {
                    iliveJumpAction.r(split3[0], split3[1]);
                }
            }
        }
        return iliveJumpAction;
    }

    @Override // com.tencent.mobileqq.app.parser.av
    public com.tencent.mobileqq.utils.ax a(BaseQQAppInterface baseQQAppInterface, Context context, String str, JumpParserResult jumpParserResult) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.utils.ax) iPatchRedirector.redirect((short) 2, this, baseQQAppInterface, context, str, jumpParserResult);
        }
        if (str.startsWith("mqqapi://vaslive")) {
            com.tencent.mobileqq.utils.ax b16 = b(baseQQAppInterface, context, str, jumpParserResult);
            if (b16 != null) {
                return b16;
            }
            return c((QQAppInterface) baseQQAppInterface, context, str);
        }
        return null;
    }
}
