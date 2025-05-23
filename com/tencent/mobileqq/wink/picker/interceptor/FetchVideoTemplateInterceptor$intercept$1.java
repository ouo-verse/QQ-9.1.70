package com.tencent.mobileqq.wink.picker.interceptor;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.wink.editor.extractor.ExtractCoverHelper;
import com.tencent.mobileqq.wink.picker.interceptor.c;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.picker.interceptor.FetchVideoTemplateInterceptor$intercept$1", f = "FetchVideoTemplateInterceptor.kt", i = {}, l = {48}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
final class FetchVideoTemplateInterceptor$intercept$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ c.a $chain;
    final /* synthetic */ Ref.ObjectRef<ArrayList<byte[]>> $coverBitmaps;
    Object L$0;
    int label;
    final /* synthetic */ FetchVideoTemplateInterceptor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FetchVideoTemplateInterceptor$intercept$1(Ref.ObjectRef<ArrayList<byte[]>> objectRef, c.a aVar, FetchVideoTemplateInterceptor fetchVideoTemplateInterceptor, Continuation<? super FetchVideoTemplateInterceptor$intercept$1> continuation) {
        super(2, continuation);
        this.$coverBitmaps = objectRef;
        this.$chain = aVar;
        this.this$0 = fetchVideoTemplateInterceptor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FetchVideoTemplateInterceptor$intercept$1(this.$coverBitmaps, this.$chain, this.this$0, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Ref.ObjectRef<ArrayList<byte[]>> objectRef;
        T t16;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                objectRef = (Ref.ObjectRef) this.L$0;
                ResultKt.throwOnFailure(obj);
                t16 = obj;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            Ref.ObjectRef<ArrayList<byte[]>> objectRef2 = this.$coverBitmaps;
            ExtractCoverHelper extractCoverHelper = ExtractCoverHelper.f320276a;
            List<LocalMediaInfo> e16 = this.$chain.e();
            this.L$0 = objectRef2;
            this.label = 1;
            Object C = extractCoverHelper.C(e16, this);
            if (C == coroutine_suspended) {
                return coroutine_suspended;
            }
            objectRef = objectRef2;
            t16 = C;
        }
        objectRef.element = t16;
        CountDownLatch countDownLatch = this.this$0.syncLatch;
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FetchVideoTemplateInterceptor$intercept$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
