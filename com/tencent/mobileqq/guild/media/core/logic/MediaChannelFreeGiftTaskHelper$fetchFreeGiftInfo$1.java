package com.tencent.mobileqq.guild.media.core.logic;

import com.tencent.mobileqq.guild.media.core.logic.MediaChannelFreeGiftTaskHelper;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProUserFreeGiftInfoRsp;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.media.core.logic.MediaChannelFreeGiftTaskHelper$fetchFreeGiftInfo$1", f = "MediaChannelFreeGiftTaskHelper.kt", i = {}, l = {131}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes14.dex */
public final class MediaChannelFreeGiftTaskHelper$fetchFreeGiftInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MediaChannelFreeGiftTaskHelper.b $callback;
    int label;
    final /* synthetic */ MediaChannelFreeGiftTaskHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaChannelFreeGiftTaskHelper$fetchFreeGiftInfo$1(MediaChannelFreeGiftTaskHelper mediaChannelFreeGiftTaskHelper, MediaChannelFreeGiftTaskHelper.b bVar, Continuation<? super MediaChannelFreeGiftTaskHelper$fetchFreeGiftInfo$1> continuation) {
        super(2, continuation);
        this.this$0 = mediaChannelFreeGiftTaskHelper;
        this.$callback = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MediaChannelFreeGiftTaskHelper$fetchFreeGiftInfo$1(this.this$0, this.$callback, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Object l06;
        String joinToString$default;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
                l06 = obj;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            MediaChannelFreeGiftTaskHelper mediaChannelFreeGiftTaskHelper = this.this$0;
            this.label = 1;
            l06 = mediaChannelFreeGiftTaskHelper.l0(this);
            if (l06 == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        MediaChannelFreeGiftTaskHelper.SuspendRsp suspendRsp = (MediaChannelFreeGiftTaskHelper.SuspendRsp) l06;
        if (suspendRsp.b() && suspendRsp.a() != null) {
            this.this$0.needCheckThemeTypes.clear();
            this.this$0.needCheckThemeTypes.addAll(((IGProUserFreeGiftInfoRsp) suspendRsp.a()).getNeedCheckThemeTypes());
            ct1.a freeGiftInfo = this.this$0.mediaChannelCore.o0().getFreeGiftInfo();
            MediaChannelFreeGiftTaskHelper mediaChannelFreeGiftTaskHelper2 = this.this$0;
            freeGiftInfo.s(((IGProUserFreeGiftInfoRsp) suspendRsp.a()).getMaxFreeGiftNum());
            String checkContext = ((IGProUserFreeGiftInfoRsp) suspendRsp.a()).getCheckContext();
            Intrinsics.checkNotNullExpressionValue(checkContext, "suspendRsp.rsp.checkContext");
            freeGiftInfo.m(checkContext);
            freeGiftInfo.t(((IGProUserFreeGiftInfoRsp) suspendRsp.a()).getNextCheckTimeMS());
            freeGiftInfo.n(((IGProUserFreeGiftInfoRsp) suspendRsp.a()).getCurrFreeGiftNum());
            freeGiftInfo.r(((IGProUserFreeGiftInfoRsp) suspendRsp.a()).getDayFreeGiftNum());
            freeGiftInfo.q(((IGProUserFreeGiftInfoRsp) suspendRsp.a()).getGotFreeGiftNum());
            freeGiftInfo.u(((IGProUserFreeGiftInfoRsp) suspendRsp.a()).getReminderFreeGiftNum());
            freeGiftInfo.o(((IGProUserFreeGiftInfoRsp) suspendRsp.a()).getCountdownSecond());
            freeGiftInfo.p(((IGProUserFreeGiftInfoRsp) suspendRsp.a()).getFreeGiftIds());
            Logger logger = Logger.f235387a;
            if (QLog.isDebugVersion()) {
                logger.d().d("QGMC.MediaChannelFreeGiftTaskHelper", 1, "[fetchFreeGiftInfo] freeGiftInfo hashCode: " + mediaChannelFreeGiftTaskHelper2.mediaChannelCore.o0().getFreeGiftInfo().hashCode());
            }
            MediaChannelFreeGiftTaskHelper mediaChannelFreeGiftTaskHelper3 = this.this$0;
            mediaChannelFreeGiftTaskHelper3.I0(mediaChannelFreeGiftTaskHelper3.mediaChannelCore.o0().getFreeGiftInfo());
            MediaChannelFreeGiftTaskHelper mediaChannelFreeGiftTaskHelper4 = this.this$0;
            Logger.a d16 = logger.d();
            ct1.a freeGiftInfo2 = mediaChannelFreeGiftTaskHelper4.mediaChannelCore.o0().getFreeGiftInfo();
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(mediaChannelFreeGiftTaskHelper4.needCheckThemeTypes, null, null, null, 0, null, null, 63, null);
            d16.d("QGMC.MediaChannelFreeGiftTaskHelper", 1, "[fetchFreeGiftInfo] giftInfo: " + freeGiftInfo2 + " needCheckThemeType: " + joinToString$default);
            MediaChannelFreeGiftTaskHelper.b bVar = this.$callback;
            if (bVar != null) {
                MediaChannelFreeGiftTaskHelper.b.a.a(bVar, false, this.this$0.mediaChannelCore.o0().getFreeGiftInfo(), 1, null);
            }
            com.tencent.mobileqq.guild.media.core.j.d().i(new com.tencent.mobileqq.guild.media.core.notify.j(this.this$0.mediaChannelCore.o0().getFreeGiftInfo()));
            this.this$0.H0();
            MediaChannelFreeGiftTaskHelper mediaChannelFreeGiftTaskHelper5 = this.this$0;
            mediaChannelFreeGiftTaskHelper5.J0(mediaChannelFreeGiftTaskHelper5.mediaChannelCore.o0().getFreeGiftInfo().l());
            return Unit.INSTANCE;
        }
        MediaChannelFreeGiftTaskHelper.b bVar2 = this.$callback;
        if (bVar2 != null) {
            MediaChannelFreeGiftTaskHelper.b.a.a(bVar2, false, null, 2, null);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MediaChannelFreeGiftTaskHelper$fetchFreeGiftInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
