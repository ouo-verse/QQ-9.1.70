package com.tencent.mobileqq.guild.temp.api.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.guild.temp.api.IMessageRecordFactoryApi;
import com.tencent.mobileqq.service.message.q;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import lu1.l;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J0\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u001c\u0010\u0016\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/guild/temp/api/impl/MessageRecordFactoryApiImpl;", "Lcom/tencent/mobileqq/guild/temp/api/IMessageRecordFactoryApi;", "()V", "createPicMessage", "Lcom/tencent/mobileqq/data/ChatMessage;", "app", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "msgRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgElement", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "picElement", "Lcom/tencent/qqnt/kernel/nativeinterface/PicElement;", "createSendMsgMarketFace", "Lcom/tencent/mobileqq/data/MessageForMarketFace;", "guildId", "", "channelId", "type", "", "mfm", "Lcom/tencent/mobileqq/data/MarkFaceMessage;", "findMatchMsgElement", "isMatch", "", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MessageRecordFactoryApiImpl implements IMessageRecordFactoryApi {
    private final boolean isMatch(MsgElement msgElement, PicElement picElement) {
        PicElement picElement2 = msgElement.picElement;
        return picElement2 != null && picElement.picSubType == picElement2.picSubType && Intrinsics.areEqual(picElement.picType, picElement2.picType) && Intrinsics.areEqual(picElement.md5HexStr, picElement2.md5HexStr);
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IMessageRecordFactoryApi
    public ChatMessage createPicMessage(BaseQQAppInterface app, MsgRecord msgRecord, PicElement picElement) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        ChatMessage a16 = new l().a(app, msgRecord, findMatchMsgElement(msgRecord, picElement));
        if (a16 != null) {
            return a16;
        }
        MessageForPic q16 = q.q(app, "", "", 0);
        Intrinsics.checkNotNullExpressionValue(q16, "createSendMSg_Pic(app, \"\", \"\", 0)");
        return q16;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IMessageRecordFactoryApi
    public MessageForMarketFace createSendMsgMarketFace(BaseQQAppInterface app, String guildId, String channelId, int type, MarkFaceMessage mfm) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(mfm, "mfm");
        MessageForMarketFace x16 = q.x((QQAppInterface) app, channelId, guildId, type, mfm);
        Intrinsics.checkNotNullExpressionValue(x16, "createSendMsg_MarketFace\u2026            mfm\n        )");
        return x16;
    }

    private final MsgElement findMatchMsgElement(MsgRecord msgRecord, PicElement picElement) {
        ArrayList<MsgElement> arrayList;
        MsgElement msgElement = null;
        if (picElement != null && (arrayList = msgRecord.elements) != null) {
            for (MsgElement it : arrayList) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (isMatch(it, picElement)) {
                    msgElement = it;
                }
            }
        }
        return msgElement;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IMessageRecordFactoryApi
    public ChatMessage createPicMessage(BaseQQAppInterface app, MsgRecord msgRecord, MsgElement msgElement) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Intrinsics.checkNotNullParameter(msgElement, "msgElement");
        ChatMessage a16 = new l().a(app, msgRecord, msgElement);
        if (a16 != null) {
            return a16;
        }
        MessageForPic q16 = q.q(app, "", "", 0);
        Intrinsics.checkNotNullExpressionValue(q16, "createSendMSg_Pic(app, \"\", \"\", 0)");
        return q16;
    }
}
