package com.tencent.mobileqq.qqexpand.chat.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qqexpand.chat.ILimitChatMatchInfoHelper;
import com.tencent.mobileqq.qqexpand.chat.f;
import com.tencent.mobileqq.qqexpand.network.d;
import expand.common.MatchedInfo;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ&\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/qqexpand/chat/impl/LimitChatMatchInfoHelperImpl;", "Lcom/tencent/mobileqq/qqexpand/chat/ILimitChatMatchInfoHelper;", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", "", "uin", "Lcom/tencent/mobileqq/qqexpand/network/d;", "callback", "", "getMatchInfoRequest", "Lexpand/common/MatchedInfo;", "matchedInfo", "", "getIceBreakAioType", "<init>", "()V", "qqexpand_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class LimitChatMatchInfoHelperImpl implements ILimitChatMatchInfoHelper {
    @Override // com.tencent.mobileqq.qqexpand.chat.ILimitChatMatchInfoHelper
    public int getIceBreakAioType(MatchedInfo matchedInfo) {
        return f.a(matchedInfo);
    }

    @Override // com.tencent.mobileqq.qqexpand.chat.ILimitChatMatchInfoHelper
    public void getMatchInfoRequest(BaseQQAppInterface app, String uin, d callback) {
        f.b(app, uin, callback);
    }
}
