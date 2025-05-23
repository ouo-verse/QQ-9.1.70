package com.tencent.guild.api.marketface;

import android.content.Context;
import android.widget.ImageView;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmojiManagerServiceProxy;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.MarketFaceElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import mr0.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007J3\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u0002H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015J+\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0019\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/guild/api/marketface/IMarketFaceApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/qqnt/kernel/nativeinterface/MarketFaceElement;", "markFaceMessage", "Lcom/tencent/qqnt/msg/api/c;", "Lmr0/a;", "fetchMarketFaceInfoSuspend", "(Lcom/tencent/qqnt/kernel/nativeinterface/MarketFaceElement;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data", "Landroid/widget/ImageView;", "bubbleIv", "", "msgId", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "contact", "", "bindMagicMarketFaceToView", "(Lcom/tencent/qqnt/kernel/nativeinterface/MarketFaceElement;Landroid/widget/ImageView;JLcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/content/Context;", "context", "addToFavEmo", "(Landroid/content/Context;Lcom/tencent/qqnt/kernel/nativeinterface/MarketFaceElement;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", EmojiManagerServiceProxy.EPID, "eId", "addEmotionToFavoriteAndTip", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "nt-guild-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes6.dex */
public interface IMarketFaceApi extends QRouteApi {
    @Nullable
    Object addEmotionToFavoriteAndTip(@NotNull Context context, @NotNull String str, @NotNull String str2, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    Object addToFavEmo(@NotNull Context context, @NotNull MarketFaceElement marketFaceElement, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    Object bindMagicMarketFaceToView(@NotNull MarketFaceElement marketFaceElement, @NotNull ImageView imageView, long j3, @NotNull Contact contact, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    Object fetchMarketFaceInfoSuspend(@NotNull MarketFaceElement marketFaceElement, @NotNull Continuation<? super c<a>> continuation);
}
