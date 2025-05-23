package com.tencent.mobileqq.guild.media;

import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.FaceElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.media.GuildMediaAIOExKt$showAIOLottieEmoji$2", f = "GuildMediaAIOEx.kt", i = {}, l = {122}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes14.dex */
public final class GuildMediaAIOExKt$showAIOLottieEmoji$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FaceElement $faceElement;
    final /* synthetic */ int $lottieWH;
    final /* synthetic */ ArrayList<MsgElement> $msgElements;
    final /* synthetic */ GuildMsgItem $msgItem;
    final /* synthetic */ ViewGroup $parentView;
    final /* synthetic */ String $resultId;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildMediaAIOExKt$showAIOLottieEmoji$2(int i3, GuildMsgItem guildMsgItem, ArrayList<MsgElement> arrayList, FaceElement faceElement, ViewGroup viewGroup, String str, Continuation<? super GuildMediaAIOExKt$showAIOLottieEmoji$2> continuation) {
        super(2, continuation);
        this.$lottieWH = i3;
        this.$msgItem = guildMsgItem;
        this.$msgElements = arrayList;
        this.$faceElement = faceElement;
        this.$parentView = viewGroup;
        this.$resultId = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(ViewGroup viewGroup, GuildMsgItem guildMsgItem, View view) {
        GuildMediaAIOExKt.o(viewGroup, guildMsgItem, view, "auto hide");
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildMediaAIOExKt$showAIOLottieEmoji$2(this.$lottieWH, this.$msgItem, this.$msgElements, this.$faceElement, this.$parentView, this.$resultId, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        HashMap hashMap;
        Handler handler;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            int i16 = this.$lottieWH;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i16, i16);
            GuildMsgItem guildMsgItem = this.$msgItem;
            ArrayList<MsgElement> arrayList = this.$msgElements;
            FaceElement faceElement = this.$faceElement;
            ViewGroup viewGroup = this.$parentView;
            this.label = 1;
            obj = GuildMediaAIOExKt.m(guildMsgItem, arrayList, faceElement, viewGroup, layoutParams, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        final View view = (View) obj;
        if (view != null) {
            final ViewGroup viewGroup2 = this.$parentView;
            int i17 = this.$lottieWH;
            final GuildMsgItem guildMsgItem2 = this.$msgItem;
            if (view.getParent() == null) {
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i17, i17);
                layoutParams2.gravity = 17;
                Unit unit = Unit.INSTANCE;
                viewGroup2.addView(view, layoutParams2);
            }
            ViewGroup.LayoutParams layoutParams3 = view.getLayoutParams();
            layoutParams3.width = i17;
            layoutParams3.height = i17;
            Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.guild.media.c
                @Override // java.lang.Runnable
                public final void run() {
                    GuildMediaAIOExKt$showAIOLottieEmoji$2.b(viewGroup2, guildMsgItem2, view);
                }
            };
            hashMap = GuildMediaAIOExKt.f227746c;
            hashMap.put(Boxing.boxLong(guildMsgItem2.getMsgId()), runnable);
            handler = GuildMediaAIOExKt.f227748e;
            handler.postDelayed(runnable, 10000L);
            GuildMediaAIOExKt.l(view, i17);
        }
        if (!TextUtils.isEmpty(this.$resultId)) {
            QLog.i("GuildMediaAIOEx", 1, "[showAIOLottieEmoji] updateRandomLottieResult");
            GuildMediaAIOExKt.q(this.$msgItem, this.$parentView);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildMediaAIOExKt$showAIOLottieEmoji$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
