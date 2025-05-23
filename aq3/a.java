package aq3;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.parser.JumpParserResult;
import com.tencent.mobileqq.app.parser.av;
import com.tencent.mobileqq.utils.ax;
import yp3.b;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a extends av {
    @Override // com.tencent.mobileqq.app.parser.av
    public ax a(BaseQQAppInterface baseQQAppInterface, Context context, String str, JumpParserResult jumpParserResult) {
        if (jumpParserResult == null) {
            return null;
        }
        b bVar = new b(baseQQAppInterface, context);
        bVar.f307438c = str;
        bVar.f307439d = jumpParserResult.getServer();
        bVar.f307440e = jumpParserResult.getAction();
        bVar.s(jumpParserResult.getParamMap());
        return bVar;
    }
}
