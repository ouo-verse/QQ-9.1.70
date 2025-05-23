package com.tencent.qqnt.aio.adapter.api.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.qqnt.aio.adapter.api.IMessageRecordFactoryApi;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J0\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/MessageRecordFactoryApiImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IMessageRecordFactoryApi;", "()V", "createPicMessage", "Lcom/tencent/mobileqq/data/ChatMessage;", "app", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "msgRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgElement", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "picElement", "Lcom/tencent/qqnt/kernel/nativeinterface/PicElement;", "createSendMsgMarketFace", "Lcom/tencent/mobileqq/data/MessageForMarketFace;", "friendUin", "", "groupUin", "type", "", "mfm", "Lcom/tencent/mobileqq/data/MarkFaceMessage;", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class MessageRecordFactoryApiImpl implements IMessageRecordFactoryApi {
    @Override // com.tencent.qqnt.aio.adapter.api.IMessageRecordFactoryApi
    public ChatMessage createPicMessage(BaseQQAppInterface app, MsgRecord msgRecord, PicElement picElement) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        return pu3.a.f427394a.b(app, msgRecord, picElement);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IMessageRecordFactoryApi
    public MessageForMarketFace createSendMsgMarketFace(BaseQQAppInterface app, String friendUin, String groupUin, int type, MarkFaceMessage mfm) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        Intrinsics.checkNotNullParameter(groupUin, "groupUin");
        Intrinsics.checkNotNullParameter(mfm, "mfm");
        return pu3.a.f427394a.c(app, friendUin, groupUin, type, mfm);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IMessageRecordFactoryApi
    public ChatMessage createPicMessage(BaseQQAppInterface app, MsgRecord msgRecord, MsgElement msgElement) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Intrinsics.checkNotNullParameter(msgElement, "msgElement");
        return pu3.a.f427394a.a(app, msgRecord, msgElement);
    }
}
