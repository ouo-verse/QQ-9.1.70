package com.tencent.mobileqq.qwallet.jump.impl;

import com.tencent.mobileqq.app.parser.av;
import com.tencent.mobileqq.qwallet.jump.IQWalletJumpParserFactory;

/* loaded from: classes16.dex */
public class QWalletJumpParserFactoryImpl implements IQWalletJumpParserFactory {
    @Override // com.tencent.mobileqq.qwallet.jump.IQWalletJumpParserFactory
    public Class<? extends av> getJumpParserClass(String str) {
        if ("mqqapi://wxminiapp/launch".equals(str)) {
            return b.class;
        }
        return null;
    }
}
