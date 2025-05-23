package com.tencent.mobileqq.guild.temp.api;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqnt.kernel.nativeinterface.FaceElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001JC\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010JW\u0010\u0011\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH&J0\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00032\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 H&\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/temp/api/IRandomLottieApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "createRandomLottieAnimView", "Landroid/view/View;", "context", "Landroid/content/Context;", "faceElement", "Lcom/tencent/qqnt/kernel/nativeinterface/FaceElement;", "faceIndex", "", "alreadyRead", "", "msgId", "", "contact", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "(Landroid/content/Context;Lcom/tencent/qqnt/kernel/nativeinterface/FaceElement;IZJLcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createRandomLottieAnimViewForMedia", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/ViewGroup;", "msgSeq", "lottieViewLP", "Landroid/widget/FrameLayout$LayoutParams;", "(Landroid/content/Context;Landroid/view/ViewGroup;Lcom/tencent/qqnt/kernel/nativeinterface/FaceElement;IZJLcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;Landroid/widget/FrameLayout$LayoutParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isAniStickerRandom", "setRandomResult", "", "resultId", "", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "tag", "finishRunnable", "Ljava/lang/Runnable;", "qqguild-df-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface IRandomLottieApi extends QRouteApi {
    @Nullable
    Object createRandomLottieAnimView(@NotNull Context context, @NotNull FaceElement faceElement, int i3, boolean z16, long j3, @NotNull Contact contact, @NotNull Continuation<? super View> continuation);

    @Nullable
    Object createRandomLottieAnimViewForMedia(@NotNull Context context, @Nullable ViewGroup viewGroup, @NotNull FaceElement faceElement, int i3, boolean z16, long j3, @NotNull Contact contact, @Nullable FrameLayout.LayoutParams layoutParams, @NotNull Continuation<? super View> continuation);

    boolean isAniStickerRandom(int faceIndex);

    void setRandomResult(@NotNull String resultId, @NotNull View rootView, @Nullable String tag, @Nullable Runnable finishRunnable);
}
