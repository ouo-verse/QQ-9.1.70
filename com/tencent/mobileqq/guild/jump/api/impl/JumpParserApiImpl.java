package com.tencent.mobileqq.guild.jump.api.impl;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.parser.JumpParserResult;
import com.tencent.mobileqq.guild.jump.GuildJumpAction;
import com.tencent.mobileqq.guild.jump.api.IJumpParserApi;
import eq1.a;

/* loaded from: classes13.dex */
public class JumpParserApiImpl implements IJumpParserApi {
    @Override // com.tencent.mobileqq.guild.jump.api.IJumpParserApi
    public IJumpParserApi.b createActionable(BaseQQAppInterface baseQQAppInterface, Context context, JumpParserResult jumpParserResult, IJumpParserApi.a aVar) {
        return new GuildJumpAction(baseQQAppInterface, context, jumpParserResult, aVar);
    }

    @Override // com.tencent.mobileqq.guild.jump.api.IJumpParserApi
    public IJumpParserApi.b createActionableForRobot(BaseQQAppInterface baseQQAppInterface, Context context, JumpParserResult jumpParserResult, IJumpParserApi.a aVar) {
        return new a(baseQQAppInterface, context, jumpParserResult, aVar);
    }
}
