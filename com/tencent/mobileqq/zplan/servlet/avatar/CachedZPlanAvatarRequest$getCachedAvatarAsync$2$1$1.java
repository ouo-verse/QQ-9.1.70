package com.tencent.mobileqq.zplan.servlet.avatar;

import com.tencent.mobileqq.zplan.model.ZPlanAvatar;
import com.tencent.mobileqq.zplan.servlet.avatar.CachedZPlanAvatarRequest;
import com.tencent.util.LRULinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import nk3.d;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/mobileqq/zplan/model/f;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.servlet.avatar.CachedZPlanAvatarRequest$getCachedAvatarAsync$2$1$1", f = "CachedZPlanAvatarRequest.kt", i = {0}, l = {72}, m = "invokeSuspend", n = {"$this$async"}, s = {"L$0"})
/* loaded from: classes34.dex */
public final class CachedZPlanAvatarRequest$getCachedAvatarAsync$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ZPlanAvatar>, Object> {
    final /* synthetic */ CachedZPlanAvatarRequest.Key $key;
    final /* synthetic */ long $uin;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/tencent/mobileqq/zplan/model/f;", "avatar", "", "a", "(Lcom/tencent/mobileqq/zplan/model/f;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<ZPlanAvatar> f335398a;

        /* JADX WARN: Multi-variable type inference failed */
        a(Continuation<? super ZPlanAvatar> continuation) {
            this.f335398a = continuation;
        }

        @Override // nk3.d
        public final void a(ZPlanAvatar zPlanAvatar) {
            this.f335398a.resumeWith(Result.m476constructorimpl(zPlanAvatar));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CachedZPlanAvatarRequest$getCachedAvatarAsync$2$1$1(long j3, CachedZPlanAvatarRequest.Key key, Continuation<? super CachedZPlanAvatarRequest$getCachedAvatarAsync$2$1$1> continuation) {
        super(2, continuation);
        this.$uin = j3;
        this.$key = key;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CachedZPlanAvatarRequest$getCachedAvatarAsync$2$1$1 cachedZPlanAvatarRequest$getCachedAvatarAsync$2$1$1 = new CachedZPlanAvatarRequest$getCachedAvatarAsync$2$1$1(this.$uin, this.$key, continuation);
        cachedZPlanAvatarRequest$getCachedAvatarAsync$2$1$1.L$0 = obj;
        return cachedZPlanAvatarRequest$getCachedAvatarAsync$2$1$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Continuation intercepted;
        Object coroutine_suspended2;
        CoroutineScope coroutineScope;
        LRULinkedHashMap lRULinkedHashMap;
        ConcurrentHashMap concurrentHashMap;
        ConcurrentHashMap concurrentHashMap2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            long j3 = this.$uin;
            CachedZPlanAvatarRequest.Key key = this.$key;
            this.L$0 = coroutineScope2;
            this.L$1 = key;
            this.J$0 = j3;
            this.label = 1;
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(this);
            SafeContinuation safeContinuation = new SafeContinuation(intercepted);
            b.f335401a.b(j3, key.getAppearanceKey(), new a(safeContinuation));
            Object orThrow = safeContinuation.getOrThrow();
            coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (orThrow == coroutine_suspended2) {
                DebugProbes.probeCoroutineSuspended(this);
            }
            if (orThrow == coroutine_suspended) {
                return coroutine_suspended;
            }
            coroutineScope = coroutineScope2;
            obj = orThrow;
        } else if (i3 == 1) {
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ZPlanAvatar zPlanAvatar = (ZPlanAvatar) obj;
        if (zPlanAvatar != null) {
            if (zPlanAvatar.getStaticAvatar().getCom.tencent.mobileqq.app.AppConstants.Key.COLUMN_IS_VALID java.lang.String()) {
                concurrentHashMap2 = CachedZPlanAvatarRequest.staticAvatarCache;
                concurrentHashMap2.put(Boxing.boxLong(this.$uin), zPlanAvatar.getStaticAvatar());
            }
            ZPlanAvatar.ZPlanDynamicAvatar dynamicAvatar = zPlanAvatar.getDynamicAvatar();
            if (dynamicAvatar != null) {
                Long boxLong = Boxing.boxLong(this.$uin);
                concurrentHashMap = CachedZPlanAvatarRequest.dynamicAvatarCache;
                concurrentHashMap.put(boxLong, dynamicAvatar);
            }
        } else {
            CachedZPlanAvatarRequest.Key key2 = this.$key;
            synchronized (coroutineScope) {
                lRULinkedHashMap = CachedZPlanAvatarRequest.deferredCache;
            }
        }
        return zPlanAvatar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ZPlanAvatar> continuation) {
        return ((CachedZPlanAvatarRequest$getCachedAvatarAsync$2$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
