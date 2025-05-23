package com.tencent.qqnt.emotion.adapter.api;

import android.content.Context;
import android.widget.ImageView;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.MarketFaceElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u00012\u00020\u0002J!\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ3\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0003H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0017H&J\u001c\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u0004\u001a\u00020\u0003H&\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qqnt/emotion/adapter/api/IMarketFaceApi;", "Lcom/tencent/qqnt/emotion/adapter/api/IPicEmoticonInfoSenderApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/qqnt/kernel/nativeinterface/MarketFaceElement;", "marketFaceElement", "Lcom/tencent/qqnt/msg/api/c;", "Lcom/tencent/qqnt/emotion/adapter/api/a;", "fetchMarketFaceInfoSuspend", "(Lcom/tencent/qqnt/kernel/nativeinterface/MarketFaceElement;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data", "Landroid/widget/ImageView;", "bubbleIv", "", "msgId", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "contact", "", "bindMagicMarketFaceToView", "(Lcom/tencent/qqnt/kernel/nativeinterface/MarketFaceElement;Landroid/widget/ImageView;JLcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/content/Context;", "context", "addToFavEmo", "(Landroid/content/Context;Lcom/tencent/qqnt/kernel/nativeinterface/MarketFaceElement;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/data/MarkFaceMessage;", "markFaceMessage", "createMarketFaceElement", "Lkotlin/Pair;", "", "calculateMarketFaceViewSize", "emotion_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes24.dex */
public interface IMarketFaceApi extends IPicEmoticonInfoSenderApi, QRouteApi {
    @Nullable
    Object addToFavEmo(@NotNull Context context, @NotNull MarketFaceElement marketFaceElement, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    Object bindMagicMarketFaceToView(@NotNull MarketFaceElement marketFaceElement, @NotNull ImageView imageView, long j3, @NotNull Contact contact, @NotNull Continuation<? super Unit> continuation);

    @NotNull
    Pair<Integer, Integer> calculateMarketFaceViewSize(@NotNull MarketFaceElement marketFaceElement);

    @NotNull
    MarketFaceElement createMarketFaceElement(@NotNull MarkFaceMessage markFaceMessage);

    @Nullable
    Object fetchMarketFaceInfoSuspend(@NotNull MarketFaceElement marketFaceElement, @NotNull Continuation<? super c<a>> continuation);
}
