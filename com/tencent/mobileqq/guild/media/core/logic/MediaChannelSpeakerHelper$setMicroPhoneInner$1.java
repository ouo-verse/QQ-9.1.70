package com.tencent.mobileqq.guild.media.core.logic;

import com.tencent.mobileqq.guild.media.core.CommonRsp;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import kotlin.Metadata;
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

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.media.core.logic.MediaChannelSpeakerHelper$setMicroPhoneInner$1", f = "MediaChannelSpeakerHelper.kt", i = {}, l = {147}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes14.dex */
public final class MediaChannelSpeakerHelper$setMicroPhoneInner$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.tencent.mobileqq.guild.media.core.i $cb;
    final /* synthetic */ boolean $enable;
    final /* synthetic */ boolean $isMute;
    int label;
    final /* synthetic */ MediaChannelSpeakerHelper this$0;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/media/core/logic/MediaChannelSpeakerHelper$setMicroPhoneInner$1$a", "Lcom/tencent/mobileqq/guild/media/core/b;", "", "isSuccess", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProSecurityResult;", "securityResult", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a implements com.tencent.mobileqq.guild.media.core.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MediaChannelSpeakerHelper f228246a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f228247b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f228248c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.guild.media.core.i f228249d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ CommonRsp f228250e;

        a(MediaChannelSpeakerHelper mediaChannelSpeakerHelper, boolean z16, boolean z17, com.tencent.mobileqq.guild.media.core.i iVar, CommonRsp commonRsp) {
            this.f228246a = mediaChannelSpeakerHelper;
            this.f228247b = z16;
            this.f228248c = z17;
            this.f228249d = iVar;
            this.f228250e = commonRsp;
        }

        @Override // com.tencent.mobileqq.guild.media.core.b
        public void a(boolean isSuccess, @Nullable IGProSecurityResult securityResult) {
            com.tencent.mobileqq.guild.media.core.i t16;
            if (isSuccess) {
                MediaChannelSpeakerHelper mediaChannelSpeakerHelper = this.f228246a;
                boolean z16 = this.f228247b;
                boolean z17 = this.f228248c;
                t16 = mediaChannelSpeakerHelper.t(this.f228249d, this.f228250e);
                mediaChannelSpeakerHelper.y(z16, z17, t16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaChannelSpeakerHelper$setMicroPhoneInner$1(MediaChannelSpeakerHelper mediaChannelSpeakerHelper, boolean z16, boolean z17, com.tencent.mobileqq.guild.media.core.i iVar, Continuation<? super MediaChannelSpeakerHelper$setMicroPhoneInner$1> continuation) {
        super(2, continuation);
        this.this$0 = mediaChannelSpeakerHelper;
        this.$enable = z16;
        this.$isMute = z17;
        this.$cb = iVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MediaChannelSpeakerHelper$setMicroPhoneInner$1(this.this$0, this.$enable, this.$isMute, this.$cb, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        com.tencent.mobileqq.guild.media.core.i s16;
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
            MediaChannelSpeakerHelper mediaChannelSpeakerHelper = this.this$0;
            boolean z16 = this.$enable;
            this.label = 1;
            obj = mediaChannelSpeakerHelper.r(z16, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        CommonRsp commonRsp = (CommonRsp) obj;
        com.tencent.mobileqq.guild.performance.report.aa.f230980i.D(this.$enable, commonRsp.getCode(), commonRsp.getMsg());
        if (!commonRsp.c()) {
            this.this$0.v(commonRsp.getCode(), commonRsp.getMsg(), this.$cb);
        } else if (!this.this$0.core.i0(this.this$0.core.E())) {
            this.this$0.core.Q().L0(new a(this.this$0, this.$enable, this.$isMute, this.$cb, commonRsp));
        } else {
            MediaChannelSpeakerHelper mediaChannelSpeakerHelper2 = this.this$0;
            boolean z17 = this.$enable;
            boolean z18 = this.$isMute;
            s16 = mediaChannelSpeakerHelper2.s(this.$cb, commonRsp);
            mediaChannelSpeakerHelper2.y(z17, z18, s16);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MediaChannelSpeakerHelper$setMicroPhoneInner$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
