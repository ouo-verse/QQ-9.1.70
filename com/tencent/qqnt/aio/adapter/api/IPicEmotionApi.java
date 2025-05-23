package com.tencent.qqnt.aio.adapter.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.EmojiHotPicSearchEmojiInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0014\u0010\u0006\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00030\u0007H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/IPicEmotionApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "downloadPicEmotion", "", "emojiInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/EmojiHotPicSearchEmojiInfo;", "callback", "Lkotlin/Function1;", "", "aio_adapter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IPicEmotionApi extends QRouteApi {
    void downloadPicEmotion(@NotNull EmojiHotPicSearchEmojiInfo emojiInfo, @NotNull Function1<? super String, Unit> callback);
}
