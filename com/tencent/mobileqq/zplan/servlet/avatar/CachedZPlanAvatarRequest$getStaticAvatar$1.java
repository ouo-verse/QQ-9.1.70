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
import nk3.j;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.servlet.avatar.CachedZPlanAvatarRequest$getStaticAvatar$1", f = "CachedZPlanAvatarRequest.kt", i = {0}, l = {42, 46, 46}, m = "invokeSuspend", n = {"cache"}, s = {"L$0"})
/* loaded from: classes34.dex */
public final class CachedZPlanAvatarRequest$getStaticAvatar$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ j $callback;
    final /* synthetic */ long $uin;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CachedZPlanAvatarRequest$getStaticAvatar$1(long j3, j jVar, Continuation<? super CachedZPlanAvatarRequest$getStaticAvatar$1> continuation) {
        super(2, continuation);
        this.$uin = j3;
        this.$callback = jVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CachedZPlanAvatarRequest$getStaticAvatar$1(this.$uin, this.$callback, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0095  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        ConcurrentHashMap concurrentHashMap;
        ZPlanAvatar.ZPlanStaticAvatar zPlanStaticAvatar;
        Object f16;
        j jVar;
        String h16;
        Object f17;
        ZPlanAvatar.ZPlanStaticAvatar zPlanStaticAvatar2;
        j jVar2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            concurrentHashMap = CachedZPlanAvatarRequest.staticAvatarCache;
            zPlanStaticAvatar = (ZPlanAvatar.ZPlanStaticAvatar) concurrentHashMap.get(Boxing.boxLong(this.$uin));
            if (zPlanStaticAvatar != null) {
                String appearanceKey = zPlanStaticAvatar.getAppearanceKey();
                CachedZPlanAvatarRequest cachedZPlanAvatarRequest = CachedZPlanAvatarRequest.f335391a;
                h16 = cachedZPlanAvatarRequest.h(this.$uin);
                if (!Intrinsics.areEqual(appearanceKey, h16)) {
                    long j3 = this.$uin;
                    this.L$0 = zPlanStaticAvatar;
                    this.label = 1;
                    f17 = cachedZPlanAvatarRequest.f(j3, this);
                    if (f17 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    zPlanStaticAvatar2 = zPlanStaticAvatar;
                    zPlanStaticAvatar = zPlanStaticAvatar2;
                }
                this.$callback.a(zPlanStaticAvatar);
            } else {
                j jVar3 = this.$callback;
                CachedZPlanAvatarRequest cachedZPlanAvatarRequest2 = CachedZPlanAvatarRequest.f335391a;
                long j16 = this.$uin;
                this.L$0 = jVar3;
                this.label = 2;
                f16 = cachedZPlanAvatarRequest2.f(j16, this);
                if (f16 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                jVar = jVar3;
                obj = f16;
                this.L$0 = jVar;
                this.label = 3;
                obj = ((Deferred) obj).await(this);
                if (obj != coroutine_suspended) {
                }
            }
        } else if (i3 == 1) {
            zPlanStaticAvatar2 = (ZPlanAvatar.ZPlanStaticAvatar) this.L$0;
            ResultKt.throwOnFailure(obj);
            zPlanStaticAvatar = zPlanStaticAvatar2;
            this.$callback.a(zPlanStaticAvatar);
        } else if (i3 == 2) {
            jVar = (j) this.L$0;
            ResultKt.throwOnFailure(obj);
            this.L$0 = jVar;
            this.label = 3;
            obj = ((Deferred) obj).await(this);
            if (obj != coroutine_suspended) {
                return coroutine_suspended;
            }
            jVar2 = jVar;
            ZPlanAvatar zPlanAvatar = (ZPlanAvatar) obj;
            jVar2.a(zPlanAvatar == null ? zPlanAvatar.getStaticAvatar() : null);
        } else if (i3 == 3) {
            jVar2 = (j) this.L$0;
            ResultKt.throwOnFailure(obj);
            ZPlanAvatar zPlanAvatar2 = (ZPlanAvatar) obj;
            jVar2.a(zPlanAvatar2 == null ? zPlanAvatar2.getStaticAvatar() : null);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CachedZPlanAvatarRequest$getStaticAvatar$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
