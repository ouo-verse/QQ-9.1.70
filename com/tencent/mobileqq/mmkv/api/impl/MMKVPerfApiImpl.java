package com.tencent.mobileqq.mmkv.api.impl;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mmkv.api.IMMKVPerfApi;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\r\u0010\u0003\u001a\u00020\u0004H\u0016\u00a2\u0006\u0002\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/mmkv/api/impl/MMKVPerfApiImpl;", "Lcom/tencent/mobileqq/mmkv/api/IMMKVPerfApi;", "()V", "isAVChatting", "", "()Ljava/lang/Boolean;", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MMKVPerfApiImpl implements IMMKVPerfApi {
    @Override // com.tencent.mobileqq.mmkv.api.IMMKVPerfApi
    public Boolean isAVChatting() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
        if (qQAppInterface == null) {
            return Boolean.FALSE;
        }
        return Boolean.valueOf(qQAppInterface.isVideoChatting() || qQAppInterface.getAVNotifyCenter().U());
    }
}
