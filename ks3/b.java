package ks3;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.parser.JumpParserResult;
import com.tencent.mobileqq.app.parser.av;
import com.tencent.mobileqq.utils.ax;
import mqq.app.api.ProcessConstant;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b extends av {
    @Override // com.tencent.mobileqq.app.parser.av
    public ax a(BaseQQAppInterface baseQQAppInterface, Context context, String str, JumpParserResult jumpParserResult) {
        a aVar = new a(baseQQAppInterface, context);
        aVar.f307438c = str;
        aVar.f307439d = ProcessConstant.MINI_BOX_CORE;
        aVar.f307440e = jumpParserResult.getAction();
        aVar.f307441f = jumpParserResult.getParamMap();
        return aVar;
    }
}
