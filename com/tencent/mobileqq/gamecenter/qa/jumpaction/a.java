package com.tencent.mobileqq.gamecenter.qa.jumpaction;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.parser.JumpParserResult;
import com.tencent.mobileqq.app.parser.av;
import com.tencent.mobileqq.utils.ax;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a extends av {
    @Override // com.tencent.mobileqq.app.parser.av
    public ax a(BaseQQAppInterface baseQQAppInterface, Context context, String str, JumpParserResult jumpParserResult) {
        GameMainQAJumpAction gameMainQAJumpAction = new GameMainQAJumpAction(baseQQAppInterface, context);
        gameMainQAJumpAction.f307438c = str;
        if (jumpParserResult != null) {
            gameMainQAJumpAction.f307439d = jumpParserResult.getServer();
            gameMainQAJumpAction.f307440e = jumpParserResult.getAction();
            gameMainQAJumpAction.s(jumpParserResult.getParamMap());
        }
        return gameMainQAJumpAction;
    }
}
