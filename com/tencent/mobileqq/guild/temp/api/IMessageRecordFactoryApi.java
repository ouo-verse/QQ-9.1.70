package com.tencent.mobileqq.guild.temp.api;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\nH&J0\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H&\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/temp/api/IMessageRecordFactoryApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "createPicMessage", "Lcom/tencent/mobileqq/data/ChatMessage;", "app", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "msgRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "picElement", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "Lcom/tencent/qqnt/kernel/nativeinterface/PicElement;", "createSendMsgMarketFace", "Lcom/tencent/mobileqq/data/MessageForMarketFace;", "guildId", "", "channelId", "type", "", "mfm", "Lcom/tencent/mobileqq/data/MarkFaceMessage;", "qqguild-df-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface IMessageRecordFactoryApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public static final class a {
        public static /* synthetic */ ChatMessage a(IMessageRecordFactoryApi iMessageRecordFactoryApi, BaseQQAppInterface baseQQAppInterface, MsgRecord msgRecord, PicElement picElement, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    picElement = null;
                }
                return iMessageRecordFactoryApi.createPicMessage(baseQQAppInterface, msgRecord, picElement);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createPicMessage");
        }
    }

    @NotNull
    ChatMessage createPicMessage(@NotNull BaseQQAppInterface app, @NotNull MsgRecord msgRecord, @NotNull MsgElement picElement);

    @NotNull
    ChatMessage createPicMessage(@NotNull BaseQQAppInterface app, @NotNull MsgRecord msgRecord, @Nullable PicElement picElement);

    @NotNull
    MessageForMarketFace createSendMsgMarketFace(@NotNull BaseQQAppInterface app, @NotNull String guildId, @NotNull String channelId, int type, @NotNull MarkFaceMessage mfm);
}
