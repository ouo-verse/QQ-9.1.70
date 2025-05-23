package com.tencent.mobileqq.zplan.servlet.avatar;

import com.tencent.mobileqq.zplan.model.ZPlanAvatar;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import nk3.f;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.servlet.avatar.CachedZPlanAvatarRequest$getDynamicAvatar$1", f = "CachedZPlanAvatarRequest.kt", i = {}, l = {61, 61}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
public final class CachedZPlanAvatarRequest$getDynamicAvatar$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ f $callback;
    final /* synthetic */ long $uin;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CachedZPlanAvatarRequest$getDynamicAvatar$1(long j3, f fVar, Continuation<? super CachedZPlanAvatarRequest$getDynamicAvatar$1> continuation) {
        super(2, continuation);
        this.$uin = j3;
        this.$callback = fVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CachedZPlanAvatarRequest$getDynamicAvatar$1(this.$uin, this.$callback, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x007c  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        ConcurrentHashMap concurrentHashMap;
        Object f16;
        f fVar;
        String h16;
        f fVar2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            concurrentHashMap = CachedZPlanAvatarRequest.dynamicAvatarCache;
            ZPlanAvatar.ZPlanDynamicAvatar zPlanDynamicAvatar = (ZPlanAvatar.ZPlanDynamicAvatar) concurrentHashMap.get(Boxing.boxLong(this.$uin));
            if (zPlanDynamicAvatar != null) {
                long j3 = this.$uin;
                f fVar3 = this.$callback;
                String appearanceKey = zPlanDynamicAvatar.getAppearanceKey();
                h16 = CachedZPlanAvatarRequest.f335391a.h(j3);
                if (Intrinsics.areEqual(appearanceKey, h16)) {
                    fVar3.a(zPlanDynamicAvatar);
                    return Unit.INSTANCE;
                }
            }
            f fVar4 = this.$callback;
            CachedZPlanAvatarRequest cachedZPlanAvatarRequest = CachedZPlanAvatarRequest.f335391a;
            long j16 = this.$uin;
            this.L$0 = fVar4;
            this.label = 1;
            f16 = cachedZPlanAvatarRequest.f(j16, this);
            if (f16 == coroutine_suspended) {
                return coroutine_suspended;
            }
            fVar = fVar4;
            obj = f16;
        } else {
            if (i3 != 1) {
                if (i3 == 2) {
                    fVar2 = (f) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    ZPlanAvatar zPlanAvatar = (ZPlanAvatar) obj;
                    fVar2.a(zPlanAvatar == null ? zPlanAvatar.getDynamicAvatar() : null);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            fVar = (f) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        this.L$0 = fVar;
        this.label = 2;
        obj = ((Deferred) obj).await(this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        fVar2 = fVar;
        ZPlanAvatar zPlanAvatar2 = (ZPlanAvatar) obj;
        fVar2.a(zPlanAvatar2 == null ? zPlanAvatar2.getDynamicAvatar() : null);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CachedZPlanAvatarRequest$getDynamicAvatar$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
