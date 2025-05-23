package com.tencent.mobileqq.guild.jump;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.parser.JumpParserResult;
import com.tencent.mobileqq.app.parser.av;
import com.tencent.mobileqq.guild.jump.api.IJumpParserApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ax;

/* compiled from: P */
/* loaded from: classes13.dex */
public class h extends av {

    /* renamed from: a, reason: collision with root package name */
    private IJumpParserApi f226413a;

    private synchronized IJumpParserApi b() {
        if (this.f226413a == null) {
            this.f226413a = (IJumpParserApi) QRoute.api(IJumpParserApi.class);
        }
        return this.f226413a;
    }

    @Override // com.tencent.mobileqq.app.parser.av
    public ax a(BaseQQAppInterface baseQQAppInterface, Context context, String str, JumpParserResult jumpParserResult) {
        IJumpParserApi.a aVar = new IJumpParserApi.a();
        return j.F(baseQQAppInterface, context, b().createActionable(baseQQAppInterface, context, jumpParserResult, aVar), str, jumpParserResult, aVar);
    }
}
