package com.tencent.mobileqq.qwallet.jump.impl;

import android.content.Context;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.parser.JumpParserResult;
import com.tencent.mobileqq.app.parser.av;
import com.tencent.mobileqq.utils.ax;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b extends av {
    @Override // com.tencent.mobileqq.app.parser.av
    public ax a(BaseQQAppInterface baseQQAppInterface, Context context, String str, JumpParserResult jumpParserResult) {
        a aVar = new a(baseQQAppInterface, context);
        aVar.f307438c = str;
        aVar.f307439d = "wxminiapp";
        aVar.f307440e = "launch";
        String[] split = str.split("\\?");
        if (split.length != 2) {
            return aVar;
        }
        String[] split2 = split[1].split(ContainerUtils.FIELD_DELIMITER);
        if (split2 != null) {
            for (String str2 : split2) {
                String[] split3 = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                if (split3 != null && split3.length == 2) {
                    aVar.r(split3[0], split3[1]);
                }
            }
        }
        return aVar;
    }
}
