package com.tencent.mobileqq.vashealth;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.parser.JumpParserResult;
import com.tencent.mobileqq.app.parser.av;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.vashealth.api.IQQHealthService;
import mqq.app.api.ProcessConstant;

/* compiled from: P */
/* loaded from: classes20.dex */
public class n extends av {

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class a extends ax {
        protected a(BaseQQAppInterface baseQQAppInterface, Context context) {
            super(baseQQAppInterface, context);
        }

        @Override // com.tencent.mobileqq.utils.ax
        public boolean b() {
            ((IQQHealthService) this.f307436a.getRuntimeService(IQQHealthService.class, ProcessConstant.MULTI)).openSportHippy(this.f307437b, this.f307441f);
            return true;
        }
    }

    @Override // com.tencent.mobileqq.app.parser.av
    public ax a(BaseQQAppInterface baseQQAppInterface, Context context, String str, JumpParserResult jumpParserResult) {
        return com.tencent.avgame.util.b.a(new a(baseQQAppInterface, context), str, "qqsport", "open");
    }
}
