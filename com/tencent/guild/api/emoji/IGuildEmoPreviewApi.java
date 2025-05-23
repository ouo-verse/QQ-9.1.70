package com.tencent.guild.api.emoji;

import android.view.View;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.MarketFaceElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J8\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013H&J \u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u000bH&\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/guild/api/emoji/IGuildEmoPreviewApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "createMarketFace", "", "faceElement", "Lcom/tencent/qqnt/kernel/nativeinterface/MarketFaceElement;", "channelId", "", "guildId", "createPicFace", "msgRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "showEmoPreview", "", "clickedView", "Landroid/view/View;", "msgId", "", "isDirectMsg", "", "showHotPicPreview", "picElement", "Lcom/tencent/qqnt/kernel/nativeinterface/PicElement;", "nt-guild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes6.dex */
public interface IGuildEmoPreviewApi extends QRouteApi {
    @NotNull
    Object createMarketFace(@NotNull MarketFaceElement faceElement, @NotNull String channelId, @NotNull String guildId);

    @NotNull
    Object createPicFace(@NotNull MsgRecord msgRecord);

    void showEmoPreview(@NotNull View clickedView, @NotNull MarketFaceElement faceElement, long msgId, @NotNull String channelId, @NotNull String guildId, boolean isDirectMsg);

    void showHotPicPreview(@NotNull View clickedView, @NotNull PicElement picElement, @NotNull MsgRecord msgRecord);
}
