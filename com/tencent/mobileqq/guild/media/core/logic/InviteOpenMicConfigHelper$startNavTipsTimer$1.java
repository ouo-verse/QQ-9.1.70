package com.tencent.mobileqq.guild.media.core.logic;

import com.tencent.mobileqq.guild.media.GuildMediaUtils;
import com.tencent.mobileqq.guild.media.config.MediaGuidanceConfig;
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
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.media.core.logic.InviteOpenMicConfigHelper$startNavTipsTimer$1", f = "InviteOpenMicConfigHelper.kt", i = {}, l = {74, 83}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes14.dex */
public final class InviteOpenMicConfigHelper$startNavTipsTimer$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MediaGuidanceConfig.NavConfigData $navigationConfig;
    int label;
    final /* synthetic */ InviteOpenMicConfigHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InviteOpenMicConfigHelper$startNavTipsTimer$1(MediaGuidanceConfig.NavConfigData navConfigData, InviteOpenMicConfigHelper inviteOpenMicConfigHelper, Continuation<? super InviteOpenMicConfigHelper$startNavTipsTimer$1> continuation) {
        super(2, continuation);
        this.$navigationConfig = navConfigData;
        this.this$0 = inviteOpenMicConfigHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new InviteOpenMicConfigHelper$startNavTipsTimer$1(this.$navigationConfig, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Object obj2;
        com.tencent.mobileqq.guild.media.core.f fVar;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    fVar = this.this$0.core;
                    fVar.o0().t().setValue(Boxing.boxBoolean(true));
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            GuildMediaUtils guildMediaUtils = GuildMediaUtils.f227771a;
            String d16 = com.tencent.mobileqq.guild.media.core.m.d(com.tencent.mobileqq.guild.media.core.j.c());
            String b16 = com.tencent.mobileqq.guild.media.core.m.b(com.tencent.mobileqq.guild.media.core.j.c());
            this.label = 1;
            obj = guildMediaUtils.p(d16, b16, 102, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        if (((Boolean) obj).booleanValue()) {
            JSONArray userEnterTime = this.$navigationConfig.getUserEnterTime();
            if (userEnterTime != null) {
                obj2 = userEnterTime.get(1);
            } else {
                obj2 = null;
            }
            if (obj2 == null) {
                obj2 = Boxing.boxInt(0);
            }
            int intValue = ((Integer) obj2).intValue();
            if (intValue == 0) {
                return Unit.INSTANCE;
            }
            this.label = 2;
            if (DelayKt.delay(intValue * 1000, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            fVar = this.this$0.core;
            fVar.o0().t().setValue(Boxing.boxBoolean(true));
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((InviteOpenMicConfigHelper$startNavTipsTimer$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
