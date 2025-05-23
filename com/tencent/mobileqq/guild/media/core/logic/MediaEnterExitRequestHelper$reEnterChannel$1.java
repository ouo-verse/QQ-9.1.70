package com.tencent.mobileqq.guild.media.core.logic;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProEnterAudioLiveChannelRsp;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
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
@DebugMetadata(c = "com.tencent.mobileqq.guild.media.core.logic.MediaEnterExitRequestHelper$reEnterChannel$1", f = "MediaEnterExitRequestHelper.kt", i = {}, l = {283}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes14.dex */
public final class MediaEnterExitRequestHelper$reEnterChannel$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.tencent.mobileqq.guild.media.core.h $callback;
    int label;
    final /* synthetic */ MediaEnterExitRequestHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaEnterExitRequestHelper$reEnterChannel$1(MediaEnterExitRequestHelper mediaEnterExitRequestHelper, com.tencent.mobileqq.guild.media.core.h hVar, Continuation<? super MediaEnterExitRequestHelper$reEnterChannel$1> continuation) {
        super(2, continuation);
        this.this$0 = mediaEnterExitRequestHelper;
        this.$callback = hVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MediaEnterExitRequestHelper$reEnterChannel$1(this.this$0, this.$callback, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Object Y0;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
                Y0 = obj;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            MediaEnterExitRequestHelper mediaEnterExitRequestHelper = this.this$0;
            long currentTimeMillis = System.currentTimeMillis();
            this.label = 1;
            Y0 = mediaEnterExitRequestHelper.Y0(currentTimeMillis, this);
            if (Y0 == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        EnterChannelRsp enterChannelRsp = (EnterChannelRsp) Y0;
        if (enterChannelRsp.e()) {
            this.this$0.j1(enterChannelRsp.getIgProEnterAudioLiveChannelRsp());
            this.this$0.core.C0(this.this$0.core.getGuildID(), this.this$0.core.E());
            this.this$0.core.n0();
            String newAuthMeta = enterChannelRsp.getIgProEnterAudioLiveChannelRsp().getAuthMeta();
            com.tencent.mobileqq.guild.media.core.n o06 = this.this$0.core.o0();
            Intrinsics.checkNotNullExpressionValue(newAuthMeta, "newAuthMeta");
            o06.f0(newAuthMeta);
            IGProEnterAudioLiveChannelRsp igProEnterAudioLiveChannelRsp = enterChannelRsp.getIgProEnterAudioLiveChannelRsp();
            com.tencent.mobileqq.guild.media.core.f fVar = this.this$0.core;
            int sdkAppId = igProEnterAudioLiveChannelRsp.getSdkAppId();
            String privateMapKey = igProEnterAudioLiveChannelRsp.getPrivateMapKey();
            Intrinsics.checkNotNullExpressionValue(privateMapKey, "igProEnterAudioLiveChannelRsp.privateMapKey");
            String valueOf = String.valueOf(igProEnterAudioLiveChannelRsp.getUserTinyId());
            String trtcUserSign = igProEnterAudioLiveChannelRsp.getTrtcUserSign();
            Intrinsics.checkNotNullExpressionValue(trtcUserSign, "igProEnterAudioLiveChannelRsp.trtcUserSign");
            fVar.s0(new j(sdkAppId, privateMapKey, valueOf, trtcUserSign, igProEnterAudioLiveChannelRsp.getNoStreamDisconnectTrtcSecond(), igProEnterAudioLiveChannelRsp.getSigExpiresSecond() + NetConnInfoCenter.getServerTime(), igProEnterAudioLiveChannelRsp.getAvChannelConfig().getChannelDataVersion()));
            this.this$0.core.l0().k(this.this$0.core.getGuildID(), this.this$0.core.E(), newAuthMeta);
            this.this$0.core.h0();
            com.tencent.mobileqq.guild.media.core.h hVar = this.$callback;
            if (hVar != null) {
                String authMeta = igProEnterAudioLiveChannelRsp.getAuthMeta();
                Intrinsics.checkNotNullExpressionValue(authMeta, "igProEnterAudioLiveChannelRsp.authMeta");
                hVar.a(true, authMeta);
            }
        } else {
            com.tencent.mobileqq.guild.media.core.h hVar2 = this.$callback;
            if (hVar2 != null) {
                hVar2.a(false, "");
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MediaEnterExitRequestHelper$reEnterChannel$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
