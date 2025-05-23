package com.tencent.mobileqq.zplan.lite;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.lite.ZPlanFilamentResourceDownloader$getAvatarResource$1", f = "ZPlanFilamentResourceDownloader.kt", i = {}, l = {55}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
public final class ZPlanFilamentResourceDownloader$getAvatarResource$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<HashMap<String, String>> $avatarResourcePathMap;
    final /* synthetic */ HashMap<String, String> $avatarUrlMap;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanFilamentResourceDownloader$getAvatarResource$1(Ref.ObjectRef<HashMap<String, String>> objectRef, HashMap<String, String> hashMap, Continuation<? super ZPlanFilamentResourceDownloader$getAvatarResource$1> continuation) {
        super(2, continuation);
        this.$avatarResourcePathMap = objectRef;
        this.$avatarUrlMap = hashMap;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ZPlanFilamentResourceDownloader$getAvatarResource$1(this.$avatarResourcePathMap, this.$avatarUrlMap, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Object h16;
        Ref.ObjectRef<HashMap<String, String>> objectRef;
        T t16;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.ObjectRef<HashMap<String, String>> objectRef2 = this.$avatarResourcePathMap;
            ZPlanFilamentResourceDownloader zPlanFilamentResourceDownloader = ZPlanFilamentResourceDownloader.f333782a;
            HashMap<String, String> hashMap = this.$avatarUrlMap;
            this.L$0 = objectRef2;
            this.label = 1;
            h16 = zPlanFilamentResourceDownloader.h(hashMap, this);
            if (h16 == coroutine_suspended) {
                return coroutine_suspended;
            }
            objectRef = objectRef2;
            t16 = h16;
        } else if (i3 == 1) {
            objectRef = (Ref.ObjectRef) this.L$0;
            ResultKt.throwOnFailure(obj);
            t16 = obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        objectRef.element = t16;
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ZPlanFilamentResourceDownloader$getAvatarResource$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
