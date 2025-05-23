package com.tencent.mobileqq.qwallet.jump;

import com.tencent.mobileqq.app.parser.av;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQWalletJumpParserFactory extends QRouteApi {
    Class<? extends av> getJumpParserClass(String str);
}
