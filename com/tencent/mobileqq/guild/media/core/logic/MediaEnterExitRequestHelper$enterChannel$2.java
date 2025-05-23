package com.tencent.mobileqq.guild.media.core.logic;

import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.media.core.logic.MediaEnterExitRequestHelper$enterChannel$2", f = "MediaEnterExitRequestHelper.kt", i = {0, 1, 1}, l = {121, 132}, m = "invokeSuspend", n = {"startTs", "enterChannelResult", "startTs"}, s = {"J$0", "L$0", "J$0"})
/* loaded from: classes14.dex */
final class MediaEnterExitRequestHelper$enterChannel$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.tencent.mobileqq.guild.media.core.b $callback;
    final /* synthetic */ com.tencent.mobileqq.guild.media.core.q $startParams;
    long J$0;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MediaEnterExitRequestHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaEnterExitRequestHelper$enterChannel$2(MediaEnterExitRequestHelper mediaEnterExitRequestHelper, com.tencent.mobileqq.guild.media.core.q qVar, com.tencent.mobileqq.guild.media.core.b bVar, Continuation<? super MediaEnterExitRequestHelper$enterChannel$2> continuation) {
        super(2, continuation);
        this.this$0 = mediaEnterExitRequestHelper;
        this.$startParams = qVar;
        this.$callback = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        MediaEnterExitRequestHelper$enterChannel$2 mediaEnterExitRequestHelper$enterChannel$2 = new MediaEnterExitRequestHelper$enterChannel$2(this.this$0, this.$startParams, this.$callback, continuation);
        mediaEnterExitRequestHelper$enterChannel$2.L$0 = obj;
        return mediaEnterExitRequestHelper$enterChannel$2;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x011e  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar;
        String str;
        ca caVar;
        long j3;
        Object n16;
        Pair pair;
        long j16;
        boolean H0;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    j16 = this.J$0;
                    pair = (Pair) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    H0 = this.this$0.H0((EnterChannelRsp) pair.getSecond());
                    if (!H0) {
                        QLog.d("QGMC.Core.MediaEnterExitRequestHelper", 1, "checkNeedEnterTRTCRoom true");
                        this.this$0.L0(this.$callback);
                    } else {
                        QLog.d("QGMC.Core.MediaEnterExitRequestHelper", 1, "checkNeedEnterTRTCRoom false");
                    }
                    Logger.f235387a.d().i("QGMC.Core.MediaEnterExitRequestHelper", 1, "enterChannelJob, end. cost:" + (System.currentTimeMillis() - j16) + "ms");
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j3 = this.J$0;
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Logger logger = Logger.f235387a;
            MediaEnterExitRequestHelper mediaEnterExitRequestHelper = this.this$0;
            Logger.a d16 = logger.d();
            bVar = mediaEnterExitRequestHelper.exitTrtcRoomJob;
            if (bVar != null) {
                str = bVar.toString();
            } else {
                str = null;
            }
            d16.i("QGMC.Core.MediaEnterExitRequestHelper", 1, "enterChannelJob, start. " + str);
            long currentTimeMillis = System.currentTimeMillis();
            this.this$0.core.o0().M0(this.$startParams);
            if (this.$startParams.getPreviewData().f()) {
                this.this$0.core.v0().getUserInfoList().f228125a.clear();
                this.this$0.core.v0().getUserInfoList().f228125a.addAll(this.$startParams.getPreviewData().e());
            }
            this.this$0.core.b0().init();
            caVar = this.this$0.modelTrans;
            caVar.i();
            this.this$0.b1(this.$startParams);
            MediaEnterExitRequestHelper mediaEnterExitRequestHelper2 = this.this$0;
            com.tencent.mobileqq.guild.media.core.b bVar2 = this.$callback;
            this.J$0 = currentTimeMillis;
            this.label = 1;
            obj = mediaEnterExitRequestHelper2.Z0(coroutineScope, currentTimeMillis, bVar2, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            j3 = currentTimeMillis;
        }
        Pair pair2 = (Pair) obj;
        if (!((Boolean) pair2.getFirst()).booleanValue()) {
            return Unit.INSTANCE;
        }
        this.this$0.S0(((EnterChannelRsp) pair2.getSecond()).getIgProEnterAudioLiveChannelRsp(), this.$callback, j3);
        MediaEnterExitRequestHelper mediaEnterExitRequestHelper3 = this.this$0;
        this.L$0 = pair2;
        this.J$0 = j3;
        this.label = 2;
        n16 = mediaEnterExitRequestHelper3.n1(this);
        if (n16 == coroutine_suspended) {
            return coroutine_suspended;
        }
        pair = pair2;
        j16 = j3;
        H0 = this.this$0.H0((EnterChannelRsp) pair.getSecond());
        if (!H0) {
        }
        Logger.f235387a.d().i("QGMC.Core.MediaEnterExitRequestHelper", 1, "enterChannelJob, end. cost:" + (System.currentTimeMillis() - j16) + "ms");
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MediaEnterExitRequestHelper$enterChannel$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
