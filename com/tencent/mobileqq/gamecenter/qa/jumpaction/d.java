package com.tencent.mobileqq.gamecenter.qa.jumpaction;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.parser.JumpParserResult;
import com.tencent.mobileqq.app.parser.av;
import com.tencent.mobileqq.utils.ax;

/* compiled from: P */
/* loaded from: classes33.dex */
public class d extends av {
    @Override // com.tencent.mobileqq.app.parser.av
    public ax a(BaseQQAppInterface baseQQAppInterface, Context context, String str, JumpParserResult jumpParserResult) {
        c cVar = new c(baseQQAppInterface, context);
        cVar.f307438c = str;
        if (jumpParserResult != null) {
            cVar.f307439d = jumpParserResult.getServer();
            cVar.f307440e = jumpParserResult.getAction();
            cVar.s(jumpParserResult.getParamMap());
        }
        return cVar;
    }
}
