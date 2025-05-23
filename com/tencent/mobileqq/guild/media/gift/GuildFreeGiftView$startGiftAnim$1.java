package com.tencent.mobileqq.guild.media.gift;

import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
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
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.media.gift.GuildFreeGiftView$startGiftAnim$1", f = "GuildFreeGiftView.kt", i = {0, 1, 2, 3}, l = {201, 202, 204, 207, 214}, m = "invokeSuspend", n = {"startTimestamp", "startTimestamp", "startTimestamp", "startTimestamp"}, s = {"J$0", "J$0", "J$0", "J$0"})
/* loaded from: classes14.dex */
public final class GuildFreeGiftView$startGiftAnim$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isLastGift;
    final /* synthetic */ int $lastNum;
    final /* synthetic */ boolean $needShowAddOne;
    final /* synthetic */ long $progressDuration;
    long J$0;
    int label;
    final /* synthetic */ GuildFreeGiftView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFreeGiftView$startGiftAnim$1(GuildFreeGiftView guildFreeGiftView, int i3, boolean z16, boolean z17, long j3, Continuation<? super GuildFreeGiftView$startGiftAnim$1> continuation) {
        super(2, continuation);
        this.this$0 = guildFreeGiftView;
        this.$lastNum = i3;
        this.$isLastGift = z16;
        this.$needShowAddOne = z17;
        this.$progressDuration = j3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildFreeGiftView$startGiftAnim$1(this.this$0, this.$lastNum, this.$isLastGift, this.$needShowAddOne, this.$progressDuration, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c9 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        long currentTimeMillis;
        int i3;
        Object M;
        long j3;
        Object M2;
        long j16;
        Object Q;
        boolean z16;
        Object O;
        boolean z17;
        Object N;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i16 = this.label;
        if (i16 != 0) {
            if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 != 3) {
                        if (i16 != 4) {
                            if (i16 == 5) {
                                ResultKt.throwOnFailure(obj);
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        }
                    } else {
                        j3 = this.J$0;
                        ResultKt.throwOnFailure(obj);
                        this.this$0.L();
                        z17 = this.this$0.mIsLastGift;
                        if (!z17) {
                            GuildFreeGiftView guildFreeGiftView = this.this$0;
                            this.J$0 = j3;
                            this.label = 4;
                            N = guildFreeGiftView.N(this);
                            if (N == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            j16 = j3;
                            currentTimeMillis = j16;
                            z16 = this.this$0.mIsLastGift;
                            if (!z16) {
                                int freeGiftCountDownSecond = com.tencent.mobileqq.guild.media.core.j.c().getFreeGiftInfo().getFreeGiftCountDownSecond();
                                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                                Logger logger = Logger.f235387a;
                                if (QLog.isDebugVersion()) {
                                    logger.d().d("GuildFreeGiftView", 1, "[startGiftAnim] hhhhhhhhhhh " + freeGiftCountDownSecond + ", " + currentTimeMillis2 + ", " + ((freeGiftCountDownSecond * 1000) - currentTimeMillis2));
                                }
                                this.label = 5;
                                O = this.this$0.O((freeGiftCountDownSecond * 1000) - currentTimeMillis2, 0.0f, this);
                                if (O == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                        } else {
                            currentTimeMillis = j3;
                            z16 = this.this$0.mIsLastGift;
                            if (!z16) {
                            }
                        }
                    }
                }
                j16 = this.J$0;
                ResultKt.throwOnFailure(obj);
                currentTimeMillis = j16;
                z16 = this.this$0.mIsLastGift;
                if (!z16) {
                }
            } else {
                j16 = this.J$0;
                ResultKt.throwOnFailure(obj);
                GuildFreeGiftView guildFreeGiftView2 = this.this$0;
                this.J$0 = j16;
                this.label = 2;
                Q = guildFreeGiftView2.Q(this);
                if (Q == coroutine_suspended) {
                    return coroutine_suspended;
                }
                currentTimeMillis = j16;
                z16 = this.this$0.mIsLastGift;
                if (!z16) {
                }
            }
        } else {
            ResultKt.throwOnFailure(obj);
            Logger logger2 = Logger.f235387a;
            int i17 = this.$lastNum;
            long j17 = this.$progressDuration;
            boolean z18 = this.$isLastGift;
            boolean z19 = this.$needShowAddOne;
            logger2.d().i("GuildFreeGiftView", 1, "[startGiftAnim] lastNum: " + i17 + ",, duration: " + j17 + ", " + z18 + " needShowAddOne: " + z19);
            this.this$0.mLastNum = this.$lastNum;
            this.this$0.mIsLastGift = this.$isLastGift;
            currentTimeMillis = System.currentTimeMillis();
            if (this.$needShowAddOne) {
                i3 = this.this$0.mLastNum;
                if (i3 == 0) {
                    GuildFreeGiftView guildFreeGiftView3 = this.this$0;
                    this.J$0 = currentTimeMillis;
                    this.label = 1;
                    M2 = guildFreeGiftView3.M(this);
                    if (M2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    j16 = currentTimeMillis;
                    GuildFreeGiftView guildFreeGiftView22 = this.this$0;
                    this.J$0 = j16;
                    this.label = 2;
                    Q = guildFreeGiftView22.Q(this);
                    if (Q == coroutine_suspended) {
                    }
                    currentTimeMillis = j16;
                    z16 = this.this$0.mIsLastGift;
                    if (!z16) {
                    }
                } else {
                    GuildFreeGiftView guildFreeGiftView4 = this.this$0;
                    this.J$0 = currentTimeMillis;
                    this.label = 3;
                    M = guildFreeGiftView4.M(this);
                    if (M == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    j3 = currentTimeMillis;
                    this.this$0.L();
                    z17 = this.this$0.mIsLastGift;
                    if (!z17) {
                    }
                }
            } else {
                GuildFreeGiftView.K(this.this$0, null, 1, null);
                this.this$0.mGiftCountView.setVisibility(0);
                z16 = this.this$0.mIsLastGift;
                if (!z16) {
                }
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildFreeGiftView$startGiftAnim$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
