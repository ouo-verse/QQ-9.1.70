package com.tencent.mobileqq.qqlive.sail.trtc;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mobileqq.qqlive.data.trtc.QQLiveRoomParams;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004J#\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\tH&J\u001b\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011J$\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\t2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015H&J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\tH&J\u0010\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001bH&J\b\u0010\u001e\u001a\u00020\u0017H&J\b\u0010\u001f\u001a\u00020\u0017H&\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/trtc/a;", "Lcom/tencent/mobileqq/qqlive/sail/trtc/c;", "Lcom/tencent/mobileqq/qqlive/sail/trtc/e;", "Lcom/tencent/mobileqq/qqlive/sail/trtc/b;", "Lcom/tencent/mobileqq/qqlive/sail/trtc/d;", "Landroid/content/Context;", "context", "", "appId", "", DomainData.DOMAIN_NAME, "(Landroid/content/Context;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isEngineReady", "Lcom/tencent/mobileqq/qqlive/data/trtc/QQLiveRoomParams;", "params", "", tl.h.F, "(Lcom/tencent/mobileqq/qqlive/data/trtc/QQLiveRoomParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "fps", "pauseAudio", "Landroid/graphics/Bitmap;", "holderBmp", "", "o", "resumeAudio", "j", "Lcom/tencent/mobileqq/qqlive/trtc/encoder/a;", "qosParam", "c", "exitRoom", "a", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public interface a extends c, e, b, d {
    void a();

    void c(@NotNull com.tencent.mobileqq.qqlive.trtc.encoder.a qosParam);

    void exitRoom();

    @Nullable
    Object h(@NotNull QQLiveRoomParams qQLiveRoomParams, @NotNull Continuation<? super Long> continuation);

    boolean isEngineReady();

    void j(boolean resumeAudio);

    @Nullable
    Object n(@NotNull Context context, @NotNull String str, @NotNull Continuation<? super Boolean> continuation);

    void o(int fps, boolean pauseAudio, @Nullable Bitmap holderBmp);
}
