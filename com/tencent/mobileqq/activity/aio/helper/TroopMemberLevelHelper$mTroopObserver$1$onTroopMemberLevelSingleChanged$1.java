package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import com.tencent.mobileqq.troop.api.ITroopMemberLevelService;
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
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.activity.aio.helper.TroopMemberLevelHelper$mTroopObserver$1$onTroopMemberLevelSingleChanged$1", f = "TroopMemberLevelHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes10.dex */
final class TroopMemberLevelHelper$mTroopObserver$1$onTroopMemberLevelSingleChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $memberUin;
    final /* synthetic */ String $troopUin;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopMemberLevelHelper$mTroopObserver$1$onTroopMemberLevelSingleChanged$1(String str, String str2, Continuation<? super TroopMemberLevelHelper$mTroopObserver$1$onTroopMemberLevelSingleChanged$1> continuation) {
        super(2, continuation);
        this.$troopUin = str;
        this.$memberUin = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(AppRuntime appRuntime, String str, String str2, TroopInfo troopInfo, TroopMemberInfo troopMemberInfo) {
        IRuntimeService runtimeService = appRuntime.getRuntimeService(ITroopMemberLevelService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
        ITroopMemberLevelService iTroopMemberLevelService = (ITroopMemberLevelService) runtimeService;
        iTroopMemberLevelService.sendMemberLevelUpdateEvent(str, str2, iTroopMemberLevelService.getTroopMemberLevelForAIO(troopInfo, troopMemberInfo));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TroopMemberLevelHelper$mTroopObserver$1$onTroopMemberLevelSingleChanged$1(this.$troopUin, this.$memberUin, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            final AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                return Unit.INSTANCE;
            }
            final TroopInfo findTroopInfo = ((ITroopInfoService) peekAppRuntime.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(this.$troopUin);
            if (findTroopInfo == null) {
                return Unit.INSTANCE;
            }
            ITroopMemberInfoService iTroopMemberInfoService = (ITroopMemberInfoService) peekAppRuntime.getRuntimeService(ITroopMemberInfoService.class, "");
            final String str = this.$troopUin;
            final String str2 = this.$memberUin;
            iTroopMemberInfoService.getTroopMemberInfoAsync(str, str2, "", new ITroopMemberInfoService.a() { // from class: com.tencent.mobileqq.activity.aio.helper.as
                @Override // com.tencent.mobileqq.troop.api.ITroopMemberInfoService.a
                public final void a(TroopMemberInfo troopMemberInfo) {
                    TroopMemberLevelHelper$mTroopObserver$1$onTroopMemberLevelSingleChanged$1.b(AppRuntime.this, str, str2, findTroopInfo, troopMemberInfo);
                }
            });
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TroopMemberLevelHelper$mTroopObserver$1$onTroopMemberLevelSingleChanged$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
