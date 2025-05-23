package com.tencent.qqnt.aio.icebreak;

import com.tencent.qqnt.aio.icebreak.IceBreakingWelcomeWording;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "Ljava/io/File;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.qqnt.aio.icebreak.IceBreakingWelcomeWording$reload$deferred$1", f = "IceBreakingWelcomeWording.kt", i = {}, l = {100}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
public final class IceBreakingWelcomeWording$reload$deferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends File>>, Object> {
    final /* synthetic */ IceBreakingWelcomeWording.ConfigRoot $config;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IceBreakingWelcomeWording$reload$deferred$1(IceBreakingWelcomeWording.ConfigRoot configRoot, Continuation<? super IceBreakingWelcomeWording$reload$deferred$1> continuation) {
        super(2, continuation);
        this.$config = configRoot;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new IceBreakingWelcomeWording$reload$deferred$1(this.$config, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            IceBreakingWelcomeWording iceBreakingWelcomeWording = IceBreakingWelcomeWording.f351145a;
            String url = this.$config.getFace().getUrl();
            String md5 = this.$config.getFace().getMd5();
            this.label = 1;
            obj = iceBreakingWelcomeWording.g(url, md5, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends File>> continuation) {
        return ((IceBreakingWelcomeWording$reload$deferred$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
