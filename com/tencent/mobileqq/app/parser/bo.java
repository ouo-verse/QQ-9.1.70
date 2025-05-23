package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;

/* compiled from: P */
/* loaded from: classes33.dex */
public class bo extends av {
    @Override // com.tencent.mobileqq.app.parser.av
    public com.tencent.mobileqq.utils.ax a(BaseQQAppInterface baseQQAppInterface, Context context, String str, JumpParserResult jumpParserResult) {
        bn bnVar = new bn((QQAppInterface) baseQQAppInterface, context);
        bnVar.f307438c = str;
        bnVar.f307439d = "miniapp";
        bnVar.f307440e = "bindwx";
        return bnVar;
    }
}
