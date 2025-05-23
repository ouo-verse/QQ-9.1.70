package com.tencent.qqnt.aio.assistedchat.chats.impl;

import com.tencent.biz.richframework.part.Part;
import com.tencent.qqnt.aio.assistedchat.chats.AIServicePart;
import com.tencent.qqnt.aio.assistedchat.chats.IAIServiceApi;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/chats/impl/AIServiceApiImpl;", "Lcom/tencent/qqnt/aio/assistedchat/chats/IAIServiceApi;", "()V", "getChatsAIServicePart", "Lcom/tencent/biz/richframework/part/Part;", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class AIServiceApiImpl implements IAIServiceApi {
    @Override // com.tencent.qqnt.aio.assistedchat.chats.IAIServiceApi
    public Part getChatsAIServicePart() {
        return new AIServicePart();
    }
}
