package com.tencent.guild.api.emoji.impl;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.guild.api.emoji.IRandomLottieProxyApi;
import com.tencent.mobileqq.guild.temp.api.IRandomLottieApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqnt.kernel.nativeinterface.FaceElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002JG\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J[\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0016J,\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u001d2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\""}, d2 = {"Lcom/tencent/guild/api/emoji/impl/RandomLottieProxyApiImpl;", "Lcom/tencent/guild/api/emoji/IRandomLottieProxyApi;", "()V", "createRandomLottieAnimView", "Landroid/view/View;", "context", "Landroid/content/Context;", "faceElement", "Lcom/tencent/qqnt/kernel/nativeinterface/FaceElement;", "faceIndex", "", "alreadyRead", "", "msgId", "", "contact", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "(Landroid/content/Context;Lcom/tencent/qqnt/kernel/nativeinterface/FaceElement;IZJLcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createRandomLottieAnimViewForMedia", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/ViewGroup;", "msgSeq", "lottieViewLP", "Landroid/widget/FrameLayout$LayoutParams;", "(Landroid/content/Context;Landroid/view/ViewGroup;Lcom/tencent/qqnt/kernel/nativeinterface/FaceElement;IZJLcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;Landroid/widget/FrameLayout$LayoutParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isAniStickerRandom", "setRandomResult", "", "resultId", "", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "tag", "finishRunnable", "Ljava/lang/Runnable;", "nt-guild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class RandomLottieProxyApiImpl implements IRandomLottieProxyApi {
    @Override // com.tencent.guild.api.emoji.IRandomLottieProxyApi
    @Nullable
    public Object createRandomLottieAnimView(@Nullable Context context, @Nullable FaceElement faceElement, int i3, boolean z16, long j3, @NotNull Contact contact, @NotNull Continuation<? super View> continuation) {
        if (context != null && faceElement != null) {
            return ((IRandomLottieApi) QRoute.api(IRandomLottieApi.class)).createRandomLottieAnimView(context, faceElement, i3, z16, j3, contact, continuation);
        }
        return null;
    }

    @Override // com.tencent.guild.api.emoji.IRandomLottieProxyApi
    @Nullable
    public Object createRandomLottieAnimViewForMedia(@Nullable Context context, @Nullable ViewGroup viewGroup, @Nullable FaceElement faceElement, int i3, boolean z16, long j3, @NotNull Contact contact, @Nullable FrameLayout.LayoutParams layoutParams, @NotNull Continuation<? super View> continuation) {
        if (context != null && faceElement != null) {
            return ((IRandomLottieApi) QRoute.api(IRandomLottieApi.class)).createRandomLottieAnimViewForMedia(context, viewGroup, faceElement, i3, z16, j3, contact, layoutParams, continuation);
        }
        return null;
    }

    @Override // com.tencent.guild.api.emoji.IRandomLottieProxyApi
    public boolean isAniStickerRandom(int faceIndex) {
        return ((IRandomLottieApi) QRoute.api(IRandomLottieApi.class)).isAniStickerRandom(faceIndex);
    }

    @Override // com.tencent.guild.api.emoji.IRandomLottieProxyApi
    public void setRandomResult(@NotNull String resultId, @NotNull View rootView, @Nullable String tag, @Nullable Runnable finishRunnable) {
        Intrinsics.checkNotNullParameter(resultId, "resultId");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        ((IRandomLottieApi) QRoute.api(IRandomLottieApi.class)).setRandomResult(resultId, rootView, tag, finishRunnable);
    }
}
