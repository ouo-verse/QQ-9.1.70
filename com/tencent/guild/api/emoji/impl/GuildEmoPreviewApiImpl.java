package com.tencent.guild.api.emoji.impl;

import android.view.View;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.guild.api.emoji.IGuildEmoPreviewApi;
import com.tencent.guild.api.marketface.impl.c;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.guild.temp.api.IMessageRecordFactoryApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qqnt.kernel.nativeinterface.MarketFaceElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import com.tencent.qqnt.msg.MsgExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0002J8\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J \u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000b\u001a\u00020\fH\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/guild/api/emoji/impl/GuildEmoPreviewApiImpl;", "Lcom/tencent/guild/api/emoji/IGuildEmoPreviewApi;", "()V", "createMarketFace", "", "faceElement", "Lcom/tencent/qqnt/kernel/nativeinterface/MarketFaceElement;", "channelId", "", "guildId", "createPicFace", "msgRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "getAppRuntime", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "showEmoPreview", "", "clickedView", "Landroid/view/View;", "msgId", "", "isDirectMsg", "", "showHotPicPreview", "picElement", "Lcom/tencent/qqnt/kernel/nativeinterface/PicElement;", "nt-guild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class GuildEmoPreviewApiImpl implements IGuildEmoPreviewApi {
    private final BaseQQAppInterface getAppRuntime() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.business.BaseQQAppInterface");
        return (BaseQQAppInterface) peekAppRuntime;
    }

    @Override // com.tencent.guild.api.emoji.IGuildEmoPreviewApi
    @NotNull
    public Object createMarketFace(@NotNull MarketFaceElement faceElement, @NotNull String channelId, @NotNull String guildId) {
        Intrinsics.checkNotNullParameter(faceElement, "faceElement");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        return ((IMessageRecordFactoryApi) QRoute.api(IMessageRecordFactoryApi.class)).createSendMsgMarketFace(getAppRuntime(), guildId, channelId, 10014, c.f112587a.d(faceElement));
    }

    @Override // com.tencent.guild.api.emoji.IGuildEmoPreviewApi
    @NotNull
    public Object createPicFace(@NotNull MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        QRouteApi api = QRoute.api(IMessageRecordFactoryApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IMessageRecordFactoryApi::class.java)");
        return IMessageRecordFactoryApi.a.a((IMessageRecordFactoryApi) api, getAppRuntime(), msgRecord, null, 4, null);
    }

    @Override // com.tencent.guild.api.emoji.IGuildEmoPreviewApi
    public void showEmoPreview(@NotNull View clickedView, @NotNull MarketFaceElement faceElement, long msgId, @NotNull String channelId, @NotNull String guildId, boolean isDirectMsg) {
        MessageForMarketFace messageForMarketFace;
        Intrinsics.checkNotNullParameter(clickedView, "clickedView");
        Intrinsics.checkNotNullParameter(faceElement, "faceElement");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Object createMarketFace = createMarketFace(faceElement, channelId, guildId);
        if (createMarketFace instanceof MessageForMarketFace) {
            messageForMarketFace = (MessageForMarketFace) createMarketFace;
        } else {
            messageForMarketFace = null;
        }
        if (messageForMarketFace != null) {
            ((MessageForMarketFace) createMarketFace).uniseq = msgId;
            ((IEmosmService) QRoute.api(IEmosmService.class)).enterEmotionPreviewFromGuild(clickedView, (MessageRecord) createMarketFace, guildId, channelId, Boolean.valueOf(isDirectMsg));
        }
    }

    @Override // com.tencent.guild.api.emoji.IGuildEmoPreviewApi
    public void showHotPicPreview(@NotNull View clickedView, @NotNull PicElement picElement, @NotNull MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(clickedView, "clickedView");
        Intrinsics.checkNotNullParameter(picElement, "picElement");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        ((IEmosmService) QRoute.api(IEmosmService.class)).enterEmotionPreviewFromGuild(clickedView, ((IMessageRecordFactoryApi) QRoute.api(IMessageRecordFactoryApi.class)).createPicMessage(getAppRuntime(), msgRecord, picElement), msgRecord.guildId, msgRecord.channelId, Boolean.valueOf(MsgExtKt.t(msgRecord)));
    }
}
